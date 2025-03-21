package com.airbnb.lottie.p106y;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* compiled from: DocumentData.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.airbnb.lottie.y.b */
/* loaded from: classes.dex */
public class C1436b {

    /* renamed from: a */
    public final String f3580a;

    /* renamed from: b */
    public final String f3581b;

    /* renamed from: c */
    public final float f3582c;

    /* renamed from: d */
    public final a f3583d;

    /* renamed from: e */
    public final int f3584e;

    /* renamed from: f */
    public final float f3585f;

    /* renamed from: g */
    public final float f3586g;

    /* renamed from: h */
    @ColorInt
    public final int f3587h;

    /* renamed from: i */
    @ColorInt
    public final int f3588i;

    /* renamed from: j */
    public final float f3589j;

    /* renamed from: k */
    public final boolean f3590k;

    /* compiled from: DocumentData.java */
    /* renamed from: com.airbnb.lottie.y.b$a */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public C1436b(String str, String str2, float f2, a aVar, int i2, float f3, float f4, @ColorInt int i3, @ColorInt int i4, float f5, boolean z) {
        this.f3580a = str;
        this.f3581b = str2;
        this.f3582c = f2;
        this.f3583d = aVar;
        this.f3584e = i2;
        this.f3585f = f3;
        this.f3586g = f4;
        this.f3587h = i3;
        this.f3588i = i4;
        this.f3589j = f5;
        this.f3590k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f3580a.hashCode() * 31) + this.f3581b.hashCode()) * 31) + this.f3582c)) * 31) + this.f3583d.ordinal()) * 31) + this.f3584e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f3585f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f3587h;
    }
}
