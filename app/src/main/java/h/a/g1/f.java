package h.a.g1;

import h.a.q;
import h.a.x0.g;
import h.a.y0.c.l;
import h.a.y0.i.j;
import h.a.y0.j.k;
import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: TestSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public class f<T> extends h.a.a1.a<T, f<T>> implements q<T>, j.d.d, h.a.u0.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final j.d.c<? super T> f10399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f10400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicReference<j.d.d> f10401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicLong f10402n;
    private l<T> o;

    /* JADX INFO: compiled from: TestSubscriber.java */
    enum a implements q<Object> {
        INSTANCE;

        @Override // j.d.c
        public void onComplete() {
        }

        @Override // j.d.c
        public void onError(Throwable th) {
        }

        @Override // j.d.c
        public void onNext(Object obj) {
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
        }
    }

    public f() {
        this(a.INSTANCE, m0.f12222b);
    }

    public static <T> f<T> C() {
        return new f<>();
    }

    public static <T> f<T> a(j.d.c<? super T> cVar) {
        return new f<>(cVar);
    }

    public static <T> f<T> b(long j2) {
        return new f<>(j2);
    }

    static String e(int i2) {
        if (i2 == 0) {
            return "NONE";
        }
        if (i2 == 1) {
            return "SYNC";
        }
        if (i2 == 2) {
            return "ASYNC";
        }
        return "Unknown(" + i2 + ")";
    }

    public final boolean A() {
        return this.f10400l;
    }

    protected void B() {
    }

    final f<T> c(int i2) {
        int i3 = this.f10234h;
        if (i3 == i2) {
            return this;
        }
        if (this.o == null) {
            throw b("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + e(i2) + ", actual: " + e(i3));
    }

    @Override // j.d.d
    public final void cancel() {
        if (this.f10400l) {
            return;
        }
        this.f10400l = true;
        j.cancel(this.f10401m);
    }

    final f<T> d(int i2) {
        this.f10233g = i2;
        return this;
    }

    @Override // h.a.u0.c
    public final void dispose() {
        cancel();
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return this.f10400l;
    }

    @Override // j.d.c
    public void onComplete() {
        if (!this.f10232f) {
            this.f10232f = true;
            if (this.f10401m.get() == null) {
                this.f10229c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f10231e = Thread.currentThread();
            this.f10230d++;
            this.f10399k.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (!this.f10232f) {
            this.f10232f = true;
            if (this.f10401m.get() == null) {
                this.f10229c.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f10231e = Thread.currentThread();
            this.f10229c.add(th);
            if (th == null) {
                this.f10229c.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f10399k.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (!this.f10232f) {
            this.f10232f = true;
            if (this.f10401m.get() == null) {
                this.f10229c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f10231e = Thread.currentThread();
        if (this.f10234h != 2) {
            this.f10228b.add(t);
            if (t == null) {
                this.f10229c.add(new NullPointerException("onNext received a null value"));
            }
            this.f10399k.onNext(t);
            return;
        }
        while (true) {
            try {
                T tPoll = this.o.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f10228b.add(tPoll);
                }
            } catch (Throwable th) {
                this.f10229c.add(th);
                this.o.cancel();
                return;
            }
        }
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        this.f10231e = Thread.currentThread();
        if (dVar == null) {
            this.f10229c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.f10401m.compareAndSet(null, dVar)) {
            dVar.cancel();
            if (this.f10401m.get() != j.CANCELLED) {
                this.f10229c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + dVar));
                return;
            }
            return;
        }
        int i2 = this.f10233g;
        if (i2 != 0 && (dVar instanceof l)) {
            this.o = (l) dVar;
            int iRequestFusion = this.o.requestFusion(i2);
            this.f10234h = iRequestFusion;
            if (iRequestFusion == 1) {
                this.f10232f = true;
                this.f10231e = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.o.poll();
                        if (tPoll == null) {
                            this.f10230d++;
                            return;
                        }
                        this.f10228b.add(tPoll);
                    } catch (Throwable th) {
                        this.f10229c.add(th);
                        return;
                    }
                }
            }
        }
        this.f10399k.onSubscribe(dVar);
        long andSet = this.f10402n.getAndSet(0L);
        if (andSet != 0) {
            dVar.request(andSet);
        }
        B();
    }

    @Override // j.d.d
    public final void request(long j2) {
        j.deferredRequest(this.f10401m, this.f10402n, j2);
    }

    final f<T> x() {
        if (this.o != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    final f<T> y() {
        if (this.o == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    public final boolean z() {
        return this.f10401m.get() != null;
    }

    public f(long j2) {
        this(a.INSTANCE, j2);
    }

    public final f<T> a(g<? super f<T>> gVar) {
        try {
            gVar.accept(this);
            return this;
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    @Override // h.a.a1.a
    public final f<T> g() {
        if (this.f10401m.get() != null) {
            throw b("Subscribed!");
        }
        if (this.f10229c.isEmpty()) {
            return this;
        }
        throw b("Not subscribed but errors found");
    }

    @Override // h.a.a1.a
    public final f<T> i() {
        if (this.f10401m.get() != null) {
            return this;
        }
        throw b("Not subscribed!");
    }

    public f(j.d.c<? super T> cVar) {
        this(cVar, m0.f12222b);
    }

    public f(j.d.c<? super T> cVar, long j2) {
        if (j2 >= 0) {
            this.f10399k = cVar;
            this.f10401m = new AtomicReference<>();
            this.f10402n = new AtomicLong(j2);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }

    public final f<T> a(long j2) {
        request(j2);
        return this;
    }
}
