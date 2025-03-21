package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p272d.AbstractC4641w;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p284j.C5182v;
import p251g.p252a.p268y0.p284j.InterfaceC5178r;

/* compiled from: ObservableBufferBoundary.java */
/* renamed from: g.a.y0.e.d.n */
/* loaded from: classes2.dex */
public final class C4980n<T, U extends Collection<? super T>, Open, Close> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final Callable<U> f19195b;

    /* renamed from: c */
    final InterfaceC4504g0<? extends Open> f19196c;

    /* renamed from: d */
    final InterfaceC4584o<? super Open, ? extends InterfaceC4504g0<? extends Close>> f19197d;

    /* compiled from: ObservableBufferBoundary.java */
    /* renamed from: g.a.y0.e.d.n$a */
    static final class a<T, U extends Collection<? super T>, Open, Close> extends AbstractC4641w<T, U, U> implements InterfaceC4552c {

        /* renamed from: K */
        final InterfaceC4504g0<? extends Open> f19198K;

        /* renamed from: L */
        final InterfaceC4584o<? super Open, ? extends InterfaceC4504g0<? extends Close>> f19199L;

        /* renamed from: M */
        final Callable<U> f19200M;

        /* renamed from: N */
        final C4551b f19201N;

        /* renamed from: O */
        InterfaceC4552c f19202O;

        /* renamed from: b0 */
        final List<U> f19203b0;

        /* renamed from: c0 */
        final AtomicInteger f19204c0;

        a(InterfaceC4514i0<? super U> interfaceC4514i0, InterfaceC4504g0<? extends Open> interfaceC4504g0, InterfaceC4584o<? super Open, ? extends InterfaceC4504g0<? extends Close>> interfaceC4584o, Callable<U> callable) {
            super(interfaceC4514i0, new C5109a());
            this.f19204c0 = new AtomicInteger();
            this.f19198K = interfaceC4504g0;
            this.f19199L = interfaceC4584o;
            this.f19200M = callable;
            this.f19203b0 = new LinkedList();
            this.f19201N = new C4551b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p272d.AbstractC4641w, p251g.p252a.p268y0.p284j.InterfaceC5178r
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18302a(InterfaceC4514i0 interfaceC4514i0, Object obj) {
            m18495a((InterfaceC4514i0<? super InterfaceC4514i0>) interfaceC4514i0, (InterfaceC4514i0) obj);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f17593H) {
                return;
            }
            this.f17593H = true;
            this.f19201N.dispose();
        }

        /* renamed from: f */
        void m18499f() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f19203b0);
                this.f19203b0.clear();
            }
            InterfaceC4615n<U> interfaceC4615n = this.f17592G;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                interfaceC4615n.offer((Collection) it.next());
            }
            this.f17594I = true;
            if (mo18305b()) {
                C5182v.m18647a((InterfaceC4615n) interfaceC4615n, (InterfaceC4514i0) this.f17591F, false, (InterfaceC4552c) this, (InterfaceC5178r) this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19204c0.decrementAndGet() == 0) {
                m18499f();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            dispose();
            this.f17593H = true;
            synchronized (this) {
                this.f19203b0.clear();
            }
            this.f17591F.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.f19203b0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19202O, interfaceC4552c)) {
                this.f19202O = interfaceC4552c;
                c cVar = new c(this);
                this.f19201N.mo18181b(cVar);
                this.f17591F.onSubscribe(this);
                this.f19204c0.lazySet(1);
                this.f19198K.subscribe(cVar);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public void m18495a(InterfaceC4514i0<? super U> interfaceC4514i0, U u) {
            interfaceC4514i0.onNext(u);
        }

        /* renamed from: a */
        void m18497a(Open open) {
            if (this.f17593H) {
                return;
            }
            try {
                Collection collection = (Collection) C4601b.m18284a(this.f19200M.call(), "The buffer supplied is null");
                try {
                    InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f19199L.apply(open), "The buffer closing Observable is null");
                    if (this.f17593H) {
                        return;
                    }
                    synchronized (this) {
                        if (this.f17593H) {
                            return;
                        }
                        this.f19203b0.add(collection);
                        b bVar = new b(collection, this);
                        this.f19201N.mo18181b(bVar);
                        this.f19204c0.getAndIncrement();
                        interfaceC4504g0.subscribe(bVar);
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                onError(th2);
            }
        }

        /* renamed from: a */
        void m18496a(InterfaceC4552c interfaceC4552c) {
            if (this.f19201N.mo18178a(interfaceC4552c) && this.f19204c0.decrementAndGet() == 0) {
                m18499f();
            }
        }

        /* renamed from: a */
        void m18498a(U u, InterfaceC4552c interfaceC4552c) {
            boolean remove;
            synchronized (this) {
                remove = this.f19203b0.remove(u);
            }
            if (remove) {
                m18304b(u, false, this);
            }
            if (this.f19201N.mo18178a(interfaceC4552c) && this.f19204c0.decrementAndGet() == 0) {
                m18499f();
            }
        }
    }

    /* compiled from: ObservableBufferBoundary.java */
    /* renamed from: g.a.y0.e.d.n$b */
    static final class b<T, U extends Collection<? super T>, Open, Close> extends AbstractC4458e<Close> {

        /* renamed from: b */
        final a<T, U, Open, Close> f19205b;

        /* renamed from: c */
        final U f19206c;

        /* renamed from: d */
        boolean f19207d;

        b(U u, a<T, U, Open, Close> aVar) {
            this.f19205b = aVar;
            this.f19206c = u;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19207d) {
                return;
            }
            this.f19207d = true;
            this.f19205b.m18498a((a<T, U, Open, Close>) this.f19206c, (InterfaceC4552c) this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19207d) {
                C4476a.m17152b(th);
            } else {
                this.f19205b.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* compiled from: ObservableBufferBoundary.java */
    /* renamed from: g.a.y0.e.d.n$c */
    static final class c<T, U extends Collection<? super T>, Open, Close> extends AbstractC4458e<Open> {

        /* renamed from: b */
        final a<T, U, Open, Close> f19208b;

        /* renamed from: c */
        boolean f19209c;

        c(a<T, U, Open, Close> aVar) {
            this.f19208b = aVar;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19209c) {
                return;
            }
            this.f19209c = true;
            this.f19208b.m18496a((InterfaceC4552c) this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19209c) {
                C4476a.m17152b(th);
            } else {
                this.f19209c = true;
                this.f19208b.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Open open) {
            if (this.f19209c) {
                return;
            }
            this.f19208b.m18497a((a<T, U, Open, Close>) open);
        }
    }

    public C4980n(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<? extends Open> interfaceC4504g02, InterfaceC4584o<? super Open, ? extends InterfaceC4504g0<? extends Close>> interfaceC4584o, Callable<U> callable) {
        super(interfaceC4504g0);
        this.f19196c = interfaceC4504g02;
        this.f19197d = interfaceC4584o;
        this.f19195b = callable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        this.f18742a.subscribe(new a(new C4466m(interfaceC4514i0), this.f19196c, this.f19197d, this.f19195b));
    }
}
