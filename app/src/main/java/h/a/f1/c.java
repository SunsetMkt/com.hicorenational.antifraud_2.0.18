package h.a.f1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableSubject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends h.a.c implements h.a.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final a[] f10355d = new a[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final a[] f10356e = new a[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Throwable f10358c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f10357b = new AtomicBoolean();
    final AtomicReference<a[]> a = new AtomicReference<>(f10355d);

    /* JADX INFO: compiled from: CompletableSubject.java */
    static final class a extends AtomicReference<c> implements h.a.u0.c {
        private static final long serialVersionUID = -7650903191002190468L;
        final h.a.f actual;

        a(h.a.f fVar, c cVar) {
            this.actual = fVar;
            lazySet(cVar);
        }

        @Override // h.a.u0.c
        public void dispose() {
            c andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    c() {
    }

    @h.a.t0.d
    public static c x() {
        return new c();
    }

    boolean a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.a.get();
            if (aVarArr == f10356e) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        a aVar = new a(fVar, this);
        fVar.onSubscribe(aVar);
        if (a(aVar)) {
            if (aVar.isDisposed()) {
                b(aVar);
            }
        } else {
            Throwable th = this.f10358c;
            if (th != null) {
                fVar.onError(th);
            } else {
                fVar.onComplete();
            }
        }
    }

    @Override // h.a.f
    public void onComplete() {
        if (this.f10357b.compareAndSet(false, true)) {
            for (a aVar : this.a.getAndSet(f10356e)) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // h.a.f
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f10357b.compareAndSet(false, true)) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10358c = th;
        for (a aVar : this.a.getAndSet(f10356e)) {
            aVar.actual.onError(th);
        }
    }

    @Override // h.a.f
    public void onSubscribe(h.a.u0.c cVar) {
        if (this.a.get() == f10356e) {
            cVar.dispose();
        }
    }

    public Throwable s() {
        if (this.a.get() == f10356e) {
            return this.f10358c;
        }
        return null;
    }

    public boolean t() {
        return this.a.get() == f10356e && this.f10358c == null;
    }

    public boolean u() {
        return this.a.get().length != 0;
    }

    public boolean v() {
        return this.a.get() == f10356e && this.f10358c != null;
    }

    int w() {
        return this.a.get().length;
    }

    void b(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.a.get();
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
                aVarArr2 = f10355d;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
    }
}
