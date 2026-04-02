package d.b.c.y.a;

/* JADX INFO: compiled from: ParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    private final r a;

    protected q(r rVar) {
        this.a = rVar;
    }

    public static void a(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public abstract String a();

    public final r b() {
        return this.a;
    }

    public final String toString() {
        return a();
    }

    public static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                a(str, sb);
            }
        }
    }
}
