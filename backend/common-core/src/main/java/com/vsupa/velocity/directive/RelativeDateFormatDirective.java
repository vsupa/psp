//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.vsupa.velocity.directive;

import com.vsupa.velocity.AbstractDirective;
import com.vsupa.velocity.RelativeDateFormat;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.apache.velocity.tools.view.ViewToolContext;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

public class RelativeDateFormatDirective extends AbstractDirective {
    public RelativeDateFormatDirective() {
    }

    public String getName() {
        return "relativeDateFormat";
    }

    public int getType() {
        return 2;
    }

    protected boolean doRender(InternalContextAdapter internalContext, ViewToolContext context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        SimpleNode sn = (SimpleNode)node.jjtGetChild(0);
        Date date = (Date)sn.value(internalContext);
        writer.write(RelativeDateFormat.format(date));
        return true;
    }
}
