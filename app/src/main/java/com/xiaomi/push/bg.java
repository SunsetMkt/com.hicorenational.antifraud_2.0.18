package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bg extends JSONObject implements be {
    private static final int a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f8779b = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedHashMap<String, Integer> f208a = new LinkedHashMap<>();

    @Override // com.xiaomi.push.be
    public int a() {
        int iIntValue = a;
        Iterator<Integer> it = this.f208a.values().iterator();
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue + (length() - 1);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            this.f208a.put(str, Integer.valueOf(str.length() + String.valueOf(i2).length() + f8779b));
        }
        return super.put(str, i2);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        this.f208a.remove(str);
        return super.remove(str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j2) {
        if (!TextUtils.isEmpty(str)) {
            this.f208a.put(str, Integer.valueOf(str.length() + String.valueOf(j2).length() + f8779b));
        }
        return super.put(str, j2);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d2) {
        if (!TextUtils.isEmpty(str)) {
            this.f208a.put(str, Integer.valueOf(str.length() + String.valueOf(d2).length() + f8779b));
        }
        return super.put(str, d2);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) throws JSONException {
        JSONObject jSONObjectPut = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof be) {
                this.f208a.put(str, Integer.valueOf(str.length() + ((be) obj).a() + f8779b));
            } else {
                this.f208a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + f8779b + a));
            }
        }
        return jSONObjectPut;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f208a.put(str, Integer.valueOf(str.length() + String.valueOf(z).length() + f8779b));
        }
        return super.put(str, z);
    }
}
