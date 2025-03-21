package p251g.p252a.p256d1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p268y0.p283i.C5156f;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: AsyncProcessor.java */
/* renamed from: g.a.d1.a */
/* loaded from: classes2.dex */
public final class C4479a<T> extends AbstractC4481c<T> {

    /* renamed from: e */
    static final a[] f17259e = new a[0];

    /* renamed from: f */
    static final a[] f17260f = new a[0];

    /* renamed from: b */
    final AtomicReference<a<T>[]> f17261b = new AtomicReference<>(f17259e);

    /* renamed from: c */
    Throwable f17262c;

    /* renamed from: d */
    T f17263d;

    /* compiled from: AsyncProcessor.java */
    /* renamed from: g.a.d1.a$a */
    static final class a<T> extends C5156f<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final C4479a<T> parent;

        a(InterfaceC5822c<? super T> interfaceC5822c, C4479a<T> c4479a) {
            super(interfaceC5822c);
            this.parent = c4479a;
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (super.tryCancel()) {
                this.parent.m17213b((a) this);
            }
        }

        void onComplete() {
            if (isCancelled()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isCancelled()) {
                C4476a.m17152b(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    C4479a() {
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: c0 */
    public static <T> C4479a<T> m17204c0() {
        return new C4479a<>();
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: T */
    public Throwable mo17205T() {
        if (this.f17261b.get() == f17260f) {
            return this.f17262c;
        }
        return null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: U */
    public boolean mo17206U() {
        return this.f17261b.get() == f17260f && this.f17262c == null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: V */
    public boolean mo17207V() {
        return this.f17261b.get().length != 0;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: W */
    public boolean mo17208W() {
        return this.f17261b.get() == f17260f && this.f17262c != null;
    }

    /* renamed from: Y */
    public T m17209Y() {
        if (this.f17261b.get() == f17260f) {
            return this.f17263d;
        }
        return null;
    }

    /* renamed from: Z */
    public Object[] m17210Z() {
        T m17209Y = m17209Y();
        return m17209Y != null ? new Object[]{m17209Y} : new Object[0];
    }

    /* renamed from: a */
    boolean m17211a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17261b.get();
            if (aVarArr == f17260f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17261b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* renamed from: a0 */
    public boolean m17212a0() {
        return this.f17261b.get() == f17260f && this.f17263d != null;
    }

    /* renamed from: b */
    void m17213b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17261b.get();
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
                aVarArr2 = f17259e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17261b.compareAndSet(aVarArr, aVarArr2));
    }

    /* renamed from: b0 */
    void m17214b0() {
        this.f17263d = null;
        NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.f17262c = nullPointerException;
        for (a<T> aVar : this.f17261b.getAndSet(f17260f)) {
            aVar.onError(nullPointerException);
        }
    }

    /* renamed from: c */
    public T[] m17215c(T[] tArr) {
        T m17209Y = m17209Y();
        if (m17209Y == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = m17209Y;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        a<T> aVar = new a<>(interfaceC5822c, this);
        interfaceC5822c.onSubscribe(aVar);
        if (m17211a((a) aVar)) {
            if (aVar.isCancelled()) {
                m17213b((a) aVar);
                return;
            }
            return;
        }
        Throwable th = this.f17262c;
        if (th != null) {
            interfaceC5822c.onError(th);
            return;
        }
        T t = this.f17263d;
        if (t != null) {
            aVar.complete(t);
        } else {
            aVar.onComplete();
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        a<T>[] aVarArr = this.f17261b.get();
        a<T>[] aVarArr2 = f17260f;
        if (aVarArr == aVarArr2) {
            return;
        }
        T t = this.f17263d;
        a<T>[] andSet = this.f17261b.getAndSet(aVarArr2);
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

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        a<T>[] aVarArr = this.f17261b.get();
        a<T>[] aVarArr2 = f17260f;
        if (aVarArr == aVarArr2) {
            C4476a.m17152b(th);
            return;
        }
        this.f17263d = null;
        this.f17262c = th;
        for (a<T> aVar : this.f17261b.getAndSet(aVarArr2)) {
            aVar.onError(th);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.f17261b.get() == f17260f) {
            return;
        }
        if (t == null) {
            m17214b0();
        } else {
            this.f17263d = t;
        }
    }

    @Override // p324i.p338d.InterfaceC5822c, p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (this.f17261b.get() == f17260f) {
            interfaceC5823d.cancel();
        } else {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }
}
