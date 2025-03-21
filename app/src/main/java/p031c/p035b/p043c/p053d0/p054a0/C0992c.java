package p031c.p035b.p043c.p053d0.p054a0;

import p031c.p035b.p043c.C1109t;

/* compiled from: FinderPattern.java */
/* renamed from: c.b.c.d0.a0.c */
/* loaded from: classes.dex */
public final class C0992c {

    /* renamed from: a */
    private final int f1796a;

    /* renamed from: b */
    private final int[] f1797b;

    /* renamed from: c */
    private final C1109t[] f1798c;

    public C0992c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.f1796a = i2;
        this.f1797b = iArr;
        float f2 = i5;
        this.f1798c = new C1109t[]{new C1109t(i3, f2), new C1109t(i4, f2)};
    }

    /* renamed from: a */
    public C1109t[] m1380a() {
        return this.f1798c;
    }

    /* renamed from: b */
    public int[] m1381b() {
        return this.f1797b;
    }

    /* renamed from: c */
    public int m1382c() {
        return this.f1796a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0992c) && this.f1796a == ((C0992c) obj).f1796a;
    }

    public int hashCode() {
        return this.f1796a;
    }
}
