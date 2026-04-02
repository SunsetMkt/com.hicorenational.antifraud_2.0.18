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
import com.umeng.ut.device.UTDevice;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements UPushApi {
    private boolean a;

    /* JADX INFO: renamed from: b */
    private boolean f8095b;

    /* JADX INFO: renamed from: c */
    private boolean f8096c;

    /* JADX INFO: renamed from: d */
    private boolean f8097d;

    /* JADX INFO: renamed from: e */
    private volatile UPushRegisterCallback f8098e;

    /* JADX INFO: renamed from: f */
    private volatile UPushThirdTokenCallback f8099f;

    /* JADX INFO: renamed from: g */
    private volatile UPushSettingCallback f8100g;

    /* JADX INFO: renamed from: h */
    private volatile UPushMessageHandler f8101h;

    /* JADX INFO: renamed from: i */
    private volatile UPushMessageHandler f8102i;

    /* JADX INFO: renamed from: com.umeng.message.proguard.u$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y.a().b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.u$2 */
    final class AnonymousClass2 implements IProcessName {
        final /* synthetic */ String a;

        AnonymousClass2(String str) {
            str = str;
        }

        @Override // com.taobao.accs.IProcessName
        public final String getCurrProcessName() {
            return str;
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.u$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f8104b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ String f8105c;

        /* JADX INFO: renamed from: com.umeng.message.proguard.u$3$1 */
        final class AnonymousClass1 extends IRegister {
            AnonymousClass1() {
            }

            @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
            public final void onFailure(String str, String str2) {
                UPLog.e("Impl", "register failed! code:", str, "desc:", str2);
                Application applicationA = x.a();
                Intent intent = new Intent("com.umeng.message.action");
                intent.setPackage(applicationA.getPackageName());
                intent.setClass(applicationA, UmengMessageHandlerService.class);
                intent.putExtra("um_command", "register");
                intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                intent.putExtra("code", str);
                intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                q.enqueueWork(applicationA, UmengMessageHandlerService.class, intent);
                UMLog.aq(ab.a, 0, "\\|");
            }

            @Override // com.taobao.agoo.IRegister
            public final void onSuccess(String str) {
                UPLog.i("Impl", "register success. deviceToken:", str);
                Application applicationA = x.a();
                Intent intent = new Intent("com.umeng.message.action");
                intent.setPackage(applicationA.getPackageName());
                intent.setClass(applicationA, UmengMessageHandlerService.class);
                intent.putExtra("um_command", "register");
                intent.putExtra("registration_id", str);
                intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                q.enqueueWork(applicationA, UmengMessageHandlerService.class, intent);
            }
        }

        AnonymousClass3(Context context, String str, String str2) {
            context = context;
            str = str;
            str = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                TaobaoRegister.register(context, AccsClientConfig.DEFAULT_CONFIGTAG, "umeng:" + str, str, "android@umeng", new IRegister() { // from class: com.umeng.message.proguard.u.3.1
                    AnonymousClass1() {
                    }

                    @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
                    public final void onFailure(String str, String str2) {
                        UPLog.e("Impl", "register failed! code:", str, "desc:", str2);
                        Application applicationA = x.a();
                        Intent intent = new Intent("com.umeng.message.action");
                        intent.setPackage(applicationA.getPackageName());
                        intent.setClass(applicationA, UmengMessageHandlerService.class);
                        intent.putExtra("um_command", "register");
                        intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                        intent.putExtra("code", str);
                        intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                        q.enqueueWork(applicationA, UmengMessageHandlerService.class, intent);
                        UMLog.aq(ab.a, 0, "\\|");
                    }

                    @Override // com.taobao.agoo.IRegister
                    public final void onSuccess(String str) {
                        UPLog.i("Impl", "register success. deviceToken:", str);
                        Application applicationA = x.a();
                        Intent intent = new Intent("com.umeng.message.action");
                        intent.setPackage(applicationA.getPackageName());
                        intent.setClass(applicationA, UmengMessageHandlerService.class);
                        intent.putExtra("um_command", "register");
                        intent.putExtra("registration_id", str);
                        intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                        q.enqueueWork(applicationA, UmengMessageHandlerService.class, intent);
                    }
                });
            } catch (Throwable th) {
                UPLog.e("Impl", th);
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.u$4 */
    final class AnonymousClass4 extends ICallback {
        final /* synthetic */ Context a;

        AnonymousClass4(Context context) {
            context = context;
        }

        @Override // com.taobao.agoo.ICallback
        public final void onFailure(String str, String str2) {
            UPLog.d("Impl", "push enable failed. code:", str, "desc:", str2);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(context.getPackageName());
            intent.setClass(context, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "enable");
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
            intent.putExtra("code", str);
            intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
            q.enqueueWork(context, UmengMessageHandlerService.class, intent);
        }

        @Override // com.taobao.agoo.ICallback
        public final void onSuccess() {
            UPLog.d("Impl", "push enable success.");
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(context.getPackageName());
            intent.setClass(context, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "enable");
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
            q.enqueueWork(context, UmengMessageHandlerService.class, intent);
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.u$5 */
    final class AnonymousClass5 extends ICallback {
        final /* synthetic */ Context a;

        AnonymousClass5(Context context) {
            context = context;
        }

        @Override // com.taobao.agoo.ICallback
        public final void onFailure(String str, String str2) {
            UPLog.e("Impl", "push disable failed. code:", str, "desc:", str2);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(context.getPackageName());
            intent.setClass(context, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "disable");
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
            intent.putExtra("code", str);
            intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
            q.enqueueWork(context, UmengMessageHandlerService.class, intent);
        }

        @Override // com.taobao.agoo.ICallback
        public final void onSuccess() {
            UPLog.i("Impl", "push disable success.");
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(context.getPackageName());
            intent.setClass(context, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "disable");
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
            q.enqueueWork(context, UmengMessageHandlerService.class, intent);
        }
    }

    static class a {
        private static final u a = new u((byte) 0);
    }

    /* synthetic */ u(byte b2) {
        this();
    }

    public static UPushApi a() {
        return a.a;
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
            Application applicationA = x.a();
            TaobaoRegister.unbindAgoo(applicationA, new ICallback() { // from class: com.umeng.message.proguard.u.5
                final /* synthetic */ Context a;

                AnonymousClass5(Context applicationA2) {
                    context = applicationA2;
                }

                @Override // com.taobao.agoo.ICallback
                public final void onFailure(String str, String str2) {
                    UPLog.e("Impl", "push disable failed. code:", str, "desc:", str2);
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(context.getPackageName());
                    intent.setClass(context, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "disable");
                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                    intent.putExtra("code", str);
                    intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                    q.enqueueWork(context, UmengMessageHandlerService.class, intent);
                }

                @Override // com.taobao.agoo.ICallback
                public final void onSuccess() {
                    UPLog.i("Impl", "push disable success.");
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(context.getPackageName());
                    intent.setClass(context, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "disable");
                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                    q.enqueueWork(context, UmengMessageHandlerService.class, intent);
                }
            });
        } catch (Exception e2) {
            UPLog.e("Impl", e2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void enable(UPushSettingCallback uPushSettingCallback) {
        setSettingCallback(uPushSettingCallback);
        try {
            Application applicationA = x.a();
            TaobaoRegister.bindAgoo(applicationA, new ICallback() { // from class: com.umeng.message.proguard.u.4
                final /* synthetic */ Context a;

                AnonymousClass4(Context applicationA2) {
                    context = applicationA2;
                }

                @Override // com.taobao.agoo.ICallback
                public final void onFailure(String str, String str2) {
                    UPLog.d("Impl", "push enable failed. code:", str, "desc:", str2);
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(context.getPackageName());
                    intent.setClass(context, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "enable");
                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                    intent.putExtra("code", str);
                    intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                    q.enqueueWork(context, UmengMessageHandlerService.class, intent);
                }

                @Override // com.taobao.agoo.ICallback
                public final void onSuccess() {
                    UPLog.d("Impl", "push enable success.");
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(context.getPackageName());
                    intent.setClass(context, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "enable");
                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                    q.enqueueWork(context, UmengMessageHandlerService.class, intent);
                }
            });
        } catch (Exception e2) {
            UPLog.e("Impl", e2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getDisplayNotificationNumber() {
        return MessageSharedPrefs.getInstance(x.a()).b();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageAppkey() {
        Application applicationA = x.a();
        String appkey = UMUtils.getAppkey(applicationA);
        if (!TextUtils.isEmpty(appkey)) {
            return appkey;
        }
        String strC = MessageSharedPrefs.getInstance(applicationA).c();
        return !TextUtils.isEmpty(strC) ? strC : d.a((Context) applicationA, "UMENG_APPKEY");
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageChannel() {
        Application applicationA = x.a();
        String channel = UMUtils.getChannel(applicationA);
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        String strB = MessageSharedPrefs.getInstance(applicationA).f7878b.b("channel", "");
        return !TextUtils.isEmpty(strB) ? strB : d.n(applicationA);
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageHandler getMessageHandler() {
        if (this.f8101h == null) {
            this.f8101h = new UmengMessageHandler();
        }
        return this.f8101h;
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageNotifyApi getMessageNotifyApi() {
        return aj.a();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageSecret() {
        Application applicationA = x.a();
        String strB = MessageSharedPrefs.getInstance(applicationA).f7878b.b("message_secret", "");
        return !TextUtils.isEmpty(strB) ? strB : d.a((Context) applicationA, "UMENG_MESSAGE_SECRET");
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getMuteDurationSeconds() {
        return MessageSharedPrefs.getInstance(x.a()).g();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbEndHour() {
        return MessageSharedPrefs.getInstance(x.a()).f7878b.b("end_hour", 7);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbEndMinute() {
        return MessageSharedPrefs.getInstance(x.a()).f7878b.b("end_minute", 0);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbStartHour() {
        return MessageSharedPrefs.getInstance(x.a()).f7878b.b("start_hour", 23);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbStartMinute() {
        return MessageSharedPrefs.getInstance(x.a()).f7878b.b("start_minute", 0);
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getNotificationChannelName() {
        String strB = MessageSharedPrefs.getInstance(x.a()).f7878b.b("notification_channel_default", "");
        return TextUtils.isEmpty(strB) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME : strB;
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageHandler getNotificationClickHandler() {
        if (this.f8102i == null) {
            this.f8102i = new UmengNotificationClickHandler();
        }
        return this.f8102i;
    }

    @Override // com.umeng.message.api.UPushApi
    public final boolean getNotificationOnForeground() {
        return MessageSharedPrefs.getInstance(x.a()).f7878b.b("notification_foreground_show", true);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlayLights() {
        return MessageSharedPrefs.getInstance(x.a()).i();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlaySound() {
        return MessageSharedPrefs.getInstance(x.a()).j();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlayVibrate() {
        return MessageSharedPrefs.getInstance(x.a()).h();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getNotificationSilenceChannelName() {
        String strB = MessageSharedPrefs.getInstance(x.a()).f7878b.b("notification_channel_silence", "");
        return TextUtils.isEmpty(strB) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_SILENCE_CHANNEL_NAME : strB;
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getPushIntentServiceClass() {
        return MessageSharedPrefs.getInstance(x.a()).e();
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushRegisterCallback getRegisterCallback() {
        return this.f8098e;
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getRegistrationId() {
        return MessageSharedPrefs.getInstance(x.a()).k();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getResourcePackageName() {
        return MessageSharedPrefs.getInstance(x.a()).f7878b.b("res_pkg", "");
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushSettingCallback getSettingCallback() {
        return this.f8100g;
    }

    @Override // com.umeng.message.api.UPushApi
    public final TagManager getTagManager() {
        return TagManager.getInstance();
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushThirdTokenCallback getThirdTokenCallback() {
        return this.f8099f;
    }

    @Override // com.umeng.message.api.UPushApi
    public final boolean isPushCheck() {
        return this.f8097d;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void keepLowPowerMode(boolean z) {
        this.a = !z;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void onAppStart() {
        b.b(new Runnable() { // from class: com.umeng.message.proguard.u.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                y.a().b();
            }
        });
    }

    @Override // com.umeng.message.api.UPushApi
    public final void register(UPushRegisterCallback uPushRegisterCallback) {
        setRegisterCallback(uPushRegisterCallback);
        try {
            if (Build.VERSION.SDK_INT < 14) {
                UPLog.e("Impl", "U-Push min support Android 4.0!");
                return;
            }
            Application applicationA = x.a();
            if (isPushCheck() && !k.a(applicationA)) {
                UPLog.e("Impl", "AndroidManifest config error!");
                return;
            }
            String messageAppkey = getMessageAppkey();
            String messageSecret = getMessageSecret();
            if (!TextUtils.isEmpty(messageAppkey) && !TextUtils.isEmpty(messageSecret)) {
                if (f.b()) {
                    UPLog.e("Impl", "init failed. silent mode!");
                    return;
                }
                f.a(applicationA, (Class<?>) UmengMessageHandlerService.class);
                AwcnConfig.setAccsSessionCreateForbiddenInBg(false);
                AwcnConfig.setWifiInfoEnable(false);
                AmdcRuntimeInfo.setForceHttps(true);
                String strA = f.a(applicationA);
                GlobalConfig.setCurrProcessNameImpl(new IProcessName() { // from class: com.umeng.message.proguard.u.2
                    final /* synthetic */ String a;

                    AnonymousClass2(String strA2) {
                        str = strA2;
                    }

                    @Override // com.taobao.accs.IProcessName
                    public final String getCurrProcessName() {
                        return str;
                    }
                });
                GlobalAppRuntimeInfo.setCurrentProcess(strA2);
                AccsClientConfig.Builder builder = new AccsClientConfig.Builder();
                builder.setAppKey("umeng:".concat(String.valueOf(messageAppkey))).setAppSecret(messageSecret).setKeepAlive(this.a).setDisableChannel(true).setAutoUnit(false).setTag(AccsClientConfig.DEFAULT_CONFIGTAG).setPullUpEnable(this.f8095b).setAccsHeartbeatEnable(this.f8096c);
                ACCSClient.setEnvironment(applicationA, 0);
                builder.setConfigEnv(0);
                builder.setInappHost("umengacs.m.taobao.com");
                builder.setInappPubKey(11);
                builder.setChannelHost("umengjmacs.m.taobao.com");
                builder.setChannelPubKey(11);
                ACCSClient.init(applicationA, builder.build());
                AmdcRuntimeInfo.setParam("deviceId", UTDevice.getUtdid(applicationA));
                DispatchConstants.setAmdcServerDomain(new String[]{"amdcopen.m.umeng.com", "amdc.wapa.taobao.com", "amdc.taobao.net"});
                DispatchConstants.setAmdcServerFixIp(new String[][]{new String[]{"59.82.113.219", "59.82.113.35"}, null, null});
                TaobaoRegister.setAgooMsgReceiveService(UmengIntentService.class.getName());
                t.a();
                t.b();
                UPLog.i("Impl", "appkey:", messageAppkey, "appSecret:", messageSecret);
                b.c(new Runnable() { // from class: com.umeng.message.proguard.u.3
                    final /* synthetic */ Context a;

                    /* JADX INFO: renamed from: b */
                    final /* synthetic */ String f8104b;

                    /* JADX INFO: renamed from: c */
                    final /* synthetic */ String f8105c;

                    /* JADX INFO: renamed from: com.umeng.message.proguard.u$3$1 */
                    final class AnonymousClass1 extends IRegister {
                        AnonymousClass1() {
                        }

                        @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
                        public final void onFailure(String str, String str2) {
                            UPLog.e("Impl", "register failed! code:", str, "desc:", str2);
                            Application applicationA = x.a();
                            Intent intent = new Intent("com.umeng.message.action");
                            intent.setPackage(applicationA.getPackageName());
                            intent.setClass(applicationA, UmengMessageHandlerService.class);
                            intent.putExtra("um_command", "register");
                            intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                            intent.putExtra("code", str);
                            intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                            q.enqueueWork(applicationA, UmengMessageHandlerService.class, intent);
                            UMLog.aq(ab.a, 0, "\\|");
                        }

                        @Override // com.taobao.agoo.IRegister
                        public final void onSuccess(String str) {
                            UPLog.i("Impl", "register success. deviceToken:", str);
                            Application applicationA = x.a();
                            Intent intent = new Intent("com.umeng.message.action");
                            intent.setPackage(applicationA.getPackageName());
                            intent.setClass(applicationA, UmengMessageHandlerService.class);
                            intent.putExtra("um_command", "register");
                            intent.putExtra("registration_id", str);
                            intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                            q.enqueueWork(applicationA, UmengMessageHandlerService.class, intent);
                        }
                    }

                    AnonymousClass3(Context applicationA2, String messageAppkey2, String messageSecret2) {
                        context = applicationA2;
                        str = messageAppkey2;
                        str = messageSecret2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            TaobaoRegister.register(context, AccsClientConfig.DEFAULT_CONFIGTAG, "umeng:" + str, str, "android@umeng", new IRegister() { // from class: com.umeng.message.proguard.u.3.1
                                AnonymousClass1() {
                                }

                                @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
                                public final void onFailure(String str, String str2) {
                                    UPLog.e("Impl", "register failed! code:", str, "desc:", str2);
                                    Application applicationA2 = x.a();
                                    Intent intent = new Intent("com.umeng.message.action");
                                    intent.setPackage(applicationA2.getPackageName());
                                    intent.setClass(applicationA2, UmengMessageHandlerService.class);
                                    intent.putExtra("um_command", "register");
                                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
                                    intent.putExtra("code", str);
                                    intent.putExtra(SocialConstants.PARAM_APP_DESC, str2);
                                    q.enqueueWork(applicationA2, UmengMessageHandlerService.class, intent);
                                    UMLog.aq(ab.a, 0, "\\|");
                                }

                                @Override // com.taobao.agoo.IRegister
                                public final void onSuccess(String str) {
                                    UPLog.i("Impl", "register success. deviceToken:", str);
                                    Application applicationA2 = x.a();
                                    Intent intent = new Intent("com.umeng.message.action");
                                    intent.setPackage(applicationA2.getPackageName());
                                    intent.setClass(applicationA2, UmengMessageHandlerService.class);
                                    intent.putExtra("um_command", "register");
                                    intent.putExtra("registration_id", str);
                                    intent.putExtra(NotificationCompat.CATEGORY_STATUS, true);
                                    q.enqueueWork(applicationA2, UmengMessageHandlerService.class, intent);
                                }
                            });
                        } catch (Throwable th) {
                            UPLog.e("Impl", th);
                        }
                    }
                });
                if (f.b(applicationA2)) {
                    i.a();
                    UPLog.upload();
                }
                aj.a().b();
                return;
            }
            UPLog.e("Impl", "Appkey\u3001MessageSecret cannot be empty!");
        } catch (Throwable th) {
            UPLog.e("Impl", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setAccsHeartbeatEnable(boolean z) {
        this.f8096c = z;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().setAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setDisplayNotificationNumber(int i2) {
        if (!f.b(x.a()) || i2 < 0 || i2 > 10) {
            return;
        }
        MessageSharedPrefs.getInstance(x.a()).f7878b.a("notification_number", i2);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableAlarmHeartbeat(boolean z) {
        try {
            GlobalConfig.setAlarmHeartbeatEnable(z);
        } catch (Throwable th) {
            UPLog.e("Impl", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableForeground(boolean z) {
        try {
            GlobalConfig.setEnableForeground(x.a(), z);
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableJobHeartbeat(boolean z) {
        try {
            GlobalConfig.setJobHeartbeatEnable(z);
        } catch (Throwable th) {
            UPLog.e("Impl", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setMessageHandler(UPushMessageHandler uPushMessageHandler) {
        this.f8101h = uPushMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setMuteDurationSeconds(int i2) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs.getInstance(applicationA).f7878b.a("mute_duration", i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNoDisturbMode(int i2, int i3, int i4, int i5) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(applicationA);
            messageSharedPrefs.f7878b.a("start_hour", i2);
            messageSharedPrefs.f7878b.a("start_minute", i3);
            messageSharedPrefs.f7878b.a("end_hour", i4);
            messageSharedPrefs.f7878b.a("end_minute", i5);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationChannelName(String str) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs.getInstance(applicationA).f7878b.a("notification_channel_default", str);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler) {
        this.f8102i = uPushMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationOnForeground(boolean z) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs.getInstance(applicationA).f7878b.a("notification_foreground_show", z);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlayLights(int i2) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs.getInstance(applicationA).f7878b.a("notification_light", i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlaySound(int i2) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs.getInstance(applicationA).f7878b.a("notification_sound", i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlayVibrate(int i2) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs.getInstance(applicationA).f7878b.a("notification_vibrate", i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationSilenceChannelName(String str) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs.getInstance(applicationA).f7878b.a("notification_channel_silence", str);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setPullUpEnable(boolean z) {
        this.f8095b = z;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setPushCheck(boolean z) {
        this.f8097d = z;
    }

    @Override // com.umeng.message.api.UPushApi
    public final <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(applicationA);
            if (cls == null) {
                messageSharedPrefs.f7878b.a("service_class");
            } else {
                messageSharedPrefs.f7878b.a("service_class", cls.getName());
            }
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback) {
        this.f8098e = uPushRegisterCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setResourcePackageName(String str) {
        Application applicationA = x.a();
        if (f.b(applicationA)) {
            MessageSharedPrefs.getInstance(applicationA).f7878b.a("res_pkg", str);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setSettingCallback(UPushSettingCallback uPushSettingCallback) {
        this.f8100g = uPushSettingCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setThirdTokenCallback(UPushThirdTokenCallback uPushThirdTokenCallback) {
        this.f8099f = uPushThirdTokenCallback;
    }

    private u() {
        this.a = true;
    }
}
