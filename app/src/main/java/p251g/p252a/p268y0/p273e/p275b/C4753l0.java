package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p282h.AbstractC5130a;
import p251g.p252a.p268y0.p282h.AbstractC5131b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableDistinctUntilChanged.java */
/* renamed from: g.a.y0.e.b.l0 */
/* loaded from: classes2.dex */
public final class C4753l0<T, K> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, K> f18012c;

    /* renamed from: d */
    final InterfaceC4573d<? super K, ? super K> f18013d;

    /* compiled from: FlowableDistinctUntilChanged.java */
    /* renamed from: g.a.y0.e.b.l0$a */
    static final class a<T, K> extends AbstractC5130a<T, T> {

        /* renamed from: f */
        final InterfaceC4584o<? super T, K> f18014f;

        /* renamed from: g */
        final InterfaceC4573d<? super K, ? super K> f18015g;

        /* renamed from: h */
        K f18016h;

        /* renamed from: i */
        boolean f18017i;

        a(InterfaceC4602a<? super T> interfaceC4602a, InterfaceC4584o<? super T, K> interfaceC4584o, InterfaceC4573d<? super K, ? super K> interfaceC4573d) {
            super(interfaceC4602a);
            this.f18014f = interfaceC4584o;
            this.f18015g = interfaceC4573d;
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
            while (true) {
                T poll = this.f19950c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f18014f.apply(poll);
                if (!this.f18017i) {
                    this.f18017i = true;
                    this.f18016h = apply;
                    return poll;
                }
                if (!this.f18015g.mo18210a(this.f18016h, apply)) {
                    this.f18016h = apply;
                    return poll;
                }
                this.f18016h = apply;
                if (this.f19952e != 1) {
                    this.f19949b.request(1L);
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
                return this.f19948a.tryOnNext(t);
            }
            try {
                K apply = this.f18014f.apply(t);
                if (this.f18017i) {
                    boolean mo18210a = this.f18015g.mo18210a(this.f18016h, apply);
                    this.f18016h = apply;
                    if (mo18210a) {
                        return false;
                    }
                } else {
                    this.f18017i = true;
                    this.f18016h = apply;
                }
                this.f19948a.onNext(t);
                return true;
            } catch (Throwable th) {
                m18583a(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableDistinctUntilChanged.java */
    /* renamed from: g.a.y0.e.b.l0$b */
    static final class b<T, K> extends AbstractC5131b<T, T> implements InterfaceC4602a<T> {

        /* renamed from: f */
        final InterfaceC4584o<? super T, K> f18018f;

        /* renamed from: g */
        final InterfaceC4573d<? super K, ? super K> f18019g;

        /* renamed from: h */
        K f18020h;

        /* renamed from: i */
        boolean f18021i;

        b(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4584o<? super T, K> interfaceC4584o, InterfaceC4573d<? super K, ? super K> interfaceC4573d) {
            super(interfaceC5822c);
            this.f18018f = interfaceC4584o;
            this.f18019g = interfaceC4573d;
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
            while (true) {
                T poll = this.f19955c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f18018f.apply(poll);
                if (!this.f18021i) {
                    this.f18021i = true;
                    this.f18020h = apply;
                    return poll;
                }
                if (!this.f18019g.mo18210a(this.f18020h, apply)) {
                    this.f18020h = apply;
                    return poll;
                }
                this.f18020h = apply;
                if (this.f19957e != 1) {
                    this.f19954b.request(1L);
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
                this.f19953a.onNext(t);
                return true;
            }
            try {
                K apply = this.f18018f.apply(t);
                if (this.f18021i) {
                    boolean mo18210a = this.f18019g.mo18210a(this.f18020h, apply);
                    this.f18020h = apply;
                    if (mo18210a) {
                        return false;
                    }
                } else {
                    this.f18021i = true;
                    this.f18020h = apply;
                }
                this.f19953a.onNext(t);
                return true;
            } catch (Throwable th) {
                m18587a(th);
                return true;
            }
        }
    }

    public C4753l0(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, K> interfaceC4584o, InterfaceC4573d<? super K, ? super K> interfaceC4573d) {
        super(abstractC4519l);
        this.f18012c = interfaceC4584o;
        this.f18013d = interfaceC4573d;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            this.f17759b.m17799a((InterfaceC4529q) new a((InterfaceC4602a) interfaceC5822c, this.f18012c, this.f18013d));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, this.f18012c, this.f18013d));
        }
    }
}
