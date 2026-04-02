package util;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import bean.AppBean;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import manager.NotificationHelper;
import ui.activity.VirusKillingActivity;

/* JADX INFO: compiled from: VirusKillUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class k2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f14934e = "virus_kill_type_first";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f14935f = "virus_kill_type_alarm";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f14936g = "alarm_virus";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f14937h = "\u5b9a\u65f6APP\u81ea\u68c0";
    private ArrayList<ArrayList<AppInfoBean>> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<ArrayList<AppInfoBean>> f14938b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f14939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14940d;

    /* JADX INFO: compiled from: VirusKillUtil.java */
    class a implements ui.e.c {
        final /* synthetic */ ArrayList a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f14941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f14942c;

        a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.a = arrayList;
            this.f14941b = arrayList2;
            this.f14942c = arrayList3;
        }

        @Override // ui.e.c
        public void a(int i2) {
            s1.c("Scanner", "APP\u603b\u6570=" + i2);
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
        }

        @Override // ui.e.c
        public void b() {
            s1.c("Scanner", "\u68c0\u6d4b\u5e94\u7528-----------------scanStop");
        }

        @Override // ui.e.c
        public void c() {
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                AppInfoBean appInfoBean = list.get(i2);
                appInfoBean.setFlag(1);
                appInfoBean.setSelect(false);
                appInfoBean.setTypeIsApp(true);
                int virusLevel = appInfoBean.getVirusLevel();
                if (virusLevel == 1) {
                    this.a.add(appInfoBean);
                    k2.this.f();
                } else if (virusLevel != 2) {
                    appInfoBean.setVirusLevel(0);
                    this.f14942c.add(appInfoBean);
                } else {
                    this.f14941b.add(appInfoBean);
                    k2.this.f();
                }
                s1.c("Scanner", "\u68c0\u6d4b\u5b8c\u6210\u5e94\u7528=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
            }
        }

        @Override // ui.e.c
        public void a() {
            s1.c("Scanner", "\u68c0\u6d4b\u5b8c\u6210");
            if (k2.this.f14940d) {
                if (k2.this.a()) {
                    k2.this.d();
                    return;
                }
                return;
            }
            k2.this.d();
        }
    }

    /* JADX INFO: compiled from: VirusKillUtil.java */
    class b implements ui.e.c {
        final /* synthetic */ ArrayList a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f14944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f14945c;

        b(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.a = arrayList;
            this.f14944b = arrayList2;
            this.f14945c = arrayList3;
        }

        @Override // ui.e.c
        public void a(int i2) {
            s1.c("Scanner", "\u5f00\u59cb\u68c0\u6d4b\u5b89\u88c5\u5305\u4e2a\u6570=====" + i2);
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
        }

        @Override // ui.e.c
        public void b() {
            s1.c("Scanner", "\u68c0\u6d4b\u5b89\u88c5\u5305       scanStop=====");
        }

        @Override // ui.e.c
        public void c() {
            s1.c("Scanner", "\u5f00\u59cb\u68c0\u6d4b\u5b89\u88c5\u5305=====");
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                AppInfoBean appInfoBean = list.get(i2);
                appInfoBean.setFlag(1);
                appInfoBean.setSelect(false);
                appInfoBean.setTypeIsApp(false);
                int virusLevel = appInfoBean.getVirusLevel();
                if (virusLevel == 1) {
                    this.a.add(appInfoBean);
                    k2.this.f();
                } else if (virusLevel != 2) {
                    appInfoBean.setVirusLevel(0);
                    if (appInfoBean.getAppIcon() != null && !TextUtils.isEmpty(appInfoBean.getName())) {
                        this.f14945c.add(appInfoBean);
                    }
                } else {
                    this.f14944b.add(appInfoBean);
                    k2.this.f();
                }
                s1.c("Scanner", "\u68c0\u6d4b\u5b8c\u6210\u5b89\u88c5\u5305=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
            }
        }

        @Override // ui.e.c
        @SuppressLint({"RestrictedApi"})
        public void a() {
            k2.this.e();
        }
    }

    public k2(Context context, String str) {
        this.f14939c = null;
        this.f14939c = new WeakReference<>(context);
        this.f14940d = TextUtils.equals(f14934e, str);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!this.f14940d) {
            g();
            a(this.f14939c.get());
        } else if (a()) {
            c2.b(c2.B0, true);
            org.greenrobot.eventbus.c.f().d(new util.n2.a(153, null));
        }
    }

    private void g() {
        ui.e.b.e().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return !c2.a(c2.z0, false);
    }

    private void b() {
        a(this.a, c2.C0, c2.D0, c2.E0);
        a(this.f14938b, c2.F0, c2.G0, c2.H0);
    }

    private void c() {
        this.a.clear();
        this.f14938b.clear();
        a(this.a, "\u5e94\u7528");
        ui.e.b.e().a(this.f14939c.get(), new a(this.a.get(0), this.a.get(1), this.a.get(2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a(this.f14938b, "\u5b89\u88c5\u5305");
        ui.e.b.e().b(this.f14939c.get(), new b(this.f14938b.get(0), this.f14938b.get(1), this.f14938b.get(2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f14940d && a()) {
            org.greenrobot.eventbus.c.f().d(new util.n2.a(154, null));
            b();
            c2.b(c2.A0, true);
            c2.b(c2.z0, true);
            g();
        }
    }

    private void a(ArrayList<ArrayList<AppInfoBean>> arrayList, String str) {
        try {
            arrayList.add(new ArrayList<>());
            arrayList.add(new ArrayList<>());
            arrayList.add(new ArrayList<>());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(ArrayList<ArrayList<AppInfoBean>> arrayList, String str, String str2, String str3) {
        if (arrayList == null || arrayList.size() <= 2) {
            return;
        }
        ArrayList<AppInfoBean> arrayList2 = arrayList.get(0);
        ArrayList<AppInfoBean> arrayList3 = arrayList.get(1);
        ArrayList<AppInfoBean> arrayList4 = arrayList.get(2);
        a(arrayList2, str, true);
        a(arrayList3, str2, true);
        a(arrayList4, str3, false);
    }

    private void a(List<AppInfoBean> list, String str, boolean z) {
        Drawable drawableB;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            AppInfoBean appInfoBean = list.get(i2);
            if (z && (drawableB = x1.b(appInfoBean.getPkgPath())) != null && !TextUtils.isEmpty(appInfoBean.getName())) {
                appInfoBean.setAppIcon(drawableB);
                k.c.a(k.c.a(appInfoBean.getAppIcon()), appInfoBean.getName(), appInfoBean.getVersionName(), k.c.f12650c);
            }
            arrayList.add(AppBean.AppInfoBean2AppBean(appInfoBean));
            c2.a((List) arrayList, str);
        }
    }

    public void a(Context context) {
        Notification.Builder builder;
        Intent intent = new Intent(context, (Class<?>) VirusKillingActivity.class);
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        PendingIntent activity = PendingIntent.getActivity(context, 101, intent, d.c.a.b.a.a.C1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(f14936g, f14937h, 4));
            builder = new Notification.Builder(context, f14936g);
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setContentTitle(f14937h).setContentText("\u68c0\u6d4b\u5230\u60a8\u7684\u624b\u673a\u6709\u53ef\u7591\u5e94\u7528").setWhen(System.currentTimeMillis()).setAutoCancel(true).setShowWhen(true).setContentIntent(activity).setSmallIcon(R.drawable.logo).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.logo)).setTicker(NotificationHelper.CHANEL_NAME).build();
        notificationManager.notify(3, builder.build());
    }
}
