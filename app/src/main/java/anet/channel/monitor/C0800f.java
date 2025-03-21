package anet.channel.monitor;

/* compiled from: Taobao */
/* renamed from: anet.channel.monitor.f */
/* loaded from: classes.dex */
public class C0800f {

    /* renamed from: b */
    protected long f913b;

    /* renamed from: c */
    private final double f914c = 40.0d;

    /* renamed from: a */
    boolean f912a = false;

    /* renamed from: d */
    private boolean f915d = true;

    /* renamed from: a */
    public int m538a() {
        return 0;
    }

    /* renamed from: a */
    public boolean m539a(double d2) {
        return d2 < 40.0d;
    }

    /* renamed from: b */
    protected final boolean m540b() {
        if (!this.f915d) {
            return false;
        }
        if (System.currentTimeMillis() - this.f913b <= m538a() * 1000) {
            return true;
        }
        this.f915d = false;
        return false;
    }
}
