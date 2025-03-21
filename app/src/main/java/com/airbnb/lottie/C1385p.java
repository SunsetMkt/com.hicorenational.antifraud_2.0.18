package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: LottieResult.java */
/* renamed from: com.airbnb.lottie.p */
/* loaded from: classes.dex */
public final class C1385p<V> {

    /* renamed from: a */
    @Nullable
    private final V f3356a;

    /* renamed from: b */
    @Nullable
    private final Throwable f3357b;

    public C1385p(V v) {
        this.f3356a = v;
        this.f3357b = null;
    }

    @Nullable
    /* renamed from: a */
    public Throwable m3060a() {
        return this.f3357b;
    }

    @Nullable
    /* renamed from: b */
    public V m3061b() {
        return this.f3356a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1385p)) {
            return false;
        }
        C1385p c1385p = (C1385p) obj;
        if (m3061b() != null && m3061b().equals(c1385p.m3061b())) {
            return true;
        }
        if (m3060a() == null || c1385p.m3060a() == null) {
            return false;
        }
        return m3060a().toString().equals(m3060a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{m3061b(), m3060a()});
    }

    public C1385p(Throwable th) {
        this.f3357b = th;
        this.f3356a = null;
    }
}
