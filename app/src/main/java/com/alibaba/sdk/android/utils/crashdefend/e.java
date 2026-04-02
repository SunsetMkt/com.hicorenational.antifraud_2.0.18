package com.alibaba.sdk.android.utils.crashdefend;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashDefendUtils.java */
/* JADX INFO: loaded from: classes.dex */
class e {
    static void a(Context context, a aVar, List<c> list) {
        if (context == null) {
            return;
        }
        synchronized (list) {
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (aVar != null) {
                        jSONObject.put("startSerialNumber", aVar.a);
                    }
                    if (list != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            for (c cVar : list) {
                                if (cVar != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("sdkId", cVar.f52a);
                                    jSONObject2.put("sdkVersion", cVar.f54b);
                                    jSONObject2.put("crashLimit", cVar.a);
                                    jSONObject2.put("crashCount", cVar.crashCount);
                                    jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, cVar.f2631b);
                                    jSONObject2.put("registerSerialNumber", cVar.f53b);
                                    jSONObject2.put("startSerialNumber", cVar.f50a);
                                    jSONObject2.put("restoreCount", cVar.f2632c);
                                    jSONArray.put(jSONObject2);
                                }
                            }
                            jSONObject.put("sdkList", jSONArray);
                        } catch (JSONException unused) {
                        }
                    }
                    String string = jSONObject.toString();
                    fileOutputStreamOpenFileOutput = m32a(context) ? context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info", 0) : context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info_" + a(context), 0);
                    fileOutputStreamOpenFileOutput.write(string.getBytes());
                } catch (IOException unused2) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused3) {
                        }
                    }
                } catch (Exception unused4) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private static String c(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e2) {
            String str = "getProcessNameByActivityThread error: " + e2;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0049 A[EXC_TOP_SPLITTER, PHI: r1
  0x0049: PHI (r1v5 java.io.FileInputStream) = 
  (r1v1 java.io.FileInputStream)
  (r1v2 java.io.FileInputStream)
  (r1v3 java.io.FileInputStream)
  (r1v14 java.io.FileInputStream)
 binds: [B:23:0x0050, B:25:0x0053, B:29:0x006b, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean m33a(Context context, a aVar, List<c> list) {
        if (context == null) {
            return false;
        }
        FileInputStream fileInputStreamOpenFileInput = null;
        StringBuilder sb = new StringBuilder();
        synchronized (list) {
            try {
                try {
                    fileInputStreamOpenFileInput = m32a(context) ? context.openFileInput("com_alibaba_aliyun_crash_defend_sdk_info") : context.openFileInput("com_alibaba_aliyun_crash_defend_sdk_info_" + a(context));
                    byte[] bArr = new byte[512];
                    while (true) {
                        int i2 = fileInputStreamOpenFileInput.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i2));
                    }
                } catch (FileNotFoundException e2) {
                    String str = "load sdk file fail:" + e2.getMessage();
                    if (fileInputStreamOpenFileInput != null) {
                    }
                } catch (IOException unused) {
                    if (fileInputStreamOpenFileInput != null) {
                    }
                } catch (Exception unused2) {
                    if (fileInputStreamOpenFileInput != null) {
                    }
                }
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused3) {
                    }
                }
                if (sb.length() == 0) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    aVar.a = jSONObject.optLong("startSerialNumber", 1L);
                    JSONArray jSONArray = jSONObject.getJSONArray("sdkList");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2 != null) {
                            c cVar = new c();
                            cVar.f52a = jSONObject2.optString("sdkId", "");
                            cVar.f54b = jSONObject2.optString("sdkVersion", "");
                            cVar.a = jSONObject2.optInt("crashLimit", -1);
                            cVar.crashCount = jSONObject2.optInt("crashCount", 0);
                            cVar.f2631b = jSONObject2.optInt(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, 0);
                            cVar.f53b = jSONObject2.optLong("registerSerialNumber", 0L);
                            cVar.f50a = jSONObject2.optLong("startSerialNumber", 0L);
                            cVar.f2632c = jSONObject2.optInt("restoreCount", 0);
                            if (!TextUtils.isEmpty(cVar.f52a)) {
                                list.add(cVar);
                            }
                        }
                    }
                } catch (JSONException | Exception unused4) {
                }
                return true;
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m32a(Context context) {
        return context.getPackageName().equalsIgnoreCase(a(context));
    }

    private static String a(Context context) throws Throwable {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        String strC = c(context);
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strA = a();
        return !TextUtils.isEmpty(strA) ? strA : b(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a() throws Throwable {
        BufferedReader bufferedReader;
        ?? MyPid = Process.myPid();
        String strTrim = null;
        strTrim = null;
        strTrim = null;
        strTrim = null;
        ?? r1 = 0;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            try {
                File file = new File("/proc/" + MyPid + "/cmdline");
                if (file.exists()) {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        strTrim = bufferedReader.readLine().trim();
                    } catch (Exception e3) {
                        e = e3;
                        String str = "getProcessNameByPid error: " + e;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return strTrim;
                    }
                } else {
                    bufferedReader = null;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                }
                throw th;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return strTrim;
        } catch (Throwable th2) {
            r1 = MyPid;
            th = th2;
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
