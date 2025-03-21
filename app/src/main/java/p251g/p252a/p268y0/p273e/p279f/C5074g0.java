package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4528p0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleLift.java */
/* renamed from: g.a.y0.e.f.g0 */
/* loaded from: classes2.dex */
public final class C5074g0<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19710a;

    /* renamed from: b */
    final InterfaceC4528p0<? extends R, ? super T> f19711b;

    public C5074g0(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4528p0<? extends R, ? super T> interfaceC4528p0) {
        this.f19710a = interfaceC4530q0;
        this.f19711b = interfaceC4528p0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        try {
            this.f19710a.mo17490a((InterfaceC4524n0) C4601b.m18284a(this.f19711b.m18006a(interfaceC4524n0), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }
}
