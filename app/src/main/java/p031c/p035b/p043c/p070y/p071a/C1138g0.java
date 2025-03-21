package p031c.p035b.p043c.p070y.p071a;

import java.util.List;
import p031c.p035b.p043c.C1107r;

/* compiled from: VEventResultParser.java */
/* renamed from: c.b.c.y.a.g0 */
/* loaded from: classes.dex */
public final class C1138g0 extends AbstractC1156u {
    /* renamed from: b */
    private static String[] m2061b(CharSequence charSequence, String str, boolean z) {
        List<List<String>> m2042b = C1136f0.m2042b(charSequence, str, z, false);
        if (m2042b == null || m2042b.isEmpty()) {
            return null;
        }
        int size = m2042b.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = m2042b.get(i2).get(0);
        }
        return strArr;
    }

    /* renamed from: e */
    private static String m2062e(String str) {
        return str != null ? (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1137g mo2004a(C1107r c1107r) {
        double parseDouble;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (m2128b.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String m2060a = m2060a((CharSequence) "SUMMARY", m2128b, true);
        String m2060a2 = m2060a((CharSequence) "DTSTART", m2128b, true);
        if (m2060a2 == null) {
            return null;
        }
        String m2060a3 = m2060a((CharSequence) "DTEND", m2128b, true);
        String m2060a4 = m2060a((CharSequence) "DURATION", m2128b, true);
        String m2060a5 = m2060a((CharSequence) "LOCATION", m2128b, true);
        String m2062e = m2062e(m2060a((CharSequence) "ORGANIZER", m2128b, true));
        String[] m2061b = m2061b("ATTENDEE", m2128b, true);
        if (m2061b != null) {
            for (int i2 = 0; i2 < m2061b.length; i2++) {
                m2061b[i2] = m2062e(m2061b[i2]);
            }
        }
        String m2060a6 = m2060a((CharSequence) "DESCRIPTION", m2128b, true);
        String m2060a7 = m2060a((CharSequence) "GEO", m2128b, true);
        double d2 = Double.NaN;
        if (m2060a7 == null) {
            parseDouble = Double.NaN;
        } else {
            int indexOf = m2060a7.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            try {
                d2 = Double.parseDouble(m2060a7.substring(0, indexOf));
                parseDouble = Double.parseDouble(m2060a7.substring(indexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new C1137g(m2060a, m2060a2, m2060a3, m2060a4, m2060a5, m2062e, m2061b, m2060a6, d2, parseDouble);
    }

    /* renamed from: a */
    private static String m2060a(CharSequence charSequence, String str, boolean z) {
        List<String> m2036a = C1136f0.m2036a(charSequence, str, z, false);
        if (m2036a == null || m2036a.isEmpty()) {
            return null;
        }
        return m2036a.get(0);
    }
}
