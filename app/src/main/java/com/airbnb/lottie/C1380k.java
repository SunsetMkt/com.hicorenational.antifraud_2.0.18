package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: LottieImageAsset.java */
/* renamed from: com.airbnb.lottie.k */
/* loaded from: classes.dex */
public class C1380k {

    /* renamed from: a */
    private final int f3316a;

    /* renamed from: b */
    private final int f3317b;

    /* renamed from: c */
    private final String f3318c;

    /* renamed from: d */
    private final String f3319d;

    /* renamed from: e */
    private final String f3320e;

    /* renamed from: f */
    @Nullable
    private Bitmap f3321f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public C1380k(int i2, int i3, String str, String str2, String str3) {
        this.f3316a = i2;
        this.f3317b = i3;
        this.f3318c = str;
        this.f3319d = str2;
        this.f3320e = str3;
    }

    @Nullable
    /* renamed from: a */
    public Bitmap m3051a() {
        return this.f3321f;
    }

    /* renamed from: b */
    public String m3053b() {
        return this.f3320e;
    }

    /* renamed from: c */
    public String m3054c() {
        return this.f3319d;
    }

    /* renamed from: d */
    public int m3055d() {
        return this.f3317b;
    }

    /* renamed from: e */
    public String m3056e() {
        return this.f3318c;
    }

    /* renamed from: f */
    public int m3057f() {
        return this.f3316a;
    }

    /* renamed from: g */
    public boolean m3058g() {
        return this.f3321f != null || (this.f3319d.startsWith("data:") && this.f3319d.indexOf("base64,") > 0);
    }

    /* renamed from: a */
    public void m3052a(@Nullable Bitmap bitmap) {
        this.f3321f = bitmap;
    }
}
