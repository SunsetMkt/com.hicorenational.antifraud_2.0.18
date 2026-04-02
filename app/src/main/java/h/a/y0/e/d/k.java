package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableAutoConnect.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k<T> extends h.a.b0<T> {
    final h.a.z0.a<? extends T> a;

    /* JADX INFO: renamed from: b */
    final int f11440b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.g<? super h.a.u0.c> f11441c;

    /* JADX INFO: renamed from: d */
    final AtomicInteger f11442d = new AtomicInteger();

    public k(h.a.z0.a<? extends T> aVar, int i2, h.a.x0.g<? super h.a.u0.c> gVar) {
        this.a = aVar;
        this.f11440b = i2;
        this.f11441c = gVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(i0Var);
        if (this.f11442d.incrementAndGet() == this.f11440b) {
            this.a.k(this.f11441c);
        }
    }
}
