package p251g.p252a.p268y0.p270b;

import p251g.p252a.p267x0.InterfaceC4573d;

/* compiled from: ObjectHelper.java */
/* renamed from: g.a.y0.b.b */
/* loaded from: classes2.dex */
public final class C4601b {

    /* renamed from: a */
    static final InterfaceC4573d<Object, Object> f17555a = new a();

    /* compiled from: ObjectHelper.java */
    /* renamed from: g.a.y0.b.b$a */
    static final class a implements InterfaceC4573d<Object, Object> {
        a() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4573d
        /* renamed from: a */
        public boolean mo18210a(Object obj, Object obj2) {
            return C4601b.m18285a(obj, obj2);
        }
    }

    private C4601b() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static int m18278a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m18280a(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 > j3 ? 1 : 0;
    }

    /* renamed from: a */
    public static <T> T m18284a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static boolean m18285a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m18281a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: a */
    public static <T> InterfaceC4573d<T, T> m18283a() {
        return (InterfaceC4573d<T, T>) f17555a;
    }

    /* renamed from: a */
    public static int m18279a(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }

    /* renamed from: a */
    public static long m18282a(long j2, String str) {
        if (j2 > 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j2);
    }
}
