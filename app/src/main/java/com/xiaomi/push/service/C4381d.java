package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.push.C4300j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.push.service.d */
/* loaded from: classes2.dex */
public class C4381d {

    /* renamed from: a */
    private static List<a> f16697a = new CopyOnWriteArrayList();

    /* renamed from: com.xiaomi.push.service.d$a */
    private static class a {

        /* renamed from: a */
        public final int f16698a;

        /* renamed from: a */
        public final long f16699a;

        /* renamed from: a */
        public final String f16700a;

        /* renamed from: a */
        public final Notification.Action[] f16701a;

        a(String str, long j2, int i2, Notification.Action[] actionArr) {
            this.f16700a = str;
            this.f16699a = j2;
            this.f16698a = i2;
            this.f16701a = actionArr;
        }
    }

    /* renamed from: a */
    protected static void m16075a(Context context, StatusBarNotification statusBarNotification, int i2) {
        if (!C4300j.m15681a(context) || i2 <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        m16076a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i2, C4355ag.m15919a(statusBarNotification.getNotification())));
    }

    /* renamed from: a */
    private static void m16076a(a aVar) {
        f16697a.add(aVar);
        m16074a();
    }

    /* renamed from: a */
    private static void m16074a() {
        for (int size = f16697a.size() - 1; size >= 0; size--) {
            a aVar = f16697a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f16699a > C2084a.f6136r) {
                f16697a.remove(aVar);
            }
        }
        if (f16697a.size() > 10) {
            f16697a.remove(0);
        }
    }
}
