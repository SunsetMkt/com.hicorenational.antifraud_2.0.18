package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceLoaderUtil {
    private static Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f5016b;

    public static int getAnimId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", f5016b);
    }

    public static int getColorId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, RemoteMessageConst.Notification.COLOR, f5016b);
    }

    public static int getDimenId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", f5016b);
    }

    public static Drawable getDrawable(String str) {
        Context context = a;
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", f5016b);
    }

    public static int getIdId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", f5016b);
    }

    public static int getLayoutId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "layout", f5016b);
    }

    public static String getString(String str) {
        Context context = a;
        return context == null ? "" : context.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "string", f5016b);
    }

    public static int getStyleId(String str) {
        Context context = a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "style", f5016b);
    }

    public static Context getmContext() {
        return a;
    }

    public static void setmContext(Context context) {
        a = context;
        if (context != null) {
            f5016b = context.getPackageName();
        } else {
            f5016b = null;
            HMSLog.e("ResourceLoaderUtil", "context is null");
        }
    }

    public static String getString(String str, Object... objArr) {
        Context context = a;
        return context == null ? "" : context.getResources().getString(getStringId(str), objArr);
    }
}
