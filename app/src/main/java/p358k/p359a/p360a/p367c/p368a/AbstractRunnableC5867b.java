package p358k.p359a.p360a.p367c.p368a;

import android.content.Context;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: AIDLTask.java */
/* renamed from: k.a.a.c.a.b */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC5867b implements Runnable {

    /* renamed from: a */
    protected final CountDownLatch f21187a = new CountDownLatch(1);

    /* renamed from: b */
    protected final AtomicBoolean f21188b = new AtomicBoolean(false);

    /* renamed from: c */
    protected Context f21189c;

    protected AbstractRunnableC5867b(Context context) {
        this.f21189c = context;
    }

    /* renamed from: c */
    private void m24735c() {
        if (this.f21188b.get()) {
            return;
        }
        this.f21188b.set(true);
        mo2274a(null);
        m24736b();
    }

    /* renamed from: a */
    protected abstract void mo2273a();

    /* renamed from: a */
    public abstract void mo2274a(ErrorStatus errorStatus);

    /* renamed from: b */
    protected void m24736b() {
        C5863e.m24692b("AIDLTask", "finishTask", true);
        ServiceConnectionC5866a m24716a = ServiceConnectionC5866a.m24716a(this.f21189c);
        if (m24716a != null) {
            m24716a.m24734b();
        }
        this.f21187a.countDown();
        this.f21188b.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        mo2273a();
        try {
            if (this.f21187a.await(12000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            m24735c();
        } catch (InterruptedException unused) {
            C5863e.m24692b("AIDLTask", "execute await InterruptedException", true);
            m24735c();
        }
    }
}
