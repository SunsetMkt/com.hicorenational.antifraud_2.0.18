package com.leon.channel.helper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Map;
import p031c.p091d.p092a.p095b.C1224a;
import p031c.p091d.p092a.p095b.C1225b;

/* compiled from: ChannelReaderUtil.java */
/* renamed from: com.leon.channel.helper.b */
/* loaded from: classes.dex */
public class C2620b {

    /* renamed from: a */
    private static final String f8324a = "ChannelReaderUtil";

    /* renamed from: b */
    private static String f8325b;

    /* renamed from: a */
    public static byte[] m8086a(Context context, int i2) {
        return C1225b.m2429b(new File(m8087b(context)), i2);
    }

    /* renamed from: b */
    public static String m8088b(Context context, int i2) {
        String m2430c = C1225b.m2430c(new File(m8087b(context)), i2);
        String str = "id = " + i2 + " , value = " + m2430c;
        return m2430c;
    }

    /* renamed from: c */
    public static String m8089c(Context context) {
        if (f8325b == null) {
            String m8091e = m8091e(context);
            if (m8091e == null) {
                m8091e = m8090d(context);
            }
            f8325b = m8091e;
        }
        return f8325b;
    }

    /* renamed from: d */
    public static String m8090d(Context context) {
        String m2425c = C1224a.m2425c(new File(m8087b(context)));
        String str = "getChannelByV1 , channel = " + m2425c;
        return m2425c;
    }

    /* renamed from: e */
    public static String m8091e(Context context) {
        String m2426d = C1224a.m2426d(new File(m8087b(context)));
        String str = "getChannelByV2 , channel = " + m2426d;
        return m2426d;
    }

    /* renamed from: a */
    public static Map<Integer, ByteBuffer> m8085a(Context context) {
        return C1225b.m2428a(new File(m8087b(context)));
    }

    /* renamed from: b */
    private static String m8087b(Context context) {
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
