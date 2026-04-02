package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IAppReceiverV1;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.t;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.Config;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static Set<String> a;

    /* JADX INFO: renamed from: b */
    private static volatile g f5778b;

    public static g a() {
        if (f5778b == null) {
            synchronized (g.class) {
                if (f5778b == null) {
                    f5778b = new g();
                }
            }
        }
        return f5778b;
    }

    protected String b() {
        return com.taobao.accs.utl.j.msgService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [com.taobao.accs.IAppReceiver] */
    /* JADX WARN: Type inference failed for: r41v0, types: [com.taobao.accs.data.g] */
    public void b(Context context, Intent intent) {
        NetPerformanceMonitor netPerformanceMonitorA;
        String str;
        String str2;
        char c2;
        int i2;
        int intExtra;
        ?? r10;
        ?? r102;
        String str3;
        IAppReceiver iAppReceiver;
        IAppReceiver iAppReceiver2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
        String action = intent.getAction();
        if (ALog.isPrintLog(ALog.Level.D) || ("accs-impaas".equals(stringExtra2) && t.e())) {
            ALog.e("MsgDistribute", "distribute ready", "action", action, Constants.KEY_DATA_ID, stringExtra, Constants.KEY_SERVICE_ID, stringExtra2);
            netPerformanceMonitorA = com.taobao.accs.utl.a.a(intent);
        } else {
            netPerformanceMonitorA = null;
        }
        if (netPerformanceMonitorA != null) {
            netPerformanceMonitorA.thread_schedule_time = System.currentTimeMillis() - jCurrentTimeMillis;
        }
        if (TextUtils.isEmpty(action)) {
            ALog.e("MsgDistribute", "action null", new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss9", "action null", 221);
            return;
        }
        try {
        } catch (Throwable th) {
            th = th;
            str = "MsgDistribute";
            str2 = stringExtra2;
            c2 = 2;
        }
        if (TextUtils.equals(action, Constants.ACTION_RECEIVE)) {
            intExtra = intent.getIntExtra("command", -1);
            try {
                String stringExtra3 = intent.getStringExtra("userInfo");
                int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                String stringExtra4 = intent.getStringExtra("appKey");
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                if (intent.getPackage() == null) {
                    try {
                        intent.setPackage(context.getPackageName());
                    } catch (Throwable th2) {
                        th = th2;
                        r10 = "MsgDistribute";
                        str2 = stringExtra2;
                        i2 = 4;
                        c2 = 2;
                        Object[] objArr = new Object[i2];
                        objArr[0] = Constants.KEY_DATA_ID;
                        objArr[1] = stringExtra;
                        objArr[c2] = Constants.KEY_SERVICE_ID;
                        objArr[3] = str2;
                        ALog.e(r10, "distribMessage", th, objArr);
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, "1", "distribute error " + intExtra + UtilityImpl.a(th));
                    }
                }
                if ("accs".equals(stringExtra2) || "accs-impaas".equals(stringExtra2)) {
                    ALog.e("MsgDistribute", "distribute start", "appkey", stringExtra4, "config", stringExtra5);
                } else {
                    ALog.d("MsgDistribute", "distribute start", "appkey", stringExtra4, "config", stringExtra5);
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (a(context, intent, stringExtra, stringExtra2)) {
                    return;
                }
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
                long jCurrentTimeMillis4 = System.currentTimeMillis();
                if (intExtra < 0) {
                    try {
                        String str4 = "command error:" + intExtra;
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Constants.KEY_SERVICE_ID;
                        objArr2[1] = stringExtra2;
                        ALog.e("MsgDistribute", str4, objArr2);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        r10 = "MsgDistribute";
                        str2 = stringExtra2;
                        i2 = 4;
                        c2 = 2;
                        Object[] objArr3 = new Object[i2];
                        objArr3[0] = Constants.KEY_DATA_ID;
                        objArr3[1] = stringExtra;
                        objArr3[c2] = Constants.KEY_SERVICE_ID;
                        objArr3[3] = str2;
                        ALog.e(r10, "distribMessage", th, objArr3);
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, "1", "distribute error " + intExtra + UtilityImpl.a(th));
                    }
                }
                long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis4;
                long jCurrentTimeMillis6 = System.currentTimeMillis();
                if (a(intExtra, stringExtra2)) {
                    return;
                }
                long jCurrentTimeMillis7 = System.currentTimeMillis() - jCurrentTimeMillis6;
                long jCurrentTimeMillis8 = System.currentTimeMillis();
                c2 = 2;
                try {
                    if (a(context, intent, stringExtra, stringExtra2, stringExtra5)) {
                        return;
                    }
                    long jCurrentTimeMillis9 = System.currentTimeMillis() - jCurrentTimeMillis8;
                    long jCurrentTimeMillis10 = System.currentTimeMillis();
                    Map<String, IAppReceiver> appReceiver = GlobalClientInfo.getInstance(context).getAppReceiver();
                    if (TextUtils.isEmpty(stringExtra5)) {
                        str3 = stringExtra5;
                        iAppReceiver = null;
                    } else {
                        if (appReceiver != null) {
                            str3 = stringExtra5;
                            try {
                                iAppReceiver2 = appReceiver.get(str3);
                            } catch (Throwable th4) {
                                th = th4;
                                str2 = stringExtra2;
                                r102 = "MsgDistribute";
                            }
                        } else {
                            str3 = stringExtra5;
                            iAppReceiver2 = null;
                        }
                        iAppReceiver = iAppReceiver2;
                    }
                    String str5 = str3;
                    if (a(context, stringExtra2, stringExtra, intent, iAppReceiver)) {
                        return;
                    }
                    long jCurrentTimeMillis11 = System.currentTimeMillis() - jCurrentTimeMillis10;
                    long jCurrentTimeMillis12 = System.currentTimeMillis();
                    str2 = stringExtra;
                    ?? r103 = iAppReceiver;
                    try {
                        a(context, intent, str5, stringExtra4, intExtra, stringExtra3, stringExtra2, str2, r103, intExtra2);
                        long jCurrentTimeMillis13 = System.currentTimeMillis() - jCurrentTimeMillis12;
                        try {
                            if (TextUtils.isEmpty(stringExtra2)) {
                                a(context, appReceiver, intent, intExtra, intExtra2);
                                return;
                            }
                            str2 = stringExtra2;
                            if (ALog.isPrintLog(ALog.Level.D)) {
                                ALog.e("MsgDistribute", "handleBusinessMsg start", Constants.KEY_DATA_ID, stringExtra, Constants.KEY_SERVICE_ID, str2, "command", Integer.valueOf(intExtra), "t1", Long.valueOf(jCurrentTimeMillis3), "t2", Long.valueOf(jCurrentTimeMillis5), "t3", Long.valueOf(jCurrentTimeMillis7), "t4", Long.valueOf(jCurrentTimeMillis9), "t5", Long.valueOf(jCurrentTimeMillis11), "t6", Long.valueOf(jCurrentTimeMillis13));
                            } else {
                                try {
                                    if ("accs-impaas".equals(str2) && t.e()) {
                                        ALog.e("MsgDistribute", "handleBusinessMsg start", Constants.KEY_DATA_ID, stringExtra, Constants.KEY_SERVICE_ID, str2, "command", Integer.valueOf(intExtra), "t1", Long.valueOf(jCurrentTimeMillis3), "t2", Long.valueOf(jCurrentTimeMillis5), "t3", Long.valueOf(jCurrentTimeMillis7), "t4", Long.valueOf(jCurrentTimeMillis9), "t5", Long.valueOf(jCurrentTimeMillis11), "t6", Long.valueOf(jCurrentTimeMillis13));
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    r103 = "MsgDistribute";
                                }
                            }
                            a(context, iAppReceiver, intent, str2, stringExtra, intExtra, intExtra2);
                            return;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        r103 = "MsgDistribute";
                        str2 = stringExtra2;
                    }
                    intExtra = intExtra;
                    r102 = r103;
                } catch (Throwable th8) {
                    th = th8;
                }
                str2 = stringExtra2;
                r102 = "MsgDistribute";
            } catch (Throwable th9) {
                th = th9;
                r102 = "MsgDistribute";
                str2 = stringExtra2;
                c2 = 2;
            }
            i2 = 4;
            r10 = r102;
            Object[] objArr32 = new Object[i2];
            objArr32[0] = Constants.KEY_DATA_ID;
            objArr32[1] = stringExtra;
            objArr32[c2] = Constants.KEY_SERVICE_ID;
            objArr32[3] = str2;
            ALog.e(r10, "distribMessage", th, objArr32);
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, "1", "distribute error " + intExtra + UtilityImpl.a(th));
        }
        str = "MsgDistribute";
        str2 = stringExtra2;
        c2 = 2;
        try {
            ALog.e(str, "distribMessage action error", new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss10", action, 221);
            return;
        } catch (Throwable th10) {
            th = th10;
        }
        i2 = 4;
        intExtra = 0;
        r10 = str;
        Object[] objArr322 = new Object[i2];
        objArr322[0] = Constants.KEY_DATA_ID;
        objArr322[1] = stringExtra;
        objArr322[c2] = Constants.KEY_SERVICE_ID;
        objArr322[3] = str2;
        ALog.e(r10, "distribMessage", th, objArr322);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, "1", "distribute error " + intExtra + UtilityImpl.a(th));
    }

    public static void a(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(stringExtra2)) {
                ALog.e("MsgDistribute", "distribMessage", Constants.KEY_DATA_ID, stringExtra);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new h(context, intent));
        } catch (Throwable th) {
            ALog.e("MsgDistribute", "distribMessage", th, new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss8", "distribMessage" + th.toString(), 221);
        }
    }

    protected boolean a(int i2, String str) {
        if (i2 != 100 && !GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            long jE = UtilityImpl.e();
            if (jE != -1 && jE <= 5242880) {
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "space low");
                ALog.e("MsgDistribute", "user space low, don't distribute", "size", Long.valueOf(jE), Constants.KEY_SERVICE_ID, str);
                return true;
            }
        }
        return false;
    }

    protected boolean a(Context context, String str, String str2, Intent intent, IAppReceiver iAppReceiver) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String service2 = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
            if (TextUtils.isEmpty(service2) && iAppReceiver != null) {
                service2 = iAppReceiver.getService(str);
            }
            if (TextUtils.isEmpty(service2)) {
                service2 = GlobalClientInfo.getInstance(context).getService(str);
            }
            if (!TextUtils.isEmpty(service2) || UtilityImpl.isMainProcess(context)) {
                return false;
            }
            if ("accs".equals(str)) {
                ALog.e("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            } else {
                ALog.i("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            }
            intent.setClassName(intent.getPackage(), b());
            com.taobao.accs.a.a.a(context, intent);
            return true;
        } catch (Throwable th) {
            ALog.e("MsgDistribute", "handleMsgInChannelProcess", th, new Object[0]);
            return false;
        }
    }

    private void a(Context context, Intent intent, String str, String str2, int i2, String str3, String str4, String str5, IAppReceiver iAppReceiver, int i3) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            Object[] objArr = new Object[12];
            objArr[0] = Constants.KEY_CONFIG_TAG;
            objArr[1] = str;
            objArr[2] = Constants.KEY_DATA_ID;
            objArr[3] = str5;
            objArr[4] = Constants.KEY_SERVICE_ID;
            objArr[5] = str4;
            objArr[6] = "command";
            objArr[7] = Integer.valueOf(i2);
            objArr[8] = Constants.KEY_ERROR_CODE;
            objArr[9] = Integer.valueOf(i3);
            objArr[10] = "appReceiver";
            objArr[11] = iAppReceiver == null ? null : iAppReceiver.getClass().getName();
            ALog.d("MsgDistribute", "handleControlMsg", objArr);
        }
        if (iAppReceiver != null) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i3 == 200) {
                        UtilityImpl.disableService(context);
                    }
                    iAppReceiver.onUnbindApp(i3);
                } else if (i2 == 3) {
                    iAppReceiver.onBindUser(str3, i3);
                } else if (i2 == 4) {
                    iAppReceiver.onUnbindUser(i3);
                } else if (i2 != 100) {
                    if (i2 == 101 && TextUtils.isEmpty(str4)) {
                        ALog.d("MsgDistribute", "handleControlMsg serviceId isEmpty", new Object[0]);
                        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                        if (byteArrayExtra != null) {
                            iAppReceiver.onData(str3, str5, byteArrayExtra);
                        }
                    }
                } else if (TextUtils.isEmpty(str4)) {
                    iAppReceiver.onSendData(str5, i3);
                }
            } else if (iAppReceiver instanceof IAppReceiverV1) {
                ((IAppReceiverV1) iAppReceiver).onBindApp(i3, null);
            } else {
                iAppReceiver.onBindApp(i3);
            }
        }
        if (i2 == 1 && GlobalClientInfo.f5716b != null && str2 != null && str2.equals(Config.a(context))) {
            ALog.d("MsgDistribute", "handleControlMsg agoo receiver onBindApp", new Object[0]);
            GlobalClientInfo.f5716b.onBindApp(i3, null);
            return;
        }
        if (iAppReceiver != null || i2 == 100 || i2 == 104 || i2 == 103) {
            return;
        }
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str4, "1", "appReceiver null return");
        UTMini.getInstance().commitEvent(66001, "MsgToBuss7", "commandId=" + i2, "serviceId=" + str4 + " errorCode=" + i3 + " dataId=" + str5, 221);
    }

    protected void a(Context context, IAppReceiver iAppReceiver, Intent intent, String str, String str2, int i2, int i3) {
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(str)) {
            ALog.e("MsgDistribute", "handleBusinessMsg start", Constants.KEY_DATA_ID, str2, Constants.KEY_SERVICE_ID, str, "command", Integer.valueOf(i2));
        }
        String service2 = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
        if (TextUtils.isEmpty(service2) && iAppReceiver != null) {
            service2 = iAppReceiver.getService(str);
        }
        if (TextUtils.isEmpty(service2)) {
            service2 = GlobalClientInfo.getInstance(context).getService(str);
        }
        if (!TextUtils.isEmpty(service2)) {
            if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(str)) {
                ALog.e("MsgDistribute", "handleBusinessMsg to start service", PushClientConstants.TAG_CLASS_NAME, service2);
            }
            NetPerformanceMonitor netPerformanceMonitorA = com.taobao.accs.utl.a.a(intent);
            if (netPerformanceMonitorA != null) {
                netPerformanceMonitorA.start_service = System.currentTimeMillis();
            }
            intent.setClassName(context, service2);
            com.taobao.accs.a.a.a(context, intent);
        } else {
            AccsDataListener listener = GlobalClientInfo.getInstance(context).getListener(str);
            if (listener != null) {
                if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(str)) {
                    ALog.e("MsgDistribute", "handleBusinessMsg getListener not null", new Object[0]);
                }
                com.taobao.accs.utl.a.a(context, intent, listener);
            } else {
                ALog.e("MsgDistribute", "handleBusinessMsg getListener also null", new Object[0]);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "service is null");
            }
        }
        UTMini.getInstance().commitEvent(66001, "MsgToBuss", "commandId=" + i2, "serviceId=" + str + " errorCode=" + i3 + " dataId=" + str2, 221);
        StringBuilder sb = new StringBuilder();
        sb.append("2commandId=");
        sb.append(i2);
        sb.append("serviceId=");
        sb.append(str);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
    }

    protected void a(Context context, Map<String, IAppReceiver> map, Intent intent, int i2, int i3) {
        ALog.e("MsgDistribute", "handBroadCastMsg", "command", Integer.valueOf(i2));
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, IAppReceiver> entry : map.entrySet()) {
                Map<String, String> allService = GlobalClientInfo.getInstance(context).getAllService(entry.getKey());
                if (allService == null) {
                    allService = entry.getValue().getAllServices();
                }
                if (allService != null) {
                    map2.putAll(allService);
                }
            }
        }
        if (i2 != 103) {
            if (i2 == 104) {
                for (String str : map2.keySet()) {
                    String service2 = (String) map2.get(str);
                    if (TextUtils.isEmpty(service2)) {
                        service2 = GlobalClientInfo.getInstance(context).getService(str);
                    }
                    if (!TextUtils.isEmpty(service2)) {
                        intent.setClassName(context, service2);
                        com.taobao.accs.a.a.a(context, intent);
                    }
                }
                return;
            }
            ALog.w("MsgDistribute", "handBroadCastMsg not handled command", new Object[0]);
            return;
        }
        for (String str2 : map2.keySet()) {
            if ("accs".equals(str2) || "windvane".equals(str2) || "motu-remote".equals(str2)) {
                String service3 = (String) map2.get(str2);
                if (TextUtils.isEmpty(service3)) {
                    service3 = GlobalClientInfo.getInstance(context).getService(str2);
                }
                if (!TextUtils.isEmpty(service3)) {
                    intent.setClassName(context, service3);
                    com.taobao.accs.a.a.a(context, intent);
                }
            }
        }
        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
        String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
        boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
        boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
        TaoBaseService.ConnectInfo connectInfo = null;
        if (!TextUtils.isEmpty(stringExtra)) {
            if (booleanExtra) {
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3);
            } else {
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, i3, stringExtra2);
            }
            connectInfo.connected = booleanExtra;
        }
        if (connectInfo != null) {
            ALog.d("MsgDistribute", "handBroadCastMsg ACTION_CONNECT_INFO", connectInfo);
            Intent intent2 = new Intent(Constants.ACTION_CONNECT_INFO);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(Constants.KEY_CONNECT_INFO, connectInfo);
            context.sendBroadcast(intent2);
            return;
        }
        ALog.e("MsgDistribute", "handBroadCastMsg connect info null, host empty", new Object[0]);
    }

    private boolean a(Context context, Intent intent, String str, String str2) {
        boolean z;
        boolean booleanExtra = intent.getBooleanExtra("routingAck", false);
        boolean booleanExtra2 = intent.getBooleanExtra("routingMsg", false);
        if (booleanExtra) {
            ALog.e("MsgDistribute", "recieve routiong ack", Constants.KEY_DATA_ID, str, Constants.KEY_SERVICE_ID, str2);
            Set<String> set = a;
            if (set != null) {
                set.remove(str);
            }
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "");
            z = true;
        } else {
            z = false;
        }
        if (booleanExtra2) {
            try {
                String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
                ALog.e("MsgDistribute", "send routiong ack", Constants.KEY_DATA_ID, str, "to pkg", stringExtra, Constants.KEY_SERVICE_ID, str2);
                Intent intent2 = new Intent(Constants.ACTION_COMMAND);
                intent2.putExtra("command", 106);
                intent2.setClassName(stringExtra, com.taobao.accs.utl.j.channelService);
                intent2.putExtra("routingAck", true);
                intent2.putExtra(Constants.KEY_PACKAGE_NAME, stringExtra);
                intent2.putExtra(Constants.KEY_DATA_ID, str);
                com.taobao.accs.a.a.a(context, intent2);
            } catch (Throwable th) {
                ALog.e("MsgDistribute", "send routing ack", th, Constants.KEY_SERVICE_ID, str2);
            }
        }
        return z;
    }

    private boolean a(Context context, Intent intent, String str, String str2, String str3) {
        AccsClientConfig configByTag = !TextUtils.isEmpty(str3) ? AccsClientConfig.getConfigByTag(str3) : null;
        if (context.getPackageName().equals(intent.getPackage())) {
            return false;
        }
        if (configByTag != null && !configByTag.isPullUpEnable()) {
            return false;
        }
        try {
            ALog.e("MsgDistribute", "start MsgDistributeService", "receive pkg", context.getPackageName(), "target pkg", intent.getPackage(), Constants.KEY_SERVICE_ID, str2);
            intent.setClassName(intent.getPackage(), com.taobao.accs.utl.j.msgService);
            intent.putExtra("routingMsg", true);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            com.taobao.accs.a.a.a(context, intent);
            if (a == null) {
                a = new HashSet();
            }
            a.add(str);
            ThreadPoolExecutorFactory.schedule(new i(this, str, str2, intent), 10L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "exception", th.toString());
            ALog.e("MsgDistribute", "routing msg error, try election", th, Constants.KEY_SERVICE_ID, str2, Constants.KEY_DATA_ID, str);
        }
        return true;
    }
}
