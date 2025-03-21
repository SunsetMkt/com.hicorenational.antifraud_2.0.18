package p286h.p319v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Iterator;
import p286h.C5215b2;
import p286h.C5441n1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p304m2.C5437q;
import p286h.p309q2.p311t.C5586v;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ULongRange.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m23546d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()J", "J", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/ULongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.v2.u */
/* loaded from: classes2.dex */
public class C5652u implements Iterable<C5441n1>, InterfaceC5569a {

    /* renamed from: d */
    public static final a f20540d = new a(null);

    /* renamed from: a */
    private final long f20541a;

    /* renamed from: b */
    private final long f20542b;

    /* renamed from: c */
    private final long f20543c;

    /* compiled from: ULongRange.kt */
    /* renamed from: h.v2.u$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5652u m23174a(long j2, long j3, long j4) {
            return new C5652u(j2, j3, j4, null);
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public /* synthetic */ C5652u(long j2, long j3, long j4, C5586v c5586v) {
        this(j2, j3, j4);
    }

    /* renamed from: b */
    public final long m23173b() {
        return this.f20543c;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5652u) {
            if (!isEmpty() || !((C5652u) obj).isEmpty()) {
                C5652u c5652u = (C5652u) obj;
                if (this.f20541a != c5652u.f20541a || this.f20542b != c5652u.f20542b || this.f20543c != c5652u.f20543c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.f20541a;
    }

    public final long getLast() {
        return this.f20542b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = this.f20541a;
        int m22205c = ((int) C5441n1.m22205c(j2 ^ C5441n1.m22205c(j2 >>> 32))) * 31;
        long j3 = this.f20542b;
        int m22205c2 = (m22205c + ((int) C5441n1.m22205c(j3 ^ C5441n1.m22205c(j3 >>> 32)))) * 31;
        long j4 = this.f20543c;
        return ((int) (j4 ^ (j4 >>> 32))) + m22205c2;
    }

    public boolean isEmpty() {
        long j2 = this.f20543c;
        int m18813a = C5215b2.m18813a(this.f20541a, this.f20542b);
        if (j2 > 0) {
            if (m18813a > 0) {
                return true;
            }
        } else if (m18813a < 0) {
            return true;
        }
        return false;
    }

    @InterfaceC5816d
    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.f20543c > 0) {
            sb = new StringBuilder();
            sb.append(C5441n1.m22239n(this.f20541a));
            sb.append("..");
            sb.append(C5441n1.m22239n(this.f20542b));
            sb.append(" step ");
            j2 = this.f20543c;
        } else {
            sb = new StringBuilder();
            sb.append(C5441n1.m22239n(this.f20541a));
            sb.append(" downTo ");
            sb.append(C5441n1.m22239n(this.f20542b));
            sb.append(" step ");
            j2 = -this.f20543c;
        }
        sb.append(j2);
        return sb.toString();
    }

    private C5652u(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f20541a = j2;
        this.f20542b = C5437q.m22191b(j2, j3, j4);
        this.f20543c = j4;
    }

    @Override // java.lang.Iterable
    @InterfaceC5816d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<C5441n1> iterator2() {
        return new C5653v(this.f20541a, this.f20542b, this.f20543c, null);
    }
}
