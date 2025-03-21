package com.tencent.connect.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import anet.channel.strategy.dispatch.DispatchConstants;
import cn.cloudwalk.util.LogUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.auth.C3211c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3288f;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public abstract class BaseApi {
    public static String businessId = null;
    public static String installChannel = null;
    public static boolean isOEM = false;
    public static String registerChannel;

    /* renamed from: b */
    protected C3211c f11012b;

    /* renamed from: c */
    protected QQToken f11013c;

    /* compiled from: ProGuard */
    public class TempRequestListener implements IRequestListener {

        /* renamed from: b */
        private final IUiListener f11015b;

        /* renamed from: c */
        private final Handler f11016c;

        public TempRequestListener(IUiListener iUiListener) {
            this.f11015b = iUiListener;
            this.f11016c = new Handler(C3289g.m10603a().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.f11015b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.f11015b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message obtainMessage = this.f11016c.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.f11016c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.f11016c.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.f11016c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message obtainMessage = this.f11016c.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.f11016c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message obtainMessage = this.f11016c.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.f11016c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message obtainMessage = this.f11016c.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.f11016c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.f11016c.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.f11016c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.f11016c.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.f11016c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message obtainMessage = this.f11016c.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.f11016c.sendMessage(obtainMessage);
        }
    }

    public BaseApi(C3211c c3211c, QQToken qQToken) {
        this.f11012b = c3211c;
        this.f11013c = qQToken;
    }

    /* renamed from: a */
    protected Bundle m10308a() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", C3288f.m10596a().m10601c(C3289g.m10603a()));
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        QQToken qQToken = this.f11013c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.f11013c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.f11013c.getAppId());
            bundle.putString("openid", this.f11013c.getOpenId());
        }
        SharedPreferences sharedPreferences = C3289g.m10603a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + DispatchConstants.ANDROID + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Bundle m10318b() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f11013c.getAppId());
        if (this.f11013c.isSessionValid()) {
            bundle.putString(Constants.PARAM_KEY_STR, this.f11013c.getAccessToken());
            bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
        }
        String openId = this.f11013c.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = C3289g.m10603a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + DispatchConstants.ANDROID + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    /* renamed from: c */
    protected Intent m10319c() {
        Intent intent = new Intent();
        if (C3295m.m10694c(C3289g.m10603a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, "com.tencent.open.agent.AgentActivity");
            if (C3293k.m10644b(C3289g.m10603a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
        if (C3293k.m10644b(C3289g.m10603a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, "com.tencent.open.agent.AgentActivity");
        if (C3293k.m10644b(C3289g.m10603a(), intent)) {
            return intent;
        }
        return null;
    }

    public void releaseResource() {
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    /* renamed from: c */
    protected Intent m10320c(String str) {
        Intent intent = new Intent();
        Intent mo10317b = mo10317b(str);
        if (mo10317b == null || mo10317b.getComponent() == null) {
            return null;
        }
        intent.setClassName(mo10317b.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public String m10309a(String str) {
        Bundle m10308a = m10308a();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            m10308a.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.encodeUrl(m10308a));
        return sb.toString();
    }

    /* renamed from: b */
    protected Intent mo10317b(String str) {
        Intent intent = new Intent();
        if (C3295m.m10694c(C3289g.m10603a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
            if (C3293k.m10637a(C3289g.m10603a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (C3293k.m10637a(C3289g.m10603a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, str);
        if (C3293k.m10637a(C3289g.m10603a(), intent)) {
            return intent;
        }
        return null;
    }

    /* renamed from: a */
    protected void m10315a(StringBuilder sb, Activity activity) {
        if (sb.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(Constants.JumpUrlConstants.URL_KEY_SRC);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(Constants.JumpUrlConstants.SRC_TYPE_APP);
        String appId = this.f11013c.getAppId();
        String openId = this.f11013c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            m10316a(sb, "app_id", appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            m10316a(sb, "open_id", C3295m.m10712k(openId));
        }
        String m10669a = C3295m.m10669a(activity);
        if (!TextUtils.isEmpty(m10669a)) {
            if (m10669a.length() > 20) {
                m10669a = m10669a.substring(0, 20) + "...";
            }
            m10316a(sb, "app_name", C3295m.m10712k(m10669a));
        }
        m10316a(sb, "sdk_version", C3295m.m10712k(Constants.SDK_VERSION));
    }

    /* renamed from: a */
    protected void m10316a(StringBuilder sb, String str, String str2) {
        sb.append("&");
        sb.append(str);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(C3295m.m10701f(str2));
    }

    /* renamed from: a */
    private Intent m10306a(Activity activity, Intent intent, Map<String, Object> map, int i2) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        intent2.putExtra("is_login", true);
        m10307a(activity, intent2, intent, i2);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(Constants.KEY_RESTORE_LANDSCAPE)) {
                intent2.putExtra(Constants.KEY_RESTORE_LANDSCAPE, ((Boolean) map.get(Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
            }
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.BaseApi", LogUtils.LOG_EXCEPTION, e2);
        }
        return intent2;
    }

    /* renamed from: a */
    protected void m10310a(Activity activity, int i2, Intent intent, boolean z) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        m10307a(activity, intent2, intent, i2);
        try {
            activity.startActivityForResult(intent2, i2);
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.BaseApi", "startAssistActivity exception", e2);
        }
    }

    /* renamed from: a */
    protected void m10311a(Activity activity, Intent intent, int i2) {
        m10312a(activity, intent, i2, (Map<String, Object>) null);
    }

    /* renamed from: a */
    protected void m10312a(Activity activity, Intent intent, int i2, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i2);
        try {
            activity.startActivityForResult(m10306a(activity, intent, map, i2), i2);
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.BaseApi", "startAssitActivity exception", e2);
        }
    }

    /* renamed from: a */
    protected void m10314a(Fragment fragment, Intent intent, int i2, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i2);
        try {
            fragment.startActivityForResult(m10306a(fragment.getActivity(), intent, map, i2), i2);
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.BaseApi", "startAssitActivity exception", e2);
        }
    }

    /* renamed from: a */
    private void m10307a(Activity activity, Intent intent, Intent intent2, int i2) {
        PendingIntent activity2;
        if (intent == null || intent2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 16 && intent2.getClipData() == null) {
                intent2.setClipData(ClipData.newPlainText(null, null));
            }
            int flags = intent2.getFlags();
            if (Build.VERSION.SDK_INT >= 21) {
                intent2.setFlags(flags & (-196));
            } else if (Build.VERSION.SDK_INT >= 19) {
                intent2.setFlags(flags & (-68));
            } else {
                intent2.setFlags(flags & (-4));
            }
        } catch (Throwable th) {
            SLog.m10501e("openSDK_LOG.BaseApi", "setActivityIntent security catch exception", th);
        }
        intent.putExtra(AssistActivity.KEY_REQUEST_ORIENTATION, activity.getRequestedOrientation());
        intent.putExtra(AssistActivity.EXTRA_INTENT, intent2);
        try {
            SLog.m10502i("openSDK_LOG.BaseApi", "setActivityIntent requestCode: " + i2);
            if (Build.VERSION.SDK_INT >= 23) {
                activity2 = PendingIntent.getActivity(activity, i2, intent2, 1140850688);
            } else {
                activity2 = PendingIntent.getActivity(activity, i2, intent2, 1073741824);
            }
            intent.putExtra(AssistActivity.KEY_EXTRA_PENDING_INTENT, activity2);
        } catch (Throwable th2) {
            SLog.m10501e("openSDK_LOG.BaseApi", "setActivityIntent create pendingIntent exception", th2);
        }
    }

    /* renamed from: a */
    protected void m10313a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new TDialog(activity, "", "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.f11013c).show();
    }
}
