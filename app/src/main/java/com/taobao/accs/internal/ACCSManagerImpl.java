package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import com.heytap.mcssdk.constant.C2084a;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.InterfaceC2965b;
import com.taobao.accs.InterfaceC2977c;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.C2989g;
import com.taobao.accs.data.Message;
import com.taobao.accs.p197a.C2961a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.C3044l;
import com.taobao.accs.utl.C3054v;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.C3397d;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.Config;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ACCSManagerImpl implements InterfaceC2965b {

    /* renamed from: c */
    private static String f9500c = "ACCSMgrImpl_";

    /* renamed from: b */
    private String f9502b;

    /* renamed from: d */
    private InterfaceC2977c f9503d;

    /* renamed from: a */
    private int f9501a = 0;

    /* renamed from: e */
    private Random f9504e = new Random();

    /* renamed from: f */
    private C3044l.b f9505f = new C2996a(this);

    public ACCSManagerImpl(Context context, String str) {
        GlobalClientInfo.f9386a = context.getApplicationContext();
        this.f9502b = str;
        this.f9503d = new C2998c(str);
        if (C3054v.m9289e(context)) {
            C3044l.m9252a().m9256a(this.f9505f);
        }
        f9500c += this.f9502b;
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: c */
    public void mo8945c(Context context, String str) {
        if (UtilityImpl.m9217d(context)) {
            return;
        }
        Intent m9062b = m9062b(context, 6);
        if (m9062b == null) {
            m9058a(context, 6, str, (String) null);
            return;
        }
        String mo8967c = this.f9503d.mo8967c();
        if (TextUtils.isEmpty(mo8967c)) {
            return;
        }
        m9062b.putExtra("appKey", mo8967c);
        m9062b.putExtra(Constants.KEY_SERVICE_ID, str);
        if (UtilityImpl.isMainProcess(context)) {
            m9059a(context, Message.buildUnbindService(this.f9503d.mo8964b((String) null), this.f9502b, m9062b), 6, false);
        }
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: e */
    public void mo8948e(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: b */
    public void mo8940b(Context context, String str) {
        if (UtilityImpl.m9217d(context) || UtilityImpl.m9217d(context)) {
            return;
        }
        Intent m9062b = m9062b(context, 5);
        if (m9062b == null) {
            m9058a(context, 5, str, (String) null);
            return;
        }
        String mo8967c = this.f9503d.mo8967c();
        if (TextUtils.isEmpty(mo8967c)) {
            return;
        }
        m9062b.putExtra("appKey", mo8967c);
        m9062b.putExtra(Constants.KEY_SERVICE_ID, str);
        if (UtilityImpl.isMainProcess(context)) {
            Message buildBindService = Message.buildBindService(this.f9503d.mo8964b((String) null), this.f9502b, m9062b);
            if (buildBindService != null && buildBindService.getNetPermanceMonitor() != null) {
                buildBindService.getNetPermanceMonitor().setDataId(buildBindService.dataId);
                buildBindService.getNetPermanceMonitor().setMsgType(3);
                buildBindService.getNetPermanceMonitor().setHost(buildBindService.host.toString());
            }
            m9059a(context, buildBindService, 5, false);
        }
        this.f9503d.mo8965b();
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: d */
    public void mo8946d(Context context) {
        UtilityImpl.focusEnableService(context);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: e */
    public void mo8949e(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0080 A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:19:0x005e, B:21:0x006e, B:23:0x0074, B:28:0x0080, B:29:0x0090, B:31:0x00a5, B:32:0x00ab, B:34:0x00b4, B:36:0x00c3, B:38:0x00c9, B:39:0x00e6, B:40:0x00f3, B:43:0x00ea), top: B:18:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:19:0x005e, B:21:0x006e, B:23:0x0074, B:28:0x0080, B:29:0x0090, B:31:0x00a5, B:32:0x00ab, B:34:0x00b4, B:36:0x00c3, B:38:0x00c9, B:39:0x00e6, B:40:0x00f3, B:43:0x00ea), top: B:18:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4 A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:19:0x005e, B:21:0x006e, B:23:0x0074, B:28:0x0080, B:29:0x0090, B:31:0x00a5, B:32:0x00ab, B:34:0x00b4, B:36:0x00c3, B:38:0x00c9, B:39:0x00e6, B:40:0x00f3, B:43:0x00ea), top: B:18:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:19:0x005e, B:21:0x006e, B:23:0x0074, B:28:0x0080, B:29:0x0090, B:31:0x00a5, B:32:0x00ab, B:34:0x00b4, B:36:0x00c3, B:38:0x00c9, B:39:0x00e6, B:40:0x00f3, B:43:0x00ea), top: B:18:0x005e }] */
    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo8928a(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, com.taobao.accs.IAppReceiver r14) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.mo8928a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.taobao.accs.IAppReceiver):void");
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: d */
    public void mo8947d(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: c */
    public void mo8944c(Context context) {
        UtilityImpl.focusDisableService(context);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: c */
    public Map<String, Boolean> mo8943c() throws Exception {
        SessionCenter.getInstance(this.f9503d.mo8967c()).forceRecreateAccsSession();
        return mo8939b();
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: b */
    public String mo8937b(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return mo8938b(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: b */
    public String mo8938b(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return mo8936b(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: b */
    public String mo8936b(Context context, ACCSManager.AccsRequest accsRequest) {
        return mo8916a(context, accsRequest, (String) null, true);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: b */
    public boolean mo8942b(Context context) {
        return UtilityImpl.m9227i(context);
    }

    /* renamed from: b */
    private Intent m9062b(Context context, int i2) {
        if (i2 != 1 && UtilityImpl.m9217d(context)) {
            ALog.m9182e(f9500c, "getIntent null command:" + i2 + " accs enabled:" + UtilityImpl.m9217d(context), new Object[0]);
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_COMMAND);
        intent.setClassName(context.getPackageName(), C3042j.channelService);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
        intent.putExtra("command", i2);
        intent.putExtra("appKey", this.f9503d.mo8967c());
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f9502b);
        return intent;
    }

    /* renamed from: a */
    private void m9059a(Context context, Message message, int i2, boolean z) {
        boolean z2;
        this.f9503d.mo8956a();
        if (message == null) {
            ALog.m9182e(f9500c, "message is null", new Object[0]);
            this.f9503d.mo8959a(Message.buildParameterError(context.getPackageName(), i2), -2);
            return;
        }
        if (i2 == 1) {
            String packageName = message.getPackageName();
            if (this.f9503d.mo8972e(packageName) && !z) {
                ALog.m9183i(f9500c, "isAppBinded", "package", packageName);
                this.f9503d.mo8959a(message, 200);
                z2 = false;
            }
            z2 = true;
        } else if (i2 != 2) {
            if (i2 == 3 && this.f9503d.mo8963a(message.getPackageName(), message.userinfo) && !z) {
                ALog.m9183i(f9500c, message.getPackageName() + "/" + message.userinfo + " isUserBinded", "isForceBind", Boolean.valueOf(z));
                this.f9503d.mo8959a(message, 200);
                z2 = false;
            }
            z2 = true;
        } else {
            if (this.f9503d.mo8974f(message.getPackageName())) {
                ALog.m9183i(f9500c, message.getPackageName() + " isAppUnbinded", new Object[0]);
                this.f9503d.mo8959a(message, 200);
                z2 = false;
            }
            z2 = true;
        }
        if (z2) {
            ALog.m9183i(f9500c, "sendControlMessage", "command", Integer.valueOf(i2));
            this.f9503d.mo8960a(message, true);
        }
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: b */
    public Map<String, Boolean> mo8939b() throws Exception {
        String mo8964b = this.f9503d.mo8964b((String) null);
        HashMap hashMap = new HashMap();
        hashMap.put(mo8964b, false);
        if (SessionCenter.getInstance(this.f9503d.mo8967c()).getThrowsException(mo8964b, C2084a.f6122d) != null) {
            hashMap.put(mo8964b, true);
        }
        ALog.m9180d(f9500c, "getChannelState " + hashMap.toString(), new Object[0]);
        return hashMap;
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: b */
    public void mo8941b(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            this.f9503d.mo8966b(accsConnectStateListener);
        }
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8923a(Context context, String str) {
        mo8929a(context, str, false);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8929a(Context context, String str, boolean z) {
        try {
            ALog.m9183i(f9500c, "bindUser", "userId", str);
            if (UtilityImpl.m9217d(context)) {
                ALog.m9182e(f9500c, "accs disabled", new Object[0]);
                return;
            }
            Intent m9062b = m9062b(context, 3);
            if (m9062b == null) {
                ALog.m9182e(f9500c, "intent null", new Object[0]);
                m9058a(context, 3, (String) null, (String) null);
                return;
            }
            String mo8967c = this.f9503d.mo8967c();
            if (TextUtils.isEmpty(mo8967c)) {
                ALog.m9182e(f9500c, "appKey null", new Object[0]);
                return;
            }
            if (UtilityImpl.m9213c(context) || z) {
                ALog.m9183i(f9500c, "force bind User", new Object[0]);
                m9062b.putExtra(Constants.KEY_FOUCE_BIND, true);
                z = true;
            }
            m9062b.putExtra("appKey", mo8967c);
            m9062b.putExtra("userInfo", str);
            if (UtilityImpl.isMainProcess(context)) {
                Message buildBindUser = Message.buildBindUser(this.f9503d.mo8964b((String) null), this.f9502b, m9062b);
                if (buildBindUser != null && buildBindUser.getNetPermanceMonitor() != null) {
                    buildBindUser.getNetPermanceMonitor().setDataId(buildBindUser.dataId);
                    buildBindUser.getNetPermanceMonitor().setMsgType(2);
                    buildBindUser.getNetPermanceMonitor().setHost(buildBindUser.host.toString());
                }
                m9059a(context, buildBindUser, 3, z);
            }
            this.f9503d.mo8965b();
        } catch (Throwable th) {
            ALog.m9181e(f9500c, "bindUser", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8920a(Context context) {
        if (UtilityImpl.m9217d(context) || UtilityImpl.m9217d(context)) {
            return;
        }
        Intent m9062b = m9062b(context, 4);
        if (m9062b == null) {
            m9058a(context, 4, (String) null, (String) null);
            return;
        }
        String mo8967c = this.f9503d.mo8967c();
        if (TextUtils.isEmpty(mo8967c)) {
            return;
        }
        m9062b.putExtra("appKey", mo8967c);
        if (UtilityImpl.isMainProcess(context)) {
            m9059a(context, Message.buildUnbindUser(this.f9503d.mo8964b((String) null), this.f9502b, m9062b), 4, false);
        }
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public String mo8917a(Context context, String str, String str2, byte[] bArr, String str3) {
        return mo8918a(context, str, str2, bArr, str3, (String) null);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public String mo8918a(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return mo8919a(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public String mo8919a(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return mo8914a(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
    
        com.taobao.accs.utl.C3043k.m9251a("accs", com.taobao.accs.utl.BaseMonitor.ALARM_POINT_REQ_ERROR, r17.serviceId, "1", "accs disable");
     */
    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo8914a(android.content.Context r16, com.taobao.accs.ACCSManager.AccsRequest r17) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.mo8914a(android.content.Context, com.taobao.accs.ACCSManager$AccsRequest):java.lang.String");
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public String mo8916a(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z) {
        try {
        } catch (Throwable th) {
            if (accsRequest != null) {
                C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request " + th.toString());
                ALog.m9181e(f9500c, "sendRequest", th, Constants.KEY_DATA_ID, accsRequest.dataId);
            }
        }
        if (accsRequest == null) {
            ALog.m9182e(f9500c, "sendRequest request null", new Object[0]);
            C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, null, "1", "request null");
            return null;
        }
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.m9182e(f9500c, "sendRequest not in mainprocess", new Object[0]);
            return null;
        }
        if (UtilityImpl.m9217d(context)) {
            ALog.m9182e(f9500c, "sendRequest disable", new Object[0]);
            C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
            return null;
        }
        if (TextUtils.isEmpty(this.f9503d.mo8967c())) {
            C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request appkey null");
            ALog.m9182e(f9500c, "sendRequest appkey null", new Object[0]);
            return null;
        }
        this.f9503d.mo8956a();
        Message buildRequest = Message.buildRequest(context, this.f9503d.mo8964b((String) null), this.f9502b, "", str == null ? context.getPackageName() : str, Constants.TARGET_SERVICE_PRE, accsRequest, z);
        if (buildRequest != null && buildRequest.getNetPermanceMonitor() != null) {
            buildRequest.getNetPermanceMonitor().onSend();
        }
        this.f9503d.mo8960a(buildRequest, true);
        return accsRequest.dataId;
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public String mo8915a(Context context, ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        try {
        } catch (Throwable th) {
            C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "push response " + th.toString());
            ALog.m9181e(f9500c, "sendPushResponse dataid:" + accsRequest.dataId, th, new Object[0]);
        }
        if (context != null && accsRequest != null) {
            C3043k.m9249a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "push response total");
            if (UtilityImpl.m9217d(context)) {
                C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse accs disable");
                return null;
            }
            String mo8967c = this.f9503d.mo8967c();
            if (TextUtils.isEmpty(mo8967c)) {
                C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse appkey null");
                ALog.m9182e(f9500c, "sendPushResponse appkey null", new Object[0]);
                return null;
            }
            if (extraInfo == null) {
                extraInfo = new TaoBaseService.ExtraInfo();
            }
            extraInfo.connType = 1;
            extraInfo.fromHost = DefaultWebClient.HTTPS_SCHEME + AccsClientConfig.getConfigByTag(Config.m24941c(context)).getInappHost();
            extraInfo.fromPackage = context.getPackageName();
            ALog.m9183i(f9500c, "sendPushResponse", "isMainProcess", Boolean.valueOf(UtilityImpl.isMainProcess(context)));
            accsRequest.host = new URL(extraInfo.fromHost);
            if (UtilityImpl.isMainProcess(context)) {
                mo8916a(context, accsRequest, context.getPackageName(), false);
            } else {
                Intent intent = new Intent(Constants.ACTION_SEND);
                intent.setClassName(extraInfo.fromPackage, C3042j.msgService);
                intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
                intent.putExtra(Constants.KEY_SEND_REQDATA, accsRequest);
                intent.putExtra("appKey", mo8967c);
                intent.putExtra(Constants.KEY_CONFIG_TAG, this.f9502b);
                C2961a.m8908a(context, intent);
            }
            return null;
        }
        ALog.m9182e(f9500c, "sendPushResponse input null", C3397d.f11892R, context, "response", accsRequest, "extraInfo", extraInfo);
        C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "sendPushResponse null");
        return null;
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public boolean mo8933a() {
        try {
            if (this.f9503d != null) {
                if (this.f9503d.mo8973f()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.taobao.accs.InterfaceC2965b
    @Deprecated
    /* renamed from: a */
    public void mo8921a(Context context, int i2) {
        ACCSClient.setEnvironment(context, i2);
    }

    /* renamed from: a */
    private void m9058a(Context context, int i2, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i2);
        intent.putExtra(Constants.KEY_SERVICE_ID, str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        intent.putExtra("appKey", this.f9503d.mo8967c());
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f9502b);
        intent.putExtra(Constants.KEY_ERROR_CODE, i2 == 2 ? 200 : 300);
        C2989g.m9042a(context, intent);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8924a(Context context, String str, int i2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(Constants.KEY_PROXY_HOST, str);
        }
        edit.putInt(Constants.KEY_PROXY_PORT, i2);
        edit.apply();
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8927a(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        GlobalClientInfo.getInstance(context).setAppReceiver(this.f9502b, iAppReceiver);
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.m9180d(f9500c, "inapp only init in main process!", new Object[0]);
            return;
        }
        ALog.m9180d(f9500c, "startInAppConnection APPKEY:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.equals(this.f9503d.mo8967c(), str)) {
            this.f9503d.mo8968c(str2);
            this.f9503d.mo8970d(str);
        }
        this.f9503d.mo8956a();
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8922a(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.f9502b, iLoginInfo);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public boolean mo8935a(String str) {
        return this.f9503d.mo8962a(str);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public boolean mo8934a(int i2) {
        return ErrorCode.isChannelError(i2);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8926a(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8925a(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8931a(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            this.f9503d.mo8958a(accsConnectStateListener);
        }
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8932a(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        this.f9503d.mo8960a(Message.buildPushAck(this.f9503d.mo8964b((String) null), this.f9502b, str, str2, str3, true, s, str4, map), true);
    }

    @Override // com.taobao.accs.InterfaceC2965b
    /* renamed from: a */
    public void mo8930a(AccsClientConfig accsClientConfig) {
        this.f9503d.mo8957a(accsClientConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9060a(InterfaceC2977c interfaceC2977c) {
        ThreadPoolExecutorFactory.schedule(new RunnableC2997b(this, interfaceC2977c), this.f9504e.nextInt(6), TimeUnit.SECONDS);
    }
}
