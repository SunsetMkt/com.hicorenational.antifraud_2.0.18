package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleError.java */
/* renamed from: g.a.y0.e.f.u */
/* loaded from: classes2.dex */
public final class C5101u<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f19801a;

    public C5101u(Callable<? extends Throwable> callable) {
        this.f19801a = callable;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        try {
            th = (Throwable) C4601b.m18284a(this.f19801a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            C4561b.m18199b(th);
        }
        EnumC4593e.error(th, interfaceC4524n0);
    }
}
