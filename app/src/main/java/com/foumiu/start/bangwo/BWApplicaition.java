package com.foumiu.start.bangwo;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * Created by dabo on 2018/6/24.
 */

public class BWApplicaition extends Application {

    public static Resources resources;
    static final int version = Build.VERSION.SDK_INT;


    @Override
    public void onCreate() {
        super.onCreate();
        resources = getResources();
    }

    public static final int getColor(Context ctx, int id) {
        if (version >= 23) {
            return ContextCompat.getColor(ctx, id);
        } else {
            return ctx.getResources().getColor(id);
        }
    }

    public static final String getString(Context ctx, int id) {
        return ctx.getResources().getString(id);
    }
}
