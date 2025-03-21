package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4609h;
import p324i.p338d.InterfaceC5821b;

/* compiled from: AbstractFlowableWithUpstream.java */
/* renamed from: g.a.y0.e.b.a */
/* loaded from: classes2.dex */
abstract class AbstractC4686a<T, R> extends AbstractC4519l<R> implements InterfaceC4609h<T> {

    /* renamed from: b */
    protected final AbstractC4519l<T> f17759b;

    AbstractC4686a(AbstractC4519l<T> abstractC4519l) {
        this.f17759b = (AbstractC4519l) C4601b.m18284a(abstractC4519l, "source is null");
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4609h
    public final InterfaceC5821b<T> source() {
        return this.f17759b;
    }
}
