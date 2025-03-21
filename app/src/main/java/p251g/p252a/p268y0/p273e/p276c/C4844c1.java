package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeSubscribeOn.java */
/* renamed from: g.a.y0.e.c.c1 */
/* loaded from: classes2.dex */
public final class C4844c1<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final AbstractC4516j0 f18584b;

    /* compiled from: MaybeSubscribeOn.java */
    /* renamed from: g.a.y0.e.c.c1$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = 8571289934935992137L;
        final InterfaceC4559v<? super T> actual;
        final C4599k task = new C4599k();

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.actual = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            this.task.dispose();
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
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* compiled from: MaybeSubscribeOn.java */
    /* renamed from: g.a.y0.e.c.c1$b */
    static final class b<T> implements Runnable {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18585a;

        /* renamed from: b */
        final InterfaceC4588y<T> f18586b;

        b(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4588y<T> interfaceC4588y) {
            this.f18585a = interfaceC4559v;
            this.f18586b = interfaceC4588y;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18586b.mo18100a(this.f18585a);
        }
    }

    public C4844c1(InterfaceC4588y<T> interfaceC4588y, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4588y);
        this.f18584b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        a aVar = new a(interfaceC4559v);
        interfaceC4559v.onSubscribe(aVar);
        aVar.task.replace(this.f18584b.mo17407a(new b(aVar, this.f18548a)));
    }
}
