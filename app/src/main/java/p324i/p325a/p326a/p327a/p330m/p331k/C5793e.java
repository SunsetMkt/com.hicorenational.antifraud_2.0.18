package p324i.p325a.p326a.p327a.p330m.p331k;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.C3397d;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p324i.p325a.p326a.p327a.p330m.p331k.C5791c;
import p324i.p325a.p326a.p327a.p330m.p331k.C5795g;

/* compiled from: PhoneticEngine.java */
/* renamed from: i.a.a.a.m.k.e */
/* loaded from: classes2.dex */
public class C5793e {

    /* renamed from: e */
    private static final Map<EnumC5792d, Set<String>> f20872e = new EnumMap(EnumC5792d.class);

    /* renamed from: a */
    private final C5790b f20873a;

    /* renamed from: b */
    private final EnumC5792d f20874b;

    /* renamed from: c */
    private final EnumC5796h f20875c;

    /* renamed from: d */
    private final boolean f20876d;

    /* compiled from: PhoneticEngine.java */
    /* renamed from: i.a.a.a.m.k.e$a */
    static class a implements CharSequence {

        /* renamed from: a */
        final /* synthetic */ CharSequence f20877a;

        /* renamed from: b */
        final /* synthetic */ CharSequence[][] f20878b;

        a(CharSequence charSequence, CharSequence[][] charSequenceArr) {
            this.f20877a = charSequence;
            this.f20878b = charSequenceArr;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i2) {
            return this.f20877a.charAt(i2);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.f20877a.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i2, int i3) {
            if (i2 == i3) {
                return "";
            }
            int i4 = i3 - 1;
            CharSequence charSequence = this.f20878b[i2][i4];
            if (charSequence != null) {
                return charSequence;
            }
            CharSequence subSequence = this.f20877a.subSequence(i2, i3);
            this.f20878b[i2][i4] = subSequence;
            return subSequence;
        }
    }

    /* compiled from: PhoneticEngine.java */
    /* renamed from: i.a.a.a.m.k.e$b */
    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f20879a = new int[EnumC5792d.values().length];

        static {
            try {
                f20879a[EnumC5792d.SEPHARDIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20879a[EnumC5792d.ASHKENAZI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20879a[EnumC5792d.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: PhoneticEngine.java */
    /* renamed from: i.a.a.a.m.k.e$c */
    static final class c {

        /* renamed from: a */
        private final Set<C5795g.k> f20880a;

        /* synthetic */ c(Set set, a aVar) {
            this(set);
        }

        /* renamed from: a */
        public static c m24378a(C5791c.c cVar) {
            return new c(Collections.singleton(new C5795g.k("", cVar)));
        }

        /* renamed from: b */
        public String m24382b() {
            StringBuilder sb = new StringBuilder();
            for (C5795g.k kVar : this.f20880a) {
                if (sb.length() > 0) {
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
                sb.append(kVar.m24414c());
            }
            return sb.toString();
        }

        private c(Set<C5795g.k> set) {
            this.f20880a = set;
        }

        /* renamed from: a */
        public c m24380a(CharSequence charSequence) {
            HashSet hashSet = new HashSet();
            Iterator<C5795g.k> it = this.f20880a.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().m24411a(charSequence));
            }
            return new c(hashSet);
        }

        /* renamed from: a */
        public c m24379a(C5795g.l lVar) {
            HashSet hashSet = new HashSet();
            for (C5795g.k kVar : this.f20880a) {
                Iterator<C5795g.k> it = lVar.mo24412a().iterator();
                while (it.hasNext()) {
                    C5795g.k m24410a = kVar.m24410a(it.next());
                    if (!m24410a.m24413b().mo24365b()) {
                        hashSet.add(m24410a);
                    }
                }
            }
            return new c(hashSet);
        }

        /* renamed from: a */
        public Set<C5795g.k> m24381a() {
            return this.f20880a;
        }
    }

    /* compiled from: PhoneticEngine.java */
    /* renamed from: i.a.a.a.m.k.e$d */
    private static final class d {

        /* renamed from: a */
        private final List<C5795g> f20881a;

        /* renamed from: b */
        private final CharSequence f20882b;

        /* renamed from: c */
        private c f20883c;

        /* renamed from: d */
        private int f20884d;

        /* renamed from: e */
        private boolean f20885e;

        public d(List<C5795g> list, CharSequence charSequence, c cVar, int i2) {
            if (list == null) {
                throw new NullPointerException("The finalRules argument must not be null");
            }
            this.f20881a = list;
            this.f20883c = cVar;
            this.f20882b = charSequence;
            this.f20884d = i2;
        }

        /* renamed from: a */
        public int m24383a() {
            return this.f20884d;
        }

        /* renamed from: b */
        public c m24384b() {
            return this.f20883c;
        }

        /* renamed from: c */
        public d m24385c() {
            int i2 = 0;
            this.f20885e = false;
            Iterator<C5795g> it = this.f20881a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C5795g next = it.next();
                int length = next.m24405b().length();
                if (next.m24404a(this.f20882b, this.f20884d)) {
                    this.f20883c = this.f20883c.m24379a(next.m24406c());
                    this.f20885e = true;
                    i2 = length;
                    break;
                }
                i2 = length;
            }
            if (!this.f20885e) {
                i2 = 1;
            }
            this.f20884d += i2;
            return this;
        }

        /* renamed from: d */
        public boolean m24386d() {
            return this.f20885e;
        }
    }

    static {
        f20872e.put(EnumC5792d.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList("bar", "ben", "da", SocializeProtocolConstants.PROTOCOL_KEY_DE, "van", "von"))));
        f20872e.put(EnumC5792d.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("al", "el", "da", "dal", SocializeProtocolConstants.PROTOCOL_KEY_DE, "del", "dela", "de la", "della", "des", "di", "do", "dos", C3397d.f11897W, "van", "von"))));
        f20872e.put(EnumC5792d.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList("da", "dal", SocializeProtocolConstants.PROTOCOL_KEY_DE, "del", "dela", "de la", "della", "des", "di", "do", "dos", C3397d.f11897W, "van", "von"))));
    }

    public C5793e(EnumC5792d enumC5792d, EnumC5796h enumC5796h, boolean z) {
        if (enumC5796h == EnumC5796h.RULES) {
            throw new IllegalArgumentException("ruleType must not be " + EnumC5796h.RULES);
        }
        this.f20874b = enumC5792d;
        this.f20875c = enumC5796h;
        this.f20876d = z;
        this.f20873a = C5790b.m24351a(enumC5792d);
    }

    /* renamed from: a */
    private static CharSequence m24370a(CharSequence charSequence) {
        return new a(charSequence, (CharSequence[][]) Array.newInstance((Class<?>) CharSequence.class, charSequence.length(), charSequence.length()));
    }

    /* renamed from: b */
    public EnumC5792d m24375b() {
        return this.f20874b;
    }

    /* renamed from: c */
    public EnumC5796h m24376c() {
        return this.f20875c;
    }

    /* renamed from: d */
    public boolean m24377d() {
        return this.f20876d;
    }

    /* renamed from: a */
    private static String m24371a(Iterable<String> iterable, String str) {
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

    /* renamed from: a */
    private c m24369a(c cVar, List<C5795g> list) {
        if (list != null) {
            if (list.isEmpty()) {
                return cVar;
            }
            TreeSet treeSet = new TreeSet(C5795g.k.f20914c);
            for (C5795g.k kVar : cVar.m24381a()) {
                c m24378a = c.m24378a(kVar.m24413b());
                CharSequence m24370a = m24370a(kVar.m24414c());
                int i2 = 0;
                while (i2 < m24370a.length()) {
                    d m24385c = new d(list, m24370a, m24378a, i2).m24385c();
                    boolean m24386d = m24385c.m24386d();
                    c m24384b = m24385c.m24384b();
                    c m24380a = !m24386d ? m24384b.m24380a(m24370a.subSequence(i2, i2 + 1)) : m24384b;
                    i2 = m24385c.m24383a();
                    m24378a = m24380a;
                }
                treeSet.addAll(m24378a.m24381a());
            }
            return new c(treeSet, null);
        }
        throw new NullPointerException("finalRules can not be null");
    }

    /* renamed from: a */
    public String m24373a(String str) {
        return m24374a(str, this.f20873a.m24354b(str));
    }

    /* renamed from: a */
    public String m24374a(String str, C5791c.c cVar) {
        String str2;
        List<C5795g> m24388a = C5795g.m24388a(this.f20874b, EnumC5796h.RULES, cVar);
        List<C5795g> m24398c = C5795g.m24398c(this.f20874b, this.f20875c, "common");
        List<C5795g> m24388a2 = C5795g.m24388a(this.f20874b, this.f20875c, cVar);
        String trim = str.toLowerCase(Locale.ENGLISH).replace('-', ' ').trim();
        int i2 = 0;
        if (this.f20874b == EnumC5792d.GENERIC) {
            if (trim.length() >= 2 && trim.substring(0, 2).equals("d'")) {
                String substring = trim.substring(2);
                return "(" + m24373a(substring) + ")-(" + m24373a("d" + substring) + ")";
            }
            for (String str3 : f20872e.get(this.f20874b)) {
                if (trim.startsWith(str3 + AbstractC1191a.f2568g)) {
                    String substring2 = trim.substring(str3.length() + 1);
                    return "(" + m24373a(substring2) + ")-(" + m24373a(str3 + substring2) + ")";
                }
            }
        }
        List asList = Arrays.asList(trim.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList();
        int i3 = b.f20879a[this.f20874b.ordinal()];
        if (i3 == 1) {
            Iterator it = asList.iterator();
            while (it.hasNext()) {
                String[] split = ((String) it.next()).split("'");
                arrayList.add(split[split.length - 1]);
            }
            arrayList.removeAll(f20872e.get(this.f20874b));
        } else if (i3 == 2) {
            arrayList.addAll(asList);
            arrayList.removeAll(f20872e.get(this.f20874b));
        } else if (i3 == 3) {
            arrayList.addAll(asList);
        } else {
            throw new IllegalStateException("Unreachable case: " + this.f20874b);
        }
        if (this.f20876d) {
            str2 = m24371a(arrayList, AbstractC1191a.f2568g);
        } else if (arrayList.size() == 1) {
            str2 = (String) asList.iterator().next();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str4 : arrayList) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(m24373a(str4));
            }
            return sb.substring(1);
        }
        c m24378a = c.m24378a(cVar);
        CharSequence m24370a = m24370a((CharSequence) str2);
        while (i2 < m24370a.length()) {
            d m24385c = new d(m24388a, m24370a, m24378a, i2).m24385c();
            i2 = m24385c.m24383a();
            m24378a = m24385c.m24384b();
        }
        return m24369a(m24369a(m24378a, m24398c), m24388a2).m24382b();
    }

    /* renamed from: a */
    public C5790b m24372a() {
        return this.f20873a;
    }
}
