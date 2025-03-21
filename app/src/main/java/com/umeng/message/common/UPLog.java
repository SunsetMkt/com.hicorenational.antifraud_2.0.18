package com.umeng.message.common;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.C3578b;
import com.umeng.message.proguard.C3586f;
import com.umeng.message.proguard.C3596p;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes2.dex */
public class UPLog {

    /* renamed from: a */
    private static boolean f13051a = false;

    /* renamed from: b */
    private static final C3596p f13052b = new C3596p();

    /* renamed from: a */
    private static void m12140a(int i2, String str, String str2) {
        if (str2 == null) {
            return;
        }
        while (str2.length() > 3072) {
            m12141b(i2, str, str2.substring(0, 3072));
            str2 = str2.substring(3072);
        }
        if (str2.length() > 0) {
            m12141b(i2, str, str2);
        }
    }

    /* renamed from: b */
    private static void m12141b(int i2, String str, String str2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                Log.println(i2, m12138a(str), str2);
                break;
        }
    }

    /* renamed from: d */
    public static void m12142d(String str, Object... objArr) {
        if (isEnable()) {
            m12140a(3, str, m12139a(objArr));
        }
    }

    /* renamed from: e */
    public static void m12144e(String str, Object... objArr) {
        if (isEnable()) {
            m12140a(6, str, m12139a(objArr));
        }
        if (f13052b.m12424a()) {
            f13052b.m12423a(6, m12138a(str), m12139a(objArr));
        }
    }

    public static String getStackTrace(Throwable th) {
        return Log.getStackTraceString(th);
    }

    /* renamed from: i */
    public static void m12145i(String str, Object... objArr) {
        if (isEnable()) {
            m12140a(4, str, m12139a(objArr));
        }
        if (f13052b.m12424a()) {
            f13052b.m12423a(4, m12138a(str), m12139a(objArr));
        }
    }

    public static boolean isEnable() {
        return f13051a;
    }

    public static void setEnable(boolean z) {
        f13051a = z;
    }

    public static void upload() {
        if (C3586f.f13277b) {
            final C3596p c3596p = f13052b;
            if (c3596p.f13314b) {
                return;
            }
            final C3596p.b bVar = new C3596p.b();
            C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.p.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    Application m12460a = C3604x.m12460a();
                    if (UMUtils.isMainProgress(m12460a)) {
                        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
                        String m12122c = messageSharedPrefs.m12122c();
                        if (TextUtils.isEmpty(m12122c)) {
                            UPLog.m12142d("Log", "init skipped.");
                            return;
                        }
                        String m12131k = messageSharedPrefs.m12131k();
                        String m12355e = C3584d.m12355e(m12460a);
                        if (TextUtils.isEmpty(m12131k) && TextUtils.isEmpty(m12355e)) {
                            UPLog.m12142d("Log", "id skipped.");
                            return;
                        }
                        if (!messageSharedPrefs.m12119a("l_u_q")) {
                            UPLog.m12142d("Log", "req skipped.");
                            return;
                        }
                        JSONObject m12426a = b.m12426a(m12122c, m12131k, m12355e);
                        long j2 = 86400;
                        if (m12426a != null) {
                            z = m12426a.optBoolean("enable");
                            j2 = Math.max(60L, m12426a.optLong(C3351bh.f11599aX, 86400L));
                        } else {
                            z = false;
                        }
                        boolean m12132l = messageSharedPrefs.m12132l();
                        messageSharedPrefs.f13043b.m12287a("l_u_e", z);
                        messageSharedPrefs.m12114a("l_u_q", j2);
                        if (z) {
                            C3578b.m12321a(new Runnable() { // from class: com.umeng.message.proguard.p.b.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        b bVar2 = b.this;
                                        Application m12460a2 = C3604x.m12460a();
                                        File file = new File(m12460a2.getFilesDir(), ".upush_log");
                                        File file2 = new File(file, new SimpleDateFormat("yyMMddHHmmssSSS", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())));
                                        try {
                                            bVar2.m12428a(file, file2);
                                            if (file2.length() < 512) {
                                                UPLog.m12142d("Log", "len small skipped! ", Long.valueOf(file2.length()));
                                                return;
                                            }
                                            if (file2.length() > 1048576) {
                                                UPLog.m12142d("Log", "len large skipped! ", Long.valueOf(file2.length()));
                                                return;
                                            }
                                            String messageAppkey = PushAgent.getInstance(m12460a2).getMessageAppkey();
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("appkey", messageAppkey);
                                            jSONObject.put("utdid", C3584d.m12371o(m12460a2));
                                            jSONObject.put("umid", C3584d.m12367k(m12460a2));
                                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(m12460a2).getRegistrationId());
                                            jSONObject.put("md5", UMUtils.getFileMD5(file2));
                                            jSONObject.put("ts", System.currentTimeMillis());
                                            jSONObject.put("app_v", C3584d.m12349b(m12460a2));
                                            jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                                            jSONObject.put("os_v", Build.VERSION.RELEASE);
                                            jSONObject.put("brand", C3584d.m12356f());
                                            jSONObject.put(Constants.KEY_MODEL, C3584d.m12352d());
                                            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, C3584d.m12355e(m12460a2));
                                            jSONObject.put(C3351bh.f11613al, UMUtils.getZid(m12460a2));
                                            jSONObject.put("os_i", Build.VERSION.SDK_INT);
                                            C3587g.m12399a(jSONObject, "https://offmsg.umeng.com/log/upload", messageAppkey, file2);
                                        } catch (Throwable th) {
                                            try {
                                                UPLog.m12142d("Log", UPLog.getStackTrace(th));
                                            } finally {
                                                C3577az.m12319a(file2.getPath());
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        UPLog.m12142d("Log", UPLog.getStackTrace(th2));
                                    }
                                }
                            }, m12132l ? 0L : 1L, TimeUnit.MINUTES);
                        } else {
                            UPLog.m12142d("Log", "enable skipped.");
                        }
                        c3596p.f13313a = Boolean.valueOf(z);
                    }
                }
            });
            c3596p.f13314b = true;
        }
    }

    /* renamed from: w */
    public static void m12147w(String str, Object... objArr) {
        if (isEnable()) {
            m12140a(5, str, m12139a(objArr));
        }
        if (f13052b.m12424a()) {
            f13052b.m12423a(5, m12138a(str), m12139a(objArr));
        }
    }

    /* renamed from: e */
    public static void m12143e(String str, Throwable th) {
        if (isEnable()) {
            m12144e(str, th.getMessage() + "\n" + getStackTrace(th));
        }
    }

    /* renamed from: w */
    public static void m12146w(String str, Throwable th) {
        if (isEnable()) {
            m12147w(str, th.getMessage() + "\n" + getStackTrace(th));
        }
    }

    /* renamed from: a */
    private static String m12138a(String str) {
        return TextUtils.isEmpty(str) ? "UPush" : (str.startsWith("NAccs") || str.startsWith("awcn") || str.startsWith("anet")) ? str : "UPush.".concat(String.valueOf(str));
    }

    /* renamed from: a */
    private static String m12139a(Object... objArr) {
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
                sb.append(AbstractC1191a.f2568g);
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
