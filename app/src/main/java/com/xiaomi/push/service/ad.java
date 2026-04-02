package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.push.gk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
class ad {
    private static ad a = new ad();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SpannableString f971a;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        List<b> f972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<b> f9343b;

        private a() {
            this.f972a = new ArrayList();
            this.f9343b = new ArrayList();
        }
    }

    private class b {
        int a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Notification f973a;

        public b(int i2, Notification notification) {
            this.a = i2;
            this.f973a = notification;
        }

        public String toString() {
            return "id:" + this.a;
        }
    }

    private ad() {
    }

    public static ad a() {
        return a;
    }

    private boolean b(Context context) {
        return ah.a(context).a(gk.NotificationAutoGroupSwitch.a(), true);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m671a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(Context context) {
        if (b(context) && af.m677a(context)) {
            return ah.a(context).a(gk.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m673b(notification) ? a(notification) : notification.getGroup();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private boolean m673b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m672a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object objA = com.xiaomi.push.aw.a((Object) notification, "isGroupSummary", (Object[]) null);
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    private void b(Context context, int i2, Notification notification) {
        String strC = ag.c(notification);
        if (TextUtils.isEmpty(strC)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("group restore not extract pkg from notification:" + i2);
            return;
        }
        af afVarA = af.a(context, strC);
        List<StatusBarNotification> listA = a(afVarA);
        if (listA == null) {
            com.xiaomi.channel.commonutils.logger.b.m48a("group restore not get notifications");
            return;
        }
        for (StatusBarNotification statusBarNotification : listA) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && m673b(notification2) && statusBarNotification.getId() != i2) {
                Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                builderRecoverBuilder.setGroup(a(notification2));
                ag.a(builderRecoverBuilder, m672a(notification2));
                afVarA.a(statusBarNotification.getId(), builderRecoverBuilder.build());
                com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!m671a() || !a(context)) {
            return str;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", jCurrentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(jCurrentTimeMillis), str);
    }

    public void a(Context context, int i2, Notification notification) {
        if (m671a()) {
            if (a(context)) {
                try {
                    b(context, i2, notification);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("group notify handle restore error " + e2);
                }
            }
            if (b(context)) {
                try {
                    a(context, i2, notification, true);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("group notify handle auto error " + e3);
                }
            }
        }
    }

    private void a(Context context, int i2, Notification notification, boolean z) {
        Notification notification2;
        String strC = ag.c(notification);
        if (TextUtils.isEmpty(strC)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("group auto not extract pkg from notification:" + i2);
            return;
        }
        List<StatusBarNotification> listA = a(af.a(context, strC));
        if (listA == null) {
            com.xiaomi.channel.commonutils.logger.b.m48a("group auto not get notifications");
            return;
        }
        String strB = b(notification);
        HashMap map = new HashMap();
        for (StatusBarNotification statusBarNotification : listA) {
            if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i2) {
                a(map, statusBarNotification);
            }
        }
        for (Map.Entry<String, a> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                a value = entry.getValue();
                if (z && key.equals(strB) && !m673b(notification)) {
                    b bVar = new b(i2, notification);
                    if (m672a(notification)) {
                        value.f9343b.add(bVar);
                    } else {
                        value.f972a.add(bVar);
                    }
                }
                int size = value.f972a.size();
                if (value.f9343b.size() <= 0) {
                    if (z && size >= 2) {
                        a(context, strC, key, value.f972a.get(0).f973a);
                    }
                } else if (size <= 0) {
                    a(context, strC, key);
                } else if (ah.a(context).a(gk.NotificationGroupUpdateTimeSwitch.a(), false) && (notification2 = value.f9343b.get(0).f973a) != null) {
                    notification2.when = System.currentTimeMillis();
                    a(context, strC, key, notification2);
                }
            }
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String strB = b(statusBarNotification.getNotification());
        a aVar = map.get(strB);
        if (aVar == null) {
            aVar = new a();
            map.put(strB, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (m672a(statusBarNotification.getNotification())) {
            aVar.f9343b.add(bVar);
        } else {
            aVar.f972a.add(bVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private SpannableString m670a(Context context, String str) {
        Resources resources;
        DisplayMetrics displayMetrics;
        int iMax;
        if (this.f971a == null) {
            int i2 = 200;
            if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null && (iMax = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) > 0) {
                i2 = iMax / 16;
            }
            if (TextUtils.isEmpty(str)) {
                str = "\u65b0\u6d88\u606f";
            }
            StringBuilder sb = new StringBuilder(str.length() + i2 + 12);
            sb.append(str);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(' ');
            }
            sb.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb.length(), 33);
            this.f971a = spannableString;
        }
        return this.f971a;
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m48a("group show summary group is null");
                return;
            }
            int iA = ag.a(context, str);
            if (iA == 0) {
                com.xiaomi.channel.commonutils.logger.b.m48a("group show summary not get icon from " + str);
                return;
            }
            af afVarA = af.a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String strC = afVarA.c(notification.getChannelId(), "groupSummary");
                NotificationChannel notificationChannelM679a = afVarA.m679a(strC);
                if ("groupSummary".equals(strC) && notificationChannelM679a == null) {
                    afVarA.a(new NotificationChannel(strC, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, strC);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ag.a(defaults, true);
            Notification notificationBuild = defaults.setContentTitle(m670a(context, "\u65b0\u6d88\u606f")).setContentText("\u4f60\u6709\u4e00\u6761\u65b0\u6d88\u606f").setSmallIcon(Icon.createWithResource(str, iA)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (Build.VERSION.SDK_INT >= 31) {
                notificationBuild.contentIntent = a(context, str);
            }
            if (!com.xiaomi.push.j.m629c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ag.m686a(notificationBuild, str);
            }
            int iA2 = a(str, str2);
            afVarA.a(iA2, notificationBuild);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + iA2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("group show summary error " + e2);
        }
    }

    private PendingIntent a(Context context, String str) {
        PendingIntent activity;
        if (context == null && TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("ctx or pkg must not be null in getting launch intent");
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                com.xiaomi.channel.commonutils.logger.b.m48a("pm must not be null in getting launch intent");
                return null;
            }
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                com.xiaomi.channel.commonutils.logger.b.m48a("targetIntent must not be null in getting launch intent");
                return null;
            }
            launchIntentForPackage.addFlags(CommonNetImpl.FLAG_AUTH);
            if (Build.VERSION.SDK_INT >= 31) {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, CommonNetImpl.FLAG_SHARE_JUMP);
            } else {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 0);
            }
            return activity;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("error occurred during getting launch pendingIntent. exception:" + th);
            return null;
        }
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        af.a(context, str).a(a(str, str2));
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    private List<StatusBarNotification> a(af afVar) {
        List<StatusBarNotification> listM685b = afVar != null ? afVar.m685b() : null;
        if (listM685b == null || listM685b.size() == 0) {
            return null;
        }
        return listM685b;
    }
}
