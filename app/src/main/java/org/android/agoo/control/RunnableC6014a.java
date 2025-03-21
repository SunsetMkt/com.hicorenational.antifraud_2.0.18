package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.C3351bh;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.a */
/* loaded from: classes2.dex */
class RunnableC6014a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ byte[] f21480a;

    /* renamed from: b */
    final /* synthetic */ String f21481b;

    /* renamed from: c */
    final /* synthetic */ AgooFactory f21482c;

    RunnableC6014a(AgooFactory agooFactory, byte[] bArr, String str) {
        this.f21482c = agooFactory;
        this.f21480a = bArr;
        this.f21481b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageService messageService;
        MessageService messageService2;
        try {
            String str = new String(this.f21480a, "utf-8");
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 1) {
                String str2 = null;
                String str3 = null;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        str2 = jSONObject.getString(C3351bh.f11581aF);
                        str3 = jSONObject.getString(C3351bh.f11576aA);
                    }
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.m9183i("AgooFactory", "saveMsg msgId:" + str2 + ",message=" + str + ",currentPack=" + str3 + ",reportTimes=" + Config.m24945f(AgooFactory.mContext), new Object[0]);
                }
                if (TextUtils.isEmpty(str3) || !TextUtils.equals(str3, AgooFactory.mContext.getPackageName())) {
                    return;
                }
                if (TextUtils.isEmpty(this.f21481b)) {
                    messageService2 = this.f21482c.messageService;
                    messageService2.m24965a(str2, str, "0");
                } else {
                    messageService = this.f21482c.messageService;
                    messageService.m24965a(str2, str, this.f21481b);
                }
            }
        } catch (Throwable th) {
            ALog.m9182e("AgooFactory", "saveMsg fail:" + th.toString(), new Object[0]);
        }
    }
}
