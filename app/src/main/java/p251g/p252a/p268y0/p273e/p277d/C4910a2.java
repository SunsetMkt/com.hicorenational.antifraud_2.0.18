package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableOnErrorReturn.java */
/* renamed from: g.a.y0.e.d.a2 */
/* loaded from: classes2.dex */
public final class C4910a2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super Throwable, ? extends T> f18750b;

    /* compiled from: ObservableOnErrorReturn.java */
    /* renamed from: g.a.y0.e.d.a2$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18751a;

        /* renamed from: b */
        final InterfaceC4584o<? super Throwable, ? extends T> f18752b;

        /* renamed from: c */
        InterfaceC4552c f18753c;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o) {
            this.f18751a = interfaceC4514i0;
            this.f18752b = interfaceC4584o;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18753c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18753c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18751a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            try {
                T apply = this.f18752b.apply(th);
                if (apply != null) {
                    this.f18751a.onNext(apply);
                    this.f18751a.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f18751a.onError(nullPointerException);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f18751a.onError(new C4560a(th, th2));
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f18751a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18753c, interfaceC4552c)) {
                this.f18753c = interfaceC4552c;
                this.f18751a.onSubscribe(this);
            }
        }
    }

    public C4910a2(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o) {
        super(interfaceC4504g0);
        this.f18750b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f18750b));
    }
}
