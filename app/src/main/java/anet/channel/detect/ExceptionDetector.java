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

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class ExceptionDetector {
    long a;

    /* JADX INFO: renamed from: b */
    String f1402b;

    /* JADX INFO: renamed from: c */
    String f1403c;

    /* JADX INFO: renamed from: d */
    String f1404d;

    /* JADX INFO: renamed from: e */
    LimitedQueue<Pair<String, Integer>> f1405e = new LimitedQueue<>(10);

    /* JADX INFO: compiled from: Taobao */
    class LimitedQueue<E> extends LinkedList<E> {

        /* JADX INFO: renamed from: b */
        private int f1406b;

        public LimitedQueue(int i2) {
            this.f1406b = i2;
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
        public boolean add(E e2) {
            boolean zAdd = super.add(e2);
            while (zAdd && size() > this.f1406b) {
                super.remove();
            }
            return zAdd;
        }
    }

    /* JADX INFO: compiled from: Taobao */
    private class a {
        String a;

        /* JADX INFO: renamed from: b */
        String f1407b;

        /* JADX INFO: renamed from: c */
        String f1408c;

        /* JADX INFO: renamed from: d */
        Future<PingResponse> f1409d;

        /* JADX INFO: renamed from: e */
        Future<PingResponse> f1410e;

        /* JADX INFO: renamed from: f */
        Future<PingResponse> f1411f;

        private a() {
        }

        /* synthetic */ a(ExceptionDetector exceptionDetector, anet.channel.detect.a aVar) {
            this();
        }
    }

    ExceptionDetector() {
    }

    public void a() {
        NetworkStatusHelper.addStatusChangeListener(new anet.channel.detect.a(this));
    }

    void b() throws JSONException {
        ALog.e("anet.ExceptionDetector", "network detect start.", null, new Object[0]);
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
        Future<PingResponse> futureLaunch = !TextUtils.isEmpty(defaultGateway) ? new PingTask(defaultGateway, 1000, 3, 0, 0).launch() : null;
        a aVarA = a("guide-acs.m.taobao.com", this.f1402b);
        a aVarA2 = a("gw.alicdn.com", this.f1404d);
        a aVarA3 = a("msgacs.m.taobao.com", this.f1403c);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("nextHop", defaultGateway);
        jSONObject3.put("ping", a(futureLaunch));
        jSONObject.put("LocalDetect", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a(aVarA));
        jSONArray.put(a(aVarA2));
        jSONArray.put(a(aVarA3));
        jSONObject.put("InternetDetect", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        for (Pair<String, Integer> pair : this.f1405e) {
            jSONObject4.put((String) pair.first, pair.second);
        }
        jSONObject.put("BizDetect", jSONObject4);
        this.f1405e.clear();
        ALog.e("anet.ExceptionDetector", "network detect result: " + jSONObject.toString(), null, new Object[0]);
    }

    boolean c() {
        if (this.f1405e.size() != 10) {
            return false;
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.NO) {
            ALog.e("anet.ExceptionDetector", "no network", null, new Object[0]);
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.a) {
            return false;
        }
        Iterator<Pair<String, Integer>> it = this.f1405e.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next().second).intValue();
            if (iIntValue == -202 || iIntValue == -400 || iIntValue == -401 || iIntValue == -405 || iIntValue == -406) {
                i2++;
            }
        }
        boolean z = i2 * 2 > 10;
        if (z) {
            this.a = jCurrentTimeMillis + 1800000;
        }
        return z;
    }

    public void a(RequestStatistic requestStatistic) {
        if (AwcnConfig.isNetworkDetectEnable()) {
            ThreadPoolExecutorFactory.submitDetectTask(new c(this, requestStatistic));
        } else {
            ALog.i("anet.ExceptionDetector", "network detect closed.", null, new Object[0]);
        }
    }

    private ArrayList<String> a(String str, int i2) {
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

    private a a(String str, String str2) {
        a aVar = new a(this, null);
        aVar.a = str;
        try {
            aVar.f1407b = InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.f1408c = str2;
        } else {
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
            if (connStrategyListByHost != null && !connStrategyListByHost.isEmpty()) {
                aVar.f1408c = connStrategyListByHost.get(0).getIp();
            }
        }
        String str3 = !TextUtils.isEmpty(aVar.f1408c) ? aVar.f1408c : aVar.f1407b;
        if (!TextUtils.isEmpty(str3)) {
            String str4 = str3;
            aVar.f1409d = new PingTask(str4, 1000, 3, 0, 0).launch();
            aVar.f1410e = new PingTask(str4, 1000, 3, 1172, 0).launch();
            aVar.f1411f = new PingTask(str4, 1000, 3, 1432, 0).launch();
        }
        return aVar;
    }

    private JSONObject a(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null && aVar.f1409d != null) {
            jSONObject.put(Constants.KEY_HOST, aVar.a);
            jSONObject.put("currentIp", aVar.f1408c);
            jSONObject.put("localIp", aVar.f1407b);
            jSONObject.put("ping", a(aVar.f1409d));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("1200", a(aVar.f1410e));
            jSONObject2.put("1460", a(aVar.f1411f));
            jSONObject.put("MTU", jSONObject2);
            if ("guide-acs.m.taobao.com".equals(aVar.a)) {
                ArrayList<String> arrayListA = a(!TextUtils.isEmpty(aVar.f1408c) ? aVar.f1408c : aVar.f1407b, 5);
                JSONObject jSONObject3 = new JSONObject();
                int i2 = 0;
                while (i2 < arrayListA.size()) {
                    int i3 = i2 + 1;
                    jSONObject3.put(String.valueOf(i3), arrayListA.get(i2));
                    i2 = i3;
                }
                jSONObject.put("traceRoute", jSONObject3);
            }
        }
        return jSONObject;
    }

    private JSONObject a(Future<PingResponse> future) throws JSONException {
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
