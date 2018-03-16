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

public class SuperDirective extends Directive {
    public SuperDirective() {
    }

    public String getName() {
        return "super";
    }

    public int getType() {
        return 2;
    }

    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        OverrideDirective.OverrideNodeWrapper current = (OverrideDirective.OverrideNodeWrapper)context.get(DirectiveUtil.OVERRIDE_CURRENT_NODE);
        if(current == null) {
            throw new ParseErrorException("#super direction must be child of override");
        } else {
            OverrideDirective.OverrideNodeWrapper parent = current.parentNode;
            if(parent == null) {
                throw new ParseErrorException("not found parent block for #super ");
            } else {
                return parent.render(context, writer);
            }
        }
    }
}
