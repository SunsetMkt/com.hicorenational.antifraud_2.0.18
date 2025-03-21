package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.ae */
/* loaded from: classes2.dex */
public class C4076ae {

    /* renamed from: a */
    private static volatile C4076ae f14478a;

    /* renamed from: a */
    private SharedPreferences f14479a;

    /* renamed from: a */
    private ScheduledThreadPoolExecutor f14482a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a */
    private Map<String, ScheduledFuture> f14481a = new HashMap();

    /* renamed from: a */
    private Object f14480a = new Object();

    /* renamed from: com.xiaomi.push.ae$a */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo13391a();
    }

    /* renamed from: com.xiaomi.push.ae$b */
    private static class b implements Runnable {

        /* renamed from: a */
        a f14487a;

        public b(a aVar) {
            this.f14487a = aVar;
        }

        /* renamed from: a */
        void mo13711a() {
        }

        /* renamed from: b */
        void mo13712b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            mo13711a();
            this.f14487a.run();
            mo13712b();
        }
    }

    private C4076ae(Context context) {
        this.f14479a = context.getSharedPreferences("mipush_extra", 0);
    }

    /* renamed from: b */
    public boolean m13710b(a aVar, int i2) {
        if (aVar == null || m13702a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f14482a.schedule(new b(aVar) { // from class: com.xiaomi.push.ae.2
            @Override // com.xiaomi.push.C4076ae.b
            /* renamed from: b */
            void mo13712b() {
                synchronized (C4076ae.this.f14480a) {
                    C4076ae.this.f14481a.remove(super.f14487a.mo13391a());
                }
            }
        }, i2, TimeUnit.SECONDS);
        synchronized (this.f14480a) {
            this.f14481a.put(aVar.mo13391a(), schedule);
        }
        return true;
    }

    /* renamed from: a */
    public static C4076ae m13698a(Context context) {
        if (f14478a == null) {
            synchronized (C4076ae.class) {
                if (f14478a == null) {
                    f14478a = new C4076ae(context);
                }
            }
        }
        return f14478a;
    }

    /* renamed from: a */
    public boolean m13706a(a aVar, int i2) {
        return m13707a(aVar, i2, 0);
    }

    /* renamed from: a */
    public boolean m13707a(a aVar, int i2, int i3) {
        return m13708a(aVar, i2, i3, false);
    }

    /* renamed from: a */
    public boolean m13708a(a aVar, int i2, int i3, final boolean z) {
        if (aVar == null || m13702a(aVar) != null) {
            return false;
        }
        final String m13700a = m13700a(aVar.mo13391a());
        b bVar = new b(aVar) { // from class: com.xiaomi.push.ae.1
            @Override // com.xiaomi.push.C4076ae.b
            /* renamed from: a */
            void mo13711a() {
                super.mo13711a();
            }

            @Override // com.xiaomi.push.C4076ae.b
            /* renamed from: b */
            void mo13712b() {
                if (z) {
                    return;
                }
                C4076ae.this.f14479a.edit().putLong(m13700a, System.currentTimeMillis()).commit();
            }
        };
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f14479a.getLong(m13700a, 0L)) / 1000;
            if (abs < i2 - i3) {
                i3 = (int) (i2 - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f14482a.scheduleAtFixedRate(bVar, i3, i2, TimeUnit.SECONDS);
            synchronized (this.f14480a) {
                this.f14481a.put(aVar.mo13391a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return true;
        }
    }

    /* renamed from: a */
    public void m13703a(Runnable runnable) {
        m13704a(runnable, 0);
    }

    /* renamed from: a */
    public void m13704a(Runnable runnable, int i2) {
        this.f14482a.schedule(runnable, i2, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public boolean m13705a(a aVar) {
        return m13710b(aVar, 0);
    }

    /* renamed from: a */
    private ScheduledFuture m13702a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f14480a) {
            scheduledFuture = this.f14481a.get(aVar.mo13391a());
        }
        return scheduledFuture;
    }

    /* renamed from: a */
    public boolean m13709a(String str) {
        synchronized (this.f14480a) {
            ScheduledFuture scheduledFuture = this.f14481a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f14481a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    /* renamed from: a */
    private static String m13700a(String str) {
        return "last_job_time" + str;
    }
}
