package h.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableGenerate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j1<T, S> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<S> f10715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<S, h.a.k<T>, S> f10716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.g<? super S> f10717d;

    /* JADX INFO: compiled from: FlowableGenerate.java */
    static final class a<T, S> extends AtomicLong implements h.a.k<T>, j.d.d {
        private static final long serialVersionUID = 7565982551505011832L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        final h.a.x0.g<? super S> disposeState;
        final h.a.x0.c<S, ? super h.a.k<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        a(j.d.c<? super T> cVar, h.a.x0.c<S, ? super h.a.k<T>, S> cVar2, h.a.x0.g<? super S> gVar, S s) {
            this.actual = cVar;
            this.generator = cVar2;
            this.disposeState = gVar;
            this.state = s;
        }

        private void a(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (h.a.y0.j.d.a(this, 1L) == 0) {
                S s = this.state;
                this.state = null;
                a(s);
            }
        }

        @Override // h.a.k
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.actual.onComplete();
        }

        @Override // h.a.k
        public void onError(Throwable th) {
            if (this.terminate) {
                h.a.c1.a.b(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.actual.onError(th);
        }

        @Override // h.a.k
        public void onNext(T t) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.hasNext = true;
                this.actual.onNext(t);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
        
            r9.state = r0;
            r4 = addAndGet(-r10);
         */
        @Override // j.d.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2) && h.a.y0.j.d.a(this, j2) == 0) {
                S sApply = this.state;
                h.a.x0.c<S, ? super h.a.k<T>, S> cVar = this.generator;
                long jAddAndGet = j2;
                do {
                    long j3 = 0;
                    while (true) {
                        if (j3 == jAddAndGet) {
                            jAddAndGet = get();
                            if (j3 == jAddAndGet) {
                                break;
                            }
                        } else {
                            if (this.cancelled) {
                                this.state = null;
                                a(sApply);
                                return;
                            }
                            this.hasNext = false;
                            try {
                                sApply = cVar.apply(sApply, this);
                                if (this.terminate) {
                                    this.cancelled = true;
                                    this.state = null;
                                    a(sApply);
                                    return;
                                }
                                j3++;
                            } catch (Throwable th) {
                                h.a.v0.b.b(th);
                                this.cancelled = true;
                                this.state = null;
                                onError(th);
                                a(sApply);
                                return;
                            }
                        }
                    }
                } while (jAddAndGet != 0);
            }
        }
    }

    public j1(Callable<S> callable, h.a.x0.c<S, h.a.k<T>, S> cVar, h.a.x0.g<? super S> gVar) {
        this.f10715b = callable;
        this.f10716c = cVar;
        this.f10717d = gVar;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        try {
            cVar.onSubscribe(new a(cVar, this.f10716c, this.f10717d, this.f10715b.call()));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
