package com.umeng.socialize.net.verify;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class VerifyResponse extends SocializeReseponse {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8363b;

    public VerifyResponse(Integer num, JSONObject jSONObject) {
        super(null);
        this.a = num.intValue();
        this.f8363b = false;
        parseJsonObject(jSONObject);
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isHttpOK() {
        return this.a == 200;
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isOk() {
        return this.f8363b;
    }

    public void parseJsonObject(JSONObject jSONObject) {
        try {
            if (jSONObject.getString("result").startsWith("success")) {
                this.f8363b = true;
            } else {
                this.f8363b = false;
            }
        } catch (JSONException e2) {
            SLog.error(UmengText.NET.PARSEERROR, e2);
        }
    }
}
