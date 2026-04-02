package d.b.c.e0.e;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: Codeword.java */
/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9700f = -1;
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9704e = -1;

    d(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.f9701b = i3;
        this.f9702c = i4;
        this.f9703d = i5;
    }

    boolean a(int i2) {
        return i2 != -1 && this.f9702c == (i2 % 3) * 3;
    }

    int b() {
        return this.f9701b;
    }

    int c() {
        return this.f9704e;
    }

    int d() {
        return this.a;
    }

    int e() {
        return this.f9703d;
    }

    int f() {
        return this.f9701b - this.a;
    }

    boolean g() {
        return a(this.f9704e);
    }

    void h() {
        this.f9704e = ((this.f9703d / 30) * 3) + (this.f9702c / 3);
    }

    public String toString() {
        return this.f9704e + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f9703d;
    }

    int a() {
        return this.f9702c;
    }

    void b(int i2) {
        this.f9704e = i2;
    }
}
