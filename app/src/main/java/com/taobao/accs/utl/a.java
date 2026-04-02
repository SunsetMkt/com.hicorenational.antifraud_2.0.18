package com.taobao.accs.utl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.accs.AgooService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String TAG = "a";
    private static Handler a = new Handler(Looper.getMainLooper());

    /* JADX WARN: Removed duplicated region for block: B:135:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, Intent intent, AccsDataListener accsDataListener) {
        String str;
        String str2;
        String str3 = "onReceiveData";
        String str4 = "1";
        String str5 = BaseMonitor.ALARM_POINT_REQ_ERROR;
        if (accsDataListener == null || context == null) {
            ALog.e(TAG, "onReceiveData listener or context null", new Object[0]);
            return 2;
        }
        if (intent == null) {
            return 2;
        }
        try {
            int intExtra = intent.getIntExtra("command", -1);
            int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            String stringExtra = intent.getStringExtra("userInfo");
            String stringExtra2 = intent.getStringExtra(Constants.KEY_DATA_ID);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            str4 = "accs-impaas";
            if (!ALog.isPrintLog(ALog.Level.I)) {
                try {
                    if ("accs-impaas".equals(stringExtra3)) {
                        str = BaseMonitor.ALARM_POINT_REQ_ERROR;
                        try {
                            str5 = TAG;
                            str2 = stringExtra;
                            ALog.e(str5, "onReceiveData", Constants.KEY_DATA_ID, stringExtra2, Constants.KEY_SERVICE_ID, stringExtra3, "command", Integer.valueOf(intExtra), PushClientConstants.TAG_CLASS_NAME, accsDataListener.getClass().getName());
                        } catch (Exception e2) {
                            e = e2;
                            str5 = "onReceiveData";
                            str3 = str;
                            str4 = "1";
                            k.a("accs", str3, "", str4, "callback error" + e.toString());
                            ALog.e(TAG, str5, e, new Object[0]);
                            return 2;
                        }
                    } else {
                        str = BaseMonitor.ALARM_POINT_REQ_ERROR;
                        str2 = stringExtra;
                    }
                    try {
                        if (intExtra <= 0) {
                            ALog.w(TAG, "onReceiveData command not handled", new Object[0]);
                            return 2;
                        }
                        UTMini.getInstance().commitEvent(66001, "MsgToBuss5", "commandId=" + intExtra, "serviceId=" + stringExtra3 + " dataId=" + stringExtra2, 221);
                        str5 = "onReceiveData";
                        try {
                            k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, "3commandId=" + intExtra + "serviceId=" + stringExtra3, 0.0d);
                            if (intExtra == 5) {
                                a(stringExtra3, new b(accsDataListener, stringExtra3, intExtra2, intent));
                                return 2;
                            }
                            if (intExtra == 6) {
                                a(stringExtra3, new c(accsDataListener, stringExtra3, intExtra2, intent));
                                return 2;
                            }
                            if (intExtra == 100) {
                                NetPerformanceMonitor netPerformanceMonitorA = a(intent);
                                if (netPerformanceMonitorA != null) {
                                    netPerformanceMonitorA.service_recv = System.currentTimeMillis();
                                    if (netPerformanceMonitorA.start_service == 0) {
                                        netPerformanceMonitorA.start_service = netPerformanceMonitorA.service_recv;
                                    }
                                }
                                if (TextUtils.equals(Constants.SEND_TYPE_RES, intent.getStringExtra(Constants.KEY_SEND_TYPE))) {
                                    a(stringExtra3, new e(netPerformanceMonitorA, stringExtra3, stringExtra2, accsDataListener, intExtra2, intent.getByteArrayExtra("data"), intent));
                                    return 2;
                                }
                                a(stringExtra3, new f(netPerformanceMonitorA, stringExtra3, stringExtra2, accsDataListener, intExtra2, intent));
                                return 2;
                            }
                            if (intExtra != 101) {
                                if (intExtra != 103) {
                                    if (intExtra != 104) {
                                        ALog.w(TAG, "onReceiveData command not handled", new Object[0]);
                                        return 2;
                                    }
                                    boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_ANTI_BRUSH_RET, false);
                                    ALog.e(TAG, "onReceiveData anti brush result:" + booleanExtra, new Object[0]);
                                    a(stringExtra3, new g(accsDataListener, booleanExtra));
                                    return 2;
                                }
                                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                                String stringExtra4 = intent.getStringExtra(Constants.KEY_HOST);
                                String stringExtra5 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                                boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                                boolean booleanExtra4 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                                if (TextUtils.isEmpty(stringExtra4)) {
                                    return 2;
                                }
                                if (booleanExtra2) {
                                    a(stringExtra3, new h(accsDataListener, stringExtra4, booleanExtra3, booleanExtra4));
                                    return 2;
                                }
                                a(stringExtra3, new i(accsDataListener, stringExtra4, booleanExtra3, booleanExtra4, intExtra2, stringExtra5));
                                return 2;
                            }
                            byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                            boolean booleanExtra5 = intent.getBooleanExtra(Constants.KEY_NEED_BUSINESS_ACK, false);
                            if (byteArrayExtra == null) {
                                ALog.e(TAG, "onReceiveData COMMAND_RECEIVE_DATA msg null", new Object[0]);
                                k.a("accs", str, stringExtra3, "1", "COMMAND_RECEIVE_DATA msg null");
                                return 2;
                            }
                            if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(stringExtra3)) {
                                ALog.e(TAG, "onReceiveData COMMAND_RECEIVE_DATA onData dataId:" + stringExtra2 + " serviceId:" + stringExtra3, new Object[0]);
                            }
                            TaoBaseService.ExtraInfo extraInfoC = c(intent);
                            if (booleanExtra5) {
                                ALog.i(TAG, "onReceiveData try to send biz ack dataId " + stringExtra2, new Object[0]);
                                a(context, intent, stringExtra2, extraInfoC.oriExtHeader);
                            }
                            try {
                                intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                                NetPerformanceMonitor netPerformanceMonitor = (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
                                if (netPerformanceMonitor != null) {
                                    netPerformanceMonitor.onToAccsTime();
                                    if (!(context instanceof AgooService)) {
                                        AppMonitor.getInstance().commitStat(netPerformanceMonitor);
                                    }
                                }
                            } catch (Exception e3) {
                                ALog.e(TAG, "get NetPerformanceMonitor Error:", e3, new Object[0]);
                            }
                            k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS_SUCCESS, "1commandId=101serviceId=" + stringExtra3, 0.0d);
                            a(stringExtra3, new d(stringExtra3, stringExtra2, intExtra, accsDataListener, str2, byteArrayExtra, extraInfoC));
                            return 2;
                        } catch (Exception e4) {
                            e = e4;
                            str3 = str;
                            str4 = "1";
                            k.a("accs", str3, "", str4, "callback error" + e.toString());
                            ALog.e(TAG, str5, e, new Object[0]);
                            return 2;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Exception e6) {
                    e = e6;
                    str4 = "1";
                    str5 = "onReceiveData";
                    str3 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                }
            }
        } catch (Exception e7) {
            e = e7;
        }
        k.a("accs", str3, "", str4, "callback error" + e.toString());
        ALog.e(TAG, str5, e, new Object[0]);
        return 2;
    }

    public static TaoBaseService.ExtraInfo c(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap map = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> mapA = a(map);
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_HOST);
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = mapA;
            extraInfo.oriExtHeader = map;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    private static void a(String str, Runnable runnable) {
        if ("accs-impaas".equals(str) && t.e()) {
            ThreadPoolExecutorFactory.executeCallback(runnable);
        } else {
            a.post(runnable);
        }
    }

    public static NetPerformanceMonitor a(Intent intent) {
        try {
            intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
            return (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
        } catch (Exception e2) {
            ALog.e(TAG, "get NetPerformanceMonitor Error:", e2, new Object[0]);
            return null;
        }
    }

    private static Map<TaoBaseService.ExtHeaderType, String> a(Map<Integer, String> map) {
        HashMap map2;
        if (map == null) {
            return null;
        }
        try {
            map2 = new HashMap();
            try {
                for (TaoBaseService.ExtHeaderType extHeaderType : TaoBaseService.ExtHeaderType.values()) {
                    String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                    if (!TextUtils.isEmpty(str)) {
                        map2.put(extHeaderType, str);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                ALog.e(TAG, "getExtHeader", e, new Object[0]);
            }
        } catch (Exception e3) {
            e = e3;
            map2 = null;
        }
        return map2;
    }

    private static void a(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra(Constants.KEY_TARGET);
                String stringExtra4 = intent.getStringExtra("appKey");
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, (short) 0);
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.a(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                } else {
                    k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "sendBusinessAck", th, new Object[0]);
            k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }
}
