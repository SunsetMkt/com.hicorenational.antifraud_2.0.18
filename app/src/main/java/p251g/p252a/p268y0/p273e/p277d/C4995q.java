package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p272d.AbstractC4641w;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p284j.C5182v;
import p251g.p252a.p268y0.p284j.InterfaceC5178r;

/* compiled from: ObservableBufferTimed.java */
/* renamed from: g.a.y0.e.d.q */
/* loaded from: classes2.dex */
public final class C4995q<T, U extends Collection<? super T>> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final long f19281b;

    /* renamed from: c */
    final long f19282c;

    /* renamed from: d */
    final TimeUnit f19283d;

    /* renamed from: e */
    final AbstractC4516j0 f19284e;

    /* renamed from: f */
    final Callable<U> f19285f;

    /* renamed from: g */
    final int f19286g;

    /* renamed from: h */
    final boolean f19287h;

    /* compiled from: ObservableBufferTimed.java */
    /* renamed from: g.a.y0.e.d.q$a */
    static final class a<T, U extends Collection<? super T>> extends AbstractC4641w<T, U, U> implements Runnable, InterfaceC4552c {

        /* renamed from: K */
        final Callable<U> f19288K;

        /* renamed from: L */
        final long f19289L;

        /* renamed from: M */
        final TimeUnit f19290M;

        /* renamed from: N */
        final int f19291N;

        /* renamed from: O */
        final boolean f19292O;

        /* renamed from: b0 */
        final AbstractC4516j0.c f19293b0;

        /* renamed from: c0 */
        U f19294c0;

        /* renamed from: d0 */
        InterfaceC4552c f19295d0;

        /* renamed from: e0 */
        InterfaceC4552c f19296e0;

        /* renamed from: f0 */
        long f19297f0;

        /* renamed from: g0 */
        long f19298g0;

        a(InterfaceC4514i0<? super U> interfaceC4514i0, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z, AbstractC4516j0.c cVar) {
            super(interfaceC4514i0, new C5109a());
            this.f19288K = callable;
            this.f19289L = j2;
            this.f19290M = timeUnit;
            this.f19291N = i2;
            this.f19292O = z;
            this.f19293b0 = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p272d.AbstractC4641w, p251g.p252a.p268y0.p284j.InterfaceC5178r
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18302a(InterfaceC4514i0 interfaceC4514i0, Object obj) {
            m18505a((InterfaceC4514i0<? super InterfaceC4514i0>) interfaceC4514i0, (InterfaceC4514i0) obj);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f17593H) {
                return;
            }
            this.f17593H = true;
            this.f19296e0.dispose();
            this.f19293b0.dispose();
            synchronized (this) {
                this.f19294c0 = null;
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            U u;
            this.f19293b0.dispose();
            synchronized (this) {
                u = this.f19294c0;
                this.f19294c0 = null;
            }
            this.f17592G.offer(u);
            this.f17594I = true;
            if (mo18305b()) {
                C5182v.m18647a((InterfaceC4615n) this.f17592G, (InterfaceC4514i0) this.f17591F, false, (InterfaceC4552c) this, (InterfaceC5178r) this);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            synchronized (this) {
                this.f19294c0 = null;
            }
            this.f17591F.onError(th);
            this.f19293b0.dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f19294c0;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.f19291N) {
                    return;
                }
                this.f19294c0 = null;
                this.f19297f0++;
                if (this.f19292O) {
                    this.f19295d0.dispose();
                }
                m18304b(u, false, this);
                try {
                    U u2 = (U) C4601b.m18284a(this.f19288K.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.f19294c0 = u2;
                        this.f19298g0++;
                    }
                    if (this.f19292O) {
                        AbstractC4516j0.c cVar = this.f19293b0;
                        long j2 = this.f19289L;
                        this.f19295d0 = cVar.mo17412a(this, j2, j2, this.f19290M);
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f17591F.onError(th);
                    dispose();
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19296e0, interfaceC4552c)) {
                this.f19296e0 = interfaceC4552c;
                try {
                    this.f19294c0 = (U) C4601b.m18284a(this.f19288K.call(), "The buffer supplied is null");
                    this.f17591F.onSubscribe(this);
                    AbstractC4516j0.c cVar = this.f19293b0;
                    long j2 = this.f19289L;
                    this.f19295d0 = cVar.mo17412a(this, j2, j2, this.f19290M);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    interfaceC4552c.dispose();
                    EnumC4593e.error(th, this.f17591F);
                    this.f19293b0.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) C4601b.m18284a(this.f19288K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.f19294c0;
                    if (u2 != null && this.f19297f0 == this.f19298g0) {
                        this.f19294c0 = u;
                        m18304b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                dispose();
                this.f17591F.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public void m18505a(InterfaceC4514i0<? super U> interfaceC4514i0, U u) {
            interfaceC4514i0.onNext(u);
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    /* renamed from: g.a.y0.e.d.q$b */
    static final class b<T, U extends Collection<? super T>> extends AbstractC4641w<T, U, U> implements Runnable, InterfaceC4552c {

        /* renamed from: K */
        final Callable<U> f19299K;

        /* renamed from: L */
        final long f19300L;

        /* renamed from: M */
        final TimeUnit f19301M;

        /* renamed from: N */
        final AbstractC4516j0 f19302N;

        /* renamed from: O */
        InterfaceC4552c f19303O;

        /* renamed from: b0 */
        U f19304b0;

        /* renamed from: c0 */
        final AtomicReference<InterfaceC4552c> f19305c0;

        b(InterfaceC4514i0<? super U> interfaceC4514i0, Callable<U> callable, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            super(interfaceC4514i0, new C5109a());
            this.f19305c0 = new AtomicReference<>();
            this.f19299K = callable;
            this.f19300L = j2;
            this.f19301M = timeUnit;
            this.f19302N = abstractC4516j0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p272d.AbstractC4641w, p251g.p252a.p268y0.p284j.InterfaceC5178r
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18302a(InterfaceC4514i0 interfaceC4514i0, Object obj) {
            m18506a((InterfaceC4514i0<? super InterfaceC4514i0>) interfaceC4514i0, (InterfaceC4514i0) obj);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this.f19305c0);
            this.f19303O.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19305c0.get() == EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.f19304b0;
                this.f19304b0 = null;
            }
            if (u != null) {
                this.f17592G.offer(u);
                this.f17594I = true;
                if (mo18305b()) {
                    C5182v.m18647a((InterfaceC4615n) this.f17592G, (InterfaceC4514i0) this.f17591F, false, (InterfaceC4552c) this, (InterfaceC5178r) this);
                }
            }
            EnumC4592d.dispose(this.f19305c0);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            synchronized (this) {
                this.f19304b0 = null;
            }
            this.f17591F.onError(th);
            EnumC4592d.dispose(this.f19305c0);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f19304b0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19303O, interfaceC4552c)) {
                this.f19303O = interfaceC4552c;
                try {
                    this.f19304b0 = (U) C4601b.m18284a(this.f19299K.call(), "The buffer supplied is null");
                    this.f17591F.onSubscribe(this);
                    if (this.f17593H) {
                        return;
                    }
                    AbstractC4516j0 abstractC4516j0 = this.f19302N;
                    long j2 = this.f19300L;
                    InterfaceC4552c mo17408a = abstractC4516j0.mo17408a(this, j2, j2, this.f19301M);
                    if (this.f19305c0.compareAndSet(null, mo17408a)) {
                        return;
                    }
                    mo17408a.dispose();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    dispose();
                    EnumC4593e.error(th, this.f17591F);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) C4601b.m18284a(this.f19299K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.f19304b0;
                    if (u != null) {
                        this.f19304b0 = u2;
                    }
                }
                if (u == null) {
                    EnumC4592d.dispose(this.f19305c0);
                } else {
                    m18303a(u, false, this);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17591F.onError(th);
                dispose();
            }
        }

        /* renamed from: a */
        public void m18506a(InterfaceC4514i0<? super U> interfaceC4514i0, U u) {
            this.f17591F.onNext(u);
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    /* renamed from: g.a.y0.e.d.q$c */
    static final class c<T, U extends Collection<? super T>> extends AbstractC4641w<T, U, U> implements Runnable, InterfaceC4552c {

        /* renamed from: K */
        final Callable<U> f19306K;

        /* renamed from: L */
        final long f19307L;

        /* renamed from: M */
        final long f19308M;

        /* renamed from: N */
        final TimeUnit f19309N;

        /* renamed from: O */
        final AbstractC4516j0.c f19310O;

        /* renamed from: b0 */
        final List<U> f19311b0;

        /* renamed from: c0 */
        InterfaceC4552c f19312c0;

        /* compiled from: ObservableBufferTimed.java */
        /* renamed from: g.a.y0.e.d.q$c$a */
        final class a implements Runnable {

            /* renamed from: a */
            private final U f19313a;

            a(U u) {
                this.f19313a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f19311b0.remove(this.f19313a);
                }
                c cVar = c.this;
                cVar.m18304b(this.f19313a, false, cVar.f19310O);
            }
        }

        /* compiled from: ObservableBufferTimed.java */
        /* renamed from: g.a.y0.e.d.q$c$b */
        final class b implements Runnable {

            /* renamed from: a */
            private final U f19315a;

            b(U u) {
                this.f19315a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f19311b0.remove(this.f19315a);
                }
                c cVar = c.this;
                cVar.m18304b(this.f19315a, false, cVar.f19310O);
            }
        }

        c(InterfaceC4514i0<? super U> interfaceC4514i0, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0.c cVar) {
            super(interfaceC4514i0, new C5109a());
            this.f19306K = callable;
            this.f19307L = j2;
            this.f19308M = j3;
            this.f19309N = timeUnit;
            this.f19310O = cVar;
            this.f19311b0 = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p272d.AbstractC4641w, p251g.p252a.p268y0.p284j.InterfaceC5178r
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18302a(InterfaceC4514i0 interfaceC4514i0, Object obj) {
            m18509a((InterfaceC4514i0<? super InterfaceC4514i0>) interfaceC4514i0, (InterfaceC4514i0) obj);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f17593H) {
                return;
            }
            this.f17593H = true;
            m18510f();
            this.f19312c0.dispose();
            this.f19310O.dispose();
        }

        /* renamed from: f */
        void m18510f() {
            synchronized (this) {
                this.f19311b0.clear();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f19311b0);
                this.f19311b0.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f17592G.offer((Collection) it.next());
            }
            this.f17594I = true;
            if (mo18305b()) {
                C5182v.m18647a((InterfaceC4615n) this.f17592G, (InterfaceC4514i0) this.f17591F, false, (InterfaceC4552c) this.f19310O, (InterfaceC5178r) this);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f17594I = true;
            m18510f();
            this.f17591F.onError(th);
            this.f19310O.dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.f19311b0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19312c0, interfaceC4552c)) {
                this.f19312c0 = interfaceC4552c;
                try {
                    Collection collection = (Collection) C4601b.m18284a(this.f19306K.call(), "The buffer supplied is null");
                    this.f19311b0.add(collection);
                    this.f17591F.onSubscribe(this);
                    AbstractC4516j0.c cVar = this.f19310O;
                    long j2 = this.f19308M;
                    cVar.mo17412a(this, j2, j2, this.f19309N);
                    this.f19310O.mo17283a(new b(collection), this.f19307L, this.f19309N);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    interfaceC4552c.dispose();
                    EnumC4593e.error(th, this.f17591F);
                    this.f19310O.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17593H) {
                return;
            }
            try {
                Collection collection = (Collection) C4601b.m18284a(this.f19306K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.f17593H) {
                        return;
                    }
                    this.f19311b0.add(collection);
                    this.f19310O.mo17283a(new a(collection), this.f19307L, this.f19309N);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17591F.onError(th);
                dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public void m18509a(InterfaceC4514i0<? super U> interfaceC4514i0, U u) {
            interfaceC4514i0.onNext(u);
        }
    }

    public C4995q(InterfaceC4504g0<T> interfaceC4504g0, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, Callable<U> callable, int i2, boolean z) {
        super(interfaceC4504g0);
        this.f19281b = j2;
        this.f19282c = j3;
        this.f19283d = timeUnit;
        this.f19284e = abstractC4516j0;
        this.f19285f = callable;
        this.f19286g = i2;
        this.f19287h = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        if (this.f19281b == this.f19282c && this.f19286g == Integer.MAX_VALUE) {
            this.f18742a.subscribe(new b(new C4466m(interfaceC4514i0), this.f19285f, this.f19281b, this.f19283d, this.f19284e));
            return;
        }
        AbstractC4516j0.c mo17277a = this.f19284e.mo17277a();
        if (this.f19281b == this.f19282c) {
            this.f18742a.subscribe(new a(new C4466m(interfaceC4514i0), this.f19285f, this.f19281b, this.f19283d, this.f19286g, this.f19287h, mo17277a));
        } else {
            this.f18742a.subscribe(new c(new C4466m(interfaceC4514i0), this.f19285f, this.f19281b, this.f19282c, this.f19283d, mo17277a));
        }
    }
}
