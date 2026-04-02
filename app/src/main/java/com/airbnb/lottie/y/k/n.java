package com.airbnb.lottie.y.k;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: ShapeGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f2494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2495c;

    public n(String str, List<b> list, boolean z) {
        this.a = str;
        this.f2494b = list;
        this.f2495c = z;
    }

    public List<b> a() {
        return this.f2494b;
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        return this.f2495c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.f2494b.toArray()) + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.d(jVar, aVar, this);
    }
}
