package h.a.b1;

import h.a.t0.e;

/* JADX INFO: compiled from: ParallelFailureHandling.java */
/* JADX INFO: loaded from: classes2.dex */
@e
public enum a implements h.a.x0.c<Long, Throwable, a> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // h.a.x0.c
    public a apply(Long l2, Throwable th) {
        return this;
    }
}
