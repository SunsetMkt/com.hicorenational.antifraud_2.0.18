package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.p207a.C3203a;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3263e;
import com.tencent.open.utils.C3285c;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.InterfaceC3286d;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class QQShare extends BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_ARK_INFO = "share_to_qq_ark_info";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_GAME_MESSAGE_EXT = "game_message_ext";
    public static final String SHARE_TO_QQ_GAME_TAG_NAME = "game_tag_name";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QQ_MINI_PROGRAM = 7;
    public static final String SHARE_TO_QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_PATH = "mini_program_path";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public String mViaShareQQType;

    public QQShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQQType = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10332d(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.QQShare", "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("audio_url");
        int i2 = bundle.getInt("req_type", 1);
        String string6 = bundle.getString(SHARE_TO_QQ_ARK_INFO);
        String string7 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_APPID);
        String string8 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_PATH);
        String string9 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i3 = bundle.getInt("cflag", 0);
        String string10 = bundle.getString("share_qq_ext_str");
        String m10669a = C3295m.m10669a(activity);
        if (m10669a == null) {
            m10669a = bundle.getString("appName");
        }
        String str = m10669a;
        String string11 = bundle.getString("imageLocalUrl");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageLocalUrlArray");
        String appId = this.f11013c.getAppId();
        String openIdWithCache = this.f11013c.getOpenIdWithCache();
        SLog.m10502i("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + openIdWithCache + ",appName=" + str);
        if (stringArrayList != null && stringArrayList.size() >= 2) {
            String str2 = stringArrayList.get(0);
            if (str2 == null) {
                str2 = "";
            }
            stringBuffer.append("&file_data=" + Base64.encodeToString(C3295m.m10711j(str2), 2));
            String str3 = stringArrayList.get(1);
            if (i2 == 7 && !TextUtils.isEmpty(str3) && C3293k.m10645c(activity, "8.3.3") < 0) {
                str3 = null;
                SLog.m10500e("openSDK_LOG.QQShare", "doShareToQQ() share to mini program set file uri empty");
            }
            Uri m10662a = C3295m.m10662a(activity, appId, str3);
            if (m10662a != null) {
                stringBuffer.append("&file_uri=");
                stringBuffer.append(Base64.encodeToString(C3295m.m10711j(m10662a.toString()), 2));
            }
        } else if (!TextUtils.isEmpty(string11)) {
            stringBuffer.append("&file_data=" + Base64.encodeToString(C3295m.m10711j(string11), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&image_url=" + Base64.encodeToString(C3295m.m10711j(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&title=" + Base64.encodeToString(C3295m.m10711j(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&description=" + Base64.encodeToString(C3295m.m10711j(string3), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuffer.append("&url=" + Base64.encodeToString(C3295m.m10711j(string4), 2));
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 20) {
                str = str.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(C3295m.m10711j(str), 2));
        }
        if (!TextUtils.isEmpty(openIdWithCache)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(C3295m.m10711j(openIdWithCache), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(C3295m.m10711j(string5), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(C3295m.m10711j(String.valueOf(i2)), 2));
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&mini_program_appid=" + Base64.encodeToString(C3295m.m10711j(String.valueOf(string7)), 2));
        }
        if (!TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_path=" + Base64.encodeToString(C3295m.m10711j(String.valueOf(string8)), 2));
        }
        if (!TextUtils.isEmpty(string9)) {
            stringBuffer.append("&mini_program_type=" + Base64.encodeToString(C3295m.m10711j(String.valueOf(string9)), 2));
        }
        if (!TextUtils.isEmpty(string6)) {
            stringBuffer.append("&share_to_qq_ark_info=" + Base64.encodeToString(C3295m.m10711j(string6), 2));
        }
        if (!TextUtils.isEmpty(string10)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(C3295m.m10711j(string10), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(C3295m.m10711j(String.valueOf(i3)), 2));
        stringBuffer.append("&third_sd=" + Base64.encodeToString(C3295m.m10711j(String.valueOf(C3295m.m10693c())), 2));
        SLog.m10506v("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
        C3203a.m10154a(C3289g.m10603a(), this.f11013c, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra(Constants.KEY_PASS_REPORT_VIA_PARAM, C3295m.m10667a(this.f11013c.getOpenId(), i3 == 1 ? "11" : "10", "3", Constants.VIA_SHARE_TO_QQ, this.f11013c.getAppId(), this.mViaShareQQType, "", "", "0", "1", "0"));
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        if (C3295m.m10703f(activity, "4.6.0")) {
            SLog.m10502i("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_SHARE, iUiListener);
            m10311a(activity, intent, Constants.REQUEST_OLD_SHARE);
        } else {
            SLog.m10502i("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQQ", iUiListener) != null) {
                SLog.m10502i("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            m10310a(activity, 10103, intent, true);
        }
        SLog.m10502i("openSDK_LOG.QQShare", "doShareToQQ() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void shareToQQ(android.app.Activity r22, android.os.Bundle r23, com.tencent.tauth.IUiListener r24) {
        /*
            Method dump skipped, instructions count: 786
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.shareToQQ(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    /* renamed from: b */
    private void m10329b(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        final String string2 = bundle.getString("title");
        final String string3 = bundle.getString("summary");
        SLog.m10506v("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (TextUtils.isEmpty(string)) {
            if (bundle.getInt("req_type", 1) == 5) {
                m10331c(activity, bundle, iUiListener);
            } else {
                m10332d(activity, bundle, iUiListener);
            }
        } else if (!C3295m.m10708h(string)) {
            bundle.putString("imageUrl", null);
            if (C3295m.m10703f(activity, "4.3.0")) {
                SLog.m10498d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                m10332d(activity, bundle, iUiListener);
            } else {
                SLog.m10498d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0:isAppSpecificDir=" + C3295m.m10714m(string) + ",hasSDPermission:" + C3295m.m10693c());
                C3229a.m10342a(activity, string, new InterfaceC3286d() { // from class: com.tencent.connect.share.QQShare.2
                    @Override // com.tencent.open.utils.InterfaceC3286d
                    /* renamed from: a */
                    public void mo10333a(int i2, String str) {
                        if (i2 == 0) {
                            bundle.putString("imageLocalUrl", str);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                SLog.m10500e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            C3263e.m10457a().m10458a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).f11013c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        QQShare.this.m10332d(activity, bundle, iUiListener);
                    }

                    @Override // com.tencent.open.utils.InterfaceC3286d
                    /* renamed from: a */
                    public void mo10334a(int i2, ArrayList<String> arrayList) {
                        if (i2 == 0) {
                            bundle.putStringArrayList("imageLocalUrlArray", arrayList);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                SLog.m10500e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            C3263e.m10457a().m10458a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).f11013c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        QQShare.this.m10332d(activity, bundle, iUiListener);
                    }
                });
            }
        } else if (C3295m.m10703f(activity, "4.3.0")) {
            new C3285c(activity).m10591a(string, new InterfaceC3286d() { // from class: com.tencent.connect.share.QQShare.1
                @Override // com.tencent.open.utils.InterfaceC3286d
                /* renamed from: a */
                public void mo10333a(int i2, String str) {
                    if (i2 == 0) {
                        bundle.putString("imageLocalUrl", str);
                    } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                        IUiListener iUiListener2 = iUiListener;
                        if (iUiListener2 != null) {
                            iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                            SLog.m10500e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                        }
                        C3263e.m10457a().m10458a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).f11013c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                        return;
                    }
                    QQShare.this.m10332d(activity, bundle, iUiListener);
                }

                @Override // com.tencent.open.utils.InterfaceC3286d
                /* renamed from: a */
                public void mo10334a(int i2, ArrayList<String> arrayList) {
                }
            });
        } else {
            m10332d(activity, bundle, iUiListener);
        }
        SLog.m10502i("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00d1, code lost:
    
        if (r2 != false) goto L21;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m10331c(android.app.Activity r9, android.os.Bundle r10, com.tencent.tauth.IUiListener r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.m10331c(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }
}
