package h.a.y0.h;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SinglePostCompleteSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s<T, R> extends AtomicLong implements h.a.q<T>, j.d.d {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final j.d.c<? super R> actual;
    protected long produced;
    protected j.d.d s;
    protected R value;

    public s(j.d.c<? super R> cVar) {
        this.actual = cVar;
    }

    @Override // j.d.d
    public void cancel() {
        this.s.cancel();
    }

    protected final void complete(R r) {
        long j2 = this.produced;
        if (j2 != 0) {
            h.a.y0.j.d.c(this, j2);
        }
        while (true) {
            long j3 = get();
            if ((j3 & Long.MIN_VALUE) != 0) {
                onDrop(r);
                return;
            }
            if ((j3 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.actual.onNext(r);
                this.actual.onComplete();
                return;
            } else {
                this.value = r;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                } else {
                    this.value = null;
                }
            }
        }
    }

    protected void onDrop(R r) {
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // j.d.d
    public final void request(long j2) {
        long j3;
        if (h.a.y0.i.j.validate(j2)) {
            do {
                j3 = get();
                if ((j3 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.actual.onNext(this.value);
                        this.actual.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j3, h.a.y0.j.d.a(j3, j2)));
            this.s.request(j2);
        }
    }
}
