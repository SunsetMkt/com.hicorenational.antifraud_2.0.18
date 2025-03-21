package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: anet.channel.heartbeat.c */
/* loaded from: classes.dex */
public class RunnableC0791c implements IHeartbeat, Runnable {

    /* renamed from: a */
    private Session f870a = null;

    /* renamed from: b */
    private volatile boolean f871b = false;

    /* renamed from: c */
    private volatile long f872c = System.currentTimeMillis();

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f872c = System.currentTimeMillis() + 45000;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f871b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f872c - 1000) {
            ThreadPoolExecutorFactory.submitScheduledTask(this, this.f872c - currentTimeMillis, TimeUnit.MILLISECONDS);
        } else {
            this.f870a.close(false);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session == null) {
            throw new NullPointerException("session is null");
        }
        this.f870a = session;
        this.f872c = System.currentTimeMillis() + 45000;
        ThreadPoolExecutorFactory.submitScheduledTask(this, 45000L, TimeUnit.MILLISECONDS);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.f871b = true;
    }
}
