package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p284j.EnumC5170j;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableConcatMapPublisher.java */
/* renamed from: g.a.y0.e.b.z */
/* loaded from: classes2.dex */
public final class C4831z<T, R> extends AbstractC4519l<R> {

    /* renamed from: b */
    final InterfaceC5821b<T> f18532b;

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> f18533c;

    /* renamed from: d */
    final int f18534d;

    /* renamed from: e */
    final EnumC5170j f18535e;

    public C4831z(InterfaceC5821b<T> interfaceC5821b, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, EnumC5170j enumC5170j) {
        this.f18532b = interfaceC5821b;
        this.f18533c = interfaceC4584o;
        this.f18534d = i2;
        this.f18535e = enumC5170j;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        if (C4708d3.m18317a(this.f18532b, interfaceC5822c, this.f18533c)) {
            return;
        }
        this.f18532b.subscribe(C4816w.m18397a(interfaceC5822c, this.f18533c, this.f18534d, this.f18535e));
    }
}
