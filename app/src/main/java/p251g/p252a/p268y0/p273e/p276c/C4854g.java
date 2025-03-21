package p251g.p252a.p268y0.p273e.p276c;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: MaybeConcatIterable.java */
/* renamed from: g.a.y0.e.c.g */
/* loaded from: classes2.dex */
public final class C4854g<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final Iterable<? extends InterfaceC4588y<? extends T>> f18610b;

    /* compiled from: MaybeConcatIterable.java */
    /* renamed from: g.a.y0.e.c.g$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4559v<T>, InterfaceC5823d {
        private static final long serialVersionUID = 3520831347801429610L;
        final InterfaceC5822c<? super T> actual;
        long produced;
        final Iterator<? extends InterfaceC4588y<? extends T>> sources;
        final AtomicLong requested = new AtomicLong();
        final C4599k disposables = new C4599k();
        final AtomicReference<Object> current = new AtomicReference<>(EnumC5177q.COMPLETE);

        a(InterfaceC5822c<? super T> interfaceC5822c, Iterator<? extends InterfaceC4588y<? extends T>> it) {
            this.actual = interfaceC5822c;
            this.sources = it;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<Object> atomicReference = this.current;
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            C4599k c4599k = this.disposables;
            while (!c4599k.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z = true;
                    if (obj != EnumC5177q.COMPLETE) {
                        long j2 = this.produced;
                        if (j2 != this.requested.get()) {
                            this.produced = j2 + 1;
                            atomicReference.lazySet(null);
                            interfaceC5822c.onNext(obj);
                        } else {
                            z = false;
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (z && !c4599k.isDisposed()) {
                        try {
                            if (this.sources.hasNext()) {
                                try {
                                    ((InterfaceC4588y) C4601b.m18284a(this.sources.next(), "The source Iterator returned a null MaybeSource")).mo18100a(this);
                                } catch (Throwable th) {
                                    C4561b.m18199b(th);
                                    interfaceC5822c.onError(th);
                                    return;
                                }
                            } else {
                                interfaceC5822c.onComplete();
                            }
                        } catch (Throwable th2) {
                            C4561b.m18199b(th2);
                            interfaceC5822c.onError(th2);
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.current.lazySet(EnumC5177q.COMPLETE);
            drain();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.disposables.replace(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }
    }

    public C4854g(Iterable<? extends InterfaceC4588y<? extends T>> iterable) {
        this.f18610b = iterable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        try {
            a aVar = new a(interfaceC5822c, (Iterator) C4601b.m18284a(this.f18610b.iterator(), "The sources Iterable returned a null Iterator"));
            interfaceC5822c.onSubscribe(aVar);
            aVar.drain();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
