package p251g.p252a.p268y0.p273e.p274a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: CompletableConcatIterable.java */
/* renamed from: g.a.y0.e.a.e */
/* loaded from: classes2.dex */
public final class C4653e extends AbstractC4474c {

    /* renamed from: a */
    final Iterable<? extends InterfaceC4513i> f17651a;

    /* compiled from: CompletableConcatIterable.java */
    /* renamed from: g.a.y0.e.a.e$a */
    static final class a extends AtomicInteger implements InterfaceC4491f {
        private static final long serialVersionUID = -7965400327305809232L;
        final InterfaceC4491f actual;

        /* renamed from: sd */
        final C4599k f17652sd = new C4599k();
        final Iterator<? extends InterfaceC4513i> sources;

        a(InterfaceC4491f interfaceC4491f, Iterator<? extends InterfaceC4513i> it) {
            this.actual = interfaceC4491f;
            this.sources = it;
        }

        void next() {
            if (!this.f17652sd.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends InterfaceC4513i> it = this.sources;
                while (!this.f17652sd.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onComplete();
                            return;
                        }
                        try {
                            ((InterfaceC4513i) C4601b.m18284a(it.next(), "The CompletableSource returned is null")).mo17074a(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            this.actual.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        this.actual.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            next();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17652sd.replace(interfaceC4552c);
        }
    }

    public C4653e(Iterable<? extends InterfaceC4513i> iterable) {
        this.f17651a = iterable;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        try {
            a aVar = new a(interfaceC4491f, (Iterator) C4601b.m18284a(this.f17651a.iterator(), "The iterator returned is null"));
            interfaceC4491f.onSubscribe(aVar.f17652sd);
            aVar.next();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4491f);
        }
    }
}
