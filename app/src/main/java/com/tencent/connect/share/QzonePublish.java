package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.C3202a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3263e;
import com.tencent.open.utils.C3295m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class QzonePublish extends BaseApi {
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ca A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0286  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m10336b(android.app.Activity r33, android.os.Bundle r34, com.tencent.tauth.IUiListener r35) {
        /*
            Method dump skipped, instructions count: 836
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzonePublish.m10336b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    public void publishToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (C3202a.m10152a("openSDK_LOG.QzonePublish", iUiListener)) {
            return;
        }
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            SLog.m10500e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            C3263e.m10457a().m10458a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f11013c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        if (!C3295m.m10702f(activity)) {
            iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            SLog.m10500e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            C3263e.m10457a().m10458a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f11013c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new TDialog(activity, "", m10309a(""), null, this.f11013c).show();
            return;
        }
        String m10669a = C3295m.m10669a(activity);
        int i2 = 0;
        if (m10669a == null) {
            m10669a = bundle.getString("appName");
        } else if (m10669a.length() > 20) {
            m10669a = m10669a.substring(0, 20) + "...";
        }
        if (!TextUtils.isEmpty(m10669a)) {
            bundle.putString("appName", m10669a);
        }
        int i3 = bundle.getInt("req_type");
        if (i3 == 3) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                while (i2 < stringArrayList.size()) {
                    if (!C3295m.m10710i(stringArrayList.get(i2))) {
                        stringArrayList.remove(i2);
                        i2--;
                    }
                    i2++;
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            }
            m10336b(activity, bundle, iUiListener);
            SLog.m10502i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            return;
        }
        if (i3 != 4) {
            iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
            SLog.m10500e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
            C3263e.m10457a().m10458a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f11013c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            return;
        }
        final String string = bundle.getString("videoPath");
        if (!C3295m.m10710i(string)) {
            SLog.m10500e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.connect.share.QzonePublish.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                long length = new File(string).length();
                int duration = mediaPlayer2.getDuration();
                bundle.putString("videoPath", string);
                bundle.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                bundle.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                QzonePublish.this.m10336b(activity, bundle, iUiListener);
                SLog.m10502i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.connect.share.QzonePublish.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i4, int i5) {
                SLog.m10500e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                return false;
            }
        });
        try {
            mediaPlayer.setDataSource(string);
            mediaPlayer.prepareAsync();
        } catch (Exception unused) {
            SLog.m10500e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
        }
    }
}
