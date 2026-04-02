package d.c.a.b.b;

/* JADX INFO: compiled from: IntentType.java */
/* JADX INFO: loaded from: classes.dex */
public enum d {
    REAL_NAME_VERIFY(d.c.a.b.a.a.K0, c.REAL_NAME_VERIFY),
    BIND_MOBILE_PHONE("BindMobilePhoneIntent", c.BIND_MOBILE_PHONE),
    BIND_EMAIL("BindEmailIntent", c.BIND_EMAIL);

    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f10085b;

    d(String str, c cVar) {
        this.a = str;
        this.f10085b = cVar;
    }

    public c getFeatureType() {
        return this.f10085b;
    }

    public String getType() {
        return this.a;
    }
}
