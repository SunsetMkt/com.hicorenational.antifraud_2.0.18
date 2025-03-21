package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4608g;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p285z0.AbstractC5187a;

/* compiled from: ObservablePublish.java */
/* renamed from: g.a.y0.e.d.b2 */
/* loaded from: classes2.dex */
public final class C4916b2<T> extends AbstractC5187a<T> implements InterfaceC4608g<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f18790a;

    /* renamed from: b */
    final AtomicReference<b<T>> f18791b;

    /* renamed from: c */
    final InterfaceC4504g0<T> f18792c;

    /* compiled from: ObservablePublish.java */
    /* renamed from: g.a.y0.e.d.b2$a */
    static final class a<T> extends AtomicReference<Object> implements InterfaceC4552c {
        private static final long serialVersionUID = -1100270633763673112L;
        final InterfaceC4514i0<? super T> child;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.child = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).m18424b(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == this;
        }

        void setParent(b<T> bVar) {
            if (compareAndSet(null, bVar)) {
                return;
            }
            bVar.m18424b(this);
        }
    }

    /* compiled from: ObservablePublish.java */
    /* renamed from: g.a.y0.e.d.b2$b */
    static final class b<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: e */
        static final a[] f18793e = new a[0];

        /* renamed from: f */
        static final a[] f18794f = new a[0];

        /* renamed from: a */
        final AtomicReference<b<T>> f18795a;

        /* renamed from: d */
        final AtomicReference<InterfaceC4552c> f18798d = new AtomicReference<>();

        /* renamed from: b */
        final AtomicReference<a<T>[]> f18796b = new AtomicReference<>(f18793e);

        /* renamed from: c */
        final AtomicBoolean f18797c = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.f18795a = atomicReference;
        }

        /* renamed from: a */
        boolean m18423a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f18796b.get();
                if (aVarArr == f18794f) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f18796b.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* renamed from: b */
        void m18424b(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f18796b.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (aVarArr[i3].equals(aVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f18793e;
                } else {
                    a<T>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f18796b.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            a<T>[] aVarArr = this.f18796b.get();
            a<T>[] aVarArr2 = f18794f;
            if (aVarArr == aVarArr2 || this.f18796b.getAndSet(aVarArr2) == f18794f) {
                return;
            }
            this.f18795a.compareAndSet(this, null);
            EnumC4592d.dispose(this.f18798d);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18796b.get() == f18794f;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18795a.compareAndSet(this, null);
            for (a<T> aVar : this.f18796b.getAndSet(f18794f)) {
                aVar.child.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18795a.compareAndSet(this, null);
            a<T>[] andSet = this.f18796b.getAndSet(f18794f);
            if (andSet.length == 0) {
                C4476a.m17152b(th);
                return;
            }
            for (a<T> aVar : andSet) {
                aVar.child.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            for (a<T> aVar : this.f18796b.get()) {
                aVar.child.onNext(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this.f18798d, interfaceC4552c);
        }
    }

    /* compiled from: ObservablePublish.java */
    /* renamed from: g.a.y0.e.d.b2$c */
    static final class c<T> implements InterfaceC4504g0<T> {

        /* renamed from: a */
        private final AtomicReference<b<T>> f18799a;

        c(AtomicReference<b<T>> atomicReference) {
            this.f18799a = atomicReference;
        }

        @Override // p251g.p252a.InterfaceC4504g0
        public void subscribe(InterfaceC4514i0<? super T> interfaceC4514i0) {
            a aVar = new a(interfaceC4514i0);
            interfaceC4514i0.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.f18799a.get();
                if (bVar == null || bVar.isDisposed()) {
                    b<T> bVar2 = new b<>(this.f18799a);
                    if (this.f18799a.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.m18423a(aVar)) {
                    aVar.setParent(bVar);
                    return;
                }
            }
        }
    }

    private C4916b2(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<T> interfaceC4504g02, AtomicReference<b<T>> atomicReference) {
        this.f18792c = interfaceC4504g0;
        this.f18790a = interfaceC4504g02;
        this.f18791b = atomicReference;
    }

    /* renamed from: w */
    public static <T> AbstractC5187a<T> m18421w(InterfaceC4504g0<T> interfaceC4504g0) {
        AtomicReference atomicReference = new AtomicReference();
        return C4476a.m17135a((AbstractC5187a) new C4916b2(new c(atomicReference), interfaceC4504g0, atomicReference));
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18792c.subscribe(interfaceC4514i0);
    }

    @Override // p251g.p252a.p285z0.AbstractC5187a
    /* renamed from: k */
    public void mo18422k(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        b<T> bVar;
        while (true) {
            bVar = this.f18791b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f18791b);
            if (this.f18791b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = !bVar.f18797c.get() && bVar.f18797c.compareAndSet(false, true);
        try {
            interfaceC4576g.accept(bVar);
            if (z) {
                this.f18790a.subscribe(bVar);
            }
        } catch (Throwable th) {
            C4561b.m18199b(th);
            throw C5171k.m18626c(th);
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4608g
    public InterfaceC4504g0<T> source() {
        return this.f18790a;
    }
}
