package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import org.android.netutil.NetUtils;
import org.android.netutil.PingEntry;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class ExceptionDetector {

    /* renamed from: a */
    long f773a;

    /* renamed from: b */
    String f774b;

    /* renamed from: c */
    String f775c;

    /* renamed from: d */
    String f776d;

    /* renamed from: e */
    LimitedQueue<Pair<String, Integer>> f777e = new LimitedQueue<>(10);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    class LimitedQueue<E> extends LinkedList<E> {

        /* renamed from: b */
        private int f779b;

        public LimitedQueue(int i2) {
            this.f779b = i2;
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
        public boolean add(E e2) {
            boolean add = super.add(e2);
            while (add && size() > this.f779b) {
                super.remove();
            }
            return add;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.detect.ExceptionDetector$a */
    private class C0758a {

        /* renamed from: a */
        String f780a;

        /* renamed from: b */
        String f781b;

        /* renamed from: c */
        String f782c;

        /* renamed from: d */
        Future<PingResponse> f783d;

        /* renamed from: e */
        Future<PingResponse> f784e;

        /* renamed from: f */
        Future<PingResponse> f785f;

        private C0758a() {
        }

        /* synthetic */ C0758a(ExceptionDetector exceptionDetector, C0759a c0759a) {
            this();
        }
    }

    ExceptionDetector() {
    }

    /* renamed from: a */
    public void m466a() {
        NetworkStatusHelper.addStatusChangeListener(new C0759a(this));
    }

    /* renamed from: b */
    void m468b() throws JSONException {
        ALog.m715e("anet.ExceptionDetector", "network detect start.", null, new Object[0]);
        SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        jSONObject2.put(NotificationCompat.CATEGORY_STATUS, status.getType());
        jSONObject2.put("subType", NetworkStatusHelper.getNetworkSubType());
        if (status != NetworkStatusHelper.NetworkStatus.NO) {
            if (status.isMobile()) {
                jSONObject2.put("apn", NetworkStatusHelper.getApn());
                jSONObject2.put("carrier", NetworkStatusHelper.getCarrier());
            } else {
                jSONObject2.put(DispatchConstants.BSSID, NetworkStatusHelper.getWifiBSSID());
                jSONObject2.put("ssid", NetworkStatusHelper.getWifiSSID());
            }
            jSONObject2.put("proxy", NetworkStatusHelper.getProxyType());
        }
        jSONObject.put("NetworkInfo", jSONObject2);
        String defaultGateway = status.isWifi() ? NetUtils.getDefaultGateway("114.114.114.114") : NetUtils.getPreferNextHop("114.114.114.114", 2);
        Future<PingResponse> launch = !TextUtils.isEmpty(defaultGateway) ? new PingTask(defaultGateway, 1000, 3, 0, 0).launch() : null;
        C0758a m462a = m462a("guide-acs.m.taobao.com", this.f774b);
        C0758a m462a2 = m462a("gw.alicdn.com", this.f776d);
        C0758a m462a3 = m462a("msgacs.m.taobao.com", this.f775c);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("nextHop", defaultGateway);
        jSONObject3.put("ping", m465a(launch));
        jSONObject.put("LocalDetect", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(m464a(m462a));
        jSONArray.put(m464a(m462a2));
        jSONArray.put(m464a(m462a3));
        jSONObject.put("InternetDetect", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        Iterator<Pair<String, Integer>> it = this.f777e.iterator();
        while (it.hasNext()) {
            Pair<String, Integer> next = it.next();
            jSONObject4.put((String) next.first, next.second);
        }
        jSONObject.put("BizDetect", jSONObject4);
        this.f777e.clear();
        ALog.m715e("anet.ExceptionDetector", "network detect result: " + jSONObject.toString(), null, new Object[0]);
    }

    /* renamed from: c */
    boolean m469c() {
        if (this.f777e.size() != 10) {
            return false;
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.NO) {
            ALog.m715e("anet.ExceptionDetector", "no network", null, new Object[0]);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f773a) {
            return false;
        }
        Iterator<Pair<String, Integer>> it = this.f777e.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next().second).intValue();
            if (intValue == -202 || intValue == -400 || intValue == -401 || intValue == -405 || intValue == -406) {
                i2++;
            }
        }
        boolean z = i2 * 2 > 10;
        if (z) {
            this.f773a = currentTimeMillis + 1800000;
        }
        return z;
    }

    /* renamed from: a */
    public void m467a(RequestStatistic requestStatistic) {
        if (AwcnConfig.isNetworkDetectEnable()) {
            ThreadPoolExecutorFactory.submitDetectTask(new RunnableC0761c(this, requestStatistic));
        } else {
            ALog.m716i("anet.ExceptionDetector", "network detect closed.", null, new Object[0]);
        }
    }

    /* renamed from: a */
    private ArrayList<String> m463a(String str, int i2) {
        PingResponse pingResponse;
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i3 = 0;
        while (i3 < i2) {
            i3++;
            try {
                pingResponse = (PingResponse) new PingTask(str, 0, 1, 0, i3).launch().get();
            } catch (Exception unused) {
                pingResponse = null;
            }
            StringBuilder sb = new StringBuilder();
            if (pingResponse != null) {
                String lastHopIPStr = pingResponse.getLastHopIPStr();
                double d2 = pingResponse.getResults()[0].rtt;
                int errcode = pingResponse.getErrcode();
                if (TextUtils.isEmpty(lastHopIPStr)) {
                    lastHopIPStr = "*";
                }
                sb.append("hop=");
                sb.append(lastHopIPStr);
                sb.append(",rtt=");
                sb.append(d2);
                sb.append(",errCode=");
                sb.append(errcode);
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    /* renamed from: a */
    private C0758a m462a(String str, String str2) {
        C0758a c0758a = new C0758a(this, null);
        c0758a.f780a = str;
        try {
            c0758a.f781b = InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
        }
        if (!TextUtils.isEmpty(str2)) {
            c0758a.f782c = str2;
        } else {
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
            if (connStrategyListByHost != null && !connStrategyListByHost.isEmpty()) {
                c0758a.f782c = connStrategyListByHost.get(0).getIp();
            }
        }
        String str3 = !TextUtils.isEmpty(c0758a.f782c) ? c0758a.f782c : c0758a.f781b;
        if (!TextUtils.isEmpty(str3)) {
            String str4 = str3;
            c0758a.f783d = new PingTask(str4, 1000, 3, 0, 0).launch();
            c0758a.f784e = new PingTask(str4, 1000, 3, 1172, 0).launch();
            c0758a.f785f = new PingTask(str4, 1000, 3, 1432, 0).launch();
        }
        return c0758a;
    }

    /* renamed from: a */
    private JSONObject m464a(C0758a c0758a) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (c0758a != null && c0758a.f783d != null) {
            jSONObject.put(Constants.KEY_HOST, c0758a.f780a);
            jSONObject.put("currentIp", c0758a.f782c);
            jSONObject.put("localIp", c0758a.f781b);
            jSONObject.put("ping", m465a(c0758a.f783d));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("1200", m465a(c0758a.f784e));
            jSONObject2.put("1460", m465a(c0758a.f785f));
            jSONObject.put("MTU", jSONObject2);
            if ("guide-acs.m.taobao.com".equals(c0758a.f780a)) {
                ArrayList<String> m463a = m463a(!TextUtils.isEmpty(c0758a.f782c) ? c0758a.f782c : c0758a.f781b, 5);
                JSONObject jSONObject3 = new JSONObject();
                int i2 = 0;
                while (i2 < m463a.size()) {
                    int i3 = i2 + 1;
                    jSONObject3.put(String.valueOf(i3), m463a.get(i2));
                    i2 = i3;
                }
                jSONObject.put("traceRoute", jSONObject3);
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    private JSONObject m465a(Future<PingResponse> future) throws JSONException {
        PingResponse pingResponse;
        JSONObject jSONObject = new JSONObject();
        if (future == null) {
            return jSONObject;
        }
        try {
            pingResponse = future.get();
        } catch (Exception unused) {
            pingResponse = null;
        }
        if (pingResponse == null) {
            return jSONObject;
        }
        jSONObject.put("errCode", pingResponse.getErrcode());
        JSONArray jSONArray = new JSONArray();
        for (PingEntry pingEntry : pingResponse.getResults()) {
            jSONArray.put("seq=" + pingEntry.seq + ",hop=" + pingEntry.hop + ",rtt=" + pingEntry.rtt);
        }
        jSONObject.put("response", jSONArray);
        return jSONObject;
    }
}
