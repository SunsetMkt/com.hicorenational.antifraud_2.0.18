package com.xiaomi.push;

import android.text.TextUtils;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.mipush.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.cc */
/* loaded from: classes2.dex */
public class C4128cc {

    /* renamed from: a */
    private long f14702a;

    /* renamed from: a */
    public String f14703a;

    /* renamed from: b */
    public String f14706b;

    /* renamed from: c */
    public String f14707c;

    /* renamed from: d */
    public String f14708d;

    /* renamed from: e */
    public String f14709e;

    /* renamed from: f */
    public String f14710f;

    /* renamed from: g */
    public String f14711g;

    /* renamed from: h */
    protected String f14712h;

    /* renamed from: i */
    private String f14713i;

    /* renamed from: a */
    private ArrayList<C4135cj> f14704a = new ArrayList<>();

    /* renamed from: a */
    private double f14701a = 0.1d;

    /* renamed from: j */
    private String f14714j = "s.mi1.cc";

    /* renamed from: b */
    private long f14705b = 86400000;

    public C4128cc(String str) {
        this.f14703a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f14702a = System.currentTimeMillis();
        this.f14704a.add(new C4135cj(str, -1));
        this.f14703a = C4132cg.m14067a();
        this.f14706b = str;
    }

    /* renamed from: a */
    public boolean m14047a() {
        return TextUtils.equals(this.f14703a, C4132cg.m14067a());
    }

    /* renamed from: b */
    public boolean mo14052b() {
        return System.currentTimeMillis() - this.f14702a < this.f14705b;
    }

    /* renamed from: c */
    boolean m14053c() {
        long j2 = this.f14705b;
        if (864000000 >= j2) {
            j2 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f14702a;
        return currentTimeMillis - j3 > j2 || (currentTimeMillis - j3 > this.f14705b && this.f14703a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14703a);
        sb.append("\n");
        sb.append(m14033a());
        Iterator<C4135cj> it = this.f14704a.iterator();
        while (it.hasNext()) {
            C4135cj next = it.next();
            sb.append("\n");
            sb.append(next.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m14048a(C4128cc c4128cc) {
        return TextUtils.equals(this.f14703a, c4128cc.f14703a);
    }

    /* renamed from: b */
    public void m14050b(String str, long j2, long j3) {
        m14042a(str, 0, j2, j3, null);
    }

    /* renamed from: a */
    public void m14039a(long j2) {
        if (j2 > 0) {
            this.f14705b = j2;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j2);
    }

    /* renamed from: b */
    public void m14051b(String str, long j2, long j3, Exception exc) {
        m14042a(str, -1, j2, j3, exc);
    }

    /* renamed from: b */
    public void m14049b(String str) {
        this.f14714j = str;
    }

    /* renamed from: c */
    private synchronized void m14031c(String str) {
        Iterator<C4135cj> it = this.f14704a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f14741a, str)) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public ArrayList<String> m14035a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f14706b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = mo14036a(true).iterator();
                while (it.hasNext()) {
                    C4130ce m14061a = C4130ce.m14061a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), m14061a.m14064a(), m14061a.m14063a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    /* renamed from: a */
    public void m14043a(String str, long j2, long j3) {
        try {
            m14050b(new URL(str).getHost(), j2, j3);
        } catch (MalformedURLException unused) {
        }
    }

    /* renamed from: a */
    public void m14044a(String str, long j2, long j3, Exception exc) {
        try {
            m14051b(new URL(str).getHost(), j2, j3, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* renamed from: a */
    public void m14042a(String str, int i2, long j2, long j3, Exception exc) {
        mo14045a(str, new C4127cb(i2, j2, j3, exc));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r1.m14112a(r5);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void mo14045a(java.lang.String r4, com.xiaomi.push.C4127cb r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<com.xiaomi.push.cj> r0 = r3.f14704a     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            com.xiaomi.push.cj r1 = (com.xiaomi.push.C4135cj) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.f14741a     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.m14112a(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C4128cc.mo14045a(java.lang.String, com.xiaomi.push.cb):void");
    }

    /* renamed from: a */
    public synchronized ArrayList<String> m14034a() {
        return mo14036a(false);
    }

    /* renamed from: a */
    public synchronized ArrayList<String> mo14036a(boolean z) {
        ArrayList<String> arrayList;
        C4135cj[] c4135cjArr = new C4135cj[this.f14704a.size()];
        this.f14704a.toArray(c4135cjArr);
        Arrays.sort(c4135cjArr);
        arrayList = new ArrayList<>();
        for (C4135cj c4135cj : c4135cjArr) {
            if (z) {
                arrayList.add(c4135cj.f14741a);
            } else {
                int indexOf = c4135cj.f14741a.indexOf(Constants.COLON_SEPARATOR);
                if (indexOf != -1) {
                    arrayList.add(c4135cj.f14741a.substring(0, indexOf));
                } else {
                    arrayList.add(c4135cj.f14741a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void m14041a(String str) {
        m14040a(new C4135cj(str));
    }

    /* renamed from: a */
    synchronized void m14040a(C4135cj c4135cj) {
        m14031c(c4135cj.f14741a);
        this.f14704a.add(c4135cj);
    }

    /* renamed from: a */
    public synchronized void m14046a(String[] strArr) {
        int i2;
        int size = this.f14704a.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 < length) {
                    if (TextUtils.equals(this.f14704a.get(size).f14741a, strArr[i2])) {
                        this.f14704a.remove(size);
                        break;
                    }
                    i2++;
                }
            }
            size--;
        }
        Iterator<C4135cj> it = this.f14704a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            C4135cj next = it.next();
            if (next.f14739a > i3) {
                i3 = next.f14739a;
            }
        }
        while (i2 < strArr.length) {
            m14040a(new C4135cj(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    /* renamed from: a */
    public synchronized String m14033a() {
        if (!TextUtils.isEmpty(this.f14713i)) {
            return this.f14713i;
        }
        if (TextUtils.isEmpty(this.f14709e)) {
            return "hardcode_isp";
        }
        this.f14713i = C4100bb.m13884a(new String[]{this.f14709e, this.f14707c, this.f14708d, this.f14711g, this.f14710f}, AbstractC1191a.f2606s1);
        return this.f14713i;
    }

    /* renamed from: a */
    public void m14038a(double d2) {
        this.f14701a = d2;
    }

    /* renamed from: a */
    public synchronized JSONObject m14037a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f14703a);
        jSONObject.put(RemoteMessageConst.TTL, this.f14705b);
        jSONObject.put("pct", this.f14701a);
        jSONObject.put("ts", this.f14702a);
        jSONObject.put(UserInfo.CITY, this.f14708d);
        jSONObject.put("prv", this.f14707c);
        jSONObject.put("cty", this.f14711g);
        jSONObject.put("isp", this.f14709e);
        jSONObject.put("ip", this.f14710f);
        jSONObject.put(com.taobao.accs.common.Constants.KEY_HOST, this.f14706b);
        jSONObject.put("xf", this.f14712h);
        JSONArray jSONArray = new JSONArray();
        Iterator<C4135cj> it = this.f14704a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m14111a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public synchronized C4128cc m14032a(JSONObject jSONObject) {
        this.f14703a = jSONObject.optString("net");
        this.f14705b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.f14701a = jSONObject.getDouble("pct");
        this.f14702a = jSONObject.getLong("ts");
        this.f14708d = jSONObject.optString(UserInfo.CITY);
        this.f14707c = jSONObject.optString("prv");
        this.f14711g = jSONObject.optString("cty");
        this.f14709e = jSONObject.optString("isp");
        this.f14710f = jSONObject.optString("ip");
        this.f14706b = jSONObject.optString(com.taobao.accs.common.Constants.KEY_HOST);
        this.f14712h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            m14040a(new C4135cj().m14110a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }
}
