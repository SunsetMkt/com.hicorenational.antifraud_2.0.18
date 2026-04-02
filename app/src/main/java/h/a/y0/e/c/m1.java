package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeToPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public enum m1 implements h.a.x0.o<h.a.y<Object>, j.d.b<Object>> {
    INSTANCE;

    public static <T> h.a.x0.o<h.a.y<T>, j.d.b<T>> instance() {
        return INSTANCE;
    }

    @Override // h.a.x0.o
    public j.d.b<Object> apply(h.a.y<Object> yVar) throws Exception {
        return new k1(yVar);
    }
}
