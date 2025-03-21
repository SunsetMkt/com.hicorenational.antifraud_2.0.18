package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;

/* compiled from: ObservableCollectSingle.java */
/* renamed from: g.a.y0.e.d.t */
/* loaded from: classes2.dex */
public final class C5010t<T, U> extends AbstractC4518k0<U> implements InterfaceC4605d<U> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19392a;

    /* renamed from: b */
    final Callable<? extends U> f19393b;

    /* renamed from: c */
    final InterfaceC4571b<? super U, ? super T> f19394c;

    /* compiled from: ObservableCollectSingle.java */
    /* renamed from: g.a.y0.e.d.t$a */
    static final class a<T, U> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super U> f19395a;

        /* renamed from: b */
        final InterfaceC4571b<? super U, ? super T> f19396b;

        /* renamed from: c */
        final U f19397c;

        /* renamed from: d */
        InterfaceC4552c f19398d;

        /* renamed from: e */
        boolean f19399e;

        a(InterfaceC4524n0<? super U> interfaceC4524n0, U u, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
            this.f19395a = interfaceC4524n0;
            this.f19396b = interfaceC4571b;
            this.f19397c = u;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19398d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19398d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19399e) {
                return;
            }
            this.f19399e = true;
            this.f19395a.onSuccess(this.f19397c);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19399e) {
                C4476a.m17152b(th);
            } else {
                this.f19399e = true;
                this.f19395a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19399e) {
                return;
            }
            try {
                this.f19396b.mo18209a(this.f19397c, t);
            } catch (Throwable th) {
                this.f19398d.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19398d, interfaceC4552c)) {
                this.f19398d = interfaceC4552c;
                this.f19395a.onSubscribe(this);
            }
        }
    }

    public C5010t(InterfaceC4504g0<T> interfaceC4504g0, Callable<? extends U> callable, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
        this.f19392a = interfaceC4504g0;
        this.f19393b = callable;
        this.f19394c = interfaceC4571b;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<U> mo18288a() {
        return C4476a.m17119a(new C5005s(this.f19392a, this.f19393b, this.f19394c));
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super U> interfaceC4524n0) {
        try {
            this.f19392a.subscribe(new a(interfaceC4524n0, C4601b.m18284a(this.f19393b.call(), "The initialSupplier returned a null value"), this.f19394c));
        } catch (Throwable th) {
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }
}
