package i.a3;

import i.q2.t.i0;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: compiled from: formatToDecimals.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private static final DecimalFormatSymbols a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DecimalFormatSymbols f12056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f12057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat> f12058d;

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ROOT);
        decimalFormatSymbols.setExponentSeparator("e");
        a = decimalFormatSymbols;
        DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols(Locale.ROOT);
        decimalFormatSymbols2.setExponentSeparator("e+");
        f12056b = decimalFormatSymbols2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal<>();
        }
        f12057c = threadLocalArr;
        f12058d = new ThreadLocal<>();
    }

    private static final DecimalFormat a(int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("0", a);
        if (i2 > 0) {
            decimalFormat.setMinimumFractionDigits(i2);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @j.c.a.d
    public static final String b(double d2, int i2) {
        DecimalFormat decimalFormatA = a(0);
        decimalFormatA.setMaximumFractionDigits(i2);
        String str = decimalFormatA.format(d2);
        i0.a((Object) str, "createFormatForDecimals(\u2026 }\n        .format(value)");
        return str;
    }

    @j.c.a.d
    public static final String a(double d2, int i2) {
        DecimalFormat decimalFormatA;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f12057c;
        if (i2 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i2];
            DecimalFormat decimalFormatA2 = threadLocal.get();
            if (decimalFormatA2 == null) {
                decimalFormatA2 = a(i2);
                threadLocal.set(decimalFormatA2);
            }
            decimalFormatA = decimalFormatA2;
        } else {
            decimalFormatA = a(i2);
        }
        String str = decimalFormatA.format(d2);
        i0.a((Object) str, "format.format(value)");
        return str;
    }

    @j.c.a.d
    public static final String a(double d2) {
        ThreadLocal<DecimalFormat> threadLocal = f12058d;
        DecimalFormat decimalFormat = threadLocal.get();
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("0E0", a);
            decimalFormat.setMinimumFractionDigits(2);
            threadLocal.set(decimalFormat);
        }
        DecimalFormat decimalFormat2 = decimalFormat;
        decimalFormat2.setDecimalFormatSymbols((d2 >= ((double) 1) || d2 <= ((double) (-1))) ? f12056b : a);
        String str = decimalFormat2.format(d2);
        i0.a((Object) str, "scientificFormat.getOrSe\u2026 }\n        .format(value)");
        return str;
    }
}
