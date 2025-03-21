package com.umeng.message.component;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.C3567ap;
import com.umeng.message.proguard.C3588h;
import com.umeng.message.proguard.C3604x;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public class UmengMessageProvider extends ContentProvider {

    /* renamed from: a */
    private final UriMatcher f13058a = new UriMatcher(-1);

    /* renamed from: b */
    private volatile C3536a f13059b;

    /* renamed from: c */
    private volatile C3537b f13060c;

    /* renamed from: com.umeng.message.component.UmengMessageProvider$a */
    static class C3536a extends SQLiteOpenHelper {
        public C3536a(Context context) {
            super(context, "MessageStore.db", (SQLiteDatabase.CursorFactory) null, 5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(String.format("create table if not exists %s (time long, type varchar default NULL, alias varchar default NULL, exclusive int, ttl long, PRIMARY KEY(time))", "MsgAlias"));
            } catch (Throwable th) {
                UPLog.m12143e("MessageProvider", th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            try {
                if (UmengMessageProvider.m12151b(sQLiteDatabase, "MsgAlias")) {
                    sQLiteDatabase.execSQL("drop table MsgAlias");
                }
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                UPLog.m12143e("MessageProvider", th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 <= 3) {
                try {
                    if (UmengMessageProvider.m12151b(sQLiteDatabase, "MsgTemp")) {
                        sQLiteDatabase.execSQL("drop table MsgTemp");
                    }
                    if (UmengMessageProvider.m12151b(sQLiteDatabase, "MessageStore")) {
                        sQLiteDatabase.execSQL("drop table MessageStore");
                    }
                } catch (Throwable th) {
                    UPLog.m12143e("MessageProvider", th);
                    return;
                }
            }
            if (i2 <= 4 && UmengMessageProvider.m12151b(sQLiteDatabase, "MsgAlias")) {
                sQLiteDatabase.execSQL("drop table MsgAlias");
            }
            onCreate(sQLiteDatabase);
        }
    }

    /* renamed from: com.umeng.message.component.UmengMessageProvider$b */
    static class C3537b extends SQLiteOpenHelper {
        public C3537b(Context context) {
            super(context, "MsgLogStore.db", (SQLiteDatabase.CursorFactory) null, 8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(String.format("create table if not exists MsgLogStore (MsgId varchar, ActionType Integer, Time long, %s varchar, PRIMARY KEY(MsgId, ActionType))", "pa"));
                sQLiteDatabase.execSQL("create table if not exists InAppLogStore (Time long, MsgId varchar, MsgType Integer, NumDisplay Integer, NumOpenFull Integer, NumOpenTop Integer, NumOpenBottom Integer, NumClose Integer, NumDuration Integer, NumCustom Integer, PRIMARY KEY(Time))");
            } catch (Throwable th) {
                UPLog.m12143e("MessageProvider", th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            try {
                if (UmengMessageProvider.m12151b(sQLiteDatabase, "MsgLogStore")) {
                    sQLiteDatabase.execSQL("drop table MsgLogStore");
                }
                if (UmengMessageProvider.m12151b(sQLiteDatabase, "InAppLogStore")) {
                    sQLiteDatabase.execSQL("drop table InAppLogStore");
                }
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                UPLog.m12143e("MessageProvider", th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 <= 5) {
                try {
                    if (UmengMessageProvider.m12151b(sQLiteDatabase, "MsgLogStore")) {
                        sQLiteDatabase.execSQL(String.format("ALTER TABLE MsgLogStore ADD COLUMN %s varchar", "pa"));
                    }
                } catch (Throwable th) {
                    UPLog.m12143e("MessageProvider", th);
                    return;
                }
            }
            if (i2 <= 6 && UmengMessageProvider.m12151b(sQLiteDatabase, "InAppLogStore")) {
                sQLiteDatabase.execSQL(String.format("ALTER TABLE InAppLogStore ADD COLUMN %s Integer", "NumCustom"));
            }
            if (i2 <= 7) {
                if (UmengMessageProvider.m12151b(sQLiteDatabase, "MsgLogStoreForAgoo")) {
                    sQLiteDatabase.execSQL("drop table MsgLogStoreForAgoo");
                }
                if (UmengMessageProvider.m12151b(sQLiteDatabase, "MsgLogIdTypeStore")) {
                    sQLiteDatabase.execSQL("drop table MsgLogIdTypeStore");
                }
                if (UmengMessageProvider.m12151b(sQLiteDatabase, "MsgLogIdTypeStoreForAgoo")) {
                    sQLiteDatabase.execSQL("drop table MsgLogIdTypeStoreForAgoo");
                }
                if (UmengMessageProvider.m12151b(sQLiteDatabase, "MsgConfigInfo")) {
                    sQLiteDatabase.execSQL("drop table MsgConfigInfo");
                }
            }
            onCreate(sQLiteDatabase);
        }
    }

    /* renamed from: b */
    private C3537b m12150b() {
        if (this.f13060c == null) {
            synchronized (C3537b.class) {
                if (this.f13060c == null) {
                    this.f13060c = new C3537b(getContext());
                }
            }
        }
        return this.f13060c;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        SQLiteDatabase writableDatabase = m12150b().getWritableDatabase();
        try {
            if (writableDatabase == null) {
                return super.applyBatch(arrayList);
            }
            try {
                writableDatabase.beginTransaction();
                ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
                writableDatabase.setTransactionSuccessful();
                return applyBatch;
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (Throwable unused) {
            return super.applyBatch(arrayList);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase;
        try {
            int match = this.f13058a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase2 = m12148a().getWritableDatabase();
                    if (writableDatabase2 != null) {
                        return writableDatabase2.delete("MsgAlias", str, strArr);
                    }
                } else if (match == 4) {
                    SQLiteDatabase writableDatabase3 = m12148a().getWritableDatabase();
                    if (writableDatabase3 != null) {
                        return writableDatabase3.delete("MsgAlias", null, null);
                    }
                } else if (match == 5) {
                    SQLiteDatabase writableDatabase4 = m12150b().getWritableDatabase();
                    if (writableDatabase4 != null) {
                        return writableDatabase4.delete("MsgLogStore", str, strArr);
                    }
                } else if (match == 10 && (writableDatabase = m12150b().getWritableDatabase()) != null) {
                    return writableDatabase.delete("InAppLogStore", str, strArr);
                }
            } else if (strArr != null && strArr.length != 0) {
                C3567ap m12275a = C3567ap.m12275a();
                if (strArr != null && strArr.length != 0) {
                    SharedPreferences.Editor edit = m12275a.f13225a.edit();
                    int i2 = 0;
                    for (String str2 : strArr) {
                        if (m12275a.f13225a.contains(str2)) {
                            edit.remove(str2);
                            i2++;
                        }
                    }
                    if (i2 > 0) {
                        edit.apply();
                    }
                    return i2;
                }
                return 0;
            }
        } catch (Throwable th) {
            UPLog.m12143e("MessageProvider", th);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int match = this.f13058a.match(uri);
        if (match == 2 || match == 3 || match == 5) {
            return "vnd.android.cursor.dir/vnd.umeng.message";
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            int match = this.f13058a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase = m12148a().getWritableDatabase();
                    if (writableDatabase == null) {
                        return null;
                    }
                    writableDatabase.insertWithOnConflict("MsgAlias", null, contentValues, 5);
                } else if (match == 5) {
                    SQLiteDatabase writableDatabase2 = m12150b().getWritableDatabase();
                    if (writableDatabase2 == null) {
                        return null;
                    }
                    writableDatabase2.insertWithOnConflict("MsgLogStore", null, contentValues, 5);
                } else if (match == 10) {
                    SQLiteDatabase writableDatabase3 = m12150b().getWritableDatabase();
                    if (writableDatabase3 == null) {
                        return null;
                    }
                    writableDatabase3.insertWithOnConflict("InAppLogStore", null, contentValues, 5);
                }
            } else {
                if (contentValues == null) {
                    return null;
                }
                String asString = contentValues.getAsString("k");
                String asString2 = contentValues.getAsString("v");
                if (!TextUtils.isEmpty(asString)) {
                    C3567ap.m12275a().m12277a(asString, asString2);
                }
            }
        } catch (Throwable th) {
            UPLog.m12143e("MessageProvider", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context = getContext();
            C3604x.m12461a(context);
            Uri m12402a = C3588h.m12402a(context);
            this.f13058a.addURI(m12402a.getAuthority(), m12402a.getPath(), 3);
            Uri m12403b = C3588h.m12403b(context);
            this.f13058a.addURI(m12403b.getAuthority(), m12403b.getPath(), 4);
            Uri m12405d = C3588h.m12405d(context);
            this.f13058a.addURI(m12405d.getAuthority(), m12405d.getPath(), 5);
            Uri m12406e = C3588h.m12406e(context);
            this.f13058a.addURI(m12406e.getAuthority(), m12406e.getPath(), 10);
            Uri m12404c = C3588h.m12404c(context);
            this.f13058a.addURI(m12404c.getAuthority(), m12404c.getPath(), 2);
            return true;
        } catch (Throwable th) {
            UPLog.m12143e("MessageProvider", th);
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase;
        try {
            int match = this.f13058a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase readableDatabase2 = m12148a().getReadableDatabase();
                    if (readableDatabase2 == null) {
                        return null;
                    }
                    return readableDatabase2.query("MsgAlias", strArr, str, strArr2, null, null, str2);
                }
                if (match != 5) {
                    if (match == 10 && (readableDatabase = m12150b().getReadableDatabase()) != null) {
                        return readableDatabase.query("InAppLogStore", strArr, str, strArr2, null, null, str2);
                    }
                    return null;
                }
                SQLiteDatabase readableDatabase3 = m12150b().getReadableDatabase();
                if (readableDatabase3 == null) {
                    return null;
                }
                return readableDatabase3.query("MsgLogStore", strArr, str, strArr2, null, null, str2);
            }
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"k", "v"});
            Map<String, ?> all = C3567ap.m12275a().f13225a.getAll();
            if (strArr2 != null && strArr2.length != 0) {
                for (String str3 : strArr2) {
                    Object obj = all.get(str3);
                    if (obj instanceof String) {
                        matrixCursor.addRow(new Object[]{str3, obj});
                    }
                }
                return matrixCursor;
            }
            for (String str4 : all.keySet()) {
                Object obj2 = all.get(str4);
                if (obj2 instanceof String) {
                    matrixCursor.addRow(new Object[]{str4, obj2});
                }
            }
            return matrixCursor;
        } catch (Throwable th) {
            UPLog.m12143e("MessageProvider", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase;
        try {
            int match = this.f13058a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase2 = m12148a().getWritableDatabase();
                    if (writableDatabase2 != null) {
                        return writableDatabase2.updateWithOnConflict("MsgAlias", contentValues, str, strArr, 5);
                    }
                } else if (match == 10 && (writableDatabase = m12150b().getWritableDatabase()) != null) {
                    return writableDatabase.updateWithOnConflict("InAppLogStore", contentValues, str, strArr, 5);
                }
            } else if (contentValues != null && strArr != null && strArr.length != 0) {
                String str2 = strArr[0];
                String asString = contentValues.getAsString("v");
                if (!TextUtils.isEmpty(str2)) {
                    C3567ap.m12275a().m12277a(str2, asString);
                    return 1;
                }
            }
        } catch (Throwable th) {
            UPLog.m12143e("MessageProvider", th);
        }
        return 0;
    }

    /* renamed from: a */
    private C3536a m12148a() {
        if (this.f13059b == null) {
            synchronized (C3536a.class) {
                if (this.f13059b == null) {
                    this.f13059b = new C3536a(getContext());
                }
            }
        }
        return this.f13059b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m12151b(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(String.format("select count(*) as c from sqlite_master where type = 'table' and name = '%s'", str.trim()), null);
            if (rawQuery != null) {
                if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        } catch (Throwable th) {
            UPLog.m12143e("MessageProvider", th);
        }
        return z;
    }
}
