package h.a.y0.e.b;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: FlowableWithLatestFromMany.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r4<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h.a.t0.g
    final j.d.b<?>[] f10952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h.a.t0.g
    final Iterable<? extends j.d.b<?>> f10953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.x0.o<? super Object[], R> f10954e;

    /* JADX INFO: compiled from: FlowableWithLatestFromMany.java */
    final class a implements h.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // h.a.x0.o
        public R apply(T t) throws Exception {
            return (R) h.a.y0.b.b.a(r4.this.f10954e.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* JADX INFO: compiled from: FlowableWithLatestFromMany.java */
    static final class b<T, R> extends AtomicInteger implements h.a.y0.c.a<T>, j.d.d {
        private static final long serialVersionUID = 1577321883966341961L;
        final j.d.c<? super R> actual;
        final h.a.x0.o<? super Object[], R> combiner;
        volatile boolean done;
        final h.a.y0.j.c error;
        final AtomicLong requested;
        final AtomicReference<j.d.d> s;
        final c[] subscribers;
        final AtomicReferenceArray<Object> values;

        b(j.d.c<? super R> cVar, h.a.x0.o<? super Object[], R> oVar, int i2) {
            this.actual = cVar;
            this.combiner = oVar;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.subscribers = cVarArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.s = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new h.a.y0.j.c();
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this.s);
            for (c cVar : this.subscribers) {
                cVar.dispose();
            }
        }

        void cancelAllBut(int i2) {
            c[] cVarArr = this.subscribers;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].dispose();
                }
            }
        }

        void innerComplete(int i2, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            h.a.y0.i.j.cancel(this.s);
            cancelAllBut(i2);
            h.a.y0.j.l.a(this.actual, this, this.error);
        }

        void innerError(int i2, Throwable th) {
            this.done = true;
            h.a.y0.i.j.cancel(this.s);
            cancelAllBut(i2);
            h.a.y0.j.l.a((j.d.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext(int i2, Object obj) {
            this.values.set(i2, obj);
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            h.a.y0.j.l.a(this.actual, this, this.error);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            h.a.y0.j.l.a((j.d.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (tryOnNext(t) || this.done) {
                return;
            }
            this.s.get().request(1L);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            h.a.y0.i.j.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
        }

        void subscribe(j.d.b<?>[] bVarArr, int i2) {
            c[] cVarArr = this.subscribers;
            AtomicReference<j.d.d> atomicReference = this.s;
            for (int i3 = 0; i3 < i2 && !h.a.y0.i.j.isCancelled(atomicReference.get()); i3++) {
                bVarArr[i3].subscribe(cVarArr[i3]);
            }
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = t;
            int i2 = 0;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return false;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                h.a.y0.j.l.a(this.actual, h.a.y0.b.b.a(this.combiner.apply(objArr), "The combiner returned a null value"), this, this.error);
                return true;
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                onError(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: FlowableWithLatestFromMany.java */
    static final class c extends AtomicReference<j.d.d> implements h.a.q<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final b<?, ?> parent;

        c(b<?, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        void dispose() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // j.d.c
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public r4(@h.a.t0.f h.a.l<T> lVar, @h.a.t0.f j.d.b<?>[] bVarArr, h.a.x0.o<? super Object[], R> oVar) {
        super(lVar);
        this.f10952c = bVarArr;
        this.f10953d = null;
        this.f10954e = oVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        int length;
        j.d.b<?>[] bVarArr = this.f10952c;
        if (bVarArr == null) {
            bVarArr = new j.d.b[8];
            try {
                length = 0;
                for (j.d.b<?> bVar : this.f10953d) {
                    if (length == bVarArr.length) {
                        bVarArr = (j.d.b[]) Arrays.copyOf(bVarArr, (length >> 1) + length);
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
            new y1(this.f10561b, new a()).d((j.d.c) cVar);
            return;
        }
        b bVar2 = new b(cVar, this.f10954e, length);
        cVar.onSubscribe(bVar2);
        bVar2.subscribe(bVarArr, length);
        this.f10561b.a((h.a.q) bVar2);
    }

    public r4(@h.a.t0.f h.a.l<T> lVar, @h.a.t0.f Iterable<? extends j.d.b<?>> iterable, @h.a.t0.f h.a.x0.o<? super Object[], R> oVar) {
        super(lVar);
        this.f10952c = null;
        this.f10953d = iterable;
        this.f10954e = oVar;
    }
}
