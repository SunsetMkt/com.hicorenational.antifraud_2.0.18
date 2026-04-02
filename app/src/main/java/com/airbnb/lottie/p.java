package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: LottieResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class p<V> {

    @Nullable
    private final V a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Throwable f2234b;

    public p(V v) {
        this.a = v;
        this.f2234b = null;
    }

    @Nullable
    public Throwable a() {
        return this.f2234b;
    }

    @Nullable
    public V b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (b() != null && b().equals(pVar.b())) {
            return true;
        }
        if (a() == null || pVar.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public p(Throwable th) {
        this.f2234b = th;
        this.a = null;
    }
}
