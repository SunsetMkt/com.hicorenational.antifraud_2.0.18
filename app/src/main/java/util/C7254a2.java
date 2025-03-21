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
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import manager.NotificationHelper;
import org.greenrobot.eventbus.C6049c;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p357j.C5844c;
import p388ui.activity.VirusKillingActivity;
import p388ui.p390e.C6823b;
import p388ui.p390e.InterfaceC6824c;
import util.p395c2.C7265a;

/* compiled from: VirusKillUtil.java */
/* renamed from: util.a2 */
/* loaded from: classes2.dex */
public class C7254a2 {

    /* renamed from: e */
    public static final String f25104e = "virus_kill_type_first";

    /* renamed from: f */
    public static final String f25105f = "virus_kill_type_alarm";

    /* renamed from: g */
    public static final String f25106g = "alarm_virus";

    /* renamed from: h */
    public static final String f25107h = "定时APP自检";

    /* renamed from: a */
    private ArrayList<ArrayList<AppInfoBean>> f25108a = new ArrayList<>();

    /* renamed from: b */
    private ArrayList<ArrayList<AppInfoBean>> f25109b = new ArrayList<>();

    /* renamed from: c */
    private WeakReference<Context> f25110c;

    /* renamed from: d */
    private boolean f25111d;

    /* compiled from: VirusKillUtil.java */
    /* renamed from: util.a2$a */
    class a implements InterfaceC6824c {

        /* renamed from: a */
        final /* synthetic */ ArrayList f25112a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f25113b;

        /* renamed from: c */
        final /* synthetic */ ArrayList f25114c;

        a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f25112a = arrayList;
            this.f25113b = arrayList2;
            this.f25114c = arrayList3;
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25403a(int i2) {
            C7301n1.m26459c("Scanner", "APP总数=" + i2);
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25405a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: b */
        public void mo25406b() {
            C7301n1.m26459c("Scanner", "检测应用-----------------scanStop");
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: c */
        public void mo25407c() {
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25404a(List<AppInfoBean> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                AppInfoBean appInfoBean = list.get(i2);
                appInfoBean.setFlag(1);
                appInfoBean.setSelect(false);
                appInfoBean.setTypeIsApp(true);
                int virusLevel = appInfoBean.getVirusLevel();
                if (virusLevel == 1) {
                    this.f25112a.add(appInfoBean);
                    C7254a2.this.m26164f();
                } else if (virusLevel != 2) {
                    appInfoBean.setVirusLevel(0);
                    this.f25114c.add(appInfoBean);
                } else {
                    this.f25113b.add(appInfoBean);
                    C7254a2.this.m26164f();
                }
                C7301n1.m26459c("Scanner", "检测完成应用=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
            }
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25402a() {
            C7301n1.m26459c("Scanner", "检测完成");
            if (C7254a2.this.f25111d) {
                if (C7254a2.this.m26155a()) {
                    C7254a2.this.m26160d();
                    return;
                }
                return;
            }
            C7254a2.this.m26160d();
        }
    }

    /* compiled from: VirusKillUtil.java */
    /* renamed from: util.a2$b */
    class b implements InterfaceC6824c {

        /* renamed from: a */
        final /* synthetic */ ArrayList f25116a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f25117b;

        /* renamed from: c */
        final /* synthetic */ ArrayList f25118c;

        b(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f25116a = arrayList;
            this.f25117b = arrayList2;
            this.f25118c = arrayList3;
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25403a(int i2) {
            C7301n1.m26459c("Scanner", "开始检测安装包个数=====" + i2);
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25405a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: b */
        public void mo25406b() {
            C7301n1.m26459c("Scanner", "检测安装包       scanStop=====");
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: c */
        public void mo25407c() {
            C7301n1.m26459c("Scanner", "开始检测安装包=====");
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25404a(List<AppInfoBean> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                AppInfoBean appInfoBean = list.get(i2);
                appInfoBean.setFlag(1);
                appInfoBean.setSelect(false);
                appInfoBean.setTypeIsApp(false);
                int virusLevel = appInfoBean.getVirusLevel();
                if (virusLevel == 1) {
                    this.f25116a.add(appInfoBean);
                    C7254a2.this.m26164f();
                } else if (virusLevel != 2) {
                    appInfoBean.setVirusLevel(0);
                    if (appInfoBean.getAppIcon() != null && !TextUtils.isEmpty(appInfoBean.getName())) {
                        this.f25118c.add(appInfoBean);
                    }
                } else {
                    this.f25117b.add(appInfoBean);
                    C7254a2.this.m26164f();
                }
                C7301n1.m26459c("Scanner", "检测完成安装包=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
            }
        }

        @Override // p388ui.p390e.InterfaceC6824c
        @SuppressLint({"RestrictedApi"})
        /* renamed from: a */
        public void mo25402a() {
            C7254a2.this.m26162e();
        }
    }

    public C7254a2(Context context, String str) {
        this.f25110c = null;
        this.f25110c = new WeakReference<>(context);
        this.f25111d = TextUtils.equals(f25104e, str);
        m26158c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m26164f() {
        if (!this.f25111d) {
            m26165g();
            m26166a(this.f25110c.get());
        } else if (m26155a()) {
            C7325u1.m26631b(C7325u1.f25626B0, true);
            C6049c.m24987f().m25000d(new C7265a(153, null));
        }
    }

    /* renamed from: g */
    private void m26165g() {
        C6823b.m25505e().m25517b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m26155a() {
        return !C7325u1.m26623a(C7325u1.f25711z0, false);
    }

    /* renamed from: b */
    private void m26156b() {
        m26152a(this.f25108a, C7325u1.f25628C0, C7325u1.f25630D0, C7325u1.f25632E0);
        m26152a(this.f25109b, C7325u1.f25634F0, C7325u1.f25636G0, C7325u1.f25638H0);
    }

    /* renamed from: c */
    private void m26158c() {
        this.f25108a.clear();
        this.f25109b.clear();
        m26151a(this.f25108a, "应用");
        C6823b.m25505e().m25516a(this.f25110c.get(), new a(this.f25108a.get(0), this.f25108a.get(1), this.f25108a.get(2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m26160d() {
        m26151a(this.f25109b, "安装包");
        C6823b.m25505e().m25519b(this.f25110c.get(), new b(this.f25109b.get(0), this.f25109b.get(1), this.f25109b.get(2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m26162e() {
        if (this.f25111d && m26155a()) {
            C6049c.m24987f().m25000d(new C7265a(154, null));
            m26156b();
            C7325u1.m26631b(C7325u1.f25624A0, true);
            C7325u1.m26631b(C7325u1.f25711z0, true);
            m26165g();
        }
    }

    /* renamed from: a */
    private void m26151a(ArrayList<ArrayList<AppInfoBean>> arrayList, String str) {
        try {
            arrayList.add(new ArrayList<>());
            arrayList.add(new ArrayList<>());
            arrayList.add(new ArrayList<>());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m26152a(ArrayList<ArrayList<AppInfoBean>> arrayList, String str, String str2, String str3) {
        if (arrayList == null || arrayList.size() <= 2) {
            return;
        }
        ArrayList<AppInfoBean> arrayList2 = arrayList.get(0);
        ArrayList<AppInfoBean> arrayList3 = arrayList.get(1);
        ArrayList<AppInfoBean> arrayList4 = arrayList.get(2);
        m26153a(arrayList2, str, true);
        m26153a(arrayList3, str2, true);
        m26153a(arrayList4, str3, false);
    }

    /* renamed from: a */
    private void m26153a(List<AppInfoBean> list, String str, boolean z) {
        Drawable m26543b;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            AppInfoBean appInfoBean = list.get(i2);
            if (z && (m26543b = C7316r1.m26543b(appInfoBean.getPkgPath())) != null && !TextUtils.isEmpty(appInfoBean.getName())) {
                appInfoBean.setAppIcon(m26543b);
                C5844c.m24592a(C5844c.m24588a(appInfoBean.getAppIcon()), appInfoBean.getName(), appInfoBean.getVersionName(), C5844c.f21114c);
            }
            arrayList.add(AppBean.AppInfoBean2AppBean(appInfoBean));
            C7325u1.m26622a((List) arrayList, str);
        }
    }

    /* renamed from: a */
    public void m26166a(Context context) {
        Notification.Builder builder;
        Intent intent = new Intent(context, (Class<?>) VirusKillingActivity.class);
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        PendingIntent activity = PendingIntent.getActivity(context, 101, intent, AbstractC1191a.f2490C1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(f25106g, f25107h, 4));
            builder = new Notification.Builder(context, f25106g);
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setContentTitle(f25107h).setContentText("检测到您的手机有可疑应用").setWhen(System.currentTimeMillis()).setAutoCancel(true).setShowWhen(true).setContentIntent(activity).setSmallIcon(C2113R.drawable.logo).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), C2113R.drawable.logo)).setTicker(NotificationHelper.CHANEL_NAME).build();
        notificationManager.notify(3, builder.build());
    }
}
