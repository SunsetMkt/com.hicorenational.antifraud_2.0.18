package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.AbstractC5154d;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableFromIterable.java */
/* renamed from: g.a.y0.e.b.g1 */
/* loaded from: classes2.dex */
public final class C4724g1<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final Iterable<? extends T> f17912b;

    /* compiled from: FlowableFromIterable.java */
    /* renamed from: g.a.y0.e.b.g1$a */
    static abstract class a<T> extends AbstractC5154d<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;

        /* renamed from: it */
        Iterator<? extends T> f17913it;
        boolean once;

        a(Iterator<? extends T> it) {
            this.f17913it = it;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public final void clear() {
            this.f17913it = null;
        }

        abstract void fastPath();

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.f17913it;
            return it == null || !it.hasNext();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public final T poll() {
            Iterator<? extends T> it = this.f17913it;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return (T) C4601b.m18284a((Object) this.f17913it.next(), "Iterator.next() returned a null value");
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void request(long j2) {
            if (EnumC5160j.validate(j2) && C5164d.m18607a(this, j2) == 0) {
                if (j2 == C5556m0.f20396b) {
                    fastPath();
                } else {
                    slowPath(j2);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public final int requestFusion(int i2) {
            return i2 & 1;
        }

        abstract void slowPath(long j2);
    }

    /* compiled from: FlowableFromIterable.java */
    /* renamed from: g.a.y0.e.b.g1$b */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final InterfaceC4602a<? super T> actual;

        b(InterfaceC4602a<? super T> interfaceC4602a, Iterator<? extends T> it) {
            super(it);
            this.actual = interfaceC4602a;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4724g1.a
        void fastPath() {
            Iterator<? extends T> it = this.f17913it;
            InterfaceC4602a<? super T> interfaceC4602a = this.actual;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        interfaceC4602a.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    interfaceC4602a.tryOnNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            interfaceC4602a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        interfaceC4602a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    interfaceC4602a.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x005c, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // p251g.p252a.p268y0.p273e.p275b.C4724g1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.f17913it
                g.a.y0.c.a<? super T> r1 = r8.actual
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L54
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4c
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L27:
                boolean r6 = r1.tryOnNext(r6)
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L30
                return
            L30:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L44
                if (r7 != 0) goto L3e
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3d
                r1.onComplete()
            L3d:
                return
            L3e:
                if (r6 == 0) goto L8
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L44:
                r9 = move-exception
                p251g.p252a.p265v0.C4561b.m18199b(r9)
                r1.onError(r9)
                return
            L4c:
                r9 = move-exception
                p251g.p252a.p265v0.C4561b.m18199b(r9)
                r1.onError(r9)
                return
            L54:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4724g1.b.slowPath(long):void");
        }
    }

    /* compiled from: FlowableFromIterable.java */
    /* renamed from: g.a.y0.e.b.g1$c */
    static final class c<T> extends a<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final InterfaceC5822c<? super T> actual;

        c(InterfaceC5822c<? super T> interfaceC5822c, Iterator<? extends T> it) {
            super(it);
            this.actual = interfaceC5822c;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4724g1.a
        void fastPath() {
            Iterator<? extends T> it = this.f17913it;
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        interfaceC5822c.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    interfaceC5822c.onNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            interfaceC5822c.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        interfaceC5822c.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    interfaceC5822c.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // p251g.p252a.p268y0.p273e.p275b.C4724g1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.f17913it
                i.d.c<? super T> r1 = r8.actual
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L51
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L49
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L27:
                r1.onNext(r6)
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L2f
                return
            L2f:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L41
                if (r6 != 0) goto L3d
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3c
                r1.onComplete()
            L3c:
                return
            L3d:
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L41:
                r9 = move-exception
                p251g.p252a.p265v0.C4561b.m18199b(r9)
                r1.onError(r9)
                return
            L49:
                r9 = move-exception
                p251g.p252a.p265v0.C4561b.m18199b(r9)
                r1.onError(r9)
                return
            L51:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4724g1.c.slowPath(long):void");
        }
    }

    public C4724g1(Iterable<? extends T> iterable) {
        this.f17912b = iterable;
    }

    /* renamed from: a */
    public static <T> void m18322a(InterfaceC5822c<? super T> interfaceC5822c, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EnumC5157g.complete(interfaceC5822c);
            } else if (interfaceC5822c instanceof InterfaceC4602a) {
                interfaceC5822c.onSubscribe(new b((InterfaceC4602a) interfaceC5822c, it));
            } else {
                interfaceC5822c.onSubscribe(new c(interfaceC5822c, it));
            }
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        try {
            m18322a((InterfaceC5822c) interfaceC5822c, (Iterator) this.f17912b.iterator());
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
