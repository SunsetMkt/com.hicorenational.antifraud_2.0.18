package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: CompletableErrorSupplier.java */
/* renamed from: g.a.y0.e.a.o */
/* loaded from: classes2.dex */
public final class C4673o extends AbstractC4474c {

    /* renamed from: a */
    final Callable<? extends Throwable> f17732a;

    public C4673o(Callable<? extends Throwable> callable) {
        this.f17732a = callable;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        try {
            th = (Throwable) C4601b.m18284a(this.f17732a.call(), "The error returned is null");
        } catch (Throwable th) {
            th = th;
            C4561b.m18199b(th);
        }
        EnumC4593e.error(th, interfaceC4491f);
    }
}
