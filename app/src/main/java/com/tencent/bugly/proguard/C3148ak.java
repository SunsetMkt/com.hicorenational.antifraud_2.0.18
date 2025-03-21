package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.bugly.C3072b;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ak */
/* loaded from: classes2.dex */
public class C3148ak {

    /* renamed from: c */
    private static C3148ak f10515c;

    /* renamed from: a */
    public InterfaceC3147aj f10516a;

    /* renamed from: b */
    public boolean f10517b;

    /* renamed from: e */
    private final Context f10519e;

    /* renamed from: g */
    private long f10521g;

    /* renamed from: h */
    private long f10522h;

    /* renamed from: l */
    private String f10526l;

    /* renamed from: f */
    private Map<Integer, Long> f10520f = new HashMap();

    /* renamed from: i */
    private LinkedBlockingQueue<Runnable> f10523i = new LinkedBlockingQueue<>();

    /* renamed from: j */
    private LinkedBlockingQueue<Runnable> f10524j = new LinkedBlockingQueue<>();

    /* renamed from: k */
    private final Object f10525k = new Object();

    /* renamed from: m */
    private byte[] f10527m = null;

    /* renamed from: n */
    private long f10528n = 0;

    /* renamed from: o */
    private byte[] f10529o = null;

    /* renamed from: p */
    private long f10530p = 0;

    /* renamed from: q */
    private String f10531q = null;

    /* renamed from: r */
    private long f10532r = 0;

    /* renamed from: s */
    private final Object f10533s = new Object();

    /* renamed from: t */
    private boolean f10534t = false;

    /* renamed from: u */
    private final Object f10535u = new Object();

    /* renamed from: v */
    private int f10536v = 0;

    /* renamed from: d */
    private final C3142ae f10518d = C3142ae.m9817a();

    protected C3148ak(Context context) {
        this.f10526l = null;
        this.f10517b = true;
        this.f10519e = context;
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException unused) {
            C3151an.m9915a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.f10517b = false;
        }
        if (this.f10517b) {
            this.f10526l = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB";
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m9873b(C3148ak c3148ak) {
        int i2 = c3148ak.f10536v - 1;
        c3148ak.f10536v = i2;
        return i2;
    }

    /* renamed from: c */
    private boolean m9876c() {
        C3151an.m9921c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C3142ae m9817a = C3142ae.m9817a();
            if (m9817a != null) {
                return m9817a.m9835a(555, "security_info", (InterfaceC3141ad) null, true);
            }
            C3151an.m9922d("[UploadManager] Failed to get Database", new Object[0]);
            return false;
        } catch (Throwable th) {
            C3151an.m9916a(th);
            return false;
        }
    }

    /* renamed from: d */
    private boolean m9879d() {
        C3151an.m9921c("[UploadManager] Record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C3142ae m9817a = C3142ae.m9817a();
            if (m9817a == null) {
                C3151an.m9922d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            StringBuilder sb = new StringBuilder();
            if (this.f10529o == null) {
                C3151an.m9921c("[UploadManager] AES key is null, will not record", new Object[0]);
                return false;
            }
            sb.append(Base64.encodeToString(this.f10529o, 0));
            sb.append("#");
            if (this.f10530p != 0) {
                sb.append(Long.toString(this.f10530p));
            } else {
                sb.append(AbstractC1191a.f2571h);
            }
            sb.append("#");
            if (this.f10531q != null) {
                sb.append(this.f10531q);
            } else {
                sb.append(AbstractC1191a.f2571h);
            }
            sb.append("#");
            if (this.f10532r != 0) {
                sb.append(Long.toString(this.f10532r));
            } else {
                sb.append(AbstractC1191a.f2571h);
            }
            m9817a.m9836a(555, "security_info", sb.toString().getBytes(), (InterfaceC3141ad) null, true);
            return true;
        } catch (Throwable th) {
            C3151an.m9916a(th);
            m9876c();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de A[Catch: all -> 0x00e2, TRY_LEAVE, TryCatch #0 {all -> 0x00e2, blocks: (B:3:0x0020, B:5:0x0026, B:8:0x002e, B:10:0x0037, B:12:0x003d, B:14:0x0052, B:17:0x005c, B:23:0x006e, B:25:0x0076, B:27:0x007e, B:33:0x0090, B:35:0x0096, B:37:0x009e, B:39:0x00a6, B:41:0x00ac, B:43:0x00b5, B:49:0x00c7, B:52:0x00de, B:54:0x00cb, B:46:0x00bd, B:20:0x0064, B:30:0x0086), top: B:2:0x0020, inners: #1, #2, #3 }] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m9881e() {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3148ak.m9881e():boolean");
    }

    /* renamed from: b */
    public boolean m9896b(int i2) {
        if (C3072b.f9834c) {
            C3151an.m9921c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - m9882a(i2);
        C3151an.m9921c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i2));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        C3151an.m9915a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ak$a */
    class a implements Runnable {

        /* renamed from: b */
        private final Context f10543b;

        /* renamed from: c */
        private final Runnable f10544c;

        /* renamed from: d */
        private final long f10545d;

        public a(Context context) {
            this.f10543b = context;
            this.f10544c = null;
            this.f10545d = 0L;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C3154aq.m9967a(this.f10543b, "security_info", 30000L)) {
                C3151an.m9921c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", 5000, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                C3154aq.m9983b(C2084a.f6136r);
                if (C3154aq.m9960a(this, "BUGLY_ASYNC_UPLOAD") == null) {
                    C3151an.m9922d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                    C3150am m9906a = C3150am.m9906a();
                    if (m9906a != null) {
                        m9906a.m9908a(this);
                        return;
                    } else {
                        C3151an.m9923e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!C3148ak.this.m9881e()) {
                C3151an.m9922d("[UploadManager] Failed to load security info from database", new Object[0]);
                C3148ak.this.m9894b(false);
            }
            if (C3148ak.this.f10531q != null) {
                if (C3148ak.this.m9895b()) {
                    C3151an.m9921c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    Runnable runnable = this.f10544c;
                    if (runnable != null) {
                        C3148ak.this.m9868a(runnable, this.f10545d);
                    }
                    C3148ak.this.m9875c(0);
                    C3154aq.m9994c(this.f10543b, "security_info");
                    synchronized (C3148ak.this.f10535u) {
                        C3148ak.this.f10534t = false;
                    }
                    return;
                }
                C3151an.m9915a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
                C3148ak.this.m9894b(true);
            }
            byte[] m9971a = C3154aq.m9971a(128);
            if (m9971a == null || m9971a.length * 8 != 128) {
                C3151an.m9922d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                C3148ak.this.m9894b(false);
                C3154aq.m9994c(this.f10543b, "security_info");
                synchronized (C3148ak.this.f10535u) {
                    C3148ak.this.f10534t = false;
                }
                return;
            }
            C3148ak.this.f10529o = m9971a;
            C3151an.m9921c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            Runnable runnable2 = this.f10544c;
            if (runnable2 != null) {
                C3148ak.this.m9868a(runnable2, this.f10545d);
            } else {
                C3148ak.this.m9875c(1);
            }
        }

        public a(Context context, Runnable runnable, long j2) {
            this.f10543b = context;
            this.f10544c = runnable;
            this.f10545d = j2;
        }
    }

    /* renamed from: a */
    public static synchronized C3148ak m9864a(Context context) {
        C3148ak c3148ak;
        synchronized (C3148ak.class) {
            if (f10515c == null) {
                f10515c = new C3148ak(context);
            }
            c3148ak = f10515c;
        }
        return c3148ak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #4 {, blocks: (B:9:0x001c, B:12:0x0049, B:13:0x0050, B:19:0x0063, B:23:0x006d, B:29:0x008f, B:31:0x0082, B:36:0x0095, B:42:0x00b7, B:44:0x00aa, B:47:0x00ba, B:99:0x005a, B:101:0x005e, B:26:0x0078, B:39:0x00a0), top: B:8:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095 A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #4 {, blocks: (B:9:0x001c, B:12:0x0049, B:13:0x0050, B:19:0x0063, B:23:0x006d, B:29:0x008f, B:31:0x0082, B:36:0x0095, B:42:0x00b7, B:44:0x00aa, B:47:0x00ba, B:99:0x005a, B:101:0x005e, B:26:0x0078, B:39:0x00a0), top: B:8:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m9875c(int r13) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3148ak.m9875c(int):void");
    }

    /* renamed from: a */
    public static synchronized C3148ak m9863a() {
        C3148ak c3148ak;
        synchronized (C3148ak.class) {
            c3148ak = f10515c;
        }
        return c3148ak;
    }

    /* renamed from: a */
    public void m9885a(int i2, int i3, byte[] bArr, String str, String str2, InterfaceC3147aj interfaceC3147aj, long j2, boolean z) {
        try {
            m9874b(new RunnableC3149al(this.f10519e, i2, i3, bArr, str, str2, interfaceC3147aj, this.f10517b, z), true, true, j2);
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    protected boolean m9895b() {
        if (this.f10531q == null || this.f10532r == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.f10528n;
        long j2 = this.f10532r;
        if (j2 >= currentTimeMillis) {
            return true;
        }
        C3151an.m9921c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(j2), new Date(this.f10532r).toString(), Long.valueOf(currentTimeMillis), new Date(currentTimeMillis).toString());
        return false;
    }

    /* renamed from: a */
    public void m9888a(int i2, C3172bh c3172bh, String str, String str2, InterfaceC3147aj interfaceC3147aj, long j2, boolean z) {
        m9885a(i2, c3172bh.f10667g, C3145ah.m9855a((Object) c3172bh), str, str2, interfaceC3147aj, j2, z);
    }

    /* renamed from: a */
    public void m9884a(int i2, int i3, byte[] bArr, String str, String str2, InterfaceC3147aj interfaceC3147aj, int i4, int i5, boolean z, Map<String, String> map) {
        try {
            m9874b(new RunnableC3149al(this.f10519e, i2, i3, bArr, str, str2, interfaceC3147aj, this.f10517b, i4, i5, false, map), z, false, 0L);
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m9894b(boolean z) {
        synchronized (this.f10533s) {
            C3151an.m9921c("[UploadManager] Clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.f10529o = null;
            this.f10531q = null;
            this.f10532r = 0L;
        }
        if (z) {
            m9876c();
        }
    }

    /* renamed from: a */
    public void m9886a(int i2, int i3, byte[] bArr, String str, String str2, InterfaceC3147aj interfaceC3147aj, boolean z, Map<String, String> map) {
        m9884a(i2, i3, bArr, str, str2, interfaceC3147aj, 0, 0, z, map);
    }

    /* renamed from: a */
    public void m9889a(int i2, C3172bh c3172bh, String str, String str2, InterfaceC3147aj interfaceC3147aj, boolean z) {
        m9884a(i2, c3172bh.f10667g, C3145ah.m9855a((Object) c3172bh), str, str2, interfaceC3147aj, 0, 0, z, null);
    }

    /* renamed from: a */
    public long m9883a(boolean z) {
        long j2;
        long m9978b = C3154aq.m9978b();
        int i2 = z ? 5 : 3;
        List<C3144ag> m9832a = this.f10518d.m9832a(i2);
        if (m9832a != null && m9832a.size() > 0) {
            j2 = 0;
            try {
                C3144ag c3144ag = m9832a.get(0);
                if (c3144ag.f10509e >= m9978b) {
                    j2 = C3154aq.m9992c(c3144ag.f10511g);
                    if (i2 == 3) {
                        this.f10521g = j2;
                    } else {
                        this.f10522h = j2;
                    }
                    m9832a.remove(c3144ag);
                }
            } catch (Throwable th) {
                C3151an.m9916a(th);
            }
            if (m9832a.size() > 0) {
                this.f10518d.m9834a(m9832a);
            }
        } else {
            j2 = z ? this.f10522h : this.f10521g;
        }
        C3151an.m9921c("[UploadManager] Local network consume: %d KB", Long.valueOf(j2 / 1024));
        return j2;
    }

    /* renamed from: b */
    private void m9874b(Runnable runnable, boolean z, boolean z2, long j2) {
        if (runnable == null) {
            C3151an.m9922d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        C3151an.m9921c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.f10531q != null) {
            if (m9895b()) {
                C3151an.m9921c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z2) {
                    m9868a(runnable, j2);
                    return;
                } else {
                    m9871a(runnable, z);
                    m9875c(0);
                    return;
                }
            }
            C3151an.m9915a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            m9894b(false);
        }
        synchronized (this.f10535u) {
            if (this.f10534t) {
                m9871a(runnable, z);
            } else {
                this.f10534t = true;
                m9869a(runnable, z, z2, j2);
            }
        }
    }

    /* renamed from: a */
    protected synchronized void m9891a(long j2, boolean z) {
        int i2 = z ? 5 : 3;
        C3144ag c3144ag = new C3144ag();
        c3144ag.f10506b = i2;
        c3144ag.f10509e = C3154aq.m9978b();
        c3144ag.f10507c = "";
        c3144ag.f10508d = "";
        c3144ag.f10511g = C3154aq.m9996c(j2);
        this.f10518d.m9840b(i2);
        this.f10518d.m9837a(c3144ag);
        if (z) {
            this.f10522h = j2;
        } else {
            this.f10521g = j2;
        }
        C3151an.m9921c("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
    }

    /* renamed from: a */
    public synchronized void m9887a(int i2, long j2) {
        if (i2 >= 0) {
            this.f10520f.put(Integer.valueOf(i2), Long.valueOf(j2));
            C3144ag c3144ag = new C3144ag();
            c3144ag.f10506b = i2;
            c3144ag.f10509e = j2;
            c3144ag.f10507c = "";
            c3144ag.f10508d = "";
            c3144ag.f10511g = new byte[0];
            this.f10518d.m9840b(i2);
            this.f10518d.m9837a(c3144ag);
            C3151an.m9921c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), C3154aq.m9953a(j2));
        } else {
            C3151an.m9923e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
        }
    }

    /* renamed from: b */
    public byte[] m9897b(byte[] bArr) {
        byte[] bArr2 = this.f10529o;
        if (bArr2 != null && bArr2.length * 8 == 128) {
            return C3154aq.m9972a(2, bArr, bArr2);
        }
        C3151an.m9922d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* renamed from: a */
    public synchronized long m9882a(int i2) {
        long j2 = 0;
        if (i2 >= 0) {
            Long l2 = this.f10520f.get(Integer.valueOf(i2));
            if (l2 != null) {
                return l2.longValue();
            }
            List<C3144ag> m9832a = this.f10518d.m9832a(i2);
            if (m9832a != null && m9832a.size() > 0) {
                if (m9832a.size() > 1) {
                    for (C3144ag c3144ag : m9832a) {
                        if (c3144ag.f10509e > j2) {
                            j2 = c3144ag.f10509e;
                        }
                    }
                    this.f10518d.m9840b(i2);
                } else {
                    try {
                        j2 = m9832a.get(0).f10509e;
                    } catch (Throwable th) {
                        C3151an.m9916a(th);
                    }
                }
            }
        } else {
            C3151an.m9923e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return j2;
    }

    /* renamed from: a */
    private boolean m9871a(Runnable runnable, boolean z) {
        if (runnable == null) {
            C3151an.m9915a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C3151an.m9921c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f10525k) {
                if (z) {
                    this.f10523i.put(runnable);
                } else {
                    this.f10524j.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            C3151an.m9923e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9868a(Runnable runnable, long j2) {
        if (runnable == null) {
            C3151an.m9922d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        C3151an.m9921c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread m9960a = C3154aq.m9960a(runnable, "BUGLY_SYNC_UPLOAD");
        if (m9960a == null) {
            C3151an.m9923e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            m9871a(runnable, true);
            return;
        }
        try {
            m9960a.join(j2);
        } catch (Throwable th) {
            C3151an.m9923e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            m9871a(runnable, true);
            m9875c(0);
        }
    }

    /* renamed from: a */
    private void m9869a(Runnable runnable, boolean z, boolean z2, long j2) {
        C3151an.m9921c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            m9868a(new a(this.f10519e, runnable, j2), 0L);
            return;
        }
        m9871a(runnable, z);
        a aVar = new a(this.f10519e);
        C3151an.m9915a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
        if (C3154aq.m9960a(aVar, "BUGLY_ASYNC_UPLOAD") == null) {
            C3151an.m9922d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
            C3150am m9906a = C3150am.m9906a();
            if (m9906a != null) {
                m9906a.m9908a(aVar);
                return;
            }
            C3151an.m9923e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
            synchronized (this.f10535u) {
                this.f10534t = false;
            }
        }
    }

    /* renamed from: a */
    public void m9890a(int i2, C3173bi c3173bi) {
        if (this.f10517b) {
            boolean z = true;
            if (i2 == 2) {
                C3151an.m9921c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                m9894b(true);
            } else {
                synchronized (this.f10535u) {
                    if (!this.f10534t) {
                        return;
                    }
                    if (c3173bi != null) {
                        C3151an.m9921c("[UploadManager] Record security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        try {
                            Map<String, String> map = c3173bi.f10694h;
                            if (map != null && map.containsKey("S1") && map.containsKey("S2")) {
                                this.f10528n = c3173bi.f10691e - System.currentTimeMillis();
                                C3151an.m9921c("[UploadManager] Time lag of server is: %d", Long.valueOf(this.f10528n));
                                this.f10531q = map.get("S1");
                                C3151an.m9921c("[UploadManager] Session ID from server is: %s", this.f10531q);
                                if (this.f10531q.length() > 0) {
                                    try {
                                        this.f10532r = Long.parseLong(map.get("S2"));
                                        C3151an.m9921c("[UploadManager] Session expired time from server is: %d(%s)", Long.valueOf(this.f10532r), new Date(this.f10532r).toString());
                                        if (this.f10532r < 1000) {
                                            C3151an.m9922d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new Object[0]);
                                            this.f10532r = 259200000L;
                                        }
                                    } catch (NumberFormatException unused) {
                                        C3151an.m9922d("[UploadManager] Session expired time is invalid, will set to default value", new Object[0]);
                                        this.f10532r = 259200000L;
                                    }
                                    if (m9879d()) {
                                        z = false;
                                    } else {
                                        C3151an.m9921c("[UploadManager] Failed to record database", new Object[0]);
                                    }
                                    m9875c(0);
                                } else {
                                    C3151an.m9921c("[UploadManager] Session ID from server is invalid, try next time", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            C3151an.m9916a(th);
                        }
                        if (z) {
                            m9894b(false);
                        }
                    } else {
                        C3151an.m9921c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        m9894b(false);
                    }
                }
            }
            synchronized (this.f10535u) {
                if (this.f10534t) {
                    this.f10534t = false;
                    C3154aq.m9994c(this.f10519e, "security_info");
                }
            }
        }
    }

    /* renamed from: a */
    public byte[] m9893a(byte[] bArr) {
        byte[] bArr2 = this.f10529o;
        if (bArr2 != null && bArr2.length * 8 == 128) {
            return C3154aq.m9972a(1, bArr, bArr2);
        }
        C3151an.m9922d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* renamed from: a */
    public boolean m9892a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        C3151an.m9921c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str = this.f10531q;
        if (str != null) {
            map.put("secureSessionId", str);
            return true;
        }
        byte[] bArr = this.f10529o;
        if (bArr != null && bArr.length * 8 == 128) {
            if (this.f10527m == null) {
                this.f10527m = Base64.decode(this.f10526l, 0);
                if (this.f10527m == null) {
                    C3151an.m9922d("[UploadManager] Failed to decode RSA public key", new Object[0]);
                    return false;
                }
            }
            byte[] m9988b = C3154aq.m9988b(1, this.f10529o, this.f10527m);
            if (m9988b == null) {
                C3151an.m9922d("[UploadManager] Failed to encrypt AES key", new Object[0]);
                return false;
            }
            String encodeToString = Base64.encodeToString(m9988b, 0);
            if (encodeToString == null) {
                C3151an.m9922d("[UploadManager] Failed to encode AES key", new Object[0]);
                return false;
            }
            map.put("raKey", encodeToString);
            return true;
        }
        C3151an.m9922d("[UploadManager] AES key is invalid", new Object[0]);
        return false;
    }
}
