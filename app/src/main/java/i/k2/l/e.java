package i.k2.l;

import androidx.exifinterface.media.ExifInterface;
import i.e1;
import i.q2.s.p;
import i.q2.t.i0;
import i.q2.t.j0;
import i.t0;
import i.y;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.1")
@y(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&\u00a2\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u00a6\u0002\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002\u00a8\u0006\u0013"}, d2 = {"Lkotlin/coroutines/experimental/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "minusKey", "plus", com.umeng.analytics.pro.d.R, "Element", "Key", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 16})
public interface e {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public static final class a {

        /* JADX INFO: renamed from: i.k2.l.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        static final class C0244a extends j0 implements p<e, b, e> {
            public static final C0244a INSTANCE = new C0244a();

            C0244a() {
                super(2);
            }

            @Override // i.q2.s.p
            @j.c.a.d
            public final e invoke(@j.c.a.d e eVar, @j.c.a.d b bVar) {
                i0.f(eVar, "acc");
                i0.f(bVar, "element");
                e eVarB = eVar.b(bVar.getKey());
                if (eVarB == g.f12127b) {
                    return bVar;
                }
                d dVar = (d) eVarB.a(d.a);
                if (dVar == null) {
                    return new i.k2.l.b(eVarB, bVar);
                }
                e eVarB2 = eVarB.b(d.a);
                return eVarB2 == g.f12127b ? new i.k2.l.b(bVar, dVar) : new i.k2.l.b(new i.k2.l.b(eVarB2, bVar), dVar);
            }
        }

        @j.c.a.d
        public static e a(e eVar, @j.c.a.d e eVar2) {
            i0.f(eVar2, com.umeng.analytics.pro.d.R);
            return eVar2 == g.f12127b ? eVar : (e) eVar2.fold(eVar, C0244a.INSTANCE);
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0010"}, d2 = {"Lkotlin/coroutines/experimental/CoroutineContext$Element;", "Lkotlin/coroutines/experimental/CoroutineContext;", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "minusKey", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 16})
    public interface b extends e {

        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class a {
            /* JADX WARN: Multi-variable type inference failed */
            @j.c.a.e
            public static <E extends b> E a(b bVar, @j.c.a.d c<E> cVar) {
                i0.f(cVar, "key");
                if (bVar.getKey() != cVar) {
                    return null;
                }
                if (bVar != 0) {
                    return bVar;
                }
                throw new e1("null cannot be cast to non-null type E");
            }

            @j.c.a.d
            public static e a(b bVar, @j.c.a.d e eVar) {
                i0.f(eVar, com.umeng.analytics.pro.d.R);
                return a.a(bVar, eVar);
            }

            @j.c.a.d
            public static e b(b bVar, @j.c.a.d c<?> cVar) {
                i0.f(cVar, "key");
                return bVar.getKey() == cVar ? g.f12127b : bVar;
            }

            public static <R> R a(b bVar, R r, @j.c.a.d p<? super R, ? super b, ? extends R> pVar) {
                i0.f(pVar, "operation");
                return pVar.invoke(r, bVar);
            }
        }

        @Override // i.k2.l.e
        @j.c.a.e
        <E extends b> E a(@j.c.a.d c<E> cVar);

        @Override // i.k2.l.e
        @j.c.a.d
        e b(@j.c.a.d c<?> cVar);

        @Override // i.k2.l.e
        <R> R fold(R r, @j.c.a.d p<? super R, ? super b, ? extends R> pVar);

        @j.c.a.d
        c<?> getKey();
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface c<E extends b> {
    }

    @j.c.a.e
    <E extends b> E a(@j.c.a.d c<E> cVar);

    @j.c.a.d
    e a(@j.c.a.d e eVar);

    @j.c.a.d
    e b(@j.c.a.d c<?> cVar);

    <R> R fold(R r, @j.c.a.d p<? super R, ? super b, ? extends R> pVar);
}
