package p381m.p384c;

import android.graphics.Bitmap;
import p031c.p035b.p043c.C1101l;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: CodeCreator.java */
/* renamed from: m.c.a */
/* loaded from: classes2.dex */
public class C5935a {
    /* renamed from: a */
    public static Bitmap m24918a(String str) throws C1112w {
        if (str == null || str.equals("")) {
            return null;
        }
        C1163b mo1189a = new C1101l().mo1189a(str, EnumC0953a.QR_CODE, 300, 300);
        int m2181g = mo1189a.m2181g();
        int m2177d = mo1189a.m2177d();
        int[] iArr = new int[m2181g * m2177d];
        for (int i2 = 0; i2 < m2177d; i2++) {
            for (int i3 = 0; i3 < m2181g; i3++) {
                if (mo1189a.m2173b(i3, i2)) {
                    iArr[(i2 * m2181g) + i3] = -16777216;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(m2181g, m2177d, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, m2181g, 0, 0, m2181g, m2177d);
        return createBitmap;
    }
}
