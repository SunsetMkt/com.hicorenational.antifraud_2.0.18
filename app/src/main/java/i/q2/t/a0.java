package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends y0<float[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f12200d;

    public a0(int i2) {
        super(i2);
        this.f12200d = new float[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.q2.t.y0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@j.c.a.d float[] fArr) {
        i0.f(fArr, "$this$getSize");
        return fArr.length;
    }

    @j.c.a.d
    public final float[] c() {
        return a(this.f12200d, new float[b()]);
    }

    public final void a(float f2) {
        float[] fArr = this.f12200d;
        int iA = a();
        a(iA + 1);
        fArr[iA] = f2;
    }
}
