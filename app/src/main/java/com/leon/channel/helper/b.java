package com.leon.channel.helper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: compiled from: ChannelReaderUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String a = "ChannelReaderUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f5270b;

    public static byte[] a(Context context, int i2) {
        return d.d.a.b.b.b(new File(b(context)), i2);
    }

    public static String b(Context context, int i2) {
        String strC = d.d.a.b.b.c(new File(b(context)), i2);
        String str = "id = " + i2 + " , value = " + strC;
        return strC;
    }

    public static String c(Context context) {
        if (f5270b == null) {
            String strE = e(context);
            if (strE == null) {
                strE = d(context);
            }
            f5270b = strE;
        }
        return f5270b;
    }

    public static String d(Context context) {
        String strC = d.d.a.b.a.c(new File(b(context)));
        String str = "getChannelByV1 , channel = " + strC;
        return strC;
    }

    public static String e(Context context) {
        String strD = d.d.a.b.a.d(new File(b(context)));
        String str = "getChannelByV2 , channel = " + strD;
        return strD;
    }

    public static Map<Integer, ByteBuffer> a(Context context) {
        return d.d.a.b.b.a(new File(b(context)));
    }

    private static String b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
