package d.b.c.f0.e;

import d.b.c.f0.c.h;
import d.b.c.f0.c.j;

/* JADX INFO: compiled from: QRCode.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9831f = 8;
    private h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.c.f0.c.f f9832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f9833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9834d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f9835e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public d.b.c.f0.c.f a() {
        return this.f9832b;
    }

    public int b() {
        return this.f9834d;
    }

    public b c() {
        return this.f9835e;
    }

    public h d() {
        return this.a;
    }

    public j e() {
        return this.f9833c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.f9832b);
        sb.append("\n version: ");
        sb.append(this.f9833c);
        sb.append("\n maskPattern: ");
        sb.append(this.f9834d);
        if (this.f9835e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f9835e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(h hVar) {
        this.a = hVar;
    }

    public void a(d.b.c.f0.c.f fVar) {
        this.f9832b = fVar;
    }

    public void a(j jVar) {
        this.f9833c = jVar;
    }

    public void a(int i2) {
        this.f9834d = i2;
    }

    public void a(b bVar) {
        this.f9835e = bVar;
    }
}
