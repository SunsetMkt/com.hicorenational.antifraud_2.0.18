package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableWithLatestFrom.java */
/* renamed from: g.a.y0.e.d.d4 */
/* loaded from: classes2.dex */
public final class C4930d4<T, U, R> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    final InterfaceC4572c<? super T, ? super U, ? extends R> f18910b;

    /* renamed from: c */
    final InterfaceC4504g0<? extends U> f18911c;

    /* compiled from: ObservableWithLatestFrom.java */
    /* renamed from: g.a.y0.e.d.d4$a */
    final class a implements InterfaceC4514i0<U> {

        /* renamed from: a */
        private final b<T, U, R> f18912a;

        a(b<T, U, R> bVar) {
            this.f18912a = bVar;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18912a.otherError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(U u) {
            this.f18912a.lazySet(u);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f18912a.setOther(interfaceC4552c);
        }
    }

    /* compiled from: ObservableWithLatestFrom.java */
    /* renamed from: g.a.y0.e.d.d4$b */
    static final class b<T, U, R> extends AtomicReference<U> implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -312246233408980075L;
        final InterfaceC4514i0<? super R> actual;
        final InterfaceC4572c<? super T, ? super U, ? extends R> combiner;

        /* renamed from: s */
        final AtomicReference<InterfaceC4552c> f18914s = new AtomicReference<>();
        final AtomicReference<InterfaceC4552c> other = new AtomicReference<>();

        b(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
            this.actual = interfaceC4514i0;
            this.combiner = interfaceC4572c;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this.f18914s);
            EnumC4592d.dispose(this.other);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(this.f18914s.get());
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            EnumC4592d.dispose(this.other);
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            EnumC4592d.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(C4601b.m18284a(this.combiner.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    dispose();
                    this.actual.onError(th);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this.f18914s, interfaceC4552c);
        }

        public void otherError(Throwable th) {
            EnumC4592d.dispose(this.f18914s);
            this.actual.onError(th);
        }

        public boolean setOther(InterfaceC4552c interfaceC4552c) {
            return EnumC4592d.setOnce(this.other, interfaceC4552c);
        }
    }

    public C4930d4(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, InterfaceC4504g0<? extends U> interfaceC4504g02) {
        super(interfaceC4504g0);
        this.f18910b = interfaceC4572c;
        this.f18911c = interfaceC4504g02;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        C4466m c4466m = new C4466m(interfaceC4514i0);
        b bVar = new b(c4466m, this.f18910b);
        c4466m.onSubscribe(bVar);
        this.f18911c.subscribe(new a(bVar));
        this.f18742a.subscribe(bVar);
    }
}
