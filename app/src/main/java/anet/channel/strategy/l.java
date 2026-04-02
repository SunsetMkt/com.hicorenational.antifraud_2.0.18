package anet.channel.strategy;

import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1608d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1609e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1610f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f1611g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f1612h;

        public a(JSONObject jSONObject) {
            this.a = jSONObject.optInt("port");
            this.f1606b = jSONObject.optString("protocol");
            this.f1607c = jSONObject.optInt("cto");
            this.f1608d = jSONObject.optInt("rto");
            this.f1609e = jSONObject.optInt("retry");
            this.f1610f = jSONObject.optInt("heartbeat");
            this.f1611g = jSONObject.optString("rtt", "");
            this.f1612h = jSONObject.optString("publickey");
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1614c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f1615d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f1616e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f1617f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String[] f1618g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a[] f1619h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final e[] f1620i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f1621j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f1622k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f1623l;

        public b(JSONObject jSONObject) {
            this.a = jSONObject.optString(Constants.KEY_HOST);
            this.f1613b = jSONObject.optInt(RemoteMessageConst.TTL);
            this.f1614c = jSONObject.optString("safeAisles");
            this.f1615d = jSONObject.optString("cname", null);
            this.f1616e = jSONObject.optString("unit", null);
            this.f1621j = jSONObject.optInt("clear") == 1;
            this.f1622k = jSONObject.optBoolean("effectNow");
            this.f1623l = jSONObject.optInt("version");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.f1617f = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f1617f[i2] = jSONArrayOptJSONArray.optString(i2);
                }
            } else {
                this.f1617f = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sips");
            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                this.f1618g = null;
            } else {
                int length2 = jSONArrayOptJSONArray2.length();
                this.f1618g = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f1618g[i3] = jSONArrayOptJSONArray2.optString(i3);
                }
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("aisles");
            if (jSONArrayOptJSONArray3 != null) {
                int length3 = jSONArrayOptJSONArray3.length();
                this.f1619h = new a[length3];
                for (int i4 = 0; i4 < length3; i4++) {
                    this.f1619h[i4] = new a(jSONArrayOptJSONArray3.optJSONObject(i4));
                }
            } else {
                this.f1619h = null;
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("strategies");
            if (jSONArrayOptJSONArray4 == null || jSONArrayOptJSONArray4.length() <= 0) {
                this.f1620i = null;
                return;
            }
            int length4 = jSONArrayOptJSONArray4.length();
            this.f1620i = new e[length4];
            for (int i5 = 0; i5 < length4; i5++) {
                this.f1620i[i5] = new e(jSONArrayOptJSONArray4.optJSONObject(i5));
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class c {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e[] f1624b;

        public c(JSONObject jSONObject) {
            this.a = jSONObject.optString(Constants.KEY_HOST);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("strategies");
            if (jSONArrayOptJSONArray == null) {
                this.f1624b = null;
                return;
            }
            int length = jSONArrayOptJSONArray.length();
            this.f1624b = new e[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.f1624b[i2] = new e(jSONArrayOptJSONArray.optJSONObject(i2));
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class d {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f1625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c[] f1626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f1627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f1628e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1629f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f1630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f1631h;

        public d(JSONObject jSONObject) {
            this.a = jSONObject.optString("ip");
            this.f1627d = jSONObject.optString("uid", null);
            this.f1628e = jSONObject.optString("utdid", null);
            this.f1629f = jSONObject.optInt(DispatchConstants.CONFIG_VERSION);
            this.f1630g = jSONObject.optInt("fcl");
            this.f1631h = jSONObject.optInt("fct");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.f1625b = new b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f1625b[i2] = new b(jSONArrayOptJSONArray.optJSONObject(i2));
                }
            } else {
                this.f1625b = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (jSONArrayOptJSONArray2 == null) {
                this.f1626c = null;
                return;
            }
            int length2 = jSONArrayOptJSONArray2.length();
            this.f1626c = new c[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                this.f1626c[i3] = new c(jSONArrayOptJSONArray2.optJSONObject(i3));
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class e {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f1632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1633c;

        public e(JSONObject jSONObject) {
            this.a = jSONObject.optString("ip");
            this.f1633c = jSONObject.optString("path");
            this.f1632b = new a(jSONObject);
        }
    }

    public static d a(JSONObject jSONObject) {
        try {
            return new d(jSONObject);
        } catch (Exception e2) {
            ALog.e("StrategyResultParser", "Parse HttpDns response failed.", null, e2, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
