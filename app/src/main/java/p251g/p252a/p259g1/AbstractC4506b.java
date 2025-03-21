package p251g.p252a.p259g1;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5169i;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: DisposableSubscriber.java */
/* renamed from: g.a.g1.b */
/* loaded from: classes2.dex */
public abstract class AbstractC4506b<T> implements InterfaceC4529q<T>, InterfaceC4552c {

    /* renamed from: a */
    final AtomicReference<InterfaceC5823d> f17406a = new AtomicReference<>();

    /* renamed from: a */
    protected final void m17381a(long j2) {
        this.f17406a.get().request(j2);
    }

    /* renamed from: b */
    protected void m17382b() {
        this.f17406a.get().request(C5556m0.f20396b);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        EnumC5160j.cancel(this.f17406a);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return this.f17406a.get() == EnumC5160j.CANCELLED;
    }

    @Override // p251g.p252a.InterfaceC4529q
    public final void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (C5169i.m18621a(this.f17406a, interfaceC5823d, getClass())) {
            m17382b();
        }
    }

    /* renamed from: a */
    protected final void m17380a() {
        dispose();
    }
}
