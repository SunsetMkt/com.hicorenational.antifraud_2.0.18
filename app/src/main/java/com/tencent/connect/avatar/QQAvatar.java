package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import cn.cloudwalk.util.LogUtils;
import com.tencent.connect.C3202a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import com.tencent.tauth.IUiListener;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class QQAvatar extends BaseApi {
    public static final String FROM_SDK_AVATAR_SET_IMAGE = "FROM_SDK_AVATAR_SET_IMAGE";

    /* renamed from: a */
    private IUiListener f10982a;

    public QQAvatar(QQToken qQToken) {
        super(qQToken);
    }

    /* renamed from: a */
    private Intent m10290a(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ImageActivity.class);
        return intent;
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iUiListener, int i2) {
        if (C3202a.m10152a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f10982a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f10982a = iUiListener;
        Bundle bundle = new Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i2);
        bundle.putString("appid", this.f11013c.getAppId());
        bundle.putString("access_token", this.f11013c.getAccessToken());
        bundle.putLong("expires_in", this.f11013c.getExpireTimeInSecond());
        bundle.putString("openid", this.f11013c.getOpenId());
        Intent m10290a = m10290a(activity);
        Bundle m10665a = C3295m.m10665a(this.f11013c.getOpenId(), Constants.VIA_SET_AVATAR, "12", "18", this.f11013c.getAppId());
        m10290a.putExtra(Constants.KEY_PASS_REPORT_VIA_TIMELY, true);
        m10290a.putExtra(Constants.KEY_PASS_REPORT_VIA_PARAM, m10665a);
        m10291a(activity, bundle, m10290a);
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        if (C3202a.m10152a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f10982a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f10982a = iUiListener;
        if (!C3293k.m10643b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (C3293k.m10645c(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String m10669a = C3295m.m10669a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_avatar_edit?");
        if (!TextUtils.isEmpty(m10669a)) {
            if (m10669a.length() > 20) {
                m10669a = m10669a.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(C3295m.m10711j(m10669a), 2));
        }
        String appId = this.f11013c.getAppId();
        String openId = this.f11013c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(C3295m.m10711j(openId), 2));
        }
        String m10686b = C3295m.m10686b(activity, uri);
        if (!TextUtils.isEmpty(m10686b)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&set_uri=" + Base64.encodeToString(C3295m.m10711j(uri.toString()), 2));
            } catch (Exception e2) {
                SLog.m10501e("QQAvatar", LogUtils.LOG_EXCEPTION, e2);
            }
        }
        if (!TextUtils.isEmpty(m10686b)) {
            stringBuffer.append("&set_path=" + Base64.encodeToString(C3295m.m10711j(m10686b), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(C3295m.m10711j(Constants.SDK_VERSION), 2));
        SLog.m10506v("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_AVATAR, iUiListener);
        m10310a(activity, Constants.REQUEST_EDIT_AVATAR, intent, false);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        if (C3202a.m10152a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f10982a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f10982a = iUiListener;
        if (!C3293k.m10643b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (C3293k.m10645c(activity, "8.0.5") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String m10669a = C3295m.m10669a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
        if (!TextUtils.isEmpty(m10669a)) {
            if (m10669a.length() > 20) {
                m10669a = m10669a.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(C3295m.m10711j(m10669a), 2));
        }
        String appId = this.f11013c.getAppId();
        String openId = this.f11013c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(C3295m.m10711j(openId), 2));
        }
        String m10686b = C3295m.m10686b(activity, uri);
        if (!TextUtils.isEmpty(m10686b)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&video_uri=");
                stringBuffer.append(Base64.encodeToString(C3295m.m10711j(uri.toString()), 2));
            } catch (Exception e2) {
                SLog.m10501e("QQAvatar", LogUtils.LOG_EXCEPTION, e2);
            }
        }
        if (!TextUtils.isEmpty(m10686b)) {
            stringBuffer.append("&video_path=" + Base64.encodeToString(C3295m.m10711j(m10686b), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(C3295m.m10711j(Constants.SDK_VERSION), 2));
        SLog.m10506v("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_DYNAMIC_AVATAR, iUiListener);
        m10310a(activity, Constants.REQUEST_EDIT_DYNAMIC_AVATAR, intent, false);
    }

    /* renamed from: a */
    private void m10291a(Activity activity, Bundle bundle, Intent intent) {
        m10292a(bundle);
        intent.putExtra(Constants.KEY_ACTION, "action_avatar");
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_AVATER, this.f10982a);
        m10311a(activity, intent, Constants.REQUEST_AVATER);
    }

    /* renamed from: a */
    private void m10292a(Bundle bundle) {
        QQToken qQToken = this.f11013c;
        if (qQToken != null) {
            bundle.putString("appid", qQToken.getAppId());
            if (this.f11013c.isSessionValid()) {
                bundle.putString(Constants.PARAM_KEY_STR, this.f11013c.getAccessToken());
                bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
            }
            String openId = this.f11013c.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString("platform", "androidqz");
            try {
                bundle.putString("pf", C3289g.m10603a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
            } catch (Exception e2) {
                e2.printStackTrace();
                bundle.putString("pf", Constants.DEFAULT_PF);
            }
        }
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
    }
}
