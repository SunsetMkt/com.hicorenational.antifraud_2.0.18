package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeUnsubscribeOn.java */
/* renamed from: g.a.y0.e.c.p1 */
/* loaded from: classes2.dex */
public final class C4883p1<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final AbstractC4516j0 f18678b;

    /* compiled from: MaybeUnsubscribeOn.java */
    /* renamed from: g.a.y0.e.c.p1$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final InterfaceC4559v<? super T> actual;

        /* renamed from: ds */
        InterfaceC4552c f18679ds;
        final AbstractC4516j0 scheduler;

        a(InterfaceC4559v<? super T> interfaceC4559v, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC4559v;
            this.scheduler = abstractC4516j0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4552c andSet = getAndSet(EnumC4592d.DISPOSED);
            if (andSet != EnumC4592d.DISPOSED) {
                this.f18679ds = andSet;
                this.scheduler.mo17407a(this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18679ds.dispose();
        }
    }

    public C4883p1(InterfaceC4588y<T> interfaceC4588y, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4588y);
        this.f18678b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18678b));
    }
}
