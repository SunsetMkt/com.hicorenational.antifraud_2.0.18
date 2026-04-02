package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CompletableAmb.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h.a.c {
    private final h.a.i[] a;

    /* JADX INFO: renamed from: b */
    private final Iterable<? extends h.a.i> f10494b;

    /* JADX INFO: renamed from: h.a.y0.e.a.a$a */
    /* JADX INFO: compiled from: CompletableAmb.java */
    static final class C0182a implements h.a.f {
        private final AtomicBoolean a;

        /* JADX INFO: renamed from: b */
        private final h.a.u0.b f10495b;

        /* JADX INFO: renamed from: c */
        private final h.a.f f10496c;

        C0182a(AtomicBoolean atomicBoolean, h.a.u0.b bVar, h.a.f fVar) {
            this.a = atomicBoolean;
            this.f10495b = bVar;
            this.f10496c = fVar;
        }

        @Override // h.a.f
        public void onComplete() {
            if (this.a.compareAndSet(false, true)) {
                this.f10495b.dispose();
                this.f10496c.onComplete();
            }
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            if (!this.a.compareAndSet(false, true)) {
                h.a.c1.a.b(th);
            } else {
                this.f10495b.dispose();
                this.f10496c.onError(th);
            }
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.f10495b.b(cVar);
        }
    }

    public a(h.a.i[] iVarArr, Iterable<? extends h.a.i> iterable) {
        this.a = iVarArr;
        this.f10494b = iterable;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        int length;
        h.a.i[] iVarArr = this.a;
        if (iVarArr == null) {
            iVarArr = new h.a.i[8];
            try {
                length = 0;
                for (h.a.i iVar : this.f10494b) {
                    if (iVar == null) {
                        h.a.y0.a.e.error(new NullPointerException("One of the sources is null"), fVar);
                        return;
                    }
                    if (length == iVarArr.length) {
                        h.a.i[] iVarArr2 = new h.a.i[(length >> 2) + length];
                        System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                        iVarArr = iVarArr2;
                    }
                    int i2 = length + 1;
                    iVarArr[length] = iVar;
                    length = i2;
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.a.e.error(th, fVar);
                return;
            }
        } else {
            length = iVarArr.length;
        }
        h.a.u0.b bVar = new h.a.u0.b();
        fVar.onSubscribe(bVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        C0182a c0182a = new C0182a(atomicBoolean, bVar, fVar);
        for (int i3 = 0; i3 < length; i3++) {
            h.a.i iVar2 = iVarArr[i3];
            if (bVar.isDisposed()) {
                return;
            }
            if (iVar2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (!atomicBoolean.compareAndSet(false, true)) {
                    h.a.c1.a.b(nullPointerException);
                    return;
                } else {
                    bVar.dispose();
                    fVar.onError(nullPointerException);
                    return;
                }
            }
            iVar2.a(c0182a);
        }
        if (length == 0) {
            fVar.onComplete();
        }
    }
}
