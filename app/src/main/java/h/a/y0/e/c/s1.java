package h.a.y0.e.c;

import h.a.y0.e.c.r1;
import h.a.y0.e.c.u0;
import java.util.Arrays;

/* JADX INFO: compiled from: MaybeZipIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s1<T, R> extends h.a.s<R> {
    final Iterable<? extends h.a.y<? extends T>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Object[], ? extends R> f11189b;

    /* JADX INFO: compiled from: MaybeZipIterable.java */
    final class a implements h.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // h.a.x0.o
        public R apply(T t) throws Exception {
            return (R) h.a.y0.b.b.a(s1.this.f11189b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public s1(Iterable<? extends h.a.y<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        this.a = iterable;
        this.f11189b = oVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        h.a.y[] yVarArr = new h.a.y[8];
        try {
            h.a.y[] yVarArr2 = yVarArr;
            int i2 = 0;
            for (h.a.y<? extends T> yVar : this.a) {
                if (yVar == null) {
                    h.a.y0.a.e.error(new NullPointerException("One of the sources is null"), vVar);
                    return;
                }
                if (i2 == yVarArr2.length) {
                    yVarArr2 = (h.a.y[]) Arrays.copyOf(yVarArr2, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                yVarArr2[i2] = yVar;
                i2 = i3;
            }
            if (i2 == 0) {
                h.a.y0.a.e.complete(vVar);
                return;
            }
            if (i2 == 1) {
                yVarArr2[0].a(new u0.a(vVar, new a()));
                return;
            }
            r1.b bVar = new r1.b(vVar, i2, this.f11189b);
            vVar.onSubscribe(bVar);
            for (int i4 = 0; i4 < i2 && !bVar.isDisposed(); i4++) {
                yVarArr2[i4].a(bVar.observers[i4]);
            }
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, vVar);
        }
    }
}
