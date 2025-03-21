package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import c.c.a.b.a.a;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.aw;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* loaded from: classes2.dex */
public class UmengNotificationClickHandler implements UPushMessageHandler {
    private static void a(Intent intent, UMessage uMessage) {
        if (intent == null || uMessage == null || uMessage.getExtra() == null) {
            return;
        }
        for (Map.Entry<String, String> entry : uMessage.getExtra().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                intent.putExtra(key, value);
            }
        }
    }

    public void changeBadgeNum(Context context, UMessage uMessage) {
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        if (TextUtils.equals(uMessage.getMsgId(), messageSharedPrefs.f())) {
            return;
        }
        messageSharedPrefs.c(uMessage.getMsgId());
        aw.b(context, -1);
    }

    public void dealWithCustomAction(Context context, UMessage uMessage) {
    }

    public void dismissNotification(Context context, UMessage uMessage) {
    }

    protected Intent getMainIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.setFlags(a.B1);
        return launchIntentForPackage;
    }

    @Override // com.umeng.message.api.UPushMessageHandler
    public void handleMessage(Context context, UMessage uMessage) {
        try {
            if (uMessage.dismiss) {
                dismissNotification(context, uMessage);
                return;
            }
            String action = uMessage.getAction();
            if (!TextUtils.equals("go_app", action)) {
                if (TextUtils.equals("go_url", action)) {
                    openUrl(context, uMessage);
                } else if (TextUtils.equals("go_activity", action)) {
                    openActivity(context, uMessage);
                } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_CUSTOM, action)) {
                    dealWithCustomAction(context, uMessage);
                } else if (uMessage.getDeeplink() != null && !TextUtils.isEmpty(uMessage.getDeeplink().trim())) {
                    openUrl(context, uMessage);
                } else if (uMessage.getActivity() != null && !TextUtils.isEmpty(uMessage.getActivity().trim())) {
                    openActivity(context, uMessage);
                } else if (uMessage.getCustom() != null && !TextUtils.isEmpty(uMessage.getContent().trim())) {
                    dealWithCustomAction(context, uMessage);
                }
                changeBadgeNum(context, uMessage);
            }
            launchApp(context, uMessage);
            changeBadgeNum(context, uMessage);
        } catch (Throwable th) {
            UPLog.e("UmengNotificationClickHandler", th);
        }
    }

    public void launchApp(Context context, UMessage uMessage) {
        try {
            Intent mainIntent = getMainIntent(context);
            if (mainIntent == null) {
                UPLog.e("UmengNotificationClickHandler", "can't find launchIntent:", context.getPackageName());
                return;
            }
            mainIntent.addFlags(CommonNetImpl.FLAG_AUTH);
            a(mainIntent, uMessage);
            UPLog.d("UmengNotificationClickHandler", "open app:", context.getPackageName());
            context.startActivity(mainIntent);
        } catch (Throwable th) {
            UPLog.e("UmengNotificationClickHandler", th);
        }
    }

    public void openActivity(Context context, UMessage uMessage) {
        try {
            String activity = uMessage.getActivity();
            if (activity == null) {
                return;
            }
            String trim = activity.trim();
            if (TextUtils.isEmpty(trim)) {
                return;
            }
            UPLog.d("UmengNotificationClickHandler", "open activity:", trim);
            Intent intent = new Intent();
            a(intent, uMessage);
            intent.setClassName(context, trim);
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent);
        } catch (Throwable th) {
            UPLog.e("UmengNotificationClickHandler", th);
        }
    }

    public void openUrl(Context context, UMessage uMessage) {
        try {
            String deeplink = uMessage.getDeeplink();
            if (deeplink == null) {
                return;
            }
            String trim = deeplink.trim();
            if (TextUtils.isEmpty(trim)) {
                return;
            }
            UPLog.d("UmengNotificationClickHandler", "open deeplink:".concat(String.valueOf(trim)));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(trim));
            a(intent, uMessage);
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent);
        } catch (Throwable th) {
            UPLog.e("UmengNotificationClickHandler", th);
        }
    }
}
