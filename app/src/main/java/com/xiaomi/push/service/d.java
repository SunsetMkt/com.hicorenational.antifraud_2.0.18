package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static List<a> a = new CopyOnWriteArrayList();

    private static class a {
        public final int a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f1039a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1040a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f1041a;

        a(String str, long j2, int i2, Notification.Action[] actionArr) {
            this.f1040a = str;
            this.f1039a = j2;
            this.a = i2;
            this.f1041a = actionArr;
        }
    }

    protected static void a(Context context, StatusBarNotification statusBarNotification, int i2) {
        if (!com.xiaomi.push.j.m625a(context) || i2 <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i2, ag.m688a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        a.add(aVar);
        a();
    }

    private static void a() {
        for (int size = a.size() - 1; size >= 0; size--) {
            a aVar = a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f1039a > com.heytap.mcssdk.constant.a.r) {
                a.remove(aVar);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }
}
