package p324i.p325a.p326a.p327a.p330m.p331k;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import p000a.p001a.p014u.C0052a;
import p324i.p325a.p326a.p327a.p330m.p331k.C5791c;

/* compiled from: Lang.java */
/* renamed from: i.a.a.a.m.k.b */
/* loaded from: classes2.dex */
public class C5790b {

    /* renamed from: c */
    private static final Map<EnumC5792d, C5790b> f20858c = new EnumMap(EnumC5792d.class);

    /* renamed from: d */
    private static final String f20859d = "org/apache/commons/codec/language/bm/lang.txt";

    /* renamed from: a */
    private final C5791c f20860a;

    /* renamed from: b */
    private final List<b> f20861b;

    /* compiled from: Lang.java */
    /* renamed from: i.a.a.a.m.k.b$b */
    private static final class b {

        /* renamed from: a */
        private final boolean f20862a;

        /* renamed from: b */
        private final Set<String> f20863b;

        /* renamed from: c */
        private final Pattern f20864c;

        private b(Pattern pattern, Set<String> set, boolean z) {
            this.f20864c = pattern;
            this.f20863b = set;
            this.f20862a = z;
        }

        /* renamed from: a */
        public boolean m24357a(String str) {
            return this.f20864c.matcher(str).find();
        }
    }

    static {
        for (EnumC5792d enumC5792d : EnumC5792d.values()) {
            f20858c.put(enumC5792d, m24352a(f20859d, C5791c.m24358a(enumC5792d)));
        }
    }

    private C5790b(List<b> list, C5791c c5791c) {
        this.f20861b = Collections.unmodifiableList(list);
        this.f20860a = c5791c;
    }

    /* renamed from: a */
    public static C5790b m24351a(EnumC5792d enumC5792d) {
        return f20858c.get(enumC5792d);
    }

    /* renamed from: b */
    public C5791c.c m24354b(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.f20860a.m24361a());
        for (b bVar : this.f20861b) {
            if (bVar.m24357a(lowerCase)) {
                if (bVar.f20862a) {
                    hashSet.retainAll(bVar.f20863b);
                } else {
                    hashSet.removeAll(bVar.f20863b);
                }
            }
        }
        C5791c.c m24367a = C5791c.c.m24367a(hashSet);
        return m24367a.equals(C5791c.f20867d) ? C5791c.f20868e : m24367a;
    }

    /* renamed from: a */
    public static C5790b m24352a(String str, C5791c c5791c) {
        ArrayList arrayList = new ArrayList();
        InputStream resourceAsStream = C5790b.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/lang.txt");
        }
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
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
                    if (trim.length() != 0) {
                        String[] split = trim.split("\\s+");
                        if (split.length != 3) {
                            System.err.println("Warning: malformed line '" + nextLine + "'");
                        } else {
                            arrayList.add(new b(Pattern.compile(split[0]), new HashSet(Arrays.asList(split[1].split("\\+"))), split[2].equals(C0052a.f158j)));
                        }
                    }
                }
            }
            return new C5790b(arrayList, c5791c);
        }
    }

    /* renamed from: a */
    public String m24353a(String str) {
        C5791c.c m24354b = m24354b(str);
        return m24354b.mo24366c() ? m24354b.mo24363a() : C5791c.f20865b;
    }
}
