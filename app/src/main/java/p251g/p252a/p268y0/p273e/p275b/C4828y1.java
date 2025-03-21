package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p282h.AbstractC5130a;
import p251g.p252a.p268y0.p282h.AbstractC5131b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableMap.java */
/* renamed from: g.a.y0.e.b.y1 */
/* loaded from: classes2.dex */
public final class C4828y1<T, U> extends AbstractC4686a<T, U> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends U> f18525c;

    /* compiled from: FlowableMap.java */
    /* renamed from: g.a.y0.e.b.y1$a */
    static final class a<T, U> extends AbstractC5130a<T, U> {

        /* renamed from: f */
        final InterfaceC4584o<? super T, ? extends U> f18526f;

        a(InterfaceC4602a<? super U> interfaceC4602a, InterfaceC4584o<? super T, ? extends U> interfaceC4584o) {
            super(interfaceC4602a);
            this.f18526f = interfaceC4584o;
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
                this.f19948a.onNext(C4601b.m18284a(this.f18526f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m18583a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public U poll() throws Exception {
            T poll = this.f19950c.poll();
            if (poll != null) {
                return (U) C4601b.m18284a(this.f18526f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
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
                return this.f19948a.tryOnNext(C4601b.m18284a(this.f18526f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m18583a(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableMap.java */
    /* renamed from: g.a.y0.e.b.y1$b */
    static final class b<T, U> extends AbstractC5131b<T, U> {

        /* renamed from: f */
        final InterfaceC4584o<? super T, ? extends U> f18527f;

        b(InterfaceC5822c<? super U> interfaceC5822c, InterfaceC4584o<? super T, ? extends U> interfaceC4584o) {
            super(interfaceC5822c);
            this.f18527f = interfaceC4584o;
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
                this.f19953a.onNext(C4601b.m18284a(this.f18527f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m18587a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public U poll() throws Exception {
            T poll = this.f19955c.poll();
            if (poll != null) {
                return (U) C4601b.m18284a(this.f18527f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18585a(i2);
        }
    }

    public C4828y1(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends U> interfaceC4584o) {
        super(abstractC4519l);
        this.f18525c = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            this.f17759b.m17799a((InterfaceC4529q) new a((InterfaceC4602a) interfaceC5822c, this.f18525c));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, this.f18525c));
        }
    }
}
