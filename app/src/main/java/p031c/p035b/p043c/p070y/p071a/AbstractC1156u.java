package p031c.p035b.p043c.p070y.p071a;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import p031c.p035b.p043c.C1107r;

/* compiled from: ResultParser.java */
/* renamed from: c.b.c.y.a.u */
/* loaded from: classes.dex */
public abstract class AbstractC1156u {

    /* renamed from: a */
    private static final AbstractC1156u[] f2374a = {new C1135f(), new C1129c(), new C1143j(), new C1127b(), new C1136f0(), new C1133e(), new C1138g0(), new C1141i(), new C1160y(), new C1126a0(), new C1157v(), new C1159x(), new C1149n(), new C1146k0(), new C1134e0(), new C1132d0(), new C1151p(), new C1155t(), new C1147l(), new C1142i0()};

    /* renamed from: b */
    private static final Pattern f2375b = Pattern.compile("\\d+");

    /* renamed from: c */
    private static final Pattern f2376c = Pattern.compile("&");

    /* renamed from: d */
    private static final Pattern f2377d = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);

    /* renamed from: e */
    private static final String f2378e = "\ufeff";

    /* renamed from: a */
    protected static int m2120a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    /* renamed from: a */
    protected static void m2123a(String str, StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }

    /* renamed from: a */
    protected static String[] m2126a(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    /* renamed from: b */
    protected static String m2128b(C1107r c1107r) {
        String m1917e = c1107r.m1917e();
        return m1917e.startsWith(f2378e) ? m1917e.substring(1) : m1917e;
    }

    /* renamed from: c */
    public static AbstractC1152q m2132c(C1107r c1107r) {
        for (AbstractC1156u abstractC1156u : f2374a) {
            AbstractC1152q mo2004a = abstractC1156u.mo2004a(c1107r);
            if (mo2004a != null) {
                return mo2004a;
            }
        }
        return new C1128b0(c1107r.m1917e(), null);
    }

    /* renamed from: d */
    static String m2134d(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* renamed from: a */
    public abstract AbstractC1152q mo2004a(C1107r c1107r);

    /* renamed from: a */
    protected static void m2124a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                sb.append('\n');
                sb.append(str);
            }
        }
    }

    /* renamed from: b */
    protected static boolean m2131b(CharSequence charSequence, int i2) {
        return charSequence != null && i2 > 0 && i2 == charSequence.length() && f2375b.matcher(charSequence).matches();
    }

    /* renamed from: c */
    protected static String m2133c(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, indexOf);
        boolean z = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z || charAt != '\\') {
                sb.append(charAt);
                z = false;
            } else {
                z = true;
            }
            indexOf++;
        }
        return sb.toString();
    }

    /* renamed from: b */
    static Map<String, String> m2130b(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(3);
        for (String str2 : f2376c.split(str.substring(indexOf + 1))) {
            m2122a(str2, hashMap);
        }
        return hashMap;
    }

    /* renamed from: a */
    protected static boolean m2125a(CharSequence charSequence, int i2, int i3) {
        int i4;
        return charSequence != null && i3 > 0 && charSequence.length() >= (i4 = i3 + i2) && f2375b.matcher(charSequence.subSequence(i2, i4)).matches();
    }

    /* renamed from: a */
    private static void m2122a(CharSequence charSequence, Map<String, String> map) {
        String[] split = f2377d.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], m2134d(split[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* renamed from: b */
    static String m2129b(String str, String str2, char c2, boolean z) {
        String[] m2127a = m2127a(str, str2, c2, z);
        if (m2127a == null) {
            return null;
        }
        return m2127a[0];
    }

    /* renamed from: a */
    static String[] m2127a(String str, String str2, char c2, boolean z) {
        int i2;
        int length = str2.length();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < length; i3 = i2) {
            int indexOf = str2.indexOf(str, i3);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            boolean z2 = true;
            i2 = length2;
            while (z2) {
                int indexOf2 = str2.indexOf(c2, i2);
                if (indexOf2 < 0) {
                    i2 = str2.length();
                } else if (m2121a(str2, indexOf2) % 2 != 0) {
                    i2 = indexOf2 + 1;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(3);
                    }
                    String m2133c = m2133c(str2.substring(length2, indexOf2));
                    if (z) {
                        m2133c = m2133c.trim();
                    }
                    if (!m2133c.isEmpty()) {
                        arrayList.add(m2133c);
                    }
                    i2 = indexOf2 + 1;
                }
                z2 = false;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    private static int m2121a(CharSequence charSequence, int i2) {
        int i3 = 0;
        for (int i4 = i2 - 1; i4 >= 0 && charSequence.charAt(i4) == '\\'; i4--) {
            i3++;
        }
        return i3;
    }
}
