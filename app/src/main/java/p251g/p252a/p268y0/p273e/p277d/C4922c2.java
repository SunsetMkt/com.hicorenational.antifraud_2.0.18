package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p258f1.C4497e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservablePublishSelector.java */
/* renamed from: g.a.y0.e.d.c2 */
/* loaded from: classes2.dex */
public final class C4922c2<T, R> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> f18831b;

    /* compiled from: ObservablePublishSelector.java */
    /* renamed from: g.a.y0.e.d.c2$a */
    static final class a<T, R> implements InterfaceC4514i0<T> {

        /* renamed from: a */
        final C4497e<T> f18832a;

        /* renamed from: b */
        final AtomicReference<InterfaceC4552c> f18833b;

        a(C4497e<T> c4497e, AtomicReference<InterfaceC4552c> atomicReference) {
            this.f18832a = c4497e;
            this.f18833b = atomicReference;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18832a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18832a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f18832a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this.f18833b, interfaceC4552c);
        }
    }

    /* compiled from: ObservablePublishSelector.java */
    /* renamed from: g.a.y0.e.d.c2$b */
    static final class b<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<R>, InterfaceC4552c {
        private static final long serialVersionUID = 854110278590336484L;
        final InterfaceC4514i0<? super R> actual;

        /* renamed from: d */
        InterfaceC4552c f18834d;

        b(InterfaceC4514i0<? super R> interfaceC4514i0) {
            this.actual = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18834d.dispose();
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18834d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            EnumC4592d.dispose(this);
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            EnumC4592d.dispose(this);
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18834d, interfaceC4552c)) {
                this.f18834d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4922c2(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o) {
        super(interfaceC4504g0);
        this.f18831b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        C4497e m17335T = C4497e.m17335T();
        try {
            InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f18831b.apply(m17335T), "The selector returned a null ObservableSource");
            b bVar = new b(interfaceC4514i0);
            interfaceC4504g0.subscribe(bVar);
            this.f18742a.subscribe(new a(m17335T, bVar));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4514i0);
        }
    }
}
