package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.channel.commonutils.logger.C4021a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.AbstractC4207fa;
import com.xiaomi.push.AbstractC4221fo;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4078ag;
import com.xiaomi.push.C4092au;
import com.xiaomi.push.C4093av;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4099ba;
import com.xiaomi.push.C4132cg;
import com.xiaomi.push.C4139cn;
import com.xiaomi.push.C4145ct;
import com.xiaomi.push.C4149cx;
import com.xiaomi.push.C4154db;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.C4172dt;
import com.xiaomi.push.C4178dz;
import com.xiaomi.push.C4194eo;
import com.xiaomi.push.C4195ep;
import com.xiaomi.push.C4197er;
import com.xiaomi.push.C4204ey;
import com.xiaomi.push.C4208fb;
import com.xiaomi.push.C4213fg;
import com.xiaomi.push.C4215fi;
import com.xiaomi.push.C4220fn;
import com.xiaomi.push.C4232fz;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4234ga;
import com.xiaomi.push.C4237gd;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4266hf;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4281hu;
import com.xiaomi.push.C4287i;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4303m;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.C4409x;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4244gk;
import com.xiaomi.push.EnumC4304n;
import com.xiaomi.push.InterfaceC4210fd;
import com.xiaomi.push.InterfaceC4212ff;
import com.xiaomi.push.InterfaceC4217fk;
import com.xiaomi.push.RunnableC4106bh;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.C4368at;
import com.xiaomi.push.service.C4391n;
import com.xiaomi.push.service.C4394q;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class XMPushService extends Service implements InterfaceC4210fd {

    /* renamed from: b */
    private static boolean f16418b = false;

    /* renamed from: a */
    private ContentObserver f16421a;

    /* renamed from: a */
    private C4204ey f16423a;

    /* renamed from: a */
    private AbstractC4207fa f16424a;

    /* renamed from: a */
    private C4208fb f16425a;

    /* renamed from: a */
    private C4328a f16427a;

    /* renamed from: a */
    private C4333f f16428a;

    /* renamed from: a */
    private C4338k f16429a;

    /* renamed from: a */
    private C4345r f16430a;

    /* renamed from: a */
    private C4347t f16431a;

    /* renamed from: a */
    private C4367as f16433a;

    /* renamed from: a */
    private C4385h f16434a;

    /* renamed from: a */
    private Object f16437a;

    /* renamed from: a */
    private boolean f16440a = false;

    /* renamed from: a */
    private int f16419a = 0;

    /* renamed from: b */
    private int f16441b = 0;

    /* renamed from: a */
    private long f16420a = 0;

    /* renamed from: a */
    protected Class f16436a = XMJobService.class;

    /* renamed from: c */
    private int f16442c = -1;

    /* renamed from: a */
    private C4359ak f16432a = null;

    /* renamed from: a */
    private C4391n f16435a = null;

    /* renamed from: a */
    Messenger f16422a = null;

    /* renamed from: a */
    private Collection<InterfaceC4349aa> f16439a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a */
    private ArrayList<InterfaceC4341n> f16438a = new ArrayList<>();

    /* renamed from: a */
    private InterfaceC4212ff f16426a = new InterfaceC4212ff() { // from class: com.xiaomi.push.service.XMPushService.1
        @Override // com.xiaomi.push.InterfaceC4212ff
        /* renamed from: a */
        public void mo14117a(AbstractC4221fo abstractC4221fo) {
            XMPushService xMPushService = XMPushService.this;
            xMPushService.m15797a(xMPushService.new C4340m(abstractC4221fo));
        }

        @Override // com.xiaomi.push.InterfaceC4212ff
        /* renamed from: a */
        public void mo14116a(C4197er c4197er) {
            if (AbstractC4382e.m16077a(c4197er)) {
                C4368at.m16002a().m16006a(c4197er.m14709e(), SystemClock.elapsedRealtime(), XMPushService.this.m15790a());
            }
            XMPushService xMPushService = XMPushService.this;
            xMPushService.m15797a(xMPushService.new C4331d(c4197er));
        }
    };

    /* renamed from: com.xiaomi.push.service.XMPushService$a */
    private class C4328a extends BroadcastReceiver {

        /* renamed from: a */
        private final Object f16464a;

        private C4328a() {
            this.f16464a = new Object();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            AbstractC4022b.m13359c("[Alarm] heartbeat alarm has been triggered.");
            if (!AbstractC4362an.f16615q.equals(intent.getAction())) {
                AbstractC4022b.m13347a("[Alarm] cancel the old ping timer");
                C4178dz.m14578a();
                return;
            }
            if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                AbstractC4022b.m13359c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    m15817a(3000L);
                    AbstractC4022b.m13347a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }

        /* renamed from: a */
        private void m15817a(long j2) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                AbstractC4022b.m13361d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f16464a) {
                try {
                    this.f16464a.wait(j2);
                } catch (InterruptedException e2) {
                    AbstractC4022b.m13347a("[Alarm] interrupt from waiting state. " + e2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m15816a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                AbstractC4022b.m13361d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f16464a) {
                try {
                    this.f16464a.notifyAll();
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("[Alarm] notify lock. " + e2);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$c */
    static class C4330c extends AbstractC4337j {

        /* renamed from: a */
        private final C4361am.b f16467a;

        public C4330c(C4361am.b bVar) {
            super(12);
            this.f16467a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            this.f16467a.m15979a(C4361am.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C4330c) {
                return TextUtils.equals(((C4330c) obj).f16467a.f16563g, this.f16467a.f16563g);
            }
            return false;
        }

        public int hashCode() {
            return this.f16467a.f16563g.hashCode();
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "bind time out. chid=" + this.f16467a.f16563g;
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$d */
    class C4331d extends AbstractC4337j {

        /* renamed from: a */
        private C4197er f16468a;

        public C4331d(C4197er c4197er) {
            super(8);
            this.f16468a = null;
            this.f16468a = c4197er;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            XMPushService.this.f16432a.m15947a(this.f16468a);
            if (AbstractC4382e.m16077a(this.f16468a)) {
                XMPushService.this.m15798a(new C4368at.a(), 15000L);
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$e */
    public class C4332e extends AbstractC4337j {
        C4332e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            if (XMPushService.this.m15806a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.m15760a(xMPushService.getApplicationContext())) {
                    XMPushService.this.m15780f();
                    return;
                }
            }
            AbstractC4022b.m13347a("should not connect. quit the job.");
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$f */
    class C4333f extends BroadcastReceiver {
        C4333f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C4092au.m13797a();
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$g */
    public class C4334g extends AbstractC4337j {

        /* renamed from: a */
        public Exception f16473a;

        /* renamed from: b */
        public int f16474b;

        C4334g(int i2, Exception exc) {
            super(2);
            this.f16474b = i2;
            this.f16473a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            XMPushService.this.m15795a(this.f16474b, this.f16473a);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$h */
    class C4335h extends AbstractC4337j {
        C4335h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            XMPushService.this.m15771c();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$i */
    class C4336i extends AbstractC4337j {

        /* renamed from: a */
        private Intent f16476a;

        public C4336i(Intent intent) {
            super(15);
            this.f16476a = null;
            this.f16476a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            XMPushService.this.m15777d(this.f16476a);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "Handle intent action = " + this.f16476a.getAction();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$j */
    public static abstract class AbstractC4337j extends C4391n.b {
        public AbstractC4337j(int i2) {
            super(i2);
        }

        /* renamed from: a */
        public abstract String mo14643a();

        /* renamed from: a */
        public abstract void mo14644a();

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f16731a;
            if (i2 != 4 && i2 != 8) {
                AbstractC4022b.m13348a(C4021a.f14297a, mo14643a());
            }
            mo14644a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$k */
    class C4338k extends BroadcastReceiver {
        C4338k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC4022b.m13347a("[HB] hold short heartbeat, " + C4300j.m15676a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$l */
    class C4339l extends AbstractC4337j {
        public C4339l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            XMPushService.this.f16435a.m16164a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$m */
    class C4340m extends AbstractC4337j {

        /* renamed from: a */
        private AbstractC4221fo f16480a;

        public C4340m(AbstractC4221fo abstractC4221fo) {
            super(8);
            this.f16480a = null;
            this.f16480a = abstractC4221fo;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            XMPushService.this.f16432a.m15948a(this.f16480a);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$n */
    public interface InterfaceC4341n {
        /* renamed from: a */
        void mo14950a();
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$o */
    class C4342o extends AbstractC4337j {

        /* renamed from: a */
        boolean f16483a;

        public C4342o(boolean z) {
            super(4);
            this.f16483a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            if (XMPushService.this.m15812c()) {
                try {
                    if (!this.f16483a) {
                        C4195ep.m14667a();
                    }
                    XMPushService.this.f16424a.mo14777b(this.f16483a);
                } catch (C4215fi e2) {
                    AbstractC4022b.m13351a(e2);
                    XMPushService.this.m15795a(10, e2);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$q */
    class C4344q extends AbstractC4337j {
        C4344q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            XMPushService.this.m15795a(11, (Exception) null);
            if (XMPushService.this.m15806a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.m15760a(xMPushService.getApplicationContext())) {
                    XMPushService.this.m15780f();
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$r */
    class C4345r extends BroadcastReceiver {
        C4345r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$t */
    class C4347t extends BroadcastReceiver {
        C4347t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f16440a) {
                XMPushService.this.f16440a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: d */
    private void m15776d() {
        C4093av m13784a = C4092au.m13784a();
        C4390m.m16121a(getApplicationContext()).m16143a(m13784a);
        if (m13784a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + m13784a.m13814a() + "[" + m13784a.m13817b() + "], state: " + m13784a.m13813a() + "/" + m13784a.m13812a());
            AbstractC4022b.m13348a("XMPushService", sb.toString());
            NetworkInfo.State m13813a = m13784a.m13813a();
            if (m13813a == NetworkInfo.State.SUSPENDED || m13813a == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            AbstractC4022b.m13348a("XMPushService", "network changed, no active network");
        }
        if (C4194eo.m14656a() != null) {
            C4194eo.m14656a().m14653a();
        }
        C4232fz.m14915a((Context) this);
        this.f16423a.m14781d();
        if (C4092au.m13799a((Context) this)) {
            if (m15812c() && m15781f()) {
                m15769b(false);
            }
            if (!m15812c() && !m15813d()) {
                this.f16435a.m16165a(1);
                m15797a(new C4332e());
            }
            C4154db.m14261a(this).m14269a();
        } else {
            m15797a(new C4334g(2, null));
        }
        m15778e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m15778e() {
        if (!m15806a()) {
            C4178dz.m14578a();
        } else {
            if (C4178dz.m14582a()) {
                return;
            }
            C4178dz.m14581a(true);
        }
    }

    /* renamed from: f */
    private boolean m15781f() {
        if (SystemClock.elapsedRealtime() - this.f16420a < 30000) {
            return false;
        }
        return C4092au.m13802c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m15783g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    /* renamed from: h */
    private void m15784h() {
    }

    /* renamed from: h */
    private boolean m15785h() {
        boolean z;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            AbstractC4022b.m13347a("current sdk expect region is cn");
            z = EnumC4304n.China.name().equals(C4375b.m16045a(getApplicationContext()).m16048a());
        } else {
            z = !C4395r.m16214a(this).m16218b(packageName);
        }
        if (!z) {
            AbstractC4022b.m13350a("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(z), ", package=", packageName, ", region=", C4375b.m16045a(getApplicationContext()).m16048a());
        }
        return z;
    }

    /* renamed from: i */
    private boolean m15787i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && m15788j() && !C4287i.m15644b((Context) this) && !C4287i.m15638a(getApplicationContext());
    }

    /* renamed from: j */
    private boolean m15788j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f16419a;
        int i3 = this.f16441b;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    private boolean m15789k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return C4356ah.m15923a(this).m15935a(EnumC4244gk.ForegroundServiceSwitch.m15014a(), false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f16422a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        AbstractC4022b.m13344a(getApplicationContext());
        C4309r.m15718a((Context) this);
        C4393p m16204a = C4394q.m16204a((Context) this);
        if (m16204a != null) {
            C4409x.m16365a(m16204a.f16753a);
        }
        if (C4300j.m15681a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f16427a = new C4328a();
            C4303m.m15702a(this, this.f16427a, new IntentFilter(AbstractC4362an.f16615q), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            f16418b = true;
            handler.post(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th) {
                        AbstractC4022b.m13347a("[Alarm] disable ping receiver may be failure. " + th);
                    }
                }
            });
        }
        this.f16422a = new Messenger(new Handler() { // from class: com.xiaomi.push.service.XMPushService.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    try {
                        int i2 = message.what;
                        if (i2 != 17) {
                            if (i2 == 18) {
                                Message obtain = Message.obtain((Handler) null, 0);
                                obtain.what = 18;
                                Bundle bundle = new Bundle();
                                bundle.putString("xmsf_region", C4375b.m16045a(XMPushService.this.getApplicationContext()).m16048a());
                                obtain.setData(bundle);
                                message.replyTo.send(obtain);
                            }
                        } else if (message.obj != null) {
                            XMPushService.this.onStart((Intent) message.obj, 1);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        C4363ao.m15983a(this);
        this.f16425a = new C4208fb(null, 5222, "xiaomi.com", null) { // from class: com.xiaomi.push.service.XMPushService.9
            @Override // com.xiaomi.push.C4208fb
            /* renamed from: a */
            public byte[] mo14790a() {
                try {
                    C4168dp.b bVar = new C4168dp.b();
                    bVar.m14374a(C4372ax.m16017a().m16025a());
                    return bVar.m14590a();
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("getOBBString err: " + e2.toString());
                    return null;
                }
            }
        };
        this.f16425a.m14788a(true);
        this.f16423a = new C4204ey(this, this.f16425a);
        this.f16434a = m15792a();
        C4178dz.m14579a(this);
        this.f16423a.m14765a(this);
        this.f16432a = new C4359ak(this);
        this.f16433a = new C4367as(this);
        new C4386i().m16109a();
        C4194eo.m14657a().m14663a(this);
        this.f16435a = new C4391n("Connection Controller Thread");
        C4361am m15951a = C4361am.m15951a();
        m15951a.m15965b();
        m15951a.m15961a(new C4361am.a() { // from class: com.xiaomi.push.service.XMPushService.10
            @Override // com.xiaomi.push.service.C4361am.a
            /* renamed from: a */
            public void mo15814a() {
                XMPushService.this.m15778e();
                if (C4361am.m15951a().m15953a() <= 0) {
                    XMPushService xMPushService = XMPushService.this;
                    xMPushService.m15797a(xMPushService.new C4334g(12, null));
                }
            }
        });
        if (m15789k()) {
            m15784h();
        }
        C4237gd.m14961a(this).m14964a(new C4392o(this), "UPLOADER_PUSH_CHANNEL");
        m15799a(new C4234ga(this));
        m15799a(new C4379bd(this));
        if (C4300j.m15681a((Context) this)) {
            m15799a(new C4360al());
            if (C4287i.m15637a()) {
                m15799a(new InterfaceC4341n() { // from class: com.xiaomi.push.service.XMPushService.11
                    @Override // com.xiaomi.push.service.XMPushService.InterfaceC4341n
                    /* renamed from: a */
                    public void mo14950a() {
                        RunnableC4106bh.m13905a(XMPushService.this.getApplicationContext());
                    }
                });
            }
        }
        m15797a(new C4335h());
        this.f16439a.add(C4373ay.m16032a(this));
        if (m15785h()) {
            this.f16428a = new C4333f();
            C4303m.m15701a(this, this.f16428a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
            this.f16437a = C4092au.m13788a((Context) this);
        }
        if (C4300j.m15681a(getApplicationContext())) {
            this.f16431a = new C4347t();
            C4303m.m15702a(this, this.f16431a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            this.f16429a = new C4338k();
            C4303m.m15702a(this, this.f16429a, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f16421a = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.push.service.XMPushService.12
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        super.onChange(z);
                        boolean m15783g = XMPushService.this.m15783g();
                        AbstractC4022b.m13347a("SuperPowerMode:" + m15783g);
                        XMPushService.this.m15778e();
                        if (!m15783g) {
                            XMPushService.this.m15803a(true);
                        } else {
                            XMPushService xMPushService = XMPushService.this;
                            xMPushService.m15797a(xMPushService.new C4334g(24, null));
                        }
                    }
                };
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f16421a);
                } catch (Throwable th) {
                    AbstractC4022b.m13361d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] m15765a = m15765a();
            if (m15765a != null) {
                this.f16430a = new C4345r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                C4303m.m15701a(this, this.f16430a, intentFilter, (String) null, (Handler) null);
                this.f16419a = m15765a[0];
                this.f16441b = m15765a[1];
                AbstractC4022b.m13347a("falldown initialized: " + this.f16419a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f16441b);
            }
        }
        C4139cn.m14122a(this, this.f16423a);
        C4145ct.m14185a(this, this.f16423a);
        String str = "";
        if (m16204a != null) {
            try {
                if (!TextUtils.isEmpty(m16204a.f16754a) && (split = m16204a.f16754a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        C4149cx.m14243a(this);
        AbstractC4022b.m13363e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + C4233g.m14925a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        C4333f c4333f = this.f16428a;
        if (c4333f != null) {
            m15754a(c4333f);
            this.f16428a = null;
        }
        Object obj = this.f16437a;
        if (obj != null) {
            C4092au.m13798a(this, obj);
            this.f16437a = null;
        }
        C4347t c4347t = this.f16431a;
        if (c4347t != null) {
            m15754a(c4347t);
            this.f16431a = null;
        }
        C4338k c4338k = this.f16429a;
        if (c4338k != null) {
            m15754a(c4338k);
            this.f16429a = null;
        }
        C4345r c4345r = this.f16430a;
        if (c4345r != null) {
            m15754a(c4345r);
            this.f16430a = null;
        }
        C4328a c4328a = this.f16427a;
        if (c4328a != null) {
            m15754a(c4328a);
            this.f16427a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f16421a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f16421a);
            } catch (Throwable th) {
                AbstractC4022b.m13361d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f16439a.clear();
        this.f16435a.m16171b();
        m15797a(new AbstractC4337j(2) { // from class: com.xiaomi.push.service.XMPushService.4
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "disconnect for service destroy.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                if (XMPushService.this.f16424a != null) {
                    XMPushService.this.f16424a.mo14773b(15, (Exception) null);
                    XMPushService.this.f16424a = null;
                }
            }
        });
        m15797a(new C4339l());
        C4361am.m15951a().m15965b();
        C4361am.m15951a().m15960a(this, 15);
        C4361am.m15951a().m15958a();
        this.f16423a.m14774b(this);
        C4372ax.m16017a().m16027a();
        C4178dz.m14578a();
        m15786i();
        C4139cn.m14127b(this, this.f16423a);
        C4145ct.m14189b(this, this.f16423a);
        super.onDestroy();
        AbstractC4022b.m13347a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            AbstractC4022b.m13361d("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(AbstractC4362an.f16620v);
                String stringExtra2 = intent.getStringExtra(AbstractC4362an.f16586F);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && !"miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    AbstractC4022b.m13348a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), stringExtra, stringExtra2, stringExtra3));
                }
                AbstractC4022b.m13348a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", intent.getAction(), stringExtra, stringExtra2, stringExtra3, C4300j.m15676a(intent)));
            } catch (Throwable th) {
                AbstractC4022b.m13361d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f16435a.m16169a()) {
                    AbstractC4022b.m13361d("ERROR, the job controller is blocked.");
                    C4361am.m15951a().m15960a(this, 14);
                    stopSelf();
                } else {
                    m15797a(new C4336i(intent));
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                m15797a(new C4336i(intent));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            AbstractC4022b.m13359c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return C4300j.m15681a((Context) this) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15771c() {
        String str;
        C4132cg.m14066a().m14093d();
        C4390m.m16121a(getApplicationContext()).m16141a();
        C4375b m16045a = C4375b.m16045a(getApplicationContext());
        String m16048a = m16045a.m16048a();
        AbstractC4022b.m13348a("XMPushService", "region of cache is " + m16048a);
        if (TextUtils.isEmpty(m16048a)) {
            String m15766b = m15766b();
            str = m15766b;
            m16048a = C4300j.m15674a(m15766b).name();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(m16048a) && EnumC4304n.China.name().equals(m16048a)) {
            m16045a.m16049a(m16048a, true);
            m16045a.m16051b("CN", true);
            str = "CN";
        } else if (TextUtils.isEmpty(m16048a)) {
            m16048a = EnumC4304n.China.name();
        } else {
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                m16048a = "";
                str = m16048a;
            } else {
                m16048a = EnumC4304n.China.name();
                str = "CN";
            }
            m16045a.m16049a(m16048a, true);
            m16045a.m16051b(str, true);
        }
        AbstractC4022b.m13350a("XMPushService", "after check, appRegion is ", m16048a, ", countryCode=", str);
        if (EnumC4304n.China.name().equals(m16048a)) {
            C4208fb.m14785a("cn.app.chat.xiaomi.net");
        }
        m15758a(m16048a);
        if (m15785h()) {
            AbstractC4022b.m13348a("XMPushService", "-->postOnCreate(): try trigger connect now");
            final AbstractC4337j abstractC4337j = new AbstractC4337j(11) { // from class: com.xiaomi.push.service.XMPushService.13
                @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
                /* renamed from: a */
                public String mo14643a() {
                    return "prepare the mi push account.";
                }

                @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
                /* renamed from: a */
                public void mo14644a() {
                    C4401w.m16280a(XMPushService.this);
                    if (C4092au.m13799a((Context) XMPushService.this)) {
                        XMPushService.this.m15803a(true);
                    }
                }
            };
            m15797a(abstractC4337j);
            C4394q.m16212a(new C4394q.a() { // from class: com.xiaomi.push.service.XMPushService.14
                @Override // com.xiaomi.push.service.C4394q.a
                /* renamed from: a */
                public void mo15815a() {
                    XMPushService.this.m15797a(abstractC4337j);
                }
            });
        }
        try {
            if (C4309r.m15719a()) {
                this.f16434a.m16102a(this);
            }
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            C4233g.m14933a((Context) this, getApplicationInfo(), true);
        }
    }

    /* renamed from: b */
    private String m15766b() {
        String str;
        C4078ag.m13726a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            C4364ap m15985a = C4364ap.m15985a(this);
            String str2 = null;
            while (true) {
                if (!TextUtils.isEmpty(str2) && m15985a.m15986a() != 0) {
                    str = m15753a();
                    break;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = m15753a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
        } else {
            str = "CN";
        }
        AbstractC4022b.m13347a("wait coutrycode :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i2);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m15780f() {
        AbstractC4207fa abstractC4207fa = this.f16424a;
        if (abstractC4207fa != null && abstractC4207fa.m14778b()) {
            AbstractC4022b.m13361d("try to connect while connecting.");
            return;
        }
        AbstractC4207fa abstractC4207fa2 = this.f16424a;
        if (abstractC4207fa2 != null && abstractC4207fa2.m14780c()) {
            AbstractC4022b.m13361d("try to connect while is connected.");
            return;
        }
        this.f16425a.m14792b(C4092au.m13789a((Context) this));
        m15782g();
        if (this.f16424a == null) {
            C4361am.m15951a().m15959a(this);
            m15775c(false);
        }
    }

    /* renamed from: g */
    private void m15782g() {
        try {
            this.f16423a.m14767a(this.f16426a, new InterfaceC4217fk() { // from class: com.xiaomi.push.service.XMPushService.5
                @Override // com.xiaomi.push.InterfaceC4217fk
                /* renamed from: a */
                public boolean mo14118a(AbstractC4221fo abstractC4221fo) {
                    return true;
                }
            });
            this.f16423a.m14811e();
            this.f16424a = this.f16423a;
        } catch (C4215fi e2) {
            AbstractC4022b.m13349a("fail to create Slim connection", e2);
            this.f16423a.mo14773b(3, e2);
        }
    }

    /* renamed from: i */
    private void m15786i() {
        synchronized (this.f16438a) {
            this.f16438a.clear();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$p */
    class C4343p extends AbstractC4337j {

        /* renamed from: a */
        C4361am.b f16485a;

        public C4343p(C4361am.b bVar) {
            super(4);
            this.f16485a = null;
            this.f16485a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            try {
                this.f16485a.m15979a(C4361am.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f16424a.mo14743a(this.f16485a.f16563g, this.f16485a.f16557b);
                XMPushService.this.m15798a(XMPushService.this.new C4329b(this.f16485a), 300L);
            } catch (C4215fi e2) {
                AbstractC4022b.m13351a(e2);
                XMPushService.this.m15795a(10, e2);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "rebind the client. " + this.f16485a.f16563g;
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$s */
    class C4346s extends AbstractC4337j {

        /* renamed from: a */
        C4361am.b f16489a;

        /* renamed from: a */
        String f16490a;

        /* renamed from: b */
        int f16491b;

        /* renamed from: b */
        String f16492b;

        public C4346s(C4361am.b bVar, int i2, String str, String str2) {
            super(9);
            this.f16489a = null;
            this.f16489a = bVar;
            this.f16491b = i2;
            this.f16490a = str;
            this.f16492b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            if (this.f16489a.f16551a != C4361am.c.unbind && XMPushService.this.f16424a != null) {
                try {
                    XMPushService.this.f16424a.mo14743a(this.f16489a.f16563g, this.f16489a.f16557b);
                } catch (C4215fi e2) {
                    AbstractC4022b.m13351a(e2);
                    XMPushService.this.m15795a(10, e2);
                }
            }
            this.f16489a.m15979a(C4361am.c.unbind, this.f16491b, 0, this.f16492b, this.f16490a);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "unbind the channel. " + this.f16489a.f16563g;
        }
    }

    /* renamed from: e */
    public static boolean m15779e() {
        return f16418b;
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$b */
    class C4329b extends AbstractC4337j {

        /* renamed from: a */
        C4361am.b f16466a;

        public C4329b(C4361am.b bVar) {
            super(9);
            this.f16466a = null;
            this.f16466a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            try {
                if (XMPushService.this.m15812c()) {
                    C4361am.b m15954a = C4361am.m15951a().m15954a(this.f16466a.f16563g, this.f16466a.f16557b);
                    if (m15954a == null) {
                        AbstractC4022b.m13347a("ignore bind because the channel " + this.f16466a.f16563g + " is removed ");
                    } else if (m15954a.f16551a == C4361am.c.unbind) {
                        m15954a.m15979a(C4361am.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f16424a.mo14742a(m15954a);
                        C4195ep.m14672a(XMPushService.this, m15954a);
                    } else {
                        AbstractC4022b.m13347a("trying duplicate bind, ingore! " + m15954a.f16551a);
                    }
                } else {
                    AbstractC4022b.m13361d("trying bind while the connection is not created, quit!");
                }
            } catch (Exception e2) {
                AbstractC4022b.m13361d("Meet error when trying to bind. " + e2);
                XMPushService.this.m15795a(10, e2);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "bind the client. " + this.f16466a.f16563g;
        }
    }

    /* renamed from: a */
    public int m15790a() {
        if (this.f16442c < 0) {
            this.f16442c = C4233g.m14925a((Context) this, "com.xiaomi.xmsf");
        }
        return this.f16442c;
    }

    /* renamed from: a */
    private int[] m15765a() {
        String[] split;
        String m15930a = C4356ah.m15923a(getApplicationContext()).m15930a(EnumC4244gk.FallDownTimeRange.m15014a(), "");
        if (!TextUtils.isEmpty(m15930a) && (split = m15930a.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e2) {
                AbstractC4022b.m13361d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m15769b(boolean z) {
        this.f16420a = SystemClock.elapsedRealtime();
        if (!m15812c()) {
            m15803a(true);
        } else if (C4092au.m13799a((Context) this)) {
            m15773c(new C4342o(z));
        } else {
            m15773c(new C4334g(17, null));
            m15803a(true);
        }
    }

    /* renamed from: a */
    private String m15753a() {
        String m15678a = C4300j.m15678a("ro.miui.region");
        return TextUtils.isEmpty(m15678a) ? C4300j.m15678a("ro.product.locale.region") : m15678a;
    }

    /* renamed from: b */
    private void m15767b(Intent intent) {
        long j2;
        String stringExtra = intent.getStringExtra(AbstractC4362an.f16586F);
        String stringExtra2 = intent.getStringExtra(AbstractC4362an.f16590J);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        C4361am m15951a = C4361am.m15951a();
        C4197er c4197er = null;
        if (bundleExtra != null) {
            C4220fn c4220fn = (C4220fn) m15749a(new C4220fn(bundleExtra), stringExtra, stringExtra2);
            if (c4220fn == null) {
                return;
            } else {
                c4197er = C4197er.m14680a(c4220fn, m15951a.m15954a(c4220fn.m14865k(), c4220fn.m14869m()).f16564h);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(AbstractC4362an.f16617s));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(AbstractC4362an.f16618t);
                String stringExtra4 = intent.getStringExtra(AbstractC4362an.f16619u);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                C4361am.b m15954a = m15951a.m15954a(stringExtra5, String.valueOf(j2));
                if (m15954a != null) {
                    C4197er c4197er2 = new C4197er();
                    try {
                        c4197er2.m14688a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    c4197er2.m14692a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    c4197er2.m14690a(j2, stringExtra3, stringExtra4);
                    c4197er2.m14691a(intent.getStringExtra("ext_pkt_id"));
                    c4197er2.m14694a(byteArrayExtra, m15954a.f16564h);
                    AbstractC4022b.m13347a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    c4197er = c4197er2;
                }
            }
        }
        if (c4197er != null) {
            m15773c(new C4371aw(this, c4197er));
        }
    }

    /* renamed from: a */
    private static void m15758a(String str) {
        if (EnumC4304n.China.name().equals(str)) {
            C4132cg.m14072a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            C4132cg.m14072a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            C4132cg.m14072a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            C4132cg.m14072a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            C4132cg.m14072a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            C4132cg.m14072a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            C4132cg.m14072a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:172:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m15777d(android.content.Intent r15) {
        /*
            Method dump skipped, instructions count: 2266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.m15777d(android.content.Intent):void");
    }

    /* renamed from: c */
    private void m15772c(Intent intent) {
        String stringExtra = intent.getStringExtra(AbstractC4362an.f16586F);
        String stringExtra2 = intent.getStringExtra(AbstractC4362an.f16590J);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        C4220fn[] c4220fnArr = new C4220fn[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            c4220fnArr[i2] = new C4220fn((Bundle) parcelableArrayExtra[i2]);
            c4220fnArr[i2] = (C4220fn) m15749a(c4220fnArr[i2], stringExtra, stringExtra2);
            if (c4220fnArr[i2] == null) {
                return;
            }
        }
        C4361am m15951a = C4361am.m15951a();
        C4197er[] c4197erArr = new C4197er[c4220fnArr.length];
        for (int i3 = 0; i3 < c4220fnArr.length; i3++) {
            C4220fn c4220fn = c4220fnArr[i3];
            c4197erArr[i3] = C4197er.m14680a(c4220fn, m15951a.m15954a(c4220fn.m14865k(), c4220fn.m14869m()).f16564h);
        }
        m15773c(new C4380c(this, c4197erArr));
    }

    /* renamed from: a */
    private void m15755a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("digest");
        C4390m.m16121a(getApplicationContext()).m16144a(string);
        C4139cn.m14123a(this, string);
    }

    /* renamed from: a */
    void m15793a() {
        if (SystemClock.elapsedRealtime() - this.f16420a >= C4213fg.m14796a() && C4092au.m13802c(this)) {
            m15769b(true);
        }
    }

    /* renamed from: a */
    void m15802a(final String str, final byte[] bArr, boolean z) {
        Collection<C4361am.b> m15956a = C4361am.m15951a().m15956a("5");
        if (m15956a.isEmpty()) {
            if (z) {
                C4398t.m16232b(str, bArr);
            }
        } else if (m15956a.iterator().next().f16551a == C4361am.c.binded) {
            m15797a(new AbstractC4337j(4) { // from class: com.xiaomi.push.service.XMPushService.3
                @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
                /* renamed from: a */
                public String mo14643a() {
                    return "send mi push message";
                }

                @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
                /* renamed from: a */
                public void mo14644a() {
                    try {
                        C4401w.m16284a(XMPushService.this, str, bArr);
                    } catch (C4215fi e2) {
                        AbstractC4022b.m13351a(e2);
                        XMPushService.this.m15795a(10, e2);
                    }
                }
            });
        } else if (z) {
            C4398t.m16232b(str, bArr);
        }
    }

    /* renamed from: c */
    private void m15773c(AbstractC4337j abstractC4337j) {
        this.f16435a.m16167a(abstractC4337j);
    }

    /* renamed from: a */
    public void m15804a(byte[] bArr, String str) {
        if (bArr == null) {
            C4398t.m16228a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            AbstractC4022b.m13347a("register request without payload");
            return;
        }
        C4262hb c4262hb = new C4262hb();
        try {
            C4276hp.m15566a(c4262hb, bArr);
            if (c4262hb.f15998a == EnumC4239gf.Registration) {
                C4266hf c4266hf = new C4266hf();
                try {
                    C4276hp.m15566a(c4266hf, c4262hb.m15276a());
                    m15797a(new C4397s(this, c4262hb.m15279b(), c4266hf.m15350b(), c4266hf.m15355c(), bArr));
                    C4172dt.m14529a(getApplicationContext()).m14535a(c4262hb.m15279b(), "E100003", c4266hf.m15343a(), AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, null);
                } catch (C4281hu e2) {
                    AbstractC4022b.m13361d("app register error. " + e2);
                    C4398t.m16228a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                C4398t.m16228a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                AbstractC4022b.m13347a("register request with invalid payload");
            }
        } catch (C4281hu e3) {
            AbstractC4022b.m13361d("app register fail. " + e3);
            C4398t.m16228a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    /* renamed from: c */
    private void m15775c(boolean z) {
        try {
            if (C4309r.m15719a()) {
                if (z) {
                    if (C4300j.m15681a((Context) this)) {
                        Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                        intent.addFlags(1073741824);
                        sendBroadcast(intent);
                    }
                    for (InterfaceC4349aa interfaceC4349aa : (InterfaceC4349aa[]) this.f16439a.toArray(new InterfaceC4349aa[0])) {
                        interfaceC4349aa.mo15822a();
                    }
                    return;
                }
                if (C4300j.m15681a((Context) this)) {
                    Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                    intent2.addFlags(1073741824);
                    sendBroadcast(intent2);
                }
            }
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
        }
    }

    /* renamed from: b */
    public boolean m15811b() {
        try {
            Class<?> m15716a = C4309r.m15716a(this, "miui.os.Build");
            Field field = m15716a.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = m15716a.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = m15716a.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public C4385h m15808b() {
        return this.f16434a;
    }

    /* renamed from: b */
    public void m15810b(AbstractC4337j abstractC4337j) {
        this.f16435a.m16166a(abstractC4337j.f16731a, abstractC4337j);
    }

    @Override // com.xiaomi.push.InterfaceC4210fd
    /* renamed from: b */
    public void mo14176b(AbstractC4207fa abstractC4207fa) {
        C4194eo.m14656a().mo14176b(abstractC4207fa);
        m15775c(true);
        this.f16433a.m16000a();
        if (!C4178dz.m14582a() && !m15787i()) {
            AbstractC4022b.m13347a("reconnection successful, reactivate alarm.");
            C4178dz.m14581a(true);
        }
        Iterator<C4361am.b> it = C4361am.m15951a().m15955a().iterator();
        while (it.hasNext()) {
            m15797a(new C4329b(it.next()));
        }
        if (this.f16440a || !C4300j.m15681a(getApplicationContext())) {
            return;
        }
        C4076ae.m13698a(getApplicationContext()).m13703a(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.6
            @Override // java.lang.Runnable
            public void run() {
                XMPushService.this.f16440a = true;
                try {
                    AbstractC4022b.m13347a("try to trigger the wifi digest broadcast.");
                    Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                    if (systemService != null) {
                        C4094aw.m13831b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* renamed from: c */
    public boolean m15812c() {
        AbstractC4207fa abstractC4207fa = this.f16424a;
        return abstractC4207fa != null && abstractC4207fa.m14780c();
    }

    /* renamed from: b */
    void m15809b() {
        C4390m.m16121a(getApplicationContext()).m16148d();
        Iterator it = new ArrayList(this.f16438a).iterator();
        while (it.hasNext()) {
            ((InterfaceC4341n) it.next()).mo14950a();
        }
    }

    /* renamed from: a */
    private AbstractC4221fo m15749a(AbstractC4221fo abstractC4221fo, String str, String str2) {
        C4361am m15951a = C4361am.m15951a();
        List<String> m15957a = m15951a.m15957a(str);
        if (m15957a.isEmpty()) {
            AbstractC4022b.m13347a("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        abstractC4221fo.m14874o(str);
        String m14865k = abstractC4221fo.m14865k();
        if (TextUtils.isEmpty(m14865k)) {
            m14865k = m15957a.get(0);
            abstractC4221fo.m14868l(m14865k);
        }
        C4361am.b m15954a = m15951a.m15954a(m14865k, abstractC4221fo.m14869m());
        if (!m15812c()) {
            AbstractC4022b.m13347a("drop a packet as the channel is not connected, chid=" + m14865k);
            return null;
        }
        if (m15954a != null && m15954a.f16551a == C4361am.c.binded) {
            if (TextUtils.equals(str2, m15954a.f16565i)) {
                return abstractC4221fo;
            }
            AbstractC4022b.m13347a("invalid session. " + str2);
            return null;
        }
        AbstractC4022b.m13347a("drop a packet as the channel is not opened, chid=" + m14865k);
        return null;
    }

    /* renamed from: a */
    private boolean m15764a(String str, Intent intent) {
        C4361am.b m15954a = C4361am.m15951a().m15954a(str, intent.getStringExtra(AbstractC4362an.f16617s));
        boolean z = false;
        if (m15954a == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(AbstractC4362an.f16590J);
        String stringExtra2 = intent.getStringExtra(AbstractC4362an.f16582B);
        if (!TextUtils.isEmpty(m15954a.f16565i) && !TextUtils.equals(stringExtra, m15954a.f16565i)) {
            AbstractC4022b.m13347a("session changed. old session=" + m15954a.f16565i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(m15954a.f16564h)) {
            return z;
        }
        AbstractC4022b.m13347a("security changed. chid = " + str + " sechash = " + C4099ba.m13875a(stringExtra2));
        return true;
    }

    /* renamed from: a */
    private C4361am.b m15751a(String str, Intent intent) {
        C4361am.b m15954a = C4361am.m15951a().m15954a(str, intent.getStringExtra(AbstractC4362an.f16617s));
        if (m15954a == null) {
            m15954a = new C4361am.b(this);
        }
        m15954a.f16563g = intent.getStringExtra(AbstractC4362an.f16620v);
        m15954a.f16557b = intent.getStringExtra(AbstractC4362an.f16617s);
        m15954a.f16559c = intent.getStringExtra(AbstractC4362an.f16624z);
        m15954a.f16553a = intent.getStringExtra(AbstractC4362an.f16586F);
        m15954a.f16561e = intent.getStringExtra(AbstractC4362an.f16584D);
        m15954a.f16562f = intent.getStringExtra(AbstractC4362an.f16585E);
        m15954a.f16555a = intent.getBooleanExtra(AbstractC4362an.f16583C, false);
        m15954a.f16564h = intent.getStringExtra(AbstractC4362an.f16582B);
        m15954a.f16565i = intent.getStringExtra(AbstractC4362an.f16590J);
        m15954a.f16560d = intent.getStringExtra(AbstractC4362an.f16581A);
        m15954a.f16552a = this.f16434a;
        m15954a.m15977a((Messenger) intent.getParcelableExtra(AbstractC4362an.f16594N));
        m15954a.f16545a = getApplicationContext();
        C4361am.m15951a().m15962a(m15954a);
        return m15954a;
    }

    /* renamed from: a */
    public void m15801a(String str, String str2, int i2, String str3, String str4) {
        C4361am.b m15954a = C4361am.m15951a().m15954a(str, str2);
        if (m15954a != null) {
            m15797a(new C4346s(m15954a, i2, str4, str3));
        }
        C4361am.m15951a().m15964a(str, str2);
    }

    /* renamed from: a */
    private void m15759a(String str, int i2) {
        Collection<C4361am.b> m15956a = C4361am.m15951a().m15956a(str);
        if (m15956a != null) {
            for (C4361am.b bVar : m15956a) {
                if (bVar != null) {
                    m15797a(new C4346s(bVar, i2, null, null));
                }
            }
        }
        C4361am.m15951a().m15963a(str);
    }

    /* renamed from: a */
    public void m15797a(AbstractC4337j abstractC4337j) {
        m15798a(abstractC4337j, 0L);
    }

    /* renamed from: a */
    public void m15798a(AbstractC4337j abstractC4337j, long j2) {
        try {
            this.f16435a.m16168a(abstractC4337j, j2);
        } catch (IllegalStateException e2) {
            AbstractC4022b.m13347a("can't execute job err = " + e2.getMessage());
        }
    }

    /* renamed from: a */
    private void m15754a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                AbstractC4022b.m13351a(e2);
            }
        }
    }

    /* renamed from: a */
    public void m15796a(C4197er c4197er) {
        AbstractC4207fa abstractC4207fa = this.f16424a;
        if (abstractC4207fa != null) {
            abstractC4207fa.mo14748b(c4197er);
            return;
        }
        throw new C4215fi("try send msg while connection is null.");
    }

    /* renamed from: a */
    public void m15805a(C4197er[] c4197erArr) {
        AbstractC4207fa abstractC4207fa = this.f16424a;
        if (abstractC4207fa != null) {
            abstractC4207fa.mo14745a(c4197erArr);
            return;
        }
        throw new C4215fi("try send msg while connection is null.");
    }

    /* renamed from: a */
    public void m15803a(boolean z) {
        this.f16433a.m16001a(z);
    }

    /* renamed from: a */
    public void m15800a(C4361am.b bVar) {
        if (bVar != null) {
            long m15974a = bVar.m15974a();
            AbstractC4022b.m13347a("schedule rebind job in " + (m15974a / 1000));
            m15798a(new C4329b(bVar), m15974a);
        }
    }

    /* renamed from: a */
    public void m15795a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        AbstractC4207fa abstractC4207fa = this.f16424a;
        sb.append(abstractC4207fa == null ? null : Integer.valueOf(abstractC4207fa.hashCode()));
        AbstractC4022b.m13347a(sb.toString());
        AbstractC4207fa abstractC4207fa2 = this.f16424a;
        if (abstractC4207fa2 != null) {
            abstractC4207fa2.mo14773b(i2, exc);
            this.f16424a = null;
        }
        m15794a(7);
        m15794a(4);
        C4361am.m15951a().m15960a(this, i2);
    }

    /* renamed from: a */
    public boolean m15806a() {
        boolean m13799a = C4092au.m13799a((Context) this);
        boolean z = C4361am.m15951a().m15953a() > 0;
        boolean z2 = !m15811b();
        boolean m15785h = m15785h();
        boolean z3 = !m15783g();
        boolean z4 = m13799a && z && z2 && m15785h && z3;
        if (!z4) {
            AbstractC4022b.m13363e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(m13799a), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m15785h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a */
    public C4385h m15792a() {
        return new C4385h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15760a(Context context) {
        try {
            C4078ag.m13726a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (C4092au.m13801b(context)) {
                    AbstractC4022b.m13347a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a */
    public AbstractC4207fa m15791a() {
        return this.f16424a;
    }

    /* renamed from: a */
    public void m15794a(int i2) {
        this.f16435a.m16165a(i2);
    }

    /* renamed from: a */
    public boolean m15807a(int i2) {
        return this.f16435a.m16170a(i2);
    }

    @Override // com.xiaomi.push.InterfaceC4210fd
    /* renamed from: a */
    public void mo14173a(AbstractC4207fa abstractC4207fa) {
        AbstractC4022b.m13359c("begin to connect...");
        C4194eo.m14656a().mo14173a(abstractC4207fa);
    }

    @Override // com.xiaomi.push.InterfaceC4210fd
    /* renamed from: a */
    public void mo14174a(AbstractC4207fa abstractC4207fa, int i2, Exception exc) {
        C4194eo.m14656a().mo14174a(abstractC4207fa, i2, exc);
        if (m15787i()) {
            return;
        }
        m15803a(false);
    }

    @Override // com.xiaomi.push.InterfaceC4210fd
    /* renamed from: a */
    public void mo14175a(AbstractC4207fa abstractC4207fa, Exception exc) {
        C4194eo.m14656a().mo14175a(abstractC4207fa, exc);
        m15775c(false);
        if (m15787i()) {
            return;
        }
        m15803a(false);
    }

    /* renamed from: a */
    public void m15799a(InterfaceC4341n interfaceC4341n) {
        synchronized (this.f16438a) {
            this.f16438a.add(interfaceC4341n);
        }
    }

    /* renamed from: d */
    public boolean m15813d() {
        AbstractC4207fa abstractC4207fa = this.f16424a;
        return abstractC4207fa != null && abstractC4207fa.m14778b();
    }
}
