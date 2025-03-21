package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p279f.C5076h0;

/* compiled from: SingleZipArray.java */
/* renamed from: g.a.y0.e.f.u0 */
/* loaded from: classes2.dex */
public final class C5102u0<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T>[] f19802a;

    /* renamed from: b */
    final InterfaceC4584o<? super Object[], ? extends R> f19803b;

    /* compiled from: SingleZipArray.java */
    /* renamed from: g.a.y0.e.f.u0$a */
    final class a implements InterfaceC4584o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(T t) throws Exception {
            return (R) C4601b.m18284a(C5102u0.this.f19803b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* compiled from: SingleZipArray.java */
    /* renamed from: g.a.y0.e.f.u0$b */
    static final class b<T, R> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = -5556924161382950569L;
        final InterfaceC4524n0<? super R> actual;
        final c<T>[] observers;
        final Object[] values;
        final InterfaceC4584o<? super Object[], ? extends R> zipper;

        b(InterfaceC4524n0<? super R> interfaceC4524n0, int i2, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
            super(i2);
            this.actual = interfaceC4524n0;
            this.zipper = interfaceC4584o;
            c<T>[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c<>(this, i3);
            }
            this.observers = cVarArr;
            this.values = new Object[i2];
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (c<T> cVar : this.observers) {
                    cVar.dispose();
                }
            }
        }

        void disposeExcept(int i2) {
            c<T>[] cVarArr = this.observers;
            int length = cVarArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3].dispose();
            }
            while (true) {
                i2++;
                if (i2 >= length) {
                    return;
                } else {
                    cVarArr[i2].dispose();
                }
            }
        }

        void innerError(Throwable th, int i2) {
            if (getAndSet(0) <= 0) {
                C4476a.m17152b(th);
            } else {
                disposeExcept(i2);
                this.actual.onError(th);
            }
        }

        void innerSuccess(T t, int i2) {
            this.values[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.actual.onSuccess(C4601b.m18284a(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    /* compiled from: SingleZipArray.java */
    /* renamed from: g.a.y0.e.f.u0$c */
    static final class c<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final b<T, ?> parent;

        c(b<T, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public C5102u0(InterfaceC4530q0<? extends T>[] interfaceC4530q0Arr, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        this.f19802a = interfaceC4530q0Arr;
        this.f19803b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        InterfaceC4530q0<? extends T>[] interfaceC4530q0Arr = this.f19802a;
        int length = interfaceC4530q0Arr.length;
        if (length == 1) {
            interfaceC4530q0Arr[0].mo17490a(new C5076h0.a(interfaceC4524n0, new a()));
            return;
        }
        b bVar = new b(interfaceC4524n0, length, this.f19803b);
        interfaceC4524n0.onSubscribe(bVar);
        for (int i2 = 0; i2 < length && !bVar.isDisposed(); i2++) {
            InterfaceC4530q0<? extends T> interfaceC4530q0 = interfaceC4530q0Arr[i2];
            if (interfaceC4530q0 == null) {
                bVar.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            interfaceC4530q0.mo17490a(bVar.observers[i2]);
        }
    }
}
