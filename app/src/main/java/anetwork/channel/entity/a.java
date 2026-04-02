package anetwork.channel.entity;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.a.a {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1758b;

    public a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.f1758b = str2;
    }

    @Override // b.a.a
    public String getName() {
        return this.a;
    }

    @Override // b.a.a
    public String getValue() {
        return this.f1758b;
    }
}
