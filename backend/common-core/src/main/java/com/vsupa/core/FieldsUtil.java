package com.vsupa.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 字段工具类；
 * @author Maxwell.Lee
 * @date 2018-02-28 11:15
 * @since   1.0.0
 */
public class FieldsUtil {

    private static final String DefaultSeparator = ",";

    public static List<String> split(String str) {
        if (str == null || str.length() == 0) return null;

        String[] fields = str.split(DefaultSeparator);

        return new ArrayList<>(Arrays.asList(fields));
    }

    public static String composite(Collection<String> fields) {
        if (fields == null) return null;
        if (fields.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String f : fields) {
            if (!isFirst) sb.append(DefaultSeparator);

            sb.append(f);
            isFirst = false;
        }

        return sb.toString();
    }

}
