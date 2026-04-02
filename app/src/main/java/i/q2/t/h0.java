package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends y0<int[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f12211d;

    public h0(int i2) {
        super(i2);
        this.f12211d = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.q2.t.y0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@j.c.a.d int[] iArr) {
        i0.f(iArr, "$this$getSize");
        return iArr.length;
    }

    @j.c.a.d
    public final int[] c() {
        return a(this.f12211d, new int[b()]);
    }

    public final void b(int i2) {
        int[] iArr = this.f12211d;
        int iA = a();
        a(iA + 1);
        iArr[iA] = i2;
    }
}
