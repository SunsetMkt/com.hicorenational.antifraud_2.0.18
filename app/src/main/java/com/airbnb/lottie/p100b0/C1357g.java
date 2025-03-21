package com.airbnb.lottie.p100b0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.p102w.p103b.InterfaceC1403k;
import com.airbnb.lottie.p106y.C1435a;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p108k.C1470l;
import java.util.List;

/* compiled from: MiscUtils.java */
/* renamed from: com.airbnb.lottie.b0.g */
/* loaded from: classes.dex */
public class C1357g {

    /* renamed from: a */
    private static PointF f3145a = new PointF();

    /* renamed from: a */
    public static int m2823a(int i2, int i3, @FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        return (int) (i2 + (f2 * (i3 - i2)));
    }

    /* renamed from: a */
    public static PointF m2825a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* renamed from: b */
    public static double m2828b(double d2, double d3, @FloatRange(from = 0.0d, m293to = 1.0d) double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    /* renamed from: b */
    private static int m2829b(int i2, int i3) {
        return i2 - (i3 * m2822a(i2, i3));
    }

    /* renamed from: b */
    public static boolean m2830b(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    /* renamed from: c */
    public static float m2831c(float f2, float f3, @FloatRange(from = 0.0d, m293to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    /* renamed from: a */
    public static void m2827a(C1470l c1470l, Path path) {
        path.reset();
        PointF m3296b = c1470l.m3296b();
        path.moveTo(m3296b.x, m3296b.y);
        f3145a.set(m3296b.x, m3296b.y);
        for (int i2 = 0; i2 < c1470l.m3294a().size(); i2++) {
            C1435a c1435a = c1470l.m3294a().get(i2);
            PointF m3185a = c1435a.m3185a();
            PointF m3187b = c1435a.m3187b();
            PointF m3189c = c1435a.m3189c();
            if (m3185a.equals(f3145a) && m3187b.equals(m3189c)) {
                path.lineTo(m3189c.x, m3189c.y);
            } else {
                path.cubicTo(m3185a.x, m3185a.y, m3187b.x, m3187b.y, m3189c.x, m3189c.y);
            }
            f3145a.set(m3189c.x, m3189c.y);
        }
        if (c1470l.m3297c()) {
            path.close();
        }
    }

    /* renamed from: a */
    static int m2821a(float f2, float f3) {
        return m2829b((int) f2, (int) f3);
    }

    /* renamed from: a */
    private static int m2822a(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    /* renamed from: a */
    public static int m2824a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    /* renamed from: a */
    public static float m2820a(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    /* renamed from: a */
    public static double m2819a(double d2, double d3, double d4) {
        return Math.max(d3, Math.min(d4, d2));
    }

    /* renamed from: a */
    public static void m2826a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2, InterfaceC1403k interfaceC1403k) {
        if (c1439e.m3207a(interfaceC1403k.getName(), i2)) {
            list.add(c1439e2.m3205a(interfaceC1403k.getName()).m3204a(interfaceC1403k));
        }
    }
}
