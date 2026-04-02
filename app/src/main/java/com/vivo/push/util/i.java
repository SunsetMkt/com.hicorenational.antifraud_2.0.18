package com.vivo.push.util;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.just.agentweb.DefaultWebClient;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConvertMsgToIntentImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8672e = 0;

    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Intent b(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        String packageName;
        Intent intentA;
        int iA;
        try {
            packageName = context.getPackageName();
        } catch (Exception e2) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient parsing error : " + e2.getMessage());
            this.f8672e = 2159;
        }
        if (insideNotificationItem != null && !TextUtils.isEmpty(packageName)) {
            u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient getSkipType \uff1a\uff1a" + insideNotificationItem.getSkipType());
            int skipType = insideNotificationItem.getSkipType();
            boolean z = true;
            if (skipType != 1) {
                if (skipType == 2) {
                    String skipContent = insideNotificationItem.getSkipContent();
                    if (!TextUtils.isEmpty(skipContent)) {
                        String lowerCase = skipContent.toLowerCase();
                        if (!lowerCase.startsWith(DefaultWebClient.HTTP_SCHEME) && !lowerCase.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                            z = false;
                        }
                        if (z) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(skipContent));
                            intent.setFlags(CommonNetImpl.FLAG_AUTH);
                            a(intent, insideNotificationItem.getParams());
                            u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url urlAddr ::".concat(String.valueOf(skipContent)));
                            intentA = intent;
                        } else {
                            u.c(context, " \u8df3\u8f6c\u53c2\u6570\u4e0d\u5408\u6cd5\uff0c\u6253\u5f00\u7f51\u9875\u5730\u5740\u4e0d\u7b26\u5408\u8981\u6c42 \u901a\u77e5\u672a\u5c55\u793a 2157");
                            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url not legal");
                            this.f8672e = 2157;
                            intentA = null;
                        }
                    }
                } else if (skipType == 3) {
                    String skipContent2 = insideNotificationItem.getSkipContent();
                    u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient \uff1a\uff1a" + insideNotificationItem.getSkipContent());
                    if (notifyArriveCallbackByUser.getIntent() != null) {
                        u.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   not null  ");
                        try {
                            intentA = notifyArriveCallbackByUser.getIntent();
                            intentA.setSelector(null);
                            intentA.setFlags(335544320);
                            b(intentA, insideNotificationItem.getParams());
                            iA = a(intentA, packageName);
                        } catch (Exception e3) {
                            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(skipContent2)), e3);
                            this.f8672e = 2158;
                        }
                        if (iA > 0) {
                            this.f8672e = iA;
                            intentA = null;
                        }
                    } else {
                        u.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   is null \u6839\u636eskipcontent\u751f\u6210\u8df3\u8f6c\u53c2\u6570 ");
                        intentA = a(skipContent2, packageName, insideNotificationItem, context);
                    }
                } else if (skipType != 4) {
                    u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : intent null");
                    this.f8672e = 2159;
                    intentA = null;
                } else {
                    String skipContent3 = insideNotificationItem.getSkipContent();
                    u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient \uff1a\uff1a" + insideNotificationItem.getSkipContent());
                    intentA = a(skipContent3, packageName, insideNotificationItem, context);
                }
                return null;
            }
            intentA = a(insideNotificationItem.getParams(), packageName, context);
            if (intentA == null) {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : " + insideNotificationItem.getSkipType());
                return null;
            }
            intentA.putExtra("vivo_push_messageId", b());
            intentA.putExtra("command_type", "reflect_receiver");
            b.a(intentA, context);
            this.f8672e = 0;
            return intentA;
        }
        u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient notify == null");
        this.f8672e = 2159;
        return null;
    }

    @Override // com.vivo.push.util.b
    protected final int a() {
        return this.f8672e;
    }

    @Override // com.vivo.push.util.b
    protected final Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        return b(context, insideNotificationItem, notifyArriveCallbackByUser);
    }

    @Override // com.vivo.push.util.b
    protected final PendingIntent a(Context context, Intent intent) {
        return PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
    }

    private Intent a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) {
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.setSelector(null);
            uri.setPackage(str2);
            uri.setFlags(335544320);
            a(uri, insideNotificationItem.getParams());
            int iA = a(uri, str2);
            if (iA <= 0) {
                return uri;
            }
            this.f8672e = iA;
            u.c(context, " \u843d\u5730\u9875\u672a\u627e\u5230\uff0c\u901a\u77e5\u4e0d\u5c55\u793a\uff1a  " + this.f8672e);
            return null;
        } catch (Exception e2) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e2);
            this.f8672e = 2158;
            return null;
        }
    }

    private static Intent a(Map<String, String> map, String str, Context context) {
        Intent intent = new Intent();
        intent.setPackage(str);
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(str)) {
                        u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient topClassName=" + componentName.getClassName());
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        a(intent, map);
                        return intent;
                    }
                }
            }
        } catch (Exception e2) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ActivityManager", e2);
        }
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
            if (intent != null) {
                intent.setFlags(335544320);
                a(intent, map);
            } else {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
            }
        } catch (Exception e3) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e3.getMessage());
        }
        return intent;
    }

    private static Intent a(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int a(Intent intent, String str) {
        int iA = a(intent);
        u.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(iA)));
        if (iA != 0) {
            return iA;
        }
        int iB = b(intent, str);
        u.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(iB)));
        if (iB != 0) {
            return iB;
        }
        return 0;
    }

    private int a(Intent intent) {
        if (intent.resolveActivityInfo(this.f8661c.getPackageManager(), 65536) != null) {
            return 0;
        }
        u.a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
        u.c(this.f8661c, " \u8df3\u8f6c\u53c2\u6570\u5bf9\u5e94\u7684Activity\u627e\u4e0d\u5230 \u901a\u77e5\u4e0d\u5c55\u793a   2162");
        return 2162;
    }

    private static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && !intent.hasExtra(entry.getKey())) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int b(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : intent.getPackage();
                if (TextUtils.isEmpty(packageName) || TextUtils.equals(str, packageName)) {
                    return 0;
                }
                u.d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + str + "; but remote pkgName is " + packageName);
                u.a(this.f8661c, " \u8df3\u8f6c\u53c2\u6570\u5bf9\u5e94\u7684\u5305\u540d\u4e0d\u662f\u5f53\u524d\u5e94\u7528\u5305\u540d    local pkgName is " + str + "; but remote pkgName is " + packageName + " code =2813");
                return 2813;
            } catch (Exception e2) {
                u.a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e2.getMessage());
                return 2158;
            }
        }
        StringBuilder sb = new StringBuilder("checkSkipContentPackageFit intent = : ");
        Object obj = intent;
        if (intent == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(" mPkgName = ");
        sb.append(str);
        u.a("AndroidTwelveNotifyClickIntentParam", sb.toString());
        return 2158;
    }
}
