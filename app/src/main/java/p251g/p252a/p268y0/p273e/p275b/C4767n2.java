package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.AbstractC5154d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableRange.java */
/* renamed from: g.a.y0.e.b.n2 */
/* loaded from: classes2.dex */
public final class C4767n2 extends AbstractC4519l<Integer> {

    /* renamed from: b */
    final int f18120b;

    /* renamed from: c */
    final int f18121c;

    /* compiled from: FlowableRange.java */
    /* renamed from: g.a.y0.e.b.n2$a */
    static abstract class a extends AbstractC5154d<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        a(int i2, int i3) {
            this.index = i2;
            this.end = i3;
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
        public final Integer poll() {
            int i2 = this.index;
            if (i2 == this.end) {
                return null;
            }
            this.index = i2 + 1;
            return Integer.valueOf(i2);
        }
    }

    /* compiled from: FlowableRange.java */
    /* renamed from: g.a.y0.e.b.n2$b */
    static final class b extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final InterfaceC4602a<? super Integer> actual;

        b(InterfaceC4602a<? super Integer> interfaceC4602a, int i2, int i3) {
            super(i2, i3);
            this.actual = interfaceC4602a;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4767n2.a
        void fastPath() {
            int i2 = this.end;
            InterfaceC4602a<? super Integer> interfaceC4602a = this.actual;
            for (int i3 = this.index; i3 != i2; i3++) {
                if (this.cancelled) {
                    return;
                }
                interfaceC4602a.tryOnNext(Integer.valueOf(i3));
            }
            if (this.cancelled) {
                return;
            }
            interfaceC4602a.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        
            r9.index = r1;
            r5 = addAndGet(-r10);
         */
        @Override // p251g.p252a.p268y0.p273e.p275b.C4767n2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r10) {
            /*
                r9 = this;
                int r0 = r9.end
                int r1 = r9.index
                g.a.y0.c.a<? super java.lang.Integer> r2 = r9.actual
                r3 = 0
                r5 = r10
            L9:
                r10 = r3
            La:
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 == 0) goto L25
                if (r1 == r0) goto L25
                boolean r7 = r9.cancelled
                if (r7 == 0) goto L15
                return
            L15:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                boolean r7 = r2.tryOnNext(r7)
                if (r7 == 0) goto L22
                r7 = 1
                long r10 = r10 + r7
            L22:
                int r1 = r1 + 1
                goto La
            L25:
                if (r1 != r0) goto L2f
                boolean r10 = r9.cancelled
                if (r10 != 0) goto L2e
                r2.onComplete()
            L2e:
                return
            L2f:
                long r5 = r9.get()
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 != 0) goto La
                r9.index = r1
                long r10 = -r10
                long r5 = r9.addAndGet(r10)
                int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r10 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4767n2.b.slowPath(long):void");
        }
    }

    /* compiled from: FlowableRange.java */
    /* renamed from: g.a.y0.e.b.n2$c */
    static final class c extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final InterfaceC5822c<? super Integer> actual;

        c(InterfaceC5822c<? super Integer> interfaceC5822c, int i2, int i3) {
            super(i2, i3);
            this.actual = interfaceC5822c;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4767n2.a
        void fastPath() {
            int i2 = this.end;
            InterfaceC5822c<? super Integer> interfaceC5822c = this.actual;
            for (int i3 = this.index; i3 != i2; i3++) {
                if (this.cancelled) {
                    return;
                }
                interfaceC5822c.onNext(Integer.valueOf(i3));
            }
            if (this.cancelled) {
                return;
            }
            interfaceC5822c.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        
            r9.index = r1;
            r5 = addAndGet(-r10);
         */
        @Override // p251g.p252a.p268y0.p273e.p275b.C4767n2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r10) {
            /*
                r9 = this;
                int r0 = r9.end
                int r1 = r9.index
                i.d.c<? super java.lang.Integer> r2 = r9.actual
                r3 = 0
                r5 = r10
            L9:
                r10 = r3
            La:
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 == 0) goto L22
                if (r1 == r0) goto L22
                boolean r7 = r9.cancelled
                if (r7 == 0) goto L15
                return
            L15:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r2.onNext(r7)
                r7 = 1
                long r10 = r10 + r7
                int r1 = r1 + 1
                goto La
            L22:
                if (r1 != r0) goto L2c
                boolean r10 = r9.cancelled
                if (r10 != 0) goto L2b
                r2.onComplete()
            L2b:
                return
            L2c:
                long r5 = r9.get()
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 != 0) goto La
                r9.index = r1
                long r10 = -r10
                long r5 = r9.addAndGet(r10)
                int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r10 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4767n2.c.slowPath(long):void");
        }
    }

    public C4767n2(int i2, int i3) {
        this.f18120b = i2;
        this.f18121c = i2 + i3;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super Integer> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            interfaceC5822c.onSubscribe(new b((InterfaceC4602a) interfaceC5822c, this.f18120b, this.f18121c));
        } else {
            interfaceC5822c.onSubscribe(new c(interfaceC5822c, this.f18120b, this.f18121c));
        }
    }
}
