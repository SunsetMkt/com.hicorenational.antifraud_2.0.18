package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4243gj;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.service.C4374az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a */
    public static class C4041a {

        /* renamed from: a */
        private static volatile C4041a f14351a;

        /* renamed from: a */
        private Context f14352a;

        /* renamed from: a */
        private Boolean f14354a;

        /* renamed from: a */
        private String f14355a;

        /* renamed from: a */
        private a f14353a = new a();

        /* renamed from: a */
        private final ArrayList<C4243gj> f14356a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a */
        public class a {

            /* renamed from: a */
            private ScheduledFuture<?> f14360a;

            /* renamed from: a */
            private ScheduledThreadPoolExecutor f14361a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a */
            public final ArrayList<C4243gj> f14359a = new ArrayList<>();

            /* renamed from: a */
            private final Runnable f14358a = new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f14359a.size() != 0) {
                        a.this.m13450b();
                    } else if (a.this.f14360a != null) {
                        a.this.f14360a.cancel(false);
                        a.this.f14360a = null;
                    }
                }
            };

            public a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: b */
            public void m13450b() {
                C4243gj remove = this.f14359a.remove(0);
                for (C4265he c4265he : C4374az.m16041a(Arrays.asList(remove), C4041a.this.f14352a.getPackageName(), C4048b.m13476a(C4041a.this.f14352a).m13480a(), 30720)) {
                    AbstractC4022b.m13359c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.m15001d());
                    C4067u.m13627a(C4041a.this.f14352a).m13661a((C4067u) c4265he, EnumC4239gf.Notification, true, (C4252gs) null);
                }
            }

            /* renamed from: a */
            public void m13452a(final C4243gj c4243gj) {
                this.f14361a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f14359a.add(c4243gj);
                        a.this.m13448a();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public void m13448a() {
                if (this.f14360a == null) {
                    this.f14360a = this.f14361a.scheduleAtFixedRate(this.f14358a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }
        }

        /* renamed from: b */
        public void m13445b(String str) {
            AbstractC4022b.m13359c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f14356a) {
                arrayList.addAll(this.f14356a);
                this.f14356a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m13444a((C4243gj) it.next());
            }
        }

        /* renamed from: a */
        public static C4041a m13436a() {
            if (f14351a == null) {
                synchronized (C4041a.class) {
                    if (f14351a == null) {
                        f14351a = new C4041a();
                    }
                }
            }
            return f14351a;
        }

        /* renamed from: a */
        public void m13441a(Context context) {
            if (context == null) {
                AbstractC4022b.m13347a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f14352a = context;
            this.f14354a = Boolean.valueOf(m13438a(context));
            m13445b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        /* renamed from: b */
        private boolean m13439b(Context context) {
            return C4048b.m13476a(context).m13480a() == null && !m13438a(this.f14352a);
        }

        /* renamed from: b */
        private boolean m13440b(C4243gj c4243gj) {
            if (C4374az.m16043a(c4243gj, false)) {
                return false;
            }
            if (this.f14354a.booleanValue()) {
                AbstractC4022b.m13359c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + c4243gj.m15001d());
                C4067u.m13627a(this.f14352a).m13656a(c4243gj);
                return true;
            }
            this.f14353a.m13452a(c4243gj);
            return true;
        }

        /* renamed from: a */
        public synchronized void m13442a(String str) {
            if (TextUtils.isEmpty(str)) {
                AbstractC4022b.m13347a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f14355a = str;
                m13445b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a */
        private boolean m13438a(Context context) {
            if (!C4067u.m13627a(context).m13671a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a */
        public boolean m13443a() {
            return this.f14352a != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a5, code lost:
        
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13359c("MiTinyDataClient Pending " + r6.m14993b() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL);
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized boolean m13444a(com.xiaomi.push.C4243gj r6) {
            /*
                Method dump skipped, instructions count: 281
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiTinyDataClient.C4041a.m13444a(com.xiaomi.push.gj):boolean");
        }

        /* renamed from: a */
        private void m13437a(C4243gj c4243gj) {
            synchronized (this.f14356a) {
                if (!this.f14356a.contains(c4243gj)) {
                    this.f14356a.add(c4243gj);
                    if (this.f14356a.size() > 100) {
                        this.f14356a.remove(0);
                    }
                }
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            AbstractC4022b.m13347a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        C4041a.m13436a().m13441a(context);
        if (TextUtils.isEmpty(str)) {
            AbstractC4022b.m13347a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            C4041a.m13436a().m13442a(str);
        }
    }

    public static boolean upload(String str, String str2, long j2, String str3) {
        C4243gj c4243gj = new C4243gj();
        c4243gj.m15000d(str);
        c4243gj.m14996c(str2);
        c4243gj.m14980a(j2);
        c4243gj.m14992b(str3);
        return C4041a.m13436a().m13444a(c4243gj);
    }

    public static boolean upload(Context context, String str, String str2, long j2, String str3) {
        C4243gj c4243gj = new C4243gj();
        c4243gj.m15000d(str);
        c4243gj.m14996c(str2);
        c4243gj.m14980a(j2);
        c4243gj.m14992b(str3);
        c4243gj.m14983a(true);
        c4243gj.m14981a("push_sdk_channel");
        return upload(context, c4243gj);
    }

    public static boolean upload(Context context, C4243gj c4243gj) {
        AbstractC4022b.m13359c("MiTinyDataClient.upload " + c4243gj.m15001d());
        if (!C4041a.m13436a().m13443a()) {
            C4041a.m13436a().m13441a(context);
        }
        return C4041a.m13436a().m13444a(c4243gj);
    }
}
