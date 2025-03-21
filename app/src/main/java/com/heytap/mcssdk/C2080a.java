package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.heytap.mcssdk.C2090f;
import com.heytap.mcssdk.constant.C2085b;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.p154b.C2081a;
import com.heytap.mcssdk.p155d.C2088a;
import com.heytap.mcssdk.p157h.C2093a;
import com.heytap.mcssdk.p157h.C2094b;
import com.heytap.mcssdk.p157h.InterfaceC2096d;
import com.heytap.mcssdk.p158i.C2097a;
import com.heytap.mcssdk.p158i.C2098b;
import com.heytap.mcssdk.p158i.InterfaceC2099c;
import com.heytap.mcssdk.p160k.C2102b;
import com.heytap.mcssdk.p160k.C2103c;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.statis.StatisticUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p031c.p096e.p097a.InterfaceC1226a;

/* renamed from: com.heytap.mcssdk.a */
/* loaded from: classes.dex */
public class C2080a implements InterfaceC2089e {

    /* renamed from: A */
    private static final String f6038A = "globalID";

    /* renamed from: B */
    private static final String f6039B = "supportOpenPush";

    /* renamed from: C */
    private static final String f6040C = "versionName";

    /* renamed from: D */
    private static final String f6041D = "versionCode";

    /* renamed from: E */
    private static final String f6042E = "pushSdkVersion";

    /* renamed from: F */
    public static final String f6043F = "miniProgramPkg";

    /* renamed from: G */
    private static final int f6044G = 23;

    /* renamed from: H */
    private static final int f6045H = 59;

    /* renamed from: I */
    private static final int f6046I = 24;

    /* renamed from: J */
    private static final int f6047J = 1000;

    /* renamed from: K */
    private static final int f6048K = 2;

    /* renamed from: M */
    private static String f6050M = null;

    /* renamed from: N */
    private static boolean f6051N = false;

    /* renamed from: l */
    private static final String f6052l = "a";

    /* renamed from: m */
    private static final int f6053m = 32;

    /* renamed from: r */
    private static final String f6058r = "Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ==";

    /* renamed from: s */
    private static final String f6059s = "type";

    /* renamed from: t */
    private static final int f6060t = 1019;

    /* renamed from: u */
    private static final String f6061u = "eventID";

    /* renamed from: v */
    private static final String f6062v = "taskID";

    /* renamed from: w */
    private static final String f6063w = "appPackage";

    /* renamed from: x */
    private static final String f6064x = "extra";

    /* renamed from: y */
    private static final String f6065y = "messageType";

    /* renamed from: z */
    private static final String f6066z = "messageID";

    /* renamed from: a */
    private Context f6067a;

    /* renamed from: b */
    private List<InterfaceC2099c> f6068b;

    /* renamed from: c */
    private List<InterfaceC2096d> f6069c;

    /* renamed from: d */
    private String f6070d;

    /* renamed from: e */
    private String f6071e;

    /* renamed from: f */
    private String f6072f;

    /* renamed from: g */
    private ICallBackResultService f6073g;

    /* renamed from: h */
    private ISetAppNotificationCallBackService f6074h;

    /* renamed from: i */
    private IGetAppNotificationCallBackService f6075i;

    /* renamed from: j */
    private ConcurrentHashMap<Integer, C2090f.b> f6076j;

    /* renamed from: k */
    private boolean f6077k;

    /* renamed from: n */
    private static final int[] f6054n = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};

    /* renamed from: o */
    private static final int[] f6055o = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};

    /* renamed from: p */
    private static final int[] f6056p = {99, 111, 109, 46, 104, 101, 121, 116, 97, 112, 46, 109, 99, 115};

    /* renamed from: q */
    private static String f6057q = "";

    /* renamed from: L */
    private static int f6049L = 0;

    /* renamed from: com.heytap.mcssdk.a$a */
    class a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Intent f6078a;

        a(Intent intent) {
            this.f6078a = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Bundle bundle = new Bundle();
            bundle.putAll(this.f6078a.getExtras());
            try {
                InterfaceC1226a.b.m2433a(iBinder).mo2431a(bundle);
            } catch (Exception e2) {
                C2107g.m5884b("bindMcsService exception:" + e2);
            }
            C2080a.this.f6067a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.heytap.mcssdk.a$b */
    private static class b {

        /* renamed from: a */
        private static final C2080a f6080a = new C2080a(null);

        private b() {
        }
    }

    private C2080a() {
        this.f6068b = new ArrayList();
        this.f6069c = new ArrayList();
        this.f6072f = null;
        this.f6077k = true;
        synchronized (C2080a.class) {
            if (f6049L > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            f6049L++;
        }
        m5686a(new C2094b());
        m5686a(new C2093a());
        m5687a(new C2098b());
        m5687a(new C2097a());
        this.f6076j = new ConcurrentHashMap<>();
    }

    /* synthetic */ C2080a(a aVar) {
        this();
    }

    /* renamed from: a */
    private Intent m5685a(int i2, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(m5716b(this.f6067a));
        intent.setPackage(m5702a(this.f6067a));
        intent.putExtra("type", i2);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(f6040C, C2103c.m5865b(this.f6067a, this.f6067a.getPackageName()));
            jSONObject2.putOpt(f6041D, Integer.valueOf(C2103c.m5860a(this.f6067a, this.f6067a.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra(f6064x, jSONObject2.toString());
            throw th;
        }
        intent.putExtra(f6064x, jSONObject2.toString());
        intent.putExtra(C2085b.f6159D, str);
        intent.putExtra("appPackage", this.f6067a.getPackageName());
        intent.putExtra("appKey", this.f6070d);
        intent.putExtra(C2085b.f6156A, this.f6071e);
        intent.putExtra(C2085b.f6157B, this.f6072f);
        intent.putExtra("sdkVersion", m5700y());
        return intent;
    }

    /* renamed from: a */
    private synchronized void m5686a(InterfaceC2096d interfaceC2096d) {
        if (interfaceC2096d != null) {
            this.f6069c.add(interfaceC2096d);
        }
    }

    /* renamed from: a */
    private synchronized void m5687a(InterfaceC2099c interfaceC2099c) {
        if (interfaceC2099c != null) {
            this.f6068b.add(interfaceC2099c);
        }
    }

    /* renamed from: a */
    private boolean m5688a(C2090f.b bVar) {
        long m5792a = bVar.m5792a();
        long currentTimeMillis = System.currentTimeMillis();
        C2107g.m5884b("checkTimeNeedUpdate : lastedTime " + m5792a + " currentTime:" + currentTimeMillis);
        return currentTimeMillis - m5792a > 1000;
    }

    /* renamed from: b */
    private void m5689b(int i2, String str, JSONObject jSONObject) {
        if (m5725c(i2)) {
            if (this.f6073g != null) {
                this.f6073g.onError(m5726d(i2), "api_call_too_frequently", this.f6067a.getPackageName(), m5740j(jSONObject));
                return;
            }
            return;
        }
        try {
            this.f6067a.startService(m5685a(i2, str, jSONObject));
        } catch (Exception e2) {
            C2107g.m5896e("startMcsService--Exception" + e2.getMessage());
        }
    }

    /* renamed from: b */
    private void m5690b(int i2, JSONObject jSONObject) {
        m5689b(i2, "", jSONObject);
    }

    /* renamed from: e */
    private C2090f.b m5691e(int i2) {
        String str;
        if (!this.f6076j.containsKey(Integer.valueOf(i2))) {
            C2090f.b bVar = new C2090f.b(System.currentTimeMillis(), 1);
            this.f6076j.put(Integer.valueOf(i2), bVar);
            C2107g.m5884b("addCommandToMap :appBean is null");
            return bVar;
        }
        C2090f.b bVar2 = this.f6076j.get(Integer.valueOf(i2));
        if (m5688a(bVar2)) {
            bVar2.m5793a(1);
            bVar2.m5794a(System.currentTimeMillis());
            str = "addCommandToMap : appLimitBean.setCount(1)";
        } else {
            bVar2.m5793a(bVar2.m5795b() + 1);
            str = "addCommandToMap :appLimitBean.getCount() + 1";
        }
        C2107g.m5884b(str);
        return bVar2;
    }

    /* renamed from: e */
    private String m5692e(Context context) {
        C2107g.m5885b(f6052l, "getMcsPackageNameInner -- ");
        if (Build.VERSION.SDK_INT >= 24) {
            PackageManager packageManager = context.getPackageManager();
            try {
                try {
                    String m5862a = C2103c.m5862a(f6056p);
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(m5862a, 0);
                    if (applicationInfo != null) {
                        boolean z = (applicationInfo.flags & 1) == 1;
                        boolean z2 = packageManager.getPackageUid(m5862a, 0) == packageManager.getPackageUid(DispatchConstants.ANDROID, 0);
                        if (z || z2) {
                            return m5862a;
                        }
                    }
                    return null;
                } catch (PackageManager.NameNotFoundException e2) {
                    C2107g.m5897e(f6052l, "NameNotFoundException in get mcs package name:" + e2.getMessage());
                } catch (Exception e3) {
                    C2107g.m5897e(f6052l, "Error in get mcs package name:" + e3.getMessage());
                    return null;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: f */
    private boolean m5693f(Context context) {
        if (this.f6067a == null) {
            this.f6067a = context.getApplicationContext();
        }
        String m5702a = m5702a(this.f6067a);
        boolean z = C2103c.m5867c(this.f6067a, m5702a) && C2103c.m5860a(this.f6067a, m5702a) >= 1019 && C2103c.m5863a(this.f6067a, m5702a, f6039B);
        C2107g.m5885b(f6052l, "isSupportPushInner -- " + z);
        return z;
    }

    @Deprecated
    /* renamed from: g */
    private static void m5694g(Context context) {
        C2102b.m5855a(context, new MessageStat(context.getPackageName(), "app_start", null));
    }

    /* renamed from: t */
    private boolean m5695t() {
        return m5696u() && m5697v();
    }

    /* renamed from: u */
    private boolean m5696u() {
        return this.f6067a != null;
    }

    /* renamed from: v */
    private boolean m5697v() {
        return this.f6072f != null;
    }

    /* renamed from: w */
    public static C2080a m5698w() {
        return b.f6080a;
    }

    /* renamed from: x */
    public static int m5699x() {
        return C2083c.f6116e;
    }

    /* renamed from: y */
    public static String m5700y() {
        return C2083c.f6117f;
    }

    /* renamed from: a */
    public C2080a m5701a(Context context, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        m5723c(context);
        new C2088a().m5790a(this.f6067a);
        C2107g.m5901f(z);
        return this;
    }

    /* renamed from: a */
    public String m5702a(Context context) {
        boolean z;
        if (f6050M == null) {
            String m5692e = m5692e(context);
            if (m5692e == null) {
                f6050M = C2103c.m5862a(f6054n);
                z = false;
            } else {
                f6050M = m5692e;
                z = true;
            }
            f6051N = z;
        }
        return f6050M;
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5703a() {
        mo5735g((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5704a(int i2) {
        mo5705a(i2, (JSONObject) null);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5705a(int i2, JSONObject jSONObject) {
        if (!m5695t()) {
            C2107g.m5897e(C2107g.f6249a, "please call the register first!");
            return;
        }
        m5689b(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE, i2 + "", jSONObject);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5706a(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        mo5707a(context, str, str2, (JSONObject) null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5707a(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null, null, null);
                return;
            }
            return;
        }
        if (this.f6067a == null) {
            this.f6067a = context.getApplicationContext();
        }
        if (!C2103c.m5866c(this.f6067a)) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null, null, null);
                return;
            }
            return;
        }
        if (this.f6077k) {
            C2107g.m5885b("registerAction:", "Will static push_register event :");
            StatisticUtils.statisticEvent(this.f6067a, "push_register");
            this.f6077k = false;
        }
        this.f6070d = str;
        this.f6071e = str2;
        this.f6073g = iCallBackResultService;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.putOpt(Constants.KEY_APP_VERSION_CODE, Integer.valueOf(C2103c.m5859a(context)));
            jSONObject.putOpt(Constants.KEY_APP_VERSION_NAME, C2103c.m5864b(context));
        } catch (JSONException e2) {
            C2107g.m5896e("register-Exception:" + e2.getMessage());
        }
        m5690b(MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
    }

    /* renamed from: a */
    public void m5708a(ICallBackResultService iCallBackResultService) {
        this.f6073g = iCallBackResultService;
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5709a(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        if (m5696u()) {
            this.f6075i = iGetAppNotificationCallBackService;
            m5690b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET, null);
        } else {
            IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.f6075i;
            if (iGetAppNotificationCallBackService2 != null) {
                iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
            }
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5710a(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (m5696u()) {
            this.f6074h = iSetAppNotificationCallBackService;
            m5690b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        } else if (m5745n() != null) {
            this.f6074h.onSetAppNotificationSwitch(-2);
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5711a(String str) {
        this.f6072f = str;
    }

    /* renamed from: a */
    public void m5712a(String str, String str2) {
        this.f6070d = str;
        this.f6071e = str2;
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5713a(List<Integer> list, int i2, int i3, int i4, int i5) {
        mo5714a(list, i2, i3, i4, i5, null);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5714a(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject) {
        if (!m5695t()) {
            if (m5745n() != null) {
                m5745n().onSetPushTime(-2, "please call the register first!");
                return;
            }
            return;
        }
        if (list == null || list.size() <= 0 || i2 < 0 || i3 < 0 || i4 < i2 || i4 > 23 || i5 < i3 || i5 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("weekDays", C2090f.c.m5796a(list));
            jSONObject2.put("startHour", i2);
            jSONObject2.put("startMin", i3);
            jSONObject2.put("endHour", i4);
            jSONObject2.put("endMin", i5);
            m5689b(MessageConstant.CommandId.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
        } catch (JSONException e2) {
            C2107g.m5897e(C2107g.f6249a, e2.getLocalizedMessage());
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: a */
    public void mo5715a(JSONObject jSONObject) {
        if (m5696u()) {
            m5690b(MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } else {
            C2107g.m5897e(C2107g.f6249a, "please call the register first!");
        }
    }

    /* renamed from: b */
    public String m5716b(Context context) {
        if (f6050M == null) {
            m5692e(context);
        }
        if (!f6051N) {
            return C2103c.m5862a(f6055o);
        }
        if (TextUtils.isEmpty(f6057q)) {
            f6057q = new String(C2081a.m5759d(f6058r));
        }
        return f6057q;
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: b */
    public void mo5717b() {
        mo5731e((JSONObject) null);
    }

    /* renamed from: b */
    public void m5718b(int i2) {
        if (!m5725c(i2)) {
            Intent m5685a = m5685a(i2, "", null);
            this.f6067a.bindService(m5685a, new a(m5685a), 1);
        } else {
            ICallBackResultService iCallBackResultService = this.f6073g;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(m5726d(i2), "api_call_too_frequently", this.f6067a.getPackageName(), "");
            }
        }
    }

    /* renamed from: b */
    public void m5719b(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.f6070d = str;
        this.f6071e = str2;
        this.f6067a = context.getApplicationContext();
        this.f6073g = iCallBackResultService;
        mo5737h(jSONObject);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: b */
    public void mo5720b(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (m5696u()) {
            this.f6074h = iSetAppNotificationCallBackService;
            m5690b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
        } else {
            ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.f6074h;
            if (iSetAppNotificationCallBackService2 != null) {
                iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
            }
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: b */
    public void mo5721b(JSONObject jSONObject) {
        if (m5695t()) {
            m5690b(MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } else {
            C2107g.m5897e(C2107g.f6249a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: c */
    public void mo5722c() {
        mo5733f((JSONObject) null);
    }

    /* renamed from: c */
    public void m5723c(Context context) {
        boolean z;
        this.f6067a = context.getApplicationContext();
        if (f6050M == null) {
            String m5692e = m5692e(context);
            if (m5692e == null) {
                f6050M = C2103c.m5862a(f6054n);
                z = false;
            } else {
                f6050M = m5692e;
                z = true;
            }
            f6051N = z;
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: c */
    public void mo5724c(JSONObject jSONObject) {
        if (m5695t()) {
            m5690b(MessageConstant.CommandId.COMMAND_RESUME_PUSH, jSONObject);
        } else {
            C2107g.m5897e(C2107g.f6249a, "please call the register first!");
        }
    }

    /* renamed from: c */
    public boolean m5725c(int i2) {
        return (i2 == 12291 || i2 == 12312 || m5691e(i2).m5795b() <= 2) ? false : true;
    }

    /* renamed from: d */
    public int m5726d(int i2) {
        switch (i2) {
            case MessageConstant.CommandId.COMMAND_REGISTER /* 12289 */:
                return -1;
            case MessageConstant.CommandId.COMMAND_UNREGISTER /* 12290 */:
                return -2;
            case MessageConstant.CommandId.COMMAND_STATISTIC /* 12291 */:
                return -14;
            default:
                switch (i2) {
                    case MessageConstant.CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                        return -11;
                    case MessageConstant.CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                        return -3;
                    case MessageConstant.CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                        return -4;
                    default:
                        switch (i2) {
                            case MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS /* 12306 */:
                                return -10;
                            case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                                return -6;
                            case MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                                return -7;
                            case MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                                return -5;
                            case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS /* 12310 */:
                                return -8;
                            case MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION /* 12311 */:
                                return -9;
                            case MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK /* 12312 */:
                                return -13;
                            case MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE /* 12313 */:
                                return -12;
                            default:
                                switch (i2) {
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                        return -15;
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                        return -16;
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                        return -17;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: d */
    public String mo5727d() {
        return this.f6072f;
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: d */
    public void mo5728d(JSONObject jSONObject) {
        if (m5695t()) {
            m5690b(MessageConstant.CommandId.COMMAND_CANCEL_NOTIFICATION, jSONObject);
        } else {
            C2107g.m5897e(C2107g.f6249a, "please call the register first!");
        }
    }

    /* renamed from: d */
    public boolean m5729d(Context context) {
        return m5693f(context);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: e */
    public void mo5730e() {
        if (Build.VERSION.SDK_INT < 32) {
            if (m5696u()) {
                m5718b(MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
                return;
            } else {
                C2107g.m5897e(C2107g.f6249a, "please call the register first!");
                return;
            }
        }
        C2107g.m5885b(f6052l, "requestNotificationPermission() will return due to Android T device , current device Android SDK version code is :" + Build.VERSION.SDK_INT);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: e */
    public void mo5731e(JSONObject jSONObject) {
        if (m5695t()) {
            m5690b(MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } else if (m5745n() != null) {
            m5745n().onGetNotificationStatus(-2, 0);
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: f */
    public void mo5732f() {
        mo5715a((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: f */
    public void mo5733f(JSONObject jSONObject) {
        if (m5695t()) {
            m5690b(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } else {
            C2107g.m5897e(C2107g.f6249a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: g */
    public void mo5734g() {
        mo5721b((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: g */
    public void mo5735g(JSONObject jSONObject) {
        if (m5695t()) {
            m5690b(MessageConstant.CommandId.COMMAND_PAUSE_PUSH, jSONObject);
        } else {
            C2107g.m5897e(C2107g.f6249a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: h */
    public void mo5736h() {
        mo5739i(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: h */
    public void mo5737h(JSONObject jSONObject) {
        if (m5696u()) {
            m5690b(MessageConstant.CommandId.COMMAND_UNREGISTER, jSONObject);
        } else if (m5745n() != null) {
            m5745n().onUnRegister(-2, this.f6067a.getPackageName(), m5740j(jSONObject));
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: i */
    public void mo5738i() {
        mo5724c((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    /* renamed from: i */
    public void mo5739i(JSONObject jSONObject) {
        if (m5696u()) {
            m5690b(MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
        } else if (m5745n() != null) {
            m5745n().onRegister(-2, null, null, null);
        }
    }

    /* renamed from: j */
    public String m5740j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            try {
                return jSONObject.optString("miniProgramPkg");
            } catch (Exception e2) {
                C2107g.m5884b("Error happened in getMiniProgramPkgFromJSON() :" + e2.getMessage());
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: j */
    public Map<Integer, C2090f.b> m5741j() {
        return this.f6076j;
    }

    /* renamed from: k */
    public Context m5742k() {
        return this.f6067a;
    }

    /* renamed from: l */
    public List<InterfaceC2096d> m5743l() {
        return this.f6069c;
    }

    /* renamed from: m */
    public List<InterfaceC2099c> m5744m() {
        return this.f6068b;
    }

    /* renamed from: n */
    public ICallBackResultService m5745n() {
        return this.f6073g;
    }

    /* renamed from: o */
    public IGetAppNotificationCallBackService m5746o() {
        return this.f6075i;
    }

    /* renamed from: p */
    public ISetAppNotificationCallBackService m5747p() {
        return this.f6074h;
    }

    /* renamed from: q */
    public void m5748q() {
        if (m5695t()) {
            m5690b(MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS, null);
        } else if (m5745n() != null) {
            m5745n().onGetPushStatus(-2, 0);
        }
    }

    /* renamed from: r */
    public int m5749r() {
        if (!m5696u()) {
            return 0;
        }
        Context context = this.f6067a;
        return C2103c.m5860a(context, m5702a(context));
    }

    /* renamed from: s */
    public String m5750s() {
        if (!m5696u()) {
            return "";
        }
        Context context = this.f6067a;
        return C2103c.m5865b(context, m5702a(context));
    }

    @Override // com.heytap.mcssdk.InterfaceC2089e
    public void unRegister() {
        mo5737h(null);
    }
}
