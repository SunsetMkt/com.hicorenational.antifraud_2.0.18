package h.a.y0.e.d;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableWindow.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y3<T> extends h.a.y0.e.d.a<T, h.a.b0<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11722d;

    /* JADX INFO: compiled from: ObservableWindow.java */
    static final class a<T> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        final h.a.i0<? super h.a.b0<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        h.a.u0.c s;
        long size;
        h.a.f1.j<T> window;

        a(h.a.i0<? super h.a.b0<T>> i0Var, long j2, int i2) {
            this.actual = i0Var;
            this.count = j2;
            this.capacityHint = i2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.cancelled = true;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            h.a.f1.j<T> jVar = this.window;
            if (jVar != null) {
                this.window = null;
                jVar.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.f1.j<T> jVar = this.window;
            if (jVar != null) {
                this.window = null;
                jVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            h.a.f1.j<T> jVarA = this.window;
            if (jVarA == null && !this.cancelled) {
                jVarA = h.a.f1.j.a(this.capacityHint, (Runnable) this);
                this.window = jVarA;
                this.actual.onNext(jVarA);
            }
            if (jVarA != null) {
                jVarA.onNext(t);
                long j2 = this.size + 1;
                this.size = j2;
                if (j2 >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    jVarA.onComplete();
                    if (this.cancelled) {
                        this.s.dispose();
                    }
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.s.dispose();
            }
        }
    }

    /* JADX INFO: compiled from: ObservableWindow.java */
    static final class b<T> extends AtomicBoolean implements h.a.i0<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        final h.a.i0<? super h.a.b0<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        long firstEmission;
        long index;
        h.a.u0.c s;
        final long skip;
        final AtomicInteger wip = new AtomicInteger();
        final ArrayDeque<h.a.f1.j<T>> windows = new ArrayDeque<>();

        b(h.a.i0<? super h.a.b0<T>> i0Var, long j2, long j3, int i2) {
            this.actual = i0Var;
            this.count = j2;
            this.skip = j3;
            this.capacityHint = i2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.cancelled = true;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            ArrayDeque<h.a.f1.j<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            ArrayDeque<h.a.f1.j<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            ArrayDeque<h.a.f1.j<T>> arrayDeque = this.windows;
            long j2 = this.index;
            long j3 = this.skip;
            if (j2 % j3 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                h.a.f1.j<T> jVarA = h.a.f1.j.a(this.capacityHint, (Runnable) this);
                arrayDeque.offer(jVarA);
                this.actual.onNext(jVarA);
            }
            long j4 = this.firstEmission + 1;
            Iterator<h.a.f1.j<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j4 >= this.count) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.cancelled) {
                    this.s.dispose();
                    return;
                }
                this.firstEmission = j4 - j3;
            } else {
                this.firstEmission = j4;
            }
            this.index = j2 + 1;
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.s.dispose();
            }
        }
    }

    public y3(h.a.g0<T> g0Var, long j2, long j3, int i2) {
        super(g0Var);
        this.f11720b = j2;
        this.f11721c = j3;
        this.f11722d = i2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super h.a.b0<T>> i0Var) {
        long j2 = this.f11720b;
        long j3 = this.f11721c;
        if (j2 == j3) {
            this.a.subscribe(new a(i0Var, j2, this.f11722d));
        } else {
            this.a.subscribe(new b(i0Var, j2, j3, this.f11722d));
        }
    }
}
