package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3404e;

/* compiled from: UMDBCreater.java */
/* renamed from: com.umeng.analytics.pro.f */
/* loaded from: classes2.dex */
class C3405f extends SQLiteOpenHelper {

    /* renamed from: b */
    private static Context f12040b;

    /* renamed from: a */
    private String f12041a;

    /* compiled from: UMDBCreater.java */
    /* renamed from: com.umeng.analytics.pro.f$a */
    private static class a {

        /* renamed from: a */
        private static final C3405f f12042a = new C3405f(C3405f.f12040b, C3407h.m11228b(C3405f.f12040b), C3404e.f11974b, null, 2);

        private a() {
        }
    }

    /* renamed from: a */
    public static C3405f m11207a(Context context) {
        if (f12040b == null) {
            f12040b = context.getApplicationContext();
        }
        return a.f12042a;
    }

    /* renamed from: c */
    private void m11212c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f12041a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f12041a);
        } catch (SQLException unused) {
        }
    }

    /* renamed from: d */
    private void m11213d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f12041a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f12041a);
        } catch (SQLException unused) {
        }
    }

    /* renamed from: e */
    private void m11214e(SQLiteDatabase sQLiteDatabase) {
        if (!C3407h.m11226a(sQLiteDatabase, C3404e.d.f12015a, "__av")) {
            C3407h.m11225a(sQLiteDatabase, C3404e.d.f12015a, "__sp", "TEXT");
            C3407h.m11225a(sQLiteDatabase, C3404e.d.f12015a, "__pp", "TEXT");
            C3407h.m11225a(sQLiteDatabase, C3404e.d.f12015a, "__av", "TEXT");
            C3407h.m11225a(sQLiteDatabase, C3404e.d.f12015a, "__vc", "TEXT");
        }
        if (!C3407h.m11226a(sQLiteDatabase, C3404e.b.f11989a, "__av")) {
            C3407h.m11225a(sQLiteDatabase, C3404e.b.f11989a, "__av", "TEXT");
            C3407h.m11225a(sQLiteDatabase, C3404e.b.f11989a, "__vc", "TEXT");
        }
        if (C3407h.m11226a(sQLiteDatabase, C3404e.a.f11978a, "__av")) {
            return;
        }
        C3407h.m11225a(sQLiteDatabase, C3404e.a.f11978a, "__av", "TEXT");
        C3407h.m11225a(sQLiteDatabase, C3404e.a.f11978a, "__vc", "TEXT");
    }

    /* renamed from: f */
    private void m11215f(SQLiteDatabase sQLiteDatabase) {
        m11209a(sQLiteDatabase, C3404e.d.f12015a);
        m11209a(sQLiteDatabase, C3404e.b.f11989a);
        m11209a(sQLiteDatabase, C3404e.a.f11978a);
        m11216a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                m11212c(sQLiteDatabase);
                m11213d(sQLiteDatabase);
                m11211b(sQLiteDatabase);
                m11208a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                C3407h.m11224a(f12040b);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 <= i2 || i2 != 1) {
            return;
        }
        try {
            try {
                m11214e(sQLiteDatabase);
            } catch (Exception unused) {
                m11214e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            m11215f(sQLiteDatabase);
        }
    }

    private C3405f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        this(new C3370c(context, str), str2, cursorFactory, i2);
    }

    /* renamed from: b */
    private void m11211b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f12041a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f12041a);
        } catch (SQLException unused) {
        }
    }

    private C3405f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, TextUtils.isEmpty(str) ? C3404e.f11974b : str, cursorFactory, i2);
        this.f12041a = null;
        m11216a();
    }

    /* renamed from: a */
    public void m11216a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!C3407h.m11227a(C3404e.d.f12015a, writableDatabase)) {
                m11212c(writableDatabase);
            }
            if (!C3407h.m11227a(C3404e.c.f12002a, writableDatabase)) {
                m11213d(writableDatabase);
            }
            if (!C3407h.m11227a(C3404e.b.f11989a, writableDatabase)) {
                m11211b(writableDatabase);
            }
            if (C3407h.m11227a(C3404e.a.f11978a, writableDatabase)) {
                return;
            }
            m11208a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m11208a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f12041a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f12041a);
        } catch (SQLException unused) {
        }
    }

    /* renamed from: a */
    private void m11209a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
