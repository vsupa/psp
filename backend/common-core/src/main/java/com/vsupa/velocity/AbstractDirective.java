//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.vsupa.velocity;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.tools.view.ViewToolContext;

import java.io.IOException;
import java.io.Writer;

public abstract class AbstractDirective extends Directive {
    public AbstractDirective() {
    }

    public boolean render(InternalContextAdapter internalContext, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        ViewToolContext context = (ViewToolContext)internalContext.getInternalUserContext();
        return this.doRender(internalContext, context, writer, node);
    }

    protected abstract boolean doRender(InternalContextAdapter var1, ViewToolContext var2, Writer var3, Node var4) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException;
}
