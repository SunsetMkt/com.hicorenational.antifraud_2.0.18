package com.xiaomi.push;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class cd {
    private String a;

    /* JADX INFO: renamed from: a */
    private final ArrayList<cc> f252a = new ArrayList<>();

    public cd(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    public synchronized void a(cc ccVar) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f252a.size()) {
                break;
            }
            if (this.f252a.get(i2).a(ccVar)) {
                this.f252a.set(i2, ccVar);
                break;
            }
            i2++;
        }
        if (i2 >= this.f252a.size()) {
            this.f252a.add(ccVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<cc> it = this.f252a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public cd() {
    }

    public synchronized cc a() {
        for (int size = this.f252a.size() - 1; size >= 0; size--) {
            cc ccVar = this.f252a.get(size);
            if (ccVar.m219a()) {
                cg.a().m230a(ccVar.a());
                return ccVar;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<cc> m221a() {
        return this.f252a;
    }

    public synchronized void a(boolean z) {
        for (int size = this.f252a.size() - 1; size >= 0; size--) {
            cc ccVar = this.f252a.get(size);
            if (z) {
                if (ccVar.c()) {
                    this.f252a.remove(size);
                }
            } else if (!ccVar.b()) {
                this.f252a.remove(size);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public String m220a() {
        return this.a;
    }

    /* JADX INFO: renamed from: a */
    public synchronized JSONObject m222a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(Constants.KEY_HOST, this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cc> it = this.f252a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m217a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized cd a(JSONObject jSONObject) {
        this.a = jSONObject.getString(Constants.KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f252a.add(new cc(this.a).a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }
}
