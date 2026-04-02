package d.b.c;

import java.util.Map;

/* JADX INFO: compiled from: MultiFormatWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements v {

    /* JADX INFO: compiled from: MultiFormatWriter.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[d.b.c.a.values().length];

        static {
            try {
                a[d.b.c.a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.b.c.a.EAN_13.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.b.c.a.UPC_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.b.c.a.QR_CODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.c.a.CODE_39.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.b.c.a.CODE_128.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.b.c.a.ITF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.b.c.a.PDF_417.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.b.c.a.CODABAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.b.c.a.DATA_MATRIX.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.b.c.a.AZTEC.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3) throws w {
        return a(str, aVar, i2, i3, null);
    }

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3, Map<g, ?> map) throws w {
        v kVar;
        switch (a.a[aVar.ordinal()]) {
            case 1:
                kVar = new d.b.c.d0.k();
                break;
            case 2:
                kVar = new d.b.c.d0.i();
                break;
            case 3:
                kVar = new d.b.c.d0.t();
                break;
            case 4:
                kVar = new d.b.c.f0.b();
                break;
            case 5:
                kVar = new d.b.c.d0.f();
                break;
            case 6:
                kVar = new d.b.c.d0.d();
                break;
            case 7:
                kVar = new d.b.c.d0.n();
                break;
            case 8:
                kVar = new d.b.c.e0.d();
                break;
            case 9:
                kVar = new d.b.c.d0.b();
                break;
            case 10:
                kVar = new d.b.c.a0.b();
                break;
            case 11:
                kVar = new d.b.c.x.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + aVar);
        }
        return kVar.a(str, aVar, i2, i3, map);
    }
}
