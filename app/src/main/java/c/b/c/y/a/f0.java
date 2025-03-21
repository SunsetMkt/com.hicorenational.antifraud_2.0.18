package c.b.c.y.a;

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

/* compiled from: VCardResultParser.java */
/* loaded from: classes.dex */
public final class f0 extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2924f = Pattern.compile("BEGIN:VCARD", 2);

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f2925g = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f2926h = Pattern.compile("\r\n[ \t]");

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f2927i = Pattern.compile("\\\\[nN]");

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f2928j = Pattern.compile("\\\\([,;\\\\])");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f2929k = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f2930l = Pattern.compile(";");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f2931m = Pattern.compile("(?<!\\\\);+");
    private static final Pattern n = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private static final Pattern o = Pattern.compile("[;,]");

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cd, code lost:
    
        r2 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.List<java.util.List<java.lang.String>> b(java.lang.CharSequence r16, java.lang.String r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.y.a.f0.b(java.lang.CharSequence, java.lang.String, boolean, boolean):java.util.List");
    }

    @Override // c.b.c.y.a.u
    public d a(c.b.c.r rVar) {
        String b2 = u.b(rVar);
        Matcher matcher = f2924f.matcher(b2);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> b3 = b((CharSequence) "FN", b2, true, false);
        if (b3 == null) {
            b3 = b((CharSequence) "N", b2, true, false);
            a((Iterable<List<String>>) b3);
        }
        List<String> a2 = a((CharSequence) "NICKNAME", b2, true, false);
        String[] split = a2 == null ? null : n.split(a2.get(0));
        List<List<String>> b4 = b((CharSequence) "TEL", b2, true, false);
        List<List<String>> b5 = b((CharSequence) "EMAIL", b2, true, false);
        List<String> a3 = a((CharSequence) "NOTE", b2, false, false);
        List<List<String>> b6 = b((CharSequence) "ADR", b2, true, true);
        List<String> a4 = a((CharSequence) "ORG", b2, true, true);
        List<String> a5 = a((CharSequence) "BDAY", b2, true, false);
        List<String> list = (a5 == null || a((CharSequence) a5.get(0))) ? a5 : null;
        List<String> a6 = a((CharSequence) "TITLE", b2, true, false);
        List<List<String>> b7 = b((CharSequence) "URL", b2, true, false);
        List<String> a7 = a((CharSequence) "IMPP", b2, true, false);
        List<String> a8 = a((CharSequence) "GEO", b2, true, false);
        String[] split2 = a8 == null ? null : o.split(a8.get(0));
        return new d(a((Collection<List<String>>) b3), split, null, a((Collection<List<String>>) b4), b(b4), a((Collection<List<String>>) b5), b(b5), a(a7), a(a3), a((Collection<List<String>>) b6), b(b6), a(a4), a(list), a(a6), a((Collection<List<String>>) b7), (split2 == null || split2.length == 2) ? split2 : null);
    }

    private static String a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 != '\n' && charAt2 != '\r') {
                if (charAt2 != '=') {
                    a(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (i2 < length - 2 && (charAt = charSequence.charAt(i2 + 1)) != '\r' && charAt != '\n') {
                    i2 += 2;
                    char charAt3 = charSequence.charAt(i2);
                    int a2 = u.a(charAt);
                    int a3 = u.a(charAt3);
                    if (a2 >= 0 && a3 >= 0) {
                        byteArrayOutputStream.write((a2 << 4) + a3);
                    }
                }
            }
            i2++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static String[] b(Collection<List<String>> collection) {
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
                if (e.f.f21130c.equalsIgnoreCase(str2.substring(0, indexOf))) {
                    str = str2.substring(indexOf + 1);
                    break;
                }
                i2++;
            }
            arrayList.add(str);
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
        List<List<String>> b2 = b(charSequence, str, z, z2);
        if (b2 == null || b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
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
        return charSequence == null || f2925g.matcher(charSequence).matches();
    }

    private static void a(Iterable<List<String>> iterable) {
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
