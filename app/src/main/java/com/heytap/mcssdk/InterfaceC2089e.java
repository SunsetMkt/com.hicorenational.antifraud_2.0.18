package com.heytap.mcssdk;

import android.content.Context;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.heytap.mcssdk.e */
/* loaded from: classes.dex */
interface InterfaceC2089e {
    /* renamed from: a */
    void mo5703a();

    @Deprecated
    /* renamed from: a */
    void mo5704a(int i2);

    @Deprecated
    /* renamed from: a */
    void mo5705a(int i2, JSONObject jSONObject);

    /* renamed from: a */
    void mo5706a(Context context, String str, String str2, ICallBackResultService iCallBackResultService);

    /* renamed from: a */
    void mo5707a(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService);

    /* renamed from: a */
    void mo5709a(IGetAppNotificationCallBackService iGetAppNotificationCallBackService);

    /* renamed from: a */
    void mo5710a(ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    /* renamed from: a */
    void mo5711a(String str);

    /* renamed from: a */
    void mo5713a(List<Integer> list, int i2, int i3, int i4, int i5);

    /* renamed from: a */
    void mo5714a(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject);

    /* renamed from: a */
    void mo5715a(JSONObject jSONObject);

    /* renamed from: b */
    void mo5717b();

    /* renamed from: b */
    void mo5720b(ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    @Deprecated
    /* renamed from: b */
    void mo5721b(JSONObject jSONObject);

    /* renamed from: c */
    void mo5722c();

    /* renamed from: c */
    void mo5724c(JSONObject jSONObject);

    /* renamed from: d */
    String mo5727d();

    /* renamed from: d */
    void mo5728d(JSONObject jSONObject);

    /* renamed from: e */
    void mo5730e();

    /* renamed from: e */
    void mo5731e(JSONObject jSONObject);

    /* renamed from: f */
    void mo5732f();

    /* renamed from: f */
    void mo5733f(JSONObject jSONObject);

    @Deprecated
    /* renamed from: g */
    void mo5734g();

    /* renamed from: g */
    void mo5735g(JSONObject jSONObject);

    /* renamed from: h */
    void mo5736h();

    /* renamed from: h */
    void mo5737h(JSONObject jSONObject);

    /* renamed from: i */
    void mo5738i();

    /* renamed from: i */
    void mo5739i(JSONObject jSONObject);

    void unRegister();
}
