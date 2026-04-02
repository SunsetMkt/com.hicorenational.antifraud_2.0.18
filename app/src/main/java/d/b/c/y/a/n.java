package d.b.c.y.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: GeoResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class n extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f9978f = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // d.b.c.y.a.u
    public m a(d.b.c.r rVar) {
        Matcher matcher = f9978f.matcher(u.b(rVar));
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(4);
        try {
            double d2 = Double.parseDouble(matcher.group(1));
            if (d2 <= 90.0d && d2 >= -90.0d) {
                double d3 = Double.parseDouble(matcher.group(2));
                if (d3 <= 180.0d && d3 >= -180.0d) {
                    double d4 = 0.0d;
                    if (matcher.group(3) != null) {
                        double d5 = Double.parseDouble(matcher.group(3));
                        if (d5 < 0.0d) {
                            return null;
                        }
                        d4 = d5;
                    }
                    return new m(d2, d3, d4, strGroup);
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
