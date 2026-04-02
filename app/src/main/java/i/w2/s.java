package i.w2;

import anet.channel.strategy.dispatch.DispatchConstants;
import i.q2.t.i0;
import i.t0;
import i.y;

/* JADX INFO: compiled from: KType.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.1")
@y(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", DispatchConstants.OTHER, "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class s {

    @j.c.a.e
    private final t a;

    /* JADX INFO: renamed from: b */
    @j.c.a.e
    private final q f12340b;

    /* JADX INFO: renamed from: d */
    public static final a f12339d = new a(null);

    /* JADX INFO: renamed from: c */
    @j.c.a.d
    private static final s f12338c = new s(null, null);

    /* JADX INFO: compiled from: KType.kt */
    public static final class a {
        private a() {
        }

        @j.c.a.d
        public final s a() {
            return s.f12338c;
        }

        @j.c.a.d
        public final s b(@j.c.a.d q qVar) {
            i0.f(qVar, "type");
            return new s(t.OUT, qVar);
        }

        @j.c.a.d
        public final s c(@j.c.a.d q qVar) {
            i0.f(qVar, "type");
            return new s(t.INVARIANT, qVar);
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }

        @j.c.a.d
        public final s a(@j.c.a.d q qVar) {
            i0.f(qVar, "type");
            return new s(t.IN, qVar);
        }
    }

    public s(@j.c.a.e t tVar, @j.c.a.e q qVar) {
        this.a = tVar;
        this.f12340b = qVar;
    }

    public static /* synthetic */ s a(s sVar, t tVar, q qVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            tVar = sVar.a;
        }
        if ((i2 & 2) != 0) {
            qVar = sVar.f12340b;
        }
        return sVar.a(tVar, qVar);
    }

    @j.c.a.d
    public final s a(@j.c.a.e t tVar, @j.c.a.e q qVar) {
        return new s(tVar, qVar);
    }

    @j.c.a.e
    public final t a() {
        return this.a;
    }

    @j.c.a.e
    public final q b() {
        return this.f12340b;
    }

    @j.c.a.e
    public final q c() {
        return this.f12340b;
    }

    @j.c.a.e
    public final t d() {
        return this.a;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return i0.a(this.a, sVar.a) && i0.a(this.f12340b, sVar.f12340b);
    }

    public int hashCode() {
        t tVar = this.a;
        int iHashCode = (tVar != null ? tVar.hashCode() : 0) * 31;
        q qVar = this.f12340b;
        return iHashCode + (qVar != null ? qVar.hashCode() : 0);
    }

    @j.c.a.d
    public String toString() {
        return "KTypeProjection(variance=" + this.a + ", type=" + this.f12340b + ")";
    }
}
