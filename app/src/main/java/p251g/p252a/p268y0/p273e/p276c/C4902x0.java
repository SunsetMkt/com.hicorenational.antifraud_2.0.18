package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeObserveOn.java */
/* renamed from: g.a.y0.e.c.x0 */
/* loaded from: classes2.dex */
public final class C4902x0<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final AbstractC4516j0 f18724b;

    /* compiled from: MaybeObserveOn.java */
    /* renamed from: g.a.y0.e.c.x0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final InterfaceC4559v<? super T> actual;
        Throwable error;
        final AbstractC4516j0 scheduler;
        T value;

        a(InterfaceC4559v<? super T> interfaceC4559v, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC4559v;
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
            EnumC4592d.replace(this, this.scheduler.mo17407a(this));
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.error = th;
            EnumC4592d.replace(this, this.scheduler.mo17407a(this));
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
            EnumC4592d.replace(this, this.scheduler.mo17407a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t == null) {
                this.actual.onComplete();
            } else {
                this.value = null;
                this.actual.onSuccess(t);
            }
        }
    }

    public C4902x0(InterfaceC4588y<T> interfaceC4588y, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4588y);
        this.f18724b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18724b));
    }
}
