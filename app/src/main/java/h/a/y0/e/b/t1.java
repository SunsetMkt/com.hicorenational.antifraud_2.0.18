package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableJust.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t1<T> extends h.a.l<T> implements h.a.y0.c.m<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f10986b;

    public t1(T t) {
        this.f10986b = t;
    }

    @Override // h.a.y0.c.m, java.util.concurrent.Callable
    public T call() {
        return this.f10986b;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        cVar.onSubscribe(new h.a.y0.i.h(cVar, this.f10986b));
    }
}
