package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p268y0.p271c.InterfaceC4607f;

/* compiled from: AbstractMaybeWithUpstream.java */
/* renamed from: g.a.y0.e.c.a */
/* loaded from: classes2.dex */
abstract class AbstractC4836a<T, R> extends AbstractC4533s<R> implements InterfaceC4607f<T> {

    /* renamed from: a */
    protected final InterfaceC4588y<T> f18548a;

    AbstractC4836a(InterfaceC4588y<T> interfaceC4588y) {
        this.f18548a = interfaceC4588y;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4607f
    public final InterfaceC4588y<T> source() {
        return this.f18548a;
    }
}
