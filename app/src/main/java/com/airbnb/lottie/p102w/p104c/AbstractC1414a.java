package com.airbnb.lottie.p102w.p104c;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC1414a<K, A> {

    /* renamed from: c */
    private final d<K> f3518c;

    /* renamed from: e */
    @Nullable
    protected C1370j<A> f3520e;

    /* renamed from: a */
    final List<b> f3516a = new ArrayList(1);

    /* renamed from: b */
    private boolean f3517b = false;

    /* renamed from: d */
    protected float f3519d = 0.0f;

    /* renamed from: f */
    @Nullable
    private A f3521f = null;

    /* renamed from: g */
    private float f3522g = -1.0f;

    /* renamed from: h */
    private float f3523h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.w.c.a$b */
    public interface b {
        /* renamed from: a */
        void mo3093a();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.w.c.a$c */
    private static final class c<T> implements d<T> {
        private c() {
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: a */
        public C1361a<T> mo3146a() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: b */
        public float mo3148b() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: b */
        public boolean mo3149b(float f2) {
            return false;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: c */
        public float mo3150c() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        public boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: a */
        public boolean mo3147a(float f2) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.w.c.a$d */
    private interface d<T> {
        /* renamed from: a */
        C1361a<T> mo3146a();

        /* renamed from: a */
        boolean mo3147a(float f2);

        @FloatRange(from = 0.0d, m293to = 1.0d)
        /* renamed from: b */
        float mo3148b();

        /* renamed from: b */
        boolean mo3149b(float f2);

        @FloatRange(from = 0.0d, m293to = 1.0d)
        /* renamed from: c */
        float mo3150c();

        boolean isEmpty();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.w.c.a$e */
    private static final class e<T> implements d<T> {

        /* renamed from: a */
        private final List<? extends C1361a<T>> f3524a;

        /* renamed from: c */
        private C1361a<T> f3526c = null;

        /* renamed from: d */
        private float f3527d = -1.0f;

        /* renamed from: b */
        @NonNull
        private C1361a<T> f3525b = m3151c(0.0f);

        e(List<? extends C1361a<T>> list) {
            this.f3524a = list;
        }

        /* renamed from: c */
        private C1361a<T> m3151c(float f2) {
            List<? extends C1361a<T>> list = this.f3524a;
            C1361a<T> c1361a = list.get(list.size() - 1);
            if (f2 >= c1361a.m2853d()) {
                return c1361a;
            }
            for (int size = this.f3524a.size() - 2; size >= 1; size--) {
                C1361a<T> c1361a2 = this.f3524a.get(size);
                if (this.f3525b != c1361a2 && c1361a2.m2850a(f2)) {
                    return c1361a2;
                }
            }
            return this.f3524a.get(0);
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        @NonNull
        /* renamed from: a */
        public C1361a<T> mo3146a() {
            return this.f3525b;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: b */
        public boolean mo3149b(float f2) {
            if (this.f3525b.m2850a(f2)) {
                return !this.f3525b.m2856g();
            }
            this.f3525b = m3151c(f2);
            return true;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: a */
        public boolean mo3147a(float f2) {
            if (this.f3526c == this.f3525b && this.f3527d == f2) {
                return true;
            }
            this.f3526c = this.f3525b;
            this.f3527d = f2;
            return false;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: b */
        public float mo3148b() {
            return this.f3524a.get(r0.size() - 1).m2849a();
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: c */
        public float mo3150c() {
            return this.f3524a.get(0).m2853d();
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.w.c.a$f */
    private static final class f<T> implements d<T> {

        /* renamed from: a */
        @NonNull
        private final C1361a<T> f3528a;

        /* renamed from: b */
        private float f3529b = -1.0f;

        f(List<? extends C1361a<T>> list) {
            this.f3528a = list.get(0);
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: a */
        public C1361a<T> mo3146a() {
            return this.f3528a;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: b */
        public boolean mo3149b(float f2) {
            return !this.f3528a.m2856g();
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: c */
        public float mo3150c() {
            return this.f3528a.m2853d();
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: a */
        public boolean mo3147a(float f2) {
            if (this.f3529b == f2) {
                return true;
            }
            this.f3529b = f2;
            return false;
        }

        @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.d
        /* renamed from: b */
        public float mo3148b() {
            return this.f3528a.m2849a();
        }
    }

    AbstractC1414a(List<? extends C1361a<K>> list) {
        this.f3518c = m3131a(list);
    }

    @FloatRange(from = 0.0d, m293to = 1.0d)
    /* renamed from: i */
    private float m3132i() {
        if (this.f3522g == -1.0f) {
            this.f3522g = this.f3518c.mo3150c();
        }
        return this.f3522g;
    }

    /* renamed from: a */
    abstract A mo3134a(C1361a<K> c1361a, float f2);

    /* renamed from: a */
    public void m3138a(b bVar) {
        this.f3516a.add(bVar);
    }

    @FloatRange(from = 0.0d, m293to = 1.0d)
    /* renamed from: b */
    float mo3139b() {
        if (this.f3523h == -1.0f) {
            this.f3523h = this.f3518c.mo3148b();
        }
        return this.f3523h;
    }

    /* renamed from: c */
    protected float m3140c() {
        C1361a<K> m3133a = m3133a();
        if (m3133a.m2856g()) {
            return 0.0f;
        }
        return m3133a.f3158d.getInterpolation(m3141d());
    }

    /* renamed from: d */
    float m3141d() {
        if (this.f3517b) {
            return 0.0f;
        }
        C1361a<K> m3133a = m3133a();
        if (m3133a.m2856g()) {
            return 0.0f;
        }
        return (this.f3519d - m3133a.m2853d()) / (m3133a.m2849a() - m3133a.m2853d());
    }

    /* renamed from: e */
    public float m3142e() {
        return this.f3519d;
    }

    /* renamed from: f */
    public A mo3143f() {
        float m3141d = m3141d();
        if (this.f3520e == null && this.f3518c.mo3147a(m3141d)) {
            return this.f3521f;
        }
        C1361a<K> m3133a = m3133a();
        Interpolator interpolator = m3133a.f3159e;
        A mo3134a = (interpolator == null || m3133a.f3160f == null) ? mo3134a(m3133a, m3140c()) : mo3135a(m3133a, m3141d, interpolator.getInterpolation(m3141d), m3133a.f3160f.getInterpolation(m3141d));
        this.f3521f = mo3134a;
        return mo3134a;
    }

    /* renamed from: g */
    public void mo3144g() {
        for (int i2 = 0; i2 < this.f3516a.size(); i2++) {
            this.f3516a.get(i2).mo3093a();
        }
    }

    /* renamed from: h */
    public void m3145h() {
        this.f3517b = true;
    }

    /* renamed from: a */
    public void mo3136a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        if (this.f3518c.isEmpty()) {
            return;
        }
        if (f2 < m3132i()) {
            f2 = m3132i();
        } else if (f2 > mo3139b()) {
            f2 = mo3139b();
        }
        if (f2 == this.f3519d) {
            return;
        }
        this.f3519d = f2;
        if (this.f3518c.mo3149b(f2)) {
            mo3144g();
        }
    }

    /* renamed from: a */
    protected C1361a<K> m3133a() {
        C1374e.m2881a("BaseKeyframeAnimation#getCurrentKeyframe");
        C1361a<K> mo3146a = this.f3518c.mo3146a();
        C1374e.m2883b("BaseKeyframeAnimation#getCurrentKeyframe");
        return mo3146a;
    }

    /* renamed from: a */
    public void m3137a(@Nullable C1370j<A> c1370j) {
        C1370j<A> c1370j2 = this.f3520e;
        if (c1370j2 != null) {
            c1370j2.m2870a((AbstractC1414a<?, ?>) null);
        }
        this.f3520e = c1370j;
        if (c1370j != null) {
            c1370j.m2870a((AbstractC1414a<?, ?>) this);
        }
    }

    /* renamed from: a */
    protected A mo3135a(C1361a<K> c1361a, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    /* renamed from: a */
    private static <T> d<T> m3131a(List<? extends C1361a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }
}
