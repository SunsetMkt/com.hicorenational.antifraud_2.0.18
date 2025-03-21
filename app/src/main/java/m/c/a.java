package m.c;

import android.graphics.Bitmap;
import c.b.c.l;
import c.b.c.w;
import c.b.c.z.b;

/* compiled from: CodeCreator.java */
/* loaded from: classes2.dex */
public class a {
    public static Bitmap a(String str) throws w {
        if (str == null || str.equals("")) {
            return null;
        }
        b a2 = new l().a(str, c.b.c.a.QR_CODE, 300, 300);
        int g2 = a2.g();
        int d2 = a2.d();
        int[] iArr = new int[g2 * d2];
        for (int i2 = 0; i2 < d2; i2++) {
            for (int i3 = 0; i3 < g2; i3++) {
                if (a2.b(i3, i2)) {
                    iArr[(i2 * g2) + i3] = -16777216;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(g2, d2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, g2, 0, 0, g2, d2);
        return createBitmap;
    }
}
