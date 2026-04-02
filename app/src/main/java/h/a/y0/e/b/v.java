package h.a.y0.e.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableConcatArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<? extends T>[] f11013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11014c;

    /* JADX INFO: compiled from: FlowableConcatArray.java */
    static final class a<T> extends h.a.y0.i.i implements h.a.q<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final j.d.c<? super T> actual;
        final boolean delayError;
        List<Throwable> errors;
        int index;
        long produced;
        final j.d.b<? extends T>[] sources;
        final AtomicInteger wip = new AtomicInteger();

        a(j.d.b<? extends T>[] bVarArr, boolean z, j.d.c<? super T> cVar) {
            this.actual = cVar;
            this.sources = bVarArr;
            this.delayError = z;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                j.d.b<? extends T>[] bVarArr = this.sources;
                int length = bVarArr.length;
                int i2 = this.index;
                while (i2 != length) {
                    j.d.b<? extends T> bVar = bVarArr[i2];
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (!this.delayError) {
                            this.actual.onError(nullPointerException);
                            return;
                        }
                        List arrayList = this.errors;
                        if (arrayList == null) {
                            arrayList = new ArrayList((length - i2) + 1);
                            this.errors = arrayList;
                        }
                        arrayList.add(nullPointerException);
                        i2++;
                    } else {
                        long j2 = this.produced;
                        if (j2 != 0) {
                            this.produced = 0L;
                            produced(j2);
                        }
                        bVar.subscribe(this);
                        i2++;
                        this.index = i2;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list = this.errors;
                if (list == null) {
                    this.actual.onComplete();
                } else if (list.size() == 1) {
                    this.actual.onError(list.get(0));
                } else {
                    this.actual.onError(new h.a.v0.a(list));
                }
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (!this.delayError) {
                this.actual.onError(th);
                return;
            }
            List arrayList = this.errors;
            if (arrayList == null) {
                arrayList = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = arrayList;
            }
            arrayList.add(th);
            onComplete();
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            setSubscription(dVar);
        }
    }

    public v(j.d.b<? extends T>[] bVarArr, boolean z) {
        this.f11013b = bVarArr;
        this.f11014c = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        a aVar = new a(this.f11013b, this.f11014c, cVar);
        cVar.onSubscribe(aVar);
        aVar.onComplete();
    }
}
