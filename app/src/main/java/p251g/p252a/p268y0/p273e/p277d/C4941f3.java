package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableSubscribeOn.java */
/* renamed from: g.a.y0.e.d.f3 */
/* loaded from: classes2.dex */
public final class C4941f3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final AbstractC4516j0 f18975b;

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: g.a.y0.e.d.f3$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 8094547886072529208L;
        final InterfaceC4514i0<? super T> actual;

        /* renamed from: s */
        final AtomicReference<InterfaceC4552c> f18976s = new AtomicReference<>();

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.actual = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this.f18976s);
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this.f18976s, interfaceC4552c);
        }

        void setDisposable(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: g.a.y0.e.d.f3$b */
    final class b implements Runnable {

        /* renamed from: a */
        private final a<T> f18977a;

        b(a<T> aVar) {
            this.f18977a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4941f3.this.f18742a.subscribe(this.f18977a);
        }
    }

    public C4941f3(InterfaceC4504g0<T> interfaceC4504g0, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4504g0);
        this.f18975b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0);
        interfaceC4514i0.onSubscribe(aVar);
        aVar.setDisposable(this.f18975b.mo17407a(new b(aVar)));
    }
}
