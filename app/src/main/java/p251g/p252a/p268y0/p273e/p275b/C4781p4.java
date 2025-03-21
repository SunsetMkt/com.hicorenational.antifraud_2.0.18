package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p256d1.C4485g;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p282h.AbstractC5142m;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableWindowTimed.java */
/* renamed from: g.a.y0.e.b.p4 */
/* loaded from: classes2.dex */
public final class C4781p4<T> extends AbstractC4686a<T, AbstractC4519l<T>> {

    /* renamed from: c */
    final long f18232c;

    /* renamed from: d */
    final long f18233d;

    /* renamed from: e */
    final TimeUnit f18234e;

    /* renamed from: f */
    final AbstractC4516j0 f18235f;

    /* renamed from: g */
    final long f18236g;

    /* renamed from: h */
    final int f18237h;

    /* renamed from: i */
    final boolean f18238i;

    /* compiled from: FlowableWindowTimed.java */
    /* renamed from: g.a.y0.e.b.p4$a */
    static final class a<T> extends AbstractC5142m<T, Object, AbstractC4519l<T>> implements InterfaceC5823d {

        /* renamed from: m0 */
        final long f18239m0;

        /* renamed from: n0 */
        final TimeUnit f18240n0;

        /* renamed from: o0 */
        final AbstractC4516j0 f18241o0;

        /* renamed from: p0 */
        final int f18242p0;

        /* renamed from: q0 */
        final boolean f18243q0;

        /* renamed from: r0 */
        final long f18244r0;

        /* renamed from: s0 */
        final AbstractC4516j0.c f18245s0;

        /* renamed from: t0 */
        long f18246t0;

        /* renamed from: u0 */
        long f18247u0;

        /* renamed from: v0 */
        InterfaceC5823d f18248v0;

        /* renamed from: w0 */
        C4485g<T> f18249w0;

        /* renamed from: x0 */
        volatile boolean f18250x0;

        /* renamed from: y0 */
        final C4599k f18251y0;

        /* compiled from: FlowableWindowTimed.java */
        /* renamed from: g.a.y0.e.b.p4$a$a, reason: collision with other inner class name */
        static final class RunnableC7395a implements Runnable {

            /* renamed from: a */
            final long f18252a;

            /* renamed from: b */
            final a<?> f18253b;

            RunnableC7395a(long j2, a<?> aVar) {
                this.f18252a = j2;
                this.f18253b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f18253b;
                if (((AbstractC5142m) aVar).f19968j0) {
                    aVar.f18250x0 = true;
                    aVar.dispose();
                } else {
                    ((AbstractC5142m) aVar).f19967i0.offer(this);
                }
                if (aVar.mo18596b()) {
                    aVar.m18377f();
                }
            }
        }

        a(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, long j3, boolean z) {
            super(interfaceC5822c, new C5109a());
            this.f18251y0 = new C4599k();
            this.f18239m0 = j2;
            this.f18240n0 = timeUnit;
            this.f18241o0 = abstractC4516j0;
            this.f18242p0 = i2;
            this.f18244r0 = j3;
            this.f18243q0 = z;
            if (z) {
                this.f18245s0 = abstractC4516j0.mo17277a();
            } else {
                this.f18245s0 = null;
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19968j0 = true;
        }

        public void dispose() {
            EnumC4592d.dispose(this.f18251y0);
            AbstractC4516j0.c cVar = this.f18245s0;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        
            if (r17.f18247u0 == r7.f18252a) goto L33;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m18377f() {
            /*
                Method dump skipped, instructions count: 295
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4781p4.a.m18377f():void");
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f19969k0 = true;
            if (mo18596b()) {
                m18377f();
            }
            this.f19966h0.onComplete();
            dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f19970l0 = th;
            this.f19969k0 = true;
            if (mo18596b()) {
                m18377f();
            }
            this.f19966h0.onError(th);
            dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18250x0) {
                return;
            }
            if (m18599e()) {
                C4485g<T> c4485g = this.f18249w0;
                c4485g.onNext(t);
                long j2 = this.f18246t0 + 1;
                if (j2 >= this.f18244r0) {
                    this.f18247u0++;
                    this.f18246t0 = 0L;
                    c4485g.onComplete();
                    long requested = requested();
                    if (requested == 0) {
                        this.f18249w0 = null;
                        this.f18248v0.cancel();
                        this.f19966h0.onError(new C4562c("Could not deliver window due to lack of requests"));
                        dispose();
                        return;
                    }
                    C4485g<T> m17260m = C4485g.m17260m(this.f18242p0);
                    this.f18249w0 = m17260m;
                    this.f19966h0.onNext(m17260m);
                    if (requested != C5556m0.f20396b) {
                        mo18591a(1L);
                    }
                    if (this.f18243q0) {
                        InterfaceC4552c interfaceC4552c = this.f18251y0.get();
                        interfaceC4552c.dispose();
                        AbstractC4516j0.c cVar = this.f18245s0;
                        RunnableC7395a runnableC7395a = new RunnableC7395a(this.f18247u0, this);
                        long j3 = this.f18239m0;
                        InterfaceC4552c mo17412a = cVar.mo17412a(runnableC7395a, j3, j3, this.f18240n0);
                        if (!this.f18251y0.compareAndSet(interfaceC4552c, mo17412a)) {
                            mo17412a.dispose();
                        }
                    }
                } else {
                    this.f18246t0 = j2;
                }
                if (mo18590a(-1) == 0) {
                    return;
                }
            } else {
                this.f19967i0.offer(EnumC5177q.next(t));
                if (!mo18596b()) {
                    return;
                }
            }
            m18377f();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            InterfaceC4552c mo17408a;
            if (EnumC5160j.validate(this.f18248v0, interfaceC5823d)) {
                this.f18248v0 = interfaceC5823d;
                InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
                interfaceC5822c.onSubscribe(this);
                if (this.f19968j0) {
                    return;
                }
                C4485g<T> m17260m = C4485g.m17260m(this.f18242p0);
                this.f18249w0 = m17260m;
                long requested = requested();
                if (requested == 0) {
                    this.f19968j0 = true;
                    interfaceC5823d.cancel();
                    interfaceC5822c.onError(new C4562c("Could not deliver initial window due to lack of requests."));
                    return;
                }
                interfaceC5822c.onNext(m17260m);
                if (requested != C5556m0.f20396b) {
                    mo18591a(1L);
                }
                RunnableC7395a runnableC7395a = new RunnableC7395a(this.f18247u0, this);
                if (this.f18243q0) {
                    AbstractC4516j0.c cVar = this.f18245s0;
                    long j2 = this.f18239m0;
                    mo17408a = cVar.mo17412a(runnableC7395a, j2, j2, this.f18240n0);
                } else {
                    AbstractC4516j0 abstractC4516j0 = this.f18241o0;
                    long j3 = this.f18239m0;
                    mo17408a = abstractC4516j0.mo17408a(runnableC7395a, j3, j3, this.f18240n0);
                }
                if (this.f18251y0.replace(mo17408a)) {
                    interfaceC5823d.request(C5556m0.f20396b);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }
    }

    /* compiled from: FlowableWindowTimed.java */
    /* renamed from: g.a.y0.e.b.p4$b */
    static final class b<T> extends AbstractC5142m<T, Object, AbstractC4519l<T>> implements InterfaceC4529q<T>, InterfaceC5823d, Runnable {

        /* renamed from: u0 */
        static final Object f18254u0 = new Object();

        /* renamed from: m0 */
        final long f18255m0;

        /* renamed from: n0 */
        final TimeUnit f18256n0;

        /* renamed from: o0 */
        final AbstractC4516j0 f18257o0;

        /* renamed from: p0 */
        final int f18258p0;

        /* renamed from: q0 */
        InterfaceC5823d f18259q0;

        /* renamed from: r0 */
        C4485g<T> f18260r0;

        /* renamed from: s0 */
        final C4599k f18261s0;

        /* renamed from: t0 */
        volatile boolean f18262t0;

        b(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2) {
            super(interfaceC5822c, new C5109a());
            this.f18261s0 = new C4599k();
            this.f18255m0 = j2;
            this.f18256n0 = timeUnit;
            this.f18257o0 = abstractC4516j0;
            this.f18258p0 = i2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19968j0 = true;
        }

        public void dispose() {
            EnumC4592d.dispose(this.f18261s0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.f18260r0 = null;
            r0.clear();
            dispose();
            r0 = r10.f19970l0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [g.a.d1.g<T>] */
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m18378f() {
            /*
                r10 = this;
                g.a.y0.c.n<U> r0 = r10.f19967i0
                i.d.c<? super V> r1 = r10.f19966h0
                g.a.d1.g<T> r2 = r10.f18260r0
                r3 = 1
            L7:
                boolean r4 = r10.f18262t0
                boolean r5 = r10.f19969k0
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2c
                if (r6 == 0) goto L18
                java.lang.Object r5 = p251g.p252a.p268y0.p273e.p275b.C4781p4.b.f18254u0
                if (r6 != r5) goto L2c
            L18:
                r10.f18260r0 = r7
                r0.clear()
                r10.dispose()
                java.lang.Throwable r0 = r10.f19970l0
                if (r0 == 0) goto L28
                r2.onError(r0)
                goto L2b
            L28:
                r2.onComplete()
            L2b:
                return
            L2c:
                if (r6 != 0) goto L36
                int r3 = -r3
                int r3 = r10.mo18590a(r3)
                if (r3 != 0) goto L7
                return
            L36:
                java.lang.Object r5 = p251g.p252a.p268y0.p273e.p275b.C4781p4.b.f18254u0
                if (r6 != r5) goto L83
                r2.onComplete()
                if (r4 != 0) goto L7d
                int r2 = r10.f18258p0
                g.a.d1.g r2 = p251g.p252a.p256d1.C4485g.m17260m(r2)
                r10.f18260r0 = r2
                long r4 = r10.requested()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L63
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 == 0) goto L7
                r4 = 1
                r10.mo18591a(r4)
                goto L7
            L63:
                r10.f18260r0 = r7
                g.a.y0.c.n<U> r0 = r10.f19967i0
                r0.clear()
                i.d.d r0 = r10.f18259q0
                r0.cancel()
                r10.dispose()
                g.a.v0.c r0 = new g.a.v0.c
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                return
            L7d:
                i.d.d r4 = r10.f18259q0
                r4.cancel()
                goto L7
            L83:
                java.lang.Object r4 = p251g.p252a.p268y0.p284j.EnumC5177q.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4781p4.b.m18378f():void");
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f19969k0 = true;
            if (mo18596b()) {
                m18378f();
            }
            this.f19966h0.onComplete();
            dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f19970l0 = th;
            this.f19969k0 = true;
            if (mo18596b()) {
                m18378f();
            }
            this.f19966h0.onError(th);
            dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18262t0) {
                return;
            }
            if (m18599e()) {
                this.f18260r0.onNext(t);
                if (mo18590a(-1) == 0) {
                    return;
                }
            } else {
                this.f19967i0.offer(EnumC5177q.next(t));
                if (!mo18596b()) {
                    return;
                }
            }
            m18378f();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18259q0, interfaceC5823d)) {
                this.f18259q0 = interfaceC5823d;
                this.f18260r0 = C4485g.m17260m(this.f18258p0);
                InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
                interfaceC5822c.onSubscribe(this);
                long requested = requested();
                if (requested == 0) {
                    this.f19968j0 = true;
                    interfaceC5823d.cancel();
                    interfaceC5822c.onError(new C4562c("Could not deliver first window due to lack of requests."));
                    return;
                }
                interfaceC5822c.onNext(this.f18260r0);
                if (requested != C5556m0.f20396b) {
                    mo18591a(1L);
                }
                if (this.f19968j0) {
                    return;
                }
                C4599k c4599k = this.f18261s0;
                AbstractC4516j0 abstractC4516j0 = this.f18257o0;
                long j2 = this.f18255m0;
                if (c4599k.replace(abstractC4516j0.mo17408a(this, j2, j2, this.f18256n0))) {
                    interfaceC5823d.request(C5556m0.f20396b);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19968j0) {
                this.f18262t0 = true;
                dispose();
            }
            this.f19967i0.offer(f18254u0);
            if (mo18596b()) {
                m18378f();
            }
        }
    }

    /* compiled from: FlowableWindowTimed.java */
    /* renamed from: g.a.y0.e.b.p4$c */
    static final class c<T> extends AbstractC5142m<T, Object, AbstractC4519l<T>> implements InterfaceC5823d, Runnable {

        /* renamed from: m0 */
        final long f18263m0;

        /* renamed from: n0 */
        final long f18264n0;

        /* renamed from: o0 */
        final TimeUnit f18265o0;

        /* renamed from: p0 */
        final AbstractC4516j0.c f18266p0;

        /* renamed from: q0 */
        final int f18267q0;

        /* renamed from: r0 */
        final List<C4485g<T>> f18268r0;

        /* renamed from: s0 */
        InterfaceC5823d f18269s0;

        /* renamed from: t0 */
        volatile boolean f18270t0;

        /* compiled from: FlowableWindowTimed.java */
        /* renamed from: g.a.y0.e.b.p4$c$a */
        final class a implements Runnable {

            /* renamed from: a */
            private final C4485g<T> f18271a;

            a(C4485g<T> c4485g) {
                this.f18271a = c4485g;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.m18379a(this.f18271a);
            }
        }

        /* compiled from: FlowableWindowTimed.java */
        /* renamed from: g.a.y0.e.b.p4$c$b */
        static final class b<T> {

            /* renamed from: a */
            final C4485g<T> f18273a;

            /* renamed from: b */
            final boolean f18274b;

            b(C4485g<T> c4485g, boolean z) {
                this.f18273a = c4485g;
                this.f18274b = z;
            }
        }

        c(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0.c cVar, int i2) {
            super(interfaceC5822c, new C5109a());
            this.f18263m0 = j2;
            this.f18264n0 = j3;
            this.f18265o0 = timeUnit;
            this.f18266p0 = cVar;
            this.f18267q0 = i2;
            this.f18268r0 = new LinkedList();
        }

        /* renamed from: a */
        void m18379a(C4485g<T> c4485g) {
            this.f19967i0.offer(new b(c4485g, false));
            if (mo18596b()) {
                m18380f();
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19968j0 = true;
        }

        public void dispose() {
            this.f18266p0.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: f */
        void m18380f() {
            InterfaceC4616o interfaceC4616o = this.f19967i0;
            InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
            List<C4485g<T>> list = this.f18268r0;
            int i2 = 1;
            while (!this.f18270t0) {
                boolean z = this.f19969k0;
                Object poll = interfaceC4616o.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof b;
                if (z && (z2 || z3)) {
                    interfaceC4616o.clear();
                    Throwable th = this.f19970l0;
                    if (th != null) {
                        Iterator<C4485g<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<C4485g<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    dispose();
                    return;
                }
                if (z2) {
                    i2 = mo18590a(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) poll;
                    if (!bVar.f18274b) {
                        list.remove(bVar.f18273a);
                        bVar.f18273a.onComplete();
                        if (list.isEmpty() && this.f19968j0) {
                            this.f18270t0 = true;
                        }
                    } else if (!this.f19968j0) {
                        long requested = requested();
                        if (requested != 0) {
                            C4485g<T> m17260m = C4485g.m17260m(this.f18267q0);
                            list.add(m17260m);
                            interfaceC5822c.onNext(m17260m);
                            if (requested != C5556m0.f20396b) {
                                mo18591a(1L);
                            }
                            this.f18266p0.mo17283a(new a(m17260m), this.f18263m0, this.f18265o0);
                        } else {
                            interfaceC5822c.onError(new C4562c("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<C4485g<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(poll);
                    }
                }
            }
            this.f18269s0.cancel();
            dispose();
            interfaceC4616o.clear();
            list.clear();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f19969k0 = true;
            if (mo18596b()) {
                m18380f();
            }
            this.f19966h0.onComplete();
            dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f19970l0 = th;
            this.f19969k0 = true;
            if (mo18596b()) {
                m18380f();
            }
            this.f19966h0.onError(th);
            dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (m18599e()) {
                Iterator<C4485g<T>> it = this.f18268r0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (mo18590a(-1) == 0) {
                    return;
                }
            } else {
                this.f19967i0.offer(t);
                if (!mo18596b()) {
                    return;
                }
            }
            m18380f();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18269s0, interfaceC5823d)) {
                this.f18269s0 = interfaceC5823d;
                this.f19966h0.onSubscribe(this);
                if (this.f19968j0) {
                    return;
                }
                long requested = requested();
                if (requested == 0) {
                    interfaceC5823d.cancel();
                    this.f19966h0.onError(new C4562c("Could not emit the first window due to lack of requests"));
                    return;
                }
                C4485g<T> m17260m = C4485g.m17260m(this.f18267q0);
                this.f18268r0.add(m17260m);
                this.f19966h0.onNext(m17260m);
                if (requested != C5556m0.f20396b) {
                    mo18591a(1L);
                }
                this.f18266p0.mo17283a(new a(m17260m), this.f18263m0, this.f18265o0);
                AbstractC4516j0.c cVar = this.f18266p0;
                long j2 = this.f18264n0;
                cVar.mo17412a(this, j2, j2, this.f18265o0);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(C4485g.m17260m(this.f18267q0), true);
            if (!this.f19968j0) {
                this.f19967i0.offer(bVar);
            }
            if (mo18596b()) {
                m18380f();
            }
        }
    }

    public C4781p4(AbstractC4519l<T> abstractC4519l, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, long j4, int i2, boolean z) {
        super(abstractC4519l);
        this.f18232c = j2;
        this.f18233d = j3;
        this.f18234e = timeUnit;
        this.f18235f = abstractC4516j0;
        this.f18236g = j4;
        this.f18237h = i2;
        this.f18238i = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c) {
        C4509e c4509e = new C4509e(interfaceC5822c);
        long j2 = this.f18232c;
        long j3 = this.f18233d;
        if (j2 != j3) {
            this.f17759b.m17799a((InterfaceC4529q) new c(c4509e, j2, j3, this.f18234e, this.f18235f.mo17277a(), this.f18237h));
            return;
        }
        long j4 = this.f18236g;
        if (j4 == C5556m0.f20396b) {
            this.f17759b.m17799a((InterfaceC4529q) new b(c4509e, j2, this.f18234e, this.f18235f, this.f18237h));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new a(c4509e, j2, this.f18234e, this.f18235f, this.f18237h, j4, this.f18238i));
        }
    }
}
