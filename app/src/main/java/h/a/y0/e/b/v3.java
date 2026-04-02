package h.a.y0.e.b;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableTakeLast.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f11023c;

    /* JADX INFO: compiled from: FlowableTakeLast.java */
    static final class a<T> extends ArrayDeque<T> implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 7240042530241604978L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        final int count;
        volatile boolean done;
        j.d.d s;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        a(j.d.c<? super T> cVar, int i2) {
            this.actual = cVar;
            this.count = i2;
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                j.d.c<? super T> cVar = this.actual;
                long jAddAndGet = this.requested.get();
                while (!this.cancelled) {
                    if (this.done) {
                        long j2 = 0;
                        while (j2 != jAddAndGet) {
                            if (this.cancelled) {
                                return;
                            }
                            T tPoll = poll();
                            if (tPoll == null) {
                                cVar.onComplete();
                                return;
                            } else {
                                cVar.onNext(tPoll);
                                j2++;
                            }
                        }
                        if (j2 != 0 && jAddAndGet != i.q2.t.m0.f12222b) {
                            jAddAndGet = this.requested.addAndGet(-j2);
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
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

    public v3(h.a.l<T> lVar, int i2) {
        super(lVar);
        this.f11023c = i2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f11023c));
    }
}
