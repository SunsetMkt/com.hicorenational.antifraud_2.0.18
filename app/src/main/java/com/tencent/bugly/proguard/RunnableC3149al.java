package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.p208mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.al */
/* loaded from: classes2.dex */
public class RunnableC3149al implements Runnable {

    /* renamed from: a */
    public int f10546a;

    /* renamed from: b */
    public int f10547b;

    /* renamed from: c */
    protected int f10548c;

    /* renamed from: d */
    protected long f10549d;

    /* renamed from: e */
    protected long f10550e;

    /* renamed from: f */
    protected boolean f10551f;

    /* renamed from: g */
    private final Context f10552g;

    /* renamed from: h */
    private final int f10553h;

    /* renamed from: i */
    private final byte[] f10554i;

    /* renamed from: j */
    private final C3113a f10555j;

    /* renamed from: k */
    private final C3116a f10556k;

    /* renamed from: l */
    private final C3146ai f10557l;

    /* renamed from: m */
    private final C3148ak f10558m;

    /* renamed from: n */
    private final int f10559n;

    /* renamed from: o */
    private final InterfaceC3147aj f10560o;

    /* renamed from: p */
    private final InterfaceC3147aj f10561p;

    /* renamed from: q */
    private String f10562q;

    /* renamed from: r */
    private final String f10563r;

    /* renamed from: s */
    private final Map<String, String> f10564s;

    /* renamed from: t */
    private boolean f10565t;

    public RunnableC3149al(Context context, int i2, int i3, byte[] bArr, String str, String str2, InterfaceC3147aj interfaceC3147aj, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, interfaceC3147aj, z, 2, BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    /* renamed from: a */
    protected void m9900a() {
        this.f10558m.m9887a(this.f10559n, System.currentTimeMillis());
        InterfaceC3147aj interfaceC3147aj = this.f10560o;
        if (interfaceC3147aj != null) {
            interfaceC3147aj.mo9370a(this.f10553h);
        }
        InterfaceC3147aj interfaceC3147aj2 = this.f10561p;
        if (interfaceC3147aj2 != null) {
            interfaceC3147aj2.mo9370a(this.f10553h);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] m9861a;
        Map<String, String> map;
        int i2;
        long j2;
        int i3 = 0;
        try {
            this.f10548c = 0;
            this.f10549d = 0L;
            this.f10550e = 0L;
            byte[] bArr = this.f10554i;
            if (C3114b.m9606f(this.f10552g) == null) {
                m9903a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArr != null && bArr.length != 0) {
                C3151an.m9921c("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f10553h));
                if (this.f10552g != null && this.f10555j != null && this.f10556k != null && this.f10557l != null) {
                    StrategyBean m9644c = this.f10556k.m9644c();
                    if (m9644c == null) {
                        m9903a(null, false, 0, "illegal local strategy", 0);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("prodId", this.f10555j.m9571f());
                    hashMap.put("bundleId", this.f10555j.f10196d);
                    hashMap.put("appVer", this.f10555j.f10208p);
                    if (this.f10564s != null) {
                        hashMap.putAll(this.f10564s);
                    }
                    if (this.f10551f) {
                        hashMap.put(AbstractC3059b.JSON_CMD, Integer.toString(this.f10553h));
                        hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
                        hashMap.put("sdkVer", this.f10555j.f10202j);
                        hashMap.put("strategylastUpdateTime", Long.toString(m9644c.f10239p));
                        if (!this.f10558m.m9892a(hashMap)) {
                            m9903a(null, false, 0, "failed to add security info to HTTP headers", 0);
                            return;
                        }
                        byte[] m9975a = C3154aq.m9975a(bArr, 2);
                        if (m9975a == null) {
                            m9903a(null, false, 0, "failed to zip request body", 0);
                            return;
                        }
                        bArr = this.f10558m.m9893a(m9975a);
                        if (bArr == null) {
                            m9903a(null, false, 0, "failed to encrypt request body", 0);
                            return;
                        }
                    }
                    m9900a();
                    String str = this.f10562q;
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = -1;
                    while (true) {
                        int i7 = i4 + 1;
                        if (i4 >= this.f10546a) {
                            m9903a(null, false, i5, "failed after many attempts", 0);
                            return;
                        }
                        if (i7 > 1) {
                            C3151an.m9922d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i7));
                            C3154aq.m9983b(this.f10547b);
                            if (i7 == this.f10546a) {
                                C3151an.m9922d("[Upload] Use the back-up url at the last time: %s", this.f10563r);
                                str = this.f10563r;
                            }
                        }
                        C3151an.m9921c("[Upload] Send %d bytes", Integer.valueOf(bArr.length));
                        if (this.f10551f) {
                            str = m9898a(str);
                        }
                        C3151an.m9921c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str, Integer.valueOf(this.f10553h), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        m9861a = this.f10557l.m9861a(str, bArr, this, hashMap);
                        if (m9861a != null) {
                            map = this.f10557l.f10514b;
                            if (!this.f10551f) {
                                i2 = i6;
                                break;
                            }
                            if (m9899a(map)) {
                                try {
                                    i2 = Integer.parseInt(map.get(NotificationCompat.CATEGORY_STATUS));
                                } catch (Throwable unused) {
                                    j2 = 0;
                                }
                                try {
                                    C3151an.m9921c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                    if (i2 != 0) {
                                        if (i2 != 2) {
                                            m9903a(null, false, 1, "status of server is " + i2, i2);
                                            return;
                                        }
                                        if (this.f10549d + this.f10550e > 0) {
                                            this.f10558m.m9891a(this.f10558m.m9883a(this.f10565t) + this.f10549d + this.f10550e, this.f10565t);
                                        }
                                        this.f10558m.m9890a(i2, (C3173bi) null);
                                        C3151an.m9915a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                        this.f10558m.m9884a(this.f10559n, this.f10553h, this.f10554i, this.f10562q, this.f10563r, this.f10560o, this.f10546a, this.f10547b, true, this.f10564s);
                                        return;
                                    }
                                } catch (Throwable unused2) {
                                    j2 = 0;
                                    i6 = i2;
                                    m9901a(1, "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i6));
                                    i4 = i7;
                                    i5 = 1;
                                }
                            } else {
                                C3151an.m9921c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                m9901a(1, "[Upload] Failed to upload for no status header.");
                                if (map != null) {
                                    for (Map.Entry<String, String> entry : map.entrySet()) {
                                        C3151an.m9921c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
                                    }
                                }
                                C3151an.m9921c("[Upload] Failed to upload for no status header.", new Object[0]);
                            }
                        } else {
                            m9901a(1, "Failed to upload for no response!");
                        }
                        i4 = i7;
                        i5 = 1;
                    }
                    C3151an.m9921c("[Upload] Received %d bytes", Integer.valueOf(m9861a.length));
                    if (this.f10551f) {
                        if (m9861a.length == 0) {
                            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                                C3151an.m9921c("[Upload] HTTP headers from server: key = %s, value = %s", entry2.getKey(), entry2.getValue());
                            }
                            m9903a(null, false, 1, "response data from server is empty", 0);
                            return;
                        }
                        byte[] m9897b = this.f10558m.m9897b(m9861a);
                        if (m9897b == null) {
                            m9903a(null, false, 1, "failed to decrypt response from server", 0);
                            return;
                        }
                        m9861a = C3154aq.m9989b(m9897b, 2);
                        if (m9861a == null) {
                            m9903a(null, false, 1, "failed unzip(Gzip) response from server", 0);
                            return;
                        }
                    }
                    C3173bi m9850a = C3145ah.m9850a(m9861a, m9644c, this.f10551f);
                    if (m9850a == null) {
                        m9903a(null, false, 1, "failed to decode response package", 0);
                        return;
                    }
                    if (this.f10551f) {
                        this.f10558m.m9890a(i2, m9850a);
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(m9850a.f10688b);
                    if (m9850a.f10689c != null) {
                        i3 = m9850a.f10689c.length;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    C3151an.m9921c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                    if (m9905a(m9850a, this.f10555j, this.f10556k)) {
                        m9903a(m9850a, true, 2, "successfully uploaded", 0);
                        return;
                    } else {
                        m9903a(m9850a, false, 2, "failed to process response package", 0);
                        return;
                    }
                }
                m9903a(null, false, 0, "illegal access error", 0);
                return;
            }
            m9903a(null, false, 0, "request package is empty!", 0);
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public RunnableC3149al(Context context, int i2, int i3, byte[] bArr, String str, String str2, InterfaceC3147aj interfaceC3147aj, boolean z, int i4, int i5, boolean z2, Map<String, String> map) {
        this.f10546a = 2;
        this.f10547b = BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH;
        this.f10562q = null;
        this.f10548c = 0;
        this.f10549d = 0L;
        this.f10550e = 0L;
        this.f10551f = true;
        this.f10565t = false;
        this.f10552g = context;
        this.f10555j = C3113a.m9531a(context);
        this.f10554i = bArr;
        this.f10556k = C3116a.m9635a();
        this.f10557l = C3146ai.m9856a(context);
        this.f10558m = C3148ak.m9863a();
        this.f10559n = i2;
        this.f10562q = str;
        this.f10563r = str2;
        this.f10560o = interfaceC3147aj;
        this.f10561p = this.f10558m.f10516a;
        this.f10551f = z;
        this.f10553h = i3;
        if (i4 > 0) {
            this.f10546a = i4;
        }
        if (i5 > 0) {
            this.f10547b = i5;
        }
        this.f10565t = z2;
        this.f10564s = map;
    }

    /* renamed from: a */
    protected void m9901a(int i2, String str) {
        C3151an.m9923e("[Upload] Failed to upload(%d): %s", Integer.valueOf(i2), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m9903a(com.tencent.bugly.proguard.C3173bi r14, boolean r15, int r16, java.lang.String r17, int r18) {
        /*
            r13 = this;
            r0 = r13
            int r1 = r0.f10553h
            r2 = 630(0x276, float:8.83E-43)
            if (r1 == r2) goto L1b
            r2 = 640(0x280, float:8.97E-43)
            if (r1 == r2) goto L18
            r2 = 830(0x33e, float:1.163E-42)
            if (r1 == r2) goto L1b
            r2 = 840(0x348, float:1.177E-42)
            if (r1 == r2) goto L18
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L1d
        L18:
            java.lang.String r1 = "userinfo"
            goto L1d
        L1b:
            java.lang.String r1 = "crash"
        L1d:
            r2 = 1
            r3 = 0
            if (r15 == 0) goto L2b
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r1
            java.lang.String r1 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.C3151an.m9915a(r1, r2)
            goto L4a
        L2b:
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)
            r4[r3] = r5
            r4[r2] = r1
            r1 = 2
            r4[r1] = r17
            java.lang.String r1 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.C3151an.m9923e(r1, r4)
            boolean r1 = r0.f10551f
            if (r1 == 0) goto L4a
            com.tencent.bugly.proguard.ak r1 = r0.f10558m
            r2 = 0
            r3 = r18
            r1.m9890a(r3, r2)
        L4a:
            long r1 = r0.f10549d
            long r3 = r0.f10550e
            long r1 = r1 + r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L6a
            com.tencent.bugly.proguard.ak r1 = r0.f10558m
            boolean r2 = r0.f10565t
            long r1 = r1.m9883a(r2)
            long r3 = r0.f10549d
            long r1 = r1 + r3
            long r3 = r0.f10550e
            long r1 = r1 + r3
            com.tencent.bugly.proguard.ak r3 = r0.f10558m
            boolean r4 = r0.f10565t
            r3.m9891a(r1, r4)
        L6a:
            com.tencent.bugly.proguard.aj r4 = r0.f10560o
            if (r4 == 0) goto L7b
            int r5 = r0.f10553h
            long r7 = r0.f10549d
            long r9 = r0.f10550e
            r6 = r14
            r11 = r15
            r12 = r17
            r4.mo9371a(r5, r6, r7, r9, r11, r12)
        L7b:
            com.tencent.bugly.proguard.aj r4 = r0.f10561p
            if (r4 == 0) goto L8c
            int r5 = r0.f10553h
            long r7 = r0.f10549d
            long r9 = r0.f10550e
            r6 = r14
            r11 = r15
            r12 = r17
            r4.mo9371a(r5, r6, r7, r9, r11, r12)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC3149al.m9903a(com.tencent.bugly.proguard.bi, boolean, int, java.lang.String, int):void");
    }

    /* renamed from: a */
    protected boolean m9905a(C3173bi c3173bi, C3113a c3113a, C3116a c3116a) {
        if (c3173bi == null) {
            C3151an.m9922d("resp == null!", new Object[0]);
            return false;
        }
        byte b2 = c3173bi.f10687a;
        if (b2 != 0) {
            C3151an.m9923e("resp result error %d", Byte.valueOf(b2));
            return false;
        }
        try {
            if (!C3154aq.m9970a(c3173bi.f10690d) && !C3113a.m9532b().m9576i().equals(c3173bi.f10690d)) {
                C3142ae.m9817a().m9836a(C3116a.f10249a, "gateway", c3173bi.f10690d.getBytes("UTF-8"), (InterfaceC3141ad) null, true);
                c3113a.m9568d(c3173bi.f10690d);
            }
            if (!C3154aq.m9970a(c3173bi.f10693g) && !C3113a.m9532b().m9577j().equals(c3173bi.f10693g)) {
                C3142ae.m9817a().m9836a(C3116a.f10249a, "device", c3173bi.f10693g.getBytes("UTF-8"), (InterfaceC3141ad) null, true);
                c3113a.m9570e(c3173bi.f10693g);
            }
        } catch (Throwable th) {
            C3151an.m9916a(th);
        }
        c3113a.f10207o = c3173bi.f10691e;
        int i2 = c3173bi.f10688b;
        if (i2 == 510) {
            byte[] bArr = c3173bi.f10689c;
            if (bArr == null) {
                C3151an.m9923e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            C3175bk c3175bk = (C3175bk) C3145ah.m9853a(bArr, C3175bk.class);
            if (c3175bk == null) {
                C3151an.m9923e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(c3173bi.f10688b));
                return false;
            }
            c3116a.m9642a(c3175bk);
        }
        return true;
    }

    /* renamed from: a */
    public void m9904a(String str, long j2, String str2) {
        this.f10548c++;
        this.f10549d += j2;
    }

    /* renamed from: a */
    public void m9902a(long j2) {
        this.f10550e += j2;
    }

    /* renamed from: a */
    private static String m9898a(String str) {
        if (C3154aq.m9970a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            C3151an.m9916a(th);
            return str;
        }
    }

    /* renamed from: a */
    private static boolean m9899a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            if (!map.containsKey(NotificationCompat.CATEGORY_STATUS)) {
                C3151an.m9922d("[Upload] Headers does not contain %s", NotificationCompat.CATEGORY_STATUS);
                return false;
            }
            if (!map.containsKey("Bugly-Version")) {
                C3151an.m9922d("[Upload] Headers does not contain %s", "Bugly-Version");
                return false;
            }
            String str = map.get("Bugly-Version");
            if (!str.contains("bugly")) {
                C3151an.m9922d("[Upload] Bugly version is not valid: %s", str);
                return false;
            }
            C3151an.m9921c("[Upload] Bugly version from headers is: %s", str);
            return true;
        }
        C3151an.m9922d("[Upload] Headers is empty.", new Object[0]);
        return false;
    }
}
