package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: MaybeCache.java */
/* renamed from: g.a.y0.e.c.c */
/* loaded from: classes2.dex */
public final class C4842c<T> extends AbstractC4533s<T> implements InterfaceC4559v<T> {

    /* renamed from: e */
    static final a[] f18570e = new a[0];

    /* renamed from: f */
    static final a[] f18571f = new a[0];

    /* renamed from: a */
    final AtomicReference<InterfaceC4588y<T>> f18572a;

    /* renamed from: b */
    final AtomicReference<a<T>[]> f18573b = new AtomicReference<>(f18570e);

    /* renamed from: c */
    T f18574c;

    /* renamed from: d */
    Throwable f18575d;

    /* compiled from: MaybeCache.java */
    /* renamed from: g.a.y0.e.c.c$a */
    static final class a<T> extends AtomicReference<C4842c<T>> implements InterfaceC4552c {
        private static final long serialVersionUID = -5791853038359966195L;
        final InterfaceC4559v<? super T> actual;

        a(InterfaceC4559v<? super T> interfaceC4559v, C4842c<T> c4842c) {
            super(c4842c);
            this.actual = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            C4842c<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.m18410b((a) this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public C4842c(InterfaceC4588y<T> interfaceC4588y) {
        this.f18572a = new AtomicReference<>(interfaceC4588y);
    }

    /* renamed from: a */
    boolean m18409a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f18573b.get();
            if (aVarArr == f18571f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f18573b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        a<T> aVar = new a<>(interfaceC4559v, this);
        interfaceC4559v.onSubscribe(aVar);
        if (m18409a((a) aVar)) {
            if (aVar.isDisposed()) {
                m18410b((a) aVar);
                return;
            }
            InterfaceC4588y<T> andSet = this.f18572a.getAndSet(null);
            if (andSet != null) {
                andSet.mo18100a(this);
                return;
            }
            return;
        }
        if (aVar.isDisposed()) {
            return;
        }
        Throwable th = this.f18575d;
        if (th != null) {
            interfaceC4559v.onError(th);
            return;
        }
        T t = this.f18574c;
        if (t != null) {
            interfaceC4559v.onSuccess(t);
        } else {
            interfaceC4559v.onComplete();
        }
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onComplete() {
        for (a<T> aVar : this.f18573b.getAndSet(f18571f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onError(Throwable th) {
        this.f18575d = th;
        for (a<T> aVar : this.f18573b.getAndSet(f18571f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
    }

    @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        this.f18574c = t;
        for (a<T> aVar : this.f18573b.getAndSet(f18571f)) {
            if (!aVar.isDisposed()) {
                aVar.actual.onSuccess(t);
            }
        }
    }

    /* renamed from: b */
    void m18410b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f18573b.get();
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
                aVarArr2 = f18570e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f18573b.compareAndSet(aVarArr, aVarArr2));
    }
}
