package com.umeng.socialize.tracker;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.DeviceConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TrackerManager {
    private static final String APPKEY_IS_EMPTY = "appkey\u53c2\u6570\u4e0d\u80fd\u4e3anull\u6216\u8005\u7a7a\u5b57\u7b26\u4e32\u3002";
    private static final String ATTRIBUTES_EXCEED_LIMIT = "SDK\u4ec5\u652f\u630110\u4e2a\u81ea\u5b9a\u4e49\u5c5e\u6027\u3002";
    private static final String CALLBACK_IS_NULL = "callback\u53c2\u6570\u4e0d\u80fd\u4e3anull\u3002";
    private static final String CONTEXT_IS_NULL = "context\u53c2\u6570\u4e0d\u80fd\u4e3anull\u3002";
    private static final String TAG = "TrackerManager";
    private static final String UMID_IS_EMPTY = "umid\u53c2\u6570\u4e0d\u80fd\u4e3anull\u6216\u8005\u7a7a\u5b57\u7b26\u4e32\u3002";
    private static final String URL_IS_EMPTY = "url\u53c2\u6570\u4e0d\u80fd\u4e3anull\u6216\u8005\u7a7a\u5b57\u7b26\u4e32\u3002";

    private TrackerManager() {
    }

    public static String getUMID(Context context) {
        return UMConfigure.getUMIDString(context);
    }

    public static void requestTrackerCode(Context context, String str, String str2, String str3, String str4, Map<String, String> map, TrackerResultHandler trackerResultHandler) {
        if (CommonUtil.isSilentMode(context) || context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || trackerResultHandler == null) {
            return;
        }
        if (map == null || map.size() <= 10) {
            if (DeviceConfig.isNetworkAvailable(context)) {
                b.a().a(context, str, str2, str3, str4, map, 0, trackerResultHandler);
            } else {
                trackerResultHandler.codeGenerateFailed(new Throwable(com.umeng.socialize.tracker.utils.a.NetworkUnavailable.a()));
            }
        }
    }
}
