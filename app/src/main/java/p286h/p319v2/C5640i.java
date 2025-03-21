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
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m23546d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.v2.i */
/* loaded from: classes2.dex */
public class C5640i implements Iterable<Integer>, InterfaceC5569a {

    /* renamed from: d */
    public static final a f20510d = new a(null);

    /* renamed from: a */
    private final int f20511a;

    /* renamed from: b */
    private final int f20512b;

    /* renamed from: c */
    private final int f20513c;

    /* compiled from: Progressions.kt */
    /* renamed from: h.v2.i$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5640i m23022a(int i2, int i3, int i4) {
            return new C5640i(i2, i3, i4);
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public C5640i(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f20511a = i2;
        this.f20512b = C5433m.m22186b(i2, i3, i4);
        this.f20513c = i4;
    }

    /* renamed from: b */
    public final int m23021b() {
        return this.f20513c;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5640i) {
            if (!isEmpty() || !((C5640i) obj).isEmpty()) {
                C5640i c5640i = (C5640i) obj;
                if (this.f20511a != c5640i.f20511a || this.f20512b != c5640i.f20512b || this.f20513c != c5640i.f20513c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f20511a;
    }

    public final int getLast() {
        return this.f20512b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f20511a * 31) + this.f20512b) * 31) + this.f20513c;
    }

    public boolean isEmpty() {
        if (this.f20513c > 0) {
            if (this.f20511a > this.f20512b) {
                return true;
            }
        } else if (this.f20511a < this.f20512b) {
            return true;
        }
        return false;
    }

    @InterfaceC5816d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f20513c > 0) {
            sb = new StringBuilder();
            sb.append(this.f20511a);
            sb.append("..");
            sb.append(this.f20512b);
            sb.append(" step ");
            i2 = this.f20513c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f20511a);
            sb.append(" downTo ");
            sb.append(this.f20512b);
            sb.append(" step ");
            i2 = -this.f20513c;
        }
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @InterfaceC5816d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Integer> iterator2() {
        return new C5641j(this.f20511a, this.f20512b, this.f20513c);
    }
}
