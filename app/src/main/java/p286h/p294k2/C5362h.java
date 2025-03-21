package p286h.p294k2;

import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p294k2.InterfaceC5361g;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutineContextImpl.kt */
/* renamed from: h.k2.h */
/* loaded from: classes2.dex */
public final class C5362h {
    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5817e
    /* renamed from: a */
    public static final <E extends InterfaceC5361g.b> E m22022a(@InterfaceC5816d InterfaceC5361g.b bVar, @InterfaceC5816d InterfaceC5361g.c<E> cVar) {
        C5544i0.m22546f(bVar, "$this$getPolymorphicElement");
        C5544i0.m22546f(cVar, "key");
        if (!(cVar instanceof AbstractC5356b)) {
            if (bVar.getKey() == cVar) {
                return bVar;
            }
            return null;
        }
        AbstractC5356b abstractC5356b = (AbstractC5356b) cVar;
        if (!abstractC5356b.m21996a(bVar.getKey())) {
            return null;
        }
        E e2 = (E) abstractC5356b.m21995a(bVar);
        if (e2 instanceof InterfaceC5361g.b) {
            return e2;
        }
        return null;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: b */
    public static final InterfaceC5361g m22023b(@InterfaceC5816d InterfaceC5361g.b bVar, @InterfaceC5816d InterfaceC5361g.c<?> cVar) {
        C5544i0.m22546f(bVar, "$this$minusPolymorphicKey");
        C5544i0.m22546f(cVar, "key");
        if (!(cVar instanceof AbstractC5356b)) {
            return bVar.getKey() == cVar ? C5363i.INSTANCE : bVar;
        }
        AbstractC5356b abstractC5356b = (AbstractC5356b) cVar;
        return (!abstractC5356b.m21996a(bVar.getKey()) || abstractC5356b.m21995a(bVar) == null) ? bVar : C5363i.INSTANCE;
    }
}
