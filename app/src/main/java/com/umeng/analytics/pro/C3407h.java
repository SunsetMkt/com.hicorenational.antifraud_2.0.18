package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: UMDBUtils.java */
/* renamed from: com.umeng.analytics.pro.h */
/* loaded from: classes2.dex */
public class C3407h {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r1 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r1 == null) goto L20;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m11227a(java.lang.String r12, android.database.sqlite.SQLiteDatabase r13) {
        /*
            r0 = 0
            if (r12 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.lang.String r2 = "count(*)"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            r2 = 2
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            java.lang.String r2 = "table"
            r7[r0] = r2     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            java.lang.String r12 = r12.trim()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            r2 = 1
            r7[r2] = r12     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            java.lang.String r4 = "sqlite_master"
            java.lang.String r6 = "type=? and name=?"
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r3 = r13
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            if (r12 == 0) goto L33
            int r12 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            if (r12 <= 0) goto L33
            r0 = 1
        L33:
            if (r1 == 0) goto L44
        L35:
            r1.close()
            goto L44
        L39:
            r12 = move-exception
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            throw r12
        L40:
            if (r1 == 0) goto L44
            goto L35
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.C3407h.m11227a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    /* renamed from: b */
    public static String m11228b(Context context) {
        return context.getDatabasePath(C3404e.f11974b).getParent() + File.separator;
    }

    /* renamed from: c */
    public static String m11230c(Context context) {
        return m11228b(context) + C3404e.f11973a;
    }

    /* renamed from: b */
    public static List<String> m11229b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m11224a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File databasePath = context.getDatabasePath(C3404e.f11974b);
            if (databasePath != null && databasePath.exists()) {
                databasePath.delete();
            }
            C3405f.m11207a(context).m11216a();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static String m11222a(List<String> list) {
        return TextUtils.join("!", list);
    }

    /* renamed from: a */
    public static List<String> m11223a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (r9.isClosed() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r9.isClosed() == false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m11226a(android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, java.lang.String r12) {
        /*
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            java.lang.String r7 = "LIMIT 0"
            r0 = r10
            r1 = r11
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L33
            if (r9 == 0) goto L1a
            int r10 = r9.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L33
            r11 = -1
            if (r10 == r11) goto L1a
            r10 = 1
            r8 = 1
        L1a:
            if (r9 == 0) goto L3d
            boolean r10 = r9.isClosed()
            if (r10 != 0) goto L3d
        L22:
            r9.close()
            goto L3d
        L26:
            r10 = move-exception
            if (r9 == 0) goto L32
            boolean r11 = r9.isClosed()
            if (r11 != 0) goto L32
            r9.close()
        L32:
            throw r10
        L33:
            if (r9 == 0) goto L3d
            boolean r10 = r9.isClosed()
            if (r10 != 0) goto L3d
            goto L22
        L3d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.C3407h.m11226a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static void m11225a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + AbstractC1191a.f2568g + str3);
    }
}
