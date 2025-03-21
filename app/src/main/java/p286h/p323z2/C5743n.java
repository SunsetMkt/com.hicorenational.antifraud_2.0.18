package p286h.p323z2;

import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5240a;
import p286h.p289g2.AbstractC5252d;
import p286h.p289g2.C5262g0;
import p286h.p289g2.C5315y;
import p286h.p304m2.C5432l;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5642k;
import p286h.p321x2.C5707u;
import p286h.p323z2.InterfaceC5742m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Regex.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, m23546d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", SurveyH5Bean.VALUE, "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.z2.n */
/* loaded from: classes2.dex */
final class C5743n implements InterfaceC5742m {

    /* renamed from: a */
    @InterfaceC5816d
    private final InterfaceC5740k f20741a;

    /* renamed from: b */
    private List<String> f20742b;

    /* renamed from: c */
    private final Matcher f20743c;

    /* renamed from: d */
    private final CharSequence f20744d;

    /* compiled from: Regex.kt */
    /* renamed from: h.z2.n$a */
    public static final class a extends AbstractC5252d<String> {
        a() {
        }

        /* renamed from: a */
        public /* bridge */ boolean m24037a(String str) {
            return super.contains(str);
        }

        /* renamed from: b */
        public /* bridge */ int m24038b(String str) {
            return super.indexOf(str);
        }

        /* renamed from: c */
        public /* bridge */ int m24039c(String str) {
            return super.lastIndexOf(str);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return m24037a((String) obj);
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return C5743n.this.m24036e().groupCount() + 1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return m24038b((String) obj);
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return m24039c((String) obj);
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public String get(int i2) {
            String group = C5743n.this.m24036e().group(i2);
            return group != null ? group : "";
        }
    }

    public C5743n(@InterfaceC5816d Matcher matcher, @InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(matcher, "matcher");
        C5544i0.m22546f(charSequence, "input");
        this.f20743c = matcher;
        this.f20744d = charSequence;
        this.f20741a = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public final MatchResult m24036e() {
        return this.f20743c;
    }

    @Override // p286h.p323z2.InterfaceC5742m
    @InterfaceC5816d
    /* renamed from: b */
    public List<String> mo24019b() {
        if (this.f20742b == null) {
            this.f20742b = new a();
        }
        List<String> list = this.f20742b;
        if (list == null) {
            C5544i0.m22545f();
        }
        return list;
    }

    @Override // p286h.p323z2.InterfaceC5742m
    @InterfaceC5816d
    /* renamed from: c */
    public InterfaceC5740k mo24020c() {
        return this.f20741a;
    }

    @Override // p286h.p323z2.InterfaceC5742m
    @InterfaceC5816d
    /* renamed from: d */
    public C5642k mo24021d() {
        C5642k m24053b;
        m24053b = C5745p.m24053b(m24036e());
        return m24053b;
    }

    @Override // p286h.p323z2.InterfaceC5742m
    @InterfaceC5816d
    public String getValue() {
        String group = m24036e().group();
        C5544i0.m22521a((Object) group, "matchResult.group()");
        return group;
    }

    @Override // p286h.p323z2.InterfaceC5742m
    @InterfaceC5817e
    public InterfaceC5742m next() {
        InterfaceC5742m m24055b;
        int end = m24036e().end() + (m24036e().end() == m24036e().start() ? 1 : 0);
        if (end > this.f20744d.length()) {
            return null;
        }
        Matcher matcher = this.f20743c.pattern().matcher(this.f20744d);
        C5544i0.m22521a((Object) matcher, "matcher.pattern().matcher(input)");
        m24055b = C5745p.m24055b(matcher, end, this.f20744d);
        return m24055b;
    }

    @Override // p286h.p323z2.InterfaceC5742m
    @InterfaceC5816d
    /* renamed from: a */
    public InterfaceC5742m.b mo24018a() {
        return InterfaceC5742m.a.m24022a(this);
    }

    /* compiled from: Regex.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m23546d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", CommonNetImpl.NAME, "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: h.z2.n$b */
    public static final class b extends AbstractC5240a<C5739j> implements InterfaceC5741l {

        /* compiled from: Regex.kt */
        /* renamed from: h.z2.n$b$a */
        static final class a extends AbstractC5547j0 implements InterfaceC5506l<Integer, C5739j> {
            a() {
                super(1);
            }

            @Override // p286h.p309q2.p310s.InterfaceC5506l
            public /* bridge */ /* synthetic */ C5739j invoke(Integer num) {
                return invoke(num.intValue());
            }

            @InterfaceC5817e
            public final C5739j invoke(int i2) {
                return b.this.get(i2);
            }
        }

        b() {
        }

        /* renamed from: a */
        public /* bridge */ boolean m24040a(C5739j c5739j) {
            return super.contains(c5739j);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof C5739j : true) {
                return m24040a((C5739j) obj);
            }
            return false;
        }

        @Override // p286h.p323z2.InterfaceC5740k
        @InterfaceC5817e
        public C5739j get(int i2) {
            C5642k m24054b;
            m24054b = C5745p.m24054b(C5743n.this.m24036e(), i2);
            if (m24054b.getStart().intValue() < 0) {
                return null;
            }
            String group = C5743n.this.m24036e().group(i2);
            C5544i0.m22521a((Object) group, "matchResult.group(index)");
            return new C5739j(group, m24054b);
        }

        @Override // p286h.p289g2.AbstractC5240a
        public int getSize() {
            return C5743n.this.m24036e().groupCount() + 1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection, java.lang.Iterable
        @InterfaceC5816d
        public Iterator<C5739j> iterator() {
            C5642k m21766a;
            m21766a = C5315y.m21766a((Collection<?>) this);
            return C5707u.m23502w(C5262g0.m19888i(m21766a), new a()).iterator();
        }

        @Override // p286h.p323z2.InterfaceC5741l
        @InterfaceC5817e
        public C5739j get(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, CommonNetImpl.NAME);
            return C5432l.f20299a.m22177a(C5743n.this.m24036e(), str);
        }
    }
}
