package p251g.p252a.p268y0.p273e.p277d;

import java.util.Collection;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;

/* compiled from: ObservableToListSingle.java */
/* renamed from: g.a.y0.e.d.v3 */
/* loaded from: classes2.dex */
public final class C5024v3<T, U extends Collection<? super T>> extends AbstractC4518k0<U> implements InterfaceC4605d<U> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19463a;

    /* renamed from: b */
    final Callable<U> f19464b;

    /* compiled from: ObservableToListSingle.java */
    /* renamed from: g.a.y0.e.d.v3$a */
    static final class a<T, U extends Collection<? super T>> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super U> f19465a;

        /* renamed from: b */
        U f19466b;

        /* renamed from: c */
        InterfaceC4552c f19467c;

        a(InterfaceC4524n0<? super U> interfaceC4524n0, U u) {
            this.f19465a = interfaceC4524n0;
            this.f19466b = u;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19467c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19467c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            U u = this.f19466b;
            this.f19466b = null;
            this.f19465a.onSuccess(u);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19466b = null;
            this.f19465a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19466b.add(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19467c, interfaceC4552c)) {
                this.f19467c = interfaceC4552c;
                this.f19465a.onSubscribe(this);
            }
        }
    }

    public C5024v3(InterfaceC4504g0<T> interfaceC4504g0, int i2) {
        this.f19463a = interfaceC4504g0;
        this.f19464b = C4600a.m18249a(i2);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<U> mo18288a() {
        return C4476a.m17119a(new C5019u3(this.f19463a, this.f19464b));
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    public void mo17357b(InterfaceC4524n0<? super U> interfaceC4524n0) {
        try {
            this.f19463a.subscribe(new a(interfaceC4524n0, (Collection) C4601b.m18284a(this.f19464b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }

    public C5024v3(InterfaceC4504g0<T> interfaceC4504g0, Callable<U> callable) {
        this.f19463a = interfaceC4504g0;
        this.f19464b = callable;
    }
}
