package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableError.java */
/* renamed from: g.a.y0.e.d.s0 */
/* loaded from: classes2.dex */
public final class C5006s0<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f19372a;

    public C5006s0(Callable<? extends Throwable> callable) {
        this.f19372a = callable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        try {
            th = (Throwable) C4601b.m18284a(this.f19372a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            C4561b.m18199b(th);
        }
        EnumC4593e.error(th, interfaceC4514i0);
    }
}
