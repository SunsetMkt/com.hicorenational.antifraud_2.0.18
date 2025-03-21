package com.airbnb.lottie.p102w.p103b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.C1392a;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1416c;
import com.airbnb.lottie.p102w.p104c.C1418e;
import com.airbnb.lottie.p102w.p104c.C1429p;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1447d;
import com.airbnb.lottie.p106y.p108k.C1475q;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* renamed from: com.airbnb.lottie.w.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1393a implements AbstractC1414a.b, InterfaceC1403k, InterfaceC1397e {

    /* renamed from: e */
    private final C1379j f3379e;

    /* renamed from: f */
    protected final AbstractC1477a f3380f;

    /* renamed from: h */
    private final float[] f3382h;

    /* renamed from: j */
    private final AbstractC1414a<?, Float> f3384j;

    /* renamed from: k */
    private final AbstractC1414a<?, Integer> f3385k;

    /* renamed from: l */
    private final List<AbstractC1414a<?, Float>> f3386l;

    /* renamed from: m */
    @Nullable
    private final AbstractC1414a<?, Float> f3387m;

    /* renamed from: n */
    @Nullable
    private AbstractC1414a<ColorFilter, ColorFilter> f3388n;

    /* renamed from: a */
    private final PathMeasure f3375a = new PathMeasure();

    /* renamed from: b */
    private final Path f3376b = new Path();

    /* renamed from: c */
    private final Path f3377c = new Path();

    /* renamed from: d */
    private final RectF f3378d = new RectF();

    /* renamed from: g */
    private final List<b> f3381g = new ArrayList();

    /* renamed from: i */
    final Paint f3383i = new C1392a(1);

    /* compiled from: BaseStrokeContent.java */
    /* renamed from: com.airbnb.lottie.w.b.a$b */
    private static final class b {

        /* renamed from: a */
        private final List<InterfaceC1406n> f3389a;

        /* renamed from: b */
        @Nullable
        private final C1412t f3390b;

        private b(@Nullable C1412t c1412t) {
            this.f3389a = new ArrayList();
            this.f3390b = c1412t;
        }
    }

    AbstractC1393a(C1379j c1379j, AbstractC1477a abstractC1477a, Paint.Cap cap, Paint.Join join, float f2, C1447d c1447d, C1445b c1445b, List<C1445b> list, C1445b c1445b2) {
        this.f3379e = c1379j;
        this.f3380f = abstractC1477a;
        this.f3383i.setStyle(Paint.Style.STROKE);
        this.f3383i.setStrokeCap(cap);
        this.f3383i.setStrokeJoin(join);
        this.f3383i.setStrokeMiter(f2);
        this.f3385k = c1447d.mo3220a();
        this.f3384j = c1445b.mo3220a();
        if (c1445b2 == null) {
            this.f3387m = null;
        } else {
            this.f3387m = c1445b2.mo3220a();
        }
        this.f3386l = new ArrayList(list.size());
        this.f3382h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f3386l.add(list.get(i2).mo3220a());
        }
        abstractC1477a.m3345a(this.f3385k);
        abstractC1477a.m3345a(this.f3384j);
        for (int i3 = 0; i3 < this.f3386l.size(); i3++) {
            abstractC1477a.m3345a(this.f3386l.get(i3));
        }
        AbstractC1414a<?, Float> abstractC1414a = this.f3387m;
        if (abstractC1414a != null) {
            abstractC1477a.m3345a(abstractC1414a);
        }
        this.f3385k.m3138a(this);
        this.f3384j.m3138a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f3386l.get(i4).m3138a(this);
        }
        AbstractC1414a<?, Float> abstractC1414a2 = this.f3387m;
        if (abstractC1414a2 != null) {
            abstractC1414a2.m3138a(this);
        }
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        this.f3379e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        C1412t c1412t = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            InterfaceC1395c interfaceC1395c = list.get(size);
            if (interfaceC1395c instanceof C1412t) {
                C1412t c1412t2 = (C1412t) interfaceC1395c;
                if (c1412t2.m3129e() == C1475q.a.INDIVIDUALLY) {
                    c1412t = c1412t2;
                }
            }
        }
        if (c1412t != null) {
            c1412t.m3125a(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            InterfaceC1395c interfaceC1395c2 = list2.get(size2);
            if (interfaceC1395c2 instanceof C1412t) {
                C1412t c1412t3 = (C1412t) interfaceC1395c2;
                if (c1412t3.m3129e() == C1475q.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f3381g.add(bVar);
                    }
                    bVar = new b(c1412t3);
                    c1412t3.m3125a(this);
                }
            }
            if (interfaceC1395c2 instanceof InterfaceC1406n) {
                if (bVar == null) {
                    bVar = new b(c1412t);
                }
                bVar.f3389a.add((InterfaceC1406n) interfaceC1395c2);
            }
        }
        if (bVar != null) {
            this.f3381g.add(bVar);
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3094a(Canvas canvas, Matrix matrix, int i2) {
        C1374e.m2881a("StrokeContent#draw");
        if (C1358h.m2846b(matrix)) {
            C1374e.m2883b("StrokeContent#draw");
            return;
        }
        this.f3383i.setAlpha(C1357g.m2824a((int) ((((i2 / 255.0f) * ((C1418e) this.f3385k).m3157i()) / 100.0f) * 255.0f), 0, 255));
        this.f3383i.setStrokeWidth(((C1416c) this.f3384j).m3155i() * C1358h.m2834a(matrix));
        if (this.f3383i.getStrokeWidth() <= 0.0f) {
            C1374e.m2883b("StrokeContent#draw");
            return;
        }
        m3092a(matrix);
        AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3388n;
        if (abstractC1414a != null) {
            this.f3383i.setColorFilter(abstractC1414a.mo3143f());
        }
        for (int i3 = 0; i3 < this.f3381g.size(); i3++) {
            b bVar = this.f3381g.get(i3);
            if (bVar.f3390b != null) {
                m3091a(canvas, bVar, matrix);
            } else {
                C1374e.m2881a("StrokeContent#buildPath");
                this.f3376b.reset();
                for (int size = bVar.f3389a.size() - 1; size >= 0; size--) {
                    this.f3376b.addPath(((InterfaceC1406n) bVar.f3389a.get(size)).getPath(), matrix);
                }
                C1374e.m2883b("StrokeContent#buildPath");
                C1374e.m2881a("StrokeContent#drawPath");
                canvas.drawPath(this.f3376b, this.f3383i);
                C1374e.m2883b("StrokeContent#drawPath");
            }
        }
        C1374e.m2883b("StrokeContent#draw");
    }

    /* renamed from: a */
    private void m3091a(Canvas canvas, b bVar, Matrix matrix) {
        C1374e.m2881a("StrokeContent#applyTrimPath");
        if (bVar.f3390b == null) {
            C1374e.m2883b("StrokeContent#applyTrimPath");
            return;
        }
        this.f3376b.reset();
        for (int size = bVar.f3389a.size() - 1; size >= 0; size--) {
            this.f3376b.addPath(((InterfaceC1406n) bVar.f3389a.get(size)).getPath(), matrix);
        }
        this.f3375a.setPath(this.f3376b, false);
        float length = this.f3375a.getLength();
        while (this.f3375a.nextContour()) {
            length += this.f3375a.getLength();
        }
        float floatValue = (bVar.f3390b.m3127c().mo3143f().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f3390b.m3128d().mo3143f().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f3390b.m3126b().mo3143f().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.f3389a.size() - 1; size2 >= 0; size2--) {
            this.f3377c.set(((InterfaceC1406n) bVar.f3389a.get(size2)).getPath());
            this.f3377c.transform(matrix);
            this.f3375a.setPath(this.f3377c, false);
            float length2 = this.f3375a.getLength();
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f2 + length2 && f2 < f3) {
                    C1358h.m2841a(this.f3377c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f3377c, this.f3383i);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.f3377c, this.f3383i);
                } else {
                    C1358h.m2841a(this.f3377c, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.f3377c, this.f3383i);
                }
            }
            f2 += length2;
        }
        C1374e.m2883b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        C1374e.m2881a("StrokeContent#getBounds");
        this.f3376b.reset();
        for (int i2 = 0; i2 < this.f3381g.size(); i2++) {
            b bVar = this.f3381g.get(i2);
            for (int i3 = 0; i3 < bVar.f3389a.size(); i3++) {
                this.f3376b.addPath(((InterfaceC1406n) bVar.f3389a.get(i3)).getPath(), matrix);
            }
        }
        this.f3376b.computeBounds(this.f3378d, false);
        float m3155i = ((C1416c) this.f3384j).m3155i();
        RectF rectF2 = this.f3378d;
        float f2 = m3155i / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f3378d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        C1374e.m2883b("StrokeContent#getBounds");
    }

    /* renamed from: a */
    private void m3092a(Matrix matrix) {
        C1374e.m2881a("StrokeContent#applyDashPattern");
        if (this.f3386l.isEmpty()) {
            C1374e.m2883b("StrokeContent#applyDashPattern");
            return;
        }
        float m2834a = C1358h.m2834a(matrix);
        for (int i2 = 0; i2 < this.f3386l.size(); i2++) {
            this.f3382h[i2] = this.f3386l.get(i2).mo3143f().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f3382h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f3382h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f3382h;
            fArr3[i2] = fArr3[i2] * m2834a;
        }
        AbstractC1414a<?, Float> abstractC1414a = this.f3387m;
        this.f3383i.setPathEffect(new DashPathEffect(this.f3382h, abstractC1414a == null ? 0.0f : m2834a * abstractC1414a.mo3143f().floatValue()));
        C1374e.m2883b("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        C1357g.m2826a(c1439e, i2, list, c1439e2, this);
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    @CallSuper
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        if (t == InterfaceC1384o.f3333d) {
            this.f3385k.m3137a((C1370j<Integer>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3346q) {
            this.f3384j.m3137a((C1370j<Float>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3326E) {
            AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3388n;
            if (abstractC1414a != null) {
                this.f3380f.m3350b(abstractC1414a);
            }
            if (c1370j == null) {
                this.f3388n = null;
                return;
            }
            this.f3388n = new C1429p(c1370j);
            this.f3388n.m3138a(this);
            this.f3380f.m3345a(this.f3388n);
        }
    }
}
