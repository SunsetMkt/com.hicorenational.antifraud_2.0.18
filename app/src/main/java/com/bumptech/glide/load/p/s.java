package com.bumptech.glide.load.p;

import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Jobs.java */
/* JADX INFO: loaded from: classes.dex */
final class s {
    private final Map<com.bumptech.glide.load.g, l<?>> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.g, l<?>> f3020b = new HashMap();

    s() {
    }

    @VisibleForTesting
    Map<com.bumptech.glide.load.g, l<?>> a() {
        return Collections.unmodifiableMap(this.a);
    }

    void b(com.bumptech.glide.load.g gVar, l<?> lVar) {
        Map<com.bumptech.glide.load.g, l<?>> mapA = a(lVar.g());
        if (lVar.equals(mapA.get(gVar))) {
            mapA.remove(gVar);
        }
    }

    l<?> a(com.bumptech.glide.load.g gVar, boolean z) {
        return a(z).get(gVar);
    }

    void a(com.bumptech.glide.load.g gVar, l<?> lVar) {
        a(lVar.g()).put(gVar, lVar);
    }

    private Map<com.bumptech.glide.load.g, l<?>> a(boolean z) {
        return z ? this.f3020b : this.a;
    }
}
