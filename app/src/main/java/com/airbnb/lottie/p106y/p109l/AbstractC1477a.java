package com.airbnb.lottie.p106y.p109l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.C1392a;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p102w.p103b.InterfaceC1397e;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1416c;
import com.airbnb.lottie.p102w.p104c.C1420g;
import com.airbnb.lottie.p102w.p104c.C1428o;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.InterfaceC1440f;
import com.airbnb.lottie.p106y.p108k.C1465g;
import com.airbnb.lottie.p106y.p108k.C1470l;
import com.airbnb.lottie.p106y.p109l.C1480d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseLayer.java */
/* renamed from: com.airbnb.lottie.y.l.a */
/* loaded from: classes.dex */
public abstract class AbstractC1477a implements InterfaceC1397e, AbstractC1414a.b, InterfaceC1440f {

    /* renamed from: A */
    private static final int f3729A = 16;

    /* renamed from: B */
    private static final int f3730B = 1;

    /* renamed from: C */
    private static final int f3731C = 19;

    /* renamed from: z */
    private static final int f3732z = 2;

    /* renamed from: l */
    private final String f3744l;

    /* renamed from: n */
    final C1379j f3746n;

    /* renamed from: o */
    final C1480d f3747o;

    /* renamed from: p */
    @Nullable
    private C1420g f3748p;

    /* renamed from: q */
    @Nullable
    private C1416c f3749q;

    /* renamed from: r */
    @Nullable
    private AbstractC1477a f3750r;

    /* renamed from: s */
    @Nullable
    private AbstractC1477a f3751s;

    /* renamed from: t */
    private List<AbstractC1477a> f3752t;

    /* renamed from: v */
    final C1428o f3754v;

    /* renamed from: x */
    private boolean f3756x;

    /* renamed from: y */
    @Nullable
    private Paint f3757y;

    /* renamed from: a */
    private final Path f3733a = new Path();

    /* renamed from: b */
    private final Matrix f3734b = new Matrix();

    /* renamed from: c */
    private final Paint f3735c = new C1392a(1);

    /* renamed from: d */
    private final Paint f3736d = new C1392a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e */
    private final Paint f3737e = new C1392a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: f */
    private final Paint f3738f = new C1392a(1);

    /* renamed from: g */
    private final Paint f3739g = new C1392a(PorterDuff.Mode.CLEAR);

    /* renamed from: h */
    private final RectF f3740h = new RectF();

    /* renamed from: i */
    private final RectF f3741i = new RectF();

    /* renamed from: j */
    private final RectF f3742j = new RectF();

    /* renamed from: k */
    private final RectF f3743k = new RectF();

    /* renamed from: m */
    final Matrix f3745m = new Matrix();

    /* renamed from: u */
    private final List<AbstractC1414a<?, ?>> f3753u = new ArrayList();

    /* renamed from: w */
    private boolean f3755w = true;

    /* compiled from: BaseLayer.java */
    /* renamed from: com.airbnb.lottie.y.l.a$a */
    class a implements AbstractC1414a.b {
        a() {
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
        /* renamed from: a */
        public void mo3093a() {
            AbstractC1477a abstractC1477a = AbstractC1477a.this;
            abstractC1477a.m3334b(abstractC1477a.f3749q.m3155i() == 1.0f);
        }
    }

    /* compiled from: BaseLayer.java */
    /* renamed from: com.airbnb.lottie.y.l.a$b */
    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f3759a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3760b = new int[C1465g.a.values().length];

        static {
            try {
                f3760b[C1465g.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3760b[C1465g.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3760b[C1465g.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3760b[C1465g.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3759a = new int[C1480d.a.values().length];
            try {
                f3759a[C1480d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3759a[C1480d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3759a[C1480d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3759a[C1480d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3759a[C1480d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3759a[C1480d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3759a[C1480d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    AbstractC1477a(C1379j c1379j, C1480d c1480d) {
        this.f3746n = c1379j;
        this.f3747o = c1480d;
        this.f3744l = c1480d.m3365g() + "#draw";
        if (c1480d.m3364f() == C1480d.b.INVERT) {
            this.f3738f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f3738f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.f3754v = c1480d.m3379u().m3224a();
        this.f3754v.m3168a((AbstractC1414a.b) this);
        if (c1480d.m3363e() != null && !c1480d.m3363e().isEmpty()) {
            this.f3748p = new C1420g(c1480d.m3363e());
            Iterator<AbstractC1414a<C1470l, Path>> it = this.f3748p.m3158a().iterator();
            while (it.hasNext()) {
                it.next().m3138a(this);
            }
            for (AbstractC1414a<Integer, Integer> abstractC1414a : this.f3748p.m3160c()) {
                m3345a(abstractC1414a);
                abstractC1414a.m3138a(this);
            }
        }
        m3343h();
    }

    /* renamed from: e */
    private boolean m3339e() {
        if (this.f3748p.m3158a().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f3748p.m3159b().size(); i2++) {
            if (this.f3748p.m3159b().get(i2).m3266a() != C1465g.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private void m3341f(Canvas canvas, Matrix matrix, C1465g c1465g, AbstractC1414a<C1470l, Path> abstractC1414a, AbstractC1414a<Integer, Integer> abstractC1414a2) {
        this.f3733a.set(abstractC1414a.mo3143f());
        this.f3733a.transform(matrix);
        canvas.drawPath(this.f3733a, this.f3737e);
    }

    /* renamed from: g */
    private void m3342g() {
        this.f3746n.invalidateSelf();
    }

    /* renamed from: h */
    private void m3343h() {
        if (this.f3747o.m3361c().isEmpty()) {
            m3334b(true);
            return;
        }
        this.f3749q = new C1416c(this.f3747o.m3361c());
        this.f3749q.m3145h();
        this.f3749q.m3138a(new a());
        m3334b(this.f3749q.mo3143f().floatValue() == 1.0f);
        m3345a(this.f3749q);
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
    }

    /* renamed from: b */
    C1480d m3348b() {
        return this.f3747o;
    }

    /* renamed from: b */
    abstract void mo3349b(Canvas canvas, Matrix matrix, int i2);

    /* renamed from: b */
    void mo3351b(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
    }

    /* renamed from: d */
    boolean m3354d() {
        return this.f3750r != null;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3747o.m3365g();
    }

    @Nullable
    /* renamed from: a */
    static AbstractC1477a m3325a(C1480d c1480d, C1379j c1379j, C1376g c1376g) {
        switch (b.f3759a[c1480d.m3362d().ordinal()]) {
            case 1:
                return new C1482f(c1379j, c1480d);
            case 2:
                return new C1478b(c1379j, c1480d, c1376g.m2899c(c1480d.m3369k()), c1376g);
            case 3:
                return new C1483g(c1379j, c1480d);
            case 4:
                return new C1479c(c1379j, c1480d);
            case 5:
                return new C1481e(c1379j, c1480d);
            case 6:
                return new C1484h(c1379j, c1480d);
            default:
                C1354d.m2791b("Unknown layer type " + c1480d.m3362d());
                return null;
        }
    }

    /* renamed from: c */
    private void m3336c(Canvas canvas, Matrix matrix, C1465g c1465g, AbstractC1414a<C1470l, Path> abstractC1414a, AbstractC1414a<Integer, Integer> abstractC1414a2) {
        C1358h.m2839a(canvas, this.f3740h, this.f3735c);
        canvas.drawRect(this.f3740h, this.f3735c);
        this.f3733a.set(abstractC1414a.mo3143f());
        this.f3733a.transform(matrix);
        this.f3735c.setAlpha((int) (abstractC1414a2.mo3143f().intValue() * 2.55f));
        canvas.drawPath(this.f3733a, this.f3737e);
        canvas.restore();
    }

    /* renamed from: d */
    private void m3337d(Canvas canvas, Matrix matrix, C1465g c1465g, AbstractC1414a<C1470l, Path> abstractC1414a, AbstractC1414a<Integer, Integer> abstractC1414a2) {
        C1358h.m2839a(canvas, this.f3740h, this.f3736d);
        canvas.drawRect(this.f3740h, this.f3735c);
        this.f3737e.setAlpha((int) (abstractC1414a2.mo3143f().intValue() * 2.55f));
        this.f3733a.set(abstractC1414a.mo3143f());
        this.f3733a.transform(matrix);
        canvas.drawPath(this.f3733a, this.f3737e);
        canvas.restore();
    }

    /* renamed from: b */
    void m3352b(@Nullable AbstractC1477a abstractC1477a) {
        this.f3751s = abstractC1477a;
    }

    /* renamed from: b */
    public void m3350b(AbstractC1414a<?, ?> abstractC1414a) {
        this.f3753u.remove(abstractC1414a);
    }

    /* renamed from: b */
    private void m3331b(float f2) {
        this.f3746n.m3027f().m2908l().m3077a(this.f3747o.m3365g(), f2);
    }

    /* renamed from: e */
    private void m3338e(Canvas canvas, Matrix matrix, C1465g c1465g, AbstractC1414a<C1470l, Path> abstractC1414a, AbstractC1414a<Integer, Integer> abstractC1414a2) {
        C1358h.m2839a(canvas, this.f3740h, this.f3737e);
        canvas.drawRect(this.f3740h, this.f3735c);
        this.f3737e.setAlpha((int) (abstractC1414a2.mo3143f().intValue() * 2.55f));
        this.f3733a.set(abstractC1414a.mo3143f());
        this.f3733a.transform(matrix);
        canvas.drawPath(this.f3733a, this.f3737e);
        canvas.restore();
    }

    /* renamed from: f */
    private void m3340f() {
        if (this.f3752t != null) {
            return;
        }
        if (this.f3751s == null) {
            this.f3752t = Collections.emptyList();
            return;
        }
        this.f3752t = new ArrayList();
        for (AbstractC1477a abstractC1477a = this.f3751s; abstractC1477a != null; abstractC1477a = abstractC1477a.f3751s) {
            this.f3752t.add(abstractC1477a);
        }
    }

    /* renamed from: b */
    private void m3333b(RectF rectF, Matrix matrix) {
        if (m3354d() && this.f3747o.m3364f() != C1480d.b.INVERT) {
            this.f3742j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f3750r.mo3095a(this.f3742j, matrix, true);
            if (rectF.intersect(this.f3742j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* renamed from: c */
    boolean m3353c() {
        C1420g c1420g = this.f3748p;
        return (c1420g == null || c1420g.m3158a().isEmpty()) ? false : true;
    }

    /* renamed from: a */
    void mo3347a(boolean z) {
        if (z && this.f3757y == null) {
            this.f3757y = new C1392a();
        }
        this.f3756x = z;
    }

    /* renamed from: b */
    private void m3332b(Canvas canvas, Matrix matrix, C1465g c1465g, AbstractC1414a<C1470l, Path> abstractC1414a, AbstractC1414a<Integer, Integer> abstractC1414a2) {
        C1358h.m2839a(canvas, this.f3740h, this.f3736d);
        this.f3733a.set(abstractC1414a.mo3143f());
        this.f3733a.transform(matrix);
        this.f3735c.setAlpha((int) (abstractC1414a2.mo3143f().intValue() * 2.55f));
        canvas.drawPath(this.f3733a, this.f3735c);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        m3342g();
    }

    /* renamed from: a */
    void m3346a(@Nullable AbstractC1477a abstractC1477a) {
        this.f3750r = abstractC1477a;
    }

    /* renamed from: a */
    public void m3345a(@Nullable AbstractC1414a<?, ?> abstractC1414a) {
        if (abstractC1414a == null) {
            return;
        }
        this.f3753u.add(abstractC1414a);
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    @CallSuper
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        this.f3740h.set(0.0f, 0.0f, 0.0f, 0.0f);
        m3340f();
        this.f3745m.set(matrix);
        if (z) {
            List<AbstractC1477a> list = this.f3752t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3745m.preConcat(this.f3752t.get(size).f3754v.m3171b());
                }
            } else {
                AbstractC1477a abstractC1477a = this.f3751s;
                if (abstractC1477a != null) {
                    this.f3745m.preConcat(abstractC1477a.f3754v.m3171b());
                }
            }
        }
        this.f3745m.preConcat(this.f3754v.m3171b());
    }

    /* renamed from: b */
    public void m3334b(boolean z) {
        if (z != this.f3755w) {
            this.f3755w = z;
            m3342g();
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3094a(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        C1374e.m2881a(this.f3744l);
        if (this.f3755w && !this.f3747o.m3380v()) {
            m3340f();
            C1374e.m2881a("Layer#parentMatrix");
            this.f3734b.reset();
            this.f3734b.set(matrix);
            for (int size = this.f3752t.size() - 1; size >= 0; size--) {
                this.f3734b.preConcat(this.f3752t.get(size).f3754v.m3171b());
            }
            C1374e.m2883b("Layer#parentMatrix");
            int intValue = (int) ((((i2 / 255.0f) * (this.f3754v.m3173c() == null ? 100 : this.f3754v.m3173c().mo3143f().intValue())) / 100.0f) * 255.0f);
            if (!m3354d() && !m3353c()) {
                this.f3734b.preConcat(this.f3754v.m3171b());
                C1374e.m2881a("Layer#drawLayer");
                mo3349b(canvas, this.f3734b, intValue);
                C1374e.m2883b("Layer#drawLayer");
                m3331b(C1374e.m2883b(this.f3744l));
                return;
            }
            C1374e.m2881a("Layer#computeBounds");
            mo3095a(this.f3740h, this.f3734b, false);
            m3333b(this.f3740h, matrix);
            this.f3734b.preConcat(this.f3754v.m3171b());
            m3329a(this.f3740h, this.f3734b);
            if (!this.f3740h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f3740h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            C1374e.m2883b("Layer#computeBounds");
            if (this.f3740h.width() >= 1.0f && this.f3740h.height() >= 1.0f) {
                C1374e.m2881a("Layer#saveLayer");
                this.f3735c.setAlpha(255);
                C1358h.m2839a(canvas, this.f3740h, this.f3735c);
                C1374e.m2883b("Layer#saveLayer");
                m3326a(canvas);
                C1374e.m2881a("Layer#drawLayer");
                mo3349b(canvas, this.f3734b, intValue);
                C1374e.m2883b("Layer#drawLayer");
                if (m3353c()) {
                    m3327a(canvas, this.f3734b);
                }
                if (m3354d()) {
                    C1374e.m2881a("Layer#drawMatte");
                    C1374e.m2881a("Layer#saveLayer");
                    C1358h.m2840a(canvas, this.f3740h, this.f3738f, 19);
                    C1374e.m2883b("Layer#saveLayer");
                    m3326a(canvas);
                    this.f3750r.mo3094a(canvas, matrix, intValue);
                    C1374e.m2881a("Layer#restoreLayer");
                    canvas.restore();
                    C1374e.m2883b("Layer#restoreLayer");
                    C1374e.m2883b("Layer#drawMatte");
                }
                C1374e.m2881a("Layer#restoreLayer");
                canvas.restore();
                C1374e.m2883b("Layer#restoreLayer");
            }
            if (this.f3756x && (paint = this.f3757y) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.f3757y.setColor(-251901);
                this.f3757y.setStrokeWidth(4.0f);
                canvas.drawRect(this.f3740h, this.f3757y);
                this.f3757y.setStyle(Paint.Style.FILL);
                this.f3757y.setColor(1357638635);
                canvas.drawRect(this.f3740h, this.f3757y);
            }
            m3331b(C1374e.m2883b(this.f3744l));
            return;
        }
        C1374e.m2883b(this.f3744l);
    }

    /* renamed from: a */
    private void m3326a(Canvas canvas) {
        C1374e.m2881a("Layer#clearLayer");
        RectF rectF = this.f3740h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f3739g);
        C1374e.m2883b("Layer#clearLayer");
    }

    /* renamed from: a */
    private void m3329a(RectF rectF, Matrix matrix) {
        this.f3741i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (m3353c()) {
            int size = this.f3748p.m3159b().size();
            for (int i2 = 0; i2 < size; i2++) {
                C1465g c1465g = this.f3748p.m3159b().get(i2);
                this.f3733a.set(this.f3748p.m3158a().get(i2).mo3143f());
                this.f3733a.transform(matrix);
                int i3 = b.f3760b[c1465g.m3266a().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return;
                }
                if ((i3 == 3 || i3 == 4) && c1465g.m3269d()) {
                    return;
                }
                this.f3733a.computeBounds(this.f3743k, false);
                if (i2 == 0) {
                    this.f3741i.set(this.f3743k);
                } else {
                    RectF rectF2 = this.f3741i;
                    rectF2.set(Math.min(rectF2.left, this.f3743k.left), Math.min(this.f3741i.top, this.f3743k.top), Math.max(this.f3741i.right, this.f3743k.right), Math.max(this.f3741i.bottom, this.f3743k.bottom));
                }
            }
            if (rectF.intersect(this.f3741i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* renamed from: a */
    private void m3327a(Canvas canvas, Matrix matrix) {
        C1374e.m2881a("Layer#saveLayer");
        C1358h.m2840a(canvas, this.f3740h, this.f3736d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            m3326a(canvas);
        }
        C1374e.m2883b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.f3748p.m3159b().size(); i2++) {
            C1465g c1465g = this.f3748p.m3159b().get(i2);
            AbstractC1414a<C1470l, Path> abstractC1414a = this.f3748p.m3158a().get(i2);
            AbstractC1414a<Integer, Integer> abstractC1414a2 = this.f3748p.m3160c().get(i2);
            int i3 = b.f3760b[c1465g.m3266a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.f3735c.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f3735c.setAlpha(255);
                        canvas.drawRect(this.f3740h, this.f3735c);
                    }
                    if (c1465g.m3269d()) {
                        m3338e(canvas, matrix, c1465g, abstractC1414a, abstractC1414a2);
                    } else {
                        m3341f(canvas, matrix, c1465g, abstractC1414a, abstractC1414a2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (c1465g.m3269d()) {
                            m3336c(canvas, matrix, c1465g, abstractC1414a, abstractC1414a2);
                        } else {
                            m3328a(canvas, matrix, c1465g, abstractC1414a, abstractC1414a2);
                        }
                    }
                } else if (c1465g.m3269d()) {
                    m3337d(canvas, matrix, c1465g, abstractC1414a, abstractC1414a2);
                } else {
                    m3332b(canvas, matrix, c1465g, abstractC1414a, abstractC1414a2);
                }
            } else if (m3339e()) {
                this.f3735c.setAlpha(255);
                canvas.drawRect(this.f3740h, this.f3735c);
            }
        }
        C1374e.m2881a("Layer#restoreLayer");
        canvas.restore();
        C1374e.m2883b("Layer#restoreLayer");
    }

    /* renamed from: a */
    private void m3328a(Canvas canvas, Matrix matrix, C1465g c1465g, AbstractC1414a<C1470l, Path> abstractC1414a, AbstractC1414a<Integer, Integer> abstractC1414a2) {
        this.f3733a.set(abstractC1414a.mo3143f());
        this.f3733a.transform(matrix);
        this.f3735c.setAlpha((int) (abstractC1414a2.mo3143f().intValue() * 2.55f));
        canvas.drawPath(this.f3733a, this.f3735c);
    }

    /* renamed from: a */
    void mo3344a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        this.f3754v.m3172b(f2);
        if (this.f3748p != null) {
            for (int i2 = 0; i2 < this.f3748p.m3158a().size(); i2++) {
                this.f3748p.m3158a().get(i2).mo3136a(f2);
            }
        }
        C1416c c1416c = this.f3749q;
        if (c1416c != null) {
            c1416c.mo3136a(f2);
        }
        AbstractC1477a abstractC1477a = this.f3750r;
        if (abstractC1477a != null) {
            abstractC1477a.mo3344a(f2);
        }
        for (int i3 = 0; i3 < this.f3753u.size(); i3++) {
            this.f3753u.get(i3).mo3136a(f2);
        }
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        AbstractC1477a abstractC1477a = this.f3750r;
        if (abstractC1477a != null) {
            C1439e m3205a = c1439e2.m3205a(abstractC1477a.getName());
            if (c1439e.m3207a(this.f3750r.getName(), i2)) {
                list.add(m3205a.m3204a(this.f3750r));
            }
            if (c1439e.m3211d(getName(), i2)) {
                this.f3750r.mo3351b(c1439e, c1439e.m3208b(this.f3750r.getName(), i2) + i2, list, m3205a);
            }
        }
        if (c1439e.m3210c(getName(), i2)) {
            if (!"__container".equals(getName())) {
                c1439e2 = c1439e2.m3205a(getName());
                if (c1439e.m3207a(getName(), i2)) {
                    list.add(c1439e2.m3204a(this));
                }
            }
            if (c1439e.m3211d(getName(), i2)) {
                mo3351b(c1439e, i2 + c1439e.m3208b(getName(), i2), list, c1439e2);
            }
        }
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    @CallSuper
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        this.f3754v.m3170a(t, c1370j);
    }
}
