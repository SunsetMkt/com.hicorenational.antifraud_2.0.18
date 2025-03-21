package com.xiaomi.push;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cd */
/* loaded from: classes2.dex */
class C4129cd {

    /* renamed from: a */
    private String f14715a;

    /* renamed from: a */
    private final ArrayList<C4128cc> f14716a = new ArrayList<>();

    public C4129cd(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f14715a = str;
    }

    /* renamed from: a */
    public synchronized void m14059a(C4128cc c4128cc) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f14716a.size()) {
                break;
            }
            if (this.f14716a.get(i2).m14048a(c4128cc)) {
                this.f14716a.set(i2, c4128cc);
                break;
            }
            i2++;
        }
        if (i2 >= this.f14716a.size()) {
            this.f14716a.add(c4128cc);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14715a);
        sb.append("\n");
        Iterator<C4128cc> it = this.f14716a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public C4129cd() {
    }

    /* renamed from: a */
    public synchronized C4128cc m14054a() {
        for (int size = this.f14716a.size() - 1; size >= 0; size--) {
            C4128cc c4128cc = this.f14716a.get(size);
            if (c4128cc.m14047a()) {
                C4132cg.m14066a().m14081a(c4128cc.m14033a());
                return c4128cc;
            }
        }
        return null;
    }

    /* renamed from: a */
    public ArrayList<C4128cc> m14057a() {
        return this.f14716a;
    }

    /* renamed from: a */
    public synchronized void m14060a(boolean z) {
        for (int size = this.f14716a.size() - 1; size >= 0; size--) {
            C4128cc c4128cc = this.f14716a.get(size);
            if (z) {
                if (c4128cc.m14053c()) {
                    this.f14716a.remove(size);
                }
            } else if (!c4128cc.mo14052b()) {
                this.f14716a.remove(size);
            }
        }
    }

    /* renamed from: a */
    public String m14056a() {
        return this.f14715a;
    }

    /* renamed from: a */
    public synchronized JSONObject m14058a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(Constants.KEY_HOST, this.f14715a);
        JSONArray jSONArray = new JSONArray();
        Iterator<C4128cc> it = this.f14716a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m14037a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public synchronized C4129cd m14055a(JSONObject jSONObject) {
        this.f14715a = jSONObject.getString(Constants.KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f14716a.add(new C4128cc(this.f14715a).m14032a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }
}
