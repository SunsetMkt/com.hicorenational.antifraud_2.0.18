package h.a.d1;

import h.a.y0.i.j;
import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PublishProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends c<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final a[] f10280d = new a[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final a[] f10281e = new a[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>[]> f10282b = new AtomicReference<>(f10281e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Throwable f10283c;

    /* JADX INFO: compiled from: PublishProcessor.java */
    static final class a<T> extends AtomicLong implements j.d.d {
        private static final long serialVersionUID = 3562861878281475070L;
        final j.d.c<? super T> actual;
        final d<T> parent;

        a(j.d.c<? super T> cVar, d<T> dVar) {
            this.actual = cVar;
            this.parent = dVar;
        }

        @Override // j.d.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b((a) this);
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
                h.a.c1.a.b(th);
            }
        }

        public void onNext(T t) {
            long j2 = get();
            if (j2 == Long.MIN_VALUE) {
                return;
            }
            if (j2 != 0) {
                this.actual.onNext(t);
                h.a.y0.j.d.d(this, 1L);
            } else {
                cancel();
                this.actual.onError(new h.a.v0.c("Could not emit value due to lack of requests"));
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (j.validate(j2)) {
                h.a.y0.j.d.b(this, j2);
            }
        }
    }

    d() {
    }

    @h.a.t0.d
    public static <T> d<T> Y() {
        return new d<>();
    }

    @Override // h.a.d1.c
    public Throwable T() {
        if (this.f10282b.get() == f10280d) {
            return this.f10283c;
        }
        return null;
    }

    @Override // h.a.d1.c
    public boolean U() {
        return this.f10282b.get() == f10280d && this.f10283c == null;
    }

    @Override // h.a.d1.c
    public boolean V() {
        return this.f10282b.get().length != 0;
    }

    @Override // h.a.d1.c
    public boolean W() {
        return this.f10282b.get() == f10280d && this.f10283c != null;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f10282b.get();
            if (aVarArr == f10280d) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f10282b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f10282b.get();
            if (aVarArr == f10280d || aVarArr == f10281e) {
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
                aVarArr2 = f10281e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f10282b.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        a<T> aVar = new a<>(cVar, this);
        cVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isCancelled()) {
                b((a) aVar);
            }
        } else {
            Throwable th = this.f10283c;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
        }
    }

    @h.a.t0.e
    public boolean m(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        a<T>[] aVarArr = this.f10282b.get();
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

    @Override // j.d.c
    public void onComplete() {
        a<T>[] aVarArr = this.f10282b.get();
        a<T>[] aVarArr2 = f10280d;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.f10282b.getAndSet(aVarArr2)) {
            aVar.onComplete();
        }
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (this.f10282b.get() == f10280d) {
            h.a.c1.a.b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f10283c = th;
        for (a<T> aVar : this.f10282b.getAndSet(f10280d)) {
            aVar.onError(th);
        }
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (this.f10282b.get() == f10280d) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (a<T> aVar : this.f10282b.get()) {
            aVar.onNext(t);
        }
    }

    @Override // j.d.c, h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (this.f10282b.get() == f10280d) {
            dVar.cancel();
        } else {
            dVar.request(m0.f12222b);
        }
    }
}
