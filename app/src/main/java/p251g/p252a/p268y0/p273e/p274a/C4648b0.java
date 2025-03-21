package p251g.p252a.p268y0.p273e.p274a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p274a.C4646a0;
import p251g.p252a.p268y0.p284j.C5163c;

/* compiled from: CompletableMergeDelayErrorIterable.java */
/* renamed from: g.a.y0.e.a.b0 */
/* loaded from: classes2.dex */
public final class C4648b0 extends AbstractC4474c {

    /* renamed from: a */
    final Iterable<? extends InterfaceC4513i> f17643a;

    public C4648b0(Iterable<? extends InterfaceC4513i> iterable) {
        this.f17643a = iterable;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        C4551b c4551b = new C4551b();
        interfaceC4491f.onSubscribe(c4551b);
        try {
            Iterator it = (Iterator) C4601b.m18284a(this.f17643a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            C5163c c5163c = new C5163c();
            while (!c4551b.isDisposed()) {
                try {
                    if (it.hasNext()) {
                        if (c4551b.isDisposed()) {
                            return;
                        }
                        try {
                            InterfaceC4513i interfaceC4513i = (InterfaceC4513i) C4601b.m18284a(it.next(), "The iterator returned a null CompletableSource");
                            if (c4551b.isDisposed()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            interfaceC4513i.mo17074a(new C4646a0.a(interfaceC4491f, c4551b, c5163c, atomicInteger));
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            c5163c.addThrowable(th);
                        }
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    c5163c.addThrowable(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable terminate = c5163c.terminate();
                    if (terminate == null) {
                        interfaceC4491f.onComplete();
                        return;
                    } else {
                        interfaceC4491f.onError(terminate);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th3) {
            C4561b.m18199b(th3);
            interfaceC4491f.onError(th3);
        }
    }
}
