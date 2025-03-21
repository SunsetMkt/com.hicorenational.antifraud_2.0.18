package com.taobao.accs.p198b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.taobao.accs.p199ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.C3355bl;
import com.umeng.analytics.pro.C3397d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.b.a */
/* loaded from: classes.dex */
public class C2966a extends SQLiteOpenHelper {

    /* renamed from: c */
    private static volatile C2966a f9378c;

    /* renamed from: e */
    private static final Lock f9379e = new ReentrantLock();

    /* renamed from: a */
    public int f9380a;

    /* renamed from: b */
    LinkedList<a> f9381b;

    /* renamed from: d */
    private Context f9382d;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.b.a$a */
    private class a {

        /* renamed from: a */
        String f9383a;

        /* renamed from: b */
        Object[] f9384b;

        private a(String str, Object[] objArr) {
            this.f9383a = str;
            this.f9384b = objArr;
        }
    }

    private C2966a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.f9380a = 0;
        this.f9381b = new LinkedList<>();
        this.f9382d = context;
    }

    /* renamed from: a */
    public static C2966a m8950a(Context context) {
        if (f9378c == null) {
            synchronized (C2966a.class) {
                if (f9378c == null) {
                    f9378c = new C2966a(context, Constants.DB_NAME, null, 3);
                }
            }
        }
        return f9378c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (C3042j.m9246a(super.getWritableDatabase().getPath(), 102400)) {
            return super.getWritableDatabase();
        }
        return null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            if (f9379e.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
        } finally {
            f9379e.unlock();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 < i3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }

    /* renamed from: a */
    public void m8955a(String str, String str2, String str3, boolean z, long j2, String str4) {
        if (m8952a(str, str3, z, str4)) {
            m8951a("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j2), str4, str, str3, String.valueOf(z)}, true);
        } else {
            m8951a("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z), Long.valueOf(j2)}, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        if (r0 == null) goto L25;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean m8952a(java.lang.String r12, java.lang.String r13, boolean r14, java.lang.String r15) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            if (r2 != 0) goto Lb
            monitor-exit(r11)
            return r1
        Lb:
            java.lang.String r3 = "traffic"
            java.lang.String r4 = "_id"
            java.lang.String r5 = "date"
            java.lang.String r6 = "host"
            java.lang.String r7 = "serviceid"
            java.lang.String r8 = "bid"
            java.lang.String r9 = "isbackground"
            java.lang.String r10 = "size"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10}     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r5 = "date=? AND host=? AND bid=? AND isbackground=?"
            r6 = 4
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r6[r1] = r15     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r15 = 1
            r6[r15] = r12     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r12 = 2
            r6[r12] = r13     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r12 = 3
            java.lang.String r13 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r6[r12] = r13     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r7 = 0
            r8 = 0
            r9 = 0
            r12 = 100
            java.lang.String r10 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            if (r0 == 0) goto L4f
            int r12 = r0.getCount()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            if (r12 <= 0) goto L4f
            if (r0 == 0) goto L4d
            r0.close()     // Catch: java.lang.Throwable -> L6e
        L4d:
            monitor-exit(r11)
            return r15
        L4f:
            if (r0 == 0) goto L66
        L51:
            r0.close()     // Catch: java.lang.Throwable -> L6e
            goto L66
        L55:
            r12 = move-exception
            goto L68
        L57:
            r12 = move-exception
            java.lang.String r13 = "DBHelper"
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L55
            java.lang.Object[] r14 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.taobao.accs.utl.ALog.m9186w(r13, r12, r14)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L66
            goto L51
        L66:
            monitor-exit(r11)
            return r1
        L68:
            if (r0 == 0) goto L6d
            r0.close()     // Catch: java.lang.Throwable -> L6e
        L6d:
            throw r12     // Catch: java.lang.Throwable -> L6e
        L6e:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.p198b.C2966a.m8952a(java.lang.String, java.lang.String, boolean, java.lang.String):boolean");
    }

    /* renamed from: a */
    public void m8954a() {
        m8951a("DELETE FROM traffic", null, true);
    }

    /* renamed from: a */
    public List<TrafficsMonitor.C3032a> m8953a(boolean z) {
        SQLiteDatabase writableDatabase;
        Cursor query;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (Exception e2) {
                    e = e2;
                }
                if (writableDatabase == null) {
                    return null;
                }
                if (z) {
                    query = writableDatabase.query(C3397d.f11880F, new String[]{C3355bl.f11732d, "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=?", new String[]{UtilityImpl.m9195a(System.currentTimeMillis())}, null, null, null, String.valueOf(100));
                } else {
                    query = writableDatabase.query(C3397d.f11880F, new String[]{C3355bl.f11732d, "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, null, null, null, null, null, String.valueOf(100));
                }
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                try {
                    if (query.moveToFirst()) {
                        do {
                            String string = query.getString(1);
                            String string2 = query.getString(2);
                            String string3 = query.getString(3);
                            String string4 = query.getString(4);
                            boolean booleanValue = Boolean.valueOf(query.getString(5)).booleanValue();
                            long j2 = query.getLong(6);
                            if (string4 != null && j2 > 0) {
                                arrayList.add(new TrafficsMonitor.C3032a(string, string4, string3, booleanValue, string2, j2));
                            }
                        } while (query.moveToNext());
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e3) {
                    cursor = query;
                    e = e3;
                    ALog.m9186w("DBHelper", e.toString(), new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    cursor = query;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        com.taobao.accs.utl.ALog.m9180d("DBHelper", "db is full!", new java.lang.Object[0]);
        onUpgrade(r5, 0, 1);
        r4.f9380a = 0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void m8951a(java.lang.String r5, java.lang.Object[] r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.util.LinkedList<com.taobao.accs.b.a$a> r1 = r4.f9381b     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            com.taobao.accs.b.a$a r2 = new com.taobao.accs.b.a$a     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r3 = 0
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r1.add(r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            java.util.LinkedList<com.taobao.accs.b.a$a> r5 = r4.f9381b     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r6 = 5
            if (r5 > r6) goto L18
            if (r7 == 0) goto L7c
        L18:
            android.database.sqlite.SQLiteDatabase r5 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            if (r5 != 0) goto L20
            monitor-exit(r4)
            return
        L20:
            java.util.LinkedList<com.taobao.accs.b.a$a> r6 = r4.f9381b     // Catch: java.lang.Throwable -> L69
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L69
            if (r6 <= 0) goto L65
            java.util.LinkedList<com.taobao.accs.b.a$a> r6 = r4.f9381b     // Catch: java.lang.Throwable -> L69
            java.lang.Object r6 = r6.removeFirst()     // Catch: java.lang.Throwable -> L69
            com.taobao.accs.b.a$a r6 = (com.taobao.accs.p198b.C2966a.a) r6     // Catch: java.lang.Throwable -> L69
            java.lang.Object[] r7 = r6.f9384b     // Catch: java.lang.Throwable -> L69
            if (r7 == 0) goto L3c
            java.lang.String r7 = r6.f9383a     // Catch: java.lang.Throwable -> L69
            java.lang.Object[] r1 = r6.f9384b     // Catch: java.lang.Throwable -> L69
            r5.execSQL(r7, r1)     // Catch: java.lang.Throwable -> L69
            goto L41
        L3c:
            java.lang.String r7 = r6.f9383a     // Catch: java.lang.Throwable -> L69
            r5.execSQL(r7)     // Catch: java.lang.Throwable -> L69
        L41:
            java.lang.String r6 = r6.f9383a     // Catch: java.lang.Throwable -> L69
            java.lang.String r7 = "INSERT"
            boolean r6 = r6.contains(r7)     // Catch: java.lang.Throwable -> L69
            if (r6 == 0) goto L20
            int r6 = r4.f9380a     // Catch: java.lang.Throwable -> L69
            r7 = 1
            int r6 = r6 + r7
            r4.f9380a = r6     // Catch: java.lang.Throwable -> L69
            int r6 = r4.f9380a     // Catch: java.lang.Throwable -> L69
            r1 = 4000(0xfa0, float:5.605E-42)
            if (r6 <= r1) goto L20
            java.lang.String r6 = "DBHelper"
            java.lang.String r1 = "db is full!"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L69
            com.taobao.accs.utl.ALog.m9180d(r6, r1, r2)     // Catch: java.lang.Throwable -> L69
            r4.onUpgrade(r5, r0, r7)     // Catch: java.lang.Throwable -> L69
            r4.f9380a = r0     // Catch: java.lang.Throwable -> L69
        L65:
            r5.close()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            goto L7c
        L69:
            r6 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            throw r6     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
        L6e:
            r5 = move-exception
            goto L7e
        L70:
            r5 = move-exception
            java.lang.String r6 = "DBHelper"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6e
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L6e
            com.taobao.accs.utl.ALog.m9180d(r6, r5, r7)     // Catch: java.lang.Throwable -> L6e
        L7c:
            monitor-exit(r4)
            return
        L7e:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.p198b.C2966a.m8951a(java.lang.String, java.lang.Object[], boolean):void");
    }
}
