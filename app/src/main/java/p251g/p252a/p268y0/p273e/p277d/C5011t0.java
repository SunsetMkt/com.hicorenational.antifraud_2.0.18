package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p272d.AbstractC4617a;

/* compiled from: ObservableFilter.java */
/* renamed from: g.a.y0.e.d.t0 */
/* loaded from: classes2.dex */
public final class C5011t0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4587r<? super T> f19400b;

    /* compiled from: ObservableFilter.java */
    /* renamed from: g.a.y0.e.d.t0$a */
    static final class a<T> extends AbstractC4617a<T, T> {

        /* renamed from: f */
        final InterfaceC4587r<? super T> f19401f;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4587r<? super T> interfaceC4587r) {
            super(interfaceC4514i0);
            this.f19401f = interfaceC4587r;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f17565e != 0) {
                this.f17561a.onNext(null);
                return;
            }
            try {
                if (this.f19401f.test(t)) {
                    this.f17561a.onNext(t);
                }
            } catch (Throwable th) {
                m18291a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f17563c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f19401f.test(poll));
            return poll;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18289a(i2);
        }
    }

    public C5011t0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4587r<? super T> interfaceC4587r) {
        super(interfaceC4504g0);
        this.f19400b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19400b));
    }
}
