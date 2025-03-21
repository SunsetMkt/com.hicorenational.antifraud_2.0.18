package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.C4553d;

/* compiled from: MaybeError.java */
/* renamed from: g.a.y0.e.c.v */
/* loaded from: classes2.dex */
public final class C4897v<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final Throwable f18716a;

    public C4897v(Throwable th) {
        this.f18716a = th;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        interfaceC4559v.onSubscribe(C4553d.m18183a());
        interfaceC4559v.onError(this.f18716a);
    }
}
