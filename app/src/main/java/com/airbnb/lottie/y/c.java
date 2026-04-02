package com.airbnb.lottie.y;

import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: Font.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class c {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f2413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Typeface f2414e;

    public c(String str, String str2, String str3, float f2) {
        this.a = str;
        this.f2411b = str2;
        this.f2412c = str3;
        this.f2413d = f2;
    }

    float a() {
        return this.f2413d;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f2411b;
    }

    public String d() {
        return this.f2412c;
    }

    @Nullable
    public Typeface e() {
        return this.f2414e;
    }

    public void a(@Nullable Typeface typeface) {
        this.f2414e = typeface;
    }
}
