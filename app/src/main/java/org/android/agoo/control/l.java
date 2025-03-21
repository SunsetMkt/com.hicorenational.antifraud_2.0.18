package org.android.agoo.control;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17346a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17347b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17348c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f17349d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NotifManager f17350e;

    l(NotifManager notifManager, String str, String str2, String str3, boolean z) {
        this.f17350e = notifManager;
        this.f17346a = str;
        this.f17347b = str2;
        this.f17348c = str3;
        this.f17349d = z;
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
        String a2;
        Context context9;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("thirdTokenType", this.f17346a);
            hashMap.put("token", this.f17347b);
            context2 = this.f17350e.mContext;
            hashMap.put("appkey", Config.a(context2));
            context3 = this.f17350e.mContext;
            hashMap.put("utdid", com.taobao.accs.utl.j.b(context3));
            if (!TextUtils.isEmpty(this.f17348c)) {
                hashMap.put("vendorSdkVersion", this.f17348c);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("report,utdid=");
            context4 = this.f17350e.mContext;
            sb.append(com.taobao.accs.utl.j.b(context4));
            sb.append(",regId=");
            sb.append(this.f17347b);
            sb.append(",type=");
            sb.append(this.f17346a);
            ALog.d("NotifManager", sb.toString(), new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, "agooTokenReport", new JSONObject(hashMap).toString().getBytes("UTF-8"), null, null, null, null);
            context5 = this.f17350e.mContext;
            context6 = this.f17350e.mContext;
            String a3 = Config.a(context6);
            context7 = this.f17350e.mContext;
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context5, a3, Config.c(context7));
            if (this.f17349d) {
                context9 = this.f17350e.mContext;
                a2 = accsInstance.a(context9, accsRequest);
            } else {
                context8 = this.f17350e.mContext;
                a2 = accsInstance.a(context8, accsRequest, new TaoBaseService.ExtraInfo());
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.i("NotifManager", "reportThirdPushToken,dataId=" + a2 + ",regId=" + this.f17347b + ",type=" + this.f17346a, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini uTMini = UTMini.getInstance();
            context = this.f17350e.mContext;
            uTMini.commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", com.taobao.accs.utl.j.b(context), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
