package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h implements AesDecrypt {
    private final Context a;

    /* JADX INFO: renamed from: b */
    private final String f4332b;

    /* JADX INFO: renamed from: c */
    private IDecrypt f4333c;

    public h(Context context, String str) {
        this.a = context;
        this.f4332b = str;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String str, String str2) {
        if (this.f4333c == null) {
            this.f4333c = decryptComponent();
        }
        if (this.f4333c == null) {
            this.f4333c = new g(this.a, this.f4332b).decryptComponent();
        }
        return this.f4333c.decrypt(l.a(this.a, this.f4332b, "agc_plugin_", str), str2);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() {
        String strA = l.a(this.a, this.f4332b, "agc_plugin_", "crypto_component");
        if (strA == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Hex.decodeHexString(strA), "utf-8"));
            return new f(new d(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e2) {
            String str = "FlexibleDecrypt exception: " + e2.getMessage();
            return null;
        }
    }
}
