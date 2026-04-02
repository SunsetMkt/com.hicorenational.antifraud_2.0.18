package l.a.a.a.j.f;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: Record.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final SimpleDateFormat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f12679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f12680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f12681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f12682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f12683j;

    /* JADX INFO: compiled from: Record.java */
    public static class b {
        private final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f12685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f12686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f12687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f12688f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f12689g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f12690h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f12691i;

        private b(int i2, String str) {
            this.a = System.currentTimeMillis();
            this.f12684b = Process.myPid();
            this.f12685c = Process.myTid();
            this.f12686d = i2;
            this.f12687e = str;
            this.f12688f = "";
            this.f12689g = 0;
            this.f12691i = "";
        }

        public a a() {
            return new a(this);
        }

        public b a(String str) {
            this.f12690h = str;
            return this;
        }
    }

    private static char a(int i2) {
        if (i2 == 3) {
            return 'D';
        }
        if (i2 == 4) {
            return 'I';
        }
        if (i2 == 5) {
            return 'W';
        }
        if (i2 != 6) {
            return i2 != 7 ? 'V' : 'A';
        }
        return 'E';
    }

    public static b a(int i2, String str) {
        return new b(i2, str);
    }

    public void b(StringBuilder sb) {
        sb.append(this.f12682i);
    }

    public void c(StringBuilder sb) {
        if (this.f12683j != null) {
            sb.append('\n');
            sb.append(this.f12683j);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        sb.append(d.c.a.b.a.a.f10074g);
        b(sb);
        c(sb);
        sb.append("\n");
        return sb.toString();
    }

    private a(b bVar) {
        this.a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        this.f12675b = bVar.a;
        this.f12676c = bVar.f12684b;
        this.f12677d = bVar.f12685c;
        this.f12678e = bVar.f12686d;
        this.f12679f = bVar.f12687e;
        this.f12680g = bVar.f12688f;
        this.f12681h = bVar.f12689g;
        this.f12682i = bVar.f12690h;
        this.f12683j = bVar.f12691i;
    }

    public void a(StringBuilder sb) {
        sb.append("[");
        sb.append(this.a.format(Long.valueOf(this.f12675b)));
        sb.append(d.c.a.b.a.a.f10074g);
        sb.append(a(this.f12678e));
        sb.append("/");
        sb.append(this.f12679f);
        sb.append(d.c.a.b.a.a.f10074g);
        sb.append(this.f12676c);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f12677d);
        sb.append(d.c.a.b.a.a.f10074g);
        sb.append(this.f12680g);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f12681h);
        sb.append("]");
    }
}
