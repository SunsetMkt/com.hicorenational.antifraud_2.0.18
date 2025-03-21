package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import com.tencent.connect.common.Constants;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushSelfShowMessage.java */
/* renamed from: com.huawei.hms.push.o */
/* loaded from: classes.dex */
public class C2495o {

    /* renamed from: B */
    private int f7757B;

    /* renamed from: D */
    private String f7759D;

    /* renamed from: b */
    private int f7763b;

    /* renamed from: c */
    private String f7764c;

    /* renamed from: d */
    private String f7765d;

    /* renamed from: l */
    private String f7773l;

    /* renamed from: m */
    private String f7774m;

    /* renamed from: n */
    private String f7775n;

    /* renamed from: o */
    private String f7776o;

    /* renamed from: p */
    private String f7777p;

    /* renamed from: r */
    private String f7779r;

    /* renamed from: s */
    private String f7780s;

    /* renamed from: z */
    private String f7787z;

    /* renamed from: a */
    private String f7762a = "";

    /* renamed from: e */
    private String f7766e = "";

    /* renamed from: f */
    private String f7767f = "";

    /* renamed from: g */
    private String f7768g = "";

    /* renamed from: h */
    private String f7769h = "";

    /* renamed from: i */
    private String f7770i = "";

    /* renamed from: j */
    private String f7771j = "";

    /* renamed from: k */
    private String f7772k = "";

    /* renamed from: q */
    private String f7778q = "";

    /* renamed from: t */
    private int f7781t = EnumC2491k.STYLE_DEFAULT.ordinal();

    /* renamed from: u */
    private String f7782u = "";

    /* renamed from: v */
    private String f7783v = "";

    /* renamed from: w */
    private String f7784w = "";

    /* renamed from: x */
    private int f7785x = 0;

    /* renamed from: y */
    private int f7786y = 0;

    /* renamed from: A */
    private String f7756A = "";

    /* renamed from: C */
    private String f7758C = "";

    /* renamed from: E */
    private String f7760E = "";

    /* renamed from: F */
    private String f7761F = "";

    public C2495o(byte[] bArr, byte[] bArr2) {
        Charset charset = C2493m.f7752a;
        this.f7779r = new String(bArr, charset);
        this.f7780s = new String(bArr2, charset);
    }

    /* renamed from: a */
    private JSONObject m7587a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.f7762a);
        jSONObject2.put("tag", this.f7756A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f7785x);
        jSONObject2.put(RemoteMessageConst.Notification.VISIBILITY, this.f7786y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.f7787z);
        return jSONObject2;
    }

    /* renamed from: b */
    private JSONObject m7589b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(AbstractC3059b.JSON_CMD, this.f7768g);
        jSONObject2.put("content", this.f7769h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f7770i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f7771j);
        jSONObject2.put("notifySummary", this.f7772k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    /* renamed from: c */
    private void m7590c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(string) || string.length() >= 48) {
                this.f7765d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i2 = 0; i2 < length; i2++) {
                sb.append("0");
            }
            sb.append(string);
            this.f7765d = sb.toString();
        }
    }

    /* renamed from: d */
    private boolean m7591d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f7774m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f7764c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f7773l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.m7712d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    /* renamed from: e */
    private boolean m7592e(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(RemoteMessageConst.MSGID)) {
            HMSLog.m7717i("PushSelfShowLog", "msgId == null");
            return false;
        }
        Object obj = jSONObject.get(RemoteMessageConst.MSGID);
        if (obj instanceof String) {
            this.f7766e = (String) obj;
            return true;
        }
        if (!(obj instanceof Integer)) {
            return true;
        }
        this.f7766e = String.valueOf(((Integer) obj).intValue());
        return true;
    }

    /* renamed from: f */
    private boolean m7593f(JSONObject jSONObject) {
        HMSLog.m7712d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.f7781t = jSONObject2.getInt("style");
            }
            this.f7782u = jSONObject2.optString("bigTitle");
            this.f7783v = jSONObject2.optString("bigContent");
            this.f7760E = jSONObject2.optString(RemoteMessageConst.Notification.ICON);
            return true;
        } catch (JSONException e2) {
            HMSLog.m7717i("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    /* renamed from: g */
    private void m7594g(JSONObject jSONObject) {
        this.f7762a = jSONObject.optString("group");
        HMSLog.m7712d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f7762a);
        this.f7785x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.m7712d("PushSelfShowLog", "autoCancel: " + this.f7785x);
        this.f7786y = jSONObject.optInt(RemoteMessageConst.Notification.VISIBILITY, 0);
        this.f7787z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.f7756A = jSONObject.optString("tag");
    }

    /* renamed from: h */
    private boolean m7595h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.f7763b = jSONObject2.getInt("autoClear");
            } else {
                this.f7763b = 0;
            }
            if (!Constants.JumpUrlConstants.SRC_TYPE_APP.equals(this.f7768g) && !"cosa".equals(this.f7768g)) {
                if ("url".equals(this.f7768g)) {
                    m7598k(jSONObject2);
                    return true;
                }
                if (!"rp".equals(this.f7768g)) {
                    return true;
                }
                m7597j(jSONObject2);
                return true;
            }
            m7591d(jSONObject2);
            return true;
        } catch (Exception e2) {
            HMSLog.m7716e("PushSelfShowLog", "ParseParam error ", e2);
            return false;
        }
    }

    /* renamed from: i */
    private boolean m7596i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f7768g = jSONObject2.getString(AbstractC3059b.JSON_CMD);
            this.f7769h = jSONObject2.optString("content");
            this.f7770i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f7771j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f7772k = jSONObject2.optString("notifySummary");
            this.f7759D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || m7593f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return m7595h(jSONObject2);
            }
        }
        return false;
    }

    /* renamed from: j */
    private boolean m7597j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f7773l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            HMSLog.m7712d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.f7776o = jSONObject.getString("rpl");
        this.f7777p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f7778q = jSONObject.getString("rpct");
        return true;
    }

    /* renamed from: k */
    private boolean m7598k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (!jSONObject.has("url")) {
            HMSLog.m7712d("PushSelfShowLog", "url is null");
            return false;
        }
        this.f7775n = jSONObject.getString("url");
        if (jSONObject.has("appPackageName")) {
            this.f7773l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            return true;
        }
        this.f7776o = jSONObject.getString("rpl");
        this.f7777p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f7778q = jSONObject.getString("rpct");
        return true;
    }

    /* renamed from: q */
    private JSONObject m7599q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.f7781t);
        jSONObject.put("bigTitle", this.f7782u);
        jSONObject.put("bigContent", this.f7783v);
        jSONObject.put("bigPic", this.f7784w);
        return jSONObject;
    }

    /* renamed from: u */
    private JSONObject m7600u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f7763b);
        jSONObject.put("url", this.f7775n);
        jSONObject.put("rpl", this.f7776o);
        jSONObject.put("rpt", this.f7777p);
        jSONObject.put("rpct", this.f7778q);
        jSONObject.put("appPackageName", this.f7773l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f7774m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f7764c);
        return jSONObject;
    }

    /* renamed from: l */
    public String m7613l() {
        return this.f7760E;
    }

    /* renamed from: m */
    public String m7614m() {
        return this.f7764c;
    }

    /* renamed from: n */
    public byte[] m7615n() {
        try {
            return m7587a(m7588a(m7589b(m7600u()), m7599q())).toString().getBytes(C2493m.f7752a);
        } catch (JSONException e2) {
            HMSLog.m7716e("PushSelfShowLog", "getMsgData failed JSONException:", e2);
            return new byte[0];
        }
    }

    /* renamed from: o */
    public String m7616o() {
        HMSLog.m7712d("PushSelfShowLog", "msgId =" + this.f7766e);
        return this.f7766e;
    }

    /* renamed from: p */
    public String m7617p() {
        return this.f7756A;
    }

    /* renamed from: r */
    public int m7618r() {
        return this.f7757B;
    }

    /* renamed from: s */
    public String m7619s() {
        return this.f7772k;
    }

    /* renamed from: t */
    public String m7620t() {
        return this.f7771j;
    }

    /* renamed from: v */
    public int m7621v() {
        return this.f7781t;
    }

    /* renamed from: w */
    public String m7622w() {
        return this.f7759D;
    }

    /* renamed from: x */
    public byte[] m7623x() {
        return this.f7780s.getBytes(C2493m.f7752a);
    }

    /* renamed from: y */
    public boolean m7624y() {
        try {
            if (TextUtils.isEmpty(this.f7779r)) {
                HMSLog.m7712d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f7779r);
            m7594g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!m7592e(jSONObject2)) {
                return false;
            }
            this.f7767f = jSONObject2.optString("dispPkgName");
            m7590c(jSONObject2);
            this.f7757B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.f7758C = jSONObject2.optString("data");
            this.f7761F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return m7596i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.m7712d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e2) {
            HMSLog.m7712d("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    /* renamed from: a */
    private JSONObject m7588a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f7767f);
        jSONObject3.put(RemoteMessageConst.MSGID, this.f7766e);
        jSONObject3.put("ap", this.f7765d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.f7757B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.f7759D);
        jSONObject3.put("data", this.f7758C);
        return jSONObject3;
    }

    /* renamed from: b */
    public String m7603b() {
        return this.f7761F;
    }

    /* renamed from: d */
    public int m7605d() {
        return this.f7785x;
    }

    /* renamed from: g */
    public String m7608g() {
        return this.f7782u;
    }

    /* renamed from: e */
    public int m7606e() {
        return this.f7763b;
    }

    /* renamed from: f */
    public String m7607f() {
        return this.f7783v;
    }

    /* renamed from: j */
    public String m7611j() {
        return this.f7767f;
    }

    /* renamed from: c */
    public String m7604c() {
        return this.f7773l;
    }

    /* renamed from: k */
    public String m7612k() {
        return this.f7762a;
    }

    /* renamed from: h */
    public String m7609h() {
        return this.f7768g;
    }

    /* renamed from: i */
    public String m7610i() {
        return this.f7769h;
    }

    /* renamed from: a */
    public String m7601a() {
        return this.f7774m;
    }

    /* renamed from: a */
    public void m7602a(int i2) {
        this.f7757B = i2;
    }
}
