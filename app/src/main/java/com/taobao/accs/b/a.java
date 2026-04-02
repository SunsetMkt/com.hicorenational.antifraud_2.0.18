package com.taobao.accs.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c */
    private static volatile a f5710c;

    /* JADX INFO: renamed from: e */
    private static final Lock f5711e = new ReentrantLock();
    public int a;

    /* JADX INFO: renamed from: b */
    LinkedList<C0110a> f5712b;

    /* JADX INFO: renamed from: d */
    private Context f5713d;

    /* JADX INFO: renamed from: com.taobao.accs.b.a$a */
    /* JADX INFO: compiled from: Taobao */
    private class C0110a {
        String a;

        /* JADX INFO: renamed from: b */
        Object[] f5714b;

        /* synthetic */ C0110a(a aVar, String str, Object[] objArr, b bVar) {
            this(str, objArr);
        }

        private C0110a(String str, Object[] objArr) {
            this.a = str;
            this.f5714b = objArr;
        }
    }

    private a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.a = 0;
        this.f5712b = new LinkedList<>();
        this.f5713d = context;
    }

    public static a a(Context context) {
        if (f5710c == null) {
            synchronized (a.class) {
                if (f5710c == null) {
                    f5710c = new a(context, Constants.DB_NAME, null, 3);
                }
            }
        }
        return f5710c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (j.a(super.getWritableDatabase().getPath(), 102400)) {
            return super.getWritableDatabase();
        }
        return null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            if (f5711e.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
        } finally {
            f5711e.unlock();
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

    public void a(String str, String str2, String str3, boolean z, long j2, String str4) {
        if (a(str, str3, z, str4)) {
            a("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j2), str4, str, str3, String.valueOf(z)}, true);
        } else {
            a("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z), Long.valueOf(j2)}, true);
        }
    }

    private synchronized boolean a(String str, String str2, boolean z, String str3) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
            } catch (Exception e2) {
                ALog.w("DBHelper", e2.toString(), new Object[0]);
                if (cursorQuery != null) {
                }
            }
            if (writableDatabase == null) {
                return false;
            }
            cursorQuery = writableDatabase.query(d.F, new String[]{bl.f7101d, "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=? AND host=? AND bid=? AND isbackground=?", new String[]{str3, str, str2, String.valueOf(z)}, null, null, null, String.valueOf(100));
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0) {
                    return true;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public void a() {
        a("DELETE FROM traffic", null, true);
    }

    public List<TrafficsMonitor.a> a(boolean z) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery;
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
                    cursorQuery = writableDatabase.query(d.F, new String[]{bl.f7101d, "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=?", new String[]{UtilityImpl.a(System.currentTimeMillis())}, null, null, null, String.valueOf(100));
                } else {
                    cursorQuery = writableDatabase.query(d.F, new String[]{bl.f7101d, "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, null, null, null, null, null, String.valueOf(100));
                }
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(1);
                            String string2 = cursorQuery.getString(2);
                            String string3 = cursorQuery.getString(3);
                            String string4 = cursorQuery.getString(4);
                            boolean zBooleanValue = Boolean.valueOf(cursorQuery.getString(5)).booleanValue();
                            long j2 = cursorQuery.getLong(6);
                            if (string4 != null && j2 > 0) {
                                arrayList.add(new TrafficsMonitor.a(string, string4, string3, zBooleanValue, string2, j2));
                            }
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e3) {
                    cursor = cursorQuery;
                    e = e3;
                    ALog.w("DBHelper", e.toString(), new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    cursor = cursorQuery;
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

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0057, code lost:
    
        com.taobao.accs.utl.ALog.d("DBHelper", "db is full!", new java.lang.Object[0]);
        onUpgrade(r5, 0, 1);
        r4.a = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(String str, Object[] objArr, boolean z) {
        try {
            this.f5712b.add(new C0110a(str, objArr));
            if (this.f5712b.size() > 5 || z) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                while (true) {
                    try {
                        if (this.f5712b.size() <= 0) {
                            break;
                        }
                        C0110a c0110aRemoveFirst = this.f5712b.removeFirst();
                        if (c0110aRemoveFirst.f5714b != null) {
                            writableDatabase.execSQL(c0110aRemoveFirst.a, c0110aRemoveFirst.f5714b);
                        } else {
                            writableDatabase.execSQL(c0110aRemoveFirst.a);
                        }
                        if (c0110aRemoveFirst.a.contains("INSERT")) {
                            this.a++;
                            if (this.a > 4000) {
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        writableDatabase.close();
                        throw th;
                    }
                }
                writableDatabase.close();
            }
        } catch (Exception e2) {
            ALog.d("DBHelper", e2.toString(), new Object[0]);
        }
    }
}
