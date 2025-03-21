package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.crash.C3126b;
import com.tencent.bugly.crashreport.crash.C3127c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3153ap;
import com.tencent.bugly.proguard.C3154aq;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.jni.a */
/* loaded from: classes2.dex */
public class C3134a implements NativeExceptionHandler {

    /* renamed from: a */
    private final Context f10452a;

    /* renamed from: b */
    private final C3126b f10453b;

    /* renamed from: c */
    private final C3113a f10454c;

    /* renamed from: d */
    private final C3116a f10455d;

    public C3134a(Context context, C3113a c3113a, C3126b c3126b, C3116a c3116a) {
        this.f10452a = context;
        this.f10453b = c3126b;
        this.f10454c = c3113a;
        this.f10455d = c3116a;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public void handleNativeException(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        C3151an.m9915a("Native Crash Happen v1", new Object[0]);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C3134a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i2;
        String str12;
        int indexOf;
        boolean m9726l = C3127c.m9705a().m9726l();
        if (m9726l) {
            C3151an.m9923e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f10290b = 1;
        crashDetailBean.f10293e = this.f10454c.m9575h();
        C3113a c3113a = this.f10454c;
        crashDetailBean.f10294f = c3113a.f10208p;
        crashDetailBean.f10295g = c3113a.m9590w();
        crashDetailBean.f10301m = this.f10454c.m9573g();
        crashDetailBean.f10302n = str3;
        crashDetailBean.f10303o = m9726l ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f10304p = str4;
        crashDetailBean.f10305q = str5 != null ? str5 : "";
        crashDetailBean.f10306r = j2;
        crashDetailBean.f10309u = C3154aq.m9981b(crashDetailBean.f10305q.getBytes());
        crashDetailBean.f10266A = str;
        crashDetailBean.f10267B = str2;
        crashDetailBean.f10274I = this.f10454c.m9592y();
        crashDetailBean.f10296h = this.f10454c.m9589v();
        crashDetailBean.f10297i = this.f10454c.m9544J();
        crashDetailBean.f10310v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String m9783a = C3135b.m9783a(dumpFilePath, str8);
        if (!C3154aq.m9970a(m9783a)) {
            crashDetailBean.f10287V = m9783a;
        }
        crashDetailBean.f10288W = C3135b.m9788c(dumpFilePath);
        crashDetailBean.f10311w = C3135b.m9782a(str9, C3127c.f10364e, C3127c.f10367h, C3127c.f10372m);
        crashDetailBean.f10312x = C3135b.m9782a(str10, C3127c.f10364e, null, true);
        crashDetailBean.f10276K = str7;
        crashDetailBean.f10277L = str6;
        crashDetailBean.f10278M = str11;
        crashDetailBean.f10271F = this.f10454c.m9583p();
        crashDetailBean.f10272G = this.f10454c.m9582o();
        crashDetailBean.f10273H = this.f10454c.m9584q();
        if (z) {
            crashDetailBean.f10268C = C3114b.m9611i();
            crashDetailBean.f10269D = C3114b.m9607g();
            crashDetailBean.f10270E = C3114b.m9615k();
            if (crashDetailBean.f10311w == null) {
                crashDetailBean.f10311w = C3154aq.m9954a(this.f10452a, C3127c.f10364e, C3127c.f10367h);
            }
            crashDetailBean.f10313y = C3153ap.m9934a();
            C3113a c3113a2 = this.f10454c;
            crashDetailBean.f10279N = c3113a2.f10160a;
            crashDetailBean.f10280O = c3113a2.m9559a();
            crashDetailBean.f10282Q = this.f10454c.m9542H();
            crashDetailBean.f10283R = this.f10454c.m9543I();
            crashDetailBean.f10284S = this.f10454c.m9536B();
            crashDetailBean.f10285T = this.f10454c.m9541G();
            crashDetailBean.f10314z = C3154aq.m9962a(C3127c.f10365f, false);
            int indexOf2 = crashDetailBean.f10305q.indexOf("java:\n");
            if (indexOf2 > 0 && (i2 = indexOf2 + 6) < crashDetailBean.f10305q.length()) {
                String str13 = crashDetailBean.f10305q;
                String substring = str13.substring(i2, str13.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f10314z.containsKey(crashDetailBean.f10267B) && (indexOf = (str12 = crashDetailBean.f10314z.get(crashDetailBean.f10267B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f10314z.put(crashDetailBean.f10267B, substring2);
                    crashDetailBean.f10305q = crashDetailBean.f10305q.substring(0, i2);
                    crashDetailBean.f10305q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.f10266A = this.f10454c.f10197e;
            }
            this.f10453b.m9700c(crashDetailBean);
        } else {
            crashDetailBean.f10268C = -1L;
            crashDetailBean.f10269D = -1L;
            crashDetailBean.f10270E = -1L;
            if (crashDetailBean.f10311w == null) {
                crashDetailBean.f10311w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f10279N = -1L;
            crashDetailBean.f10282Q = -1;
            crashDetailBean.f10283R = -1;
            crashDetailBean.f10284S = map;
            crashDetailBean.f10285T = this.f10454c.m9541G();
            crashDetailBean.f10314z = null;
            if (str == null) {
                crashDetailBean.f10266A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f10313y = bArr;
            }
        }
        return crashDetailBean;
    }
}
