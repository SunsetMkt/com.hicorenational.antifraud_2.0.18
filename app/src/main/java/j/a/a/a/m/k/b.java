package j.a.a.a.m.k;

import j.a.a.a.m.k.c;
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

/* JADX INFO: compiled from: Lang.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<d, b> f12497c = new EnumMap(d.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12498d = "org/apache/commons/codec/language/bm/lang.txt";
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<C0254b> f12499b;

    /* JADX INFO: renamed from: j.a.a.a.m.k.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Lang.java */
    private static final class C0254b {
        private final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f12500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Pattern f12501c;

        private C0254b(Pattern pattern, Set<String> set, boolean z) {
            this.f12501c = pattern;
            this.f12500b = set;
            this.a = z;
        }

        public boolean a(String str) {
            return this.f12501c.matcher(str).find();
        }
    }

    static {
        for (d dVar : d.values()) {
            f12497c.put(dVar, a(f12498d, c.a(dVar)));
        }
    }

    private b(List<C0254b> list, c cVar) {
        this.f12499b = Collections.unmodifiableList(list);
        this.a = cVar;
    }

    public static b a(d dVar) {
        return f12497c.get(dVar);
    }

    public c.AbstractC0255c b(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.a.a());
        for (C0254b c0254b : this.f12499b) {
            if (c0254b.a(lowerCase)) {
                if (c0254b.a) {
                    hashSet.retainAll(c0254b.f12500b);
                } else {
                    hashSet.removeAll(c0254b.f12500b);
                }
            }
        }
        c.AbstractC0255c abstractC0255cA = c.AbstractC0255c.a(hashSet);
        return abstractC0255cA.equals(c.f12504d) ? c.f12505e : abstractC0255cA;
    }

    public static b a(String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        InputStream resourceAsStream = b.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/lang.txt");
        }
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
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
                    if (strTrim.length() != 0) {
                        String[] strArrSplit = strTrim.split("\\s+");
                        if (strArrSplit.length != 3) {
                            System.err.println("Warning: malformed line '" + strNextLine + "'");
                        } else {
                            arrayList.add(new C0254b(Pattern.compile(strArrSplit[0]), new HashSet(Arrays.asList(strArrSplit[1].split("\\+"))), strArrSplit[2].equals(b.a.u.a.f1908j)));
                        }
                    }
                }
            }
            return new b(arrayList, cVar);
        }
    }

    public String a(String str) {
        c.AbstractC0255c abstractC0255cB = b(str);
        return abstractC0255cB.c() ? abstractC0255cB.a() : c.f12502b;
    }
}
