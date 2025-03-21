package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.C2563e;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.p323z2.C5736h0;

/* renamed from: com.huawei.secure.android.common.ssl.hostname.b */
/* loaded from: classes.dex */
public class C2558b {

    /* renamed from: a */
    private static final Pattern f8216a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b */
    private static final String[] f8217b = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};

    static {
        Arrays.sort(f8217b);
    }

    /* renamed from: a */
    public static final void m7935a(String str, X509Certificate x509Certificate, boolean z) throws SSLException {
        String[] m7938a = m7938a(x509Certificate);
        String[] m7940b = m7940b(x509Certificate);
        C2563e.m7984a("", "cn is : " + Arrays.toString(m7938a));
        C2563e.m7984a("", "san is : " + Arrays.toString(m7940b));
        m7936a(str, m7938a, m7940b, z);
    }

    /* renamed from: b */
    public static String[] m7940b(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e2) {
            C2563e.m7985a("", "Error parsing certificate.", e2);
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    /* renamed from: c */
    private static boolean m7941c(String str) {
        return f8216a.matcher(str).matches();
    }

    /* renamed from: a */
    public static final void m7936a(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && strArr[0] != null) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            for (String str2 : strArr2) {
                if (str2 != null) {
                    linkedList.add(str2);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append(C5736h0.f20716e);
                if (it.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && m7937a(lowerCase2) && !m7941c(str)) {
                    boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (endsWith && z) {
                        z2 = m7939b(lowerCase) == m7939b(lowerCase2);
                    } else {
                        z2 = endsWith;
                    }
                } else {
                    z2 = lowerCase.equals(lowerCase2);
                }
                if (z2) {
                    break;
                }
            }
            if (z2) {
                return;
            }
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    /* renamed from: b */
    public static int m7939b(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '.') {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static boolean m7937a(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i2 = length - 3;
        if (str.charAt(i2) == '.') {
            return Arrays.binarySearch(f8217b, str.substring(2, i2)) < 0;
        }
        return true;
    }

    /* renamed from: a */
    public static String[] m7938a(X509Certificate x509Certificate) {
        List<String> m7934b = new C2557a(x509Certificate.getSubjectX500Principal()).m7934b(AbstractC1191a.f2509J);
        if (m7934b.isEmpty()) {
            return null;
        }
        String[] strArr = new String[m7934b.size()];
        m7934b.toArray(strArr);
        return strArr;
    }
}
