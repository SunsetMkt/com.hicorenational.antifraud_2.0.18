package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class al implements Runnable {
    public int a;

    /* JADX INFO: renamed from: b */
    public int f6395b;

    /* JADX INFO: renamed from: c */
    protected int f6396c;

    /* JADX INFO: renamed from: d */
    protected long f6397d;

    /* JADX INFO: renamed from: e */
    protected long f6398e;

    /* JADX INFO: renamed from: f */
    protected boolean f6399f;

    /* JADX INFO: renamed from: g */
    private final Context f6400g;

    /* JADX INFO: renamed from: h */
    private final int f6401h;

    /* JADX INFO: renamed from: i */
    private final byte[] f6402i;

    /* JADX INFO: renamed from: j */
    private final com.tencent.bugly.crashreport.common.info.a f6403j;

    /* JADX INFO: renamed from: k */
    private final com.tencent.bugly.crashreport.common.strategy.a f6404k;

    /* JADX INFO: renamed from: l */
    private final ai f6405l;

    /* JADX INFO: renamed from: m */
    private final ak f6406m;

    /* JADX INFO: renamed from: n */
    private final int f6407n;
    private final aj o;
    private final aj p;
    private String q;
    private final String r;
    private final Map<String, String> s;
    private boolean t;

    public al(Context context, int i2, int i3, byte[] bArr, String str, String str2, aj ajVar, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, ajVar, z, 2, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    protected void a() {
        this.f6406m.a(this.f6407n, System.currentTimeMillis());
        aj ajVar = this.o;
        if (ajVar != null) {
            ajVar.a(this.f6401h);
        }
        aj ajVar2 = this.p;
        if (ajVar2 != null) {
            ajVar2.a(this.f6401h);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:224:0x02a8, code lost:
    
        com.tencent.bugly.proguard.an.c("[Upload] Received %d bytes", java.lang.Integer.valueOf(r2.length));
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02b8, code lost:
    
        if (r19.f6399f == false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x02bb, code lost:
    
        if (r2.length != 0) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02bd, code lost:
    
        r0 = r3.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x02c9, code lost:
    
        if (r0.hasNext() == false) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x02cb, code lost:
    
        r2 = r0.next();
        com.tencent.bugly.proguard.an.c("[Upload] HTTP headers from server: key = %s, value = %s", r2.getKey(), r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x02e5, code lost:
    
        a(null, false, 1, "response data from server is empty", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x02f0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02f1, code lost:
    
        r0 = r19.f6406m.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x02f7, code lost:
    
        if (r0 != null) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x02f9, code lost:
    
        a(null, false, 1, "failed to decrypt response from server", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0304, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0305, code lost:
    
        r2 = com.tencent.bugly.proguard.aq.b(r0, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0309, code lost:
    
        if (r2 != null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x030b, code lost:
    
        a(null, false, 1, "failed unzip(Gzip) response from server", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0316, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0317, code lost:
    
        r2 = com.tencent.bugly.proguard.ah.a(r2, r5, r19.f6399f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x031d, code lost:
    
        if (r2 != null) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x031f, code lost:
    
        a(null, false, 1, "failed to decode response package", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x032a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x032d, code lost:
    
        if (r19.f6399f == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x032f, code lost:
    
        r19.f6406m.a(r9, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0334, code lost:
    
        r3 = new java.lang.Object[2];
        r3[0] = java.lang.Integer.valueOf(r2.f6480b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0342, code lost:
    
        if (r2.f6481c != null) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0345, code lost:
    
        r1 = r2.f6481c.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0348, code lost:
    
        r3[1] = java.lang.Integer.valueOf(r1);
        com.tencent.bugly.proguard.an.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0359, code lost:
    
        if (a(r2, r19.f6403j, r19.f6404k) != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x035b, code lost:
    
        a(r2, false, 2, "failed to process response package", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0365, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0366, code lost:
    
        a(r2, true, 2, "successfully uploaded", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0370, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i2;
        long j2;
        int length = 0;
        try {
            this.f6396c = 0;
            this.f6397d = 0L;
            this.f6398e = 0L;
            byte[] bArrA = this.f6402i;
            if (com.tencent.bugly.crashreport.common.info.b.f(this.f6400g) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArrA != null && bArrA.length != 0) {
                an.c("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f6401h));
                if (this.f6400g != null && this.f6403j != null && this.f6404k != null && this.f6405l != null) {
                    StrategyBean strategyBeanC = this.f6404k.c();
                    if (strategyBeanC == null) {
                        a(null, false, 0, "illegal local strategy", 0);
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put("prodId", this.f6403j.f());
                    map.put("bundleId", this.f6403j.f6175d);
                    map.put("appVer", this.f6403j.p);
                    if (this.s != null) {
                        map.putAll(this.s);
                    }
                    if (this.f6399f) {
                        map.put(com.taobao.agoo.a.a.b.JSON_CMD, Integer.toString(this.f6401h));
                        map.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
                        map.put("sdkVer", this.f6403j.f6181j);
                        map.put("strategylastUpdateTime", Long.toString(strategyBeanC.p));
                        if (!this.f6406m.a(map)) {
                            a(null, false, 0, "failed to add security info to HTTP headers", 0);
                            return;
                        }
                        byte[] bArrA2 = aq.a(bArrA, 2);
                        if (bArrA2 == null) {
                            a(null, false, 0, "failed to zip request body", 0);
                            return;
                        }
                        bArrA = this.f6406m.a(bArrA2);
                        if (bArrA == null) {
                            a(null, false, 0, "failed to encrypt request body", 0);
                            return;
                        }
                    }
                    a();
                    String strA = this.q;
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = -1;
                    while (true) {
                        int i6 = i3 + 1;
                        if (i3 >= this.a) {
                            a(null, false, i4, "failed after many attempts", 0);
                            return;
                        }
                        if (i6 > 1) {
                            an.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i6));
                            aq.b(this.f6395b);
                            if (i6 == this.a) {
                                an.d("[Upload] Use the back-up url at the last time: %s", this.r);
                                strA = this.r;
                            }
                        }
                        an.c("[Upload] Send %d bytes", Integer.valueOf(bArrA.length));
                        if (this.f6399f) {
                            strA = a(strA);
                        }
                        an.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strA, Integer.valueOf(this.f6401h), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        byte[] bArrA3 = this.f6405l.a(strA, bArrA, this, map);
                        if (bArrA3 != null) {
                            Map<String, String> map2 = this.f6405l.f6375b;
                            if (!this.f6399f) {
                                i2 = i5;
                                break;
                            }
                            if (a(map2)) {
                                try {
                                    i2 = Integer.parseInt(map2.get(NotificationCompat.CATEGORY_STATUS));
                                } catch (Throwable unused) {
                                    j2 = 0;
                                }
                                try {
                                    an.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                    if (i2 != 0) {
                                        if (i2 != 2) {
                                            a(null, false, 1, "status of server is " + i2, i2);
                                            return;
                                        }
                                        if (this.f6397d + this.f6398e > 0) {
                                            this.f6406m.a(this.f6406m.a(this.t) + this.f6397d + this.f6398e, this.t);
                                        }
                                        this.f6406m.a(i2, (bi) null);
                                        an.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                        this.f6406m.a(this.f6407n, this.f6401h, this.f6402i, this.q, this.r, this.o, this.a, this.f6395b, true, this.s);
                                        return;
                                    }
                                } catch (Throwable unused2) {
                                    j2 = 0;
                                    i5 = i2;
                                    a(1, "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i5));
                                    i3 = i6;
                                    i4 = 1;
                                }
                            } else {
                                an.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                a(1, "[Upload] Failed to upload for no status header.");
                                if (map2 != null) {
                                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                                        an.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
                                    }
                                }
                                an.c("[Upload] Failed to upload for no status header.", new Object[0]);
                            }
                        } else {
                            a(1, "Failed to upload for no response!");
                        }
                        i3 = i6;
                        i4 = 1;
                    }
                }
                a(null, false, 0, "illegal access error", 0);
                return;
            }
            a(null, false, 0, "request package is empty!", 0);
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public al(Context context, int i2, int i3, byte[] bArr, String str, String str2, aj ajVar, boolean z, int i4, int i5, boolean z2, Map<String, String> map) {
        this.a = 2;
        this.f6395b = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        this.q = null;
        this.f6396c = 0;
        this.f6397d = 0L;
        this.f6398e = 0L;
        this.f6399f = true;
        this.t = false;
        this.f6400g = context;
        this.f6403j = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f6402i = bArr;
        this.f6404k = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f6405l = ai.a(context);
        this.f6406m = ak.a();
        this.f6407n = i2;
        this.q = str;
        this.r = str2;
        this.o = ajVar;
        this.p = this.f6406m.a;
        this.f6399f = z;
        this.f6401h = i3;
        if (i4 > 0) {
            this.a = i4;
        }
        if (i5 > 0) {
            this.f6395b = i5;
        }
        this.t = z2;
        this.s = map;
    }

    protected void a(int i2, String str) {
        an.e("[Upload] Failed to upload(%d): %s", Integer.valueOf(i2), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(bi biVar, boolean z, int i2, String str, int i3) {
        String strValueOf;
        int i4 = this.f6401h;
        if (i4 == 630) {
            strValueOf = CrashHianalyticsData.EVENT_ID_CRASH;
        } else if (i4 == 640) {
            strValueOf = "userinfo";
        } else if (i4 != 830) {
            if (i4 != 840) {
                strValueOf = String.valueOf(i4);
            }
        }
        if (z) {
            an.a("[Upload] Success: %s", strValueOf);
        } else {
            an.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i2), strValueOf, str);
            if (this.f6399f) {
                this.f6406m.a(i3, (bi) null);
            }
        }
        if (this.f6397d + this.f6398e > 0) {
            this.f6406m.a(this.f6406m.a(this.t) + this.f6397d + this.f6398e, this.t);
        }
        aj ajVar = this.o;
        if (ajVar != null) {
            ajVar.a(this.f6401h, biVar, this.f6397d, this.f6398e, z, str);
        }
        aj ajVar2 = this.p;
        if (ajVar2 != null) {
            ajVar2.a(this.f6401h, biVar, this.f6397d, this.f6398e, z, str);
        }
    }

    protected boolean a(bi biVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (biVar == null) {
            an.d("resp == null!", new Object[0]);
            return false;
        }
        byte b2 = biVar.a;
        if (b2 != 0) {
            an.e("resp result error %d", Byte.valueOf(b2));
            return false;
        }
        try {
            if (!aq.a(biVar.f6482d) && !com.tencent.bugly.crashreport.common.info.a.b().i().equals(biVar.f6482d)) {
                ae.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "gateway", biVar.f6482d.getBytes("UTF-8"), (ad) null, true);
                aVar.d(biVar.f6482d);
            }
            if (!aq.a(biVar.f6485g) && !com.tencent.bugly.crashreport.common.info.a.b().j().equals(biVar.f6485g)) {
                ae.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "device", biVar.f6485g.getBytes("UTF-8"), (ad) null, true);
                aVar.e(biVar.f6485g);
            }
        } catch (Throwable th) {
            an.a(th);
        }
        aVar.o = biVar.f6483e;
        int i2 = biVar.f6480b;
        if (i2 == 510) {
            byte[] bArr = biVar.f6481c;
            if (bArr == null) {
                an.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            bk bkVar = (bk) ah.a(bArr, bk.class);
            if (bkVar == null) {
                an.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(biVar.f6480b));
                return false;
            }
            aVar2.a(bkVar);
        }
        return true;
    }

    public void a(String str, long j2, String str2) {
        this.f6396c++;
        this.f6397d += j2;
    }

    public void a(long j2) {
        this.f6398e += j2;
    }

    private static String a(String str) {
        if (aq.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            an.a(th);
            return str;
        }
    }

    private static boolean a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            if (!map.containsKey(NotificationCompat.CATEGORY_STATUS)) {
                an.d("[Upload] Headers does not contain %s", NotificationCompat.CATEGORY_STATUS);
                return false;
            }
            if (!map.containsKey("Bugly-Version")) {
                an.d("[Upload] Headers does not contain %s", "Bugly-Version");
                return false;
            }
            String str = map.get("Bugly-Version");
            if (!str.contains("bugly")) {
                an.d("[Upload] Bugly version is not valid: %s", str);
                return false;
            }
            an.c("[Upload] Bugly version from headers is: %s", str);
            return true;
        }
        an.d("[Upload] Headers is empty.", new Object[0]);
        return false;
    }
}
