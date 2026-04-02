package anet.channel.monitor;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public enum NetworkSpeed {
    Slow("\u5f31\u7f51\u7edc", 1),
    Fast("\u5f3a\u7f51\u7edc", 5);

    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1467b;

    NetworkSpeed(String str, int i2) {
        this.a = str;
        this.f1467b = i2;
    }

    public static NetworkSpeed valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.f1467b;
    }

    public String getDesc() {
        return this.a;
    }
}
