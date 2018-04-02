package com.vsupa.psp.portal.admin.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;

/**
 * Spring 工具类 ，获取Spring容器中的上下文信息。<br>
 * 使用的时候需要注入到 servlet-context.xml 如下设置：<br>
 *     &lt;!-- 获取ApplicationContext上下文 --&gt;<br>
 *     &lt;bean id="springContextHolder" class="org.springframework.context.ApplicationContextAware" /&gt;
 * @author Maxwell.Lee
 * @date 2018-03-04 10:35
 * @since   1.0.0
 */
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {
        ensureApplicationContext();
        return context;
    }

    public static <T> T getBean(Class<T> clazz) {
        ensureApplicationContext();
        return context.getBean(clazz);
    }

    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     * <p>Invoked after population of normal bean properties but before an init callback such
     * as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method. Invoked after {@link ResourceLoaderAware#setResourceLoader},
     * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     *
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws ApplicationContextException in case of context initialization errors
     * @throws BeansException              if thrown by application context methods
     * @see BeanInitializationException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    private static void ensureApplicationContext() {
        if (context == null) {
            throw new RuntimeException("ApplicationContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }

}
