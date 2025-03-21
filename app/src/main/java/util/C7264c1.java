package util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.IOException;
import p388ui.Hicore;

/* compiled from: DisplayUtil.java */
/* renamed from: util.c1 */
/* loaded from: classes2.dex */
public class C7264c1 {

    /* renamed from: a */
    private static int f25190a;

    /* renamed from: a */
    public static RectF m26288a(int i2, int i3, int i4, int i5) {
        Point m26293b = m26293b(i2, i3, i4, i5);
        return new RectF(m26293b.x, m26293b.y, i4 + r2, i5 + r1);
    }

    /* renamed from: b */
    public static Point m26293b(int i2, int i3, int i4, int i5) {
        return new Point((i2 / 2) - (i4 / 2), (i3 - i5) / 4);
    }

    /* renamed from: c */
    public static float m26294c(Context context) {
        return m26289a(context).widthPixels;
    }

    /* renamed from: d */
    public static int m26296d(Context context) {
        int i2 = f25190a;
        if (i2 > 0) {
            return i2;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            f25190a = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            return f25190a;
        } catch (Throwable th) {
            th.printStackTrace();
            return f25190a;
        }
    }

    /* renamed from: c */
    public static int m26295c(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: b */
    public static Point m26292b(float f2, float f3, int i2, int i3) {
        if (f2 > f3) {
            i2 = (int) (i3 / f2);
        } else {
            i3 = (int) (i2 * f2);
        }
        return new Point(i2, i3);
    }

    /* renamed from: a */
    public static Point m26287a(float f2, float f3, int i2, int i3) {
        int i4;
        int i5;
        if (f2 > f3) {
            i4 = (int) (i3 / 1.5f);
            i5 = (int) (i4 / f2);
        } else {
            int i6 = (int) (i2 / 1.5f);
            i4 = (int) (i6 * f2);
            i5 = i6;
        }
        return new Point(i5, i4);
    }

    /* renamed from: b */
    public static float m26290b(Context context) {
        return m26289a(context).heightPixels;
    }

    /* renamed from: a */
    public static DisplayMetrics m26289a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: b */
    public static float m26291b(Context context, float f2) {
        return (f2 / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    /* renamed from: a */
    public static int m26285a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static int m26284a(int i2) {
        return Hicore.getApp().getResources().getDimensionPixelSize(i2);
    }

    /* renamed from: a */
    public static int m26286a(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
