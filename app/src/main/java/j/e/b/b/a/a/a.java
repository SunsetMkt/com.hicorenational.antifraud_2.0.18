package j.e.b.b.a.a;

/* JADX INFO: loaded from: classes2.dex */
class a {
    long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f12562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12564d;

    a(String str) {
        this.f12563c = str;
    }

    void a(int i2) {
        this.f12564d = i2;
    }

    void a(long j2) {
        this.a = j2;
    }

    void a(String str) {
        this.f12562b = str;
    }

    boolean a() {
        return this.a > System.currentTimeMillis();
    }

    void b() {
        this.a = 0L;
    }
}
