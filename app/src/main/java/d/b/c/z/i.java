package d.b.c.z;

import d.b.c.m;

/* JADX INFO: compiled from: GridSampler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    private static i a = new f();

    public static void a(i iVar) {
        a = iVar;
    }

    public abstract b a(b bVar, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws m;

    public abstract b a(b bVar, int i2, int i3, k kVar) throws m;

    public static i a() {
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void a(b bVar, float[] fArr) throws m {
        int iG = bVar.g();
        int iD = bVar.d();
        boolean z = true;
        for (int i2 = 0; i2 < fArr.length && z; i2 += 2) {
            int i3 = (int) fArr[i2];
            int i4 = i2 + 1;
            int i5 = (int) fArr[i4];
            if (i3 < -1 || i3 > iG || i5 < -1 || i5 > iD) {
                throw m.getNotFoundInstance();
            }
            if (i3 == -1) {
                fArr[i2] = 0.0f;
            } else if (i3 == iG) {
                fArr[i2] = iG - 1;
            } else {
                z = false;
                if (i5 != -1) {
                    fArr[i4] = 0.0f;
                } else if (i5 == iD) {
                    fArr[i4] = iD - 1;
                }
                z = true;
            }
            z = true;
            if (i5 != -1) {
            }
            z = true;
        }
        boolean z2 = true;
        for (int length = fArr.length - 2; length >= 0 && z2; length -= 2) {
            int i6 = (int) fArr[length];
            int i7 = length + 1;
            int i8 = (int) fArr[i7];
            if (i6 < -1 || i6 > iG || i8 < -1 || i8 > iD) {
                throw m.getNotFoundInstance();
            }
            if (i6 == -1) {
                fArr[length] = 0.0f;
            } else if (i6 == iG) {
                fArr[length] = iG - 1;
            } else {
                z2 = false;
                if (i8 != -1) {
                    fArr[i7] = 0.0f;
                } else if (i8 == iD) {
                    fArr[i7] = iD - 1;
                }
                z2 = true;
            }
            z2 = true;
            if (i8 != -1) {
            }
            z2 = true;
        }
    }
}
