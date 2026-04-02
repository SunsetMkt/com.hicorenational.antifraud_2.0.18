package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends y0<boolean[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean[] f12221d;

    public m(int i2) {
        super(i2);
        this.f12221d = new boolean[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.q2.t.y0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@j.c.a.d boolean[] zArr) {
        i0.f(zArr, "$this$getSize");
        return zArr.length;
    }

    @j.c.a.d
    public final boolean[] c() {
        return a(this.f12221d, new boolean[b()]);
    }

    public final void a(boolean z) {
        boolean[] zArr = this.f12221d;
        int iA = a();
        a(iA + 1);
        zArr[iA] = z;
    }
}
