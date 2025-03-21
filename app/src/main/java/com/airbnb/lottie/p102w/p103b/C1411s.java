package com.airbnb.lottie.p102w.p103b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1415b;
import com.airbnb.lottie.p102w.p104c.C1429p;
import com.airbnb.lottie.p106y.p108k.C1474p;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: StrokeContent.java */
/* renamed from: com.airbnb.lottie.w.b.s */
/* loaded from: classes.dex */
public class C1411s extends AbstractC1393a {

    /* renamed from: o */
    private final AbstractC1477a f3504o;

    /* renamed from: p */
    private final String f3505p;

    /* renamed from: q */
    private final boolean f3506q;

    /* renamed from: r */
    private final AbstractC1414a<Integer, Integer> f3507r;

    /* renamed from: s */
    @Nullable
    private AbstractC1414a<ColorFilter, ColorFilter> f3508s;

    public C1411s(C1379j c1379j, AbstractC1477a abstractC1477a, C1474p c1474p) {
        super(c1379j, abstractC1477a, c1474p.m3309a().toPaintCap(), c1474p.m3312d().toPaintJoin(), c1474p.m3314f(), c1474p.m3316h(), c1474p.m3317i(), c1474p.m3313e(), c1474p.m3311c());
        this.f3504o = abstractC1477a;
        this.f3505p = c1474p.m3315g();
        this.f3506q = c1474p.m3318j();
        this.f3507r = c1474p.m3310b().mo3220a();
        this.f3507r.m3138a(this);
        abstractC1477a.m3345a(this.f3507r);
    }

    @Override // com.airbnb.lottie.p102w.p103b.AbstractC1393a, com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3094a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f3506q) {
            return;
        }
        this.f3383i.setColor(((C1415b) this.f3507r).m3153i());
        AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3508s;
        if (abstractC1414a != null) {
            this.f3383i.setColorFilter(abstractC1414a.mo3143f());
        }
        super.mo3094a(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3505p;
    }

    @Override // com.airbnb.lottie.p102w.p103b.AbstractC1393a, com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        super.mo3097a((C1411s) t, (C1370j<C1411s>) c1370j);
        if (t == InterfaceC1384o.f3331b) {
            this.f3507r.m3137a((C1370j<Integer>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3326E) {
            AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3508s;
            if (abstractC1414a != null) {
                this.f3504o.m3350b(abstractC1414a);
            }
            if (c1370j == null) {
                this.f3508s = null;
                return;
            }
            this.f3508s = new C1429p(c1370j);
            this.f3508s.m3138a(this);
            this.f3504o.m3345a(this.f3507r);
        }
    }
}
