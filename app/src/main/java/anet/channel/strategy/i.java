package anet.channel.strategy;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a()) {
            return;
        }
        this.a.f1599b.c();
    }
}
