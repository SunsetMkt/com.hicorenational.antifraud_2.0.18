package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.AbstractC3071a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.umeng.analytics.pro.C3355bl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.af */
/* loaded from: classes2.dex */
public class C3143af extends SQLiteOpenHelper {

    /* renamed from: a */
    public static String f10501a = "bugly_db";

    /* renamed from: b */
    public static int f10502b = 15;

    /* renamed from: c */
    protected Context f10503c;

    /* renamed from: d */
    private List<AbstractC3071a> f10504d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C3143af(android.content.Context r4, java.util.List<com.tencent.bugly.AbstractC3071a> r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.tencent.bugly.proguard.C3143af.f10501a
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            com.tencent.bugly.crashreport.common.info.a r1 = com.tencent.bugly.crashreport.common.info.C3113a.m9531a(r4)
            r1.getClass()
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r1 = com.tencent.bugly.proguard.C3143af.f10502b
            r2 = 0
            r3.<init>(r4, r0, r2, r1)
            r3.f10503c = r4
            r3.f10504d = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3143af.<init>(android.content.Context, java.util.List):void");
    }

    /* renamed from: a */
    protected synchronized boolean m9848a(SQLiteDatabase sQLiteDatabase) {
        try {
            for (String str : new String[]{"t_lr", "t_ui", "t_pf"}) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str, new String[0]);
            }
        } catch (Throwable th) {
            if (!C3151an.m9919b(th)) {
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
                C3151an.m9922d("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    C3151an.m9923e("[Database] Failed to get db.", new Object[0]);
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
                C3151an.m9922d("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    C3151an.m9923e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            C3151an.m9922d("[Database] db error delay error record 1min.", new Object[0]);
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
            sb.append(C3355bl.f11732d);
            sb.append(AbstractC1191a.f2568g);
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_ut");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append(C3355bl.f11733e);
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(AbstractC1191a.f2568g);
            sb.append("blob");
            sb.append(" , ");
            sb.append("_pc");
            sb.append(AbstractC1191a.f2568g);
            sb.append("text");
            sb.append(" ) ");
            C3151an.m9921c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_lr");
            sb.append(" ( ");
            sb.append(C3355bl.f11732d);
            sb.append(AbstractC1191a.f2568g);
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append(C3355bl.f11733e);
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_pc");
            sb.append(AbstractC1191a.f2568g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_th");
            sb.append(AbstractC1191a.f2568g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(AbstractC1191a.f2568g);
            sb.append("blob");
            sb.append(" ) ");
            C3151an.m9921c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_pf");
            sb.append(" ( ");
            sb.append(C3355bl.f11732d);
            sb.append(AbstractC1191a.f2568g);
            sb.append("integer");
            sb.append(" , ");
            sb.append(C3355bl.f11733e);
            sb.append(AbstractC1191a.f2568g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(AbstractC1191a.f2568g);
            sb.append("blob");
            sb.append(",primary key(");
            sb.append(C3355bl.f11732d);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(C3355bl.f11733e);
            sb.append(" )) ");
            C3151an.m9921c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_cr");
            sb.append(" ( ");
            sb.append(C3355bl.f11732d);
            sb.append(AbstractC1191a.f2568g);
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_s1");
            sb.append(AbstractC1191a.f2568g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_up");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_me");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_uc");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(AbstractC1191a.f2568g);
            sb.append("blob");
            sb.append(" ) ");
            C3151an.m9921c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("dl_1002");
            sb.append(" (");
            sb.append(C3355bl.f11732d);
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
            C3151an.m9921c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ");
            sb.append("ge_1002");
            sb.append(" (");
            sb.append(C3355bl.f11732d);
            sb.append(" integer primary key autoincrement, ");
            sb.append("_time");
            sb.append(" INTEGER, ");
            sb.append("_datas");
            sb.append(" blob)");
            C3151an.m9921c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("st_1002");
            sb.append(" ( ");
            sb.append(C3355bl.f11732d);
            sb.append(AbstractC1191a.f2568g);
            sb.append("integer");
            sb.append(" , ");
            sb.append(C3355bl.f11733e);
            sb.append(AbstractC1191a.f2568g);
            sb.append("text");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(AbstractC1191a.f2568g);
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(AbstractC1191a.f2568g);
            sb.append("blob");
            sb.append(",primary key(");
            sb.append(C3355bl.f11732d);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(C3355bl.f11733e);
            sb.append(" )) ");
            C3151an.m9921c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        } catch (Throwable th) {
            if (!C3151an.m9919b(th)) {
                th.printStackTrace();
            }
        }
        if (this.f10504d == null) {
            return;
        }
        Iterator<AbstractC3071a> it = this.f10504d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDbCreate(sQLiteDatabase);
            } catch (Throwable th2) {
                if (!C3151an.m9919b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (C3114b.m9599c() >= 11) {
            C3151an.m9922d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i2), Integer.valueOf(i3));
            if (this.f10504d != null) {
                Iterator<AbstractC3071a> it = this.f10504d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbDowngrade(sQLiteDatabase, i2, i3);
                    } catch (Throwable th) {
                        if (!C3151an.m9919b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (m9848a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                C3151an.m9922d("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f10503c.getDatabasePath(f10501a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        C3151an.m9922d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.f10504d != null) {
            Iterator<AbstractC3071a> it = this.f10504d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDbUpgrade(sQLiteDatabase, i2, i3);
                } catch (Throwable th) {
                    if (!C3151an.m9919b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (m9848a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
        } else {
            C3151an.m9922d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f10503c.getDatabasePath(f10501a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }
}
