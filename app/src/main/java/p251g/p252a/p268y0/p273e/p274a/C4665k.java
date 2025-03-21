package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CompletableDoFinally.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.a.k */
/* loaded from: classes2.dex */
public final class C4665k extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17712a;

    /* renamed from: b */
    final InterfaceC4570a f17713b;

    /* compiled from: CompletableDoFinally.java */
    /* renamed from: g.a.y0.e.a.k$a */
    static final class a extends AtomicInteger implements InterfaceC4491f, InterfaceC4552c {
        private static final long serialVersionUID = 4109457741734051389L;
        final InterfaceC4491f actual;

        /* renamed from: d */
        InterfaceC4552c f17714d;
        final InterfaceC4570a onFinally;

        a(InterfaceC4491f interfaceC4491f, InterfaceC4570a interfaceC4570a) {
            this.actual = interfaceC4491f;
            this.onFinally = interfaceC4570a;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17714d.dispose();
            runFinally();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17714d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f17714d, interfaceC4552c)) {
                this.f17714d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            }
        }
    }

    public C4665k(InterfaceC4513i interfaceC4513i, InterfaceC4570a interfaceC4570a) {
        this.f17712a = interfaceC4513i;
        this.f17713b = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17712a.mo17074a(new a(interfaceC4491f, this.f17713b));
    }
}
