package p286h.p323z2;

import bean.SurveyH5Bean;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5642k;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Regex.kt */
/* renamed from: h.z2.j */
/* loaded from: classes2.dex */
public final class C5739j {

    /* renamed from: a */
    @InterfaceC5816d
    private final String f20738a;

    /* renamed from: b */
    @InterfaceC5816d
    private final C5642k f20739b;

    public C5739j(@InterfaceC5816d String str, @InterfaceC5816d C5642k c5642k) {
        C5544i0.m22546f(str, SurveyH5Bean.VALUE);
        C5544i0.m22546f(c5642k, "range");
        this.f20738a = str;
        this.f20739b = c5642k;
    }

    /* renamed from: a */
    public static /* synthetic */ C5739j m24012a(C5739j c5739j, String str, C5642k c5642k, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c5739j.f20738a;
        }
        if ((i2 & 2) != 0) {
            c5642k = c5739j.f20739b;
        }
        return c5739j.m24013a(str, c5642k);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C5739j m24013a(@InterfaceC5816d String str, @InterfaceC5816d C5642k c5642k) {
        C5544i0.m22546f(str, SurveyH5Bean.VALUE);
        C5544i0.m22546f(c5642k, "range");
        return new C5739j(str, c5642k);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final String m24014a() {
        return this.f20738a;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final C5642k m24015b() {
        return this.f20739b;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final C5642k m24016c() {
        return this.f20739b;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public final String m24017d() {
        return this.f20738a;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5739j)) {
            return false;
        }
        C5739j c5739j = (C5739j) obj;
        return C5544i0.m22531a((Object) this.f20738a, (Object) c5739j.f20738a) && C5544i0.m22531a(this.f20739b, c5739j.f20739b);
    }

    public int hashCode() {
        String str = this.f20738a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        C5642k c5642k = this.f20739b;
        return hashCode + (c5642k != null ? c5642k.hashCode() : 0);
    }

    @InterfaceC5816d
    public String toString() {
        return "MatchGroup(value=" + this.f20738a + ", range=" + this.f20739b + ")";
    }
}
