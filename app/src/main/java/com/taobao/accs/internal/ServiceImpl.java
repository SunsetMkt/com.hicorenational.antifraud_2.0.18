package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.client.C2978a;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.C2989g;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.AbstractC3001a;
import com.taobao.accs.net.C3011k;
import com.taobao.accs.net.C3022v;
import com.taobao.accs.p199ut.p200a.C3028c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.C3049q;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.service.IMessageService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ServiceImpl extends AbstractC2999d {

    /* renamed from: b */
    private Service f9506b;

    /* renamed from: c */
    private Context f9507c;

    /* renamed from: d */
    private long f9508d;

    /* renamed from: e */
    private String f9509e;

    /* renamed from: f */
    private final IMessageService.Stub f9510f;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.internal.ServiceImpl$1 */
    class BinderC29951 extends IMessageService.Stub {
        BinderC29951() {
        }

        @Override // org.android.agoo.service.IMessageService
        public boolean ping() throws RemoteException {
            return true;
        }

        @Override // org.android.agoo.service.IMessageService
        public void probe() throws RemoteException {
            ALog.m9180d("ServiceImpl", "ReceiverImpl probeTaoBao begin......messageServiceBinder [probe]", new Object[0]);
            ThreadPoolExecutorFactory.execute(new RunnableC3000e(this));
        }
    }

    public ServiceImpl(Service service2) {
        super(service2);
        this.f9506b = null;
        this.f9509e = "unknown";
        this.f9510f = new BinderC29951();
        this.f9506b = service2;
        this.f9507c = service2.getApplicationContext();
    }

    /* renamed from: b */
    private void m9071b(Intent intent) {
        Message.ReqType reqType;
        URL url;
        Message buildRequest;
        int intExtra = intent.getIntExtra("command", -1);
        ALog.m9183i("ServiceImpl", "handleCommand", "command", Integer.valueOf(intExtra));
        String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
        String stringExtra3 = intent.getStringExtra("userInfo");
        String stringExtra4 = intent.getStringExtra("appKey");
        String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
        String stringExtra6 = intent.getStringExtra(Constants.KEY_TTID);
        intent.getStringExtra("sid");
        intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
        if (intExtra == 201) {
            m9068a(Message.BuildPing(true, 0), true);
            m9073d();
        }
        if (intExtra <= 0 || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        AbstractC3001a m9079b = AbstractC2999d.m9079b(this.f9507c, stringExtra5, true);
        if (m9079b == null) {
            ALog.m9182e("ServiceImpl", "no connection", Constants.KEY_CONFIG_TAG, stringExtra5, "command", Integer.valueOf(intExtra));
            return;
        }
        m9079b.mo9082a();
        Message message = null;
        if (intExtra == 1) {
            if (!stringExtra.equals(this.f9507c.getPackageName())) {
                ALog.m9182e("ServiceImpl", "handleCommand bindapp pkg error", new Object[0]);
                return;
            }
            Message buildBindApp = Message.buildBindApp(this.f9507c, stringExtra5, stringExtra4, intent.getStringExtra("app_sercet"), stringExtra, stringExtra6, intent.getStringExtra("appVersion"));
            m9079b.f9521a = stringExtra6;
            if (m9079b.m9106j().m8986c(stringExtra) && !intent.getBooleanExtra(Constants.KEY_FOUCE_BIND, false)) {
                ALog.m9183i("ServiceImpl", stringExtra + " isAppBinded", new Object[0]);
                m9079b.m9095b(buildBindApp, 200);
                return;
            }
            message = buildBindApp;
        } else if (intExtra == 2) {
            ALog.m9182e("ServiceImpl", "onHostStartCommand COMMAND_UNBIND_APP", new Object[0]);
            if (m9079b.m9106j().m8987d(stringExtra)) {
                Message buildUnbindApp = Message.buildUnbindApp(m9079b.mo9091b((String) null), stringExtra);
                ALog.m9183i("ServiceImpl", stringExtra + " isAppUnbinded", new Object[0]);
                m9079b.m9095b(buildUnbindApp, 200);
                return;
            }
        } else if (intExtra == 5) {
            message = Message.buildBindService(m9079b.mo9091b((String) null), stringExtra2);
        } else if (intExtra == 6) {
            message = Message.buildUnbindService(stringExtra, stringExtra2);
        } else if (intExtra == 3) {
            message = Message.buildBindUser(stringExtra, stringExtra3);
            if (m9079b.m9106j().m8985b(stringExtra, stringExtra3) && !intent.getBooleanExtra(Constants.KEY_FOUCE_BIND, false)) {
                ALog.m9183i("ServiceImpl", stringExtra + "/" + stringExtra3 + " isUserBinded", new Object[0]);
                if (message != null) {
                    m9079b.m9095b(message, 200);
                    return;
                }
                return;
            }
        } else if (intExtra == 4) {
            message = Message.buildUnbindUser(stringExtra);
        } else if (intExtra == 100) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("data");
            String stringExtra7 = intent.getStringExtra(Constants.KEY_DATA_ID);
            String stringExtra8 = intent.getStringExtra(Constants.KEY_TARGET);
            String stringExtra9 = intent.getStringExtra(Constants.KEY_BUSINESSID);
            String stringExtra10 = intent.getStringExtra(Constants.KEY_EXT_TAG);
            try {
                reqType = (Message.ReqType) intent.getSerializableExtra(Constants.KEY_SEND_TYPE);
            } catch (Exception unused) {
                reqType = null;
            }
            if (byteArrayExtra != null) {
                try {
                    url = new URL(DefaultWebClient.HTTPS_SCHEME + ((C3022v) m9079b).m9161p());
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                    url = null;
                }
                Message.ReqType reqType2 = reqType;
                ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(stringExtra3, stringExtra2, byteArrayExtra, stringExtra7, stringExtra8, url, stringExtra9);
                accsRequest.setTag(stringExtra10);
                if (reqType2 == null) {
                    buildRequest = Message.buildSendData(m9079b.mo9091b((String) null), stringExtra5, m9079b.f9529i.getStoreId(), this.f9507c, stringExtra, accsRequest, false);
                } else if (reqType2 == Message.ReqType.REQ) {
                    buildRequest = Message.buildRequest(this.f9507c, m9079b.mo9091b((String) null), stringExtra5, m9079b.f9529i.getStoreId(), stringExtra, Constants.TARGET_SERVICE_PRE, accsRequest, false);
                }
                message = buildRequest;
            }
        } else if (intExtra == 106) {
            intent.setAction(Constants.ACTION_RECEIVE);
            intent.putExtra("command", -1);
            C2989g.m9041a().m9052b(this.f9507c, intent);
            return;
        }
        if (message == null) {
            ALog.m9182e("ServiceImpl", "message is null", new Object[0]);
            m9079b.m9095b(Message.buildParameterError(stringExtra, intExtra), -2);
        } else {
            ALog.m9180d("ServiceImpl", "try send message", new Object[0]);
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().onSend();
            }
            m9079b.m9096b(message, true);
        }
    }

    /* renamed from: c */
    private void m9072c() {
        ConcurrentHashMap<String, AbstractC3001a> concurrentHashMap = AbstractC2999d.f9515a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, AbstractC3001a>> it = AbstractC2999d.f9515a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().mo9092b();
        }
    }

    /* renamed from: d */
    private void m9073d() {
        ConcurrentHashMap<String, AbstractC3001a> concurrentHashMap = AbstractC2999d.f9515a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, AbstractC3001a>> it = AbstractC2999d.f9515a.entrySet().iterator();
        while (it.hasNext()) {
            C3028c mo9097c = it.next().getValue().mo9097c();
            if (mo9097c != null) {
                mo9097c.f9650h = this.f9508d;
                mo9097c.m9172a();
            }
        }
    }

    /* renamed from: e */
    private void m9074e() {
        ConcurrentHashMap<String, AbstractC3001a> concurrentHashMap = AbstractC2999d.f9515a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, AbstractC3001a>> it = AbstractC2999d.f9515a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().mo9101e();
        }
    }

    @Override // com.taobao.accs.internal.AbstractC2999d, com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        ALog.m9180d("ServiceImpl", "accs probeTaoBao begin......action=" + action, new Object[0]);
        if (TextUtils.isEmpty(action) || !TextUtils.equals(action, "org.agoo.android.intent.action.PING_V4")) {
            return null;
        }
        UTMini.getInstance().commitEvent(66001, "probeChannelService", UtilityImpl.m9228j(this.f9507c), intent.getStringExtra("source"));
        return this.f9510f;
    }

    @Override // com.taobao.accs.internal.AbstractC2999d, com.taobao.accs.base.IBaseService
    public void onCreate() {
        super.onCreate();
        m9066a();
    }

    @Override // com.taobao.accs.internal.AbstractC2999d, com.taobao.accs.base.IBaseService
    public void onDestroy() {
        super.onDestroy();
        ALog.m9182e("ServiceImpl", "Service onDestroy", new Object[0]);
        UtilityImpl.m9201a(this.f9507c, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        this.f9506b = null;
        this.f9507c = null;
        m9074e();
        Process.killProcess(Process.myPid());
    }

    @Override // com.taobao.accs.internal.AbstractC2999d, com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    @Override // com.taobao.accs.internal.AbstractC2999d
    /* renamed from: a */
    public int mo9075a(Intent intent) {
        String action;
        Bundle extras;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i("ServiceImpl", "onHostStartCommand", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
        }
        try {
            if (ALog.isPrintLog(ALog.Level.D) && intent != null && (extras = intent.getExtras()) != null) {
                for (String str : extras.keySet()) {
                    ALog.m9180d("ServiceImpl", "onHostStartCommand", "key", str, " value", extras.get(str));
                }
            }
            int m9266c = C3049q.m9266c();
            if (m9266c > 3) {
                ALog.m9182e("ServiceImpl", "onHostStartCommand load SO fail 4 times, don't auto restart", new Object[0]);
                C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_SOFAIL, UtilityImpl.m9194a(m9266c), 0.0d);
            }
            action = intent == null ? null : intent.getAction();
        } finally {
            try {
                return 2;
            } finally {
            }
        }
        if (!TextUtils.isEmpty(action)) {
            m9067a(intent, action);
            return 2;
        }
        m9070b();
        m9069a(false, false);
        return 2;
    }

    /* renamed from: a */
    private void m9066a() {
        ALog.m9180d("ServiceImpl", "init start", new Object[0]);
        GlobalClientInfo.getInstance(this.f9507c);
        C2978a.f9405f.incrementAndGet();
        this.f9508d = System.currentTimeMillis();
        this.f9509e = UtilityImpl.m9225h(this.f9507c);
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i("ServiceImpl", "init", "sdkVersion", 221, "procStart", Integer.valueOf(C2978a.f9405f.intValue()));
        }
        UTMini.getInstance().commitEvent(66001, "START", UtilityImpl.m9224h(), "PROXY");
        long m9229k = UtilityImpl.m9229k(this.f9507c);
        ALog.m9180d("ServiceImpl", "getServiceAliveTime", "aliveTime", Long.valueOf(m9229k));
        if (m9229k > 20000) {
            C3043k.m9250a("accs", BaseMonitor.COUNT_SERVICE_ALIVE, "", m9229k / 1000);
        }
        UtilityImpl.m9201a(this.f9507c, Constants.SP_KEY_SERVICE_START, System.currentTimeMillis());
        UTMini.getInstance().commitEvent(66001, "NOTIFY", UtilityImpl.m9233o(this.f9507c));
    }

    /* renamed from: a */
    private void m9067a(Intent intent, String str) {
        ALog.m9180d("ServiceImpl", "handleAction", "action", str);
        try {
            if (!TextUtils.isEmpty(str) && "org.agoo.android.intent.action.PING_V4".equals(str)) {
                String stringExtra = intent.getStringExtra("source");
                ALog.m9183i("ServiceImpl", "org.agoo.android.intent.action.PING_V4,start channel by brothers", "serviceStart", Integer.valueOf(C2978a.f9405f.intValue()), "source" + stringExtra);
                C3043k.m9250a("accs", "startChannel", stringExtra, 0.0d);
                if (C2978a.m8978c()) {
                    C3043k.m9250a("accs", "createChannel", stringExtra, 0.0d);
                }
            }
            m9070b();
            if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
                return;
            }
            if (TextUtils.equals(str, "android.net.conn.CONNECTIVITY_CHANGE")) {
                String m9225h = UtilityImpl.m9225h(this.f9507c);
                boolean m9227i = UtilityImpl.m9227i(this.f9507c);
                ALog.m9183i("ServiceImpl", "network change:" + this.f9509e + " to " + m9225h, new Object[0]);
                if (m9227i) {
                    this.f9509e = m9225h;
                    m9072c();
                    m9069a(true, false);
                    UTMini.getInstance().commitEvent(66001, "CONNECTIVITY_CHANGE", m9225h, UtilityImpl.m9224h(), "0");
                }
                if (m9225h.equals("unknown")) {
                    m9072c();
                    this.f9509e = m9225h;
                    return;
                }
                return;
            }
            if (TextUtils.equals(str, "android.intent.action.BOOT_COMPLETED")) {
                m9069a(true, false);
                return;
            }
            if (TextUtils.equals(str, "android.intent.action.USER_PRESENT")) {
                ALog.m9180d("ServiceImpl", "action android.intent.action.USER_PRESENT", new Object[0]);
                m9069a(true, false);
            } else if (str.equals(Constants.ACTION_COMMAND)) {
                m9071b(intent);
            } else if (str.equals(Constants.ACTION_START_FROM_AGOO)) {
                ALog.m9183i("ServiceImpl", "ACTION_START_FROM_AGOO", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.m9181e("ServiceImpl", "handleAction", th, new Object[0]);
        }
    }

    /* renamed from: b */
    private synchronized void m9070b() {
        if (AbstractC2999d.f9515a != null && AbstractC2999d.f9515a.size() != 0) {
            for (Map.Entry<String, AbstractC3001a> entry : AbstractC2999d.f9515a.entrySet()) {
                AbstractC3001a value = entry.getValue();
                if (value == null) {
                    ALog.m9182e("ServiceImpl", "tryConnect connection null", "appkey", value.m9105i());
                    return;
                }
                ALog.m9183i("ServiceImpl", "tryConnect", "appkey", value.m9105i(), Constants.KEY_CONFIG_TAG, entry.getKey());
                if (value.m9108l() && TextUtils.isEmpty(value.f9529i.getAppSecret())) {
                    ALog.m9182e("ServiceImpl", "tryConnect secret is null", new Object[0]);
                } else {
                    value.mo9082a();
                }
            }
            return;
        }
        ALog.m9186w("ServiceImpl", "tryConnect no connections", new Object[0]);
    }

    /* renamed from: a */
    private void m9068a(Message message, boolean z) {
        ConcurrentHashMap<String, AbstractC3001a> concurrentHashMap = AbstractC2999d.f9515a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, AbstractC3001a>> it = AbstractC2999d.f9515a.entrySet().iterator();
        while (it.hasNext()) {
            AbstractC3001a value = it.next().getValue();
            if (value instanceof C3011k) {
                value.mo9088a(true, false);
            } else {
                value.m9096b(message, z);
            }
        }
    }

    /* renamed from: a */
    private void m9069a(boolean z, boolean z2) {
        ConcurrentHashMap<String, AbstractC3001a> concurrentHashMap = AbstractC2999d.f9515a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, AbstractC3001a>> it = AbstractC2999d.f9515a.entrySet().iterator();
        while (it.hasNext()) {
            AbstractC3001a value = it.next().getValue();
            value.mo9088a(z, z2);
            ALog.m9183i("ServiceImpl", "ping connection", "appkey", value.m9105i());
        }
    }
}
