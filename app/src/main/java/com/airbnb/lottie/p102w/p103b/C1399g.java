package com.airbnb.lottie.p102w.p103b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.C1392a;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1415b;
import com.airbnb.lottie.p102w.p104c.C1429p;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p108k.C1471m;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* renamed from: com.airbnb.lottie.w.b.g */
/* loaded from: classes.dex */
public class C1399g implements InterfaceC1397e, AbstractC1414a.b, InterfaceC1403k {

    /* renamed from: c */
    private final AbstractC1477a f3414c;

    /* renamed from: d */
    private final String f3415d;

    /* renamed from: e */
    private final boolean f3416e;

    /* renamed from: g */
    private final AbstractC1414a<Integer, Integer> f3418g;

    /* renamed from: h */
    private final AbstractC1414a<Integer, Integer> f3419h;

    /* renamed from: i */
    @Nullable
    private AbstractC1414a<ColorFilter, ColorFilter> f3420i;

    /* renamed from: j */
    private final C1379j f3421j;

    /* renamed from: a */
    private final Path f3412a = new Path();

    /* renamed from: b */
    private final Paint f3413b = new C1392a(1);

    /* renamed from: f */
    private final List<InterfaceC1406n> f3417f = new ArrayList();

    public C1399g(C1379j c1379j, AbstractC1477a abstractC1477a, C1471m c1471m) {
        this.f3414c = abstractC1477a;
        this.f3415d = c1471m.m3300c();
        this.f3416e = c1471m.m3302e();
        this.f3421j = c1379j;
        if (c1471m.m3298a() == null || c1471m.m3301d() == null) {
            this.f3418g = null;
            this.f3419h = null;
            return;
        }
        this.f3412a.setFillType(c1471m.m3299b());
        this.f3418g = c1471m.m3298a().mo3220a();
        this.f3418g.m3138a(this);
        abstractC1477a.m3345a(this.f3418g);
        this.f3419h = c1471m.m3301d().mo3220a();
        this.f3419h.m3138a(this);
        abstractC1477a.m3345a(this.f3419h);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        this.f3421j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3415d;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            InterfaceC1395c interfaceC1395c = list2.get(i2);
            if (interfaceC1395c instanceof InterfaceC1406n) {
                this.f3417f.add((InterfaceC1406n) interfaceC1395c);
            }
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3094a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f3416e) {
            return;
        }
        C1374e.m2881a("FillContent#draw");
        this.f3413b.setColor(((C1415b) this.f3418g).m3153i());
        this.f3413b.setAlpha(C1357g.m2824a((int) ((((i2 / 255.0f) * this.f3419h.mo3143f().intValue()) / 100.0f) * 255.0f), 0, 255));
        AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3420i;
        if (abstractC1414a != null) {
            this.f3413b.setColorFilter(abstractC1414a.mo3143f());
        }
        this.f3412a.reset();
        for (int i3 = 0; i3 < this.f3417f.size(); i3++) {
            this.f3412a.addPath(this.f3417f.get(i3).getPath(), matrix);
        }
        canvas.drawPath(this.f3412a, this.f3413b);
        C1374e.m2883b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        this.f3412a.reset();
        for (int i2 = 0; i2 < this.f3417f.size(); i2++) {
            this.f3412a.addPath(this.f3417f.get(i2).getPath(), matrix);
        }
        this.f3412a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        C1357g.m2826a(c1439e, i2, list, c1439e2, this);
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        if (t == InterfaceC1384o.f3330a) {
            this.f3418g.m3137a((C1370j<Integer>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3333d) {
            this.f3419h.m3137a((C1370j<Integer>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3326E) {
            AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3420i;
            if (abstractC1414a != null) {
                this.f3414c.m3350b(abstractC1414a);
            }
            if (c1370j == null) {
                this.f3420i = null;
                return;
            }
            this.f3420i = new C1429p(c1370j);
            this.f3420i.m3138a(this);
            this.f3414c.m3345a(this.f3420i);
        }
    }
}
