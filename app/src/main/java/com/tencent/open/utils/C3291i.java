package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p211a.C3255f;
import com.tencent.open.p211a.InterfaceC3256g;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.i */
/* loaded from: classes2.dex */
public class C3291i {

    /* renamed from: a */
    private static Map<String, C3291i> f11306a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private static String f11307b = null;

    /* renamed from: c */
    private Context f11308c;

    /* renamed from: d */
    private String f11309d;

    /* renamed from: e */
    private JSONObject f11310e = null;

    /* renamed from: f */
    private long f11311f = 0;

    /* renamed from: g */
    private int f11312g = 0;

    /* renamed from: h */
    private boolean f11313h = true;

    private C3291i(Context context, String str) {
        this.f11308c = null;
        this.f11309d = null;
        this.f11308c = context.getApplicationContext();
        this.f11309d = str;
        m10616a();
        m10620b();
    }

    /* renamed from: b */
    private void m10620b() {
        if (this.f11312g != 0) {
            m10623d("update thread is running, return");
            return;
        }
        this.f11312g = 1;
        final HashMap hashMap = new HashMap();
        hashMap.put("appid", this.f11309d);
        hashMap.put("status_os", Build.VERSION.RELEASE);
        hashMap.put("status_machine", C3288f.m10596a().m10601c(C3289g.m10603a()));
        hashMap.put("status_version", Build.VERSION.SDK);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        hashMap.put("sdkp", "a");
        C3294l.m10654a(new Runnable() { // from class: com.tencent.open.utils.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InterfaceC3256g m10420a = C3255f.m10416a().m10420a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", hashMap);
                    String mo10410a = m10420a.mo10410a();
                    SLog.m10502i("openSDK_LOG.OpenConfig", "update: get config statusCode " + m10420a.mo10413d());
                    C3291i.this.m10619a(C3295m.m10696d(mo10410a));
                } catch (Exception e2) {
                    SLog.m10501e("openSDK_LOG.OpenConfig", "get config error ", e2);
                }
                C3291i.this.f11312g = 0;
            }
        });
    }

    /* renamed from: c */
    private String m10621c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f11309d != null) {
                    str2 = str + "." + this.f11309d;
                } else {
                    str2 = str;
                }
                open = this.f11308c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                open = this.f11308c.getAssets().open(str);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (Throwable th) {
                            try {
                                open.close();
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        open.close();
                        bufferedReader.close();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            str3 = stringBuffer.toString();
            open.close();
            bufferedReader.close();
            return str3;
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    /* renamed from: d */
    private void m10623d(String str) {
        if (this.f11313h) {
            SLog.m10506v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f11309d);
        }
    }

    /* renamed from: a */
    public static C3291i m10615a(Context context, String str) {
        C3291i c3291i;
        synchronized (f11306a) {
            SLog.m10506v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f11307b = str;
            }
            if (str == null) {
                str = f11307b != null ? f11307b : "0";
            }
            c3291i = f11306a.get(str);
            if (c3291i == null) {
                c3291i = new C3291i(context, str);
                f11306a.put(str, c3291i);
            }
            SLog.m10506v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return c3291i;
    }

    /* renamed from: b */
    public boolean m10625b(String str) {
        m10623d("get " + str);
        m10622c();
        Object opt = this.f11310e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    /* renamed from: a */
    private void m10616a() {
        try {
            this.f11310e = new JSONObject(m10621c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f11310e = new JSONObject();
        }
    }

    /* renamed from: a */
    private void m10618a(String str, String str2) {
        try {
            if (this.f11309d != null) {
                str = str + "." + this.f11309d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f11308c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m10622c() {
        int optInt = this.f11310e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f11311f >= optInt * 3600000) {
            m10620b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10619a(JSONObject jSONObject) {
        m10623d("cgi back, do update");
        this.f11310e = jSONObject;
        m10618a("com.tencent.open.config.json", jSONObject.toString());
        this.f11311f = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public int m10624a(String str) {
        m10623d("get " + str);
        m10622c();
        return this.f11310e.optInt(str);
    }
}
