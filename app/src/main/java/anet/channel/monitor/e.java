package anet.channel.monitor;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f1486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f1487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f1488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f1489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f1490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f1491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f1492h;
    private long a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f1493i = 0.0d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private double f1494j = 0.0d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f1495k = 0.0d;

    e() {
    }

    public double a(double d2, double d3) {
        double d4 = d2 / d3;
        if (d4 < 8.0d) {
            if (this.a != 0) {
                return this.f1495k;
            }
            this.f1495k = d4;
            return this.f1495k;
        }
        long j2 = this.a;
        if (j2 == 0) {
            this.f1493i = d4;
            this.f1492h = this.f1493i;
            double d5 = this.f1492h;
            this.f1488d = d5 * 0.1d;
            this.f1487c = 0.02d * d5;
            this.f1489e = 0.1d * d5 * d5;
        } else if (j2 == 1) {
            this.f1494j = d4;
            this.f1492h = this.f1494j;
        } else {
            double d6 = this.f1494j;
            double d7 = d4 - d6;
            this.f1493i = d6;
            this.f1494j = d4;
            this.f1486b = d4 / 0.95d;
            this.f1491g = this.f1486b - (this.f1492h * 0.95d);
            char c2 = 0;
            double dSqrt = Math.sqrt(this.f1488d);
            double d8 = this.f1491g;
            if (d8 >= 4.0d * dSqrt) {
                this.f1491g = (d8 * 0.75d) + (dSqrt * 2.0d);
                c2 = 1;
            } else if (d8 <= (-4.0d) * dSqrt) {
                this.f1491g = (dSqrt * (-1.0d)) + (d8 * 0.75d);
                c2 = 2;
            }
            double d9 = this.f1488d * 1.05d;
            double d10 = this.f1491g;
            this.f1488d = Math.min(Math.max(Math.abs(d9 - ((0.0025d * d10) * d10)), this.f1488d * 0.8d), this.f1488d * 1.25d);
            double d11 = this.f1489e;
            this.f1490f = d11 / ((0.9025d * d11) + this.f1488d);
            this.f1492h = this.f1492h + (1.0526315789473684d * d7) + (this.f1490f * this.f1491g);
            if (c2 == 1) {
                this.f1492h = Math.min(this.f1492h, this.f1486b);
            } else if (c2 == 2) {
                this.f1492h = Math.max(this.f1492h, this.f1486b);
            }
            this.f1489e = (1.0d - (0.95d * this.f1490f)) * (this.f1489e + this.f1487c);
        }
        double d12 = this.f1492h;
        if (d12 < 0.0d) {
            this.f1495k = this.f1494j * 0.7d;
            this.f1492h = this.f1495k;
        } else {
            this.f1495k = d12;
        }
        return this.f1495k;
    }

    public void a() {
        this.a = 0L;
        this.f1495k = 0.0d;
    }
}
