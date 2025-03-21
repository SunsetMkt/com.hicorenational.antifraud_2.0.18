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
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private static Context f13323a;

    /* renamed from: a, reason: collision with other field name */
    private static Object f978a;

    /* renamed from: a, reason: collision with other field name */
    private static WeakHashMap<Integer, af> f979a = new WeakHashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private static boolean f980a;

    /* renamed from: a, reason: collision with other field name */
    private String f981a;

    /* renamed from: b, reason: collision with root package name */
    private String f13324b;

    private af(String str) {
        this.f981a = str;
    }

    public static String b(String str, String str2) {
        return a(m678a() ? "mipush|%s|%s" : "mipush_%s_%s", str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Context m682a() {
        return f13323a;
    }

    String c(String str, String str2) {
        return m678a() ? str : str2;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f981a + "}";
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m683a() {
        return this.f981a;
    }

    public static af a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        af afVar = f979a.get(Integer.valueOf(hashCode));
        if (afVar != null) {
            return afVar;
        }
        af afVar2 = new af(str);
        f979a.put(Integer.valueOf(hashCode), afVar2);
        return afVar2;
    }

    private String b(String str) {
        return b(this.f981a, str);
    }

    String b() {
        if (TextUtils.isEmpty(this.f13324b)) {
            this.f13324b = b(AccsClientConfig.DEFAULT_CONFIGTAG);
        }
        return this.f13324b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public List<StatusBarNotification> m687b() {
        StatusBarNotification[] m680a;
        String str = this.f981a;
        NotificationManager a2 = a();
        ArrayList arrayList = null;
        try {
            if (m678a()) {
                int a3 = com.xiaomi.push.i.a();
                if (a3 != -1) {
                    return (List) a(com.xiaomi.push.aw.a(f978a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
                }
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                m680a = a2.getActiveNotifications();
            } else {
                m680a = m680a();
            }
            if (m680a == null || m680a.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : m680a) {
                    if (str.equals(ag.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                m677a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m679a(Context context) {
        a(context);
        return m678a();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a("mipush|%s|%s", str2, "");
        return str.startsWith(a2) ? a("mipush_%s_%s", str2, str.replace(a2, "")) : str;
    }

    private static void a(Context context) {
        if (f13323a == null) {
            f13323a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) com.xiaomi.push.aw.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m677a("fwk is support.init:" + bool);
            f980a = bool != null ? bool.booleanValue() : false;
            if (f980a) {
                f978a = com.xiaomi.push.aw.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) f13323a.getSystemService("notification");
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m678a() {
        if (com.xiaomi.push.j.m626a() && ah.a(f13323a).a(gk.NotificationBelongToAppSwitch.a(), true)) {
            return f980a;
        }
        return false;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return f13323a.getPackageManager().getPackageUid(str, 0);
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

    /* renamed from: a, reason: collision with other method in class */
    public boolean m686a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m684a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        return com.xiaomi.push.j.m627a(m682a()) ? b(str) : str;
    }

    @TargetApi(26)
    void a(NotificationChannel notificationChannel) {
        String str = this.f981a;
        try {
            if (m678a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    com.xiaomi.push.aw.b(f978a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
                }
            } else {
                a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e2) {
            m677a("createNotificationChannel error" + e2);
        }
    }

    @TargetApi(26)
    /* renamed from: a, reason: collision with other method in class */
    public NotificationChannel m681a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m678a()) {
                List<NotificationChannel> m685a = m685a();
                if (m685a != null) {
                    for (NotificationChannel notificationChannel2 : m685a) {
                        if (str.equals(notificationChannel2.getId())) {
                            notificationChannel = notificationChannel2;
                            break;
                        }
                    }
                }
            } else {
                notificationChannel = a().getNotificationChannel(str);
            }
        } catch (Exception e2) {
            m677a("getNotificationChannel error" + e2);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @TargetApi(26)
    /* renamed from: a, reason: collision with other method in class */
    public List<NotificationChannel> m685a() {
        String str;
        String str2 = this.f981a;
        List<NotificationChannel> list = null;
        try {
            if (m678a()) {
                int a2 = a(str2);
                if (a2 != -1) {
                    Object obj = f978a;
                    Object[] objArr = {str2, Integer.valueOf(a2), false};
                    str = "mipush|%s|%s";
                    list = (List) a(com.xiaomi.push.aw.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                list = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!com.xiaomi.push.j.m626a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String a3 = a(str, str2, "");
            for (NotificationChannel notificationChannel : list) {
                if (notificationChannel.getId().startsWith(a3)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            m677a("getNotificationChannels error " + e2);
            return list;
        }
    }

    void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f981a;
        try {
            if (z) {
                int a2 = a(str);
                if (a2 != -1) {
                    com.xiaomi.push.aw.b(f978a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e2) {
            m677a("updateNotificationChannel error " + e2);
        }
    }

    public void a(int i2, Notification notification) {
        String str = this.f981a;
        NotificationManager a2 = a();
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (!m678a()) {
                a2.notify(i2, notification);
                return;
            }
            if (i3 >= 19) {
                notification.extras.putString("xmsf_target_package", str);
            }
            if (i3 >= 29) {
                a2.notifyAsPackage(str, null, i2, notification);
            } else {
                a2.notify(i2, notification);
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i2) {
        String str = this.f981a;
        try {
            if (m678a()) {
                int a2 = com.xiaomi.push.i.a();
                String packageName = m682a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.aw.b(f978a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i2), Integer.valueOf(a2));
                } else {
                    com.xiaomi.push.aw.b(f978a, "cancelNotificationWithTag", str, null, Integer.valueOf(i2), Integer.valueOf(a2));
                }
                m677a("cancel succ:" + i2);
                return;
            }
            a().cancel(i2);
        } catch (Exception e2) {
            m677a("cancel error" + e2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private StatusBarNotification[] m680a() {
        if (!com.xiaomi.push.j.m627a(m682a())) {
            return null;
        }
        try {
            Object a2 = com.xiaomi.push.aw.a(f978a, "getActiveNotifications", m682a().getPackageName());
            if (a2 instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) a2;
            }
            return null;
        } catch (Throwable th) {
            m677a("getAllNotifications error " + th);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    static void m677a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m50a("NMHelper:" + str);
    }
}
