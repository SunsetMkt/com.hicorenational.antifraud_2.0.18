package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4617a;

/* compiled from: ObservableMap.java */
/* renamed from: g.a.y0.e.d.u1 */
/* loaded from: classes2.dex */
public final class C5017u1<T, U> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends U> f19423b;

    /* compiled from: ObservableMap.java */
    /* renamed from: g.a.y0.e.d.u1$a */
    static final class a<T, U> extends AbstractC4617a<T, U> {

        /* renamed from: f */
        final InterfaceC4584o<? super T, ? extends U> f19424f;

        a(InterfaceC4514i0<? super U> interfaceC4514i0, InterfaceC4584o<? super T, ? extends U> interfaceC4584o) {
            super(interfaceC4514i0);
            this.f19424f = interfaceC4584o;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f17564d) {
                return;
            }
            if (this.f17565e != 0) {
                this.f17561a.onNext(null);
                return;
            }
            try {
                this.f17561a.onNext(C4601b.m18284a(this.f19424f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m18291a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public U poll() throws Exception {
            T poll = this.f17563c.poll();
            if (poll != null) {
                return (U) C4601b.m18284a(this.f19424f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18289a(i2);
        }
    }

    public C5017u1(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends U> interfaceC4584o) {
        super(interfaceC4504g0);
        this.f19423b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19423b));
    }
}
