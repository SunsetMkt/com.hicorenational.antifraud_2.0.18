package p000a.p001a.p009q.p010b;

/* compiled from: Taobao */
/* renamed from: a.a.q.b.a */
/* loaded from: classes.dex */
public enum EnumC0030a {
    Slow("弱网络", 1),
    Fast("强网络", 5);

    private final int code;
    private final String desc;

    EnumC0030a(String str, int i2) {
        this.desc = str;
        this.code = i2;
    }

    public static EnumC0030a valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
