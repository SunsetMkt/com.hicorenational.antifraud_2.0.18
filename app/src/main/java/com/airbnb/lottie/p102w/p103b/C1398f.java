package com.airbnb.lottie.p102w.p103b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p108k.C1459a;
import com.airbnb.lottie.p106y.p108k.C1475q;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.List;

/* compiled from: EllipseContent.java */
/* renamed from: com.airbnb.lottie.w.b.f */
/* loaded from: classes.dex */
public class C1398f implements InterfaceC1406n, AbstractC1414a.b, InterfaceC1403k {

    /* renamed from: i */
    private static final float f3403i = 0.55228f;

    /* renamed from: b */
    private final String f3405b;

    /* renamed from: c */
    private final C1379j f3406c;

    /* renamed from: d */
    private final AbstractC1414a<?, PointF> f3407d;

    /* renamed from: e */
    private final AbstractC1414a<?, PointF> f3408e;

    /* renamed from: f */
    private final C1459a f3409f;

    /* renamed from: h */
    private boolean f3411h;

    /* renamed from: a */
    private final Path f3404a = new Path();

    /* renamed from: g */
    private C1394b f3410g = new C1394b();

    public C1398f(C1379j c1379j, AbstractC1477a abstractC1477a, C1459a c1459a) {
        this.f3405b = c1459a.m3234a();
        this.f3406c = c1379j;
        this.f3407d = c1459a.m3236c().mo3220a();
        this.f3408e = c1459a.m3235b().mo3220a();
        this.f3409f = c1459a;
        abstractC1477a.m3345a(this.f3407d);
        abstractC1477a.m3345a(this.f3408e);
        this.f3407d.m3138a(this);
        this.f3408e.m3138a(this);
    }

    /* renamed from: b */
    private void m3108b() {
        this.f3411h = false;
        this.f3406c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        m3108b();
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3405b;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1406n
    public Path getPath() {
        if (this.f3411h) {
            return this.f3404a;
        }
        this.f3404a.reset();
        if (this.f3409f.m3237d()) {
            this.f3411h = true;
            return this.f3404a;
        }
        PointF mo3143f = this.f3407d.mo3143f();
        float f2 = mo3143f.x / 2.0f;
        float f3 = mo3143f.y / 2.0f;
        float f4 = f2 * f3403i;
        float f5 = f3403i * f3;
        this.f3404a.reset();
        if (this.f3409f.m3238e()) {
            float f6 = -f3;
            this.f3404a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.f3404a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.f3404a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.f3404a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.f3404a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.f3404a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.f3404a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.f3404a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.f3404a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.f3404a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF mo3143f2 = this.f3408e.mo3143f();
        this.f3404a.offset(mo3143f2.x, mo3143f2.y);
        this.f3404a.close();
        this.f3410g.m3101a(this.f3404a);
        this.f3411h = true;
        return this.f3404a;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            InterfaceC1395c interfaceC1395c = list.get(i2);
            if (interfaceC1395c instanceof C1412t) {
                C1412t c1412t = (C1412t) interfaceC1395c;
                if (c1412t.m3129e() == C1475q.a.SIMULTANEOUSLY) {
                    this.f3410g.m3102a(c1412t);
                    c1412t.m3125a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        C1357g.m2826a(c1439e, i2, list, c1439e2, this);
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        if (t == InterfaceC1384o.f3338i) {
            this.f3407d.m3137a((C1370j<PointF>) c1370j);
        } else if (t == InterfaceC1384o.f3341l) {
            this.f3408e.m3137a((C1370j<PointF>) c1370j);
        }
    }
}
