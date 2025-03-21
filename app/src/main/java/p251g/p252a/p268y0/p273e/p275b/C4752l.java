package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.LinkedBlockingQueue;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p282h.C5135f;
import p251g.p252a.p268y0.p282h.C5141l;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5166f;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableBlockingSubscribe.java */
/* renamed from: g.a.y0.e.b.l */
/* loaded from: classes2.dex */
public final class C4752l {
    private C4752l() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> void m18330a(InterfaceC5821b<? extends T> interfaceC5821b, InterfaceC5822c<? super T> interfaceC5822c) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        C5135f c5135f = new C5135f(linkedBlockingQueue);
        interfaceC5821b.subscribe(c5135f);
        while (!c5135f.isCancelled()) {
            try {
                Object poll = linkedBlockingQueue.poll();
                if (poll == null) {
                    if (c5135f.isCancelled()) {
                        return;
                    }
                    C5165e.m18612a();
                    poll = linkedBlockingQueue.take();
                }
                if (c5135f.isCancelled() || interfaceC5821b == C5135f.TERMINATED || EnumC5177q.acceptFull(poll, interfaceC5822c)) {
                    return;
                }
            } catch (InterruptedException e2) {
                c5135f.cancel();
                interfaceC5822c.onError(e2);
                return;
            }
        }
    }

    /* renamed from: a */
    public static <T> void m18328a(InterfaceC5821b<? extends T> interfaceC5821b) {
        C5166f c5166f = new C5166f();
        C5141l c5141l = new C5141l(C4600a.m18257d(), c5166f, c5166f, C4600a.f17524l);
        interfaceC5821b.subscribe(c5141l);
        C5165e.m18613a(c5166f, c5141l);
        Throwable th = c5166f.f20027a;
        if (th != null) {
            throw C5171k.m18626c(th);
        }
    }

    /* renamed from: a */
    public static <T> void m18329a(InterfaceC5821b<? extends T> interfaceC5821b, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4576g, "onNext is null");
        C4601b.m18284a(interfaceC4576g2, "onError is null");
        C4601b.m18284a(interfaceC4570a, "onComplete is null");
        m18330a(interfaceC5821b, new C5141l(interfaceC4576g, interfaceC4576g2, interfaceC4570a, C4600a.f17524l));
    }
}
