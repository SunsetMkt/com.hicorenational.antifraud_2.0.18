package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleDefer.java */
/* renamed from: g.a.y0.e.f.e */
/* loaded from: classes2.dex */
public final class C5069e<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final Callable<? extends InterfaceC4530q0<? extends T>> f19689a;

    public C5069e(Callable<? extends InterfaceC4530q0<? extends T>> callable) {
        this.f19689a = callable;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        try {
            ((InterfaceC4530q0) C4601b.m18284a(this.f19689a.call(), "The singleSupplier returned a null SingleSource")).mo17490a(interfaceC4524n0);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }
}
