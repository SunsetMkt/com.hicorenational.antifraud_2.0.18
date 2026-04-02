package anetwork.channel.entity;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class d implements b.a.g {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1772b;

    public d(String str, String str2) {
        this.a = str;
        this.f1772b = str2;
    }

    @Override // b.a.g
    public String getKey() {
        return this.a;
    }

    @Override // b.a.g
    public String getValue() {
        return this.f1772b;
    }
}
