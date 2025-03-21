package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: SingleCache.java */
/* renamed from: g.a.y0.e.f.b */
/* loaded from: classes2.dex */
public final class C5063b<T> extends AbstractC4518k0<T> implements InterfaceC4524n0<T> {

    /* renamed from: f */
    static final a[] f19666f = new a[0];

    /* renamed from: g */
    static final a[] f19667g = new a[0];

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19668a;

    /* renamed from: b */
    final AtomicInteger f19669b = new AtomicInteger();

    /* renamed from: c */
    final AtomicReference<a<T>[]> f19670c = new AtomicReference<>(f19666f);

    /* renamed from: d */
    T f19671d;

    /* renamed from: e */
    Throwable f19672e;

    /* compiled from: SingleCache.java */
    /* renamed from: g.a.y0.e.f.b$a */
    static final class a<T> extends AtomicBoolean implements InterfaceC4552c {
        private static final long serialVersionUID = 7514387411091976596L;
        final InterfaceC4524n0<? super T> actual;
        final C5063b<T> parent;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, C5063b<T> c5063b) {
            this.actual = interfaceC4524n0;
            this.parent = c5063b;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.m18526b((a) this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get();
        }
    }

    public C5063b(InterfaceC4530q0<? extends T> interfaceC4530q0) {
        this.f19668a = interfaceC4530q0;
    }

    /* renamed from: a */
    boolean m18525a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f19670c.get();
            if (aVarArr == f19667g) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f19670c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        a<T> aVar = new a<>(interfaceC4524n0, this);
        interfaceC4524n0.onSubscribe(aVar);
        if (m18525a((a) aVar)) {
            if (aVar.isDisposed()) {
                m18526b((a) aVar);
            }
            if (this.f19669b.getAndIncrement() == 0) {
                this.f19668a.mo17490a(this);
                return;
            }
            return;
        }
        Throwable th = this.f19672e;
        if (th != null) {
            interfaceC4524n0.onError(th);
        } else {
            interfaceC4524n0.onSuccess(this.f19671d);
        }
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onError(Throwable th) {
        this.f19672e = th;
        for (a<T> aVar : this.f19670c.getAndSet(f19667g)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        this.f19671d = t;
        for (a<T> aVar : this.f19670c.getAndSet(f19667g)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    /* renamed from: b */
    void m18526b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f19670c.get();
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
                if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f19666f;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f19670c.compareAndSet(aVarArr, aVarArr2));
    }
}
