package com.umeng.socialize.net.dplus.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.socialize.utils.ContextUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DBManager {
    private static DBManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static StandardDBHelper f8361b;

    private DBManager() {
        f8361b = new StandardDBHelper(ContextUtil.getContext());
    }

    public static synchronized DBManager get(Context context) {
        if (a == null) {
            a = new DBManager();
        }
        return a;
    }

    public synchronized void closeDatabase() {
        f8361b.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[EXC_TOP_SPLITTER, PHI: r0
  0x003f: PHI (r0v2 android.database.sqlite.SQLiteDatabase) = (r0v1 android.database.sqlite.SQLiteDatabase), (r0v3 android.database.sqlite.SQLiteDatabase) binds: [B:12:0x0043, B:9:0x003d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void delete(ArrayList<Integer> arrayList, String str) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f8361b.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                writableDatabase.execSQL("delete from " + str + " where Id='" + arrayList.get(i2) + "' ");
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable unused) {
            if (writableDatabase != null) {
            }
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029 A[EXC_TOP_SPLITTER, PHI: r0
  0x0029: PHI (r0v2 android.database.sqlite.SQLiteDatabase) = (r0v1 android.database.sqlite.SQLiteDatabase), (r0v3 android.database.sqlite.SQLiteDatabase) binds: [B:8:0x002d, B:5:0x0027] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void deleteTable(String str) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f8361b.getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.execSQL("DELETE FROM " + str + ";");
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable unused) {
            if (writableDatabase != null) {
            }
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void insertAuth(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        try {
            writableDatabase = f8361b.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("auth", null, contentValues);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
                if (writableDatabase != null) {
                }
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void insertDau(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        try {
            writableDatabase = f8361b.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("dau", null, contentValues);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
                if (writableDatabase != null) {
                }
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void insertS_E(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        try {
            writableDatabase = f8361b.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("s_e", null, contentValues);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
                if (writableDatabase != null) {
                }
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void insertStats(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        try {
            writableDatabase = f8361b.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("stats", null, contentValues);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
                if (writableDatabase != null) {
                }
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void insertUserInfo(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        try {
            writableDatabase = f8361b.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBConfig.VALUE, jSONObject.toString());
                writableDatabase.insert("userinfo", null, contentValues);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
                if (writableDatabase != null) {
                }
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        }
    }

    public synchronized JSONArray select(String str, ArrayList<Integer> arrayList, double d2, boolean z) throws JSONException {
        JSONArray jSONArray;
        SQLiteDatabase writableDatabase;
        jSONArray = new JSONArray();
        Cursor cursorQuery = null;
        try {
            try {
                writableDatabase = f8361b.getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    cursorQuery = writableDatabase.query(str, null, null, null, null, null, null);
                    while (cursorQuery.moveToNext()) {
                        int i2 = cursorQuery.getInt(0);
                        String string = cursorQuery.getString(1);
                        if (z && jSONArray.toString().getBytes().length + string.getBytes().length > d2) {
                            break;
                        }
                        jSONArray.put(new JSONObject(string));
                        if (!arrayList.contains(Integer.valueOf(i2))) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (JSONException e2) {
                    e = e2;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable unused) {
                                throw th;
                            }
                        }
                        if (writableDatabase == null) {
                            throw th;
                        }
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (Throwable unused2) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (writableDatabase != null) {
                    }
                    return jSONArray;
                }
            } catch (JSONException e3) {
                e = e3;
                writableDatabase = null;
            } catch (Throwable unused3) {
                writableDatabase = null;
            }
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
        } catch (Throwable unused4) {
        }
        return jSONArray;
    }
}
