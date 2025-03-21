package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.C3211c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.p213c.C3269b;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3291i;
import com.tencent.open.utils.C3292j;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.C3298a;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class SocialApiIml extends BaseApi {

    /* renamed from: a */
    private Activity f11098a;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.SocialApiIml$a */
    private class C3244a extends DefaultUiListener {

        /* renamed from: b */
        private IUiListener f11100b;

        /* renamed from: c */
        private String f11101c;

        /* renamed from: d */
        private String f11102d;

        /* renamed from: e */
        private Bundle f11103e;

        /* renamed from: f */
        private Activity f11104f;

        C3244a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.f11100b = iUiListener;
            this.f11101c = str;
            this.f11102d = str2;
            this.f11103e = bundle;
            this.f11104f = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f11100b.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e2) {
                e2.printStackTrace();
                SLog.m10501e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e2);
                str = null;
            }
            this.f11103e.putString("encrytoken", str);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.m10378a((Context) socialApiIml.f11098a, this.f11101c, this.f11103e, this.f11102d, this.f11100b);
            if (TextUtils.isEmpty(str)) {
                SLog.m10498d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f11104f);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.m10498d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.f11100b.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        m10376a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    @Override // com.tencent.connect.common.BaseApi
    /* renamed from: b */
    protected Intent mo10317b(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
        if (C3295m.m10694c(C3289g.m10603a()) && C3293k.m10637a(C3289g.m10603a(), intent)) {
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        if (C3293k.m10637a(C3289g.m10603a(), intent2) && C3293k.m10645c(C3289g.m10603a(), "4.7") >= 0) {
            return intent2;
        }
        Intent intent3 = new Intent();
        intent3.setClassName(Constants.PACKAGE_QZONE, str);
        if (C3293k.m10637a(C3289g.m10603a(), intent3) && C3293k.m10628a(C3293k.m10634a(C3289g.m10603a(), Constants.PACKAGE_QZONE), "4.2") >= 0 && C3293k.m10638a(C3289g.m10603a(), intent3.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
            return intent3;
        }
        return null;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        m10376a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f11098a = activity;
        Intent m10320c = m10320c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (m10320c == null) {
            SLog.m10502i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            m10320c = m10320c(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(m10318b());
        m10375a(activity, m10320c, SocialConstants.ACTION_INVITE, bundle, C3292j.m10626a().m10627a(C3289g.m10603a(), "https://imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f11098a = activity;
        Intent m10320c = m10320c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(m10318b());
        m10375a(activity, m10320c, SocialConstants.ACTION_STORY, bundle, C3292j.m10626a().m10627a(C3289g.m10603a(), "https://imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String str;
        String accessToken = this.f11013c.getAccessToken();
        String appId = this.f11013c.getAppId();
        String openId = this.f11013c.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            str = C3295m.m10704g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        C3269b c3269b = new C3269b(context);
        WebSettings settings = c3269b.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        C3298a.m10720a(c3269b);
        String str2 = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f11013c.getOpenId() + AbstractC1191a.f2606s1 + this.f11013c.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>";
        String m10627a = C3292j.m10626a().m10627a(context, "https://imgcache.qq.com");
        c3269b.loadDataWithBaseURL(m10627a, str2, "text/html", "utf-8", m10627a);
    }

    public SocialApiIml(C3211c c3211c, QQToken qQToken) {
        super(c3211c, qQToken);
    }

    /* renamed from: a */
    private void m10376a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.f11098a = activity;
        Intent m10320c = m10320c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (m10320c == null) {
            SLog.m10502i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            m10320c = m10320c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = m10320c;
        bundle.putAll(m10318b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_REQUEST);
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        m10375a(activity, intent, str, bundle, C3292j.m10626a().m10627a(C3289g.m10603a(), "https://imgcache.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    /* renamed from: a */
    private void m10375a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        boolean z2 = true;
        sb.append(intent == null);
        SLog.m10502i("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            m10374a(activity, intent, str, bundle, iUiListener);
            return;
        }
        C3291i m10615a = C3291i.m10615a(C3289g.m10603a(), this.f11013c.getAppId());
        if (!z && !m10615a.m10625b("C_LoginH5")) {
            z2 = false;
        }
        if (z2) {
            m10377a(activity, str, bundle, str2, iUiListener);
        } else {
            m10313a(activity, bundle, iUiListener);
        }
    }

    /* renamed from: a */
    private void m10374a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        m10311a(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    /* renamed from: a */
    private void m10377a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent m10319c = m10319c();
        IUiListener c3244a = new C3244a(activity, iUiListener, str, str2, bundle);
        Intent mo10317b = mo10317b("com.tencent.open.agent.EncryTokenActivity");
        if (mo10317b != null && m10319c != null && m10319c.getComponent() != null && mo10317b.getComponent() != null && m10319c.getComponent().getPackageName().equals(mo10317b.getComponent().getPackageName())) {
            mo10317b.putExtra("oauth_consumer_key", this.f11013c.getAppId());
            mo10317b.putExtra("openid", this.f11013c.getOpenId());
            mo10317b.putExtra("access_token", this.f11013c.getAccessToken());
            mo10317b.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            SLog.m10502i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, c3244a);
            m10311a(activity, mo10317b, Constants.REQUEST_SOCIAL_H5);
            return;
        }
        SLog.m10502i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String m10704g = C3295m.m10704g("tencent&sdk&qazxc***14969%%" + this.f11013c.getAccessToken() + this.f11013c.getAppId() + this.f11013c.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, m10704g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c3244a.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10378a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.m10506v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.f11013c.getAppId());
        if (this.f11013c.isSessionValid()) {
            bundle.putString("access_token", this.f11013c.getAccessToken());
        }
        String openId = this.f11013c.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString("pf", C3289g.m10603a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
        } catch (Exception e2) {
            e2.printStackTrace();
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        SLog.m10498d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            new TDialog(this.f11098a, str, str3, iUiListener, this.f11013c).show();
        } else {
            SLog.m10498d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new DialogC3272d(this.f11098a, str, str3, iUiListener, this.f11013c).show();
        }
    }
}
