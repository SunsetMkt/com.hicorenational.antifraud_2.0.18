package com.airbnb.lottie.p102w.p103b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1428o;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p108k.C1469k;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* renamed from: com.airbnb.lottie.w.b.q */
/* loaded from: classes.dex */
public class C1409q implements InterfaceC1397e, InterfaceC1406n, InterfaceC1402j, AbstractC1414a.b, InterfaceC1403k {

    /* renamed from: a */
    private final Matrix f3487a = new Matrix();

    /* renamed from: b */
    private final Path f3488b = new Path();

    /* renamed from: c */
    private final C1379j f3489c;

    /* renamed from: d */
    private final AbstractC1477a f3490d;

    /* renamed from: e */
    private final String f3491e;

    /* renamed from: f */
    private final boolean f3492f;

    /* renamed from: g */
    private final AbstractC1414a<Float, Float> f3493g;

    /* renamed from: h */
    private final AbstractC1414a<Float, Float> f3494h;

    /* renamed from: i */
    private final C1428o f3495i;

    /* renamed from: j */
    private C1396d f3496j;

    public C1409q(C1379j c1379j, AbstractC1477a abstractC1477a, C1469k c1469k) {
        this.f3489c = c1379j;
        this.f3490d = abstractC1477a;
        this.f3491e = c1469k.m3289b();
        this.f3492f = c1469k.m3292e();
        this.f3493g = c1469k.m3288a().mo3220a();
        abstractC1477a.m3345a(this.f3493g);
        this.f3493g.m3138a(this);
        this.f3494h = c1469k.m3290c().mo3220a();
        abstractC1477a.m3345a(this.f3494h);
        this.f3494h.m3138a(this);
        this.f3495i = c1469k.m3291d().m3224a();
        this.f3495i.m3169a(abstractC1477a);
        this.f3495i.m3168a(this);
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1402j
    /* renamed from: a */
    public void mo3117a(ListIterator<InterfaceC1395c> listIterator) {
        if (this.f3496j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f3496j = new C1396d(this.f3489c, this.f3490d, "Repeater", this.f3492f, arrayList, null);
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3491e;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1406n
    public Path getPath() {
        Path path = this.f3496j.getPath();
        this.f3488b.reset();
        float floatValue = this.f3493g.mo3143f().floatValue();
        float floatValue2 = this.f3494h.mo3143f().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f3487a.set(this.f3495i.m3166a(i2 + floatValue2));
            this.f3488b.addPath(path, this.f3487a);
        }
        return this.f3488b;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        this.f3496j.mo3098a(list, list2);
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3094a(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f3493g.mo3143f().floatValue();
        float floatValue2 = this.f3494h.mo3143f().floatValue();
        float floatValue3 = this.f3495i.m3174d().mo3143f().floatValue() / 100.0f;
        float floatValue4 = this.f3495i.m3167a().mo3143f().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f3487a.set(matrix);
            float f2 = i3;
            this.f3487a.preConcat(this.f3495i.m3166a(f2 + floatValue2));
            this.f3496j.mo3094a(canvas, this.f3487a, (int) (i2 * C1357g.m2831c(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        this.f3496j.mo3095a(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        this.f3489c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        C1357g.m2826a(c1439e, i2, list, c1439e2, this);
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        if (this.f3495i.m3170a(t, c1370j)) {
            return;
        }
        if (t == InterfaceC1384o.f3348s) {
            this.f3493g.m3137a((C1370j<Float>) c1370j);
        } else if (t == InterfaceC1384o.f3349t) {
            this.f3494h.m3137a((C1370j<Float>) c1370j);
        }
    }
}
