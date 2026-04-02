package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends y0<long[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long[] f12230d;

    public n0(int i2) {
        super(i2);
        this.f12230d = new long[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.q2.t.y0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@j.c.a.d long[] jArr) {
        i0.f(jArr, "$this$getSize");
        return jArr.length;
    }

    @j.c.a.d
    public final long[] c() {
        return a(this.f12230d, new long[b()]);
    }

    public final void a(long j2) {
        long[] jArr = this.f12230d;
        int iA = a();
        a(iA + 1);
        jArr[iA] = j2;
    }
}
