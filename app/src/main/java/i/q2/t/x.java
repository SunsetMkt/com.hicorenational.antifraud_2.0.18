package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends y0<double[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double[] f12258d;

    public x(int i2) {
        super(i2);
        this.f12258d = new double[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.q2.t.y0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@j.c.a.d double[] dArr) {
        i0.f(dArr, "$this$getSize");
        return dArr.length;
    }

    @j.c.a.d
    public final double[] c() {
        return a(this.f12258d, new double[b()]);
    }

    public final void a(double d2) {
        double[] dArr = this.f12258d;
        int iA = a();
        a(iA + 1);
        dArr[iA] = d2;
    }
}
