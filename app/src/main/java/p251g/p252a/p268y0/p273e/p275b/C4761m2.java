package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5182v;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowablePublishMulticast.java */
/* renamed from: g.a.y0.e.b.m2 */
/* loaded from: classes2.dex */
public final class C4761m2<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4584o<? super AbstractC4519l<T>, ? extends InterfaceC5821b<? extends R>> f18064c;

    /* renamed from: d */
    final int f18065d;

    /* renamed from: e */
    final boolean f18066e;

    /* compiled from: FlowablePublishMulticast.java */
    /* renamed from: g.a.y0.e.b.m2$b */
    static final class b<T> extends AtomicLong implements InterfaceC5823d {
        private static final long serialVersionUID = 8664815189257569791L;
        final InterfaceC5822c<? super T> actual;
        final a<T> parent;

        b(InterfaceC5822c<? super T> interfaceC5822c, a<T> aVar) {
            this.actual = interfaceC5822c;
            this.parent = aVar;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.m18335b((b) this);
                this.parent.m18333U();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18609b(this, j2);
                this.parent.m18333U();
            }
        }
    }

    /* compiled from: FlowablePublishMulticast.java */
    /* renamed from: g.a.y0.e.b.m2$c */
    static final class c<R> implements InterfaceC4529q<R>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super R> f18080a;

        /* renamed from: b */
        final a<?> f18081b;

        /* renamed from: c */
        InterfaceC5823d f18082c;

        c(InterfaceC5822c<? super R> interfaceC5822c, a<?> aVar) {
            this.f18080a = interfaceC5822c;
            this.f18081b = aVar;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18082c.cancel();
            this.f18081b.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18080a.onComplete();
            this.f18081b.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18080a.onError(th);
            this.f18081b.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(R r) {
            this.f18080a.onNext(r);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18082c, interfaceC5823d)) {
                this.f18082c = interfaceC5823d;
                this.f18080a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f18082c.request(j2);
        }
    }

    public C4761m2(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super AbstractC4519l<T>, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, boolean z) {
        super(abstractC4519l);
        this.f18064c = interfaceC4584o;
        this.f18065d = i2;
        this.f18066e = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        a aVar = new a(this.f18065d, this.f18066e);
        try {
            ((InterfaceC5821b) C4601b.m18284a(this.f18064c.apply(aVar), "selector returned a null Publisher")).subscribe(new c(interfaceC5822c, aVar));
            this.f17759b.m17799a((InterfaceC4529q) aVar);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }

    /* compiled from: FlowablePublishMulticast.java */
    /* renamed from: g.a.y0.e.b.m2$a */
    static final class a<T> extends AbstractC4519l<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: m */
        static final b[] f18067m = new b[0];

        /* renamed from: n */
        static final b[] f18068n = new b[0];

        /* renamed from: d */
        final int f18071d;

        /* renamed from: e */
        final int f18072e;

        /* renamed from: f */
        final boolean f18073f;

        /* renamed from: h */
        volatile InterfaceC4616o<T> f18075h;

        /* renamed from: i */
        int f18076i;

        /* renamed from: j */
        volatile boolean f18077j;

        /* renamed from: k */
        Throwable f18078k;

        /* renamed from: l */
        int f18079l;

        /* renamed from: b */
        final AtomicInteger f18069b = new AtomicInteger();

        /* renamed from: g */
        final AtomicReference<InterfaceC5823d> f18074g = new AtomicReference<>();

        /* renamed from: c */
        final AtomicReference<b<T>[]> f18070c = new AtomicReference<>(f18067m);

        a(int i2, boolean z) {
            this.f18071d = i2;
            this.f18072e = i2 - (i2 >> 2);
            this.f18073f = z;
        }

        /* renamed from: T */
        void m18332T() {
            for (b<T> bVar : this.f18070c.getAndSet(f18068n)) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.actual.onComplete();
                }
            }
        }

        /* renamed from: U */
        void m18333U() {
            Throwable th;
            Throwable th2;
            if (this.f18069b.getAndIncrement() != 0) {
                return;
            }
            InterfaceC4616o<T> interfaceC4616o = this.f18075h;
            int i2 = this.f18079l;
            int i3 = this.f18072e;
            boolean z = this.f18076i != 1;
            int i4 = i2;
            int i5 = 1;
            while (true) {
                b<T>[] bVarArr = this.f18070c.get();
                int length = bVarArr.length;
                if (interfaceC4616o != null && length != 0) {
                    long j2 = Long.MAX_VALUE;
                    for (b<T> bVar : bVarArr) {
                        long j3 = bVar.get();
                        if (j3 != Long.MIN_VALUE && j2 > j3) {
                            j2 = j3;
                        }
                    }
                    long j4 = 0;
                    while (j4 != j2) {
                        if (isDisposed()) {
                            interfaceC4616o.clear();
                            return;
                        }
                        boolean z2 = this.f18077j;
                        if (z2 && !this.f18073f && (th2 = this.f18078k) != null) {
                            m18336b(th2);
                            return;
                        }
                        try {
                            T poll = interfaceC4616o.poll();
                            boolean z3 = poll == null;
                            if (z2 && z3) {
                                Throwable th3 = this.f18078k;
                                if (th3 != null) {
                                    m18336b(th3);
                                    return;
                                } else {
                                    m18332T();
                                    return;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            int length2 = bVarArr.length;
                            int i6 = 0;
                            while (i6 < length2) {
                                int i7 = length2;
                                b<T> bVar2 = bVarArr[i6];
                                if (bVar2.get() != Long.MIN_VALUE) {
                                    bVar2.actual.onNext(poll);
                                }
                                i6++;
                                length2 = i7;
                            }
                            j4++;
                            if (z) {
                                int i8 = i4 + 1;
                                if (i8 == i3) {
                                    this.f18074g.get().request(i3);
                                    i4 = 0;
                                } else {
                                    i4 = i8;
                                }
                            }
                        } catch (Throwable th4) {
                            C4561b.m18199b(th4);
                            EnumC5160j.cancel(this.f18074g);
                            m18336b(th4);
                            return;
                        }
                    }
                    if (j4 == j2) {
                        if (isDisposed()) {
                            interfaceC4616o.clear();
                            return;
                        }
                        boolean z4 = this.f18077j;
                        if (z4 && !this.f18073f && (th = this.f18078k) != null) {
                            m18336b(th);
                            return;
                        }
                        if (z4 && interfaceC4616o.isEmpty()) {
                            Throwable th5 = this.f18078k;
                            if (th5 != null) {
                                m18336b(th5);
                                return;
                            } else {
                                m18332T();
                                return;
                            }
                        }
                    }
                    for (b<T> bVar3 : bVarArr) {
                        C5164d.m18610c(bVar3, j4);
                    }
                }
                this.f18079l = i4;
                i5 = this.f18069b.addAndGet(-i5);
                if (i5 == 0) {
                    return;
                }
                if (interfaceC4616o == null) {
                    interfaceC4616o = this.f18075h;
                }
            }
        }

        /* renamed from: a */
        boolean m18334a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f18070c.get();
                if (bVarArr == f18068n) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f18070c.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        /* renamed from: b */
        void m18335b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f18070c.get();
                if (bVarArr == f18068n || bVarArr == f18067m) {
                    return;
                }
                int length = bVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (bVarArr[i3] == bVar) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f18067m;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f18070c.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // p251g.p252a.AbstractC4519l
        /* renamed from: d */
        protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
            b<T> bVar = new b<>(interfaceC5822c, this);
            interfaceC5822c.onSubscribe(bVar);
            if (m18334a((b) bVar)) {
                if (bVar.isCancelled()) {
                    m18335b((b) bVar);
                    return;
                } else {
                    m18333U();
                    return;
                }
            }
            Throwable th = this.f18078k;
            if (th != null) {
                interfaceC5822c.onError(th);
            } else {
                interfaceC5822c.onComplete();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4616o<T> interfaceC4616o;
            EnumC5160j.cancel(this.f18074g);
            if (this.f18069b.getAndIncrement() != 0 || (interfaceC4616o = this.f18075h) == null) {
                return;
            }
            interfaceC4616o.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC5160j.isCancelled(this.f18074g.get());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18077j) {
                return;
            }
            this.f18077j = true;
            m18333U();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18077j) {
                C4476a.m17152b(th);
                return;
            }
            this.f18078k = th;
            this.f18077j = true;
            m18333U();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18077j) {
                return;
            }
            if (this.f18076i != 0 || this.f18075h.offer(t)) {
                m18333U();
            } else {
                this.f18074g.get().cancel();
                onError(new C4562c());
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this.f18074g, interfaceC5823d)) {
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f18076i = requestFusion;
                        this.f18075h = interfaceC4613l;
                        this.f18077j = true;
                        m18333U();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.f18076i = requestFusion;
                        this.f18075h = interfaceC4613l;
                        C5182v.m18650a(interfaceC5823d, this.f18071d);
                        return;
                    }
                }
                this.f18075h = C5182v.m18646a(this.f18071d);
                C5182v.m18650a(interfaceC5823d, this.f18071d);
            }
        }

        /* renamed from: b */
        void m18336b(Throwable th) {
            for (b<T> bVar : this.f18070c.getAndSet(f18068n)) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.actual.onError(th);
                }
            }
        }
    }
}
