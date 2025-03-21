package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableScanSeed.java */
/* renamed from: g.a.y0.e.d.u2 */
/* loaded from: classes2.dex */
public final class C5018u2<T, R> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    final InterfaceC4572c<R, ? super T, R> f19425b;

    /* renamed from: c */
    final Callable<R> f19426c;

    /* compiled from: ObservableScanSeed.java */
    /* renamed from: g.a.y0.e.d.u2$a */
    static final class a<T, R> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super R> f19427a;

        /* renamed from: b */
        final InterfaceC4572c<R, ? super T, R> f19428b;

        /* renamed from: c */
        R f19429c;

        /* renamed from: d */
        InterfaceC4552c f19430d;

        /* renamed from: e */
        boolean f19431e;

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4572c<R, ? super T, R> interfaceC4572c, R r) {
            this.f19427a = interfaceC4514i0;
            this.f19428b = interfaceC4572c;
            this.f19429c = r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19430d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19430d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19431e) {
                return;
            }
            this.f19431e = true;
            this.f19427a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19431e) {
                C4476a.m17152b(th);
            } else {
                this.f19431e = true;
                this.f19427a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19431e) {
                return;
            }
            try {
                R r = (R) C4601b.m18284a(this.f19428b.apply(this.f19429c, t), "The accumulator returned a null value");
                this.f19429c = r;
                this.f19427a.onNext(r);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19430d.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19430d, interfaceC4552c)) {
                this.f19430d = interfaceC4552c;
                this.f19427a.onSubscribe(this);
                this.f19427a.onNext(this.f19429c);
            }
        }
    }

    public C5018u2(InterfaceC4504g0<T> interfaceC4504g0, Callable<R> callable, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        super(interfaceC4504g0);
        this.f19425b = interfaceC4572c;
        this.f19426c = callable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        try {
            this.f18742a.subscribe(new a(interfaceC4514i0, this.f19425b, C4601b.m18284a(this.f19426c.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4514i0);
        }
    }
}
