package i.k2.l;

import androidx.exifinterface.media.ExifInterface;
import i.k2.l.e;
import i.q2.s.p;
import i.q2.t.i0;
import i.t0;
import i.y;

/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.1")
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lkotlin/coroutines/experimental/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/experimental/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "Key", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 16})
public interface d extends e.b {
    public static final b a = b.a;

    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class a {
        @j.c.a.e
        public static <E extends e.b> E a(d dVar, @j.c.a.d e.c<E> cVar) {
            i0.f(cVar, "key");
            return (E) e.b.a.a(dVar, cVar);
        }

        @j.c.a.d
        public static e a(d dVar, @j.c.a.d e eVar) {
            i0.f(eVar, com.umeng.analytics.pro.d.R);
            return e.b.a.a(dVar, eVar);
        }

        public static <R> R a(d dVar, R r, @j.c.a.d p<? super R, ? super e.b, ? extends R> pVar) {
            i0.f(pVar, "operation");
            return (R) e.b.a.a(dVar, r, pVar);
        }

        @j.c.a.d
        public static e b(d dVar, @j.c.a.d e.c<?> cVar) {
            i0.f(cVar, "key");
            return e.b.a.b(dVar, cVar);
        }
    }

    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class b implements e.c<d> {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    @j.c.a.d
    <T> c<T> a(@j.c.a.d c<? super T> cVar);
}
