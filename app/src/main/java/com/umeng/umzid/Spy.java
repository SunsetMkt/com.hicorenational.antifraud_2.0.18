package com.umeng.umzid;

import android.content.Context;

/* loaded from: classes2.dex */
public class Spy {
    public static boolean initSuccess = false;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z, boolean z2);

    public static synchronized String getTag(Context context) {
        boolean j2;
        String nativeTag;
        synchronized (Spy.class) {
            if (context != null) {
                try {
                    j2 = d.j(context);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                j2 = false;
            }
            nativeTag = getNativeTag(j2, context != null ? d.i(context) : false);
        }
        return nativeTag;
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
