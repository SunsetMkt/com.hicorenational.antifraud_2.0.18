package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p272d.AbstractC4617a;

/* compiled from: ObservableDistinctUntilChanged.java */
/* renamed from: g.a.y0.e.d.j0 */
/* loaded from: classes2.dex */
public final class C4961j0<T, K> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, K> f19081b;

    /* renamed from: c */
    final InterfaceC4573d<? super K, ? super K> f19082c;

    /* compiled from: ObservableDistinctUntilChanged.java */
    /* renamed from: g.a.y0.e.d.j0$a */
    static final class a<T, K> extends AbstractC4617a<T, T> {

        /* renamed from: f */
        final InterfaceC4584o<? super T, K> f19083f;

        /* renamed from: g */
        final InterfaceC4573d<? super K, ? super K> f19084g;

        /* renamed from: h */
        K f19085h;

        /* renamed from: i */
        boolean f19086i;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4584o<? super T, K> interfaceC4584o, InterfaceC4573d<? super K, ? super K> interfaceC4573d) {
            super(interfaceC4514i0);
            this.f19083f = interfaceC4584o;
            this.f19084g = interfaceC4573d;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f17564d) {
                return;
            }
            if (this.f17565e != 0) {
                this.f17561a.onNext(t);
                return;
            }
            try {
                K apply = this.f19083f.apply(t);
                if (this.f19086i) {
                    boolean mo18210a = this.f19084g.mo18210a(this.f19085h, apply);
                    this.f19085h = apply;
                    if (mo18210a) {
                        return;
                    }
                } else {
                    this.f19086i = true;
                    this.f19085h = apply;
                }
                this.f17561a.onNext(t);
            } catch (Throwable th) {
                m18291a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            while (true) {
                T poll = this.f17563c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f19083f.apply(poll);
                if (!this.f19086i) {
                    this.f19086i = true;
                    this.f19085h = apply;
                    return poll;
                }
                if (!this.f19084g.mo18210a(this.f19085h, apply)) {
                    this.f19085h = apply;
                    return poll;
                }
                this.f19085h = apply;
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18289a(i2);
        }
    }

    public C4961j0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, K> interfaceC4584o, InterfaceC4573d<? super K, ? super K> interfaceC4573d) {
        super(interfaceC4504g0);
        this.f19081b = interfaceC4584o;
        this.f19082c = interfaceC4573d;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19081b, this.f19082c));
    }
}
