package h.a.y0.i;

import h.a.y0.c.l;

/* JADX INFO: compiled from: EmptySubscription.java */
/* JADX INFO: loaded from: classes2.dex */
public enum g implements l<Object> {
    INSTANCE;

    public static void complete(j.d.c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th, j.d.c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    @Override // j.d.d
    public void cancel() {
    }

    @Override // h.a.y0.c.o
    public void clear() {
    }

    @Override // h.a.y0.c.o
    public boolean isEmpty() {
        return true;
    }

    @Override // h.a.y0.c.o
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // h.a.y0.c.o
    @h.a.t0.g
    public Object poll() {
        return null;
    }

    @Override // j.d.d
    public void request(long j2) {
        j.validate(j2);
    }

    @Override // h.a.y0.c.k
    public int requestFusion(int i2) {
        return i2 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // h.a.y0.c.o
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
