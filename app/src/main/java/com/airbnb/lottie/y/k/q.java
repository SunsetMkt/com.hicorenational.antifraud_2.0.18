package com.airbnb.lottie.y.k;

import com.airbnb.lottie.w.b.t;

/* JADX INFO: compiled from: ShapeTrimPath.java */
/* JADX INFO: loaded from: classes.dex */
public class q implements b {
    private final String a;

    /* JADX INFO: renamed from: b */
    private final a f2509b;

    /* JADX INFO: renamed from: c */
    private final com.airbnb.lottie.y.j.b f2510c;

    /* JADX INFO: renamed from: d */
    private final com.airbnb.lottie.y.j.b f2511d;

    /* JADX INFO: renamed from: e */
    private final com.airbnb.lottie.y.j.b f2512e;

    /* JADX INFO: renamed from: f */
    private final boolean f2513f;

    /* JADX INFO: compiled from: ShapeTrimPath.java */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a forId(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i2);
        }
    }

    public q(String str, a aVar, com.airbnb.lottie.y.j.b bVar, com.airbnb.lottie.y.j.b bVar2, com.airbnb.lottie.y.j.b bVar3, boolean z) {
        this.a = str;
        this.f2509b = aVar;
        this.f2510c = bVar;
        this.f2511d = bVar2;
        this.f2512e = bVar3;
        this.f2513f = z;
    }

    public com.airbnb.lottie.y.j.b a() {
        return this.f2511d;
    }

    public String b() {
        return this.a;
    }

    public com.airbnb.lottie.y.j.b c() {
        return this.f2512e;
    }

    public com.airbnb.lottie.y.j.b d() {
        return this.f2510c;
    }

    public a e() {
        return this.f2509b;
    }

    public boolean f() {
        return this.f2513f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f2510c + ", end: " + this.f2511d + ", offset: " + this.f2512e + "}";
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new t(aVar, this);
    }
}
