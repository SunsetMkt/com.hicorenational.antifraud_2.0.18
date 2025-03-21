package p031c.p035b.p043c.p070y.p071a;

import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p031c.p035b.p043c.C1107r;
import zxing.android.C7346e;

/* compiled from: VCardResultParser.java */
/* renamed from: c.b.c.y.a.f0 */
/* loaded from: classes.dex */
public final class C1136f0 extends AbstractC1156u {

    /* renamed from: f */
    private static final Pattern f2301f = Pattern.compile("BEGIN:VCARD", 2);

    /* renamed from: g */
    private static final Pattern f2302g = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* renamed from: h */
    private static final Pattern f2303h = Pattern.compile("\r\n[ \t]");

    /* renamed from: i */
    private static final Pattern f2304i = Pattern.compile("\\\\[nN]");

    /* renamed from: j */
    private static final Pattern f2305j = Pattern.compile("\\\\([,;\\\\])");

    /* renamed from: k */
    private static final Pattern f2306k = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);

    /* renamed from: l */
    private static final Pattern f2307l = Pattern.compile(";");

    /* renamed from: m */
    private static final Pattern f2308m = Pattern.compile("(?<!\\\\);+");

    /* renamed from: n */
    private static final Pattern f2309n = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: o */
    private static final Pattern f2310o = Pattern.compile("[;,]");

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cd, code lost:
    
        r2 = r1;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.List<java.util.List<java.lang.String>> m2042b(java.lang.CharSequence r16, java.lang.String r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p070y.p071a.C1136f0.m2042b(java.lang.CharSequence, java.lang.String, boolean, boolean):java.util.List");
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1131d mo2004a(C1107r c1107r) {
        String m2128b = AbstractC1156u.m2128b(c1107r);
        Matcher matcher = f2301f.matcher(m2128b);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> m2042b = m2042b((CharSequence) "FN", m2128b, true, false);
        if (m2042b == null) {
            m2042b = m2042b((CharSequence) "N", m2128b, true, false);
            m2038a((Iterable<List<String>>) m2042b);
        }
        List<String> m2036a = m2036a((CharSequence) "NICKNAME", m2128b, true, false);
        String[] split = m2036a == null ? null : f2309n.split(m2036a.get(0));
        List<List<String>> m2042b2 = m2042b((CharSequence) "TEL", m2128b, true, false);
        List<List<String>> m2042b3 = m2042b((CharSequence) "EMAIL", m2128b, true, false);
        List<String> m2036a2 = m2036a((CharSequence) "NOTE", m2128b, false, false);
        List<List<String>> m2042b4 = m2042b((CharSequence) "ADR", m2128b, true, true);
        List<String> m2036a3 = m2036a((CharSequence) "ORG", m2128b, true, true);
        List<String> m2036a4 = m2036a((CharSequence) "BDAY", m2128b, true, false);
        List<String> list = (m2036a4 == null || m2040a((CharSequence) m2036a4.get(0))) ? m2036a4 : null;
        List<String> m2036a5 = m2036a((CharSequence) "TITLE", m2128b, true, false);
        List<List<String>> m2042b5 = m2042b((CharSequence) "URL", m2128b, true, false);
        List<String> m2036a6 = m2036a((CharSequence) "IMPP", m2128b, true, false);
        List<String> m2036a7 = m2036a((CharSequence) "GEO", m2128b, true, false);
        String[] split2 = m2036a7 == null ? null : f2310o.split(m2036a7.get(0));
        return new C1131d(m2041a((Collection<List<String>>) m2042b), split, null, m2041a((Collection<List<String>>) m2042b2), m2043b(m2042b2), m2041a((Collection<List<String>>) m2042b3), m2043b(m2042b3), m2035a(m2036a6), m2035a(m2036a2), m2041a((Collection<List<String>>) m2042b4), m2043b(m2042b4), m2035a(m2036a3), m2035a(list), m2035a(m2036a5), m2041a((Collection<List<String>>) m2042b5), (split2 == null || split2.length == 2) ? split2 : null);
    }

    /* renamed from: a */
    private static String m2034a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 != '\n' && charAt2 != '\r') {
                if (charAt2 != '=') {
                    m2037a(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (i2 < length - 2 && (charAt = charSequence.charAt(i2 + 1)) != '\r' && charAt != '\n') {
                    i2 += 2;
                    char charAt3 = charSequence.charAt(i2);
                    int m2120a = AbstractC1156u.m2120a(charAt);
                    int m2120a2 = AbstractC1156u.m2120a(charAt3);
                    if (m2120a >= 0 && m2120a2 >= 0) {
                        byteArrayOutputStream.write((m2120a << 4) + m2120a2);
                    }
                }
            }
            i2++;
        }
        m2037a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    /* renamed from: b */
    private static String[] m2043b(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            int i2 = 1;
            while (true) {
                if (i2 >= list.size()) {
                    str = null;
                    break;
                }
                String str2 = list.get(i2);
                int indexOf = str2.indexOf(61);
                if (indexOf < 0) {
                    str = str2;
                    break;
                }
                if (C7346e.f.f25857c.equalsIgnoreCase(str2.substring(0, indexOf))) {
                    str = str2.substring(indexOf + 1);
                    break;
                }
                i2++;
            }
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    /* renamed from: a */
    private static void m2037a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, Charset.forName("UTF-8"));
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, Charset.forName("UTF-8"));
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    /* renamed from: a */
    static List<String> m2036a(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> m2042b = m2042b(charSequence, str, z, z2);
        if (m2042b == null || m2042b.isEmpty()) {
            return null;
        }
        return m2042b.get(0);
    }

    /* renamed from: a */
    private static String m2035a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /* renamed from: a */
    private static String[] m2041a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> it = collection.iterator();
        while (it.hasNext()) {
            String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    /* renamed from: a */
    private static boolean m2040a(CharSequence charSequence) {
        return charSequence == null || f2302g.matcher(charSequence).matches();
    }

    /* renamed from: a */
    private static void m2038a(Iterable<List<String>> iterable) {
        int indexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < strArr.length - 1 && (indexOf = str.indexOf(59, i3)) >= 0) {
                    strArr[i2] = str.substring(i3, indexOf);
                    i2++;
                    i3 = indexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                m2039a(strArr, 3, sb);
                m2039a(strArr, 1, sb);
                m2039a(strArr, 2, sb);
                m2039a(strArr, 0, sb);
                m2039a(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private static void m2039a(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] == null || strArr[i2].isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i2]);
    }
}
