package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.heytap.mcssdk.constant.C2084a;
import java.util.ArrayList;
import java.util.List;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.as */
/* loaded from: classes2.dex */
public class C3156as extends Thread {

    /* renamed from: b */
    private boolean f10610b = false;

    /* renamed from: a */
    final List<RunnableC3155ar> f10609a = new ArrayList();

    /* renamed from: c */
    private List<InterfaceC3157at> f10611c = new ArrayList();

    /* renamed from: e */
    private int m10006e() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f10609a.size(); i3++) {
            try {
                i2 = Math.max(i2, this.f10609a.get(i3).m10001c());
            } catch (Exception e2) {
                C3151an.m9919b(e2);
            }
        }
        return i2;
    }

    /* renamed from: a */
    public void m10007a() {
        m10008a(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: b */
    public void m10011b() {
        m10012b(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: c */
    public boolean m10014c() {
        this.f10610b = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            C3151an.m9919b(e2);
        }
        return true;
    }

    /* renamed from: d */
    public boolean m10015d() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            C3151an.m9919b(e2);
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.f10610b) {
            for (int i2 = 0; i2 < this.f10609a.size(); i2++) {
                try {
                    this.f10609a.get(i2).m9998a();
                } catch (Exception e2) {
                    C3151an.m9919b(e2);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j2 = 2000; j2 > 0 && !isInterrupted(); j2 = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                Thread.sleep(j2);
            }
            int m10006e = m10006e();
            if (m10006e != 0 && m10006e != 1) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < this.f10609a.size(); i3++) {
                    RunnableC3155ar runnableC3155ar = this.f10609a.get(i3);
                    if (runnableC3155ar.m10000b()) {
                        arrayList.add(runnableC3155ar);
                        runnableC3155ar.m9999a(C5556m0.f20396b);
                    }
                }
                int i4 = 0;
                boolean z = false;
                while (i4 < arrayList.size()) {
                    RunnableC3155ar runnableC3155ar2 = (RunnableC3155ar) arrayList.get(i4);
                    Thread m10002d = runnableC3155ar2.m10002d();
                    boolean z2 = z;
                    for (int i5 = 0; i5 < this.f10611c.size(); i5++) {
                        if (this.f10611c.get(i5).mo9671a(m10002d)) {
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        m10005a(runnableC3155ar2);
                    }
                    i4++;
                    z = z2;
                }
            }
        }
    }

    /* renamed from: a */
    public void m10008a(Handler handler) {
        m10009a(handler, C2084a.f6136r);
    }

    /* renamed from: b */
    public void m10012b(Handler handler) {
        if (handler == null) {
            C3151an.m9923e("removeThread handler should not be null", new Object[0]);
            return;
        }
        for (int i2 = 0; i2 < this.f10609a.size(); i2++) {
            try {
                if (this.f10609a.get(i2).m10003e().equals(handler.getLooper().getThread().getName())) {
                    C3151an.m9921c("remove handler::%s", this.f10609a.get(i2));
                    this.f10609a.remove(i2);
                }
            } catch (Exception e2) {
                C3151an.m9919b(e2);
                return;
            }
        }
    }

    /* renamed from: a */
    public void m10009a(Handler handler, long j2) {
        if (handler == null) {
            C3151an.m9923e("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i2 = 0; i2 < this.f10609a.size(); i2++) {
            try {
                if (this.f10609a.get(i2).m10003e().equals(handler.getLooper().getThread().getName())) {
                    C3151an.m9923e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                C3151an.m9919b(e2);
            }
        }
        this.f10609a.add(new RunnableC3155ar(handler, name, j2));
    }

    /* renamed from: b */
    public void m10013b(InterfaceC3157at interfaceC3157at) {
        this.f10611c.remove(interfaceC3157at);
    }

    /* renamed from: a */
    public void m10010a(InterfaceC3157at interfaceC3157at) {
        if (this.f10611c.contains(interfaceC3157at)) {
            C3151an.m9921c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f10611c.add(interfaceC3157at);
        }
    }

    /* renamed from: a */
    private void m10005a(RunnableC3155ar runnableC3155ar) {
        if (runnableC3155ar.m10003e().contains("main")) {
            runnableC3155ar.m10004f();
            C3151an.m9922d("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new Object[0]);
        }
    }
}
