package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;

/* compiled from: ObservableAnySingle.java */
/* renamed from: g.a.y0.e.d.j */
/* loaded from: classes2.dex */
public final class C4960j<T> extends AbstractC4518k0<Boolean> implements InterfaceC4605d<Boolean> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19075a;

    /* renamed from: b */
    final InterfaceC4587r<? super T> f19076b;

    /* compiled from: ObservableAnySingle.java */
    /* renamed from: g.a.y0.e.d.j$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super Boolean> f19077a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f19078b;

        /* renamed from: c */
        InterfaceC4552c f19079c;

        /* renamed from: d */
        boolean f19080d;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f19077a = interfaceC4524n0;
            this.f19078b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19079c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19079c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19080d) {
                return;
            }
            this.f19080d = true;
            this.f19077a.onSuccess(false);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19080d) {
                C4476a.m17152b(th);
            } else {
                this.f19080d = true;
                this.f19077a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19080d) {
                return;
            }
            try {
                if (this.f19078b.test(t)) {
                    this.f19080d = true;
                    this.f19079c.dispose();
                    this.f19077a.onSuccess(true);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19079c.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19079c, interfaceC4552c)) {
                this.f19079c = interfaceC4552c;
                this.f19077a.onSubscribe(this);
            }
        }
    }

    public C4960j(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4587r<? super T> interfaceC4587r) {
        this.f19075a = interfaceC4504g0;
        this.f19076b = interfaceC4587r;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<Boolean> mo18288a() {
        return C4476a.m17119a(new C4955i(this.f19075a, this.f19076b));
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        this.f19075a.subscribe(new a(interfaceC4524n0, this.f19076b));
    }
}
