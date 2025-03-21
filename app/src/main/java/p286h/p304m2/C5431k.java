package p286h.p304m2;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.p311t.C5544i0;
import p286h.p318u2.AbstractC5625f;
import p286h.p318u2.C5621b;
import p286h.p323z2.C5739j;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: PlatformImplementations.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, m23546d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", CommonNetImpl.NAME, "", "ReflectAddSuppressedMethod", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.m2.k */
/* loaded from: classes2.dex */
public class C5431k {

    /* compiled from: PlatformImplementations.kt */
    /* renamed from: h.m2.k$a */
    private static final class a {

        /* renamed from: a */
        @InterfaceC5479c
        @InterfaceC5817e
        public static final Method f20297a;

        /* renamed from: b */
        public static final a f20298b = new a();

        /* JADX WARN: Removed duplicated region for block: B:10:0x0049 A[EDGE_INSN: B:10:0x0049->B:11:0x0049 BREAK  A[LOOP:0: B:2:0x0015->B:9:0x0045], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0045 A[LOOP:0: B:2:0x0015->B:9:0x0045, LOOP_END] */
        static {
            /*
                h.m2.k$a r0 = new h.m2.k$a
                r0.<init>()
                p286h.p304m2.C5431k.a.f20298b = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableClass.methods"
                p286h.p309q2.p311t.C5544i0.m22521a(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                if (r4 >= r2) goto L48
                r5 = r1[r4]
                java.lang.String r6 = "it"
                p286h.p309q2.p311t.C5544i0.m22521a(r5, r6)
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = p286h.p309q2.p311t.C5544i0.m22531a(r6, r7)
                if (r6 == 0) goto L41
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                p286h.p309q2.p311t.C5544i0.m22521a(r6, r7)
                java.lang.Object r6 = p286h.p289g2.C5282n.m20042H(r6)
                java.lang.Class r6 = (java.lang.Class) r6
                boolean r6 = p286h.p309q2.p311t.C5544i0.m22531a(r6, r0)
                if (r6 == 0) goto L41
                r6 = 1
                goto L42
            L41:
                r6 = 0
            L42:
                if (r6 == 0) goto L45
                goto L49
            L45:
                int r4 = r4 + 1
                goto L15
            L48:
                r5 = 0
            L49:
                p286h.p304m2.C5431k.a.f20297a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p286h.p304m2.C5431k.a.<clinit>():void");
        }

        private a() {
        }
    }

    /* renamed from: a */
    public void mo22178a(@InterfaceC5816d Throwable th, @InterfaceC5816d Throwable th2) {
        C5544i0.m22546f(th, "cause");
        C5544i0.m22546f(th2, "exception");
        Method method = a.f20297a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    @InterfaceC5817e
    /* renamed from: a */
    public C5739j m22177a(@InterfaceC5816d MatchResult matchResult, @InterfaceC5816d String str) {
        C5544i0.m22546f(matchResult, "matchResult");
        C5544i0.m22546f(str, CommonNetImpl.NAME);
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @InterfaceC5816d
    /* renamed from: a */
    public AbstractC5625f m22176a() {
        return new C5621b();
    }
}
