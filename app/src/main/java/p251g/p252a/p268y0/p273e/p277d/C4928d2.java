package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p272d.AbstractC4619b;

/* compiled from: ObservableRange.java */
/* renamed from: g.a.y0.e.d.d2 */
/* loaded from: classes2.dex */
public final class C4928d2 extends AbstractC4469b0<Integer> {

    /* renamed from: a */
    private final int f18897a;

    /* renamed from: b */
    private final long f18898b;

    /* compiled from: ObservableRange.java */
    /* renamed from: g.a.y0.e.d.d2$a */
    static final class a extends AbstractC4619b<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        final InterfaceC4514i0<? super Integer> actual;
        final long end;
        boolean fused;
        long index;

        a(InterfaceC4514i0<? super Integer> interfaceC4514i0, long j2, long j3) {
            this.actual = interfaceC4514i0;
            this.index = j2;
            this.end = j3;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            set(1);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        void run() {
            if (this.fused) {
                return;
            }
            InterfaceC4514i0<? super Integer> interfaceC4514i0 = this.actual;
            long j2 = this.end;
            for (long j3 = this.index; j3 != j2 && get() == 0; j3++) {
                interfaceC4514i0.onNext(Integer.valueOf((int) j3));
            }
            if (get() == 0) {
                lazySet(1);
                interfaceC4514i0.onComplete();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public Integer poll() throws Exception {
            long j2 = this.index;
            if (j2 != this.end) {
                this.index = 1 + j2;
                return Integer.valueOf((int) j2);
            }
            lazySet(1);
            return null;
        }
    }

    public C4928d2(int i2, int i3) {
        this.f18897a = i2;
        this.f18898b = i2 + i3;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super Integer> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0, this.f18897a, this.f18898b);
        interfaceC4514i0.onSubscribe(aVar);
        aVar.run();
    }
}
