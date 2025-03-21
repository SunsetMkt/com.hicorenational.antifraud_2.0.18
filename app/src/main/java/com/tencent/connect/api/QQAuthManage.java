package com.tencent.connect.api;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.connect.C3202a;
import com.tencent.connect.auth.C3211c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.apireq.BaseResp;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3293k;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class QQAuthManage extends BaseApi {

    /* compiled from: ProGuard */
    public static class Resp extends BaseResp {
    }

    public QQAuthManage(C3211c c3211c, QQToken qQToken) {
        super(c3211c, qQToken);
    }

    public void gotoManagePage(final Activity activity, final IApiCallback iApiCallback) {
        SLog.m10502i("QQAuthManage", "gotoManagePage");
        final Resp resp = new Resp();
        if (C3202a.m10152a("QQAuthManage", null)) {
            resp.setCode(BaseResp.CODE_PERMISSION_NOT_GRANTED);
            iApiCallback.onResp(resp);
            return;
        }
        int m10159a = m10159a(activity);
        if (m10159a != 0) {
            resp.setCode(m10159a);
            iApiCallback.onResp(resp);
        } else {
            if (this.f11013c.isSessionValid() && this.f11013c.getOpenId() != null) {
                this.f11012b.m10244a(new IUiListener() { // from class: com.tencent.connect.api.QQAuthManage.1
                    @Override // com.tencent.tauth.IUiListener
                    public void onCancel() {
                    }

                    @Override // com.tencent.tauth.IUiListener
                    public void onComplete(Object obj) {
                        if (obj instanceof JSONObject) {
                            if (((JSONObject) obj).optInt("ret", -1) == 0) {
                                QQAuthManage.this.m10160a(activity, iApiCallback);
                                return;
                            }
                            SLog.m10502i("QQAuthManage", "gotoManagePage: checkLogin not login");
                            resp.setCode(-2001);
                            iApiCallback.onResp(resp);
                        }
                    }

                    @Override // com.tencent.tauth.IUiListener
                    public void onError(UiError uiError) {
                        resp.setCode(uiError.errorCode);
                        resp.setErrorMsg(uiError.errorMessage);
                        SLog.m10500e("QQAuthManage", "gotoManagePage: checkLogin error. " + resp);
                        iApiCallback.onResp(resp);
                    }

                    @Override // com.tencent.tauth.IUiListener
                    public void onWarning(int i2) {
                    }
                });
                return;
            }
            SLog.m10502i("QQAuthManage", "gotoManagePage: not login");
            resp.setCode(-2001);
            iApiCallback.onResp(resp);
        }
    }

    /* renamed from: a */
    private int m10159a(Activity activity) {
        if (!C3293k.m10647c(activity)) {
            SLog.m10502i("QQAuthManage", "gotoManagePage: not installed all qq");
            return -1000;
        }
        if (!C3293k.m10643b(activity)) {
            SLog.m10502i("QQAuthManage", "gotoManagePage: only support mobile qq");
            return BaseResp.CODE_UNSUPPORTED_BRANCH;
        }
        if (C3293k.m10645c(activity, "8.6.0") >= 0) {
            return 0;
        }
        SLog.m10502i("QQAuthManage", "gotoManagePage: low version");
        return BaseResp.CODE_QQ_LOW_VERSION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10160a(Activity activity, IApiCallback iApiCallback) {
        SLog.m10502i("QQAuthManage", "doGotoMangePage");
        StringBuilder sb = new StringBuilder("mqqapi://opensdk/open_auth_manage");
        m10315a(sb, activity);
        Intent intent = new Intent();
        intent.setData(Uri.parse(sb.toString()));
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setPackage("com.tencent.mobileqq");
        intent.setFlags(335544320);
        activity.startActivity(intent);
        iApiCallback.onResp(new Resp());
    }
}
