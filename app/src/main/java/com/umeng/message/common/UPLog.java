package com.umeng.message.common;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import c.c.a.b.a.a;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.p;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UPLog {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f11136a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final p f11137b = new p();

    private static void a(int i2, String str, String str2) {
        if (str2 == null) {
            return;
        }
        while (str2.length() > 3072) {
            b(i2, str, str2.substring(0, 3072));
            str2 = str2.substring(3072);
        }
        if (str2.length() > 0) {
            b(i2, str, str2);
        }
    }

    private static void b(int i2, String str, String str2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                Log.println(i2, a(str), str2);
                break;
        }
    }

    public static void d(String str, Object... objArr) {
        if (isEnable()) {
            a(3, str, a(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (isEnable()) {
            a(6, str, a(objArr));
        }
        if (f11137b.a()) {
            f11137b.a(6, a(str), a(objArr));
        }
    }

    public static String getStackTrace(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void i(String str, Object... objArr) {
        if (isEnable()) {
            a(4, str, a(objArr));
        }
        if (f11137b.a()) {
            f11137b.a(4, a(str), a(objArr));
        }
    }

    public static boolean isEnable() {
        return f11136a;
    }

    public static void setEnable(boolean z) {
        f11136a = z;
    }

    public static void upload() {
        if (f.f11349b) {
            final p pVar = f11137b;
            if (pVar.f11386b) {
                return;
            }
            final p.b bVar = new p.b();
            b.b(new Runnable() { // from class: com.umeng.message.proguard.p.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    Application a2 = x.a();
                    if (UMUtils.isMainProgress(a2)) {
                        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a2);
                        String c2 = messageSharedPrefs.c();
                        if (TextUtils.isEmpty(c2)) {
                            UPLog.d("Log", "init skipped.");
                            return;
                        }
                        String k2 = messageSharedPrefs.k();
                        String e2 = d.e(a2);
                        if (TextUtils.isEmpty(k2) && TextUtils.isEmpty(e2)) {
                            UPLog.d("Log", "id skipped.");
                            return;
                        }
                        if (!messageSharedPrefs.a("l_u_q")) {
                            UPLog.d("Log", "req skipped.");
                            return;
                        }
                        JSONObject a3 = b.a(c2, k2, e2);
                        long j2 = 86400;
                        if (a3 != null) {
                            z = a3.optBoolean("enable");
                            j2 = Math.max(60L, a3.optLong(bh.aX, 86400L));
                        } else {
                            z = false;
                        }
                        boolean l2 = messageSharedPrefs.l();
                        messageSharedPrefs.f11128b.a("l_u_e", z);
                        messageSharedPrefs.a("l_u_q", j2);
                        if (z) {
                            com.umeng.message.proguard.b.a(new Runnable() { // from class: com.umeng.message.proguard.p.b.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        b bVar2 = b.this;
                                        Application a4 = x.a();
                                        File file = new File(a4.getFilesDir(), ".upush_log");
                                        File file2 = new File(file, new SimpleDateFormat("yyMMddHHmmssSSS", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())));
                                        try {
                                            bVar2.a(file, file2);
                                            if (file2.length() < 512) {
                                                UPLog.d("Log", "len small skipped! ", Long.valueOf(file2.length()));
                                                return;
                                            }
                                            if (file2.length() > 1048576) {
                                                UPLog.d("Log", "len large skipped! ", Long.valueOf(file2.length()));
                                                return;
                                            }
                                            String messageAppkey = PushAgent.getInstance(a4).getMessageAppkey();
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("appkey", messageAppkey);
                                            jSONObject.put("utdid", d.o(a4));
                                            jSONObject.put("umid", d.k(a4));
                                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(a4).getRegistrationId());
                                            jSONObject.put("md5", UMUtils.getFileMD5(file2));
                                            jSONObject.put("ts", System.currentTimeMillis());
                                            jSONObject.put("app_v", d.b(a4));
                                            jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                                            jSONObject.put("os_v", Build.VERSION.RELEASE);
                                            jSONObject.put("brand", d.f());
                                            jSONObject.put(Constants.KEY_MODEL, d.d());
                                            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, d.e(a4));
                                            jSONObject.put(bh.al, UMUtils.getZid(a4));
                                            jSONObject.put("os_i", Build.VERSION.SDK_INT);
                                            g.a(jSONObject, "https://offmsg.umeng.com/log/upload", messageAppkey, file2);
                                        } catch (Throwable th) {
                                            try {
                                                UPLog.d("Log", UPLog.getStackTrace(th));
                                            } finally {
                                                az.a(file2.getPath());
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        UPLog.d("Log", UPLog.getStackTrace(th2));
                                    }
                                }
                            }, l2 ? 0L : 1L, TimeUnit.MINUTES);
                        } else {
                            UPLog.d("Log", "enable skipped.");
                        }
                        pVar.f11385a = Boolean.valueOf(z);
                    }
                }
            });
            pVar.f11386b = true;
        }
    }

    public static void w(String str, Object... objArr) {
        if (isEnable()) {
            a(5, str, a(objArr));
        }
        if (f11137b.a()) {
            f11137b.a(5, a(str), a(objArr));
        }
    }

    public static void e(String str, Throwable th) {
        if (isEnable()) {
            e(str, th.getMessage() + "\n" + getStackTrace(th));
        }
    }

    public static void w(String str, Throwable th) {
        if (isEnable()) {
            w(str, th.getMessage() + "\n" + getStackTrace(th));
        }
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "UPush" : (str.startsWith("NAccs") || str.startsWith("awcn") || str.startsWith("anet")) ? str : "UPush.".concat(String.valueOf(str));
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(objArr[0]);
        for (int i2 = 1; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj != null) {
                sb.append(a.f3100g);
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
