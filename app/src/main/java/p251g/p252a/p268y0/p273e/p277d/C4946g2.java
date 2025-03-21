package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableReduceSeedSingle.java */
/* renamed from: g.a.y0.e.d.g2 */
/* loaded from: classes2.dex */
public final class C4946g2<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19008a;

    /* renamed from: b */
    final R f19009b;

    /* renamed from: c */
    final InterfaceC4572c<R, ? super T, R> f19010c;

    /* compiled from: ObservableReduceSeedSingle.java */
    /* renamed from: g.a.y0.e.d.g2$a */
    static final class a<T, R> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super R> f19011a;

        /* renamed from: b */
        final InterfaceC4572c<R, ? super T, R> f19012b;

        /* renamed from: c */
        R f19013c;

        /* renamed from: d */
        InterfaceC4552c f19014d;

        a(InterfaceC4524n0<? super R> interfaceC4524n0, InterfaceC4572c<R, ? super T, R> interfaceC4572c, R r) {
            this.f19011a = interfaceC4524n0;
            this.f19013c = r;
            this.f19012b = interfaceC4572c;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19014d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19014d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            R r = this.f19013c;
            this.f19013c = null;
            if (r != null) {
                this.f19011a.onSuccess(r);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            R r = this.f19013c;
            this.f19013c = null;
            if (r != null) {
                this.f19011a.onError(th);
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            R r = this.f19013c;
            if (r != null) {
                try {
                    this.f19013c = (R) C4601b.m18284a(this.f19012b.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f19014d.dispose();
                    onError(th);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19014d, interfaceC4552c)) {
                this.f19014d = interfaceC4552c;
                this.f19011a.onSubscribe(this);
            }
        }
    }

    public C4946g2(InterfaceC4504g0<T> interfaceC4504g0, R r, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        this.f19008a = interfaceC4504g0;
        this.f19009b = r;
        this.f19010c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        this.f19008a.subscribe(new a(interfaceC4524n0, this.f19010c, this.f19009b));
    }
}
