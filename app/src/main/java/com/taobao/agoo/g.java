package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.l;
import java.util.Map;
import org.android.agoo.common.Config;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class g implements IAgooAppReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f8730a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f8731b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ IRegister f8732c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f8733d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f8734e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.taobao.accs.b f8735f;

    g(Context context, Context context2, IRegister iRegister, String str, String str2, com.taobao.accs.b bVar) {
        this.f8730a = context;
        this.f8731b = context2;
        this.f8732c = iRegister;
        this.f8733d = str;
        this.f8734e = str2;
        this.f8735f = bVar;
    }

    @Override // com.taobao.accs.IAppReceiver
    public Map<String, String> getAllServices() {
        return null;
    }

    @Override // com.taobao.accs.IAgooAppReceiver
    public String getAppkey() {
        return this.f8733d;
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
        com.taobao.agoo.a.b bVar;
        com.taobao.agoo.a.b bVar2;
        com.taobao.agoo.a.b bVar3;
        try {
            ALog.i("TaobaoRegister", "onBindApp", Constants.KEY_ERROR_CODE, Integer.valueOf(i2));
            if (i2 != 200) {
                if (this.f8732c != null) {
                    this.f8732c.onFailure(String.valueOf(i2), "accs bindapp error!");
                    return;
                }
                return;
            }
            bVar = TaobaoRegister.mRequestListener;
            if (bVar == null) {
                com.taobao.agoo.a.b unused = TaobaoRegister.mRequestListener = new com.taobao.agoo.a.b(this.f8730a);
            }
            GlobalClientInfo globalClientInfo = GlobalClientInfo.getInstance(this.f8731b);
            bVar2 = TaobaoRegister.mRequestListener;
            globalClientInfo.registerListener("AgooDeviceCmd", bVar2);
            if (com.taobao.agoo.a.b.f8728b.b(this.f8730a.getPackageName()) && !UtilityImpl.b(Constants.SP_CHANNEL_FILE_NAME, this.f8731b)) {
                String g2 = Config.g(this.f8730a);
                if (!TextUtils.isEmpty(g2)) {
                    boolean unused2 = TaobaoRegister.isRegisterSuccess = true;
                    l.a().b();
                    ALog.i("TaobaoRegister", "agoo already Registered return ", new Object[0]);
                    if (this.f8732c != null) {
                        this.f8732c.onSuccess(g2);
                        return;
                    }
                    return;
                }
            }
            byte[] a2 = com.taobao.agoo.a.a.c.a(this.f8730a, this.f8733d, this.f8734e);
            if (a2 == null) {
                if (this.f8732c != null) {
                    this.f8732c.onFailure("503.1", "req data null");
                    return;
                }
                return;
            }
            String b2 = this.f8735f.b(this.f8730a, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", a2, null));
            if (TextUtils.isEmpty(b2)) {
                if (this.f8732c != null) {
                    this.f8732c.onFailure("503.1", "accs channel disabled!");
                }
            } else if (this.f8732c != null) {
                bVar3 = TaobaoRegister.mRequestListener;
                bVar3.f8729a.put(b2, this.f8732c);
            }
        } catch (Throwable th) {
            ALog.e("TaobaoRegister", "register onBindApp", th, new Object[0]);
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
