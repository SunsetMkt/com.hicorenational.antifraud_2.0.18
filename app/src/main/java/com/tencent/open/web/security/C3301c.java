package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.C3258b;
import com.tencent.open.log.SLog;
import com.tencent.open.p213c.C3271d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.web.security.c */
/* loaded from: classes2.dex */
public class C3301c extends C3258b.a {

    /* renamed from: d */
    private String f11339d;

    public C3301c(WebView webView, long j2, String str, String str2) {
        super(webView, j2, str);
        this.f11339d = str2;
    }

    /* renamed from: b */
    private void m10725b(String str) {
        WebView webView = this.f11163a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f11339d);
            stringBuffer.append("){");
            stringBuffer.append(this.f11339d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            SLog.m10506v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.C3258b.a
    /* renamed from: a */
    public void mo10438a(Object obj) {
        SLog.m10506v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.C3258b.a
    /* renamed from: a */
    public void mo10437a() {
        SLog.m10498d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.C3258b.a
    /* renamed from: a */
    public void mo10439a(String str) {
        SLog.m10506v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !C3271d.f11207a ? -4 : 0);
            jSONObject.put("sn", this.f11164b);
            jSONObject.put("data", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        m10725b(jSONObject.toString());
    }
}
