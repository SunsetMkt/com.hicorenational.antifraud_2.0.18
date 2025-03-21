package p251g.p252a.p258f1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: SingleSubject.java */
/* renamed from: g.a.f1.h */
/* loaded from: classes2.dex */
public final class C4500h<T> extends AbstractC4518k0<T> implements InterfaceC4524n0<T> {

    /* renamed from: e */
    static final a[] f17389e = new a[0];

    /* renamed from: f */
    static final a[] f17390f = new a[0];

    /* renamed from: c */
    T f17393c;

    /* renamed from: d */
    Throwable f17394d;

    /* renamed from: b */
    final AtomicBoolean f17392b = new AtomicBoolean();

    /* renamed from: a */
    final AtomicReference<a<T>[]> f17391a = new AtomicReference<>(f17389e);

    /* compiled from: SingleSubject.java */
    /* renamed from: g.a.f1.h$a */
    static final class a<T> extends AtomicReference<C4500h<T>> implements InterfaceC4552c {
        private static final long serialVersionUID = -7650903191002190468L;
        final InterfaceC4524n0<? super T> actual;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, C4500h<T> c4500h) {
            this.actual = interfaceC4524n0;
            lazySet(c4500h);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            C4500h<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.m17356b((a) this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    C4500h() {
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: x */
    public static <T> C4500h<T> m17354x() {
        return new C4500h<>();
    }

    /* renamed from: a */
    boolean m17355a(@InterfaceC4546f a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17391a.get();
            if (aVarArr == f17390f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17391a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(@InterfaceC4546f InterfaceC4524n0<? super T> interfaceC4524n0) {
        a<T> aVar = new a<>(interfaceC4524n0, this);
        interfaceC4524n0.onSubscribe(aVar);
        if (m17355a((a) aVar)) {
            if (aVar.isDisposed()) {
                m17356b((a) aVar);
            }
        } else {
            Throwable th = this.f17394d;
            if (th != null) {
                interfaceC4524n0.onError(th);
            } else {
                interfaceC4524n0.onSuccess(this.f17393c);
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onError(@InterfaceC4546f Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f17392b.compareAndSet(false, true)) {
            C4476a.m17152b(th);
            return;
        }
        this.f17394d = th;
        for (a<T> aVar : this.f17391a.getAndSet(f17390f)) {
            aVar.actual.onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (this.f17391a.get() == f17390f) {
            interfaceC4552c.dispose();
        }
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSuccess(@InterfaceC4546f T t) {
        if (t == null) {
            onError(new NullPointerException("Null values are not allowed in 2.x"));
            return;
        }
        if (this.f17392b.compareAndSet(false, true)) {
            this.f17393c = t;
            for (a<T> aVar : this.f17391a.getAndSet(f17390f)) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    @InterfaceC4547g
    /* renamed from: r */
    public Throwable m17358r() {
        if (this.f17391a.get() == f17390f) {
            return this.f17394d;
        }
        return null;
    }

    @InterfaceC4547g
    /* renamed from: s */
    public T m17359s() {
        if (this.f17391a.get() == f17390f) {
            return this.f17393c;
        }
        return null;
    }

    /* renamed from: t */
    public boolean m17360t() {
        return this.f17391a.get().length != 0;
    }

    /* renamed from: u */
    public boolean m17361u() {
        return this.f17391a.get() == f17390f && this.f17394d != null;
    }

    /* renamed from: v */
    public boolean m17362v() {
        return this.f17391a.get() == f17390f && this.f17393c != null;
    }

    /* renamed from: w */
    int m17363w() {
        return this.f17391a.get().length;
    }

    /* renamed from: b */
    void m17356b(@InterfaceC4546f a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17391a.get();
            int length = aVarArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f17389e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17391a.compareAndSet(aVarArr, aVarArr2));
    }
}
