package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class fb implements Cloneable {
    public static String a = "wcc-ml-test10.bj";

    /* JADX INFO: renamed from: b */
    public static String f8967b;

    /* JADX INFO: renamed from: a */
    private int f509a;

    /* JADX INFO: renamed from: a */
    private fe f510a;

    /* JADX INFO: renamed from: a */
    private boolean f511a = fa.f494a;

    /* JADX INFO: renamed from: b */
    private boolean f512b = true;

    /* JADX INFO: renamed from: c */
    private String f8968c;

    /* JADX INFO: renamed from: d */
    private String f8969d;

    /* JADX INFO: renamed from: e */
    private String f8970e;

    public fb(Map<String, Integer> map, int i2, String str, fe feVar) {
        a(map, i2, str, feVar);
    }

    public static final String a() {
        String str = f8967b;
        return str != null ? str : x.m764a() ? "sandbox.xmpush.xiaomi.com" : x.b() ? "10.38.162.35" : "app.chat.xiaomi.net";
    }

    /* JADX INFO: renamed from: a */
    public byte[] mo420a() {
        return null;
    }

    public void b(String str) {
        this.f8970e = str;
    }

    public String c() {
        if (this.f8969d == null) {
            this.f8969d = a();
        }
        return this.f8969d;
    }

    public String b() {
        return this.f8970e;
    }

    public static final void a(String str) {
        if (x.b()) {
            return;
        }
        f8967b = str;
    }

    public void c(String str) {
        this.f8969d = str;
    }

    private void a(Map<String, Integer> map, int i2, String str, fe feVar) {
        this.f509a = i2;
        this.f8968c = str;
        this.f510a = feVar;
    }

    /* JADX INFO: renamed from: a */
    public int m418a() {
        return this.f509a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m419a() {
        return this.f511a;
    }

    public void a(boolean z) {
        this.f511a = z;
    }
}
