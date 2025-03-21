package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: CompletableDefer.java */
/* renamed from: g.a.y0.e.a.g */
/* loaded from: classes2.dex */
public final class C4657g extends AbstractC4474c {

    /* renamed from: a */
    final Callable<? extends InterfaceC4513i> f17660a;

    public C4657g(Callable<? extends InterfaceC4513i> callable) {
        this.f17660a = callable;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        try {
            ((InterfaceC4513i) C4601b.m18284a(this.f17660a.call(), "The completableSupplier returned a null CompletableSource")).mo17074a(interfaceC4491f);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4491f);
        }
    }
}
