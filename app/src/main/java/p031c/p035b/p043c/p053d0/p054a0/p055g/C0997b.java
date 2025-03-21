package p031c.p035b.p043c.p053d0.p054a0.p055g;

import p031c.p035b.p043c.p053d0.p054a0.C0991b;
import p031c.p035b.p043c.p053d0.p054a0.C0992c;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ExpandedPair.java */
/* renamed from: c.b.c.d0.a0.g.b */
/* loaded from: classes.dex */
final class C0997b {

    /* renamed from: a */
    private final boolean f1810a;

    /* renamed from: b */
    private final C0991b f1811b;

    /* renamed from: c */
    private final C0991b f1812c;

    /* renamed from: d */
    private final C0992c f1813d;

    C0997b(C0991b c0991b, C0991b c0991b2, C0992c c0992c, boolean z) {
        this.f1811b = c0991b;
        this.f1812c = c0991b2;
        this.f1813d = c0992c;
        this.f1810a = z;
    }

    /* renamed from: a */
    C0992c m1399a() {
        return this.f1813d;
    }

    /* renamed from: b */
    C0991b m1400b() {
        return this.f1811b;
    }

    /* renamed from: c */
    C0991b m1401c() {
        return this.f1812c;
    }

    /* renamed from: d */
    boolean m1402d() {
        return this.f1810a;
    }

    /* renamed from: e */
    public boolean m1403e() {
        return this.f1812c == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0997b)) {
            return false;
        }
        C0997b c0997b = (C0997b) obj;
        return m1398a(this.f1811b, c0997b.f1811b) && m1398a(this.f1812c, c0997b.f1812c) && m1398a(this.f1813d, c0997b.f1813d);
    }

    public int hashCode() {
        return (m1397a(this.f1811b) ^ m1397a(this.f1812c)) ^ m1397a(this.f1813d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.f1811b);
        sb.append(" , ");
        sb.append(this.f1812c);
        sb.append(" : ");
        C0992c c0992c = this.f1813d;
        sb.append(c0992c == null ? AbstractC1191a.f2571h : Integer.valueOf(c0992c.m1382c()));
        sb.append(" ]");
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m1398a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: a */
    private static int m1397a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
