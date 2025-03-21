package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.y0 */
/* loaded from: classes2.dex */
public abstract class AbstractC5593y0<T> {

    /* renamed from: a */
    private int f20445a;

    /* renamed from: b */
    private final T[] f20446b;

    /* renamed from: c */
    private final int f20447c;

    public AbstractC5593y0(int i2) {
        this.f20447c = i2;
        this.f20446b = (T[]) new Object[this.f20447c];
    }

    /* renamed from: c */
    private static /* synthetic */ void m22697c() {
    }

    /* renamed from: a */
    protected final int m22698a() {
        return this.f20445a;
    }

    /* renamed from: b */
    protected final int m22702b() {
        int i2 = this.f20447c - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = 0;
            while (true) {
                T t = this.f20446b[i4];
                i3 += t != null ? mo22466b(t) : 1;
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
        }
        return i3;
    }

    /* renamed from: b */
    protected abstract int mo22466b(@InterfaceC5816d T t);

    /* renamed from: a */
    protected final void m22700a(int i2) {
        this.f20445a = i2;
    }

    /* renamed from: a */
    public final void m22701a(@InterfaceC5816d T t) {
        C5544i0.m22546f(t, "spreadArgument");
        T[] tArr = this.f20446b;
        int i2 = this.f20445a;
        this.f20445a = i2 + 1;
        tArr[i2] = t;
    }

    @InterfaceC5816d
    /* renamed from: a */
    protected final T m22699a(@InterfaceC5816d T t, @InterfaceC5816d T t2) {
        int i2;
        C5544i0.m22546f(t, "values");
        C5544i0.m22546f(t2, "result");
        int i3 = this.f20447c - 1;
        int i4 = 0;
        if (i3 >= 0) {
            int i5 = 0;
            int i6 = 0;
            i2 = 0;
            while (true) {
                T t3 = this.f20446b[i5];
                if (t3 != null) {
                    if (i6 < i5) {
                        int i7 = i5 - i6;
                        System.arraycopy(t, i6, t2, i2, i7);
                        i2 += i7;
                    }
                    int mo22466b = mo22466b(t3);
                    System.arraycopy(t3, 0, t2, i2, mo22466b);
                    i2 += mo22466b;
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
        int i8 = this.f20447c;
        if (i4 < i8) {
            System.arraycopy(t, i4, t2, i2, i8 - i4);
        }
        return t2;
    }
}
