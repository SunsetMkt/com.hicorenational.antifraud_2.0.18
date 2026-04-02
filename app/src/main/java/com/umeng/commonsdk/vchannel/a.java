package com.umeng.commonsdk.vchannel;

/* JADX INFO: compiled from: Constant.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a = "https://pslog.umeng.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7863b = "https://pslog.umeng.com/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f7864c = "explog";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7865d = "analytics";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7866e = "ekv";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7867f = "id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7868g = "ts";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7869h = "ds";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7870i = "pn";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f7871j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
        f7871j = sb.toString();
    }
}
