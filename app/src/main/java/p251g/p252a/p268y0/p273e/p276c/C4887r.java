package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeDoFinally.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.c.r */
/* loaded from: classes2.dex */
public final class C4887r<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4570a f18691b;

    /* compiled from: MaybeDoFinally.java */
    /* renamed from: g.a.y0.e.c.r$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = 4109457741734051389L;
        final InterfaceC4559v<? super T> actual;

        /* renamed from: d */
        InterfaceC4552c f18692d;
        final InterfaceC4570a onFinally;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4570a interfaceC4570a) {
            this.actual = interfaceC4559v;
            this.onFinally = interfaceC4570a;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18692d.dispose();
            runFinally();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18692d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18692d, interfaceC4552c)) {
                this.f18692d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            runFinally();
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

    public C4887r(InterfaceC4588y<T> interfaceC4588y, InterfaceC4570a interfaceC4570a) {
        super(interfaceC4588y);
        this.f18691b = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18691b));
    }
}
