package p286h.p323z2;

import bean.SurveyH5Bean;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5642k;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: MatchResult.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0000H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, m23546d2 = {"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", SurveyH5Bean.VALUE, "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.z2.m */
/* loaded from: classes2.dex */
public interface InterfaceC5742m {

    /* compiled from: MatchResult.kt */
    /* renamed from: h.z2.m$a */
    public static final class a {
        @InterfaceC5816d
        /* renamed from: a */
        public static b m24022a(InterfaceC5742m interfaceC5742m) {
            return new b(interfaceC5742m);
        }
    }

    /* compiled from: MatchResult.kt */
    /* renamed from: h.z2.m$b */
    public static final class b {

        /* renamed from: a */
        @InterfaceC5816d
        private final InterfaceC5742m f20740a;

        public b(@InterfaceC5816d InterfaceC5742m interfaceC5742m) {
            C5544i0.m22546f(interfaceC5742m, "match");
            this.f20740a = interfaceC5742m;
        }

        @InterfaceC5426f
        /* renamed from: c */
        private final String m24023c() {
            return m24033a().mo24019b().get(1);
        }

        @InterfaceC5426f
        /* renamed from: d */
        private final String m24024d() {
            return m24033a().mo24019b().get(10);
        }

        @InterfaceC5426f
        /* renamed from: e */
        private final String m24025e() {
            return m24033a().mo24019b().get(2);
        }

        @InterfaceC5426f
        /* renamed from: f */
        private final String m24026f() {
            return m24033a().mo24019b().get(3);
        }

        @InterfaceC5426f
        /* renamed from: g */
        private final String m24027g() {
            return m24033a().mo24019b().get(4);
        }

        @InterfaceC5426f
        /* renamed from: h */
        private final String m24028h() {
            return m24033a().mo24019b().get(5);
        }

        @InterfaceC5426f
        /* renamed from: i */
        private final String m24029i() {
            return m24033a().mo24019b().get(6);
        }

        @InterfaceC5426f
        /* renamed from: j */
        private final String m24030j() {
            return m24033a().mo24019b().get(7);
        }

        @InterfaceC5426f
        /* renamed from: k */
        private final String m24031k() {
            return m24033a().mo24019b().get(8);
        }

        @InterfaceC5426f
        /* renamed from: l */
        private final String m24032l() {
            return m24033a().mo24019b().get(9);
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final InterfaceC5742m m24033a() {
            return this.f20740a;
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final List<String> m24034b() {
            return this.f20740a.mo24019b().subList(1, this.f20740a.mo24019b().size());
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    b mo24018a();

    @InterfaceC5816d
    /* renamed from: b */
    List<String> mo24019b();

    @InterfaceC5816d
    /* renamed from: c */
    InterfaceC5740k mo24020c();

    @InterfaceC5816d
    /* renamed from: d */
    C5642k mo24021d();

    @InterfaceC5816d
    String getValue();

    @InterfaceC5817e
    InterfaceC5742m next();
}
