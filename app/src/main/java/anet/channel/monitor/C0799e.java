package anet.channel.monitor;

/* compiled from: Taobao */
/* renamed from: anet.channel.monitor.e */
/* loaded from: classes.dex */
class C0799e {

    /* renamed from: b */
    private double f902b;

    /* renamed from: c */
    private double f903c;

    /* renamed from: d */
    private double f904d;

    /* renamed from: e */
    private double f905e;

    /* renamed from: f */
    private double f906f;

    /* renamed from: g */
    private double f907g;

    /* renamed from: h */
    private double f908h;

    /* renamed from: a */
    private long f901a = 0;

    /* renamed from: i */
    private double f909i = 0.0d;

    /* renamed from: j */
    private double f910j = 0.0d;

    /* renamed from: k */
    private double f911k = 0.0d;

    C0799e() {
    }

    /* renamed from: a */
    public double m536a(double d2, double d3) {
        double d4 = d2 / d3;
        if (d4 < 8.0d) {
            if (this.f901a != 0) {
                return this.f911k;
            }
            this.f911k = d4;
            return this.f911k;
        }
        long j2 = this.f901a;
        if (j2 == 0) {
            this.f909i = d4;
            this.f908h = this.f909i;
            double d5 = this.f908h;
            this.f904d = d5 * 0.1d;
            this.f903c = 0.02d * d5;
            this.f905e = 0.1d * d5 * d5;
        } else if (j2 == 1) {
            this.f910j = d4;
            this.f908h = this.f910j;
        } else {
            double d6 = this.f910j;
            double d7 = d4 - d6;
            this.f909i = d6;
            this.f910j = d4;
            this.f902b = d4 / 0.95d;
            this.f907g = this.f902b - (this.f908h * 0.95d);
            char c2 = 0;
            double sqrt = Math.sqrt(this.f904d);
            double d8 = this.f907g;
            if (d8 >= 4.0d * sqrt) {
                this.f907g = (d8 * 0.75d) + (sqrt * 2.0d);
                c2 = 1;
            } else if (d8 <= (-4.0d) * sqrt) {
                this.f907g = (sqrt * (-1.0d)) + (d8 * 0.75d);
                c2 = 2;
            }
            double d9 = this.f904d * 1.05d;
            double d10 = this.f907g;
            this.f904d = Math.min(Math.max(Math.abs(d9 - ((0.0025d * d10) * d10)), this.f904d * 0.8d), this.f904d * 1.25d);
            double d11 = this.f905e;
            this.f906f = d11 / ((0.9025d * d11) + this.f904d);
            this.f908h = this.f908h + (1.0526315789473684d * d7) + (this.f906f * this.f907g);
            if (c2 == 1) {
                this.f908h = Math.min(this.f908h, this.f902b);
            } else if (c2 == 2) {
                this.f908h = Math.max(this.f908h, this.f902b);
            }
            this.f905e = (1.0d - (0.95d * this.f906f)) * (this.f905e + this.f903c);
        }
        double d12 = this.f908h;
        if (d12 < 0.0d) {
            this.f911k = this.f910j * 0.7d;
            this.f908h = this.f911k;
        } else {
            this.f911k = d12;
        }
        return this.f911k;
    }

    /* renamed from: a */
    public void m537a() {
        this.f901a = 0L;
        this.f911k = 0.0d;
    }
}
