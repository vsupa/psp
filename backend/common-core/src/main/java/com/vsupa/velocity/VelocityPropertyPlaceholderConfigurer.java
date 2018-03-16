package com.vsupa.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.PropertyPlaceholderHelper.PlaceholderResolver;
import org.springframework.util.StringValueResolver;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class VelocityPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private String charset;
    private static VelocityContext velocityContext = null;
    private Resource[] locations;
    private RunEnvironment runEnvironment;
    private String placeholderValue;

    public VelocityPropertyPlaceholderConfigurer() {
        this.charset = "UTF-8";
        this.placeholderValue = "";
    }

    public void setLocation(Resource location) {
        this.locations = new Resource[]{location};
    }

    public void setLocations(Resource... locations) {
        this.locations = locations;
    }

    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        VelocityPropertyPlaceholderConfigurer.PlaceholderResolvingStringValueResolver valueResolver = new VelocityPropertyPlaceholderConfigurer.PlaceholderResolvingStringValueResolver(props);
        this.doProcessProperties(beanFactoryToProcess, valueResolver);
    }

    public void fillMergeProperties(Properties prop, InputStream input) {
        try {
            StringWriter e = new StringWriter();
            BufferedReader br = new BufferedReader(new InputStreamReader(input, this.getCharset()));
            if(velocityContext == null) {
                HashMap context = new HashMap();
                context.put("env", this.getRunEnvironment());
                context.putAll(System.getProperties());
                velocityContext = new VelocityContext(context);
            }

            Velocity.evaluate(velocityContext, e, "VelocityPropertyPlaceholderConfigurer", br);
            prop.load(new StringReader(e.toString()));
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }
    }

    protected void loadProperties(Properties props) throws IOException {
        if(this.locations != null && props != null) {
            Resource[] var2 = this.locations;
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Resource location = var2[var4];
                if(this.logger.isInfoEnabled()) {
                    this.logger.info("Loading properties file from " + location);
                }

                this.fillMergeProperties(props, location.getInputStream());
            }
        }

    }

    public RunEnvironment getRunEnvironment() {
        return this.runEnvironment == null?new RunEnvironment():this.runEnvironment;
    }

    public void setRunEnvironment(RunEnvironment runEnvironment) {
        this.runEnvironment = runEnvironment;
    }

    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getPlaceholderValue() {
        return this.placeholderValue;
    }

    public void setPlaceholderValue(String placeholderValue) {
        this.placeholderValue = placeholderValue;
    }

    private class PropertyPlaceholderConfigurerResolver implements PlaceholderResolver {
        private final Properties props;

        private PropertyPlaceholderConfigurerResolver(Properties props) {
            this.props = props;
        }

        public String resolvePlaceholder(String placeholderName) {
            return VelocityPropertyPlaceholderConfigurer.this.resolvePlaceholder(placeholderName, this.props, 1);
        }
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver {
        private final PropertyPlaceholderHelper helper;
        private final PlaceholderResolver resolver;

        public PlaceholderResolvingStringValueResolver(Properties props) {
            this.helper = new PropertyPlaceholderHelper(VelocityPropertyPlaceholderConfigurer.this.placeholderPrefix, VelocityPropertyPlaceholderConfigurer.this.placeholderSuffix, VelocityPropertyPlaceholderConfigurer.this.valueSeparator, VelocityPropertyPlaceholderConfigurer.this.ignoreUnresolvablePlaceholders);
            this.resolver = VelocityPropertyPlaceholderConfigurer.this.new PropertyPlaceholderConfigurerResolver(props);
        }

        public String resolveStringValue(String strVal) throws BeansException {
            String value = this.helper.replacePlaceholders(strVal, this.resolver);
            return value.contains(VelocityPropertyPlaceholderConfigurer.this.placeholderPrefix) && value.equals(strVal)?VelocityPropertyPlaceholderConfigurer.this.placeholderValue:(value.equals(VelocityPropertyPlaceholderConfigurer.this.nullValue)?null:value);
        }
    }
}
