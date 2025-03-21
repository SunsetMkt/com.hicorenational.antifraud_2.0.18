package p251g.p252a.p268y0.p282h;

import java.util.concurrent.CountDownLatch;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: BlockingBaseSubscriber.java */
/* renamed from: g.a.y0.h.c */
/* loaded from: classes2.dex */
public abstract class AbstractC5132c<T> extends CountDownLatch implements InterfaceC4529q<T> {

    /* renamed from: a */
    T f19958a;

    /* renamed from: b */
    Throwable f19959b;

    /* renamed from: c */
    InterfaceC5823d f19960c;

    /* renamed from: d */
    volatile boolean f19961d;

    public AbstractC5132c() {
        super(1);
    }

    /* renamed from: a */
    public final T m18589a() {
        if (getCount() != 0) {
            try {
                C5165e.m18612a();
                await();
            } catch (InterruptedException e2) {
                InterfaceC5823d interfaceC5823d = this.f19960c;
                this.f19960c = EnumC5160j.CANCELLED;
                if (interfaceC5823d != null) {
                    interfaceC5823d.cancel();
                }
                throw C5171k.m18626c(e2);
            }
        }
        Throwable th = this.f19959b;
        if (th == null) {
            return this.f19958a;
        }
        throw C5171k.m18626c(th);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public final void onComplete() {
        countDown();
    }

    @Override // p251g.p252a.InterfaceC4529q
    public final void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.validate(this.f19960c, interfaceC5823d)) {
            this.f19960c = interfaceC5823d;
            if (this.f19961d) {
                return;
            }
            interfaceC5823d.request(C5556m0.f20396b);
            if (this.f19961d) {
                this.f19960c = EnumC5160j.CANCELLED;
                interfaceC5823d.cancel();
            }
        }
    }
}
