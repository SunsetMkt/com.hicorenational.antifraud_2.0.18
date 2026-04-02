package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k1 extends y0<short[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short[] f12220d;

    public k1(int i2) {
        super(i2);
        this.f12220d = new short[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.q2.t.y0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@j.c.a.d short[] sArr) {
        i0.f(sArr, "$this$getSize");
        return sArr.length;
    }

    @j.c.a.d
    public final short[] c() {
        return a(this.f12220d, new short[b()]);
    }

    public final void a(short s) {
        short[] sArr = this.f12220d;
        int iA = a();
        a(iA + 1);
        sArr[iA] = s;
    }
}
