package com.airbnb.lottie.y.k;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShapeData.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private final List<com.airbnb.lottie.y.a> a;

    /* JADX INFO: renamed from: b */
    private PointF f2487b;

    /* JADX INFO: renamed from: c */
    private boolean f2488c;

    public l(PointF pointF, boolean z, List<com.airbnb.lottie.y.a> list) {
        this.f2487b = pointF;
        this.f2488c = z;
        this.a = new ArrayList(list);
    }

    private void a(float f2, float f3) {
        if (this.f2487b == null) {
            this.f2487b = new PointF();
        }
        this.f2487b.set(f2, f3);
    }

    public PointF b() {
        return this.f2487b;
    }

    public boolean c() {
        return this.f2488c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.f2488c + '}';
    }

    public List<com.airbnb.lottie.y.a> a() {
        return this.a;
    }

    public l() {
        this.a = new ArrayList();
    }

    public void a(l lVar, l lVar2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f2487b == null) {
            this.f2487b = new PointF();
        }
        this.f2488c = lVar.c() || lVar2.c();
        if (lVar.a().size() != lVar2.a().size()) {
            com.airbnb.lottie.b0.d.b("Curves must have the same number of control points. Shape 1: " + lVar.a().size() + "\tShape 2: " + lVar2.a().size());
        }
        int iMin = Math.min(lVar.a().size(), lVar2.a().size());
        if (this.a.size() < iMin) {
            for (int size = this.a.size(); size < iMin; size++) {
                this.a.add(new com.airbnb.lottie.y.a());
            }
        } else if (this.a.size() > iMin) {
            for (int size2 = this.a.size() - 1; size2 >= iMin; size2--) {
                List<com.airbnb.lottie.y.a> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = lVar.b();
        PointF pointFB2 = lVar2.b();
        a(com.airbnb.lottie.b0.g.c(pointFB.x, pointFB2.x, f2), com.airbnb.lottie.b0.g.c(pointFB.y, pointFB2.y, f2));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            com.airbnb.lottie.y.a aVar = lVar.a().get(size3);
            com.airbnb.lottie.y.a aVar2 = lVar2.a().get(size3);
            PointF pointFA = aVar.a();
            PointF pointFB3 = aVar.b();
            PointF pointFC = aVar.c();
            PointF pointFA2 = aVar2.a();
            PointF pointFB4 = aVar2.b();
            PointF pointFC2 = aVar2.c();
            this.a.get(size3).a(com.airbnb.lottie.b0.g.c(pointFA.x, pointFA2.x, f2), com.airbnb.lottie.b0.g.c(pointFA.y, pointFA2.y, f2));
            this.a.get(size3).b(com.airbnb.lottie.b0.g.c(pointFB3.x, pointFB4.x, f2), com.airbnb.lottie.b0.g.c(pointFB3.y, pointFB4.y, f2));
            this.a.get(size3).c(com.airbnb.lottie.b0.g.c(pointFC.x, pointFC2.x, f2), com.airbnb.lottie.b0.g.c(pointFC.y, pointFC2.y, f2));
        }
    }
}
