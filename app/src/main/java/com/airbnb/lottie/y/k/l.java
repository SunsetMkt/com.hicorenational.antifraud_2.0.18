package com.airbnb.lottie.y.k;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final List<com.airbnb.lottie.y.a> f3916a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f3917b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3918c;

    public l(PointF pointF, boolean z, List<com.airbnb.lottie.y.a> list) {
        this.f3917b = pointF;
        this.f3918c = z;
        this.f3916a = new ArrayList(list);
    }

    private void a(float f2, float f3) {
        if (this.f3917b == null) {
            this.f3917b = new PointF();
        }
        this.f3917b.set(f2, f3);
    }

    public PointF b() {
        return this.f3917b;
    }

    public boolean c() {
        return this.f3918c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f3916a.size() + "closed=" + this.f3918c + '}';
    }

    public List<com.airbnb.lottie.y.a> a() {
        return this.f3916a;
    }

    public l() {
        this.f3916a = new ArrayList();
    }

    public void a(l lVar, l lVar2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f3917b == null) {
            this.f3917b = new PointF();
        }
        this.f3918c = lVar.c() || lVar2.c();
        if (lVar.a().size() != lVar2.a().size()) {
            com.airbnb.lottie.b0.d.b("Curves must have the same number of control points. Shape 1: " + lVar.a().size() + "\tShape 2: " + lVar2.a().size());
        }
        int min = Math.min(lVar.a().size(), lVar2.a().size());
        if (this.f3916a.size() < min) {
            for (int size = this.f3916a.size(); size < min; size++) {
                this.f3916a.add(new com.airbnb.lottie.y.a());
            }
        } else if (this.f3916a.size() > min) {
            for (int size2 = this.f3916a.size() - 1; size2 >= min; size2--) {
                List<com.airbnb.lottie.y.a> list = this.f3916a;
                list.remove(list.size() - 1);
            }
        }
        PointF b2 = lVar.b();
        PointF b3 = lVar2.b();
        a(com.airbnb.lottie.b0.g.c(b2.x, b3.x, f2), com.airbnb.lottie.b0.g.c(b2.y, b3.y, f2));
        for (int size3 = this.f3916a.size() - 1; size3 >= 0; size3--) {
            com.airbnb.lottie.y.a aVar = lVar.a().get(size3);
            com.airbnb.lottie.y.a aVar2 = lVar2.a().get(size3);
            PointF a2 = aVar.a();
            PointF b4 = aVar.b();
            PointF c2 = aVar.c();
            PointF a3 = aVar2.a();
            PointF b5 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f3916a.get(size3).a(com.airbnb.lottie.b0.g.c(a2.x, a3.x, f2), com.airbnb.lottie.b0.g.c(a2.y, a3.y, f2));
            this.f3916a.get(size3).b(com.airbnb.lottie.b0.g.c(b4.x, b5.x, f2), com.airbnb.lottie.b0.g.c(b4.y, b5.y, f2));
            this.f3916a.get(size3).c(com.airbnb.lottie.b0.g.c(c2.x, c3.x, f2), com.airbnb.lottie.b0.g.c(c2.y, c3.y, f2));
        }
    }
}
