package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C3151an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.a */
/* loaded from: classes2.dex */
public abstract class AbstractC3071a {

    /* renamed from: id */
    public int f9831id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z, BuglyStrategy buglyStrategy);

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th) {
            if (C3151an.m9919b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th) {
            if (C3151an.m9919b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }
}
