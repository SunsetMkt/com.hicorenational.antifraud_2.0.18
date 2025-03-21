package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.AbstractC5154d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableFromArray.java */
/* renamed from: g.a.y0.e.b.d1 */
/* loaded from: classes2.dex */
public final class C4706d1<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final T[] f17826b;

    /* compiled from: FlowableFromArray.java */
    /* renamed from: g.a.y0.e.b.d1$a */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final InterfaceC4602a<? super T> actual;

        a(InterfaceC4602a<? super T> interfaceC4602a, T[] tArr) {
            super(tArr);
            this.actual = interfaceC4602a;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4706d1.c
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            InterfaceC4602a<? super T> interfaceC4602a = this.actual;
            for (int i2 = this.index; i2 != length; i2++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    interfaceC4602a.onError(new NullPointerException("array element is null"));
                    return;
                }
                interfaceC4602a.tryOnNext(t);
            }
            if (this.cancelled) {
                return;
            }
            interfaceC4602a.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
        
            r10.index = r2;
            r6 = addAndGet(-r11);
         */
        @Override // p251g.p252a.p268y0.p273e.p275b.C4706d1.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                g.a.y0.c.a<? super T> r3 = r10.actual
                r4 = 0
                r6 = r11
            La:
                r11 = r4
            Lb:
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 == 0) goto L31
                if (r2 == r1) goto L31
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L16
                return
            L16:
                r8 = r0[r2]
                if (r8 != 0) goto L25
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L25:
                boolean r8 = r3.tryOnNext(r8)
                if (r8 == 0) goto L2e
                r8 = 1
                long r11 = r11 + r8
            L2e:
                int r2 = r2 + 1
                goto Lb
            L31:
                if (r2 != r1) goto L3b
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L3a
                r3.onComplete()
            L3a:
                return
            L3b:
                long r6 = r10.get()
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 != 0) goto Lb
                r10.index = r2
                long r11 = -r11
                long r6 = r10.addAndGet(r11)
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4706d1.a.slowPath(long):void");
        }
    }

    /* compiled from: FlowableFromArray.java */
    /* renamed from: g.a.y0.e.b.d1$b */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final InterfaceC5822c<? super T> actual;

        b(InterfaceC5822c<? super T> interfaceC5822c, T[] tArr) {
            super(tArr);
            this.actual = interfaceC5822c;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4706d1.c
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            for (int i2 = this.index; i2 != length; i2++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    interfaceC5822c.onError(new NullPointerException("array element is null"));
                    return;
                }
                interfaceC5822c.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            interfaceC5822c.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        
            r10.index = r2;
            r6 = addAndGet(-r11);
         */
        @Override // p251g.p252a.p268y0.p273e.p275b.C4706d1.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                i.d.c<? super T> r3 = r10.actual
                r4 = 0
                r6 = r11
            La:
                r11 = r4
            Lb:
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 == 0) goto L2e
                if (r2 == r1) goto L2e
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L16
                return
            L16:
                r8 = r0[r2]
                if (r8 != 0) goto L25
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L25:
                r3.onNext(r8)
                r8 = 1
                long r11 = r11 + r8
                int r2 = r2 + 1
                goto Lb
            L2e:
                if (r2 != r1) goto L38
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L37
                r3.onComplete()
            L37:
                return
            L38:
                long r6 = r10.get()
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 != 0) goto Lb
                r10.index = r2
                long r11 = -r11
                long r6 = r10.addAndGet(r11)
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4706d1.b.slowPath(long):void");
        }
    }

    /* compiled from: FlowableFromArray.java */
    /* renamed from: g.a.y0.e.b.d1$c */
    static abstract class c<T> extends AbstractC5154d<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        c(T[] tArr) {
            this.array = tArr;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public final void clear() {
            this.index = this.array.length;
        }

        abstract void fastPath();

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public final T poll() {
            int i2 = this.index;
            T[] tArr = this.array;
            if (i2 == tArr.length) {
                return null;
            }
            this.index = i2 + 1;
            return (T) C4601b.m18284a((Object) tArr[i2], "array element is null");
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
    }

    public C4706d1(T[] tArr) {
        this.f17826b = tArr;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            interfaceC5822c.onSubscribe(new a((InterfaceC4602a) interfaceC5822c, this.f17826b));
        } else {
            interfaceC5822c.onSubscribe(new b(interfaceC5822c, this.f17826b));
        }
    }
}
