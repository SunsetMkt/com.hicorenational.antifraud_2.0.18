package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import d.c.a.b.a.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FlowCtrlInfoHolder f5784b;

    /* JADX INFO: compiled from: Taobao */
    public static class FlowControlInfo implements Serializable {
        private static final long serialVersionUID = -2259991484877844919L;
        public String bizId;
        public long delayTime;
        public long expireTime;
        public String serviceId;
        public long startTime;
        public int status;

        public FlowControlInfo(String str, String str2, int i2, long j2, long j3, long j4) {
            this.serviceId = str;
            this.bizId = str2;
            this.status = i2;
            this.delayTime = j2;
            this.expireTime = j3 <= 0 ? 0L : j3;
            this.startTime = j4 > 0 ? j4 : 0L;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - (this.startTime + this.expireTime) > 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("flow ctrl serviceId:");
            stringBuffer.append(this.serviceId);
            stringBuffer.append(" bizId:");
            stringBuffer.append(this.bizId);
            stringBuffer.append(" status:");
            stringBuffer.append(this.status);
            stringBuffer.append(" delayTime:");
            stringBuffer.append(this.delayTime);
            stringBuffer.append(" startTime:");
            stringBuffer.append(this.startTime);
            stringBuffer.append(" expireTime:");
            stringBuffer.append(this.expireTime);
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        Map<String, FlowControlInfo> flowCtrlMap = null;

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str + a.s1 + str2;
            }
            return this.flowCtrlMap.get(str);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + a.s1 + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(str, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.a = context;
    }

    public int a(Map<Integer, String> map, String str) {
        long j2;
        int iIntValue;
        FlowControlInfo flowControlInfo;
        if (map != null) {
            try {
                String str2 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_STATUS.ordinal()));
                String str3 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_DELAY.ordinal()));
                String str4 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_EXPIRE.ordinal()));
                String str5 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()));
                iIntValue = TextUtils.isEmpty(str2) ? 0 : Integer.valueOf(str2).intValue();
                try {
                    long jLongValue = TextUtils.isEmpty(str3) ? 0L : Long.valueOf(str3).longValue();
                    try {
                        long jLongValue2 = TextUtils.isEmpty(str4) ? 0L : Long.valueOf(str4).longValue();
                        if ((iIntValue != 420 && iIntValue != 421 && iIntValue != 422) || !a(jLongValue, jLongValue2)) {
                            return 0;
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (this.f5784b == null) {
                                        this.f5784b = new FlowCtrlInfoHolder();
                                    }
                                    if (iIntValue == 420) {
                                        j2 = jLongValue;
                                        flowControlInfo = new FlowControlInfo("ALL", "", iIntValue, jLongValue, jLongValue2, System.currentTimeMillis());
                                        this.f5784b.put("ALL", "", flowControlInfo);
                                    } else {
                                        j2 = jLongValue;
                                        if (iIntValue == 422) {
                                            flowControlInfo = new FlowControlInfo(SERVICE_ALL_BRUSH, "", iIntValue, j2, jLongValue2, System.currentTimeMillis());
                                            this.f5784b.put(SERVICE_ALL_BRUSH, "", flowControlInfo);
                                        } else if (iIntValue != 421 || TextUtils.isEmpty(str)) {
                                            flowControlInfo = null;
                                        } else {
                                            FlowControlInfo flowControlInfo2 = new FlowControlInfo(str, str5, iIntValue, j2, jLongValue2, System.currentTimeMillis());
                                            this.f5784b.put(str, str5, flowControlInfo2);
                                            flowControlInfo = flowControlInfo2;
                                        }
                                    }
                                    if (flowControlInfo != null) {
                                        ALog.e("FlowControl", "updateFlowCtrlInfo " + flowControlInfo.toString(), new Object[0]);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    j2 = jLongValue;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        j2 = jLongValue;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    j2 = 0;
                }
            } catch (Throwable th6) {
                th = th6;
                j2 = 0;
                iIntValue = 0;
            }
            ALog.e("FlowControl", "updateFlowCtrlInfo", th, new Object[0]);
        } else {
            j2 = 0;
            iIntValue = 0;
        }
        if (j2 > 0) {
            return 1;
        }
        if (j2 == 0) {
            return 0;
        }
        return 422 == iIntValue ? 3 : 2;
    }

    private boolean a(long j2, long j3) {
        if (j2 != 0 && j3 > 0) {
            return true;
        }
        ALog.e("FlowControl", "error flow ctrl info", new Object[0]);
        return false;
    }

    public long a(String str, String str2) {
        long j2;
        long j3;
        long j4;
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f5784b;
        long j5 = 0;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        synchronized (this) {
            FlowControlInfo flowControlInfo = this.f5784b.get("ALL", null);
            FlowControlInfo flowControlInfo2 = this.f5784b.get(SERVICE_ALL_BRUSH, null);
            FlowControlInfo flowControlInfo3 = this.f5784b.get(str, null);
            FlowControlInfo flowControlInfo4 = this.f5784b.get(str, str2);
            j2 = (flowControlInfo == null || flowControlInfo.isExpired()) ? 0L : flowControlInfo.delayTime;
            long j6 = (flowControlInfo2 == null || flowControlInfo2.isExpired()) ? 0L : flowControlInfo2.delayTime;
            j3 = (flowControlInfo3 == null || flowControlInfo3.isExpired()) ? 0L : flowControlInfo3.delayTime;
            if (flowControlInfo4 != null && !flowControlInfo4.isExpired()) {
                j5 = flowControlInfo4.delayTime;
            }
            j4 = -1;
            if (j2 != -1 && j5 != -1 && j3 != -1) {
                if (j6 == -1) {
                    j4 = -1000;
                } else {
                    long j7 = j2 > j5 ? j2 : j5;
                    j4 = j7 > j3 ? j7 : j3;
                }
            }
            if ((flowControlInfo4 != null && flowControlInfo4.isExpired()) || (flowControlInfo != null && flowControlInfo.isExpired())) {
                a();
            }
        }
        ALog.e("FlowControl", "getFlowCtrlDelay service " + str + " biz " + str2 + " result:" + j4 + " global:" + j2 + " serviceDelay:" + j3 + " bidDelay:" + j5, new Object[0]);
        return j4;
    }

    private void a() {
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f5784b;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null) {
            return;
        }
        synchronized (this) {
            Iterator<Map.Entry<String, FlowControlInfo>> it = this.f5784b.flowCtrlMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().isExpired()) {
                    it.remove();
                }
            }
        }
    }
}
