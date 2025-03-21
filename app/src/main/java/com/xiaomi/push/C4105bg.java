package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.bg */
/* loaded from: classes2.dex */
public class C4105bg extends JSONObject implements InterfaceC4103be {

    /* renamed from: a */
    private static final int f14619a = 2;

    /* renamed from: b */
    private static final int f14620b = 3;

    /* renamed from: a */
    private final LinkedHashMap<String, Integer> f14621a = new LinkedHashMap<>();

    @Override // com.xiaomi.push.InterfaceC4103be
    /* renamed from: a */
    public int mo13904a() {
        int i2 = f14619a;
        Iterator<Integer> it = this.f14621a.values().iterator();
        while (it.hasNext()) {
            i2 += it.next().intValue();
        }
        return i2 + (length() - 1);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            this.f14621a.put(str, Integer.valueOf(str.length() + String.valueOf(i2).length() + f14620b));
        }
        return super.put(str, i2);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        this.f14621a.remove(str);
        return super.remove(str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j2) {
        if (!TextUtils.isEmpty(str)) {
            this.f14621a.put(str, Integer.valueOf(str.length() + String.valueOf(j2).length() + f14620b));
        }
        return super.put(str, j2);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d2) {
        if (!TextUtils.isEmpty(str)) {
            this.f14621a.put(str, Integer.valueOf(str.length() + String.valueOf(d2).length() + f14620b));
        }
        return super.put(str, d2);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) {
        JSONObject put = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof InterfaceC4103be) {
                this.f14621a.put(str, Integer.valueOf(str.length() + ((InterfaceC4103be) obj).mo13904a() + f14620b));
            } else {
                this.f14621a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + f14620b + f14619a));
            }
        }
        return put;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f14621a.put(str, Integer.valueOf(str.length() + String.valueOf(z).length() + f14620b));
        }
        return super.put(str, z);
    }
}
