package com.umeng.socialize;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.p208mm.opensdk.channel.MMessageActV2;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class UmengTool {
    public static void checkAlipay(Context context) {
        if (UMUtils.checkPath(context.getPackageName() + ".apshare.ShareEntryActivity")) {
            SLog.m12716E(UmengText.CHECK.ALIPAYSUCCESS);
        } else {
            SLog.m12716E(UmengText.CHECK.ALIPAYERROR);
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
            return "包名为空";
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return "kakao 配置正确，请检查kakao后台签名:" + UMUtils.getAppHashKey(context);
        } catch (PackageManager.NameNotFoundException unused) {
            return "签名获取失败";
        }
    }

    public static String checkLinkin(Context context) {
        if (TextUtils.isEmpty(context.getPackageName())) {
            return "包名为空";
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return "领英 配置正确，请检查领英后台签名:" + UMUtils.getAppHashKey(context);
        } catch (PackageManager.NameNotFoundException unused) {
            return "签名获取失败";
        }
    }

    public static void checkQQ(Context context) {
        showDialog(context, checkQQByself(context));
    }

    public static String checkQQByself(Context context) {
        return !UMUtils.checkAndroidManifest(context, "com.tencent.tauth.AuthActivity") ? UmengText.C3778QQ.getError("com.tencent.tauth.AuthActivity") : !UMUtils.checkAndroidManifest(context, "com.tencent.connect.common.AssistActivity") ? UmengText.C3778QQ.getError("com.tencent.connect.common.AssistActivity") : !UMUtils.checkIntentFilterData(context, ((PlatformConfig.APPIDPlatform) PlatformConfig.getPlatform(SHARE_MEDIA.QQ)).appId) ? UmengText.C3778QQ.ERRORDATA : "qq配置正确";
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
        return "你使用的签名：" + UMUtils.getAppSHA1Key(context).replace(Constants.COLON_SEPARATOR, "");
    }

    public static void checkWx(Context context) {
        showDialog(context, checkWxBySelf(context));
    }

    public static String checkWxBySelf(Context context) {
        String packageName = context.getPackageName();
        String str = packageName + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
        if (UMUtils.checkPath(str)) {
            return UMUtils.checkAndroidManifest(context, str) ? UmengText.CHECK.checkSuccess(UMUtils.getAppMD5Signature(context).toLowerCase(), packageName) : UmengText.C3779WX.WX_ERRORMANIFEST;
        }
        return UmengText.C3779WX.WX_ERRORACTIVITY;
    }

    public static void getSignature(Context context) {
        showDialog(context, "包名：" + ContextUtil.getPackageName() + "\n签名:" + UMUtils.getAppMD5Signature(context) + "\nfacebook keyhash:" + UMUtils.getAppHashKey(context));
    }

    public static String getStrRedicrectUrl() {
        return ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.SINA)).redirectUrl;
    }

    public static void showDialog(Context context, String str) {
        new AlertDialog.Builder(context).setTitle("友盟Debug模式自检").setMessage(str).setPositiveButton("关闭", (DialogInterface.OnClickListener) null).show();
    }
}
