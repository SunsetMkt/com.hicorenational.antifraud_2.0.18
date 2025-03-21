package com.umeng.socialize.net.dplus.p220db;

import android.content.Context;
import com.umeng.socialize.utils.ContextUtil;

/* loaded from: classes2.dex */
public class DBManager {

    /* renamed from: a */
    private static DBManager f13761a;

    /* renamed from: b */
    private static StandardDBHelper f13762b;

    private DBManager() {
        f13762b = new StandardDBHelper(ContextUtil.getContext());
    }

    public static synchronized DBManager get(Context context) {
        DBManager dBManager;
        synchronized (DBManager.class) {
            if (f13761a == null) {
                f13761a = new DBManager();
            }
            dBManager = f13761a;
        }
        return dBManager;
    }

    public synchronized void closeDatabase() {
        f13762b.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        if (r0 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r0 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void delete(java.util.ArrayList<java.lang.Integer> r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p220db.DBManager.f13762b     // Catch: java.lang.Throwable -> L43
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L43
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L43
            r1 = 0
        Lc:
            int r2 = r5.size()     // Catch: java.lang.Throwable -> L43
            if (r1 >= r2) goto L3a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r2.<init>()     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "delete from "
            r2.append(r3)     // Catch: java.lang.Throwable -> L43
            r2.append(r6)     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = " where Id='"
            r2.append(r3)     // Catch: java.lang.Throwable -> L43
            java.lang.Object r3 = r5.get(r1)     // Catch: java.lang.Throwable -> L43
            r2.append(r3)     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "' "
            r2.append(r3)     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L43
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L43
            int r1 = r1 + 1
            goto Lc
        L3a:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L46
        L3f:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L46
            goto L46
        L43:
            if (r0 == 0) goto L46
            goto L3f
        L46:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p220db.DBManager.delete(java.util.ArrayList, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r0 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
    
        if (r0 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void deleteTable(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p220db.DBManager.f13762b     // Catch: java.lang.Throwable -> L2d
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2d
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d
            r1.<init>()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = "DELETE FROM "
            r1.append(r2)     // Catch: java.lang.Throwable -> L2d
            r1.append(r4)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r4 = ";"
            r1.append(r4)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L2d
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L2d
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L30
        L29:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L30
            goto L30
        L2d:
            if (r0 == 0) goto L30
            goto L29
        L30:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p220db.DBManager.deleteTable(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertAuth(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p220db.DBManager.f13762b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "auth"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p220db.DBManager.insertAuth(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertDau(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p220db.DBManager.f13762b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "dau"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p220db.DBManager.insertDau(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertS_E(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p220db.DBManager.f13762b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "s_e"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p220db.DBManager.insertS_E(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertStats(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p220db.DBManager.f13762b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "stats"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p220db.DBManager.insertStats(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertUserInfo(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p220db.DBManager.f13762b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "userinfo"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p220db.DBManager.insertUserInfo(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (r3 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        r3.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0074, code lost:
    
        if (r3 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized org.json.JSONArray select(java.lang.String r13, java.util.ArrayList<java.lang.Integer> r14, double r15, boolean r17) throws org.json.JSONException {
        /*
            r12 = this;
            r0 = r14
            monitor-enter(r12)
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L89
            r1.<init>()     // Catch: java.lang.Throwable -> L89
            r2 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r3 = com.umeng.socialize.net.dplus.p220db.DBManager.f13762b     // Catch: java.lang.Throwable -> L6e org.json.JSONException -> L79
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L6e org.json.JSONException -> L79
            r3.beginTransaction()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r3
            r5 = r13
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
        L1d:
            boolean r4 = r2.moveToNext()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            if (r4 == 0) goto L5e
            r4 = 0
            int r4 = r2.getInt(r4)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r5 = 1
            java.lang.String r5 = r2.getString(r5)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            if (r17 == 0) goto L44
            java.lang.String r6 = r1.toString()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            byte[] r6 = r6.getBytes()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            int r6 = r6.length     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            byte[] r7 = r5.getBytes()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            int r7 = r7.length     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            int r6 = r6 + r7
            double r6 = (double) r6     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            int r8 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r8 <= 0) goto L44
            goto L5e
        L44:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r6.<init>(r5)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r1.put(r6)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            boolean r5 = r14.contains(r5)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            if (r5 != 0) goto L1d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r14.add(r4)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            goto L1d
        L5e:
            r3.setTransactionSuccessful()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.lang.Throwable -> L77
        L66:
            if (r3 == 0) goto L77
        L68:
            r3.endTransaction()     // Catch: java.lang.Throwable -> L77
            goto L77
        L6c:
            r0 = move-exception
            goto L7b
        L6e:
            r3 = r2
        L6f:
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.lang.Throwable -> L77
        L74:
            if (r3 == 0) goto L77
            goto L68
        L77:
            monitor-exit(r12)
            return r1
        L79:
            r0 = move-exception
            r3 = r2
        L7b:
            throw r0     // Catch: java.lang.Throwable -> L7c
        L7c:
            r0 = move-exception
            r1 = r0
            if (r2 == 0) goto L83
            r2.close()     // Catch: java.lang.Throwable -> L88
        L83:
            if (r3 == 0) goto L88
            r3.endTransaction()     // Catch: java.lang.Throwable -> L88
        L88:
            throw r1     // Catch: java.lang.Throwable -> L89
        L89:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p220db.DBManager.select(java.lang.String, java.util.ArrayList, double, boolean):org.json.JSONArray");
    }
}
