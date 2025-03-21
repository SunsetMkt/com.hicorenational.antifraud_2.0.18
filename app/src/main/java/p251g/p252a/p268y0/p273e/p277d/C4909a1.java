package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4621c;

/* compiled from: ObservableFromArray.java */
/* renamed from: g.a.y0.e.d.a1 */
/* loaded from: classes2.dex */
public final class C4909a1<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final T[] f18744a;

    /* compiled from: ObservableFromArray.java */
    /* renamed from: g.a.y0.e.d.a1$a */
    static final class a<T> extends AbstractC4621c<T> {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18745a;

        /* renamed from: b */
        final T[] f18746b;

        /* renamed from: c */
        int f18747c;

        /* renamed from: d */
        boolean f18748d;

        /* renamed from: e */
        volatile boolean f18749e;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, T[] tArr) {
            this.f18745a = interfaceC4514i0;
            this.f18746b = tArr;
        }

        /* renamed from: a */
        void m18413a() {
            T[] tArr = this.f18746b;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !isDisposed(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    this.f18745a.onError(new NullPointerException("The " + i2 + "th element is null"));
                    return;
                }
                this.f18745a.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.f18745a.onComplete();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f18747c = this.f18746b.length;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18749e = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18749e;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f18747c == this.f18746b.length;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() {
            int i2 = this.f18747c;
            T[] tArr = this.f18746b;
            if (i2 == tArr.length) {
                return null;
            }
            this.f18747c = i2 + 1;
            return (T) C4601b.m18284a((Object) tArr[i2], "The array element is null");
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f18748d = true;
            return 1;
        }
    }

    public C4909a1(T[] tArr) {
        this.f18744a = tArr;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0, this.f18744a);
        interfaceC4514i0.onSubscribe(aVar);
        if (aVar.f18748d) {
            return;
        }
        aVar.m18413a();
    }
}
