package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: ObservableAmb.java */
/* renamed from: g.a.y0.e.d.h */
/* loaded from: classes2.dex */
public final class C4949h<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final InterfaceC4504g0<? extends T>[] f19028a;

    /* renamed from: b */
    final Iterable<? extends InterfaceC4504g0<? extends T>> f19029b;

    /* compiled from: ObservableAmb.java */
    /* renamed from: g.a.y0.e.d.h$b */
    static final class b<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final InterfaceC4514i0<? super T> actual;
        final int index;
        final a<T> parent;
        boolean won;

        b(a<T> aVar, int i2, InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.parent = aVar;
            this.index = i2;
            this.actual = interfaceC4514i0;
        }

        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.m18450a(this.index)) {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (!this.parent.m18450a(this.index)) {
                C4476a.m17152b(th);
            } else {
                this.won = true;
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (!this.parent.m18450a(this.index)) {
                get().dispose();
            } else {
                this.won = true;
                this.actual.onNext(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    public C4949h(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr, Iterable<? extends InterfaceC4504g0<? extends T>> iterable) {
        this.f19028a = interfaceC4504g0Arr;
        this.f19029b = iterable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        int length;
        InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr = this.f19028a;
        if (interfaceC4504g0Arr == null) {
            interfaceC4504g0Arr = new AbstractC4469b0[8];
            try {
                length = 0;
                for (InterfaceC4504g0<? extends T> interfaceC4504g0 : this.f19029b) {
                    if (interfaceC4504g0 == null) {
                        EnumC4593e.error(new NullPointerException("One of the sources is null"), interfaceC4514i0);
                        return;
                    }
                    if (length == interfaceC4504g0Arr.length) {
                        InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr2 = new InterfaceC4504g0[(length >> 2) + length];
                        System.arraycopy(interfaceC4504g0Arr, 0, interfaceC4504g0Arr2, 0, length);
                        interfaceC4504g0Arr = interfaceC4504g0Arr2;
                    }
                    int i2 = length + 1;
                    interfaceC4504g0Arr[length] = interfaceC4504g0;
                    length = i2;
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC4593e.error(th, interfaceC4514i0);
                return;
            }
        } else {
            length = interfaceC4504g0Arr.length;
        }
        if (length == 0) {
            EnumC4593e.complete(interfaceC4514i0);
        } else if (length == 1) {
            interfaceC4504g0Arr[0].subscribe(interfaceC4514i0);
        } else {
            new a(interfaceC4514i0, length).m18449a(interfaceC4504g0Arr);
        }
    }

    /* compiled from: ObservableAmb.java */
    /* renamed from: g.a.y0.e.d.h$a */
    static final class a<T> implements InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19030a;

        /* renamed from: b */
        final b<T>[] f19031b;

        /* renamed from: c */
        final AtomicInteger f19032c = new AtomicInteger();

        a(InterfaceC4514i0<? super T> interfaceC4514i0, int i2) {
            this.f19030a = interfaceC4514i0;
            this.f19031b = new b[i2];
        }

        /* renamed from: a */
        public void m18449a(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr) {
            b<T>[] bVarArr = this.f19031b;
            int length = bVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr[i2] = new b<>(this, i3, this.f19030a);
                i2 = i3;
            }
            this.f19032c.lazySet(0);
            this.f19030a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f19032c.get() == 0; i4++) {
                interfaceC4504g0Arr[i4].subscribe(bVarArr[i4]);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f19032c.get() != -1) {
                this.f19032c.lazySet(-1);
                for (b<T> bVar : this.f19031b) {
                    bVar.dispose();
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19032c.get() == -1;
        }

        /* renamed from: a */
        public boolean m18450a(int i2) {
            int i3 = this.f19032c.get();
            int i4 = 0;
            if (i3 != 0) {
                return i3 == i2;
            }
            if (!this.f19032c.compareAndSet(0, i2)) {
                return false;
            }
            b<T>[] bVarArr = this.f19031b;
            int length = bVarArr.length;
            while (i4 < length) {
                int i5 = i4 + 1;
                if (i5 != i2) {
                    bVarArr[i4].dispose();
                }
                i4 = i5;
            }
            return true;
        }
    }
}
