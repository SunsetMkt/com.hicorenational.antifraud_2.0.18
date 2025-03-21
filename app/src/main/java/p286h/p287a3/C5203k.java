package p286h.p287a3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: formatToDecimals.kt */
/* renamed from: h.a3.k */
/* loaded from: classes2.dex */
public final class C5203k {

    /* renamed from: a */
    private static final DecimalFormatSymbols f20069a;

    /* renamed from: b */
    private static final DecimalFormatSymbols f20070b;

    /* renamed from: c */
    private static final ThreadLocal<DecimalFormat>[] f20071c;

    /* renamed from: d */
    private static final ThreadLocal<DecimalFormat> f20072d;

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ROOT);
        decimalFormatSymbols.setExponentSeparator("e");
        f20069a = decimalFormatSymbols;
        DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols(Locale.ROOT);
        decimalFormatSymbols2.setExponentSeparator("e+");
        f20070b = decimalFormatSymbols2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal<>();
        }
        f20071c = threadLocalArr;
        f20072d = new ThreadLocal<>();
    }

    /* renamed from: a */
    private static final DecimalFormat m18784a(int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("0", f20069a);
        if (i2 > 0) {
            decimalFormat.setMinimumFractionDigits(i2);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m18785b(double d2, int i2) {
        DecimalFormat m18784a = m18784a(0);
        m18784a.setMaximumFractionDigits(i2);
        String format = m18784a.format(d2);
        C5544i0.m22521a((Object) format, "createFormatForDecimals(… }\n        .format(value)");
        return format;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m18783a(double d2, int i2) {
        DecimalFormat m18784a;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f20071c;
        if (i2 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i2];
            DecimalFormat decimalFormat = threadLocal.get();
            if (decimalFormat == null) {
                decimalFormat = m18784a(i2);
                threadLocal.set(decimalFormat);
            }
            m18784a = decimalFormat;
        } else {
            m18784a = m18784a(i2);
        }
        String format = m18784a.format(d2);
        C5544i0.m22521a((Object) format, "format.format(value)");
        return format;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m18782a(double d2) {
        ThreadLocal<DecimalFormat> threadLocal = f20072d;
        DecimalFormat decimalFormat = threadLocal.get();
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("0E0", f20069a);
            decimalFormat.setMinimumFractionDigits(2);
            threadLocal.set(decimalFormat);
        }
        DecimalFormat decimalFormat2 = decimalFormat;
        decimalFormat2.setDecimalFormatSymbols((d2 >= ((double) 1) || d2 <= ((double) (-1))) ? f20070b : f20069a);
        String format = decimalFormat2.format(d2);
        C5544i0.m22521a((Object) format, "scientificFormat.getOrSe… }\n        .format(value)");
        return format;
    }
}
