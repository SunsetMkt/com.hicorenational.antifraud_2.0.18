package util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import java.util.Calendar;
import receiver.AlarmReceiver;

/* compiled from: AlarmUtil.java */
/* renamed from: util.v0 */
/* loaded from: classes2.dex */
public class C7327v0 {
    /* renamed from: c */
    private void m26638c(Context context, int i2) {
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setExact(0, m26633a(i2), PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AlarmReceiver.class), 0));
    }

    /* renamed from: a */
    public void m26640a(Context context, int i2) {
        if (m26635a()) {
            m26638c(context, i2);
        }
    }

    /* renamed from: b */
    public void m26641b(Context context, int i2) {
        m26636b();
        m26635a();
        m26638c(context, i2);
    }

    /* renamed from: a */
    private boolean m26635a() {
        long m26614a = C7325u1.m26614a(C7325u1.f25642J0, 0L);
        long m26614a2 = C7325u1.m26614a(C7325u1.f25644K0, 0L);
        long currentTimeMillis = System.currentTimeMillis() - m26614a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - m26614a2;
        if (m26614a != 0 && m26614a2 != 0 && Math.abs(currentTimeMillis - elapsedRealtime) <= 500) {
            return false;
        }
        C7325u1.m26629b(C7325u1.f25642J0, System.currentTimeMillis());
        C7325u1.m26629b(C7325u1.f25644K0, SystemClock.elapsedRealtime());
        return true;
    }

    /* renamed from: b */
    private void m26636b() {
        C7325u1.m26629b(C7325u1.f25642J0, 0L);
        C7325u1.m26629b(C7325u1.f25644K0, 0L);
    }

    /* renamed from: c */
    private void m26639c(Calendar calendar) {
        calendar.set(2, calendar.get(2) + 1);
        calendar.set(5, 1);
    }

    /* renamed from: b */
    private void m26637b(Calendar calendar) {
        int i2 = calendar.get(7);
        calendar.add(5, i2 != 1 ? 9 - i2 : 1);
    }

    /* renamed from: a */
    private long m26633a(int i2) {
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(5);
        int i4 = calendar.get(11);
        if (i2 == 1) {
            calendar = Calendar.getInstance();
            if (i4 >= 9) {
                calendar.set(5, i3 + 1);
            }
        } else if (i2 != 2) {
            if (i2 == 3) {
                if (i3 != 1) {
                    m26639c(calendar);
                } else if (i4 >= 9) {
                    m26639c(calendar);
                }
            }
        } else if (calendar.get(7) != 2) {
            m26637b(calendar);
        } else if (i4 >= 9) {
            m26637b(calendar);
        }
        return m26634a(calendar);
    }

    /* renamed from: a */
    private long m26634a(Calendar calendar) {
        calendar.set(11, 9);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println("每天9点" + timeInMillis);
        calendar.clear();
        return timeInMillis;
    }
}
