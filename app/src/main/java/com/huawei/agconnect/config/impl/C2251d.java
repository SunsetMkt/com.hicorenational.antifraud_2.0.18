package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

/* renamed from: com.huawei.agconnect.config.impl.d */
/* loaded from: classes.dex */
public class C2251d {

    /* renamed from: a */
    private final String f6890a;

    /* renamed from: b */
    private final String f6891b;

    /* renamed from: c */
    private final String f6892c;

    /* renamed from: d */
    private final String f6893d;

    /* renamed from: e */
    private final String f6894e;

    /* renamed from: f */
    private final int f6895f;

    /* renamed from: g */
    private int f6896g;

    public C2251d(String str, String str2, String str3, String str4, String str5, int i2) {
        this.f6896g = 0;
        this.f6890a = str;
        this.f6891b = str2;
        this.f6892c = str3;
        this.f6893d = str4;
        this.f6894e = str5;
        this.f6895f = i2;
        if (str != null) {
            this.f6896g = str.length() / 2;
        }
    }

    /* renamed from: a */
    public boolean m6420a() {
        return (TextUtils.isEmpty(this.f6890a) || TextUtils.isEmpty(this.f6891b) || TextUtils.isEmpty(this.f6892c) || TextUtils.isEmpty(this.f6893d) || this.f6890a.length() != this.f6891b.length() || this.f6891b.length() != this.f6892c.length() || this.f6892c.length() != this.f6896g * 2 || this.f6895f < 0 || TextUtils.isEmpty(this.f6894e)) ? false : true;
    }

    /* renamed from: b */
    public String m6421b() {
        return this.f6890a;
    }

    /* renamed from: c */
    public String m6422c() {
        return this.f6891b;
    }

    /* renamed from: d */
    public String m6423d() {
        return this.f6892c;
    }

    /* renamed from: e */
    public String m6424e() {
        return this.f6893d;
    }

    /* renamed from: f */
    public String m6425f() {
        return this.f6894e;
    }

    /* renamed from: g */
    public int m6426g() {
        return this.f6895f;
    }

    /* renamed from: h */
    public int m6427h() {
        return this.f6896g;
    }
}
