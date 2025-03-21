package com.umeng.message.proguard;

import android.app.Application;
import android.content.ContentValues;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class aq {

    /* renamed from: a, reason: collision with root package name */
    private final String f11298a;

    public aq(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + c.c.a.b.a.a.s1;
        }
        this.f11298a = str;
    }

    private String b(String str) {
        return this.f11298a + str;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(java.lang.String r9, java.lang.String r10) {
        /*
            r0 = 0
            android.app.Application r1 = com.umeng.message.proguard.x.a()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            boolean r2 = com.umeng.message.proguard.f.b(r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r2 == 0) goto L16
            com.umeng.message.proguard.ap r1 = com.umeng.message.proguard.ap.a()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            android.content.SharedPreferences r1 = r1.f11297a     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r9 = r1.getString(r9, r10)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            return r9
        L16:
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2 = 0
            r7[r2] = r9     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            android.net.Uri r4 = com.umeng.message.proguard.h.c(r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
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
            com.umeng.message.common.UPLog.e(r1, r9)     // Catch: java.lang.Throwable -> L4a
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
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.aq.c(java.lang.String, java.lang.String):java.lang.String");
    }

    private static void d(String str, String str2) {
        try {
            Application a2 = x.a();
            if (f.b(a2)) {
                ap.a().a(str, str2);
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("k", str);
            contentValues.put("v", str2);
            a2.getContentResolver().insert(h.c(a2), contentValues);
        } catch (Exception e2) {
            UPLog.e("KV", e2);
        }
    }

    public final void a(String str, int i2) {
        d(b(str), String.valueOf(i2));
    }

    public final void a(String str, long j2) {
        d(b(str), String.valueOf(j2));
    }

    public final Set<String> b(String str, Set<String> set) {
        try {
            String c2 = c(b(str), "");
            if (!TextUtils.isEmpty(c2)) {
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = new JSONArray(c2);
                int length = jSONArray.length();
                if (length > 0) {
                    for (int i2 = 0; i2 < length; i2++) {
                        hashSet.add(jSONArray.optString(i2));
                    }
                }
                return hashSet;
            }
        } catch (Throwable th) {
            UPLog.e("KV", th);
        }
        return set;
    }

    public final void a(String str, String str2) {
        d(b(str), String.valueOf(str2));
    }

    public final void a(String str, boolean z) {
        d(b(str), String.valueOf(z));
    }

    public final void a(String str, Set<String> set) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (set != null) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            d(b(str), jSONArray.toString());
        } catch (Throwable th) {
            UPLog.e("KV", th);
        }
    }

    public final int b(String str, int i2) {
        String c2 = c(b(str), String.valueOf(i2));
        if (!TextUtils.isEmpty(c2)) {
            try {
                return Integer.parseInt(c2);
            } catch (Exception e2) {
                UPLog.e("KV", e2);
            }
        }
        return i2;
    }

    public final void a(String str) {
        c(b(str));
    }

    public final long b(String str, long j2) {
        String c2 = c(b(str), String.valueOf(j2));
        if (!TextUtils.isEmpty(c2)) {
            try {
                return Long.parseLong(c2);
            } catch (Exception e2) {
                UPLog.e("KV", e2);
            }
        }
        return j2;
    }

    private static void c(String str) {
        try {
            Application a2 = x.a();
            if (f.b(a2)) {
                ap.a().a(str);
            } else {
                a2.getContentResolver().delete(h.c(a2), null, new String[]{str});
            }
        } catch (Throwable th) {
            UPLog.e("KV", th);
        }
    }

    public final boolean b(String str, boolean z) {
        String c2 = c(b(str), String.valueOf(z));
        if (!TextUtils.isEmpty(c2)) {
            try {
                return Boolean.parseBoolean(c2);
            } catch (Exception e2) {
                UPLog.e("KV", e2);
            }
        }
        return z;
    }

    public final String b(String str, String str2) {
        return c(b(str), str2);
    }
}
