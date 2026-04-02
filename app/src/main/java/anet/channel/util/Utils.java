package anet.channel.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import com.ta.utdid2.device.UTDevice;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
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
                Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                context = (Context) objInvoke.getClass().getMethod("getApplication", new Class[0]).invoke(objInvoke, new Object[0]);
            } catch (Exception e2) {
                ALog.w(TAG, "getAppContext", null, e2, new Object[0]);
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
        return anet.channel.monitor.b.a().b() == NetworkSpeed.Fast.getCode() ? f2 * 0.75f : f2;
    }

    public static String getProcessName(Context context2, int i2) {
        String str = "";
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context2.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, ErrorConstant.formatMsg(ErrorConstant.ERROR_GET_PROCESS_NULL, "BuildVersion=" + String.valueOf(Build.VERSION.SDK_INT)), "rt"));
            } else {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (it.hasNext()) {
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == i2) {
                            str = next.processName;
                            break;
                        }
                    }
                }
            }
            break;
        } catch (Exception e2) {
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, e2.toString(), "rt"));
        }
        return TextUtils.isEmpty(str) ? getProcessNameNew(i2) : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x0087, code lost:
    
        r10 = r3[8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x008b, code lost:
    
        r7.close();
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0092, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0093, code lost:
    
        anet.channel.util.ALog.e(anet.channel.util.Utils.TAG, "getProcessNameNew ", null, r0, new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getProcessNameNew(int i2) throws Throwable {
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Process processExec;
        String str;
        String str2 = "ps  |  grep  " + i2;
        try {
            try {
                processExec = Runtime.getRuntime().exec("sh");
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                dataOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                dataOutputStream = null;
            }
            try {
                dataOutputStream2 = new DataOutputStream(processExec.getOutputStream());
            } catch (Exception e3) {
                e = e3;
                dataOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        ALog.e(TAG, "getProcessNameNew ", null, e4, new Object[0]);
                        throw th;
                    }
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw th;
            }
            try {
                dataOutputStream2.writeBytes(str2 + "  &\n");
                dataOutputStream2.flush();
                dataOutputStream2.writeBytes("exit\n");
                processExec.waitFor();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        try {
                            bufferedReader.close();
                            dataOutputStream2.close();
                            return "";
                        } catch (IOException e5) {
                            ALog.e(TAG, "getProcessNameNew ", null, e5, new Object[0]);
                            return "";
                        }
                    }
                    String[] strArrSplit = line.replaceAll("\\s+", "  ").split("  ");
                    if (strArrSplit.length >= 9 && !TextUtils.isEmpty(strArrSplit[1]) && strArrSplit[1].trim().equals(String.valueOf(i2))) {
                        break;
                    }
                }
                return str;
            } catch (Exception e6) {
                e = e6;
                ALog.e(TAG, "getProcessNameNew ", null, e, new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        ALog.e(TAG, "getProcessNameNew ", null, e7, new Object[0]);
                        return "";
                    }
                }
                if (dataOutputStream2 == null) {
                    return "";
                }
                dataOutputStream2.close();
                return "";
            }
        } catch (Throwable th3) {
            th = th3;
        }
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
            ALog.e(TAG, "getStackMsg", null, e2, new Object[0]);
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
