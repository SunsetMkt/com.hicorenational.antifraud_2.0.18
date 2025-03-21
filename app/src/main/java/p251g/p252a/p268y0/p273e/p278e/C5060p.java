package p251g.p252a.p268y0.p273e.p278e;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.InterfaceC0000a;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelSortedJoin.java */
/* renamed from: g.a.y0.e.e.p */
/* loaded from: classes2.dex */
public final class C5060p<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final AbstractC4471b<List<T>> f19660b;

    /* renamed from: c */
    final Comparator<? super T> f19661c;

    /* compiled from: ParallelSortedJoin.java */
    /* renamed from: g.a.y0.e.e.p$a */
    static final class a<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final b<T> parent;

        a(b<T> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        void cancel() {
            EnumC5160j.cancel(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }
    }

    /* compiled from: ParallelSortedJoin.java */
    /* renamed from: g.a.y0.e.e.p$b */
    static final class b<T> extends AtomicInteger implements InterfaceC5823d {
        private static final long serialVersionUID = 3481980673745556697L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final int[] indexes;
        final List<T>[] lists;
        final a<T>[] subscribers;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        b(InterfaceC5822c<? super T> interfaceC5822c, int i2, Comparator<? super T> comparator) {
            this.actual = interfaceC5822c;
            this.comparator = comparator;
            a<T>[] aVarArr = new a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = new a<>(this, i3);
            }
            this.subscribers = aVarArr;
            this.lists = new List[i2];
            this.indexes = new int[i2];
            this.remaining.lazySet(i2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.lists, (Object) null);
            }
        }

        void cancelAll() {
            for (a<T> aVar : this.subscribers) {
                aVar.cancel();
            }
        }

        void drain() {
            boolean z;
            T t;
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i2 = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th = this.error.get();
                    if (th != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        interfaceC5822c.onError(th);
                        return;
                    }
                    InterfaceC0000a interfaceC0000a = null;
                    int i3 = -1;
                    for (int i4 = 0; i4 < length; i4++) {
                        List<T> list = listArr[i4];
                        int i5 = iArr[i4];
                        if (list.size() != i5) {
                            if (interfaceC0000a == null) {
                                t = list.get(i5);
                            } else {
                                t = list.get(i5);
                                try {
                                    if (!(this.comparator.compare(interfaceC0000a, t) > 0)) {
                                    }
                                } catch (Throwable th2) {
                                    C4561b.m18199b(th2);
                                    cancelAll();
                                    Arrays.fill(listArr, (Object) null);
                                    if (!this.error.compareAndSet(null, th2)) {
                                        C4476a.m17152b(th2);
                                    }
                                    interfaceC5822c.onError(this.error.get());
                                    return;
                                }
                            }
                            interfaceC0000a = (Object) t;
                            i3 = i4;
                        }
                    }
                    if (interfaceC0000a == null) {
                        Arrays.fill(listArr, (Object) null);
                        interfaceC5822c.onComplete();
                        return;
                    } else {
                        interfaceC5822c.onNext(interfaceC0000a);
                        iArr[i3] = iArr[i3] + 1;
                        j3++;
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th3 = this.error.get();
                    if (th3 != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        interfaceC5822c.onError(th3);
                        return;
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            z = true;
                            break;
                        } else {
                            if (iArr[i6] != listArr[i6].size()) {
                                z = false;
                                break;
                            }
                            i6++;
                        }
                    }
                    if (z) {
                        Arrays.fill(listArr, (Object) null);
                        interfaceC5822c.onComplete();
                        return;
                    }
                }
                if (j3 != 0 && j2 != C5556m0.f20396b) {
                    this.requested.addAndGet(-j3);
                }
                int i7 = get();
                if (i7 == i2 && (i7 = addAndGet(-i2)) == 0) {
                    return;
                } else {
                    i2 = i7;
                }
            }
        }

        void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                drain();
            } else if (th != this.error.get()) {
                C4476a.m17152b(th);
            }
        }

        void innerNext(List<T> list, int i2) {
            this.lists[i2] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }
    }

    public C5060p(AbstractC4471b<List<T>> abstractC4471b, Comparator<? super T> comparator) {
        this.f19660b = abstractC4471b;
        this.f19661c = comparator;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        b bVar = new b(interfaceC5822c, this.f19660b.mo16967a(), this.f19661c);
        interfaceC5822c.onSubscribe(bVar);
        this.f19660b.mo16994a(bVar.subscribers);
    }
}
