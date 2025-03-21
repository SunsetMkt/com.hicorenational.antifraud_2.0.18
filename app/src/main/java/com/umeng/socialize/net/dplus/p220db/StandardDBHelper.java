package com.umeng.socialize.net.dplus.p220db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;

/* loaded from: classes2.dex */
public class StandardDBHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private static Context f13763a;

    /* renamed from: b */
    private String f13764b;

    public StandardDBHelper(Context context) {
        super(context, DBConfig.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.f13764b = null;
    }

    /* renamed from: a */
    private void m12694a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f13764b = "create table if not exists stats (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.f13764b);
        } catch (SQLException e2) {
            SLog.error(UmengText.CACHE.CACHEFILE, e2);
        }
    }

    /* renamed from: b */
    private void m12695b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f13764b = "create table if not exists s_e (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.f13764b);
        } catch (SQLException e2) {
            SLog.error(UmengText.CACHE.CACHEFILE, e2);
        }
    }

    /* renamed from: c */
    private void m12696c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f13764b = "create table if not exists auth (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.f13764b);
        } catch (SQLException e2) {
            SLog.error(UmengText.CACHE.CACHEFILE, e2);
        }
    }

    /* renamed from: d */
    private void m12697d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f13764b = "create table if not exists userinfo (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.f13764b);
        } catch (SQLException e2) {
            SLog.error(UmengText.CACHE.CACHEFILE, e2);
        }
    }

    /* renamed from: e */
    private void m12698e(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f13764b = "create table if not exists dau (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.f13764b);
        } catch (SQLException e2) {
            SLog.error(UmengText.CACHE.CACHEFILE, e2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m12694a(sQLiteDatabase);
        m12695b(sQLiteDatabase);
        m12696c(sQLiteDatabase);
        m12697d(sQLiteDatabase);
        m12698e(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
