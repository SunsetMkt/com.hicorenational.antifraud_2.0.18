package com.alibaba.sdk.android.httpdns.p112b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.alibaba.sdk.android.httpdns.b.d */
/* loaded from: classes.dex */
class C1507d extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final Object f3855a = new Object();

    C1507d(Context context) {
        super(context, "aliclound_httpdns.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: a */
    private long m3446a(SQLiteDatabase sQLiteDatabase, C1510g c1510g) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(c1510g.f3863i));
        contentValues.put("ip", c1510g.f3865o);
        contentValues.put(RemoteMessageConst.TTL, c1510g.f3866p);
        try {
            return sQLiteDatabase.insert("ip", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
    
        if (r10 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008d, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:
    
        if (r10 != null) goto L29;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.alibaba.sdk.android.httpdns.p112b.C1510g> m3447a(long r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L85
            java.lang.String r3 = "ip"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r2 = 0
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r6[r2] = r12     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r1 == 0) goto L6c
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r12 <= 0) goto L6c
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
        L2c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f3864id = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f3863i = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f3865o = r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f3866p = r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r0.add(r12)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r12 != 0) goto L2c
        L6c:
            if (r1 == 0) goto L71
            r1.close()
        L71:
            if (r10 == 0) goto L90
            goto L8d
        L74:
            r12 = move-exception
            goto L7a
        L76:
            goto L86
        L78:
            r12 = move-exception
            r10 = r1
        L7a:
            if (r1 == 0) goto L7f
            r1.close()
        L7f:
            if (r10 == 0) goto L84
            r10.close()
        L84:
            throw r12
        L85:
            r10 = r1
        L86:
            if (r1 == 0) goto L8b
            r1.close()
        L8b:
            if (r10 == 0) goto L90
        L8d:
            r10.close()
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.p112b.C1507d.m3447a(long):java.util.List");
    }

    /* renamed from: a */
    private List<C1510g> m3448a(C1508e c1508e) {
        return m3447a(c1508e.f3860id);
    }

    /* renamed from: a */
    private void m3449a(long j2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete(Constants.KEY_HOST, "id = ?", new String[]{String.valueOf(j2)});
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    /* renamed from: a */
    private void m3450a(C1510g c1510g) {
        m3454b(c1510g.f3864id);
    }

    /* renamed from: b */
    private long m3451b(SQLiteDatabase sQLiteDatabase, C1510g c1510g) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(c1510g.f3863i));
        contentValues.put("ip", c1510g.f3865o);
        contentValues.put(RemoteMessageConst.TTL, c1510g.f3866p);
        try {
            return sQLiteDatabase.insert("ipv6", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
    
        if (r10 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008d, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:
    
        if (r10 != null) goto L29;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.alibaba.sdk.android.httpdns.p112b.C1510g> m3452b(long r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L85
            java.lang.String r3 = "ipv6"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r2 = 0
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r6[r2] = r12     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r1 == 0) goto L6c
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r12 <= 0) goto L6c
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
        L2c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f3864id = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f3863i = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f3865o = r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f3866p = r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r0.add(r12)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r12 != 0) goto L2c
        L6c:
            if (r1 == 0) goto L71
            r1.close()
        L71:
            if (r10 == 0) goto L90
            goto L8d
        L74:
            r12 = move-exception
            goto L7a
        L76:
            goto L86
        L78:
            r12 = move-exception
            r10 = r1
        L7a:
            if (r1 == 0) goto L7f
            r1.close()
        L7f:
            if (r10 == 0) goto L84
            r10.close()
        L84:
            throw r12
        L85:
            r10 = r1
        L86:
            if (r1 == 0) goto L8b
            r1.close()
        L8b:
            if (r10 == 0) goto L90
        L8d:
            r10.close()
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.p112b.C1507d.m3452b(long):java.util.List");
    }

    /* renamed from: b */
    private List<C1510g> m3453b(C1508e c1508e) {
        return m3452b(c1508e.f3860id);
    }

    /* renamed from: b */
    private void m3454b(long j2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete("ip", "id = ?", new String[]{String.valueOf(j2)});
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    /* renamed from: b */
    private void m3455b(C1510g c1510g) {
        m3456c(c1510g.f3864id);
    }

    /* renamed from: c */
    private void m3456c(long j2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete("ipv6", "id = ?", new String[]{String.valueOf(j2)});
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    /* renamed from: c */
    private void m3457c(C1508e c1508e) {
        m3449a(c1508e.f3860id);
    }

    /* renamed from: a */
    long m3458a(C1508e c1508e) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (f3855a) {
            m3461b(c1508e.f3861m, c1508e.host);
            ContentValues contentValues = new ContentValues();
            try {
                sQLiteDatabase = getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    contentValues.put(Constants.KEY_HOST, c1508e.host);
                    contentValues.put("sp", c1508e.f3861m);
                    contentValues.put("time", C1506c.m3444c(c1508e.f3862n));
                    contentValues.put("extra", c1508e.f3856a);
                    contentValues.put("cache_key", c1508e.f3858b);
                    long insert = sQLiteDatabase.insert(Constants.KEY_HOST, null, contentValues);
                    c1508e.f3860id = insert;
                    if (c1508e.f3857a != null) {
                        Iterator<C1510g> it = c1508e.f3857a.iterator();
                        while (it.hasNext()) {
                            C1510g next = it.next();
                            next.f3863i = insert;
                            next.f3864id = m3446a(sQLiteDatabase, next);
                        }
                    }
                    if (c1508e.f3859b != null) {
                        Iterator<C1510g> it2 = c1508e.f3859b.iterator();
                        while (it2.hasNext()) {
                            C1510g next2 = it2.next();
                            next2.f3863i = insert;
                            next2.f3864id = m3451b(sQLiteDatabase, next2);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.close();
                    }
                    return insert;
                } catch (Exception unused) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.close();
                    }
                    return 0L;
                } catch (Throwable th) {
                    th = th;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                sQLiteDatabase = null;
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0098, code lost:
    
        if (r10 == null) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0095 A[Catch: all -> 0x00bb, TRY_ENTER, TryCatch #3 {all -> 0x00bb, blocks: (B:12:0x0095, B:14:0x009a, B:15:0x00c0, B:28:0x00b7, B:34:0x00a9, B:36:0x00ae, B:37:0x00b1), top: B:4:0x0004 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.alibaba.sdk.android.httpdns.p112b.C1508e m3459a(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.Object r0 = com.alibaba.sdk.android.httpdns.p112b.C1507d.f3855a
            monitor-enter(r0)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb2
            java.lang.String r3 = "host"
            r4 = 0
            java.lang.String r5 = "sp=? AND host=?"
            r2 = 2
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r2 = 0
            r6[r2] = r12     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r12 = 1
            r6[r12] = r13     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            if (r12 == 0) goto L92
            int r13 = r12.getCount()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            if (r13 <= 0) goto L92
            r12.moveToFirst()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            com.alibaba.sdk.android.httpdns.b.e r13 = new com.alibaba.sdk.android.httpdns.b.e     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r13.<init>()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r1 = "id"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            int r1 = r12.getInt(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            long r1 = (long) r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f3860id = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "host"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.host = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "sp"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f3861m = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "time"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = com.alibaba.sdk.android.httpdns.p112b.C1506c.m3445d(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f3862n = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.util.List r1 = r11.m3448a(r13)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f3857a = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.util.List r1 = r11.m3453b(r13)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f3859b = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "extra"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f3856a = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "cache_key"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f3858b = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            goto L93
        L8c:
            goto Lb5
        L8e:
            r13 = move-exception
            goto La7
        L90:
            r13 = r1
            goto Lb5
        L92:
            r13 = r1
        L93:
            if (r12 == 0) goto L98
            r12.close()     // Catch: java.lang.Throwable -> Lbb
        L98:
            if (r10 == 0) goto Lc0
        L9a:
            r10.close()     // Catch: java.lang.Throwable -> Lbb
            goto Lc0
        L9e:
            r13 = move-exception
            r12 = r1
            goto La7
        La1:
            r12 = r1
            r13 = r12
            goto Lb5
        La4:
            r13 = move-exception
            r12 = r1
            r10 = r12
        La7:
            if (r12 == 0) goto Lac
            r12.close()     // Catch: java.lang.Throwable -> Lbb
        Lac:
            if (r10 == 0) goto Lb1
            r10.close()     // Catch: java.lang.Throwable -> Lbb
        Lb1:
            throw r13     // Catch: java.lang.Throwable -> Lbb
        Lb2:
            r12 = r1
            r13 = r12
            r10 = r13
        Lb5:
            if (r12 == 0) goto Lbd
            r12.close()     // Catch: java.lang.Throwable -> Lbb
            goto Lbd
        Lbb:
            r12 = move-exception
            goto Lc2
        Lbd:
            if (r10 == 0) goto Lc0
            goto L9a
        Lc0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbb
            return r13
        Lc2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbb
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.p112b.C1507d.m3459a(java.lang.String, java.lang.String):com.alibaba.sdk.android.httpdns.b.e");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
    
        if (r11 != null) goto L17;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.List<com.alibaba.sdk.android.httpdns.p112b.C1508e> m3460b() {
        /*
            r12 = this;
            java.lang.Object r0 = com.alibaba.sdk.android.httpdns.p112b.C1507d.f3855a
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb7
            r1.<init>()     // Catch: java.lang.Throwable -> Lb7
            r2 = 0
            android.database.sqlite.SQLiteDatabase r11 = r12.getReadableDatabase()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> Lac
            java.lang.String r4 = "host"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r11
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r2 == 0) goto L90
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r3 <= 0) goto L90
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
        L25:
            com.alibaba.sdk.android.httpdns.b.e r3 = new com.alibaba.sdk.android.httpdns.b.e     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.<init>()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = "id"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r4 = r2.getInt(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.f3860id = r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = "host"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.host = r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = "sp"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.f3861m = r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = "time"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = com.alibaba.sdk.android.httpdns.p112b.C1506c.m3445d(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.f3862n = r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.util.List r4 = r12.m3448a(r3)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.f3857a = r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.util.List r4 = r12.m3453b(r3)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.f3859b = r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = "extra"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.f3856a = r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = "cache_key"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3.f3858b = r4     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r1.add(r3)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r3 != 0) goto L25
        L90:
            if (r2 == 0) goto L95
            r2.close()     // Catch: java.lang.Throwable -> Lb7
        L95:
            if (r11 == 0) goto Lb5
        L97:
            r11.close()     // Catch: java.lang.Throwable -> Lb7
            goto Lb5
        L9b:
            r1 = move-exception
            goto La1
        L9d:
            goto Lad
        L9f:
            r1 = move-exception
            r11 = r2
        La1:
            if (r2 == 0) goto La6
            r2.close()     // Catch: java.lang.Throwable -> Lb7
        La6:
            if (r11 == 0) goto Lab
            r11.close()     // Catch: java.lang.Throwable -> Lb7
        Lab:
            throw r1     // Catch: java.lang.Throwable -> Lb7
        Lac:
            r11 = r2
        Lad:
            if (r2 == 0) goto Lb2
            r2.close()     // Catch: java.lang.Throwable -> Lb7
        Lb2:
            if (r11 == 0) goto Lb5
            goto L97
        Lb5:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb7
            return r1
        Lb7:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb7
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.p112b.C1507d.m3460b():java.util.List");
    }

    /* renamed from: b */
    void m3461b(String str, String str2) {
        synchronized (f3855a) {
            C1508e m3459a = m3459a(str, str2);
            if (m3459a != null) {
                m3457c(m3459a);
                if (m3459a.f3857a != null) {
                    Iterator<C1510g> it = m3459a.f3857a.iterator();
                    while (it.hasNext()) {
                        m3450a(it.next());
                    }
                }
                if (m3459a.f3859b != null) {
                    Iterator<C1510g> it2 = m3459a.f3859b.iterator();
                    while (it2.hasNext()) {
                        m3455b(it2.next());
                    }
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE host (id INTEGER PRIMARY KEY,host TEXT,sp TEXT,time TEXT,extra TEXT,cache_key TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ip (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ipv6 (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 != i3) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS host;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ip;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ipv6;");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } catch (Exception unused) {
            }
        }
    }
}
