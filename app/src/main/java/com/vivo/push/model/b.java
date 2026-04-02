package com.vivo.push.model;

import android.text.TextUtils;

/* JADX INFO: compiled from: PushPackageInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private String a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8567d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8565b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8566c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8568e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8569f = false;

    public b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final long b() {
        return this.f8565b;
    }

    public final boolean c() {
        return this.f8568e;
    }

    public final boolean d() {
        return this.f8569f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.a + ", mPushVersion=" + this.f8565b + ", mPackageVersion=" + this.f8566c + ", mInBlackList=" + this.f8568e + ", mPushEnable=" + this.f8569f + "}";
    }

    public final void a(long j2) {
        this.f8565b = j2;
    }

    public final void b(boolean z) {
        this.f8569f = z;
    }

    public final void a(boolean z) {
        this.f8568e = z;
    }

    public final void a(int i2) {
        this.f8566c = i2;
    }

    public final void a(String str) {
        this.f8567d = str;
    }
}
