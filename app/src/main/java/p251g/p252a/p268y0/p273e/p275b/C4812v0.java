package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p282h.AbstractC5130a;
import p251g.p252a.p268y0.p282h.AbstractC5131b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableFilter.java */
/* renamed from: g.a.y0.e.b.v0 */
/* loaded from: classes2.dex */
public final class C4812v0<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4587r<? super T> f18450c;

    /* compiled from: FlowableFilter.java */
    /* renamed from: g.a.y0.e.b.v0$a */
    static final class a<T> extends AbstractC5130a<T, T> {

        /* renamed from: f */
        final InterfaceC4587r<? super T> f18451f;

        a(InterfaceC4602a<? super T> interfaceC4602a, InterfaceC4587r<? super T> interfaceC4587r) {
            super(interfaceC4602a);
            this.f18451f = interfaceC4587r;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f19949b.request(1L);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            InterfaceC4613l<T> interfaceC4613l = this.f19950c;
            InterfaceC4587r<? super T> interfaceC4587r = this.f18451f;
            while (true) {
                T poll = interfaceC4613l.poll();
                if (poll == null) {
                    return null;
                }
                if (interfaceC4587r.test(poll)) {
                    return poll;
                }
                if (this.f19952e == 2) {
                    interfaceC4613l.request(1L);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18581a(i2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            if (this.f19951d) {
                return false;
            }
            if (this.f19952e != 0) {
                return this.f19948a.tryOnNext(null);
            }
            try {
                return this.f18451f.test(t) && this.f19948a.tryOnNext(t);
            } catch (Throwable th) {
                m18583a(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableFilter.java */
    /* renamed from: g.a.y0.e.b.v0$b */
    static final class b<T> extends AbstractC5131b<T, T> implements InterfaceC4602a<T> {

        /* renamed from: f */
        final InterfaceC4587r<? super T> f18452f;

        b(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4587r<? super T> interfaceC4587r) {
            super(interfaceC5822c);
            this.f18452f = interfaceC4587r;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f19954b.request(1L);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            InterfaceC4613l<T> interfaceC4613l = this.f19955c;
            InterfaceC4587r<? super T> interfaceC4587r = this.f18452f;
            while (true) {
                T poll = interfaceC4613l.poll();
                if (poll == null) {
                    return null;
                }
                if (interfaceC4587r.test(poll)) {
                    return poll;
                }
                if (this.f19957e == 2) {
                    interfaceC4613l.request(1L);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18585a(i2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            if (this.f19956d) {
                return false;
            }
            if (this.f19957e != 0) {
                this.f19953a.onNext(null);
                return true;
            }
            try {
                boolean test = this.f18452f.test(t);
                if (test) {
                    this.f19953a.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                m18587a(th);
                return true;
            }
        }
    }

    public C4812v0(AbstractC4519l<T> abstractC4519l, InterfaceC4587r<? super T> interfaceC4587r) {
        super(abstractC4519l);
        this.f18450c = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            this.f17759b.m17799a((InterfaceC4529q) new a((InterfaceC4602a) interfaceC5822c, this.f18450c));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, this.f18450c));
        }
    }
}
