package com.airbnb.lottie.y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* JADX INFO: compiled from: LottieCompositionCache.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f2422b = new g();
    private final LruCache<String, com.airbnb.lottie.g> a = new LruCache<>(20);

    @VisibleForTesting
    g() {
    }

    public static g b() {
        return f2422b;
    }

    @Nullable
    public com.airbnb.lottie.g a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.g gVar) {
        if (str == null) {
            return;
        }
        this.a.put(str, gVar);
    }

    public void a() {
        this.a.evictAll();
    }

    public void a(int i2) {
        this.a.resize(i2);
    }
}
