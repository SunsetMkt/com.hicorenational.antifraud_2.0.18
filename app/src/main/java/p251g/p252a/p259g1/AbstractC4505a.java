package p251g.p252a.p259g1;

import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5169i;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: DefaultSubscriber.java */
/* renamed from: g.a.g1.a */
/* loaded from: classes2.dex */
public abstract class AbstractC4505a<T> implements InterfaceC4529q<T> {

    /* renamed from: a */
    private InterfaceC5823d f17405a;

    /* renamed from: a */
    protected final void m17378a(long j2) {
        InterfaceC5823d interfaceC5823d = this.f17405a;
        if (interfaceC5823d != null) {
            interfaceC5823d.request(j2);
        }
    }

    /* renamed from: b */
    protected void m17379b() {
        m17378a(C5556m0.f20396b);
    }

    @Override // p251g.p252a.InterfaceC4529q
    public final void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (C5169i.m18619a(this.f17405a, interfaceC5823d, getClass())) {
            this.f17405a = interfaceC5823d;
            m17379b();
        }
    }

    /* renamed from: a */
    protected final void m17377a() {
        InterfaceC5823d interfaceC5823d = this.f17405a;
        this.f17405a = EnumC5160j.CANCELLED;
        interfaceC5823d.cancel();
    }
}
