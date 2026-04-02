package anet.channel;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class j implements Runnable {
    j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            anet.channel.b.a aVar = new anet.channel.b.a();
            aVar.a();
            b.a.j.b.a(aVar, new k(this), 1);
        } catch (Exception unused) {
        }
    }
}
