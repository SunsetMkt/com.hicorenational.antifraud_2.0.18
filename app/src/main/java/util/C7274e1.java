package util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.HashMap;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.p062f0.C1073b;
import p031c.p035b.p043c.p062f0.p063c.EnumC1079f;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: EncodingUtils.java */
/* renamed from: util.e1 */
/* loaded from: classes2.dex */
public class C7274e1 {
    /* renamed from: a */
    public static Bitmap m26333a(String str, int i2, int i3, Bitmap bitmap) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EnumC1096g.CHARACTER_SET, "utf-8");
                    hashMap.put(EnumC1096g.ERROR_CORRECTION, EnumC1079f.H);
                    C1163b mo1190a = new C1073b().mo1190a(str, EnumC0953a.QR_CODE, i2, i3, hashMap);
                    int[] iArr = new int[i2 * i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        for (int i5 = 0; i5 < i2; i5++) {
                            if (mo1190a.m2173b(i5, i4)) {
                                iArr[(i4 * i2) + i5] = -16777216;
                            } else {
                                iArr[(i4 * i2) + i5] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                    createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
                    return bitmap != null ? m26332a(createBitmap, bitmap) : createBitmap;
                }
            } catch (C1112w e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Bitmap m26332a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 == 0 || height2 == 0) {
            return bitmap;
        }
        float f2 = ((width * 1.0f) / 5.0f) / width2;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f2, f2, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save();
            canvas.restore();
            return createBitmap;
        } catch (Exception e2) {
            e2.getStackTrace();
            return null;
        }
    }
}
