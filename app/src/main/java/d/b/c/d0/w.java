package d.b.c.d0;

/* JADX INFO: compiled from: UPCEANExtensionSupport.java */
/* JADX INFO: loaded from: classes.dex */
final class w {

    /* JADX INFO: renamed from: c */
    private static final int[] f9662c = {1, 1, 2};
    private final u a = new u();

    /* JADX INFO: renamed from: b */
    private final v f9663b = new v();

    w() {
    }

    d.b.c.r a(int i2, d.b.c.z.a aVar, int i3) throws d.b.c.m {
        int[] iArrA = x.a(aVar, i3, false, f9662c);
        try {
            return this.f9663b.a(i2, aVar, iArrA);
        } catch (d.b.c.q unused) {
            return this.a.a(i2, aVar, iArrA);
        }
    }
}
