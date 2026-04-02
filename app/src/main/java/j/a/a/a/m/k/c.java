package j.a.a.a.m.k;

import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/* JADX INFO: compiled from: Languages.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12502b = "any";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<j.a.a.a.m.k.d, c> f12503c = new EnumMap(j.a.a.a.m.k.d.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC0255c f12504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC0255c f12505e;
    private final Set<String> a;

    /* JADX INFO: compiled from: Languages.java */
    static class a extends AbstractC0255c {
        a() {
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public AbstractC0255c a(AbstractC0255c abstractC0255c) {
            return this;
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public String a() {
            throw new NoSuchElementException("Can't fetch any language from the empty language set.");
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean a(String str) {
            return false;
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean b() {
            return true;
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean c() {
            return false;
        }

        public String toString() {
            return "NO_LANGUAGES";
        }
    }

    /* JADX INFO: compiled from: Languages.java */
    static class b extends AbstractC0255c {
        b() {
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public AbstractC0255c a(AbstractC0255c abstractC0255c) {
            return abstractC0255c;
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public String a() {
            throw new NoSuchElementException("Can't fetch any language from the any language set.");
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean a(String str) {
            return true;
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean b() {
            return false;
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean c() {
            return false;
        }

        public String toString() {
            return "ANY_LANGUAGE";
        }
    }

    /* JADX INFO: renamed from: j.a.a.a.m.k.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Languages.java */
    public static abstract class AbstractC0255c {
        public static AbstractC0255c a(Set<String> set) {
            return set.isEmpty() ? c.f12504d : new d(set, null);
        }

        public abstract AbstractC0255c a(AbstractC0255c abstractC0255c);

        public abstract String a();

        public abstract boolean a(String str);

        public abstract boolean b();

        public abstract boolean c();
    }

    /* JADX INFO: compiled from: Languages.java */
    public static final class d extends AbstractC0255c {
        private final Set<String> a;

        /* synthetic */ d(Set set, a aVar) {
            this(set);
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean a(String str) {
            return this.a.contains(str);
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean b() {
            return this.a.isEmpty();
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public boolean c() {
            return this.a.size() == 1;
        }

        public Set<String> d() {
            return this.a;
        }

        public String toString() {
            return "Languages(" + this.a.toString() + ")";
        }

        private d(Set<String> set) {
            this.a = Collections.unmodifiableSet(set);
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public String a() {
            return this.a.iterator().next();
        }

        @Override // j.a.a.a.m.k.c.AbstractC0255c
        public AbstractC0255c a(AbstractC0255c abstractC0255c) {
            if (abstractC0255c == c.f12504d) {
                return abstractC0255c;
            }
            if (abstractC0255c == c.f12505e) {
                return this;
            }
            d dVar = (d) abstractC0255c;
            if (dVar.a.containsAll(this.a)) {
                return this;
            }
            HashSet hashSet = new HashSet(this.a);
            hashSet.retainAll(dVar.a);
            return AbstractC0255c.a(hashSet);
        }
    }

    static {
        for (j.a.a.a.m.k.d dVar : j.a.a.a.m.k.d.values()) {
            f12503c.put(dVar, a(b(dVar)));
        }
        f12504d = new a();
        f12505e = new b();
    }

    private c(Set<String> set) {
        this.a = set;
    }

    public static c a(j.a.a.a.m.k.d dVar) {
        return f12503c.get(dVar);
    }

    private static String b(j.a.a.a.m.k.d dVar) {
        return String.format("org/apache/commons/codec/language/bm/%s_languages.txt", dVar.getName());
    }

    public static c a(String str) {
        HashSet hashSet = new HashSet();
        InputStream resourceAsStream = c.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalArgumentException("Unable to resolve required resource: " + str);
        }
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                String strTrim = scanner.nextLine().trim();
                if (z) {
                    if (strTrim.endsWith("*/")) {
                        break;
                    }
                } else if (strTrim.startsWith("/*")) {
                    z = true;
                } else if (strTrim.length() > 0) {
                    hashSet.add(strTrim);
                }
            }
            return new c(Collections.unmodifiableSet(hashSet));
        }
    }

    public Set<String> a() {
        return this.a;
    }
}
