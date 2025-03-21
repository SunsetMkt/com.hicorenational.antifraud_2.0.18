package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5174n;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableCache.java */
/* renamed from: g.a.y0.e.b.r */
/* loaded from: classes2.dex */
public final class C4788r<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final a<T> f18334c;

    /* renamed from: d */
    final AtomicBoolean f18335d;

    /* compiled from: FlowableCache.java */
    /* renamed from: g.a.y0.e.b.r$a */
    static final class a<T> extends C5174n implements InterfaceC4529q<T> {

        /* renamed from: k */
        static final b[] f18336k = new b[0];

        /* renamed from: l */
        static final b[] f18337l = new b[0];

        /* renamed from: f */
        final AbstractC4519l<T> f18338f;

        /* renamed from: g */
        final AtomicReference<InterfaceC5823d> f18339g;

        /* renamed from: h */
        final AtomicReference<b<T>[]> f18340h;

        /* renamed from: i */
        volatile boolean f18341i;

        /* renamed from: j */
        boolean f18342j;

        a(AbstractC4519l<T> abstractC4519l, int i2) {
            super(i2);
            this.f18339g = new AtomicReference<>();
            this.f18338f = abstractC4519l;
            this.f18340h = new AtomicReference<>(f18336k);
        }

        /* renamed from: a */
        public void m18389a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f18340h.get();
                if (bVarArr == f18337l) {
                    return;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f18340h.compareAndSet(bVarArr, bVarArr2));
        }

        /* renamed from: b */
        public void m18390b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f18340h.get();
                int length = bVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (bVarArr[i3].equals(bVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f18336k;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f18340h.compareAndSet(bVarArr, bVarArr2));
        }

        /* renamed from: c */
        public void m18391c() {
            this.f18338f.m17799a((InterfaceC4529q) this);
            this.f18341i = true;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18342j) {
                return;
            }
            this.f18342j = true;
            m18633a(EnumC5177q.complete());
            EnumC5160j.cancel(this.f18339g);
            for (b<T> bVar : this.f18340h.getAndSet(f18337l)) {
                bVar.replay();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18342j) {
                C4476a.m17152b(th);
                return;
            }
            this.f18342j = true;
            m18633a(EnumC5177q.error(th));
            EnumC5160j.cancel(this.f18339g);
            for (b<T> bVar : this.f18340h.getAndSet(f18337l)) {
                bVar.replay();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18342j) {
                return;
            }
            m18633a(EnumC5177q.next(t));
            for (b<T> bVar : this.f18340h.get()) {
                bVar.replay();
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this.f18339g, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    /* compiled from: FlowableCache.java */
    /* renamed from: g.a.y0.e.b.r$b */
    static final class b<T> extends AtomicInteger implements InterfaceC5823d {

        /* renamed from: a */
        private static final long f18343a = -1;
        private static final long serialVersionUID = -2557562030197141021L;
        final InterfaceC5822c<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final a<T> state;

        b(InterfaceC5822c<? super T> interfaceC5822c, a<T> aVar) {
            this.child = interfaceC5822c;
            this.state = aVar;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.requested.getAndSet(-1L) != -1) {
                this.state.m18390b(this);
            }
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super T> interfaceC5822c = this.child;
            AtomicLong atomicLong = this.requested;
            int i2 = 1;
            int i3 = 1;
            while (true) {
                long j2 = atomicLong.get();
                if (j2 < 0) {
                    return;
                }
                int m18635b = this.state.m18635b();
                if (m18635b != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.m18634a();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - i2;
                    int i4 = this.index;
                    int i5 = this.currentIndexInBuffer;
                    int i6 = 0;
                    while (i4 < m18635b && j2 > 0) {
                        if (atomicLong.get() == -1) {
                            return;
                        }
                        if (i5 == length) {
                            objArr = (Object[]) objArr[length];
                            i5 = 0;
                        }
                        if (EnumC5177q.accept(objArr[i5], interfaceC5822c)) {
                            return;
                        }
                        i5++;
                        i4++;
                        j2--;
                        i6++;
                    }
                    if (atomicLong.get() == -1) {
                        return;
                    }
                    if (j2 == 0) {
                        Object obj = objArr[i5];
                        if (EnumC5177q.isComplete(obj)) {
                            interfaceC5822c.onComplete();
                            return;
                        } else if (EnumC5177q.isError(obj)) {
                            interfaceC5822c.onError(EnumC5177q.getError(obj));
                            return;
                        }
                    }
                    if (i6 != 0) {
                        C5164d.m18611d(atomicLong, i6);
                    }
                    this.index = i4;
                    this.currentIndexInBuffer = i5;
                    this.currentBuffer = objArr;
                }
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                } else {
                    i2 = 1;
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            long j3;
            if (EnumC5160j.validate(j2)) {
                do {
                    j3 = this.requested.get();
                    if (j3 == -1) {
                        return;
                    }
                } while (!this.requested.compareAndSet(j3, C5164d.m18606a(j3, j2)));
                replay();
            }
        }
    }

    public C4788r(AbstractC4519l<T> abstractC4519l, int i2) {
        super(abstractC4519l);
        this.f18334c = new a<>(abstractC4519l, i2);
        this.f18335d = new AtomicBoolean();
    }

    /* renamed from: T */
    int m18386T() {
        return this.f18334c.m18635b();
    }

    /* renamed from: U */
    boolean m18387U() {
        return this.f18334c.f18340h.get().length != 0;
    }

    /* renamed from: V */
    boolean m18388V() {
        return this.f18334c.f18341i;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        b<T> bVar = new b<>(interfaceC5822c, this.f18334c);
        this.f18334c.m18389a((b) bVar);
        interfaceC5822c.onSubscribe(bVar);
        if (this.f18335d.get() || !this.f18335d.compareAndSet(false, true)) {
            return;
        }
        this.f18334c.m18391c();
    }
}
