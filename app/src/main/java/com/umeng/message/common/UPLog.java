package com.umeng.message.common;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
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
import d.c.a.b.a.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UPLog {
    private static boolean a = false;

    /* JADX INFO: renamed from: b */
    private static final p f7882b = new p();

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
        if (f7882b.a()) {
            f7882b.a(6, a(str), a(objArr));
        }
    }

    public static String getStackTrace(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void i(String str, Object... objArr) {
        if (isEnable()) {
            a(4, str, a(objArr));
        }
        if (f7882b.a()) {
            f7882b.a(4, a(str), a(objArr));
        }
    }

    public static boolean isEnable() {
        return a;
    }

    public static void setEnable(boolean z) {
        a = z;
    }

    public static void upload() {
        if (f.f8036b) {
            p pVar = f7882b;
            if (pVar.f8060b) {
                return;
            }
            b.b(new Runnable() { // from class: com.umeng.message.proguard.p.b.1
                final /* synthetic */ p a;

                /* JADX INFO: renamed from: com.umeng.message.proguard.p$b$1$1 */
                final class RunnableC01411 implements Runnable {
                    RunnableC01411() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b bVar = b.this;
                            Application applicationA = x.a();
                            File file = new File(applicationA.getFilesDir(), ".upush_log");
                            File file2 = new File(file, new SimpleDateFormat("yyMMddHHmmssSSS", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())));
                            try {
                                bVar.a(file, file2);
                                if (file2.length() < 512) {
                                    UPLog.d("Log", "len small skipped! ", Long.valueOf(file2.length()));
                                    return;
                                }
                                if (file2.length() > 1048576) {
                                    UPLog.d("Log", "len large skipped! ", Long.valueOf(file2.length()));
                                    return;
                                }
                                String messageAppkey = PushAgent.getInstance(applicationA).getMessageAppkey();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("appkey", messageAppkey);
                                jSONObject.put("utdid", d.o(applicationA));
                                jSONObject.put("umid", d.k(applicationA));
                                jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(applicationA).getRegistrationId());
                                jSONObject.put("md5", UMUtils.getFileMD5(file2));
                                jSONObject.put("ts", System.currentTimeMillis());
                                jSONObject.put("app_v", d.b(applicationA));
                                jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                                jSONObject.put("os_v", Build.VERSION.RELEASE);
                                jSONObject.put("brand", d.f());
                                jSONObject.put(Constants.KEY_MODEL, d.d());
                                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, d.e(applicationA));
                                jSONObject.put(bh.al, UMUtils.getZid(applicationA));
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
                }

                public AnonymousClass1(p pVar2) {
                    pVar = pVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    boolean zOptBoolean;
                    Application applicationA = x.a();
                    if (UMUtils.isMainProgress(applicationA)) {
                        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(applicationA);
                        String strC = messageSharedPrefs.c();
                        if (TextUtils.isEmpty(strC)) {
                            UPLog.d("Log", "init skipped.");
                            return;
                        }
                        String strK = messageSharedPrefs.k();
                        String strE = d.e(applicationA);
                        if (TextUtils.isEmpty(strK) && TextUtils.isEmpty(strE)) {
                            UPLog.d("Log", "id skipped.");
                            return;
                        }
                        if (!messageSharedPrefs.a("l_u_q")) {
                            UPLog.d("Log", "req skipped.");
                            return;
                        }
                        JSONObject jSONObjectA = b.a(strC, strK, strE);
                        long jMax = 86400;
                        if (jSONObjectA != null) {
                            zOptBoolean = jSONObjectA.optBoolean("enable");
                            jMax = Math.max(60L, jSONObjectA.optLong(bh.aX, 86400L));
                        } else {
                            zOptBoolean = false;
                        }
                        boolean zL = messageSharedPrefs.l();
                        messageSharedPrefs.f7878b.a("l_u_e", zOptBoolean);
                        messageSharedPrefs.a("l_u_q", jMax);
                        if (zOptBoolean) {
                            com.umeng.message.proguard.b.a(new Runnable() { // from class: com.umeng.message.proguard.p.b.1.1
                                RunnableC01411() {
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        b bVar = b.this;
                                        Application applicationA2 = x.a();
                                        File file = new File(applicationA2.getFilesDir(), ".upush_log");
                                        File file2 = new File(file, new SimpleDateFormat("yyMMddHHmmssSSS", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())));
                                        try {
                                            bVar.a(file, file2);
                                            if (file2.length() < 512) {
                                                UPLog.d("Log", "len small skipped! ", Long.valueOf(file2.length()));
                                                return;
                                            }
                                            if (file2.length() > 1048576) {
                                                UPLog.d("Log", "len large skipped! ", Long.valueOf(file2.length()));
                                                return;
                                            }
                                            String messageAppkey = PushAgent.getInstance(applicationA2).getMessageAppkey();
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("appkey", messageAppkey);
                                            jSONObject.put("utdid", d.o(applicationA2));
                                            jSONObject.put("umid", d.k(applicationA2));
                                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(applicationA2).getRegistrationId());
                                            jSONObject.put("md5", UMUtils.getFileMD5(file2));
                                            jSONObject.put("ts", System.currentTimeMillis());
                                            jSONObject.put("app_v", d.b(applicationA2));
                                            jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                                            jSONObject.put("os_v", Build.VERSION.RELEASE);
                                            jSONObject.put("brand", d.f());
                                            jSONObject.put(Constants.KEY_MODEL, d.d());
                                            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, d.e(applicationA2));
                                            jSONObject.put(bh.al, UMUtils.getZid(applicationA2));
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
                            }, zL ? 0L : 1L, TimeUnit.MINUTES);
                        } else {
                            UPLog.d("Log", "enable skipped.");
                        }
                        pVar.a = Boolean.valueOf(zOptBoolean);
                    }
                }
            });
            pVar2.f8060b = true;
        }
    }

    public static void w(String str, Object... objArr) {
        if (isEnable()) {
            a(5, str, a(objArr));
        }
        if (f7882b.a()) {
            f7882b.a(5, a(str), a(objArr));
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
                sb.append(a.f10074g);
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
