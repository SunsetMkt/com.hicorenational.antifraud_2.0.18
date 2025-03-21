package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* renamed from: com.xiaomi.push.aq */
/* loaded from: classes2.dex */
class C4088aq implements InterfaceC4080ai {

    /* renamed from: a */
    private static String f14560a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* renamed from: b */
    private static String f14561b = f14560a + "OAID";

    /* renamed from: c */
    private static String f14562c = f14560a + "VAID_";

    /* renamed from: d */
    private static String f14563d = f14560a + "AAID_";

    /* renamed from: e */
    private static String f14564e = f14560a + "OAIDSTATUS";

    /* renamed from: f */
    private static String f14565f = "persist.sys.identifierid.supported";

    /* renamed from: a */
    private Context f14566a;

    public C4088aq(Context context) {
        this.f14566a = context;
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public boolean mo13737a() {
        return "1".equals(C4308q.m15713a(f14565f, "0"));
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public String mo13736a() {
        return m13775a(f14561b);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m13775a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.f14566a     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L3a
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C4088aq.m13775a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m13776a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f14560a).getAuthority(), 128);
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
