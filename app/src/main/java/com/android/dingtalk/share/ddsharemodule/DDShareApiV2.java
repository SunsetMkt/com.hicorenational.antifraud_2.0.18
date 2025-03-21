package com.android.dingtalk.share.ddsharemodule;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.dingtalk.share.ddsharemodule.message.BaseReq;
import com.android.dingtalk.share.ddsharemodule.message.DDMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDMessageAct;
import com.android.dingtalk.share.ddsharemodule.message.SendAuth;
import com.android.dingtalk.share.ddsharemodule.message.SendMessageToDD;
import com.android.dingtalk.share.ddsharemodule.plugin.DDVersionCheck;
import com.android.dingtalk.share.ddsharemodule.plugin.SignatureCheck;

/* loaded from: classes.dex */
public class DDShareApiV2 implements IDDShareApi {
    private static final String TAG = "DDShareApiV2";
    private String mAppId;
    private Context mContext;
    private boolean mNeedSignatureCheck;

    public DDShareApiV2(Context context, String str, boolean z) {
        this.mContext = context;
        this.mAppId = str;
        this.mNeedSignatureCheck = z;
    }

    protected boolean checkSumConsistent(Context context, String str) {
        if (this.mNeedSignatureCheck) {
            return TextUtils.equals(SignatureCheck.getMD5Signature(context, str), ShareConstant.DD_APP_SIGNATURE);
        }
        return true;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public int getDDSupportAPI() {
        return getDDSupportAPI(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean handleIntent(Intent intent, IDDAPIEventHandler iDDAPIEventHandler) {
        String stringExtra = intent.getStringExtra(ShareConstant.EXTRA_MESSAGE_APP_PACKAGE_NAME);
        if (stringExtra == null || stringExtra.length() == 0 || iDDAPIEventHandler == null) {
            return false;
        }
        int intExtra = intent.getIntExtra(ShareConstant.EXTRA_COMMAND_TYPE, 0);
        if (intExtra == 1) {
            iDDAPIEventHandler.onResp(new SendMessageToDD.Resp(intent.getExtras()));
            return true;
        }
        if (intExtra == 2) {
            iDDAPIEventHandler.onResp(new SendMessageToDD.Resp(intent.getExtras()));
            return true;
        }
        if (intExtra == 3) {
            iDDAPIEventHandler.onReq(new SendMessageToDD.Req(intent.getExtras()));
            return true;
        }
        if (intExtra == 4) {
            iDDAPIEventHandler.onReq(new SendMessageToDD.Req(intent.getExtras()));
            return true;
        }
        if (intExtra != 100) {
            return false;
        }
        SendAuth.Resp resp = new SendAuth.Resp();
        resp.fromBundle(intent.getExtras());
        iDDAPIEventHandler.onResp(resp);
        return true;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDAppInstalled() {
        return isDDAppInstalled(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDSupportAPI() {
        return isDDSupportAPI(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDSupportDingAPI() {
        return isDDSupportDingAPI(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDSupportDingAPI(Context context) {
        return false;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean openDDApp() {
        return openDDApp(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean registerApp(String str) {
        return registerApp(this.mContext, str);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean sendReq(BaseReq baseReq) {
        return sendReq(this.mContext, baseReq);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean sendReqToDing(BaseReq baseReq) {
        return sendReqToDing(this.mContext, baseReq);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public void unregisterApp() {
        unregisterApp(this.mContext);
    }

    private boolean sendReq(Context context, BaseReq baseReq) {
        if (!isDDSupportAPI(context)) {
            return false;
        }
        if (baseReq.getSupportVersion() > getDDSupportAPI(context)) {
            String str = "sendReq failed for dd not supported baseRequest,minSupportVersion:" + baseReq.getSupportVersion() + ",dingtalkSupportSdkVersion:" + getDDSupportAPI(context);
            return false;
        }
        if (!checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE) || !baseReq.checkArgs()) {
            return false;
        }
        Bundle bundle = new Bundle();
        baseReq.attachContext(context);
        baseReq.toBundle(bundle);
        return baseReq.getType() == 100 ? DDMessageAct.sendDDAuth(context, this.mAppId, bundle) : DDMessageAct.sendDDFriend(context, this.mAppId, bundle);
    }

    private boolean sendReqToDing(Context context, BaseReq baseReq) {
        if (!isDDSupportDingAPI(context) || !checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE) || !baseReq.checkArgs()) {
            return false;
        }
        Bundle bundle = new Bundle();
        baseReq.toBundle(bundle);
        return DDMessageAct.sendDing(context, this.mAppId, bundle);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public int getDDSupportAPI(Context context) {
        if (isDDAppInstalled(context)) {
            return DDVersionCheck.getSdkVersionFromMetaData(context, 0);
        }
        return 0;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDAppInstalled(Context context) {
        try {
            if (context.getPackageManager().getPackageInfo(ShareConstant.DD_APP_PACKAGE, 64) != null) {
                return checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE);
            }
            return false;
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            return false;
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDSupportAPI(Context context) {
        return getDDSupportAPI(context) >= 20151201;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean openDDApp(Context context) {
        if (!isDDAppInstalled(context)) {
            return false;
        }
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(ShareConstant.DD_APP_PACKAGE));
            return true;
        } catch (Exception e2) {
            String str = "start dd Main Activity fail, exception = " + e2.getMessage();
            return false;
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean registerApp(Context context, String str) {
        if (!checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE)) {
            return false;
        }
        if (str != null) {
            this.mAppId = str;
        }
        if (context == null) {
            return false;
        }
        String str2 = "register app " + context.getPackageName();
        DDMessage.send(context, ShareConstant.DD_APP_PACKAGE, ShareConstant.PERMISSION_ACTION_HANDLE_APP_REGISTER, ShareConstant.ACTION_APP_REGISTER + str);
        return true;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public void unregisterApp(Context context) {
        String str;
        if (!checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE) || (str = this.mAppId) == null || str.length() == 0 || context == null) {
            return;
        }
        String str2 = "unregister app " + context.getPackageName();
        DDMessage.send(context, ShareConstant.DD_APP_PACKAGE, ShareConstant.PERMISSION_ACTION_HANDLE_APP_UNREGISTER, ShareConstant.ACTION_APP_UNREGISTER + this.mAppId);
    }

    private static boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0 || bArr.length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
