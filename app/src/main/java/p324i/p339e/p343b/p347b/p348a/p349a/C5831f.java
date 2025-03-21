package p324i.p339e.p343b.p347b.p348a.p349a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import bean.SurveyH5Bean;

/* renamed from: i.e.b.b.a.a.f */
/* loaded from: classes2.dex */
class C5831f {

    /* renamed from: g */
    private static volatile C5831f f20970g = null;

    /* renamed from: h */
    private static boolean f20971h = false;

    /* renamed from: f */
    private BroadcastReceiver f20977f;

    /* renamed from: a */
    C5826a f20972a = new C5826a("udid");

    /* renamed from: b */
    C5826a f20973b = new C5826a("oaid");

    /* renamed from: d */
    C5826a f20975d = new C5826a("vaid");

    /* renamed from: c */
    C5826a f20974c = new C5826a("aaid");

    /* renamed from: e */
    private C5828c f20976e = new C5828c();

    private C5831f() {
    }

    /* renamed from: a */
    private static C5829d m24467a(Cursor cursor) {
        String str;
        C5829d c5829d = new C5829d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(SurveyH5Bean.VALUE);
                if (columnIndex >= 0) {
                    c5829d.f20967a = cursor.getString(columnIndex);
                } else {
                    m24470a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    c5829d.f20968b = cursor.getInt(columnIndex2);
                } else {
                    m24470a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    c5829d.f20969c = cursor.getLong(columnIndex3);
                } else {
                    m24470a("parseExpired fail, index < 0.");
                }
                return c5829d;
            }
            str = "parseValue fail, cursor is closed.";
        }
        m24470a(str);
        return c5829d;
    }

    /* renamed from: a */
    public static final C5831f m24468a() {
        if (f20970g == null) {
            synchronized (C5831f.class) {
                if (f20970g == null) {
                    f20970g = new C5831f();
                }
            }
        }
        return f20970g;
    }

    /* renamed from: a */
    private static String m24469a(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    /* renamed from: a */
    static void m24470a(String str) {
        boolean z = f20971h;
    }

    /* renamed from: a */
    public static void m24471a(boolean z) {
        f20971h = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if (r7 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        if (r7 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        if ("0".equals(r8.f20967a) != false) goto L9;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m24472a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            m24470a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3 = 0
            r4 = 0
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r7 == 0) goto L3b
            i.e.b.b.a.a.d r8 = m24467a(r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r8.f20968b     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r1 != r2) goto L34
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.f20967a     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r8 == 0) goto L35
        L34:
            r0 = 1
        L35:
            if (r7 == 0) goto L3a
            r7.close()
        L3a:
            return r0
        L3b:
            if (r7 == 0) goto L5c
        L3d:
            r7.close()
            goto L5c
        L41:
            r8 = move-exception
            goto L5d
        L43:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L41
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L41
            r1.append(r8)     // Catch: java.lang.Throwable -> L41
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L41
            m24470a(r8)     // Catch: java.lang.Throwable -> L41
            if (r7 == 0) goto L5c
            goto L3d
        L5c:
            return r0
        L5d:
            if (r7 == 0) goto L62
            r7.close()
        L62:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p324i.p339e.p343b.p347b.p348a.p349a.C5831f.m24472a(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v0, types: [i.e.b.b.a.a.a] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m24473b(android.content.Context r10, p324i.p339e.p343b.p347b.p348a.p349a.C5826a r11) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.f20961c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            m24470a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r6 = r11.f20961c     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            if (r1 == 0) goto L7e
            i.e.b.b.a.a.d r2 = m24467a(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r0 = r2.f20967a     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.m24453a(r0)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            long r3 = r2.f20969c     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.m24452a(r3)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r3 = r2.f20968b     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.m24451a(r3)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.<init>()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r4 = r11.f20961c     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.append(r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r11 = r11.f20962d     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.append(r11)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            m24470a(r11)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r11 = r2.f20968b     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L93
            r9.m24475b(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            boolean r11 = r9.m24477a(r10, r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r11 != 0) goto L93
            boolean r10 = r9.m24477a(r10, r7)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
        L7a:
            m24470a(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            goto L93
        L7e:
            boolean r11 = r9.m24477a(r10, r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r11 == 0) goto L93
            boolean r10 = r9.m24477a(r10, r7)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            goto L7a
        L93:
            if (r1 == 0) goto L98
            r1.close()
        L98:
            r11 = r0
            goto Lbf
        L9a:
            r10 = move-exception
            goto Lc0
        L9c:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto La5
        La0:
            r10 = move-exception
            r1 = r0
            goto Lc0
        La3:
            r10 = move-exception
            r11 = r0
        La5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> La0
            r1.append(r10)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> La0
            m24470a(r10)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto Lbf
            r0.close()
        Lbf:
            return r11
        Lc0:
            if (r1 == 0) goto Lc5
            r1.close()
        Lc5:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p324i.p339e.p343b.p347b.p348a.p349a.C5831f.m24473b(android.content.Context, i.e.b.b.a.a.a):java.lang.String");
    }

    /* renamed from: b */
    private static String m24474b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            m24470a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private synchronized void m24475b(Context context) {
        if (this.f20977f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        this.f20977f = new C5830e();
        context.registerReceiver(this.f20977f, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    /* renamed from: a */
    final String m24476a(Context context, C5826a c5826a) {
        String str;
        if (c5826a == null) {
            str = "getId, openId = null.";
        } else {
            if (c5826a.m24454a()) {
                return c5826a.f20960b;
            }
            if (m24477a(context, true)) {
                return m24473b(context, c5826a);
            }
            str = "getId, isSupported = false.";
        }
        m24470a(str);
        return null;
    }

    /* renamed from: a */
    final boolean m24477a(Context context, boolean z) {
        if (this.f20976e.m24463a() && !z) {
            return this.f20976e.m24466b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String m24469a = m24469a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(m24469a)) {
            return false;
        }
        String m24474b = m24474b(packageManager, m24469a);
        if (this.f20976e.m24463a() && this.f20976e.m24464a(m24474b)) {
            m24470a("use same version cache, safeVersion : ".concat(String.valueOf(m24474b)));
            return this.f20976e.m24466b();
        }
        this.f20976e.m24465b(m24474b);
        boolean m24472a = m24472a(context);
        m24470a("query support, result : ".concat(String.valueOf(m24472a)));
        this.f20976e.m24462a(m24472a);
        return m24472a;
    }
}
