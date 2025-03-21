package com.vivo.push.model;

import android.text.TextUtils;

/* compiled from: PushPackageInfo.java */
/* renamed from: com.vivo.push.model.b */
/* loaded from: classes2.dex */
public final class C3926b {

    /* renamed from: a */
    private String f14093a;

    /* renamed from: d */
    private String f14096d;

    /* renamed from: b */
    private long f14094b = -1;

    /* renamed from: c */
    private int f14095c = -1;

    /* renamed from: e */
    private boolean f14097e = false;

    /* renamed from: f */
    private boolean f14098f = false;

    public C3926b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f14093a = str;
    }

    /* renamed from: a */
    public final String m13060a() {
        return this.f14093a;
    }

    /* renamed from: b */
    public final long m13065b() {
        return this.f14094b;
    }

    /* renamed from: c */
    public final boolean m13067c() {
        return this.f14097e;
    }

    /* renamed from: d */
    public final boolean m13068d() {
        return this.f14098f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f14093a + ", mPushVersion=" + this.f14094b + ", mPackageVersion=" + this.f14095c + ", mInBlackList=" + this.f14097e + ", mPushEnable=" + this.f14098f + "}";
    }

    /* renamed from: a */
    public final void m13062a(long j2) {
        this.f14094b = j2;
    }

    /* renamed from: b */
    public final void m13066b(boolean z) {
        this.f14098f = z;
    }

    /* renamed from: a */
    public final void m13064a(boolean z) {
        this.f14097e = z;
    }

    /* renamed from: a */
    public final void m13061a(int i2) {
        this.f14095c = i2;
    }

    /* renamed from: a */
    public final void m13063a(String str) {
        this.f14096d = str;
    }
}
