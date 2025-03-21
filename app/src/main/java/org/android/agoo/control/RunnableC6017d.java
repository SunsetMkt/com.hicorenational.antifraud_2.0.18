package org.android.agoo.control;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3043k;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.d */
/* loaded from: classes2.dex */
class RunnableC6017d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ byte[] f21488a;

    /* renamed from: b */
    final /* synthetic */ boolean f21489b;

    /* renamed from: c */
    final /* synthetic */ AgooFactory f21490c;

    RunnableC6017d(AgooFactory agooFactory, byte[] bArr, boolean z) {
        this.f21490c = agooFactory;
        this.f21488a = bArr;
        this.f21489b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageService messageService;
        MessageService messageService2;
        try {
            String str = new String(this.f21488a, "utf-8");
            if (TextUtils.isEmpty(str)) {
                C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "msg==null", 0.0d);
                return;
            }
            ALog.m9183i("AgooFactory", "message = " + str, new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("api");
            String string2 = jSONObject.getString("id");
            String string3 = TextUtils.equals(string, "agooReport") ? jSONObject.getString(NotificationCompat.CATEGORY_STATUS) : null;
            if (TextUtils.equals(string, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "handlerACKMessage", 0.0d);
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.m9183i("AgooFactory", "updateMsg data begin,api=" + string + ",id=" + string2 + ",status=" + string3 + ",reportTimes=" + Config.m24945f(AgooFactory.mContext), new Object[0]);
                }
                if (TextUtils.equals(string, "agooReport")) {
                    if (TextUtils.equals(string3, "4") && this.f21489b) {
                        messageService2 = this.f21490c.messageService;
                        messageService2.m24964a(string2, "1");
                    } else if ((TextUtils.equals(string3, "8") || TextUtils.equals(string3, "9")) && this.f21489b) {
                        messageService = this.f21490c.messageService;
                        messageService.m24964a(string2, MessageService.MSG_DB_COMPLETE);
                    }
                    C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, string3, 0.0d);
                    return;
                }
                return;
            }
            C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json key null", 0.0d);
        } catch (Throwable th) {
            ALog.m9182e("AgooFactory", "updateMsg get data error,e=" + th, new Object[0]);
            C3043k.m9250a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json exception", 0.0d);
        }
    }
}
