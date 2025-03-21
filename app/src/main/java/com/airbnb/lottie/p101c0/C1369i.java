package com.airbnb.lottie.p101c0;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.p100b0.C1357g;

/* compiled from: LottieRelativePointValueCallback.java */
/* renamed from: com.airbnb.lottie.c0.i */
/* loaded from: classes.dex */
public class C1369i extends C1370j<PointF> {

    /* renamed from: d */
    private final PointF f3182d;

    public C1369i() {
        this.f3182d = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public PointF m2868b(C1362b<PointF> c1362b) {
        T t = this.f3185c;
        if (t != 0) {
            return (PointF) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p101c0.C1370j
    /* renamed from: a */
    public final PointF mo2653a(C1362b<PointF> c1362b) {
        this.f3182d.set(C1357g.m2831c(c1362b.m2864g().x, c1362b.m2859b().x, c1362b.m2860c()), C1357g.m2831c(c1362b.m2864g().y, c1362b.m2859b().y, c1362b.m2860c()));
        PointF m2868b = m2868b(c1362b);
        this.f3182d.offset(m2868b.x, m2868b.y);
        return this.f3182d;
    }

    public C1369i(@NonNull PointF pointF) {
        super(pointF);
        this.f3182d = new PointF();
    }
}
