package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cj */
/* loaded from: classes2.dex */
class C4135cj implements Comparable<C4135cj> {

    /* renamed from: a */
    protected int f14739a;

    /* renamed from: a */
    private long f14740a;

    /* renamed from: a */
    String f14741a;

    /* renamed from: a */
    private final LinkedList<C4127cb> f14742a;

    public C4135cj() {
        this(null, 0);
    }

    /* renamed from: a */
    protected synchronized void m14112a(C4127cb c4127cb) {
        if (c4127cb != null) {
            this.f14742a.add(c4127cb);
            int m14028a = c4127cb.m14028a();
            if (m14028a > 0) {
                this.f14739a += c4127cb.m14028a();
            } else {
                int i2 = 0;
                for (int size = this.f14742a.size() - 1; size >= 0 && this.f14742a.get(size).m14028a() < 0; size--) {
                    i2++;
                }
                this.f14739a += m14028a * i2;
            }
            if (this.f14742a.size() > 30) {
                this.f14739a -= this.f14742a.remove().m14028a();
            }
        }
    }

    public String toString() {
        return this.f14741a + Constants.COLON_SEPARATOR + this.f14739a;
    }

    public C4135cj(String str) {
        this(str, 0);
    }

    public C4135cj(String str, int i2) {
        this.f14742a = new LinkedList<>();
        this.f14740a = 0L;
        this.f14741a = str;
        this.f14739a = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4135cj c4135cj) {
        if (c4135cj == null) {
            return 1;
        }
        return c4135cj.f14739a - this.f14739a;
    }

    /* renamed from: a */
    public synchronized JSONObject m14111a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f14740a);
        jSONObject.put("wt", this.f14739a);
        jSONObject.put(com.taobao.accs.common.Constants.KEY_HOST, this.f14741a);
        JSONArray jSONArray = new JSONArray();
        Iterator<C4127cb> it = this.f14742a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m14030a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public synchronized C4135cj m14110a(JSONObject jSONObject) {
        this.f14740a = jSONObject.getLong("tt");
        this.f14739a = jSONObject.getInt("wt");
        this.f14741a = jSONObject.getString(com.taobao.accs.common.Constants.KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f14742a.add(new C4127cb().m14029a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }
}
