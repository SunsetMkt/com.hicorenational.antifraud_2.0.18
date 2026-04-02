package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class cj implements Comparable<cj> {
    protected int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedList<cb> f268a;

    public cj() {
        this(null, 0);
    }

    protected synchronized void a(cb cbVar) {
        if (cbVar != null) {
            this.f268a.add(cbVar);
            int iA = cbVar.a();
            if (iA > 0) {
                this.a += cbVar.a();
            } else {
                int i2 = 0;
                for (int size = this.f268a.size() - 1; size >= 0 && this.f268a.get(size).a() < 0; size--) {
                    i2++;
                }
                this.a += iA * i2;
            }
            if (this.f268a.size() > 30) {
                this.a -= this.f268a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f267a + Constants.COLON_SEPARATOR + this.a;
    }

    public cj(String str) {
        this(str, 0);
    }

    public cj(String str, int i2) {
        this.f268a = new LinkedList<>();
        this.f266a = 0L;
        this.f267a = str;
        this.a = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(cj cjVar) {
        if (cjVar == null) {
            return 1;
        }
        return cjVar.a - this.a;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f266a);
        jSONObject.put("wt", this.a);
        jSONObject.put(com.taobao.accs.common.Constants.KEY_HOST, this.f267a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cb> it = this.f268a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m215a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized cj a(JSONObject jSONObject) {
        this.f266a = jSONObject.getLong("tt");
        this.a = jSONObject.getInt("wt");
        this.f267a = jSONObject.getString(com.taobao.accs.common.Constants.KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f268a.add(new cb().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }
}
