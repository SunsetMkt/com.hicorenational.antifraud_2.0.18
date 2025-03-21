package p251g.p252a.p268y0.p273e.p277d;

import java.util.Collection;
import java.util.concurrent.Callable;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableToList.java */
/* renamed from: g.a.y0.e.d.u3 */
/* loaded from: classes2.dex */
public final class C5019u3<T, U extends Collection<? super T>> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final Callable<U> f19432b;

    /* compiled from: ObservableToList.java */
    /* renamed from: g.a.y0.e.d.u3$a */
    static final class a<T, U extends Collection<? super T>> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        U f19433a;

        /* renamed from: b */
        final InterfaceC4514i0<? super U> f19434b;

        /* renamed from: c */
        InterfaceC4552c f19435c;

        a(InterfaceC4514i0<? super U> interfaceC4514i0, U u) {
            this.f19434b = interfaceC4514i0;
            this.f19433a = u;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19435c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19435c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            U u = this.f19433a;
            this.f19433a = null;
            this.f19434b.onNext(u);
            this.f19434b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19433a = null;
            this.f19434b.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19433a.add(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19435c, interfaceC4552c)) {
                this.f19435c = interfaceC4552c;
                this.f19434b.onSubscribe(this);
            }
        }
    }

    public C5019u3(InterfaceC4504g0<T> interfaceC4504g0, int i2) {
        super(interfaceC4504g0);
        this.f19432b = C4600a.m18249a(i2);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        try {
            this.f18742a.subscribe(new a(interfaceC4514i0, (Collection) C4601b.m18284a(this.f19432b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4514i0);
        }
    }

    public C5019u3(InterfaceC4504g0<T> interfaceC4504g0, Callable<U> callable) {
        super(interfaceC4504g0);
        this.f19432b = callable;
    }
}
