package h.a.y0.e.b;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableOnBackpressureBufferStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.a f10653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.a f10654e;

    /* JADX INFO: compiled from: FlowableOnBackpressureBufferStrategy.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[h.a.a.values().length];

        static {
            try {
                a[h.a.a.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.a.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: FlowableOnBackpressureBufferStrategy.java */
    static final class b<T> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 3240706908776709697L;
        final j.d.c<? super T> actual;
        final long bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final h.a.x0.a onOverflow;
        j.d.d s;
        final h.a.a strategy;
        final AtomicLong requested = new AtomicLong();
        final Deque<T> deque = new ArrayDeque();

        b(j.d.c<? super T> cVar, h.a.x0.a aVar, h.a.a aVar2, long j2) {
            this.actual = cVar;
            this.onOverflow = aVar;
            this.strategy = aVar2;
            this.bufferSize = j2;
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                clear(this.deque);
            }
        }

        void clear(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        void drain() {
            boolean zIsEmpty;
            T tPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            Deque<T> deque = this.deque;
            j.d.c<? super T> cVar = this.actual;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        clear(deque);
                        return;
                    }
                    boolean z = this.done;
                    synchronized (deque) {
                        tPoll = deque.poll();
                    }
                    boolean z2 = tPoll == null;
                    if (z) {
                        Throwable th = this.error;
                        if (th != null) {
                            clear(deque);
                            cVar.onError(th);
                            return;
                        } else if (z2) {
                            cVar.onComplete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(tPoll);
                    j3++;
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        clear(deque);
                        return;
                    }
                    boolean z3 = this.done;
                    synchronized (deque) {
                        zIsEmpty = deque.isEmpty();
                    }
                    if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            clear(deque);
                            cVar.onError(th2);
                            return;
                        } else if (zIsEmpty) {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    h.a.y0.j.d.c(this.requested, j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onNext(T t) {
            boolean z;
            boolean z2;
            if (this.done) {
                return;
            }
            Deque<T> deque = this.deque;
            synchronized (deque) {
                z = false;
                z2 = true;
                if (deque.size() == this.bufferSize) {
                    int i2 = a.a[this.strategy.ordinal()];
                    if (i2 == 1) {
                        deque.pollLast();
                        deque.offer(t);
                    } else if (i2 == 2) {
                        deque.poll();
                        deque.offer(t);
                    }
                    z = true;
                } else {
                    deque.offer(t);
                }
                z2 = false;
            }
            if (!z) {
                if (!z2) {
                    drain();
                    return;
                } else {
                    this.s.cancel();
                    onError(new h.a.v0.c());
                    return;
                }
            }
            h.a.x0.a aVar = this.onOverflow;
            if (aVar != null) {
                try {
                    aVar.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public f2(h.a.l<T> lVar, long j2, h.a.x0.a aVar, h.a.a aVar2) {
        super(lVar);
        this.f10652c = j2;
        this.f10653d = aVar;
        this.f10654e = aVar2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new b(cVar, this.f10653d, this.f10654e, this.f10652c));
    }
}
