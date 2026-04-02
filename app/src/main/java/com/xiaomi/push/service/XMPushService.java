package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
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
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.bh;
import com.xiaomi.push.bl;
import com.xiaomi.push.cg;
import com.xiaomi.push.cn;
import com.xiaomi.push.ct;
import com.xiaomi.push.cx;
import com.xiaomi.push.db;
import com.xiaomi.push.dp;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.dz;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.er;
import com.xiaomi.push.ey;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fd;
import com.xiaomi.push.fe;
import com.xiaomi.push.ff;
import com.xiaomi.push.fg;
import com.xiaomi.push.fi;
import com.xiaomi.push.fk;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fq;
import com.xiaomi.push.fz;
import com.xiaomi.push.ga;
import com.xiaomi.push.gd;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.hb;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.n;
import com.xiaomi.push.service.q;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class XMPushService extends Service implements fd {

    /* JADX INFO: renamed from: b */
    private static boolean f9338b = false;

    /* JADX INFO: renamed from: a */
    private ContentObserver f934a;

    /* JADX INFO: renamed from: a */
    private ey f936a;

    /* JADX INFO: renamed from: a */
    private fa f937a;

    /* JADX INFO: renamed from: a */
    private fb f938a;

    /* JADX INFO: renamed from: a */
    private a f940a;

    /* JADX INFO: renamed from: a */
    private f f941a;

    /* JADX INFO: renamed from: a */
    private k f942a;

    /* JADX INFO: renamed from: a */
    private r f943a;

    /* JADX INFO: renamed from: a */
    private t f944a;

    /* JADX INFO: renamed from: a */
    private as f946a;

    /* JADX INFO: renamed from: a */
    private com.xiaomi.push.service.h f947a;

    /* JADX INFO: renamed from: a */
    private Object f950a;

    /* JADX INFO: renamed from: a */
    private boolean f953a = false;
    private int a = 0;

    /* JADX INFO: renamed from: b */
    private int f954b = 0;

    /* JADX INFO: renamed from: a */
    private long f933a = 0;

    /* JADX INFO: renamed from: a */
    protected Class f949a = XMJobService.class;

    /* JADX INFO: renamed from: c */
    private int f9339c = -1;

    /* JADX INFO: renamed from: a */
    private ak f945a = null;

    /* JADX INFO: renamed from: a */
    private com.xiaomi.push.service.n f948a = null;

    /* JADX INFO: renamed from: a */
    Messenger f935a = null;

    /* JADX INFO: renamed from: a */
    private Collection<aa> f952a = Collections.synchronizedCollection(new ArrayList());

    /* JADX INFO: renamed from: a */
    private ArrayList<n> f951a = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    private ff f939a = new ff() { // from class: com.xiaomi.push.service.XMPushService.1
        AnonymousClass1() {
        }

        @Override // com.xiaomi.push.ff
        public void a(fo foVar) {
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new m(foVar));
        }

        @Override // com.xiaomi.push.ff
        public void a(er erVar) {
            if (com.xiaomi.push.service.e.a(erVar)) {
                at.a().a(erVar.e(), SystemClock.elapsedRealtime(), XMPushService.this.m657a());
            }
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new d(erVar));
        }
    };

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$1 */
    class AnonymousClass1 implements ff {
        AnonymousClass1() {
        }

        @Override // com.xiaomi.push.ff
        public void a(fo foVar) {
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new m(foVar));
        }

        @Override // com.xiaomi.push.ff
        public void a(er erVar) {
            if (com.xiaomi.push.service.e.a(erVar)) {
                at.a().a(erVar.e(), SystemClock.elapsedRealtime(), XMPushService.this.m657a());
            }
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new d(erVar));
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$10 */
    class AnonymousClass10 implements am.a {
        AnonymousClass10() {
        }

        @Override // com.xiaomi.push.service.am.a
        public void a() {
            XMPushService.this.e();
            if (am.a().m689a() <= 0) {
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(xMPushService.new g(12, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$11 */
    class AnonymousClass11 implements n {
        AnonymousClass11() {
        }

        @Override // com.xiaomi.push.service.XMPushService.n
        /* JADX INFO: renamed from: a */
        public void mo456a() {
            bh.a(XMPushService.this.getApplicationContext());
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$12 */
    class AnonymousClass12 extends ContentObserver {
        AnonymousClass12(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            boolean zM654g = XMPushService.this.m654g();
            com.xiaomi.channel.commonutils.logger.b.m48a("SuperPowerMode:" + zM654g);
            XMPushService.this.e();
            if (!zM654g) {
                XMPushService.this.a(true);
            } else {
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(xMPushService.new g(24, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$13 */
    class AnonymousClass13 extends j {
        AnonymousClass13(int i2) {
            super(i2);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "prepare the mi push account.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            w.a(XMPushService.this);
            if (com.xiaomi.push.au.m149a((Context) XMPushService.this)) {
                XMPushService.this.a(true);
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$14 */
    class AnonymousClass14 implements q.a {
        final /* synthetic */ j a;

        AnonymousClass14(j jVar) {
            jVar = jVar;
        }

        @Override // com.xiaomi.push.service.q.a
        public void a() {
            XMPushService.this.a(jVar);
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$2 */
    class AnonymousClass2 extends j {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f956a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ byte[] f957a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f9340b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i2, int i3, String str, byte[] bArr) {
            super(i2);
            i = i3;
            str = str;
            bArr = bArr;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "clear account cache.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            com.xiaomi.push.service.q.m741a((Context) XMPushService.this);
            am.a().m694a("5");
            com.xiaomi.push.x.a(i);
            XMPushService.this.f938a.c(fb.a());
            com.xiaomi.channel.commonutils.logger.b.m48a("clear account and start registration. " + str);
            XMPushService.this.a(bArr, str);
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$3 */
    class AnonymousClass3 extends j {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f958a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ byte[] f959a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(int i2, String str, byte[] bArr) {
            super(i2);
            str = str;
            bArr = bArr;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "send mi push message";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            try {
                w.a(XMPushService.this, str, bArr);
            } catch (fi e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                XMPushService.this.a(10, e2);
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$4 */
    class AnonymousClass4 extends j {
        AnonymousClass4(int i2) {
            super(i2);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "disconnect for service destroy.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            if (XMPushService.this.f937a != null) {
                XMPushService.this.f937a.b(15, (Exception) null);
                XMPushService.this.f937a = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$5 */
    class AnonymousClass5 implements fk {
        AnonymousClass5() {
        }

        @Override // com.xiaomi.push.fk
        /* JADX INFO: renamed from: a */
        public boolean mo238a(fo foVar) {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$6 */
    class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XMPushService.this.f953a = true;
            try {
                com.xiaomi.channel.commonutils.logger.b.m48a("try to trigger the wifi digest broadcast.");
                Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                if (systemService != null) {
                    com.xiaomi.push.aw.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$7 */
    class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] disable ping receiver may be failure. " + th);
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$8 */
    class AnonymousClass8 extends Handler {
        AnonymousClass8() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                try {
                    int i2 = message.what;
                    if (i2 != 17) {
                        if (i2 == 18) {
                            Message messageObtain = Message.obtain((Handler) null, 0);
                            messageObtain.what = 18;
                            Bundle bundle = new Bundle();
                            bundle.putString("xmsf_region", com.xiaomi.push.service.b.a(XMPushService.this.getApplicationContext()).a());
                            messageObtain.setData(bundle);
                            message.replyTo.send(messageObtain);
                        }
                    } else if (message.obj != null) {
                        XMPushService.this.onStart((Intent) message.obj, 1);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.XMPushService$9 */
    class AnonymousClass9 extends fb {
        AnonymousClass9(Map map, int i2, String str, fe feVar) {
            super(map, i2, str, feVar);
        }

        @Override // com.xiaomi.push.fb
        /* JADX INFO: renamed from: a */
        public byte[] mo420a() {
            try {
                dp.b bVar = new dp.b();
                bVar.a(ax.a().m706a());
                return bVar.m372a();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m48a("getOBBString err: " + e2.toString());
                return null;
            }
        }
    }

    private class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        private final Object f960a;

        private a() {
            this.f960a = new Object();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!an.q.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] cancel the old ping timer");
                dz.a();
                return;
            }
            if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000L);
                    com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }

        private void a(long j2) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f960a) {
                try {
                    this.f960a.wait(j2);
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] interrupt from waiting state. " + e2);
                }
            }
        }

        /* synthetic */ a(XMPushService xMPushService, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f960a) {
                try {
                    this.f960a.notifyAll();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] notify lock. " + e2);
                }
            }
        }
    }

    static class c extends j {
        private final am.b a;

        public c(am.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            this.a.a(am.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).a.f9362g, this.a.f9362g);
            }
            return false;
        }

        public int hashCode() {
            return this.a.f9362g.hashCode();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind time out. chid=" + this.a.f9362g;
        }
    }

    class d extends j {
        private er a;

        public d(er erVar) {
            super(8);
            this.a = null;
            this.a = erVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            XMPushService.this.f945a.a(this.a);
            if (com.xiaomi.push.service.e.a(this.a)) {
                XMPushService.this.a(new at.a(), 15000L);
            }
        }
    }

    public class e extends j {
        e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            if (XMPushService.this.m661a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("should not connect. quit the job.");
        }
    }

    class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.au.m148a();
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class g extends j {

        /* JADX INFO: renamed from: a */
        public Exception f963a;

        /* JADX INFO: renamed from: b */
        public int f9341b;

        g(int i2, Exception exc) {
            super(2);
            this.f9341b = i2;
            this.f963a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            XMPushService.this.a(this.f9341b, this.f963a);
        }
    }

    class h extends j {
        h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            XMPushService.this.c();
        }
    }

    class i extends j {
        private Intent a;

        public i(Intent intent) {
            super(15);
            this.a = null;
            this.a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            XMPushService.this.d(this.a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Handle intent action = " + this.a.getAction();
        }
    }

    public static abstract class j extends n.b {
        public j(int i2) {
            super(i2);
        }

        public abstract String a();

        /* JADX INFO: renamed from: a */
        public abstract void mo377a();

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.a;
            if (i2 != 4 && i2 != 8) {
                com.xiaomi.channel.commonutils.logger.b.m49a(com.xiaomi.channel.commonutils.logger.a.a, a());
            }
            mo377a();
        }
    }

    class k extends BroadcastReceiver {
        k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m48a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            XMPushService.this.f948a.m728a();
        }
    }

    class m extends j {
        private fo a;

        public m(fo foVar) {
            super(8);
            this.a = null;
            this.a = foVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            XMPushService.this.f945a.a(this.a);
        }
    }

    public interface n {
        /* JADX INFO: renamed from: a */
        void mo456a();
    }

    class o extends j {

        /* JADX INFO: renamed from: a */
        boolean f966a;

        public o(boolean z) {
            super(4);
            this.f966a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            if (XMPushService.this.m666c()) {
                try {
                    if (!this.f966a) {
                        ep.a();
                    }
                    XMPushService.this.f937a.b(this.f966a);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
        }
    }

    class q extends j {
        q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m661a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    class r extends BroadcastReceiver {
        r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    class t extends BroadcastReceiver {
        t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f953a) {
                XMPushService.this.f953a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    private void d() {
        com.xiaomi.push.av avVarM142a = com.xiaomi.push.au.m142a();
        com.xiaomi.push.service.m.a(getApplicationContext()).a(avVarM142a);
        if (avVarM142a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + avVarM142a.m152a() + "[" + avVarM142a.m154b() + "], state: " + avVarM142a.m151a() + "/" + avVarM142a.m150a());
            com.xiaomi.channel.commonutils.logger.b.m49a("XMPushService", sb.toString());
            NetworkInfo.State stateM151a = avVarM142a.m151a();
            if (stateM151a == NetworkInfo.State.SUSPENDED || stateM151a == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m49a("XMPushService", "network changed, no active network");
        }
        if (eo.a() != null) {
            eo.a().m379a();
        }
        fz.m445a((Context) this);
        this.f936a.d();
        if (com.xiaomi.push.au.m149a((Context) this)) {
            if (m666c() && m653f()) {
                b(false);
            }
            if (!m666c() && !m667d()) {
                this.f948a.a(1);
                a(new e());
            }
            db.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    public void e() {
        if (!m661a()) {
            dz.a();
        } else {
            if (dz.m369a()) {
                return;
            }
            dz.a(true);
        }
    }

    /* JADX INFO: renamed from: f */
    private boolean m653f() {
        if (SystemClock.elapsedRealtime() - this.f933a < 30000) {
            return false;
        }
        return com.xiaomi.push.au.c(this);
    }

    /* JADX INFO: renamed from: g */
    public boolean m654g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* JADX INFO: renamed from: h */
    private boolean m655h() {
        boolean zEquals;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("current sdk expect region is cn");
            zEquals = com.xiaomi.push.n.China.name().equals(com.xiaomi.push.service.b.a(getApplicationContext()).a());
        } else {
            zEquals = !com.xiaomi.push.service.r.a(this).m744b(packageName);
        }
        if (!zEquals) {
            com.xiaomi.channel.commonutils.logger.b.m50a("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(zEquals), ", package=", packageName, ", region=", com.xiaomi.push.service.b.a(getApplicationContext()).a());
        }
        return zEquals;
    }

    /* JADX INFO: renamed from: i */
    private boolean m656i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m618b((Context) this) && !com.xiaomi.push.i.m615a(getApplicationContext());
    }

    private boolean j() {
        int iIntValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.a;
        int i3 = this.f954b;
        if (i2 > i3) {
            if (iIntValue >= i2 || iIntValue < i3) {
                return true;
            }
        } else if (i2 < i3 && iIntValue >= i2 && iIntValue < i3) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ah.a(this).a(gk.ForegroundServiceSwitch.a(), false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f935a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] strArrSplit;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.r.a((Context) this);
        com.xiaomi.push.service.p pVarM739a = com.xiaomi.push.service.q.m739a((Context) this);
        if (pVarM739a != null) {
            com.xiaomi.push.x.a(pVarM739a.a);
        }
        if (com.xiaomi.push.j.m625a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f940a = new a();
            com.xiaomi.push.m.a(this, this.f940a, new IntentFilter(an.q), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            f9338b = true;
            handler.post(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.7
                AnonymousClass7() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] disable ping receiver may be failure. " + th);
                    }
                }
            });
        }
        this.f935a = new Messenger(new Handler() { // from class: com.xiaomi.push.service.XMPushService.8
            AnonymousClass8() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    try {
                        int i2 = message.what;
                        if (i2 != 17) {
                            if (i2 == 18) {
                                Message messageObtain = Message.obtain((Handler) null, 0);
                                messageObtain.what = 18;
                                Bundle bundle = new Bundle();
                                bundle.putString("xmsf_region", com.xiaomi.push.service.b.a(XMPushService.this.getApplicationContext()).a());
                                messageObtain.setData(bundle);
                                message.replyTo.send(messageObtain);
                            }
                        } else if (message.obj != null) {
                            XMPushService.this.onStart((Intent) message.obj, 1);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        ao.a(this);
        this.f938a = new fb(null, 5222, "xiaomi.com", null) { // from class: com.xiaomi.push.service.XMPushService.9
            AnonymousClass9(Map map, int i2, String str, fe feVar) {
                super(map, i2, str, feVar);
            }

            @Override // com.xiaomi.push.fb
            /* JADX INFO: renamed from: a */
            public byte[] mo420a() {
                try {
                    dp.b bVar = new dp.b();
                    bVar.a(ax.a().m706a());
                    return bVar.m372a();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("getOBBString err: " + e2.toString());
                    return null;
                }
            }
        };
        this.f938a.a(true);
        this.f936a = new ey(this, this.f938a);
        this.f947a = m659a();
        dz.a(this);
        this.f936a.a(this);
        this.f945a = new ak(this);
        this.f946a = new as(this);
        new com.xiaomi.push.service.i().a();
        eo.m380a().a(this);
        this.f948a = new com.xiaomi.push.service.n("Connection Controller Thread");
        am amVarA = am.a();
        amVarA.b();
        amVarA.a(new am.a() { // from class: com.xiaomi.push.service.XMPushService.10
            AnonymousClass10() {
            }

            @Override // com.xiaomi.push.service.am.a
            public void a() {
                XMPushService.this.e();
                if (am.a().m689a() <= 0) {
                    XMPushService xMPushService = XMPushService.this;
                    xMPushService.a(xMPushService.new g(12, null));
                }
            }
        });
        if (k()) {
            h();
        }
        gd.a(this).a(new com.xiaomi.push.service.o(this), "UPLOADER_PUSH_CHANNEL");
        a(new ga(this));
        a(new bd(this));
        if (com.xiaomi.push.j.m625a((Context) this)) {
            a(new al());
            if (com.xiaomi.push.i.m614a()) {
                a(new n() { // from class: com.xiaomi.push.service.XMPushService.11
                    AnonymousClass11() {
                    }

                    @Override // com.xiaomi.push.service.XMPushService.n
                    /* JADX INFO: renamed from: a */
                    public void mo456a() {
                        bh.a(XMPushService.this.getApplicationContext());
                    }
                });
            }
        }
        a(new h());
        this.f952a.add(ay.a(this));
        if (m655h()) {
            this.f941a = new f();
            com.xiaomi.push.m.a(this, this.f941a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
            this.f950a = com.xiaomi.push.au.m144a((Context) this);
        }
        if (com.xiaomi.push.j.m625a(getApplicationContext())) {
            this.f944a = new t();
            com.xiaomi.push.m.a(this, this.f944a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            this.f942a = new k();
            com.xiaomi.push.m.a(this, this.f942a, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f934a = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.push.service.XMPushService.12
                    AnonymousClass12(Handler handler2) {
                        super(handler2);
                    }

                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        super.onChange(z);
                        boolean zM654g = XMPushService.this.m654g();
                        com.xiaomi.channel.commonutils.logger.b.m48a("SuperPowerMode:" + zM654g);
                        XMPushService.this.e();
                        if (!zM654g) {
                            XMPushService.this.a(true);
                        } else {
                            XMPushService xMPushService = XMPushService.this;
                            xMPushService.a(xMPushService.new g(24, null));
                        }
                    }
                };
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f934a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] iArrM650a = m650a();
            if (iArrM650a != null) {
                this.f943a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                com.xiaomi.push.m.a(this, this.f943a, intentFilter, (String) null, (Handler) null);
                this.a = iArrM650a[0];
                this.f954b = iArrM650a[1];
                com.xiaomi.channel.commonutils.logger.b.m48a("falldown initialized: " + this.a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f954b);
            }
        }
        cn.a(this, this.f936a);
        ct.a(this, this.f936a);
        String str = "";
        if (pVarM739a != null) {
            try {
                if (!TextUtils.isEmpty(pVarM739a.f1067a) && (strArrSplit = pVarM739a.f1067a.split("@")) != null && strArrSplit.length > 0) {
                    str = strArrSplit[0];
                }
            } catch (Exception unused) {
            }
        }
        cx.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f941a;
        if (fVar != null) {
            a(fVar);
            this.f941a = null;
        }
        Object obj = this.f950a;
        if (obj != null) {
            com.xiaomi.push.au.a(this, obj);
            this.f950a = null;
        }
        t tVar = this.f944a;
        if (tVar != null) {
            a(tVar);
            this.f944a = null;
        }
        k kVar = this.f942a;
        if (kVar != null) {
            a(kVar);
            this.f942a = null;
        }
        r rVar = this.f943a;
        if (rVar != null) {
            a(rVar);
            this.f943a = null;
        }
        a aVar = this.f940a;
        if (aVar != null) {
            a(aVar);
            this.f940a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f934a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f934a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f952a.clear();
        this.f948a.m731b();
        a(new j(2) { // from class: com.xiaomi.push.service.XMPushService.4
            AnonymousClass4(int i2) {
                super(i2);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "disconnect for service destroy.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                if (XMPushService.this.f937a != null) {
                    XMPushService.this.f937a.b(15, (Exception) null);
                    XMPushService.this.f937a = null;
                }
            }
        });
        a(new l());
        am.a().b();
        am.a().a(this, 15);
        am.a().m693a();
        this.f936a.b(this);
        ax.a().m708a();
        dz.a();
        i();
        cn.b(this, this.f936a);
        ct.b(this, this.f936a);
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m48a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(an.v);
                String stringExtra2 = intent.getStringExtra(an.F);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || "miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m49a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", intent.getAction(), stringExtra, stringExtra2, stringExtra3, com.xiaomi.push.j.a(intent)));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m49a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), stringExtra, stringExtra2, stringExtra3));
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f948a.m729a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    am.a().a(this, 14);
                    stopSelf();
                } else {
                    a(new i(intent));
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                a(new i(intent));
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + jCurrentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return com.xiaomi.push.j.m625a((Context) this) ? 1 : 2;
    }

    public void c() {
        String str;
        cg.a().m235d();
        com.xiaomi.push.service.m.a(getApplicationContext()).m722a();
        com.xiaomi.push.service.b bVarA = com.xiaomi.push.service.b.a(getApplicationContext());
        String strA = bVarA.a();
        com.xiaomi.channel.commonutils.logger.b.m49a("XMPushService", "region of cache is " + strA);
        if (TextUtils.isEmpty(strA)) {
            String strB = b();
            str = strB;
            strA = com.xiaomi.push.j.a(strB).name();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(strA) && com.xiaomi.push.n.China.name().equals(strA)) {
            bVarA.a(strA, true);
            bVarA.b("CN", true);
            str = "CN";
        } else if (TextUtils.isEmpty(strA)) {
            strA = com.xiaomi.push.n.China.name();
        } else {
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                strA = "";
                str = strA;
            } else {
                strA = com.xiaomi.push.n.China.name();
                str = "CN";
            }
            bVarA.a(strA, true);
            bVarA.b(str, true);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("XMPushService", "after check, appRegion is ", strA, ", countryCode=", str);
        if (com.xiaomi.push.n.China.name().equals(strA)) {
            fb.a("cn.app.chat.xiaomi.net");
        }
        a(strA);
        if (m655h()) {
            com.xiaomi.channel.commonutils.logger.b.m49a("XMPushService", "-->postOnCreate(): try trigger connect now");
            AnonymousClass13 anonymousClass13 = new j(11) { // from class: com.xiaomi.push.service.XMPushService.13
                AnonymousClass13(int i2) {
                    super(i2);
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "prepare the mi push account.";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* JADX INFO: renamed from: a */
                public void mo377a() {
                    w.a(XMPushService.this);
                    if (com.xiaomi.push.au.m149a((Context) XMPushService.this)) {
                        XMPushService.this.a(true);
                    }
                }
            };
            a(anonymousClass13);
            com.xiaomi.push.service.q.a(new q.a() { // from class: com.xiaomi.push.service.XMPushService.14
                final /* synthetic */ j a;

                AnonymousClass14(j anonymousClass132) {
                    jVar = anonymousClass132;
                }

                @Override // com.xiaomi.push.service.q.a
                public void a() {
                    XMPushService.this.a(jVar);
                }
            });
        }
        try {
            if (com.xiaomi.push.r.m636a()) {
                this.f947a.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            com.xiaomi.push.g.a((Context) this, getApplicationInfo(), true);
        }
    }

    private String b() {
        String strA;
        com.xiaomi.push.ag.a();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            ap apVarA = ap.a(this);
            String strA2 = null;
            while (true) {
                if (!TextUtils.isEmpty(strA2) && apVarA.a() != 0) {
                    strA = a();
                    break;
                }
                if (TextUtils.isEmpty(strA2)) {
                    strA2 = a();
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
            strA = "CN";
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("wait coutrycode :" + strA + " cost = " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " , count = " + i2);
        return strA;
    }

    public void f() {
        fa faVar = this.f937a;
        if (faVar != null && faVar.m416b()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
            return;
        }
        fa faVar2 = this.f937a;
        if (faVar2 != null && faVar2.m417c()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
            return;
        }
        this.f938a.b(com.xiaomi.push.au.m145a((Context) this));
        g();
        if (this.f937a == null) {
            am.a().a(this);
            c(false);
        }
    }

    private void g() {
        try {
            this.f936a.a(this.f939a, new fk() { // from class: com.xiaomi.push.service.XMPushService.5
                AnonymousClass5() {
                }

                @Override // com.xiaomi.push.fk
                /* JADX INFO: renamed from: a */
                public boolean mo238a(fo foVar) {
                    return true;
                }
            });
            this.f936a.e();
            this.f937a = this.f936a;
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f936a.b(3, e2);
        }
    }

    private void i() {
        synchronized (this.f951a) {
            this.f951a.clear();
        }
    }

    class p extends j {

        /* JADX INFO: renamed from: a */
        am.b f967a;

        public p(am.b bVar) {
            super(4);
            this.f967a = null;
            this.f967a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            try {
                this.f967a.a(am.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f937a.a(this.f967a.f9362g, this.f967a.f1001b);
                XMPushService.this.a(XMPushService.this.new b(this.f967a), 300L);
            } catch (fi e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                XMPushService.this.a(10, e2);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "rebind the client. " + this.f967a.f9362g;
        }
    }

    class s extends j {

        /* JADX INFO: renamed from: a */
        am.b f968a;

        /* JADX INFO: renamed from: a */
        String f969a;

        /* JADX INFO: renamed from: b */
        int f9342b;

        /* JADX INFO: renamed from: b */
        String f970b;

        public s(am.b bVar, int i2, String str, String str2) {
            super(9);
            this.f968a = null;
            this.f968a = bVar;
            this.f9342b = i2;
            this.f969a = str;
            this.f970b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            if (this.f968a.f996a != am.c.unbind && XMPushService.this.f937a != null) {
                try {
                    XMPushService.this.f937a.a(this.f968a.f9362g, this.f968a.f1001b);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
            this.f968a.a(am.c.unbind, this.f9342b, 0, this.f970b, this.f969a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "unbind the channel. " + this.f968a.f9362g;
        }
    }

    /* JADX INFO: renamed from: e */
    public static boolean m652e() {
        return f9338b;
    }

    class b extends j {

        /* JADX INFO: renamed from: a */
        am.b f961a;

        public b(am.b bVar) {
            super(9);
            this.f961a = null;
            this.f961a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            try {
                if (XMPushService.this.m666c()) {
                    am.b bVarA = am.a().a(this.f961a.f9362g, this.f961a.f1001b);
                    if (bVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.m48a("ignore bind because the channel " + this.f961a.f9362g + " is removed ");
                    } else if (bVarA.f996a == am.c.unbind) {
                        bVarA.a(am.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f937a.a(bVarA);
                        ep.a(XMPushService.this, bVarA);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m48a("trying duplicate bind, ingore! " + bVarA.f996a);
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e2);
                XMPushService.this.a(10, e2);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind the client. " + this.f961a.f9362g;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m657a() {
        if (this.f9339c < 0) {
            this.f9339c = com.xiaomi.push.g.a((Context) this, "com.xiaomi.xmsf");
        }
        return this.f9339c;
    }

    /* JADX INFO: renamed from: a */
    private int[] m650a() {
        String[] strArrSplit;
        String strA = ah.a(getApplicationContext()).a(gk.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(strA) && (strArrSplit = strA.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && strArrSplit.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(strArrSplit[0]).intValue();
                iArr[1] = Integer.valueOf(strArrSplit[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private void b(boolean z) {
        this.f933a = SystemClock.elapsedRealtime();
        if (!m666c()) {
            a(true);
        } else if (com.xiaomi.push.au.m149a((Context) this)) {
            c(new o(z));
        } else {
            c(new g(17, null));
            a(true);
        }
    }

    private String a() {
        String strM622a = com.xiaomi.push.j.m622a("ro.miui.region");
        return TextUtils.isEmpty(strM622a) ? com.xiaomi.push.j.m622a("ro.product.locale.region") : strM622a;
    }

    private void b(Intent intent) {
        long j2;
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.J);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        am amVarA = am.a();
        er erVarA = null;
        if (bundleExtra != null) {
            fn fnVar = (fn) a(new fn(bundleExtra), stringExtra, stringExtra2);
            if (fnVar == null) {
                return;
            } else {
                erVarA = er.a(fnVar, amVarA.a(fnVar.k(), fnVar.m()).f9363h);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(an.s));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(an.t);
                String stringExtra4 = intent.getStringExtra(an.u);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                am.b bVarA = amVarA.a(stringExtra5, String.valueOf(j2));
                if (bVarA != null) {
                    er erVar = new er();
                    try {
                        erVar.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    erVar.a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    erVar.a(j2, stringExtra3, stringExtra4);
                    erVar.a(intent.getStringExtra("ext_pkt_id"));
                    erVar.a(byteArrayExtra, bVarA.f9363h);
                    com.xiaomi.channel.commonutils.logger.b.m48a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    erVarA = erVar;
                }
            }
        }
        if (erVarA != null) {
            c(new aw(this, erVarA));
        }
    }

    private static void a(String str) {
        if (com.xiaomi.push.n.China.name().equals(str)) {
            cg.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            cg.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            cg.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            cg.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            cg.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            cg.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            cg.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    public void d(Intent intent) {
        int i2;
        String strB;
        int intExtra;
        SharedPreferences sharedPreferences;
        am amVarA = am.a();
        boolean z = true;
        if (!an.f9372d.equalsIgnoreCase(intent.getAction()) && !an.f9378j.equalsIgnoreCase(intent.getAction())) {
            if (an.f9377i.equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra(an.F);
                String stringExtra2 = intent.getStringExtra(an.v);
                String stringExtra3 = intent.getStringExtra(an.s);
                com.xiaomi.channel.commonutils.logger.b.m48a("Service called close channel chid = " + stringExtra2 + " res = " + am.b.a(stringExtra3));
                if (TextUtils.isEmpty(stringExtra2)) {
                    Iterator<String> it = amVarA.m692a(stringExtra).iterator();
                    while (it.hasNext()) {
                        a(it.next(), 2);
                    }
                    return;
                } else if (TextUtils.isEmpty(stringExtra3)) {
                    a(stringExtra2, 2);
                    return;
                } else {
                    a(stringExtra2, stringExtra3, 2, null, null);
                    return;
                }
            }
            if (an.f9373e.equalsIgnoreCase(intent.getAction())) {
                b(intent);
                return;
            }
            if (an.f9375g.equalsIgnoreCase(intent.getAction())) {
                c(intent);
                return;
            }
            if (an.f9374f.equalsIgnoreCase(intent.getAction())) {
                fo foVarA = a(new fm(intent.getBundleExtra("ext_packet")), intent.getStringExtra(an.F), intent.getStringExtra(an.J));
                if (foVarA != null) {
                    c(new aw(this, er.a(foVarA, amVarA.a(foVarA.k(), foVarA.m()).f9363h)));
                    return;
                }
                return;
            }
            if (an.f9376h.equalsIgnoreCase(intent.getAction())) {
                fo foVarA2 = a(new fq(intent.getBundleExtra("ext_packet")), intent.getStringExtra(an.F), intent.getStringExtra(an.J));
                if (foVarA2 != null) {
                    c(new aw(this, er.a(foVarA2, amVarA.a(foVarA2.k(), foVarA2.m()).f9363h)));
                    return;
                }
                return;
            }
            if (an.f9379k.equals(intent.getAction())) {
                String stringExtra4 = intent.getStringExtra(an.v);
                String stringExtra5 = intent.getStringExtra(an.s);
                if (stringExtra4 != null) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("request reset connection from chid = " + stringExtra4);
                    am.b bVarA = am.a().a(stringExtra4, stringExtra5);
                    if (bVarA != null && bVarA.f9363h.equals(intent.getStringExtra(an.B)) && bVarA.f996a == am.c.binded) {
                        fa faVarM658a = m658a();
                        if (faVarM658a == null || !faVarM658a.a(SystemClock.elapsedRealtime() - 15000)) {
                            c(new q());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            String string = null;
            bVarA = null;
            am.b bVarA2 = null;
            string = null;
            if (an.f9380l.equals(intent.getAction())) {
                String stringExtra6 = intent.getStringExtra(an.F);
                List<String> listM692a = amVarA.m692a(stringExtra6);
                if (listM692a.isEmpty()) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("open channel should be called first before update info, pkg=" + stringExtra6);
                    return;
                }
                String stringExtra7 = intent.getStringExtra(an.v);
                String stringExtra8 = intent.getStringExtra(an.s);
                if (TextUtils.isEmpty(stringExtra7)) {
                    stringExtra7 = listM692a.get(0);
                }
                if (TextUtils.isEmpty(stringExtra8)) {
                    Collection<am.b> collectionM691a = amVarA.m691a(stringExtra7);
                    if (collectionM691a != null && !collectionM691a.isEmpty()) {
                        bVarA2 = collectionM691a.iterator().next();
                    }
                } else {
                    bVarA2 = amVarA.a(stringExtra7, stringExtra8);
                }
                if (bVarA2 != null) {
                    if (intent.hasExtra(an.D)) {
                        bVarA2.f9360e = intent.getStringExtra(an.D);
                    }
                    if (intent.hasExtra(an.E)) {
                        bVarA2.f9361f = intent.getStringExtra(an.E);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) && !"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                    if (ap.a(getApplicationContext()).m699a() && ap.a(getApplicationContext()).a() == 0) {
                        com.xiaomi.channel.commonutils.logger.b.m48a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                        return;
                    }
                    byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                    String stringExtra9 = intent.getStringExtra("mipush_app_package");
                    boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                    int intExtra2 = intent.getIntExtra("mipush_env_type", 1);
                    com.xiaomi.push.service.r.a(this).d(stringExtra9);
                    if (booleanExtra && !"com.xiaomi.xmsf".equals(getPackageName())) {
                        c(new j(14) { // from class: com.xiaomi.push.service.XMPushService.2

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ String f956a;

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ byte[] f957a;

                            /* JADX INFO: renamed from: b */
                            final /* synthetic */ int f9340b;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass2(int i22, int intExtra22, String stringExtra92, byte[] byteArrayExtra2) {
                                super(i22);
                                i = intExtra22;
                                str = stringExtra92;
                                bArr = byteArrayExtra2;
                            }

                            @Override // com.xiaomi.push.service.XMPushService.j
                            public String a() {
                                return "clear account cache.";
                            }

                            @Override // com.xiaomi.push.service.XMPushService.j
                            /* JADX INFO: renamed from: a */
                            public void mo377a() {
                                com.xiaomi.push.service.q.m741a((Context) XMPushService.this);
                                am.a().m694a("5");
                                com.xiaomi.push.x.a(i);
                                XMPushService.this.f938a.c(fb.a());
                                com.xiaomi.channel.commonutils.logger.b.m48a("clear account and start registration. " + str);
                                XMPushService.this.a(bArr, str);
                            }
                        });
                        return;
                    } else {
                        a(byteArrayExtra2, stringExtra92);
                        return;
                    }
                }
                if (!"com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) && !"com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    if (aq.a.equals(intent.getAction())) {
                        String stringExtra10 = intent.getStringExtra("uninstall_pkg_name");
                        if (stringExtra10 == null || TextUtils.isEmpty(stringExtra10.trim())) {
                            return;
                        }
                        try {
                            PackageInfo packageInfo = getPackageManager().getPackageInfo(stringExtra10, 0);
                            if (packageInfo == null || packageInfo.applicationInfo == null || !com.xiaomi.push.i.m616a((Context) this, packageInfo.packageName)) {
                                z = false;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m48a("dual space's app uninstalled " + stringExtra10);
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if ("com.xiaomi.channel".equals(stringExtra10) && !am.a().m691a("1").isEmpty() && z) {
                            a("1", 0);
                            com.xiaomi.channel.commonutils.logger.b.m48a("close the miliao channel as the app is uninstalled.");
                            return;
                        }
                        SharedPreferences sharedPreferences2 = getSharedPreferences("pref_registered_pkg_names", 0);
                        String string2 = sharedPreferences2.getString(stringExtra10, null);
                        if (TextUtils.isEmpty(string2) || !z) {
                            return;
                        }
                        SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
                        editorEdit.remove(stringExtra10);
                        editorEdit.commit();
                        if (x.m758b((Context) this, stringExtra10)) {
                            x.c(this, stringExtra10);
                        }
                        x.m752a((Context) this, stringExtra10);
                        ac.a(getApplicationContext(), stringExtra10);
                        if (!m666c() || string2 == null) {
                            return;
                        }
                        try {
                            w.a(this, w.a(stringExtra10, string2));
                            com.xiaomi.channel.commonutils.logger.b.m48a("uninstall " + stringExtra10 + " msg sent");
                            return;
                        } catch (fi e2) {
                            com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e2.getMessage());
                            a(10, e2);
                            return;
                        }
                    }
                    if (aq.f9383b.equals(intent.getAction())) {
                        String stringExtra11 = intent.getStringExtra("data_cleared_pkg_name");
                        if (TextUtils.isEmpty(stringExtra11)) {
                            return;
                        }
                        try {
                            sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                            if (sharedPreferences != null) {
                                try {
                                    string = sharedPreferences.getString(stringExtra11, null);
                                } catch (Throwable th) {
                                    th = th;
                                    com.xiaomi.channel.commonutils.logger.b.m48a("Fail to get sp or appId : " + th);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            sharedPreferences = null;
                        }
                        if (!TextUtils.isEmpty(string)) {
                            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                            editorEdit2.remove(stringExtra11);
                            editorEdit2.commit();
                            if (x.m758b((Context) this, stringExtra11)) {
                                x.c(this, stringExtra11);
                            }
                            x.m752a((Context) this, stringExtra11);
                            a(stringExtra11, hp.a(w.b(stringExtra11, string)), true);
                        }
                        ac.a((Context) this, stringExtra11);
                        if (com.xiaomi.push.j.m625a(getApplicationContext())) {
                            v.a(stringExtra11);
                            return;
                        }
                        return;
                    }
                    if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                        String stringExtra12 = intent.getStringExtra(an.F);
                        int intExtra3 = intent.getIntExtra(an.G, -2);
                        if (TextUtils.isEmpty(stringExtra12)) {
                            return;
                        }
                        if (intExtra3 >= -1) {
                            x.a(this, stringExtra12, intExtra3, intent.getIntExtra(an.H, -1));
                            return;
                        } else {
                            x.a(this, stringExtra12, intent.getStringExtra(an.L), intent.getStringExtra(an.M));
                            return;
                        }
                    }
                    if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(intent.getAction())) {
                        String stringExtra13 = intent.getStringExtra(an.F);
                        if (TextUtils.isEmpty(stringExtra13)) {
                            return;
                        }
                        x.m757b((Context) this, stringExtra13);
                        return;
                    }
                    if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                        String stringExtra14 = intent.getStringExtra(an.F);
                        String stringExtra15 = intent.getStringExtra(an.K);
                        if (intent.hasExtra(an.I)) {
                            intExtra = intent.getIntExtra(an.I, 0);
                            strB = com.xiaomi.push.ba.b(stringExtra14 + intExtra);
                            z = false;
                        } else {
                            strB = com.xiaomi.push.ba.b(stringExtra14);
                            intExtra = 0;
                        }
                        if (TextUtils.isEmpty(stringExtra14) || !TextUtils.equals(stringExtra15, strB)) {
                            com.xiaomi.channel.commonutils.logger.b.d("invalid notification for " + stringExtra14);
                            return;
                        }
                        if (z) {
                            x.c(this, stringExtra14);
                            return;
                        } else {
                            x.b(this, stringExtra14, intExtra);
                            return;
                        }
                    }
                    if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                        String stringExtra16 = intent.getStringExtra("mipush_app_package");
                        if (!TextUtils.isEmpty(stringExtra16)) {
                            com.xiaomi.push.service.r.a(this).b(stringExtra16);
                        }
                        if ("com.xiaomi.xmsf".equals(getPackageName())) {
                            return;
                        }
                        a(19, (Exception) null);
                        e();
                        stopSelf();
                        return;
                    }
                    if (!"com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) && !"com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                            String stringExtra17 = intent.getStringExtra("mipush_app_package");
                            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                            gj gjVar = new gj();
                            try {
                                hp.a(gjVar, byteArrayExtra2);
                                gd.a(this).a(gjVar, stringExtra17);
                                return;
                            } catch (hu e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                                return;
                            }
                        }
                        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] Service called on timer");
                            if (m656i()) {
                                if (dz.m369a()) {
                                    com.xiaomi.channel.commonutils.logger.b.m48a("enter falldown mode, stop alarm");
                                    dz.a();
                                }
                            } else {
                                dz.a(false);
                                if (m653f()) {
                                    b(false);
                                }
                            }
                            a aVar = this.f940a;
                            if (aVar != null) {
                                aVar.a();
                                return;
                            }
                            return;
                        }
                        if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m48a("Service called on check alive.");
                            if (m653f()) {
                                b(false);
                                return;
                            }
                            return;
                        }
                        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m48a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                            dz.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                            return;
                        }
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            d();
                            return;
                        }
                        if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                            a(intent);
                            return;
                        }
                        if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
                            if (intent.getExtras() == null || (i2 = intent.getExtras().getInt("effectivePeriod", 0)) <= 0 || i2 > 604800) {
                                return;
                            }
                            com.xiaomi.push.service.m.a(getApplicationContext()).a(i2);
                            return;
                        }
                        if ("action_cr_config".equals(intent.getAction())) {
                            boolean booleanExtra2 = intent.getBooleanExtra("action_cr_event_switch", false);
                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_perf_switch", false);
                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_event_en", true);
                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                            Config configBuild = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra2).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra3).setPerfUploadFrequency(longExtra2).setAESKey(bl.a(getApplicationContext())).setEventEncrypted(booleanExtra4).setMaxFileLength(longExtra3).build(getApplicationContext());
                            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                return;
                            }
                            ds.a(getApplicationContext(), configBuild);
                            return;
                        }
                        if (an.f9382n.equals(intent.getAction())) {
                            com.xiaomi.push.service.l.a(getApplicationContext(), intent);
                            return;
                        } else {
                            if (an.o.equals(intent.getAction())) {
                                String stringExtra18 = intent.getStringExtra("ext_downward_pkt_id");
                                if (TextUtils.isEmpty(stringExtra18)) {
                                    return;
                                }
                                at.a().b(stringExtra18, intent.getLongExtra("ext_app_receive_time", 0L));
                                return;
                            }
                            return;
                        }
                    }
                    String stringExtra19 = intent.getStringExtra("mipush_app_package");
                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                    String stringExtra20 = intent.getStringExtra("mipush_app_id");
                    String stringExtra21 = intent.getStringExtra("mipush_app_token");
                    if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        com.xiaomi.push.service.r.a(this).c(stringExtra19);
                    }
                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        com.xiaomi.push.service.r.a(this).e(stringExtra19);
                        com.xiaomi.push.service.r.a(this).f(stringExtra19);
                    }
                    if (byteArrayExtra3 == null) {
                        com.xiaomi.push.service.t.a(this, stringExtra19, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                        return;
                    }
                    com.xiaomi.push.service.t.b(stringExtra19, byteArrayExtra3);
                    a(new com.xiaomi.push.service.s(this, stringExtra19, stringExtra20, stringExtra21, byteArrayExtra3));
                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        if (this.f941a == null) {
                            this.f941a = new f();
                            com.xiaomi.push.m.a(this, this.f941a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
                        }
                        if (this.f950a == null) {
                            this.f950a = com.xiaomi.push.au.m144a((Context) this);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String stringExtra22 = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                boolean booleanExtra5 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                if (com.xiaomi.push.service.k.a(byteArrayExtra4, stringExtra22)) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("duplicate msg from: " + String.valueOf(stringExtra22));
                    return;
                }
                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    com.xiaomi.push.service.r.a(this).a(stringExtra22);
                    if (com.xiaomi.push.j.m625a(getApplicationContext())) {
                        v.a(stringExtra22);
                    }
                }
                a(stringExtra22, byteArrayExtra4, booleanExtra5);
                return;
            }
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                if (m656i()) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m48a("exit falldown mode, activate alarm.");
                e();
                if (m666c() || m667d()) {
                    return;
                }
                a(true);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m656i() && dz.m369a()) {
                com.xiaomi.channel.commonutils.logger.b.m48a("enter falldown mode, stop alarm.");
                dz.a();
                return;
            }
            return;
        }
        String stringExtra23 = intent.getStringExtra(an.v);
        if (TextUtils.isEmpty(intent.getStringExtra(an.B))) {
            com.xiaomi.channel.commonutils.logger.b.m48a("security is empty. ignore.");
            return;
        }
        if (!TextUtils.isEmpty(stringExtra23)) {
            boolean zM649a = m649a(stringExtra23, intent);
            am.b bVarA3 = a(stringExtra23, intent);
            if (!com.xiaomi.push.au.b(this)) {
                this.f947a.a(this, bVarA3, false, 2, null);
                return;
            }
            if (m666c()) {
                am.c cVar = bVarA3.f996a;
                if (cVar == am.c.unbind) {
                    c(new b(bVarA3));
                    return;
                }
                if (zM649a) {
                    c(new p(bVarA3));
                    return;
                } else if (cVar == am.c.binding) {
                    com.xiaomi.channel.commonutils.logger.b.m48a(String.format("the client is binding. %1$s %2$s.", bVarA3.f9362g, am.b.a(bVarA3.f1001b)));
                    return;
                } else {
                    if (cVar == am.c.binded) {
                        this.f947a.a(this, bVarA3, true, 0, null);
                        return;
                    }
                    return;
                }
            }
            a(true);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.J);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        fn[] fnVarArr = new fn[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            fnVarArr[i2] = new fn((Bundle) parcelableArrayExtra[i2]);
            fnVarArr[i2] = (fn) a(fnVarArr[i2], stringExtra, stringExtra2);
            if (fnVarArr[i2] == null) {
                return;
            }
        }
        am amVarA = am.a();
        er[] erVarArr = new er[fnVarArr.length];
        for (int i3 = 0; i3 < fnVarArr.length; i3++) {
            fn fnVar = fnVarArr[i3];
            erVarArr[i3] = er.a(fnVar, amVarA.a(fnVar.k(), fnVar.m()).f9363h);
        }
        c(new com.xiaomi.push.service.c(this, erVarArr));
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("digest");
        com.xiaomi.push.service.m.a(getApplicationContext()).m723a(string);
        cn.a(this, string);
    }

    /* JADX INFO: renamed from: a */
    void m660a() {
        if (SystemClock.elapsedRealtime() - this.f933a >= fg.a() && com.xiaomi.push.au.c(this)) {
            b(true);
        }
    }

    void a(String str, byte[] bArr, boolean z) {
        Collection<am.b> collectionM691a = am.a().m691a("5");
        if (collectionM691a.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.t.b(str, bArr);
            }
        } else if (collectionM691a.iterator().next().f996a == am.c.binded) {
            a(new j(4) { // from class: com.xiaomi.push.service.XMPushService.3

                /* JADX INFO: renamed from: a */
                final /* synthetic */ String f958a;

                /* JADX INFO: renamed from: a */
                final /* synthetic */ byte[] f959a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(int i2, String str2, byte[] bArr2) {
                    super(i2);
                    str = str2;
                    bArr = bArr2;
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "send mi push message";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* JADX INFO: renamed from: a */
                public void mo377a() {
                    try {
                        w.a(XMPushService.this, str, bArr);
                    } catch (fi e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        XMPushService.this.a(10, e2);
                    }
                }
            });
        } else if (z) {
            com.xiaomi.push.service.t.b(str2, bArr2);
        }
    }

    private void c(j jVar) {
        this.f948a.a(jVar);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m48a("register request without payload");
            return;
        }
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            if (hbVar.f717a == gf.Registration) {
                hf hfVar = new hf();
                try {
                    hp.a(hfVar, hbVar.m533a());
                    a(new com.xiaomi.push.service.s(this, hbVar.b(), hfVar.b(), hfVar.c(), bArr));
                    dt.a(getApplicationContext()).a(hbVar.b(), "E100003", hfVar.a(), AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, null);
                } catch (hu e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m48a("register request with invalid payload");
            }
        } catch (hu e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.r.m636a()) {
                if (z) {
                    if (com.xiaomi.push.j.m625a((Context) this)) {
                        Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                        intent.addFlags(1073741824);
                        sendBroadcast(intent);
                    }
                    for (aa aaVar : (aa[]) this.f952a.toArray(new aa[0])) {
                        aaVar.mo710a();
                    }
                    return;
                }
                if (com.xiaomi.push.j.m625a((Context) this)) {
                    Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                    intent2.addFlags(1073741824);
                    sendBroadcast(intent2);
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m665b() {
        try {
            Class<?> clsA = com.xiaomi.push.r.a(this, "miui.os.Build");
            Field field = clsA.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = clsA.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = clsA.getField("IS_CT_CUSTOMIZATION_TEST");
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

    /* JADX INFO: renamed from: b */
    public com.xiaomi.push.service.h m663b() {
        return this.f947a;
    }

    public void b(j jVar) {
        this.f948a.a(jVar.a, jVar);
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        eo.a().b(faVar);
        c(true);
        this.f946a.m701a();
        if (!dz.m369a() && !m656i()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("reconnection successful, reactivate alarm.");
            dz.a(true);
        }
        Iterator<am.b> it = am.a().m690a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f953a || !com.xiaomi.push.j.m625a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.ae.a(getApplicationContext()).a(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.6
            AnonymousClass6() {
            }

            @Override // java.lang.Runnable
            public void run() {
                XMPushService.this.f953a = true;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m48a("try to trigger the wifi digest broadcast.");
                    Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                    if (systemService != null) {
                        com.xiaomi.push.aw.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public boolean m666c() {
        fa faVar = this.f937a;
        return faVar != null && faVar.m417c();
    }

    /* JADX INFO: renamed from: b */
    void m664b() {
        com.xiaomi.push.service.m.a(getApplicationContext()).m727d();
        Iterator it = new ArrayList(this.f951a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).mo456a();
        }
    }

    private fo a(fo foVar, String str, String str2) {
        am amVarA = am.a();
        List<String> listM692a = amVarA.m692a(str);
        if (listM692a.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        foVar.o(str);
        String strK = foVar.k();
        if (TextUtils.isEmpty(strK)) {
            strK = listM692a.get(0);
            foVar.l(strK);
        }
        am.b bVarA = amVarA.a(strK, foVar.m());
        if (!m666c()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("drop a packet as the channel is not connected, chid=" + strK);
            return null;
        }
        if (bVarA != null && bVarA.f996a == am.c.binded) {
            if (TextUtils.equals(str2, bVarA.f9364i)) {
                return foVar;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("invalid session. " + str2);
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("drop a packet as the channel is not opened, chid=" + strK);
        return null;
    }

    /* JADX INFO: renamed from: a */
    private boolean m649a(String str, Intent intent) {
        am.b bVarA = am.a().a(str, intent.getStringExtra(an.s));
        boolean z = false;
        if (bVarA == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(an.J);
        String stringExtra2 = intent.getStringExtra(an.B);
        if (!TextUtils.isEmpty(bVarA.f9364i) && !TextUtils.equals(stringExtra, bVarA.f9364i)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("session changed. old session=" + bVarA.f9364i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(bVarA.f9363h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.ba.a(stringExtra2));
        return true;
    }

    private am.b a(String str, Intent intent) {
        am.b bVarA = am.a().a(str, intent.getStringExtra(an.s));
        if (bVarA == null) {
            bVarA = new am.b(this);
        }
        bVarA.f9362g = intent.getStringExtra(an.v);
        bVarA.f1001b = intent.getStringExtra(an.s);
        bVarA.f9358c = intent.getStringExtra(an.z);
        bVarA.f998a = intent.getStringExtra(an.F);
        bVarA.f9360e = intent.getStringExtra(an.D);
        bVarA.f9361f = intent.getStringExtra(an.E);
        bVarA.f1000a = intent.getBooleanExtra(an.C, false);
        bVarA.f9363h = intent.getStringExtra(an.B);
        bVarA.f9364i = intent.getStringExtra(an.J);
        bVarA.f9359d = intent.getStringExtra(an.A);
        bVarA.f997a = this.f947a;
        bVarA.a((Messenger) intent.getParcelableExtra(an.N));
        bVarA.f990a = getApplicationContext();
        am.a().a(bVarA);
        return bVarA;
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        am.b bVarA = am.a().a(str, str2);
        if (bVarA != null) {
            a(new s(bVarA, i2, str4, str3));
        }
        am.a().m695a(str, str2);
    }

    private void a(String str, int i2) {
        Collection<am.b> collectionM691a = am.a().m691a(str);
        if (collectionM691a != null) {
            for (am.b bVar : collectionM691a) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        am.a().m694a(str);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.f948a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("can't execute job err = " + e2.getMessage());
        }
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public void a(er erVar) throws fi {
        fa faVar = this.f937a;
        if (faVar != null) {
            faVar.b(erVar);
            return;
        }
        throw new fi("try send msg while connection is null.");
    }

    public void a(er[] erVarArr) throws fi {
        fa faVar = this.f937a;
        if (faVar != null) {
            faVar.a(erVarArr);
            return;
        }
        throw new fi("try send msg while connection is null.");
    }

    public void a(boolean z) {
        this.f946a.a(z);
    }

    public void a(am.b bVar) {
        if (bVar != null) {
            long jA = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m48a("schedule rebind job in " + (jA / 1000));
            a(new b(bVar), jA);
        }
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        fa faVar = this.f937a;
        sb.append(faVar == null ? null : Integer.valueOf(faVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m48a(sb.toString());
        fa faVar2 = this.f937a;
        if (faVar2 != null) {
            faVar2.b(i2, exc);
            this.f937a = null;
        }
        a(7);
        a(4);
        am.a().a(this, i2);
    }

    /* JADX INFO: renamed from: a */
    public boolean m661a() {
        boolean zM149a = com.xiaomi.push.au.m149a((Context) this);
        boolean z = am.a().m689a() > 0;
        boolean z2 = !m665b();
        boolean zM655h = m655h();
        boolean z3 = !m654g();
        boolean z4 = zM149a && z && z2 && zM655h && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(zM149a), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(zM655h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* JADX INFO: renamed from: a */
    public com.xiaomi.push.service.h m659a() {
        return new com.xiaomi.push.service.h();
    }

    public boolean a(Context context) {
        try {
            com.xiaomi.push.ag.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.au.b(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("network connectivity ok.");
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

    /* JADX INFO: renamed from: a */
    public fa m658a() {
        return this.f937a;
    }

    public void a(int i2) {
        this.f948a.a(i2);
    }

    /* JADX INFO: renamed from: a */
    public boolean m662a(int i2) {
        return this.f948a.m730a(i2);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        eo.a().a(faVar);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i2, Exception exc) {
        eo.a().a(faVar, i2, exc);
        if (m656i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
        eo.a().a(faVar, exc);
        c(false);
        if (m656i()) {
            return;
        }
        a(false);
    }

    public void a(n nVar) {
        synchronized (this.f951a) {
            this.f951a.add(nVar);
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m667d() {
        fa faVar = this.f937a;
        return faVar != null && faVar.m416b();
    }
}
