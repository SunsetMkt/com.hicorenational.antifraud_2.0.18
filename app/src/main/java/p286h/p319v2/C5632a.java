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
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m23546d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.v2.a */
/* loaded from: classes2.dex */
public class C5632a implements Iterable<Character>, InterfaceC5569a {

    /* renamed from: d */
    public static final a f20494d = new a(null);

    /* renamed from: a */
    private final char f20495a;

    /* renamed from: b */
    private final char f20496b;

    /* renamed from: c */
    private final int f20497c;

    /* compiled from: Progressions.kt */
    /* renamed from: h.v2.a$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5632a m23007a(char c2, char c3, int i2) {
            return new C5632a(c2, c3, i2);
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public C5632a(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f20495a = c2;
        this.f20496b = (char) C5433m.m22186b((int) c2, (int) c3, i2);
        this.f20497c = i2;
    }

    /* renamed from: b */
    public final int m23006b() {
        return this.f20497c;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5632a) {
            if (!isEmpty() || !((C5632a) obj).isEmpty()) {
                C5632a c5632a = (C5632a) obj;
                if (this.f20495a != c5632a.f20495a || this.f20496b != c5632a.f20496b || this.f20497c != c5632a.f20497c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char getFirst() {
        return this.f20495a;
    }

    public final char getLast() {
        return this.f20496b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f20495a * 31) + this.f20496b) * 31) + this.f20497c;
    }

    public boolean isEmpty() {
        if (this.f20497c > 0) {
            if (this.f20495a > this.f20496b) {
                return true;
            }
        } else if (this.f20495a < this.f20496b) {
            return true;
        }
        return false;
    }

    @InterfaceC5816d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f20497c > 0) {
            sb = new StringBuilder();
            sb.append(this.f20495a);
            sb.append("..");
            sb.append(this.f20496b);
            sb.append(" step ");
            i2 = this.f20497c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f20495a);
            sb.append(" downTo ");
            sb.append(this.f20496b);
            sb.append(" step ");
            i2 = -this.f20497c;
        }
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @InterfaceC5816d
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Character> iterator2() {
        return new C5633b(this.f20495a, this.f20496b, this.f20497c);
    }
}
