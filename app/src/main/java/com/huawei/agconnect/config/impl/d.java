package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f4324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4325g;

    public d(String str, String str2, String str3, String str4, String str5, int i2) {
        this.f4325g = 0;
        this.a = str;
        this.f4320b = str2;
        this.f4321c = str3;
        this.f4322d = str4;
        this.f4323e = str5;
        this.f4324f = i2;
        if (str != null) {
            this.f4325g = str.length() / 2;
        }
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f4320b) || TextUtils.isEmpty(this.f4321c) || TextUtils.isEmpty(this.f4322d) || this.a.length() != this.f4320b.length() || this.f4320b.length() != this.f4321c.length() || this.f4321c.length() != this.f4325g * 2 || this.f4324f < 0 || TextUtils.isEmpty(this.f4323e)) ? false : true;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f4320b;
    }

    public String d() {
        return this.f4321c;
    }

    public String e() {
        return this.f4322d;
    }

    public String f() {
        return this.f4323e;
    }

    public int g() {
        return this.f4324f;
    }

    public int h() {
        return this.f4325g;
    }
}
