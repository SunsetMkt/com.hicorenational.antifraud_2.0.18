package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableCollect.java */
/* renamed from: g.a.y0.e.d.s */
/* loaded from: classes2.dex */
public final class C5005s<T, U> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final Callable<? extends U> f19365b;

    /* renamed from: c */
    final InterfaceC4571b<? super U, ? super T> f19366c;

    /* compiled from: ObservableCollect.java */
    /* renamed from: g.a.y0.e.d.s$a */
    static final class a<T, U> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super U> f19367a;

        /* renamed from: b */
        final InterfaceC4571b<? super U, ? super T> f19368b;

        /* renamed from: c */
        final U f19369c;

        /* renamed from: d */
        InterfaceC4552c f19370d;

        /* renamed from: e */
        boolean f19371e;

        a(InterfaceC4514i0<? super U> interfaceC4514i0, U u, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
            this.f19367a = interfaceC4514i0;
            this.f19368b = interfaceC4571b;
            this.f19369c = u;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19370d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19370d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19371e) {
                return;
            }
            this.f19371e = true;
            this.f19367a.onNext(this.f19369c);
            this.f19367a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19371e) {
                C4476a.m17152b(th);
            } else {
                this.f19371e = true;
                this.f19367a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19371e) {
                return;
            }
            try {
                this.f19368b.mo18209a(this.f19369c, t);
            } catch (Throwable th) {
                this.f19370d.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19370d, interfaceC4552c)) {
                this.f19370d = interfaceC4552c;
                this.f19367a.onSubscribe(this);
            }
        }
    }

    public C5005s(InterfaceC4504g0<T> interfaceC4504g0, Callable<? extends U> callable, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
        super(interfaceC4504g0);
        this.f19365b = callable;
        this.f19366c = interfaceC4571b;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        try {
            this.f18742a.subscribe(new a(interfaceC4514i0, C4601b.m18284a(this.f19365b.call(), "The initialSupplier returned a null value"), this.f19366c));
        } catch (Throwable th) {
            EnumC4593e.error(th, interfaceC4514i0);
        }
    }
}
