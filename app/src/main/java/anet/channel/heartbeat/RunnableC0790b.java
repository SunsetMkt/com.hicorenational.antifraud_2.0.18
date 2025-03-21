package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: anet.channel.heartbeat.b */
/* loaded from: classes.dex */
class RunnableC0790b implements IHeartbeat, Runnable {

    /* renamed from: a */
    private Session f866a;

    /* renamed from: b */
    private volatile long f867b = 0;

    /* renamed from: c */
    private volatile boolean f868c = false;

    /* renamed from: d */
    private long f869d = 0;

    RunnableC0790b() {
    }

    /* renamed from: a */
    private void m520a(long j2) {
        try {
            this.f867b = System.currentTimeMillis() + j2;
            ThreadPoolExecutorFactory.submitScheduledTask(this, j2 + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.m714e("awcn.DefaultHeartbeatImpl", "Submit heartbeat task failed.", this.f866a.f698p, e2, new Object[0]);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f867b = System.currentTimeMillis() + this.f869d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f868c) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f867b - 1000) {
            m520a(this.f867b - currentTimeMillis);
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground()) {
            Session session = this.f866a;
            ALog.m715e("awcn.DefaultHeartbeatImpl", "close session in background", session.f698p, C3397d.f11932aw, session);
            this.f866a.close(false);
        } else {
            if (ALog.isPrintLog(1)) {
                Session session2 = this.f866a;
                ALog.m713d("awcn.DefaultHeartbeatImpl", "heartbeat", session2.f698p, C3397d.f11932aw, session2);
            }
            this.f866a.ping(true);
            m520a(this.f869d);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session == null) {
            throw new NullPointerException("session is null");
        }
        this.f866a = session;
        this.f869d = session.getConnStrategy().getHeartbeat();
        if (this.f869d <= 0) {
            this.f869d = 45000L;
        }
        ALog.m716i("awcn.DefaultHeartbeatImpl", "heartbeat start", session.f698p, C3397d.f11932aw, session, C3351bh.f11599aX, Long.valueOf(this.f869d));
        m520a(this.f869d);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Session session = this.f866a;
        if (session == null) {
            return;
        }
        ALog.m716i("awcn.DefaultHeartbeatImpl", "heartbeat stop", session.f698p, C3397d.f11932aw, session);
        this.f868c = true;
    }
}
