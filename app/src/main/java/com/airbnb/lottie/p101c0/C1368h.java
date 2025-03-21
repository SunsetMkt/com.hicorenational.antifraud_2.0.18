package com.airbnb.lottie.p101c0;

import com.airbnb.lottie.p100b0.C1357g;

/* compiled from: LottieRelativeIntegerValueCallback.java */
/* renamed from: com.airbnb.lottie.c0.h */
/* loaded from: classes.dex */
public class C1368h extends C1370j<Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public Integer m2867b(C1362b<Integer> c1362b) {
        T t = this.f3185c;
        if (t != 0) {
            return (Integer) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p101c0.C1370j
    /* renamed from: a */
    public Integer mo2653a(C1362b<Integer> c1362b) {
        return Integer.valueOf(C1357g.m2823a(c1362b.m2864g().intValue(), c1362b.m2859b().intValue(), c1362b.m2860c()) + m2867b(c1362b).intValue());
    }
}
