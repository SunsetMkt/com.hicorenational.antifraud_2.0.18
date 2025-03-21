package com.airbnb.lottie.p102w.p104c;

import androidx.annotation.Nullable;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1362b;
import com.airbnb.lottie.p101c0.C1370j;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.p */
/* loaded from: classes.dex */
public class C1429p<K, A> extends AbstractC1414a<K, A> {

    /* renamed from: i */
    private final C1362b<A> f3564i;

    /* renamed from: j */
    private final A f3565j;

    public C1429p(C1370j<A> c1370j) {
        this(c1370j, null);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public void mo3136a(float f2) {
        this.f3519d = f2;
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: b */
    float mo3139b() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: f */
    public A mo3143f() {
        C1370j<A> c1370j = this.f3520e;
        A a2 = this.f3565j;
        return c1370j.m2869a(0.0f, 0.0f, a2, a2, m3142e(), m3142e(), m3142e());
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: g */
    public void mo3144g() {
        if (this.f3520e != null) {
            super.mo3144g();
        }
    }

    public C1429p(C1370j<A> c1370j, @Nullable A a2) {
        super(Collections.emptyList());
        this.f3564i = new C1362b<>();
        m3137a(c1370j);
        this.f3565j = a2;
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    A mo3134a(C1361a<K> c1361a, float f2) {
        return mo3143f();
    }
}
