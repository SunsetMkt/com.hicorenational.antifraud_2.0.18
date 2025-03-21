package p031c.p035b.p043c.p053d0.p054a0.p055g;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandedRow.java */
/* renamed from: c.b.c.d0.a0.g.c */
/* loaded from: classes.dex */
final class C0998c {

    /* renamed from: a */
    private final List<C0997b> f1814a;

    /* renamed from: b */
    private final int f1815b;

    /* renamed from: c */
    private final boolean f1816c;

    C0998c(List<C0997b> list, int i2, boolean z) {
        this.f1814a = new ArrayList(list);
        this.f1815b = i2;
        this.f1816c = z;
    }

    /* renamed from: a */
    List<C0997b> m1404a() {
        return this.f1814a;
    }

    /* renamed from: b */
    int m1406b() {
        return this.f1815b;
    }

    /* renamed from: c */
    boolean m1407c() {
        return this.f1816c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0998c)) {
            return false;
        }
        C0998c c0998c = (C0998c) obj;
        return this.f1814a.equals(c0998c.m1404a()) && this.f1816c == c0998c.f1816c;
    }

    public int hashCode() {
        return this.f1814a.hashCode() ^ Boolean.valueOf(this.f1816c).hashCode();
    }

    public String toString() {
        return "{ " + this.f1814a + " }";
    }

    /* renamed from: a */
    boolean m1405a(List<C0997b> list) {
        return this.f1814a.equals(list);
    }
}
