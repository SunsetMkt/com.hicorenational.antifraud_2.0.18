package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.LinkedBlockingQueue;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.C4627i;
import p251g.p252a.p268y0.p272d.C4640v;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5166f;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: ObservableBlockingSubscribe.java */
/* renamed from: g.a.y0.e.d.l */
/* loaded from: classes2.dex */
public final class C4970l {
    private C4970l() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> void m18458a(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4514i0<? super T> interfaceC4514i0) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        C4627i c4627i = new C4627i(linkedBlockingQueue);
        interfaceC4514i0.onSubscribe(c4627i);
        interfaceC4504g0.subscribe(c4627i);
        while (!c4627i.isDisposed()) {
            Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (InterruptedException e2) {
                    c4627i.dispose();
                    interfaceC4514i0.onError(e2);
                    return;
                }
            }
            if (c4627i.isDisposed() || interfaceC4504g0 == C4627i.TERMINATED || EnumC5177q.acceptFull(poll, interfaceC4514i0)) {
                return;
            }
        }
    }

    /* renamed from: a */
    public static <T> void m18457a(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C5166f c5166f = new C5166f();
        C4640v c4640v = new C4640v(C4600a.m18257d(), c5166f, c5166f, C4600a.m18257d());
        interfaceC4504g0.subscribe(c4640v);
        C5165e.m18613a(c5166f, c4640v);
        Throwable th = c5166f.f20027a;
        if (th != null) {
            throw C5171k.m18626c(th);
        }
    }

    /* renamed from: a */
    public static <T> void m18459a(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4576g, "onNext is null");
        C4601b.m18284a(interfaceC4576g2, "onError is null");
        C4601b.m18284a(interfaceC4570a, "onComplete is null");
        m18458a(interfaceC4504g0, new C4640v(interfaceC4576g, interfaceC4576g2, interfaceC4570a, C4600a.m18257d()));
    }
}
