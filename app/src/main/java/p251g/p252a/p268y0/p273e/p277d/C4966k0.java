package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p272d.AbstractC4617a;

/* compiled from: ObservableDoAfterNext.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.d.k0 */
/* loaded from: classes2.dex */
public final class C4966k0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4576g<? super T> f19097b;

    /* compiled from: ObservableDoAfterNext.java */
    /* renamed from: g.a.y0.e.d.k0$a */
    static final class a<T> extends AbstractC4617a<T, T> {

        /* renamed from: f */
        final InterfaceC4576g<? super T> f19098f;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4576g<? super T> interfaceC4576g) {
            super(interfaceC4514i0);
            this.f19098f = interfaceC4576g;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f17561a.onNext(t);
            if (this.f17565e == 0) {
                try {
                    this.f19098f.accept(t);
                } catch (Throwable th) {
                    m18291a(th);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll = this.f17563c.poll();
            if (poll != null) {
                this.f19098f.accept(poll);
            }
            return poll;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18289a(i2);
        }
    }

    public C4966k0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4576g<? super T> interfaceC4576g) {
        super(interfaceC4504g0);
        this.f19097b = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19097b));
    }
}
