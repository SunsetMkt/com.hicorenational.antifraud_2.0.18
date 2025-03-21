package p251g.p252a.p268y0.p273e.p274a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: CompletableMergeIterable.java */
/* renamed from: g.a.y0.e.a.c0 */
/* loaded from: classes2.dex */
public final class C4650c0 extends AbstractC4474c {

    /* renamed from: a */
    final Iterable<? extends InterfaceC4513i> f17647a;

    /* compiled from: CompletableMergeIterable.java */
    /* renamed from: g.a.y0.e.a.c0$a */
    static final class a extends AtomicBoolean implements InterfaceC4491f {
        private static final long serialVersionUID = -7730517613164279224L;
        final InterfaceC4491f actual;
        final C4551b set;
        final AtomicInteger wip;

        a(InterfaceC4491f interfaceC4491f, C4551b c4551b, AtomicInteger atomicInteger) {
            this.actual = interfaceC4491f;
            this.set = c4551b;
            this.wip = atomicInteger;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.set.dispose();
            if (compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.set.mo18181b(interfaceC4552c);
        }
    }

    public C4650c0(Iterable<? extends InterfaceC4513i> iterable) {
        this.f17647a = iterable;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        C4551b c4551b = new C4551b();
        interfaceC4491f.onSubscribe(c4551b);
        try {
            Iterator it = (Iterator) C4601b.m18284a(this.f17647a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            a aVar = new a(interfaceC4491f, c4551b, atomicInteger);
            while (!c4551b.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        aVar.onComplete();
                        return;
                    }
                    if (c4551b.isDisposed()) {
                        return;
                    }
                    try {
                        InterfaceC4513i interfaceC4513i = (InterfaceC4513i) C4601b.m18284a(it.next(), "The iterator returned a null CompletableSource");
                        if (c4551b.isDisposed()) {
                            return;
                        }
                        atomicInteger.getAndIncrement();
                        interfaceC4513i.mo17074a(aVar);
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        c4551b.dispose();
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    c4551b.dispose();
                    aVar.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            C4561b.m18199b(th3);
            interfaceC4491f.onError(th3);
        }
    }
}
