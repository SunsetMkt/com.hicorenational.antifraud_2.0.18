package com.airbnb.lottie.p102w.p103b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.C1392a;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1429p;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p108k.C1461c;
import com.airbnb.lottie.p106y.p108k.C1462d;
import com.airbnb.lottie.p106y.p108k.EnumC1464f;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* renamed from: com.airbnb.lottie.w.b.h */
/* loaded from: classes.dex */
public class C1400h implements InterfaceC1397e, AbstractC1414a.b, InterfaceC1403k {

    /* renamed from: s */
    private static final int f3422s = 32;

    /* renamed from: a */
    @NonNull
    private final String f3423a;

    /* renamed from: b */
    private final boolean f3424b;

    /* renamed from: c */
    private final AbstractC1477a f3425c;

    /* renamed from: d */
    private final LongSparseArray<LinearGradient> f3426d = new LongSparseArray<>();

    /* renamed from: e */
    private final LongSparseArray<RadialGradient> f3427e = new LongSparseArray<>();

    /* renamed from: f */
    private final Path f3428f = new Path();

    /* renamed from: g */
    private final Paint f3429g = new C1392a(1);

    /* renamed from: h */
    private final RectF f3430h = new RectF();

    /* renamed from: i */
    private final List<InterfaceC1406n> f3431i = new ArrayList();

    /* renamed from: j */
    private final EnumC1464f f3432j;

    /* renamed from: k */
    private final AbstractC1414a<C1461c, C1461c> f3433k;

    /* renamed from: l */
    private final AbstractC1414a<Integer, Integer> f3434l;

    /* renamed from: m */
    private final AbstractC1414a<PointF, PointF> f3435m;

    /* renamed from: n */
    private final AbstractC1414a<PointF, PointF> f3436n;

    /* renamed from: o */
    @Nullable
    private AbstractC1414a<ColorFilter, ColorFilter> f3437o;

    /* renamed from: p */
    @Nullable
    private C1429p f3438p;

    /* renamed from: q */
    private final C1379j f3439q;

    /* renamed from: r */
    private final int f3440r;

    public C1400h(C1379j c1379j, AbstractC1477a abstractC1477a, C1462d c1462d) {
        this.f3425c = abstractC1477a;
        this.f3423a = c1462d.m3249g();
        this.f3424b = c1462d.m3252j();
        this.f3439q = c1379j;
        this.f3432j = c1462d.m3246d();
        this.f3428f.setFillType(c1462d.m3244b());
        this.f3440r = (int) (c1379j.m3027f().m2898c() / 32.0f);
        this.f3433k = c1462d.m3245c().mo3220a();
        this.f3433k.m3138a(this);
        abstractC1477a.m3345a(this.f3433k);
        this.f3434l = c1462d.m3250h().mo3220a();
        this.f3434l.m3138a(this);
        abstractC1477a.m3345a(this.f3434l);
        this.f3435m = c1462d.m3251i().mo3220a();
        this.f3435m.m3138a(this);
        abstractC1477a.m3345a(this.f3435m);
        this.f3436n = c1462d.m3243a().mo3220a();
        this.f3436n.m3138a(this);
        abstractC1477a.m3345a(this.f3436n);
    }

    /* renamed from: b */
    private int m3110b() {
        int round = Math.round(this.f3435m.m3142e() * this.f3440r);
        int round2 = Math.round(this.f3436n.m3142e() * this.f3440r);
        int round3 = Math.round(this.f3433k.m3142e() * this.f3440r);
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    /* renamed from: c */
    private LinearGradient m3111c() {
        long m3110b = m3110b();
        LinearGradient linearGradient = this.f3426d.get(m3110b);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF mo3143f = this.f3435m.mo3143f();
        PointF mo3143f2 = this.f3436n.mo3143f();
        C1461c mo3143f3 = this.f3433k.mo3143f();
        LinearGradient linearGradient2 = new LinearGradient(mo3143f.x, mo3143f.y, mo3143f2.x, mo3143f2.y, m3109a(mo3143f3.m3240a()), mo3143f3.m3241b(), Shader.TileMode.CLAMP);
        this.f3426d.put(m3110b, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: d */
    private RadialGradient m3112d() {
        long m3110b = m3110b();
        RadialGradient radialGradient = this.f3427e.get(m3110b);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF mo3143f = this.f3435m.mo3143f();
        PointF mo3143f2 = this.f3436n.mo3143f();
        C1461c mo3143f3 = this.f3433k.mo3143f();
        int[] m3109a = m3109a(mo3143f3.m3240a());
        float[] m3241b = mo3143f3.m3241b();
        float f2 = mo3143f.x;
        float f3 = mo3143f.y;
        float hypot = (float) Math.hypot(mo3143f2.x - f2, mo3143f2.y - f3);
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, hypot <= 0.0f ? 0.001f : hypot, m3109a, m3241b, Shader.TileMode.CLAMP);
        this.f3427e.put(m3110b, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        this.f3439q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3423a;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            InterfaceC1395c interfaceC1395c = list2.get(i2);
            if (interfaceC1395c instanceof InterfaceC1406n) {
                this.f3431i.add((InterfaceC1406n) interfaceC1395c);
            }
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3094a(Canvas canvas, Matrix matrix, int i2) {
        Shader m3112d;
        if (this.f3424b) {
            return;
        }
        C1374e.m2881a("GradientFillContent#draw");
        this.f3428f.reset();
        for (int i3 = 0; i3 < this.f3431i.size(); i3++) {
            this.f3428f.addPath(this.f3431i.get(i3).getPath(), matrix);
        }
        this.f3428f.computeBounds(this.f3430h, false);
        if (this.f3432j == EnumC1464f.LINEAR) {
            m3112d = m3111c();
        } else {
            m3112d = m3112d();
        }
        m3112d.setLocalMatrix(matrix);
        this.f3429g.setShader(m3112d);
        AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3437o;
        if (abstractC1414a != null) {
            this.f3429g.setColorFilter(abstractC1414a.mo3143f());
        }
        this.f3429g.setAlpha(C1357g.m2824a((int) ((((i2 / 255.0f) * this.f3434l.mo3143f().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f3428f, this.f3429g);
        C1374e.m2883b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        this.f3428f.reset();
        for (int i2 = 0; i2 < this.f3431i.size(); i2++) {
            this.f3428f.addPath(this.f3431i.get(i2).getPath(), matrix);
        }
        this.f3428f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* renamed from: a */
    private int[] m3109a(int[] iArr) {
        C1429p c1429p = this.f3438p;
        if (c1429p != null) {
            Integer[] numArr = (Integer[]) c1429p.mo3143f();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        C1357g.m2826a(c1439e, i2, list, c1439e2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        if (t == InterfaceC1384o.f3333d) {
            this.f3434l.m3137a((C1370j<Integer>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3326E) {
            AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3437o;
            if (abstractC1414a != null) {
                this.f3425c.m3350b(abstractC1414a);
            }
            if (c1370j == null) {
                this.f3437o = null;
                return;
            }
            this.f3437o = new C1429p(c1370j);
            this.f3437o.m3138a(this);
            this.f3425c.m3345a(this.f3437o);
            return;
        }
        if (t == InterfaceC1384o.f3327F) {
            C1429p c1429p = this.f3438p;
            if (c1429p != null) {
                this.f3425c.m3350b(c1429p);
            }
            if (c1370j == null) {
                this.f3438p = null;
                return;
            }
            this.f3426d.clear();
            this.f3427e.clear();
            this.f3438p = new C1429p(c1370j);
            this.f3438p.m3138a(this);
            this.f3425c.m3345a(this.f3438p);
        }
    }
}
