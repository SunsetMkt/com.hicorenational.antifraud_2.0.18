package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4092au;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4099ba;
import com.xiaomi.push.C4144cs;
import com.xiaomi.push.C4172dt;
import com.xiaomi.push.C4243gj;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4266hf;
import com.xiaomi.push.C4272hl;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4240gg;
import com.xiaomi.push.EnumC4244gk;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.InterfaceC4277hq;
import com.xiaomi.push.service.AbstractC4362an;
import com.xiaomi.push.service.C4356ah;
import com.xiaomi.push.service.C4358aj;
import com.xiaomi.push.service.C4364ap;
import com.xiaomi.push.service.C4384g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.mipush.sdk.u */
/* loaded from: classes2.dex */
public class C4067u {

    /* renamed from: a */
    private static C4067u f14442a = null;

    /* renamed from: a */
    private static final ArrayList<a> f14443a = new ArrayList<>();

    /* renamed from: b */
    private static boolean f14444b = false;

    /* renamed from: a */
    private long f14445a;

    /* renamed from: a */
    private Context f14446a;

    /* renamed from: a */
    private Handler f14448a;

    /* renamed from: a */
    private Messenger f14449a;

    /* renamed from: a */
    private boolean f14453a;

    /* renamed from: a */
    private List<Message> f14452a = new ArrayList();

    /* renamed from: c */
    private boolean f14455c = false;

    /* renamed from: b */
    private String f14454b = null;

    /* renamed from: a */
    private Intent f14447a = null;

    /* renamed from: a */
    private Integer f14450a = null;

    /* renamed from: a */
    private String f14451a = null;

    /* renamed from: com.xiaomi.mipush.sdk.u$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14460a = new int[EnumC4068v.values().length];

        static {
            try {
                f14460a[EnumC4068v.DISABLE_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14460a[EnumC4068v.ENABLE_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14460a[EnumC4068v.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14460a[EnumC4068v.UPLOAD_FCM_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14460a[EnumC4068v.UPLOAD_COS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14460a[EnumC4068v.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.u$a */
    static class a<T extends InterfaceC4277hq<T, ?>> {

        /* renamed from: a */
        EnumC4239gf f14461a;

        /* renamed from: a */
        T f14462a;

        /* renamed from: a */
        boolean f14463a;

        a() {
        }
    }

    private C4067u(Context context) {
        this.f14453a = false;
        this.f14448a = null;
        this.f14446a = context.getApplicationContext();
        this.f14453a = m13640c();
        f14444b = m13643d();
        this.f14448a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.mipush.sdk.u.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message.what != 19) {
                    return;
                }
                String str = (String) message.obj;
                int i2 = message.arg1;
                synchronized (C4062p.class) {
                    if (C4062p.m13587a(C4067u.this.f14446a).m13592a(str)) {
                        if (C4062p.m13587a(C4067u.this.f14446a).m13588a(str) < 10) {
                            String string = message.getData() != null ? message.getData().getString("third_sync_reason") : "";
                            if (EnumC4068v.DISABLE_PUSH.ordinal() == i2 && "syncing".equals(C4062p.m13587a(C4067u.this.f14446a).m13589a(EnumC4068v.DISABLE_PUSH))) {
                                C4067u.this.m13633a(str, EnumC4068v.DISABLE_PUSH, true, (HashMap<String, String>) null);
                            } else if (EnumC4068v.ENABLE_PUSH.ordinal() == i2 && "syncing".equals(C4062p.m13587a(C4067u.this.f14446a).m13589a(EnumC4068v.ENABLE_PUSH))) {
                                C4067u.this.m13633a(str, EnumC4068v.ENABLE_PUSH, true, (HashMap<String, String>) null);
                            } else if (EnumC4068v.UPLOAD_HUAWEI_TOKEN.ordinal() == i2 && "syncing".equals(C4062p.m13587a(C4067u.this.f14446a).m13589a(EnumC4068v.UPLOAD_HUAWEI_TOKEN))) {
                                HashMap<String, String> m13535a = C4052f.m13535a(C4067u.this.f14446a, EnumC4050d.ASSEMBLE_PUSH_HUAWEI);
                                m13535a.put("third_sync_reason", string);
                                C4067u.this.m13633a(str, EnumC4068v.UPLOAD_HUAWEI_TOKEN, false, m13535a);
                            } else if (EnumC4068v.UPLOAD_FCM_TOKEN.ordinal() == i2 && "syncing".equals(C4062p.m13587a(C4067u.this.f14446a).m13589a(EnumC4068v.UPLOAD_FCM_TOKEN))) {
                                C4067u.this.m13633a(str, EnumC4068v.UPLOAD_FCM_TOKEN, false, C4052f.m13535a(C4067u.this.f14446a, EnumC4050d.ASSEMBLE_PUSH_FCM));
                            } else if (EnumC4068v.UPLOAD_COS_TOKEN.ordinal() == i2 && "syncing".equals(C4062p.m13587a(C4067u.this.f14446a).m13589a(EnumC4068v.UPLOAD_COS_TOKEN))) {
                                HashMap<String, String> m13535a2 = C4052f.m13535a(C4067u.this.f14446a, EnumC4050d.ASSEMBLE_PUSH_COS);
                                m13535a2.put("third_sync_reason", string);
                                C4067u.this.m13633a(str, EnumC4068v.UPLOAD_COS_TOKEN, false, m13535a2);
                            } else if (EnumC4068v.UPLOAD_FTOS_TOKEN.ordinal() == i2 && "syncing".equals(C4062p.m13587a(C4067u.this.f14446a).m13589a(EnumC4068v.UPLOAD_FTOS_TOKEN))) {
                                HashMap<String, String> m13535a3 = C4052f.m13535a(C4067u.this.f14446a, EnumC4050d.ASSEMBLE_PUSH_FTOS);
                                m13535a3.put("third_sync_reason", string);
                                C4067u.this.m13633a(str, EnumC4068v.UPLOAD_FTOS_TOKEN, false, m13535a3);
                            }
                            C4062p.m13587a(C4067u.this.f14446a).m13593b(str);
                        } else {
                            C4062p.m13587a(C4067u.this.f14446a).m13594c(str);
                        }
                    }
                }
            }
        };
        if (C4300j.m15681a(context)) {
            C4384g.m16095a(new C4384g.b() { // from class: com.xiaomi.mipush.sdk.u.2
            });
        }
        Intent m13635b = m13635b();
        if (m13635b != null) {
            m13636b(m13635b);
        }
    }

    /* renamed from: c */
    private synchronized void m13638c(int i2) {
        this.f14446a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i2).commit();
    }

    /* renamed from: d */
    private Intent m13641d() {
        Intent intent = new Intent();
        String packageName = this.f14446a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m13630a());
        intent.putExtra("mipush_app_package", packageName);
        m13647h();
        return intent;
    }

    /* renamed from: e */
    private Intent m13644e() {
        Intent intent = new Intent();
        String packageName = this.f14446a.getPackageName();
        m13648i();
        intent.setComponent(new ComponentName(this.f14446a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: g */
    private void m13646g() {
        this.f14445a = SystemClock.elapsedRealtime();
    }

    /* renamed from: h */
    private void m13647h() {
        try {
            PackageManager packageManager = this.f14446a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f14446a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    private void m13648i() {
        try {
            PackageManager packageManager = this.f14446a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f14446a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public final void m13673b() {
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        m13639c(m13623a);
    }

    /* renamed from: f */
    public void m13679f() {
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m13623a.putExtra(AbstractC4362an.f16586F, this.f14446a.getPackageName());
        m13623a.putExtra(AbstractC4362an.f16591K, C4099ba.m13877b(this.f14446a.getPackageName()));
        m13639c(m13623a);
    }

    /* renamed from: b */
    private Intent m13635b() {
        if (!"com.xiaomi.xmsf".equals(this.f14446a.getPackageName())) {
            return m13637c();
        }
        AbstractC4022b.m13359c("pushChannel xmsf create own channel");
        return m13644e();
    }

    /* renamed from: c */
    private boolean m13640c() {
        try {
            PackageInfo packageInfo = this.f14446a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e */
    public void m13678e() {
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) C4094aw.m13824a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f14446a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            AbstractC4022b.m13347a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        m13623a.putExtra(AbstractC4362an.f16586F, packageName);
        m13639c(m13623a);
    }

    /* renamed from: c */
    private Intent m13637c() {
        if (m13671a()) {
            AbstractC4022b.m13359c("pushChannel app start miui china channel");
            return m13641d();
        }
        AbstractC4022b.m13359c("pushChannel app start  own channel");
        return m13644e();
    }

    /* renamed from: d */
    public void m13677d() {
        synchronized (f14443a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = f14443a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                m13663a(next.f14462a, next.f14461a, next.f14463a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f14443a.clear();
        }
    }

    /* renamed from: b */
    public void m13674b(int i2) {
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m13623a.putExtra(AbstractC4362an.f16586F, this.f14446a.getPackageName());
        m13623a.putExtra(AbstractC4362an.f16589I, i2);
        m13623a.putExtra(AbstractC4362an.f16591K, C4099ba.m13877b(this.f14446a.getPackageName() + i2));
        m13639c(m13623a);
    }

    /* renamed from: a */
    public static synchronized C4067u m13627a(Context context) {
        C4067u c4067u;
        synchronized (C4067u.class) {
            if (f14442a == null) {
                f14442a = new C4067u(context);
            }
            c4067u = f14442a;
        }
        return c4067u;
    }

    /* renamed from: a */
    private synchronized int m13621a() {
        return this.f14446a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: c */
    public void m13676c() {
        if (this.f14447a != null) {
            m13646g();
            m13639c(this.f14447a);
            this.f14447a = null;
        }
    }

    /* renamed from: d */
    private boolean m13643d() {
        if (m13671a()) {
            try {
                return this.f14446a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m13675b() {
        if (!m13671a() || !m13645e()) {
            return true;
        }
        if (this.f14450a == null) {
            this.f14450a = Integer.valueOf(C4364ap.m15985a(this.f14446a).m15986a());
            if (this.f14450a.intValue() == 0) {
                this.f14446a.getContentResolver().registerContentObserver(C4364ap.m15985a(this.f14446a).m15987a(), false, new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.mipush.sdk.u.3
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        C4067u c4067u = C4067u.this;
                        c4067u.f14450a = Integer.valueOf(C4364ap.m15985a(c4067u.f14446a).m15986a());
                        if (C4067u.this.f14450a.intValue() != 0) {
                            C4067u.this.f14446a.getContentResolver().unregisterContentObserver(this);
                            if (C4092au.m13799a(C4067u.this.f14446a)) {
                                C4067u.this.m13676c();
                            }
                        }
                    }
                });
            }
        }
        return this.f14450a.intValue() != 0;
    }

    /* renamed from: a */
    public long m13649a() {
        return this.f14445a;
    }

    /* renamed from: c */
    private void m13639c(Intent intent) {
        int m15927a = C4356ah.m15923a(this.f14446a).m15927a(EnumC4244gk.ServiceBootMode.m15014a(), EnumC4240gg.START.m14969a());
        int m13621a = m13621a();
        boolean z = m15927a == EnumC4240gg.BIND.m14969a() && f14444b;
        int m14969a = (z ? EnumC4240gg.BIND : EnumC4240gg.START).m14969a();
        if (m14969a != m13621a) {
            m13672a(m14969a);
        }
        if (z) {
            m13642d(intent);
        } else {
            m13636b(intent);
        }
    }

    /* renamed from: e */
    private boolean m13645e() {
        String packageName = this.f14446a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f14446a.getApplicationInfo().flags & 1) != 0;
    }

    /* renamed from: a */
    public final void m13657a(C4266hf c4266hf, boolean z) {
        C4172dt.m14529a(this.f14446a.getApplicationContext()).m14535a(this.f14446a.getPackageName(), "E100003", c4266hf.m15343a(), AuthCode.StatusCode.WAITING_CONNECT, null);
        this.f14447a = null;
        C4048b.m13476a(this.f14446a).f14378a = c4266hf.m15343a();
        Intent m13623a = m13623a();
        byte[] m15567a = C4276hp.m15567a(C4064r.m13595a(this.f14446a, c4266hf, EnumC4239gf.Registration));
        if (m15567a == null) {
            AbstractC4022b.m13347a("register fail, because msgBytes is null.");
            return;
        }
        m13623a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m13623a.putExtra("mipush_app_id", C4048b.m13476a(this.f14446a).m13480a());
        m13623a.putExtra("mipush_payload", m15567a);
        m13623a.putExtra("mipush_session", this.f14451a);
        m13623a.putExtra("mipush_env_chanage", z);
        m13623a.putExtra("mipush_env_type", C4048b.m13476a(this.f14446a).m13478a());
        if (C4092au.m13799a(this.f14446a) && m13675b()) {
            m13646g();
            m13639c(m13623a);
        } else {
            this.f14447a = m13623a;
        }
    }

    /* renamed from: d */
    private synchronized void m13642d(Intent intent) {
        if (this.f14455c) {
            Message m13624a = m13624a(intent);
            if (this.f14452a.size() >= 50) {
                this.f14452a.remove(0);
            }
            this.f14452a.add(m13624a);
            return;
        }
        if (this.f14449a == null) {
            this.f14446a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.mipush.sdk.u.4
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (C4067u.this) {
                        C4067u.this.f14449a = new Messenger(iBinder);
                        C4067u.this.f14455c = false;
                        Iterator it = C4067u.this.f14452a.iterator();
                        while (it.hasNext()) {
                            try {
                                C4067u.this.f14449a.send((Message) it.next());
                            } catch (RemoteException e2) {
                                AbstractC4022b.m13351a(e2);
                            }
                        }
                        C4067u.this.f14452a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    C4067u.this.f14449a = null;
                    C4067u.this.f14455c = false;
                }
            }, 1);
            this.f14455c = true;
            this.f14452a.clear();
            this.f14452a.add(m13624a(intent));
        } else {
            try {
                this.f14449a.send(m13624a(intent));
            } catch (RemoteException unused) {
                this.f14449a = null;
                this.f14455c = false;
            }
        }
    }

    /* renamed from: b */
    private void m13636b(Intent intent) {
        try {
            if (!C4300j.m15680a() && Build.VERSION.SDK_INT >= 26) {
                m13642d(intent);
            } else {
                this.f14446a.startService(intent);
            }
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
        }
    }

    /* renamed from: a */
    public void m13650a() {
        m13636b(m13623a());
    }

    /* renamed from: a */
    public final void m13658a(C4272hl c4272hl) {
        byte[] m15567a = C4276hp.m15567a(C4064r.m13595a(this.f14446a, c4272hl, EnumC4239gf.UnRegistration));
        if (m15567a == null) {
            AbstractC4022b.m13347a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m13623a.putExtra("mipush_app_id", C4048b.m13476a(this.f14446a).m13480a());
        m13623a.putExtra("mipush_payload", m15567a);
        m13639c(m13623a);
    }

    /* renamed from: a */
    public final void m13669a(boolean z) {
        m13670a(z, (String) null);
    }

    /* renamed from: a */
    public final void m13670a(boolean z, String str) {
        if (z) {
            C4062p.m13587a(this.f14446a).m13590a(EnumC4068v.DISABLE_PUSH, "syncing");
            C4062p.m13587a(this.f14446a).m13590a(EnumC4068v.ENABLE_PUSH, "");
            m13633a(str, EnumC4068v.DISABLE_PUSH, true, (HashMap<String, String>) null);
        } else {
            C4062p.m13587a(this.f14446a).m13590a(EnumC4068v.ENABLE_PUSH, "syncing");
            C4062p.m13587a(this.f14446a).m13590a(EnumC4068v.DISABLE_PUSH, "");
            m13633a(str, EnumC4068v.ENABLE_PUSH, true, (HashMap<String, String>) null);
        }
    }

    /* renamed from: a */
    public void m13654a(Context context) {
        if (C4300j.m15680a()) {
            return;
        }
        EnumC4063q m13558a = C4054h.m13558a(context);
        if (EnumC4063q.HUAWEI.equals(m13558a)) {
            m13667a((String) null, EnumC4068v.UPLOAD_HUAWEI_TOKEN, EnumC4050d.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (EnumC4063q.OPPO.equals(m13558a)) {
            m13667a((String) null, EnumC4068v.UPLOAD_COS_TOKEN, EnumC4050d.ASSEMBLE_PUSH_COS, "update");
        }
        if (EnumC4063q.VIVO.equals(m13558a)) {
            m13667a((String) null, EnumC4068v.UPLOAD_FTOS_TOKEN, EnumC4050d.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    /* renamed from: a */
    public final void m13667a(String str, EnumC4068v enumC4068v, EnumC4050d enumC4050d, String str2) {
        C4062p.m13587a(this.f14446a).m13590a(enumC4068v, "syncing");
        HashMap<String, String> m13535a = C4052f.m13535a(this.f14446a, enumC4050d);
        m13535a.put("third_sync_reason", str2);
        m13633a(str, enumC4068v, false, m13535a);
    }

    /* renamed from: a */
    void m13653a(int i2, String str) {
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.thirdparty");
        m13623a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i2);
        m13623a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        m13636b(m13623a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13633a(String str, EnumC4068v enumC4068v, boolean z, HashMap<String, String> hashMap) {
        C4265he c4265he;
        if (C4048b.m13476a(this.f14446a).m13494b() && C4092au.m13799a(this.f14446a)) {
            C4265he c4265he2 = new C4265he();
            c4265he2.m15304a(true);
            Intent m13623a = m13623a();
            if (TextUtils.isEmpty(str)) {
                str = C4358aj.m15941a();
                c4265he2.m15301a(str);
                c4265he = z ? new C4265he(str, true) : null;
                synchronized (C4062p.class) {
                    C4062p.m13587a(this.f14446a).m13591a(str);
                }
            } else {
                c4265he2.m15301a(str);
                c4265he = z ? new C4265he(str, true) : null;
            }
            switch (AnonymousClass5.f14460a[enumC4068v.ordinal()]) {
                case 1:
                    c4265he2.m15318c(EnumC4249gp.DisablePushMessage.f15769a);
                    c4265he.m15318c(EnumC4249gp.DisablePushMessage.f15769a);
                    if (hashMap != null) {
                        c4265he2.m15303a(hashMap);
                        c4265he.m15303a(hashMap);
                    }
                    m13623a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    c4265he2.m15318c(EnumC4249gp.EnablePushMessage.f15769a);
                    c4265he.m15318c(EnumC4249gp.EnablePushMessage.f15769a);
                    if (hashMap != null) {
                        c4265he2.m15303a(hashMap);
                        c4265he.m15303a(hashMap);
                    }
                    m13623a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    c4265he2.m15318c(EnumC4249gp.ThirdPartyRegUpdate.f15769a);
                    if (hashMap != null) {
                        c4265he2.m15303a(hashMap);
                        break;
                    }
                    break;
            }
            AbstractC4022b.m13363e("type:" + enumC4068v + ", " + str);
            c4265he2.m15314b(C4048b.m13476a(this.f14446a).m13480a());
            c4265he2.m15322d(this.f14446a.getPackageName());
            m13661a((C4067u) c4265he2, EnumC4239gf.Notification, false, (C4252gs) null);
            if (z) {
                c4265he.m15314b(C4048b.m13476a(this.f14446a).m13480a());
                c4265he.m15322d(this.f14446a.getPackageName());
                Context context = this.f14446a;
                byte[] m15567a = C4276hp.m15567a(C4064r.m13596a(context, c4265he, EnumC4239gf.Notification, false, context.getPackageName(), C4048b.m13476a(this.f14446a).m13480a()));
                if (m15567a != null) {
                    C4144cs.m14182a(this.f14446a.getPackageName(), this.f14446a, c4265he, EnumC4239gf.Notification, m15567a.length);
                    m13623a.putExtra("mipush_payload", m15567a);
                    m13623a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m13623a.putExtra("mipush_app_id", C4048b.m13476a(this.f14446a).m13480a());
                    m13623a.putExtra("mipush_app_token", C4048b.m13476a(this.f14446a).m13490b());
                    m13639c(m13623a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = enumC4068v.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            if (hashMap != null && hashMap.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", hashMap.get("third_sync_reason"));
                obtain.setData(bundle);
            }
            this.f14448a.sendMessageDelayed(obtain, C2084a.f6136r);
        }
    }

    /* renamed from: a */
    public final <T extends InterfaceC4277hq<T, ?>> void m13659a(T t, EnumC4239gf enumC4239gf, C4252gs c4252gs) {
        m13661a((C4067u) t, enumC4239gf, !enumC4239gf.equals(EnumC4239gf.Registration), c4252gs);
    }

    /* renamed from: a */
    public final <T extends InterfaceC4277hq<T, ?>> void m13662a(T t, EnumC4239gf enumC4239gf, boolean z, C4252gs c4252gs, boolean z2) {
        m13663a(t, enumC4239gf, z, true, c4252gs, z2);
    }

    /* renamed from: a */
    public final <T extends InterfaceC4277hq<T, ?>> void m13661a(T t, EnumC4239gf enumC4239gf, boolean z, C4252gs c4252gs) {
        m13663a(t, enumC4239gf, z, true, c4252gs, true);
    }

    /* renamed from: a */
    public final <T extends InterfaceC4277hq<T, ?>> void m13663a(T t, EnumC4239gf enumC4239gf, boolean z, boolean z2, C4252gs c4252gs, boolean z3) {
        m13664a(t, enumC4239gf, z, z2, c4252gs, z3, this.f14446a.getPackageName(), C4048b.m13476a(this.f14446a).m13480a());
    }

    /* renamed from: a */
    public final <T extends InterfaceC4277hq<T, ?>> void m13664a(T t, EnumC4239gf enumC4239gf, boolean z, boolean z2, C4252gs c4252gs, boolean z3, String str, String str2) {
        m13665a(t, enumC4239gf, z, z2, c4252gs, z3, str, str2, true);
    }

    /* renamed from: a */
    public final <T extends InterfaceC4277hq<T, ?>> void m13665a(T t, EnumC4239gf enumC4239gf, boolean z, boolean z2, C4252gs c4252gs, boolean z3, String str, String str2, boolean z4) {
        m13666a(t, enumC4239gf, z, z2, c4252gs, z3, str, str2, z4, true);
    }

    /* renamed from: a */
    public final <T extends InterfaceC4277hq<T, ?>> void m13666a(T t, EnumC4239gf enumC4239gf, boolean z, boolean z2, C4252gs c4252gs, boolean z3, String str, String str2, boolean z4, boolean z5) {
        C4262hb m13600b;
        if (z5 && !C4048b.m13476a(this.f14446a).m13496c()) {
            if (z2) {
                m13660a((C4067u) t, enumC4239gf, z);
                return;
            } else {
                AbstractC4022b.m13347a("drop the message before initialization.");
                return;
            }
        }
        if (z4) {
            m13600b = C4064r.m13596a(this.f14446a, t, enumC4239gf, z, str, str2);
        } else {
            m13600b = C4064r.m13600b(this.f14446a, t, enumC4239gf, z, str, str2);
        }
        if (c4252gs != null) {
            m13600b.m15266a(c4252gs);
        }
        byte[] m15567a = C4276hp.m15567a(m13600b);
        if (m15567a == null) {
            AbstractC4022b.m13347a("send message fail, because msgBytes is null.");
            return;
        }
        C4144cs.m14182a(this.f14446a.getPackageName(), this.f14446a, t, enumC4239gf, m15567a.length);
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m13623a.putExtra("mipush_payload", m15567a);
        m13623a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        m13639c(m13623a);
    }

    /* renamed from: a */
    public final void m13656a(C4243gj c4243gj) {
        Intent m13623a = m13623a();
        byte[] m15567a = C4276hp.m15567a(c4243gj);
        if (m15567a == null) {
            AbstractC4022b.m13347a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m13623a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m13623a.putExtra("mipush_payload", m15567a);
        m13636b(m13623a);
    }

    /* renamed from: a */
    private Intent m13623a() {
        if (m13671a() && !"com.xiaomi.xmsf".equals(this.f14446a.getPackageName())) {
            return m13641d();
        }
        return m13644e();
    }

    /* renamed from: a */
    private String m13630a() {
        String str = this.f14454b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f14446a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f14454b = "com.xiaomi.push.service.XMPushService";
                return this.f14454b;
            }
        } catch (Exception unused) {
        }
        this.f14454b = "com.xiaomi.xmsf.push.service.XMPushService";
        return this.f14454b;
    }

    /* renamed from: a */
    public boolean m13671a() {
        return this.f14453a && 1 == C4048b.m13476a(this.f14446a).m13478a();
    }

    /* renamed from: a */
    public <T extends InterfaceC4277hq<T, ?>> void m13660a(T t, EnumC4239gf enumC4239gf, boolean z) {
        a aVar = new a();
        aVar.f14462a = t;
        aVar.f14461a = enumC4239gf;
        aVar.f14463a = z;
        synchronized (f14443a) {
            f14443a.add(aVar);
            if (f14443a.size() > 10) {
                f14443a.remove(0);
            }
        }
    }

    /* renamed from: a */
    public void m13651a(int i2) {
        m13652a(i2, 0);
    }

    /* renamed from: a */
    void m13652a(int i2, int i3) {
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m13623a.putExtra(AbstractC4362an.f16586F, this.f14446a.getPackageName());
        m13623a.putExtra(AbstractC4362an.f16587G, i2);
        m13623a.putExtra(AbstractC4362an.f16588H, i3);
        m13639c(m13623a);
    }

    /* renamed from: a */
    public void m13668a(String str, String str2) {
        Intent m13623a = m13623a();
        m13623a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m13623a.putExtra(AbstractC4362an.f16586F, this.f14446a.getPackageName());
        m13623a.putExtra(AbstractC4362an.f16592L, str);
        m13623a.putExtra(AbstractC4362an.f16593M, str2);
        m13639c(m13623a);
    }

    /* renamed from: a */
    void m13655a(Intent intent) {
        intent.fillIn(m13623a(), 24);
        m13639c(intent);
    }

    /* renamed from: a */
    private Message m13624a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a */
    public boolean m13672a(int i2) {
        if (!C4048b.m13476a(this.f14446a).m13494b()) {
            return false;
        }
        m13638c(i2);
        C4265he c4265he = new C4265he();
        c4265he.m15301a(C4358aj.m15941a());
        c4265he.m15314b(C4048b.m13476a(this.f14446a).m13480a());
        c4265he.m15322d(this.f14446a.getPackageName());
        c4265he.m15318c(EnumC4249gp.ClientABTest.f15769a);
        c4265he.f16034a = new HashMap();
        c4265he.f16034a.put("boot_mode", i2 + "");
        m13627a(this.f14446a).m13661a((C4067u) c4265he, EnumC4239gf.Notification, false, (C4252gs) null);
        return true;
    }
}
