package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4233g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import p000a.p001a.p014u.C0052a;

/* renamed from: com.xiaomi.push.service.ag */
/* loaded from: classes2.dex */
public class C4355ag {

    /* renamed from: a */
    public static final a<String, String, String> f16517a;

    /* renamed from: a */
    static Boolean f16518a;

    /* renamed from: b */
    public static final a<String, String, String> f16521b;

    /* renamed from: c */
    public static final a<String, String, String> f16522c;

    /* renamed from: d */
    public static final a<String, String, String> f16523d;

    /* renamed from: e */
    public static final a<String, String, String> f16524e;

    /* renamed from: f */
    public static final a<String, String, String> f16525f;

    /* renamed from: g */
    public static final a<String, String, String> f16526g;

    /* renamed from: h */
    public static final a<String, String, String> f16527h;

    /* renamed from: a */
    private static final String[] f16520a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: a */
    private static String f16519a = null;

    /* renamed from: com.xiaomi.push.service.ag$a */
    public static class a<F, S, T> {

        /* renamed from: a */
        F f16528a;

        /* renamed from: b */
        S f16529b;

        /* renamed from: c */
        T f16530c;

        private a(F f2, S s, T t) {
            this.f16528a = f2;
            this.f16529b = s;
            this.f16530c = t;
        }
    }

    static {
        String str = "getNotificationSettings";
        f16517a = new a<>(str, str, str);
        String str2 = "canSound";
        f16521b = new a<>("setSound", str2, str2);
        String str3 = "canVibrate";
        f16522c = new a<>("setVibrate", str3, str3);
        String str4 = "canLights";
        f16523d = new a<>("setLights", str4, str4);
        String str5 = "canShowOnKeyguard";
        f16524e = new a<>("setShowOnKeyguard", str5, str5);
        f16525f = new a<>("setFloat", "canFloat", "canShowFloat");
        String str6 = "canShowBadge";
        f16526g = new a<>("setShowBadge", str6, str6);
        String str7 = "canShowOngoing";
        f16527h = new a<>("setShowOngoing", str7, str7);
    }

    /* renamed from: a */
    public static boolean m15914a() {
        if (f16518a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                Bundle m16084a = C4383f.m16084a("com.xiaomi.xmsf", (String) null);
                if (m16084a == null || m16084a.isEmpty()) {
                    f16518a = false;
                } else {
                    f16518a = true;
                }
            } else {
                f16518a = false;
            }
        }
        return f16518a.booleanValue();
    }

    /* renamed from: b */
    public static String m15920b(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            if (TextUtils.isEmpty(charSequence) && Build.VERSION.SDK_INT >= 21) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* renamed from: c */
    public static String m15922c(Notification notification) {
        Object m13821a;
        try {
            r0 = notification.extras != null ? notification.extras.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE) : null;
            if (TextUtils.isEmpty(r0) && (m13821a = C4094aw.m13821a(notification, "extraNotification")) != null) {
                return (String) C4094aw.m13822a(m13821a, "getTargetPkg", new Object[0]);
            }
        } catch (Exception unused) {
        }
        return r0;
    }

    /* renamed from: b */
    public static void m15921b(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableKeyguard", z);
            }
            Object m13821a = C4094aw.m13821a(notification, "extraNotification");
            if (m13821a != null) {
                C4094aw.m13822a(m13821a, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static String m15906a(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* renamed from: a */
    public static Notification.Action[] m15919a(Notification notification) {
        Parcelable[] parcelableArray;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    /* renamed from: a */
    public static <T> T m15904a(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return null;
        }
        try {
            return (T) bundle.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m15913a(Map<String, String> map, Bundle bundle, String str) {
        if (map != null && bundle != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(map.get(str))) {
                bundle.remove(str);
                return;
            } else {
                bundle.putString(str, map.get(str));
                return;
            }
        }
        AbstractC4022b.m13347a("cp map to b fail:" + str);
    }

    /* renamed from: a */
    static void m15910a(Notification notification, String str) {
        try {
            if (notification.extras != null) {
                notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object m13821a = C4094aw.m13821a(notification, "extraNotification");
            if (m13821a != null) {
                C4094aw.m13822a(m13821a, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static void m15911a(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableFloat", z);
            }
            Object m13821a = C4094aw.m13821a(notification, "extraNotification");
            if (m13821a != null) {
                C4094aw.m13822a(m13821a, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static void m15908a(Notification notification, int i2) {
        try {
            if (notification.extras != null) {
                notification.extras.putInt("miui.messageCount", i2);
            }
            Object m13821a = C4094aw.m13821a(notification, "extraNotification");
            if (m13821a != null) {
                C4094aw.m13822a(m13821a, "setMessageCount", Integer.valueOf(i2));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static void m15909a(Notification notification, int i2, int i3) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i2);
            notification.extras.putInt("mipush_class", i3);
        }
    }

    /* renamed from: a */
    public static String m15907a(Object obj) {
        return (String) m15905a(obj, "msg_busi_type", "");
    }

    /* renamed from: a */
    public static <T> T m15905a(Object obj, String str, T t) {
        Object obj2 = null;
        try {
            if (obj instanceof Notification) {
                obj2 = m15904a((Notification) obj, str);
            } else if (obj instanceof Map) {
                obj2 = ((Map) obj).get(str);
            } else if (obj instanceof Bundle) {
                obj2 = ((Bundle) obj).get(str);
            } else {
                AbstractC4022b.m13347a("not support get value from classType:" + obj);
            }
        } catch (Exception e2) {
            AbstractC4022b.m13347a("get value error " + e2);
        }
        return obj2 == null ? t : (T) obj2;
    }

    /* renamed from: a */
    static int m15900a(Context context, String str) {
        return C4233g.m14936b(context, str);
    }

    /* renamed from: a */
    static void m15912a(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f16520a));
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = (String) arrayList.get(i2);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("can't match url intent. " + e2);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    /* renamed from: a */
    public static int m15899a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e2) {
            AbstractC4022b.m13347a("get user aggregate failed, " + e2);
            return 0;
        }
    }

    /* renamed from: a */
    public static boolean m15916a(ContentResolver contentResolver) {
        int m15899a = m15899a(contentResolver);
        return m15899a == 1 || m15899a == 2;
    }

    /* renamed from: a */
    public static boolean m15918a(Map<String, String> map) {
        return Boolean.parseBoolean((String) m15905a(map, "not_suppress", C0052a.f158j));
    }

    /* renamed from: a */
    public static boolean m15915a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        AbstractC4022b.m13356b("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a */
    public static int m15901a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar == null) {
            return -1;
        }
        try {
            Bundle m15903a = m15903a(context, aVar.f16529b, str, str2, (Bundle) null);
            if (m15903a == null || !m15903a.containsKey(aVar.f16530c)) {
                return -1;
            }
            return m15903a.getBoolean(aVar.f16530c) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static Bundle m15902a(Context context, String str, String str2) {
        try {
            return m15903a(context, f16517a.f16529b, str, str2, (Bundle) null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m15917a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.f16530c, z);
                m15903a(context, aVar.f16528a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static Bundle m15903a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("package", str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle2.putString("channel_id", str3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
        }
        throw new IllegalArgumentException("call notification provider failed!");
    }
}
