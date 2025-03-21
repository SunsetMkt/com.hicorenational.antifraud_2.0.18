package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4517k;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p284j.C5164d;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableGenerate.java */
/* renamed from: g.a.y0.e.b.j1 */
/* loaded from: classes2.dex */
public final class C4742j1<T, S> extends AbstractC4519l<T> {

    /* renamed from: b */
    final Callable<S> f17971b;

    /* renamed from: c */
    final InterfaceC4572c<S, InterfaceC4517k<T>, S> f17972c;

    /* renamed from: d */
    final InterfaceC4576g<? super S> f17973d;

    /* compiled from: FlowableGenerate.java */
    /* renamed from: g.a.y0.e.b.j1$a */
    static final class a<T, S> extends AtomicLong implements InterfaceC4517k<T>, InterfaceC5823d {
        private static final long serialVersionUID = 7565982551505011832L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        final InterfaceC4576g<? super S> disposeState;
        final InterfaceC4572c<S, ? super InterfaceC4517k<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4572c<S, ? super InterfaceC4517k<T>, S> interfaceC4572c, InterfaceC4576g<? super S> interfaceC4576g, S s) {
            this.actual = interfaceC5822c;
            this.generator = interfaceC4572c;
            this.disposeState = interfaceC4576g;
            this.state = s;
        }

        /* renamed from: a */
        private void m18326a(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (C5164d.m18607a(this, 1L) == 0) {
                S s = this.state;
                this.state = null;
                m18326a(s);
            }
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onError(Throwable th) {
            if (this.terminate) {
                C4476a.m17152b(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onNext(T t) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.hasNext = true;
                this.actual.onNext(t);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
        
            r9.state = r0;
            r4 = addAndGet(-r10);
         */
        @Override // p324i.p338d.InterfaceC5823d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void request(long r10) {
            /*
                r9 = this;
                boolean r0 = p251g.p252a.p268y0.p283i.EnumC5160j.validate(r10)
                if (r0 != 0) goto L7
                return
            L7:
                long r0 = p251g.p252a.p268y0.p284j.C5164d.m18607a(r9, r10)
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L12
                return
            L12:
                S r0 = r9.state
                g.a.x0.c<S, ? super g.a.k<T>, S> r1 = r9.generator
                r4 = r10
            L17:
                r10 = r2
            L18:
                int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r6 == 0) goto L4e
                boolean r6 = r9.cancelled
                r7 = 0
                if (r6 == 0) goto L27
                r9.state = r7
                r9.m18326a(r0)
                return
            L27:
                r6 = 0
                r9.hasNext = r6
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r9)     // Catch: java.lang.Throwable -> L3f
                boolean r8 = r9.terminate
                if (r8 == 0) goto L3b
                r9.cancelled = r6
                r9.state = r7
                r9.m18326a(r0)
                return
            L3b:
                r6 = 1
                long r10 = r10 + r6
                goto L18
            L3f:
                r10 = move-exception
                p251g.p252a.p265v0.C4561b.m18199b(r10)
                r9.cancelled = r6
                r9.state = r7
                r9.onError(r10)
                r9.m18326a(r0)
                return
            L4e:
                long r4 = r9.get()
                int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r6 != 0) goto L18
                r9.state = r0
                long r10 = -r10
                long r4 = r9.addAndGet(r10)
                int r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r10 != 0) goto L17
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4742j1.a.request(long):void");
        }
    }

    public C4742j1(Callable<S> callable, InterfaceC4572c<S, InterfaceC4517k<T>, S> interfaceC4572c, InterfaceC4576g<? super S> interfaceC4576g) {
        this.f17971b = callable;
        this.f17972c = interfaceC4572c;
        this.f17973d = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        try {
            interfaceC5822c.onSubscribe(new a(interfaceC5822c, this.f17972c, this.f17973d, this.f17971b.call()));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
