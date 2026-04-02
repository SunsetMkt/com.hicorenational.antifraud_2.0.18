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
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.f;
import com.heytap.mcssdk.h.d;
import com.heytap.mcssdk.k.g;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.statis.StatisticUtils;
import com.taobao.accs.common.Constants;
import d.e.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements e {
    private static final String A = "globalID";
    private static final String B = "supportOpenPush";
    private static final String C = "versionName";
    private static final String D = "versionCode";
    private static final String E = "pushSdkVersion";
    public static final String F = "miniProgramPkg";
    private static final int G = 23;
    private static final int H = 59;
    private static final int I = 24;
    private static final int J = 1000;
    private static final int K = 2;
    private static String M = null;
    private static boolean N = false;

    /* JADX INFO: renamed from: l */
    private static final String f3833l = "a";

    /* JADX INFO: renamed from: m */
    private static final int f3834m = 32;
    private static final String r = "Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ==";
    private static final String s = "type";
    private static final int t = 1019;
    private static final String u = "eventID";
    private static final String v = "taskID";
    private static final String w = "appPackage";
    private static final String x = "extra";
    private static final String y = "messageType";
    private static final String z = "messageID";
    private Context a;

    /* JADX INFO: renamed from: b */
    private List<com.heytap.mcssdk.i.c> f3836b;

    /* JADX INFO: renamed from: c */
    private List<d> f3837c;

    /* JADX INFO: renamed from: d */
    private String f3838d;

    /* JADX INFO: renamed from: e */
    private String f3839e;

    /* JADX INFO: renamed from: f */
    private String f3840f;

    /* JADX INFO: renamed from: g */
    private ICallBackResultService f3841g;

    /* JADX INFO: renamed from: h */
    private ISetAppNotificationCallBackService f3842h;

    /* JADX INFO: renamed from: i */
    private IGetAppNotificationCallBackService f3843i;

    /* JADX INFO: renamed from: j */
    private ConcurrentHashMap<Integer, f.b> f3844j;

    /* JADX INFO: renamed from: k */
    private boolean f3845k;

    /* JADX INFO: renamed from: n */
    private static final int[] f3835n = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] o = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static final int[] p = {99, 111, 109, 46, 104, 101, 121, 116, 97, 112, 46, 109, 99, 115};
    private static String q = "";
    private static int L = 0;

    /* JADX INFO: renamed from: com.heytap.mcssdk.a$a */
    class ServiceConnectionC0081a implements ServiceConnection {
        final /* synthetic */ Intent a;

        ServiceConnectionC0081a(Intent intent) {
            this.a = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Bundle bundle = new Bundle();
            bundle.putAll(this.a.getExtras());
            try {
                a.b.a(iBinder).a(bundle);
            } catch (Exception e2) {
                g.b("bindMcsService exception:" + e2);
            }
            a.this.a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static class b {
        private static final a a = new a(null);

        private b() {
        }
    }

    private a() {
        this.f3836b = new ArrayList();
        this.f3837c = new ArrayList();
        this.f3840f = null;
        this.f3845k = true;
        synchronized (a.class) {
            if (L > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            L++;
        }
        a(new com.heytap.mcssdk.h.b());
        a(new com.heytap.mcssdk.h.a());
        a(new com.heytap.mcssdk.i.b());
        a(new com.heytap.mcssdk.i.a());
        this.f3844j = new ConcurrentHashMap<>();
    }

    /* synthetic */ a(ServiceConnectionC0081a serviceConnectionC0081a) {
        this();
    }

    private Intent a(int i2, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(b(this.a));
        intent.setPackage(a(this.a));
        intent.putExtra("type", i2);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(C, com.heytap.mcssdk.k.c.b(this.a, this.a.getPackageName()));
            jSONObject2.putOpt(D, Integer.valueOf(com.heytap.mcssdk.k.c.a(this.a, this.a.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra(x, jSONObject2.toString());
            throw th;
        }
        intent.putExtra(x, jSONObject2.toString());
        intent.putExtra(com.heytap.mcssdk.constant.b.D, str);
        intent.putExtra("appPackage", this.a.getPackageName());
        intent.putExtra("appKey", this.f3838d);
        intent.putExtra(com.heytap.mcssdk.constant.b.A, this.f3839e);
        intent.putExtra(com.heytap.mcssdk.constant.b.B, this.f3840f);
        intent.putExtra("sdkVersion", y());
        return intent;
    }

    private synchronized void a(d dVar) {
        if (dVar != null) {
            this.f3837c.add(dVar);
        }
    }

    private synchronized void a(com.heytap.mcssdk.i.c cVar) {
        if (cVar != null) {
            this.f3836b.add(cVar);
        }
    }

    private boolean a(f.b bVar) {
        long jA = bVar.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        g.b("checkTimeNeedUpdate : lastedTime " + jA + " currentTime:" + jCurrentTimeMillis);
        return jCurrentTimeMillis - jA > 1000;
    }

    private void b(int i2, String str, JSONObject jSONObject) {
        if (c(i2)) {
            if (this.f3841g != null) {
                this.f3841g.onError(d(i2), "api_call_too_frequently", this.a.getPackageName(), j(jSONObject));
                return;
            }
            return;
        }
        try {
            this.a.startService(a(i2, str, jSONObject));
        } catch (Exception e2) {
            g.e("startMcsService--Exception" + e2.getMessage());
        }
    }

    private void b(int i2, JSONObject jSONObject) {
        b(i2, "", jSONObject);
    }

    private f.b e(int i2) {
        String str;
        if (!this.f3844j.containsKey(Integer.valueOf(i2))) {
            f.b bVar = new f.b(System.currentTimeMillis(), 1);
            this.f3844j.put(Integer.valueOf(i2), bVar);
            g.b("addCommandToMap :appBean is null");
            return bVar;
        }
        f.b bVar2 = this.f3844j.get(Integer.valueOf(i2));
        if (a(bVar2)) {
            bVar2.a(1);
            bVar2.a(System.currentTimeMillis());
            str = "addCommandToMap : appLimitBean.setCount(1)";
        } else {
            bVar2.a(bVar2.b() + 1);
            str = "addCommandToMap :appLimitBean.getCount() + 1";
        }
        g.b(str);
        return bVar2;
    }

    private String e(Context context) {
        g.b(f3833l, "getMcsPackageNameInner -- ");
        if (Build.VERSION.SDK_INT >= 24) {
            PackageManager packageManager = context.getPackageManager();
            try {
                try {
                    String strA = com.heytap.mcssdk.k.c.a(p);
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(strA, 0);
                    if (applicationInfo != null) {
                        boolean z2 = (applicationInfo.flags & 1) == 1;
                        boolean z3 = packageManager.getPackageUid(strA, 0) == packageManager.getPackageUid(DispatchConstants.ANDROID, 0);
                        if (z2 || z3) {
                            return strA;
                        }
                    }
                    return null;
                } catch (PackageManager.NameNotFoundException e2) {
                    g.e(f3833l, "NameNotFoundException in get mcs package name:" + e2.getMessage());
                } catch (Exception e3) {
                    g.e(f3833l, "Error in get mcs package name:" + e3.getMessage());
                    return null;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private boolean f(Context context) {
        if (this.a == null) {
            this.a = context.getApplicationContext();
        }
        String strA = a(this.a);
        boolean z2 = com.heytap.mcssdk.k.c.c(this.a, strA) && com.heytap.mcssdk.k.c.a(this.a, strA) >= 1019 && com.heytap.mcssdk.k.c.a(this.a, strA, B);
        g.b(f3833l, "isSupportPushInner -- " + z2);
        return z2;
    }

    @Deprecated
    private static void g(Context context) {
        com.heytap.mcssdk.k.b.a(context, new MessageStat(context.getPackageName(), "app_start", null));
    }

    private boolean t() {
        return u() && v();
    }

    private boolean u() {
        return this.a != null;
    }

    private boolean v() {
        return this.f3840f != null;
    }

    public static a w() {
        return b.a;
    }

    public static int x() {
        return c.f3863e;
    }

    public static String y() {
        return c.f3864f;
    }

    public a a(Context context, boolean z2) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        c(context);
        new com.heytap.mcssdk.d.a().a(this.a);
        g.f(z2);
        return this;
    }

    public String a(Context context) {
        boolean z2;
        if (M == null) {
            String strE = e(context);
            if (strE == null) {
                M = com.heytap.mcssdk.k.c.a(f3835n);
                z2 = false;
            } else {
                M = strE;
                z2 = true;
            }
            N = z2;
        }
        return M;
    }

    @Override // com.heytap.mcssdk.e
    public void a() {
        g((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void a(int i2) {
        a(i2, (JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void a(int i2, JSONObject jSONObject) {
        if (!t()) {
            g.e(g.a, "please call the register first!");
            return;
        }
        b(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE, i2 + "", jSONObject);
    }

    @Override // com.heytap.mcssdk.e
    public void a(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        a(context, str, str2, (JSONObject) null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.e
    public void a(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null, null, null);
                return;
            }
            return;
        }
        if (this.a == null) {
            this.a = context.getApplicationContext();
        }
        if (!com.heytap.mcssdk.k.c.c(this.a)) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null, null, null);
                return;
            }
            return;
        }
        if (this.f3845k) {
            g.b("registerAction:", "Will static push_register event :");
            StatisticUtils.statisticEvent(this.a, "push_register");
            this.f3845k = false;
        }
        this.f3838d = str;
        this.f3839e = str2;
        this.f3841g = iCallBackResultService;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.putOpt(Constants.KEY_APP_VERSION_CODE, Integer.valueOf(com.heytap.mcssdk.k.c.a(context)));
            jSONObject.putOpt(Constants.KEY_APP_VERSION_NAME, com.heytap.mcssdk.k.c.b(context));
        } catch (JSONException e2) {
            g.e("register-Exception:" + e2.getMessage());
        }
        b(MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
    }

    public void a(ICallBackResultService iCallBackResultService) {
        this.f3841g = iCallBackResultService;
    }

    @Override // com.heytap.mcssdk.e
    public void a(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        if (u()) {
            this.f3843i = iGetAppNotificationCallBackService;
            b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET, null);
        } else {
            IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.f3843i;
            if (iGetAppNotificationCallBackService2 != null) {
                iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
            }
        }
    }

    @Override // com.heytap.mcssdk.e
    public void a(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (u()) {
            this.f3842h = iSetAppNotificationCallBackService;
            b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        } else if (n() != null) {
            this.f3842h.onSetAppNotificationSwitch(-2);
        }
    }

    @Override // com.heytap.mcssdk.e
    public void a(String str) {
        this.f3840f = str;
    }

    public void a(String str, String str2) {
        this.f3838d = str;
        this.f3839e = str2;
    }

    @Override // com.heytap.mcssdk.e
    public void a(List<Integer> list, int i2, int i3, int i4, int i5) {
        a(list, i2, i3, i4, i5, null);
    }

    @Override // com.heytap.mcssdk.e
    public void a(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject) {
        if (!t()) {
            if (n() != null) {
                n().onSetPushTime(-2, "please call the register first!");
                return;
            }
            return;
        }
        if (list == null || list.size() <= 0 || i2 < 0 || i3 < 0 || i4 < i2 || i4 > 23 || i5 < i3 || i5 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("weekDays", f.c.a(list));
            jSONObject2.put("startHour", i2);
            jSONObject2.put("startMin", i3);
            jSONObject2.put("endHour", i4);
            jSONObject2.put("endMin", i5);
            b(MessageConstant.CommandId.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
        } catch (JSONException e2) {
            g.e(g.a, e2.getLocalizedMessage());
        }
    }

    @Override // com.heytap.mcssdk.e
    public void a(JSONObject jSONObject) {
        if (u()) {
            b(MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } else {
            g.e(g.a, "please call the register first!");
        }
    }

    public String b(Context context) {
        if (M == null) {
            e(context);
        }
        if (!N) {
            return com.heytap.mcssdk.k.c.a(o);
        }
        if (TextUtils.isEmpty(q)) {
            q = new String(com.heytap.mcssdk.b.a.d(r));
        }
        return q;
    }

    @Override // com.heytap.mcssdk.e
    public void b() {
        e((JSONObject) null);
    }

    public void b(int i2) {
        if (!c(i2)) {
            Intent intentA = a(i2, "", null);
            this.a.bindService(intentA, new ServiceConnectionC0081a(intentA), 1);
        } else {
            ICallBackResultService iCallBackResultService = this.f3841g;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(d(i2), "api_call_too_frequently", this.a.getPackageName(), "");
            }
        }
    }

    public void b(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.f3838d = str;
        this.f3839e = str2;
        this.a = context.getApplicationContext();
        this.f3841g = iCallBackResultService;
        h(jSONObject);
    }

    @Override // com.heytap.mcssdk.e
    public void b(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (u()) {
            this.f3842h = iSetAppNotificationCallBackService;
            b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
        } else {
            ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.f3842h;
            if (iSetAppNotificationCallBackService2 != null) {
                iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
            }
        }
    }

    @Override // com.heytap.mcssdk.e
    public void b(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } else {
            g.e(g.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.e
    public void c() {
        f((JSONObject) null);
    }

    public void c(Context context) {
        boolean z2;
        this.a = context.getApplicationContext();
        if (M == null) {
            String strE = e(context);
            if (strE == null) {
                M = com.heytap.mcssdk.k.c.a(f3835n);
                z2 = false;
            } else {
                M = strE;
                z2 = true;
            }
            N = z2;
        }
    }

    @Override // com.heytap.mcssdk.e
    public void c(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_RESUME_PUSH, jSONObject);
        } else {
            g.e(g.a, "please call the register first!");
        }
    }

    public boolean c(int i2) {
        return (i2 == 12291 || i2 == 12312 || e(i2).b() <= 2) ? false : true;
    }

    public int d(int i2) {
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

    @Override // com.heytap.mcssdk.e
    public String d() {
        return this.f3840f;
    }

    @Override // com.heytap.mcssdk.e
    public void d(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_CANCEL_NOTIFICATION, jSONObject);
        } else {
            g.e(g.a, "please call the register first!");
        }
    }

    public boolean d(Context context) {
        return f(context);
    }

    @Override // com.heytap.mcssdk.e
    public void e() {
        if (Build.VERSION.SDK_INT < 32) {
            if (u()) {
                b(MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
                return;
            } else {
                g.e(g.a, "please call the register first!");
                return;
            }
        }
        g.b(f3833l, "requestNotificationPermission() will return due to Android T device , current device Android SDK version code is :" + Build.VERSION.SDK_INT);
    }

    @Override // com.heytap.mcssdk.e
    public void e(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } else if (n() != null) {
            n().onGetNotificationStatus(-2, 0);
        }
    }

    @Override // com.heytap.mcssdk.e
    public void f() {
        a((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void f(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } else {
            g.e(g.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.e
    public void g() {
        b((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void g(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_PAUSE_PUSH, jSONObject);
        } else {
            g.e(g.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.e
    public void h() {
        i(null);
    }

    @Override // com.heytap.mcssdk.e
    public void h(JSONObject jSONObject) {
        if (u()) {
            b(MessageConstant.CommandId.COMMAND_UNREGISTER, jSONObject);
        } else if (n() != null) {
            n().onUnRegister(-2, this.a.getPackageName(), j(jSONObject));
        }
    }

    @Override // com.heytap.mcssdk.e
    public void i() {
        c((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void i(JSONObject jSONObject) {
        if (u()) {
            b(MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
        } else if (n() != null) {
            n().onRegister(-2, null, null, null);
        }
    }

    public String j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            try {
                return jSONObject.optString("miniProgramPkg");
            } catch (Exception e2) {
                g.b("Error happened in getMiniProgramPkgFromJSON() :" + e2.getMessage());
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public Map<Integer, f.b> j() {
        return this.f3844j;
    }

    public Context k() {
        return this.a;
    }

    public List<d> l() {
        return this.f3837c;
    }

    public List<com.heytap.mcssdk.i.c> m() {
        return this.f3836b;
    }

    public ICallBackResultService n() {
        return this.f3841g;
    }

    public IGetAppNotificationCallBackService o() {
        return this.f3843i;
    }

    public ISetAppNotificationCallBackService p() {
        return this.f3842h;
    }

    public void q() {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS, null);
        } else if (n() != null) {
            n().onGetPushStatus(-2, 0);
        }
    }

    public int r() {
        if (!u()) {
            return 0;
        }
        Context context = this.a;
        return com.heytap.mcssdk.k.c.a(context, a(context));
    }

    public String s() {
        if (!u()) {
            return "";
        }
        Context context = this.a;
        return com.heytap.mcssdk.k.c.b(context, a(context));
    }

    @Override // com.heytap.mcssdk.e
    public void unRegister() {
        h(null);
    }
}
