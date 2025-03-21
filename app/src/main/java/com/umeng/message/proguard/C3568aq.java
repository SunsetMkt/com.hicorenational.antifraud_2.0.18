package com.umeng.message.proguard;

import android.app.Application;
import android.content.ContentValues;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.umeng.message.proguard.aq */
/* loaded from: classes2.dex */
public final class C3568aq {

    /* renamed from: a */
    private final String f13226a;

    public C3568aq(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + AbstractC1191a.f2606s1;
        }
        this.f13226a = str;
    }

    /* renamed from: b */
    private String m12278b(String str) {
        return this.f13226a + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r0 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        if (0 == 0) goto L25;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m12279c(java.lang.String r9, java.lang.String r10) {
        /*
            r0 = 0
            android.app.Application r1 = com.umeng.message.proguard.C3604x.m12460a()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            boolean r2 = com.umeng.message.proguard.C3586f.m12390b(r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r2 == 0) goto L16
            com.umeng.message.proguard.ap r1 = com.umeng.message.proguard.C3567ap.m12275a()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            android.content.SharedPreferences r1 = r1.f13225a     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r9 = r1.getString(r9, r10)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            return r9
        L16:
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2 = 0
            r7[r2] = r9     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            android.net.Uri r4 = com.umeng.message.proguard.C3588h.m12404c(r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r5 = 0
            r6 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r0 != 0) goto L33
            if (r0 == 0) goto L32
            r0.close()     // Catch: java.lang.Throwable -> L32
        L32:
            return r10
        L33:
            boolean r9 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r9 == 0) goto L44
            java.lang.String r9 = "v"
            int r9 = r0.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r9 = r0.getString(r9)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r10 = r9
        L44:
            if (r0 == 0) goto L55
        L46:
            r0.close()     // Catch: java.lang.Throwable -> L55
            goto L55
        L4a:
            r9 = move-exception
            goto L56
        L4c:
            r9 = move-exception
            java.lang.String r1 = "KV"
            com.umeng.message.common.UPLog.m12143e(r1, r9)     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L55
            goto L46
        L55:
            return r10
        L56:
            if (r0 == 0) goto L5b
            r0.close()     // Catch: java.lang.Throwable -> L5b
        L5b:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.C3568aq.m12279c(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    private static void m12281d(String str, String str2) {
        try {
            Application m12460a = C3604x.m12460a();
            if (C3586f.m12390b(m12460a)) {
                C3567ap.m12275a().m12277a(str, str2);
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("k", str);
            contentValues.put("v", str2);
            m12460a.getContentResolver().insert(C3588h.m12404c(m12460a), contentValues);
        } catch (Exception e2) {
            UPLog.m12143e("KV", e2);
        }
    }

    /* renamed from: a */
    public final void m12283a(String str, int i2) {
        m12281d(m12278b(str), String.valueOf(i2));
    }

    /* renamed from: a */
    public final void m12284a(String str, long j2) {
        m12281d(m12278b(str), String.valueOf(j2));
    }

    /* renamed from: b */
    public final Set<String> m12291b(String str, Set<String> set) {
        try {
            String m12279c = m12279c(m12278b(str), "");
            if (!TextUtils.isEmpty(m12279c)) {
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = new JSONArray(m12279c);
                int length = jSONArray.length();
                if (length > 0) {
                    for (int i2 = 0; i2 < length; i2++) {
                        hashSet.add(jSONArray.optString(i2));
                    }
                }
                return hashSet;
            }
        } catch (Throwable th) {
            UPLog.m12143e("KV", th);
        }
        return set;
    }

    /* renamed from: a */
    public final void m12285a(String str, String str2) {
        m12281d(m12278b(str), String.valueOf(str2));
    }

    /* renamed from: a */
    public final void m12287a(String str, boolean z) {
        m12281d(m12278b(str), String.valueOf(z));
    }

    /* renamed from: a */
    public final void m12286a(String str, Set<String> set) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (set != null) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            m12281d(m12278b(str), jSONArray.toString());
        } catch (Throwable th) {
            UPLog.m12143e("KV", th);
        }
    }

    /* renamed from: b */
    public final int m12288b(String str, int i2) {
        String m12279c = m12279c(m12278b(str), String.valueOf(i2));
        if (!TextUtils.isEmpty(m12279c)) {
            try {
                return Integer.parseInt(m12279c);
            } catch (Exception e2) {
                UPLog.m12143e("KV", e2);
            }
        }
        return i2;
    }

    /* renamed from: a */
    public final void m12282a(String str) {
        m12280c(m12278b(str));
    }

    /* renamed from: b */
    public final long m12289b(String str, long j2) {
        String m12279c = m12279c(m12278b(str), String.valueOf(j2));
        if (!TextUtils.isEmpty(m12279c)) {
            try {
                return Long.parseLong(m12279c);
            } catch (Exception e2) {
                UPLog.m12143e("KV", e2);
            }
        }
        return j2;
    }

    /* renamed from: c */
    private static void m12280c(String str) {
        try {
            Application m12460a = C3604x.m12460a();
            if (C3586f.m12390b(m12460a)) {
                C3567ap.m12275a().m12276a(str);
            } else {
                m12460a.getContentResolver().delete(C3588h.m12404c(m12460a), null, new String[]{str});
            }
        } catch (Throwable th) {
            UPLog.m12143e("KV", th);
        }
    }

    /* renamed from: b */
    public final boolean m12292b(String str, boolean z) {
        String m12279c = m12279c(m12278b(str), String.valueOf(z));
        if (!TextUtils.isEmpty(m12279c)) {
            try {
                return Boolean.parseBoolean(m12279c);
            } catch (Exception e2) {
                UPLog.m12143e("KV", e2);
            }
        }
        return z;
    }

    /* renamed from: b */
    public final String m12290b(String str, String str2) {
        return m12279c(m12278b(str), str2);
    }
}
