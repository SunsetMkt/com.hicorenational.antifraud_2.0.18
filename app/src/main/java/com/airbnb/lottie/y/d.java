package com.airbnb.lottie.y;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.y.k.n;
import java.util.List;

/* JADX INFO: compiled from: FontCharacter.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class d {
    private final List<n> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f2415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f2416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f2417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2419f;

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.a = list;
        this.f2415b = c2;
        this.f2416c = d2;
        this.f2417d = d3;
        this.f2418e = str;
        this.f2419f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    double b() {
        return this.f2416c;
    }

    String c() {
        return this.f2418e;
    }

    public double d() {
        return this.f2417d;
    }

    public int hashCode() {
        return a(this.f2415b, this.f2419f, this.f2418e);
    }

    public List<n> a() {
        return this.a;
    }
}
