package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMStoreManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static final int a = 2049;

    /* JADX INFO: renamed from: b */
    public static final int f7287b = 2050;

    /* JADX INFO: renamed from: c */
    private static final int f7288c = 1000;

    /* JADX INFO: renamed from: d */
    private static Context f7289d = null;

    /* JADX INFO: renamed from: e */
    private static String f7290e = null;

    /* JADX INFO: renamed from: f */
    private static final String f7291f = "umeng+";

    /* JADX INFO: renamed from: g */
    private static final String f7292g = "ek__id";

    /* JADX INFO: renamed from: h */
    private static final String f7293h = "ek_key";

    /* JADX INFO: renamed from: i */
    private List<String> f7294i;

    /* JADX INFO: renamed from: j */
    private List<Integer> f7295j;

    /* JADX INFO: renamed from: k */
    private String f7296k;

    /* JADX INFO: renamed from: l */
    private List<String> f7297l;

    /* JADX INFO: compiled from: UMStoreManager.java */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: compiled from: UMStoreManager.java */
    private static class b {
        private static final i a = new i();

        private b() {
        }
    }

    /* synthetic */ i(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static i a(Context context) {
        i iVar = b.a;
        if (f7289d == null && context != null) {
            f7289d = context.getApplicationContext();
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f7294i.clear();
            this.f7297l.clear();
            this.f7295j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f7290e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f7289d, f7292g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f7289d).getString(f7292g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f7289d, f7292g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < strSubstring.length(); i2++) {
                        char cCharAt = strSubstring.charAt(i2);
                        if (!Character.isDigit(cCharAt)) {
                            sb.append(cCharAt);
                        } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                        }
                    }
                    f7290e = sb.toString();
                }
                if (TextUtils.isEmpty(f7290e)) {
                    return;
                }
                f7290e += new StringBuilder(f7290e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f7289d, f7293h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f7289d, f7293h, c(f7291f));
                } else {
                    if (f7291f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.f7297l.clear();
    }

    public boolean c() {
        return this.f7297l.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x006f A[EXC_TOP_SPLITTER, PHI: r0
  0x006f: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
  (r0v4 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
  (r0v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:57:0x006d, B:61:0x0081, B:55:0x006a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        String strC;
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                sQLiteDatabaseA.beginTransaction();
                strC = u.a().c();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f7289d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            for (String str : new String[]{"", "-1"}) {
                sQLiteDatabaseA.execSQL("update __et set __i=\"" + strC + "\" where __i=\"" + str + "\"");
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f7289d).b();
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            g.a(f7289d).b();
        }
    }

    public boolean e() {
        return this.f7294i.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0088 A[EXC_TOP_SPLITTER, PHI: r2 r5
  0x0088: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:95:0x0086, B:102:0x00a1] A[DONT_GENERATE, DONT_INLINE]
  0x0088: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:95:0x0086, B:102:0x00a1] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject f() {
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        jSONObject = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.f7297l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabaseA = g.a(f7289d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorA = a(e.c.a, sQLiteDatabaseA, null, "__ii=? ", new String[]{this.f7297l.get(0)}, null, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = cursorA;
                                try {
                                    h.a(f7289d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                    }
                                    return jSONObject;
                                } finally {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    g.a(f7289d).b();
                                }
                            } catch (Throwable unused3) {
                                cursor = cursorA;
                                return jSONObject;
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                g.a(f7289d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0088 A[EXC_TOP_SPLITTER, PHI: r2 r5
  0x0088: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:95:0x0086, B:102:0x00a1] A[DONT_GENERATE, DONT_INLINE]
  0x0088: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:95:0x0086, B:102:0x00a1] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject g() {
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        jSONObject = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.f7294i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabaseA = g.a(f7289d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorA = a(e.d.a, sQLiteDatabaseA, null, "__ii=? ", new String[]{this.f7294i.get(0)}, null, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = cursorA;
                                try {
                                    h.a(f7289d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                    }
                                    return jSONObject;
                                } finally {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    g.a(f7289d).b();
                                }
                            } catch (Throwable unused3) {
                                cursor = cursorA;
                                return jSONObject;
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                g.a(f7289d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0049 A[EXC_TOP_SPLITTER, PHI: r0
  0x0049: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
  (r0v4 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
  (r0v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:46:0x0047, B:50:0x005b, B:44:0x0044] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                sQLiteDatabaseA.beginTransaction();
                if (this.f7295j.size() > 0) {
                    for (int i2 = 0; i2 < this.f7295j.size(); i2++) {
                        sQLiteDatabaseA.execSQL("delete from __et where rowid=" + this.f7295j.get(i2));
                    }
                }
                this.f7295j.clear();
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f7289d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f7289d).b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x001b A[EXC_TOP_SPLITTER, PHI: r0
  0x001b: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
  (r0v4 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
  (r0v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:33:0x0019, B:37:0x002d, B:31:0x0016] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.execSQL("delete from __er");
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f7289d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f7289d).b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0053 A[EXC_TOP_SPLITTER, PHI: r1
  0x0053: PHI (r1v8 android.database.sqlite.SQLiteDatabase) = 
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v5 android.database.sqlite.SQLiteDatabase)
  (r1v11 android.database.sqlite.SQLiteDatabase)
 binds: [B:46:0x0051, B:51:0x0066, B:43:0x004d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j() {
        SQLiteDatabase sQLiteDatabaseA;
        if (!TextUtils.isEmpty(this.f7296k)) {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    sQLiteDatabaseA.execSQL("delete from __er where __i=\"" + this.f7296k + "\"");
                    sQLiteDatabaseA.execSQL("delete from __et where __i=\"" + this.f7296k + "\"");
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        h.a(f7289d);
                        if (sQLiteDatabaseA != null) {
                        }
                    } finally {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        g.a(f7289d).b();
                    }
                } catch (Throwable unused3) {
                    if (sQLiteDatabaseA != null) {
                    }
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabaseA = null;
            } catch (Throwable unused5) {
                sQLiteDatabaseA = null;
            }
        }
        this.f7296k = null;
    }

    private i() {
        this.f7294i = new ArrayList();
        this.f7295j = new ArrayList();
        this.f7296k = null;
        this.f7297l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC2);
            contentValues.put("__pp", strC);
            contentValues.put("__av", UMGlobalContext.getInstance(f7289d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f7289d));
            sQLiteDatabase.insert(e.c.a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        JSONObject jSONObject2;
        String str2;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(e.d.a.f7264e);
            if (jSONObjectOptJSONObject != null) {
                jSONObject2 = jSONObjectOptJSONObject;
                Cursor cursorA = a(e.d.a, sQLiteDatabase, new String[]{e.d.a.f7264e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    String strD = null;
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(e.d.a.f7264e)));
                        } catch (Throwable unused) {
                            cursor = cursorA;
                            if (cursor == null) {
                                return;
                            }
                            cursor.close();
                        }
                    }
                    String str3 = strD;
                    cursor = cursorA;
                    str2 = str3;
                } else {
                    cursor = cursorA;
                    str2 = null;
                }
            } else {
                jSONObject2 = jSONObjectOptJSONObject;
                str2 = null;
                cursor = null;
            }
            if (jSONObject2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray = new JSONArray(str2);
                    }
                    jSONArray.put(jSONObject2);
                    String strC = c(jSONArray.toString());
                    if (!TextUtils.isEmpty(strC)) {
                        sQLiteDatabase.execSQL("update  __sd set __d=\"" + strC + "\" where __ii=\"" + str + "\"");
                    }
                } catch (Throwable unused2) {
                    if (cursor == null) {
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(e.d.a.f7263d);
            if (jSONObjectOptJSONObject2 != null) {
                String strC2 = c(jSONObjectOptJSONObject2.toString());
                if (!TextUtils.isEmpty(strC2)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + strC2 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(e.d.a.f7266g)) + "\" where __ii=\"" + str + "\"");
            if (cursor == null) {
                return;
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
        cursor.close();
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.f7294i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0090, code lost:
    
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0096, code lost:
    
        if (r3 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0098, code lost:
    
        r3.endTransaction();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(JSONArray jSONArray) {
        SQLiteDatabase sQLiteDatabaseA;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                try {
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                ContentValues contentValues = new ContentValues();
                                String strOptString = jSONObject.optString("__i");
                                if (TextUtils.isEmpty(strOptString) || "-1".equals(strOptString)) {
                                    strOptString = u.a().b();
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = "-1";
                                    }
                                }
                                contentValues.put("__i", strOptString);
                                contentValues.put("__e", jSONObject.optString("id"));
                                contentValues.put("__t", Integer.valueOf(jSONObject.optInt("__t")));
                                contentValues.put("__av", UMUtils.getAppVersionName(f7289d));
                                contentValues.put("__vc", UMUtils.getAppVersionCode(f7289d));
                                jSONObject.remove("__i");
                                jSONObject.remove("__t");
                                contentValues.put("__s", c(jSONObject.toString()));
                                sQLiteDatabaseA.insert(e.b.a, null, contentValues);
                            } catch (Exception unused) {
                            }
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                    } catch (SQLiteDatabaseCorruptException unused2) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        try {
                            h.a(f7289d);
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            g.a(f7289d).b();
                        } catch (Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Throwable unused3) {
                                }
                            }
                            g.a(f7289d).b();
                            throw th;
                        }
                    }
                } catch (Throwable unused4) {
                }
            } catch (SQLiteDatabaseCorruptException unused5) {
            } catch (Throwable unused6) {
                sQLiteDatabaseA = null;
            }
        } catch (Throwable unused7) {
        }
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f7290e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f7290e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0098 A[PHI: r0 r1
  0x0098: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:92:0x0085, B:98:0x0093, B:99:0x0095] A[DONT_GENERATE, DONT_INLINE]
  0x0098: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:92:0x0085, B:98:0x0093, B:99:0x0095] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    if (!TextUtils.isEmpty(str)) {
                        cursorA = a(e.a.a, sQLiteDatabaseA, null, "__i=? ", new String[]{str}, null, null, null, null);
                    } else {
                        cursorA = a(e.a.a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    }
                    cursor = cursorA;
                    if (cursor != null) {
                        JSONArray jSONArray = new JSONArray();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("__a"));
                            if (!TextUtils.isEmpty(string)) {
                                jSONArray.put(new JSONObject(d(string)));
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("error", jSONArray);
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused) {
                    h.a(f7289d);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    g.a(f7289d).b();
                } catch (Throwable unused2) {
                    h.a(f7289d);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    g.a(f7289d).b();
                }
            } catch (SQLiteDatabaseCorruptException unused3) {
                sQLiteDatabaseA = null;
            } catch (Throwable unused4) {
                sQLiteDatabaseA = null;
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused5) {
                }
            }
            g.a(f7289d).b();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            g.a(f7289d).b();
            throw th;
        }
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f7290e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f7290e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0054 A[EXC_TOP_SPLITTER, PHI: r1
  0x0054: PHI (r1v4 android.database.sqlite.SQLiteDatabase) = 
  (r1v2 android.database.sqlite.SQLiteDatabase)
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:50:0x0052, B:55:0x0067, B:47:0x004e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2, int i2) {
        SQLiteDatabase sQLiteDatabaseA;
        try {
            sQLiteDatabaseA = g.a(f7289d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("__i", str);
                String strC = c(str2);
                if (!TextUtils.isEmpty(strC)) {
                    contentValues.put("__a", strC);
                    contentValues.put("__t", Integer.valueOf(i2));
                    contentValues.put("__av", UMUtils.getAppVersionName(f7289d));
                    contentValues.put("__vc", UMUtils.getAppVersionCode(f7289d));
                    sQLiteDatabaseA.insert(e.a.a, null, contentValues);
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                try {
                    h.a(f7289d);
                    if (sQLiteDatabaseA != null) {
                    }
                } finally {
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused2) {
                        }
                    }
                    g.a(f7289d).b();
                }
            } catch (Throwable unused3) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabaseA = null;
        } catch (Throwable unused5) {
            sQLiteDatabaseA = null;
        }
        return false;
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x00d9 A[PHI: r0 r1 r2
  0x00d9: PHI (r0v3 java.lang.String) = (r0v1 java.lang.String), (r0v2 java.lang.String), (r0v4 java.lang.String) binds: [B:109:0x00c5, B:115:0x00d4, B:116:0x00d6] A[DONT_GENERATE, DONT_INLINE]
  0x00d9: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:109:0x00c5, B:115:0x00d4, B:116:0x00d6] A[DONT_GENERATE, DONT_INLINE]
  0x00d9: PHI (r2v5 android.database.Cursor) = (r2v3 android.database.Cursor), (r2v4 android.database.Cursor), (r2v6 android.database.Cursor) binds: [B:109:0x00c5, B:115:0x00d4, B:116:0x00d6] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(JSONObject jSONObject, boolean z) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        String string = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorA = a(e.c.a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    if (cursorA != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            while (cursorA.moveToNext()) {
                                JSONObject jSONObject2 = new JSONObject();
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                this.f7297l.add(string);
                                String string3 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                String string4 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                if (!TextUtils.isEmpty(string3)) {
                                    jSONObject2.put(d.au, new JSONObject(d(string3)));
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    jSONObject2.put(d.av, new JSONObject(d(string4)));
                                }
                                if (!TextUtils.isEmpty(string2)) {
                                    jSONObject2.put("id", string);
                                    jSONObject2.put(d.p, string2);
                                    if (jSONObject2.length() > 0) {
                                        jSONArray.put(jSONObject2);
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put(d.f7219n, jSONArray);
                            }
                        } catch (SQLiteDatabaseCorruptException unused) {
                            h.a(f7289d);
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                            g.a(f7289d).b();
                            return string;
                        } catch (Throwable unused2) {
                            h.a(f7289d);
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                            g.a(f7289d).b();
                            return string;
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursorA != null) {
                        cursorA.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused3) {
                    cursorA = null;
                } catch (Throwable unused4) {
                    cursorA = null;
                }
            } catch (SQLiteDatabaseCorruptException unused5) {
                sQLiteDatabaseA = null;
                cursorA = null;
            } catch (Throwable unused6) {
                sQLiteDatabaseA = null;
                cursorA = null;
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused7) {
                }
            }
            g.a(f7289d).b();
            return string;
        } catch (Throwable th) {
            if (cursorA != null) {
                cursorA.close();
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused8) {
                }
            }
            g.a(f7289d).b();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0083 A[EXC_TOP_SPLITTER, PHI: r3
  0x0083: PHI (r3v4 android.database.sqlite.SQLiteDatabase) = 
  (r3v2 android.database.sqlite.SQLiteDatabase)
  (r3v3 android.database.sqlite.SQLiteDatabase)
  (r3v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:85:0x0081, B:90:0x0096, B:82:0x007d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, JSONObject jSONObject, a aVar) {
        SQLiteDatabase sQLiteDatabaseA;
        if (jSONObject == null) {
            return false;
        }
        try {
            sQLiteDatabaseA = g.a(f7289d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                if (aVar == a.BEGIN) {
                    long jLongValue = ((Long) jSONObject.opt("__e")).longValue();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__ii", str);
                    contentValues.put("__e", String.valueOf(jLongValue));
                    contentValues.put("__av", UMUtils.getAppVersionName(f7289d));
                    contentValues.put("__vc", UMUtils.getAppVersionCode(f7289d));
                    sQLiteDatabaseA.insert(e.d.a, null, contentValues);
                } else if (aVar == a.INSTANTSESSIONBEGIN) {
                    b(str, jSONObject, sQLiteDatabaseA);
                } else if (aVar == a.END) {
                    a(str, jSONObject, sQLiteDatabaseA);
                } else if (aVar == a.PAGE) {
                    a(str, jSONObject, sQLiteDatabaseA, "__a");
                } else if (aVar == a.AUTOPAGE) {
                    a(str, jSONObject, sQLiteDatabaseA, e.d.a.f7262c);
                } else if (aVar == a.NEWSESSION) {
                    c(str, jSONObject, sQLiteDatabaseA);
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                try {
                    h.a(f7289d);
                    if (sQLiteDatabaseA != null) {
                    }
                } finally {
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused2) {
                        }
                    }
                    g.a(f7289d).b();
                }
            } catch (Throwable unused3) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabaseA = null;
        } catch (Throwable unused5) {
            sQLiteDatabaseA = null;
        }
        return false;
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.opt(e.d.a.f7266g)).longValue();
            long jLongValue2 = 0;
            Object objOpt = jSONObject.opt(e.d.a.f7267h);
            if (objOpt != null && (objOpt instanceof Long)) {
                jLongValue2 = ((Long) objOpt).longValue();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", " + e.d.a.f7267h + "=\"" + jLongValue2 + "\", __sp=\"" + strC2 + "\", __pp=\"" + strC + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0055 A[EXC_TOP_SPLITTER, PHI: r0
  0x0055: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = 
  (r0v2 android.database.sqlite.SQLiteDatabase)
  (r0v3 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
 binds: [B:54:0x0053, B:58:0x0067, B:52:0x0050] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                sQLiteDatabaseA.beginTransaction();
                if (z2) {
                    if (z) {
                        sQLiteDatabaseA.execSQL("delete from __sd");
                    }
                } else if (this.f7294i.size() > 0) {
                    for (int i2 = 0; i2 < this.f7294i.size(); i2++) {
                        sQLiteDatabaseA.execSQL("delete from __sd where __ii=\"" + this.f7294i.get(i2) + "\"");
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f7289d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f7289d).b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x005f A[Catch: Exception -> 0x0062, PHI: r2 r4
  0x005f: PHI (r2v3 long) = (r2v0 long), (r2v6 long) binds: [B:62:0x005d, B:47:0x003c] A[DONT_GENERATE, DONT_INLINE]
  0x005f: PHI (r4v4 android.database.sqlite.SQLiteDatabase) = (r4v3 android.database.sqlite.SQLiteDatabase), (r4v7 android.database.sqlite.SQLiteDatabase) binds: [B:62:0x005d, B:47:0x003c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {Exception -> 0x0062, blocks: (B:46:0x0039, B:63:0x005f, B:61:0x005a), top: B:71:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA = null;
        long j2 = 0;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorA = a(e.d.a, sQLiteDatabaseA, new String[]{e.d.a.f7266g}, "__ii=? ", new String[]{str}, null, null, null, null);
                    if (cursorA != null) {
                        cursorA.moveToFirst();
                        j2 = cursorA.getLong(cursorA.getColumnIndex(e.d.a.f7266g));
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                } catch (Exception unused) {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorA != null) {
                        try {
                            cursorA.close();
                        } catch (Exception unused2) {
                            g.a(f7289d).b();
                            throw th;
                        }
                    }
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                    g.a(f7289d).b();
                    throw th;
                }
            } catch (Exception unused3) {
                sQLiteDatabaseA = null;
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabaseA = null;
            }
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
        } catch (Exception unused4) {
        }
        g.a(f7289d).b();
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0035 A[EXC_TOP_SPLITTER, PHI: r0
  0x0035: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
  (r0v4 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
  (r0v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:39:0x0033, B:43:0x0047, B:37:0x0030] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.execSQL("delete from __is where __ii=\"" + str + "\"");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f7289d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f7289d).b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0056 A[EXC_TOP_SPLITTER, LOOP:1: B:121:0x0056->B:91:0x005c, LOOP_START, PHI: r14
  0x0056: PHI (r14v1 java.lang.String) = (r14v0 java.lang.String), (r14v2 java.lang.String) binds: [B:88:0x0054, B:91:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0077 A[Catch: all -> 0x0069, TryCatch #1 {all -> 0x0069, blocks: (B:89:0x0056, B:91:0x005c, B:93:0x006c, B:95:0x0077, B:96:0x007c, B:103:0x008b, B:105:0x0091, B:107:0x0097, B:109:0x009d, B:111:0x00ab, B:108:0x009a), top: B:121:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws JSONException {
        Cursor cursorA;
        JSONArray jSONArray;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArray2;
        String strD = null;
        try {
        } catch (Throwable unused) {
            cursorA = null;
        }
        if ("__a".equals(str2)) {
            jSONArrayOptJSONArray = jSONObject.optJSONArray("__a");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            if (jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
        } else if (e.d.a.f7262c.equals(str2)) {
            jSONArrayOptJSONArray = jSONObject.optJSONArray(e.d.a.f7262c);
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
        } else {
            jSONArray = null;
            cursorA = a(e.d.a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
            if (cursorA != null) {
                while (cursorA.moveToNext()) {
                    try {
                        strD = d(cursorA.getString(cursorA.getColumnIndex(str2)));
                    } catch (Throwable unused2) {
                        if (cursorA == null) {
                            return;
                        }
                    }
                }
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(strD)) {
                jSONArray2 = new JSONArray(strD);
            }
            if (jSONArray2.length() <= 1000) {
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        jSONArray2.put(jSONObject2);
                    }
                } catch (JSONException unused3) {
                }
            }
            String strC = c(jSONArray2.toString());
            if (!TextUtils.isEmpty(strC)) {
                sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
            }
            if (cursorA == null) {
                return;
            }
            cursorA.close();
            return;
        }
        jSONArray = jSONArrayOptJSONArray;
        cursorA = a(e.d.a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
        if (cursorA != null) {
        }
        jSONArray2 = new JSONArray();
        if (!TextUtils.isEmpty(strD)) {
        }
        if (jSONArray2.length() <= 1000) {
        }
    }

    public JSONObject a(boolean z) {
        a();
        this.f7295j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String strA = a(jSONObject, z);
            if (!TextUtils.isEmpty(strA)) {
                b(jSONObject, strA);
                a(jSONObject, strA);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x0195 A[PHI: r0 r1
  0x0195: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:197:0x0182, B:203:0x0190, B:204:0x0192] A[DONT_GENERATE, DONT_INLINE]
  0x0195: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:197:0x0182, B:203:0x0190, B:204:0x0192] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
            } catch (SQLiteDatabaseCorruptException unused) {
                sQLiteDatabaseA = null;
            } catch (Throwable unused2) {
                sQLiteDatabaseA = null;
            }
            try {
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    cursorA = a(e.b.a, sQLiteDatabaseA, null, "__i=? ", new String[]{str}, null, null, null, null);
                } else {
                    cursorA = a(e.b.a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                }
                cursor = cursorA;
                if (cursor != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    String strB = u.a().b();
                    while (cursor.moveToNext()) {
                        int i2 = cursor.getInt(cursor.getColumnIndex("__t"));
                        String string = cursor.getString(cursor.getColumnIndex("__i"));
                        String string2 = cursor.getString(cursor.getColumnIndex("__s"));
                        if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                            if (!TextUtils.isEmpty(strB)) {
                                string = strB;
                            }
                        }
                        this.f7295j.add(Integer.valueOf(cursor.getInt(0)));
                        if (i2 != 2049) {
                            if (i2 == 2050 && !TextUtils.isEmpty(string2)) {
                                JSONObject jSONObject4 = new JSONObject(d(string2));
                                if (jSONObject3.has(string)) {
                                    jSONArray = jSONObject3.optJSONArray(string);
                                } else {
                                    jSONArray = new JSONArray();
                                }
                                jSONArray.put(jSONObject4);
                                jSONObject3.put(string, jSONArray);
                            }
                        } else if (!TextUtils.isEmpty(string2)) {
                            JSONObject jSONObject5 = new JSONObject(d(string2));
                            if (jSONObject2.has(string)) {
                                jSONArray2 = jSONObject2.optJSONArray(string);
                            } else {
                                jSONArray2 = new JSONArray();
                            }
                            jSONArray2.put(jSONObject5);
                            jSONObject2.put(string, jSONArray2);
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<String> itKeys = jSONObject2.keys();
                        while (itKeys.hasNext()) {
                            JSONObject jSONObject6 = new JSONObject();
                            String next = itKeys.next();
                            jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                            if (jSONObject6.length() > 0) {
                                jSONArray3.put(jSONObject6);
                            }
                        }
                        if (jSONArray3.length() > 0) {
                            jSONObject.put("ekv", jSONArray3);
                        }
                    }
                    if (jSONObject3.length() > 0) {
                        JSONArray jSONArray4 = new JSONArray();
                        Iterator<String> itKeys2 = jSONObject3.keys();
                        while (itKeys2.hasNext()) {
                            JSONObject jSONObject7 = new JSONObject();
                            String next2 = itKeys2.next();
                            jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                            if (jSONObject7.length() > 0) {
                                jSONArray4.put(jSONObject7);
                            }
                        }
                        if (jSONArray4.length() > 0) {
                            jSONObject.put(d.T, jSONArray4);
                        }
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteDatabaseCorruptException unused3) {
                h.a(f7289d);
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabaseA != null) {
                }
                g.a(f7289d).b();
            } catch (Throwable unused4) {
                h.a(f7289d);
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabaseA != null) {
                }
                g.a(f7289d).b();
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused5) {
                }
            }
            g.a(f7289d).b();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            g.a(f7289d).b();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:239:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0238 A[PHI: r0 r12 r14
  0x0238: PHI (r0v4 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v5 java.lang.String) binds: [B:240:0x0224, B:246:0x0233, B:247:0x0235] A[DONT_GENERATE, DONT_INLINE]
  0x0238: PHI (r12v5 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:240:0x0224, B:246:0x0233, B:247:0x0235] A[DONT_GENERATE, DONT_INLINE]
  0x0238: PHI (r14v5 android.database.Cursor) = (r14v3 android.database.Cursor), (r14v4 android.database.Cursor), (r14v6 android.database.Cursor) binds: [B:240:0x0224, B:246:0x0233, B:247:0x0235] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0235 A[EXC_TOP_SPLITTER, PHI: r0 r12 r14
  0x0235: PHI (r0v5 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v38 java.lang.String) binds: [B:240:0x0224, B:246:0x0233, B:232:0x0211] A[DONT_GENERATE, DONT_INLINE]
  0x0235: PHI (r12v6 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:240:0x0224, B:246:0x0233, B:232:0x0211] A[DONT_GENERATE, DONT_INLINE]
  0x0235: PHI (r14v6 android.database.Cursor) = (r14v3 android.database.Cursor), (r14v4 android.database.Cursor), (r14v33 android.database.Cursor) binds: [B:240:0x0224, B:246:0x0233, B:232:0x0211] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(JSONObject jSONObject, boolean z) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursor;
        JSONArray jSONArray;
        String str;
        JSONArray jSONArray2;
        String string = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    Cursor cursorA = a(e.d.a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    if (cursorA != null) {
                        try {
                            JSONArray jSONArray3 = new JSONArray();
                            while (true) {
                                if (!cursorA.moveToNext()) {
                                    cursor = cursorA;
                                    jSONArray = jSONArray3;
                                    break;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                String string2 = cursorA.getString(cursorA.getColumnIndex(e.d.a.f7266g));
                                String string3 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                String string4 = cursorA.getString(cursorA.getColumnIndex(e.d.a.f7267h));
                                string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                try {
                                    if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                                        str = string;
                                        cursor = cursorA;
                                        jSONArray = jSONArray3;
                                    } else {
                                        if (Long.parseLong(string2) - Long.parseLong(string3) > 0) {
                                            String string5 = cursorA.getString(cursorA.getColumnIndex("__a"));
                                            String string6 = cursorA.getString(cursorA.getColumnIndex(e.d.a.f7262c));
                                            String string7 = cursorA.getString(cursorA.getColumnIndex(e.d.a.f7263d));
                                            String string8 = cursorA.getString(cursorA.getColumnIndex(e.d.a.f7264e));
                                            this.f7294i.add(string);
                                            String string9 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                            String string10 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                            jSONObject2.put("id", string);
                                            jSONObject2.put(d.p, string3);
                                            jSONObject2.put(d.q, string2);
                                            str = string;
                                            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                cursor = cursorA;
                                                jSONArray2 = jSONArray3;
                                                jSONObject2.put("duration", Long.parseLong(string2) - Long.parseLong(string3));
                                            } else {
                                                try {
                                                    if (Long.parseLong(string4) <= 0) {
                                                        jSONObject2.put("duration", Long.parseLong(string2) - Long.parseLong(string3));
                                                        cursor = cursorA;
                                                        jSONArray2 = jSONArray3;
                                                    } else {
                                                        cursor = cursorA;
                                                        jSONArray2 = jSONArray3;
                                                        jSONObject2.put("duration", Long.parseLong(string4));
                                                        jSONObject2.put(d.s, Long.parseLong(string2) - Long.parseLong(string3));
                                                    }
                                                } catch (SQLiteDatabaseCorruptException unused) {
                                                    cursor = cursorA;
                                                    string = str;
                                                    h.a(f7289d);
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    if (sQLiteDatabaseA == null) {
                                                    }
                                                    g.a(f7289d).b();
                                                    return string;
                                                } catch (Throwable unused2) {
                                                    cursor = cursorA;
                                                    string = str;
                                                    h.a(f7289d);
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    if (sQLiteDatabaseA == null) {
                                                    }
                                                    g.a(f7289d).b();
                                                    return string;
                                                }
                                            }
                                            if (!TextUtils.isEmpty(string5)) {
                                                try {
                                                    jSONObject2.put(d.t, new JSONArray(d(string5)));
                                                } catch (SQLiteDatabaseCorruptException unused3) {
                                                    string = str;
                                                    h.a(f7289d);
                                                    if (cursor != null) {
                                                    }
                                                    if (sQLiteDatabaseA == null) {
                                                    }
                                                    g.a(f7289d).b();
                                                    return string;
                                                } catch (Throwable unused4) {
                                                    string = str;
                                                    h.a(f7289d);
                                                    if (cursor != null) {
                                                    }
                                                    if (sQLiteDatabaseA == null) {
                                                    }
                                                    g.a(f7289d).b();
                                                    return string;
                                                }
                                            }
                                            boolean z2 = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO;
                                            if (!TextUtils.isEmpty(string6) && z2) {
                                                JSONArray jSONArray4 = new JSONArray(d(string6));
                                                JSONArray jSONArray5 = new JSONArray();
                                                if (jSONArray4.length() > 0) {
                                                    jSONArray5 = b(jSONArray4);
                                                }
                                                jSONObject2.put(d.u, jSONArray5);
                                            }
                                            if (!TextUtils.isEmpty(string7)) {
                                                jSONObject2.put(d.F, new JSONObject(d(string7)));
                                            }
                                            if (!TextUtils.isEmpty(string8)) {
                                                jSONObject2.put(d.B, new JSONArray(d(string8)));
                                            }
                                            if (!TextUtils.isEmpty(string9)) {
                                                jSONObject2.put(d.au, new JSONObject(d(string9)));
                                            }
                                            if (!TextUtils.isEmpty(string10)) {
                                                jSONObject2.put(d.av, new JSONObject(d(string10)));
                                            }
                                            if (jSONObject2.length() > 0) {
                                                jSONArray = jSONArray2;
                                                jSONArray.put(jSONObject2);
                                            } else {
                                                jSONArray = jSONArray2;
                                            }
                                        } else {
                                            str = string;
                                            cursor = cursorA;
                                            jSONArray = jSONArray3;
                                        }
                                        if (z) {
                                            string = str;
                                            break;
                                        }
                                    }
                                    jSONArray3 = jSONArray;
                                    cursorA = cursor;
                                    string = str;
                                } catch (SQLiteDatabaseCorruptException unused5) {
                                    cursor = cursorA;
                                    h.a(f7289d);
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabaseA == null) {
                                    }
                                    g.a(f7289d).b();
                                    return string;
                                } catch (Throwable unused6) {
                                    cursor = cursorA;
                                    h.a(f7289d);
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabaseA == null) {
                                    }
                                    g.a(f7289d).b();
                                    return string;
                                }
                            }
                            try {
                                if (this.f7294i.size() < 1) {
                                    return string;
                                }
                                if (jSONArray.length() > 0) {
                                    jSONObject.put(d.f7219n, jSONArray);
                                }
                            } catch (SQLiteDatabaseCorruptException unused7) {
                                h.a(f7289d);
                                if (cursor != null) {
                                }
                                if (sQLiteDatabaseA == null) {
                                }
                                g.a(f7289d).b();
                                return string;
                            } catch (Throwable unused8) {
                                h.a(f7289d);
                                if (cursor != null) {
                                }
                                if (sQLiteDatabaseA == null) {
                                }
                                g.a(f7289d).b();
                                return string;
                            }
                        } catch (SQLiteDatabaseCorruptException unused9) {
                        } catch (Throwable unused10) {
                        }
                    } else {
                        cursor = cursorA;
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused11) {
                    cursor = null;
                } catch (Throwable unused12) {
                    cursor = null;
                }
            } catch (SQLiteDatabaseCorruptException unused13) {
                sQLiteDatabaseA = null;
                cursor = null;
            } catch (Throwable unused14) {
                sQLiteDatabaseA = null;
                cursor = null;
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused15) {
                }
            }
            g.a(f7289d).b();
            return string;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused16) {
                }
            }
            g.a(f7289d).b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0068 A[EXC_TOP_SPLITTER, PHI: r0
  0x0068: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = 
  (r0v1 android.database.sqlite.SQLiteDatabase)
  (r0v2 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
 binds: [B:70:0x0066, B:68:0x0060, B:64:0x0056] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(f7289d).a();
                    sQLiteDatabaseA.beginTransaction();
                    if (!z2) {
                        int size = this.f7297l.size();
                        int i2 = 0;
                        if (size > 0) {
                            int i3 = 0;
                            while (i2 < size) {
                                String str = this.f7297l.get(i2);
                                if (str == null) {
                                    i3 = 1;
                                }
                                sQLiteDatabaseA.execSQL("delete from __is where __ii=\"" + str + "\"");
                                i2++;
                            }
                            i2 = i3;
                        }
                        if (i2 != 0) {
                            sQLiteDatabaseA.execSQL("delete from __is where __ii is null");
                        }
                    } else if (z) {
                        sQLiteDatabaseA.execSQL("delete from __is");
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    h.a(f7289d);
                    if (sQLiteDatabaseA != null) {
                    }
                }
            } catch (Throwable unused2) {
                h.a(f7289d);
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
            }
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
            g.a(f7289d).b();
        } catch (Throwable th) {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            g.a(f7289d).b();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0068 A[EXC_TOP_SPLITTER, PHI: r0
  0x0068: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = 
  (r0v2 android.database.sqlite.SQLiteDatabase)
  (r0v3 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
 binds: [B:39:0x0066, B:43:0x007a, B:37:0x0063] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f7289d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.execSQL("delete from __er where __i=\"" + str + "\"");
                    sQLiteDatabaseA.execSQL("delete from __et where __i=\"" + str + "\"");
                    this.f7295j.clear();
                    sQLiteDatabaseA.execSQL("delete from __sd where __ii=\"" + str + "\"");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f7289d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f7289d).b();
        }
    }
}
