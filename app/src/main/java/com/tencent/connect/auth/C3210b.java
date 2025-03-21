package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.auth.b */
/* loaded from: classes2.dex */
public class C3210b {

    /* renamed from: a */
    public static C3210b f10936a;

    /* renamed from: d */
    static final /* synthetic */ boolean f10937d = !C3210b.class.desiredAssertionStatus();

    /* renamed from: e */
    private static int f10938e = 0;

    /* renamed from: b */
    public HashMap<String, a> f10939b = new HashMap<>();

    /* renamed from: c */
    public final String f10940c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.b$a */
    public static class a {

        /* renamed from: a */
        public IUiListener f10941a;

        /* renamed from: b */
        public DialogC3209a f10942b;

        /* renamed from: c */
        public String f10943c;
    }

    /* renamed from: a */
    public static C3210b m10227a() {
        if (f10936a == null) {
            f10936a = new C3210b();
        }
        return f10936a;
    }

    /* renamed from: b */
    public static int m10228b() {
        int i2 = f10938e + 1;
        f10938e = i2;
        return i2;
    }

    /* renamed from: c */
    public String m10230c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < ceil; i2++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String m10229a(a aVar) {
        int m10228b = m10228b();
        try {
            this.f10939b.put("" + m10228b, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + m10228b;
    }
}
