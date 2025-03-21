package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p282h.AbstractC5130a;
import p251g.p252a.p268y0.p282h.AbstractC5131b;
import p251g.p252a.p268y0.p284j.C5171k;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableDoOnEach.java */
/* renamed from: g.a.y0.e.b.o0 */
/* loaded from: classes2.dex */
public final class C4771o0<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4576g<? super T> f18151c;

    /* renamed from: d */
    final InterfaceC4576g<? super Throwable> f18152d;

    /* renamed from: e */
    final InterfaceC4570a f18153e;

    /* renamed from: f */
    final InterfaceC4570a f18154f;

    /* compiled from: FlowableDoOnEach.java */
    /* renamed from: g.a.y0.e.b.o0$a */
    static final class a<T> extends AbstractC5130a<T, T> {

        /* renamed from: f */
        final InterfaceC4576g<? super T> f18155f;

        /* renamed from: g */
        final InterfaceC4576g<? super Throwable> f18156g;

        /* renamed from: h */
        final InterfaceC4570a f18157h;

        /* renamed from: i */
        final InterfaceC4570a f18158i;

        a(InterfaceC4602a<? super T> interfaceC4602a, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2) {
            super(interfaceC4602a);
            this.f18155f = interfaceC4576g;
            this.f18156g = interfaceC4576g2;
            this.f18157h = interfaceC4570a;
            this.f18158i = interfaceC4570a2;
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5130a, p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19951d) {
                return;
            }
            try {
                this.f18157h.run();
                this.f19951d = true;
                this.f19948a.onComplete();
                try {
                    this.f18158i.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            } catch (Throwable th2) {
                m18583a(th2);
            }
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5130a, p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19951d) {
                C4476a.m17152b(th);
                return;
            }
            boolean z = true;
            this.f19951d = true;
            try {
                this.f18156g.accept(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f19948a.onError(new C4560a(th, th2));
                z = false;
            }
            if (z) {
                this.f19948a.onError(th);
            }
            try {
                this.f18158i.run();
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                C4476a.m17152b(th3);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19951d) {
                return;
            }
            if (this.f19952e != 0) {
                this.f19948a.onNext(null);
                return;
            }
            try {
                this.f18155f.accept(t);
                this.f19948a.onNext(t);
            } catch (Throwable th) {
                m18583a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            try {
                T poll = this.f19950c.poll();
                if (poll != null) {
                    try {
                        this.f18155f.accept(poll);
                    } catch (Throwable th) {
                        try {
                            C4561b.m18199b(th);
                            try {
                                this.f18156g.accept(th);
                                throw C5171k.m18625b(th);
                            } catch (Throwable th2) {
                                throw new C4560a(th, th2);
                            }
                        } finally {
                            this.f18158i.run();
                        }
                    }
                } else if (this.f19952e == 1) {
                    this.f18157h.run();
                }
                return poll;
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                try {
                    this.f18156g.accept(th3);
                    throw C5171k.m18625b(th3);
                } catch (Throwable th4) {
                    throw new C4560a(th3, th4);
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
            try {
                this.f18155f.accept(t);
                return this.f19948a.tryOnNext(t);
            } catch (Throwable th) {
                m18583a(th);
                return false;
            }
        }
    }

    /* compiled from: FlowableDoOnEach.java */
    /* renamed from: g.a.y0.e.b.o0$b */
    static final class b<T> extends AbstractC5131b<T, T> {

        /* renamed from: f */
        final InterfaceC4576g<? super T> f18159f;

        /* renamed from: g */
        final InterfaceC4576g<? super Throwable> f18160g;

        /* renamed from: h */
        final InterfaceC4570a f18161h;

        /* renamed from: i */
        final InterfaceC4570a f18162i;

        b(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2) {
            super(interfaceC5822c);
            this.f18159f = interfaceC4576g;
            this.f18160g = interfaceC4576g2;
            this.f18161h = interfaceC4570a;
            this.f18162i = interfaceC4570a2;
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5131b, p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19956d) {
                return;
            }
            try {
                this.f18161h.run();
                this.f19956d = true;
                this.f19953a.onComplete();
                try {
                    this.f18162i.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            } catch (Throwable th2) {
                m18587a(th2);
            }
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5131b, p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19956d) {
                C4476a.m17152b(th);
                return;
            }
            boolean z = true;
            this.f19956d = true;
            try {
                this.f18160g.accept(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f19953a.onError(new C4560a(th, th2));
                z = false;
            }
            if (z) {
                this.f19953a.onError(th);
            }
            try {
                this.f18162i.run();
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                C4476a.m17152b(th3);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19956d) {
                return;
            }
            if (this.f19957e != 0) {
                this.f19953a.onNext(null);
                return;
            }
            try {
                this.f18159f.accept(t);
                this.f19953a.onNext(t);
            } catch (Throwable th) {
                m18587a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            try {
                T poll = this.f19955c.poll();
                if (poll != null) {
                    try {
                        this.f18159f.accept(poll);
                    } catch (Throwable th) {
                        try {
                            C4561b.m18199b(th);
                            try {
                                this.f18160g.accept(th);
                                throw C5171k.m18625b(th);
                            } catch (Throwable th2) {
                                throw new C4560a(th, th2);
                            }
                        } finally {
                            this.f18162i.run();
                        }
                    }
                } else if (this.f19957e == 1) {
                    this.f18161h.run();
                }
                return poll;
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                try {
                    this.f18160g.accept(th3);
                    throw C5171k.m18625b(th3);
                } catch (Throwable th4) {
                    throw new C4560a(th3, th4);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18585a(i2);
        }
    }

    public C4771o0(AbstractC4519l<T> abstractC4519l, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2) {
        super(abstractC4519l);
        this.f18151c = interfaceC4576g;
        this.f18152d = interfaceC4576g2;
        this.f18153e = interfaceC4570a;
        this.f18154f = interfaceC4570a2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            this.f17759b.m17799a((InterfaceC4529q) new a((InterfaceC4602a) interfaceC5822c, this.f18151c, this.f18152d, this.f18153e, this.f18154f));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, this.f18151c, this.f18152d, this.f18153e, this.f18154f));
        }
    }
}
