package i.v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Iterator;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public class a implements Iterable<Character>, i.q2.t.q1.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0250a f12295d = new C0250a(null);
    private final char a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f12296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12297c;

    /* JADX INFO: renamed from: i.v2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Progressions.kt */
    public static final class C0250a {
        private C0250a() {
        }

        @j.c.a.d
        public final a a(char c2, char c3, int i2) {
            return new a(c2, c3, i2);
        }

        public /* synthetic */ C0250a(i.q2.t.v vVar) {
            this();
        }
    }

    public a(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = c2;
        this.f12296b = (char) i.m2.m.b((int) c2, (int) c3, i2);
        this.f12297c = i2;
    }

    public final int b() {
        return this.f12297c;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.a != aVar.a || this.f12296b != aVar.f12296b || this.f12297c != aVar.f12297c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char getFirst() {
        return this.a;
    }

    public final char getLast() {
        return this.f12296b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.f12296b) * 31) + this.f12297c;
    }

    public boolean isEmpty() {
        if (this.f12297c > 0) {
            if (this.a > this.f12296b) {
                return true;
            }
        } else if (this.a < this.f12296b) {
            return true;
        }
        return false;
    }

    @j.c.a.d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f12297c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.f12296b);
            sb.append(" step ");
            i2 = this.f12297c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.f12296b);
            sb.append(" step ");
            i2 = -this.f12297c;
        }
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @j.c.a.d
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Character> iterator2() {
        return new b(this.a, this.f12296b, this.f12297c);
    }
}
