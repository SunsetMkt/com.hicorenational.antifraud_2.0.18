package l.a.a.c.a;

import android.content.Context;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import l.a.a.a.j.e;

/* JADX INFO: compiled from: AIDLTask.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Runnable {
    protected final CountDownLatch a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b */
    protected final AtomicBoolean f12705b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c */
    protected Context f12706c;

    protected b(Context context) {
        this.f12706c = context;
    }

    private void c() {
        if (this.f12705b.get()) {
            return;
        }
        this.f12705b.set(true);
        a(null);
        b();
    }

    protected abstract void a();

    public abstract void a(ErrorStatus errorStatus);

    public void b() {
        e.b("AIDLTask", "finishTask", true);
        a aVarA = a.a(this.f12706c);
        if (aVarA != null) {
            aVarA.b();
        }
        this.a.countDown();
        this.f12705b.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        try {
            if (this.a.await(12000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            c();
        } catch (InterruptedException unused) {
            e.b("AIDLTask", "execute await InterruptedException", true);
            c();
        }
    }
}
