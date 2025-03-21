package p358k.p359a.p360a.p367c.p368a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.hihonor.cloudservice.framework.aidl.InterfaceC2129b;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p358k.p359a.p360a.p361a.C5851e;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: AIDLClientInvokeManager.java */
/* renamed from: k.a.a.c.a.a */
/* loaded from: classes2.dex */
public class ServiceConnectionC5866a implements ServiceConnection {

    /* renamed from: j */
    private static ServiceConnectionC5866a f21173j;

    /* renamed from: k */
    private static final AtomicInteger f21174k = new AtomicInteger();

    /* renamed from: l */
    private static final ExecutorService f21175l = Executors.newFixedThreadPool(3);

    /* renamed from: a */
    private InterfaceC2129b f21176a;

    /* renamed from: f */
    private Context f21181f;

    /* renamed from: i */
    private Handler f21184i;

    /* renamed from: b */
    private final AtomicBoolean f21177b = new AtomicBoolean(false);

    /* renamed from: c */
    private final Queue<AbstractRunnableC5867b> f21178c = new LinkedBlockingQueue();

    /* renamed from: d */
    private AtomicInteger f21179d = new AtomicInteger(0);

    /* renamed from: e */
    private CountDownLatch f21180e = null;

    /* renamed from: g */
    private int f21182g = 0;

    /* renamed from: h */
    final HandlerThread f21183h = new HandlerThread("AIDLClientInvokeManager");

    /* compiled from: AIDLClientInvokeManager.java */
    /* renamed from: k.a.a.c.a.a$a */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            C5863e.m24692b("AIDLClientInvokeManager", "msg.what: " + message.what, true);
            int i2 = message.what;
            if (i2 == 3001) {
                if (ServiceConnectionC5866a.this.f21179d.get() == 2) {
                    ServiceConnectionC5866a.this.m24724f();
                    return;
                } else {
                    if (ServiceConnectionC5866a.this.f21179d.get() == 0) {
                        ServiceConnectionC5866a.this.m24730i();
                        return;
                    }
                    return;
                }
            }
            if (i2 == 3002) {
                ServiceConnectionC5866a.this.f21179d.set(2);
                ServiceConnectionC5866a.this.m24724f();
                return;
            }
            if (i2 == 3003) {
                ServiceConnectionC5866a.this.f21179d.set(0);
                ServiceConnectionC5866a.this.m24722e();
            } else if (i2 == 3004) {
                C5863e.m24692b("AIDLClientInvokeManager", "MSG_FINISH_TASK, unbind", true);
                ServiceConnectionC5866a.this.m24731j();
                ServiceConnectionC5866a.this.f21179d.set(0);
            } else if (i2 == 3005) {
                C5863e.m24692b("AIDLClientInvokeManager", "MSG_START_SERVICE_FAILED all login return failed", true);
                ServiceConnectionC5866a.this.f21179d.set(0);
                ServiceConnectionC5866a.this.m24727g();
            }
        }
    }

    /* compiled from: AIDLClientInvokeManager.java */
    /* renamed from: k.a.a.c.a.a$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean await = ServiceConnectionC5866a.this.f21180e.await(4000L, TimeUnit.MILLISECONDS);
                C5863e.m24692b("AIDLClientInvokeManager", "startService await", true);
                if (await) {
                    return;
                }
                ServiceConnectionC5866a.this.m24728h();
            } catch (InterruptedException unused) {
                C5863e.m24692b("AIDLClientInvokeManager", "serviceStartDownLatch InterruptedException", true);
                ServiceConnectionC5866a.this.m24728h();
            }
        }
    }

    private ServiceConnectionC5866a(Context context) {
        this.f21181f = context.getApplicationContext();
        this.f21183h.start();
        this.f21184i = new a(this.f21183h.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m24730i() {
        C5863e.m24692b("AIDLClientInvokeManager", "startService", true);
        this.f21179d.set(1);
        m24718c();
        m24720d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m24731j() {
        C5863e.m24692b("AIDLClientInvokeManager", "unbind Service", true);
        try {
            this.f21181f.unbindService(this);
        } catch (Exception unused) {
            C5863e.m24692b("AIDLClientInvokeManager", "unbind service error", true);
        }
        m24722e();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C5863e.m24692b("AIDLClientInvokeManager", "onServiceConnected", true);
        try {
            this.f21182g = 0;
            this.f21176a = InterfaceC2129b.a.m5980a(iBinder);
            this.f21180e.countDown();
            this.f21177b.set(true);
            this.f21184i.sendEmptyMessage(ErrorStatus.f6701r0);
        } catch (RuntimeException unused) {
            C5863e.m24691a("AIDLClientInvokeManager", "onServiceConnected RuntimeException!", true);
        } catch (Exception unused2) {
            C5863e.m24691a("AIDLClientInvokeManager", "onServiceConnected Exception!", true);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C5863e.m24692b("AIDLClientInvokeManager", "onServiceDisconnected", true);
        this.f21182g = 0;
        this.f21184i.sendEmptyMessage(ErrorStatus.f6699q0);
    }

    /* renamed from: a */
    public static ServiceConnectionC5866a m24716a(Context context) {
        ServiceConnectionC5866a serviceConnectionC5866a;
        if (context == null) {
            return null;
        }
        synchronized (ServiceConnectionC5866a.class) {
            if (f21173j == null) {
                C5863e.m24692b("AIDLClientInvokeManager", "AIDLClientInvokeManager init", true);
                f21173j = new ServiceConnectionC5866a(context);
            }
            serviceConnectionC5866a = f21173j;
        }
        return serviceConnectionC5866a;
    }

    /* renamed from: c */
    private void m24718c() {
        C5863e.m24692b("AIDLClientInvokeManager", "begin to bindService", true);
        Intent intent = new Intent();
        String m24638a = C5851e.m24637a(this.f21181f).m24638a();
        intent.setAction("com.hihonor.id.HonorInvokeService");
        intent.setPackage(m24638a);
        try {
            if (this.f21181f.bindService(intent, this, 1)) {
                return;
            }
            C5863e.m24691a("AIDLClientInvokeManager", "bind service failed", true);
        } catch (Exception unused) {
            C5863e.m24691a("AIDLClientInvokeManager", "bind service exception", true);
        }
    }

    /* renamed from: d */
    private void m24720d() {
        this.f21177b.set(false);
        this.f21180e = new CountDownLatch(1);
        new Thread(new b()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m24722e() {
        synchronized (this.f21178c) {
            this.f21176a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m24724f() {
        C5863e.m24692b("AIDLClientInvokeManager", "doTask", true);
        synchronized (this.f21178c) {
            while (true) {
                AbstractRunnableC5867b poll = this.f21178c.poll();
                if (poll != null) {
                    try {
                        try {
                            f21175l.submit(poll);
                        } catch (RejectedExecutionException unused) {
                            C5863e.m24691a("AIDLClientInvokeManager", "Execute submit RejectedExecutionException!", true);
                        } catch (Exception unused2) {
                            C5863e.m24691a("AIDLClientInvokeManager", "Execute submit Exception!", true);
                        }
                    } catch (NullPointerException unused3) {
                        C5863e.m24691a("AIDLClientInvokeManager", "Execute submit NullPointerException!", true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m24727g() {
        C5863e.m24692b("AIDLClientInvokeManager", "onBindServiceFailed", true);
        synchronized (this.f21178c) {
            while (true) {
                AbstractRunnableC5867b poll = this.f21178c.poll();
                if (poll != null) {
                    f21174k.decrementAndGet();
                    poll.mo2274a(new ErrorStatus(40, "start APK service ERROR"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m24728h() {
        C5863e.m24692b("AIDLClientInvokeManager", "onServiceConnectedTimeout", true);
        if (this.f21177b.get()) {
            return;
        }
        m24731j();
        int i2 = this.f21182g;
        if (i2 < 3) {
            this.f21182g = i2 + 1;
            m24730i();
        } else {
            this.f21177b.set(true);
            this.f21184i.sendEmptyMessage(3005);
        }
    }

    /* renamed from: b */
    public void m24734b() {
        C5863e.m24692b("AIDLClientInvokeManager", "sendTaskFinishMsg", true);
        synchronized (this.f21178c) {
            if (f21174k.decrementAndGet() == 0) {
                this.f21184i.sendEmptyMessage(ErrorStatus.f6697p0);
            }
        }
    }

    /* renamed from: a */
    public InterfaceC2129b m24732a() {
        return this.f21176a;
    }

    /* renamed from: a */
    public void m24733a(AbstractRunnableC5867b abstractRunnableC5867b) {
        C5863e.m24692b("AIDLClientInvokeManager", "addTask:", true);
        synchronized (this.f21178c) {
            f21174k.incrementAndGet();
            this.f21178c.add(abstractRunnableC5867b);
        }
        this.f21184i.sendEmptyMessage(3001);
    }
}
