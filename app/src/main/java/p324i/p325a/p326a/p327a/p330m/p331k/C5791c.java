package p324i.p325a.p326a.p327a.p330m.p331k;

import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/* compiled from: Languages.java */
/* renamed from: i.a.a.a.m.k.c */
/* loaded from: classes2.dex */
public class C5791c {

    /* renamed from: b */
    public static final String f20865b = "any";

    /* renamed from: c */
    private static final Map<EnumC5792d, C5791c> f20866c = new EnumMap(EnumC5792d.class);

    /* renamed from: d */
    public static final c f20867d;

    /* renamed from: e */
    public static final c f20868e;

    /* renamed from: a */
    private final Set<String> f20869a;

    /* compiled from: Languages.java */
    /* renamed from: i.a.a.a.m.k.c$a */
    static class a extends c {
        a() {
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public c mo24362a(c cVar) {
            return this;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public String mo24363a() {
            throw new NoSuchElementException("Can't fetch any language from the empty language set.");
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public boolean mo24364a(String str) {
            return false;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: b */
        public boolean mo24365b() {
            return true;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: c */
        public boolean mo24366c() {
            return false;
        }

        public String toString() {
            return "NO_LANGUAGES";
        }
    }

    /* compiled from: Languages.java */
    /* renamed from: i.a.a.a.m.k.c$b */
    static class b extends c {
        b() {
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public c mo24362a(c cVar) {
            return cVar;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public String mo24363a() {
            throw new NoSuchElementException("Can't fetch any language from the any language set.");
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public boolean mo24364a(String str) {
            return true;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: b */
        public boolean mo24365b() {
            return false;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: c */
        public boolean mo24366c() {
            return false;
        }

        public String toString() {
            return "ANY_LANGUAGE";
        }
    }

    /* compiled from: Languages.java */
    /* renamed from: i.a.a.a.m.k.c$c */
    public static abstract class c {
        /* renamed from: a */
        public static c m24367a(Set<String> set) {
            return set.isEmpty() ? C5791c.f20867d : new d(set, null);
        }

        /* renamed from: a */
        public abstract c mo24362a(c cVar);

        /* renamed from: a */
        public abstract String mo24363a();

        /* renamed from: a */
        public abstract boolean mo24364a(String str);

        /* renamed from: b */
        public abstract boolean mo24365b();

        /* renamed from: c */
        public abstract boolean mo24366c();
    }

    /* compiled from: Languages.java */
    /* renamed from: i.a.a.a.m.k.c$d */
    public static final class d extends c {

        /* renamed from: a */
        private final Set<String> f20870a;

        /* synthetic */ d(Set set, a aVar) {
            this(set);
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public boolean mo24364a(String str) {
            return this.f20870a.contains(str);
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: b */
        public boolean mo24365b() {
            return this.f20870a.isEmpty();
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: c */
        public boolean mo24366c() {
            return this.f20870a.size() == 1;
        }

        /* renamed from: d */
        public Set<String> m24368d() {
            return this.f20870a;
        }

        public String toString() {
            return "Languages(" + this.f20870a.toString() + ")";
        }

        private d(Set<String> set) {
            this.f20870a = Collections.unmodifiableSet(set);
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public String mo24363a() {
            return this.f20870a.iterator().next();
        }

        @Override // p324i.p325a.p326a.p327a.p330m.p331k.C5791c.c
        /* renamed from: a */
        public c mo24362a(c cVar) {
            if (cVar == C5791c.f20867d) {
                return cVar;
            }
            if (cVar == C5791c.f20868e) {
                return this;
            }
            d dVar = (d) cVar;
            if (dVar.f20870a.containsAll(this.f20870a)) {
                return this;
            }
            HashSet hashSet = new HashSet(this.f20870a);
            hashSet.retainAll(dVar.f20870a);
            return c.m24367a(hashSet);
        }
    }

    static {
        for (EnumC5792d enumC5792d : EnumC5792d.values()) {
            f20866c.put(enumC5792d, m24359a(m24360b(enumC5792d)));
        }
        f20867d = new a();
        f20868e = new b();
    }

    private C5791c(Set<String> set) {
        this.f20869a = set;
    }

    /* renamed from: a */
    public static C5791c m24358a(EnumC5792d enumC5792d) {
        return f20866c.get(enumC5792d);
    }

    /* renamed from: b */
    private static String m24360b(EnumC5792d enumC5792d) {
        return String.format("org/apache/commons/codec/language/bm/%s_languages.txt", enumC5792d.getName());
    }

    /* renamed from: a */
    public static C5791c m24359a(String str) {
        HashSet hashSet = new HashSet();
        InputStream resourceAsStream = C5791c.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalArgumentException("Unable to resolve required resource: " + str);
        }
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                String trim = scanner.nextLine().trim();
                if (z) {
                    if (trim.endsWith("*/")) {
                        break;
                    }
                } else if (trim.startsWith("/*")) {
                    z = true;
                } else if (trim.length() > 0) {
                    hashSet.add(trim);
                }
            }
            return new C5791c(Collections.unmodifiableSet(hashSet));
        }
    }

    /* renamed from: a */
    public Set<String> m24361a() {
        return this.f20869a;
    }
}
