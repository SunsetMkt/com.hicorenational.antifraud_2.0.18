package com.airbnb.lottie.w.c;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: PathKeyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends com.airbnb.lottie.c0.a<PointF> {

    @Nullable
    private Path s;
    private final com.airbnb.lottie.c0.a<PointF> t;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.c0.a<PointF> aVar) {
        super(gVar, aVar.f2111b, aVar.f2112c, aVar.f2113d, aVar.f2114e, aVar.f2115f, aVar.f2116g, aVar.f2117h);
        this.t = aVar;
        h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        T t;
        T t2;
        T t3 = this.f2112c;
        boolean z = (t3 == 0 || (t2 = this.f2111b) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.f2111b;
        if (t4 == 0 || (t = this.f2112c) == 0 || z) {
            return;
        }
        com.airbnb.lottie.c0.a<PointF> aVar = this.t;
        this.s = com.airbnb.lottie.b0.h.a((PointF) t4, (PointF) t, aVar.o, aVar.p);
    }

    @Nullable
    Path i() {
        return this.s;
    }
}
