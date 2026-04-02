package com.alibaba.sdk.android.httpdns.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class d extends SQLiteOpenHelper {
    private static final Object a = new Object();

    d(Context context) {
        super(context, "aliclound_httpdns.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private long a(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f2550i));
        contentValues.put("ip", gVar.o);
        contentValues.put(RemoteMessageConst.TTL, gVar.p);
        try {
            return sQLiteDatabase.insert("ip", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[PHI: r10
  0x008e: PHI (r10v4 android.database.sqlite.SQLiteDatabase) = (r10v3 android.database.sqlite.SQLiteDatabase), (r10v5 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x008c, B:13:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<g> a(long j2) throws Throwable {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Exception unused) {
            writableDatabase = null;
        } catch (Throwable th) {
            th = th;
            writableDatabase = null;
        }
        try {
            cursorQuery = writableDatabase.query("ip", null, "host_id=?", new String[]{String.valueOf(j2)}, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                do {
                    g gVar = new g();
                    gVar.id = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                    gVar.f2550i = cursorQuery.getInt(cursorQuery.getColumnIndex("host_id"));
                    gVar.o = cursorQuery.getString(cursorQuery.getColumnIndex("ip"));
                    gVar.p = cursorQuery.getString(cursorQuery.getColumnIndex(RemoteMessageConst.TTL));
                    arrayList.add(gVar);
                } while (cursorQuery.moveToNext());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (writableDatabase != null) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        if (writableDatabase != null) {
            writableDatabase.close();
        }
        return arrayList;
    }

    private List<g> a(e eVar) {
        return a(eVar.id);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m8a(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete(Constants.KEY_HOST, "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void a(g gVar) {
        m9b(gVar.id);
    }

    private long b(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f2550i));
        contentValues.put("ip", gVar.o);
        contentValues.put(RemoteMessageConst.TTL, gVar.p);
        try {
            return sQLiteDatabase.insert("ipv6", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[PHI: r10
  0x008e: PHI (r10v4 android.database.sqlite.SQLiteDatabase) = (r10v3 android.database.sqlite.SQLiteDatabase), (r10v5 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x008c, B:13:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<g> b(long j2) throws Throwable {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Exception unused) {
            writableDatabase = null;
        } catch (Throwable th) {
            th = th;
            writableDatabase = null;
        }
        try {
            cursorQuery = writableDatabase.query("ipv6", null, "host_id=?", new String[]{String.valueOf(j2)}, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                do {
                    g gVar = new g();
                    gVar.id = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                    gVar.f2550i = cursorQuery.getInt(cursorQuery.getColumnIndex("host_id"));
                    gVar.o = cursorQuery.getString(cursorQuery.getColumnIndex("ip"));
                    gVar.p = cursorQuery.getString(cursorQuery.getColumnIndex(RemoteMessageConst.TTL));
                    arrayList.add(gVar);
                } while (cursorQuery.moveToNext());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (writableDatabase != null) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        if (writableDatabase != null) {
            writableDatabase.close();
        }
        return arrayList;
    }

    private List<g> b(e eVar) {
        return b(eVar.id);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private void m9b(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete("ip", "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void b(g gVar) {
        c(gVar.id);
    }

    private void c(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete("ipv6", "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void c(e eVar) {
        m8a(eVar.id);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    long m10a(e eVar) {
        SQLiteDatabase writableDatabase;
        synchronized (a) {
            b(eVar.f2548m, eVar.host);
            ContentValues contentValues = new ContentValues();
            try {
                writableDatabase = getWritableDatabase();
            } catch (Exception unused) {
                writableDatabase = null;
            } catch (Throwable th) {
                th = th;
                writableDatabase = null;
            }
            try {
                writableDatabase.beginTransaction();
                contentValues.put(Constants.KEY_HOST, eVar.host);
                contentValues.put("sp", eVar.f2548m);
                contentValues.put("time", c.c(eVar.f2549n));
                contentValues.put("extra", eVar.a);
                contentValues.put("cache_key", eVar.f2547b);
                long jInsert = writableDatabase.insert(Constants.KEY_HOST, null, contentValues);
                eVar.id = jInsert;
                if (eVar.f7a != null) {
                    for (g gVar : eVar.f7a) {
                        gVar.f2550i = jInsert;
                        gVar.id = a(writableDatabase, gVar);
                    }
                }
                if (eVar.f8b != null) {
                    for (g gVar2 : eVar.f8b) {
                        gVar2.f2550i = jInsert;
                        gVar2.id = b(writableDatabase, gVar2);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
                return jInsert;
            } catch (Exception unused2) {
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
                return 0L;
            } catch (Throwable th2) {
                th = th2;
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    e a(String str, String str2) {
        Cursor cursorQuery;
        SQLiteDatabase readableDatabase;
        e eVar;
        synchronized (a) {
            try {
                try {
                    readableDatabase = getReadableDatabase();
                    try {
                        cursorQuery = readableDatabase.query(Constants.KEY_HOST, null, "sp=? AND host=?", new String[]{str, str2}, null, null, null);
                    } catch (Exception unused) {
                        cursorQuery = null;
                        eVar = null;
                    } catch (Throwable th) {
                        th = th;
                        cursorQuery = null;
                    }
                } catch (Exception unused2) {
                    cursorQuery = null;
                    eVar = null;
                    readableDatabase = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                    readableDatabase = null;
                }
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                cursorQuery.moveToFirst();
                                eVar = new e();
                                try {
                                    eVar.id = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                                    eVar.host = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.KEY_HOST));
                                    eVar.f2548m = cursorQuery.getString(cursorQuery.getColumnIndex("sp"));
                                    eVar.f2549n = c.d(cursorQuery.getString(cursorQuery.getColumnIndex("time")));
                                    eVar.f7a = (ArrayList) a(eVar);
                                    eVar.f8b = (ArrayList) b(eVar);
                                    eVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                                    eVar.f2547b = cursorQuery.getString(cursorQuery.getColumnIndex("cache_key"));
                                } catch (Exception unused3) {
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (readableDatabase != null) {
                                    }
                                    return eVar;
                                }
                            } else {
                                eVar = null;
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (readableDatabase != null) {
                                readableDatabase.close();
                            }
                            throw th;
                        }
                    } catch (Exception unused4) {
                        eVar = null;
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                }
            } finally {
            }
        }
        return eVar;
    }

    List<e> b() {
        ArrayList arrayList;
        SQLiteDatabase readableDatabase;
        synchronized (a) {
            arrayList = new ArrayList();
            Cursor cursorQuery = null;
            try {
                readableDatabase = getReadableDatabase();
                try {
                    cursorQuery = readableDatabase.query(Constants.KEY_HOST, null, null, null, null, null, null);
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        do {
                            e eVar = new e();
                            eVar.id = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                            eVar.host = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.KEY_HOST));
                            eVar.f2548m = cursorQuery.getString(cursorQuery.getColumnIndex("sp"));
                            eVar.f2549n = c.d(cursorQuery.getString(cursorQuery.getColumnIndex("time")));
                            eVar.f7a = (ArrayList) a(eVar);
                            eVar.f8b = (ArrayList) b(eVar);
                            eVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                            eVar.f2547b = cursorQuery.getString(cursorQuery.getColumnIndex("cache_key"));
                            arrayList.add(eVar);
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (readableDatabase != null) {
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                readableDatabase = null;
            } catch (Throwable th2) {
                th = th2;
                readableDatabase = null;
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
        }
        return arrayList;
    }

    void b(String str, String str2) {
        synchronized (a) {
            e eVarA = a(str, str2);
            if (eVarA != null) {
                c(eVarA);
                if (eVarA.f7a != null) {
                    Iterator<g> it = eVarA.f7a.iterator();
                    while (it.hasNext()) {
                        a(it.next());
                    }
                }
                if (eVarA.f8b != null) {
                    Iterator<g> it2 = eVarA.f8b.iterator();
                    while (it2.hasNext()) {
                        b(it2.next());
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
