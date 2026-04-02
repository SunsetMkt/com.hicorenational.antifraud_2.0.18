package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableAutoConnect.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b */
    final h.a.w0.a<? extends T> f10727b;

    /* JADX INFO: renamed from: c */
    final int f10728c;

    /* JADX INFO: renamed from: d */
    final h.a.x0.g<? super h.a.u0.c> f10729d;

    /* JADX INFO: renamed from: e */
    final AtomicInteger f10730e = new AtomicInteger();

    public k(h.a.w0.a<? extends T> aVar, int i2, h.a.x0.g<? super h.a.u0.c> gVar) {
        this.f10727b = aVar;
        this.f10728c = i2;
        this.f10729d = gVar;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        this.f10727b.subscribe(cVar);
        if (this.f10730e.incrementAndGet() == this.f10728c) {
            this.f10727b.l(this.f10729d);
        }
    }
}
