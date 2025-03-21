package p251g.p252a.p258f1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p272d.C4630l;

/* compiled from: AsyncSubject.java */
/* renamed from: g.a.f1.a */
/* loaded from: classes2.dex */
public final class C4493a<T> extends AbstractC4501i<T> {

    /* renamed from: d */
    static final a[] f17341d = new a[0];

    /* renamed from: e */
    static final a[] f17342e = new a[0];

    /* renamed from: a */
    final AtomicReference<a<T>[]> f17343a = new AtomicReference<>(f17341d);

    /* renamed from: b */
    Throwable f17344b;

    /* renamed from: c */
    T f17345c;

    /* compiled from: AsyncSubject.java */
    /* renamed from: g.a.f1.a$a */
    static final class a<T> extends C4630l<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final C4493a<T> parent;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, C4493a<T> c4493a) {
            super(interfaceC4514i0);
            this.parent = c4493a;
        }

        @Override // p251g.p252a.p268y0.p272d.C4630l, p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (super.tryDispose()) {
                this.parent.m17300b((a) this);
            }
        }

        void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isDisposed()) {
                C4476a.m17152b(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    C4493a() {
    }

    @InterfaceC4544d
    /* renamed from: X */
    public static <T> C4493a<T> m17290X() {
        return new C4493a<>();
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: O */
    public Throwable mo17291O() {
        if (this.f17343a.get() == f17342e) {
            return this.f17344b;
        }
        return null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: P */
    public boolean mo17292P() {
        return this.f17343a.get() == f17342e && this.f17344b == null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: Q */
    public boolean mo17293Q() {
        return this.f17343a.get().length != 0;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: R */
    public boolean mo17294R() {
        return this.f17343a.get() == f17342e && this.f17344b != null;
    }

    /* renamed from: T */
    public T m17295T() {
        if (this.f17343a.get() == f17342e) {
            return this.f17345c;
        }
        return null;
    }

    /* renamed from: U */
    public Object[] m17296U() {
        T m17295T = m17295T();
        return m17295T != null ? new Object[]{m17295T} : new Object[0];
    }

    /* renamed from: V */
    public boolean m17297V() {
        return this.f17343a.get() == f17342e && this.f17345c != null;
    }

    /* renamed from: W */
    void m17298W() {
        this.f17345c = null;
        NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.f17344b = nullPointerException;
        for (a<T> aVar : this.f17343a.getAndSet(f17342e)) {
            aVar.onError(nullPointerException);
        }
    }

    /* renamed from: a */
    boolean m17299a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17343a.get();
            if (aVarArr == f17342e) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17343a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* renamed from: b */
    void m17300b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17343a.get();
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
                aVarArr2 = f17341d;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17343a.compareAndSet(aVarArr, aVarArr2));
    }

    /* renamed from: c */
    public T[] m17301c(T[] tArr) {
        T m17295T = m17295T();
        if (m17295T == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = m17295T;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        a<T> aVar = new a<>(interfaceC4514i0, this);
        interfaceC4514i0.onSubscribe(aVar);
        if (m17299a((a) aVar)) {
            if (aVar.isDisposed()) {
                m17300b((a) aVar);
                return;
            }
            return;
        }
        Throwable th = this.f17344b;
        if (th != null) {
            interfaceC4514i0.onError(th);
            return;
        }
        T t = this.f17345c;
        if (t != null) {
            aVar.complete(t);
        } else {
            aVar.onComplete();
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        a<T>[] aVarArr = this.f17343a.get();
        a<T>[] aVarArr2 = f17342e;
        if (aVarArr == aVarArr2) {
            return;
        }
        T t = this.f17345c;
        a<T>[] andSet = this.f17343a.getAndSet(aVarArr2);
        int i2 = 0;
        if (t == null) {
            int length = andSet.length;
            while (i2 < length) {
                andSet[i2].onComplete();
                i2++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i2 < length2) {
            andSet[i2].complete(t);
            i2++;
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        a<T>[] aVarArr = this.f17343a.get();
        a<T>[] aVarArr2 = f17342e;
        if (aVarArr == aVarArr2) {
            C4476a.m17152b(th);
            return;
        }
        this.f17345c = null;
        this.f17344b = th;
        for (a<T> aVar : this.f17343a.getAndSet(aVarArr2)) {
            aVar.onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (this.f17343a.get() == f17342e) {
            return;
        }
        if (t == null) {
            m17298W();
        } else {
            this.f17345c = t;
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (this.f17343a.get() == f17342e) {
            interfaceC4552c.dispose();
        }
    }
}
