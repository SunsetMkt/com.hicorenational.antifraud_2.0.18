package com.airbnb.lottie.p106y;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.p106y.p108k.C1472n;
import java.util.List;

/* compiled from: FontCharacter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.airbnb.lottie.y.d */
/* loaded from: classes.dex */
public class C1438d {

    /* renamed from: a */
    private final List<C1472n> f3597a;

    /* renamed from: b */
    private final char f3598b;

    /* renamed from: c */
    private final double f3599c;

    /* renamed from: d */
    private final double f3600d;

    /* renamed from: e */
    private final String f3601e;

    /* renamed from: f */
    private final String f3602f;

    public C1438d(List<C1472n> list, char c2, double d2, double d3, String str, String str2) {
        this.f3597a = list;
        this.f3598b = c2;
        this.f3599c = d2;
        this.f3600d = d3;
        this.f3601e = str;
        this.f3602f = str2;
    }

    /* renamed from: a */
    public static int m3197a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    /* renamed from: b */
    double m3199b() {
        return this.f3599c;
    }

    /* renamed from: c */
    String m3200c() {
        return this.f3601e;
    }

    /* renamed from: d */
    public double m3201d() {
        return this.f3600d;
    }

    public int hashCode() {
        return m3197a(this.f3598b, this.f3602f, this.f3601e);
    }

    /* renamed from: a */
    public List<C1472n> m3198a() {
        return this.f3597a;
    }
}
