package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeDelay.java */
/* renamed from: g.a.y0.e.c.l */
/* loaded from: classes2.dex */
public final class C4869l<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final long f18642b;

    /* renamed from: c */
    final TimeUnit f18643c;

    /* renamed from: d */
    final AbstractC4516j0 f18644d;

    /* compiled from: MaybeDelay.java */
    /* renamed from: g.a.y0.e.c.l$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        final InterfaceC4559v<? super T> actual;
        final long delay;
        Throwable error;
        final AbstractC4516j0 scheduler;
        final TimeUnit unit;
        T value;

        a(InterfaceC4559v<? super T> interfaceC4559v, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC4559v;
            this.delay = j2;
            this.unit = timeUnit;
            this.scheduler = abstractC4516j0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            schedule();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.error = th;
            schedule();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.value = t;
            schedule();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
        }

        void schedule() {
            EnumC4592d.replace(this, this.scheduler.mo17409a(this, this.delay, this.unit));
        }
    }

    public C4869l(InterfaceC4588y<T> interfaceC4588y, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4588y);
        this.f18642b = j2;
        this.f18643c = timeUnit;
        this.f18644d = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18642b, this.f18643c, this.f18644d));
    }
}
