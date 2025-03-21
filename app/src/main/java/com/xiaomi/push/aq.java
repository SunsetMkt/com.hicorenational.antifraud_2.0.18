package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* loaded from: classes2.dex */
class aq implements ai {

    /* renamed from: a, reason: collision with root package name */
    private static String f12452a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* renamed from: b, reason: collision with root package name */
    private static String f12453b = f12452a + "OAID";

    /* renamed from: c, reason: collision with root package name */
    private static String f12454c = f12452a + "VAID_";

    /* renamed from: d, reason: collision with root package name */
    private static String f12455d = f12452a + "AAID_";

    /* renamed from: e, reason: collision with root package name */
    private static String f12456e = f12452a + "OAIDSTATUS";

    /* renamed from: f, reason: collision with root package name */
    private static String f12457f = "persist.sys.identifierid.supported";

    /* renamed from: a, reason: collision with other field name */
    private Context f194a;

    public aq(Context context) {
        this.f194a = context;
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public boolean mo137a() {
        return "1".equals(q.a(f12457f, "0"));
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public String mo136a() {
        return a(f12453b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if (r10 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002d, code lost:
    
        if (r10 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.f194a     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L3a
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L3a
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L3a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L3a
            if (r10 == 0) goto L2d
            boolean r1 = r10.moveToNext()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2b
            if (r1 == 0) goto L2d
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2b
            java.lang.String r0 = r10.getString(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2b
            goto L2d
        L26:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L34
        L2b:
            goto L3b
        L2d:
            if (r10 == 0) goto L3e
        L2f:
            r10.close()
            goto L3e
        L33:
            r10 = move-exception
        L34:
            if (r0 == 0) goto L39
            r0.close()
        L39:
            throw r10
        L3a:
            r10 = r0
        L3b:
            if (r10 == 0) goto L3e
            goto L2f
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.aq.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f12452a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
