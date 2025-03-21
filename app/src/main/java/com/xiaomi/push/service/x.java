package com.xiaomi.push.service;

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
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import anet.channel.util.HttpConstant;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public static long f13473a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile ab f1087a;

    /* renamed from: a, reason: collision with other field name */
    private static final LinkedList<Pair<Integer, hb>> f1088a = new LinkedList<>();

    /* renamed from: a, reason: collision with other field name */
    private static ExecutorService f1089a = Executors.newCachedThreadPool();

    private static class a implements Callable<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private Context f13475a;

        /* renamed from: a, reason: collision with other field name */
        private String f1092a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f1093a;

        public a(String str, Context context, boolean z) {
            this.f13475a = context;
            this.f1092a = str;
            this.f1093a = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            if (TextUtils.isEmpty(this.f1092a)) {
                com.xiaomi.channel.commonutils.logger.b.m50a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f1092a.startsWith(HttpConstant.HTTP)) {
                ae.b a2 = ae.a(this.f13475a, this.f1092a, this.f1093a);
                if (a2 != null) {
                    return a2.f977a;
                }
                com.xiaomi.channel.commonutils.logger.b.m50a("Failed get online picture/icon resource");
                return null;
            }
            Bitmap a3 = ae.a(this.f13475a, this.f1092a);
            if (a3 != null) {
                return a3;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("Failed get online picture/icon resource");
            return a3;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        long f13476a = 0;

        /* renamed from: a, reason: collision with other field name */
        Notification f1094a;
    }

    public static class c {

        /* renamed from: a, reason: collision with other field name */
        public String f1095a;

        /* renamed from: a, reason: collision with root package name */
        public long f13477a = 0;

        /* renamed from: a, reason: collision with other field name */
        public boolean f1096a = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m755a(Context context, String str) {
        return com.xiaomi.push.g.m456b(context, str);
    }

    /* renamed from: b, reason: collision with other method in class */
    private static boolean m762b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("meta extra is null");
        return false;
    }

    static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean d(hb hbVar) {
        return hbVar.a() == gf.Registration;
    }

    public static boolean e(hb hbVar) {
        return m757a(hbVar) || c(hbVar) || m761b(hbVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m756a(Context context, String str, boolean z) {
        return com.xiaomi.push.j.m626a() && !z && m755a(context, str);
    }

    public static boolean c(hb hbVar) {
        gs m529a = hbVar.m529a();
        return a(m529a) && m529a.f634b == 0 && !m757a(hbVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static c m753a(Context context, hb hbVar, byte[] bArr) {
        int i2;
        Map<String, String> map;
        c cVar = new c();
        g.b a2 = com.xiaomi.push.g.a(context, a(hbVar), true);
        gs m529a = hbVar.m529a();
        if (m529a != null) {
            i2 = m529a.c();
            map = m529a.m496a();
        } else {
            i2 = 0;
            map = null;
        }
        final int b2 = com.xiaomi.push.s.b(a(hbVar), i2);
        if (com.xiaomi.push.j.m627a(context) && a2 == g.b.NOT_ALLOWED) {
            if (m529a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), m529a.m495a(), "10:" + a(hbVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("Do not notify because user block " + a(hbVar) + "‘s notification");
            return cVar;
        }
        if (com.xiaomi.push.j.m627a(context) && f1087a != null && f1087a.m670a(context, b2, a(hbVar), map)) {
            if (m529a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), m529a.m495a(), "14:" + a(hbVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("Do not notify because card notification is canceled or sequence incorrect");
            return cVar;
        }
        RemoteViews a3 = a(context, hbVar, bArr);
        PendingIntent a4 = a(context, hbVar, hbVar.b(), bArr, b2);
        if (a4 == null) {
            if (m529a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), m529a.m495a(), "11");
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("The click PendingIntent is null. ");
            return cVar;
        }
        b a5 = a(context, hbVar, bArr, a3, a4, b2);
        cVar.f13477a = a5.f13476a;
        cVar.f1095a = a(hbVar);
        Notification notification = a5.f1094a;
        if (com.xiaomi.push.j.m626a()) {
            if (!TextUtils.isEmpty(m529a.m495a())) {
                notification.extras.putString("message_id", m529a.m495a());
            }
            notification.extras.putString("local_paid", hbVar.m530a());
            ag.a(map, notification.extras, "msg_busi_type");
            ag.a(map, notification.extras, "disable_notification_flags");
            String str = m529a.m501b() == null ? null : m529a.m501b().get("score_info");
            if (!TextUtils.isEmpty(str)) {
                notification.extras.putString("score_info", str);
            }
            notification.extras.putString("pushUid", a(m529a.f632a, "n_stats_expose"));
            int i3 = -1;
            if (c(hbVar)) {
                i3 = 1000;
            } else if (m757a(hbVar)) {
                i3 = PathInterpolatorCompat.MAX_NUM_POINTS;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i3));
            notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(hbVar));
        }
        String str2 = m529a.m496a() == null ? null : m529a.m496a().get("message_count");
        if (com.xiaomi.push.j.m626a() && str2 != null) {
            try {
                ag.a(notification, Integer.parseInt(str2));
            } catch (NumberFormatException e2) {
                if (m529a != null) {
                    dt.a(context.getApplicationContext()).b(hbVar.b(), b(hbVar), m529a.m495a(), "8");
                }
                com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e2);
            }
        }
        String a6 = a(hbVar);
        ag.m688a(notification, a6);
        final af a7 = af.a(context, a6);
        if (com.xiaomi.push.j.m627a(context) && f1087a != null) {
            f1087a.a(hbVar, m529a.m496a(), b2, notification);
        }
        if (com.xiaomi.push.j.m627a(context) && f1087a != null && f1087a.a(m529a.m496a(), b2, notification)) {
            com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
        } else {
            a7.a(b2, notification);
            cVar.f1096a = true;
            com.xiaomi.channel.commonutils.logger.b.m50a("notification: " + m529a.m495a() + " is notifyied");
        }
        if (com.xiaomi.push.j.m626a() && com.xiaomi.push.j.m627a(context)) {
            ad.a().a(context, b2, notification);
            bb.m713a(context, a6, b2, m529a.m495a(), notification);
        }
        if (m757a(hbVar)) {
            dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), m529a.m495a(), ErrorStatus.r0, null);
        }
        if (c(hbVar)) {
            dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), m529a.m495a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            String m495a = m529a != null ? m529a.m495a() : null;
            com.xiaomi.push.ae a8 = com.xiaomi.push.ae.a(context);
            int a9 = a(m529a.m496a());
            if (a9 > 0 && !TextUtils.isEmpty(m495a)) {
                final String str3 = "n_timeout_" + m495a;
                a8.m131a(str3);
                a8.b(new ae.a() { // from class: com.xiaomi.push.service.x.1
                    @Override // com.xiaomi.push.ae.a
                    /* renamed from: a */
                    public String mo183a() {
                        return str3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a7.a(b2);
                    }
                }, a9);
            }
        }
        Pair<Integer, hb> pair = new Pair<>(Integer.valueOf(b2), hbVar);
        synchronized (f1088a) {
            f1088a.add(pair);
            if (f1088a.size() > 100) {
                f1088a.remove();
            }
        }
        return cVar;
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return a2 == 0 ? context.getApplicationInfo().logo : a2;
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

    /* renamed from: b, reason: collision with other method in class */
    public static void m759b(Context context, String str) {
        if (!com.xiaomi.push.j.m627a(context) || f1087a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f1087a.a(str);
    }

    /* renamed from: b, reason: collision with other method in class */
    static boolean m760b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    static void b(Context context, String str, int i2) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i2).commit();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m761b(hb hbVar) {
        gs m529a = hbVar.m529a();
        return a(m529a) && m529a.f634b == 1 && !m757a(hbVar);
    }

    public static String b(hb hbVar) {
        return m757a(hbVar) ? "E100002" : c(hbVar) ? "E100000" : m761b(hbVar) ? "E100001" : d(hbVar) ? "E100003" : "";
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent b(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, int r8) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.b(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(android.content.Context r2, java.lang.String r3, com.xiaomi.push.dv r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            boolean r0 = com.xiaomi.push.j.m627a(r2)
            if (r0 != 0) goto L2c
            java.lang.String r0 = "fcm_icon_uri"
            java.lang.String r0 = a(r5, r0)
            java.lang.String r1 = "fcm_icon_color"
            java.lang.String r5 = a(r5, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L2c
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L2c
            int r0 = a(r2, r3, r0)
            if (r0 <= 0) goto L2c
            r1 = 1
            r4.setSmallIcon(r0)
            r4.mo362a(r5)
            goto L2d
        L2c:
            r1 = 0
        L2d:
            if (r1 != 0) goto L48
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r5 < r0) goto L41
            int r2 = com.xiaomi.push.service.ag.a(r2, r3)
            android.graphics.drawable.Icon r2 = android.graphics.drawable.Icon.createWithResource(r3, r2)
            r4.setSmallIcon(r2)
            goto L48
        L41:
            int r2 = b(r2, r3)
            r4.setSmallIcon(r2)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.b(android.content.Context, java.lang.String, com.xiaomi.push.dv, java.util.Map):void");
    }

    private static PendingIntent a(Context context, hb hbVar, String str, byte[] bArr, int i2) {
        return a(context, hbVar, str, bArr, i2, 0, a(context, hbVar, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.PendingIntent a(android.content.Context r16, com.xiaomi.push.hb r17, java.lang.String r18, byte[] r19, int r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.hb, java.lang.String, byte[], int, int, boolean):android.app.PendingIntent");
    }

    private static void a(Context context, Intent intent, hb hbVar, gs gsVar, String str, int i2) {
        if (hbVar == null || gsVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = a(gsVar.m496a(), i2);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (an.f13364a.equals(a2) || an.f13365b.equals(a2) || an.f13366c.equals(a2)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", hbVar.f720a);
            if (!TextUtils.isEmpty(hbVar.f724b)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, hbVar.f724b);
            }
            intent.putExtra("job_key", a(gsVar.m496a(), "jobkey"));
            intent.putExtra(i2 + c.c.a.b.a.a.s1 + "target_component", a(context, hbVar.f724b, gsVar.m496a(), i2));
        }
    }

    private static boolean a(Context context, hb hbVar, String str) {
        if (hbVar != null && hbVar.m529a() != null && hbVar.m529a().m496a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(hbVar.m529a().m496a().get("use_clicked_activity")) && j.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("should clicked activity params are null.");
        return false;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0072, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] a(android.content.Context r3, com.xiaomi.push.gs r4) {
        /*
            java.lang.String r0 = r4.m503c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.m496a()
            if (r4 == 0) goto L73
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L51
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L42
            r0 = r3
        L42:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
            goto L72
        L51:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L73
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L64
            r0 = r3
        L64:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
        L72:
            r1 = r3
        L73:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.gs):java.lang.String[]");
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static int a(Context context, String str, Map<String, String> map, int i2) {
        ComponentName a2;
        Intent b2 = b(context, str, map, i2);
        if (b2 == null || (a2 = j.a(context, b2)) == null) {
            return 0;
        }
        return a2.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03b4  */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.x.b a(android.content.Context r27, com.xiaomi.push.hb r28, byte[] r29, android.widget.RemoteViews r30, android.app.PendingIntent r31, int r32) {
        /*
            Method dump skipped, instructions count: 1139
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.hb, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.x$b");
    }

    @TargetApi(16)
    private static void a(dv dvVar, Context context, String str, hb hbVar, byte[] bArr, int i2) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Map<String, String> m496a = hbVar.m529a().m496a();
        if (TextUtils.equals("3", m496a.get("notification_style_type")) || TextUtils.equals("4", m496a.get("notification_style_type"))) {
            return;
        }
        if (m762b(m496a)) {
            for (int i3 = 1; i3 <= 3; i3++) {
                String str2 = m496a.get(String.format("cust_btn_%s_n", Integer.valueOf(i3)));
                if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, hbVar, bArr, i2, i3)) != null) {
                    dvVar.addAction(0, str2, a5);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(m496a.get("notification_style_button_left_name")) && (a4 = a(context, str, hbVar, bArr, i2, 1)) != null) {
            dvVar.addAction(0, m496a.get("notification_style_button_left_name"), a4);
        }
        if (!TextUtils.isEmpty(m496a.get("notification_style_button_mid_name")) && (a3 = a(context, str, hbVar, bArr, i2, 2)) != null) {
            dvVar.addAction(0, m496a.get("notification_style_button_mid_name"), a3);
        }
        if (TextUtils.isEmpty(m496a.get("notification_style_button_right_name")) || (a2 = a(context, str, hbVar, bArr, i2, 3)) == null) {
            return;
        }
        dvVar.addAction(0, m496a.get("notification_style_button_right_name"), a2);
    }

    private static PendingIntent a(Context context, String str, hb hbVar, byte[] bArr, int i2, int i3) {
        Map<String, String> m496a = hbVar.m529a().m496a();
        if (m496a == null) {
            return null;
        }
        boolean a2 = a(context, hbVar, str);
        if (a2) {
            return a(context, hbVar, str, bArr, i2, i3, a2);
        }
        Intent m752a = m752a(context, str, m496a, i3);
        if (m752a == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, m752a, 167772160);
        }
        return PendingIntent.getActivity(context, 0, m752a, c.c.a.b.a.a.C1);
    }

    public static String a(Map<String, String> map, int i2) {
        String format;
        if (i2 == 0) {
            format = "notify_effect";
        } else {
            format = m762b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i2)) : i2 == 1 ? "notification_style_button_left_notify_effect" : i2 == 2 ? "notification_style_button_mid_notify_effect" : i2 == 3 ? "notification_style_button_right_notify_effect" : i2 == 4 ? "notification_colorful_button_notify_effect" : null;
        }
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Intent m752a(Context context, String str, Map<String, String> map, int i2) {
        if (m762b(map)) {
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent a(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    @TargetApi(16)
    private static dv a(Context context, hb hbVar, byte[] bArr, String str, int i2) {
        PendingIntent a2;
        String a3 = a(hbVar);
        Map<String, String> m496a = hbVar.m529a().m496a();
        String str2 = m496a.get("notification_style_type");
        dv a4 = (!com.xiaomi.push.j.m627a(context) || f1087a == null) ? null : f1087a.a(context, i2, a3, m496a);
        if (a4 != null) {
            a4.a(m496a);
            return a4;
        }
        if ("2".equals(str2)) {
            dv dvVar = new dv(context);
            Bitmap a5 = TextUtils.isEmpty(m496a.get("notification_bigPic_uri")) ? null : a(context, m496a.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                com.xiaomi.channel.commonutils.logger.b.m50a("can not get big picture.");
                return dvVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(dvVar);
            bigPictureStyle.bigPicture(a5);
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
        if ("4".equals(str2) && com.xiaomi.push.j.m626a()) {
            du duVar = new du(context, a3);
            if (!TextUtils.isEmpty(m496a.get("notification_banner_image_uri"))) {
                duVar.setLargeIcon(a(context, m496a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m496a.get("notification_banner_icon_uri"))) {
                duVar.b(a(context, m496a.get("notification_banner_icon_uri"), false));
            }
            duVar.a(m496a);
            return duVar;
        }
        if ("3".equals(str2) && com.xiaomi.push.j.m626a()) {
            dw dwVar = new dw(context, i2, a3);
            if (!TextUtils.isEmpty(m496a.get("notification_colorful_button_text")) && (a2 = a(context, a3, hbVar, bArr, i2, 4)) != null) {
                dwVar.a(m496a.get("notification_colorful_button_text"), a2).mo362a(m496a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m496a.get("notification_colorful_bg_color"))) {
                dwVar.b(m496a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m496a.get("notification_colorful_bg_image_uri"))) {
                dwVar.setLargeIcon(a(context, m496a.get("notification_colorful_bg_image_uri"), false));
            }
            dwVar.a(m496a);
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
        gs m529a = hbVar.m529a();
        String a2 = a(hbVar);
        if (m529a != null && m529a.m496a() != null) {
            Map<String, String> m496a = m529a.m496a();
            String str = m496a.get("layout_name");
            String str2 = m496a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a2, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a2);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
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
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static Notification a(Notification notification) {
        Object a2 = com.xiaomi.push.aw.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.aw.a(a2, "setCustomizedIcon", true);
        }
        return notification;
    }

    public static String a(hb hbVar) {
        gs m529a;
        if ("com.xiaomi.xmsf".equals(hbVar.f724b) && (m529a = hbVar.m529a()) != null && m529a.m496a() != null) {
            String str = m529a.m496a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hbVar.f724b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m754a(Context context, String str) {
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
        af a2 = af.a(context, str);
        List<StatusBarNotification> m687b = a2.m687b();
        if (com.xiaomi.push.s.a(m687b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        int i4 = 0;
        if (i2 == -1) {
            z = true;
        } else {
            i4 = ((str.hashCode() / 10) * 10) + i2;
            z = false;
        }
        Iterator<StatusBarNotification> it = m687b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    a2.a(id);
                } else if (i4 == id) {
                    d.a(context, next, i3);
                    linkedList.add(next);
                    a2.a(id);
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
        af a2 = af.a(context, str);
        List<StatusBarNotification> m687b = a2.m687b();
        if (com.xiaomi.push.s.a(m687b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : m687b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String a3 = ag.a(notification);
                String b2 = ag.b(notification);
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2) && a(a3, str2) && a(b2, str3)) {
                    linkedList.add(statusBarNotification);
                    a2.a(id);
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

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m758a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static boolean a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        String m495a = gsVar.m495a();
        return !TextUtils.isEmpty(m495a) && m495a.length() == 22 && "satuigmo".indexOf(m495a.charAt(0)) >= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m757a(hb hbVar) {
        gs m529a = hbVar.m529a();
        return a(m529a) && m529a.l();
    }

    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = f1089a.submit(new a(str, context, z));
        try {
            try {
                try {
                    Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                    return bitmap == null ? bitmap : bitmap;
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    submit.cancel(true);
                    return null;
                } catch (TimeoutException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                    submit.cancel(true);
                    return null;
                }
            } catch (ExecutionException e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                submit.cancel(true);
                return null;
            }
        } finally {
            submit.cancel(true);
        }
    }

    private static String a(Context context, String str, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_name"))) {
            return map.get("channel_name");
        }
        return com.xiaomi.push.g.m455b(context, str);
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
        int a2 = a(context, str, "mipush_small_notification");
        int a3 = a(context, str, "mipush_notification");
        if (com.xiaomi.push.j.m627a(context)) {
            if (a2 > 0 && a3 > 0) {
                dvVar.setSmallIcon(a2);
                dvVar.setLargeIcon(a(context, a3));
                return;
            } else {
                b(context, str, dvVar, map);
                return;
            }
        }
        if (a2 > 0) {
            dvVar.setSmallIcon(a2);
        } else {
            b(context, str, dvVar, map);
        }
        if (a3 > 0) {
            dvVar.setLargeIcon(a(context, a3));
        }
    }
}
