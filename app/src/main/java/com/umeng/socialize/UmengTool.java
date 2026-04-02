package com.umeng.socialize;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class UmengTool {
    public static void checkAlipay(Context context) {
        if (UMUtils.checkPath(context.getPackageName() + ".apshare.ShareEntryActivity")) {
            SLog.E(UmengText.CHECK.ALIPAYSUCCESS);
        } else {
            SLog.E(UmengText.CHECK.ALIPAYERROR);
        }
    }

    @TargetApi(9)
    public static String checkFBByself(Context context) {
        return !UMUtils.checkAndroidManifest(context, "com.umeng.facebook.FacebookActivity") ? UmengText.FACEBOOK.NOFACEBOOKACTIVITY : !UMUtils.checkMetaData(context, "com.facebook.sdk.ApplicationId") ? UmengText.FACEBOOK.NOMETA : !UMUtils.checkResource(context, "facebook_app_id", "string") ? UmengText.FACEBOOK.ERRORMETA : UmengText.CHECK.checkSuccess(UMUtils.getAppHashKey(context), ContextUtil.getPackageName());
    }

    public static void checkFacebook(Context context) {
        showDialog(context, checkFBByself(context));
    }

    public static String checkKakao(Context context) {
        if (TextUtils.isEmpty(context.getPackageName())) {
            return "\u5305\u540d\u4e3a\u7a7a";
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return "kakao \u914d\u7f6e\u6b63\u786e\uff0c\u8bf7\u68c0\u67e5kakao\u540e\u53f0\u7b7e\u540d:" + UMUtils.getAppHashKey(context);
        } catch (PackageManager.NameNotFoundException unused) {
            return "\u7b7e\u540d\u83b7\u53d6\u5931\u8d25";
        }
    }

    public static String checkLinkin(Context context) {
        if (TextUtils.isEmpty(context.getPackageName())) {
            return "\u5305\u540d\u4e3a\u7a7a";
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return "\u9886\u82f1 \u914d\u7f6e\u6b63\u786e\uff0c\u8bf7\u68c0\u67e5\u9886\u82f1\u540e\u53f0\u7b7e\u540d:" + UMUtils.getAppHashKey(context);
        } catch (PackageManager.NameNotFoundException unused) {
            return "\u7b7e\u540d\u83b7\u53d6\u5931\u8d25";
        }
    }

    public static void checkQQ(Context context) {
        showDialog(context, checkQQByself(context));
    }

    public static String checkQQByself(Context context) {
        return !UMUtils.checkAndroidManifest(context, "com.tencent.tauth.AuthActivity") ? UmengText.QQ.getError("com.tencent.tauth.AuthActivity") : !UMUtils.checkAndroidManifest(context, "com.tencent.connect.common.AssistActivity") ? UmengText.QQ.getError("com.tencent.connect.common.AssistActivity") : !UMUtils.checkIntentFilterData(context, ((PlatformConfig.APPIDPlatform) PlatformConfig.getPlatform(SHARE_MEDIA.QQ)).appId) ? UmengText.QQ.ERRORDATA : "qq\u914d\u7f6e\u6b63\u786e";
    }

    public static void checkSina(Context context) {
        showDialog(context, checkSinaBySelf(context));
    }

    public static String checkSinaBySelf(Context context) {
        return UmengText.CHECK.checkSuccess(UMUtils.getAppMD5Signature(context).toLowerCase(), context.getPackageName());
    }

    public static void checkVK(Context context) {
        showDialog(context, checkVKByself(context));
    }

    public static String checkVKByself(Context context) {
        return "\u4f60\u4f7f\u7528\u7684\u7b7e\u540d\uff1a" + UMUtils.getAppSHA1Key(context).replace(Constants.COLON_SEPARATOR, "");
    }

    public static void checkWx(Context context) {
        showDialog(context, checkWxBySelf(context));
    }

    public static String checkWxBySelf(Context context) {
        String packageName = context.getPackageName();
        String str = packageName + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
        if (UMUtils.checkPath(str)) {
            return UMUtils.checkAndroidManifest(context, str) ? UmengText.CHECK.checkSuccess(UMUtils.getAppMD5Signature(context).toLowerCase(), packageName) : UmengText.WX.WX_ERRORMANIFEST;
        }
        return UmengText.WX.WX_ERRORACTIVITY;
    }

    public static void getSignature(Context context) {
        showDialog(context, "\u5305\u540d\uff1a" + ContextUtil.getPackageName() + "\n\u7b7e\u540d:" + UMUtils.getAppMD5Signature(context) + "\nfacebook keyhash:" + UMUtils.getAppHashKey(context));
    }

    public static String getStrRedicrectUrl() {
        return ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.SINA)).redirectUrl;
    }

    public static void showDialog(Context context, String str) {
        new AlertDialog.Builder(context).setTitle("\u53cb\u76dfDebug\u6a21\u5f0f\u81ea\u68c0").setMessage(str).setPositiveButton("\u5173\u95ed", (DialogInterface.OnClickListener) null).show();
    }
}
