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
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4172dt;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4310s;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.NotificationBuilderC4173du;
import com.xiaomi.push.NotificationBuilderC4174dv;
import com.xiaomi.push.NotificationBuilderC4175dw;
import com.xiaomi.push.service.C4353ae;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.service.x */
/* loaded from: classes2.dex */
public class C4402x {

    /* renamed from: a */
    public static long f16801a;

    /* renamed from: a */
    private static volatile AbstractC4350ab f16802a;

    /* renamed from: a */
    private static final LinkedList<Pair<Integer, C4262hb>> f16803a = new LinkedList<>();

    /* renamed from: a */
    private static ExecutorService f16804a = Executors.newCachedThreadPool();

    /* renamed from: com.xiaomi.push.service.x$a */
    private static class a implements Callable<Bitmap> {

        /* renamed from: a */
        private Context f16808a;

        /* renamed from: a */
        private String f16809a;

        /* renamed from: a */
        private boolean f16810a;

        public a(String str, Context context, boolean z) {
            this.f16808a = context;
            this.f16809a = str;
            this.f16810a = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            if (TextUtils.isEmpty(this.f16809a)) {
                AbstractC4022b.m13347a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f16809a.startsWith(HttpConstant.HTTP)) {
                C4353ae.b m15864a = C4353ae.m15864a(this.f16808a, this.f16809a, this.f16810a);
                if (m15864a != null) {
                    return m15864a.f16510a;
                }
                AbstractC4022b.m13347a("Failed get online picture/icon resource");
                return null;
            }
            Bitmap m15862a = C4353ae.m15862a(this.f16808a, this.f16809a);
            if (m15862a != null) {
                return m15862a;
            }
            AbstractC4022b.m13347a("Failed get online picture/icon resource");
            return m15862a;
        }
    }

    /* renamed from: com.xiaomi.push.service.x$b */
    public static class b {

        /* renamed from: a */
        long f16811a = 0;

        /* renamed from: a */
        Notification f16812a;
    }

    /* renamed from: com.xiaomi.push.service.x$c */
    public static class c {

        /* renamed from: a */
        public String f16814a;

        /* renamed from: a */
        public long f16813a = 0;

        /* renamed from: a */
        public boolean f16815a = false;
    }

    /* renamed from: a */
    public static boolean m16319a(Context context, String str) {
        return C4233g.m14938b(context, str);
    }

    /* renamed from: b */
    private static boolean m16335b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        AbstractC4022b.m13347a("meta extra is null");
        return false;
    }

    /* renamed from: c */
    static void m16337c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    /* renamed from: d */
    public static boolean m16339d(C4262hb c4262hb) {
        return c4262hb.m15263a() == EnumC4239gf.Registration;
    }

    /* renamed from: e */
    public static boolean m16340e(C4262hb c4262hb) {
        return m16322a(c4262hb) || m16338c(c4262hb) || m16334b(c4262hb);
    }

    /* renamed from: a */
    public static boolean m16320a(Context context, String str, boolean z) {
        return C4300j.m15680a() && !z && m16319a(context, str);
    }

    /* renamed from: c */
    public static boolean m16338c(C4262hb c4262hb) {
        C4252gs m15264a = c4262hb.m15264a();
        return m16321a(m15264a) && m15264a.f15844b == 0 && !m16322a(c4262hb);
    }

    /* renamed from: a */
    public static c m16304a(Context context, C4262hb c4262hb, byte[] bArr) {
        int i2;
        Map<String, String> map;
        c cVar = new c();
        C4233g.b m14929a = C4233g.m14929a(context, m16306a(c4262hb), true);
        C4252gs m15264a = c4262hb.m15264a();
        if (m15264a != null) {
            i2 = m15264a.m15111c();
            map = m15264a.m15097a();
        } else {
            i2 = 0;
            map = null;
        }
        final int m15729b = C4310s.m15729b(m16306a(c4262hb), i2);
        if (C4300j.m15681a(context) && m14929a == C4233g.b.NOT_ALLOWED) {
            if (m15264a != null) {
                C4172dt.m14529a(context.getApplicationContext()).m14536a(c4262hb.m15279b(), m16329b(c4262hb), m15264a.m15096a(), "10:" + m16306a(c4262hb));
            }
            AbstractC4022b.m13347a("Do not notify because user block " + m16306a(c4262hb) + "‘s notification");
            return cVar;
        }
        if (C4300j.m15681a(context) && f16802a != null && f16802a.m15826a(context, m15729b, m16306a(c4262hb), map)) {
            if (m15264a != null) {
                C4172dt.m14529a(context.getApplicationContext()).m14536a(c4262hb.m15279b(), m16329b(c4262hb), m15264a.m15096a(), "14:" + m16306a(c4262hb));
            }
            AbstractC4022b.m13347a("Do not notify because card notification is canceled or sequence incorrect");
            return cVar;
        }
        RemoteViews m16301a = m16301a(context, c4262hb, bArr);
        PendingIntent m16292a = m16292a(context, c4262hb, c4262hb.m15279b(), bArr, m15729b);
        if (m16292a == null) {
            if (m15264a != null) {
                C4172dt.m14529a(context.getApplicationContext()).m14536a(c4262hb.m15279b(), m16329b(c4262hb), m15264a.m15096a(), "11");
            }
            AbstractC4022b.m13347a("The click PendingIntent is null. ");
            return cVar;
        }
        b m16303a = m16303a(context, c4262hb, bArr, m16301a, m16292a, m15729b);
        cVar.f16813a = m16303a.f16811a;
        cVar.f16814a = m16306a(c4262hb);
        Notification notification = m16303a.f16812a;
        if (C4300j.m15680a()) {
            if (!TextUtils.isEmpty(m15264a.m15096a())) {
                notification.extras.putString("message_id", m15264a.m15096a());
            }
            notification.extras.putString("local_paid", c4262hb.m15271a());
            C4355ag.m15913a(map, notification.extras, "msg_busi_type");
            C4355ag.m15913a(map, notification.extras, "disable_notification_flags");
            String str = m15264a.m15107b() == null ? null : m15264a.m15107b().get("score_info");
            if (!TextUtils.isEmpty(str)) {
                notification.extras.putString("score_info", str);
            }
            notification.extras.putString("pushUid", m16308a(m15264a.f15842a, "n_stats_expose"));
            int i3 = -1;
            if (m16338c(c4262hb)) {
                i3 = 1000;
            } else if (m16322a(c4262hb)) {
                i3 = PathInterpolatorCompat.MAX_NUM_POINTS;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i3));
            notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, m16306a(c4262hb));
        }
        String str2 = m15264a.m15097a() == null ? null : m15264a.m15097a().get("message_count");
        if (C4300j.m15680a() && str2 != null) {
            try {
                C4355ag.m15908a(notification, Integer.parseInt(str2));
            } catch (NumberFormatException e2) {
                if (m15264a != null) {
                    C4172dt.m14529a(context.getApplicationContext()).m14537b(c4262hb.m15279b(), m16329b(c4262hb), m15264a.m15096a(), "8");
                }
                AbstractC4022b.m13361d("fail to set message count. " + e2);
            }
        }
        String m16306a = m16306a(c4262hb);
        C4355ag.m15910a(notification, m16306a);
        final C4354af m15874a = C4354af.m15874a(context, m16306a);
        if (C4300j.m15681a(context) && f16802a != null) {
            f16802a.m15824a(c4262hb, m15264a.m15097a(), m15729b, notification);
        }
        if (C4300j.m15681a(context) && f16802a != null && f16802a.m15827a(m15264a.m15097a(), m15729b, notification)) {
            AbstractC4022b.m13356b("consume this notificaiton by agent");
        } else {
            m15874a.m15892a(m15729b, notification);
            cVar.f16815a = true;
            AbstractC4022b.m13347a("notification: " + m15264a.m15096a() + " is notifyied");
        }
        if (C4300j.m15680a() && C4300j.m15681a(context)) {
            C4352ad.m15845a().m15860a(context, m15729b, notification);
            C4377bb.m16061a(context, m16306a, m15729b, m15264a.m15096a(), notification);
        }
        if (m16322a(c4262hb)) {
            C4172dt.m14529a(context.getApplicationContext()).m14535a(c4262hb.m15279b(), m16329b(c4262hb), m15264a.m15096a(), ErrorStatus.f6701r0, null);
        }
        if (m16338c(c4262hb)) {
            C4172dt.m14529a(context.getApplicationContext()).m14535a(c4262hb.m15279b(), m16329b(c4262hb), m15264a.m15096a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            String m15096a = m15264a != null ? m15264a.m15096a() : null;
            C4076ae m13698a = C4076ae.m13698a(context);
            int m16290a = m16290a(m15264a.m15097a());
            if (m16290a > 0 && !TextUtils.isEmpty(m15096a)) {
                final String str3 = "n_timeout_" + m15096a;
                m13698a.m13709a(str3);
                m13698a.m13710b(new C4076ae.a() { // from class: com.xiaomi.push.service.x.1
                    @Override // com.xiaomi.push.C4076ae.a
                    /* renamed from: a */
                    public String mo13391a() {
                        return str3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        m15874a.m15891a(m15729b);
                    }
                }, m16290a);
            }
        }
        Pair<Integer, C4262hb> pair = new Pair<>(Integer.valueOf(m15729b), c4262hb);
        synchronized (f16803a) {
            f16803a.add(pair);
            if (f16803a.size() > 100) {
                f16803a.remove();
            }
        }
        return cVar;
    }

    /* renamed from: b */
    private static int m16326b(Context context, String str) {
        int m16288a = m16288a(context, str, "mipush_notification");
        int m16288a2 = m16288a(context, str, "mipush_small_notification");
        if (m16288a <= 0) {
            m16288a = m16288a2 > 0 ? m16288a2 : context.getApplicationInfo().icon;
        }
        return m16288a == 0 ? context.getApplicationInfo().logo : m16288a;
    }

    /* renamed from: c */
    private static int m16336c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            AbstractC4022b.m13359c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            AbstractC4022b.m13361d("parsing notification priority error: " + e2);
            return 0;
        }
    }

    /* renamed from: b */
    public static void m16330b(Context context, String str) {
        if (!C4300j.m15681a(context) || f16802a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f16802a.m15825a(str);
    }

    /* renamed from: b */
    static boolean m16333b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b */
    static void m16331b(Context context, String str, int i2) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i2).commit();
    }

    /* renamed from: b */
    public static boolean m16334b(C4262hb c4262hb) {
        C4252gs m15264a = c4262hb.m15264a();
        return m16321a(m15264a) && m15264a.f15844b == 1 && !m16322a(c4262hb);
    }

    /* renamed from: b */
    public static String m16329b(C4262hb c4262hb) {
        return m16322a(c4262hb) ? "E100002" : m16338c(c4262hb) ? "E100000" : m16334b(c4262hb) ? "E100001" : m16339d(c4262hb) ? "E100003" : "";
    }

    /* renamed from: b */
    private static int m16327b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            AbstractC4022b.m13359c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            AbstractC4022b.m13361d("parsing channel importance error: " + e2);
            return 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0150  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent m16328b(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, int r8) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4402x.m16328b(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m16332b(android.content.Context r2, java.lang.String r3, com.xiaomi.push.NotificationBuilderC4174dv r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            boolean r0 = com.xiaomi.push.C4300j.m15681a(r2)
            if (r0 != 0) goto L2c
            java.lang.String r0 = "fcm_icon_uri"
            java.lang.String r0 = m16308a(r5, r0)
            java.lang.String r1 = "fcm_icon_color"
            java.lang.String r5 = m16308a(r5, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L2c
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L2c
            int r0 = m16288a(r2, r3, r0)
            if (r0 <= 0) goto L2c
            r1 = 1
            r4.setSmallIcon(r0)
            r4.mo14540a(r5)
            goto L2d
        L2c:
            r1 = 0
        L2d:
            if (r1 != 0) goto L48
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r5 < r0) goto L41
            int r2 = com.xiaomi.push.service.C4355ag.m15900a(r2, r3)
            android.graphics.drawable.Icon r2 = android.graphics.drawable.Icon.createWithResource(r3, r2)
            r4.setSmallIcon(r2)
            goto L48
        L41:
            int r2 = m16326b(r2, r3)
            r4.setSmallIcon(r2)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4402x.m16332b(android.content.Context, java.lang.String, com.xiaomi.push.dv, java.util.Map):void");
    }

    /* renamed from: a */
    private static PendingIntent m16292a(Context context, C4262hb c4262hb, String str, byte[] bArr, int i2) {
        return m16293a(context, c4262hb, str, bArr, i2, 0, m16318a(context, c4262hb, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.PendingIntent m16293a(android.content.Context r16, com.xiaomi.push.C4262hb r17, java.lang.String r18, byte[] r19, int r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4402x.m16293a(android.content.Context, com.xiaomi.push.hb, java.lang.String, byte[], int, int, boolean):android.app.PendingIntent");
    }

    /* renamed from: a */
    private static void m16309a(Context context, Intent intent, C4262hb c4262hb, C4252gs c4252gs, String str, int i2) {
        if (c4262hb == null || c4252gs == null || TextUtils.isEmpty(str)) {
            return;
        }
        String m16307a = m16307a(c4252gs.m15097a(), i2);
        if (TextUtils.isEmpty(m16307a)) {
            return;
        }
        if (AbstractC4362an.f16599a.equals(m16307a) || AbstractC4362an.f16600b.equals(m16307a) || AbstractC4362an.f16601c.equals(m16307a)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", c4262hb.f16001a);
            if (!TextUtils.isEmpty(c4262hb.f16005b)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, c4262hb.f16005b);
            }
            intent.putExtra("job_key", m16308a(c4252gs.m15097a(), "jobkey"));
            intent.putExtra(i2 + AbstractC1191a.f2606s1 + "target_component", m16289a(context, c4262hb.f16005b, c4252gs.m15097a(), i2));
        }
    }

    /* renamed from: a */
    private static boolean m16318a(Context context, C4262hb c4262hb, String str) {
        if (c4262hb != null && c4262hb.m15264a() != null && c4262hb.m15264a().m15097a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(c4262hb.m15264a().m15097a().get("use_clicked_activity")) && C4387j.m16112a(context, m16295a(str));
        }
        AbstractC4022b.m13347a("should clicked activity params are null.");
        return false;
    }

    /* renamed from: a */
    public static ComponentName m16295a(String str) {
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] m16325a(android.content.Context r3, com.xiaomi.push.C4252gs r4) {
        /*
            java.lang.String r0 = r4.m15114c()
            java.lang.String r1 = r4.m15118d()
            java.util.Map r4 = r4.m15097a()
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4402x.m16325a(android.content.Context, com.xiaomi.push.gs):java.lang.String[]");
    }

    /* renamed from: a */
    private static String m16308a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: a */
    private static int m16289a(Context context, String str, Map<String, String> map, int i2) {
        ComponentName m16111a;
        Intent m16328b = m16328b(context, str, map, i2);
        if (m16328b == null || (m16111a = C4387j.m16111a(context, m16328b)) == null) {
            return 0;
        }
        return m16111a.hashCode();
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.C4402x.b m16303a(android.content.Context r27, com.xiaomi.push.C4262hb r28, byte[] r29, android.widget.RemoteViews r30, android.app.PendingIntent r31, int r32) {
        /*
            Method dump skipped, instructions count: 1139
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4402x.m16303a(android.content.Context, com.xiaomi.push.hb, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.x$b");
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m16317a(NotificationBuilderC4174dv notificationBuilderC4174dv, Context context, String str, C4262hb c4262hb, byte[] bArr, int i2) {
        PendingIntent m16294a;
        PendingIntent m16294a2;
        PendingIntent m16294a3;
        PendingIntent m16294a4;
        Map<String, String> m15097a = c4262hb.m15264a().m15097a();
        if (TextUtils.equals("3", m15097a.get("notification_style_type")) || TextUtils.equals("4", m15097a.get("notification_style_type"))) {
            return;
        }
        if (m16335b(m15097a)) {
            for (int i3 = 1; i3 <= 3; i3++) {
                String str2 = m15097a.get(String.format("cust_btn_%s_n", Integer.valueOf(i3)));
                if (!TextUtils.isEmpty(str2) && (m16294a4 = m16294a(context, str, c4262hb, bArr, i2, i3)) != null) {
                    notificationBuilderC4174dv.addAction(0, str2, m16294a4);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(m15097a.get("notification_style_button_left_name")) && (m16294a3 = m16294a(context, str, c4262hb, bArr, i2, 1)) != null) {
            notificationBuilderC4174dv.addAction(0, m15097a.get("notification_style_button_left_name"), m16294a3);
        }
        if (!TextUtils.isEmpty(m15097a.get("notification_style_button_mid_name")) && (m16294a2 = m16294a(context, str, c4262hb, bArr, i2, 2)) != null) {
            notificationBuilderC4174dv.addAction(0, m15097a.get("notification_style_button_mid_name"), m16294a2);
        }
        if (TextUtils.isEmpty(m15097a.get("notification_style_button_right_name")) || (m16294a = m16294a(context, str, c4262hb, bArr, i2, 3)) == null) {
            return;
        }
        notificationBuilderC4174dv.addAction(0, m15097a.get("notification_style_button_right_name"), m16294a);
    }

    /* renamed from: a */
    private static PendingIntent m16294a(Context context, String str, C4262hb c4262hb, byte[] bArr, int i2, int i3) {
        Map<String, String> m15097a = c4262hb.m15264a().m15097a();
        if (m15097a == null) {
            return null;
        }
        boolean m16318a = m16318a(context, c4262hb, str);
        if (m16318a) {
            return m16293a(context, c4262hb, str, bArr, i2, i3, m16318a);
        }
        Intent m16296a = m16296a(context, str, m15097a, i3);
        if (m16296a == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, m16296a, 167772160);
        }
        return PendingIntent.getActivity(context, 0, m16296a, AbstractC1191a.f2490C1);
    }

    /* renamed from: a */
    public static String m16307a(Map<String, String> map, int i2) {
        String format;
        if (i2 == 0) {
            format = "notify_effect";
        } else {
            format = m16335b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i2)) : i2 == 1 ? "notification_style_button_left_notify_effect" : i2 == 2 ? "notification_style_button_mid_notify_effect" : i2 == 3 ? "notification_style_button_right_notify_effect" : i2 == 4 ? "notification_colorful_button_notify_effect" : null;
        }
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    /* renamed from: a */
    public static Intent m16296a(Context context, String str, Map<String, String> map, int i2) {
        if (m16335b(map)) {
            return m16297a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i2)), String.format("cust_btn_%s_iu", Integer.valueOf(i2)), String.format("cust_btn_%s_ic", Integer.valueOf(i2)), String.format("cust_btn_%s_wu", Integer.valueOf(i2)));
        }
        if (i2 == 1) {
            return m16297a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        }
        if (i2 == 2) {
            return m16297a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        if (i2 == 3) {
            return m16297a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
        }
        if (i2 != 4) {
            return null;
        }
        return m16297a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0115  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent m16297a(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4402x.m16297a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    @TargetApi(16)
    /* renamed from: a */
    private static NotificationBuilderC4174dv m16302a(Context context, C4262hb c4262hb, byte[] bArr, String str, int i2) {
        PendingIntent m16294a;
        String m16306a = m16306a(c4262hb);
        Map<String, String> m15097a = c4262hb.m15264a().m15097a();
        String str2 = m15097a.get("notification_style_type");
        NotificationBuilderC4174dv m15823a = (!C4300j.m15681a(context) || f16802a == null) ? null : f16802a.m15823a(context, i2, m16306a, m15097a);
        if (m15823a != null) {
            m15823a.mo14551a(m15097a);
            return m15823a;
        }
        if ("2".equals(str2)) {
            NotificationBuilderC4174dv notificationBuilderC4174dv = new NotificationBuilderC4174dv(context);
            Bitmap m16299a = TextUtils.isEmpty(m15097a.get("notification_bigPic_uri")) ? null : m16299a(context, m15097a.get("notification_bigPic_uri"), false);
            if (m16299a == null) {
                AbstractC4022b.m13347a("can not get big picture.");
                return notificationBuilderC4174dv;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(notificationBuilderC4174dv);
            bigPictureStyle.bigPicture(m16299a);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            notificationBuilderC4174dv.setStyle(bigPictureStyle);
            return notificationBuilderC4174dv;
        }
        if ("1".equals(str2)) {
            NotificationBuilderC4174dv notificationBuilderC4174dv2 = new NotificationBuilderC4174dv(context);
            notificationBuilderC4174dv2.setStyle(new Notification.BigTextStyle().bigText(str));
            return notificationBuilderC4174dv2;
        }
        if ("4".equals(str2) && C4300j.m15680a()) {
            NotificationBuilderC4173du notificationBuilderC4173du = new NotificationBuilderC4173du(context, m16306a);
            if (!TextUtils.isEmpty(m15097a.get("notification_banner_image_uri"))) {
                notificationBuilderC4173du.setLargeIcon(m16299a(context, m15097a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m15097a.get("notification_banner_icon_uri"))) {
                notificationBuilderC4173du.m14544b(m16299a(context, m15097a.get("notification_banner_icon_uri"), false));
            }
            notificationBuilderC4173du.mo14551a(m15097a);
            return notificationBuilderC4173du;
        }
        if ("3".equals(str2) && C4300j.m15680a()) {
            NotificationBuilderC4175dw notificationBuilderC4175dw = new NotificationBuilderC4175dw(context, i2, m16306a);
            if (!TextUtils.isEmpty(m15097a.get("notification_colorful_button_text")) && (m16294a = m16294a(context, m16306a, c4262hb, bArr, i2, 4)) != null) {
                notificationBuilderC4175dw.m14554a(m15097a.get("notification_colorful_button_text"), m16294a).mo14540a(m15097a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m15097a.get("notification_colorful_bg_color"))) {
                notificationBuilderC4175dw.m14555b(m15097a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m15097a.get("notification_colorful_bg_image_uri"))) {
                notificationBuilderC4175dw.setLargeIcon(m16299a(context, m15097a.get("notification_colorful_bg_image_uri"), false));
            }
            notificationBuilderC4175dw.mo14551a(m15097a);
            return notificationBuilderC4175dw;
        }
        return new NotificationBuilderC4174dv(context);
    }

    /* renamed from: a */
    private static int m16290a(Map<String, String> map) {
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

    /* renamed from: a */
    private static RemoteViews m16301a(Context context, C4262hb c4262hb, byte[] bArr) {
        C4252gs m15264a = c4262hb.m15264a();
        String m16306a = m16306a(c4262hb);
        if (m15264a != null && m15264a.m15097a() != null) {
            Map<String, String> m15097a = m15264a.m15097a();
            String str = m15097a.get("layout_name");
            String str2 = m15097a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(m16306a);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", m16306a);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(m16306a, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", m16306a);
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
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", m16306a);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", m16306a);
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
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", m16306a);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e2) {
                        AbstractC4022b.m13351a(e2);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    AbstractC4022b.m13351a(e3);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Bitmap m16298a(Context context, int i2) {
        return m16300a(context.getResources().getDrawable(i2));
    }

    /* renamed from: a */
    private static int m16288a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    /* renamed from: a */
    public static Bitmap m16300a(Drawable drawable) {
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

    /* renamed from: a */
    private static Notification m16291a(Notification notification) {
        Object m13821a = C4094aw.m13821a(notification, "extraNotification");
        if (m13821a != null) {
            C4094aw.m13822a(m13821a, "setCustomizedIcon", true);
        }
        return notification;
    }

    /* renamed from: a */
    public static String m16306a(C4262hb c4262hb) {
        C4252gs m15264a;
        if ("com.xiaomi.xmsf".equals(c4262hb.f16005b) && (m15264a = c4262hb.m15264a()) != null && m15264a.m15097a() != null) {
            String str = m15264a.m15097a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return c4262hb.f16005b;
    }

    /* renamed from: a */
    public static void m16310a(Context context, String str) {
        m16311a(context, str, -1);
    }

    /* renamed from: a */
    public static void m16311a(Context context, String str, int i2) {
        m16312a(context, str, i2, -1);
    }

    /* renamed from: a */
    public static void m16312a(Context context, String str, int i2, int i3) {
        boolean z;
        if (context == null || TextUtils.isEmpty(str) || i2 < -1) {
            return;
        }
        C4354af m15874a = C4354af.m15874a(context, str);
        List<StatusBarNotification> m15897b = m15874a.m15897b();
        if (C4310s.m15728a(m15897b)) {
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
        Iterator<StatusBarNotification> it = m15897b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    m15874a.m15891a(id);
                } else if (i4 == id) {
                    C4381d.m16075a(context, next, i3);
                    linkedList.add(next);
                    m15874a.m15891a(id);
                    break;
                }
            }
        }
        m16315a(context, (LinkedList<? extends Object>) linkedList);
    }

    /* renamed from: a */
    public static void m16314a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        C4354af m15874a = C4354af.m15874a(context, str);
        List<StatusBarNotification> m15897b = m15874a.m15897b();
        if (C4310s.m15728a(m15897b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : m15897b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String m15906a = C4355ag.m15906a(notification);
                String m15920b = C4355ag.m15920b(notification);
                if (!TextUtils.isEmpty(m15906a) && !TextUtils.isEmpty(m15920b) && m16323a(m15906a, str2) && m16323a(m15920b, str3)) {
                    linkedList.add(statusBarNotification);
                    m15874a.m15891a(id);
                }
            }
        }
        m16315a(context, (LinkedList<? extends Object>) linkedList);
    }

    /* renamed from: a */
    private static boolean m16323a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a */
    public static void m16315a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        C4374az.m16042a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    /* renamed from: a */
    static int m16287a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static boolean m16324a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* renamed from: a */
    private static boolean m16321a(C4252gs c4252gs) {
        if (c4252gs == null) {
            return false;
        }
        String m15096a = c4252gs.m15096a();
        return !TextUtils.isEmpty(m15096a) && m15096a.length() == 22 && "satuigmo".indexOf(m15096a.charAt(0)) >= 0;
    }

    /* renamed from: a */
    public static boolean m16322a(C4262hb c4262hb) {
        C4252gs m15264a = c4262hb.m15264a();
        return m16321a(m15264a) && m15264a.m15129l();
    }

    /* renamed from: a */
    private static Bitmap m16299a(Context context, String str, boolean z) {
        Future submit = f16804a.submit(new a(str, context, z));
        try {
            try {
                try {
                    Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                    return bitmap == null ? bitmap : bitmap;
                } catch (InterruptedException e2) {
                    AbstractC4022b.m13351a(e2);
                    submit.cancel(true);
                    return null;
                } catch (TimeoutException e3) {
                    AbstractC4022b.m13351a(e3);
                    submit.cancel(true);
                    return null;
                }
            } catch (ExecutionException e4) {
                AbstractC4022b.m13351a(e4);
                submit.cancel(true);
                return null;
            }
        } finally {
            submit.cancel(true);
        }
    }

    /* renamed from: a */
    private static String m16305a(Context context, String str, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_name"))) {
            return map.get("channel_name");
        }
        return C4233g.m14937b(context, str);
    }

    /* renamed from: a */
    private static void m16316a(Intent intent) {
        if (intent == null) {
            return;
        }
        int flags = intent.getFlags() & (-2) & (-3) & (-65);
        if (Build.VERSION.SDK_INT >= 21) {
            flags &= -129;
        }
        intent.setFlags(flags);
    }

    /* renamed from: a */
    private static void m16313a(Context context, String str, NotificationBuilderC4174dv notificationBuilderC4174dv, Map<String, String> map) {
        int m16288a = m16288a(context, str, "mipush_small_notification");
        int m16288a2 = m16288a(context, str, "mipush_notification");
        if (C4300j.m15681a(context)) {
            if (m16288a > 0 && m16288a2 > 0) {
                notificationBuilderC4174dv.setSmallIcon(m16288a);
                notificationBuilderC4174dv.setLargeIcon(m16298a(context, m16288a2));
                return;
            } else {
                m16332b(context, str, notificationBuilderC4174dv, map);
                return;
            }
        }
        if (m16288a > 0) {
            notificationBuilderC4174dv.setSmallIcon(m16288a);
        } else {
            m16332b(context, str, notificationBuilderC4174dv, map);
        }
        if (m16288a2 > 0) {
            notificationBuilderC4174dv.setLargeIcon(m16298a(context, m16288a2));
        }
    }
}
