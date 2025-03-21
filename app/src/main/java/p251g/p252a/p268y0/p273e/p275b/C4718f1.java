package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p283i.C5156f;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableFromFuture.java */
/* renamed from: g.a.y0.e.b.f1 */
/* loaded from: classes2.dex */
public final class C4718f1<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final Future<? extends T> f17872b;

    /* renamed from: c */
    final long f17873c;

    /* renamed from: d */
    final TimeUnit f17874d;

    public C4718f1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.f17872b = future;
        this.f17873c = j2;
        this.f17874d = timeUnit;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C5156f c5156f = new C5156f(interfaceC5822c);
        interfaceC5822c.onSubscribe(c5156f);
        try {
            T t = this.f17874d != null ? this.f17872b.get(this.f17873c, this.f17874d) : this.f17872b.get();
            if (t == null) {
                interfaceC5822c.onError(new NullPointerException("The future returned null"));
            } else {
                c5156f.complete(t);
            }
        } catch (Throwable th) {
            C4561b.m18199b(th);
            if (c5156f.isCancelled()) {
                return;
            }
            interfaceC5822c.onError(th);
        }
    }
}
