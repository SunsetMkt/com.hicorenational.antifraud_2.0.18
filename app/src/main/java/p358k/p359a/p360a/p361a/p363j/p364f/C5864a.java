package p358k.p359a.p360a.p361a.p363j.p364f;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Record.java */
/* renamed from: k.a.a.a.j.f.a */
/* loaded from: classes2.dex */
public class C5864a {

    /* renamed from: a */
    private final SimpleDateFormat f21151a;

    /* renamed from: b */
    private final long f21152b;

    /* renamed from: c */
    private final long f21153c;

    /* renamed from: d */
    private final long f21154d;

    /* renamed from: e */
    private final int f21155e;

    /* renamed from: f */
    private final String f21156f;

    /* renamed from: g */
    private final String f21157g;

    /* renamed from: h */
    private final int f21158h;

    /* renamed from: i */
    private final String f21159i;

    /* renamed from: j */
    private final String f21160j;

    /* compiled from: Record.java */
    /* renamed from: k.a.a.a.j.f.a$b */
    public static class b {

        /* renamed from: a */
        private final long f21161a;

        /* renamed from: b */
        private final long f21162b;

        /* renamed from: c */
        private final long f21163c;

        /* renamed from: d */
        private final int f21164d;

        /* renamed from: e */
        private final String f21165e;

        /* renamed from: f */
        private String f21166f;

        /* renamed from: g */
        private int f21167g;

        /* renamed from: h */
        private String f21168h;

        /* renamed from: i */
        private String f21169i;

        private b(int i2, String str) {
            this.f21161a = System.currentTimeMillis();
            this.f21162b = Process.myPid();
            this.f21163c = Process.myTid();
            this.f21164d = i2;
            this.f21165e = str;
            this.f21166f = "";
            this.f21167g = 0;
            this.f21169i = "";
        }

        /* renamed from: a */
        public C5864a m24710a() {
            return new C5864a(this);
        }

        /* renamed from: a */
        public b m24709a(String str) {
            this.f21168h = str;
            return this;
        }
    }

    /* renamed from: a */
    private static char m24695a(int i2) {
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

    /* renamed from: a */
    public static b m24696a(int i2, String str) {
        return new b(i2, str);
    }

    /* renamed from: b */
    public void m24698b(StringBuilder sb) {
        sb.append(this.f21159i);
    }

    /* renamed from: c */
    public void m24699c(StringBuilder sb) {
        if (this.f21160j != null) {
            sb.append('\n');
            sb.append(this.f21160j);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        m24697a(sb);
        sb.append(AbstractC1191a.f2568g);
        m24698b(sb);
        m24699c(sb);
        sb.append("\n");
        return sb.toString();
    }

    private C5864a(b bVar) {
        this.f21151a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        this.f21152b = bVar.f21161a;
        this.f21153c = bVar.f21162b;
        this.f21154d = bVar.f21163c;
        this.f21155e = bVar.f21164d;
        this.f21156f = bVar.f21165e;
        this.f21157g = bVar.f21166f;
        this.f21158h = bVar.f21167g;
        this.f21159i = bVar.f21168h;
        this.f21160j = bVar.f21169i;
    }

    /* renamed from: a */
    public void m24697a(StringBuilder sb) {
        sb.append("[");
        sb.append(this.f21151a.format(Long.valueOf(this.f21152b)));
        sb.append(AbstractC1191a.f2568g);
        sb.append(m24695a(this.f21155e));
        sb.append("/");
        sb.append(this.f21156f);
        sb.append(AbstractC1191a.f2568g);
        sb.append(this.f21153c);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f21154d);
        sb.append(AbstractC1191a.f2568g);
        sb.append(this.f21157g);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f21158h);
        sb.append("]");
    }
}
