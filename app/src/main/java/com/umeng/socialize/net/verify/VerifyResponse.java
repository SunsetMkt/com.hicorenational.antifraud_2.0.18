package com.umeng.socialize.net.verify;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class VerifyResponse extends SocializeReseponse {

    /* renamed from: a */
    private int f13765a;

    /* renamed from: b */
    private boolean f13766b;

    public VerifyResponse(Integer num, JSONObject jSONObject) {
        super(null);
        this.f13765a = num.intValue();
        this.f13766b = false;
        parseJsonObject(jSONObject);
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isHttpOK() {
        return this.f13765a == 200;
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isOk() {
        return this.f13766b;
    }

    public void parseJsonObject(JSONObject jSONObject) {
        try {
            if (jSONObject.getString("result").startsWith("success")) {
                this.f13766b = true;
            } else {
                this.f13766b = false;
            }
        } catch (JSONException e2) {
            SLog.error(UmengText.NET.PARSEERROR, e2);
        }
    }
}
