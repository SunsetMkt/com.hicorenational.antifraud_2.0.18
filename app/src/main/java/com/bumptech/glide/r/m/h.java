package com.bumptech.glide.r.m;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.r.m.k;

/* JADX INFO: compiled from: ViewAnimationFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class h<R> implements g<R> {
    private final k.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f<R> f3543b;

    /* JADX INFO: compiled from: ViewAnimationFactory.java */
    private static class a implements k.a {
        private final Animation a;

        a(Animation animation) {
            this.a = animation;
        }

        @Override // com.bumptech.glide.r.m.k.a
        public Animation a(Context context) {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: ViewAnimationFactory.java */
    private static class b implements k.a {
        private final int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // com.bumptech.glide.r.m.k.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.a);
        }
    }

    public h(Animation animation) {
        this(new a(animation));
    }

    @Override // com.bumptech.glide.r.m.g
    public f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        if (aVar == com.bumptech.glide.load.a.MEMORY_CACHE || !z) {
            return e.a();
        }
        if (this.f3543b == null) {
            this.f3543b = new k(this.a);
        }
        return this.f3543b;
    }

    public h(int i2) {
        this(new b(i2));
    }

    h(k.a aVar) {
        this.a = aVar;
    }
}
