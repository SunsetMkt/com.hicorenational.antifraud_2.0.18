package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    public static class a {
        private static volatile a a;

        /* JADX INFO: renamed from: a */
        private Context f93a;

        /* JADX INFO: renamed from: a */
        private Boolean f95a;

        /* JADX INFO: renamed from: a */
        private String f96a;

        /* JADX INFO: renamed from: a */
        private C0151a f94a = new C0151a();

        /* JADX INFO: renamed from: a */
        private final ArrayList<gj> f97a = new ArrayList<>();

        /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a */
        public class C0151a {

            /* JADX INFO: renamed from: a */
            private ScheduledFuture<?> f100a;

            /* JADX INFO: renamed from: a */
            private ScheduledThreadPoolExecutor f101a = new ScheduledThreadPoolExecutor(1);

            /* JADX INFO: renamed from: a */
            public final ArrayList<gj> f99a = new ArrayList<>();

            /* JADX INFO: renamed from: a */
            private final Runnable f98a = new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C0151a.this.f99a.size() != 0) {
                        C0151a.this.b();
                    } else if (C0151a.this.f100a != null) {
                        C0151a.this.f100a.cancel(false);
                        C0151a.this.f100a = null;
                    }
                }
            };

            /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a$1 */
            class AnonymousClass1 implements Runnable {

                /* JADX INFO: renamed from: a */
                final /* synthetic */ gj f102a;

                AnonymousClass1(gj gjVar) {
                    gjVar = gjVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0151a.this.f99a.add(gjVar);
                    C0151a.this.a();
                }
            }

            /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a$2 */
            class AnonymousClass2 implements Runnable {
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C0151a.this.f99a.size() != 0) {
                        C0151a.this.b();
                    } else if (C0151a.this.f100a != null) {
                        C0151a.this.f100a.cancel(false);
                        C0151a.this.f100a = null;
                    }
                }
            }

            public C0151a() {
            }

            public void b() {
                gj gjVarRemove = this.f99a.remove(0);
                for (he heVar : az.a(Arrays.asList(gjVarRemove), a.this.f93a.getPackageName(), b.m73a(a.this.f93a).m74a(), 30720)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + gjVarRemove.d());
                    u.a(a.this.f93a).a(heVar, gf.Notification, true, (gs) null);
                }
            }

            public void a(gj gjVar) {
                this.f101a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.1

                    /* JADX INFO: renamed from: a */
                    final /* synthetic */ gj f102a;

                    AnonymousClass1(gj gjVar2) {
                        gjVar = gjVar2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C0151a.this.f99a.add(gjVar);
                        C0151a.this.a();
                    }
                });
            }

            public void a() {
                if (this.f100a == null) {
                    this.f100a = this.f101a.scheduleAtFixedRate(this.f98a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f97a) {
                arrayList.addAll(this.f97a);
                this.f97a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m69a((gj) it.next());
            }
        }

        public static a a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        /* JADX INFO: renamed from: a */
        public void m67a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m48a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f93a = context;
            this.f95a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        private boolean b(Context context) {
            return b.m73a(context).m74a() == null && !a(this.f93a);
        }

        private boolean b(gj gjVar) {
            if (az.a(gjVar, false)) {
                return false;
            }
            if (this.f95a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + gjVar.d());
                u.a(this.f93a).a(gjVar);
                return true;
            }
            this.f94a.a(gjVar);
            return true;
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m48a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f96a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        private boolean a(Context context) {
            if (!u.a(context).m118a()) {
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

        /* JADX INFO: renamed from: a */
        public boolean m68a() {
            return this.f93a != null;
        }

        /* JADX INFO: renamed from: a */
        public synchronized boolean m69a(gj gjVar) {
            if (gjVar == null) {
                return false;
            }
            if (az.a(gjVar, true)) {
                return false;
            }
            boolean z = TextUtils.isEmpty(gjVar.m461a()) && TextUtils.isEmpty(this.f96a);
            boolean z2 = !m68a();
            boolean z3 = this.f93a == null || b(this.f93a);
            if (!z2 && !z && !z3) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + gjVar.d());
                if (TextUtils.isEmpty(gjVar.d())) {
                    gjVar.f(aj.a());
                }
                if (TextUtils.isEmpty(gjVar.m461a())) {
                    gjVar.a(this.f96a);
                }
                if (TextUtils.isEmpty(gjVar.c())) {
                    gjVar.e(this.f93a.getPackageName());
                }
                if (gjVar.a() <= 0) {
                    gjVar.b(System.currentTimeMillis());
                }
                return b(gjVar);
            }
            if (z) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL);
            } else if (z2) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT);
            } else if (z3) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID);
            }
            a(gjVar);
            return true;
        }

        private void a(gj gjVar) {
            synchronized (this.f97a) {
                if (!this.f97a.contains(gjVar)) {
                    this.f97a.add(gjVar);
                    if (this.f97a.size() > 100) {
                        this.f97a.remove(0);
                    }
                }
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m48a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m67a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(String str, String str2, long j2, String str3) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c(str2);
        gjVar.a(j2);
        gjVar.b(str3);
        return a.a().m69a(gjVar);
    }

    public static boolean upload(Context context, String str, String str2, long j2, String str3) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c(str2);
        gjVar.a(j2);
        gjVar.b(str3);
        gjVar.a(true);
        gjVar.a("push_sdk_channel");
        return upload(context, gjVar);
    }

    public static boolean upload(Context context, gj gjVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + gjVar.d());
        if (!a.a().m68a()) {
            a.a().m67a(context);
        }
        return a.a().m69a(gjVar);
    }
}
