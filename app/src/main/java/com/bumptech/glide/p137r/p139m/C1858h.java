package com.bumptech.glide.p137r.p139m;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.p137r.p139m.C1861k;

/* compiled from: ViewAnimationFactory.java */
/* renamed from: com.bumptech.glide.r.m.h */
/* loaded from: classes.dex */
public class C1858h<R> implements InterfaceC1857g<R> {

    /* renamed from: a */
    private final C1861k.a f5448a;

    /* renamed from: b */
    private InterfaceC1856f<R> f5449b;

    /* compiled from: ViewAnimationFactory.java */
    /* renamed from: com.bumptech.glide.r.m.h$a */
    private static class a implements C1861k.a {

        /* renamed from: a */
        private final Animation f5450a;

        a(Animation animation) {
            this.f5450a = animation;
        }

        @Override // com.bumptech.glide.p137r.p139m.C1861k.a
        /* renamed from: a */
        public Animation mo4941a(Context context) {
            return this.f5450a;
        }
    }

    /* compiled from: ViewAnimationFactory.java */
    /* renamed from: com.bumptech.glide.r.m.h$b */
    private static class b implements C1861k.a {

        /* renamed from: a */
        private final int f5451a;

        b(int i2) {
            this.f5451a = i2;
        }

        @Override // com.bumptech.glide.p137r.p139m.C1861k.a
        /* renamed from: a */
        public Animation mo4941a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f5451a);
        }
    }

    public C1858h(Animation animation) {
        this(new a(animation));
    }

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1857g
    /* renamed from: a */
    public InterfaceC1856f<R> mo4934a(EnumC1587a enumC1587a, boolean z) {
        if (enumC1587a == EnumC1587a.MEMORY_CACHE || !z) {
            return C1855e.m4939a();
        }
        if (this.f5449b == null) {
            this.f5449b = new C1861k(this.f5448a);
        }
        return this.f5449b;
    }

    public C1858h(int i2) {
        this(new b(i2));
    }

    C1858h(C1861k.a aVar) {
        this.f5448a = aVar;
    }
}
