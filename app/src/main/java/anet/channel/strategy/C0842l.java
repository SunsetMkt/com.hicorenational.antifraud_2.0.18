package anet.channel.strategy;

import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.l */
/* loaded from: classes.dex */
public class C0842l {

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.l$a */
    public static class a {

        /* renamed from: a */
        public final int f1109a;

        /* renamed from: b */
        public final String f1110b;

        /* renamed from: c */
        public final int f1111c;

        /* renamed from: d */
        public final int f1112d;

        /* renamed from: e */
        public final int f1113e;

        /* renamed from: f */
        public final int f1114f;

        /* renamed from: g */
        public final String f1115g;

        /* renamed from: h */
        public final String f1116h;

        public a(JSONObject jSONObject) {
            this.f1109a = jSONObject.optInt("port");
            this.f1110b = jSONObject.optString("protocol");
            this.f1111c = jSONObject.optInt("cto");
            this.f1112d = jSONObject.optInt("rto");
            this.f1113e = jSONObject.optInt("retry");
            this.f1114f = jSONObject.optInt("heartbeat");
            this.f1115g = jSONObject.optString("rtt", "");
            this.f1116h = jSONObject.optString("publickey");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.l$b */
    public static class b {

        /* renamed from: a */
        public final String f1117a;

        /* renamed from: b */
        public final int f1118b;

        /* renamed from: c */
        public final String f1119c;

        /* renamed from: d */
        public final String f1120d;

        /* renamed from: e */
        public final String f1121e;

        /* renamed from: f */
        public final String[] f1122f;

        /* renamed from: g */
        public final String[] f1123g;

        /* renamed from: h */
        public final a[] f1124h;

        /* renamed from: i */
        public final e[] f1125i;

        /* renamed from: j */
        public final boolean f1126j;

        /* renamed from: k */
        public final boolean f1127k;

        /* renamed from: l */
        public final int f1128l;

        public b(JSONObject jSONObject) {
            this.f1117a = jSONObject.optString(Constants.KEY_HOST);
            this.f1118b = jSONObject.optInt(RemoteMessageConst.TTL);
            this.f1119c = jSONObject.optString("safeAisles");
            this.f1120d = jSONObject.optString("cname", null);
            this.f1121e = jSONObject.optString("unit", null);
            this.f1126j = jSONObject.optInt("clear") == 1;
            this.f1127k = jSONObject.optBoolean("effectNow");
            this.f1128l = jSONObject.optInt("version");
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f1122f = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f1122f[i2] = optJSONArray.optString(i2);
                }
            } else {
                this.f1122f = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sips");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                this.f1123g = null;
            } else {
                int length2 = optJSONArray2.length();
                this.f1123g = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f1123g[i3] = optJSONArray2.optString(i3);
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("aisles");
            if (optJSONArray3 != null) {
                int length3 = optJSONArray3.length();
                this.f1124h = new a[length3];
                for (int i4 = 0; i4 < length3; i4++) {
                    this.f1124h[i4] = new a(optJSONArray3.optJSONObject(i4));
                }
            } else {
                this.f1124h = null;
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("strategies");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                this.f1125i = null;
                return;
            }
            int length4 = optJSONArray4.length();
            this.f1125i = new e[length4];
            for (int i5 = 0; i5 < length4; i5++) {
                this.f1125i[i5] = new e(optJSONArray4.optJSONObject(i5));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.l$c */
    public static class c {

        /* renamed from: a */
        public final String f1129a;

        /* renamed from: b */
        public final e[] f1130b;

        public c(JSONObject jSONObject) {
            this.f1129a = jSONObject.optString(Constants.KEY_HOST);
            JSONArray optJSONArray = jSONObject.optJSONArray("strategies");
            if (optJSONArray == null) {
                this.f1130b = null;
                return;
            }
            int length = optJSONArray.length();
            this.f1130b = new e[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.f1130b[i2] = new e(optJSONArray.optJSONObject(i2));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.l$d */
    public static class d {

        /* renamed from: a */
        public final String f1131a;

        /* renamed from: b */
        public final b[] f1132b;

        /* renamed from: c */
        public final c[] f1133c;

        /* renamed from: d */
        public final String f1134d;

        /* renamed from: e */
        public final String f1135e;

        /* renamed from: f */
        public final int f1136f;

        /* renamed from: g */
        public final int f1137g;

        /* renamed from: h */
        public final int f1138h;

        public d(JSONObject jSONObject) {
            this.f1131a = jSONObject.optString("ip");
            this.f1134d = jSONObject.optString("uid", null);
            this.f1135e = jSONObject.optString("utdid", null);
            this.f1136f = jSONObject.optInt(DispatchConstants.CONFIG_VERSION);
            this.f1137g = jSONObject.optInt("fcl");
            this.f1138h = jSONObject.optInt("fct");
            JSONArray optJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f1132b = new b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f1132b[i2] = new b(optJSONArray.optJSONObject(i2));
                }
            } else {
                this.f1132b = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (optJSONArray2 == null) {
                this.f1133c = null;
                return;
            }
            int length2 = optJSONArray2.length();
            this.f1133c = new c[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                this.f1133c[i3] = new c(optJSONArray2.optJSONObject(i3));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.l$e */
    public static class e {

        /* renamed from: a */
        public final String f1139a;

        /* renamed from: b */
        public final a f1140b;

        /* renamed from: c */
        public final String f1141c;

        public e(JSONObject jSONObject) {
            this.f1139a = jSONObject.optString("ip");
            this.f1141c = jSONObject.optString("path");
            this.f1140b = new a(jSONObject);
        }
    }

    /* renamed from: a */
    public static d m690a(JSONObject jSONObject) {
        try {
            return new d(jSONObject);
        } catch (Exception e2) {
            ALog.m714e("StrategyResultParser", "Parse HttpDns response failed.", null, e2, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
