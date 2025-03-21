package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4178dz;
import com.xiaomi.push.service.AbstractC4362an;
import com.xiaomi.push.service.C4390m;

/* renamed from: com.xiaomi.push.ea */
/* loaded from: classes2.dex */
class C4180ea implements C4178dz.a {

    /* renamed from: a */
    protected Context f15066a;

    /* renamed from: a */
    private PendingIntent f15065a = null;

    /* renamed from: a */
    private volatile long f15064a = 0;

    public C4180ea(Context context) {
        this.f15066a = null;
        this.f15066a = context;
    }

    /* renamed from: a */
    public void m14592a(Intent intent, long j2) {
        AlarmManager alarmManager = (AlarmManager) this.f15066a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (Build.VERSION.SDK_INT >= 31) {
            this.f15065a = PendingIntent.getBroadcast(this.f15066a, 0, intent, CommonNetImpl.FLAG_SHARE_JUMP);
        } else {
            this.f15065a = PendingIntent.getBroadcast(this.f15066a, 0, intent, 0);
        }
        if (Build.VERSION.SDK_INT >= 31 && !C4300j.m15681a(this.f15066a)) {
            alarmManager.set(2, j2, this.f15065a);
        } else if (Build.VERSION.SDK_INT >= 23) {
            C4094aw.m13822a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j2), this.f15065a);
        } else {
            m14591a(alarmManager, j2, this.f15065a);
        }
        AbstractC4022b.m13359c("[Alarm] register timer " + j2);
    }

    /* renamed from: a */
    private void m14591a(AlarmManager alarmManager, long j2, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j2), pendingIntent);
        } catch (Exception e2) {
            AbstractC4022b.m13361d("[Alarm] invoke setExact method meet error. " + e2);
        }
    }

    @Override // com.xiaomi.push.C4178dz.a
    /* renamed from: a */
    public void mo14584a(boolean z) {
        long m16140a = C4390m.m16121a(this.f15066a).m16140a();
        if (z || this.f15064a != 0) {
            if (z) {
                mo14583a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.f15064a == 0) {
                this.f15064a = elapsedRealtime + (m16140a - (elapsedRealtime % m16140a));
            } else if (this.f15064a <= elapsedRealtime) {
                this.f15064a += m16140a;
                if (this.f15064a < elapsedRealtime) {
                    this.f15064a = elapsedRealtime + m16140a;
                }
            }
            Intent intent = new Intent(AbstractC4362an.f16615q);
            intent.setPackage(this.f15066a.getPackageName());
            m14592a(intent, this.f15064a);
        }
    }

    @Override // com.xiaomi.push.C4178dz.a
    /* renamed from: a */
    public void mo14583a() {
        if (this.f15065a != null) {
            try {
                ((AlarmManager) this.f15066a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f15065a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f15065a = null;
                AbstractC4022b.m13359c("[Alarm] unregister timer");
                this.f15064a = 0L;
                throw th;
            }
            this.f15065a = null;
            AbstractC4022b.m13359c("[Alarm] unregister timer");
            this.f15064a = 0L;
        }
        this.f15064a = 0L;
    }

    @Override // com.xiaomi.push.C4178dz.a
    /* renamed from: a */
    public boolean mo14585a() {
        return this.f15064a != 0;
    }
}
