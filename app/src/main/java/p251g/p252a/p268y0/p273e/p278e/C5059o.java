package p251g.p252a.p268y0.p273e.p278e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelRunOn.java */
/* renamed from: g.a.y0.e.e.o */
/* loaded from: classes2.dex */
public final class C5059o<T> extends AbstractC4471b<T> {

    /* renamed from: a */
    final AbstractC4471b<? extends T> f19656a;

    /* renamed from: b */
    final AbstractC4516j0 f19657b;

    /* renamed from: c */
    final int f19658c;

    /* compiled from: ParallelRunOn.java */
    /* renamed from: g.a.y0.e.e.o$a */
    static abstract class a<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final C5110b<T> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s */
        InterfaceC5823d f19659s;
        final AbstractC4516j0.c worker;

        a(int i2, C5110b<T> c5110b, AbstractC4516j0.c cVar) {
            this.prefetch = i2;
            this.queue = c5110b;
            this.limit = i2 - (i2 >> 2);
            this.worker = cVar;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f19659s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.queue.offer(t)) {
                schedule();
            } else {
                this.f19659s.cancel();
                onError(new C4562c("Queue is full?!"));
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                schedule();
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.mo17282a(this);
            }
        }
    }

    /* compiled from: ParallelRunOn.java */
    /* renamed from: g.a.y0.e.e.o$b */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final InterfaceC4602a<? super T> actual;

        b(InterfaceC4602a<? super T> interfaceC4602a, int i2, C5110b<T> c5110b, AbstractC4516j0.c cVar) {
            super(i2, c5110b, cVar);
            this.actual = interfaceC4602a;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19659s, interfaceC5823d)) {
                this.f19659s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i2 = this.consumed;
            C5110b<T> c5110b = this.queue;
            InterfaceC4602a<? super T> interfaceC4602a = this.actual;
            int i3 = this.limit;
            int i4 = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        c5110b.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        c5110b.clear();
                        interfaceC4602a.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = c5110b.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        interfaceC4602a.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        if (interfaceC4602a.tryOnNext(poll)) {
                            j3++;
                        }
                        i2++;
                        if (i2 == i3) {
                            this.f19659s.request(i2);
                            i2 = 0;
                        }
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        c5110b.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            c5110b.clear();
                            interfaceC4602a.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (c5110b.isEmpty()) {
                            interfaceC4602a.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j3 != 0 && j2 != C5556m0.f20396b) {
                    this.requested.addAndGet(-j3);
                }
                int i5 = get();
                if (i5 == i4) {
                    this.consumed = i2;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }
    }

    /* compiled from: ParallelRunOn.java */
    /* renamed from: g.a.y0.e.e.o$c */
    static final class c<T> extends a<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final InterfaceC5822c<? super T> actual;

        c(InterfaceC5822c<? super T> interfaceC5822c, int i2, C5110b<T> c5110b, AbstractC4516j0.c cVar) {
            super(i2, c5110b, cVar);
            this.actual = interfaceC5822c;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19659s, interfaceC5823d)) {
                this.f19659s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i2 = this.consumed;
            C5110b<T> c5110b = this.queue;
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            int i3 = this.limit;
            int i4 = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        c5110b.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        c5110b.clear();
                        interfaceC5822c.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = c5110b.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        interfaceC5822c.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        interfaceC5822c.onNext(poll);
                        j3++;
                        i2++;
                        if (i2 == i3) {
                            this.f19659s.request(i2);
                            i2 = 0;
                        }
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        c5110b.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            c5110b.clear();
                            interfaceC5822c.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (c5110b.isEmpty()) {
                            interfaceC5822c.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j3 != 0 && j2 != C5556m0.f20396b) {
                    this.requested.addAndGet(-j3);
                }
                int i5 = get();
                if (i5 == i4) {
                    this.consumed = i2;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }
    }

    public C5059o(AbstractC4471b<? extends T> abstractC4471b, AbstractC4516j0 abstractC4516j0, int i2) {
        this.f19656a = abstractC4471b;
        this.f19657b = abstractC4516j0;
        this.f19658c = i2;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super T>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super Object>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            int i2 = this.f19658c;
            for (int i3 = 0; i3 < length; i3++) {
                InterfaceC5822c<? super T> interfaceC5822c = interfaceC5822cArr[i3];
                AbstractC4516j0.c mo17277a = this.f19657b.mo17277a();
                C5110b c5110b = new C5110b(i2);
                if (interfaceC5822c instanceof InterfaceC4602a) {
                    interfaceC5822cArr2[i3] = new b((InterfaceC4602a) interfaceC5822c, i2, c5110b, mo17277a);
                } else {
                    interfaceC5822cArr2[i3] = new c(interfaceC5822c, i2, c5110b, mo17277a);
                }
            }
            this.f19656a.mo16994a(interfaceC5822cArr2);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19656a.mo16967a();
    }
}
