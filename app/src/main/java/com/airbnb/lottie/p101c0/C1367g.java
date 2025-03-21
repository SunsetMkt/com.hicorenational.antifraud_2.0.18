package com.airbnb.lottie.p101c0;

import androidx.annotation.NonNull;
import com.airbnb.lottie.p100b0.C1357g;

/* compiled from: LottieRelativeFloatValueCallback.java */
/* renamed from: com.airbnb.lottie.c0.g */
/* loaded from: classes.dex */
public class C1367g extends C1370j<Float> {
    public C1367g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public Float m2866b(C1362b<Float> c1362b) {
        T t = this.f3185c;
        if (t != 0) {
            return (Float) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    public C1367g(@NonNull Float f2) {
        super(f2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p101c0.C1370j
    /* renamed from: a */
    public Float mo2653a(C1362b<Float> c1362b) {
        return Float.valueOf(C1357g.m2831c(c1362b.m2864g().floatValue(), c1362b.m2859b().floatValue(), c1362b.m2860c()) + m2866b(c1362b).floatValue());
    }
}
