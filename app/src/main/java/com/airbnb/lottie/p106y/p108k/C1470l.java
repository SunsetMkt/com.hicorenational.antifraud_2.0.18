package com.airbnb.lottie.p106y.p108k;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p106y.C1435a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* renamed from: com.airbnb.lottie.y.k.l */
/* loaded from: classes.dex */
public class C1470l {

    /* renamed from: a */
    private final List<C1435a> f3692a;

    /* renamed from: b */
    private PointF f3693b;

    /* renamed from: c */
    private boolean f3694c;

    public C1470l(PointF pointF, boolean z, List<C1435a> list) {
        this.f3693b = pointF;
        this.f3694c = z;
        this.f3692a = new ArrayList(list);
    }

    /* renamed from: a */
    private void m3293a(float f2, float f3) {
        if (this.f3693b == null) {
            this.f3693b = new PointF();
        }
        this.f3693b.set(f2, f3);
    }

    /* renamed from: b */
    public PointF m3296b() {
        return this.f3693b;
    }

    /* renamed from: c */
    public boolean m3297c() {
        return this.f3694c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f3692a.size() + "closed=" + this.f3694c + '}';
    }

    /* renamed from: a */
    public List<C1435a> m3294a() {
        return this.f3692a;
    }

    public C1470l() {
        this.f3692a = new ArrayList();
    }

    /* renamed from: a */
    public void m3295a(C1470l c1470l, C1470l c1470l2, @FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        if (this.f3693b == null) {
            this.f3693b = new PointF();
        }
        this.f3694c = c1470l.m3297c() || c1470l2.m3297c();
        if (c1470l.m3294a().size() != c1470l2.m3294a().size()) {
            C1354d.m2791b("Curves must have the same number of control points. Shape 1: " + c1470l.m3294a().size() + "\tShape 2: " + c1470l2.m3294a().size());
        }
        int min = Math.min(c1470l.m3294a().size(), c1470l2.m3294a().size());
        if (this.f3692a.size() < min) {
            for (int size = this.f3692a.size(); size < min; size++) {
                this.f3692a.add(new C1435a());
            }
        } else if (this.f3692a.size() > min) {
            for (int size2 = this.f3692a.size() - 1; size2 >= min; size2--) {
                List<C1435a> list = this.f3692a;
                list.remove(list.size() - 1);
            }
        }
        PointF m3296b = c1470l.m3296b();
        PointF m3296b2 = c1470l2.m3296b();
        m3293a(C1357g.m2831c(m3296b.x, m3296b2.x, f2), C1357g.m2831c(m3296b.y, m3296b2.y, f2));
        for (int size3 = this.f3692a.size() - 1; size3 >= 0; size3--) {
            C1435a c1435a = c1470l.m3294a().get(size3);
            C1435a c1435a2 = c1470l2.m3294a().get(size3);
            PointF m3185a = c1435a.m3185a();
            PointF m3187b = c1435a.m3187b();
            PointF m3189c = c1435a.m3189c();
            PointF m3185a2 = c1435a2.m3185a();
            PointF m3187b2 = c1435a2.m3187b();
            PointF m3189c2 = c1435a2.m3189c();
            this.f3692a.get(size3).m3186a(C1357g.m2831c(m3185a.x, m3185a2.x, f2), C1357g.m2831c(m3185a.y, m3185a2.y, f2));
            this.f3692a.get(size3).m3188b(C1357g.m2831c(m3187b.x, m3187b2.x, f2), C1357g.m2831c(m3187b.y, m3187b2.y, f2));
            this.f3692a.get(size3).m3190c(C1357g.m2831c(m3189c.x, m3189c2.x, f2), C1357g.m2831c(m3189c.y, m3189c2.y, f2));
        }
    }
}
