package p031c.p035b.p043c.p053d0.p054a0;

/* compiled from: DataCharacter.java */
/* renamed from: c.b.c.d0.a0.b */
/* loaded from: classes.dex */
public class C0991b {

    /* renamed from: a */
    private final int f1794a;

    /* renamed from: b */
    private final int f1795b;

    public C0991b(int i2, int i3) {
        this.f1794a = i2;
        this.f1795b = i3;
    }

    /* renamed from: a */
    public final int m1378a() {
        return this.f1795b;
    }

    /* renamed from: b */
    public final int m1379b() {
        return this.f1794a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0991b)) {
            return false;
        }
        C0991b c0991b = (C0991b) obj;
        return this.f1794a == c0991b.f1794a && this.f1795b == c0991b.f1795b;
    }

    public final int hashCode() {
        return this.f1794a ^ this.f1795b;
    }

    public final String toString() {
        return this.f1794a + "(" + this.f1795b + ')';
    }
}
