package d.c.a.b.b;

/* JADX INFO: compiled from: FeatureType.java */
/* JADX INFO: loaded from: classes.dex */
public enum c {
    REAL_NAME_VERIFY(a.a),
    BIND_MOBILE_PHONE(a.a),
    BIND_EMAIL(a.a);

    private final String a;

    c(String str) {
        this.a = str;
    }

    public String getType() {
        return this.a;
    }
}
