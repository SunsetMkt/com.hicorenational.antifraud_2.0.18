package p251g.p252a.p268y0.p284j;

/* compiled from: Pow2.java */
/* renamed from: g.a.y0.j.t */
/* loaded from: classes2.dex */
public final class C5180t {
    private C5180t() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static boolean m18644a(int i2) {
        return (i2 & (i2 + (-1))) == 0;
    }

    /* renamed from: b */
    public static int m18645b(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }
}
