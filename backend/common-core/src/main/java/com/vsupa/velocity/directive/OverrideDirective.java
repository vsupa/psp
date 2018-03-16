//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.vsupa.velocity.directive;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

import java.io.IOException;
import java.io.Writer;

public class OverrideDirective extends Directive {
    public OverrideDirective() {
    }

    public String getName() {
        return "override";
    }

    public int getType() {
        return 1;
    }

    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        String name = DirectiveUtil.getRequiredArgument(context, node, 0, this.getName());
        OverrideDirective.OverrideNodeWrapper override = (OverrideDirective.OverrideNodeWrapper)context.get(DirectiveUtil.getOverrideVariableName(name));
        if(override == null) {
            Node current = node.jjtGetChild(1);
            context.put(DirectiveUtil.getOverrideVariableName(name), new OverrideDirective.OverrideNodeWrapper(current));
        } else {
            OverrideDirective.OverrideNodeWrapper current1 = new OverrideDirective.OverrideNodeWrapper(node.jjtGetChild(1));
            DirectiveUtil.setParentForTop(current1, override);
        }

        return true;
    }

    private boolean isOverrided(InternalContextAdapter context, String name) {
        return context.get(DirectiveUtil.getOverrideVariableName(name)) != null;
    }

    static class OverrideNodeWrapper extends SimpleNode {
        Node current;
        OverrideDirective.OverrideNodeWrapper parentNode;

        public OverrideNodeWrapper(Node node) {
            super(1);
            this.current = node;
        }

        public boolean render(InternalContextAdapter context, Writer writer) throws IOException, MethodInvocationException, ParseErrorException, ResourceNotFoundException {
            OverrideDirective.OverrideNodeWrapper preNode = (OverrideDirective.OverrideNodeWrapper)context.get(DirectiveUtil.OVERRIDE_CURRENT_NODE);

            boolean var4;
            try {
                context.put(DirectiveUtil.OVERRIDE_CURRENT_NODE, this);
                var4 = this.current.render(context, writer);
            } finally {
                context.put(DirectiveUtil.OVERRIDE_CURRENT_NODE, preNode);
            }

            return var4;
        }
    }
}
