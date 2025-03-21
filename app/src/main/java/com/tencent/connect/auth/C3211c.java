package com.tencent.connect.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.p207a.C3203a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3284b;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.util.Map;
import p000a.p001a.p014u.C0052a;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.auth.c */
/* loaded from: classes2.dex */
public class C3211c {

    /* renamed from: a */
    private AuthAgent f10944a;

    /* renamed from: b */
    private QQToken f10945b;

    private C3211c(String str, Context context) {
        SLog.m10502i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f10945b = new QQToken(str);
        this.f10944a = new AuthAgent(this.f10945b);
        C3203a.m10157c(context, this.f10945b);
        m10235a(context, Constants.SDK_VERSION);
        SLog.m10502i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    /* renamed from: a */
    public static void m10235a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("bcb3903995", str);
        edit.apply();
    }

    /* renamed from: b */
    public int m10246b(Activity activity, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.QQAuth", "reAuth()");
        return this.f10944a.m10180a(activity, str, iUiListener, true, null, false);
    }

    /* renamed from: c */
    public boolean m10249c() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSessionValid(), result = ");
        sb.append(this.f10945b.isSessionValid() ? C0052a.f158j : C0052a.f159k);
        SLog.m10502i("openSDK_LOG.QQAuth", sb.toString());
        return this.f10945b.isSessionValid();
    }

    /* renamed from: b */
    public QQToken m10247b() {
        return this.f10945b;
    }

    /* renamed from: b */
    public void m10248b(Context context, String str) {
        SLog.m10502i("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.f10945b.setOpenId(str);
        C3203a.m10158d(context, this.f10945b);
        SLog.m10502i("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    /* renamed from: a */
    public static C3211c m10234a(String str, Context context) {
        C3289g.m10605a(context.getApplicationContext());
        SLog.m10502i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        C3211c c3211c = new C3211c(str, context);
        SLog.m10502i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        return c3211c;
    }

    /* renamed from: a */
    public int m10237a(Activity activity, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.QQAuth", "login()");
        return m10238a(activity, str, iUiListener, "");
    }

    /* renamed from: a */
    public int m10239a(Activity activity, String str, IUiListener iUiListener, boolean z) {
        SLog.m10502i("openSDK_LOG.QQAuth", "login()");
        return m10232a(activity, null, str, iUiListener, "", z);
    }

    /* renamed from: a */
    public int m10236a(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.m10502i("openSDK_LOG.QQAuth", "login--params");
        return m10233a(activity, (Fragment) null, C3295m.m10673a(map, Constants.KEY_SCOPE, "all"), iUiListener, "", C3295m.m10682a(map, Constants.KEY_QRCODE, false), map);
    }

    /* renamed from: a */
    public int m10238a(Activity activity, String str, IUiListener iUiListener, String str2) {
        SLog.m10502i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return m10231a(activity, (Fragment) null, str, iUiListener, str2);
    }

    /* renamed from: a */
    public int m10241a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        FragmentActivity activity = fragment.getActivity();
        SLog.m10502i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return m10231a(activity, fragment, str, iUiListener, str2);
    }

    /* renamed from: a */
    public int m10242a(Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        FragmentActivity activity = fragment.getActivity();
        SLog.m10502i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return m10232a(activity, fragment, str, iUiListener, str2, z);
    }

    /* renamed from: a */
    private int m10231a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        return m10232a(activity, fragment, str, iUiListener, str2, false);
    }

    /* renamed from: a */
    private int m10232a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        return m10233a(activity, fragment, str, iUiListener, str2, z, (Map<String, Object>) null);
    }

    /* renamed from: a */
    private int m10233a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z, Map<String, Object> map) {
        try {
            String m10631a = C3293k.m10631a(activity);
            if (m10631a != null) {
                String m10581a = C3284b.m10581a(new File(m10631a));
                if (!TextUtils.isEmpty(m10581a)) {
                    SLog.m10506v("openSDK_LOG.QQAuth", "-->login channelId: " + m10581a);
                    return m10240a(activity, str, iUiListener, z, m10581a, m10581a, "");
                }
            }
        } catch (Throwable th) {
            SLog.m10501e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
        }
        SLog.m10498d("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.f10944a.doLogin(activity, str, iUiListener, false, fragment, z, map);
    }

    @Deprecated
    /* renamed from: a */
    public int m10240a(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        SLog.m10502i("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = AbstractC1191a.f2571h;
        }
        if (str3.equals("")) {
            str3 = AbstractC1191a.f2571h;
        }
        if (str4.equals("")) {
            str4 = AbstractC1191a.f2571h;
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.f10944a.m10180a(activity, str, iUiListener, false, null, z);
    }

    /* renamed from: a */
    public void m10243a() {
        this.f10944a.m10181a((IUiListener) null);
    }

    /* renamed from: a */
    public void m10244a(IUiListener iUiListener) {
        this.f10944a.m10182b(iUiListener);
    }

    /* renamed from: a */
    public void m10245a(String str, String str2) {
        SLog.m10502i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.f10945b.setAccessToken(str, str2);
    }
}
