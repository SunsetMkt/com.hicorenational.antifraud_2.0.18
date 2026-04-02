package b.a.q.b;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public enum a {
    Slow("\u5f31\u7f51\u7edc", 1),
    Fast("\u5f3a\u7f51\u7edc", 5);

    private final int code;
    private final String desc;

    a(String str, int i2) {
        this.desc = str;
        this.code = i2;
    }

    public static a valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
