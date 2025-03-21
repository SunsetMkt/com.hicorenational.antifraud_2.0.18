package com.airbnb.lottie.p102w.p103b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1429p;
import com.airbnb.lottie.p106y.p108k.C1461c;
import com.airbnb.lottie.p106y.p108k.C1463e;
import com.airbnb.lottie.p106y.p108k.EnumC1464f;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: GradientStrokeContent.java */
/* renamed from: com.airbnb.lottie.w.b.i */
/* loaded from: classes.dex */
public class C1401i extends AbstractC1393a {

    /* renamed from: z */
    private static final int f3441z = 32;

    /* renamed from: o */
    private final String f3442o;

    /* renamed from: p */
    private final boolean f3443p;

    /* renamed from: q */
    private final LongSparseArray<LinearGradient> f3444q;

    /* renamed from: r */
    private final LongSparseArray<RadialGradient> f3445r;

    /* renamed from: s */
    private final RectF f3446s;

    /* renamed from: t */
    private final EnumC1464f f3447t;

    /* renamed from: u */
    private final int f3448u;

    /* renamed from: v */
    private final AbstractC1414a<C1461c, C1461c> f3449v;

    /* renamed from: w */
    private final AbstractC1414a<PointF, PointF> f3450w;

    /* renamed from: x */
    private final AbstractC1414a<PointF, PointF> f3451x;

    /* renamed from: y */
    @Nullable
    private C1429p f3452y;

    public C1401i(C1379j c1379j, AbstractC1477a abstractC1477a, C1463e c1463e) {
        super(c1379j, abstractC1477a, c1463e.m3253a().toPaintCap(), c1463e.m3258f().toPaintJoin(), c1463e.m3260h(), c1463e.m3262j(), c1463e.m3264l(), c1463e.m3259g(), c1463e.m3254b());
        this.f3444q = new LongSparseArray<>();
        this.f3445r = new LongSparseArray<>();
        this.f3446s = new RectF();
        this.f3442o = c1463e.m3261i();
        this.f3447t = c1463e.m3257e();
        this.f3443p = c1463e.m3265m();
        this.f3448u = (int) (c1379j.m3027f().m2898c() / 32.0f);
        this.f3449v = c1463e.m3256d().mo3220a();
        this.f3449v.m3138a(this);
        abstractC1477a.m3345a(this.f3449v);
        this.f3450w = c1463e.m3263k().mo3220a();
        this.f3450w.m3138a(this);
        abstractC1477a.m3345a(this.f3450w);
        this.f3451x = c1463e.m3255c().mo3220a();
        this.f3451x.m3138a(this);
        abstractC1477a.m3345a(this.f3451x);
    }

    /* renamed from: b */
    private int m3114b() {
        int round = Math.round(this.f3450w.m3142e() * this.f3448u);
        int round2 = Math.round(this.f3451x.m3142e() * this.f3448u);
        int round3 = Math.round(this.f3449v.m3142e() * this.f3448u);
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    /* renamed from: c */
    private LinearGradient m3115c() {
        long m3114b = m3114b();
        LinearGradient linearGradient = this.f3444q.get(m3114b);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF mo3143f = this.f3450w.mo3143f();
        PointF mo3143f2 = this.f3451x.mo3143f();
        C1461c mo3143f3 = this.f3449v.mo3143f();
        LinearGradient linearGradient2 = new LinearGradient(mo3143f.x, mo3143f.y, mo3143f2.x, mo3143f2.y, m3113a(mo3143f3.m3240a()), mo3143f3.m3241b(), Shader.TileMode.CLAMP);
        this.f3444q.put(m3114b, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: d */
    private RadialGradient m3116d() {
        long m3114b = m3114b();
        RadialGradient radialGradient = this.f3445r.get(m3114b);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF mo3143f = this.f3450w.mo3143f();
        PointF mo3143f2 = this.f3451x.mo3143f();
        C1461c mo3143f3 = this.f3449v.mo3143f();
        int[] m3113a = m3113a(mo3143f3.m3240a());
        float[] m3241b = mo3143f3.m3241b();
        RadialGradient radialGradient2 = new RadialGradient(mo3143f.x, mo3143f.y, (float) Math.hypot(mo3143f2.x - r7, mo3143f2.y - r8), m3113a, m3241b, Shader.TileMode.CLAMP);
        this.f3445r.put(m3114b, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.p102w.p103b.AbstractC1393a, com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3094a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f3443p) {
            return;
        }
        mo3095a(this.f3446s, matrix, false);
        Shader m3115c = this.f3447t == EnumC1464f.LINEAR ? m3115c() : m3116d();
        m3115c.setLocalMatrix(matrix);
        this.f3383i.setShader(m3115c);
        super.mo3094a(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3442o;
    }

    /* renamed from: a */
    private int[] m3113a(int[] iArr) {
        C1429p c1429p = this.f3452y;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.p102w.p103b.AbstractC1393a, com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        super.mo3097a((C1401i) t, (C1370j<C1401i>) c1370j);
        if (t == InterfaceC1384o.f3327F) {
            C1429p c1429p = this.f3452y;
            if (c1429p != null) {
                this.f3380f.m3350b(c1429p);
            }
            if (c1370j == null) {
                this.f3452y = null;
                return;
            }
            this.f3452y = new C1429p(c1370j);
            this.f3452y.m3138a(this);
            this.f3380f.m3345a(this.f3452y);
        }
    }
}
