package org.android.agoo.accs;

import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.UTMini;
import java.nio.charset.Charset;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.control.AgooFactory;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AgooService extends TaoBaseService {

    /* renamed from: a */
    public static CallBack f21463a;

    /* renamed from: b */
    public static CallBack f21464b;

    /* renamed from: c */
    private AgooFactory f21465c;

    /* renamed from: a */
    private String m24933a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i2, TaoBaseService.ExtraInfo extraInfo) {
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.m9182e("AgooService", "into--[onBind]:serviceId:" + str + ",errorCode=" + i2, new Object[0]);
        }
        if (f21463a != null && GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            if (i2 == 200) {
                f21463a.onSuccess();
            } else {
                f21463a.onFailure(String.valueOf(i2), "bind Agoo service fail");
            }
        }
        f21463a = null;
    }

    @Override // com.taobao.accs.base.TaoBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ALog.m9180d("AgooService", "into--[onCreate]", new Object[0]);
        this.f21465c = new AgooFactory();
        this.f21465c.init(getApplicationContext(), null, null);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i("AgooService", "into--[onData]:serviceId:" + str + ",dataId=" + str3, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("push data:");
            sb.append(new String(bArr, Charset.forName("UTF-8")));
            ALog.m9180d("AgooService", sb.toString(), new Object[0]);
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", C3042j.m9247b(getApplicationContext()), str3);
        C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_TOTAL_ARRIVE, "total_arrive", 0.0d);
        try {
            this.f21465c.saveMsg(bArr);
            this.f21465c.msgRecevie(bArr, "accs", extraInfo);
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", "onDataError", th);
            ALog.m9182e("AgooService", "into--[onData,dealMessage]:error:" + th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.base.TaoBaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i2, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i("AgooService", "onResponse,dataId=" + str2 + ",errorCode=" + i2 + ",data=" + bArr + ",serviceId=" + str, new Object[0]);
        }
        String str3 = null;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    str3 = new String(bArr, "utf-8");
                }
            } catch (Throwable th) {
                ALog.m9182e("AgooService", "onResponse get data error,e=" + th, new Object[0]);
            }
        }
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.m9180d("AgooService", "onResponse,message=" + str3, new Object[0]);
        }
        if (i2 == 200 && TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK)) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.m9182e("AgooService", "request is success", Constants.KEY_DATA_ID, str2);
            }
            this.f21465c.updateMsg(bArr, true);
        } else {
            if (i2 != 200 && TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.m9182e("AgooService", "request is error", Constants.KEY_DATA_ID, str2, "errorid", Integer.valueOf(i2));
                }
                Config.m24935a(getApplicationContext(), 1);
                C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, String.valueOf(i2), 0.0d);
                return;
            }
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.m9182e("AgooService", "business request is error,message=" + str3, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i2, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.m9183i("AgooService", "onSendData,dataId=" + str2 + ",errorCode=" + i2 + ",serviceId=" + str, new Object[0]);
            }
            if (i2 != 200) {
                if (TextUtils.equals(AgooConstants.AGOO_SERVICE_AGOOACK, str)) {
                    Config.m24935a(getApplicationContext(), 1);
                    C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, String.valueOf(i2), 0.0d);
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.m9183i("AgooService", "onSendData error,dataId=" + str2 + ",serviceId=" + str, new Object[0]);
                    ALog.m9182e("AgooService", "into--[parseError]", new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", C3042j.m9247b(getApplicationContext()), Constants.KEY_ERROR_CODE, str2 + ",serviceId=" + str + ",errorCode=" + i2);
                return;
            }
            if (TextUtils.equals(AgooConstants.AGOO_SERVICE_AGOOACK, str)) {
                C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "8/9", 0.0d);
            }
            if (!TextUtils.isEmpty(str) && TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK) && Long.parseLong(str2) > 300000000 && Long.parseLong(str2) < 600000000) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.m9183i("AgooService", "onSendData,AckData=" + str2 + ",serviceId=" + str, new Object[0]);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str) || !TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK) || Long.parseLong(str2) <= 600000000 || !ALog.isPrintLog(ALog.Level.I)) {
                return;
            }
            ALog.m9183i("AgooService", "onSendData,reportData=" + str2 + ",serviceId=" + str, new Object[0]);
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.m9182e("AgooService", "onSendData exception,e=" + th.getMessage() + ",e.getStackMsg=" + m24933a(th), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", C3042j.m9247b(getApplicationContext()), "onSendDataException", m24933a(th));
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i2, TaoBaseService.ExtraInfo extraInfo) {
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.m9182e("AgooService", "into--[onUnbind]:serviceId:" + str + ",errorCode=" + i2, new Object[0]);
        }
        if (f21464b != null && GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            if (i2 == 200) {
                f21464b.onSuccess();
            } else {
                f21464b.onFailure(String.valueOf(i2), "unbind Agoo service fail");
            }
        }
        f21464b = null;
    }
}
