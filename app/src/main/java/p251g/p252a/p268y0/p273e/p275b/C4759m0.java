package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p282h.AbstractC5130a;
import p251g.p252a.p268y0.p282h.AbstractC5131b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableDoAfterNext.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.b.m0 */
/* loaded from: classes2.dex */
public final class C4759m0<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4576g<? super T> f18059c;

    /* compiled from: FlowableDoAfterNext.java */
    /* renamed from: g.a.y0.e.b.m0$a */
    static final class a<T> extends AbstractC5130a<T, T> {

        /* renamed from: f */
        final InterfaceC4576g<? super T> f18060f;

        a(InterfaceC4602a<? super T> interfaceC4602a, InterfaceC4576g<? super T> interfaceC4576g) {
            super(interfaceC4602a);
            this.f18060f = interfaceC4576g;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f19948a.onNext(t);
            if (this.f19952e == 0) {
                try {
                    this.f18060f.accept(t);
                } catch (Throwable th) {
                    m18583a(th);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll = this.f19950c.poll();
            if (poll != null) {
                this.f18060f.accept(poll);
            }
            return poll;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18581a(i2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            boolean tryOnNext = this.f19948a.tryOnNext(t);
            try {
                this.f18060f.accept(t);
            } catch (Throwable th) {
                m18583a(th);
            }
            return tryOnNext;
        }
    }

    /* compiled from: FlowableDoAfterNext.java */
    /* renamed from: g.a.y0.e.b.m0$b */
    static final class b<T> extends AbstractC5131b<T, T> {

        /* renamed from: f */
        final InterfaceC4576g<? super T> f18061f;

        b(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4576g<? super T> interfaceC4576g) {
            super(interfaceC5822c);
            this.f18061f = interfaceC4576g;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19956d) {
                return;
            }
            this.f19953a.onNext(t);
            if (this.f19957e == 0) {
                try {
                    this.f18061f.accept(t);
                } catch (Throwable th) {
                    m18587a(th);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll = this.f19955c.poll();
            if (poll != null) {
                this.f18061f.accept(poll);
            }
            return poll;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18585a(i2);
        }
    }

    public C4759m0(AbstractC4519l<T> abstractC4519l, InterfaceC4576g<? super T> interfaceC4576g) {
        super(abstractC4519l);
        this.f18059c = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            this.f17759b.m17799a((InterfaceC4529q) new a((InterfaceC4602a) interfaceC5822c, this.f18059c));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, this.f18059c));
        }
    }
}
