package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
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
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, i> f9921a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    private static String f9922b = null;

    /* renamed from: c, reason: collision with root package name */
    private Context f9923c;

    /* renamed from: d, reason: collision with root package name */
    private String f9924d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f9925e = null;

    /* renamed from: f, reason: collision with root package name */
    private long f9926f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f9927g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9928h = true;

    private i(Context context, String str) {
        this.f9923c = null;
        this.f9924d = null;
        this.f9923c = context.getApplicationContext();
        this.f9924d = str;
        a();
        b();
    }

    private void b() {
        if (this.f9927g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f9927g = 1;
        final HashMap hashMap = new HashMap();
        hashMap.put("appid", this.f9924d);
        hashMap.put("status_os", Build.VERSION.RELEASE);
        hashMap.put("status_machine", f.a().c(g.a()));
        hashMap.put("status_version", Build.VERSION.SDK);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        hashMap.put("sdkp", "a");
        l.a(new Runnable() { // from class: com.tencent.open.utils.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.a.g a2 = com.tencent.open.a.f.a().a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", hashMap);
                    String a3 = a2.a();
                    SLog.i("openSDK_LOG.OpenConfig", "update: get config statusCode " + a2.d());
                    i.this.a(m.d(a3));
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.OpenConfig", "get config error ", e2);
                }
                i.this.f9927g = 0;
            }
        });
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f9924d != null) {
                    str2 = str + "." + this.f9924d;
                } else {
                    str2 = str;
                }
                open = this.f9923c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                open = this.f9923c.getAssets().open(str);
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

    private void d(String str) {
        if (this.f9928h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f9924d);
        }
    }

    public static i a(Context context, String str) {
        i iVar;
        synchronized (f9921a) {
            SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f9922b = str;
            }
            if (str == null) {
                str = f9922b != null ? f9922b : "0";
            }
            iVar = f9921a.get(str);
            if (iVar == null) {
                iVar = new i(context, str);
                f9921a.put(str, iVar);
            }
            SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return iVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.f9925e.opt(str);
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

    private void a() {
        try {
            this.f9925e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f9925e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f9924d != null) {
                str = str + "." + this.f9924d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f9923c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.f9925e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f9926f >= optInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f9925e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f9926f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f9925e.optInt(str);
    }
}
