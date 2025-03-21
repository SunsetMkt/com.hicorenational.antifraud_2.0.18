package org.android.agoo.control;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.InterfaceC2965b;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.l */
/* loaded from: classes2.dex */
class RunnableC6025l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f21502a;

    /* renamed from: b */
    final /* synthetic */ String f21503b;

    /* renamed from: c */
    final /* synthetic */ String f21504c;

    /* renamed from: d */
    final /* synthetic */ boolean f21505d;

    /* renamed from: e */
    final /* synthetic */ NotifManager f21506e;

    RunnableC6025l(NotifManager notifManager, String str, String str2, String str3, boolean z) {
        this.f21506e = notifManager;
        this.f21502a = str;
        this.f21503b = str2;
        this.f21504c = str3;
        this.f21505d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        String mo8915a;
        Context context9;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("thirdTokenType", this.f21502a);
            hashMap.put("token", this.f21503b);
            context2 = this.f21506e.mContext;
            hashMap.put("appkey", Config.m24934a(context2));
            context3 = this.f21506e.mContext;
            hashMap.put("utdid", C3042j.m9247b(context3));
            if (!TextUtils.isEmpty(this.f21504c)) {
                hashMap.put("vendorSdkVersion", this.f21504c);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("report,utdid=");
            context4 = this.f21506e.mContext;
            sb.append(C3042j.m9247b(context4));
            sb.append(",regId=");
            sb.append(this.f21503b);
            sb.append(",type=");
            sb.append(this.f21502a);
            ALog.m9180d("NotifManager", sb.toString(), new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, "agooTokenReport", new JSONObject(hashMap).toString().getBytes("UTF-8"), null, null, null, null);
            context5 = this.f21506e.mContext;
            context6 = this.f21506e.mContext;
            String m24934a = Config.m24934a(context6);
            context7 = this.f21506e.mContext;
            InterfaceC2965b accsInstance = ACCSManager.getAccsInstance(context5, m24934a, Config.m24941c(context7));
            if (this.f21505d) {
                context9 = this.f21506e.mContext;
                mo8915a = accsInstance.mo8914a(context9, accsRequest);
            } else {
                context8 = this.f21506e.mContext;
                mo8915a = accsInstance.mo8915a(context8, accsRequest, new TaoBaseService.ExtraInfo());
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9183i("NotifManager", "reportThirdPushToken,dataId=" + mo8915a + ",regId=" + this.f21503b + ",type=" + this.f21502a, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini uTMini = UTMini.getInstance();
            context = this.f21506e.mContext;
            uTMini.commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", C3042j.m9247b(context), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.m9181e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
