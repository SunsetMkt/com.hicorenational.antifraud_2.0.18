package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableSkipWhile.java */
/* renamed from: g.a.y0.e.d.e3 */
/* loaded from: classes2.dex */
public final class C4935e3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4587r<? super T> f18945b;

    /* compiled from: ObservableSkipWhile.java */
    /* renamed from: g.a.y0.e.d.e3$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18946a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f18947b;

        /* renamed from: c */
        InterfaceC4552c f18948c;

        /* renamed from: d */
        boolean f18949d;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f18946a = interfaceC4514i0;
            this.f18947b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18948c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18948c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18946a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18946a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18949d) {
                this.f18946a.onNext(t);
                return;
            }
            try {
                if (this.f18947b.test(t)) {
                    return;
                }
                this.f18949d = true;
                this.f18946a.onNext(t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18948c.dispose();
                this.f18946a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18948c, interfaceC4552c)) {
                this.f18948c = interfaceC4552c;
                this.f18946a.onSubscribe(this);
            }
        }
    }

    public C4935e3(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4587r<? super T> interfaceC4587r) {
        super(interfaceC4504g0);
        this.f18945b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f18945b));
    }
}
