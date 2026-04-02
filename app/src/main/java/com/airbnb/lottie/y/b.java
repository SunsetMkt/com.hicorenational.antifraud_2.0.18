package com.airbnb.lottie.y;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: DocumentData.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f2403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f2405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f2406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColorInt
    public final int f2407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColorInt
    public final int f2408i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f2409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f2410k;

    /* JADX INFO: compiled from: DocumentData.java */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, float f2, a aVar, int i2, float f3, float f4, @ColorInt int i3, @ColorInt int i4, float f5, boolean z) {
        this.a = str;
        this.f2401b = str2;
        this.f2402c = f2;
        this.f2403d = aVar;
        this.f2404e = i2;
        this.f2405f = f3;
        this.f2406g = f4;
        this.f2407h = i3;
        this.f2408i = i4;
        this.f2409j = f5;
        this.f2410k = z;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.a.hashCode() * 31) + this.f2401b.hashCode()) * 31) + this.f2402c)) * 31) + this.f2403d.ordinal()) * 31) + this.f2404e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f2405f);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f2407h;
    }
}
