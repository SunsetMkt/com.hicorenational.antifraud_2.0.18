package p031c.p035b.p043c.p070y.p071a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p031c.p035b.p043c.C1107r;

/* compiled from: GeoResultParser.java */
/* renamed from: c.b.c.y.a.n */
/* loaded from: classes.dex */
public final class C1149n extends AbstractC1156u {

    /* renamed from: f */
    private static final Pattern f2368f = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1148m mo2004a(C1107r c1107r) {
        Matcher matcher = f2368f.matcher(AbstractC1156u.m2128b(c1107r));
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(4);
        try {
            double parseDouble = Double.parseDouble(matcher.group(1));
            if (parseDouble <= 90.0d && parseDouble >= -90.0d) {
                double parseDouble2 = Double.parseDouble(matcher.group(2));
                if (parseDouble2 <= 180.0d && parseDouble2 >= -180.0d) {
                    double d2 = 0.0d;
                    if (matcher.group(3) != null) {
                        double parseDouble3 = Double.parseDouble(matcher.group(3));
                        if (parseDouble3 < 0.0d) {
                            return null;
                        }
                        d2 = parseDouble3;
                    }
                    return new C1148m(parseDouble, parseDouble2, d2, group);
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
