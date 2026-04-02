package j.e.b.b.a.a;

/* JADX INFO: loaded from: classes2.dex */
class d {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12568c = System.currentTimeMillis() + 86400000;

    public d(String str, int i2) {
        this.a = str;
        this.f12567b = i2;
    }

    public String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.f12567b + ", expired=" + this.f12568c + '}';
    }
}
