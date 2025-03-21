package anet.channel.monitor;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);


    /* renamed from: a */
    private final String f876a;

    /* renamed from: b */
    private final int f877b;

    NetworkSpeed(String str, int i2) {
        this.f876a = str;
        this.f877b = i2;
    }

    public static NetworkSpeed valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.f877b;
    }

    public String getDesc() {
        return this.f876a;
    }
}
