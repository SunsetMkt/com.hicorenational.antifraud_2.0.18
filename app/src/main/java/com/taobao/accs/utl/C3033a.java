package com.taobao.accs.utl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.InterfaceC2965b;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.p199ut.monitor.NetPerformanceMonitor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.a */
/* loaded from: classes2.dex */
public class C3033a {
    public static final String TAG = "a";

    /* renamed from: a */
    private static Handler f9702a = new Handler(Looper.getMainLooper());

    /* JADX WARN: Removed duplicated region for block: B:16:0x008d A[Catch: Exception -> 0x02c9, all -> 0x02d0, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:7:0x0020, B:96:0x0044, B:16:0x008d, B:19:0x00e4, B:31:0x00fd, B:34:0x0107, B:36:0x0131, B:39:0x0159, B:41:0x0163, B:44:0x0173, B:46:0x0182, B:48:0x018a, B:50:0x01b1, B:52:0x01b7, B:54:0x01d5, B:56:0x01f0, B:58:0x01f7, B:60:0x020a, B:63:0x0200, B:64:0x0190, B:65:0x0234, B:67:0x0244, B:87:0x02d8, B:69:0x0249, B:71:0x0253, B:73:0x0261, B:74:0x0265, B:76:0x0273, B:78:0x028b, B:80:0x029d, B:82:0x02aa, B:90:0x02b9, B:12:0x0057), top: B:6:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02b9 A[Catch: Exception -> 0x02c7, all -> 0x02d0, TRY_LEAVE, TryCatch #1 {, blocks: (B:7:0x0020, B:96:0x0044, B:16:0x008d, B:19:0x00e4, B:31:0x00fd, B:34:0x0107, B:36:0x0131, B:39:0x0159, B:41:0x0163, B:44:0x0173, B:46:0x0182, B:48:0x018a, B:50:0x01b1, B:52:0x01b7, B:54:0x01d5, B:56:0x01f0, B:58:0x01f7, B:60:0x020a, B:63:0x0200, B:64:0x0190, B:65:0x0234, B:67:0x0244, B:87:0x02d8, B:69:0x0249, B:71:0x0253, B:73:0x0261, B:74:0x0265, B:76:0x0273, B:78:0x028b, B:80:0x029d, B:82:0x02aa, B:90:0x02b9, B:12:0x0057), top: B:6:0x0020 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9235a(android.content.Context r27, android.content.Intent r28, com.taobao.accs.base.AccsDataListener r29) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.C3033a.m9235a(android.content.Context, android.content.Intent, com.taobao.accs.base.AccsDataListener):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static TaoBaseService.ExtraInfo m9241c(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap hashMap = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> m9237a = m9237a(hashMap);
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_HOST);
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = m9237a;
            extraInfo.oriExtHeader = hashMap;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.m9181e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    /* renamed from: a */
    private static void m9239a(String str, Runnable runnable) {
        if ("accs-impaas".equals(str) && C3052t.m9280e()) {
            ThreadPoolExecutorFactory.executeCallback(runnable);
        } else {
            f9702a.post(runnable);
        }
    }

    /* renamed from: a */
    public static NetPerformanceMonitor m9236a(Intent intent) {
        try {
            intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
            return (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
        } catch (Exception e2) {
            ALog.m9181e(TAG, "get NetPerformanceMonitor Error:", e2, new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private static Map<TaoBaseService.ExtHeaderType, String> m9237a(Map<Integer, String> map) {
        HashMap hashMap;
        if (map == null) {
            return null;
        }
        try {
            hashMap = new HashMap();
            try {
                for (TaoBaseService.ExtHeaderType extHeaderType : TaoBaseService.ExtHeaderType.values()) {
                    String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(extHeaderType, str);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                ALog.m9181e(TAG, "getExtHeader", e, new Object[0]);
                return hashMap;
            }
        } catch (Exception e3) {
            e = e3;
            hashMap = null;
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m9238a(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.m9183i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra(Constants.KEY_TARGET);
                String stringExtra4 = intent.getStringExtra("appKey");
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, (short) 0);
                InterfaceC2965b accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.mo8932a(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    C3043k.m9250a("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                } else {
                    C3043k.m9250a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
                }
            }
        } catch (Throwable th) {
            ALog.m9181e(TAG, "sendBusinessAck", th, new Object[0]);
            C3043k.m9250a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }
}
