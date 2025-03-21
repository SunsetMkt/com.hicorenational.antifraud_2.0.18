package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableError.java */
/* renamed from: g.a.y0.e.b.u0 */
/* loaded from: classes2.dex */
public final class C4807u0<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final Callable<? extends Throwable> f18440b;

    public C4807u0(Callable<? extends Throwable> callable) {
        this.f18440b = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        try {
            th = (Throwable) C4601b.m18284a(this.f18440b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            C4561b.m18199b(th);
        }
        EnumC5157g.error(th, interfaceC5822c);
    }
}
