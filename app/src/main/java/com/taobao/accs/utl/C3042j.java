package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.C2978a;
import com.umeng.p221ut.device.UTDevice;
import java.io.File;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.j */
/* loaded from: classes2.dex */
public class C3042j {

    /* renamed from: a */
    private static String f9743a = "";

    /* renamed from: b */
    private static String f9744b = "";

    /* renamed from: c */
    private static boolean f9745c = true;
    public static final String channelService = "com.taobao.accs.ChannelService";

    /* renamed from: d */
    private static boolean f9746d = false;
    public static final String msgService = "com.taobao.accs.data.MsgDistributeService";

    /* renamed from: a */
    public static boolean m9245a(Context context) {
        String str;
        if (f9746d) {
            return f9745c;
        }
        try {
            if (TextUtils.isEmpty(C2978a.f9402c)) {
                if (TextUtils.isEmpty(f9743a)) {
                    f9743a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
                }
                str = f9743a;
            } else {
                str = C2978a.f9402c;
            }
            if (TextUtils.isEmpty(f9744b)) {
                f9744b = m9243a(context, Process.myPid());
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f9744b)) {
                f9745c = str.equalsIgnoreCase(f9744b);
                f9746d = true;
            }
        } catch (Throwable th) {
            ALog.m9181e("AdapterUtilityImpl", "isMainProcess", th, new Object[0]);
        }
        return f9745c;
    }

    /* renamed from: b */
    public static String m9247b(Context context) {
        return UTDevice.getUtdid(context);
    }

    /* renamed from: c */
    public static String m9248c(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return String.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } catch (Throwable th) {
                ALog.m9181e("AdapterUtilityImpl", "Android above 7.0 isNotificationEnabled", th, new Object[0]);
            }
        } else {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i2 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                boolean z = true;
                if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i2), packageName)).intValue() != 0) {
                    z = false;
                }
                return String.valueOf(z);
            } catch (Throwable th2) {
                ALog.m9181e("AdapterUtilityImpl", "isNotificationEnabled", th2, new Object[0]);
            }
        }
        return "unknown";
    }

    /* renamed from: a */
    public static String m9243a(Context context, int i2) {
        IProcessName iProcessName = C2978a.f9404e;
        if (iProcessName != null) {
            return iProcessName.getCurrProcessName();
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : C2978a.m8976a(context).m8979a().getRunningAppProcesses()) {
            try {
                if (runningAppProcessInfo.pid == i2) {
                    str = runningAppProcessInfo.processName;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    /* renamed from: a */
    public static long m9242a() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1L;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return dataDirectory.getUsableSpace();
            }
            if (!dataDirectory.exists()) {
                return -1L;
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Throwable th) {
            ALog.m9181e("AdapterUtilityImpl", "getUsableSpace", th, new Object[0]);
            return -1L;
        }
    }

    /* renamed from: a */
    public static String m9244a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append("\n");
                }
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static boolean m9246a(String str, int i2) {
        if (str == null) {
            return false;
        }
        try {
            StatFs statFs = new StatFs(str);
            int blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            StringBuilder sb = new StringBuilder();
            sb.append("st.getAvailableBlocks()=");
            sb.append(statFs.getAvailableBlocks());
            sb.append(",st.getAvailableBlocks() * blockSize=");
            long j2 = blockSize;
            sb.append(statFs.getAvailableBlocks() * j2);
            ALog.m9180d("FileCheckUtils", sb.toString(), new Object[0]);
            return statFs.getAvailableBlocks() > 10 && availableBlocks * j2 > ((long) i2);
        } catch (Throwable unused) {
            return false;
        }
    }
}
