package com.umeng.message.component;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.C3397d;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.AbstractServiceC3597q;
import com.umeng.message.proguard.C3578b;
import com.umeng.message.proguard.C3586f;
import com.umeng.message.proguard.C3588h;
import com.umeng.message.proguard.C3590j;
import com.umeng.message.proguard.C3594n;
import com.umeng.message.proguard.C3601u;
import com.umeng.message.proguard.C3602v;
import com.umeng.message.proguard.C3604x;
import com.umeng.message.proguard.C3605y;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class UmengMessageHandlerService extends AbstractServiceC3597q {

    /* renamed from: a */
    private static final LruCache<String, String> f13053a = new LruCache<>(3);

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.umeng.message.proguard.AbstractServiceC3597q
    public final void onHandleWork(Intent intent) {
        final String stringExtra;
        boolean booleanExtra;
        final UPushRegisterCallback registerCallback;
        UPushMessageHandler messageHandler;
        super.onHandleWork(intent);
        final Application m12460a = C3604x.m12460a();
        if (m12460a == null) {
            UPLog.m12145i("MsgHandlerService", "context null!");
            return;
        }
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        String stringExtra2 = intent.getStringExtra("um_command");
        UPLog.m12145i("MsgHandlerService", "action:", action, stringExtra2);
        if (TextUtils.equals("com.umeng.message.action", action)) {
            if (stringExtra2 == null || stringExtra2.length() == 0) {
                return;
            }
            char c2 = 65535;
            switch (stringExtra2.hashCode()) {
                case -1298848381:
                    if (stringExtra2.equals("enable")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1224577496:
                    if (stringExtra2.equals("handle")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -690213213:
                    if (stringExtra2.equals("register")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3526536:
                    if (stringExtra2.equals("send")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 443595041:
                    if (stringExtra2.equals("third_token")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1671308008:
                    if (stringExtra2.equals("disable")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                try {
                    stringExtra = intent.getStringExtra("registration_id");
                    booleanExtra = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPLog.m12145i("MsgHandlerService", "deviceToken:", stringExtra, "status:", Boolean.valueOf(booleanExtra));
                    registerCallback = C3601u.m12450a().getRegisterCallback();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (booleanExtra) {
                        C3578b.m12327c(new Runnable() { // from class: com.umeng.message.component.UmengMessageHandlerService.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                final String str = "";
                                try {
                                    MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
                                    str = messageSharedPrefs.m12131k();
                                    if (stringExtra != null && str != null && !stringExtra.equals(str)) {
                                        String str2 = stringExtra;
                                        if (str2 == null) {
                                            messageSharedPrefs.f13043b.m12282a(RemoteMessageConst.DEVICE_TOKEN);
                                        } else {
                                            messageSharedPrefs.f13043b.m12285a(RemoteMessageConst.DEVICE_TOKEN, str2);
                                        }
                                        Context context = m12460a;
                                        messageSharedPrefs.f13043b.m12282a("has_register");
                                        messageSharedPrefs.f13043b.m12282a(C3397d.f11950p);
                                        messageSharedPrefs.f13043b.m12282a("re_pop_times");
                                        messageSharedPrefs.f13043b.m12282a("re_pop_cfg");
                                        messageSharedPrefs.f13043b.m12282a(SocializeProtocolConstants.TAGS);
                                        messageSharedPrefs.f13043b.m12282a("tag_remain");
                                        messageSharedPrefs.m12121b("tag_add_");
                                        messageSharedPrefs.m12121b("tag_del_");
                                        messageSharedPrefs.m12121b("tag_get_");
                                        messageSharedPrefs.m12121b("alias_del_");
                                        messageSharedPrefs.m12121b("alias_set_");
                                        messageSharedPrefs.m12121b("alias_add_");
                                        try {
                                            context.getContentResolver().delete(C3588h.m12403b(context), null, null);
                                        } catch (Throwable th2) {
                                            UPLog.m12143e("Prefs", th2);
                                        }
                                    }
                                } catch (Throwable th3) {
                                    UPLog.m12143e("MsgHandlerService", th3);
                                }
                                try {
                                    if (registerCallback != null) {
                                        registerCallback.onSuccess(stringExtra);
                                    }
                                } catch (Throwable th4) {
                                    UPLog.m12143e("MsgHandlerService", th4);
                                }
                                final C3605y m12463a = C3605y.m12463a();
                                if (!C3605y.m12470c()) {
                                    final MessageSharedPrefs messageSharedPrefs2 = MessageSharedPrefs.getInstance(C3604x.m12460a());
                                    if (!messageSharedPrefs2.f13043b.m12292b("has_register", false) && !C3605y.f13390b) {
                                        C3605y.f13390b = true;
                                        C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.y.3
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                try {
                                                    C3605y.this.f13392d.mo12223a(str);
                                                    UPLog.m12142d("Track", "trackRegister deviceToken:", messageSharedPrefs2.m12131k());
                                                } catch (Throwable th5) {
                                                    UPLog.m12143e("Track", th5);
                                                    C3605y.f13390b = false;
                                                }
                                            }
                                        });
                                    }
                                }
                                C3601u.m12450a().onAppStart();
                                C3594n.m12421a();
                            }
                        });
                        return;
                    } else {
                        if (registerCallback != null) {
                            registerCallback.onFailure(intent.getStringExtra("code"), intent.getStringExtra(SocialConstants.PARAM_APP_DESC));
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    UPLog.m12143e("MsgHandlerService", th);
                    return;
                }
            }
            if (c2 == 1) {
                try {
                    boolean booleanExtra2 = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPushSettingCallback settingCallback = C3601u.m12450a().getSettingCallback();
                    UPLog.m12145i("MsgHandlerService", "push open status:".concat(String.valueOf(booleanExtra2)));
                    if (booleanExtra2) {
                        if (settingCallback != null) {
                            settingCallback.onSuccess();
                            return;
                        }
                        return;
                    } else {
                        if (settingCallback != null) {
                            settingCallback.onFailure(intent.getStringExtra("code"), intent.getStringExtra(SocialConstants.PARAM_APP_DESC));
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    UPLog.m12143e("MsgHandlerService", th3);
                    return;
                }
            }
            if (c2 == 2) {
                try {
                    boolean booleanExtra3 = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPushSettingCallback settingCallback2 = C3601u.m12450a().getSettingCallback();
                    UPLog.m12145i("MsgHandlerService", "push close status:".concat(String.valueOf(booleanExtra3)));
                    if (booleanExtra3) {
                        if (settingCallback2 != null) {
                            settingCallback2.onSuccess();
                            return;
                        }
                        return;
                    } else {
                        if (settingCallback2 != null) {
                            settingCallback2.onFailure(intent.getStringExtra("code"), intent.getStringExtra(SocialConstants.PARAM_APP_DESC));
                            return;
                        }
                        return;
                    }
                } catch (Throwable th4) {
                    UPLog.m12143e("MsgHandlerService", th4);
                    return;
                }
            }
            if (c2 == 3) {
                try {
                    String stringExtra3 = intent.getStringExtra("body");
                    if (stringExtra3 == null) {
                        return;
                    }
                    UMessage uMessage = new UMessage(new JSONObject(stringExtra3));
                    if (("notification".equals(uMessage.getDisplayType()) && uMessage.hasResourceFromInternet() && C3590j.m12414a().m12417a(intent)) || (messageHandler = C3601u.m12450a().getMessageHandler()) == null) {
                        return;
                    }
                    messageHandler.handleMessage(m12460a, uMessage);
                    return;
                } catch (Throwable th5) {
                    UPLog.m12143e("MsgHandlerService", th5);
                    return;
                }
            }
            if (c2 == 4) {
                try {
                    String stringExtra4 = intent.getStringExtra("send_message");
                    if (stringExtra4 == null) {
                        return;
                    }
                    String stringExtra5 = intent.getStringExtra("um_px_path");
                    JSONObject jSONObject = new JSONObject(stringExtra4);
                    jSONObject.put("um_px_path", stringExtra5);
                    UMWorkDispatch.sendEvent(m12460a, 16388, C3602v.m12452a(), jSONObject.toString());
                    return;
                } catch (Throwable th6) {
                    UPLog.m12143e("MsgHandlerService", th6);
                    return;
                }
            }
            if (c2 != 5) {
                return;
            }
            try {
                String stringExtra6 = intent.getStringExtra("third_token");
                String m12383a = C3586f.m12383a(intent.getStringExtra("type"));
                if (!TextUtils.isEmpty(m12383a) && !TextUtils.isEmpty(stringExtra6)) {
                    if (TextUtils.equals(f13053a.get(m12383a), stringExtra6)) {
                        UPLog.m12145i("MsgHandlerService", "third push callback skipped! already called.");
                        return;
                    }
                    UPLog.m12145i("MsgHandlerService", "third push type:", m12383a, "token:", stringExtra6);
                    UPushThirdTokenCallback thirdTokenCallback = C3601u.m12450a().getThirdTokenCallback();
                    if (thirdTokenCallback != null) {
                        thirdTokenCallback.onToken(m12383a, stringExtra6);
                    } else {
                        String pushIntentServiceClass = C3601u.m12450a().getPushIntentServiceClass();
                        if (!TextUtils.isEmpty(pushIntentServiceClass)) {
                            Class<?> cls = Class.forName(pushIntentServiceClass);
                            Intent intent2 = new Intent();
                            intent2.setPackage(m12460a.getPackageName());
                            intent2.putExtra("um_command", "third_token");
                            intent2.putExtra("third_token", stringExtra6);
                            intent2.putExtra("type", m12383a);
                            intent2.setClass(m12460a, cls);
                            AbstractServiceC3597q.enqueueWork(m12460a, cls, intent2);
                        }
                    }
                    f13053a.put(m12383a, stringExtra6);
                    return;
                }
                UPLog.m12145i("MsgHandlerService", "third push skipped! type:", m12383a, "token:", stringExtra6);
            } catch (Throwable th7) {
                UPLog.m12143e("MsgHandlerService", th7);
            }
        }
    }
}
