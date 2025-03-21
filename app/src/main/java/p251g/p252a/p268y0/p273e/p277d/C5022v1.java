package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableMapNotification.java */
/* renamed from: g.a.y0.e.d.v1 */
/* loaded from: classes2.dex */
public final class C5022v1<T, R> extends AbstractC4907a<T, InterfaceC4504g0<? extends R>> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> f19444b;

    /* renamed from: c */
    final InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends R>> f19445c;

    /* renamed from: d */
    final Callable<? extends InterfaceC4504g0<? extends R>> f19446d;

    /* compiled from: ObservableMapNotification.java */
    /* renamed from: g.a.y0.e.d.v1$a */
    static final class a<T, R> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super InterfaceC4504g0<? extends R>> f19447a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> f19448b;

        /* renamed from: c */
        final InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends R>> f19449c;

        /* renamed from: d */
        final Callable<? extends InterfaceC4504g0<? extends R>> f19450d;

        /* renamed from: e */
        InterfaceC4552c f19451e;

        a(InterfaceC4514i0<? super InterfaceC4504g0<? extends R>> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o2, Callable<? extends InterfaceC4504g0<? extends R>> callable) {
            this.f19447a = interfaceC4514i0;
            this.f19448b = interfaceC4584o;
            this.f19449c = interfaceC4584o2;
            this.f19450d = callable;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19451e.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19451e.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            try {
                this.f19447a.onNext((InterfaceC4504g0) C4601b.m18284a(this.f19450d.call(), "The onComplete ObservableSource returned is null"));
                this.f19447a.onComplete();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19447a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            try {
                this.f19447a.onNext((InterfaceC4504g0) C4601b.m18284a(this.f19449c.apply(th), "The onError ObservableSource returned is null"));
                this.f19447a.onComplete();
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f19447a.onError(new C4560a(th, th2));
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            try {
                this.f19447a.onNext((InterfaceC4504g0) C4601b.m18284a(this.f19448b.apply(t), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19447a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19451e, interfaceC4552c)) {
                this.f19451e = interfaceC4552c;
                this.f19447a.onSubscribe(this);
            }
        }
    }

    public C5022v1(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o2, Callable<? extends InterfaceC4504g0<? extends R>> callable) {
        super(interfaceC4504g0);
        this.f19444b = interfaceC4584o;
        this.f19445c = interfaceC4584o2;
        this.f19446d = callable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super InterfaceC4504g0<? extends R>> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19444b, this.f19445c, this.f19446d));
    }
}
