package com.alibaba.sdk.android.utils.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: CrashDefendManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b */
    private static b f2628b;
    private com.alibaba.sdk.android.utils.a a;

    /* JADX INFO: renamed from: a */
    private c f46a;

    /* JADX INFO: renamed from: a */
    private ExecutorService f48a;
    private Context context;

    /* JADX INFO: renamed from: a */
    private com.alibaba.sdk.android.utils.crashdefend.a f45a = new com.alibaba.sdk.android.utils.crashdefend.a();

    /* JADX INFO: renamed from: a */
    private final List<c> f47a = new ArrayList();

    /* JADX INFO: renamed from: d */
    private Map<String, String> f2629d = new HashMap();

    /* JADX INFO: renamed from: a */
    private final int[] f49a = new int[5];

    /* JADX INFO: compiled from: CrashDefendManager.java */
    private class a implements Runnable {
        private d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            do {
                try {
                    Thread.sleep(1000L);
                    d dVar = this.a;
                    dVar.f2634d--;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            } while (this.a.f2634d > 0);
            if (this.a.f2634d <= 0) {
                b.this.b(this.a.f2633b);
                e.a(b.this.context, b.this.f45a, (List<c>) b.this.f47a);
                return;
            }
            return;
        }
    }

    private b(Context context, com.alibaba.sdk.android.utils.a aVar) {
        this.f48a = null;
        this.context = context;
        this.a = aVar;
        this.f48a = new f().a();
        for (int i2 = 0; i2 < 5; i2++) {
            this.f49a[i2] = (i2 * 5) + 5;
        }
        this.f2629d.put("sdkId", "utils");
        this.f2629d.put("sdkVersion", "2.0.0");
        try {
            a();
            b();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    private void b() {
        this.f46a = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f47a) {
            for (c cVar : this.f47a) {
                if (cVar.crashCount >= cVar.a) {
                    arrayList.add(cVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c cVar2 = (c) it.next();
                if (cVar2.f2632c < 5) {
                    long j2 = this.f45a.a - ((long) this.f49a[cVar2.f2632c]);
                    g.a("UtilsSDK", "after restart " + ((cVar2.f50a - j2) + 1) + " times, sdk will be restore");
                    if (cVar2.f50a < j2) {
                        this.f46a = cVar2;
                        break;
                    }
                } else {
                    String str = "SDK " + cVar2.f52a + " has been closed";
                }
            }
            if (this.f46a != null) {
                this.f46a.f2632c++;
                String str2 = this.f46a.f52a + " will restore --- startSerialNumber:" + this.f46a.f50a + "   crashCount:" + this.f46a.crashCount;
            }
        }
    }

    public void b(String str, String str2) {
    }

    public static synchronized b a(Context context, com.alibaba.sdk.android.utils.a aVar) {
        if (f2628b == null) {
            f2628b = new b(context, aVar);
        }
        return f2628b;
    }

    private void a() {
        if (e.m33a(this.context, this.f45a, this.f47a)) {
            this.f45a.a++;
        } else {
            this.f45a.a = 1L;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m31a(c cVar, SDKMessageCallback sDKMessageCallback) {
        c cVarA;
        if (cVar != null && sDKMessageCallback != null) {
            try {
                if (TextUtils.isEmpty(cVar.f54b) || TextUtils.isEmpty(cVar.f52a) || (cVarA = a(cVar, sDKMessageCallback)) == null) {
                    return false;
                }
                boolean zM30a = m30a(cVarA);
                if (cVarA.crashCount == cVarA.a) {
                    a(cVarA.f52a, cVarA.f54b, cVarA.crashCount, cVarA.a);
                }
                cVarA.crashCount++;
                e.a(this.context, this.f45a, this.f47a);
                if (zM30a) {
                    a(cVarA);
                    String str = "START:" + cVarA.f52a + " --- limit:" + cVarA.a + "  count:" + (cVarA.crashCount - 1) + "  restore:" + cVarA.f2632c + "  startSerialNumber:" + cVarA.f50a + "  registerSerialNumber:" + cVarA.f53b;
                } else {
                    sDKMessageCallback.crashDefendMessage(cVarA.a, cVarA.crashCount - 1);
                    String str2 = "STOP:" + cVarA.f52a + " --- limit:" + cVarA.a + "  count:" + (cVarA.crashCount - 1) + "  restore:" + cVarA.f2632c + "  startSerialNumber:" + cVarA.f50a + "  registerSerialNumber:" + cVarA.f53b;
                }
                return true;
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return false;
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        int i2 = cVar.f2632c;
        if (i2 > 0) {
            b(cVar.f52a, cVar.f54b, i2, 5);
        }
        cVar.crashCount = 0;
        cVar.f2632c = 0;
    }

    private void b(String str, String str2, int i2, int i3) {
        if (this.a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.f2629d);
        map.put("crashSdkId", str);
        map.put("crashSdkVer", str2);
        map.put("recoverCount", String.valueOf(i2));
        map.put("recoverThreshold", String.valueOf(i3));
        this.a.sendCustomHit("utils_biz_recover", 0L, map);
    }

    private c a(c cVar, SDKMessageCallback sDKMessageCallback) {
        synchronized (this.f47a) {
            c cVar2 = null;
            if (this.f47a != null && this.f47a.size() > 0) {
                Iterator<c> it = this.f47a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && next.f52a.equals(cVar.f52a)) {
                        if (!next.f54b.equals(cVar.f54b)) {
                            next.f54b = cVar.f54b;
                            next.a = cVar.a;
                            next.f2631b = cVar.f2631b;
                            next.crashCount = 0;
                            next.f2632c = 0;
                        }
                        if (next.f55c) {
                            String str = "SDK " + cVar.f52a + " has been registered";
                            return null;
                        }
                        next.f55c = true;
                        next.f51a = sDKMessageCallback;
                        next.f53b = this.f45a.a;
                        cVar2 = next;
                    }
                }
            }
            if (cVar2 == null) {
                cVar2 = (c) cVar.clone();
                cVar2.f55c = true;
                cVar2.f51a = sDKMessageCallback;
                cVar2.crashCount = 0;
                cVar2.f53b = this.f45a.a;
                this.f47a.add(cVar2);
            }
            return cVar2;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m30a(c cVar) {
        if (cVar.crashCount < cVar.a) {
            cVar.f50a = cVar.f53b;
            return true;
        }
        c cVar2 = this.f46a;
        if (cVar2 == null || !cVar2.f52a.equals(cVar.f52a)) {
            return false;
        }
        cVar.crashCount = cVar.a - 1;
        cVar.f50a = cVar.f53b;
        return true;
    }

    private void a(c cVar) {
        if (cVar == null) {
            return;
        }
        d dVar = new d();
        dVar.f2633b = cVar;
        dVar.f2634d = cVar.f2631b;
        a(dVar);
        SDKMessageCallback sDKMessageCallback = cVar.f51a;
        if (sDKMessageCallback != null) {
            sDKMessageCallback.crashDefendMessage(cVar.a, cVar.crashCount - 1);
        }
    }

    private void a(d dVar) {
        if (dVar == null || dVar.f2633b == null) {
            return;
        }
        this.f48a.execute(new a(dVar));
    }

    private void a(String str, String str2, int i2, int i3) {
        if (this.a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.f2629d);
        map.put("crashSdkId", str);
        map.put("crashSdkVer", str2);
        map.put("curCrashCount", String.valueOf(i2));
        map.put("crashThreshold", String.valueOf(i3));
        this.a.sendCustomHit("utils_biz_crash", 0L, map);
    }
}
