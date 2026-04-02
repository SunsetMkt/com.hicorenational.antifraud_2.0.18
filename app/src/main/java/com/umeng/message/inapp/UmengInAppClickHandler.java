package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* JADX INFO: loaded from: classes2.dex */
public class UmengInAppClickHandler implements UInAppHandler {
    private static final String a = "com.umeng.message.inapp.UmengInAppClickHandler";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7922b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7923c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7924d = null;

    @Override // com.umeng.message.inapp.UInAppHandler
    public final void handleInAppMessage(Activity activity, UInAppMessage uInAppMessage, int i2) {
        switch (i2) {
            case 16:
                this.f7922b = uInAppMessage.action_type;
                this.f7923c = uInAppMessage.action_activity;
                this.f7924d = uInAppMessage.action_url;
                break;
            case 17:
                this.f7922b = uInAppMessage.bottom_action_type;
                this.f7923c = uInAppMessage.bottom_action_activity;
                this.f7924d = uInAppMessage.bottom_action_url;
                break;
            case 18:
                this.f7922b = uInAppMessage.plainTextActionType;
                this.f7923c = uInAppMessage.plainTextActivity;
                this.f7924d = uInAppMessage.plainTextUrl;
                break;
            case 19:
                this.f7922b = uInAppMessage.customButtonActionType;
                this.f7923c = uInAppMessage.customButtonActivity;
                this.f7924d = uInAppMessage.customButtonUrl;
                break;
        }
        if (TextUtils.isEmpty(this.f7922b)) {
            return;
        }
        if (TextUtils.equals("go_activity", this.f7922b)) {
            openActivity(activity, this.f7923c);
        } else if (TextUtils.equals("go_url", this.f7922b)) {
            openUrl(activity, this.f7924d);
        } else {
            TextUtils.equals("go_app", this.f7922b);
        }
    }

    public void openActivity(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(a, 2, "\u6253\u5f00Activity: ".concat(String.valueOf(str)));
                Intent intent = new Intent();
                intent.setClassName(activity, str);
                intent.setFlags(CommonNetImpl.FLAG_SHARE);
                activity.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void openUrl(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(a, 2, "\u6253\u5f00\u94fe\u63a5: ".concat(String.valueOf(str)));
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
