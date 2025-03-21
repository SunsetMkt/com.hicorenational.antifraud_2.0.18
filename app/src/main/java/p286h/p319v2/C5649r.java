package p286h.p319v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Iterator;
import p286h.C5215b2;
import p286h.C5341j1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p304m2.C5437q;
import p286h.p309q2.p311t.C5586v;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UIntRange.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m23546d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()I", "I", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/UIntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.v2.r */
/* loaded from: classes2.dex */
public class C5649r implements Iterable<C5341j1>, InterfaceC5569a {

    /* renamed from: d */
    public static final a f20530d = new a(null);

    /* renamed from: a */
    private final int f20531a;

    /* renamed from: b */
    private final int f20532b;

    /* renamed from: c */
    private final int f20533c;

    /* compiled from: UIntRange.kt */
    /* renamed from: h.v2.r$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5649r m23169a(int i2, int i3, int i4) {
            return new C5649r(i2, i3, i4, null);
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public /* synthetic */ C5649r(int i2, int i3, int i4, C5586v c5586v) {
        this(i2, i3, i4);
    }

    /* renamed from: b */
    public final int m23168b() {
        return this.f20533c;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5649r) {
            if (!isEmpty() || !((C5649r) obj).isEmpty()) {
                C5649r c5649r = (C5649r) obj;
                if (this.f20531a != c5649r.f20531a || this.f20532b != c5649r.f20532b || this.f20533c != c5649r.f20533c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f20531a;
    }

    public final int getLast() {
        return this.f20532b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f20531a * 31) + this.f20532b) * 31) + this.f20533c;
    }

    public boolean isEmpty() {
        if (this.f20533c > 0) {
            if (C5215b2.m18812a(this.f20531a, this.f20532b) > 0) {
                return true;
            }
        } else if (C5215b2.m18812a(this.f20531a, this.f20532b) < 0) {
            return true;
        }
        return false;
    }

    @InterfaceC5816d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f20533c > 0) {
            sb = new StringBuilder();
            sb.append(C5341j1.m21963n(this.f20531a));
            sb.append("..");
            sb.append(C5341j1.m21963n(this.f20532b));
            sb.append(" step ");
            i2 = this.f20533c;
        } else {
            sb = new StringBuilder();
            sb.append(C5341j1.m21963n(this.f20531a));
            sb.append(" downTo ");
            sb.append(C5341j1.m21963n(this.f20532b));
            sb.append(" step ");
            i2 = -this.f20533c;
        }
        sb.append(i2);
        return sb.toString();
    }

    private C5649r(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f20531a = i2;
        this.f20532b = C5437q.m22190b(i2, i3, i4);
        this.f20533c = i4;
    }

    @Override // java.lang.Iterable
    @InterfaceC5816d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<C5341j1> iterator2() {
        return new C5650s(this.f20531a, this.f20532b, this.f20533c, null);
    }
}
