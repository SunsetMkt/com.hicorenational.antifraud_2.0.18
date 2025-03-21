package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengMessageService;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushApi;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.component.UmengIntentService;
import com.umeng.message.component.UmengMessageHandlerService;
import com.umeng.message.tag.TagManager;
import com.umeng.p221ut.device.UTDevice;

/* renamed from: com.umeng.message.proguard.u */
/* loaded from: classes2.dex */
public final class C3601u implements UPushApi {

    /* renamed from: a */
    private boolean f13363a;

    /* renamed from: b */
    private boolean f13364b;

    /* renamed from: c */
    private boolean f13365c;

    /* renamed from: d */
    private boolean f13366d;

    /* renamed from: e */
    private volatile UPushRegisterCallback f13367e;

    /* renamed from: f */
    private volatile UPushThirdTokenCallback f13368f;

    /* renamed from: g */
    private volatile UPushSettingCallback f13369g;

    /* renamed from: h */
    private volatile UPushMessageHandler f13370h;

    /* renamed from: i */
    private volatile UPushMessageHandler f13371i;

    /* renamed from: com.umeng.message.proguard.u$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C3605y.m12463a().m12473b();
        }
    }

    /* renamed from: com.umeng.message.proguard.u$2 */
    final class AnonymousClass2 implements IProcessName {

        /* renamed from: a */
        final /* synthetic */ String f13373a;

        AnonymousClass2(String str) {
            r2 = str;
        }

        @Override // com.taobao.accs.IProcessName
        public final String getCurrProcessName() {
            return r2;
        }
    }

    /* renamed from: com.umeng.message.proguard.u$3 */
    final class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f13375a;

        /* renamed from: b */
        final /* synthetic */ String f13376b;

        /* renamed from: c */
        final /* synthetic */ String f13377c;

        /* renamed from: com.umeng.message.proguard.u$3$1 */
        final class AnonymousClass1 extends IRegister {
            AnonymousClass1() {
            }

            @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
            public final void onFailure(String str, String str2) {
                UPLog.m12144e("Impl", "register failed! code:", str, "desc:", str2);
                Application m12460a = C3604x.m12460a();
                Intent intent = new Intent("com.umeng.message.action");
                intent.setPackage(m12460a.getPackageName());
                intent.setClass(m12460a, UmengMessageHandlerService.class);
                intent.putExtra("um_command", "register");
                intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                intent.putExtra("code", str);
                intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
                UMLog.m11549aq(C3553ab.f13148a, 0, "\\|");
            }

            @Override // com.taobao.agoo.IRegister
            public final void onSuccess(String str) {
                UPLog.m12145i("Impl", "register success. deviceToken:", str);
                Application m12460a = C3604x.m12460a();
                Intent intent = new Intent("com.umeng.message.action");
                intent.setPackage(m12460a.getPackageName());
                intent.setClass(m12460a, UmengMessageHandlerService.class);
                intent.putExtra("um_command", "register");
                intent.putExtra("registration_id", str);
                intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
            }
        }

        AnonymousClass3(Context context, String str, String str2) {
            r2 = context;
            r3 = str;
            r4 = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                TaobaoRegister.register(r2, AccsClientConfig.DEFAULT_CONFIGTAG, "umeng:" + r3, r4, "android@umeng", new IRegister() { // from class: com.umeng.message.proguard.u.3.1
                    AnonymousClass1() {
                    }

                    @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
                    public final void onFailure(String str, String str2) {
                        UPLog.m12144e("Impl", "register failed! code:", str, "desc:", str2);
                        Application m12460a = C3604x.m12460a();
                        Intent intent = new Intent("com.umeng.message.action");
                        intent.setPackage(m12460a.getPackageName());
                        intent.setClass(m12460a, UmengMessageHandlerService.class);
                        intent.putExtra("um_command", "register");
                        intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                        intent.putExtra("code", str);
                        intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                        AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
                        UMLog.m11549aq(C3553ab.f13148a, 0, "\\|");
                    }

                    @Override // com.taobao.agoo.IRegister
                    public final void onSuccess(String str) {
                        UPLog.m12145i("Impl", "register success. deviceToken:", str);
                        Application m12460a = C3604x.m12460a();
                        Intent intent = new Intent("com.umeng.message.action");
                        intent.setPackage(m12460a.getPackageName());
                        intent.setClass(m12460a, UmengMessageHandlerService.class);
                        intent.putExtra("um_command", "register");
                        intent.putExtra("registration_id", str);
                        intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                        AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
                    }
                });
            } catch (Throwable th) {
                UPLog.m12143e("Impl", th);
            }
        }
    }

    /* renamed from: com.umeng.message.proguard.u$4 */
    final class AnonymousClass4 extends ICallback {

        /* renamed from: a */
        final /* synthetic */ Context f13380a;

        AnonymousClass4(Context context) {
            r2 = context;
        }

        @Override // com.taobao.agoo.ICallback
        public final void onFailure(String str, String str2) {
            UPLog.m12142d("Impl", "push enable failed. code:", str, "desc:", str2);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(r2.getPackageName());
            intent.setClass(r2, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "enable");
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
            intent.putExtra("code", str);
            intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
            AbstractServiceC3597q.enqueueWork(r2, UmengMessageHandlerService.class, intent);
        }

        @Override // com.taobao.agoo.ICallback
        public final void onSuccess() {
            UPLog.m12142d("Impl", "push enable success.");
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(r2.getPackageName());
            intent.setClass(r2, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "enable");
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
            AbstractServiceC3597q.enqueueWork(r2, UmengMessageHandlerService.class, intent);
        }
    }

    /* renamed from: com.umeng.message.proguard.u$5 */
    final class AnonymousClass5 extends ICallback {

        /* renamed from: a */
        final /* synthetic */ Context f13382a;

        AnonymousClass5(Context context) {
            r2 = context;
        }

        @Override // com.taobao.agoo.ICallback
        public final void onFailure(String str, String str2) {
            UPLog.m12144e("Impl", "push disable failed. code:", str, "desc:", str2);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(r2.getPackageName());
            intent.setClass(r2, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "disable");
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
            intent.putExtra("code", str);
            intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
            AbstractServiceC3597q.enqueueWork(r2, UmengMessageHandlerService.class, intent);
        }

        @Override // com.taobao.agoo.ICallback
        public final void onSuccess() {
            UPLog.m12145i("Impl", "push disable success.");
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(r2.getPackageName());
            intent.setClass(r2, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "disable");
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
            AbstractServiceC3597q.enqueueWork(r2, UmengMessageHandlerService.class, intent);
        }
    }

    /* renamed from: com.umeng.message.proguard.u$a */
    static class a {

        /* renamed from: a */
        private static final C3601u f13384a = new C3601u((byte) 0);
    }

    /* synthetic */ C3601u(byte b2) {
        this();
    }

    /* renamed from: a */
    public static UPushApi m12450a() {
        return a.f13384a;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void addAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().addAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void deleteAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().deleteAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void disable(UPushSettingCallback uPushSettingCallback) {
        setSettingCallback(uPushSettingCallback);
        try {
            Application m12460a = C3604x.m12460a();
            TaobaoRegister.unbindAgoo(m12460a, new ICallback() { // from class: com.umeng.message.proguard.u.5

                /* renamed from: a */
                final /* synthetic */ Context f13382a;

                AnonymousClass5(Context m12460a2) {
                    r2 = m12460a2;
                }

                @Override // com.taobao.agoo.ICallback
                public final void onFailure(String str, String str2) {
                    UPLog.m12144e("Impl", "push disable failed. code:", str, "desc:", str2);
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(r2.getPackageName());
                    intent.setClass(r2, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "disable");
                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                    intent.putExtra("code", str);
                    intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                    AbstractServiceC3597q.enqueueWork(r2, UmengMessageHandlerService.class, intent);
                }

                @Override // com.taobao.agoo.ICallback
                public final void onSuccess() {
                    UPLog.m12145i("Impl", "push disable success.");
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(r2.getPackageName());
                    intent.setClass(r2, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "disable");
                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                    AbstractServiceC3597q.enqueueWork(r2, UmengMessageHandlerService.class, intent);
                }
            });
        } catch (Exception e2) {
            UPLog.m12143e("Impl", e2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void enable(UPushSettingCallback uPushSettingCallback) {
        setSettingCallback(uPushSettingCallback);
        try {
            Application m12460a = C3604x.m12460a();
            TaobaoRegister.bindAgoo(m12460a, new ICallback() { // from class: com.umeng.message.proguard.u.4

                /* renamed from: a */
                final /* synthetic */ Context f13380a;

                AnonymousClass4(Context m12460a2) {
                    r2 = m12460a2;
                }

                @Override // com.taobao.agoo.ICallback
                public final void onFailure(String str, String str2) {
                    UPLog.m12142d("Impl", "push enable failed. code:", str, "desc:", str2);
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(r2.getPackageName());
                    intent.setClass(r2, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "enable");
                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                    intent.putExtra("code", str);
                    intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                    AbstractServiceC3597q.enqueueWork(r2, UmengMessageHandlerService.class, intent);
                }

                @Override // com.taobao.agoo.ICallback
                public final void onSuccess() {
                    UPLog.m12142d("Impl", "push enable success.");
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(r2.getPackageName());
                    intent.setClass(r2, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "enable");
                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                    AbstractServiceC3597q.enqueueWork(r2, UmengMessageHandlerService.class, intent);
                }
            });
        } catch (Exception e2) {
            UPLog.m12143e("Impl", e2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getDisplayNotificationNumber() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).m12120b();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageAppkey() {
        Application m12460a = C3604x.m12460a();
        String appkey = UMUtils.getAppkey(m12460a);
        if (!TextUtils.isEmpty(appkey)) {
            return appkey;
        }
        String m12122c = MessageSharedPrefs.getInstance(m12460a).m12122c();
        return !TextUtils.isEmpty(m12122c) ? m12122c : C3584d.m12346a((Context) m12460a, "UMENG_APPKEY");
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageChannel() {
        Application m12460a = C3604x.m12460a();
        String channel = UMUtils.getChannel(m12460a);
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        String m12290b = MessageSharedPrefs.getInstance(m12460a).f13043b.m12290b("channel", "");
        return !TextUtils.isEmpty(m12290b) ? m12290b : C3584d.m12370n(m12460a);
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageHandler getMessageHandler() {
        if (this.f13370h == null) {
            this.f13370h = new UmengMessageHandler();
        }
        return this.f13370h;
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageNotifyApi getMessageNotifyApi() {
        return C3561aj.m12251a();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageSecret() {
        Application m12460a = C3604x.m12460a();
        String m12290b = MessageSharedPrefs.getInstance(m12460a).f13043b.m12290b("message_secret", "");
        return !TextUtils.isEmpty(m12290b) ? m12290b : C3584d.m12346a((Context) m12460a, "UMENG_MESSAGE_SECRET");
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getMuteDurationSeconds() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).m12127g();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbEndHour() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12288b("end_hour", 7);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbEndMinute() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12288b("end_minute", 0);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbStartHour() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12288b("start_hour", 23);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbStartMinute() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12288b("start_minute", 0);
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getNotificationChannelName() {
        String m12290b = MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12290b("notification_channel_default", "");
        return TextUtils.isEmpty(m12290b) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME : m12290b;
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageHandler getNotificationClickHandler() {
        if (this.f13371i == null) {
            this.f13371i = new UmengNotificationClickHandler();
        }
        return this.f13371i;
    }

    @Override // com.umeng.message.api.UPushApi
    public final boolean getNotificationOnForeground() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12292b("notification_foreground_show", true);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlayLights() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).m12129i();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlaySound() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).m12130j();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlayVibrate() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).m12128h();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getNotificationSilenceChannelName() {
        String m12290b = MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12290b("notification_channel_silence", "");
        return TextUtils.isEmpty(m12290b) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_SILENCE_CHANNEL_NAME : m12290b;
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getPushIntentServiceClass() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).m12125e();
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushRegisterCallback getRegisterCallback() {
        return this.f13367e;
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getRegistrationId() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).m12131k();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getResourcePackageName() {
        return MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12290b("res_pkg", "");
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushSettingCallback getSettingCallback() {
        return this.f13369g;
    }

    @Override // com.umeng.message.api.UPushApi
    public final TagManager getTagManager() {
        return TagManager.getInstance();
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushThirdTokenCallback getThirdTokenCallback() {
        return this.f13368f;
    }

    @Override // com.umeng.message.api.UPushApi
    public final boolean isPushCheck() {
        return this.f13366d;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void keepLowPowerMode(boolean z) {
        this.f13363a = !z;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void onAppStart() {
        C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.u.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                C3605y.m12463a().m12473b();
            }
        });
    }

    @Override // com.umeng.message.api.UPushApi
    public final void register(UPushRegisterCallback uPushRegisterCallback) {
        setRegisterCallback(uPushRegisterCallback);
        try {
            if (Build.VERSION.SDK_INT < 14) {
                UPLog.m12144e("Impl", "U-Push min support Android 4.0!");
                return;
            }
            Application m12460a = C3604x.m12460a();
            if (isPushCheck() && !C3591k.m12420a(m12460a)) {
                UPLog.m12144e("Impl", "AndroidManifest config error!");
                return;
            }
            String messageAppkey = getMessageAppkey();
            String messageSecret = getMessageSecret();
            if (!TextUtils.isEmpty(messageAppkey) && !TextUtils.isEmpty(messageSecret)) {
                if (C3586f.m12389b()) {
                    UPLog.m12144e("Impl", "init failed. silent mode!");
                    return;
                }
                C3586f.m12384a(m12460a, (Class<?>) UmengMessageHandlerService.class);
                AwcnConfig.setAccsSessionCreateForbiddenInBg(false);
                AwcnConfig.setWifiInfoEnable(false);
                AmdcRuntimeInfo.setForceHttps(true);
                String m12381a = C3586f.m12381a(m12460a);
                GlobalConfig.setCurrProcessNameImpl(new IProcessName() { // from class: com.umeng.message.proguard.u.2

                    /* renamed from: a */
                    final /* synthetic */ String f13373a;

                    AnonymousClass2(String m12381a2) {
                        r2 = m12381a2;
                    }

                    @Override // com.taobao.accs.IProcessName
                    public final String getCurrProcessName() {
                        return r2;
                    }
                });
                GlobalAppRuntimeInfo.setCurrentProcess(m12381a2);
                AccsClientConfig.Builder builder = new AccsClientConfig.Builder();
                builder.setAppKey("umeng:".concat(String.valueOf(messageAppkey))).setAppSecret(messageSecret).setKeepAlive(this.f13363a).setDisableChannel(true).setAutoUnit(false).setTag(AccsClientConfig.DEFAULT_CONFIGTAG).setPullUpEnable(this.f13364b).setAccsHeartbeatEnable(this.f13365c);
                ACCSClient.setEnvironment(m12460a, 0);
                builder.setConfigEnv(0);
                builder.setInappHost("umengacs.m.taobao.com");
                builder.setInappPubKey(11);
                builder.setChannelHost("umengjmacs.m.taobao.com");
                builder.setChannelPubKey(11);
                ACCSClient.init(m12460a, builder.build());
                AmdcRuntimeInfo.setParam("deviceId", UTDevice.getUtdid(m12460a));
                DispatchConstants.setAmdcServerDomain(new String[]{"amdcopen.m.umeng.com", "amdc.wapa.taobao.com", "amdc.taobao.net"});
                DispatchConstants.setAmdcServerFixIp(new String[][]{new String[]{"59.82.113.219", "59.82.113.35"}, null, null});
                TaobaoRegister.setAgooMsgReceiveService(UmengIntentService.class.getName());
                C3600t.m12440a();
                C3600t.m12443b();
                UPLog.m12145i("Impl", "appkey:", messageAppkey, "appSecret:", messageSecret);
                C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.u.3

                    /* renamed from: a */
                    final /* synthetic */ Context f13375a;

                    /* renamed from: b */
                    final /* synthetic */ String f13376b;

                    /* renamed from: c */
                    final /* synthetic */ String f13377c;

                    /* renamed from: com.umeng.message.proguard.u$3$1 */
                    final class AnonymousClass1 extends IRegister {
                        AnonymousClass1() {
                        }

                        @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
                        public final void onFailure(String str, String str2) {
                            UPLog.m12144e("Impl", "register failed! code:", str, "desc:", str2);
                            Application m12460a = C3604x.m12460a();
                            Intent intent = new Intent("com.umeng.message.action");
                            intent.setPackage(m12460a.getPackageName());
                            intent.setClass(m12460a, UmengMessageHandlerService.class);
                            intent.putExtra("um_command", "register");
                            intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                            intent.putExtra("code", str);
                            intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                            AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
                            UMLog.m11549aq(C3553ab.f13148a, 0, "\\|");
                        }

                        @Override // com.taobao.agoo.IRegister
                        public final void onSuccess(String str) {
                            UPLog.m12145i("Impl", "register success. deviceToken:", str);
                            Application m12460a = C3604x.m12460a();
                            Intent intent = new Intent("com.umeng.message.action");
                            intent.setPackage(m12460a.getPackageName());
                            intent.setClass(m12460a, UmengMessageHandlerService.class);
                            intent.putExtra("um_command", "register");
                            intent.putExtra("registration_id", str);
                            intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                            AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
                        }
                    }

                    AnonymousClass3(Context m12460a2, String messageAppkey2, String messageSecret2) {
                        r2 = m12460a2;
                        r3 = messageAppkey2;
                        r4 = messageSecret2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            TaobaoRegister.register(r2, AccsClientConfig.DEFAULT_CONFIGTAG, "umeng:" + r3, r4, "android@umeng", new IRegister() { // from class: com.umeng.message.proguard.u.3.1
                                AnonymousClass1() {
                                }

                                @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
                                public final void onFailure(String str, String str2) {
                                    UPLog.m12144e("Impl", "register failed! code:", str, "desc:", str2);
                                    Application m12460a2 = C3604x.m12460a();
                                    Intent intent = new Intent("com.umeng.message.action");
                                    intent.setPackage(m12460a2.getPackageName());
                                    intent.setClass(m12460a2, UmengMessageHandlerService.class);
                                    intent.putExtra("um_command", "register");
                                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                                    intent.putExtra("code", str);
                                    intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                                    AbstractServiceC3597q.enqueueWork(m12460a2, UmengMessageHandlerService.class, intent);
                                    UMLog.m11549aq(C3553ab.f13148a, 0, "\\|");
                                }

                                @Override // com.taobao.agoo.IRegister
                                public final void onSuccess(String str) {
                                    UPLog.m12145i("Impl", "register success. deviceToken:", str);
                                    Application m12460a2 = C3604x.m12460a();
                                    Intent intent = new Intent("com.umeng.message.action");
                                    intent.setPackage(m12460a2.getPackageName());
                                    intent.setClass(m12460a2, UmengMessageHandlerService.class);
                                    intent.putExtra("um_command", "register");
                                    intent.putExtra("registration_id", str);
                                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                                    AbstractServiceC3597q.enqueueWork(m12460a2, UmengMessageHandlerService.class, intent);
                                }
                            });
                        } catch (Throwable th) {
                            UPLog.m12143e("Impl", th);
                        }
                    }
                });
                if (C3586f.m12390b(m12460a2)) {
                    C3589i.m12408a();
                    UPLog.upload();
                }
                C3561aj.m12251a().m12254b();
                return;
            }
            UPLog.m12144e("Impl", "Appkey、MessageSecret cannot be empty!");
        } catch (Throwable th) {
            UPLog.m12143e("Impl", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setAccsHeartbeatEnable(boolean z) {
        this.f13365c = z;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().setAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setDisplayNotificationNumber(int i2) {
        if (!C3586f.m12390b(C3604x.m12460a()) || i2 < 0 || i2 > 10) {
            return;
        }
        MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12283a("notification_number", i2);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableAlarmHeartbeat(boolean z) {
        try {
            GlobalConfig.setAlarmHeartbeatEnable(z);
        } catch (Throwable th) {
            UPLog.m12143e("Impl", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableForeground(boolean z) {
        try {
            GlobalConfig.setEnableForeground(C3604x.m12460a(), z);
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableJobHeartbeat(boolean z) {
        try {
            GlobalConfig.setJobHeartbeatEnable(z);
        } catch (Throwable th) {
            UPLog.m12143e("Impl", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setMessageHandler(UPushMessageHandler uPushMessageHandler) {
        this.f13370h = uPushMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setMuteDurationSeconds(int i2) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs.getInstance(m12460a).f13043b.m12283a("mute_duration", i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNoDisturbMode(int i2, int i3, int i4, int i5) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
            messageSharedPrefs.f13043b.m12283a("start_hour", i2);
            messageSharedPrefs.f13043b.m12283a("start_minute", i3);
            messageSharedPrefs.f13043b.m12283a("end_hour", i4);
            messageSharedPrefs.f13043b.m12283a("end_minute", i5);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationChannelName(String str) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs.getInstance(m12460a).f13043b.m12285a("notification_channel_default", str);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler) {
        this.f13371i = uPushMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationOnForeground(boolean z) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs.getInstance(m12460a).f13043b.m12287a("notification_foreground_show", z);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlayLights(int i2) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs.getInstance(m12460a).f13043b.m12283a("notification_light", i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlaySound(int i2) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs.getInstance(m12460a).f13043b.m12283a("notification_sound", i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlayVibrate(int i2) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs.getInstance(m12460a).f13043b.m12283a("notification_vibrate", i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationSilenceChannelName(String str) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs.getInstance(m12460a).f13043b.m12285a("notification_channel_silence", str);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setPullUpEnable(boolean z) {
        this.f13364b = z;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setPushCheck(boolean z) {
        this.f13366d = z;
    }

    @Override // com.umeng.message.api.UPushApi
    public final <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
            if (cls == null) {
                messageSharedPrefs.f13043b.m12282a("service_class");
            } else {
                messageSharedPrefs.f13043b.m12285a("service_class", cls.getName());
            }
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback) {
        this.f13367e = uPushRegisterCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setResourcePackageName(String str) {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            MessageSharedPrefs.getInstance(m12460a).f13043b.m12285a("res_pkg", str);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setSettingCallback(UPushSettingCallback uPushSettingCallback) {
        this.f13369g = uPushSettingCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setThirdTokenCallback(UPushThirdTokenCallback uPushThirdTokenCallback) {
        this.f13368f = uPushThirdTokenCallback;
    }

    private C3601u() {
        this.f13363a = true;
    }
}
