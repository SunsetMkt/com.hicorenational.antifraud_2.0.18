package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeDefer.java */
/* renamed from: g.a.y0.e.c.k */
/* loaded from: classes2.dex */
public final class C4866k<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final Callable<? extends InterfaceC4588y<? extends T>> f18636a;

    public C4866k(Callable<? extends InterfaceC4588y<? extends T>> callable) {
        this.f18636a = callable;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        try {
            ((InterfaceC4588y) C4601b.m18284a(this.f18636a.call(), "The maybeSupplier returned a null MaybeSource")).mo18100a(interfaceC4559v);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4559v);
        }
    }
}
