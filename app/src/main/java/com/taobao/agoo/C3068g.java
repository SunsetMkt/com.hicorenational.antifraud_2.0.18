package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.InterfaceC2965b;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3044l;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.p201a.C3062b;
import com.taobao.agoo.p201a.p202a.C3060c;
import java.util.Map;
import org.android.agoo.common.Config;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.g */
/* loaded from: classes2.dex */
class C3068g implements IAgooAppReceiver {

    /* renamed from: a */
    final /* synthetic */ Context f9800a;

    /* renamed from: b */
    final /* synthetic */ Context f9801b;

    /* renamed from: c */
    final /* synthetic */ IRegister f9802c;

    /* renamed from: d */
    final /* synthetic */ String f9803d;

    /* renamed from: e */
    final /* synthetic */ String f9804e;

    /* renamed from: f */
    final /* synthetic */ InterfaceC2965b f9805f;

    C3068g(Context context, Context context2, IRegister iRegister, String str, String str2, InterfaceC2965b interfaceC2965b) {
        this.f9800a = context;
        this.f9801b = context2;
        this.f9802c = iRegister;
        this.f9803d = str;
        this.f9804e = str2;
        this.f9805f = interfaceC2965b;
    }

    @Override // com.taobao.accs.IAppReceiver
    public Map<String, String> getAllServices() {
        return null;
    }

    @Override // com.taobao.accs.IAgooAppReceiver
    public String getAppkey() {
        return this.f9803d;
    }

    @Override // com.taobao.accs.IAppReceiver
    public String getService(String str) {
        return null;
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindApp(int i2) {
    }

    @Override // com.taobao.accs.IAppReceiverV1
    public void onBindApp(int i2, String str) {
        C3062b c3062b;
        C3062b c3062b2;
        C3062b c3062b3;
        try {
            ALog.m9183i("TaobaoRegister", "onBindApp", Constants.KEY_ERROR_CODE, Integer.valueOf(i2));
            if (i2 != 200) {
                if (this.f9802c != null) {
                    this.f9802c.onFailure(String.valueOf(i2), "accs bindapp error!");
                    return;
                }
                return;
            }
            c3062b = TaobaoRegister.mRequestListener;
            if (c3062b == null) {
                C3062b unused = TaobaoRegister.mRequestListener = new C3062b(this.f9800a);
            }
            GlobalClientInfo globalClientInfo = GlobalClientInfo.getInstance(this.f9801b);
            c3062b2 = TaobaoRegister.mRequestListener;
            globalClientInfo.registerListener("AgooDeviceCmd", c3062b2);
            if (C3062b.f9798b.m9294b(this.f9800a.getPackageName()) && !UtilityImpl.m9211b(Constants.SP_CHANNEL_FILE_NAME, this.f9801b)) {
                String m24946g = Config.m24946g(this.f9800a);
                if (!TextUtils.isEmpty(m24946g)) {
                    boolean unused2 = TaobaoRegister.isRegisterSuccess = true;
                    C3044l.m9252a().m9257b();
                    ALog.m9183i("TaobaoRegister", "agoo already Registered return ", new Object[0]);
                    if (this.f9802c != null) {
                        this.f9802c.onSuccess(m24946g);
                        return;
                    }
                    return;
                }
            }
            byte[] m9302a = C3060c.m9302a(this.f9800a, this.f9803d, this.f9804e);
            if (m9302a == null) {
                if (this.f9802c != null) {
                    this.f9802c.onFailure("503.1", "req data null");
                    return;
                }
                return;
            }
            String mo8936b = this.f9805f.mo8936b(this.f9800a, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", m9302a, null));
            if (TextUtils.isEmpty(mo8936b)) {
                if (this.f9802c != null) {
                    this.f9802c.onFailure("503.1", "accs channel disabled!");
                }
            } else if (this.f9802c != null) {
                c3062b3 = TaobaoRegister.mRequestListener;
                c3062b3.f9799a.put(mo8936b, this.f9802c);
            }
        } catch (Throwable th) {
            ALog.m9181e("TaobaoRegister", "register onBindApp", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindUser(String str, int i2) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onData(String str, String str2, byte[] bArr) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onSendData(String str, int i2) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindApp(int i2) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindUser(int i2) {
    }
}
