package com.taobao.agoo.p201a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3044l;
import com.taobao.accs.utl.C3048p;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import com.taobao.agoo.p201a.p202a.C3058a;
import com.taobao.agoo.p201a.p202a.C3061d;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.a.b */
/* loaded from: classes2.dex */
public class C3062b implements AccsDataListener {

    /* renamed from: b */
    public static C3057a f9798b;

    /* renamed from: a */
    public Map<String, ICallback> f9799a = new HashMap();

    public C3062b(Context context) {
        if (f9798b == null) {
            f9798b = new C3057a(context.getApplicationContext());
        }
    }

    /* renamed from: a */
    private void m9306a(JSONObject jSONObject, ICallback iCallback) throws JSONException {
        String m9259a = C3048p.m9259a(jSONObject, C3058a.JSON_PUSH_USER_TOKEN, null);
        if (TextUtils.isEmpty(m9259a)) {
            if (iCallback != null) {
                iCallback.onFailure("", "agoo server error-pushtoken null");
            }
        } else {
            Config.m24942c(GlobalClientInfo.getContext(), m9259a);
            if (iCallback != null) {
                iCallback.onSuccess();
                f9798b.m9295c(iCallback.extra);
            }
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i2, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i2, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        boolean equals;
        try {
            if ("AgooDeviceCmd".equals(str)) {
                ICallback iCallback = this.f9799a.get(str2);
                if (i2 == 200) {
                    String str3 = new String(bArr, "utf-8");
                    ALog.m9183i("RequestListener", "RequestListener onResponse", Constants.KEY_DATA_ID, str2, "listener", iCallback, "json", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    String m9259a = C3048p.m9259a(jSONObject, AbstractC3059b.JSON_ERRORCODE, null);
                    String m9259a2 = C3048p.m9259a(jSONObject, AbstractC3059b.JSON_CMD, null);
                    if (!"success".equals(m9259a)) {
                        if (iCallback != null) {
                            iCallback.onFailure(String.valueOf(m9259a), "agoo server error");
                        }
                        if (equals) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if ("register".equals(m9259a2)) {
                        String m9259a3 = C3048p.m9259a(jSONObject, "deviceId", null);
                        if (!TextUtils.isEmpty(m9259a3)) {
                            TaobaoRegister.setIsRegisterSuccess(true);
                            C3044l.m9252a().m9257b();
                            Config.m24939b(GlobalClientInfo.getContext(), m9259a3);
                            f9798b.m9293a(GlobalClientInfo.getContext().getPackageName());
                            if (iCallback instanceof IRegister) {
                                UtilityImpl.m9212c(Config.PREFERENCES, GlobalClientInfo.getContext());
                                ((IRegister) iCallback).onSuccess(m9259a3);
                            }
                        } else if (iCallback != null) {
                            iCallback.onFailure("", "agoo server error deviceid null");
                        }
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f9799a.remove(str2);
                            return;
                        }
                        return;
                    }
                    if (C3058a.JSON_CMD_SETALIAS.equals(m9259a2)) {
                        m9306a(jSONObject, iCallback);
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f9799a.remove(str2);
                            return;
                        }
                        return;
                    }
                    if (C3058a.JSON_CMD_REMOVEALIAS.equals(m9259a2)) {
                        Config.m24942c(GlobalClientInfo.getContext(), null);
                        if (iCallback != null) {
                            iCallback.onSuccess();
                        }
                        f9798b.m9292a();
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f9799a.remove(str2);
                            return;
                        }
                        return;
                    }
                    if ((C3061d.JSON_CMD_ENABLEPUSH.equals(m9259a2) || C3061d.JSON_CMD_DISABLEPUSH.equals(m9259a2)) && iCallback != null) {
                        iCallback.onSuccess();
                    }
                } else if (iCallback != null) {
                    iCallback.onFailure(String.valueOf(i2), "accs channel error");
                }
            }
            if (!"AgooDeviceCmd".equals(str)) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.m9181e("RequestListener", "onResponse", th, new Object[0]);
                if (!"AgooDeviceCmd".equals(str)) {
                    return;
                }
            } finally {
                if ("AgooDeviceCmd".equals(str)) {
                    this.f9799a.remove(str2);
                }
            }
        }
        this.f9799a.remove(str2);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i2, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i2, TaoBaseService.ExtraInfo extraInfo) {
    }
}
