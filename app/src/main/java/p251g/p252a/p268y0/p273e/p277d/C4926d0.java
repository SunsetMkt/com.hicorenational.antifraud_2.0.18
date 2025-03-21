package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableDefer.java */
/* renamed from: g.a.y0.e.d.d0 */
/* loaded from: classes2.dex */
public final class C4926d0<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final Callable<? extends InterfaceC4504g0<? extends T>> f18889a;

    public C4926d0(Callable<? extends InterfaceC4504g0<? extends T>> callable) {
        this.f18889a = callable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        try {
            ((InterfaceC4504g0) C4601b.m18284a(this.f18889a.call(), "null ObservableSource supplied")).subscribe(interfaceC4514i0);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4514i0);
        }
    }
}
