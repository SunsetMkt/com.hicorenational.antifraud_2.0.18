package com.leon.channel.helper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: ChannelReaderUtil.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7742a = "ChannelReaderUtil";

    /* renamed from: b, reason: collision with root package name */
    private static String f7743b;

    public static byte[] a(Context context, int i2) {
        return c.d.a.b.b.b(new File(b(context)), i2);
    }

    public static String b(Context context, int i2) {
        String c2 = c.d.a.b.b.c(new File(b(context)), i2);
        String str = "id = " + i2 + " , value = " + c2;
        return c2;
    }

    public static String c(Context context) {
        if (f7743b == null) {
            String e2 = e(context);
            if (e2 == null) {
                e2 = d(context);
            }
            f7743b = e2;
        }
        return f7743b;
    }

    public static String d(Context context) {
        String c2 = c.d.a.b.a.c(new File(b(context)));
        String str = "getChannelByV1 , channel = " + c2;
        return c2;
    }

    public static String e(Context context) {
        String d2 = c.d.a.b.a.d(new File(b(context)));
        String str = "getChannelByV2 , channel = " + d2;
        return d2;
    }

    public static Map<Integer, ByteBuffer> a(Context context) {
        return c.d.a.b.b.a(new File(b(context)));
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
