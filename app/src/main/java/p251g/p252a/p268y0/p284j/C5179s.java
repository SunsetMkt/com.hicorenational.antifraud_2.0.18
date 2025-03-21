package p251g.p252a.p268y0.p284j;

/* compiled from: OpenHashSet.java */
/* renamed from: g.a.y0.j.s */
/* loaded from: classes2.dex */
public final class C5179s<T> {

    /* renamed from: f */
    private static final int f20044f = -1640531527;

    /* renamed from: a */
    final float f20045a;

    /* renamed from: b */
    int f20046b;

    /* renamed from: c */
    int f20047c;

    /* renamed from: d */
    int f20048d;

    /* renamed from: e */
    T[] f20049e;

    public C5179s() {
        this(16, 0.75f);
    }

    /* renamed from: a */
    static int m18637a(int i2) {
        int i3 = i2 * f20044f;
        return i3 ^ (i3 >>> 16);
    }

    /* renamed from: a */
    public boolean m18639a(T t) {
        T t2;
        T[] tArr = this.f20049e;
        int i2 = this.f20046b;
        int m18637a = m18637a(t.hashCode()) & i2;
        T t3 = tArr[m18637a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                m18637a = (m18637a + 1) & i2;
                t2 = tArr[m18637a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[m18637a] = t;
        int i3 = this.f20047c + 1;
        this.f20047c = i3;
        if (i3 >= this.f20048d) {
            m18641b();
        }
        return true;
    }

    /* renamed from: b */
    public boolean m18642b(T t) {
        T t2;
        T[] tArr = this.f20049e;
        int i2 = this.f20046b;
        int m18637a = m18637a(t.hashCode()) & i2;
        T t3 = tArr[m18637a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return m18638a(m18637a, tArr, i2);
        }
        do {
            m18637a = (m18637a + 1) & i2;
            t2 = tArr[m18637a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return m18638a(m18637a, tArr, i2);
    }

    /* renamed from: c */
    public int m18643c() {
        return this.f20047c;
    }

    public C5179s(int i2) {
        this(i2, 0.75f);
    }

    public C5179s(int i2, float f2) {
        this.f20045a = f2;
        int m18645b = C5180t.m18645b(i2);
        this.f20046b = m18645b - 1;
        this.f20048d = (int) (f2 * m18645b);
        this.f20049e = (T[]) new Object[m18645b];
    }

    /* renamed from: b */
    void m18641b() {
        T[] tArr = this.f20049e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (T[]) new Object[i2];
        int i4 = this.f20047c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int m18637a = m18637a(tArr[length].hashCode()) & i3;
                if (tArr2[m18637a] != null) {
                    do {
                        m18637a = (m18637a + 1) & i3;
                    } while (tArr2[m18637a] != null);
                }
                tArr2[m18637a] = tArr[length];
                i4 = i5;
            } else {
                this.f20046b = i3;
                this.f20048d = (int) (i2 * this.f20045a);
                this.f20049e = tArr2;
                return;
            }
        }
    }

    /* renamed from: a */
    boolean m18638a(int i2, T[] tArr, int i3) {
        int i4;
        T t;
        this.f20047c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int m18637a = m18637a(t.hashCode()) & i3;
                if (i2 > i4) {
                    if (i2 >= m18637a && m18637a > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else if (i2 < m18637a && m18637a <= i4) {
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    /* renamed from: a */
    public Object[] m18640a() {
        return this.f20049e;
    }
}
