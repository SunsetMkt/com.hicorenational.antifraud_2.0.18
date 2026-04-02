package anetwork.channel.aidl.j;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ byte a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f1751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f1752c;

    h(e eVar, byte b2, Object obj) {
        this.f1752c = eVar;
        this.a = b2;
        this.f1751b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1752c.b(this.a, this.f1751b);
    }
}
