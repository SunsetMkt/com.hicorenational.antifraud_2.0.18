package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ae {
    private static volatile ae a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ScheduledThreadPoolExecutor f153a = new ScheduledThreadPoolExecutor(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, ScheduledFuture> f152a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f151a = new Object();

    public static abstract class a implements Runnable {
        /* JADX INFO: renamed from: a */
        public abstract String mo181a();
    }

    private static class b implements Runnable {
        a a;

        public b(a aVar) {
            this.a = aVar;
        }

        void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.a.run();
            b();
        }
    }

    private ae(Context context) {
        this.f150a = context.getSharedPreferences("mipush_extra", 0);
    }

    public boolean b(a aVar, int i2) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> scheduledFutureSchedule = this.f153a.schedule(new b(aVar) { // from class: com.xiaomi.push.ae.2
            @Override // com.xiaomi.push.ae.b
            void b() {
                synchronized (ae.this.f151a) {
                    ae.this.f152a.remove(super.a.mo181a());
                }
            }
        }, i2, TimeUnit.SECONDS);
        synchronized (this.f151a) {
            this.f152a.put(aVar.mo181a(), scheduledFutureSchedule);
        }
        return true;
    }

    public static ae a(Context context) {
        if (a == null) {
            synchronized (ae.class) {
                if (a == null) {
                    a = new ae(context);
                }
            }
        }
        return a;
    }

    public boolean a(a aVar, int i2) {
        return a(aVar, i2, 0);
    }

    public boolean a(a aVar, int i2, int i3) {
        return a(aVar, i2, i3, false);
    }

    public boolean a(a aVar, int i2, int i3, final boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        final String strA = a(aVar.mo181a());
        b bVar = new b(aVar) { // from class: com.xiaomi.push.ae.1
            @Override // com.xiaomi.push.ae.b
            void a() {
                super.a();
            }

            @Override // com.xiaomi.push.ae.b
            void b() {
                if (z) {
                    return;
                }
                ae.this.f150a.edit().putLong(strA, System.currentTimeMillis()).commit();
            }
        };
        if (!z) {
            long jAbs = Math.abs(System.currentTimeMillis() - this.f150a.getLong(strA, 0L)) / 1000;
            if (jAbs < i2 - i3) {
                i3 = (int) (((long) i2) - jAbs);
            }
        }
        try {
            ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = this.f153a.scheduleAtFixedRate(bVar, i3, i2, TimeUnit.SECONDS);
            synchronized (this.f151a) {
                this.f152a.put(aVar.mo181a(), scheduledFutureScheduleAtFixedRate);
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return true;
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i2) {
        this.f153a.schedule(runnable, i2, TimeUnit.SECONDS);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m128a(a aVar) {
        return b(aVar, 0);
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f151a) {
            scheduledFuture = this.f152a.get(aVar.mo181a());
        }
        return scheduledFuture;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m129a(String str) {
        synchronized (this.f151a) {
            ScheduledFuture scheduledFuture = this.f152a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f152a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }
}
