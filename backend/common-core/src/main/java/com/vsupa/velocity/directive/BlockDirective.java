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

import java.io.IOException;
import java.io.Writer;

public class BlockDirective extends Directive {
    public BlockDirective() {
    }

    public String getName() {
        return "block";
    }

    public int getType() {
        return 1;
    }

    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        String name = DirectiveUtil.getRequiredArgument(context, node, 0, this.getName());
        OverrideDirective.OverrideNodeWrapper overrideNode = this.getOverrideNode(context, name);
        Node topNode = node.jjtGetChild(1);
        if(overrideNode == null) {
            return topNode.render(context, writer);
        } else {
            DirectiveUtil.setParentForTop(new OverrideDirective.OverrideNodeWrapper(topNode), overrideNode);
            return overrideNode.render(context, writer);
        }
    }

    private OverrideDirective.OverrideNodeWrapper getOverrideNode(InternalContextAdapter context, String name) {
        return (OverrideDirective.OverrideNodeWrapper)context.get(DirectiveUtil.getOverrideVariableName(name));
    }
}
