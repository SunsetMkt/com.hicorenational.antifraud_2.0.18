package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.AbstractC5154d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableRangeLong.java */
/* renamed from: g.a.y0.e.b.o2 */
/* loaded from: classes2.dex */
public final class C4773o2 extends AbstractC4519l<Long> {

    /* renamed from: b */
    final long f18166b;

    /* renamed from: c */
    final long f18167c;

    /* compiled from: FlowableRangeLong.java */
    /* renamed from: g.a.y0.e.b.o2$a */
    static abstract class a extends AbstractC5154d<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        a(long j2, long j3) {
            this.index = j2;
            this.end = j3;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public final void clear() {
            this.index = this.end;
        }

        abstract void fastPath();

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void request(long j2) {
            if (EnumC5160j.validate(j2) && C5164d.m18607a(this, j2) == 0) {
                if (j2 == C5556m0.f20396b) {
                    fastPath();
                } else {
                    slowPath(j2);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public final int requestFusion(int i2) {
            return i2 & 1;
        }

        abstract void slowPath(long j2);

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public final Long poll() {
            long j2 = this.index;
            if (j2 == this.end) {
                return null;
            }
            this.index = 1 + j2;
            return Long.valueOf(j2);
        }
    }

    /* compiled from: FlowableRangeLong.java */
    /* renamed from: g.a.y0.e.b.o2$b */
    static final class b extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final InterfaceC4602a<? super Long> actual;

        b(InterfaceC4602a<? super Long> interfaceC4602a, long j2, long j3) {
            super(j2, j3);
            this.actual = interfaceC4602a;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4773o2.a
        void fastPath() {
            long j2 = this.end;
            InterfaceC4602a<? super Long> interfaceC4602a = this.actual;
            for (long j3 = this.index; j3 != j2; j3++) {
                if (this.cancelled) {
                    return;
                }
                interfaceC4602a.tryOnNext(Long.valueOf(j3));
            }
            if (this.cancelled) {
                return;
            }
            interfaceC4602a.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
        
            r12.index = r7;
            r2 = addAndGet(-r13);
         */
        @Override // p251g.p252a.p268y0.p273e.p275b.C4773o2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r13) {
            /*
                r12 = this;
                long r0 = r12.end
                long r2 = r12.index
                g.a.y0.c.a<? super java.lang.Long> r4 = r12.actual
                r5 = 0
                r7 = r2
                r2 = r13
            La:
                r13 = r5
            Lb:
                int r9 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
                if (r9 == 0) goto L27
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 == 0) goto L27
                boolean r9 = r12.cancelled
                if (r9 == 0) goto L18
                return
            L18:
                java.lang.Long r9 = java.lang.Long.valueOf(r7)
                boolean r9 = r4.tryOnNext(r9)
                r10 = 1
                if (r9 == 0) goto L25
                long r13 = r13 + r10
            L25:
                long r7 = r7 + r10
                goto Lb
            L27:
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 != 0) goto L33
                boolean r13 = r12.cancelled
                if (r13 != 0) goto L32
                r4.onComplete()
            L32:
                return
            L33:
                long r2 = r12.get()
                int r9 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
                if (r9 != 0) goto Lb
                r12.index = r7
                long r13 = -r13
                long r2 = r12.addAndGet(r13)
                int r13 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r13 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4773o2.b.slowPath(long):void");
        }
    }

    /* compiled from: FlowableRangeLong.java */
    /* renamed from: g.a.y0.e.b.o2$c */
    static final class c extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final InterfaceC5822c<? super Long> actual;

        c(InterfaceC5822c<? super Long> interfaceC5822c, long j2, long j3) {
            super(j2, j3);
            this.actual = interfaceC5822c;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4773o2.a
        void fastPath() {
            long j2 = this.end;
            InterfaceC5822c<? super Long> interfaceC5822c = this.actual;
            for (long j3 = this.index; j3 != j2; j3++) {
                if (this.cancelled) {
                    return;
                }
                interfaceC5822c.onNext(Long.valueOf(j3));
            }
            if (this.cancelled) {
                return;
            }
            interfaceC5822c.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        
            r11.index = r7;
            r2 = addAndGet(-r12);
         */
        @Override // p251g.p252a.p268y0.p273e.p275b.C4773o2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r12) {
            /*
                r11 = this;
                long r0 = r11.end
                long r2 = r11.index
                i.d.c<? super java.lang.Long> r4 = r11.actual
                r5 = 0
                r7 = r2
                r2 = r12
            La:
                r12 = r5
            Lb:
                int r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
                if (r9 == 0) goto L24
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 == 0) goto L24
                boolean r9 = r11.cancelled
                if (r9 == 0) goto L18
                return
            L18:
                java.lang.Long r9 = java.lang.Long.valueOf(r7)
                r4.onNext(r9)
                r9 = 1
                long r12 = r12 + r9
                long r7 = r7 + r9
                goto Lb
            L24:
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 != 0) goto L30
                boolean r12 = r11.cancelled
                if (r12 != 0) goto L2f
                r4.onComplete()
            L2f:
                return
            L30:
                long r2 = r11.get()
                int r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
                if (r9 != 0) goto Lb
                r11.index = r7
                long r12 = -r12
                long r2 = r11.addAndGet(r12)
                int r12 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r12 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4773o2.c.slowPath(long):void");
        }
    }

    public C4773o2(long j2, long j3) {
        this.f18166b = j2;
        this.f18167c = j2 + j3;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super Long> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            interfaceC5822c.onSubscribe(new b((InterfaceC4602a) interfaceC5822c, this.f18166b, this.f18167c));
        } else {
            interfaceC5822c.onSubscribe(new c(interfaceC5822c, this.f18166b, this.f18167c));
        }
    }
}
