package h.a.y0.e.b;

import h.a.y0.e.b.u3;

/* JADX INFO: compiled from: FlowableTakePublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y3<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<T> f11075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11076c;

    public y3(j.d.b<T> bVar, long j2) {
        this.f11075b = bVar;
        this.f11076c = j2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f11075b.subscribe(new u3.a(cVar, this.f11076c));
    }
}
