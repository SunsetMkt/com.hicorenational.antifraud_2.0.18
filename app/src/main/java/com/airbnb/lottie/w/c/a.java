package com.airbnb.lottie.w.c;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BaseKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<K, A> {

    /* JADX INFO: renamed from: c */
    private final d<K> f2348c;

    /* JADX INFO: renamed from: e */
    @Nullable
    protected com.airbnb.lottie.c0.j<A> f2350e;
    final List<b> a = new ArrayList(1);

    /* JADX INFO: renamed from: b */
    private boolean f2347b = false;

    /* JADX INFO: renamed from: d */
    protected float f2349d = 0.0f;

    /* JADX INFO: renamed from: f */
    @Nullable
    private A f2351f = null;

    /* JADX INFO: renamed from: g */
    private float f2352g = -1.0f;

    /* JADX INFO: renamed from: h */
    private float f2353h = -1.0f;

    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    private static final class c<T> implements d<T> {
        private c() {
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public com.airbnb.lottie.c0.a<T> a() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float b() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean b(float f2) {
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float c() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean isEmpty() {
            return true;
        }

        /* synthetic */ c(C0038a c0038a) {
            this();
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean a(float f2) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    private interface d<T> {
        com.airbnb.lottie.c0.a<T> a();

        boolean a(float f2);

        @FloatRange(from = 0.0d, to = 1.0d)
        float b();

        boolean b(float f2);

        @FloatRange(from = 0.0d, to = 1.0d)
        float c();

        boolean isEmpty();
    }

    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    private static final class e<T> implements d<T> {
        private final List<? extends com.airbnb.lottie.c0.a<T>> a;

        /* JADX INFO: renamed from: c */
        private com.airbnb.lottie.c0.a<T> f2355c = null;

        /* JADX INFO: renamed from: d */
        private float f2356d = -1.0f;

        /* JADX INFO: renamed from: b */
        @NonNull
        private com.airbnb.lottie.c0.a<T> f2354b = c(0.0f);

        e(List<? extends com.airbnb.lottie.c0.a<T>> list) {
            this.a = list;
        }

        private com.airbnb.lottie.c0.a<T> c(float f2) {
            List<? extends com.airbnb.lottie.c0.a<T>> list = this.a;
            com.airbnb.lottie.c0.a<T> aVar = list.get(list.size() - 1);
            if (f2 >= aVar.d()) {
                return aVar;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                com.airbnb.lottie.c0.a<T> aVar2 = this.a.get(size);
                if (this.f2354b != aVar2 && aVar2.a(f2)) {
                    return aVar2;
                }
            }
            return this.a.get(0);
        }

        @Override // com.airbnb.lottie.w.c.a.d
        @NonNull
        public com.airbnb.lottie.c0.a<T> a() {
            return this.f2354b;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean b(float f2) {
            if (this.f2354b.a(f2)) {
                return !this.f2354b.g();
            }
            this.f2354b = c(f2);
            return true;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean a(float f2) {
            if (this.f2355c == this.f2354b && this.f2356d == f2) {
                return true;
            }
            this.f2355c = this.f2354b;
            this.f2356d = f2;
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float b() {
            return this.a.get(r0.size() - 1).a();
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float c() {
            return this.a.get(0).d();
        }
    }

    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    private static final class f<T> implements d<T> {

        @NonNull
        private final com.airbnb.lottie.c0.a<T> a;

        /* JADX INFO: renamed from: b */
        private float f2357b = -1.0f;

        f(List<? extends com.airbnb.lottie.c0.a<T>> list) {
            this.a = list.get(0);
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public com.airbnb.lottie.c0.a<T> a() {
            return this.a;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean b(float f2) {
            return !this.a.g();
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float c() {
            return this.a.d();
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public boolean a(float f2) {
            if (this.f2357b == f2) {
                return true;
            }
            this.f2357b = f2;
            return false;
        }

        @Override // com.airbnb.lottie.w.c.a.d
        public float b() {
            return this.a.a();
        }
    }

    a(List<? extends com.airbnb.lottie.c0.a<K>> list) {
        this.f2348c = a(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float i() {
        if (this.f2352g == -1.0f) {
            this.f2352g = this.f2348c.c();
        }
        return this.f2352g;
    }

    abstract A a(com.airbnb.lottie.c0.a<K> aVar, float f2);

    public void a(b bVar) {
        this.a.add(bVar);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float b() {
        if (this.f2353h == -1.0f) {
            this.f2353h = this.f2348c.b();
        }
        return this.f2353h;
    }

    protected float c() {
        com.airbnb.lottie.c0.a<K> aVarA = a();
        if (aVarA.g()) {
            return 0.0f;
        }
        return aVarA.f2113d.getInterpolation(d());
    }

    float d() {
        if (this.f2347b) {
            return 0.0f;
        }
        com.airbnb.lottie.c0.a<K> aVarA = a();
        if (aVarA.g()) {
            return 0.0f;
        }
        return (this.f2349d - aVarA.d()) / (aVarA.a() - aVarA.d());
    }

    public float e() {
        return this.f2349d;
    }

    public A f() {
        float fD = d();
        if (this.f2350e == null && this.f2348c.a(fD)) {
            return this.f2351f;
        }
        com.airbnb.lottie.c0.a<K> aVarA = a();
        Interpolator interpolator = aVarA.f2114e;
        A a = (interpolator == null || aVarA.f2115f == null) ? a(aVarA, c()) : a(aVarA, fD, interpolator.getInterpolation(fD), aVarA.f2115f.getInterpolation(fD));
        this.f2351f = a;
        return a;
    }

    public void g() {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).a();
        }
    }

    public void h() {
        this.f2347b = true;
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f2348c.isEmpty()) {
            return;
        }
        if (f2 < i()) {
            f2 = i();
        } else if (f2 > b()) {
            f2 = b();
        }
        if (f2 == this.f2349d) {
            return;
        }
        this.f2349d = f2;
        if (this.f2348c.b(f2)) {
            g();
        }
    }

    protected com.airbnb.lottie.c0.a<K> a() {
        com.airbnb.lottie.e.a("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.c0.a<K> aVarA = this.f2348c.a();
        com.airbnb.lottie.e.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarA;
    }

    public void a(@Nullable com.airbnb.lottie.c0.j<A> jVar) {
        com.airbnb.lottie.c0.j<A> jVar2 = this.f2350e;
        if (jVar2 != null) {
            jVar2.a((a<?, ?>) null);
        }
        this.f2350e = jVar;
        if (jVar != null) {
            jVar.a((a<?, ?>) this);
        }
    }

    protected A a(com.airbnb.lottie.c0.a<K> aVar, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> d<T> a(List<? extends com.airbnb.lottie.c0.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }
}
