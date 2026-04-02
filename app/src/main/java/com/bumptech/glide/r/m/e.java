package com.bumptech.glide.r.m;

import com.bumptech.glide.r.m.f;

/* JADX INFO: compiled from: NoTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class e<R> implements f<R> {
    static final e<?> a = new e<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g<?> f3542b = new a();

    /* JADX INFO: compiled from: NoTransition.java */
    public static class a<R> implements g<R> {
        @Override // com.bumptech.glide.r.m.g
        public f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
            return e.a;
        }
    }

    public static <R> f<R> a() {
        return a;
    }

    public static <R> g<R> b() {
        return (g<R>) f3542b;
    }

    @Override // com.bumptech.glide.r.m.f
    public boolean a(Object obj, f.a aVar) {
        return false;
    }
}
