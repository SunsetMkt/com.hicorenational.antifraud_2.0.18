package com.tencent.open.miniapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.connect.C3202a;
import com.tencent.connect.auth.C3211c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class MiniApp extends BaseApi {
    public static final int MINIAPP_CONTEXT_NULL = -6;
    public static final int MINIAPP_ID_EMPTY = -1;
    public static final int MINIAPP_ID_NOT_DIGIT = -4;
    public static final int MINIAPP_SHOULD_DOWNLOAD = -2;
    public static final String MINIAPP_SRC_ID = "21";
    public static final int MINIAPP_SRC_ID_NOT_DIGIT = -3;
    public static final int MINIAPP_SUCCESS = 0;
    public static final String MINIAPP_TYPE_NORMAL = "mini_program_or_game";
    public static final int MINIAPP_UNKNOWN_TYPE = -5;
    public static final String MINIAPP_VERSION_RELEASE = "release";
    public static final int MINIAPP_VERSION_WRONG = -7;
    public static final String MINIAPP_VERSION_DEVELOP = "develop";
    public static final String MINIAPP_VERSION_TRIAL = "trial";
    public static final List<String> OPEN_CONNECT_DEMO_MINI_APP_VERSIONS = Arrays.asList(MINIAPP_VERSION_DEVELOP, MINIAPP_VERSION_TRIAL, "release");

    public MiniApp(Context context, C3211c c3211c, QQToken qQToken) {
        super(c3211c, qQToken);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3, String str4, String str5) {
        if (C3202a.m10152a("openSDK_LOG.MiniApp", null)) {
            return -5;
        }
        if (activity == null) {
            SLog.m10502i("openSDK_LOG.MiniApp", "Result is MINIAPP_CONTEXT_NULL : -6");
            return -6;
        }
        if (!MINIAPP_TYPE_NORMAL.equals(str)) {
            SLog.m10502i("openSDK_LOG.MiniApp", "Result is MINIAPP_UNKNOWN_TYPE : -5");
            return -5;
        }
        if (TextUtils.isEmpty(str2)) {
            SLog.m10502i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_EMPTY : -1");
            return -1;
        }
        for (int i2 = 0; i2 < str2.length(); i2++) {
            if (!Character.isDigit(str2.charAt(i2))) {
                SLog.m10502i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_NOT_DIGIT : -4");
                return -4;
            }
        }
        String str6 = str4 == null ? "" : str4;
        if (!OPEN_CONNECT_DEMO_MINI_APP_VERSIONS.contains(str5)) {
            SLog.m10502i("openSDK_LOG.MiniApp", "Result is MINIAPP_VERSION_WRONG : -7");
            return -7;
        }
        if (!C3295m.m10699e(activity)) {
            try {
                new TDialog(activity, "", m10309a(""), null, this.f11013c).show();
            } catch (RuntimeException e2) {
                SLog.m10500e("openSDK_LOG.MiniApp", "Show download dialog exception:" + e2.getMessage());
            }
            SLog.m10502i("openSDK_LOG.MiniApp", "Result is MINIAPP_SHOULD_DOWNLOAD : -2");
            return -2;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.mobileqq");
        intent.setData(Uri.parse(String.format("mqqapi://connect_miniapp/launch?app_type=%1$s&mini_app_id=%2$s&version=1&src_type=app&app_name=%3$s&app_id=%4$s&src_id=%5$s&mini_app_path=%6$s&mini_app_type=%7$s&open_id=%8$s", str, str2, C3295m.m10712k(C3293k.m10633a((Context) activity)), C3295m.m10712k(this.f11013c.getAppId()), str3, C3295m.m10712k(str6), C3295m.m10712k(str5), C3295m.m10712k(this.f11013c.getOpenId()))));
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        try {
            try {
                activity.startActivity(intent);
                SLog.m10502i("openSDK_LOG.MiniApp", "Result is MINIAPP_SUCCESS : 0");
                return 0;
            } catch (RuntimeException e3) {
                SLog.m10500e("openSDK_LOG.MiniApp", "Show download dialog exception:" + e3.getMessage());
                SLog.m10502i("openSDK_LOG.MiniApp", "QQ is not installed, Result is MINIAPP_SHOULD_DOWNLOAD : -2");
                return -2;
            }
        } catch (ActivityNotFoundException unused) {
            new TDialog(activity, "", m10309a(""), null, this.f11013c).show();
            SLog.m10502i("openSDK_LOG.MiniApp", "QQ is not installed, Result is MINIAPP_SHOULD_DOWNLOAD : -2");
            return -2;
        }
    }

    public MiniApp(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public MiniApp(QQToken qQToken) {
        super(qQToken);
    }
}
