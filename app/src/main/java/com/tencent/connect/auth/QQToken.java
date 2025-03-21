package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3260b;
import com.tencent.open.utils.C3283a;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g */
    private static SharedPreferences f10895g;

    /* renamed from: a */
    private String f10896a;

    /* renamed from: b */
    private String f10897b;

    /* renamed from: c */
    private String f10898c;

    /* renamed from: d */
    private int f10899d = 1;

    /* renamed from: e */
    private long f10900e = -1;

    /* renamed from: f */
    private C3283a f10901f;

    public QQToken(String str) {
        this.f10896a = str;
    }

    @TargetApi(11)
    /* renamed from: a */
    private static synchronized SharedPreferences m10187a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (f10895g == null) {
                f10895g = C3289g.m10603a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = f10895g;
        }
        return sharedPreferences;
    }

    @Deprecated
    /* renamed from: b */
    private static String m10191b(String str) {
        return Base64.encodeToString(C3295m.m10711j(str), 2);
    }

    @Deprecated
    /* renamed from: c */
    private static String m10192c(String str) {
        return Base64.encodeToString(C3295m.m10711j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.f10897b;
    }

    public String getAppId() {
        return this.f10896a;
    }

    public int getAuthSource() {
        return this.f10899d;
    }

    public long getExpireTimeInSecond() {
        return this.f10900e;
    }

    public String getOpenId() {
        return this.f10898c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.f10896a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.m10502i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.f10896a);
            } else {
                SLog.m10502i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.f10896a);
            }
        } catch (Exception e2) {
            SLog.m10502i("QQToken", "getLocalOpenIdByAppId " + e2.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.f10897b != null && System.currentTimeMillis() < this.f10900e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f10901f == null) {
                this.f10901f = new C3283a(C3289g.m10603a());
            }
            return m10189a(str, this.f10901f);
        } catch (Exception e2) {
            SLog.m10502i("QQToken", "login loadSession" + e2.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = m10187a().edit();
        edit.remove(m10192c(str));
        edit.remove(m10192c(str));
        edit.remove(m10188a(str));
        edit.apply();
        SLog.m10502i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f10901f == null) {
                this.f10901f = new C3283a(C3289g.m10603a());
            }
            return m10190a(this.f10896a, jSONObject, this.f10901f);
        } catch (Exception e2) {
            SLog.m10502i("QQToken", "login saveSession" + e2.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f10897b = str;
        this.f10900e = 0L;
        if (str2 != null) {
            this.f10900e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f10896a = str;
    }

    public void setAuthSource(int i2) {
        this.f10899d = i2;
    }

    public void setOpenId(String str) {
        this.f10898c = str;
        C3260b.m10440a().m10449a(str);
    }

    /* renamed from: a */
    private static synchronized JSONObject m10189a(String str, C3283a c3283a) {
        String m10579b;
        synchronized (QQToken.class) {
            if (C3289g.m10603a() == null) {
                SLog.m10502i("QQToken", "loadJsonPreference context null");
                return null;
            }
            if (str == null) {
                SLog.m10502i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            }
            String string = m10187a().getString(m10188a(str), "");
            if (TextUtils.isEmpty(string)) {
                if (!JniInterface.isJniOk) {
                    C3293k.m10639a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                    JniInterface.loadSo();
                }
                if (!JniInterface.isJniOk) {
                    SLog.m10502i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                    return null;
                }
                String m10192c = m10192c(str);
                String string2 = m10187a().getString(m10192c, "");
                try {
                    if (TextUtils.isEmpty(string2)) {
                        String m10191b = m10191b(str);
                        String string3 = m10187a().getString(m10191b, "");
                        try {
                            if (TextUtils.isEmpty(string3)) {
                                SLog.m10502i("QQToken", "loadJsonPreference oldDesValue null");
                                return null;
                            }
                            m10579b = JniInterface.m10723d1(string3);
                            if (TextUtils.isEmpty(m10579b)) {
                                SLog.m10502i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                return null;
                            }
                            m10190a(str, new JSONObject(m10579b), c3283a);
                        } catch (Exception e2) {
                            SLog.m10501e("QQToken", "Catch Exception", e2);
                            return null;
                        } finally {
                            m10187a().edit().remove(m10191b).apply();
                        }
                    } else {
                        m10579b = JniInterface.m10724d2(string2);
                        m10190a(str, new JSONObject(m10579b), c3283a);
                    }
                } catch (Exception e3) {
                    SLog.m10501e("QQToken", "Catch Exception", e3);
                    return null;
                } finally {
                    m10187a().edit().remove(m10192c).apply();
                }
            } else {
                m10579b = c3283a.m10579b(string);
            }
            try {
                JSONObject jSONObject = new JSONObject(m10579b);
                SLog.m10502i("QQToken", "loadJsonPreference sucess");
                return jSONObject;
            } catch (Exception e4) {
                SLog.m10502i("QQToken", "loadJsonPreference decode " + e4.toString());
                return null;
            }
        }
    }

    /* renamed from: a */
    private static synchronized boolean m10190a(String str, JSONObject jSONObject, C3283a c3283a) {
        synchronized (QQToken.class) {
            if (C3289g.m10603a() == null) {
                SLog.m10502i("QQToken", "saveJsonPreference context null");
                return false;
            }
            if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String m10188a = m10188a(str);
                        String m10578a = c3283a.m10578a(jSONObject.toString());
                        if (m10188a.length() > 6 && m10578a != null) {
                            m10187a().edit().putString(m10188a, m10578a).commit();
                            SLog.m10502i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.m10502i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.m10502i("QQToken", "expires is null");
                    return false;
                } catch (Exception e2) {
                    SLog.m10500e("QQToken", "saveJsonPreference exception:" + e2.toString());
                    return false;
                }
            }
            SLog.m10502i("QQToken", "saveJsonPreference prefKey or jsonObject null");
            return false;
        }
    }

    /* renamed from: a */
    private static String m10188a(String str) {
        return Base64.encodeToString(C3295m.m10711j(str), 2) + "_aes_google";
    }
}
