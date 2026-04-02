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

/* JADX INFO: loaded from: classes2.dex */
public class cc {

    /* JADX INFO: renamed from: a */
    private long f248a;

    /* JADX INFO: renamed from: a */
    public String f249a;

    /* JADX INFO: renamed from: b */
    public String f251b;

    /* JADX INFO: renamed from: c */
    public String f8794c;

    /* JADX INFO: renamed from: d */
    public String f8795d;

    /* JADX INFO: renamed from: e */
    public String f8796e;

    /* JADX INFO: renamed from: f */
    public String f8797f;

    /* JADX INFO: renamed from: g */
    public String f8798g;

    /* JADX INFO: renamed from: h */
    protected String f8799h;

    /* JADX INFO: renamed from: i */
    private String f8800i;

    /* JADX INFO: renamed from: a */
    private ArrayList<cj> f250a = new ArrayList<>();
    private double a = 0.1d;

    /* JADX INFO: renamed from: j */
    private String f8801j = "s.mi1.cc";

    /* JADX INFO: renamed from: b */
    private long f8793b = 86400000;

    public cc(String str) {
        this.f249a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f248a = System.currentTimeMillis();
        this.f250a.add(new cj(str, -1));
        this.f249a = cg.m225a();
        this.f251b = str;
    }

    /* JADX INFO: renamed from: a */
    public boolean m219a() {
        return TextUtils.equals(this.f249a, cg.m225a());
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f248a < this.f8793b;
    }

    boolean c() {
        long j2 = this.f8793b;
        if (864000000 >= j2) {
            j2 = 864000000;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = this.f248a;
        return jCurrentTimeMillis - j3 > j2 || (jCurrentTimeMillis - j3 > this.f8793b && this.f249a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f249a);
        sb.append("\n");
        sb.append(a());
        for (cj cjVar : this.f250a) {
            sb.append("\n");
            sb.append(cjVar.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    public boolean a(cc ccVar) {
        return TextUtils.equals(this.f249a, ccVar.f249a);
    }

    public void b(String str, long j2, long j3) {
        a(str, 0, j2, j3, null);
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.f8793b = j2;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j2);
    }

    public void b(String str, long j2, long j3, Exception exc) {
        a(str, -1, j2, j3, exc);
    }

    public void b(String str) {
        this.f8801j = str;
    }

    private synchronized void c(String str) {
        Iterator<cj> it = this.f250a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f267a, str)) {
                it.remove();
            }
        }
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f251b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    ce ceVarA = ce.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), ceVarA.m224a(), ceVarA.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public void a(String str, long j2, long j3) {
        try {
            b(new URL(str).getHost(), j2, j3);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j2, long j3, Exception exc) {
        try {
            b(new URL(str).getHost(), j2, j3, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, int i2, long j2, long j3, Exception exc) {
        a(str, new cb(i2, j2, j3, exc));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x001b, code lost:
    
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, cb cbVar) {
        Iterator<cj> it = this.f250a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            cj next = it.next();
            if (TextUtils.equals(str, next.f267a)) {
                break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized ArrayList<String> m216a() {
        return a(false);
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        cj[] cjVarArr = new cj[this.f250a.size()];
        this.f250a.toArray(cjVarArr);
        Arrays.sort(cjVarArr);
        arrayList = new ArrayList<>();
        for (cj cjVar : cjVarArr) {
            if (z) {
                arrayList.add(cjVar.f267a);
            } else {
                int iIndexOf = cjVar.f267a.indexOf(Constants.COLON_SEPARATOR);
                if (iIndexOf != -1) {
                    arrayList.add(cjVar.f267a.substring(0, iIndexOf));
                } else {
                    arrayList.add(cjVar.f267a);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m218a(String str) {
        a(new cj(str));
    }

    synchronized void a(cj cjVar) {
        c(cjVar.f267a);
        this.f250a.add(cjVar);
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.f250a.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 < length) {
                    if (TextUtils.equals(this.f250a.get(size).f267a, strArr[i2])) {
                        this.f250a.remove(size);
                        break;
                    }
                    i2++;
                }
            }
            size--;
        }
        int i3 = 0;
        for (cj cjVar : this.f250a) {
            if (cjVar.a > i3) {
                i3 = cjVar.a;
            }
        }
        while (i2 < strArr.length) {
            a(new cj(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.f8800i)) {
            return this.f8800i;
        }
        if (TextUtils.isEmpty(this.f8796e)) {
            return "hardcode_isp";
        }
        this.f8800i = bb.a(new String[]{this.f8796e, this.f8794c, this.f8795d, this.f8798g, this.f8797f}, d.c.a.b.a.a.s1);
        return this.f8800i;
    }

    public void a(double d2) {
        this.a = d2;
    }

    /* JADX INFO: renamed from: a */
    public synchronized JSONObject m217a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f249a);
        jSONObject.put(RemoteMessageConst.TTL, this.f8793b);
        jSONObject.put("pct", this.a);
        jSONObject.put("ts", this.f248a);
        jSONObject.put(UserInfo.CITY, this.f8795d);
        jSONObject.put("prv", this.f8794c);
        jSONObject.put("cty", this.f8798g);
        jSONObject.put("isp", this.f8796e);
        jSONObject.put("ip", this.f8797f);
        jSONObject.put(com.taobao.accs.common.Constants.KEY_HOST, this.f251b);
        jSONObject.put("xf", this.f8799h);
        JSONArray jSONArray = new JSONArray();
        Iterator<cj> it = this.f250a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized cc a(JSONObject jSONObject) {
        this.f249a = jSONObject.optString("net");
        this.f8793b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.a = jSONObject.getDouble("pct");
        this.f248a = jSONObject.getLong("ts");
        this.f8795d = jSONObject.optString(UserInfo.CITY);
        this.f8794c = jSONObject.optString("prv");
        this.f8798g = jSONObject.optString("cty");
        this.f8796e = jSONObject.optString("isp");
        this.f8797f = jSONObject.optString("ip");
        this.f251b = jSONObject.optString(com.taobao.accs.common.Constants.KEY_HOST);
        this.f8799h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new cj().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }
}
