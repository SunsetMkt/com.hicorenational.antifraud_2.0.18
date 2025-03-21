package com.airbnb.lottie.p102w.p103b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.C1392a;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1428o;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.InterfaceC1440f;
import com.airbnb.lottie.p106y.p107j.C1455l;
import com.airbnb.lottie.p106y.p108k.C1472n;
import com.airbnb.lottie.p106y.p108k.InterfaceC1460b;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup.java */
/* renamed from: com.airbnb.lottie.w.b.d */
/* loaded from: classes.dex */
public class C1396d implements InterfaceC1397e, InterfaceC1406n, AbstractC1414a.b, InterfaceC1440f {

    /* renamed from: a */
    private Paint f3392a;

    /* renamed from: b */
    private RectF f3393b;

    /* renamed from: c */
    private final Matrix f3394c;

    /* renamed from: d */
    private final Path f3395d;

    /* renamed from: e */
    private final RectF f3396e;

    /* renamed from: f */
    private final String f3397f;

    /* renamed from: g */
    private final boolean f3398g;

    /* renamed from: h */
    private final List<InterfaceC1395c> f3399h;

    /* renamed from: i */
    private final C1379j f3400i;

    /* renamed from: j */
    @Nullable
    private List<InterfaceC1406n> f3401j;

    /* renamed from: k */
    @Nullable
    private C1428o f3402k;

    public C1396d(C1379j c1379j, AbstractC1477a abstractC1477a, C1472n c1472n) {
        this(c1379j, abstractC1477a, c1472n.m3304b(), c1472n.m3305c(), m3104a(c1379j, abstractC1477a, c1472n.m3303a()), m3103a(c1472n.m3303a()));
    }

    /* renamed from: a */
    private static List<InterfaceC1395c> m3104a(C1379j c1379j, AbstractC1477a abstractC1477a, List<InterfaceC1460b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            InterfaceC1395c mo3223a = list.get(i2).mo3223a(c1379j, abstractC1477a);
            if (mo3223a != null) {
                arrayList.add(mo3223a);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private boolean m3105d() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3399h.size(); i3++) {
            if ((this.f3399h.get(i3) instanceof InterfaceC1397e) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    List<InterfaceC1406n> m3106b() {
        if (this.f3401j == null) {
            this.f3401j = new ArrayList();
            for (int i2 = 0; i2 < this.f3399h.size(); i2++) {
                InterfaceC1395c interfaceC1395c = this.f3399h.get(i2);
                if (interfaceC1395c instanceof InterfaceC1406n) {
                    this.f3401j.add((InterfaceC1406n) interfaceC1395c);
                }
            }
        }
        return this.f3401j;
    }

    /* renamed from: c */
    Matrix m3107c() {
        C1428o c1428o = this.f3402k;
        if (c1428o != null) {
            return c1428o.m3171b();
        }
        this.f3394c.reset();
        return this.f3394c;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3397f;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1406n
    public Path getPath() {
        this.f3394c.reset();
        C1428o c1428o = this.f3402k;
        if (c1428o != null) {
            this.f3394c.set(c1428o.m3171b());
        }
        this.f3395d.reset();
        if (this.f3398g) {
            return this.f3395d;
        }
        for (int size = this.f3399h.size() - 1; size >= 0; size--) {
            InterfaceC1395c interfaceC1395c = this.f3399h.get(size);
            if (interfaceC1395c instanceof InterfaceC1406n) {
                this.f3395d.addPath(((InterfaceC1406n) interfaceC1395c).getPath(), this.f3394c);
            }
        }
        return this.f3395d;
    }

    C1396d(C1379j c1379j, AbstractC1477a abstractC1477a, String str, boolean z, List<InterfaceC1395c> list, @Nullable C1455l c1455l) {
        this.f3392a = new C1392a();
        this.f3393b = new RectF();
        this.f3394c = new Matrix();
        this.f3395d = new Path();
        this.f3396e = new RectF();
        this.f3397f = str;
        this.f3400i = c1379j;
        this.f3398g = z;
        this.f3399h = list;
        if (c1455l != null) {
            this.f3402k = c1455l.m3224a();
            this.f3402k.m3169a(abstractC1477a);
            this.f3402k.m3168a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            InterfaceC1395c interfaceC1395c = list.get(size);
            if (interfaceC1395c instanceof InterfaceC1402j) {
                arrayList.add((InterfaceC1402j) interfaceC1395c);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((InterfaceC1402j) arrayList.get(size2)).mo3117a(list.listIterator(list.size()));
        }
    }

    @Nullable
    /* renamed from: a */
    static C1455l m3103a(List<InterfaceC1460b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            InterfaceC1460b interfaceC1460b = list.get(i2);
            if (interfaceC1460b instanceof C1455l) {
                return (C1455l) interfaceC1460b;
            }
        }
        return null;
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        this.f3400i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f3399h.size());
        arrayList.addAll(list);
        for (int size = this.f3399h.size() - 1; size >= 0; size--) {
            InterfaceC1395c interfaceC1395c = this.f3399h.get(size);
            interfaceC1395c.mo3098a(arrayList, this.f3399h.subList(0, size));
            arrayList.add(interfaceC1395c);
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3094a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f3398g) {
            return;
        }
        this.f3394c.set(matrix);
        C1428o c1428o = this.f3402k;
        if (c1428o != null) {
            this.f3394c.preConcat(c1428o.m3171b());
            i2 = (int) (((((this.f3402k.m3173c() == null ? 100 : this.f3402k.m3173c().mo3143f().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z = this.f3400i.m3044u() && m3105d() && i2 != 255;
        if (z) {
            this.f3393b.set(0.0f, 0.0f, 0.0f, 0.0f);
            mo3095a(this.f3393b, this.f3394c, true);
            this.f3392a.setAlpha(i2);
            C1358h.m2839a(canvas, this.f3393b, this.f3392a);
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.f3399h.size() - 1; size >= 0; size--) {
            InterfaceC1395c interfaceC1395c = this.f3399h.get(size);
            if (interfaceC1395c instanceof InterfaceC1397e) {
                ((InterfaceC1397e) interfaceC1395c).mo3094a(canvas, this.f3394c, i2);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        this.f3394c.set(matrix);
        C1428o c1428o = this.f3402k;
        if (c1428o != null) {
            this.f3394c.preConcat(c1428o.m3171b());
        }
        this.f3396e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f3399h.size() - 1; size >= 0; size--) {
            InterfaceC1395c interfaceC1395c = this.f3399h.get(size);
            if (interfaceC1395c instanceof InterfaceC1397e) {
                ((InterfaceC1397e) interfaceC1395c).mo3095a(this.f3396e, this.f3394c, z);
                rectF.union(this.f3396e);
            }
        }
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        if (c1439e.m3210c(getName(), i2) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                c1439e2 = c1439e2.m3205a(getName());
                if (c1439e.m3207a(getName(), i2)) {
                    list.add(c1439e2.m3204a(this));
                }
            }
            if (c1439e.m3211d(getName(), i2)) {
                int m3208b = i2 + c1439e.m3208b(getName(), i2);
                for (int i3 = 0; i3 < this.f3399h.size(); i3++) {
                    InterfaceC1395c interfaceC1395c = this.f3399h.get(i3);
                    if (interfaceC1395c instanceof InterfaceC1440f) {
                        ((InterfaceC1440f) interfaceC1395c).mo3096a(c1439e, m3208b, list, c1439e2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        C1428o c1428o = this.f3402k;
        if (c1428o != null) {
            c1428o.m3170a(t, c1370j);
        }
    }
}
