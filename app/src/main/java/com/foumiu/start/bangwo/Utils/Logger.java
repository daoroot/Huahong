package com.foumiu.start.bangwo.Utils;

import android.util.Log;

/**
 * Created by dabo on 2018/6/24.
 */

public class Logger {
    private static final String appTag = Logger.class.getName();

    private static final boolean DEBUG = true;

    public static void v(String tag, String desc) {
        if (DEBUG)
            v(tag.concat(desc));
    }

    public static void d(String tag, String desc) {
        if (DEBUG)
            v(tag.concat(desc));
    }

    public static void i(String tag, String desc) {
        if (DEBUG)
            v(tag.concat(desc));
    }

    public static void e(String tag, String desc) {
        if (DEBUG)
            v(tag.concat(desc));
    }

    public static void v(String desc) {
        if (DEBUG)
            Log.v(appTag, desc);
    }

    public static void d(String desc) {
        if (DEBUG)
            Log.v(appTag, desc);
    }

    public static void i(String desc) {
        if (DEBUG)
            Log.v(appTag, desc);
    }

    public static void e(String desc) {
        if (DEBUG)
            Log.v(appTag, desc);
    }
}
