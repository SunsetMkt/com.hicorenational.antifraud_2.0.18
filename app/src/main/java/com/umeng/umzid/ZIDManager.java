package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ZIDManager {

    /* renamed from: d */
    public static ZIDManager f13839d;

    /* renamed from: a */
    public boolean f13840a = false;

    /* renamed from: b */
    public boolean f13841b = false;

    /* renamed from: c */
    public boolean f13842c;

    /* renamed from: com.umeng.umzid.ZIDManager$a */
    public class RunnableC3789a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f13843a;

        /* renamed from: b */
        public final /* synthetic */ IZIDCompletionCallback f13844b;

        public RunnableC3789a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f13843a = context;
            this.f13844b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String m12727a = ZIDManager.m12727a(ZIDManager.this, this.f13843a);
            if (TextUtils.isEmpty(m12727a)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f13844b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f13844b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(m12727a);
            }
        }
    }

    /* renamed from: com.umeng.umzid.ZIDManager$b */
    public class RunnableC3790b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f13846a;

        public RunnableC3790b(Context context) {
            this.f13846a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.m12730b(this.f13846a);
        }
    }

    /* renamed from: com.umeng.umzid.ZIDManager$c */
    public class RunnableC3791c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f13848a;

        public RunnableC3791c(Context context) {
            this.f13848a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.m12727a(ZIDManager.this, this.f13848a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:5:0x0010, B:16:0x0056, B:17:0x005b, B:20:0x006b, B:22:0x008a, B:24:0x009f, B:26:0x00b4, B:27:0x00b7, B:29:0x00c3, B:30:0x00c6, B:32:0x00d2, B:33:0x00d5, B:38:0x0051), top: B:4:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:5:0x0010, B:16:0x0056, B:17:0x005b, B:20:0x006b, B:22:0x008a, B:24:0x009f, B:26:0x00b4, B:27:0x00b7, B:29:0x00c3, B:30:0x00c6, B:32:0x00d2, B:33:0x00d5, B:38:0x0051), top: B:4:0x0010 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.String m12727a(com.umeng.umzid.ZIDManager r10, android.content.Context r11) {
        /*
            boolean r0 = r10.f13840a
            r1 = 0
            if (r0 == 0) goto L7
            goto Ldf
        L7:
            r0 = 1
            r10.f13840a = r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r3 = 0
            java.lang.String r4 = com.umeng.umzid.Spy.getID()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "z"
            r2.put(r5, r4)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = com.umeng.umzid.C3795d.m12747e(r11)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r6 = "mc"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r6 = com.umeng.umzid.C3795d.m12749f(r11)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = "o"
            r2.put(r7, r6)     // Catch: java.lang.Throwable -> Ld9
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            r7.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r8 = "vpn_pxy"
            boolean r9 = com.umeng.umzid.C3795d.m12753i(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r8 = "wifi_pxy"
            boolean r9 = com.umeng.umzid.C3795d.m12754j(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r8 = "double"
            boolean r9 = com.umeng.umzid.C3795d.m12751g(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            goto L54
        L4c:
            r8 = move-exception
            goto L51
        L4e:
            r7 = move-exception
            r8 = r7
            r7 = r1
        L51:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> Ld9
        L54:
            if (r7 == 0) goto L5b
            java.lang.String r8 = "anti"
            r2.put(r8, r7)     // Catch: java.lang.Throwable -> Ld9
        L5b:
            r10.m12728a(r11, r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = com.umeng.umzid.C3795d.m12739b(r11)     // Catch: java.lang.Throwable -> Ld9
            int r8 = r7.length()     // Catch: java.lang.Throwable -> Ld9
            if (r8 <= 0) goto L69
            goto L6b
        L69:
            java.lang.String r7 = "https://utoken.umeng.com"
        L6b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld9
            r8.<init>()     // Catch: java.lang.Throwable -> Ld9
            r8.append(r7)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = "/anti/postZdata"
            r8.append(r7)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r7 = r8.toString()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = com.umeng.umzid.C3792a.m12732a(r7, r2)     // Catch: java.lang.Throwable -> Ld9
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Ld9
            if (r7 != 0) goto Ld5
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ld9
            r7.<init>(r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = "suc"
            boolean r2 = r7.optBoolean(r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> Ld9
            if (r2 != r0) goto Ld5
            com.umeng.umzid.C3795d.m12750f(r11, r4)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.umzid.C3795d.m12738a(r11, r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.umzid.C3795d.m12741b(r11, r6)     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r0 = "aaid"
            java.lang.String r1 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Ld9
            if (r0 != 0) goto Lb7
            com.umeng.umzid.C3795d.m12748e(r11, r1)     // Catch: java.lang.Throwable -> Ld9
        Lb7:
            java.lang.String r0 = "uabc"
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r2 != 0) goto Lc6
            com.umeng.umzid.C3795d.m12746d(r11, r0)     // Catch: java.lang.Throwable -> Ld9
        Lc6:
            java.lang.String r0 = "resetToken"
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r2 != 0) goto Ld5
            com.umeng.umzid.C3795d.m12743c(r11, r0)     // Catch: java.lang.Throwable -> Ld9
        Ld5:
            r10.m12729a(r11)     // Catch: java.lang.Throwable -> Ld9
            goto Ldd
        Ld9:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> Le0
        Ldd:
            r10.f13840a = r3
        Ldf:
            return r1
        Le0:
            r11 = move-exception
            r10.f13840a = r3
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.m12727a(com.umeng.umzid.ZIDManager, android.content.Context):java.lang.String");
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences m12731a;
        SharedPreferences.Editor edit;
        String m12740b = C3795d.m12740b(str);
        if (context == null || m12740b == null || TextUtils.isEmpty(m12740b) || (m12731a = C3792a.m12731a(context)) == null || (edit = m12731a.edit()) == null) {
            return;
        }
        edit.putString("inputDomain", m12740b).commit();
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f13839d == null) {
                f13839d = new ZIDManager();
            }
            zIDManager = f13839d;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.8.0";
    }

    /* renamed from: a */
    public final void m12729a(Context context) {
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0])) == null || (invoke = declaredMethod.invoke(cls, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("init", Context.class)) == null) {
                return;
            }
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(invoke, context);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:14|(3:80|81|(27:83|17|(1:79)(2:21|(1:23))|24|(1:78)(2:28|(1:30))|31|32|(1:36)|37|(1:39)|40|41|42|43|44|45|46|47|48|(1:50)|51|(1:53)|54|(2:56|(6:58|(1:60)|61|(1:63)|64|(1:66)))|67|68|69))|16|17|(1:19)|79|24|(1:26)|78|31|32|(2:34|36)|37|(0)|40|41|42|43|44|45|46|47|48|(0)|51|(0)|54|(0)|67|68|69) */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ef, code lost:
    
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f4, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f1, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f2, code lost:
    
        r11 = r6;
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9 A[Catch: all -> 0x0172, TRY_ENTER, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9 A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f9 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:81:0x0038, B:83:0x003e, B:17:0x0046, B:19:0x0056, B:21:0x005c, B:23:0x0068, B:24:0x006e, B:26:0x007e, B:28:0x0084, B:30:0x0090, B:31:0x0096, B:34:0x00b9, B:36:0x00bf, B:37:0x00c3, B:39:0x00c9, B:50:0x00f9, B:51:0x00fe, B:54:0x010b, B:56:0x012a, B:58:0x013f, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:66:0x016c, B:67:0x016f, B:74:0x00f4), top: B:80:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m12730b(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.m12730b(android.content.Context):java.lang.String");
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String m12745d = C3795d.m12745d(applicationContext);
        if (!TextUtils.isEmpty(m12745d)) {
            return m12745d;
        }
        C3794c.m12735a(new RunnableC3791c(applicationContext));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0079 A[Catch: all -> 0x00a8, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x0011, B:13:0x001a, B:16:0x0022, B:19:0x002b, B:22:0x0033, B:24:0x0039, B:26:0x003f, B:28:0x0045, B:29:0x004e, B:31:0x0054, B:34:0x005b, B:36:0x0065, B:37:0x0071, B:39:0x0079, B:40:0x0081, B:42:0x0087, B:46:0x0099, B:51:0x0069), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087 A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x0011, B:13:0x001a, B:16:0x0022, B:19:0x002b, B:22:0x0033, B:24:0x0039, B:26:0x003f, B:28:0x0045, B:29:0x004e, B:31:0x0054, B:34:0x005b, B:36:0x0065, B:37:0x0071, B:39:0x0079, B:40:0x0081, B:42:0x0087, B:46:0x0099, B:51:0x0069), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r4, java.lang.String r5, com.umeng.umzid.IZIDCompletionCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.umeng.umzid.C3795d.m12752h(r4)     // Catch: java.lang.Throwable -> La8
            r3.f13842c = r0     // Catch: java.lang.Throwable -> La8
            boolean r0 = r3.f13842c     // Catch: java.lang.Throwable -> La8
            if (r0 != 0) goto Ld
            monitor-exit(r3)
            return
        Ld:
            if (r4 != 0) goto L1a
            if (r6 == 0) goto L18
            java.lang.String r4 = "1001"
            java.lang.String r5 = "传入参数Context为null"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> La8
        L18:
            monitor-exit(r3)
            return
        L1a:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La8
            if (r0 == 0) goto L2b
            if (r6 == 0) goto L29
            java.lang.String r4 = "1003"
            java.lang.String r5 = "传入参数appkey为空"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> La8
        L29:
            monitor-exit(r3)
            return
        L2b:
            android.content.Context r0 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> La8
            if (r0 == 0) goto L4e
            if (r5 == 0) goto L4e
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La8
            if (r1 != 0) goto L4e
            android.content.SharedPreferences r1 = com.umeng.umzid.C3792a.m12731a(r0)     // Catch: java.lang.Throwable -> La8
            if (r1 == 0) goto L4e
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> La8
            if (r1 == 0) goto L4e
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch: java.lang.Throwable -> La8
            r5.commit()     // Catch: java.lang.Throwable -> La8
        L4e:
            java.lang.String r5 = com.umeng.umzid.C3795d.m12745d(r0)     // Catch: java.lang.Throwable -> La8
            if (r5 == 0) goto L69
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La8
            if (r1 == 0) goto L5b
            goto L69
        L5b:
            com.umeng.umzid.ZIDManager$b r1 = new com.umeng.umzid.ZIDManager$b     // Catch: java.lang.Throwable -> La8
            r1.<init>(r0)     // Catch: java.lang.Throwable -> La8
            com.umeng.umzid.C3794c.m12735a(r1)     // Catch: java.lang.Throwable -> La8
            if (r6 == 0) goto L71
            r6.onSuccess(r5)     // Catch: java.lang.Throwable -> La8
            goto L71
        L69:
            com.umeng.umzid.ZIDManager$a r5 = new com.umeng.umzid.ZIDManager$a     // Catch: java.lang.Throwable -> La8
            r5.<init>(r0, r6)     // Catch: java.lang.Throwable -> La8
            com.umeng.umzid.C3794c.m12735a(r5)     // Catch: java.lang.Throwable -> La8
        L71:
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = com.umeng.umzid.C3792a.m12731a(r4)     // Catch: java.lang.Throwable -> La8
            if (r6 == 0) goto L81
            java.lang.String r5 = "uuid"
            java.lang.String r0 = ""
            java.lang.String r5 = r6.getString(r5, r0)     // Catch: java.lang.Throwable -> La8
        L81:
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La8
            if (r5 == 0) goto La6
            java.lang.String r5 = ""
            android.content.SharedPreferences r4 = com.umeng.umzid.C3792a.m12731a(r4)     // Catch: java.lang.Throwable -> La8
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> La8
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L96
            goto L97
        L96:
        L97:
            if (r4 == 0) goto La6
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> La8
            java.lang.String r6 = "uuid"
            android.content.SharedPreferences$Editor r4 = r4.putString(r6, r5)     // Catch: java.lang.Throwable -> La8
            r4.commit()     // Catch: java.lang.Throwable -> La8
        La6:
            monitor-exit(r3)
            return
        La8:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(37:0|1|(5:90|91|(2:98|99)|93|(34:95|4|5|6|(2:11|(29:15|16|17|18|19|20|(3:71|72|(5:74|75|(2:78|76)|79|80))|22|(1:24)(1:70)|25|(1:27)(1:69)|28|29|30|31|32|33|34|35|36|37|(1:41)|42|43|44|(2:49|(3:53|54|55))|58|54|55))|88|16|17|18|19|20|(0)|22|(0)(0)|25|(0)(0)|28|29|30|31|32|33|34|35|36|37|(2:39|41)|42|43|44|(4:46|47|49|(4:51|53|54|55))|58|54|55))|3|4|5|6|(4:8|9|11|(30:13|15|16|17|18|19|20|(0)|22|(0)(0)|25|(0)(0)|28|29|30|31|32|33|34|35|36|37|(0)|42|43|44|(0)|58|54|55))|88|16|17|18|19|20|(0)|22|(0)(0)|25|(0)(0)|28|29|30|31|32|33|34|35|36|37|(0)|42|43|44|(0)|58|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x016e, code lost:
    
        r2.printStackTrace();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0155, code lost:
    
        r2.printStackTrace();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0131, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0132, code lost:
    
        r2.printStackTrace();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00e7, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject m12728a(android.content.Context r9, org.json.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.m12728a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }
}
