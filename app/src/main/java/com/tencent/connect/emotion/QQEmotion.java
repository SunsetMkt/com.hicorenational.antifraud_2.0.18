package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.C3202a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class QQEmotion extends BaseApi {

    /* renamed from: a */
    private IUiListener f11023a;

    public QQEmotion(QQToken qQToken) {
        super(qQToken);
    }

    /* renamed from: a */
    private boolean m10325a(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            SLog.m10502i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j2 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long m10660a = C3295m.m10660a(context, arrayList.get(i2));
            if (m10660a > 1048576) {
                SLog.m10502i("QQEMOTION", "isLegality -->illegal, fileSize: " + m10660a);
                return false;
            }
            j2 += m10660a;
        }
        if (j2 > 3145728) {
            SLog.m10502i("QQEMOTION", "isLegality -->illegal, totalSize: " + j2);
            return false;
        }
        SLog.m10502i("QQEMOTION", "isLegality -->legal, totalSize: " + j2);
        return true;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        if (C3202a.m10152a("QQEmotion", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f11023a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f11023a = iUiListener;
        if (!C3293k.m10643b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (C3293k.m10645c(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
            return;
        }
        if (!m10325a(activity.getApplicationContext(), arrayList)) {
            Toast.makeText(activity.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
            return;
        }
        String m10669a = C3295m.m10669a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(m10669a)) {
            if (m10669a.length() > 20) {
                m10669a = m10669a.substring(0, 20) + "...";
            }
            sb.append(m10669a);
            stringBuffer.append("&app_name=" + Base64.encodeToString(C3295m.m10711j(m10669a), 2));
        }
        String appId = this.f11013c.getAppId();
        String openId = this.f11013c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
            sb.append(appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            sb.append(openId);
            stringBuffer.append("&open_id=" + Base64.encodeToString(C3295m.m10711j(openId), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(C3295m.m10711j(Constants.SDK_VERSION), 2));
        sb.append(Constants.SDK_VERSION);
        String m10324a = m10324a(activity, arrayList);
        if (TextUtils.isEmpty(m10324a)) {
            iUiListener.onError(new UiError(-6, Constants.MSG_UNKNOWN_ERROR, "picPathList is null"));
            return;
        }
        sb.append(m10324a);
        stringBuffer.append("&set_uri_list=" + Base64.encodeToString(C3295m.m10711j(m10324a), 2));
        stringBuffer.append("&");
        stringBuffer.append(Constants.KEY_PPSTS);
        stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
        stringBuffer.append(C3293k.m10632a(activity, sb.toString()));
        SLog.m10506v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.setPackage("com.tencent.mobileqq");
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_EMOTION, iUiListener);
        m10310a(activity, Constants.REQUEST_EDIT_EMOTION, intent, false);
    }

    /* renamed from: a */
    private String m10324a(Activity activity, ArrayList<Uri> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<Uri> it = arrayList.iterator();
        while (it.hasNext()) {
            Uri m10662a = C3295m.m10662a(activity, this.f11013c.getAppId(), C3295m.m10686b(activity, it.next()));
            if (m10662a == null) {
                SLog.m10500e("QQEmotion", "getFilePathListJson: grantedUri = null");
            } else {
                sb.append(m10662a);
                sb.append(";");
            }
        }
        String sb2 = sb.toString();
        SLog.m10502i("QQEmotion", "-->getFilePathListJson listStr : " + sb2);
        return sb2;
    }
}
