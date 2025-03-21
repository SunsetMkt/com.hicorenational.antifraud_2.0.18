package com.umeng.message;

import android.content.Context;
import com.taobao.accs.utl.ALog;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushApi;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.C3574aw;
import com.umeng.message.proguard.C3584d;
import com.umeng.message.proguard.C3586f;
import com.umeng.message.proguard.C3589i;
import com.umeng.message.proguard.C3595o;
import com.umeng.message.proguard.C3600t;
import com.umeng.message.proguard.C3601u;
import com.umeng.message.proguard.C3604x;
import com.umeng.message.tag.TagManager;
import org.android.spdy.SpdyAgent;

/* loaded from: classes2.dex */
public class PushAgent {
    private static final String TAG = "PushAgent";
    private static boolean sInit = false;
    private static volatile PushAgent sInstance;
    private UPushApi api;
    public boolean isZyb = true;

    static {
        try {
            C3595o c3595o = new C3595o();
            ALog.setLog(c3595o);
            anet.channel.util.ALog.setLog(c3595o);
        } catch (Throwable th) {
            UPLog.m12143e(TAG, th);
        }
    }

    private PushAgent(Context context) {
        if (context == null) {
            try {
                context = C3604x.m12460a();
            } catch (Throwable th) {
                UPLog.m12143e(TAG, th);
            }
        }
        C3604x.m12461a(context);
        C3600t.m12440a();
        this.api = C3601u.m12450a();
    }

    public static PushAgent getInstance(Context context) {
        if (sInstance == null) {
            synchronized (PushAgent.class) {
                if (sInstance == null) {
                    sInstance = new PushAgent(context);
                }
            }
        }
        return sInstance;
    }

    private static void init(Context context) {
        if (sInit) {
            return;
        }
        C3586f.m12391c();
        sInit = true;
    }

    public static void setup(Context context, String str, String str2) {
        UPLog.m12142d("Core", "setup appkey:", str, "appSecret:", str2);
        C3604x.m12461a(context);
        C3600t.m12440a();
    }

    public void addAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        this.api.addAlias(str, str2, uPushAliasCallback);
    }

    public void changeBadgeNum(int i2) {
        C3574aw.m12314b(C3604x.m12460a(), i2);
    }

    public void deleteAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        this.api.deleteAlias(str, str2, uPushAliasCallback);
    }

    public void disable(UPushSettingCallback uPushSettingCallback) {
        this.api.disable(uPushSettingCallback);
    }

    public void enable(UPushSettingCallback uPushSettingCallback) {
        this.api.enable(uPushSettingCallback);
    }

    public UPushSettingCallback getCallback() {
        return this.api.getSettingCallback();
    }

    public int getDisplayNotificationNumber() {
        return this.api.getDisplayNotificationNumber();
    }

    public String getMessageAppkey() {
        return this.api.getMessageAppkey();
    }

    public String getMessageChannel() {
        return this.api.getMessageChannel();
    }

    public UPushMessageHandler getMessageHandler() {
        return this.api.getMessageHandler();
    }

    public UPushMessageNotifyApi getMessageNotifyApi() {
        return this.api.getMessageNotifyApi();
    }

    public String getMessageSecret() {
        return this.api.getMessageSecret();
    }

    public int getMuteDurationSeconds() {
        return this.api.getMuteDurationSeconds();
    }

    public int getNoDisturbEndHour() {
        return this.api.getNoDisturbEndHour();
    }

    public int getNoDisturbEndMinute() {
        return this.api.getNoDisturbEndMinute();
    }

    public int getNoDisturbStartHour() {
        return this.api.getNoDisturbStartHour();
    }

    public int getNoDisturbStartMinute() {
        return this.api.getNoDisturbStartMinute();
    }

    public String getNotificationChannelName() {
        return this.api.getNotificationChannelName();
    }

    public UPushMessageHandler getNotificationClickHandler() {
        return this.api.getNotificationClickHandler();
    }

    public boolean getNotificationOnForeground() {
        return this.api.getNotificationOnForeground();
    }

    public int getNotificationPlayLights() {
        return this.api.getNotificationPlayLights();
    }

    public int getNotificationPlaySound() {
        return this.api.getNotificationPlaySound();
    }

    public int getNotificationPlayVibrate() {
        return this.api.getNotificationPlayVibrate();
    }

    public String getNotificationSilenceChannelName() {
        return this.api.getNotificationSilenceChannelName();
    }

    public String getPushIntentServiceClass() {
        return this.api.getPushIntentServiceClass();
    }

    public UPushRegisterCallback getRegisterCallback() {
        return this.api.getRegisterCallback();
    }

    public String getRegistrationId() {
        return this.api.getRegistrationId();
    }

    public String getResourcePackageName() {
        return this.api.getResourcePackageName();
    }

    public TagManager getTagManager() {
        return this.api.getTagManager();
    }

    public boolean isNotificationEnabled() {
        return C3584d.m12373q(C3604x.m12460a()) == 1;
    }

    public boolean isPushCheck() {
        return this.api.isPushCheck();
    }

    public void keepLowPowerMode(boolean z) {
        this.api.keepLowPowerMode(z);
    }

    public void onAppStart() {
        this.api.onAppStart();
    }

    public boolean openNotificationSettings() {
        return C3584d.m12374r(C3604x.m12460a());
    }

    public void register(UPushRegisterCallback uPushRegisterCallback) {
        this.api.register(uPushRegisterCallback);
    }

    public void setAccsHeartbeatEnable(boolean z) {
        this.api.setAccsHeartbeatEnable(z);
    }

    public void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        this.api.setAlias(str, str2, uPushAliasCallback);
    }

    public void setBadgeNum(int i2) {
        C3574aw.m12312a(C3604x.m12460a(), i2);
    }

    public void setCallback(UPushSettingCallback uPushSettingCallback) {
        this.api.setSettingCallback(uPushSettingCallback);
    }

    public void setDebugMode(boolean z) {
        UPLog.setEnable(z);
        try {
            SpdyAgent.enableDebug = z;
        } catch (Throwable th) {
            UPLog.m12143e(TAG, th);
        }
    }

    public void setDisplayNotificationNumber(int i2) {
        this.api.setDisplayNotificationNumber(i2);
    }

    public void setEnableAlarmHeartbeat(boolean z) {
        this.api.setEnableAlarmHeartbeat(z);
    }

    public void setEnableForeground(Context context, boolean z) {
        this.api.setEnableForeground(z);
    }

    public void setEnableJobHeartbeat(boolean z) {
        this.api.setEnableJobHeartbeat(z);
    }

    public void setLogUploadEnable(boolean z) {
        C3586f.f13277b = z;
    }

    public void setMessageHandler(UPushMessageHandler uPushMessageHandler) {
        this.api.setMessageHandler(uPushMessageHandler);
    }

    public void setMuteDurationSeconds(int i2) {
        this.api.setMuteDurationSeconds(i2);
    }

    public void setNoDisturbMode(int i2, int i3, int i4, int i5) {
        this.api.setNoDisturbMode(i2, i3, i4, i5);
    }

    public void setNotificationChannelName(String str) {
        this.api.setNotificationChannelName(str);
    }

    public void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler) {
        this.api.setNotificationClickHandler(uPushMessageHandler);
    }

    public void setNotificationOnForeground(boolean z) {
        this.api.setNotificationOnForeground(z);
    }

    public void setNotificationPlayLights(int i2) {
        this.api.setNotificationPlayLights(i2);
    }

    public void setNotificationPlaySound(int i2) {
        this.api.setNotificationPlaySound(i2);
    }

    public void setNotificationPlayVibrate(int i2) {
        this.api.setNotificationPlayVibrate(i2);
    }

    public void setNotificationSilenceChannelName(String str) {
        this.api.setNotificationSilenceChannelName(str);
    }

    public void setPackageListenerEnable(boolean z) {
        C3589i.m12411a(z);
    }

    public void setPullUpEnable(boolean z) {
        this.api.setPullUpEnable(z);
    }

    public void setPushCheck(boolean z) {
        this.api.setPushCheck(z);
    }

    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        this.api.setPushIntentServiceClass(cls);
    }

    public void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback) {
        this.api.setRegisterCallback(uPushRegisterCallback);
    }

    public void setResourcePackageName(String str) {
        this.api.setResourcePackageName(str);
    }

    public void setSmartEnable(boolean z) {
        C3586f.f13276a = z;
    }

    public void setThirdTokenCallback(UPushThirdTokenCallback uPushThirdTokenCallback) {
        this.api.setThirdTokenCallback(uPushThirdTokenCallback);
    }

    private PushAgent() {
    }
}
