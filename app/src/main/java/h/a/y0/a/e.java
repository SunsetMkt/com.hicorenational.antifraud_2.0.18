package h.a.y0.a;

import h.a.i0;
import h.a.n0;
import h.a.v;

/* JADX INFO: compiled from: EmptyDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public enum e implements h.a.y0.c.j<Object> {
    INSTANCE,
    NEVER;

    public static void complete(i0<?> i0Var) {
        i0Var.onSubscribe(INSTANCE);
        i0Var.onComplete();
    }

    public static void error(Throwable th, i0<?> i0Var) {
        i0Var.onSubscribe(INSTANCE);
        i0Var.onError(th);
    }

    @Override // h.a.y0.c.o
    public void clear() {
    }

    @Override // h.a.u0.c
    public void dispose() {
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this == INSTANCE;
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
    public Object poll() throws Exception {
        return null;
    }

    @Override // h.a.y0.c.k
    public int requestFusion(int i2) {
        return i2 & 2;
    }

    @Override // h.a.y0.c.o
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(v<?> vVar) {
        vVar.onSubscribe(INSTANCE);
        vVar.onComplete();
    }

    public static void error(Throwable th, h.a.f fVar) {
        fVar.onSubscribe(INSTANCE);
        fVar.onError(th);
    }

    public static void complete(h.a.f fVar) {
        fVar.onSubscribe(INSTANCE);
        fVar.onComplete();
    }

    public static void error(Throwable th, n0<?> n0Var) {
        n0Var.onSubscribe(INSTANCE);
        n0Var.onError(th);
    }

    public static void error(Throwable th, v<?> vVar) {
        vVar.onSubscribe(INSTANCE);
        vVar.onError(th);
    }
}
