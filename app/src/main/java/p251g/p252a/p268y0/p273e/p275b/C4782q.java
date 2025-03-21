package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p282h.AbstractC5142m;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5182v;
import p251g.p252a.p268y0.p284j.InterfaceC5181u;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableBufferTimed.java */
/* renamed from: g.a.y0.e.b.q */
/* loaded from: classes2.dex */
public final class C4782q<T, U extends Collection<? super T>> extends AbstractC4686a<T, U> {

    /* renamed from: c */
    final long f18275c;

    /* renamed from: d */
    final long f18276d;

    /* renamed from: e */
    final TimeUnit f18277e;

    /* renamed from: f */
    final AbstractC4516j0 f18278f;

    /* renamed from: g */
    final Callable<U> f18279g;

    /* renamed from: h */
    final int f18280h;

    /* renamed from: i */
    final boolean f18281i;

    /* compiled from: FlowableBufferTimed.java */
    /* renamed from: g.a.y0.e.b.q$a */
    static final class a<T, U extends Collection<? super T>> extends AbstractC5142m<T, U, U> implements InterfaceC5823d, Runnable, InterfaceC4552c {

        /* renamed from: m0 */
        final Callable<U> f18282m0;

        /* renamed from: n0 */
        final long f18283n0;

        /* renamed from: o0 */
        final TimeUnit f18284o0;

        /* renamed from: p0 */
        final int f18285p0;

        /* renamed from: q0 */
        final boolean f18286q0;

        /* renamed from: r0 */
        final AbstractC4516j0.c f18287r0;

        /* renamed from: s0 */
        U f18288s0;

        /* renamed from: t0 */
        InterfaceC4552c f18289t0;

        /* renamed from: u0 */
        InterfaceC5823d f18290u0;

        /* renamed from: v0 */
        long f18291v0;

        /* renamed from: w0 */
        long f18292w0;

        a(InterfaceC5822c<? super U> interfaceC5822c, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z, AbstractC4516j0.c cVar) {
            super(interfaceC5822c, new C5109a());
            this.f18282m0 = callable;
            this.f18283n0 = j2;
            this.f18284o0 = timeUnit;
            this.f18285p0 = i2;
            this.f18286q0 = z;
            this.f18287r0 = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p282h.AbstractC5142m, p251g.p252a.p268y0.p284j.InterfaceC5181u
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo18337a(InterfaceC5822c interfaceC5822c, Object obj) {
            return m18381a((InterfaceC5822c<? super InterfaceC5822c>) interfaceC5822c, (InterfaceC5822c) obj);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.f19968j0) {
                return;
            }
            this.f19968j0 = true;
            dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            synchronized (this) {
                this.f18288s0 = null;
            }
            this.f18290u0.cancel();
            this.f18287r0.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18287r0.isDisposed();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.f18288s0;
                this.f18288s0 = null;
            }
            this.f19967i0.offer(u);
            this.f19969k0 = true;
            if (mo18596b()) {
                C5182v.m18648a((InterfaceC4615n) this.f19967i0, (InterfaceC5822c) this.f19966h0, false, (InterfaceC4552c) this, (InterfaceC5181u) this);
            }
            this.f18287r0.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            synchronized (this) {
                this.f18288s0 = null;
            }
            this.f19966h0.onError(th);
            this.f18287r0.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f18288s0;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.f18285p0) {
                    return;
                }
                this.f18288s0 = null;
                this.f18291v0++;
                if (this.f18286q0) {
                    this.f18289t0.dispose();
                }
                m18595b(u, false, this);
                try {
                    U u2 = (U) C4601b.m18284a(this.f18282m0.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.f18288s0 = u2;
                        this.f18292w0++;
                    }
                    if (this.f18286q0) {
                        AbstractC4516j0.c cVar = this.f18287r0;
                        long j2 = this.f18283n0;
                        this.f18289t0 = cVar.mo17412a(this, j2, j2, this.f18284o0);
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    cancel();
                    this.f19966h0.onError(th);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18290u0, interfaceC5823d)) {
                this.f18290u0 = interfaceC5823d;
                try {
                    this.f18288s0 = (U) C4601b.m18284a(this.f18282m0.call(), "The supplied buffer is null");
                    this.f19966h0.onSubscribe(this);
                    AbstractC4516j0.c cVar = this.f18287r0;
                    long j2 = this.f18283n0;
                    this.f18289t0 = cVar.mo17412a(this, j2, j2, this.f18284o0);
                    interfaceC5823d.request(C5556m0.f20396b);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f18287r0.dispose();
                    interfaceC5823d.cancel();
                    EnumC5157g.error(th, this.f19966h0);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) C4601b.m18284a(this.f18282m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.f18288s0;
                    if (u2 != null && this.f18291v0 == this.f18292w0) {
                        this.f18288s0 = u;
                        m18595b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                this.f19966h0.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public boolean m18381a(InterfaceC5822c<? super U> interfaceC5822c, U u) {
            interfaceC5822c.onNext(u);
            return true;
        }
    }

    /* compiled from: FlowableBufferTimed.java */
    /* renamed from: g.a.y0.e.b.q$b */
    static final class b<T, U extends Collection<? super T>> extends AbstractC5142m<T, U, U> implements InterfaceC5823d, Runnable, InterfaceC4552c {

        /* renamed from: m0 */
        final Callable<U> f18293m0;

        /* renamed from: n0 */
        final long f18294n0;

        /* renamed from: o0 */
        final TimeUnit f18295o0;

        /* renamed from: p0 */
        final AbstractC4516j0 f18296p0;

        /* renamed from: q0 */
        InterfaceC5823d f18297q0;

        /* renamed from: r0 */
        U f18298r0;

        /* renamed from: s0 */
        final AtomicReference<InterfaceC4552c> f18299s0;

        b(InterfaceC5822c<? super U> interfaceC5822c, Callable<U> callable, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            super(interfaceC5822c, new C5109a());
            this.f18299s0 = new AtomicReference<>();
            this.f18293m0 = callable;
            this.f18294n0 = j2;
            this.f18295o0 = timeUnit;
            this.f18296p0 = abstractC4516j0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p282h.AbstractC5142m, p251g.p252a.p268y0.p284j.InterfaceC5181u
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo18337a(InterfaceC5822c interfaceC5822c, Object obj) {
            return m18382a((InterfaceC5822c<? super InterfaceC5822c>) interfaceC5822c, (InterfaceC5822c) obj);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18297q0.cancel();
            EnumC4592d.dispose(this.f18299s0);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            cancel();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18299s0.get() == EnumC4592d.DISPOSED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            EnumC4592d.dispose(this.f18299s0);
            synchronized (this) {
                U u = this.f18298r0;
                if (u == null) {
                    return;
                }
                this.f18298r0 = null;
                this.f19967i0.offer(u);
                this.f19969k0 = true;
                if (mo18596b()) {
                    C5182v.m18648a((InterfaceC4615n) this.f19967i0, (InterfaceC5822c) this.f19966h0, false, (InterfaceC4552c) this, (InterfaceC5181u) this);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            EnumC4592d.dispose(this.f18299s0);
            synchronized (this) {
                this.f18298r0 = null;
            }
            this.f19966h0.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f18298r0;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18297q0, interfaceC5823d)) {
                this.f18297q0 = interfaceC5823d;
                try {
                    this.f18298r0 = (U) C4601b.m18284a(this.f18293m0.call(), "The supplied buffer is null");
                    this.f19966h0.onSubscribe(this);
                    if (this.f19968j0) {
                        return;
                    }
                    interfaceC5823d.request(C5556m0.f20396b);
                    AbstractC4516j0 abstractC4516j0 = this.f18296p0;
                    long j2 = this.f18294n0;
                    InterfaceC4552c mo17408a = abstractC4516j0.mo17408a(this, j2, j2, this.f18295o0);
                    if (this.f18299s0.compareAndSet(null, mo17408a)) {
                        return;
                    }
                    mo17408a.dispose();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    cancel();
                    EnumC5157g.error(th, this.f19966h0);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) C4601b.m18284a(this.f18293m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    u = this.f18298r0;
                    if (u != null) {
                        this.f18298r0 = u2;
                    }
                }
                if (u == null) {
                    EnumC4592d.dispose(this.f18299s0);
                } else {
                    m18593a(u, false, this);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                this.f19966h0.onError(th);
            }
        }

        /* renamed from: a */
        public boolean m18382a(InterfaceC5822c<? super U> interfaceC5822c, U u) {
            this.f19966h0.onNext(u);
            return true;
        }
    }

    /* compiled from: FlowableBufferTimed.java */
    /* renamed from: g.a.y0.e.b.q$c */
    static final class c<T, U extends Collection<? super T>> extends AbstractC5142m<T, U, U> implements InterfaceC5823d, Runnable {

        /* renamed from: m0 */
        final Callable<U> f18300m0;

        /* renamed from: n0 */
        final long f18301n0;

        /* renamed from: o0 */
        final long f18302o0;

        /* renamed from: p0 */
        final TimeUnit f18303p0;

        /* renamed from: q0 */
        final AbstractC4516j0.c f18304q0;

        /* renamed from: r0 */
        final List<U> f18305r0;

        /* renamed from: s0 */
        InterfaceC5823d f18306s0;

        /* compiled from: FlowableBufferTimed.java */
        /* renamed from: g.a.y0.e.b.q$c$a */
        final class a implements Runnable {

            /* renamed from: a */
            private final U f18307a;

            a(U u) {
                this.f18307a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f18305r0.remove(this.f18307a);
                }
                c cVar = c.this;
                cVar.m18595b(this.f18307a, false, cVar.f18304q0);
            }
        }

        c(InterfaceC5822c<? super U> interfaceC5822c, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0.c cVar) {
            super(interfaceC5822c, new C5109a());
            this.f18300m0 = callable;
            this.f18301n0 = j2;
            this.f18302o0 = j3;
            this.f18303p0 = timeUnit;
            this.f18304q0 = cVar;
            this.f18305r0 = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p282h.AbstractC5142m, p251g.p252a.p268y0.p284j.InterfaceC5181u
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo18337a(InterfaceC5822c interfaceC5822c, Object obj) {
            return m18384a((InterfaceC5822c<? super InterfaceC5822c>) interfaceC5822c, (InterfaceC5822c) obj);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            m18385f();
            this.f18306s0.cancel();
            this.f18304q0.dispose();
        }

        /* renamed from: f */
        void m18385f() {
            synchronized (this) {
                this.f18305r0.clear();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f18305r0);
                this.f18305r0.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f19967i0.offer((Collection) it.next());
            }
            this.f19969k0 = true;
            if (mo18596b()) {
                C5182v.m18648a((InterfaceC4615n) this.f19967i0, (InterfaceC5822c) this.f19966h0, false, (InterfaceC4552c) this.f18304q0, (InterfaceC5181u) this);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f19969k0 = true;
            this.f18304q0.dispose();
            m18385f();
            this.f19966h0.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.f18305r0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18306s0, interfaceC5823d)) {
                this.f18306s0 = interfaceC5823d;
                try {
                    Collection collection = (Collection) C4601b.m18284a(this.f18300m0.call(), "The supplied buffer is null");
                    this.f18305r0.add(collection);
                    this.f19966h0.onSubscribe(this);
                    interfaceC5823d.request(C5556m0.f20396b);
                    AbstractC4516j0.c cVar = this.f18304q0;
                    long j2 = this.f18302o0;
                    cVar.mo17412a(this, j2, j2, this.f18303p0);
                    this.f18304q0.mo17283a(new a(collection), this.f18301n0, this.f18303p0);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f18304q0.dispose();
                    interfaceC5823d.cancel();
                    EnumC5157g.error(th, this.f19966h0);
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
                return;
            }
            try {
                Collection collection = (Collection) C4601b.m18284a(this.f18300m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.f19968j0) {
                        return;
                    }
                    this.f18305r0.add(collection);
                    this.f18304q0.mo17283a(new a(collection), this.f18301n0, this.f18303p0);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                this.f19966h0.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public boolean m18384a(InterfaceC5822c<? super U> interfaceC5822c, U u) {
            interfaceC5822c.onNext(u);
            return true;
        }
    }

    public C4782q(AbstractC4519l<T> abstractC4519l, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, Callable<U> callable, int i2, boolean z) {
        super(abstractC4519l);
        this.f18275c = j2;
        this.f18276d = j3;
        this.f18277e = timeUnit;
        this.f18278f = abstractC4516j0;
        this.f18279g = callable;
        this.f18280h = i2;
        this.f18281i = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        if (this.f18275c == this.f18276d && this.f18280h == Integer.MAX_VALUE) {
            this.f17759b.m17799a((InterfaceC4529q) new b(new C4509e(interfaceC5822c), this.f18279g, this.f18275c, this.f18277e, this.f18278f));
            return;
        }
        AbstractC4516j0.c mo17277a = this.f18278f.mo17277a();
        if (this.f18275c == this.f18276d) {
            this.f17759b.m17799a((InterfaceC4529q) new a(new C4509e(interfaceC5822c), this.f18279g, this.f18275c, this.f18277e, this.f18280h, this.f18281i, mo17277a));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new c(new C4509e(interfaceC5822c), this.f18279g, this.f18275c, this.f18276d, this.f18277e, mo17277a));
        }
    }
}
