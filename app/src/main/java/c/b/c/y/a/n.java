package c.b.c.y.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: GeoResultParser.java */
/* loaded from: classes.dex */
public final class n extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2982f = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // c.b.c.y.a.u
    public m a(c.b.c.r rVar) {
        Matcher matcher = f2982f.matcher(u.b(rVar));
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
                    return new m(parseDouble, parseDouble2, d2, group);
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
