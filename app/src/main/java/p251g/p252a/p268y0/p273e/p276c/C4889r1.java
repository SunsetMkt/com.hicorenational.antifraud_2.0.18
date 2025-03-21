package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p276c.C4896u0;

/* compiled from: MaybeZipArray.java */
/* renamed from: g.a.y0.e.c.r1 */
/* loaded from: classes2.dex */
public final class C4889r1<T, R> extends AbstractC4533s<R> {

    /* renamed from: a */
    final InterfaceC4588y<? extends T>[] f18696a;

    /* renamed from: b */
    final InterfaceC4584o<? super Object[], ? extends R> f18697b;

    /* compiled from: MaybeZipArray.java */
    /* renamed from: g.a.y0.e.c.r1$a */
    final class a implements InterfaceC4584o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(T t) throws Exception {
            return (R) C4601b.m18284a(C4889r1.this.f18697b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* compiled from: MaybeZipArray.java */
    /* renamed from: g.a.y0.e.c.r1$b */
    static final class b<T, R> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = -5556924161382950569L;
        final InterfaceC4559v<? super R> actual;
        final c<T>[] observers;
        final Object[] values;
        final InterfaceC4584o<? super Object[], ? extends R> zipper;

        b(InterfaceC4559v<? super R> interfaceC4559v, int i2, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
            super(i2);
            this.actual = interfaceC4559v;
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

        void innerComplete(int i2) {
            if (getAndSet(0) > 0) {
                disposeExcept(i2);
                this.actual.onComplete();
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

    /* compiled from: MaybeZipArray.java */
    /* renamed from: g.a.y0.e.c.r1$c */
    static final class c<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T> {
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

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public C4889r1(InterfaceC4588y<? extends T>[] interfaceC4588yArr, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        this.f18696a = interfaceC4588yArr;
        this.f18697b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        InterfaceC4588y<? extends T>[] interfaceC4588yArr = this.f18696a;
        int length = interfaceC4588yArr.length;
        if (length == 1) {
            interfaceC4588yArr[0].mo18100a(new C4896u0.a(interfaceC4559v, new a()));
            return;
        }
        b bVar = new b(interfaceC4559v, length, this.f18697b);
        interfaceC4559v.onSubscribe(bVar);
        for (int i2 = 0; i2 < length && !bVar.isDisposed(); i2++) {
            InterfaceC4588y<? extends T> interfaceC4588y = interfaceC4588yArr[i2];
            if (interfaceC4588y == null) {
                bVar.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            interfaceC4588y.mo18100a(bVar.observers[i2]);
        }
    }
}
