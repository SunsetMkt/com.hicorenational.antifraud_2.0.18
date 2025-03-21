package p251g.p252a.p258f1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: MaybeSubject.java */
/* renamed from: g.a.f1.d */
/* loaded from: classes2.dex */
public final class C4496d<T> extends AbstractC4533s<T> implements InterfaceC4559v<T> {

    /* renamed from: e */
    static final a[] f17369e = new a[0];

    /* renamed from: f */
    static final a[] f17370f = new a[0];

    /* renamed from: c */
    T f17373c;

    /* renamed from: d */
    Throwable f17374d;

    /* renamed from: b */
    final AtomicBoolean f17372b = new AtomicBoolean();

    /* renamed from: a */
    final AtomicReference<a<T>[]> f17371a = new AtomicReference<>(f17369e);

    /* compiled from: MaybeSubject.java */
    /* renamed from: g.a.f1.d$a */
    static final class a<T> extends AtomicReference<C4496d<T>> implements InterfaceC4552c {
        private static final long serialVersionUID = -7650903191002190468L;
        final InterfaceC4559v<? super T> actual;

        a(InterfaceC4559v<? super T> interfaceC4559v, C4496d<T> c4496d) {
            this.actual = interfaceC4559v;
            lazySet(c4496d);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            C4496d<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.m17326b((a) this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    C4496d() {
    }

    @InterfaceC4544d
    /* renamed from: A */
    public static <T> C4496d<T> m17324A() {
        return new C4496d<>();
    }

    /* renamed from: a */
    boolean m17325a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17371a.get();
            if (aVarArr == f17370f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17371a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        a<T> aVar = new a<>(interfaceC4559v, this);
        interfaceC4559v.onSubscribe(aVar);
        if (m17325a((a) aVar)) {
            if (aVar.isDisposed()) {
                m17326b((a) aVar);
                return;
            }
            return;
        }
        Throwable th = this.f17374d;
        if (th != null) {
            interfaceC4559v.onError(th);
            return;
        }
        T t = this.f17373c;
        if (t == null) {
            interfaceC4559v.onComplete();
        } else {
            interfaceC4559v.onSuccess(t);
        }
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onComplete() {
        if (this.f17372b.compareAndSet(false, true)) {
            for (a<T> aVar : this.f17371a.getAndSet(f17370f)) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f17372b.compareAndSet(false, true)) {
            C4476a.m17152b(th);
            return;
        }
        this.f17374d = th;
        for (a<T> aVar : this.f17371a.getAndSet(f17370f)) {
            aVar.actual.onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (this.f17371a.get() == f17370f) {
            interfaceC4552c.dispose();
        }
    }

    @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        if (t == null) {
            onError(new NullPointerException("Null values are not allowed in 2.x"));
            return;
        }
        if (this.f17372b.compareAndSet(false, true)) {
            this.f17373c = t;
            for (a<T> aVar : this.f17371a.getAndSet(f17370f)) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    /* renamed from: t */
    public Throwable m17328t() {
        if (this.f17371a.get() == f17370f) {
            return this.f17374d;
        }
        return null;
    }

    /* renamed from: u */
    public T m17329u() {
        if (this.f17371a.get() == f17370f) {
            return this.f17373c;
        }
        return null;
    }

    /* renamed from: v */
    public boolean m17330v() {
        return this.f17371a.get() == f17370f && this.f17373c == null && this.f17374d == null;
    }

    /* renamed from: w */
    public boolean m17331w() {
        return this.f17371a.get().length != 0;
    }

    /* renamed from: x */
    public boolean m17332x() {
        return this.f17371a.get() == f17370f && this.f17374d != null;
    }

    /* renamed from: y */
    public boolean m17333y() {
        return this.f17371a.get() == f17370f && this.f17373c != null;
    }

    /* renamed from: z */
    int m17334z() {
        return this.f17371a.get().length;
    }

    /* renamed from: b */
    void m17326b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17371a.get();
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
                aVarArr2 = f17369e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17371a.compareAndSet(aVarArr, aVarArr2));
    }
}
