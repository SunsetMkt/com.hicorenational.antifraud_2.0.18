package com.umeng.p221ut.p226b.p227a.p228a;

import android.text.TextUtils;
import java.util.Random;

/* renamed from: com.umeng.ut.b.a.a.c */
/* loaded from: classes2.dex */
public class C3813c {
    /* renamed from: e */
    private static String m12794e() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] bytes = C3812b.getBytes(currentTimeMillis);
        byte[] bytes2 = C3812b.getBytes(nanoTime);
        byte[] bytes3 = C3812b.getBytes(nextInt);
        byte[] bytes4 = C3812b.getBytes(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return C3811a.m12790a(bArr, 2);
    }

    /* renamed from: f */
    public static String m12795f() {
        String m12796g = m12796g();
        return C3814d.isEmpty(m12796g) ? m12794e() : m12796g;
    }

    /* renamed from: g */
    private static String m12796g() {
        String str = C3815e.get("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(str)) {
            str = C3815e.get("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(str) ? m12797h() : str;
    }

    /* renamed from: h */
    private static String m12797h() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }
}
