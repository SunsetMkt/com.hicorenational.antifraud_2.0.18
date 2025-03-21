package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class af extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static String f9199a = "bugly_db";

    /* renamed from: b, reason: collision with root package name */
    public static int f9200b = 15;

    /* renamed from: c, reason: collision with root package name */
    protected Context f9201c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.bugly.a> f9202d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public af(android.content.Context r4, java.util.List<com.tencent.bugly.a> r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.tencent.bugly.proguard.af.f9199a
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            com.tencent.bugly.crashreport.common.info.a r1 = com.tencent.bugly.crashreport.common.info.a.a(r4)
            r1.getClass()
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r1 = com.tencent.bugly.proguard.af.f9200b
            r2 = 0
            r3.<init>(r4, r0, r2, r1)
            r3.f9201c = r4
            r3.f9202d = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.af.<init>(android.content.Context, java.util.List):void");
    }

    protected synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            for (String str : new String[]{"t_lr", "t_ui", "t_pf"}) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str, new String[0]);
            }
        } catch (Throwable th) {
            if (!an.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i2 = 0;
        while (sQLiteDatabase == null && i2 < 5) {
            i2++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                an.d("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    an.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i2 = 0;
        while (sQLiteDatabase == null && i2 < 5) {
            i2++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                an.d("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    an.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            an.d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_ui");
            sb.append(" ( ");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_ut");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append(com.umeng.analytics.pro.bl.f10171e);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("blob");
            sb.append(" , ");
            sb.append("_pc");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("text");
            sb.append(" ) ");
            an.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_lr");
            sb.append(" ( ");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append(com.umeng.analytics.pro.bl.f10171e);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_pc");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_th");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("blob");
            sb.append(" ) ");
            an.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_pf");
            sb.append(" ( ");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("integer");
            sb.append(" , ");
            sb.append(com.umeng.analytics.pro.bl.f10171e);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("blob");
            sb.append(",primary key(");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(com.umeng.analytics.pro.bl.f10171e);
            sb.append(" )) ");
            an.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_cr");
            sb.append(" ( ");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_s1");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_up");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_me");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_uc");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("blob");
            sb.append(" ) ");
            an.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("dl_1002");
            sb.append(" (");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(" integer primary key autoincrement, ");
            sb.append("_dUrl");
            sb.append(" varchar(100), ");
            sb.append("_sFile");
            sb.append(" varchar(100), ");
            sb.append("_sLen");
            sb.append(" INTEGER, ");
            sb.append("_tLen");
            sb.append(" INTEGER, ");
            sb.append("_MD5");
            sb.append(" varchar(100), ");
            sb.append("_DLTIME");
            sb.append(" INTEGER)");
            an.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ");
            sb.append("ge_1002");
            sb.append(" (");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(" integer primary key autoincrement, ");
            sb.append("_time");
            sb.append(" INTEGER, ");
            sb.append("_datas");
            sb.append(" blob)");
            an.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("st_1002");
            sb.append(" ( ");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("integer");
            sb.append(" , ");
            sb.append(com.umeng.analytics.pro.bl.f10171e);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append("blob");
            sb.append(",primary key(");
            sb.append(com.umeng.analytics.pro.bl.f10170d);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(com.umeng.analytics.pro.bl.f10171e);
            sb.append(" )) ");
            an.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        } catch (Throwable th) {
            if (!an.b(th)) {
                th.printStackTrace();
            }
        }
        if (this.f9202d == null) {
            return;
        }
        Iterator<com.tencent.bugly.a> it = this.f9202d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDbCreate(sQLiteDatabase);
            } catch (Throwable th2) {
                if (!an.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (com.tencent.bugly.crashreport.common.info.b.c() >= 11) {
            an.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i2), Integer.valueOf(i3));
            if (this.f9202d != null) {
                Iterator<com.tencent.bugly.a> it = this.f9202d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbDowngrade(sQLiteDatabase, i2, i3);
                    } catch (Throwable th) {
                        if (!an.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                an.d("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f9201c.getDatabasePath(f9199a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        an.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.f9202d != null) {
            Iterator<com.tencent.bugly.a> it = this.f9202d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDbUpgrade(sQLiteDatabase, i2, i3);
                } catch (Throwable th) {
                    if (!an.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
        } else {
            an.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f9201c.getDatabasePath(f9199a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }
}
