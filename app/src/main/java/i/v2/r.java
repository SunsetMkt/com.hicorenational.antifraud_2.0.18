package i.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import i.b2;
import i.j1;
import i.t0;
import java.util.Iterator;

/* JADX INFO: compiled from: UIntRange.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
@i.y(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\b\u001a\u00020\u0002\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()I", "I", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/UIntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@i.k
public class r implements Iterable<j1>, i.q2.t.q1.a {

    /* JADX INFO: renamed from: d */
    public static final a f12322d = new a(null);
    private final int a;

    /* JADX INFO: renamed from: b */
    private final int f12323b;

    /* JADX INFO: renamed from: c */
    private final int f12324c;

    /* JADX INFO: compiled from: UIntRange.kt */
    public static final class a {
        private a() {
        }

        @j.c.a.d
        public final r a(int i2, int i3, int i4) {
            return new r(i2, i3, i4, null);
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }
    }

    public /* synthetic */ r(int i2, int i3, int i4, i.q2.t.v vVar) {
        this(i2, i3, i4);
    }

    public final int b() {
        return this.f12324c;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (obj instanceof r) {
            if (!isEmpty() || !((r) obj).isEmpty()) {
                r rVar = (r) obj;
                if (this.a != rVar.a || this.f12323b != rVar.f12323b || this.f12324c != rVar.f12324c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.a;
    }

    public final int getLast() {
        return this.f12323b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.f12323b) * 31) + this.f12324c;
    }

    public boolean isEmpty() {
        if (this.f12324c > 0) {
            if (b2.a(this.a, this.f12323b) > 0) {
                return true;
            }
        } else if (b2.a(this.a, this.f12323b) < 0) {
            return true;
        }
        return false;
    }

    @j.c.a.d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f12324c > 0) {
            sb = new StringBuilder();
            sb.append(j1.n(this.a));
            sb.append("..");
            sb.append(j1.n(this.f12323b));
            sb.append(" step ");
            i2 = this.f12324c;
        } else {
            sb = new StringBuilder();
            sb.append(j1.n(this.a));
            sb.append(" downTo ");
            sb.append(j1.n(this.f12323b));
            sb.append(" step ");
            i2 = -this.f12324c;
        }
        sb.append(i2);
        return sb.toString();
    }

    private r(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = i2;
        this.f12323b = i.m2.q.b(i2, i3, i4);
        this.f12324c = i4;
    }

    @Override // java.lang.Iterable
    @j.c.a.d
    /* JADX INFO: renamed from: iterator */
    public Iterator<j1> iterator2() {
        return new s(this.a, this.f12323b, this.f12324c, null);
    }
}
