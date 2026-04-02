package com.bumptech.glide.r.m;

import com.bumptech.glide.r.m.j;

/* JADX INFO: compiled from: ViewPropertyAnimationFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class i<R> implements g<R> {
    private final j.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j<R> f3544b;

    public i(j.a aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.r.m.g
    public f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        if (aVar == com.bumptech.glide.load.a.MEMORY_CACHE || !z) {
            return e.a();
        }
        if (this.f3544b == null) {
            this.f3544b = new j<>(this.a);
        }
        return this.f3544b;
    }
}
