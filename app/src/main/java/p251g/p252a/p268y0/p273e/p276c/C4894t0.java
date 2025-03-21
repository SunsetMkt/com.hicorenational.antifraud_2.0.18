package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4569x;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeLift.java */
/* renamed from: g.a.y0.e.c.t0 */
/* loaded from: classes2.dex */
public final class C4894t0<T, R> extends AbstractC4836a<T, R> {

    /* renamed from: b */
    final InterfaceC4569x<? extends R, ? super T> f18708b;

    public C4894t0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4569x<? extends R, ? super T> interfaceC4569x) {
        super(interfaceC4588y);
        this.f18708b = interfaceC4569x;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        try {
            this.f18548a.mo18100a((InterfaceC4559v) C4601b.m18284a(this.f18708b.m18208a(interfaceC4559v), "The operator returned a null MaybeObserver"));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4559v);
        }
    }
}
