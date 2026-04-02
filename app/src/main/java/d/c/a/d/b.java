package d.c.a.d;

import java.util.Iterator;

/* JADX INFO: compiled from: CancellationTokenSource.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private com.hihonor.cloudservice.tasks.q.a a = new com.hihonor.cloudservice.tasks.q.a();

    public void a() {
        com.hihonor.cloudservice.tasks.q.a aVar = this.a;
        if (aVar.f4068c) {
            return;
        }
        synchronized (aVar.f4067b) {
            aVar.f4068c = true;
            Iterator<Runnable> it = aVar.a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public a b() {
        return this.a;
    }
}
