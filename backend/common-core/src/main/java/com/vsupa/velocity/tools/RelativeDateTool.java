//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.vsupa.velocity.tools;

import com.vsupa.velocity.RelativeDateFormat;
import org.apache.velocity.tools.ConversionUtils;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.generic.FormatConfig;

@DefaultKey("relativeDate")
public class RelativeDateTool extends FormatConfig {
    public RelativeDateTool() {
    }

    public String format(Object obj) {
        return RelativeDateFormat.format(ConversionUtils.toDate(obj));
    }
}
