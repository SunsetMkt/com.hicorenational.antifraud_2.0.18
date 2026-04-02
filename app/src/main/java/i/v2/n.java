package i.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", SurveyH5Bean.VALUE, "equals", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class n extends l implements g<Long> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12321f = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @j.c.a.d
    private static final n f12320e = new n(1, 0);

    /* JADX INFO: compiled from: Ranges.kt */
    public static final class a {
        private a() {
        }

        @j.c.a.d
        public final n a() {
            return n.f12320e;
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }
    }

    public n(long j2, long j3) {
        super(j2, j3, 1L);
    }

    public boolean a(long j2) {
        return getFirst() <= j2 && j2 <= getLast();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).longValue());
    }

    @Override // i.v2.l
    public boolean equals(@j.c.a.e Object obj) {
        if (obj instanceof n) {
            if (!isEmpty() || !((n) obj).isEmpty()) {
                n nVar = (n) obj;
                if (getFirst() != nVar.getFirst() || getLast() != nVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // i.v2.l
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    @Override // i.v2.l, i.v2.g
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // i.v2.l
    @j.c.a.d
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    @Override // i.v2.g
    @j.c.a.d
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // i.v2.g
    @j.c.a.d
    public Long getStart() {
        return Long.valueOf(getFirst());
    }
}
