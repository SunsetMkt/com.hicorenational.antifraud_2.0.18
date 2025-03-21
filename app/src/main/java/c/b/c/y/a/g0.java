package c.b.c.y.a;

import java.util.List;

/* compiled from: VEventResultParser.java */
/* loaded from: classes.dex */
public final class g0 extends u {
    private static String[] b(CharSequence charSequence, String str, boolean z) {
        List<List<String>> b2 = f0.b(charSequence, str, z, false);
        if (b2 == null || b2.isEmpty()) {
            return null;
        }
        int size = b2.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = b2.get(i2).get(0);
        }
        return strArr;
    }

    private static String e(String str) {
        return str != null ? (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    @Override // c.b.c.y.a.u
    public g a(c.b.c.r rVar) {
        double parseDouble;
        String b2 = u.b(rVar);
        if (b2.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String a2 = a((CharSequence) "SUMMARY", b2, true);
        String a3 = a((CharSequence) "DTSTART", b2, true);
        if (a3 == null) {
            return null;
        }
        String a4 = a((CharSequence) "DTEND", b2, true);
        String a5 = a((CharSequence) "DURATION", b2, true);
        String a6 = a((CharSequence) "LOCATION", b2, true);
        String e2 = e(a((CharSequence) "ORGANIZER", b2, true));
        String[] b3 = b("ATTENDEE", b2, true);
        if (b3 != null) {
            for (int i2 = 0; i2 < b3.length; i2++) {
                b3[i2] = e(b3[i2]);
            }
        }
        String a7 = a((CharSequence) "DESCRIPTION", b2, true);
        String a8 = a((CharSequence) "GEO", b2, true);
        double d2 = Double.NaN;
        if (a8 == null) {
            parseDouble = Double.NaN;
        } else {
            int indexOf = a8.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            try {
                d2 = Double.parseDouble(a8.substring(0, indexOf));
                parseDouble = Double.parseDouble(a8.substring(indexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new g(a2, a3, a4, a5, a6, e2, b3, a7, d2, parseDouble);
    }

    private static String a(CharSequence charSequence, String str, boolean z) {
        List<String> a2 = f0.a(charSequence, str, z, false);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return a2.get(0);
    }
}
