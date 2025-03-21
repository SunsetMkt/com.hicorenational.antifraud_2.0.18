package p286h.p319v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p304m2.C5433m;
import p286h.p309q2.p311t.C5586v;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Progressions.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, m23546d2 = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.v2.l */
/* loaded from: classes2.dex */
public class C5643l implements Iterable<Long>, InterfaceC5569a {

    /* renamed from: d */
    public static final a f20520d = new a(null);

    /* renamed from: a */
    private final long f20521a;

    /* renamed from: b */
    private final long f20522b;

    /* renamed from: c */
    private final long f20523c;

    /* compiled from: Progressions.kt */
    /* renamed from: h.v2.l$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5643l m23028a(long j2, long j3, long j4) {
            return new C5643l(j2, j3, j4);
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public C5643l(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f20521a = j2;
        this.f20522b = C5433m.m22187b(j2, j3, j4);
        this.f20523c = j4;
    }

    /* renamed from: b */
    public final long m23027b() {
        return this.f20523c;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5643l) {
            if (!isEmpty() || !((C5643l) obj).isEmpty()) {
                C5643l c5643l = (C5643l) obj;
                if (this.f20521a != c5643l.f20521a || this.f20522b != c5643l.f20522b || this.f20523c != c5643l.f20523c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.f20521a;
    }

    public final long getLast() {
        return this.f20522b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = 31;
        long j3 = this.f20521a;
        long j4 = this.f20522b;
        long j5 = j2 * (((j3 ^ (j3 >>> 32)) * j2) + (j4 ^ (j4 >>> 32)));
        long j6 = this.f20523c;
        return (int) (j5 + (j6 ^ (j6 >>> 32)));
    }

    public boolean isEmpty() {
        long j2 = this.f20523c;
        long j3 = this.f20521a;
        long j4 = this.f20522b;
        if (j2 > 0) {
            if (j3 > j4) {
                return true;
            }
        } else if (j3 < j4) {
            return true;
        }
        return false;
    }

    @InterfaceC5816d
    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.f20523c > 0) {
            sb = new StringBuilder();
            sb.append(this.f20521a);
            sb.append("..");
            sb.append(this.f20522b);
            sb.append(" step ");
            j2 = this.f20523c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f20521a);
            sb.append(" downTo ");
            sb.append(this.f20522b);
            sb.append(" step ");
            j2 = -this.f20523c;
        }
        sb.append(j2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @InterfaceC5816d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Long> iterator2() {
        return new C5644m(this.f20521a, this.f20522b, this.f20523c);
    }
}
