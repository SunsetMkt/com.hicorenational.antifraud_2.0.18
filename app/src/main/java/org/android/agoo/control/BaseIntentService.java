package org.android.agoo.control;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.t;
import com.taobao.accs.utl.v;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.huawei.HuaweiRcvService;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;
import org.android.agoo.xiaomi.MiPushBroadcastReceiver;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseIntentService extends Service {
    private static final String TAG = "BaseIntentService";
    private static boolean isBinded = false;
    private static final String msgStatus = "4";
    private AgooFactory agooFactory;
    private MessageService messageService;
    private NotifManager notifyManager;
    private Context mContext = null;
    private Messenger messenger = new Messenger(new g(this));

    private final String getTrace(Context context, long j2) {
        String str = TextUtils.isEmpty(null) ? "unknow" : null;
        String str2 = TextUtils.isEmpty(null) ? "unknow" : null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appkey");
        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        stringBuffer.append(j2);
        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        stringBuffer.append(str);
        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x00d0 A[Catch: all -> 0x036e, TryCatch #5 {all -> 0x036e, blocks: (B:204:0x00c2, B:206:0x00d0, B:207:0x010d, B:209:0x0136, B:211:0x0140, B:213:0x0152, B:215:0x015c, B:218:0x016e, B:223:0x0186, B:221:0x017d, B:203:0x00a3), top: B:310:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0136 A[Catch: all -> 0x036e, TryCatch #5 {all -> 0x036e, blocks: (B:204:0x00c2, B:206:0x00d0, B:207:0x010d, B:209:0x0136, B:211:0x0140, B:213:0x0152, B:215:0x015c, B:218:0x016e, B:223:0x0186, B:221:0x017d, B:203:0x00a3), top: B:310:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0186 A[Catch: all -> 0x036e, TRY_LEAVE, TryCatch #5 {all -> 0x036e, blocks: (B:204:0x00c2, B:206:0x00d0, B:207:0x010d, B:209:0x0136, B:211:0x0140, B:213:0x0152, B:215:0x015c, B:218:0x016e, B:223:0x0186, B:221:0x017d, B:203:0x00a3), top: B:310:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleRemoteMessage(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        TaoBaseService.ExtraInfo extraInfo;
        String stringExtra;
        String str4;
        String stringExtra2;
        String str5;
        CharSequence charSequence;
        String stringExtra3;
        try {
            String stringExtra4 = intent.getStringExtra("id");
            String stringExtra5 = intent.getStringExtra("body");
            String stringExtra6 = intent.getStringExtra("type");
            String stringExtra7 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra8 = intent.getStringExtra(AgooConstants.MESSAGE_REPORT);
            String stringExtra9 = intent.getStringExtra(AgooConstants.MESSAGE_ENCRYPTED);
            String stringExtra10 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            try {
                String stringExtra11 = intent.getStringExtra(AgooConstants.MESSAGE_ORI);
                try {
                    str3 = "messageId=";
                } catch (Throwable th) {
                    th = th;
                    str3 = "messageId=";
                }
                try {
                    getTrace(context, Long.valueOf(intent.getLongExtra(AgooConstants.MESSAGE_TRACE, -1L)).longValue());
                    Bundle bundleExtra = intent.getBundleExtra(AgooConstants.MESSAGE_AGOO_BUNDLE);
                    extraInfo = bundleExtra != null ? (TaoBaseService.ExtraInfo) bundleExtra.getSerializable(AgooConstants.MESSAGE_ACCS_EXTRA) : null;
                    try {
                        stringExtra = intent.getStringExtra("source");
                    } catch (Throwable th2) {
                        th = th2;
                        stringExtra = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    extraInfo = null;
                    stringExtra = null;
                    try {
                        str4 = TAG;
                        ALog.e(str4, "_trace,t=" + th, new Object[0]);
                        stringExtra2 = null;
                        extraInfo = extraInfo;
                        if (ALog.isPrintLog(ALog.Level.I)) {
                        }
                        MsgDO msgDO = new MsgDO();
                        msgDO.msgIds = stringExtra4;
                        msgDO.extData = stringExtra10;
                        msgDO.messageSource = stringExtra7;
                        msgDO.msgStatus = "4";
                        msgDO.reportStr = stringExtra8;
                        msgDO.fromPkg = stringExtra;
                        msgDO.fromAppkey = stringExtra2;
                        msgDO.isStartProc = com.taobao.accs.client.a.c();
                        msgDO.notifyEnable = com.taobao.accs.utl.j.c(this.mContext);
                        if (!TextUtils.isEmpty(stringExtra5)) {
                        }
                        if (!TextUtils.isEmpty(stringExtra5)) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                        com.taobao.accs.utl.k.a(str2, str, "arrive_exception" + th.toString(), 0.0d);
                        return;
                    }
                }
                try {
                    if (TextUtils.isEmpty(stringExtra)) {
                        stringExtra = "oldsdk";
                    }
                    stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_FROM_APPKEY);
                    str4 = TAG;
                } catch (Throwable th5) {
                    th = th5;
                    str4 = TAG;
                    ALog.e(str4, "_trace,t=" + th, new Object[0]);
                    stringExtra2 = null;
                    extraInfo = extraInfo;
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(str4, "handleRemoteMessage", "message", stringExtra5, "source", stringExtra7, RemoteMessageConst.MSGID, stringExtra4, "utdid", com.taobao.accs.utl.j.b(context), "fromPkg", stringExtra, AgooConstants.MESSAGE_FROM_APPKEY, stringExtra2);
                }
                MsgDO msgDO2 = new MsgDO();
                msgDO2.msgIds = stringExtra4;
                msgDO2.extData = stringExtra10;
                msgDO2.messageSource = stringExtra7;
                msgDO2.msgStatus = "4";
                msgDO2.reportStr = stringExtra8;
                msgDO2.fromPkg = stringExtra;
                msgDO2.fromAppkey = stringExtra2;
                msgDO2.isStartProc = com.taobao.accs.client.a.c();
                msgDO2.notifyEnable = com.taobao.accs.utl.j.c(this.mContext);
                if (!TextUtils.isEmpty(stringExtra5)) {
                    if (!Integer.toString(4).equals(stringExtra9)) {
                        ALog.e(str4, "msg encrypted flag not exist~~", new Object[0]);
                        try {
                            msgDO2.errorCode = "24";
                            this.notifyManager.report(msgDO2, extraInfo);
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    ALog.i(str4, "message is encrypted, attemp to decrypt msg", new Object[0]);
                    stringExtra5 = AgooFactory.parseEncryptedMsg(stringExtra5);
                    if (TextUtils.isEmpty(stringExtra5)) {
                        msgDO2.errorCode = "22";
                        this.notifyManager.handlerACKMessage(msgDO2, extraInfo);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(stringExtra5)) {
                    try {
                        msgDO2.errorCode = "21";
                        this.notifyManager.report(msgDO2, extraInfo);
                    } catch (Throwable unused2) {
                    }
                    ALog.e(str4, "handleMessage--->[null]", new Object[0]);
                    return;
                }
                intent.putExtra("body", stringExtra5);
                try {
                    this.notifyManager.report(msgDO2, extraInfo);
                    this.messageService.a(stringExtra4, stringExtra11, "0");
                    UTMini uTMini = UTMini.getInstance();
                    String[] strArr = new String[2];
                    strArr[0] = null;
                    StringBuilder sb = new StringBuilder();
                    str5 = str3;
                    try {
                        sb.append(str5);
                        sb.append(msgDO2.msgIds);
                        strArr[1] = sb.toString();
                        uTMini.commitEvent(UTMini.EVENTID_AGOO, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_ID, (Object) null, (Object) null, strArr);
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                    } catch (Throwable th6) {
                        th = th6;
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str = BaseMonitor.COUNT_AGOO_ARRIVE;
                    str2 = "accs";
                    str5 = str3;
                }
                try {
                    com.taobao.accs.utl.k.a(str2, str, "arrive", 0.0d);
                } catch (Throwable th8) {
                    th = th8;
                    try {
                        ALog.e(str4, "report message Throwable--->t=" + th.toString(), new Object[0]);
                    } catch (Throwable th9) {
                        th = th9;
                        com.taobao.accs.utl.k.a(str2, str, "arrive_exception" + th.toString(), 0.0d);
                        return;
                    }
                }
                if (this.messageService.a(stringExtra4)) {
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(str4, "handleRemoteMessage hasMessageDuplicate,messageId=" + stringExtra4 + ",utdid=" + com.taobao.accs.utl.j.b(context), new Object[0]);
                    }
                    com.taobao.accs.utl.k.a(str2, str, "arrive_dup", 0.0d);
                    return;
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(str4, "handleMessage--->[" + stringExtra5 + "],[" + stringExtra7 + "]", new Object[0]);
                }
                try {
                    String stringExtra12 = intent.getStringExtra(AgooConstants.MESSAGE_DUPLICATE);
                    if (TextUtils.isEmpty(stringExtra12)) {
                        charSequence = "1";
                    } else {
                        charSequence = "1";
                        try {
                            if (TextUtils.equals(stringExtra12, charSequence) && this.messageService.a(stringExtra4, stringExtra5.hashCode())) {
                                com.taobao.accs.utl.k.a(str2, str, "arrive_dupbody", 0.0d);
                                return;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e(str4, "hasMessageDuplicate message,e=" + th.toString(), new Object[0]);
                            }
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    charSequence = "1";
                }
                int i2 = -1;
                try {
                    i2 = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                } catch (Throwable unused3) {
                }
                String name = "";
                try {
                    stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                    try {
                        if (!TextUtils.isEmpty(stringExtra3) && TextUtils.equals(stringExtra3, charSequence)) {
                            this.messageService.a(stringExtra4, stringExtra5, stringExtra6, i2);
                            com.taobao.accs.utl.k.a(str2, str, "arrive_test", 0.0d);
                            return;
                        } else {
                            stringExtra3 = stringExtra6;
                            name = getClass().getName();
                        }
                    } catch (Throwable unused4) {
                    }
                } catch (Throwable unused5) {
                    stringExtra3 = stringExtra6;
                }
                this.messageService.a(stringExtra4, stringExtra5, stringExtra3, i2);
                UTMini.getInstance().commitEvent(UTMini.EVENTID_AGOO, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, (Object) null, (Object) null, null, str5 + msgDO2.msgIds);
                com.taobao.accs.utl.k.a(str2, str, "arrive_real_" + name, 0.0d);
                try {
                    intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                    NetPerformanceMonitor netPerformanceMonitor = (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
                    if (netPerformanceMonitor != null) {
                        netPerformanceMonitor.onToAgooTime();
                        AppMonitor.getInstance().commitStat(netPerformanceMonitor);
                    }
                } catch (Exception e2) {
                    ALog.e(str4, "get NetPerformanceMonitor Error:", e2, new Object[0]);
                }
                onMessage(context, intent);
            } catch (Throwable th12) {
                th = th12;
                str2 = "accs";
                str = BaseMonitor.COUNT_AGOO_ARRIVE;
            }
        } catch (Throwable th13) {
            th = th13;
            str = BaseMonitor.COUNT_AGOO_ARRIVE;
            str2 = "accs";
        }
    }

    private final void handleRemovePackage(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "handleRemovePackage---->[replacing:" + booleanExtra + "],uninstallPack=" + schemeSpecificPart, new Object[0]);
        }
        if (booleanExtra) {
            return;
        }
        this.notifyManager.doUninstall(schemeSpecificPart, booleanExtra);
    }

    public static void runIntentInService(Context context, Intent intent, String str) {
        try {
            intent.setClassName(context, str);
            context.startService(intent);
        } catch (Throwable th) {
            ALog.w(TAG, "runIntentInService", th, new Object[0]);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        getApplication();
        if (t.b() && v.a(this) && !isBinded) {
            isBinded = true;
            getApplicationContext().bindService(new Intent(getApplication(), getClass()), new i(this), 1);
        }
        return this.messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new j(this));
    }

    protected abstract void onError(Context context, String str);

    protected void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        String agooCommand = IntentUtil.getAgooCommand(this.mContext);
        String thirdPushCommand = IntentUtil.getThirdPushCommand(this.mContext);
        ALog.i(TAG, "onHandleIntent,action=" + action + ",agooCommand=" + agooCommand + ",mipushCommand=" + thirdPushCommand, new Object[0]);
        try {
            if (TextUtils.equals(action, agooCommand)) {
                String stringExtra = intent.getStringExtra("command");
                ALog.d(TAG, "actionCommand --->[" + stringExtra + "]", new Object[0]);
                if (TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_READED) || TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_DELETED)) {
                    onUserCommand(this.mContext, intent);
                }
            } else if (TextUtils.equals(action, thirdPushCommand)) {
                String stringExtra2 = intent.getStringExtra("command");
                String stringExtra3 = intent.getStringExtra(AgooConstants.THIRD_PUSH_ID);
                if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_MIPUSHID_REPORT)) {
                    this.notifyManager.reportThirdPushToken(stringExtra3, MiPushBroadcastReceiver.MI_TOKEN, false);
                } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_HUAWEIPUSHID_REPORT)) {
                    ALog.d(TAG, "HW_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                    this.notifyManager.reportThirdPushToken(stringExtra3, HuaweiRcvService.HUAWEI_TOKEN, false);
                } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_GCMIPUSHID_REPORT)) {
                    ALog.i(TAG, "GCM_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                    this.notifyManager.reportThirdPushToken(stringExtra3, AgooConstants.MESSAGE_SYSTEM_SOURCE_GCM, false);
                }
            } else if (action.equals(AgooConstants.INTENT_FROM_AGOO_MESSAGE)) {
                handleRemoteMessage(this.mContext, intent);
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                handleRemovePackage(this.mContext, intent);
            } else if (TextUtils.equals(action, AgooConstants.INTENT_FROM_AGOO_REPORT) || TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE") || TextUtils.equals(action, "android.intent.action.BOOT_COMPLETED") || TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || TextUtils.equals(action, "android.intent.action.USER_PRESENT") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                try {
                    ALog.i(TAG, "is report cache msg,Config.isReportCacheMsg(mContext)=" + Config.d(this.mContext), new Object[0]);
                    if (Config.d(this.mContext) && UtilityImpl.i(this.mContext)) {
                        Config.e(this.mContext);
                        this.agooFactory.reportCacheMsg();
                        this.messageService.a();
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "is clear all msg=" + Config.b(this.mContext, jCurrentTimeMillis), new Object[0]);
                    }
                    if (Config.b(this.mContext, jCurrentTimeMillis)) {
                        Config.a(this.mContext, jCurrentTimeMillis);
                        this.messageService.a();
                    }
                } catch (Throwable th) {
                    ALog.e(TAG, "reportCacheMsg", th, new Object[0]);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    protected abstract void onMessage(Context context, Intent intent);

    protected abstract void onRegistered(Context context, String str);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        ThreadPoolExecutorFactory.execute(new k(this, intent));
        return 2;
    }

    protected void onUserCommand(Context context, Intent intent) {
    }
}
