package j.a.a.a.m.k;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import j.a.a.a.m.k.c;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Rule.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12519f = "ALL";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f12520g = "\"";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f12521h = "#include";
    private final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f12524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final n f12525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f12518e = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<j.a.a.a.m.k.d, Map<j.a.a.a.m.k.h, Map<String, List<g>>>> f12522i = new EnumMap(j.a.a.a.m.k.d.class);

    /* JADX INFO: compiled from: Rule.java */
    static class a implements n {
        Pattern a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f12526b;

        a(String str) {
            this.f12526b = str;
            this.a = Pattern.compile(this.f12526b);
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return this.a.matcher(charSequence).find();
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    static class b implements n {
        b() {
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return true;
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    static class c extends g {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f12527j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f12528k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f12529l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f12530m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, String str3, l lVar, int i2, String str4) {
            super(str, str2, str3, lVar);
            this.f12529l = i2;
            this.f12530m = str4;
            this.f12527j = this.f12529l;
            this.f12528k = this.f12530m;
        }

        public String toString() {
            return "Rule{line=" + this.f12527j + ", loc='" + this.f12528k + "'}";
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    static class d implements n {
        d() {
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    static class e implements n {
        final /* synthetic */ String a;

        e(String str) {
            this.a = str;
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.equals(this.a);
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    static class f implements n {
        final /* synthetic */ String a;

        f(String str) {
            this.a = str;
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return g.d(charSequence, this.a);
        }
    }

    /* JADX INFO: renamed from: j.a.a.a.m.k.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Rule.java */
    static class C0256g implements n {
        final /* synthetic */ String a;

        C0256g(String str) {
            this.a = str;
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return g.c(charSequence, this.a);
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    static class h implements n {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f12531b;

        h(String str, boolean z) {
            this.a = str;
            this.f12531b = z;
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() == 1 && g.b(this.a, charSequence.charAt(0)) == this.f12531b;
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    static class i implements n {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f12532b;

        i(String str, boolean z) {
            this.a = str;
            this.f12532b = z;
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() > 0 && g.b(this.a, charSequence.charAt(0)) == this.f12532b;
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    static class j implements n {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f12533b;

        j(String str, boolean z) {
            this.a = str;
            this.f12533b = z;
        }

        @Override // j.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() > 0 && g.b(this.a, charSequence.charAt(charSequence.length() - 1)) == this.f12533b;
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    public static final class k implements l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator<k> f12534c = new a();
        private final CharSequence a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c.AbstractC0255c f12535b;

        /* JADX INFO: compiled from: Rule.java */
        static class a implements Comparator<k> {
            a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(k kVar, k kVar2) {
                for (int i2 = 0; i2 < kVar.a.length(); i2++) {
                    if (i2 >= kVar2.a.length()) {
                        return 1;
                    }
                    int iCharAt = kVar.a.charAt(i2) - kVar2.a.charAt(i2);
                    if (iCharAt != 0) {
                        return iCharAt;
                    }
                }
                return kVar.a.length() < kVar2.a.length() ? -1 : 0;
            }
        }

        public k(CharSequence charSequence, c.AbstractC0255c abstractC0255c) {
            this.a = charSequence;
            this.f12535b = abstractC0255c;
        }

        public k a(CharSequence charSequence) {
            return new k(this.a.toString() + charSequence.toString(), this.f12535b);
        }

        public CharSequence c() {
            return this.a;
        }

        @Override // j.a.a.a.m.k.g.l
        public Iterable<k> a() {
            return Collections.singleton(this);
        }

        public c.AbstractC0255c b() {
            return this.f12535b;
        }

        public k a(k kVar) {
            return new k(this.a.toString() + kVar.a.toString(), this.f12535b.a(kVar.f12535b));
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    public interface l {
        Iterable<k> a();
    }

    /* JADX INFO: compiled from: Rule.java */
    public static final class m implements l {
        private final List<k> a;

        public m(List<k> list) {
            this.a = list;
        }

        @Override // j.a.a.a.m.k.g.l
        public List<k> a() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: Rule.java */
    public interface n {
        boolean a(CharSequence charSequence);
    }

    static {
        for (j.a.a.a.m.k.d dVar : j.a.a.a.m.k.d.values()) {
            EnumMap enumMap = new EnumMap(j.a.a.a.m.k.h.class);
            for (j.a.a.a.m.k.h hVar : j.a.a.a.m.k.h.values()) {
                HashMap map = new HashMap();
                for (String str : j.a.a.a.m.k.c.a(dVar).a()) {
                    try {
                        map.put(str, a(b(dVar, hVar, str), a(dVar, hVar, str)));
                    } catch (IllegalStateException e2) {
                        throw new IllegalStateException("Problem processing " + a(dVar, hVar, str), e2);
                    }
                }
                if (!hVar.equals(j.a.a.a.m.k.h.RULES)) {
                    map.put("common", a(b(dVar, hVar, "common"), a(dVar, hVar, "common")));
                }
                enumMap.put(hVar, Collections.unmodifiableMap(map));
            }
            f12522i.put(dVar, Collections.unmodifiableMap(enumMap));
        }
    }

    public g(String str, String str2, String str3, l lVar) {
        this.f12523b = str;
        this.a = d(str2 + "$");
        this.f12525d = d("^" + str3);
        this.f12524c = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        for (int length2 = charSequence2.length() - 1; length2 >= 0; length2--) {
            if (charSequence.charAt(length) != charSequence2.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    private static n d(String str) {
        boolean zStartsWith = str.startsWith("^");
        boolean zEndsWith = str.endsWith("$");
        int length = str.length();
        if (zEndsWith) {
            length--;
        }
        String strSubstring = str.substring(zStartsWith ? 1 : 0, length);
        if (strSubstring.contains("[")) {
            boolean zStartsWith2 = strSubstring.startsWith("[");
            boolean zEndsWith2 = strSubstring.endsWith("]");
            if (zStartsWith2 && zEndsWith2) {
                String strSubstring2 = strSubstring.substring(1, strSubstring.length() - 1);
                if (!strSubstring2.contains("[")) {
                    boolean zStartsWith3 = strSubstring2.startsWith("^");
                    if (zStartsWith3) {
                        strSubstring2 = strSubstring2.substring(1);
                    }
                    boolean z = !zStartsWith3;
                    if (zStartsWith && zEndsWith) {
                        return new h(strSubstring2, z);
                    }
                    if (zStartsWith) {
                        return new i(strSubstring2, z);
                    }
                    if (zEndsWith) {
                        return new j(strSubstring2, z);
                    }
                }
            }
        } else {
            if (zStartsWith && zEndsWith) {
                return strSubstring.length() == 0 ? new d() : new e(strSubstring);
            }
            if ((zStartsWith || zEndsWith) && strSubstring.length() == 0) {
                return f12518e;
            }
            if (zStartsWith) {
                return new f(strSubstring);
            }
            if (zEndsWith) {
                return new C0256g(strSubstring);
            }
        }
        return new a(str);
    }

    private static String e(String str) {
        if (str.startsWith(f12520g)) {
            str = str.substring(1);
        }
        return str.endsWith(f12520g) ? str.substring(0, str.length() - 1) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(CharSequence charSequence, char c2) {
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (charSequence.charAt(i2) == c2) {
                return true;
            }
        }
        return false;
    }

    private static String a(j.a.a.a.m.k.d dVar, j.a.a.a.m.k.h hVar, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", dVar.getName(), hVar.getName(), str);
    }

    private static Scanner a(String str) {
        String str2 = String.format("org/apache/commons/codec/language/bm/%s.txt", str);
        InputStream resourceAsStream = j.a.a.a.m.k.c.class.getClassLoader().getResourceAsStream(str2);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + str2);
    }

    private static Scanner b(j.a.a.a.m.k.d dVar, j.a.a.a.m.k.h hVar, String str) {
        String strA = a(dVar, hVar, str);
        InputStream resourceAsStream = j.a.a.a.m.k.c.class.getClassLoader().getResourceAsStream(strA);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + strA);
    }

    public static List<g> c(j.a.a.a.m.k.d dVar, j.a.a.a.m.k.h hVar, String str) {
        List<g> list = f12522i.get(dVar).get(hVar).get(str);
        if (list != null) {
            return list;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", dVar.getName(), hVar.getName(), str));
    }

    private static l c(String str) {
        if (str.startsWith("(")) {
            if (str.endsWith(")")) {
                ArrayList arrayList = new ArrayList();
                String strSubstring = str.substring(1, str.length() - 1);
                for (String str2 : strSubstring.split("[|]")) {
                    arrayList.add(b(str2));
                }
                if (strSubstring.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || strSubstring.endsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                    arrayList.add(new k("", j.a.a.a.m.k.c.f12505e));
                }
                return new m(arrayList);
            }
            throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
        }
        return b(str);
    }

    public static List<g> a(j.a.a.a.m.k.d dVar, j.a.a.a.m.k.h hVar, c.AbstractC0255c abstractC0255c) {
        return c(dVar, hVar, abstractC0255c.c() ? abstractC0255c.a() : j.a.a.a.m.k.c.f12502b);
    }

    private static k b(String str) {
        int iIndexOf = str.indexOf("[");
        if (iIndexOf >= 0) {
            if (str.endsWith("]")) {
                return new k(str.substring(0, iIndexOf), c.AbstractC0255c.a(new HashSet(Arrays.asList(str.substring(iIndexOf + 1, str.length() - 1).split("[+]")))));
            }
            throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
        }
        return new k(str, j.a.a.a.m.k.c.f12505e);
    }

    private static List<g> a(Scanner scanner, String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                i2++;
                String strNextLine = scanner.nextLine();
                if (z) {
                    if (strNextLine.endsWith("*/")) {
                        break;
                    }
                } else if (strNextLine.startsWith("/*")) {
                    z = true;
                } else {
                    int iIndexOf = strNextLine.indexOf("//");
                    String strTrim = (iIndexOf >= 0 ? strNextLine.substring(0, iIndexOf) : strNextLine).trim();
                    if (strTrim.length() == 0) {
                        continue;
                    } else if (strTrim.startsWith(f12521h)) {
                        String strTrim2 = strTrim.substring(8).trim();
                        if (strTrim2.contains(d.c.a.b.a.a.f10074g)) {
                            System.err.println("Warining: malformed import statement: " + strNextLine);
                        } else {
                            arrayList.addAll(a(a(strTrim2), str + "->" + strTrim2));
                        }
                    } else {
                        String[] strArrSplit = strTrim.split("\\s+");
                        if (strArrSplit.length != 4) {
                            System.err.println("Warning: malformed rule statement split into " + strArrSplit.length + " parts: " + strNextLine);
                        } else {
                            try {
                                arrayList.add(new c(e(strArrSplit[0]), e(strArrSplit[1]), e(strArrSplit[2]), c(e(strArrSplit[3])), i2, str));
                            } catch (IllegalArgumentException e2) {
                                throw new IllegalStateException("Problem parsing line " + i2, e2);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    public String b() {
        return this.f12523b;
    }

    public l c() {
        return this.f12524c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i2 = 0; i2 < charSequence2.length(); i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public n d() {
        return this.f12525d;
    }

    public n a() {
        return this.a;
    }

    public boolean a(CharSequence charSequence, int i2) {
        if (i2 >= 0) {
            int length = this.f12523b.length() + i2;
            if (length > charSequence.length()) {
                return false;
            }
            return charSequence.subSequence(i2, length).equals(this.f12523b) && this.f12525d.a(charSequence.subSequence(length, charSequence.length())) && this.a.a(charSequence.subSequence(0, i2));
        }
        throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
    }
}
