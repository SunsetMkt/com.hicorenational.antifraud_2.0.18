package com.airbnb.lottie.c0;

import android.graphics.PointF;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: LottieRelativePointValueCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends j<PointF> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f2134d;

    public i() {
        this.f2134d = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PointF b(b<PointF> bVar) {
        T t = this.f2136c;
        if (t != 0) {
            return (PointF) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.c0.j
    public final PointF a(b<PointF> bVar) {
        this.f2134d.set(com.airbnb.lottie.b0.g.c(bVar.g().x, bVar.b().x, bVar.c()), com.airbnb.lottie.b0.g.c(bVar.g().y, bVar.b().y, bVar.c()));
        PointF pointFB = b(bVar);
        this.f2134d.offset(pointFB.x, pointFB.y);
        return this.f2134d;
    }

    public i(@NonNull PointF pointF) {
        super(pointF);
        this.f2134d = new PointF();
    }
}
