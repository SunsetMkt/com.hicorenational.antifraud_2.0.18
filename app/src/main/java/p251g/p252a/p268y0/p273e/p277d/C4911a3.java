package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: ObservableSkip.java */
/* renamed from: g.a.y0.e.d.a3 */
/* loaded from: classes2.dex */
public final class C4911a3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f18754b;

    /* compiled from: ObservableSkip.java */
    /* renamed from: g.a.y0.e.d.a3$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18755a;

        /* renamed from: b */
        long f18756b;

        /* renamed from: c */
        InterfaceC4552c f18757c;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2) {
            this.f18755a = interfaceC4514i0;
            this.f18756b = j2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18757c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18757c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18755a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18755a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            long j2 = this.f18756b;
            if (j2 != 0) {
                this.f18756b = j2 - 1;
            } else {
                this.f18755a.onNext(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f18757c = interfaceC4552c;
            this.f18755a.onSubscribe(this);
        }
    }

    public C4911a3(InterfaceC4504g0<T> interfaceC4504g0, long j2) {
        super(interfaceC4504g0);
        this.f18754b = j2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f18754b));
    }
}
