package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static b a;

    /* JADX INFO: renamed from: d */
    static final /* synthetic */ boolean f6668d = !b.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: e */
    private static int f6669e = 0;

    /* JADX INFO: renamed from: b */
    public HashMap<String, a> f6670b = new HashMap<>();

    /* JADX INFO: renamed from: c */
    public final String f6671c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* JADX INFO: compiled from: ProGuard */
    public static class a {
        public IUiListener a;

        /* JADX INFO: renamed from: b */
        public com.tencent.connect.auth.a f6672b;

        /* JADX INFO: renamed from: c */
        public String f6673c;
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public static int b() {
        int i2 = f6669e + 1;
        f6669e = i2;
        return i2;
    }

    public String c() {
        int iCeil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < iCeil; i2++) {
            stringBuffer.append(charArray[(int) (Math.random() * ((double) length))]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int iB = b();
        try {
            this.f6670b.put("" + iB, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + iB;
    }
}
