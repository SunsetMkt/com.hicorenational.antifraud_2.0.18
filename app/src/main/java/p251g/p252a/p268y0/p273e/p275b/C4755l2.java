package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p266w0.AbstractC4567a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p271c.InterfaceC4609h;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowablePublish.java */
/* renamed from: g.a.y0.e.b.l2 */
/* loaded from: classes2.dex */
public final class C4755l2<T> extends AbstractC4567a<T> implements InterfaceC4609h<T> {

    /* renamed from: f */
    static final long f18026f = Long.MIN_VALUE;

    /* renamed from: b */
    final AbstractC4519l<T> f18027b;

    /* renamed from: c */
    final AtomicReference<c<T>> f18028c;

    /* renamed from: d */
    final int f18029d;

    /* renamed from: e */
    final InterfaceC5821b<T> f18030e;

    /* compiled from: FlowablePublish.java */
    /* renamed from: g.a.y0.e.b.l2$a */
    static final class a<T> implements InterfaceC5821b<T> {

        /* renamed from: a */
        private final AtomicReference<c<T>> f18031a;

        /* renamed from: b */
        private final int f18032b;

        a(AtomicReference<c<T>> atomicReference, int i2) {
            this.f18031a = atomicReference;
            this.f18032b = i2;
        }

        @Override // p324i.p338d.InterfaceC5821b
        public void subscribe(InterfaceC5822c<? super T> interfaceC5822c) {
            c<T> cVar;
            b<T> bVar = new b<>(interfaceC5822c);
            interfaceC5822c.onSubscribe(bVar);
            while (true) {
                cVar = this.f18031a.get();
                if (cVar == null || cVar.isDisposed()) {
                    c<T> cVar2 = new c<>(this.f18031a, this.f18032b);
                    if (this.f18031a.compareAndSet(cVar, cVar2)) {
                        cVar = cVar2;
                    } else {
                        continue;
                    }
                }
                if (cVar.add(bVar)) {
                    break;
                }
            }
            if (bVar.get() == Long.MIN_VALUE) {
                cVar.remove(bVar);
            } else {
                bVar.parent = cVar;
            }
            cVar.dispatch();
        }
    }

    /* compiled from: FlowablePublish.java */
    /* renamed from: g.a.y0.e.b.l2$b */
    static final class b<T> extends AtomicLong implements InterfaceC5823d {
        private static final long serialVersionUID = -4453897557930727610L;
        final InterfaceC5822c<? super T> child;
        volatile c<T> parent;

        b(InterfaceC5822c<? super T> interfaceC5822c) {
            this.child = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            c<T> cVar;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (cVar = this.parent) == null) {
                return;
            }
            cVar.remove(this);
            cVar.dispatch();
        }

        public long produced(long j2) {
            return C5164d.m18611d(this, j2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18609b(this, j2);
                c<T> cVar = this.parent;
                if (cVar != null) {
                    cVar.dispatch();
                }
            }
        }
    }

    /* compiled from: FlowablePublish.java */
    /* renamed from: g.a.y0.e.b.l2$c */
    static final class c<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC4552c {
        static final b[] EMPTY = new b[0];
        static final b[] TERMINATED = new b[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<c<T>> current;
        volatile InterfaceC4616o<T> queue;
        int sourceMode;
        volatile Object terminalEvent;

        /* renamed from: s */
        final AtomicReference<InterfaceC5823d> f18033s = new AtomicReference<>();
        final AtomicReference<b[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        c(AtomicReference<c<T>> atomicReference, int i2) {
            this.current = atomicReference;
            this.bufferSize = i2;
        }

        boolean add(b<T> bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = this.subscribers.get();
                if (bVarArr == TERMINATED) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.subscribers.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        boolean checkTerminated(Object obj, boolean z) {
            int i2 = 0;
            if (obj != null) {
                if (!EnumC5177q.isComplete(obj)) {
                    Throwable error = EnumC5177q.getError(obj);
                    this.current.compareAndSet(this, null);
                    b[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].child.onError(error);
                            i2++;
                        }
                    } else {
                        C4476a.m17152b(error);
                    }
                    return true;
                }
                if (z) {
                    this.current.compareAndSet(this, null);
                    b[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet2.length;
                    while (i2 < length2) {
                        andSet2[i2].child.onComplete();
                        i2++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:79:0x0115, code lost:
        
            if (r16 == false) goto L75;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void dispatch() {
            /*
                Method dump skipped, instructions count: 294
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4755l2.c.dispatch():void");
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            b[] bVarArr = this.subscribers.get();
            b[] bVarArr2 = TERMINATED;
            if (bVarArr == bVarArr2 || this.subscribers.getAndSet(bVarArr2) == TERMINATED) {
                return;
            }
            this.current.compareAndSet(this, null);
            EnumC5160j.cancel(this.f18033s);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = EnumC5177q.complete();
                dispatch();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.terminalEvent != null) {
                C4476a.m17152b(th);
            } else {
                this.terminalEvent = EnumC5177q.error(th);
                dispatch();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
            } else {
                onError(new C4562c("Prefetch queue is full?!"));
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this.f18033s, interfaceC5823d)) {
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.terminalEvent = EnumC5177q.complete();
                        dispatch();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        interfaceC5823d.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new C5110b(this.bufferSize);
                interfaceC5823d.request(this.bufferSize);
            }
        }

        void remove(b<T> bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = this.subscribers.get();
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
                    bVarArr2 = EMPTY;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.subscribers.compareAndSet(bVarArr, bVarArr2));
        }
    }

    private C4755l2(InterfaceC5821b<T> interfaceC5821b, AbstractC4519l<T> abstractC4519l, AtomicReference<c<T>> atomicReference, int i2) {
        this.f18030e = interfaceC5821b;
        this.f18027b = abstractC4519l;
        this.f18028c = atomicReference;
        this.f18029d = i2;
    }

    /* renamed from: a */
    public static <T> AbstractC4567a<T> m18331a(AbstractC4519l<T> abstractC4519l, int i2) {
        AtomicReference atomicReference = new AtomicReference();
        return C4476a.m17133a((AbstractC4567a) new C4755l2(new a(atomicReference, i2), abstractC4519l, atomicReference, i2));
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f18030e.subscribe(interfaceC5822c);
    }

    @Override // p251g.p252a.p266w0.AbstractC4567a
    /* renamed from: l */
    public void mo18205l(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        c<T> cVar;
        while (true) {
            cVar = this.f18028c.get();
            if (cVar != null && !cVar.isDisposed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.f18028c, this.f18029d);
            if (this.f18028c.compareAndSet(cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z = !cVar.shouldConnect.get() && cVar.shouldConnect.compareAndSet(false, true);
        try {
            interfaceC4576g.accept(cVar);
            if (z) {
                this.f18027b.m17799a((InterfaceC4529q) cVar);
            }
        } catch (Throwable th) {
            C4561b.m18199b(th);
            throw C5171k.m18626c(th);
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4609h
    public InterfaceC5821b<T> source() {
        return this.f18027b;
    }
}
