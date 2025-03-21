package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
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

    /* renamed from: a */
    private Context f9498a;

    /* renamed from: b */
    private FlowCtrlInfoHolder f9499b;

    /* compiled from: Taobao */
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

    /* compiled from: Taobao */
    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        Map<String, FlowControlInfo> flowCtrlMap = null;

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str + AbstractC1191a.f2606s1 + str2;
            }
            return this.flowCtrlMap.get(str);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + AbstractC1191a.f2606s1 + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(str, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.f9498a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0144  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m9055a(java.util.Map<java.lang.Integer, java.lang.String> r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.flowcontrol.FlowControl.m9055a(java.util.Map, java.lang.String):int");
    }

    /* renamed from: a */
    private boolean m9054a(long j2, long j3) {
        if (j2 != 0 && j3 > 0) {
            return true;
        }
        ALog.m9182e("FlowControl", "error flow ctrl info", new Object[0]);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:
    
        if (r5.isExpired() != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0096, code lost:
    
        m9053a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0094, code lost:
    
        if (r0.isExpired() != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x003f, B:19:0x0046, B:21:0x004c, B:24:0x0053, B:26:0x0059, B:29:0x0060, B:49:0x0088, B:51:0x0096, B:52:0x0099, B:58:0x0090), top: B:8:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059 A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x003f, B:19:0x0046, B:21:0x004c, B:24:0x0053, B:26:0x0059, B:29:0x0060, B:49:0x0088, B:51:0x0096, B:52:0x0099, B:58:0x0090), top: B:8:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0090 A[Catch: all -> 0x00dc, TryCatch #0 {, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x003f, B:19:0x0046, B:21:0x004c, B:24:0x0053, B:26:0x0059, B:29:0x0060, B:49:0x0088, B:51:0x0096, B:52:0x0099, B:58:0x0090), top: B:8:0x0013 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m9056a(java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.flowcontrol.FlowControl.m9056a(java.lang.String, java.lang.String):long");
    }

    /* renamed from: a */
    private void m9053a() {
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f9499b;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null) {
            return;
        }
        synchronized (this) {
            Iterator<Map.Entry<String, FlowControlInfo>> it = this.f9499b.flowCtrlMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().isExpired()) {
                    it.remove();
                }
            }
        }
    }
}
