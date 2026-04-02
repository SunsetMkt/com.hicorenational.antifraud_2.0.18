package com.airbnb.lottie.y.l;

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
import com.airbnb.lottie.j;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.w.c.o;
import com.airbnb.lottie.y.k.g;
import com.airbnb.lottie.y.k.l;
import com.airbnb.lottie.y.l.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BaseLayer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.airbnb.lottie.w.b.e, a.b, com.airbnb.lottie.y.f {
    private static final int A = 16;
    private static final int B = 1;
    private static final int C = 19;
    private static final int z = 2;

    /* JADX INFO: renamed from: l */
    private final String f2524l;

    /* JADX INFO: renamed from: n */
    final j f2526n;
    final d o;

    @Nullable
    private com.airbnb.lottie.w.c.g p;

    @Nullable
    private com.airbnb.lottie.w.c.c q;

    @Nullable
    private a r;

    @Nullable
    private a s;
    private List<a> t;
    final o v;
    private boolean x;

    @Nullable
    private Paint y;
    private final Path a = new Path();

    /* JADX INFO: renamed from: b */
    private final Matrix f2514b = new Matrix();

    /* JADX INFO: renamed from: c */
    private final Paint f2515c = new com.airbnb.lottie.w.a(1);

    /* JADX INFO: renamed from: d */
    private final Paint f2516d = new com.airbnb.lottie.w.a(1, PorterDuff.Mode.DST_IN);

    /* JADX INFO: renamed from: e */
    private final Paint f2517e = new com.airbnb.lottie.w.a(1, PorterDuff.Mode.DST_OUT);

    /* JADX INFO: renamed from: f */
    private final Paint f2518f = new com.airbnb.lottie.w.a(1);

    /* JADX INFO: renamed from: g */
    private final Paint f2519g = new com.airbnb.lottie.w.a(PorterDuff.Mode.CLEAR);

    /* JADX INFO: renamed from: h */
    private final RectF f2520h = new RectF();

    /* JADX INFO: renamed from: i */
    private final RectF f2521i = new RectF();

    /* JADX INFO: renamed from: j */
    private final RectF f2522j = new RectF();

    /* JADX INFO: renamed from: k */
    private final RectF f2523k = new RectF();

    /* JADX INFO: renamed from: m */
    final Matrix f2525m = new Matrix();
    private final List<com.airbnb.lottie.w.c.a<?, ?>> u = new ArrayList();
    private boolean w = true;

    /* JADX INFO: renamed from: com.airbnb.lottie.y.l.a$a */
    /* JADX INFO: compiled from: BaseLayer.java */
    class C0039a implements a.b {
        C0039a() {
        }

        @Override // com.airbnb.lottie.w.c.a.b
        public void a() {
            a aVar = a.this;
            aVar.b(aVar.q.i() == 1.0f);
        }
    }

    /* JADX INFO: compiled from: BaseLayer.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f2527b = new int[g.a.values().length];

        static {
            try {
                f2527b[g.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2527b[g.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2527b[g.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2527b[g.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = new int[d.a.values().length];
            try {
                a[d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    a(j jVar, d dVar) {
        this.f2526n = jVar;
        this.o = dVar;
        this.f2524l = dVar.g() + "#draw";
        if (dVar.f() == d.b.INVERT) {
            this.f2518f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f2518f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.v = dVar.u().a();
        this.v.a((a.b) this);
        if (dVar.e() != null && !dVar.e().isEmpty()) {
            this.p = new com.airbnb.lottie.w.c.g(dVar.e());
            Iterator<com.airbnb.lottie.w.c.a<l, Path>> it = this.p.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (com.airbnb.lottie.w.c.a<Integer, Integer> aVar : this.p.c()) {
                a(aVar);
                aVar.a(this);
            }
        }
        h();
    }

    private boolean e() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            if (this.p.b().get(i2).a() != g.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void f(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        this.a.set(aVar.f());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f2517e);
    }

    private void g() {
        this.f2526n.invalidateSelf();
    }

    private void h() {
        if (this.o.c().isEmpty()) {
            b(true);
            return;
        }
        this.q = new com.airbnb.lottie.w.c.c(this.o.c());
        this.q.h();
        this.q.a(new C0039a());
        b(this.q.f().floatValue() == 1.0f);
        a(this.q);
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<com.airbnb.lottie.w.b.c> list, List<com.airbnb.lottie.w.b.c> list2) {
    }

    d b() {
        return this.o;
    }

    abstract void b(Canvas canvas, Matrix matrix, int i2);

    void b(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
    }

    boolean d() {
        return this.r != null;
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.o.g();
    }

    @Nullable
    static a a(d dVar, j jVar, com.airbnb.lottie.g gVar) {
        switch (b.a[dVar.d().ordinal()]) {
            case 1:
                return new f(jVar, dVar);
            case 2:
                return new com.airbnb.lottie.y.l.b(jVar, dVar, gVar.c(dVar.k()), gVar);
            case 3:
                return new g(jVar, dVar);
            case 4:
                return new c(jVar, dVar);
            case 5:
                return new e(jVar, dVar);
            case 6:
                return new h(jVar, dVar);
            default:
                com.airbnb.lottie.b0.d.b("Unknown layer type " + dVar.d());
                return null;
        }
    }

    private void c(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.b0.h.a(canvas, this.f2520h, this.f2515c);
        canvas.drawRect(this.f2520h, this.f2515c);
        this.a.set(aVar.f());
        this.a.transform(matrix);
        this.f2515c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f2517e);
        canvas.restore();
    }

    private void d(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.b0.h.a(canvas, this.f2520h, this.f2516d);
        canvas.drawRect(this.f2520h, this.f2515c);
        this.f2517e.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        this.a.set(aVar.f());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f2517e);
        canvas.restore();
    }

    void b(@Nullable a aVar) {
        this.s = aVar;
    }

    public void b(com.airbnb.lottie.w.c.a<?, ?> aVar) {
        this.u.remove(aVar);
    }

    private void b(float f2) {
        this.f2526n.f().l().a(this.o.g(), f2);
    }

    private void e(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.b0.h.a(canvas, this.f2520h, this.f2517e);
        canvas.drawRect(this.f2520h, this.f2515c);
        this.f2517e.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        this.a.set(aVar.f());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f2517e);
        canvas.restore();
    }

    private void f() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (a aVar = this.s; aVar != null; aVar = aVar.s) {
            this.t.add(aVar);
        }
    }

    private void b(RectF rectF, Matrix matrix) {
        if (d() && this.o.f() != d.b.INVERT) {
            this.f2522j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.a(this.f2522j, matrix, true);
            if (rectF.intersect(this.f2522j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    boolean c() {
        com.airbnb.lottie.w.c.g gVar = this.p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    void a(boolean z2) {
        if (z2 && this.y == null) {
            this.y = new com.airbnb.lottie.w.a();
        }
        this.x = z2;
    }

    private void b(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.b0.h.a(canvas, this.f2520h, this.f2516d);
        this.a.set(aVar.f());
        this.a.transform(matrix);
        this.f2515c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f2515c);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        g();
    }

    void a(@Nullable a aVar) {
        this.r = aVar;
    }

    public void a(@Nullable com.airbnb.lottie.w.c.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.u.add(aVar);
    }

    @Override // com.airbnb.lottie.w.b.e
    @CallSuper
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        this.f2520h.set(0.0f, 0.0f, 0.0f, 0.0f);
        f();
        this.f2525m.set(matrix);
        if (z2) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2525m.preConcat(this.t.get(size).v.b());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.f2525m.preConcat(aVar.v.b());
                }
            }
        }
        this.f2525m.preConcat(this.v.b());
    }

    public void b(boolean z2) {
        if (z2 != this.w) {
            this.w = z2;
            g();
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        com.airbnb.lottie.e.a(this.f2524l);
        if (this.w && !this.o.v()) {
            f();
            com.airbnb.lottie.e.a("Layer#parentMatrix");
            this.f2514b.reset();
            this.f2514b.set(matrix);
            for (int size = this.t.size() - 1; size >= 0; size--) {
                this.f2514b.preConcat(this.t.get(size).v.b());
            }
            com.airbnb.lottie.e.b("Layer#parentMatrix");
            int iIntValue = (int) ((((i2 / 255.0f) * (this.v.c() == null ? 100 : this.v.c().f().intValue())) / 100.0f) * 255.0f);
            if (!d() && !c()) {
                this.f2514b.preConcat(this.v.b());
                com.airbnb.lottie.e.a("Layer#drawLayer");
                b(canvas, this.f2514b, iIntValue);
                com.airbnb.lottie.e.b("Layer#drawLayer");
                b(com.airbnb.lottie.e.b(this.f2524l));
                return;
            }
            com.airbnb.lottie.e.a("Layer#computeBounds");
            a(this.f2520h, this.f2514b, false);
            b(this.f2520h, matrix);
            this.f2514b.preConcat(this.v.b());
            a(this.f2520h, this.f2514b);
            if (!this.f2520h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f2520h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.e.b("Layer#computeBounds");
            if (this.f2520h.width() >= 1.0f && this.f2520h.height() >= 1.0f) {
                com.airbnb.lottie.e.a("Layer#saveLayer");
                this.f2515c.setAlpha(255);
                com.airbnb.lottie.b0.h.a(canvas, this.f2520h, this.f2515c);
                com.airbnb.lottie.e.b("Layer#saveLayer");
                a(canvas);
                com.airbnb.lottie.e.a("Layer#drawLayer");
                b(canvas, this.f2514b, iIntValue);
                com.airbnb.lottie.e.b("Layer#drawLayer");
                if (c()) {
                    a(canvas, this.f2514b);
                }
                if (d()) {
                    com.airbnb.lottie.e.a("Layer#drawMatte");
                    com.airbnb.lottie.e.a("Layer#saveLayer");
                    com.airbnb.lottie.b0.h.a(canvas, this.f2520h, this.f2518f, 19);
                    com.airbnb.lottie.e.b("Layer#saveLayer");
                    a(canvas);
                    this.r.a(canvas, matrix, iIntValue);
                    com.airbnb.lottie.e.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.e.b("Layer#restoreLayer");
                    com.airbnb.lottie.e.b("Layer#drawMatte");
                }
                com.airbnb.lottie.e.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.e.b("Layer#restoreLayer");
            }
            if (this.x && (paint = this.y) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.y.setColor(-251901);
                this.y.setStrokeWidth(4.0f);
                canvas.drawRect(this.f2520h, this.y);
                this.y.setStyle(Paint.Style.FILL);
                this.y.setColor(1357638635);
                canvas.drawRect(this.f2520h, this.y);
            }
            b(com.airbnb.lottie.e.b(this.f2524l));
            return;
        }
        com.airbnb.lottie.e.b(this.f2524l);
    }

    private void a(Canvas canvas) {
        com.airbnb.lottie.e.a("Layer#clearLayer");
        RectF rectF = this.f2520h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f2519g);
        com.airbnb.lottie.e.b("Layer#clearLayer");
    }

    private void a(RectF rectF, Matrix matrix) {
        this.f2521i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (c()) {
            int size = this.p.b().size();
            for (int i2 = 0; i2 < size; i2++) {
                com.airbnb.lottie.y.k.g gVar = this.p.b().get(i2);
                this.a.set(this.p.a().get(i2).f());
                this.a.transform(matrix);
                int i3 = b.f2527b[gVar.a().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return;
                }
                if ((i3 == 3 || i3 == 4) && gVar.d()) {
                    return;
                }
                this.a.computeBounds(this.f2523k, false);
                if (i2 == 0) {
                    this.f2521i.set(this.f2523k);
                } else {
                    RectF rectF2 = this.f2521i;
                    rectF2.set(Math.min(rectF2.left, this.f2523k.left), Math.min(this.f2521i.top, this.f2523k.top), Math.max(this.f2521i.right, this.f2523k.right), Math.max(this.f2521i.bottom, this.f2523k.bottom));
                }
            }
            if (rectF.intersect(this.f2521i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.e.a("Layer#saveLayer");
        com.airbnb.lottie.b0.h.a(canvas, this.f2520h, this.f2516d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            a(canvas);
        }
        com.airbnb.lottie.e.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            com.airbnb.lottie.y.k.g gVar = this.p.b().get(i2);
            com.airbnb.lottie.w.c.a<l, Path> aVar = this.p.a().get(i2);
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar2 = this.p.c().get(i2);
            int i3 = b.f2527b[gVar.a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.f2515c.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f2515c.setAlpha(255);
                        canvas.drawRect(this.f2520h, this.f2515c);
                    }
                    if (gVar.d()) {
                        e(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        f(canvas, matrix, gVar, aVar, aVar2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (gVar.d()) {
                            c(canvas, matrix, gVar, aVar, aVar2);
                        } else {
                            a(canvas, matrix, gVar, aVar, aVar2);
                        }
                    }
                } else if (gVar.d()) {
                    d(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    b(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (e()) {
                this.f2515c.setAlpha(255);
                canvas.drawRect(this.f2520h, this.f2515c);
            }
        }
        com.airbnb.lottie.e.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.e.b("Layer#restoreLayer");
    }

    private void a(Canvas canvas, Matrix matrix, com.airbnb.lottie.y.k.g gVar, com.airbnb.lottie.w.c.a<l, Path> aVar, com.airbnb.lottie.w.c.a<Integer, Integer> aVar2) {
        this.a.set(aVar.f());
        this.a.transform(matrix);
        this.f2515c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f2515c);
    }

    void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.v.b(f2);
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.a().size(); i2++) {
                this.p.a().get(i2).a(f2);
            }
        }
        com.airbnb.lottie.w.c.c cVar = this.q;
        if (cVar != null) {
            cVar.a(f2);
        }
        a aVar = this.r;
        if (aVar != null) {
            aVar.a(f2);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).a(f2);
        }
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        a aVar = this.r;
        if (aVar != null) {
            com.airbnb.lottie.y.e eVarA = eVar2.a(aVar.getName());
            if (eVar.a(this.r.getName(), i2)) {
                list.add(eVarA.a(this.r));
            }
            if (eVar.d(getName(), i2)) {
                this.r.b(eVar, eVar.b(this.r.getName(), i2) + i2, list, eVarA);
            }
        }
        if (eVar.c(getName(), i2)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.a(getName(), i2)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.d(getName(), i2)) {
                b(eVar, i2 + eVar.b(getName(), i2), list, eVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        this.v.a(t, jVar);
    }
}
