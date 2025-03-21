package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: CacheDBHelper.java */
/* renamed from: com.umeng.analytics.pro.bj */
/* loaded from: classes2.dex */
public class C3353bj extends SQLiteOpenHelper {

    /* renamed from: b */
    private static final Object f11717b = new Object();

    /* renamed from: c */
    private static C3353bj f11718c = null;

    /* renamed from: d */
    private static final String f11719d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* renamed from: e */
    private static final String f11720e = "DROP TABLE IF EXISTS stf";

    /* renamed from: f */
    private static final String f11721f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* renamed from: a */
    private final Context f11722a;

    private C3353bj(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.f11722a = context;
    }

    /* renamed from: a */
    public static final int m10986a() {
        return 1;
    }

    /* renamed from: a */
    public static C3353bj m10987a(Context context) {
        C3353bj c3353bj;
        synchronized (f11717b) {
            if (f11718c == null) {
                f11718c = new C3353bj(context, C3355bl.f11730b, null, 1);
            }
            c3353bj = f11718c;
        }
        return c3353bj;
    }

    /* renamed from: b */
    private void m10989b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f11719d);
        } catch (SQLiteDatabaseCorruptException unused) {
            m10988a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    /* renamed from: d */
    private void m10990d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f11721f);
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: c */
    public boolean m10998c() {
        return !m10997b(C3355bl.f11731c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m10989b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* renamed from: b */
    public void m10996b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m10988a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f11720e);
            sQLiteDatabase.execSQL(f11719d);
        } catch (SQLException unused) {
        }
    }

    /* renamed from: b */
    public boolean m10997b(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.isOpen()) {
                        cursor = sQLiteDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return false;
                    }
                    sQLiteDatabase.close();
                    return false;
                }
            }
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase == null) {
                return false;
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        sQLiteDatabase.close();
        return false;
    }

    /* renamed from: a */
    public void m10993a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m10995a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x006d, code lost:
    
        if (r1 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x006f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x007a, code lost:
    
        return r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.umeng.analytics.pro.C3354bk m10992a(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r1 = "_uuid"
            java.lang.String r2 = "_tp"
            java.lang.String r3 = "_hd"
            java.lang.String r4 = "_bd"
            java.lang.String r5 = "_re1"
            java.lang.String r6 = "_re2"
            java.lang.String[] r3 = new java.lang.String[]{r1, r2, r3, r4, r5, r6}     // Catch: java.lang.Throwable -> L73
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "1"
            r1 = r10
            r2 = r11
            android.database.Cursor r1 = r1.m10991a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L6d
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L6d
            com.umeng.analytics.pro.bk r2 = new com.umeng.analytics.pro.bk     // Catch: java.lang.Throwable -> L74
            r2.<init>()     // Catch: java.lang.Throwable -> L74
            r0 = 0
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6b
            r2.f11723a = r0     // Catch: java.lang.Throwable -> L6b
            r0 = 1
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6b
            r2.f11724b = r0     // Catch: java.lang.Throwable -> L6b
            r0 = 2
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6b
            r3 = 3
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L6b
            android.content.Context r4 = r10.f11722a     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.C3408i.m11232a(r4)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r0 = r4.m11258d(r0)     // Catch: java.lang.Throwable -> L6b
            r2.f11725c = r0     // Catch: java.lang.Throwable -> L6b
            android.content.Context r0 = r10.f11722a     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.C3408i.m11232a(r0)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r0 = r0.m11258d(r3)     // Catch: java.lang.Throwable -> L6b
            r2.f11726d = r0     // Catch: java.lang.Throwable -> L6b
            r0 = 4
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6b
            r2.f11727e = r0     // Catch: java.lang.Throwable -> L6b
            r0 = 5
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6b
            r2.f11728f = r0     // Catch: java.lang.Throwable -> L6b
            r0 = r2
            goto L6d
        L6b:
            r0 = r2
            goto L74
        L6d:
            if (r1 == 0) goto L7a
        L6f:
            r1.close()
            goto L7a
        L73:
            r1 = r0
        L74:
            r10.m10990d()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto L7a
            goto L6f
        L7a:
            return r0
        L7b:
            r0 = move-exception
            r2 = r0
            if (r1 == 0) goto L82
            r1.close()
        L82:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.C3353bj.m10992a(java.lang.String):com.umeng.analytics.pro.bk");
    }

    /* renamed from: a */
    public void m10994a(String str, String str2) {
        m10995a(str, "_uuid=?", new String[]{str2});
    }

    /* renamed from: a */
    public Cursor m10991a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }
}
