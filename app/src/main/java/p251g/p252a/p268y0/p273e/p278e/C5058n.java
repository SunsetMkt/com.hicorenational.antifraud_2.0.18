package p251g.p252a.p268y0.p273e.p278e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelReduceFull.java */
/* renamed from: g.a.y0.e.e.n */
/* loaded from: classes2.dex */
public final class C5058n<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final AbstractC4471b<? extends T> f19654b;

    /* renamed from: c */
    final InterfaceC4572c<T, T, T> f19655c;

    /* compiled from: ParallelReduceFull.java */
    /* renamed from: g.a.y0.e.e.n$a */
    static final class a<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final b<T> parent;
        final InterfaceC4572c<T, T, T> reducer;
        T value;

        a(b<T> bVar, InterfaceC4572c<T, T, T> interfaceC4572c) {
            this.parent = bVar;
            this.reducer = interfaceC4572c;
        }

        void cancel() {
            EnumC5160j.cancel(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) C4601b.m18284a((Object) this.reducer.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                C4561b.m18199b(th);
                get().cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    /* compiled from: ParallelReduceFull.java */
    /* renamed from: g.a.y0.e.e.n$b */
    static final class b<T> extends C5156f<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<c<T>> current;
        final AtomicReference<Throwable> error;
        final InterfaceC4572c<T, T, T> reducer;
        final AtomicInteger remaining;
        final a<T>[] subscribers;

        b(InterfaceC5822c<? super T> interfaceC5822c, int i2, InterfaceC4572c<T, T, T> interfaceC4572c) {
            super(interfaceC5822c);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference<>();
            a<T>[] aVarArr = new a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = new a<>(this, interfaceC4572c);
            }
            this.subscribers = aVarArr;
            this.reducer = interfaceC4572c;
            this.remaining.lazySet(i2);
        }

        c<T> addValue(T t) {
            c<T> cVar;
            int tryAcquireSlot;
            while (true) {
                cVar = this.current.get();
                if (cVar == null) {
                    cVar = new c<>();
                    if (!this.current.compareAndSet(null, cVar)) {
                        continue;
                    }
                }
                tryAcquireSlot = cVar.tryAcquireSlot();
                if (tryAcquireSlot >= 0) {
                    break;
                }
                this.current.compareAndSet(cVar, null);
            }
            if (tryAcquireSlot == 0) {
                cVar.first = t;
            } else {
                cVar.second = t;
            }
            if (!cVar.releaseSlot()) {
                return null;
            }
            this.current.compareAndSet(cVar, null);
            return cVar;
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            for (a<T> aVar : this.subscribers) {
                aVar.cancel();
            }
        }

        void innerComplete(T t) {
            if (t != null) {
                while (true) {
                    c<T> addValue = addValue(t);
                    if (addValue == null) {
                        break;
                    }
                    try {
                        t = (T) C4601b.m18284a((Object) this.reducer.apply(addValue.first, addValue.second), "The reducer returned a null value");
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        innerError(th);
                        return;
                    }
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                c<T> cVar = this.current.get();
                this.current.lazySet(null);
                if (cVar != null) {
                    complete(cVar.first);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                cancel();
                this.actual.onError(th);
            } else if (th != this.error.get()) {
                C4476a.m17152b(th);
            }
        }
    }

    /* compiled from: ParallelReduceFull.java */
    /* renamed from: g.a.y0.e.e.n$c */
    static final class c<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        T second;

        c() {
        }

        boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }

        int tryAcquireSlot() {
            int i2;
            do {
                i2 = get();
                if (i2 >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i2, i2 + 1));
            return i2;
        }
    }

    public C5058n(AbstractC4471b<? extends T> abstractC4471b, InterfaceC4572c<T, T, T> interfaceC4572c) {
        this.f19654b = abstractC4471b;
        this.f19655c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        b bVar = new b(interfaceC5822c, this.f19654b.mo16967a(), this.f19655c);
        interfaceC5822c.onSubscribe(bVar);
        this.f19654b.mo16994a(bVar.subscribers);
    }
}
