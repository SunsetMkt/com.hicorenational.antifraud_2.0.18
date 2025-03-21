package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.heytap.mcssdk.constant.C2085b;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.C3397d;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.C4025a;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.AbstractC4302l;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4085an;
import com.xiaomi.push.C4092au;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4149cx;
import com.xiaomi.push.C4159dg;
import com.xiaomi.push.C4160dh;
import com.xiaomi.push.C4169dq;
import com.xiaomi.push.C4170dr;
import com.xiaomi.push.C4171ds;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4243gj;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4259gz;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4266hf;
import com.xiaomi.push.C4270hj;
import com.xiaomi.push.C4272hl;
import com.xiaomi.push.C4274hn;
import com.xiaomi.push.C4287i;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4303m;
import com.xiaomi.push.C4306p;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.EnumC4183ed;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4244gk;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.EnumC4253gt;
import com.xiaomi.push.service.C4356ah;
import com.xiaomi.push.service.C4358aj;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        protected void setResultCode(long j2) {
            this.resultCode = j2;
        }
    }

    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        protected String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j2, String str2, List<String> list) {
        }

        public void onInitializeResult(long j2, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j2, String str, String str2) {
        }

        public void onUnsubscribeResult(long j2, String str, String str2) {
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        protected void setResultCode(long j2) {
            this.resultCode = j2;
        }

        protected void setToken(String str) {
            this.token = str;
        }
    }

    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            C4306p.m15711a(edit);
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        C4306p.m15711a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        C4306p.m15711a(edit);
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                    }
                } catch (Throwable th) {
                    AbstractC4022b.m13351a(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.m13457a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    protected static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            edit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            edit.remove("topic_" + it3.next());
        }
        edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        C4067u.m13627a(context).m13679f();
    }

    public static void clearNotification(Context context, int i2) {
        C4067u.m13627a(context).m13651a(i2);
    }

    public static void disablePush(Context context) {
        C4067u.m13627a(context).m13669a(true);
    }

    public static void enablePush(Context context) {
        C4067u.m13627a(context).m13669a(false);
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (C4048b.m13476a(context).m13496c()) {
            return C4048b.m13476a(context).m13501f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return C4300j.m15687b();
    }

    protected static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, C3397d.f11892R);
        return C4051e.m13518a(context).m13527b(EnumC4050d.ASSEMBLE_PUSH_FCM);
    }

    protected static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, C3397d.f11892R);
        return C4051e.m13518a(context).m13527b(EnumC4050d.ASSEMBLE_PUSH_HUAWEI);
    }

    protected static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, C3397d.f11892R);
        return C4051e.m13518a(context).m13527b(EnumC4050d.ASSEMBLE_PUSH_COS);
    }

    protected static boolean getOpenVIVOPush(Context context) {
        return C4051e.m13518a(context).m13527b(EnumC4050d.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (C4048b.m13476a(context).m13496c()) {
            return C4048b.m13476a(context).m13495c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        C4171ds.m14527a(new C4171ds.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.C4171ds.a
            public void uploader(Context context2, C4243gj c4243gj) {
                MiTinyDataClient.upload(context2, c4243gj);
            }
        });
        Config m14515a = C4171ds.m14515a(context);
        C4025a.m13366a(context).m13387a(BuildConfig.VERSION_NAME);
        ClientReportClient.init(context, m14515a, new C4169dq(context), new C4170dr(context));
        C4047a.m13474a(context);
        C4057k.m13574a(context, m14515a);
        C4356ah.m15923a(context).m15932a(new C4356ah.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.C4356ah.a
            protected void onCallback() {
                C4171ds.m14523a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(C4062p.m13587a(sContext).m13589a(EnumC4068v.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(C4062p.m13587a(sContext).m13589a(EnumC4068v.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(C4062p.m13587a(sContext).m13589a(EnumC4068v.UPLOAD_HUAWEI_TOKEN))) {
            C4067u.m13627a(sContext).m13667a((String) null, EnumC4068v.UPLOAD_HUAWEI_TOKEN, EnumC4050d.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(C4062p.m13587a(sContext).m13589a(EnumC4068v.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(C4062p.m13587a(sContext).m13589a(EnumC4068v.UPLOAD_COS_TOKEN))) {
            C4067u.m13627a(sContext).m13667a((String) null, EnumC4068v.UPLOAD_COS_TOKEN, EnumC4050d.ASSEMBLE_PUSH_COS, "init");
        }
        if ("syncing".equals(C4062p.m13587a(sContext).m13589a(EnumC4068v.UPLOAD_FTOS_TOKEN))) {
            C4067u.m13627a(context).m13667a((String) null, EnumC4068v.UPLOAD_FTOS_TOKEN, EnumC4050d.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, EnumC4253gt enumC4253gt) {
        AbstractC4022b.m13363e("re-register reason: " + enumC4253gt);
        String m13878a = C4100bb.m13878a(6);
        String m13480a = C4048b.m13476a(context).m13480a();
        String m13490b = C4048b.m13476a(context).m13490b();
        C4048b.m13476a(context).m13481a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        C4048b.m13476a(context).m13482a(Constants.m13421a());
        C4048b.m13476a(context).m13485a(m13480a, m13490b, m13878a);
        C4266hf c4266hf = new C4266hf();
        c4266hf.m15342a(C4358aj.m15943b());
        c4266hf.m15349b(m13480a);
        c4266hf.m15361e(m13490b);
        c4266hf.m15364f(m13878a);
        c4266hf.m15358d(context.getPackageName());
        c4266hf.m15354c(C4233g.m14931a(context, context.getPackageName()));
        c4266hf.m15348b(C4233g.m14925a(context, context.getPackageName()));
        c4266hf.m15370h(BuildConfig.VERSION_NAME);
        c4266hf.m15340a(BuildConfig.VERSION_CODE);
        c4266hf.m15341a(enumC4253gt);
        int m15630a = C4287i.m15630a();
        if (m15630a >= 0) {
            c4266hf.m15353c(m15630a);
        }
        C4067u.m13627a(context).m13657a(c4266hf, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            C4303m.m15699a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th) {
            AbstractC4022b.m13347a("dynamic register network status receiver failed:" + th);
        }
        C4092au.m13788a(sContext);
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            C4306p.m15711a(edit);
        }
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = getAllUserAccount(context).iterator();
            while (it.hasNext()) {
                removeAccount(context, it.next());
            }
        }
    }

    static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = getAllAlias(context).iterator();
            while (it.hasNext()) {
                removeAlias(context, it.next());
            }
        }
    }

    static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = getAllTopic(context).iterator();
            while (it.hasNext()) {
                removeTopic(context, it.next());
            }
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    public static void removeWindow(Context context) {
        C4067u.m13627a(context).m13678e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (C4048b.m13476a(context).m13494b()) {
            EnumC4249gp enumC4249gp = z ? EnumC4249gp.APP_SLEEP : EnumC4249gp.APP_WAKEUP;
            C4265he c4265he = new C4265he();
            c4265he.m15314b(C4048b.m13476a(context).m13480a());
            c4265he.m15318c(enumC4249gp.f15769a);
            c4265he.m15322d(context.getPackageName());
            c4265he.m15301a(C4358aj.m15941a());
            c4265he.m15304a(false);
            C4067u.m13627a(context).m13662a((C4067u) c4265he, EnumC4239gf.Notification, false, (C4252gs) null, false);
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, C4252gs c4252gs, String str2, String str3) {
        C4265he c4265he = new C4265he();
        if (TextUtils.isEmpty(str3)) {
            AbstractC4022b.m13361d("do not report clicked message");
            return;
        }
        c4265he.m15314b(str3);
        c4265he.m15318c("bar:click");
        c4265he.m15301a(str);
        c4265he.m15304a(false);
        C4067u.m13627a(context).m13664a(c4265he, EnumC4239gf.Notification, false, true, c4252gs, true, str2, str3);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (C4356ah.m15923a(sContext).m15935a(EnumC4244gk.DataCollectionSwitch.m15014a(), getDefaultSwitch())) {
            C4159dg.m14281a().m14283a(new C4055i(context));
            C4076ae.m13698a(sContext).m13704a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    C4160dh.m14284a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        C4076ae.m13698a(sContext).m13707a(new C4061o(sContext), C4356ah.m15923a(sContext).m15927a(EnumC4244gk.OcVersionCheckFrequency.m15014a(), RemoteMessageConst.DEFAULT_TTL), 5);
    }

    public static void setAcceptTime(Context context, int i2, int i3, int i4, int i5, String str) {
        if (i2 < 0 || i2 >= 24 || i4 < 0 || i4 >= 24 || i3 < 0 || i3 >= 60 || i5 < 0 || i5 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j2 = ((((i2 * 60) + i3) + rawOffset) + 1440) % 1440;
        long j3 = ((((i4 * 60) + i5) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j3 / 60), Long.valueOf(j3 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i2), Integer.valueOf(i3)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i4), Integer.valueOf(i5)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, EnumC4183ed.COMMAND_SET_ACCEPT_TIME.f15082a, (ArrayList<String>) arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.m13463a(context, str, EnumC4183ed.COMMAND_SET_ACCEPT_TIME.f15082a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_SET_ACCEPT_TIME.f15082a, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, EnumC4183ed.COMMAND_SET_ALIAS.f15082a, str, str2);
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (EnumC4183ed.COMMAND_SET_ALIAS.f15082a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m13463a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_SET_ALIAS.f15082a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (EnumC4183ed.COMMAND_UNSET_ALIAS.f15082a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            AbstractC4022b.m13347a("Don't cancel alias for " + C4100bb.m13880a(arrayList.toString(), 3) + " is unseted");
            return;
        }
        if (EnumC4183ed.COMMAND_SET_ACCOUNT.f15082a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < C2084a.f6123e) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m13463a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_SET_ACCOUNT.f15082a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (!EnumC4183ed.COMMAND_UNSET_ACCOUNT.f15082a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, (ArrayList<String>) arrayList, str3);
            return;
        }
        AbstractC4022b.m13347a("Don't cancel account for " + C4100bb.m13880a(arrayList.toString(), 3) + " is unseted");
    }

    public static void setLocalNotificationType(Context context, int i2) {
        C4067u.m13627a(context).m13674b(i2 & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, EnumC4183ed.COMMAND_SET_ACCOUNT.f15082a, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > C2084a.f6136r;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return C4067u.m13627a(context).m13671a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(C4048b.m13476a(context).m13480a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m13462a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_SUBSCRIBE_TOPIC.f15082a, arrayList, 0L, null, null, null));
            return;
        }
        C4270hj c4270hj = new C4270hj();
        String m15941a = C4358aj.m15941a();
        c4270hj.m15461a(m15941a);
        c4270hj.m15465b(C4048b.m13476a(context).m13480a());
        c4270hj.m15467c(str);
        c4270hj.m15469d(context.getPackageName());
        c4270hj.m15471e(str2);
        AbstractC4022b.m13363e("cmd:" + EnumC4183ed.COMMAND_SUBSCRIBE_TOPIC + ", " + m15941a);
        C4067u.m13627a(context).m13659a((C4067u) c4270hj, EnumC4239gf.Subscription, (C4252gs) null);
    }

    @Deprecated
    public static void syncAssembleCOSPushToken(Context context) {
    }

    public static void syncAssembleFCMPushToken(Context context) {
        C4067u.m13627a(context).m13667a((String) null, EnumC4068v.UPLOAD_FCM_TOKEN, EnumC4050d.ASSEMBLE_PUSH_FCM, "");
    }

    @Deprecated
    public static void syncAssembleFTOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssemblePushToken(Context context) {
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        C4052f.m13551c(context);
        C4356ah.m15923a(context).m15931a();
        if (C4048b.m13476a(context).m13494b()) {
            C4272hl c4272hl = new C4272hl();
            c4272hl.m15493a(C4358aj.m15941a());
            c4272hl.m15498b(C4048b.m13476a(context).m13480a());
            c4272hl.m15501c(C4048b.m13476a(context).m13495c());
            c4272hl.m15505e(C4048b.m13476a(context).m13490b());
            c4272hl.m15503d(context.getPackageName());
            C4067u.m13627a(context).m13658a(c4272hl);
            PushMessageHandler.m13454a();
            PushMessageHandler.m13467b();
            C4048b.m13476a(context).m13491b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, EnumC4183ed.COMMAND_UNSET_ALIAS.f15082a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, EnumC4183ed.COMMAND_UNSET_ACCOUNT.f15082a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (C4048b.m13476a(context).m13494b()) {
            if (topicSubscribedTime(context, str) < 0) {
                AbstractC4022b.m13347a("Don't cancel subscribe for " + C4100bb.m13880a(str, 3) + " is unsubscribed");
                return;
            }
            C4274hn c4274hn = new C4274hn();
            String m15941a = C4358aj.m15941a();
            c4274hn.m15531a(m15941a);
            c4274hn.m15535b(C4048b.m13476a(context).m13480a());
            c4274hn.m15537c(str);
            c4274hn.m15539d(context.getPackageName());
            c4274hn.m15541e(str2);
            AbstractC4022b.m13363e("cmd:" + EnumC4183ed.COMMAND_UNSUBSCRIBE_TOPIC + ", " + m15941a);
            C4067u.m13627a(context).m13659a((C4067u) c4274hn, EnumC4239gf.UnSubscription, (C4252gs) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (C4300j.m15691d()) {
                    return;
                }
                if (C4287i.m15647c(MiPushClient.sContext) != null || C4085an.m13755a(MiPushClient.sContext).mo13737a()) {
                    C4265he c4265he = new C4265he();
                    c4265he.m15314b(C4048b.m13476a(MiPushClient.sContext).m13480a());
                    c4265he.m15318c(EnumC4249gp.ClientInfoUpdate.f15769a);
                    c4265he.m15301a(C4358aj.m15941a());
                    c4265he.m15303a(new HashMap());
                    String str = "";
                    String m15647c = C4287i.m15647c(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(m15647c)) {
                        str = "" + C4100bb.m13879a(m15647c);
                    }
                    String m15651e = C4287i.m15651e(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(m15651e)) {
                        str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + m15651e;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        c4265he.m15307a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    C4085an.m13755a(MiPushClient.sContext).m13758a(c4265he.m15307a());
                    int m15630a = C4287i.m15630a();
                    if (m15630a >= 0) {
                        c4265he.m15307a().put("space_id", Integer.toString(m15630a));
                    }
                    C4067u.m13627a(MiPushClient.sContext).m13661a((C4067u) c4265he, EnumC4239gf.Notification, false, (C4252gs) null);
                }
            }
        }).start();
    }

    public static void clearNotification(Context context, String str, String str2) {
        C4067u.m13627a(context).m13668a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            AbstractC4022b.m13344a(context.getApplicationContext());
            AbstractC4022b.m13363e("sdk_version = 5_9_9-C");
            C4085an.m13755a(context).m13757a();
            C4149cx.m14243a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.m13465a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.m13464a(iCallbackResult);
            }
            if (C4309r.m15720a(sContext)) {
                C4059m.m13576a(sContext);
            }
            boolean z = C4048b.m13476a(sContext).m13478a() != Constants.m13421a();
            if (!z && !shouldSendRegRequest(sContext)) {
                C4067u.m13627a(sContext).m13650a();
                AbstractC4022b.m13347a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !C4048b.m13476a(sContext).m13488a(str, str2) || C4048b.m13476a(sContext).m13502f()) {
                String m13878a = C4100bb.m13878a(6);
                C4048b.m13476a(sContext).m13481a();
                C4048b.m13476a(sContext).m13482a(Constants.m13421a());
                C4048b.m13476a(sContext).m13485a(str, str2, m13878a);
                MiTinyDataClient.C4041a.m13436a().m13445b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                C4266hf c4266hf = new C4266hf();
                c4266hf.m15342a(C4358aj.m15943b());
                c4266hf.m15349b(str);
                c4266hf.m15361e(str2);
                c4266hf.m15358d(sContext.getPackageName());
                c4266hf.m15364f(m13878a);
                c4266hf.m15354c(C4233g.m14931a(sContext, sContext.getPackageName()));
                c4266hf.m15348b(C4233g.m14925a(sContext, sContext.getPackageName()));
                c4266hf.m15370h(BuildConfig.VERSION_NAME);
                c4266hf.m15340a(BuildConfig.VERSION_CODE);
                c4266hf.m15341a(EnumC4253gt.Init);
                if (!TextUtils.isEmpty(str3)) {
                    c4266hf.m15367g(str3);
                }
                if (!C4300j.m15691d()) {
                    String m15650d = C4287i.m15650d(sContext);
                    if (!TextUtils.isEmpty(m15650d)) {
                        c4266hf.m15373i(C4100bb.m13879a(m15650d) + Constants.ACCEPT_TIME_SEPARATOR_SP + C4287i.m15652f(sContext));
                    }
                }
                int m15630a = C4287i.m15630a();
                if (m15630a >= 0) {
                    c4266hf.m15353c(m15630a);
                }
                C4067u.m13627a(sContext).m13657a(c4266hf, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, C4048b.m13476a(sContext).m13495c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(C4048b.m13476a(sContext).m13495c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_REGISTER.f15082a, arrayList, 0L, null, null, null));
                }
                C4067u.m13627a(sContext).m13650a();
                if (C4048b.m13476a(sContext).m13487a()) {
                    C4265he c4265he = new C4265he();
                    c4265he.m15314b(C4048b.m13476a(sContext).m13480a());
                    c4265he.m15318c(EnumC4249gp.ClientInfoUpdate.f15769a);
                    c4265he.m15301a(C4358aj.m15941a());
                    c4265he.f16034a = new HashMap();
                    c4265he.f16034a.put("app_version", C4233g.m14931a(sContext, sContext.getPackageName()));
                    c4265he.f16034a.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C4233g.m14925a(sContext, sContext.getPackageName())));
                    c4265he.f16034a.put("push_sdk_vn", BuildConfig.VERSION_NAME);
                    c4265he.f16034a.put("push_sdk_vc", Integer.toString(BuildConfig.VERSION_CODE));
                    String m13499e = C4048b.m13476a(sContext).m13499e();
                    if (!TextUtils.isEmpty(m13499e)) {
                        c4265he.f16034a.put("deviceid", m13499e);
                    }
                    C4067u.m13627a(sContext).m13661a((C4067u) c4265he, EnumC4239gf.Notification, false, (C4252gs) null);
                    C4067u.m13627a(sContext).m13654a(sContext);
                }
                if (!AbstractC4302l.m15698a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    AbstractC4302l.m15696a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    C4265he c4265he2 = new C4265he();
                    c4265he2.m15314b(C4048b.m13476a(sContext).m13480a());
                    c4265he2.m15318c(EnumC4249gp.PullOfflineMessage.f15769a);
                    c4265he2.m15301a(C4358aj.m15941a());
                    c4265he2.m15304a(false);
                    C4067u.m13627a(sContext).m13662a((C4067u) c4265he2, EnumC4239gf.Notification, false, (C4252gs) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            C4069w.m13681a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                AbstractC4022b.m13340a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            AbstractC4022b.m13351a(th);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        C4252gs c4252gs = new C4252gs();
        c4252gs.m15094a(miPushMessage.getMessageId());
        c4252gs.m15105b(miPushMessage.getTopic());
        c4252gs.m15117d(miPushMessage.getDescription());
        c4252gs.m15113c(miPushMessage.getTitle());
        c4252gs.m15112c(miPushMessage.getNotifyId());
        c4252gs.m15093a(miPushMessage.getNotifyType());
        c4252gs.m15104b(miPushMessage.getPassThrough());
        c4252gs.m15095a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), c4252gs, null);
    }

    public static void clearNotification(Context context) {
        C4067u.m13627a(context).m13651a(-1);
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, C3397d.f11892R);
        checkNotNull(str, C2085b.f6180u);
        checkNotNull(str2, "appToken");
        sContext = context.getApplicationContext();
        if (sContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        C4309r.m15718a(context2);
        if (!NetworkStatusReceiver.m16226a()) {
            registerNetworkReceiver(sContext);
        }
        C4051e.m13518a(sContext).m13523a(pushConfiguration);
        C4076ae.m13698a(context2).m13703a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    static void reportMessageClicked(Context context, String str, C4252gs c4252gs, String str2) {
        C4265he c4265he = new C4265he();
        if (TextUtils.isEmpty(str2)) {
            if (C4048b.m13476a(context).m13494b()) {
                c4265he.m15314b(C4048b.m13476a(context).m13480a());
            } else {
                AbstractC4022b.m13361d("do not report clicked message");
                return;
            }
        } else {
            c4265he.m15314b(str2);
        }
        c4265he.m15318c("bar:click");
        c4265he.m15301a(str);
        c4265he.m15304a(false);
        C4067u.m13627a(context).m13661a((C4067u) c4265he, EnumC4239gf.Notification, false, c4252gs);
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(C4048b.m13476a(context).m13480a())) {
            return;
        }
        C4259gz c4259gz = new C4259gz();
        String m15941a = C4358aj.m15941a();
        c4259gz.m15218a(m15941a);
        c4259gz.m15225b(C4048b.m13476a(context).m13480a());
        c4259gz.m15228c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            c4259gz.m15221a(it.next());
        }
        c4259gz.m15233e(str2);
        c4259gz.m15231d(context.getPackageName());
        AbstractC4022b.m13363e("cmd:" + str + ", " + m15941a);
        C4067u.m13627a(context).m13659a((C4067u) c4259gz, EnumC4239gf.Command, (C4252gs) null);
    }
}
