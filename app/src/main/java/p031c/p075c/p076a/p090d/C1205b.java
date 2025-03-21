package p031c.p075c.p076a.p090d;

import com.hihonor.cloudservice.tasks.p161q.C2140a;
import java.util.Iterator;

/* compiled from: CancellationTokenSource.java */
/* renamed from: c.c.a.d.b */
/* loaded from: classes.dex */
public class C1205b {

    /* renamed from: a */
    private C2140a f2655a = new C2140a();

    /* renamed from: a */
    public void m2315a() {
        C2140a c2140a = this.f2655a;
        if (c2140a.f6435c) {
            return;
        }
        synchronized (c2140a.f6434b) {
            c2140a.f6435c = true;
            Iterator<Runnable> it = c2140a.f6433a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    /* renamed from: b */
    public AbstractC1204a m2316b() {
        return this.f2655a;
    }
}
