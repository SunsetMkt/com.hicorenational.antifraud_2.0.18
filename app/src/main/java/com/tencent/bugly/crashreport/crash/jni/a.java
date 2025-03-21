package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a implements NativeExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9155a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f9156b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f9157c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f9158d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.f9155a = context;
        this.f9156b = bVar;
        this.f9157c = aVar;
        this.f9158d = aVar2;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public void handleNativeException(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        an.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i2, i3, j2, j3, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0124 A[Catch: all -> 0x029f, TryCatch #2 {all -> 0x029f, blocks: (B:3:0x0012, B:6:0x001e, B:7:0x0070, B:10:0x0078, B:12:0x007b, B:14:0x007f, B:16:0x009a, B:19:0x00a3, B:18:0x00ad, B:23:0x00b7, B:25:0x00c1, B:27:0x00c9, B:28:0x00d5, B:30:0x00df, B:33:0x00e6, B:34:0x00f5, B:36:0x0101, B:39:0x0108, B:40:0x011e, B:42:0x0124, B:45:0x0134, B:47:0x0154, B:49:0x0193, B:51:0x01b6, B:52:0x01bd, B:55:0x01c9, B:57:0x01d1, B:94:0x016f, B:95:0x00f1, B:97:0x00b0, B:100:0x0044, B:101:0x004a, B:103:0x0054), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0154 A[Catch: all -> 0x029f, TryCatch #2 {all -> 0x029f, blocks: (B:3:0x0012, B:6:0x001e, B:7:0x0070, B:10:0x0078, B:12:0x007b, B:14:0x007f, B:16:0x009a, B:19:0x00a3, B:18:0x00ad, B:23:0x00b7, B:25:0x00c1, B:27:0x00c9, B:28:0x00d5, B:30:0x00df, B:33:0x00e6, B:34:0x00f5, B:36:0x0101, B:39:0x0108, B:40:0x011e, B:42:0x0124, B:45:0x0134, B:47:0x0154, B:49:0x0193, B:51:0x01b6, B:52:0x01bd, B:55:0x01c9, B:57:0x01d1, B:94:0x016f, B:95:0x00f1, B:97:0x00b0, B:100:0x0044, B:101:0x004a, B:103:0x0054), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b6 A[Catch: all -> 0x029f, TryCatch #2 {all -> 0x029f, blocks: (B:3:0x0012, B:6:0x001e, B:7:0x0070, B:10:0x0078, B:12:0x007b, B:14:0x007f, B:16:0x009a, B:19:0x00a3, B:18:0x00ad, B:23:0x00b7, B:25:0x00c1, B:27:0x00c9, B:28:0x00d5, B:30:0x00df, B:33:0x00e6, B:34:0x00f5, B:36:0x0101, B:39:0x0108, B:40:0x011e, B:42:0x0124, B:45:0x0134, B:47:0x0154, B:49:0x0193, B:51:0x01b6, B:52:0x01bd, B:55:0x01c9, B:57:0x01d1, B:94:0x016f, B:95:0x00f1, B:97:0x00b0, B:100:0x0044, B:101:0x004a, B:103:0x0054), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c9 A[Catch: all -> 0x029f, TRY_ENTER, TryCatch #2 {all -> 0x029f, blocks: (B:3:0x0012, B:6:0x001e, B:7:0x0070, B:10:0x0078, B:12:0x007b, B:14:0x007f, B:16:0x009a, B:19:0x00a3, B:18:0x00ad, B:23:0x00b7, B:25:0x00c1, B:27:0x00c9, B:28:0x00d5, B:30:0x00df, B:33:0x00e6, B:34:0x00f5, B:36:0x0101, B:39:0x0108, B:40:0x011e, B:42:0x0124, B:45:0x0134, B:47:0x0154, B:49:0x0193, B:51:0x01b6, B:52:0x01bd, B:55:0x01c9, B:57:0x01d1, B:94:0x016f, B:95:0x00f1, B:97:0x00b0, B:100:0x0044, B:101:0x004a, B:103:0x0054), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0231 A[Catch: all -> 0x029b, TryCatch #1 {all -> 0x029b, blocks: (B:63:0x022b, B:65:0x0231, B:67:0x023a), top: B:62:0x022b }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x023a A[Catch: all -> 0x029b, TRY_LEAVE, TryCatch #1 {all -> 0x029b, blocks: (B:63:0x022b, B:65:0x0231, B:67:0x023a), top: B:62:0x022b }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0150 A[SYNTHETIC] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instructions count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i2;
        String str12;
        int indexOf;
        boolean l2 = c.a().l();
        if (l2) {
            an.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f9023b = 1;
        crashDetailBean.f9026e = this.f9157c.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f9157c;
        crashDetailBean.f9027f = aVar.p;
        crashDetailBean.f9028g = aVar.w();
        crashDetailBean.f9034m = this.f9157c.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = l2 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        crashDetailBean.q = str5 != null ? str5 : "";
        crashDetailBean.r = j2;
        crashDetailBean.u = aq.b(crashDetailBean.q.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.f9157c.y();
        crashDetailBean.f9029h = this.f9157c.v();
        crashDetailBean.f9030i = this.f9157c.J();
        crashDetailBean.v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a2 = b.a(dumpFilePath, str8);
        if (!aq.a(a2)) {
            crashDetailBean.V = a2;
        }
        crashDetailBean.W = b.c(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.f9084e, c.f9087h, c.f9092m);
        crashDetailBean.x = b.a(str10, c.f9084e, null, true);
        crashDetailBean.K = str7;
        crashDetailBean.L = str6;
        crashDetailBean.M = str11;
        crashDetailBean.F = this.f9157c.p();
        crashDetailBean.G = this.f9157c.o();
        crashDetailBean.H = this.f9157c.q();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.k();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = aq.a(this.f9155a, c.f9084e, c.f9087h);
            }
            crashDetailBean.y = ap.a();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f9157c;
            crashDetailBean.N = aVar2.f8974a;
            crashDetailBean.O = aVar2.a();
            crashDetailBean.Q = this.f9157c.H();
            crashDetailBean.R = this.f9157c.I();
            crashDetailBean.S = this.f9157c.B();
            crashDetailBean.T = this.f9157c.G();
            crashDetailBean.z = aq.a(c.f9085f, false);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i2 = indexOf2 + 6) < crashDetailBean.q.length()) {
                String str13 = crashDetailBean.q;
                String substring = str13.substring(i2, str13.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i2);
                    crashDetailBean.q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f9157c.f8978e;
            }
            this.f9156b.c(crashDetailBean);
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
            crashDetailBean.T = this.f9157c.G();
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
