package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableDefer.java */
/* renamed from: g.a.y0.e.b.f0 */
/* loaded from: classes2.dex */
public final class C4717f0<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final Callable<? extends InterfaceC5821b<? extends T>> f17871b;

    public C4717f0(Callable<? extends InterfaceC5821b<? extends T>> callable) {
        this.f17871b = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        try {
            ((InterfaceC5821b) C4601b.m18284a(this.f17871b.call(), "The publisher supplied is null")).subscribe(interfaceC5822c);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
