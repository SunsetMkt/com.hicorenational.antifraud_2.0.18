package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.agconnect.config.impl.h */
/* loaded from: classes.dex */
public class C2255h implements AesDecrypt {

    /* renamed from: a */
    private final Context f6906a;

    /* renamed from: b */
    private final String f6907b;

    /* renamed from: c */
    private IDecrypt f6908c;

    public C2255h(Context context, String str) {
        this.f6906a = context;
        this.f6907b = str;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String str, String str2) {
        if (this.f6908c == null) {
            this.f6908c = decryptComponent();
        }
        if (this.f6908c == null) {
            this.f6908c = new C2254g(this.f6906a, this.f6907b).decryptComponent();
        }
        return this.f6908c.decrypt(C2259l.m6444a(this.f6906a, this.f6907b, "agc_plugin_", str), str2);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() {
        String m6444a = C2259l.m6444a(this.f6906a, this.f6907b, "agc_plugin_", "crypto_component");
        if (m6444a == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Hex.decodeHexString(m6444a), "utf-8"));
            return new C2253f(new C2251d(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e2) {
            String str = "FlexibleDecrypt exception: " + e2.getMessage();
            return null;
        }
    }
}
