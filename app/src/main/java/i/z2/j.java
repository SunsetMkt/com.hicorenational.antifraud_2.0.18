package i.z2;

import bean.SurveyH5Bean;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    @j.c.a.d
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.d
    private final i.v2.k f12435b;

    public j(@j.c.a.d String str, @j.c.a.d i.v2.k kVar) {
        i.q2.t.i0.f(str, SurveyH5Bean.VALUE);
        i.q2.t.i0.f(kVar, "range");
        this.a = str;
        this.f12435b = kVar;
    }

    public static /* synthetic */ j a(j jVar, String str, i.v2.k kVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = jVar.a;
        }
        if ((i2 & 2) != 0) {
            kVar = jVar.f12435b;
        }
        return jVar.a(str, kVar);
    }

    @j.c.a.d
    public final j a(@j.c.a.d String str, @j.c.a.d i.v2.k kVar) {
        i.q2.t.i0.f(str, SurveyH5Bean.VALUE);
        i.q2.t.i0.f(kVar, "range");
        return new j(str, kVar);
    }

    @j.c.a.d
    public final String a() {
        return this.a;
    }

    @j.c.a.d
    public final i.v2.k b() {
        return this.f12435b;
    }

    @j.c.a.d
    public final i.v2.k c() {
        return this.f12435b;
    }

    @j.c.a.d
    public final String d() {
        return this.a;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return i.q2.t.i0.a((Object) this.a, (Object) jVar.a) && i.q2.t.i0.a(this.f12435b, jVar.f12435b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        i.v2.k kVar = this.f12435b;
        return iHashCode + (kVar != null ? kVar.hashCode() : 0);
    }

    @j.c.a.d
    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.f12435b + ")";
    }
}
