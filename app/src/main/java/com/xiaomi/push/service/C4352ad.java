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
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.EnumC4244gk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(24)
/* renamed from: com.xiaomi.push.service.ad */
/* loaded from: classes2.dex */
class C4352ad {

    /* renamed from: a */
    private static C4352ad f16496a = new C4352ad();

    /* renamed from: a */
    private SpannableString f16497a;

    /* renamed from: com.xiaomi.push.service.ad$a */
    private class a {

        /* renamed from: a */
        List<b> f16499a;

        /* renamed from: b */
        List<b> f16500b;

        private a() {
            this.f16499a = new ArrayList();
            this.f16500b = new ArrayList();
        }
    }

    /* renamed from: com.xiaomi.push.service.ad$b */
    private class b {

        /* renamed from: a */
        int f16501a;

        /* renamed from: a */
        Notification f16502a;

        public b(int i2, Notification notification) {
            this.f16501a = i2;
            this.f16502a = notification;
        }

        public String toString() {
            return "id:" + this.f16501a;
        }
    }

    private C4352ad() {
    }

    /* renamed from: a */
    public static C4352ad m15845a() {
        return f16496a;
    }

    /* renamed from: b */
    private boolean m15858b(Context context) {
        return C4356ah.m15923a(context).m15935a(EnumC4244gk.NotificationAutoGroupSwitch.m15014a(), true);
    }

    /* renamed from: a */
    private boolean m15852a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: a */
    private boolean m15854a(Context context) {
        if (m15858b(context) && C4354af.m15882a(context)) {
            return C4356ah.m15923a(context).m15935a(EnumC4244gk.LatestNotificationNotIntoGroupSwitch.m15014a(), false);
        }
        return false;
    }

    /* renamed from: b */
    private String m15855b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m15857b(notification) ? m15846a(notification) : notification.getGroup();
    }

    /* renamed from: b */
    private boolean m15857b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), m15846a(notification)));
    }

    /* renamed from: a */
    private String m15846a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    /* renamed from: a */
    private boolean m15853a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object m13822a = C4094aw.m13822a((Object) notification, "isGroupSummary", (Object[]) null);
        if (m13822a instanceof Boolean) {
            return ((Boolean) m13822a).booleanValue();
        }
        return false;
    }

    /* renamed from: b */
    private void m15856b(Context context, int i2, Notification notification) {
        String m15922c = C4355ag.m15922c(notification);
        if (TextUtils.isEmpty(m15922c)) {
            AbstractC4022b.m13347a("group restore not extract pkg from notification:" + i2);
            return;
        }
        C4354af m15874a = C4354af.m15874a(context, m15922c);
        List<StatusBarNotification> m15847a = m15847a(m15874a);
        if (m15847a == null) {
            AbstractC4022b.m13347a("group restore not get notifications");
            return;
        }
        for (StatusBarNotification statusBarNotification : m15847a) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && m15857b(notification2) && statusBarNotification.getId() != i2) {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                recoverBuilder.setGroup(m15846a(notification2));
                C4355ag.m15915a(recoverBuilder, m15853a(notification2));
                m15874a.m15892a(statusBarNotification.getId(), recoverBuilder.build());
                AbstractC4022b.m13356b("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    /* renamed from: a */
    public String m15859a(Context context, Notification.Builder builder, String str) {
        if (!m15852a() || !m15854a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
    }

    /* renamed from: a */
    public void m15860a(Context context, int i2, Notification notification) {
        if (m15852a()) {
            if (m15854a(context)) {
                try {
                    m15856b(context, i2, notification);
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("group notify handle restore error " + e2);
                }
            }
            if (m15858b(context)) {
                try {
                    m15848a(context, i2, notification, true);
                } catch (Exception e3) {
                    AbstractC4022b.m13347a("group notify handle auto error " + e3);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15848a(Context context, int i2, Notification notification, boolean z) {
        Notification notification2;
        String m15922c = C4355ag.m15922c(notification);
        if (TextUtils.isEmpty(m15922c)) {
            AbstractC4022b.m13347a("group auto not extract pkg from notification:" + i2);
            return;
        }
        List<StatusBarNotification> m15847a = m15847a(C4354af.m15874a(context, m15922c));
        if (m15847a == null) {
            AbstractC4022b.m13347a("group auto not get notifications");
            return;
        }
        String m15855b = m15855b(notification);
        HashMap hashMap = new HashMap();
        for (StatusBarNotification statusBarNotification : m15847a) {
            if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i2) {
                m15851a(hashMap, statusBarNotification);
            }
        }
        for (Map.Entry<String, a> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                a value = entry.getValue();
                if (z && key.equals(m15855b) && !m15857b(notification)) {
                    b bVar = new b(i2, notification);
                    if (m15853a(notification)) {
                        value.f16500b.add(bVar);
                    } else {
                        value.f16499a.add(bVar);
                    }
                }
                int size = value.f16499a.size();
                if (value.f16500b.size() <= 0) {
                    if (z && size >= 2) {
                        m15850a(context, m15922c, key, value.f16499a.get(0).f16502a);
                    }
                } else if (size <= 0) {
                    m15849a(context, m15922c, key);
                } else if (C4356ah.m15923a(context).m15935a(EnumC4244gk.NotificationGroupUpdateTimeSwitch.m15014a(), false) && (notification2 = value.f16500b.get(0).f16502a) != null) {
                    notification2.when = System.currentTimeMillis();
                    m15850a(context, m15922c, key, notification2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15851a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String m15855b = m15855b(statusBarNotification.getNotification());
        a aVar = map.get(m15855b);
        if (aVar == null) {
            aVar = new a();
            map.put(m15855b, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (m15853a(statusBarNotification.getNotification())) {
            aVar.f16500b.add(bVar);
        } else {
            aVar.f16499a.add(bVar);
        }
    }

    /* renamed from: a */
    private SpannableString m15844a(Context context, String str) {
        Resources resources;
        DisplayMetrics displayMetrics;
        int max;
        if (this.f16497a == null) {
            int i2 = 200;
            if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null && (max = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) > 0) {
                i2 = max / 16;
            }
            if (TextUtils.isEmpty(str)) {
                str = "新消息";
            }
            StringBuilder sb = new StringBuilder(str.length() + i2 + 12);
            sb.append(str);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(' ');
            }
            sb.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb.length(), 33);
            this.f16497a = spannableString;
        }
        return this.f16497a;
    }

    /* renamed from: a */
    private void m15850a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                AbstractC4022b.m13347a("group show summary group is null");
                return;
            }
            int m15900a = C4355ag.m15900a(context, str);
            if (m15900a == 0) {
                AbstractC4022b.m13347a("group show summary not get icon from " + str);
                return;
            }
            C4354af m15874a = C4354af.m15874a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String m15898c = m15874a.m15898c(notification.getChannelId(), "groupSummary");
                NotificationChannel m15886a = m15874a.m15886a(m15898c);
                if ("groupSummary".equals(m15898c) && m15886a == null) {
                    m15874a.m15893a(new NotificationChannel(m15898c, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, m15898c);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            C4355ag.m15915a(defaults, true);
            Notification build = defaults.setContentTitle(m15844a(context, "新消息")).setContentText("你有一条新消息").setSmallIcon(Icon.createWithResource(str, m15900a)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (Build.VERSION.SDK_INT >= 31) {
                build.contentIntent = m15843a(context, str);
            }
            if (!C4300j.m15689c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                C4355ag.m15910a(build, str);
            }
            int m15842a = m15842a(str, str2);
            m15874a.m15892a(m15842a, build);
            AbstractC4022b.m13356b("group show summary notify:" + m15842a);
        } catch (Exception e2) {
            AbstractC4022b.m13347a("group show summary error " + e2);
        }
    }

    /* renamed from: a */
    private PendingIntent m15843a(Context context, String str) {
        PendingIntent activity;
        if (context == null && TextUtils.isEmpty(str)) {
            AbstractC4022b.m13347a("ctx or pkg must not be null in getting launch intent");
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AbstractC4022b.m13347a("pm must not be null in getting launch intent");
                return null;
            }
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                AbstractC4022b.m13347a("targetIntent must not be null in getting launch intent");
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
            AbstractC4022b.m13361d("error occurred during getting launch pendingIntent. exception:" + th);
            return null;
        }
    }

    /* renamed from: a */
    private void m15849a(Context context, String str, String str2) {
        AbstractC4022b.m13356b("group cancel summary:" + str2);
        C4354af.m15874a(context, str).m15891a(m15842a(str, str2));
    }

    /* renamed from: a */
    private int m15842a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    /* renamed from: a */
    private List<StatusBarNotification> m15847a(C4354af c4354af) {
        List<StatusBarNotification> m15897b = c4354af != null ? c4354af.m15897b() : null;
        if (m15897b == null || m15897b.size() == 0) {
            return null;
        }
        return m15897b;
    }
}
