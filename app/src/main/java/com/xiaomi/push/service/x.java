package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import anet.channel.util.HttpConstant;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.just.agentweb.DefaultWebClient;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.push.ae;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.g;
import com.xiaomi.push.gf;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.service.ae;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static long a;

    /* JADX INFO: renamed from: a */
    private static volatile ab f1087a;

    /* JADX INFO: renamed from: a */
    private static final LinkedList<Pair<Integer, hb>> f1088a = new LinkedList<>();

    /* JADX INFO: renamed from: a */
    private static ExecutorService f1089a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: com.xiaomi.push.service.x$1 */
    static class AnonymousClass1 extends ae.a {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ af f1090a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f1091a;

        AnonymousClass1(String str, af afVar, int i2) {
            str = str;
            afVar = afVar;
            i = i2;
        }

        @Override // com.xiaomi.push.ae.a
        /* JADX INFO: renamed from: a */
        public String mo181a() {
            return str;
        }

        @Override // java.lang.Runnable
        public void run() {
            afVar.a(i);
        }
    }

    private static class a implements Callable<Bitmap> {
        private Context a;

        /* JADX INFO: renamed from: a */
        private String f1092a;

        /* JADX INFO: renamed from: a */
        private boolean f1093a;

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f1092a = str;
            this.f1093a = z;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a */
        public Bitmap call() throws Throwable {
            if (TextUtils.isEmpty(this.f1092a)) {
                com.xiaomi.channel.commonutils.logger.b.m48a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f1092a.startsWith(HttpConstant.HTTP)) {
                ae.b bVarA = ae.a(this.a, this.f1092a, this.f1093a);
                if (bVarA != null) {
                    return bVarA.f977a;
                }
                com.xiaomi.channel.commonutils.logger.b.m48a("Failed get online picture/icon resource");
                return null;
            }
            Bitmap bitmapA = ae.a(this.a, this.f1092a);
            if (bitmapA != null) {
                return bitmapA;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("Failed get online picture/icon resource");
            return bitmapA;
        }
    }

    public static class b {
        long a = 0;

        /* JADX INFO: renamed from: a */
        Notification f1094a;
    }

    public static class c {

        /* JADX INFO: renamed from: a */
        public String f1095a;
        public long a = 0;

        /* JADX INFO: renamed from: a */
        public boolean f1096a = false;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m753a(Context context, String str) {
        return com.xiaomi.push.g.m454b(context, str);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m760b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("meta extra is null");
        return false;
    }

    static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean d(hb hbVar) {
        return hbVar.a() == gf.Registration;
    }

    public static boolean e(hb hbVar) {
        return m755a(hbVar) || c(hbVar) || m759b(hbVar);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m754a(Context context, String str, boolean z) {
        return com.xiaomi.push.j.m624a() && !z && m753a(context, str);
    }

    public static boolean c(hb hbVar) {
        gs gsVarM527a = hbVar.m527a();
        return a(gsVarM527a) && gsVarM527a.f634b == 0 && !m755a(hbVar);
    }

    /* JADX INFO: renamed from: a */
    public static c m751a(Context context, hb hbVar, byte[] bArr) throws Throwable {
        int iC;
        Map<String, String> mapM494a;
        c cVar = new c();
        g.b bVarA = com.xiaomi.push.g.a(context, a(hbVar), true);
        gs gsVarM527a = hbVar.m527a();
        if (gsVarM527a != null) {
            iC = gsVarM527a.c();
            mapM494a = gsVarM527a.m494a();
        } else {
            iC = 0;
            mapM494a = null;
        }
        int iB = com.xiaomi.push.s.b(a(hbVar), iC);
        if (com.xiaomi.push.j.m625a(context) && bVarA == g.b.NOT_ALLOWED) {
            if (gsVarM527a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM527a.m493a(), "10:" + a(hbVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("Do not notify because user block " + a(hbVar) + "\u2018s notification");
            return cVar;
        }
        if (com.xiaomi.push.j.m625a(context) && f1087a != null && f1087a.m668a(context, iB, a(hbVar), mapM494a)) {
            if (gsVarM527a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM527a.m493a(), "14:" + a(hbVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("Do not notify because card notification is canceled or sequence incorrect");
            return cVar;
        }
        RemoteViews remoteViewsA = a(context, hbVar, bArr);
        PendingIntent pendingIntentA = a(context, hbVar, hbVar.b(), bArr, iB);
        if (pendingIntentA == null) {
            if (gsVarM527a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM527a.m493a(), "11");
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("The click PendingIntent is null. ");
            return cVar;
        }
        b bVarA2 = a(context, hbVar, bArr, remoteViewsA, pendingIntentA, iB);
        cVar.a = bVarA2.a;
        cVar.f1095a = a(hbVar);
        Notification notification = bVarA2.f1094a;
        if (com.xiaomi.push.j.m624a()) {
            if (!TextUtils.isEmpty(gsVarM527a.m493a())) {
                notification.extras.putString("message_id", gsVarM527a.m493a());
            }
            notification.extras.putString("local_paid", hbVar.m528a());
            ag.a(mapM494a, notification.extras, "msg_busi_type");
            ag.a(mapM494a, notification.extras, "disable_notification_flags");
            String str = gsVarM527a.m499b() == null ? null : gsVarM527a.m499b().get("score_info");
            if (!TextUtils.isEmpty(str)) {
                notification.extras.putString("score_info", str);
            }
            notification.extras.putString("pushUid", a(gsVarM527a.f632a, "n_stats_expose"));
            int i2 = -1;
            if (c(hbVar)) {
                i2 = 1000;
            } else if (m755a(hbVar)) {
                i2 = PathInterpolatorCompat.MAX_NUM_POINTS;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i2));
            notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(hbVar));
        }
        String str2 = gsVarM527a.m494a() == null ? null : gsVarM527a.m494a().get("message_count");
        if (com.xiaomi.push.j.m624a() && str2 != null) {
            try {
                ag.a(notification, Integer.parseInt(str2));
            } catch (NumberFormatException e2) {
                if (gsVarM527a != null) {
                    dt.a(context.getApplicationContext()).b(hbVar.b(), b(hbVar), gsVarM527a.m493a(), "8");
                }
                com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e2);
            }
        }
        String strA = a(hbVar);
        ag.m686a(notification, strA);
        af afVarA = af.a(context, strA);
        if (com.xiaomi.push.j.m625a(context) && f1087a != null) {
            f1087a.a(hbVar, gsVarM527a.m494a(), iB, notification);
        }
        if (com.xiaomi.push.j.m625a(context) && f1087a != null && f1087a.a(gsVarM527a.m494a(), iB, notification)) {
            com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
        } else {
            afVarA.a(iB, notification);
            cVar.f1096a = true;
            com.xiaomi.channel.commonutils.logger.b.m48a("notification: " + gsVarM527a.m493a() + " is notifyied");
        }
        if (com.xiaomi.push.j.m624a() && com.xiaomi.push.j.m625a(context)) {
            ad.a().a(context, iB, notification);
            bb.m711a(context, strA, iB, gsVarM527a.m493a(), notification);
        }
        if (m755a(hbVar)) {
            dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM527a.m493a(), ErrorStatus.r0, null);
        }
        if (c(hbVar)) {
            dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM527a.m493a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            String strM493a = gsVarM527a != null ? gsVarM527a.m493a() : null;
            com.xiaomi.push.ae aeVarA = com.xiaomi.push.ae.a(context);
            int iA = a(gsVarM527a.m494a());
            if (iA > 0 && !TextUtils.isEmpty(strM493a)) {
                String str3 = "n_timeout_" + strM493a;
                aeVarA.m129a(str3);
                aeVarA.b(new ae.a() { // from class: com.xiaomi.push.service.x.1
                    final /* synthetic */ int a;

                    /* JADX INFO: renamed from: a */
                    final /* synthetic */ af f1090a;

                    /* JADX INFO: renamed from: a */
                    final /* synthetic */ String f1091a;

                    AnonymousClass1(String str32, af afVarA2, int iB2) {
                        str = str32;
                        afVar = afVarA2;
                        i = iB2;
                    }

                    @Override // com.xiaomi.push.ae.a
                    /* JADX INFO: renamed from: a */
                    public String mo181a() {
                        return str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        afVar.a(i);
                    }
                }, iA);
            }
        }
        Pair<Integer, hb> pair = new Pair<>(Integer.valueOf(iB2), hbVar);
        synchronized (f1088a) {
            f1088a.add(pair);
            if (f1088a.size() > 100) {
                f1088a.remove();
            }
        }
        return cVar;
    }

    private static int b(Context context, String str) {
        int iA = a(context, str, "mipush_notification");
        int iA2 = a(context, str, "mipush_small_notification");
        if (iA <= 0) {
            iA = iA2 > 0 ? iA2 : context.getApplicationInfo().icon;
        }
        return iA == 0 ? context.getApplicationInfo().logo : iA;
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e2);
            return 0;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m757b(Context context, String str) {
        if (!com.xiaomi.push.j.m625a(context) || f1087a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f1087a.a(str);
    }

    /* JADX INFO: renamed from: b */
    static boolean m758b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    static void b(Context context, String str, int i2) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i2).commit();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m759b(hb hbVar) {
        gs gsVarM527a = hbVar.m527a();
        return a(gsVarM527a) && gsVarM527a.f634b == 1 && !m755a(hbVar);
    }

    public static String b(hb hbVar) {
        return m755a(hbVar) ? "E100002" : c(hbVar) ? "E100000" : m759b(hbVar) ? "E100001" : d(hbVar) ? "E100003" : "";
    }

    private static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e2);
            return 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent b(Context context, String str, Map<String, String> map, int i2) {
        Intent launchIntentForPackage;
        String str2;
        Intent uri;
        if (map == null) {
            return null;
        }
        if (i2 != 0) {
            return m750a(context, str, map, i2);
        }
        if (!map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        int i3 = -1;
        String str4 = map.get("intent_flag");
        try {
            if (!TextUtils.isEmpty(str4)) {
                i3 = Integer.parseInt(str4);
            }
        } catch (NumberFormatException e2) {
            com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e2.getMessage());
        }
        if (an.a.equals(str3)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e3) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e3.getMessage());
                launchIntentForPackage = null;
            }
        } else if (an.f9370b.equals(str3)) {
            if (map.containsKey("intent_uri")) {
                String str5 = map.get("intent_uri");
                if (str5 != null) {
                    try {
                        uri = Intent.parseUri(str5, 1);
                        try {
                            uri.setPackage(str);
                        } catch (URISyntaxException e4) {
                            e = e4;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                        }
                    } catch (URISyntaxException e5) {
                        e = e5;
                        uri = null;
                    }
                } else {
                    uri = null;
                }
                launchIntentForPackage = uri;
            } else if (map.containsKey("class_name")) {
                String str6 = map.get("class_name");
                launchIntentForPackage = new Intent();
                launchIntentForPackage.setComponent(new ComponentName(str, str6));
            } else {
                launchIntentForPackage = null;
            }
        } else if (an.f9371c.equals(str3) && (str2 = map.get("web_uri")) != null) {
            String strTrim = str2.trim();
            if (!strTrim.startsWith(DefaultWebClient.HTTP_SCHEME) && !strTrim.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                strTrim = DefaultWebClient.HTTP_SCHEME + strTrim;
            }
            try {
                String protocol = new URL(strTrim).getProtocol();
                if (HttpConstant.HTTP.equals(protocol) || HttpConstant.HTTPS.equals(protocol)) {
                    launchIntentForPackage = new Intent("android.intent.action.VIEW");
                    try {
                        launchIntentForPackage.setData(Uri.parse(strTrim));
                        ag.a(context, str, launchIntentForPackage);
                    } catch (MalformedURLException e6) {
                        e = e6;
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                    }
                }
            } catch (MalformedURLException e7) {
                e = e7;
                launchIntentForPackage = null;
            }
        }
        if (launchIntentForPackage != null) {
            if (i3 >= 0) {
                launchIntentForPackage.setFlags(i3);
            }
            a(launchIntentForPackage);
            launchIntentForPackage.addFlags(CommonNetImpl.FLAG_AUTH);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.j.m625a(context) && an.f9371c.equals(str3)) {
                    return launchIntentForPackage;
                }
                com.xiaomi.channel.commonutils.logger.b.m48a("not resolve activity:" + launchIntentForPackage);
            } catch (Exception e8) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(Context context, String str, dv dvVar, Map<String, String> map) {
        boolean z;
        int iA;
        if (!com.xiaomi.push.j.m625a(context)) {
            String strA = a(map, "fcm_icon_uri");
            String strA2 = a(map, "fcm_icon_color");
            if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2) || (iA = a(context, str, strA)) <= 0) {
                z = false;
            } else {
                z = true;
                dvVar.setSmallIcon(iA);
                dvVar.mo360a(strA2);
            }
        }
        if (z) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            dvVar.setSmallIcon(Icon.createWithResource(str, ag.a(context, str)));
        } else {
            dvVar.setSmallIcon(b(context, str));
        }
    }

    private static PendingIntent a(Context context, hb hbVar, String str, byte[] bArr, int i2) {
        return a(context, hbVar, str, bArr, i2, 0, a(context, hbVar, str));
    }

    private static PendingIntent a(Context context, hb hbVar, String str, byte[] bArr, int i2, int i3, boolean z) {
        int i4;
        Intent intent;
        if (c(hbVar)) {
            i4 = 1000;
        } else {
            i4 = m755a(hbVar) ? PathInterpolatorCompat.MAX_NUM_POINTS : -1;
        }
        gs gsVarM527a = hbVar.m527a();
        String strM493a = gsVarM527a != null ? gsVarM527a.m493a() : "";
        boolean zM755a = m755a(hbVar);
        if (gsVarM527a != null && !TextUtils.isEmpty(gsVarM527a.f641e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(gsVarM527a.f641e));
            try {
                String protocol = new URL(gsVarM527a.f641e).getProtocol();
                if (!HttpConstant.HTTP.equals(protocol) && !HttpConstant.HTTPS.equals(protocol)) {
                    intent2.setPackage(str);
                } else {
                    ag.a(context, str, intent2);
                }
            } catch (MalformedURLException unused) {
                com.xiaomi.channel.commonutils.logger.b.m48a("meet URL exception : " + gsVarM527a.f641e);
                intent2.setPackage(str);
            }
            intent2.addFlags(CommonNetImpl.FLAG_AUTH);
            intent2.putExtra("messageId", strM493a);
            intent2.putExtra("eventMessageType", i4);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getActivity(context, 0, intent2, 167772160);
            }
            return PendingIntent.getActivity(context, 0, intent2, d.c.a.b.a.a.C1);
        }
        if (zM755a) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i2));
            intent.addCategory(String.valueOf(strM493a));
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i2));
            intent.addCategory(String.valueOf(strM493a));
        }
        intent.putExtra("notification_click_button", i3);
        intent.putExtra("messageId", strM493a);
        intent.putExtra("eventMessageType", i4);
        if (!zM755a && z) {
            Intent intent3 = new Intent();
            intent3.setComponent(a(str));
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.addCategory(String.valueOf(i2));
            intent3.addCategory(String.valueOf(strM493a));
            intent3.addCategory(String.valueOf(i3));
            a(context, intent3, hbVar, gsVarM527a, strM493a, i3);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getActivity(context, 0, intent3, 167772160);
            }
            return PendingIntent.getActivity(context, 0, intent3, d.c.a.b.a.a.C1);
        }
        a(context, intent, hbVar, gsVarM527a, strM493a, i3);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getService(context, 0, intent, 167772160);
        }
        return PendingIntent.getService(context, 0, intent, d.c.a.b.a.a.C1);
    }

    private static void a(Context context, Intent intent, hb hbVar, gs gsVar, String str, int i2) {
        if (hbVar == null || gsVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a(gsVar.m494a(), i2);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        if (an.a.equals(strA) || an.f9370b.equals(strA) || an.f9371c.equals(strA)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", hbVar.f720a);
            if (!TextUtils.isEmpty(hbVar.f724b)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, hbVar.f724b);
            }
            intent.putExtra("job_key", a(gsVar.m494a(), "jobkey"));
            intent.putExtra(i2 + d.c.a.b.a.a.s1 + "target_component", a(context, hbVar.f724b, gsVar.m494a(), i2));
        }
    }

    private static boolean a(Context context, hb hbVar, String str) {
        if (hbVar != null && hbVar.m527a() != null && hbVar.m527a().m494a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(hbVar.m527a().m494a().get("use_clicked_activity")) && j.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("should clicked activity params are null.");
        return false;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0072 A[PHI: r0 r3
  0x0072: PHI (r0v4 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:40:0x0070, B:32:0x004e] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r3v15 java.lang.String) = (r3v14 java.lang.String), (r3v21 java.lang.String) binds: [B:40:0x0070, B:32:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String[] a(Context context, gs gsVar) {
        String str;
        String strM501c = gsVar.m501c();
        String strD = gsVar.d();
        Map<String, String> mapM494a = gsVar.m494a();
        if (mapM494a != null) {
            int iIntValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (iIntValue <= 320) {
                String str2 = mapM494a.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    strM501c = str2;
                }
                str = mapM494a.get("description_short");
                if (!TextUtils.isEmpty(str)) {
                    strD = str;
                }
            } else if (iIntValue > 360) {
                String str3 = mapM494a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    strM501c = str3;
                }
                str = mapM494a.get("description_long");
                if (!TextUtils.isEmpty(str)) {
                }
            }
        }
        return new String[]{strM501c, strD};
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static int a(Context context, String str, Map<String, String> map, int i2) {
        ComponentName componentNameA;
        Intent intentB = b(context, str, map, i2);
        if (intentB == null || (componentNameA = j.a(context, intentB)) == null) {
            return 0;
        }
        return componentNameA.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:225:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x03e8  */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b a(Context context, hb hbVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i2) throws Throwable {
        dv dvVar;
        dv dvVar2;
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        long jCurrentTimeMillis;
        boolean z4;
        b bVar;
        int iA;
        String str2;
        String str3;
        Notification notification;
        boolean z5;
        Bitmap bitmapA;
        int i3;
        Bitmap bitmapA2;
        b bVar2 = new b();
        gs gsVarM527a = hbVar.m527a();
        String strA = a(hbVar);
        Map<String, String> mapM494a = gsVarM527a.m494a();
        String[] strArrA = a(context, gsVarM527a);
        if (remoteViews != null) {
            dv dvVar3 = new dv(context);
            dvVar3.setCustomContentView(remoteViews);
            dvVar2 = dvVar3;
        } else {
            if (mapM494a != null && mapM494a.containsKey("notification_style_type")) {
                dvVar = a(context, hbVar, bArr, strArrA[1], i2);
            } else {
                dvVar = new dv(context);
            }
            dvVar2 = dvVar;
        }
        dv dvVar4 = dvVar2;
        a(dvVar2, context, hbVar.b(), hbVar, bArr, i2);
        dvVar4.setContentTitle(strArrA[0]);
        dvVar4.setContentText(strArrA[1]);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        dvVar4.setWhen(jCurrentTimeMillis2);
        String strA2 = a(mapM494a, "notification_show_when");
        if (TextUtils.isEmpty(strA2)) {
            if (Build.VERSION.SDK_INT >= 24) {
                dvVar4.setShowWhen(true);
            }
        } else {
            dvVar4.setShowWhen(Boolean.parseBoolean(strA2));
        }
        dvVar4.setContentIntent(pendingIntent);
        a(context, strA, dvVar4, mapM494a);
        if (Build.VERSION.SDK_INT >= 23) {
            if (mapM494a == null) {
                bitmapA2 = null;
                i3 = 1;
            } else {
                i3 = 1;
                bitmapA2 = a(context, mapM494a.get("notification_small_icon_uri"), true);
            }
            if (bitmapA2 != null) {
                Object[] objArr = new Object[i3];
                objArr[0] = bitmapA2;
                Object objA = com.xiaomi.push.aw.a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                if (objA != null) {
                    Object[] objArr2 = new Object[i3];
                    objArr2[0] = objA;
                    com.xiaomi.push.aw.a((Object) dvVar4, "setSmallIcon", objArr2);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", i3);
                    dvVar4.addExtras(bundle);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m48a("failed te get small icon with url:" + mapM494a.get("notification_small_icon_uri"));
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.m48a("failed to get small icon url:" + a(mapM494a, "notification_small_icon_uri"));
            }
            dvVar4.mo360a(a(mapM494a, "notification_small_icon_color"));
        }
        String strA3 = a(mapM494a, "__dynamic_icon_uri");
        boolean z6 = Boolean.parseBoolean(a(mapM494a, "__adiom")) || !com.xiaomi.push.j.m624a();
        if (TextUtils.isEmpty(strA3) || !z6) {
            z = false;
        } else {
            if (strA3.startsWith(HttpConstant.HTTP)) {
                ae.b bVarA = ae.a(context, strA3, true);
                if (bVarA != null) {
                    bitmapA = bVarA.f977a;
                    bVar2.a = bVarA.a;
                } else {
                    bitmapA = null;
                }
            } else {
                bitmapA = ae.a(context, strA3);
            }
            if (bitmapA != null) {
                dvVar4.setLargeIcon(bitmapA);
                z = true;
            }
        }
        Bitmap bitmapA3 = mapM494a == null ? null : a(context, mapM494a.get("notification_large_icon_uri"), true);
        if (bitmapA3 != null) {
            dvVar4.setLargeIcon(bitmapA3);
        }
        if (mapM494a == null || Build.VERSION.SDK_INT < 24) {
            z2 = false;
            str = null;
        } else {
            String strA4 = mapM494a.get("notification_group");
            z2 = Boolean.parseBoolean(mapM494a.get("notification_is_summary"));
            boolean z7 = Boolean.parseBoolean(mapM494a.get("notification_group_disable_default"));
            if (TextUtils.isEmpty(strA4) && (com.xiaomi.push.j.m624a() || !z7)) {
                strA4 = a(hbVar);
            }
            com.xiaomi.push.aw.a((Object) dvVar4, "setGroupSummary", Boolean.valueOf(z2));
            String str4 = mapM494a.get("notification_style_type");
            if ("com.xiaomi.xmsf".equals(context.getPackageName()) && ("4".equals(str4) || "3".equals(str4))) {
                str = a(hbVar) + "_custom_" + jCurrentTimeMillis2;
                z3 = true;
                dvVar4.setAutoCancel(true);
                jCurrentTimeMillis = System.currentTimeMillis();
                if (mapM494a != null && mapM494a.containsKey(RemoteMessageConst.Notification.TICKER)) {
                    dvVar4.setTicker(mapM494a.get(RemoteMessageConst.Notification.TICKER));
                }
                if (jCurrentTimeMillis - a <= com.heytap.mcssdk.constant.a.q) {
                    a = jCurrentTimeMillis;
                    iA = gsVarM527a.f628a;
                    if (m758b(context, strA)) {
                        iA = a(context, strA);
                    }
                    dvVar4.setDefaults(iA);
                    if (mapM494a == null || (iA & 1) == 0) {
                        z4 = z;
                        bVar = bVar2;
                    } else {
                        String str5 = mapM494a.get("sound_uri");
                        if (!TextUtils.isEmpty(str5)) {
                            bVar = bVar2;
                            StringBuilder sb = new StringBuilder();
                            z4 = z;
                            sb.append("android.resource://");
                            sb.append(strA);
                            if (str5.startsWith(sb.toString())) {
                                dvVar4.setDefaults(iA ^ 1);
                                dvVar4.setSound(Uri.parse(str5));
                            }
                        }
                    }
                } else {
                    z4 = z;
                    bVar = bVar2;
                    iA = -100;
                }
                if (mapM494a == null && Build.VERSION.SDK_INT >= 26) {
                    af afVarA = af.a(context, strA);
                    str2 = "com.xiaomi.xmsf";
                    if (a(mapM494a) > 0) {
                        z5 = z2;
                        str3 = str;
                        com.xiaomi.push.aw.a((Object) dvVar4, "setTimeoutAfter", Long.valueOf(r15 * 1000));
                    } else {
                        z5 = z2;
                        str3 = str;
                    }
                    ac.a(gsVarM527a);
                    String str6 = mapM494a.get("channel_id");
                    if (!TextUtils.isEmpty(str6) || context.getApplicationInfo().targetSdkVersion >= 26) {
                        String strA5 = a(context, strA, mapM494a);
                        int iB = b(mapM494a);
                        int i4 = gsVarM527a.f628a;
                        String str7 = mapM494a.get("channel_description");
                        String str8 = mapM494a.get("sound_uri");
                        String str9 = mapM494a.get("channel_perm");
                        bb.a(context, mapM494a, dvVar4, jCurrentTimeMillis2);
                        com.xiaomi.push.aw.a((Object) dvVar4, "setChannelId", ac.a(afVarA, str6, strA5, str7, i4, iB, str8, str9));
                        if (iA == -100 && ag.a(mapM494a)) {
                            ag.a(dvVar4, z5);
                        }
                        if ("pulldown".equals(ag.a((Object) mapM494a)) && ag.a(mapM494a) && Objects.equals(mapM494a.get("pull_down_pop_type"), "0")) {
                            ag.a(dvVar4, z5);
                        }
                        if ("tts".equals(ag.a((Object) mapM494a)) && ag.a(mapM494a)) {
                            ag.a(dvVar4, z5);
                        }
                    }
                    String str10 = mapM494a.get("background_color");
                    if (!TextUtils.isEmpty(str10)) {
                        try {
                            int i5 = Integer.parseInt(str10);
                            dvVar4.setOngoing(true);
                            dvVar4.setColor(i5);
                            com.xiaomi.push.aw.a((Object) dvVar4, "setColorized", true);
                        } catch (Exception e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                } else {
                    str2 = "com.xiaomi.xmsf";
                    str3 = str;
                    if (mapM494a != null && Build.VERSION.SDK_INT < 26) {
                        com.xiaomi.push.aw.a((Object) dvVar4, "setPriority", Integer.valueOf(c(mapM494a)));
                    }
                }
                if (str3 != null) {
                    com.xiaomi.push.aw.a((Object) dvVar4, "setGroup", !z3 ? ad.a().a(context, dvVar4, str3) : str3);
                }
                if (com.xiaomi.push.j.m629c() && str2.equals(context.getPackageName())) {
                    com.xiaomi.push.aw.a("miui.util.NotificationHelper", "setTargetPkg", context, dvVar4, a(hbVar));
                }
                notification = dvVar4.getNotification();
                if (z4 && com.xiaomi.push.j.m624a()) {
                    a(notification);
                }
                if (mapM494a != null) {
                    if (notification.extras == null) {
                        notification.extras = new Bundle();
                    }
                    if (!TextUtils.isEmpty(mapM494a.get("enable_keyguard"))) {
                        ag.b(notification, Boolean.parseBoolean(mapM494a.get("enable_keyguard")));
                    }
                    if (!TextUtils.isEmpty(mapM494a.get("enable_float"))) {
                        ag.a(notification, Boolean.parseBoolean(mapM494a.get("enable_float")));
                    }
                    if (!TextUtils.isEmpty(mapM494a.get("float_small_win")) && "0".equals(mapM494a.get("float_small_win")) && com.xiaomi.push.g.d(context, strA)) {
                        ag.a(notification, false);
                    }
                    int iA2 = com.xiaomi.push.s.a(mapM494a.get("section_is_prr"), -1);
                    int iA3 = com.xiaomi.push.s.a(mapM494a.get("section_prr_cl"), -1);
                    if (iA2 >= 0 && iA3 >= 0) {
                        ag.a(notification, iA2, iA3);
                    }
                }
                b bVar3 = bVar;
                bVar3.f1094a = notification;
                return bVar3;
            }
            str = strA4;
        }
        z3 = false;
        dvVar4.setAutoCancel(true);
        jCurrentTimeMillis = System.currentTimeMillis();
        if (mapM494a != null) {
            dvVar4.setTicker(mapM494a.get(RemoteMessageConst.Notification.TICKER));
        }
        if (jCurrentTimeMillis - a <= com.heytap.mcssdk.constant.a.q) {
        }
        if (mapM494a == null) {
            str2 = "com.xiaomi.xmsf";
            str3 = str;
            if (mapM494a != null) {
                com.xiaomi.push.aw.a((Object) dvVar4, "setPriority", Integer.valueOf(c(mapM494a)));
            }
        }
        if (str3 != null) {
        }
        if (com.xiaomi.push.j.m629c()) {
            com.xiaomi.push.aw.a("miui.util.NotificationHelper", "setTargetPkg", context, dvVar4, a(hbVar));
        }
        notification = dvVar4.getNotification();
        if (z4) {
            a(notification);
        }
        if (mapM494a != null) {
        }
        b bVar32 = bVar;
        bVar32.f1094a = notification;
        return bVar32;
    }

    @TargetApi(16)
    private static void a(dv dvVar, Context context, String str, hb hbVar, byte[] bArr, int i2) {
        PendingIntent pendingIntentA;
        PendingIntent pendingIntentA2;
        PendingIntent pendingIntentA3;
        PendingIntent pendingIntentA4;
        Map<String, String> mapM494a = hbVar.m527a().m494a();
        if (TextUtils.equals("3", mapM494a.get("notification_style_type")) || TextUtils.equals("4", mapM494a.get("notification_style_type"))) {
            return;
        }
        if (m760b(mapM494a)) {
            for (int i3 = 1; i3 <= 3; i3++) {
                String str2 = mapM494a.get(String.format("cust_btn_%s_n", Integer.valueOf(i3)));
                if (!TextUtils.isEmpty(str2) && (pendingIntentA4 = a(context, str, hbVar, bArr, i2, i3)) != null) {
                    dvVar.addAction(0, str2, pendingIntentA4);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(mapM494a.get("notification_style_button_left_name")) && (pendingIntentA3 = a(context, str, hbVar, bArr, i2, 1)) != null) {
            dvVar.addAction(0, mapM494a.get("notification_style_button_left_name"), pendingIntentA3);
        }
        if (!TextUtils.isEmpty(mapM494a.get("notification_style_button_mid_name")) && (pendingIntentA2 = a(context, str, hbVar, bArr, i2, 2)) != null) {
            dvVar.addAction(0, mapM494a.get("notification_style_button_mid_name"), pendingIntentA2);
        }
        if (TextUtils.isEmpty(mapM494a.get("notification_style_button_right_name")) || (pendingIntentA = a(context, str, hbVar, bArr, i2, 3)) == null) {
            return;
        }
        dvVar.addAction(0, mapM494a.get("notification_style_button_right_name"), pendingIntentA);
    }

    private static PendingIntent a(Context context, String str, hb hbVar, byte[] bArr, int i2, int i3) {
        Map<String, String> mapM494a = hbVar.m527a().m494a();
        if (mapM494a == null) {
            return null;
        }
        boolean zA = a(context, hbVar, str);
        if (zA) {
            return a(context, hbVar, str, bArr, i2, i3, zA);
        }
        Intent intentM750a = m750a(context, str, mapM494a, i3);
        if (intentM750a == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, intentM750a, 167772160);
        }
        return PendingIntent.getActivity(context, 0, intentM750a, d.c.a.b.a.a.C1);
    }

    public static String a(Map<String, String> map, int i2) {
        String str;
        if (i2 == 0) {
            str = "notify_effect";
        } else {
            str = m760b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i2)) : i2 == 1 ? "notification_style_button_left_notify_effect" : i2 == 2 ? "notification_style_button_mid_notify_effect" : i2 == 3 ? "notification_style_button_right_notify_effect" : i2 == 4 ? "notification_colorful_button_notify_effect" : null;
        }
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    /* JADX INFO: renamed from: a */
    public static Intent m750a(Context context, String str, Map<String, String> map, int i2) {
        if (m760b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i2)), String.format("cust_btn_%s_iu", Integer.valueOf(i2)), String.format("cust_btn_%s_ic", Integer.valueOf(i2)), String.format("cust_btn_%s_wu", Integer.valueOf(i2)));
        }
        if (i2 == 1) {
            return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        }
        if (i2 == 2) {
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        if (i2 == 3) {
            return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
        }
        if (i2 != 4) {
            return null;
        }
        return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Intent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent launchIntentForPackage;
        Intent uri;
        String str6 = map.get(str2);
        if (TextUtils.isEmpty(str6)) {
            return null;
        }
        if (an.a.equals(str6)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                launchIntentForPackage = null;
            }
        } else if (an.f9370b.equals(str6)) {
            if (map.containsKey(str3)) {
                String str7 = map.get(str3);
                if (str7 != null) {
                    try {
                        uri = Intent.parseUri(str7, 1);
                    } catch (URISyntaxException e3) {
                        e = e3;
                        uri = null;
                    }
                    try {
                        uri.setPackage(str);
                    } catch (URISyntaxException e4) {
                        e = e4;
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                    }
                } else {
                    uri = null;
                }
                launchIntentForPackage = uri;
            } else if (map.containsKey(str4)) {
                String str8 = map.get(str4);
                launchIntentForPackage = new Intent();
                launchIntentForPackage.setComponent(new ComponentName(str, str8));
            } else {
                launchIntentForPackage = null;
            }
        } else if (an.f9371c.equals(str6)) {
            String str9 = map.get(str5);
            if (!TextUtils.isEmpty(str9)) {
                String strTrim = str9.trim();
                if (!strTrim.startsWith(DefaultWebClient.HTTP_SCHEME) && !strTrim.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                    strTrim = DefaultWebClient.HTTP_SCHEME + strTrim;
                }
                try {
                    String protocol = new URL(strTrim).getProtocol();
                    if (HttpConstant.HTTP.equals(protocol) || HttpConstant.HTTPS.equals(protocol)) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        try {
                            launchIntentForPackage.setData(Uri.parse(strTrim));
                            ag.a(context, str, launchIntentForPackage);
                        } catch (MalformedURLException e5) {
                            e = e5;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                        }
                    }
                } catch (MalformedURLException e6) {
                    e = e6;
                    launchIntentForPackage = null;
                }
            }
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(CommonNetImpl.FLAG_AUTH);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.j.m625a(context) && an.f9371c.equals(str6)) {
                    return launchIntentForPackage;
                }
                com.xiaomi.channel.commonutils.logger.b.m48a("not resolve activity:" + launchIntentForPackage + "for buttons");
            } catch (Exception e7) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
            }
        }
        return null;
    }

    @TargetApi(16)
    private static dv a(Context context, hb hbVar, byte[] bArr, String str, int i2) {
        PendingIntent pendingIntentA;
        String strA = a(hbVar);
        Map<String, String> mapM494a = hbVar.m527a().m494a();
        String str2 = mapM494a.get("notification_style_type");
        dv dvVarA = (!com.xiaomi.push.j.m625a(context) || f1087a == null) ? null : f1087a.a(context, i2, strA, mapM494a);
        if (dvVarA != null) {
            dvVarA.a(mapM494a);
            return dvVarA;
        }
        if ("2".equals(str2)) {
            dv dvVar = new dv(context);
            Bitmap bitmapA = TextUtils.isEmpty(mapM494a.get("notification_bigPic_uri")) ? null : a(context, mapM494a.get("notification_bigPic_uri"), false);
            if (bitmapA == null) {
                com.xiaomi.channel.commonutils.logger.b.m48a("can not get big picture.");
                return dvVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(dvVar);
            bigPictureStyle.bigPicture(bitmapA);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            dvVar.setStyle(bigPictureStyle);
            return dvVar;
        }
        if ("1".equals(str2)) {
            dv dvVar2 = new dv(context);
            dvVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return dvVar2;
        }
        if ("4".equals(str2) && com.xiaomi.push.j.m624a()) {
            du duVar = new du(context, strA);
            if (!TextUtils.isEmpty(mapM494a.get("notification_banner_image_uri"))) {
                duVar.setLargeIcon(a(context, mapM494a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(mapM494a.get("notification_banner_icon_uri"))) {
                duVar.b(a(context, mapM494a.get("notification_banner_icon_uri"), false));
            }
            duVar.a(mapM494a);
            return duVar;
        }
        if ("3".equals(str2) && com.xiaomi.push.j.m624a()) {
            dw dwVar = new dw(context, i2, strA);
            if (!TextUtils.isEmpty(mapM494a.get("notification_colorful_button_text")) && (pendingIntentA = a(context, strA, hbVar, bArr, i2, 4)) != null) {
                dwVar.a(mapM494a.get("notification_colorful_button_text"), pendingIntentA).mo360a(mapM494a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(mapM494a.get("notification_colorful_bg_color"))) {
                dwVar.b(mapM494a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(mapM494a.get("notification_colorful_bg_image_uri"))) {
                dwVar.setLargeIcon(a(context, mapM494a.get("notification_colorful_bg_image_uri"), false));
            }
            dwVar.a(mapM494a);
            return dwVar;
        }
        return new dv(context);
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static RemoteViews a(Context context, hb hbVar, byte[] bArr) {
        gs gsVarM527a = hbVar.m527a();
        String strA = a(hbVar);
        if (gsVarM527a != null && gsVarM527a.m494a() != null) {
            Map<String, String> mapM494a = gsVarM527a.m494a();
            String str = mapM494a.get("layout_name");
            String str2 = mapM494a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(strA);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", strA);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(strA, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", strA);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> itKeys2 = jSONObject3.keys();
                            while (itKeys2.hasNext()) {
                                String next2 = itKeys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", strA);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", strA);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> itKeys3 = jSONObject4.keys();
                            while (itKeys3.hasNext()) {
                                String next3 = itKeys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", strA);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                }
            }
        }
        return null;
    }

    private static Bitmap a(Context context, int i2) {
        return a(context.getResources().getDrawable(i2));
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private static Notification a(Notification notification) {
        Object objA = com.xiaomi.push.aw.a(notification, "extraNotification");
        if (objA != null) {
            com.xiaomi.push.aw.a(objA, "setCustomizedIcon", true);
        }
        return notification;
    }

    public static String a(hb hbVar) {
        gs gsVarM527a;
        if ("com.xiaomi.xmsf".equals(hbVar.f724b) && (gsVarM527a = hbVar.m527a()) != null && gsVarM527a.m494a() != null) {
            String str = gsVarM527a.m494a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hbVar.f724b;
    }

    /* JADX INFO: renamed from: a */
    public static void m752a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i2) {
        a(context, str, i2, -1);
    }

    public static void a(Context context, String str, int i2, int i3) {
        boolean z;
        if (context == null || TextUtils.isEmpty(str) || i2 < -1) {
            return;
        }
        af afVarA = af.a(context, str);
        List<StatusBarNotification> listM685b = afVarA.m685b();
        if (com.xiaomi.push.s.a(listM685b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        int iHashCode = 0;
        if (i2 == -1) {
            z = true;
        } else {
            iHashCode = ((str.hashCode() / 10) * 10) + i2;
            z = false;
        }
        Iterator<StatusBarNotification> it = listM685b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    afVarA.a(id);
                } else if (iHashCode == id) {
                    d.a(context, next, i3);
                    linkedList.add(next);
                    afVarA.a(id);
                    break;
                }
            }
        }
        a(context, (LinkedList<? extends Object>) linkedList);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        af afVarA = af.a(context, str);
        List<StatusBarNotification> listM685b = afVarA.m685b();
        if (com.xiaomi.push.s.a(listM685b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : listM685b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String strA = ag.a(notification);
                String strB = ag.b(notification);
                if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB) && a(strA, str2) && a(strB, str3)) {
                    linkedList.add(statusBarNotification);
                    afVarA.a(id);
                }
            }
        }
        a(context, (LinkedList<? extends Object>) linkedList);
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        az.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m756a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static boolean a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        String strM493a = gsVar.m493a();
        return !TextUtils.isEmpty(strM493a) && strM493a.length() == 22 && "satuigmo".indexOf(strM493a.charAt(0)) >= 0;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m755a(hb hbVar) {
        gs gsVarM527a = hbVar.m527a();
        return a(gsVarM527a) && gsVarM527a.l();
    }

    private static Bitmap a(Context context, String str, boolean z) {
        Future futureSubmit = f1089a.submit(new a(str, context, z));
        try {
            try {
                try {
                    Bitmap bitmap = (Bitmap) futureSubmit.get(180L, TimeUnit.SECONDS);
                    return bitmap == null ? bitmap : bitmap;
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    futureSubmit.cancel(true);
                    return null;
                } catch (TimeoutException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                    futureSubmit.cancel(true);
                    return null;
                }
            } catch (ExecutionException e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                futureSubmit.cancel(true);
                return null;
            }
        } finally {
            futureSubmit.cancel(true);
        }
    }

    private static String a(Context context, String str, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_name"))) {
            return map.get("channel_name");
        }
        return com.xiaomi.push.g.m453b(context, str);
    }

    private static void a(Intent intent) {
        if (intent == null) {
            return;
        }
        int flags = intent.getFlags() & (-2) & (-3) & (-65);
        if (Build.VERSION.SDK_INT >= 21) {
            flags &= -129;
        }
        intent.setFlags(flags);
    }

    private static void a(Context context, String str, dv dvVar, Map<String, String> map) {
        int iA = a(context, str, "mipush_small_notification");
        int iA2 = a(context, str, "mipush_notification");
        if (com.xiaomi.push.j.m625a(context)) {
            if (iA > 0 && iA2 > 0) {
                dvVar.setSmallIcon(iA);
                dvVar.setLargeIcon(a(context, iA2));
                return;
            } else {
                b(context, str, dvVar, map);
                return;
            }
        }
        if (iA > 0) {
            dvVar.setSmallIcon(iA);
        } else {
            b(context, str, dvVar, map);
        }
        if (iA2 > 0) {
            dvVar.setLargeIcon(a(context, iA2));
        }
    }
}
