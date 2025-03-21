package anet.channel.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.monitor.C0796b;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import com.ta.utdid2.device.UTDevice;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Utils {
    private static final String TAG = "awcn.Utils";
    public static Context context;

    public static Context getAppContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        synchronized (Utils.class) {
            if (context != null) {
                return context;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                context = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Exception e2) {
                ALog.m717w(TAG, "getAppContext", null, e2, new Object[0]);
            }
            return context;
        }
    }

    public static String getDeviceId(Context context2) {
        return UTDevice.getUtdid(context2);
    }

    public static String getMainProcessName(Context context2) {
        if (context2 == null) {
            return "";
        }
        try {
            return context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).applicationInfo.processName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static float getNetworkTimeFactor() {
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        float f2 = (status == NetworkStatusHelper.NetworkStatus.G4 || status == NetworkStatusHelper.NetworkStatus.WIFI) ? 0.8f : 1.0f;
        return C0796b.m526a().m532b() == NetworkSpeed.Fast.getCode() ? f2 * 0.75f : f2;
    }

    public static String getProcessName(Context context2, int i2) {
        String str = "";
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context2.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i2) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            } else {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, ErrorConstant.formatMsg(ErrorConstant.ERROR_GET_PROCESS_NULL, "BuildVersion=" + String.valueOf(Build.VERSION.SDK_INT)), "rt"));
            }
        } catch (Exception e2) {
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, e2.toString(), "rt"));
        }
        return TextUtils.isEmpty(str) ? getProcessNameNew(i2) : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0087, code lost:
    
        r10 = r3[8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
    
        r7.close();
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
    
        anet.channel.util.ALog.m714e(anet.channel.util.Utils.TAG, "getProcessNameNew ", null, r0, new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getProcessNameNew(int r10) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.Utils.getProcessNameNew(int):java.lang.String");
    }

    public static String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + "\n");
                }
            }
        } catch (Exception e2) {
            ALog.m714e(TAG, "getStackMsg", null, e2, new Object[0]);
        }
        return stringBuffer.toString();
    }

    public static Object invokeStaticMethodThrowException(String str, String str2, Class<?>[] clsArr, Object... objArr) throws Exception {
        if (str == null || str2 == null) {
            return null;
        }
        Class<?> cls = Class.forName(str);
        Method declaredMethod = clsArr != null ? cls.getDeclaredMethod(str2, clsArr) : cls.getDeclaredMethod(str2, new Class[0]);
        if (declaredMethod == null) {
            return null;
        }
        declaredMethod.setAccessible(true);
        return objArr != null ? declaredMethod.invoke(cls, objArr) : declaredMethod.invoke(cls, new Object[0]);
    }
}
