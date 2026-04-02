package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class l implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f12885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f12886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ NotifManager f12887e;

    l(NotifManager notifManager, String str, String str2, String str3, boolean z) {
        this.f12887e = notifManager;
        this.a = str;
        this.f12884b = str2;
        this.f12885c = str3;
        this.f12886d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HashMap map = new HashMap();
            map.put("thirdTokenType", this.a);
            map.put("token", this.f12884b);
            map.put("appkey", Config.a(this.f12887e.mContext));
            map.put("utdid", com.taobao.accs.utl.j.b(this.f12887e.mContext));
            if (!TextUtils.isEmpty(this.f12885c)) {
                map.put("vendorSdkVersion", this.f12885c);
            }
            ALog.d("NotifManager", "report,utdid=" + com.taobao.accs.utl.j.b(this.f12887e.mContext) + ",regId=" + this.f12884b + ",type=" + this.a, new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, "agooTokenReport", new JSONObject(map).toString().getBytes("UTF-8"), null, null, null, null);
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(this.f12887e.mContext, Config.a(this.f12887e.mContext), Config.c(this.f12887e.mContext));
            String strA = this.f12886d ? accsInstance.a(this.f12887e.mContext, accsRequest) : accsInstance.a(this.f12887e.mContext, accsRequest, new TaoBaseService.ExtraInfo());
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.i("NotifManager", "reportThirdPushToken,dataId=" + strA + ",regId=" + this.f12884b + ",type=" + this.a, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", com.taobao.accs.utl.j.b(this.f12887e.mContext), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
