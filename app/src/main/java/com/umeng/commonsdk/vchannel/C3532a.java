package com.umeng.commonsdk.vchannel;

/* compiled from: Constant.java */
/* renamed from: com.umeng.commonsdk.vchannel.a */
/* loaded from: classes2.dex */
public class C3532a {

    /* renamed from: a */
    public static String f13025a = "https://pslog.umeng.com";

    /* renamed from: b */
    public static String f13026b = "https://pslog.umeng.com/";

    /* renamed from: c */
    public static String f13027c = "explog";

    /* renamed from: d */
    public static final String f13028d = "analytics";

    /* renamed from: e */
    public static final String f13029e = "ekv";

    /* renamed from: f */
    public static final String f13030f = "id";

    /* renamed from: g */
    public static final String f13031g = "ts";

    /* renamed from: h */
    public static final String f13032h = "ds";

    /* renamed from: i */
    public static final String f13033i = "pn";

    /* renamed from: j */
    public static String f13034j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
        f13034j = sb.toString();
    }
}
