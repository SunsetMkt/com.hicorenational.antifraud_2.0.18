package com.umeng.analytics.process;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3407h;
import java.io.File;

/* compiled from: UMProcessDBCreater.java */
/* renamed from: com.umeng.analytics.process.b */
/* loaded from: classes2.dex */
class C3432b extends SQLiteOpenHelper {
    C3432b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    /* renamed from: a */
    static C3432b m11444a(Context context, String str) {
        String m11447b = m11447b(context, str);
        InterfaceC3431a.f12310h.equals(str);
        return new C3432b(context, m11447b, null, 1);
    }

    /* renamed from: b */
    public static String m11447b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = InterfaceC3431a.f12310h;
        }
        String str2 = C3407h.m11228b(context) + InterfaceC3431a.f12303a;
        if (InterfaceC3431a.f12310h.equals(str)) {
            str2 = C3407h.m11228b(context);
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return String.format(str2 + InterfaceC3431a.f12307e, str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m11446a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* renamed from: a */
    private void m11446a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: a */
    public static String m11445a(Context context) {
        return C3407h.m11228b(context) + InterfaceC3431a.f12303a;
    }
}
