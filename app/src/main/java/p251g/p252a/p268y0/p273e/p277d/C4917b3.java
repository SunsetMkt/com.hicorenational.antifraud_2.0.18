package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayDeque;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableSkipLast.java */
/* renamed from: g.a.y0.e.d.b3 */
/* loaded from: classes2.dex */
public final class C4917b3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final int f18800b;

    /* compiled from: ObservableSkipLast.java */
    /* renamed from: g.a.y0.e.d.b3$a */
    static final class a<T> extends ArrayDeque<T> implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -3807491841935125653L;
        final InterfaceC4514i0<? super T> actual;

        /* renamed from: s */
        InterfaceC4552c f18801s;
        final int skip;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, int i2) {
            super(i2);
            this.actual = interfaceC4514i0;
            this.skip = i2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18801s.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18801s.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext(poll());
            }
            offer(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18801s, interfaceC4552c)) {
                this.f18801s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4917b3(InterfaceC4504g0<T> interfaceC4504g0, int i2) {
        super(interfaceC4504g0);
        this.f18800b = i2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f18800b));
    }
}
