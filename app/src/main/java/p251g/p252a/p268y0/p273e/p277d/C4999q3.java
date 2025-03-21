package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p257e1.C4490c;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableTimeInterval.java */
/* renamed from: g.a.y0.e.d.q3 */
/* loaded from: classes2.dex */
public final class C4999q3<T> extends AbstractC4907a<T, C4490c<T>> {

    /* renamed from: b */
    final AbstractC4516j0 f19332b;

    /* renamed from: c */
    final TimeUnit f19333c;

    /* compiled from: ObservableTimeInterval.java */
    /* renamed from: g.a.y0.e.d.q3$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super C4490c<T>> f19334a;

        /* renamed from: b */
        final TimeUnit f19335b;

        /* renamed from: c */
        final AbstractC4516j0 f19336c;

        /* renamed from: d */
        long f19337d;

        /* renamed from: e */
        InterfaceC4552c f19338e;

        a(InterfaceC4514i0<? super C4490c<T>> interfaceC4514i0, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f19334a = interfaceC4514i0;
            this.f19336c = abstractC4516j0;
            this.f19335b = timeUnit;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19338e.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19338e.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19334a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19334a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            long mo17276a = this.f19336c.mo17276a(this.f19335b);
            long j2 = this.f19337d;
            this.f19337d = mo17276a;
            this.f19334a.onNext(new C4490c(t, mo17276a - j2, this.f19335b));
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19338e, interfaceC4552c)) {
                this.f19338e = interfaceC4552c;
                this.f19337d = this.f19336c.mo17276a(this.f19335b);
                this.f19334a.onSubscribe(this);
            }
        }
    }

    public C4999q3(InterfaceC4504g0<T> interfaceC4504g0, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4504g0);
        this.f19332b = abstractC4516j0;
        this.f19333c = timeUnit;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super C4490c<T>> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19333c, this.f19332b));
    }
}
