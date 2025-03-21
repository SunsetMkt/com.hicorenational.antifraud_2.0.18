package com.airbnb.lottie.p106y.p108k;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1411s;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p107j.C1444a;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1447d;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.List;

/* compiled from: ShapeStroke.java */
/* renamed from: com.airbnb.lottie.y.k.p */
/* loaded from: classes.dex */
public class C1474p implements InterfaceC1460b {

    /* renamed from: a */
    private final String f3708a;

    /* renamed from: b */
    @Nullable
    private final C1445b f3709b;

    /* renamed from: c */
    private final List<C1445b> f3710c;

    /* renamed from: d */
    private final C1444a f3711d;

    /* renamed from: e */
    private final C1447d f3712e;

    /* renamed from: f */
    private final C1445b f3713f;

    /* renamed from: g */
    private final b f3714g;

    /* renamed from: h */
    private final c f3715h;

    /* renamed from: i */
    private final float f3716i;

    /* renamed from: j */
    private final boolean f3717j;

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.airbnb.lottie.y.k.p$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3718a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3719b = new int[c.values().length];

        static {
            try {
                f3719b[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3719b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3719b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3718a = new int[b.values().length];
            try {
                f3718a[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3718a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3718a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.airbnb.lottie.y.k.p$b */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i2 = a.f3718a[ordinal()];
            return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.airbnb.lottie.y.k.p$c */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i2 = a.f3719b[ordinal()];
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

    public C1474p(String str, @Nullable C1445b c1445b, List<C1445b> list, C1444a c1444a, C1447d c1447d, C1445b c1445b2, b bVar, c cVar, float f2, boolean z) {
        this.f3708a = str;
        this.f3709b = c1445b;
        this.f3710c = list;
        this.f3711d = c1444a;
        this.f3712e = c1447d;
        this.f3713f = c1445b2;
        this.f3714g = bVar;
        this.f3715h = cVar;
        this.f3716i = f2;
        this.f3717j = z;
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        return new C1411s(c1379j, abstractC1477a, this);
    }

    /* renamed from: b */
    public C1444a m3310b() {
        return this.f3711d;
    }

    /* renamed from: c */
    public C1445b m3311c() {
        return this.f3709b;
    }

    /* renamed from: d */
    public c m3312d() {
        return this.f3715h;
    }

    /* renamed from: e */
    public List<C1445b> m3313e() {
        return this.f3710c;
    }

    /* renamed from: f */
    public float m3314f() {
        return this.f3716i;
    }

    /* renamed from: g */
    public String m3315g() {
        return this.f3708a;
    }

    /* renamed from: h */
    public C1447d m3316h() {
        return this.f3712e;
    }

    /* renamed from: i */
    public C1445b m3317i() {
        return this.f3713f;
    }

    /* renamed from: j */
    public boolean m3318j() {
        return this.f3717j;
    }

    /* renamed from: a */
    public b m3309a() {
        return this.f3714g;
    }
}
