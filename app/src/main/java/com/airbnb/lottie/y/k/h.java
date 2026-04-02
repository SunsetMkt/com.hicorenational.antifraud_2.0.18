package com.airbnb.lottie.y.k;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MergePaths.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2469c;

    /* JADX INFO: compiled from: MergePaths.java */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a forId(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public h(String str, a aVar, boolean z) {
        this.a = str;
        this.f2468b = aVar;
        this.f2469c = z;
    }

    public a a() {
        return this.f2468b;
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        return this.f2469c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f2468b + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    @Nullable
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        if (jVar.d()) {
            return new com.airbnb.lottie.w.b.l(this);
        }
        com.airbnb.lottie.b0.d.b("Animation contains merge paths but they are disabled.");
        return null;
    }
}
