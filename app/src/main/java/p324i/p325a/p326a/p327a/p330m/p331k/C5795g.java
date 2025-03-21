package p324i.p325a.p326a.p327a.p330m.p331k;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p324i.p325a.p326a.p327a.p330m.p331k.C5791c;

/* compiled from: Rule.java */
/* renamed from: i.a.a.a.m.k.g */
/* loaded from: classes2.dex */
public class C5795g {

    /* renamed from: f */
    public static final String f20891f = "ALL";

    /* renamed from: g */
    private static final String f20892g = "\"";

    /* renamed from: h */
    private static final String f20893h = "#include";

    /* renamed from: a */
    private final n f20895a;

    /* renamed from: b */
    private final String f20896b;

    /* renamed from: c */
    private final l f20897c;

    /* renamed from: d */
    private final n f20898d;

    /* renamed from: e */
    public static final n f20890e = new b();

    /* renamed from: i */
    private static final Map<EnumC5792d, Map<EnumC5796h, Map<String, List<C5795g>>>> f20894i = new EnumMap(EnumC5792d.class);

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$a */
    static class a implements n {

        /* renamed from: a */
        Pattern f20899a;

        /* renamed from: b */
        final /* synthetic */ String f20900b;

        a(String str) {
            this.f20900b = str;
            this.f20899a = Pattern.compile(this.f20900b);
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return this.f20899a.matcher(charSequence).find();
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$b */
    static class b implements n {
        b() {
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return true;
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$c */
    static class c extends C5795g {

        /* renamed from: j */
        private final int f20901j;

        /* renamed from: k */
        private final String f20902k;

        /* renamed from: l */
        final /* synthetic */ int f20903l;

        /* renamed from: m */
        final /* synthetic */ String f20904m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, String str3, l lVar, int i2, String str4) {
            super(str, str2, str3, lVar);
            this.f20903l = i2;
            this.f20904m = str4;
            this.f20901j = this.f20903l;
            this.f20902k = this.f20904m;
        }

        public String toString() {
            return "Rule{line=" + this.f20901j + ", loc='" + this.f20902k + "'}";
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$d */
    static class d implements n {
        d() {
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$e */
    static class e implements n {

        /* renamed from: a */
        final /* synthetic */ String f20905a;

        e(String str) {
            this.f20905a = str;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return charSequence.equals(this.f20905a);
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$f */
    static class f implements n {

        /* renamed from: a */
        final /* synthetic */ String f20906a;

        f(String str) {
            this.f20906a = str;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return C5795g.m24401d(charSequence, this.f20906a);
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$g */
    static class g implements n {

        /* renamed from: a */
        final /* synthetic */ String f20907a;

        g(String str) {
            this.f20907a = str;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return C5795g.m24399c(charSequence, this.f20907a);
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$h */
    static class h implements n {

        /* renamed from: a */
        final /* synthetic */ String f20908a;

        /* renamed from: b */
        final /* synthetic */ boolean f20909b;

        h(String str, boolean z) {
            this.f20908a = str;
            this.f20909b = z;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return charSequence.length() == 1 && C5795g.m24395b(this.f20908a, charSequence.charAt(0)) == this.f20909b;
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$i */
    static class i implements n {

        /* renamed from: a */
        final /* synthetic */ String f20910a;

        /* renamed from: b */
        final /* synthetic */ boolean f20911b;

        i(String str, boolean z) {
            this.f20910a = str;
            this.f20911b = z;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return charSequence.length() > 0 && C5795g.m24395b(this.f20910a, charSequence.charAt(0)) == this.f20911b;
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$j */
    static class j implements n {

        /* renamed from: a */
        final /* synthetic */ String f20912a;

        /* renamed from: b */
        final /* synthetic */ boolean f20913b;

        j(String str, boolean z) {
            this.f20912a = str;
            this.f20913b = z;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.n
        /* renamed from: a */
        public boolean mo24408a(CharSequence charSequence) {
            return charSequence.length() > 0 && C5795g.m24395b(this.f20912a, charSequence.charAt(charSequence.length() - 1)) == this.f20913b;
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$k */
    public static final class k implements l {

        /* renamed from: c */
        public static final Comparator<k> f20914c = new a();

        /* renamed from: a */
        private final CharSequence f20915a;

        /* renamed from: b */
        private final C5791c.c f20916b;

        /* compiled from: Rule.java */
        /* renamed from: i.a.a.a.m.k.g$k$a */
        static class a implements Comparator<k> {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(k kVar, k kVar2) {
                for (int i2 = 0; i2 < kVar.f20915a.length(); i2++) {
                    if (i2 >= kVar2.f20915a.length()) {
                        return 1;
                    }
                    int charAt = kVar.f20915a.charAt(i2) - kVar2.f20915a.charAt(i2);
                    if (charAt != 0) {
                        return charAt;
                    }
                }
                return kVar.f20915a.length() < kVar2.f20915a.length() ? -1 : 0;
            }
        }

        public k(CharSequence charSequence, C5791c.c cVar) {
            this.f20915a = charSequence;
            this.f20916b = cVar;
        }

        /* renamed from: a */
        public k m24411a(CharSequence charSequence) {
            return new k(this.f20915a.toString() + charSequence.toString(), this.f20916b);
        }

        /* renamed from: c */
        public CharSequence m24414c() {
            return this.f20915a;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.l
        /* renamed from: a */
        public Iterable<k> mo24412a() {
            return Collections.singleton(this);
        }

        /* renamed from: b */
        public C5791c.c m24413b() {
            return this.f20916b;
        }

        /* renamed from: a */
        public k m24410a(k kVar) {
            return new k(this.f20915a.toString() + kVar.f20915a.toString(), this.f20916b.mo24362a(kVar.f20916b));
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$l */
    public interface l {
        /* renamed from: a */
        Iterable<k> mo24412a();
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$m */
    public static final class m implements l {

        /* renamed from: a */
        private final List<k> f20917a;

        public m(List<k> list) {
            this.f20917a = list;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5795g.l
        /* renamed from: a */
        public List<k> mo24412a() {
            return this.f20917a;
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$n */
    public interface n {
        /* renamed from: a */
        boolean mo24408a(CharSequence charSequence);
    }

    static {
        for (EnumC5792d enumC5792d : EnumC5792d.values()) {
            EnumMap enumMap = new EnumMap(EnumC5796h.class);
            for (EnumC5796h enumC5796h : EnumC5796h.values()) {
                HashMap hashMap = new HashMap();
                for (String str : C5791c.m24358a(enumC5792d).m24361a()) {
                    try {
                        hashMap.put(str, m24389a(m24394b(enumC5792d, enumC5796h, str), m24387a(enumC5792d, enumC5796h, str)));
                    } catch (IllegalStateException e2) {
                        throw new IllegalStateException("Problem processing " + m24387a(enumC5792d, enumC5796h, str), e2);
                    }
                }
                if (!enumC5796h.equals(EnumC5796h.RULES)) {
                    hashMap.put("common", m24389a(m24394b(enumC5792d, enumC5796h, "common"), m24387a(enumC5792d, enumC5796h, "common")));
                }
                enumMap.put((EnumMap) enumC5796h, (EnumC5796h) Collections.unmodifiableMap(hashMap));
            }
            f20894i.put(enumC5792d, Collections.unmodifiableMap(enumMap));
        }
    }

    public C5795g(String str, String str2, String str3, l lVar) {
        this.f20896b = str;
        this.f20895a = m24400d(str2 + "$");
        this.f20898d = m24400d("^" + str3);
        this.f20897c = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m24399c(CharSequence charSequence, CharSequence charSequence2) {
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

    /* renamed from: d */
    private static n m24400d(String str) {
        boolean startsWith = str.startsWith("^");
        boolean endsWith = str.endsWith("$");
        int length = str.length();
        if (endsWith) {
            length--;
        }
        String substring = str.substring(startsWith ? 1 : 0, length);
        if (substring.contains("[")) {
            boolean startsWith2 = substring.startsWith("[");
            boolean endsWith2 = substring.endsWith("]");
            if (startsWith2 && endsWith2) {
                String substring2 = substring.substring(1, substring.length() - 1);
                if (!substring2.contains("[")) {
                    boolean startsWith3 = substring2.startsWith("^");
                    if (startsWith3) {
                        substring2 = substring2.substring(1);
                    }
                    boolean z = !startsWith3;
                    if (startsWith && endsWith) {
                        return new h(substring2, z);
                    }
                    if (startsWith) {
                        return new i(substring2, z);
                    }
                    if (endsWith) {
                        return new j(substring2, z);
                    }
                }
            }
        } else {
            if (startsWith && endsWith) {
                return substring.length() == 0 ? new d() : new e(substring);
            }
            if ((startsWith || endsWith) && substring.length() == 0) {
                return f20890e;
            }
            if (startsWith) {
                return new f(substring);
            }
            if (endsWith) {
                return new g(substring);
            }
        }
        return new a(str);
    }

    /* renamed from: e */
    private static String m24402e(String str) {
        if (str.startsWith(f20892g)) {
            str = str.substring(1);
        }
        return str.endsWith(f20892g) ? str.substring(0, str.length() - 1) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m24395b(CharSequence charSequence, char c2) {
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (charSequence.charAt(i2) == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m24387a(EnumC5792d enumC5792d, EnumC5796h enumC5796h, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", enumC5792d.getName(), enumC5796h.getName(), str);
    }

    /* renamed from: a */
    private static Scanner m24390a(String str) {
        String format = String.format("org/apache/commons/codec/language/bm/%s.txt", str);
        InputStream resourceAsStream = C5791c.class.getClassLoader().getResourceAsStream(format);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + format);
    }

    /* renamed from: b */
    private static Scanner m24394b(EnumC5792d enumC5792d, EnumC5796h enumC5796h, String str) {
        String m24387a = m24387a(enumC5792d, enumC5796h, str);
        InputStream resourceAsStream = C5791c.class.getClassLoader().getResourceAsStream(m24387a);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + m24387a);
    }

    /* renamed from: c */
    public static List<C5795g> m24398c(EnumC5792d enumC5792d, EnumC5796h enumC5796h, String str) {
        List<C5795g> list = f20894i.get(enumC5792d).get(enumC5796h).get(str);
        if (list != null) {
            return list;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", enumC5792d.getName(), enumC5796h.getName(), str));
    }

    /* renamed from: c */
    private static l m24397c(String str) {
        if (str.startsWith("(")) {
            if (str.endsWith(")")) {
                ArrayList arrayList = new ArrayList();
                String substring = str.substring(1, str.length() - 1);
                for (String str2 : substring.split("[|]")) {
                    arrayList.add(m24393b(str2));
                }
                if (substring.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || substring.endsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                    arrayList.add(new k("", C5791c.f20868e));
                }
                return new m(arrayList);
            }
            throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
        }
        return m24393b(str);
    }

    /* renamed from: a */
    public static List<C5795g> m24388a(EnumC5792d enumC5792d, EnumC5796h enumC5796h, C5791c.c cVar) {
        return m24398c(enumC5792d, enumC5796h, cVar.mo24366c() ? cVar.mo24363a() : C5791c.f20865b);
    }

    /* renamed from: b */
    private static k m24393b(String str) {
        int indexOf = str.indexOf("[");
        if (indexOf >= 0) {
            if (str.endsWith("]")) {
                return new k(str.substring(0, indexOf), C5791c.c.m24367a(new HashSet(Arrays.asList(str.substring(indexOf + 1, str.length() - 1).split("[+]")))));
            }
            throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
        }
        return new k(str, C5791c.f20868e);
    }

    /* renamed from: a */
    private static List<C5795g> m24389a(Scanner scanner, String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                i2++;
                String nextLine = scanner.nextLine();
                if (z) {
                    if (nextLine.endsWith("*/")) {
                        break;
                    }
                } else if (nextLine.startsWith("/*")) {
                    z = true;
                } else {
                    int indexOf = nextLine.indexOf("//");
                    String trim = (indexOf >= 0 ? nextLine.substring(0, indexOf) : nextLine).trim();
                    if (trim.length() == 0) {
                        continue;
                    } else if (trim.startsWith(f20893h)) {
                        String trim2 = trim.substring(8).trim();
                        if (trim2.contains(AbstractC1191a.f2568g)) {
                            System.err.println("Warining: malformed import statement: " + nextLine);
                        } else {
                            arrayList.addAll(m24389a(m24390a(trim2), str + "->" + trim2));
                        }
                    } else {
                        String[] split = trim.split("\\s+");
                        if (split.length != 4) {
                            System.err.println("Warning: malformed rule statement split into " + split.length + " parts: " + nextLine);
                        } else {
                            try {
                                arrayList.add(new c(m24402e(split[0]), m24402e(split[1]), m24402e(split[2]), m24397c(m24402e(split[3])), i2, str));
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

    /* renamed from: b */
    public String m24405b() {
        return this.f20896b;
    }

    /* renamed from: c */
    public l m24406c() {
        return this.f20897c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m24401d(CharSequence charSequence, CharSequence charSequence2) {
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

    /* renamed from: d */
    public n m24407d() {
        return this.f20898d;
    }

    /* renamed from: a */
    public n m24403a() {
        return this.f20895a;
    }

    /* renamed from: a */
    public boolean m24404a(CharSequence charSequence, int i2) {
        if (i2 >= 0) {
            int length = this.f20896b.length() + i2;
            if (length > charSequence.length()) {
                return false;
            }
            return charSequence.subSequence(i2, length).equals(this.f20896b) && this.f20898d.mo24408a(charSequence.subSequence(length, charSequence.length())) && this.f20895a.mo24408a(charSequence.subSequence(0, i2));
        }
        throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
    }
}
