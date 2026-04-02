package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: LottieImageAsset.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Bitmap f2220f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(int i2, int i3, String str, String str2, String str3) {
        this.a = i2;
        this.f2216b = i3;
        this.f2217c = str;
        this.f2218d = str2;
        this.f2219e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f2220f;
    }

    public String b() {
        return this.f2219e;
    }

    public String c() {
        return this.f2218d;
    }

    public int d() {
        return this.f2216b;
    }

    public String e() {
        return this.f2217c;
    }

    public int f() {
        return this.a;
    }

    public boolean g() {
        return this.f2220f != null || (this.f2218d.startsWith("data:") && this.f2218d.indexOf("base64,") > 0);
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f2220f = bitmap;
    }
}
