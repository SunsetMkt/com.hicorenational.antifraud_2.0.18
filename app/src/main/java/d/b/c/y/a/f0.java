package d.b.c.y.a;

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
import zxing.android.e;

/* JADX INFO: compiled from: VCardResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f9917f = Pattern.compile("BEGIN:VCARD", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f9918g = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f9919h = Pattern.compile("\r\n[ \t]");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f9920i = Pattern.compile("\\\\[nN]");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f9921j = Pattern.compile("\\\\([,;\\\\])");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f9922k = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f9923l = Pattern.compile(";");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f9924m = Pattern.compile("(?<!\\\\);+");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Pattern f9925n = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private static final Pattern o = Pattern.compile("[;,]");

    static List<List<String>> b(CharSequence charSequence, String str, boolean z, boolean z2) {
        ArrayList arrayList;
        boolean z3;
        String str2;
        int iIndexOf;
        int i2;
        String strReplaceAll;
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        ArrayList arrayList2 = null;
        while (i4 < length) {
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i4 > 0) {
                i4--;
            }
            if (!matcher.find(i4)) {
                break;
            }
            int iEnd = matcher.end(i3);
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                String[] strArrSplit = f9923l.split(strGroup);
                int length2 = strArrSplit.length;
                int i5 = 0;
                arrayList = null;
                z3 = false;
                str2 = null;
                while (i5 < length2) {
                    String str3 = strArrSplit[i5];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str3);
                    String[] strArrSplit2 = f9922k.split(str3, 2);
                    if (strArrSplit2.length > 1) {
                        String str4 = strArrSplit2[i3];
                        String str5 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str5)) {
                            z3 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str4)) {
                            str2 = str5;
                        }
                    }
                    i5++;
                    i3 = 0;
                }
            } else {
                arrayList = null;
                z3 = false;
                str2 = null;
            }
            int i6 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i6);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i7 = iIndexOf + 1;
                    if (str.charAt(i7) == ' ' || str.charAt(i7) == '\t') {
                        i6 = iIndexOf + 2;
                    }
                }
                if (!z3 || ((iIndexOf < 1 || str.charAt(iIndexOf - 1) != '=') && (iIndexOf < 2 || str.charAt(iIndexOf - 2) != '='))) {
                    break;
                }
                i6 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i2 = length;
            } else if (iIndexOf <= iEnd) {
                i2 = iIndexOf + 1;
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                if (iIndexOf >= 1 && str.charAt(iIndexOf - 1) == '\r') {
                    iIndexOf--;
                }
                String strSubstring = str.substring(iEnd, iIndexOf);
                if (z) {
                    strSubstring = strSubstring.trim();
                }
                if (z3) {
                    strReplaceAll = a(strSubstring, str2);
                    if (z2) {
                        strReplaceAll = f9924m.matcher(strReplaceAll).replaceAll("\n").trim();
                    }
                } else {
                    if (z2) {
                        strSubstring = f9924m.matcher(strSubstring).replaceAll("\n").trim();
                    }
                    strReplaceAll = f9921j.matcher(f9920i.matcher(f9919h.matcher(strSubstring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                }
                if (arrayList == null) {
                    ArrayList arrayList3 = new ArrayList(1);
                    arrayList3.add(strReplaceAll);
                    arrayList2.add(arrayList3);
                    i2 = iIndexOf + 1;
                } else {
                    arrayList.add(0, strReplaceAll);
                    arrayList2.add(arrayList);
                    i2 = iIndexOf + 1;
                }
            }
            i4 = i2;
            i3 = 0;
        }
        return arrayList2;
    }

    @Override // d.b.c.y.a.u
    public d a(d.b.c.r rVar) {
        String strB = u.b(rVar);
        Matcher matcher = f9917f.matcher(strB);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> listB = b((CharSequence) "FN", strB, true, false);
        if (listB == null) {
            listB = b((CharSequence) "N", strB, true, false);
            a((Iterable<List<String>>) listB);
        }
        List<String> listA = a((CharSequence) "NICKNAME", strB, true, false);
        String[] strArrSplit = listA == null ? null : f9925n.split(listA.get(0));
        List<List<String>> listB2 = b((CharSequence) "TEL", strB, true, false);
        List<List<String>> listB3 = b((CharSequence) "EMAIL", strB, true, false);
        List<String> listA2 = a((CharSequence) "NOTE", strB, false, false);
        List<List<String>> listB4 = b((CharSequence) "ADR", strB, true, true);
        List<String> listA3 = a((CharSequence) "ORG", strB, true, true);
        List<String> listA4 = a((CharSequence) "BDAY", strB, true, false);
        List<String> list = (listA4 == null || a((CharSequence) listA4.get(0))) ? listA4 : null;
        List<String> listA5 = a((CharSequence) "TITLE", strB, true, false);
        List<List<String>> listB5 = b((CharSequence) "URL", strB, true, false);
        List<String> listA6 = a((CharSequence) "IMPP", strB, true, false);
        List<String> listA7 = a((CharSequence) "GEO", strB, true, false);
        String[] strArrSplit2 = listA7 == null ? null : o.split(listA7.get(0));
        return new d(a((Collection<List<String>>) listB), strArrSplit, null, a((Collection<List<String>>) listB2), b(listB2), a((Collection<List<String>>) listB3), b(listB3), a(listA6), a(listA2), a((Collection<List<String>>) listB4), b(listB4), a(listA3), a(list), a(listA5), a((Collection<List<String>>) listB5), (strArrSplit2 == null || strArrSplit2.length == 2) ? strArrSplit2 : null);
    }

    private static String a(CharSequence charSequence, String str) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                if (cCharAt2 != '=') {
                    a(byteArrayOutputStream, str, sb);
                    sb.append(cCharAt2);
                } else if (i2 < length - 2 && (cCharAt = charSequence.charAt(i2 + 1)) != '\r' && cCharAt != '\n') {
                    i2 += 2;
                    char cCharAt3 = charSequence.charAt(i2);
                    int iA = u.a(cCharAt);
                    int iA2 = u.a(cCharAt3);
                    if (iA >= 0 && iA2 >= 0) {
                        byteArrayOutputStream.write((iA << 4) + iA2);
                    }
                }
            }
            i2++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static String[] b(Collection<List<String>> collection) {
        String strSubstring;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            int i2 = 1;
            while (true) {
                if (i2 >= list.size()) {
                    strSubstring = null;
                    break;
                }
                String str = list.get(i2);
                int iIndexOf = str.indexOf(61);
                if (iIndexOf < 0) {
                    strSubstring = str;
                    break;
                }
                if (e.f.f15161c.equalsIgnoreCase(str.substring(0, iIndexOf))) {
                    strSubstring = str.substring(iIndexOf + 1);
                    break;
                }
                i2++;
            }
            arrayList.add(strSubstring);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
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

    static List<String> a(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> listB = b(charSequence, str, z, z2);
        if (listB == null || listB.isEmpty()) {
            return null;
        }
        return listB.get(0);
    }

    private static String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] a(Collection<List<String>> collection) {
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

    private static boolean a(CharSequence charSequence) {
        return charSequence == null || f9918g.matcher(charSequence).matches();
    }

    private static void a(Iterable<List<String>> iterable) {
        int iIndexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < strArr.length - 1 && (iIndexOf = str.indexOf(59, i3)) >= 0) {
                    strArr[i2] = str.substring(i3, iIndexOf);
                    i2++;
                    i3 = iIndexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                a(strArr, 3, sb);
                a(strArr, 1, sb);
                a(strArr, 2, sb);
                a(strArr, 0, sb);
                a(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    private static void a(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] == null || strArr[i2].isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i2]);
    }
}
