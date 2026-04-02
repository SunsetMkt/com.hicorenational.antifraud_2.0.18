package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class y0<T> {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T[] f12260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12261c;

    public y0(int i2) {
        this.f12261c = i2;
        this.f12260b = (T[]) new Object[this.f12261c];
    }

    private static /* synthetic */ void c() {
    }

    protected final int a() {
        return this.a;
    }

    protected final int b() {
        int i2 = this.f12261c - 1;
        int iB = 0;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                T t = this.f12260b[i3];
                iB += t != null ? b(t) : 1;
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        return iB;
    }

    protected abstract int b(@j.c.a.d T t);

    protected final void a(int i2) {
        this.a = i2;
    }

    public final void a(@j.c.a.d T t) {
        i0.f(t, "spreadArgument");
        T[] tArr = this.f12260b;
        int i2 = this.a;
        this.a = i2 + 1;
        tArr[i2] = t;
    }

    @j.c.a.d
    protected final T a(@j.c.a.d T t, @j.c.a.d T t2) {
        int i2;
        i0.f(t, "values");
        i0.f(t2, "result");
        int i3 = this.f12261c - 1;
        int i4 = 0;
        if (i3 >= 0) {
            int i5 = 0;
            int i6 = 0;
            i2 = 0;
            while (true) {
                T t3 = this.f12260b[i5];
                if (t3 != null) {
                    if (i6 < i5) {
                        int i7 = i5 - i6;
                        System.arraycopy(t, i6, t2, i2, i7);
                        i2 += i7;
                    }
                    int iB = b(t3);
                    System.arraycopy(t3, 0, t2, i2, iB);
                    i2 += iB;
                    i6 = i5 + 1;
                }
                if (i5 == i3) {
                    break;
                }
                i5++;
            }
            i4 = i6;
        } else {
            i2 = 0;
        }
        int i8 = this.f12261c;
        if (i4 < i8) {
            System.arraycopy(t, i4, t2, i2, i8 - i4);
        }
        return t2;
    }
}
