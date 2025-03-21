package p251g.p252a.p258f1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: PublishSubject.java */
/* renamed from: g.a.f1.e */
/* loaded from: classes2.dex */
public final class C4497e<T> extends AbstractC4501i<T> {

    /* renamed from: c */
    static final a[] f17375c = new a[0];

    /* renamed from: d */
    static final a[] f17376d = new a[0];

    /* renamed from: a */
    final AtomicReference<a<T>[]> f17377a = new AtomicReference<>(f17376d);

    /* renamed from: b */
    Throwable f17378b;

    /* compiled from: PublishSubject.java */
    /* renamed from: g.a.f1.e$a */
    static final class a<T> extends AtomicBoolean implements InterfaceC4552c {
        private static final long serialVersionUID = 3562861878281475070L;
        final InterfaceC4514i0<? super T> actual;
        final C4497e<T> parent;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, C4497e<T> c4497e) {
            this.actual = interfaceC4514i0;
            this.parent = c4497e;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.m17337b((a) this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            if (get()) {
                C4476a.m17152b(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }
    }

    C4497e() {
    }

    @InterfaceC4544d
    /* renamed from: T */
    public static <T> C4497e<T> m17335T() {
        return new C4497e<>();
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: O */
    public Throwable mo17291O() {
        if (this.f17377a.get() == f17375c) {
            return this.f17378b;
        }
        return null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: P */
    public boolean mo17292P() {
        return this.f17377a.get() == f17375c && this.f17378b == null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: Q */
    public boolean mo17293Q() {
        return this.f17377a.get().length != 0;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: R */
    public boolean mo17294R() {
        return this.f17377a.get() == f17375c && this.f17378b != null;
    }

    /* renamed from: a */
    boolean m17336a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17377a.get();
            if (aVarArr == f17375c) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17377a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* renamed from: b */
    void m17337b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17377a.get();
            if (aVarArr == f17375c || aVarArr == f17376d) {
                return;
            }
            int length = aVarArr.length;
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
                aVarArr2 = f17376d;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17377a.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        a<T> aVar = new a<>(interfaceC4514i0, this);
        interfaceC4514i0.onSubscribe(aVar);
        if (m17336a((a) aVar)) {
            if (aVar.isDisposed()) {
                m17337b((a) aVar);
            }
        } else {
            Throwable th = this.f17378b;
            if (th != null) {
                interfaceC4514i0.onError(th);
            } else {
                interfaceC4514i0.onComplete();
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        a<T>[] aVarArr = this.f17377a.get();
        a<T>[] aVarArr2 = f17375c;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.f17377a.getAndSet(aVarArr2)) {
            aVar.onComplete();
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (this.f17377a.get() == f17375c) {
            C4476a.m17152b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f17378b = th;
        for (a<T> aVar : this.f17377a.getAndSet(f17375c)) {
            aVar.onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (this.f17377a.get() == f17375c) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (a<T> aVar : this.f17377a.get()) {
            aVar.onNext(t);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (this.f17377a.get() == f17375c) {
            interfaceC4552c.dispose();
        }
    }
}
