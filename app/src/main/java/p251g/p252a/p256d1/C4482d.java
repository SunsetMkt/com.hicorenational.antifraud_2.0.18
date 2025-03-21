package p251g.p252a.p256d1;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: PublishProcessor.java */
/* renamed from: g.a.d1.d */
/* loaded from: classes2.dex */
public final class C4482d<T> extends AbstractC4481c<T> {

    /* renamed from: d */
    static final a[] f17274d = new a[0];

    /* renamed from: e */
    static final a[] f17275e = new a[0];

    /* renamed from: b */
    final AtomicReference<a<T>[]> f17276b = new AtomicReference<>(f17275e);

    /* renamed from: c */
    Throwable f17277c;

    /* compiled from: PublishProcessor.java */
    /* renamed from: g.a.d1.d$a */
    static final class a<T> extends AtomicLong implements InterfaceC5823d {
        private static final long serialVersionUID = 3562861878281475070L;
        final InterfaceC5822c<? super T> actual;
        final C4482d<T> parent;

        a(InterfaceC5822c<? super T> interfaceC5822c, C4482d<T> c4482d) {
            this.actual = interfaceC5822c;
            this.parent = c4482d;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.m17232b((a) this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        boolean isFull() {
            return get() == 0;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            } else {
                C4476a.m17152b(th);
            }
        }

        public void onNext(T t) {
            long j2 = get();
            if (j2 == Long.MIN_VALUE) {
                return;
            }
            if (j2 != 0) {
                this.actual.onNext(t);
                C5164d.m18611d(this, 1L);
            } else {
                cancel();
                this.actual.onError(new C4562c("Could not emit value due to lack of requests"));
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18609b(this, j2);
            }
        }
    }

    C4482d() {
    }

    @InterfaceC4544d
    /* renamed from: Y */
    public static <T> C4482d<T> m17230Y() {
        return new C4482d<>();
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: T */
    public Throwable mo17205T() {
        if (this.f17276b.get() == f17274d) {
            return this.f17277c;
        }
        return null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: U */
    public boolean mo17206U() {
        return this.f17276b.get() == f17274d && this.f17277c == null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: V */
    public boolean mo17207V() {
        return this.f17276b.get().length != 0;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: W */
    public boolean mo17208W() {
        return this.f17276b.get() == f17274d && this.f17277c != null;
    }

    /* renamed from: a */
    boolean m17231a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17276b.get();
            if (aVarArr == f17274d) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17276b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* renamed from: b */
    void m17232b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17276b.get();
            if (aVarArr == f17274d || aVarArr == f17275e) {
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
                aVarArr2 = f17275e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17276b.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        a<T> aVar = new a<>(interfaceC5822c, this);
        interfaceC5822c.onSubscribe(aVar);
        if (m17231a((a) aVar)) {
            if (aVar.isCancelled()) {
                m17232b((a) aVar);
            }
        } else {
            Throwable th = this.f17277c;
            if (th != null) {
                interfaceC5822c.onError(th);
            } else {
                interfaceC5822c.onComplete();
            }
        }
    }

    @InterfaceC4545e
    /* renamed from: m */
    public boolean m17233m(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        a<T>[] aVarArr = this.f17276b.get();
        for (a<T> aVar : aVarArr) {
            if (aVar.isFull()) {
                return false;
            }
        }
        for (a<T> aVar2 : aVarArr) {
            aVar2.onNext(t);
        }
        return true;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        a<T>[] aVarArr = this.f17276b.get();
        a<T>[] aVarArr2 = f17274d;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.f17276b.getAndSet(aVarArr2)) {
            aVar.onComplete();
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (this.f17276b.get() == f17274d) {
            C4476a.m17152b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f17277c = th;
        for (a<T> aVar : this.f17276b.getAndSet(f17274d)) {
            aVar.onError(th);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.f17276b.get() == f17274d) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (a<T> aVar : this.f17276b.get()) {
            aVar.onNext(t);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c, p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (this.f17276b.get() == f17274d) {
            interfaceC5823d.cancel();
        } else {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }
}
