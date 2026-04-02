package com.airbnb.lottie.y.k;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.b.s;
import java.util.List;

/* JADX INFO: compiled from: ShapeStroke.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements com.airbnb.lottie.y.k.b {
    private final String a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private final com.airbnb.lottie.y.j.b f2499b;

    /* JADX INFO: renamed from: c */
    private final List<com.airbnb.lottie.y.j.b> f2500c;

    /* JADX INFO: renamed from: d */
    private final com.airbnb.lottie.y.j.a f2501d;

    /* JADX INFO: renamed from: e */
    private final com.airbnb.lottie.y.j.d f2502e;

    /* JADX INFO: renamed from: f */
    private final com.airbnb.lottie.y.j.b f2503f;

    /* JADX INFO: renamed from: g */
    private final b f2504g;

    /* JADX INFO: renamed from: h */
    private final c f2505h;

    /* JADX INFO: renamed from: i */
    private final float f2506i;

    /* JADX INFO: renamed from: j */
    private final boolean f2507j;

    /* JADX INFO: compiled from: ShapeStroke.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f2508b = new int[c.values().length];

        static {
            try {
                f2508b[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2508b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2508b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = new int[b.values().length];
            try {
                a[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: ShapeStroke.java */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i2 = a.a[ordinal()];
            return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* JADX INFO: compiled from: ShapeStroke.java */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i2 = a.f2508b[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, @Nullable com.airbnb.lottie.y.j.b bVar, List<com.airbnb.lottie.y.j.b> list, com.airbnb.lottie.y.j.a aVar, com.airbnb.lottie.y.j.d dVar, com.airbnb.lottie.y.j.b bVar2, b bVar3, c cVar, float f2, boolean z) {
        this.a = str;
        this.f2499b = bVar;
        this.f2500c = list;
        this.f2501d = aVar;
        this.f2502e = dVar;
        this.f2503f = bVar2;
        this.f2504g = bVar3;
        this.f2505h = cVar;
        this.f2506i = f2;
        this.f2507j = z;
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new s(jVar, aVar, this);
    }

    public com.airbnb.lottie.y.j.a b() {
        return this.f2501d;
    }

    public com.airbnb.lottie.y.j.b c() {
        return this.f2499b;
    }

    public c d() {
        return this.f2505h;
    }

    public List<com.airbnb.lottie.y.j.b> e() {
        return this.f2500c;
    }

    public float f() {
        return this.f2506i;
    }

    public String g() {
        return this.a;
    }

    public com.airbnb.lottie.y.j.d h() {
        return this.f2502e;
    }

    public com.airbnb.lottie.y.j.b i() {
        return this.f2503f;
    }

    public boolean j() {
        return this.f2507j;
    }

    public b a() {
        return this.f2504g;
    }
}
