package l.a.a.c.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.hihonor.cloudservice.framework.aidl.b;
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
import l.a.a.a.j.e;

/* JADX INFO: compiled from: AIDLClientInvokeManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements ServiceConnection {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static a f12694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicInteger f12695k = new AtomicInteger();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ExecutorService f12696l = Executors.newFixedThreadPool(3);
    private com.hihonor.cloudservice.framework.aidl.b a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f12701f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f12704i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f12697b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<l.a.a.c.a.b> f12698c = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicInteger f12699d = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownLatch f12700e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12702g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final HandlerThread f12703h = new HandlerThread("AIDLClientInvokeManager");

    /* JADX INFO: renamed from: l.a.a.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AIDLClientInvokeManager.java */
    class HandlerC0266a extends Handler {
        HandlerC0266a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            e.b("AIDLClientInvokeManager", "msg.what: " + message.what, true);
            int i2 = message.what;
            if (i2 == 3001) {
                if (a.this.f12699d.get() == 2) {
                    a.this.f();
                    return;
                } else {
                    if (a.this.f12699d.get() == 0) {
                        a.this.i();
                        return;
                    }
                    return;
                }
            }
            if (i2 == 3002) {
                a.this.f12699d.set(2);
                a.this.f();
                return;
            }
            if (i2 == 3003) {
                a.this.f12699d.set(0);
                a.this.e();
            } else if (i2 == 3004) {
                e.b("AIDLClientInvokeManager", "MSG_FINISH_TASK, unbind", true);
                a.this.j();
                a.this.f12699d.set(0);
            } else if (i2 == 3005) {
                e.b("AIDLClientInvokeManager", "MSG_START_SERVICE_FAILED all login return failed", true);
                a.this.f12699d.set(0);
                a.this.g();
            }
        }
    }

    /* JADX INFO: compiled from: AIDLClientInvokeManager.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean zAwait = a.this.f12700e.await(4000L, TimeUnit.MILLISECONDS);
                e.b("AIDLClientInvokeManager", "startService await", true);
                if (zAwait) {
                    return;
                }
                a.this.h();
            } catch (InterruptedException unused) {
                e.b("AIDLClientInvokeManager", "serviceStartDownLatch InterruptedException", true);
                a.this.h();
            }
        }
    }

    private a(Context context) {
        this.f12701f = context.getApplicationContext();
        this.f12703h.start();
        this.f12704i = new HandlerC0266a(this.f12703h.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        e.b("AIDLClientInvokeManager", "startService", true);
        this.f12699d.set(1);
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        e.b("AIDLClientInvokeManager", "unbind Service", true);
        try {
            this.f12701f.unbindService(this);
        } catch (Exception unused) {
            e.b("AIDLClientInvokeManager", "unbind service error", true);
        }
        e();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e.b("AIDLClientInvokeManager", "onServiceConnected", true);
        try {
            this.f12702g = 0;
            this.a = b.a.a(iBinder);
            this.f12700e.countDown();
            this.f12697b.set(true);
            this.f12704i.sendEmptyMessage(ErrorStatus.r0);
        } catch (RuntimeException unused) {
            e.a("AIDLClientInvokeManager", "onServiceConnected RuntimeException!", true);
        } catch (Exception unused2) {
            e.a("AIDLClientInvokeManager", "onServiceConnected Exception!", true);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        e.b("AIDLClientInvokeManager", "onServiceDisconnected", true);
        this.f12702g = 0;
        this.f12704i.sendEmptyMessage(ErrorStatus.q0);
    }

    public static a a(Context context) {
        a aVar;
        if (context == null) {
            return null;
        }
        synchronized (a.class) {
            if (f12694j == null) {
                e.b("AIDLClientInvokeManager", "AIDLClientInvokeManager init", true);
                f12694j = new a(context);
            }
            aVar = f12694j;
        }
        return aVar;
    }

    private void c() {
        e.b("AIDLClientInvokeManager", "begin to bindService", true);
        Intent intent = new Intent();
        String strA = l.a.a.a.e.a(this.f12701f).a();
        intent.setAction("com.hihonor.id.HonorInvokeService");
        intent.setPackage(strA);
        try {
            if (this.f12701f.bindService(intent, this, 1)) {
                return;
            }
            e.a("AIDLClientInvokeManager", "bind service failed", true);
        } catch (Exception unused) {
            e.a("AIDLClientInvokeManager", "bind service exception", true);
        }
    }

    private void d() {
        this.f12697b.set(false);
        this.f12700e = new CountDownLatch(1);
        new Thread(new b()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.f12698c) {
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        e.b("AIDLClientInvokeManager", "doTask", true);
        synchronized (this.f12698c) {
            while (true) {
                l.a.a.c.a.b bVarPoll = this.f12698c.poll();
                if (bVarPoll != null) {
                    try {
                        try {
                            f12696l.submit(bVarPoll);
                        } catch (RejectedExecutionException unused) {
                            e.a("AIDLClientInvokeManager", "Execute submit RejectedExecutionException!", true);
                        } catch (Exception unused2) {
                            e.a("AIDLClientInvokeManager", "Execute submit Exception!", true);
                        }
                    } catch (NullPointerException unused3) {
                        e.a("AIDLClientInvokeManager", "Execute submit NullPointerException!", true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        e.b("AIDLClientInvokeManager", "onBindServiceFailed", true);
        synchronized (this.f12698c) {
            while (true) {
                l.a.a.c.a.b bVarPoll = this.f12698c.poll();
                if (bVarPoll != null) {
                    f12695k.decrementAndGet();
                    bVarPoll.a(new ErrorStatus(40, "start APK service ERROR"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        e.b("AIDLClientInvokeManager", "onServiceConnectedTimeout", true);
        if (this.f12697b.get()) {
            return;
        }
        j();
        int i2 = this.f12702g;
        if (i2 < 3) {
            this.f12702g = i2 + 1;
            i();
        } else {
            this.f12697b.set(true);
            this.f12704i.sendEmptyMessage(3005);
        }
    }

    public void b() {
        e.b("AIDLClientInvokeManager", "sendTaskFinishMsg", true);
        synchronized (this.f12698c) {
            if (f12695k.decrementAndGet() == 0) {
                this.f12704i.sendEmptyMessage(ErrorStatus.p0);
            }
        }
    }

    public com.hihonor.cloudservice.framework.aidl.b a() {
        return this.a;
    }

    public void a(l.a.a.c.a.b bVar) {
        e.b("AIDLClientInvokeManager", "addTask:", true);
        synchronized (this.f12698c) {
            f12695k.incrementAndGet();
            this.f12698c.add(bVar);
        }
        this.f12704i.sendEmptyMessage(3001);
    }
}
