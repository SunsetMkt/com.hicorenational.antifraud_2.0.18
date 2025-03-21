package com.airbnb.lottie.p106y.p109l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1429p;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p109l.C1480d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CompositionLayer.java */
/* renamed from: com.airbnb.lottie.y.l.b */
/* loaded from: classes.dex */
public class C1478b extends AbstractC1477a {

    /* renamed from: D */
    @Nullable
    private AbstractC1414a<Float, Float> f3761D;

    /* renamed from: E */
    private final List<AbstractC1477a> f3762E;

    /* renamed from: F */
    private final RectF f3763F;

    /* renamed from: G */
    private final RectF f3764G;

    /* renamed from: H */
    private Paint f3765H;

    /* renamed from: I */
    @Nullable
    private Boolean f3766I;

    /* renamed from: J */
    @Nullable
    private Boolean f3767J;

    /* compiled from: CompositionLayer.java */
    /* renamed from: com.airbnb.lottie.y.l.b$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3768a = new int[C1480d.b.values().length];

        static {
            try {
                f3768a[C1480d.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3768a[C1480d.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C1478b(C1379j c1379j, C1480d c1480d, List<C1480d> list, C1376g c1376g) {
        super(c1379j, c1480d);
        int i2;
        AbstractC1477a abstractC1477a;
        this.f3762E = new ArrayList();
        this.f3763F = new RectF();
        this.f3764G = new RectF();
        this.f3765H = new Paint();
        C1445b m3377s = c1480d.m3377s();
        if (m3377s != null) {
            this.f3761D = m3377s.mo3220a();
            m3345a(this.f3761D);
            this.f3761D.m3138a(this);
        } else {
            this.f3761D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(c1376g.m2905i().size());
        int size = list.size() - 1;
        AbstractC1477a abstractC1477a2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            C1480d c1480d2 = list.get(size);
            AbstractC1477a m3325a = AbstractC1477a.m3325a(c1480d2, c1379j, c1376g);
            if (m3325a != null) {
                longSparseArray.put(m3325a.m3348b().m3360b(), m3325a);
                if (abstractC1477a2 != null) {
                    abstractC1477a2.m3346a(m3325a);
                    abstractC1477a2 = null;
                } else {
                    this.f3762E.add(0, m3325a);
                    int i3 = a.f3768a[c1480d2.m3364f().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        abstractC1477a2 = m3325a;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            AbstractC1477a abstractC1477a3 = (AbstractC1477a) longSparseArray.get(longSparseArray.keyAt(i2));
            if (abstractC1477a3 != null && (abstractC1477a = (AbstractC1477a) longSparseArray.get(abstractC1477a3.m3348b().m3366h())) != null) {
                abstractC1477a3.m3352b(abstractC1477a);
            }
        }
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: a */
    public void mo3347a(boolean z) {
        super.mo3347a(z);
        Iterator<AbstractC1477a> it = this.f3762E.iterator();
        while (it.hasNext()) {
            it.next().mo3347a(z);
        }
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: b */
    void mo3349b(Canvas canvas, Matrix matrix, int i2) {
        C1374e.m2881a("CompositionLayer#draw");
        this.f3764G.set(0.0f, 0.0f, this.f3747o.m3368j(), this.f3747o.m3367i());
        matrix.mapRect(this.f3764G);
        boolean z = this.f3746n.m3044u() && this.f3762E.size() > 1 && i2 != 255;
        if (z) {
            this.f3765H.setAlpha(i2);
            C1358h.m2839a(canvas, this.f3764G, this.f3765H);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.f3762E.size() - 1; size >= 0; size--) {
            if (!this.f3764G.isEmpty() ? canvas.clipRect(this.f3764G) : true) {
                this.f3762E.get(size).mo3094a(canvas, matrix, i2);
            }
        }
        canvas.restore();
        C1374e.m2883b("CompositionLayer#draw");
    }

    /* renamed from: e */
    public boolean m3355e() {
        if (this.f3767J == null) {
            for (int size = this.f3762E.size() - 1; size >= 0; size--) {
                AbstractC1477a abstractC1477a = this.f3762E.get(size);
                if (abstractC1477a instanceof C1482f) {
                    if (abstractC1477a.m3353c()) {
                        this.f3767J = true;
                        return true;
                    }
                } else if ((abstractC1477a instanceof C1478b) && ((C1478b) abstractC1477a).m3355e()) {
                    this.f3767J = true;
                    return true;
                }
            }
            this.f3767J = false;
        }
        return this.f3767J.booleanValue();
    }

    /* renamed from: f */
    public boolean m3356f() {
        if (this.f3766I == null) {
            if (m3354d()) {
                this.f3766I = true;
                return true;
            }
            for (int size = this.f3762E.size() - 1; size >= 0; size--) {
                if (this.f3762E.get(size).m3354d()) {
                    this.f3766I = true;
                    return true;
                }
            }
            this.f3766I = false;
        }
        return this.f3766I.booleanValue();
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        super.mo3095a(rectF, matrix, z);
        for (int size = this.f3762E.size() - 1; size >= 0; size--) {
            this.f3763F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f3762E.get(size).mo3095a(this.f3763F, this.f3745m, true);
            rectF.union(this.f3763F);
        }
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: a */
    public void mo3344a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        super.mo3344a(f2);
        if (this.f3761D != null) {
            f2 = ((this.f3761D.mo3143f().floatValue() * this.f3747o.m3358a().m2903g()) - this.f3747o.m3358a().m2909m()) / (this.f3746n.m3027f().m2900d() + 0.01f);
        }
        if (this.f3761D == null) {
            f2 -= this.f3747o.m3374p();
        }
        if (this.f3747o.m3378t() != 0.0f && !"__container".equals(this.f3747o.m3365g())) {
            f2 /= this.f3747o.m3378t();
        }
        for (int size = this.f3762E.size() - 1; size >= 0; size--) {
            this.f3762E.get(size).mo3344a(f2);
        }
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: b */
    protected void mo3351b(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        for (int i3 = 0; i3 < this.f3762E.size(); i3++) {
            this.f3762E.get(i3).mo3096a(c1439e, i2, list, c1439e2);
        }
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        super.mo3097a((C1478b) t, (C1370j<C1478b>) c1370j);
        if (t == InterfaceC1384o.f3324C) {
            if (c1370j == null) {
                AbstractC1414a<Float, Float> abstractC1414a = this.f3761D;
                if (abstractC1414a != null) {
                    abstractC1414a.m3137a((C1370j<Float>) null);
                    return;
                }
                return;
            }
            this.f3761D = new C1429p(c1370j);
            this.f3761D.m3138a(this);
            m3345a(this.f3761D);
        }
    }
}
