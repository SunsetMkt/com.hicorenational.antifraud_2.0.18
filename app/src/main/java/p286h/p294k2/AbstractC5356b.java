package p286h.p294k2;

import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p294k2.InterfaceC5361g;
import p286h.p294k2.InterfaceC5361g.b;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutineContextImpl.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5339j
/* renamed from: h.k2.b */
/* loaded from: classes2.dex */
public abstract class AbstractC5356b<B extends InterfaceC5361g.b, E extends B> implements InterfaceC5361g.c<E> {

    /* renamed from: a */
    private final InterfaceC5361g.c<?> f20230a;

    /* renamed from: b */
    private final InterfaceC5506l<InterfaceC5361g.b, E> f20231b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [h.k2.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [h.q2.s.l<? super h.k2.g$b, ? extends E extends B>, h.q2.s.l<h.k2.g$b, E extends B>, java.lang.Object] */
    public AbstractC5356b(@InterfaceC5816d InterfaceC5361g.c<B> cVar, @InterfaceC5816d InterfaceC5506l<? super InterfaceC5361g.b, ? extends E> interfaceC5506l) {
        C5544i0.m22546f(cVar, "baseKey");
        C5544i0.m22546f(interfaceC5506l, "safeCast");
        this.f20231b = interfaceC5506l;
        this.f20230a = cVar instanceof AbstractC5356b ? (InterfaceC5361g.c<B>) ((AbstractC5356b) cVar).f20230a : cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lh/k2/g$b;)TE; */
    @InterfaceC5817e
    /* renamed from: a */
    public final InterfaceC5361g.b m21995a(@InterfaceC5816d InterfaceC5361g.b bVar) {
        C5544i0.m22546f(bVar, "element");
        return (InterfaceC5361g.b) this.f20231b.invoke(bVar);
    }

    /* renamed from: a */
    public final boolean m21996a(@InterfaceC5816d InterfaceC5361g.c<?> cVar) {
        C5544i0.m22546f(cVar, "key");
        return cVar == this || this.f20230a == cVar;
    }
}
