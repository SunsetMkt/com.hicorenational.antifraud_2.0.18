package i.a.a.a.m.k;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import i.a.a.a.m.k.c;
import i.a.a.a.m.k.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: PhoneticEngine.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: e, reason: collision with root package name */
    private static final Map<i.a.a.a.m.k.d, Set<String>> f16818e = new EnumMap(i.a.a.a.m.k.d.class);

    /* renamed from: a, reason: collision with root package name */
    private final i.a.a.a.m.k.b f16819a;

    /* renamed from: b, reason: collision with root package name */
    private final i.a.a.a.m.k.d f16820b;

    /* renamed from: c, reason: collision with root package name */
    private final h f16821c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f16822d;

    /* compiled from: PhoneticEngine.java */
    static class a implements CharSequence {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f16823a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence[][] f16824b;

        a(CharSequence charSequence, CharSequence[][] charSequenceArr) {
            this.f16823a = charSequence;
            this.f16824b = charSequenceArr;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i2) {
            return this.f16823a.charAt(i2);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.f16823a.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i2, int i3) {
            if (i2 == i3) {
                return "";
            }
            int i4 = i3 - 1;
            CharSequence charSequence = this.f16824b[i2][i4];
            if (charSequence != null) {
                return charSequence;
            }
            CharSequence subSequence = this.f16823a.subSequence(i2, i3);
            this.f16824b[i2][i4] = subSequence;
            return subSequence;
        }
    }

    /* compiled from: PhoneticEngine.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16825a = new int[i.a.a.a.m.k.d.values().length];

        static {
            try {
                f16825a[i.a.a.a.m.k.d.SEPHARDIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16825a[i.a.a.a.m.k.d.ASHKENAZI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16825a[i.a.a.a.m.k.d.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: PhoneticEngine.java */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Set<g.k> f16826a;

        /* synthetic */ c(Set set, a aVar) {
            this(set);
        }

        public static c a(c.AbstractC0254c abstractC0254c) {
            return new c(Collections.singleton(new g.k("", abstractC0254c)));
        }

        public String b() {
            StringBuilder sb = new StringBuilder();
            for (g.k kVar : this.f16826a) {
                if (sb.length() > 0) {
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
                sb.append(kVar.c());
            }
            return sb.toString();
        }

        private c(Set<g.k> set) {
            this.f16826a = set;
        }

        public c a(CharSequence charSequence) {
            HashSet hashSet = new HashSet();
            Iterator<g.k> it = this.f16826a.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().a(charSequence));
            }
            return new c(hashSet);
        }

        public c a(g.l lVar) {
            HashSet hashSet = new HashSet();
            for (g.k kVar : this.f16826a) {
                Iterator<g.k> it = lVar.a().iterator();
                while (it.hasNext()) {
                    g.k a2 = kVar.a(it.next());
                    if (!a2.b().b()) {
                        hashSet.add(a2);
                    }
                }
            }
            return new c(hashSet);
        }

        public Set<g.k> a() {
            return this.f16826a;
        }
    }

    /* compiled from: PhoneticEngine.java */
    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final List<g> f16827a;

        /* renamed from: b, reason: collision with root package name */
        private final CharSequence f16828b;

        /* renamed from: c, reason: collision with root package name */
        private c f16829c;

        /* renamed from: d, reason: collision with root package name */
        private int f16830d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f16831e;

        public d(List<g> list, CharSequence charSequence, c cVar, int i2) {
            if (list == null) {
                throw new NullPointerException("The finalRules argument must not be null");
            }
            this.f16827a = list;
            this.f16829c = cVar;
            this.f16828b = charSequence;
            this.f16830d = i2;
        }

        public int a() {
            return this.f16830d;
        }

        public c b() {
            return this.f16829c;
        }

        public d c() {
            int i2 = 0;
            this.f16831e = false;
            Iterator<g> it = this.f16827a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                int length = next.b().length();
                if (next.a(this.f16828b, this.f16830d)) {
                    this.f16829c = this.f16829c.a(next.c());
                    this.f16831e = true;
                    i2 = length;
                    break;
                }
                i2 = length;
            }
            if (!this.f16831e) {
                i2 = 1;
            }
            this.f16830d += i2;
            return this;
        }

        public boolean d() {
            return this.f16831e;
        }
    }

    static {
        f16818e.put(i.a.a.a.m.k.d.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList("bar", "ben", "da", SocializeProtocolConstants.PROTOCOL_KEY_DE, "van", "von"))));
        f16818e.put(i.a.a.a.m.k.d.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("al", "el", "da", "dal", SocializeProtocolConstants.PROTOCOL_KEY_DE, "del", "dela", "de la", "della", "des", "di", "do", "dos", com.umeng.analytics.pro.d.W, "van", "von"))));
        f16818e.put(i.a.a.a.m.k.d.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("da", "dal", SocializeProtocolConstants.PROTOCOL_KEY_DE, "del", "dela", "de la", "della", "des", "di", "do", "dos", com.umeng.analytics.pro.d.W, "van", "von"))));
    }

    public e(i.a.a.a.m.k.d dVar, h hVar, boolean z) {
        if (hVar == h.RULES) {
            throw new IllegalArgumentException("ruleType must not be " + h.RULES);
        }
        this.f16820b = dVar;
        this.f16821c = hVar;
        this.f16822d = z;
        this.f16819a = i.a.a.a.m.k.b.a(dVar);
    }

    private static CharSequence a(CharSequence charSequence) {
        return new a(charSequence, (CharSequence[][]) Array.newInstance((Class<?>) CharSequence.class, charSequence.length(), charSequence.length()));
    }

    public i.a.a.a.m.k.d b() {
        return this.f16820b;
    }

    public h c() {
        return this.f16821c;
    }

    public boolean d() {
        return this.f16822d;
    }

    private static String a(Iterable<String> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    private c a(c cVar, List<g> list) {
        if (list != null) {
            if (list.isEmpty()) {
                return cVar;
            }
            TreeSet treeSet = new TreeSet(g.k.f16860c);
            for (g.k kVar : cVar.a()) {
                c a2 = c.a(kVar.b());
                CharSequence a3 = a(kVar.c());
                int i2 = 0;
                while (i2 < a3.length()) {
                    d c2 = new d(list, a3, a2, i2).c();
                    boolean d2 = c2.d();
                    c b2 = c2.b();
                    c a4 = !d2 ? b2.a(a3.subSequence(i2, i2 + 1)) : b2;
                    i2 = c2.a();
                    a2 = a4;
                }
                treeSet.addAll(a2.a());
            }
            return new c(treeSet, null);
        }
        throw new NullPointerException("finalRules can not be null");
    }

    public String a(String str) {
        return a(str, this.f16819a.b(str));
    }

    public String a(String str, c.AbstractC0254c abstractC0254c) {
        String str2;
        List<g> a2 = g.a(this.f16820b, h.RULES, abstractC0254c);
        List<g> c2 = g.c(this.f16820b, this.f16821c, "common");
        List<g> a3 = g.a(this.f16820b, this.f16821c, abstractC0254c);
        String trim = str.toLowerCase(Locale.ENGLISH).replace('-', ' ').trim();
        int i2 = 0;
        if (this.f16820b == i.a.a.a.m.k.d.GENERIC) {
            if (trim.length() >= 2 && trim.substring(0, 2).equals("d'")) {
                String substring = trim.substring(2);
                return "(" + a(substring) + ")-(" + a("d" + substring) + ")";
            }
            for (String str3 : f16818e.get(this.f16820b)) {
                if (trim.startsWith(str3 + c.c.a.b.a.a.f3100g)) {
                    String substring2 = trim.substring(str3.length() + 1);
                    return "(" + a(substring2) + ")-(" + a(str3 + substring2) + ")";
                }
            }
        }
        List asList = Arrays.asList(trim.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList();
        int i3 = b.f16825a[this.f16820b.ordinal()];
        if (i3 == 1) {
            Iterator it = asList.iterator();
            while (it.hasNext()) {
                String[] split = ((String) it.next()).split("'");
                arrayList.add(split[split.length - 1]);
            }
            arrayList.removeAll(f16818e.get(this.f16820b));
        } else if (i3 == 2) {
            arrayList.addAll(asList);
            arrayList.removeAll(f16818e.get(this.f16820b));
        } else if (i3 == 3) {
            arrayList.addAll(asList);
        } else {
            throw new IllegalStateException("Unreachable case: " + this.f16820b);
        }
        if (this.f16822d) {
            str2 = a(arrayList, c.c.a.b.a.a.f3100g);
        } else if (arrayList.size() == 1) {
            str2 = (String) asList.iterator().next();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str4 : arrayList) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(a(str4));
            }
            return sb.substring(1);
        }
        c a4 = c.a(abstractC0254c);
        CharSequence a5 = a((CharSequence) str2);
        while (i2 < a5.length()) {
            d c3 = new d(a2, a5, a4, i2).c();
            i2 = c3.a();
            a4 = c3.b();
        }
        return a(a(a4, c2), a3).b();
    }

    public i.a.a.a.m.k.b a() {
        return this.f16819a;
    }
}
