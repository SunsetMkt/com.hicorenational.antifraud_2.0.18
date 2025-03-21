package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: KotlinVersion.kt */
@InterfaceC5610t0(version = "1.1")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m23546d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", DispatchConstants.OTHER, "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.q */
/* loaded from: classes2.dex */
public final class C5474q implements Comparable<C5474q> {

    /* renamed from: e */
    public static final int f20350e = 255;

    /* renamed from: a */
    private final int f20353a;

    /* renamed from: b */
    private final int f20354b;

    /* renamed from: c */
    private final int f20355c;

    /* renamed from: d */
    private final int f20356d;

    /* renamed from: g */
    public static final a f20352g = new a(null);

    /* renamed from: f */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final C5474q f20351f = new C5474q(1, 3, 70);

    /* compiled from: KotlinVersion.kt */
    /* renamed from: h.q$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public C5474q(int i2, int i3, int i4) {
        this.f20354b = i2;
        this.f20355c = i3;
        this.f20356d = i4;
        this.f20353a = m22437b(this.f20354b, this.f20355c, this.f20356d);
    }

    /* renamed from: a */
    public final int m22438a() {
        return this.f20354b;
    }

    /* renamed from: b */
    public final int m22442b() {
        return this.f20355c;
    }

    /* renamed from: c */
    public final int m22443c() {
        return this.f20356d;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5474q)) {
            obj = null;
        }
        C5474q c5474q = (C5474q) obj;
        return c5474q != null && this.f20353a == c5474q.f20353a;
    }

    public int hashCode() {
        return this.f20353a;
    }

    @InterfaceC5816d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f20354b);
        sb.append('.');
        sb.append(this.f20355c);
        sb.append('.');
        sb.append(this.f20356d);
        return sb.toString();
    }

    /* renamed from: b */
    private final int m22437b(int i2, int i3, int i4) {
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@InterfaceC5816d C5474q c5474q) {
        C5544i0.m22546f(c5474q, DispatchConstants.OTHER);
        return this.f20353a - c5474q.f20353a;
    }

    public C5474q(int i2, int i3) {
        this(i2, i3, 0);
    }

    /* renamed from: a */
    public final boolean m22440a(int i2, int i3) {
        int i4 = this.f20354b;
        return i4 > i2 || (i4 == i2 && this.f20355c >= i3);
    }

    /* renamed from: a */
    public final boolean m22441a(int i2, int i3, int i4) {
        int i5;
        int i6 = this.f20354b;
        return i6 > i2 || (i6 == i2 && ((i5 = this.f20355c) > i3 || (i5 == i3 && this.f20356d >= i4)));
    }
}
