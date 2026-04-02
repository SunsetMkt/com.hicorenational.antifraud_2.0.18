package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a implements NativeExceptionHandler {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f6329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f6331d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.a = context;
        this.f6329b = bVar;
        this.f6330c = aVar;
        this.f6331d = aVar2;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public void handleNativeException(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        an.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i2, i3, j2, j3, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:0|2|99|3|4|(1:6)(5:7|(1:9)|10|(1:12)(1:13)|14)|15|(3:17|(4:20|(2:22|(2:24|104)(2:25|102))(1:103)|26|18)|101)(1:27)|28|(1:33)(1:32)|34|(1:40)(1:39)|41|(1:56)(3:46|(2:47|(2:49|(2:106|51)(1:107))(2:105|52))|(1:54)(8:55|58|(1:60)|61|62|(4:68|98|69|(2:71|72)(11:73|74|96|75|(1:77)|78|(1:80)|81|(1:83)|84|109))(2:66|67)|92|(2:94|95)(1:108)))|57|58|(0)|61|62|(1:64)|68|98|69|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x029b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b6 A[Catch: all -> 0x029f, TryCatch #2 {all -> 0x029f, blocks: (B:3:0x0012, B:6:0x001e, B:15:0x0070, B:18:0x0078, B:20:0x007b, B:22:0x007f, B:24:0x009a, B:25:0x00a3, B:26:0x00ad, B:28:0x00b7, B:30:0x00c1, B:32:0x00c9, B:34:0x00d5, B:36:0x00df, B:39:0x00e6, B:41:0x00f5, B:43:0x0101, B:46:0x0108, B:47:0x011e, B:49:0x0124, B:51:0x0134, B:54:0x0154, B:58:0x0193, B:60:0x01b6, B:61:0x01bd, B:64:0x01c9, B:66:0x01d1, B:56:0x016f, B:40:0x00f1, B:27:0x00b0, B:9:0x0044, B:10:0x004a, B:12:0x0054), top: B:99:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0231 A[Catch: all -> 0x029b, TryCatch #1 {all -> 0x029b, blocks: (B:69:0x022b, B:71:0x0231, B:73:0x023a), top: B:98:0x022b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023a A[Catch: all -> 0x029b, TRY_LEAVE, TryCatch #1 {all -> 0x029b, blocks: (B:69:0x022b, B:71:0x0231, B:73:0x023a), top: B:98:0x022b }] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleNativeException2(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7, String[] strArr) {
        String strB;
        String str8;
        String str9;
        String str10;
        HashMap map;
        boolean z;
        String str11;
        String str12;
        String str13;
        String str14;
        CrashDetailBean crashDetailBeanPackageCrashDatas;
        String str15;
        boolean z2;
        an.a("Native Crash Happen v2", new Object[0]);
        try {
            strB = b.b(str3);
            if (i4 > 0) {
                str9 = str + "(" + str5 + ")";
                str8 = "UNKNOWN";
                str10 = "KERNEL";
            } else {
                String strA = i5 > 0 ? AppInfo.a(this.a, i5) : "UNKNOWN";
                str8 = strA.equals(String.valueOf(i5)) ? strA : strA + "(" + i5 + ")";
                str9 = str;
                str10 = str5;
            }
            map = new HashMap();
            if (strArr != null) {
                for (int i8 = 0; i8 < strArr.length; i8++) {
                    String str16 = strArr[i8];
                    if (str16 != null) {
                        an.a("Extra message[%d]: %s", Integer.valueOf(i8), str16);
                        String[] strArrSplit = str16.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (strArrSplit.length == 2) {
                            map.put(strArrSplit[0], strArrSplit[1]);
                        } else {
                            an.d("bad extraMsg %s", str16);
                        }
                    }
                }
            } else {
                an.c("not found extraMsg", new Object[0]);
            }
            String str17 = (String) map.get("HasPendingException");
            if (str17 == null || !str17.equals(b.a.u.a.f1908j)) {
                z = false;
            } else {
                an.a("Native crash happened with a Java pending exception.", new Object[0]);
                z = true;
            }
            String str18 = (String) map.get("ExceptionProcessName");
            if (str18 == null || str18.length() == 0) {
                str18 = this.f6330c.f6176e;
            } else {
                an.c("Name of crash process: %s", str18);
            }
            str11 = str18;
            str12 = (String) map.get("ExceptionThreadName");
        } catch (Throwable th) {
            th = th;
        }
        if (str12 == null || str12.length() == 0) {
            Thread threadCurrentThread = Thread.currentThread();
            str13 = threadCurrentThread.getName() + "(" + threadCurrentThread.getId() + ")";
        } else {
            an.c("Name of crash thread: %s", str12);
            Iterator<Thread> it = Thread.getAllStackTraces().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str15 = str12;
                    z2 = false;
                    break;
                }
                Thread next = it.next();
                if (next.getName().equals(str12)) {
                    str15 = str12 + "(" + next.getId() + ")";
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                str14 = str15;
                long j4 = (j2 * 1000) + (j3 / 1000);
                String str19 = (String) map.get("SysLogPath");
                String str20 = (String) map.get("JniLogPath");
                if (!this.f6331d.b()) {
                    an.d("no remote but still store!", new Object[0]);
                }
                if (this.f6331d.c().f6195g && this.f6331d.b()) {
                    an.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                    com.tencent.bugly.crashreport.crash.b.a("NATIVE_CRASH", aq.a(), str11, str14, str9 + "\n" + str2 + "\n" + strB, null);
                    aq.b(str4);
                    return;
                }
                String str21 = str9;
                crashDetailBeanPackageCrashDatas = packageCrashDatas(str11, str14, j4, str9, str2, strB, str10, str8, str4, str19, str20, str7, null, null, true, z);
                if (crashDetailBeanPackageCrashDatas != null) {
                    an.e("pkg crash datas fail!", new Object[0]);
                    return;
                }
                com.tencent.bugly.crashreport.crash.b.a("NATIVE_CRASH", aq.a(), str11, str14, str21 + "\n" + str2 + "\n" + strB, crashDetailBeanPackageCrashDatas);
                try {
                    boolean z3 = this.f6329b.a(crashDetailBeanPackageCrashDatas, i4) ? false : true;
                    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                    b.a(true, nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null);
                    if (z3) {
                        this.f6329b.a(crashDetailBeanPackageCrashDatas, 3000L, true);
                    }
                    this.f6329b.b(crashDetailBeanPackageCrashDatas);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (an.a(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
            str13 = str15 + "(" + i3 + ")";
        }
        str14 = str13;
        long j42 = (j2 * 1000) + (j3 / 1000);
        String str192 = (String) map.get("SysLogPath");
        String str202 = (String) map.get("JniLogPath");
        if (!this.f6331d.b()) {
        }
        if (this.f6331d.c().f6195g) {
        }
        String str212 = str9;
        crashDetailBeanPackageCrashDatas = packageCrashDatas(str11, str14, j42, str9, str2, strB, str10, str8, str4, str192, str202, str7, null, null, true, z);
        if (crashDetailBeanPackageCrashDatas != null) {
        }
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i2;
        String str12;
        int iIndexOf;
        boolean zL = c.a().l();
        if (zL) {
            an.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f6216b = 1;
        crashDetailBean.f6219e = this.f6330c.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f6330c;
        crashDetailBean.f6220f = aVar.p;
        crashDetailBean.f6221g = aVar.w();
        crashDetailBean.f6227m = this.f6330c.g();
        crashDetailBean.f6228n = str3;
        crashDetailBean.o = zL ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        crashDetailBean.q = str5 != null ? str5 : "";
        crashDetailBean.r = j2;
        crashDetailBean.u = aq.b(crashDetailBean.q.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.f6330c.y();
        crashDetailBean.f6222h = this.f6330c.v();
        crashDetailBean.f6223i = this.f6330c.J();
        crashDetailBean.v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String strA = b.a(dumpFilePath, str8);
        if (!aq.a(strA)) {
            crashDetailBean.V = strA;
        }
        crashDetailBean.W = b.c(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.f6267e, c.f6270h, c.f6275m);
        crashDetailBean.x = b.a(str10, c.f6267e, null, true);
        crashDetailBean.K = str7;
        crashDetailBean.L = str6;
        crashDetailBean.M = str11;
        crashDetailBean.F = this.f6330c.p();
        crashDetailBean.G = this.f6330c.o();
        crashDetailBean.H = this.f6330c.q();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.k();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = aq.a(this.a, c.f6267e, c.f6270h);
            }
            crashDetailBean.y = ap.a();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f6330c;
            crashDetailBean.N = aVar2.a;
            crashDetailBean.O = aVar2.a();
            crashDetailBean.Q = this.f6330c.H();
            crashDetailBean.R = this.f6330c.I();
            crashDetailBean.S = this.f6330c.B();
            crashDetailBean.T = this.f6330c.G();
            crashDetailBean.z = aq.a(c.f6268f, false);
            int iIndexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (iIndexOf2 > 0 && (i2 = iIndexOf2 + 6) < crashDetailBean.q.length()) {
                String str13 = crashDetailBean.q;
                String strSubstring = str13.substring(i2, str13.length() - 1);
                if (strSubstring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (iIndexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(strSubstring)) > 0) {
                    String strSubstring2 = str12.substring(iIndexOf);
                    crashDetailBean.z.put(crashDetailBean.B, strSubstring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i2);
                    crashDetailBean.q += strSubstring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f6330c.f6176e;
            }
            this.f6329b.c(crashDetailBean);
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.N = -1L;
            crashDetailBean.Q = -1;
            crashDetailBean.R = -1;
            crashDetailBean.S = map;
            crashDetailBean.T = this.f6330c.G();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }
}
