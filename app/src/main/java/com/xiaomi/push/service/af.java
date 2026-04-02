package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.xiaomi.push.gk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class af {
    private static Context a;

    /* JADX INFO: renamed from: a */
    private static Object f978a;

    /* JADX INFO: renamed from: a */
    private static WeakHashMap<Integer, af> f979a = new WeakHashMap<>();

    /* JADX INFO: renamed from: a */
    private static boolean f980a;

    /* JADX INFO: renamed from: a */
    private String f981a;

    /* JADX INFO: renamed from: b */
    private String f9345b;

    private af(String str) {
        this.f981a = str;
    }

    public static String b(String str, String str2) {
        return a(m676a() ? "mipush|%s|%s" : "mipush_%s_%s", str, str2);
    }

    /* JADX INFO: renamed from: a */
    public Context m680a() {
        return a;
    }

    String c(String str, String str2) {
        return m676a() ? str : str2;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f981a + "}";
    }

    /* JADX INFO: renamed from: a */
    public String m681a() {
        return this.f981a;
    }

    public static af a(Context context, String str) {
        a(context);
        int iHashCode = str.hashCode();
        af afVar = f979a.get(Integer.valueOf(iHashCode));
        if (afVar != null) {
            return afVar;
        }
        af afVar2 = new af(str);
        f979a.put(Integer.valueOf(iHashCode), afVar2);
        return afVar2;
    }

    private String b(String str) {
        return b(this.f981a, str);
    }

    String b() {
        if (TextUtils.isEmpty(this.f9345b)) {
            this.f9345b = b(AccsClientConfig.DEFAULT_CONFIGTAG);
        }
        return this.f9345b;
    }

    /* JADX INFO: renamed from: b */
    public List<StatusBarNotification> m685b() {
        StatusBarNotification[] statusBarNotificationArrM678a;
        String str = this.f981a;
        NotificationManager notificationManagerA = a();
        ArrayList arrayList = null;
        try {
            if (m676a()) {
                int iA = com.xiaomi.push.i.a();
                if (iA != -1) {
                    return (List) a(com.xiaomi.push.aw.a(f978a, "getAppActiveNotifications", str, Integer.valueOf(iA)));
                }
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                statusBarNotificationArrM678a = notificationManagerA.getActiveNotifications();
            } else {
                statusBarNotificationArrM678a = m678a();
            }
            if (statusBarNotificationArrM678a == null || statusBarNotificationArrM678a.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : statusBarNotificationArrM678a) {
                    if (str.equals(ag.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                m675a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m677a(Context context) {
        a(context);
        return m676a();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = a("mipush|%s|%s", str2, "");
        return str.startsWith(strA) ? a("mipush_%s_%s", str2, str.replace(strA, "")) : str;
    }

    private static void a(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
            NotificationManager notificationManagerA = a();
            Boolean bool = (Boolean) com.xiaomi.push.aw.a((Object) notificationManagerA, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m675a("fwk is support.init:" + bool);
            f980a = bool != null ? bool.booleanValue() : false;
            if (f980a) {
                f978a = com.xiaomi.push.aw.a((Object) notificationManagerA, "getService", new Object[0]);
            }
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) a.getSystemService("notification");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m676a() {
        if (com.xiaomi.push.j.m624a() && ah.a(a).a(gk.NotificationBelongToAppSwitch.a(), true)) {
            return f980a;
        }
        return false;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    /* JADX INFO: renamed from: a */
    public boolean m684a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    /* JADX INFO: renamed from: a */
    public String m682a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        return com.xiaomi.push.j.m625a(m680a()) ? b(str) : str;
    }

    @TargetApi(26)
    void a(NotificationChannel notificationChannel) {
        String str = this.f981a;
        try {
            if (m676a()) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.aw.b(f978a, "createNotificationChannelsForPackage", str, Integer.valueOf(iA), a(Arrays.asList(notificationChannel)));
                }
            } else {
                a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e2) {
            m675a("createNotificationChannel error" + e2);
        }
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a */
    public NotificationChannel m679a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m676a()) {
                List<NotificationChannel> listM683a = m683a();
                if (listM683a != null) {
                    Iterator<NotificationChannel> it = listM683a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            NotificationChannel next = it.next();
                            if (str.equals(next.getId())) {
                                notificationChannel = next;
                                break;
                            }
                        }
                    }
                }
            } else {
                notificationChannel = a().getNotificationChannel(str);
            }
            break;
        } catch (Exception e2) {
            m675a("getNotificationChannel error" + e2);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @TargetApi(26)
    /* JADX INFO: renamed from: a */
    public List<NotificationChannel> m683a() {
        String str;
        String str2 = this.f981a;
        List<NotificationChannel> notificationChannels = null;
        try {
            if (m676a()) {
                int iA = a(str2);
                if (iA != -1) {
                    Object obj = f978a;
                    Object[] objArr = {str2, Integer.valueOf(iA), false};
                    str = "mipush|%s|%s";
                    notificationChannels = (List) a(com.xiaomi.push.aw.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                notificationChannels = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!com.xiaomi.push.j.m624a() || notificationChannels == null) {
                return notificationChannels;
            }
            ArrayList arrayList = new ArrayList();
            String strA = a(str, str2, "");
            for (NotificationChannel notificationChannel : notificationChannels) {
                if (notificationChannel.getId().startsWith(strA)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            m675a("getNotificationChannels error " + e2);
            return notificationChannels;
        }
    }

    void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f981a;
        try {
            if (z) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.aw.b(f978a, "updateNotificationChannelForPackage", str, Integer.valueOf(iA), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e2) {
            m675a("updateNotificationChannel error " + e2);
        }
    }

    public void a(int i2, Notification notification) {
        String str = this.f981a;
        NotificationManager notificationManagerA = a();
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (!m676a()) {
                notificationManagerA.notify(i2, notification);
                return;
            }
            if (i3 >= 19) {
                notification.extras.putString("xmsf_target_package", str);
            }
            if (i3 >= 29) {
                notificationManagerA.notifyAsPackage(str, null, i2, notification);
            } else {
                notificationManagerA.notify(i2, notification);
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i2) {
        String str = this.f981a;
        try {
            if (m676a()) {
                int iA = com.xiaomi.push.i.a();
                String packageName = m680a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.aw.b(f978a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i2), Integer.valueOf(iA));
                } else {
                    com.xiaomi.push.aw.b(f978a, "cancelNotificationWithTag", str, null, Integer.valueOf(i2), Integer.valueOf(iA));
                }
                m675a("cancel succ:" + i2);
                return;
            }
            a().cancel(i2);
        } catch (Exception e2) {
            m675a("cancel error" + e2);
        }
    }

    /* JADX INFO: renamed from: a */
    private StatusBarNotification[] m678a() {
        if (!com.xiaomi.push.j.m625a(m680a())) {
            return null;
        }
        try {
            Object objA = com.xiaomi.push.aw.a(f978a, "getActiveNotifications", m680a().getPackageName());
            if (objA instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) objA;
            }
            return null;
        } catch (Throwable th) {
            m675a("getAllNotifications error " + th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static void m675a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m48a("NMHelper:" + str);
    }
}
