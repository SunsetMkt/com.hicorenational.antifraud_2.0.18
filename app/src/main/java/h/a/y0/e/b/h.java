package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableAmb.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<? extends T>[] f10687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Iterable<? extends j.d.b<? extends T>> f10688c;

    /* JADX INFO: compiled from: FlowableAmb.java */
    static final class b<T> extends AtomicReference<j.d.d> implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -1185974347409665484L;
        final j.d.c<? super T> actual;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final a<T> parent;
        boolean won;

        b(a<T> aVar, int i2, j.d.c<? super T> cVar) {
            this.parent = aVar;
            this.index = i2;
            this.actual = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (!this.parent.a(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.a(this.index)) {
                this.won = true;
                this.actual.onError(th);
            } else {
                get().cancel();
                h.a.c1.a.b(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (!this.parent.a(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.actual.onNext(t);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            h.a.y0.i.j.deferredSetOnce(this, this.missedRequested, dVar);
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this, this.missedRequested, j2);
        }
    }

    public h(j.d.b<? extends T>[] bVarArr, Iterable<? extends j.d.b<? extends T>> iterable) {
        this.f10687b = bVarArr;
        this.f10688c = iterable;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        int length;
        j.d.b<? extends T>[] bVarArr = this.f10687b;
        if (bVarArr == null) {
            bVarArr = new j.d.b[8];
            try {
                length = 0;
                for (j.d.b<? extends T> bVar : this.f10688c) {
                    if (bVar == null) {
                        h.a.y0.i.g.error(new NullPointerException("One of the sources is null"), cVar);
                        return;
                    }
                    if (length == bVarArr.length) {
                        j.d.b<? extends T>[] bVarArr2 = new j.d.b[(length >> 2) + length];
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                        bVarArr = bVarArr2;
                    }
                    int i2 = length + 1;
                    bVarArr[length] = bVar;
                    length = i2;
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.i.g.error(th, cVar);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            h.a.y0.i.g.complete(cVar);
        } else if (length == 1) {
            bVarArr[0].subscribe(cVar);
        } else {
            new a(cVar, length).a(bVarArr);
        }
    }

    /* JADX INFO: compiled from: FlowableAmb.java */
    static final class a<T> implements j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T>[] f10689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f10690c = new AtomicInteger();

        a(j.d.c<? super T> cVar, int i2) {
            this.a = cVar;
            this.f10689b = new b[i2];
        }

        public void a(j.d.b<? extends T>[] bVarArr) {
            b<T>[] bVarArr2 = this.f10689b;
            int length = bVarArr2.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr2[i2] = new b<>(this, i3, this.a);
                i2 = i3;
            }
            this.f10690c.lazySet(0);
            this.a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f10690c.get() == 0; i4++) {
                bVarArr[i4].subscribe(bVarArr2[i4]);
            }
        }

        @Override // j.d.d
        public void cancel() {
            if (this.f10690c.get() != -1) {
                this.f10690c.lazySet(-1);
                for (b<T> bVar : this.f10689b) {
                    bVar.cancel();
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                int i2 = this.f10690c.get();
                if (i2 > 0) {
                    this.f10689b[i2 - 1].request(j2);
                    return;
                }
                if (i2 == 0) {
                    for (b<T> bVar : this.f10689b) {
                        bVar.request(j2);
                    }
                }
            }
        }

        public boolean a(int i2) {
            int i3 = 0;
            if (this.f10690c.get() != 0 || !this.f10690c.compareAndSet(0, i2)) {
                return false;
            }
            b<T>[] bVarArr = this.f10689b;
            int length = bVarArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i2) {
                    bVarArr[i3].cancel();
                }
                i3 = i4;
            }
            return true;
        }
    }
}
