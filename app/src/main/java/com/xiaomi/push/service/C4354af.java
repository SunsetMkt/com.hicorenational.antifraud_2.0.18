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
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4287i;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.EnumC4244gk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: com.xiaomi.push.service.af */
/* loaded from: classes2.dex */
public class C4354af {

    /* renamed from: a */
    private static Context f16511a;

    /* renamed from: a */
    private static Object f16512a;

    /* renamed from: a */
    private static WeakHashMap<Integer, C4354af> f16513a = new WeakHashMap<>();

    /* renamed from: a */
    private static boolean f16514a;

    /* renamed from: a */
    private String f16515a;

    /* renamed from: b */
    private String f16516b;

    private C4354af(String str) {
        this.f16515a = str;
    }

    /* renamed from: b */
    public static String m15885b(String str, String str2) {
        return m15878a(m15881a() ? "mipush|%s|%s" : "mipush_%s_%s", str, str2);
    }

    /* renamed from: a */
    public Context m15887a() {
        return f16511a;
    }

    /* renamed from: c */
    String m15898c(String str, String str2) {
        return m15881a() ? str : str2;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f16515a + "}";
    }

    /* renamed from: a */
    public String m15888a() {
        return this.f16515a;
    }

    /* renamed from: a */
    public static C4354af m15874a(Context context, String str) {
        m15879a(context);
        int hashCode = str.hashCode();
        C4354af c4354af = f16513a.get(Integer.valueOf(hashCode));
        if (c4354af != null) {
            return c4354af;
        }
        C4354af c4354af2 = new C4354af(str);
        f16513a.put(Integer.valueOf(hashCode), c4354af2);
        return c4354af2;
    }

    /* renamed from: b */
    private String m15884b(String str) {
        return m15885b(this.f16515a, str);
    }

    /* renamed from: b */
    String m15896b() {
        if (TextUtils.isEmpty(this.f16516b)) {
            this.f16516b = m15884b(AccsClientConfig.DEFAULT_CONFIGTAG);
        }
        return this.f16516b;
    }

    /* renamed from: b */
    public List<StatusBarNotification> m15897b() {
        StatusBarNotification[] m15883a;
        String str = this.f16515a;
        NotificationManager m15873a = m15873a();
        ArrayList arrayList = null;
        try {
            if (m15881a()) {
                int m15630a = C4287i.m15630a();
                if (m15630a != -1) {
                    return (List) m15875a(C4094aw.m13822a(f16512a, "getAppActiveNotifications", str, Integer.valueOf(m15630a)));
                }
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                m15883a = m15873a.getActiveNotifications();
            } else {
                m15883a = m15883a();
            }
            if (m15883a == null || m15883a.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : m15883a) {
                    if (str.equals(C4355ag.m15922c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                m15880a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static boolean m15882a(Context context) {
        m15879a(context);
        return m15881a();
    }

    /* renamed from: a */
    public static String m15877a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String m15878a = m15878a("mipush|%s|%s", str2, "");
        return str.startsWith(m15878a) ? m15878a("mipush_%s_%s", str2, str.replace(m15878a, "")) : str;
    }

    /* renamed from: a */
    private static void m15879a(Context context) {
        if (f16511a == null) {
            f16511a = context.getApplicationContext();
            NotificationManager m15873a = m15873a();
            Boolean bool = (Boolean) C4094aw.m13822a((Object) m15873a, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m15880a("fwk is support.init:" + bool);
            f16514a = bool != null ? bool.booleanValue() : false;
            if (f16514a) {
                f16512a = C4094aw.m13822a((Object) m15873a, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    private static NotificationManager m15873a() {
        return (NotificationManager) f16511a.getSystemService("notification");
    }

    /* renamed from: a */
    private static boolean m15881a() {
        if (C4300j.m15680a() && C4356ah.m15923a(f16511a).m15935a(EnumC4244gk.NotificationBelongToAppSwitch.m15014a(), true)) {
            return f16514a;
        }
        return false;
    }

    /* renamed from: a */
    private static int m15872a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return f16511a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static Object m15876a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    /* renamed from: a */
    private static <T> T m15875a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m15878a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    /* renamed from: a */
    public boolean m15895a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(m15884b(""));
    }

    /* renamed from: a */
    public String m15889a(String str) {
        if (TextUtils.isEmpty(str)) {
            return m15896b();
        }
        return C4300j.m15681a(m15887a()) ? m15884b(str) : str;
    }

    @TargetApi(26)
    /* renamed from: a */
    void m15893a(NotificationChannel notificationChannel) {
        String str = this.f16515a;
        try {
            if (m15881a()) {
                int m15872a = m15872a(str);
                if (m15872a != -1) {
                    C4094aw.m13831b(f16512a, "createNotificationChannelsForPackage", str, Integer.valueOf(m15872a), m15876a(Arrays.asList(notificationChannel)));
                }
            } else {
                m15873a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e2) {
            m15880a("createNotificationChannel error" + e2);
        }
    }

    @TargetApi(26)
    /* renamed from: a */
    public NotificationChannel m15886a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m15881a()) {
                List<NotificationChannel> m15890a = m15890a();
                if (m15890a != null) {
                    for (NotificationChannel notificationChannel2 : m15890a) {
                        if (str.equals(notificationChannel2.getId())) {
                            notificationChannel = notificationChannel2;
                            break;
                        }
                    }
                }
            } else {
                notificationChannel = m15873a().getNotificationChannel(str);
            }
        } catch (Exception e2) {
            m15880a("getNotificationChannel error" + e2);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @TargetApi(26)
    /* renamed from: a */
    public List<NotificationChannel> m15890a() {
        String str;
        String str2 = this.f16515a;
        List<NotificationChannel> list = null;
        try {
            if (m15881a()) {
                int m15872a = m15872a(str2);
                if (m15872a != -1) {
                    Object obj = f16512a;
                    Object[] objArr = {str2, Integer.valueOf(m15872a), false};
                    str = "mipush|%s|%s";
                    list = (List) m15875a(C4094aw.m13822a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                list = m15873a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!C4300j.m15680a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String m15878a = m15878a(str, str2, "");
            for (NotificationChannel notificationChannel : list) {
                if (notificationChannel.getId().startsWith(m15878a)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            m15880a("getNotificationChannels error " + e2);
            return list;
        }
    }

    /* renamed from: a */
    void m15894a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f16515a;
        try {
            if (z) {
                int m15872a = m15872a(str);
                if (m15872a != -1) {
                    C4094aw.m13831b(f16512a, "updateNotificationChannelForPackage", str, Integer.valueOf(m15872a), notificationChannel);
                }
            } else {
                m15893a(notificationChannel);
            }
        } catch (Exception e2) {
            m15880a("updateNotificationChannel error " + e2);
        }
    }

    /* renamed from: a */
    public void m15892a(int i2, Notification notification) {
        String str = this.f16515a;
        NotificationManager m15873a = m15873a();
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (!m15881a()) {
                m15873a.notify(i2, notification);
                return;
            }
            if (i3 >= 19) {
                notification.extras.putString("xmsf_target_package", str);
            }
            if (i3 >= 29) {
                m15873a.notifyAsPackage(str, null, i2, notification);
            } else {
                m15873a.notify(i2, notification);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void m15891a(int i2) {
        String str = this.f16515a;
        try {
            if (m15881a()) {
                int m15630a = C4287i.m15630a();
                String packageName = m15887a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    C4094aw.m13831b(f16512a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i2), Integer.valueOf(m15630a));
                } else {
                    C4094aw.m13831b(f16512a, "cancelNotificationWithTag", str, null, Integer.valueOf(i2), Integer.valueOf(m15630a));
                }
                m15880a("cancel succ:" + i2);
                return;
            }
            m15873a().cancel(i2);
        } catch (Exception e2) {
            m15880a("cancel error" + e2);
        }
    }

    /* renamed from: a */
    private StatusBarNotification[] m15883a() {
        if (!C4300j.m15681a(m15887a())) {
            return null;
        }
        try {
            Object m13822a = C4094aw.m13822a(f16512a, "getActiveNotifications", m15887a().getPackageName());
            if (m13822a instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) m13822a;
            }
            return null;
        } catch (Throwable th) {
            m15880a("getAllNotifications error " + th);
            return null;
        }
    }

    /* renamed from: a */
    static void m15880a(String str) {
        AbstractC4022b.m13347a("NMHelper:" + str);
    }
}
