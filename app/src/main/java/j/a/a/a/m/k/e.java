package j.a.a.a.m.k;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import j.a.a.a.m.k.c;
import j.a.a.a.m.k.g;
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

/* JADX INFO: compiled from: PhoneticEngine.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<j.a.a.a.m.k.d, Set<String>> f12506e = new EnumMap(j.a.a.a.m.k.d.class);
    private final j.a.a.a.m.k.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j.a.a.a.m.k.d f12507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f12508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f12509d;

    /* JADX INFO: compiled from: PhoneticEngine.java */
    static class a implements CharSequence {
        final /* synthetic */ CharSequence a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence[][] f12510b;

        a(CharSequence charSequence, CharSequence[][] charSequenceArr) {
            this.a = charSequence;
            this.f12510b = charSequenceArr;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i2) {
            return this.a.charAt(i2);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.a.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i2, int i3) {
            if (i2 == i3) {
                return "";
            }
            int i4 = i3 - 1;
            CharSequence charSequence = this.f12510b[i2][i4];
            if (charSequence != null) {
                return charSequence;
            }
            CharSequence charSequenceSubSequence = this.a.subSequence(i2, i3);
            this.f12510b[i2][i4] = charSequenceSubSequence;
            return charSequenceSubSequence;
        }
    }

    /* JADX INFO: compiled from: PhoneticEngine.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a = new int[j.a.a.a.m.k.d.values().length];

        static {
            try {
                a[j.a.a.a.m.k.d.SEPHARDIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.a.a.a.m.k.d.ASHKENAZI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j.a.a.a.m.k.d.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: PhoneticEngine.java */
    static final class c {
        private final Set<g.k> a;

        /* synthetic */ c(Set set, a aVar) {
            this(set);
        }

        public static c a(c.AbstractC0255c abstractC0255c) {
            return new c(Collections.singleton(new g.k("", abstractC0255c)));
        }

        public String b() {
            StringBuilder sb = new StringBuilder();
            for (g.k kVar : this.a) {
                if (sb.length() > 0) {
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
                sb.append(kVar.c());
            }
            return sb.toString();
        }

        private c(Set<g.k> set) {
            this.a = set;
        }

        public c a(CharSequence charSequence) {
            HashSet hashSet = new HashSet();
            Iterator<g.k> it = this.a.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().a(charSequence));
            }
            return new c(hashSet);
        }

        public c a(g.l lVar) {
            HashSet hashSet = new HashSet();
            for (g.k kVar : this.a) {
                Iterator<g.k> it = lVar.a().iterator();
                while (it.hasNext()) {
                    g.k kVarA = kVar.a(it.next());
                    if (!kVarA.b().b()) {
                        hashSet.add(kVarA);
                    }
                }
            }
            return new c(hashSet);
        }

        public Set<g.k> a() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: PhoneticEngine.java */
    private static final class d {
        private final List<g> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f12511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private c f12512c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f12513d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f12514e;

        public d(List<g> list, CharSequence charSequence, c cVar, int i2) {
            if (list == null) {
                throw new NullPointerException("The finalRules argument must not be null");
            }
            this.a = list;
            this.f12512c = cVar;
            this.f12511b = charSequence;
            this.f12513d = i2;
        }

        public int a() {
            return this.f12513d;
        }

        public c b() {
            return this.f12512c;
        }

        public d c() {
            int i2 = 0;
            this.f12514e = false;
            Iterator<g> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                int length = next.b().length();
                if (next.a(this.f12511b, this.f12513d)) {
                    this.f12512c = this.f12512c.a(next.c());
                    this.f12514e = true;
                    i2 = length;
                    break;
                }
                i2 = length;
            }
            if (!this.f12514e) {
                i2 = 1;
            }
            this.f12513d += i2;
            return this;
        }

        public boolean d() {
            return this.f12514e;
        }
    }

    static {
        f12506e.put(j.a.a.a.m.k.d.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList("bar", "ben", "da", SocializeProtocolConstants.PROTOCOL_KEY_DE, "van", "von"))));
        f12506e.put(j.a.a.a.m.k.d.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("al", "el", "da", "dal", SocializeProtocolConstants.PROTOCOL_KEY_DE, "del", "dela", "de la", "della", "des", "di", "do", "dos", com.umeng.analytics.pro.d.W, "van", "von"))));
        f12506e.put(j.a.a.a.m.k.d.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("da", "dal", SocializeProtocolConstants.PROTOCOL_KEY_DE, "del", "dela", "de la", "della", "des", "di", "do", "dos", com.umeng.analytics.pro.d.W, "van", "von"))));
    }

    public e(j.a.a.a.m.k.d dVar, h hVar, boolean z) {
        if (hVar == h.RULES) {
            throw new IllegalArgumentException("ruleType must not be " + h.RULES);
        }
        this.f12507b = dVar;
        this.f12508c = hVar;
        this.f12509d = z;
        this.a = j.a.a.a.m.k.b.a(dVar);
    }

    private static CharSequence a(CharSequence charSequence) {
        return new a(charSequence, (CharSequence[][]) Array.newInstance((Class<?>) CharSequence.class, charSequence.length(), charSequence.length()));
    }

    public j.a.a.a.m.k.d b() {
        return this.f12507b;
    }

    public h c() {
        return this.f12508c;
    }

    public boolean d() {
        return this.f12509d;
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
            TreeSet treeSet = new TreeSet(g.k.f12534c);
            for (g.k kVar : cVar.a()) {
                c cVarA = c.a(kVar.b());
                CharSequence charSequenceA = a(kVar.c());
                int iA = 0;
                while (iA < charSequenceA.length()) {
                    d dVarC = new d(list, charSequenceA, cVarA, iA).c();
                    boolean zD = dVarC.d();
                    c cVarB = dVarC.b();
                    c cVarA2 = !zD ? cVarB.a(charSequenceA.subSequence(iA, iA + 1)) : cVarB;
                    iA = dVarC.a();
                    cVarA = cVarA2;
                }
                treeSet.addAll(cVarA.a());
            }
            return new c(treeSet, null);
        }
        throw new NullPointerException("finalRules can not be null");
    }

    public String a(String str) {
        return a(str, this.a.b(str));
    }

    public String a(String str, c.AbstractC0255c abstractC0255c) {
        String strA;
        List<g> listA = g.a(this.f12507b, h.RULES, abstractC0255c);
        List<g> listC = g.c(this.f12507b, this.f12508c, "common");
        List<g> listA2 = g.a(this.f12507b, this.f12508c, abstractC0255c);
        String strTrim = str.toLowerCase(Locale.ENGLISH).replace('-', ' ').trim();
        int iA = 0;
        if (this.f12507b == j.a.a.a.m.k.d.GENERIC) {
            if (strTrim.length() >= 2 && strTrim.substring(0, 2).equals("d'")) {
                String strSubstring = strTrim.substring(2);
                return "(" + a(strSubstring) + ")-(" + a("d" + strSubstring) + ")";
            }
            for (String str2 : f12506e.get(this.f12507b)) {
                if (strTrim.startsWith(str2 + d.c.a.b.a.a.f10074g)) {
                    String strSubstring2 = strTrim.substring(str2.length() + 1);
                    return "(" + a(strSubstring2) + ")-(" + a(str2 + strSubstring2) + ")";
                }
            }
        }
        List listAsList = Arrays.asList(strTrim.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList();
        int i2 = b.a[this.f12507b.ordinal()];
        if (i2 == 1) {
            Iterator it = listAsList.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = ((String) it.next()).split("'");
                arrayList.add(strArrSplit[strArrSplit.length - 1]);
            }
            arrayList.removeAll(f12506e.get(this.f12507b));
        } else if (i2 == 2) {
            arrayList.addAll(listAsList);
            arrayList.removeAll(f12506e.get(this.f12507b));
        } else if (i2 == 3) {
            arrayList.addAll(listAsList);
        } else {
            throw new IllegalStateException("Unreachable case: " + this.f12507b);
        }
        if (this.f12509d) {
            strA = a(arrayList, d.c.a.b.a.a.f10074g);
        } else if (arrayList.size() == 1) {
            strA = (String) listAsList.iterator().next();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str3 : arrayList) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(a(str3));
            }
            return sb.substring(1);
        }
        c cVarA = c.a(abstractC0255c);
        CharSequence charSequenceA = a((CharSequence) strA);
        while (iA < charSequenceA.length()) {
            d dVarC = new d(listA, charSequenceA, cVarA, iA).c();
            iA = dVarC.a();
            cVarA = dVarC.b();
        }
        return a(a(cVarA, listC), listA2).b();
    }

    public j.a.a.a.m.k.b a() {
        return this.a;
    }
}
