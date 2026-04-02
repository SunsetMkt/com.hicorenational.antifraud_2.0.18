package i.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import i.b2;
import i.n1;
import i.t0;

/* JADX INFO: compiled from: ULongRange.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
@i.y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/ULong;", "getStart", "contains", "", SurveyH5Bean.VALUE, "contains-VKZWuLQ", "(J)Z", "equals", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@i.k
public final class w extends u implements g<n1> {

    /* JADX INFO: renamed from: f */
    public static final a f12337f = new a(null);

    /* JADX INFO: renamed from: e */
    @j.c.a.d
    private static final w f12336e = new w(-1, 0, null);

    /* JADX INFO: compiled from: ULongRange.kt */
    public static final class a {
        private a() {
        }

        @j.c.a.d
        public final w a() {
            return w.f12336e;
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }
    }

    private w(long j2, long j3) {
        super(j2, j3, 1L, null);
    }

    public boolean a(long j2) {
        return b2.a(getFirst(), j2) <= 0 && b2.a(j2, getLast()) <= 0;
    }

    @Override // i.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((n1) comparable).a());
    }

    @Override // i.v2.u
    public boolean equals(@j.c.a.e Object obj) {
        if (obj instanceof w) {
            if (!isEmpty() || !((w) obj).isEmpty()) {
                w wVar = (w) obj;
                if (getFirst() != wVar.getFirst() || getLast() != wVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // i.v2.u
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) n1.c(getLast() ^ n1.c(getLast() >>> 32))) + (((int) n1.c(getFirst() ^ n1.c(getFirst() >>> 32))) * 31);
    }

    @Override // i.v2.u, i.v2.g
    public boolean isEmpty() {
        return b2.a(getFirst(), getLast()) > 0;
    }

    @Override // i.v2.u
    @j.c.a.d
    public String toString() {
        return n1.n(getFirst()) + ".." + n1.n(getLast());
    }

    public /* synthetic */ w(long j2, long j3, i.q2.t.v vVar) {
        this(j2, j3);
    }

    @Override // i.v2.g
    @j.c.a.d
    public n1 getEndInclusive() {
        return n1.a(getLast());
    }

    @Override // i.v2.g
    @j.c.a.d
    public n1 getStart() {
        return n1.a(getFirst());
    }
}
