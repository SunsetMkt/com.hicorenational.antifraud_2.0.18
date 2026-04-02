package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.umeng.analytics.pro.bh;
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

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static Map<String, i> a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f6914b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f6917e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6918f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6919g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6920h = true;

    private i(Context context, String str) {
        this.f6915c = null;
        this.f6916d = null;
        this.f6915c = context.getApplicationContext();
        this.f6916d = str;
        a();
        b();
    }

    private void b() {
        if (this.f6919g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f6919g = 1;
        final HashMap map = new HashMap();
        map.put("appid", this.f6916d);
        map.put("status_os", Build.VERSION.RELEASE);
        map.put("status_machine", f.a().c(g.a()));
        map.put("status_version", Build.VERSION.SDK);
        map.put(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        map.put("sdkp", bh.ay);
        l.a(new Runnable() { // from class: com.tencent.open.utils.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.a.g gVarA = com.tencent.open.a.f.a().a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", map);
                    String strA = gVarA.a();
                    SLog.i("openSDK_LOG.OpenConfig", "update: get config statusCode " + gVarA.d());
                    i.this.a(m.d(strA));
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.OpenConfig", "get config error ", e2);
                }
                i.this.f6919g = 0;
            }
        });
    }

    private String c(String str) {
        InputStream inputStreamOpen;
        String str2;
        String string = "";
        try {
            try {
                if (this.f6916d != null) {
                    str2 = str + "." + this.f6916d;
                } else {
                    str2 = str;
                }
                inputStreamOpen = this.f6915c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                inputStreamOpen = this.f6915c.getAssets().open(str);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charset.forName("UTF-8")));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            stringBuffer.append(line);
                        } catch (Throwable th) {
                            try {
                                inputStreamOpen.close();
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        inputStreamOpen.close();
                        bufferedReader.close();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return string;
            }
            string = stringBuffer.toString();
            inputStreamOpen.close();
            bufferedReader.close();
            return string;
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private void d(String str) {
        if (this.f6920h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f6916d);
        }
    }

    public static i a(Context context, String str) {
        i iVar;
        synchronized (a) {
            SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f6914b = str;
            }
            if (str == null) {
                str = f6914b != null ? f6914b : "0";
            }
            iVar = a.get(str);
            if (iVar == null) {
                iVar = new i(context, str);
                a.put(str, iVar);
            }
            SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return iVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object objOpt = this.f6917e.opt(str);
        if (objOpt == null) {
            return false;
        }
        if (objOpt instanceof Integer) {
            return !objOpt.equals(0);
        }
        if (objOpt instanceof Boolean) {
            return ((Boolean) objOpt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.f6917e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f6917e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f6916d != null) {
                str = str + "." + this.f6916d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f6915c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        int iOptInt = this.f6917e.optInt("Common_frequency");
        if (iOptInt == 0) {
            iOptInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f6918f >= iOptInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f6917e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f6918f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f6917e.optInt(str);
    }
}
