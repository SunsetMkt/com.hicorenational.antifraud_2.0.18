package com.umeng.message.component;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.app.NotificationCompat;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.j;
import com.umeng.message.proguard.q;
import com.umeng.message.proguard.u;
import com.umeng.message.proguard.v;
import com.umeng.message.proguard.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class UmengMessageHandlerService extends q {
    private static final LruCache<String, String> a = new LruCache<>(3);

    /* JADX INFO: renamed from: com.umeng.message.component.UmengMessageHandlerService$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f7883b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ UPushRegisterCallback f7884c;

        AnonymousClass1(Context context, String str, UPushRegisterCallback uPushRegisterCallback) {
            context = context;
            str = str;
            uPushRegisterCallback = uPushRegisterCallback;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.umeng.message.proguard.y.3.<init>(com.umeng.message.proguard.y, java.lang.String, com.umeng.message.MessageSharedPrefs):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:298)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
            	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:197)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
            */
        @Override // java.lang.Runnable
        public final void run() {
            /*
                Method dump skipped, instruction units count: 212
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.component.UmengMessageHandlerService.AnonymousClass1.run():void");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.umeng.message.proguard.q
    public final void onHandleWork(Intent intent) {
        UPushMessageHandler messageHandler;
        super.onHandleWork(intent);
        Application applicationA = x.a();
        if (applicationA == null) {
            UPLog.i("MsgHandlerService", "context null!");
            return;
        }
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("um_command");
        UPLog.i("MsgHandlerService", "action:", action, stringExtra);
        if (TextUtils.equals("com.umeng.message.action", action)) {
            if (stringExtra == null || stringExtra.length() == 0) {
                return;
            }
            byte b2 = -1;
            switch (stringExtra.hashCode()) {
                case -1298848381:
                    if (stringExtra.equals("enable")) {
                        b2 = 1;
                    }
                    break;
                case -1224577496:
                    if (stringExtra.equals("handle")) {
                        b2 = 3;
                    }
                    break;
                case -690213213:
                    if (stringExtra.equals("register")) {
                        b2 = 0;
                    }
                    break;
                case 3526536:
                    if (stringExtra.equals("send")) {
                        b2 = 4;
                    }
                    break;
                case 443595041:
                    if (stringExtra.equals("third_token")) {
                        b2 = 5;
                    }
                    break;
                case 1671308008:
                    if (stringExtra.equals("disable")) {
                        b2 = 2;
                    }
                    break;
            }
            if (b2 == 0) {
                try {
                    String stringExtra2 = intent.getStringExtra("registration_id");
                    boolean booleanExtra = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPLog.i("MsgHandlerService", "deviceToken:", stringExtra2, "status:", Boolean.valueOf(booleanExtra));
                    UPushRegisterCallback registerCallback = u.a().getRegisterCallback();
                    try {
                        if (booleanExtra) {
                            b.c(new Runnable() { // from class: com.umeng.message.component.UmengMessageHandlerService.1
                                final /* synthetic */ Context a;

                                /* JADX INFO: renamed from: b */
                                final /* synthetic */ String f7883b;

                                /* JADX INFO: renamed from: c */
                                final /* synthetic */ UPushRegisterCallback f7884c;

                                AnonymousClass1(Context applicationA2, String stringExtra22, UPushRegisterCallback registerCallback2) {
                                    context = applicationA2;
                                    str = stringExtra22;
                                    uPushRegisterCallback = registerCallback2;
                                }

                                /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.umeng.message.proguard.y.3.<init>(com.umeng.message.proguard.y, java.lang.String, com.umeng.message.MessageSharedPrefs):void, class status: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:298)
                                    	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
                                    	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
                                    	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:197)
                                    	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
                                    	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
                                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
                                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
                                    	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
                                    */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    /*
                                        Method dump skipped, instruction units count: 212
                                        To view this dump change 'Code comments level' option to 'DEBUG'
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.component.UmengMessageHandlerService.AnonymousClass1.run():void");
                                }
                            });
                            return;
                        } else {
                            if (registerCallback2 != null) {
                                registerCallback2.onFailure(intent.getStringExtra("code"), intent.getStringExtra(SocialConstants.PARAM_APP_DESC));
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                UPLog.e("MsgHandlerService", th);
                return;
            }
            if (b2 == 1) {
                try {
                    boolean booleanExtra2 = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPushSettingCallback settingCallback = u.a().getSettingCallback();
                    UPLog.i("MsgHandlerService", "push open status:".concat(String.valueOf(booleanExtra2)));
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
                    UPLog.e("MsgHandlerService", th3);
                    return;
                }
            }
            if (b2 == 2) {
                try {
                    boolean booleanExtra3 = intent.getBooleanExtra(NotificationCompat.CATEGORY_STATUS, false);
                    UPushSettingCallback settingCallback2 = u.a().getSettingCallback();
                    UPLog.i("MsgHandlerService", "push close status:".concat(String.valueOf(booleanExtra3)));
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
                    UPLog.e("MsgHandlerService", th4);
                    return;
                }
            }
            if (b2 == 3) {
                try {
                    String stringExtra3 = intent.getStringExtra("body");
                    if (stringExtra3 == null) {
                        return;
                    }
                    UMessage uMessage = new UMessage(new JSONObject(stringExtra3));
                    if (("notification".equals(uMessage.getDisplayType()) && uMessage.hasResourceFromInternet() && j.a().a(intent)) || (messageHandler = u.a().getMessageHandler()) == null) {
                        return;
                    }
                    messageHandler.handleMessage(applicationA2, uMessage);
                    return;
                } catch (Throwable th5) {
                    UPLog.e("MsgHandlerService", th5);
                    return;
                }
            }
            if (b2 == 4) {
                try {
                    String stringExtra4 = intent.getStringExtra("send_message");
                    if (stringExtra4 == null) {
                        return;
                    }
                    String stringExtra5 = intent.getStringExtra("um_px_path");
                    JSONObject jSONObject = new JSONObject(stringExtra4);
                    jSONObject.put("um_px_path", stringExtra5);
                    UMWorkDispatch.sendEvent(applicationA2, 16388, v.a(), jSONObject.toString());
                    return;
                } catch (Throwable th6) {
                    UPLog.e("MsgHandlerService", th6);
                    return;
                }
            }
            if (b2 != 5) {
                return;
            }
            try {
                String stringExtra6 = intent.getStringExtra("third_token");
                String strA = f.a(intent.getStringExtra("type"));
                if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(stringExtra6)) {
                    if (TextUtils.equals(a.get(strA), stringExtra6)) {
                        UPLog.i("MsgHandlerService", "third push callback skipped! already called.");
                        return;
                    }
                    UPLog.i("MsgHandlerService", "third push type:", strA, "token:", stringExtra6);
                    UPushThirdTokenCallback thirdTokenCallback = u.a().getThirdTokenCallback();
                    if (thirdTokenCallback != null) {
                        thirdTokenCallback.onToken(strA, stringExtra6);
                    } else {
                        String pushIntentServiceClass = u.a().getPushIntentServiceClass();
                        if (!TextUtils.isEmpty(pushIntentServiceClass)) {
                            Class<?> cls = Class.forName(pushIntentServiceClass);
                            Intent intent2 = new Intent();
                            intent2.setPackage(applicationA2.getPackageName());
                            intent2.putExtra("um_command", "third_token");
                            intent2.putExtra("third_token", stringExtra6);
                            intent2.putExtra("type", strA);
                            intent2.setClass(applicationA2, cls);
                            q.enqueueWork(applicationA2, cls, intent2);
                        }
                    }
                    a.put(strA, stringExtra6);
                    return;
                }
                UPLog.i("MsgHandlerService", "third push skipped! type:", strA, "token:", stringExtra6);
            } catch (Throwable th7) {
                UPLog.e("MsgHandlerService", th7);
            }
        }
    }
}
