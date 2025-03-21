package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p275b.C4791r2;
import p324i.p338d.InterfaceC5821b;

/* compiled from: FlowableReduceWithSingle.java */
/* renamed from: g.a.y0.e.b.s2 */
/* loaded from: classes2.dex */
public final class C4797s2<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC5821b<T> f18391a;

    /* renamed from: b */
    final Callable<R> f18392b;

    /* renamed from: c */
    final InterfaceC4572c<R, ? super T, R> f18393c;

    public C4797s2(InterfaceC5821b<T> interfaceC5821b, Callable<R> callable, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        this.f18391a = interfaceC5821b;
        this.f18392b = callable;
        this.f18393c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        try {
            this.f18391a.subscribe(new C4791r2.a(interfaceC4524n0, this.f18393c, C4601b.m18284a(this.f18392b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }
}
