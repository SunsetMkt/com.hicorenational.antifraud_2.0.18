package i.q2.t;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends y0<char[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char[] f12245d;

    public r(int i2) {
        super(i2);
        this.f12245d = new char[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.q2.t.y0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@j.c.a.d char[] cArr) {
        i0.f(cArr, "$this$getSize");
        return cArr.length;
    }

    @j.c.a.d
    public final char[] c() {
        return a(this.f12245d, new char[b()]);
    }

    public final void a(char c2) {
        char[] cArr = this.f12245d;
        int iA = a();
        a(iA + 1);
        cArr[iA] = c2;
    }
}
