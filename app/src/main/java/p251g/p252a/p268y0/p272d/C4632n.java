package p251g.p252a.p268y0.p272d;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: DisposableLambdaObserver.java */
/* renamed from: g.a.y0.d.n */
/* loaded from: classes2.dex */
public final class C4632n<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

    /* renamed from: a */
    final InterfaceC4514i0<? super T> f17579a;

    /* renamed from: b */
    final InterfaceC4576g<? super InterfaceC4552c> f17580b;

    /* renamed from: c */
    final InterfaceC4570a f17581c;

    /* renamed from: d */
    InterfaceC4552c f17582d;

    public C4632n(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g, InterfaceC4570a interfaceC4570a) {
        this.f17579a = interfaceC4514i0;
        this.f17580b = interfaceC4576g;
        this.f17581c = interfaceC4570a;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        try {
            this.f17581c.run();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
        this.f17582d.dispose();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f17582d.isDisposed();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.f17582d != EnumC4592d.DISPOSED) {
            this.f17579a.onComplete();
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (this.f17582d != EnumC4592d.DISPOSED) {
            this.f17579a.onError(th);
        } else {
            C4476a.m17152b(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        this.f17579a.onNext(t);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        try {
            this.f17580b.accept(interfaceC4552c);
            if (EnumC4592d.validate(this.f17582d, interfaceC4552c)) {
                this.f17582d = interfaceC4552c;
                this.f17579a.onSubscribe(this);
            }
        } catch (Throwable th) {
            C4561b.m18199b(th);
            interfaceC4552c.dispose();
            this.f17582d = EnumC4592d.DISPOSED;
            EnumC4593e.error(th, this.f17579a);
        }
    }
}
