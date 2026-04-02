package h.a.a1;

import h.a.i0;
import h.a.n0;
import h.a.v;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: TestObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public class n<T> extends h.a.a1.a<T, n<T>> implements i0<T>, h.a.u0.c, v<T>, n0<T>, h.a.f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final i0<? super T> f10249k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicReference<h.a.u0.c> f10250l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private h.a.y0.c.j<T> f10251m;

    /* JADX INFO: compiled from: TestObserver.java */
    enum a implements i0<Object> {
        INSTANCE;

        @Override // h.a.i0
        public void onComplete() {
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
        }

        @Override // h.a.i0
        public void onNext(Object obj) {
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
        }
    }

    public n() {
        this(a.INSTANCE);
    }

    public static <T> n<T> B() {
        return new n<>();
    }

    public static <T> n<T> a(i0<? super T> i0Var) {
        return new n<>(i0Var);
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
        return isDisposed();
    }

    final n<T> c(int i2) {
        int i3 = this.f10234h;
        if (i3 == i2) {
            return this;
        }
        if (this.f10251m == null) {
            throw b("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + e(i2) + ", actual: " + e(i3));
    }

    public final void cancel() {
        dispose();
    }

    final n<T> d(int i2) {
        this.f10233g = i2;
        return this;
    }

    @Override // h.a.u0.c
    public final void dispose() {
        h.a.y0.a.d.dispose(this.f10250l);
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return h.a.y0.a.d.isDisposed(this.f10250l.get());
    }

    @Override // h.a.i0
    public void onComplete() {
        if (!this.f10232f) {
            this.f10232f = true;
            if (this.f10250l.get() == null) {
                this.f10229c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f10231e = Thread.currentThread();
            this.f10230d++;
            this.f10249k.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (!this.f10232f) {
            this.f10232f = true;
            if (this.f10250l.get() == null) {
                this.f10229c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f10231e = Thread.currentThread();
            if (th == null) {
                this.f10229c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f10229c.add(th);
            }
            this.f10249k.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (!this.f10232f) {
            this.f10232f = true;
            if (this.f10250l.get() == null) {
                this.f10229c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f10231e = Thread.currentThread();
        if (this.f10234h != 2) {
            this.f10228b.add(t);
            if (t == null) {
                this.f10229c.add(new NullPointerException("onNext received a null value"));
            }
            this.f10249k.onNext(t);
            return;
        }
        while (true) {
            try {
                T tPoll = this.f10251m.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f10228b.add(tPoll);
                }
            } catch (Throwable th) {
                this.f10229c.add(th);
                this.f10251m.dispose();
                return;
            }
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        this.f10231e = Thread.currentThread();
        if (cVar == null) {
            this.f10229c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.f10250l.compareAndSet(null, cVar)) {
            cVar.dispose();
            if (this.f10250l.get() != h.a.y0.a.d.DISPOSED) {
                this.f10229c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + cVar));
                return;
            }
            return;
        }
        int i2 = this.f10233g;
        if (i2 != 0 && (cVar instanceof h.a.y0.c.j)) {
            this.f10251m = (h.a.y0.c.j) cVar;
            int iRequestFusion = this.f10251m.requestFusion(i2);
            this.f10234h = iRequestFusion;
            if (iRequestFusion == 1) {
                this.f10232f = true;
                this.f10231e = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.f10251m.poll();
                        if (tPoll == null) {
                            this.f10230d++;
                            this.f10250l.lazySet(h.a.y0.a.d.DISPOSED);
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
        this.f10249k.onSubscribe(cVar);
    }

    @Override // h.a.v, h.a.n0
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    final n<T> x() {
        if (this.f10251m != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    final n<T> y() {
        if (this.f10251m == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    public final boolean z() {
        return this.f10250l.get() != null;
    }

    public n(i0<? super T> i0Var) {
        this.f10250l = new AtomicReference<>();
        this.f10249k = i0Var;
    }

    public final n<T> a(h.a.x0.g<? super n<T>> gVar) {
        try {
            gVar.accept(this);
            return this;
        } catch (Throwable th) {
            throw h.a.y0.j.k.c(th);
        }
    }

    @Override // h.a.a1.a
    public final n<T> g() {
        if (this.f10250l.get() != null) {
            throw b("Subscribed!");
        }
        if (this.f10229c.isEmpty()) {
            return this;
        }
        throw b("Not subscribed but errors found");
    }

    @Override // h.a.a1.a
    public final n<T> i() {
        if (this.f10250l.get() != null) {
            return this;
        }
        throw b("Not subscribed!");
    }
}
