package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p277d.C4946g2;

/* compiled from: ObservableReduceWithSingle.java */
/* renamed from: g.a.y0.e.d.h2 */
/* loaded from: classes2.dex */
public final class C4952h2<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19041a;

    /* renamed from: b */
    final Callable<R> f19042b;

    /* renamed from: c */
    final InterfaceC4572c<R, ? super T, R> f19043c;

    public C4952h2(InterfaceC4504g0<T> interfaceC4504g0, Callable<R> callable, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        this.f19041a = interfaceC4504g0;
        this.f19042b = callable;
        this.f19043c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        try {
            this.f19041a.subscribe(new C4946g2.a(interfaceC4524n0, this.f19043c, C4601b.m18284a(this.f19042b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }
}
