package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableCache.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class b extends h.a.c implements h.a.f {

    /* JADX INFO: renamed from: e */
    static final a[] f10500e = new a[0];

    /* JADX INFO: renamed from: f */
    static final a[] f10501f = new a[0];
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final AtomicReference<a[]> f10502b = new AtomicReference<>(f10500e);

    /* JADX INFO: renamed from: c */
    final AtomicBoolean f10503c = new AtomicBoolean();

    /* JADX INFO: renamed from: d */
    Throwable f10504d;

    /* JADX INFO: compiled from: CompletableCache.java */
    final class a extends AtomicBoolean implements h.a.u0.c {
        private static final long serialVersionUID = 8943152917179642732L;
        final h.a.f actual;

        a(h.a.f fVar) {
            this.actual = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                b.this.b(this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get();
        }
    }

    public b(h.a.i iVar) {
        this.a = iVar;
    }

    boolean a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f10502b.get();
            if (aVarArr == f10501f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f10502b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        a aVar = new a(fVar);
        fVar.onSubscribe(aVar);
        if (a(aVar)) {
            if (aVar.isDisposed()) {
                b(aVar);
            }
            if (this.f10503c.compareAndSet(false, true)) {
                this.a.a(this);
                return;
            }
            return;
        }
        Throwable th = this.f10504d;
        if (th != null) {
            fVar.onError(th);
        } else {
            fVar.onComplete();
        }
    }

    @Override // h.a.f
    public void onComplete() {
        for (a aVar : this.f10502b.getAndSet(f10501f)) {
            if (!aVar.get()) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // h.a.f
    public void onError(Throwable th) {
        this.f10504d = th;
        for (a aVar : this.f10502b.getAndSet(f10501f)) {
            if (!aVar.get()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // h.a.f
    public void onSubscribe(h.a.u0.c cVar) {
    }

    void b(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f10502b.get();
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
                aVarArr2 = f10500e;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f10502b.compareAndSet(aVarArr, aVarArr2));
    }
}
