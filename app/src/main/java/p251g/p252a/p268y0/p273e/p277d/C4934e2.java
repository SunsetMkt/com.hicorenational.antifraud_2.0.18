package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p272d.AbstractC4619b;

/* compiled from: ObservableRangeLong.java */
/* renamed from: g.a.y0.e.d.e2 */
/* loaded from: classes2.dex */
public final class C4934e2 extends AbstractC4469b0<Long> {

    /* renamed from: a */
    private final long f18943a;

    /* renamed from: b */
    private final long f18944b;

    /* compiled from: ObservableRangeLong.java */
    /* renamed from: g.a.y0.e.d.e2$a */
    static final class a extends AbstractC4619b<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final InterfaceC4514i0<? super Long> actual;
        final long end;
        boolean fused;
        long index;

        a(InterfaceC4514i0<? super Long> interfaceC4514i0, long j2, long j3) {
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
            InterfaceC4514i0<? super Long> interfaceC4514i0 = this.actual;
            long j2 = this.end;
            for (long j3 = this.index; j3 != j2 && get() == 0; j3++) {
                interfaceC4514i0.onNext(Long.valueOf(j3));
            }
            if (get() == 0) {
                lazySet(1);
                interfaceC4514i0.onComplete();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public Long poll() throws Exception {
            long j2 = this.index;
            if (j2 != this.end) {
                this.index = 1 + j2;
                return Long.valueOf(j2);
            }
            lazySet(1);
            return null;
        }
    }

    public C4934e2(long j2, long j3) {
        this.f18943a = j2;
        this.f18944b = j3;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super Long> interfaceC4514i0) {
        long j2 = this.f18943a;
        a aVar = new a(interfaceC4514i0, j2, j2 + this.f18944b);
        interfaceC4514i0.onSubscribe(aVar);
        aVar.run();
    }
}
