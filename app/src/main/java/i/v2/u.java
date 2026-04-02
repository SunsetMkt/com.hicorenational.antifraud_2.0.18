package i.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import i.b2;
import i.n1;
import i.t0;
import java.util.Iterator;

/* JADX INFO: compiled from: ULongRange.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
@i.y(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\b\u001a\u00020\u0002\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()J", "J", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/ULongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@i.k
public class u implements Iterable<n1>, i.q2.t.q1.a {

    /* JADX INFO: renamed from: d */
    public static final a f12330d = new a(null);
    private final long a;

    /* JADX INFO: renamed from: b */
    private final long f12331b;

    /* JADX INFO: renamed from: c */
    private final long f12332c;

    /* JADX INFO: compiled from: ULongRange.kt */
    public static final class a {
        private a() {
        }

        @j.c.a.d
        public final u a(long j2, long j3, long j4) {
            return new u(j2, j3, j4, null);
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }
    }

    public /* synthetic */ u(long j2, long j3, long j4, i.q2.t.v vVar) {
        this(j2, j3, j4);
    }

    public final long b() {
        return this.f12332c;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (obj instanceof u) {
            if (!isEmpty() || !((u) obj).isEmpty()) {
                u uVar = (u) obj;
                if (this.a != uVar.a || this.f12331b != uVar.f12331b || this.f12332c != uVar.f12332c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.a;
    }

    public final long getLast() {
        return this.f12331b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = this.a;
        int iC = ((int) n1.c(j2 ^ n1.c(j2 >>> 32))) * 31;
        long j3 = this.f12331b;
        int iC2 = (iC + ((int) n1.c(j3 ^ n1.c(j3 >>> 32)))) * 31;
        long j4 = this.f12332c;
        return ((int) (j4 ^ (j4 >>> 32))) + iC2;
    }

    public boolean isEmpty() {
        long j2 = this.f12332c;
        int iA = b2.a(this.a, this.f12331b);
        if (j2 > 0) {
            if (iA > 0) {
                return true;
            }
        } else if (iA < 0) {
            return true;
        }
        return false;
    }

    @j.c.a.d
    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.f12332c > 0) {
            sb = new StringBuilder();
            sb.append(n1.n(this.a));
            sb.append("..");
            sb.append(n1.n(this.f12331b));
            sb.append(" step ");
            j2 = this.f12332c;
        } else {
            sb = new StringBuilder();
            sb.append(n1.n(this.a));
            sb.append(" downTo ");
            sb.append(n1.n(this.f12331b));
            sb.append(" step ");
            j2 = -this.f12332c;
        }
        sb.append(j2);
        return sb.toString();
    }

    private u(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = j2;
        this.f12331b = i.m2.q.b(j2, j3, j4);
        this.f12332c = j4;
    }

    @Override // java.lang.Iterable
    @j.c.a.d
    /* JADX INFO: renamed from: iterator */
    public Iterator<n1> iterator2() {
        return new v(this.a, this.f12331b, this.f12332c, null);
    }
}
