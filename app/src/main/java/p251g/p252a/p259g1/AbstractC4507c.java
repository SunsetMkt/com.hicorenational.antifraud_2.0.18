package p251g.p252a.p259g1;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4597i;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5169i;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ResourceSubscriber.java */
/* renamed from: g.a.g1.c */
/* loaded from: classes2.dex */
public abstract class AbstractC4507c<T> implements InterfaceC4529q<T>, InterfaceC4552c {

    /* renamed from: a */
    private final AtomicReference<InterfaceC5823d> f17407a = new AtomicReference<>();

    /* renamed from: b */
    private final C4597i f17408b = new C4597i();

    /* renamed from: c */
    private final AtomicLong f17409c = new AtomicLong();

    /* renamed from: a */
    public final void m17385a(InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "resource is null");
        this.f17408b.mo18181b(interfaceC4552c);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        if (EnumC5160j.cancel(this.f17407a)) {
            this.f17408b.dispose();
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return EnumC5160j.isCancelled(this.f17407a.get());
    }

    @Override // p251g.p252a.InterfaceC4529q
    public final void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (C5169i.m18621a(this.f17407a, interfaceC5823d, (Class<?>) AbstractC4507c.class)) {
            long andSet = this.f17409c.getAndSet(0L);
            if (andSet != 0) {
                interfaceC5823d.request(andSet);
            }
            m17383a();
        }
    }

    /* renamed from: a */
    protected void m17383a() {
        m17384a(C5556m0.f20396b);
    }

    /* renamed from: a */
    protected final void m17384a(long j2) {
        EnumC5160j.deferredRequest(this.f17407a, this.f17409c, j2);
    }
}
