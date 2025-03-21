package org.android.agoo.control;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.UTMini;
import com.umeng.message.component.UmengMessageHandlerService;
import com.umeng.message.proguard.AbstractServiceC3597q;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NotifManager {
    private static final String ACK_MESSAGE = "accs.ackMessage";
    private static final int EVENT_ID = 66001;
    private static final String TAG = "NotifManager";
    private Context mContext = null;

    private byte[] convertMsgToBytes(MsgDO msgDO) throws UnsupportedEncodingException {
        HashMap hashMap = new HashMap();
        hashMap.put("api", "agooReport");
        hashMap.put("id", msgDO.msgIds + "@" + msgDO.messageSource);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, msgDO.extData);
        hashMap.put(NotificationCompat.CATEGORY_STATUS, msgDO.msgStatus);
        if (!TextUtils.isEmpty(msgDO.errorCode)) {
            hashMap.put("ec", msgDO.errorCode);
        }
        if (!TextUtils.isEmpty(msgDO.type)) {
            hashMap.put("type", msgDO.type);
        }
        if (!TextUtils.isEmpty(msgDO.fromPkg)) {
            hashMap.put("fromPkg", msgDO.fromPkg);
        }
        if (!TextUtils.isEmpty(msgDO.fromAppkey)) {
            hashMap.put(AgooConstants.MESSAGE_FROM_APPKEY, msgDO.fromAppkey);
        }
        if (!TextUtils.isEmpty(msgDO.notifyEnable)) {
            hashMap.put("notifyEnable", msgDO.notifyEnable);
        }
        if (!TextUtils.isEmpty(msgDO.extData)) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, msgDO.extData);
        }
        hashMap.put("isStartProc", Boolean.toString(msgDO.isStartProc));
        hashMap.put("appkey", Config.m24934a(this.mContext));
        hashMap.put("utdid", C3042j.m9247b(this.mContext));
        hashMap.put("evokeAppStatus", String.valueOf(msgDO.evokeAppStatus));
        hashMap.put("lastActiveTime", String.valueOf(msgDO.lastActiveTime));
        hashMap.put("isGlobalClick", String.valueOf(msgDO.isGlobalClick));
        return new JSONObject(hashMap).toString().getBytes("UTF-8");
    }

    private void reportMethod(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (msgDO == null) {
                ALog.m9182e(TAG, "reportMethod msg null", new Object[0]);
                return;
            }
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), null, null, null, null);
            accsRequest.setTag(msgDO.msgIds);
            String mo8915a = ACCSManager.getAccsInstance(this.mContext, Config.m24934a(this.mContext), Config.m24941c(this.mContext)).mo8915a(this.mContext, accsRequest, extraInfo);
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.m9182e(TAG, AgooConstants.MESSAGE_REPORT, Constants.KEY_DATA_ID, mo8915a, NotificationCompat.CATEGORY_STATUS, msgDO.msgStatus, "errorcode", msgDO.errorCode);
            }
        } catch (Throwable th) {
            C3043k.m9250a("accs", "error", th.toString(), 0.0d);
        }
    }

    public void doUninstall(String str, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("pack", str);
            hashMap.put("appkey", Config.m24934a(this.mContext));
            hashMap.put("utdid", C3042j.m9247b(this.mContext));
            ACCSManager.getAccsInstance(this.mContext, Config.m24934a(this.mContext), Config.m24941c(this.mContext)).mo8915a(this.mContext, new ACCSManager.AccsRequest(null, "agooKick", new JSONObject(hashMap).toString().getBytes("UTF-8"), null, null, null, null), new TaoBaseService.ExtraInfo());
        } catch (Throwable th) {
            ALog.m9181e(TAG, "[doUninstall] is error", th, new Object[0]);
        }
    }

    public void handlerACKMessage(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        if (msgDO == null) {
            return;
        }
        if (TextUtils.isEmpty(msgDO.msgIds) && TextUtils.isEmpty(msgDO.removePacks) && TextUtils.isEmpty(msgDO.errorCode)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, C3042j.m9247b(this.mContext), "handlerACKMessageRetuen", "msgids=" + msgDO.msgIds + ",removePacks=" + msgDO.removePacks + ",errorCode=" + msgDO.errorCode);
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("api", AgooConstants.AGOO_SERVICE_AGOOACK);
            hashMap.put("id", msgDO.msgIds + "@" + msgDO.messageSource);
            if (!TextUtils.isEmpty(msgDO.removePacks)) {
                hashMap.put("del_pack", msgDO.removePacks);
            }
            if (!TextUtils.isEmpty(msgDO.errorCode)) {
                hashMap.put("ec", msgDO.errorCode);
            }
            if (!TextUtils.isEmpty(msgDO.type)) {
                hashMap.put("type", msgDO.type);
            }
            if (!TextUtils.isEmpty(msgDO.extData)) {
                hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, msgDO.extData);
            }
            hashMap.put("appkey", Config.m24934a(this.mContext));
            hashMap.put("utdid", C3042j.m9247b(this.mContext));
            byte[] bytes = new JSONObject(hashMap).toString().getBytes("UTF-8");
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, C3042j.m9247b(this.mContext), "handlerACKMessageSendData", msgDO.msgIds);
            C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_ACK, "handlerACKMessage", 0.0d);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, bytes, null, null, null, null);
            if (msgDO != null) {
                accsRequest.setTag(msgDO.msgIds);
            }
            ALog.m9183i(TAG, "handlerACKMessage,endRequest,dataId=" + ACCSManager.getAccsInstance(this.mContext, Config.m24934a(this.mContext), Config.m24941c(this.mContext)).mo8915a(this.mContext, accsRequest, extraInfo), new Object[0]);
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.m9182e(TAG, "handlerACKMessage Throwable,msgIds=" + msgDO.msgIds + ",type=" + msgDO.type + ",e=" + th.toString(), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, C3042j.m9247b(this.mContext), "handlerACKMessageExceptionFailed", th.toString());
        }
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void pingApp(String str, String str2, String str3, int i2) {
    }

    public void report(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        if (TextUtils.isEmpty(msgDO.reportStr)) {
            return;
        }
        try {
            if (Integer.parseInt(msgDO.reportStr) >= -1) {
                reportMethod(msgDO, extraInfo);
                if (msgDO.isFromCache) {
                    return;
                }
                C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
            }
        } catch (Throwable th) {
            ALog.m9181e(TAG, "[report] is error", th, new Object[0]);
        }
    }

    public void reportNotifyMessage(MsgDO msgDO) {
        if (msgDO != null) {
            try {
                C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_REPORT_ID, msgDO.msgIds, 0.0d);
                ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), null, null, null, null);
                ACCSManager.getAccsInstance(this.mContext, Config.m24934a(this.mContext), Config.m24941c(this.mContext)).mo8915a(this.mContext, accsRequest, (TaoBaseService.ExtraInfo) null);
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.m9182e(TAG, "reportNotifyMessage", Constants.KEY_DATA_ID, accsRequest.dataId, NotificationCompat.CATEGORY_STATUS, msgDO.msgStatus);
                }
                C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_CLICK, msgDO.msgStatus, 0.0d);
                C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
            } catch (Throwable th) {
                ALog.m9181e(TAG, "[reportNotifyMessage] is error", th, new Object[0]);
                C3043k.m9250a("accs", "error", th.toString(), 0.0d);
            }
        }
    }

    public void reportThirdPushToken(String str, String str2, boolean z) {
        reportThirdPushToken(str, str2, null, z);
    }

    public void reportThirdPushToken(String str, String str2, String str3, boolean z) {
        ThreadPoolExecutorFactory.schedule(new RunnableC6025l(this, str2, str, str3, z), 10L, TimeUnit.SECONDS);
        try {
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(this.mContext.getPackageName());
            intent.setClass(this.mContext, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "third_token");
            intent.putExtra("third_token", str);
            intent.putExtra("type", str2);
            AbstractServiceC3597q.enqueueWork(this.mContext, UmengMessageHandlerService.class, intent);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "report push token error", th, new Object[0]);
        }
    }

    public void reportThirdPushToken(String str, String str2) {
        reportThirdPushToken(str, str2, true);
    }
}
