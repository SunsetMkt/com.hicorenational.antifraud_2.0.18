package com.alibaba.sdk.android.utils.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.utils.C1565a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: CrashDefendManager.java */
/* renamed from: com.alibaba.sdk.android.utils.crashdefend.b */
/* loaded from: classes.dex */
public class C1568b {

    /* renamed from: b */
    private static C1568b f4038b;

    /* renamed from: a */
    private C1565a f4039a;

    /* renamed from: a */
    private C1569c f4041a;

    /* renamed from: a */
    private ExecutorService f4043a;
    private Context context;

    /* renamed from: a */
    private C1567a f4040a = new C1567a();

    /* renamed from: a */
    private final List<C1569c> f4042a = new ArrayList();

    /* renamed from: d */
    private Map<String, String> f4045d = new HashMap();

    /* renamed from: a */
    private final int[] f4044a = new int[5];

    /* compiled from: CrashDefendManager.java */
    /* renamed from: com.alibaba.sdk.android.utils.crashdefend.b$a */
    private class a implements Runnable {

        /* renamed from: a */
        private C1570d f4046a;

        a(C1570d c1570d) {
            this.f4046a = c1570d;
        }

        @Override // java.lang.Runnable
        public void run() {
            do {
                try {
                    Thread.sleep(1000L);
                    C1570d c1570d = this.f4046a;
                    c1570d.f4058d--;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            } while (this.f4046a.f4058d > 0);
            if (this.f4046a.f4058d <= 0) {
                C1568b.this.m3614b(this.f4046a.f4057b);
                C1571e.m3620a(C1568b.this.context, C1568b.this.f4040a, (List<C1569c>) C1568b.this.f4042a);
            }
        }
    }

    private C1568b(Context context, C1565a c1565a) {
        this.f4043a = null;
        this.context = context;
        this.f4039a = c1565a;
        this.f4043a = new C1572f().m3625a();
        for (int i2 = 0; i2 < 5; i2++) {
            this.f4044a[i2] = (i2 * 5) + 5;
        }
        this.f4045d.put("sdkId", "utils");
        this.f4045d.put("sdkVersion", "2.0.0");
        try {
            m3607a();
            m3613b();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    /* renamed from: b */
    private void m3613b() {
        this.f4041a = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f4042a) {
            for (C1569c c1569c : this.f4042a) {
                if (c1569c.crashCount >= c1569c.f4048a) {
                    arrayList.add(c1569c);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1569c c1569c2 = (C1569c) it.next();
                if (c1569c2.f4055c < 5) {
                    long j2 = this.f4040a.f4037a - this.f4044a[c1569c2.f4055c];
                    C1573g.m3626a("UtilsSDK", "after restart " + ((c1569c2.f4049a - j2) + 1) + " times, sdk will be restore");
                    if (c1569c2.f4049a < j2) {
                        this.f4041a = c1569c2;
                        break;
                    }
                } else {
                    String str = "SDK " + c1569c2.f4051a + " has been closed";
                }
            }
            if (this.f4041a != null) {
                this.f4041a.f4055c++;
                String str2 = this.f4041a.f4051a + " will restore --- startSerialNumber:" + this.f4041a.f4049a + "   crashCount:" + this.f4041a.crashCount;
            }
        }
    }

    /* renamed from: b */
    public void m3617b(String str, String str2) {
    }

    /* renamed from: a */
    public static synchronized C1568b m3604a(Context context, C1565a c1565a) {
        C1568b c1568b;
        synchronized (C1568b.class) {
            if (f4038b == null) {
                f4038b = new C1568b(context, c1565a);
            }
            c1568b = f4038b;
        }
        return c1568b;
    }

    /* renamed from: a */
    private void m3607a() {
        if (C1571e.m3622a(this.context, this.f4040a, this.f4042a)) {
            this.f4040a.f4037a++;
        } else {
            this.f4040a.f4037a = 1L;
        }
    }

    /* renamed from: a */
    public boolean m3616a(C1569c c1569c, SDKMessageCallback sDKMessageCallback) {
        C1569c m3605a;
        if (c1569c != null && sDKMessageCallback != null) {
            try {
                if (TextUtils.isEmpty(c1569c.f4054b) || TextUtils.isEmpty(c1569c.f4051a) || (m3605a = m3605a(c1569c, sDKMessageCallback)) == null) {
                    return false;
                }
                boolean m3612a = m3612a(m3605a);
                if (m3605a.crashCount == m3605a.f4048a) {
                    m3611a(m3605a.f4051a, m3605a.f4054b, m3605a.crashCount, m3605a.f4048a);
                }
                m3605a.crashCount++;
                C1571e.m3620a(this.context, this.f4040a, this.f4042a);
                if (m3612a) {
                    m3609a(m3605a);
                    String str = "START:" + m3605a.f4051a + " --- limit:" + m3605a.f4048a + "  count:" + (m3605a.crashCount - 1) + "  restore:" + m3605a.f4055c + "  startSerialNumber:" + m3605a.f4049a + "  registerSerialNumber:" + m3605a.f4053b;
                } else {
                    sDKMessageCallback.crashDefendMessage(m3605a.f4048a, m3605a.crashCount - 1);
                    String str2 = "STOP:" + m3605a.f4051a + " --- limit:" + m3605a.f4048a + "  count:" + (m3605a.crashCount - 1) + "  restore:" + m3605a.f4055c + "  startSerialNumber:" + m3605a.f4049a + "  registerSerialNumber:" + m3605a.f4053b;
                }
                return true;
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3614b(C1569c c1569c) {
        if (c1569c == null) {
            return;
        }
        int i2 = c1569c.f4055c;
        if (i2 > 0) {
            m3615b(c1569c.f4051a, c1569c.f4054b, i2, 5);
        }
        c1569c.crashCount = 0;
        c1569c.f4055c = 0;
    }

    /* renamed from: b */
    private void m3615b(String str, String str2, int i2, int i3) {
        if (this.f4039a == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f4045d);
        hashMap.put("crashSdkId", str);
        hashMap.put("crashSdkVer", str2);
        hashMap.put("recoverCount", String.valueOf(i2));
        hashMap.put("recoverThreshold", String.valueOf(i3));
        this.f4039a.sendCustomHit("utils_biz_recover", 0L, hashMap);
    }

    /* renamed from: a */
    private C1569c m3605a(C1569c c1569c, SDKMessageCallback sDKMessageCallback) {
        synchronized (this.f4042a) {
            C1569c c1569c2 = null;
            if (this.f4042a != null && this.f4042a.size() > 0) {
                Iterator<C1569c> it = this.f4042a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1569c next = it.next();
                    if (next != null && next.f4051a.equals(c1569c.f4051a)) {
                        if (!next.f4054b.equals(c1569c.f4054b)) {
                            next.f4054b = c1569c.f4054b;
                            next.f4048a = c1569c.f4048a;
                            next.f4052b = c1569c.f4052b;
                            next.crashCount = 0;
                            next.f4055c = 0;
                        }
                        if (next.f4056c) {
                            String str = "SDK " + c1569c.f4051a + " has been registered";
                            return null;
                        }
                        next.f4056c = true;
                        next.f4050a = sDKMessageCallback;
                        next.f4053b = this.f4040a.f4037a;
                        c1569c2 = next;
                    }
                }
            }
            if (c1569c2 == null) {
                c1569c2 = (C1569c) c1569c.clone();
                c1569c2.f4056c = true;
                c1569c2.f4050a = sDKMessageCallback;
                c1569c2.crashCount = 0;
                c1569c2.f4053b = this.f4040a.f4037a;
                this.f4042a.add(c1569c2);
            }
            return c1569c2;
        }
    }

    /* renamed from: a */
    private boolean m3612a(C1569c c1569c) {
        if (c1569c.crashCount < c1569c.f4048a) {
            c1569c.f4049a = c1569c.f4053b;
            return true;
        }
        C1569c c1569c2 = this.f4041a;
        if (c1569c2 == null || !c1569c2.f4051a.equals(c1569c.f4051a)) {
            return false;
        }
        c1569c.crashCount = c1569c.f4048a - 1;
        c1569c.f4049a = c1569c.f4053b;
        return true;
    }

    /* renamed from: a */
    private void m3609a(C1569c c1569c) {
        if (c1569c == null) {
            return;
        }
        C1570d c1570d = new C1570d();
        c1570d.f4057b = c1569c;
        c1570d.f4058d = c1569c.f4052b;
        m3610a(c1570d);
        SDKMessageCallback sDKMessageCallback = c1569c.f4050a;
        if (sDKMessageCallback != null) {
            sDKMessageCallback.crashDefendMessage(c1569c.f4048a, c1569c.crashCount - 1);
        }
    }

    /* renamed from: a */
    private void m3610a(C1570d c1570d) {
        if (c1570d == null || c1570d.f4057b == null) {
            return;
        }
        this.f4043a.execute(new a(c1570d));
    }

    /* renamed from: a */
    private void m3611a(String str, String str2, int i2, int i3) {
        if (this.f4039a == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f4045d);
        hashMap.put("crashSdkId", str);
        hashMap.put("crashSdkVer", str2);
        hashMap.put("curCrashCount", String.valueOf(i2));
        hashMap.put("crashThreshold", String.valueOf(i3));
        this.f4039a.sendCustomHit("utils_biz_crash", 0L, hashMap);
    }
}
