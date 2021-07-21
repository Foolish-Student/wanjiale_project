package com.framework.common.utils;

import java.util.UUID;

/**
 * @author 246419
 * @date 2021/01/28
 */
public class CUtils {
    private static final String HYPHEN = "-";

    private static final String SPACE = "";

    public static String uuid() {
        return UUID.randomUUID().toString().replace(HYPHEN, SPACE);
    }
}
