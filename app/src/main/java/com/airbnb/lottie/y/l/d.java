package com.airbnb.lottie.y.l;

import androidx.annotation.Nullable;
import com.airbnb.lottie.y.j.j;
import com.airbnb.lottie.y.j.k;
import com.airbnb.lottie.y.j.l;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: Layer.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private final List<com.airbnb.lottie.y.k.b> a;

    /* JADX INFO: renamed from: b */
    private final com.airbnb.lottie.g f2528b;

    /* JADX INFO: renamed from: c */
    private final String f2529c;

    /* JADX INFO: renamed from: d */
    private final long f2530d;

    /* JADX INFO: renamed from: e */
    private final a f2531e;

    /* JADX INFO: renamed from: f */
    private final long f2532f;

    /* JADX INFO: renamed from: g */
    @Nullable
    private final String f2533g;

    /* JADX INFO: renamed from: h */
    private final List<com.airbnb.lottie.y.k.g> f2534h;

    /* JADX INFO: renamed from: i */
    private final l f2535i;

    /* JADX INFO: renamed from: j */
    private final int f2536j;

    /* JADX INFO: renamed from: k */
    private final int f2537k;

    /* JADX INFO: renamed from: l */
    private final int f2538l;

    /* JADX INFO: renamed from: m */
    private final float f2539m;

    /* JADX INFO: renamed from: n */
    private final float f2540n;
    private final int o;
    private final int p;

    @Nullable
    private final j q;

    @Nullable
    private final k r;

    @Nullable
    private final com.airbnb.lottie.y.j.b s;
    private final List<com.airbnb.lottie.c0.a<Float>> t;
    private final b u;
    private final boolean v;

    /* JADX INFO: compiled from: Layer.java */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* JADX INFO: compiled from: Layer.java */
    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public d(List<com.airbnb.lottie.y.k.b> list, com.airbnb.lottie.g gVar, String str, long j2, a aVar, long j3, @Nullable String str2, List<com.airbnb.lottie.y.k.g> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.c0.a<Float>> list3, b bVar, @Nullable com.airbnb.lottie.y.j.b bVar2, boolean z) {
        this.a = list;
        this.f2528b = gVar;
        this.f2529c = str;
        this.f2530d = j2;
        this.f2531e = aVar;
        this.f2532f = j3;
        this.f2533g = str2;
        this.f2534h = list2;
        this.f2535i = lVar;
        this.f2536j = i2;
        this.f2537k = i3;
        this.f2538l = i4;
        this.f2539m = f2;
        this.f2540n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
        this.v = z;
    }

    com.airbnb.lottie.g a() {
        return this.f2528b;
    }

    public long b() {
        return this.f2530d;
    }

    List<com.airbnb.lottie.c0.a<Float>> c() {
        return this.t;
    }

    public a d() {
        return this.f2531e;
    }

    List<com.airbnb.lottie.y.k.g> e() {
        return this.f2534h;
    }

    b f() {
        return this.u;
    }

    String g() {
        return this.f2529c;
    }

    long h() {
        return this.f2532f;
    }

    int i() {
        return this.p;
    }

    int j() {
        return this.o;
    }

    @Nullable
    String k() {
        return this.f2533g;
    }

    List<com.airbnb.lottie.y.k.b> l() {
        return this.a;
    }

    int m() {
        return this.f2538l;
    }

    int n() {
        return this.f2537k;
    }

    int o() {
        return this.f2536j;
    }

    float p() {
        return this.f2540n / this.f2528b.d();
    }

    @Nullable
    j q() {
        return this.q;
    }

    @Nullable
    k r() {
        return this.r;
    }

    @Nullable
    com.airbnb.lottie.y.j.b s() {
        return this.s;
    }

    float t() {
        return this.f2539m;
    }

    public String toString() {
        return a("");
    }

    l u() {
        return this.f2535i;
    }

    public boolean v() {
        return this.v;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        d dVarA = this.f2528b.a(h());
        if (dVarA != null) {
            sb.append("\t\tParents: ");
            sb.append(dVarA.g());
            d dVarA2 = this.f2528b.a(dVarA.h());
            while (dVarA2 != null) {
                sb.append("->");
                sb.append(dVarA2.g());
                dVarA2 = this.f2528b.a(dVarA2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.y.k.b bVar : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
