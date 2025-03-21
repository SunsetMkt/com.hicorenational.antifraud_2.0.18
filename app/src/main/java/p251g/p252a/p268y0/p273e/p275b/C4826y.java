package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p273e.p275b.C4821x;
import p251g.p252a.p268y0.p284j.EnumC5170j;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableConcatMapEagerPublisher.java */
/* renamed from: g.a.y0.e.b.y */
/* loaded from: classes2.dex */
public final class C4826y<T, R> extends AbstractC4519l<R> {

    /* renamed from: b */
    final InterfaceC5821b<T> f18515b;

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> f18516c;

    /* renamed from: d */
    final int f18517d;

    /* renamed from: e */
    final int f18518e;

    /* renamed from: f */
    final EnumC5170j f18519f;

    public C4826y(InterfaceC5821b<T> interfaceC5821b, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, int i3, EnumC5170j enumC5170j) {
        this.f18515b = interfaceC5821b;
        this.f18516c = interfaceC4584o;
        this.f18517d = i2;
        this.f18518e = i3;
        this.f18519f = enumC5170j;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        this.f18515b.subscribe(new C4821x.a(interfaceC5822c, this.f18516c, this.f18517d, this.f18518e, this.f18519f));
    }
}
