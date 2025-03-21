package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* loaded from: classes2.dex */
public class UmengInAppClickHandler implements UInAppHandler {

    /* renamed from: a */
    private static final String f13110a = "com.umeng.message.inapp.UmengInAppClickHandler";

    /* renamed from: b */
    private String f13111b = null;

    /* renamed from: c */
    private String f13112c = null;

    /* renamed from: d */
    private String f13113d = null;

    @Override // com.umeng.message.inapp.UInAppHandler
    public final void handleInAppMessage(Activity activity, UInAppMessage uInAppMessage, int i2) {
        switch (i2) {
            case 16:
                this.f13111b = uInAppMessage.action_type;
                this.f13112c = uInAppMessage.action_activity;
                this.f13113d = uInAppMessage.action_url;
                break;
            case 17:
                this.f13111b = uInAppMessage.bottom_action_type;
                this.f13112c = uInAppMessage.bottom_action_activity;
                this.f13113d = uInAppMessage.bottom_action_url;
                break;
            case 18:
                this.f13111b = uInAppMessage.plainTextActionType;
                this.f13112c = uInAppMessage.plainTextActivity;
                this.f13113d = uInAppMessage.plainTextUrl;
                break;
            case 19:
                this.f13111b = uInAppMessage.customButtonActionType;
                this.f13112c = uInAppMessage.customButtonActivity;
                this.f13113d = uInAppMessage.customButtonUrl;
                break;
        }
        if (TextUtils.isEmpty(this.f13111b)) {
            return;
        }
        if (TextUtils.equals("go_activity", this.f13111b)) {
            openActivity(activity, this.f13112c);
        } else if (TextUtils.equals("go_url", this.f13111b)) {
            openUrl(activity, this.f13113d);
        } else {
            TextUtils.equals("go_app", this.f13111b);
        }
    }

    public void openActivity(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(f13110a, 2, "打开Activity: ".concat(String.valueOf(str)));
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
                UMLog.mutlInfo(f13110a, 2, "打开链接: ".concat(String.valueOf(str)));
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
