package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class ae {
    public static boolean a = false;

    /* JADX INFO: renamed from: b */
    private static ae f6350b;

    /* JADX INFO: renamed from: c */
    private static af f6351c;

    private ae(Context context, List<com.tencent.bugly.a> list) {
        f6351c = new af(context, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x00cb A[Catch: all -> 0x00cf, PHI: r1
  0x00cb: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:145:0x00e6, B:131:0x00c9] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {, blocks: (B:97:0x002c, B:98:0x002f, B:101:0x0035, B:118:0x00b2, B:119:0x00b5, B:122:0x00bb, B:142:0x00df, B:143:0x00e2, B:132:0x00cb, B:151:0x00ee, B:152:0x00f1, B:155:0x00f7, B:156:0x00fa, B:129:0x00c5, B:138:0x00d4, B:140:0x00da), top: B:169:0x0002, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<ag> c(int i2) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery;
        try {
            writableDatabase = f6351c.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            writableDatabase = null;
            cursorQuery = null;
        }
        if (writableDatabase == null) {
            if (a && writableDatabase != null) {
                writableDatabase.close();
            }
            return null;
        }
        try {
            String str = "_id = " + i2;
            cursorQuery = writableDatabase.query("t_pf", null, str, null, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    ag agVarB = b(cursorQuery);
                    if (agVarB != null) {
                        arrayList.add(agVarB);
                    } else {
                        try {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.umeng.analytics.pro.bl.f7102e));
                            sb.append(" or ");
                            sb.append(com.umeng.analytics.pro.bl.f7102e);
                            sb.append(" = ");
                            sb.append(string);
                        } catch (Throwable unused) {
                            an.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                if (sb.length() > 0) {
                    sb.append(" and ");
                    sb.append(com.umeng.analytics.pro.bl.f7101d);
                    sb.append(" = ");
                    sb.append(i2);
                    an.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (a && writableDatabase != null) {
                    }
                    return null;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (a && writableDatabase != null) {
                        writableDatabase.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    private synchronized boolean d(ag agVar) {
        ContentValues contentValuesC;
        if (agVar == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f6351c.getWritableDatabase();
            if (writableDatabase == null || (contentValuesC = c(agVar)) == null) {
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", com.umeng.analytics.pro.bl.f7101d, contentValuesC);
            if (jReplace >= 0) {
                an.c("[Database] insert %s success.", "t_pf");
                agVar.a = jReplace;
                return true;
            }
            if (a && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    public synchronized void b(int i2) {
        String str;
        SQLiteDatabase writableDatabase = f6351c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                try {
                    str = "_tp = " + i2;
                } catch (Throwable th) {
                    try {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                        if (a && writableDatabase != null) {
                        }
                    } finally {
                        if (a && writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                str = null;
            }
            an.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    class a extends Thread {

        /* JADX INFO: renamed from: b */
        private int f6352b;

        /* JADX INFO: renamed from: c */
        private ad f6353c;

        /* JADX INFO: renamed from: d */
        private String f6354d;

        /* JADX INFO: renamed from: e */
        private ContentValues f6355e;

        /* JADX INFO: renamed from: f */
        private boolean f6356f;

        /* JADX INFO: renamed from: g */
        private String[] f6357g;

        /* JADX INFO: renamed from: h */
        private String f6358h;

        /* JADX INFO: renamed from: i */
        private String[] f6359i;

        /* JADX INFO: renamed from: j */
        private String f6360j;

        /* JADX INFO: renamed from: k */
        private String f6361k;

        /* JADX INFO: renamed from: l */
        private String f6362l;

        /* JADX INFO: renamed from: m */
        private String f6363m;

        /* JADX INFO: renamed from: n */
        private String f6364n;
        private String[] o;
        private int p;
        private String q;
        private byte[] r;

        public a(int i2, ad adVar) {
            this.f6352b = i2;
            this.f6353c = adVar;
        }

        public void a(String str, ContentValues contentValues) {
            this.f6354d = str;
            this.f6355e = contentValues;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            switch (this.f6352b) {
                case 1:
                    ae.this.a(this.f6354d, this.f6355e, this.f6353c);
                    break;
                case 2:
                    ae.this.a(this.f6354d, this.f6364n, this.o, this.f6353c);
                    break;
                case 3:
                    Cursor cursorA = ae.this.a(this.f6356f, this.f6354d, this.f6357g, this.f6358h, this.f6359i, this.f6360j, this.f6361k, this.f6362l, this.f6363m, this.f6353c);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    break;
                case 4:
                    ae.this.a(this.p, this.q, this.r, this.f6353c);
                    break;
                case 5:
                    ae.this.a(this.p, this.f6353c);
                    break;
                case 6:
                    ae.this.a(this.p, this.q, this.f6353c);
                    break;
            }
        }

        public void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f6356f = z;
            this.f6354d = str;
            this.f6357g = strArr;
            this.f6358h = str2;
            this.f6359i = strArr2;
            this.f6360j = str3;
            this.f6361k = str4;
            this.f6362l = str5;
            this.f6363m = str6;
        }

        public void a(String str, String str2, String[] strArr) {
            this.f6354d = str;
            this.f6364n = str2;
            this.o = strArr;
        }

        public void a(int i2, String str, byte[] bArr) {
            this.p = i2;
            this.q = str;
            this.r = bArr;
        }

        public void a(int i2) {
            this.p = i2;
        }

        public void a(int i2, String str) {
            this.p = i2;
            this.q = str;
        }
    }

    public static synchronized ae a(Context context, List<com.tencent.bugly.a> list) {
        if (f6350b == null) {
            f6350b = new ae(context, list);
        }
        return f6350b;
    }

    public static synchronized ae a() {
        return f6350b;
    }

    public long a(String str, ContentValues contentValues, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(1, adVar);
            aVar.a(str, contentValues);
            am.a().a(aVar);
            return 0L;
        }
        return a(str, contentValues, adVar);
    }

    protected ContentValues b(ag agVar) {
        if (agVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (agVar.a > 0) {
                contentValues.put(com.umeng.analytics.pro.bl.f7101d, Long.valueOf(agVar.a));
            }
            contentValues.put(com.umeng.analytics.pro.bl.f7102e, Integer.valueOf(agVar.f6368b));
            contentValues.put("_pc", agVar.f6369c);
            contentValues.put("_th", agVar.f6370d);
            contentValues.put("_tm", Long.valueOf(agVar.f6371e));
            if (agVar.f6373g != null) {
                contentValues.put("_dt", agVar.f6373g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, ad adVar, boolean z) {
        return a(false, str, strArr, str2, strArr2, (String) null, (String) null, (String) null, (String) null, adVar, z);
    }

    public Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, ad adVar, boolean z2) {
        if (!z2) {
            a aVar = new a(3, adVar);
            aVar.a(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            am.a().a(aVar);
            return null;
        }
        return a(z, str, strArr, str2, strArr2, str3, str4, str5, str6, adVar);
    }

    public int a(String str, String str2, String[] strArr, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(2, adVar);
            aVar.a(str, str2, strArr);
            am.a().a(aVar);
            return 0;
        }
        return a(str, str2, strArr, adVar);
    }

    protected ag b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ag agVar = new ag();
            agVar.a = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f7101d));
            agVar.f6371e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f6372f = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f7102e));
            agVar.f6373g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public synchronized long a(String str, ContentValues contentValues, ad adVar) {
        long j2;
        SQLiteDatabase writableDatabase = null;
        j2 = 0;
        try {
            writableDatabase = f6351c.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, com.umeng.analytics.pro.bl.f7101d, contentValues);
                if (jReplace >= 0) {
                    an.c("[Database] insert %s success.", str);
                } else {
                    an.d("[Database] replace %s error.", str);
                }
                j2 = jReplace;
            }
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (adVar != null) {
                    adVar.a(0L);
                }
                if (a && 0 != 0) {
                }
            } finally {
                if (adVar != null) {
                    adVar.a(0L);
                }
                if (a && 0 != 0) {
                    writableDatabase.close();
                }
            }
        }
        return j2;
    }

    protected ContentValues c(ag agVar) {
        if (agVar != null && !aq.a(agVar.f6372f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (agVar.a > 0) {
                    contentValues.put(com.umeng.analytics.pro.bl.f7101d, Long.valueOf(agVar.a));
                }
                contentValues.put(com.umeng.analytics.pro.bl.f7102e, agVar.f6372f);
                contentValues.put("_tm", Long.valueOf(agVar.f6371e));
                if (agVar.f6373g != null) {
                    contentValues.put("_dt", agVar.f6373g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, ad adVar) {
        Cursor cursorQuery;
        try {
            SQLiteDatabase writableDatabase = f6351c.getWritableDatabase();
            cursorQuery = writableDatabase != null ? writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6) : null;
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (adVar != null) {
                }
            } finally {
                if (adVar != null) {
                    adVar.a(null);
                }
            }
        }
        return cursorQuery;
    }

    public synchronized int a(String str, String str2, String[] strArr, ad adVar) {
        int iDelete;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f6351c.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (adVar != null) {
                    adVar.a(0);
                }
                if (a && writableDatabase != null) {
                }
            } finally {
                if (adVar != null) {
                    adVar.a(0);
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
        return iDelete;
    }

    public boolean a(int i2, String str, byte[] bArr, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(4, adVar);
            aVar.a(i2, str, bArr);
            am.a().a(aVar);
            return true;
        }
        return a(i2, str, bArr, adVar);
    }

    public Map<String, byte[]> a(int i2, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(5, adVar);
            aVar.a(i2);
            am.a().a(aVar);
            return null;
        }
        return a(i2, adVar);
    }

    public boolean a(int i2, String str, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(6, adVar);
            aVar.a(i2, str);
            am.a().a(aVar);
            return false;
        }
        return a(i2, str, adVar);
    }

    public boolean a(int i2, String str, byte[] bArr, ad adVar) {
        boolean zD = false;
        try {
            ag agVar = new ag();
            agVar.a = i2;
            agVar.f6372f = str;
            agVar.f6371e = System.currentTimeMillis();
            agVar.f6373g = bArr;
            zD = d(agVar);
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (adVar != null) {
                }
            } finally {
                if (adVar != null) {
                    adVar.a(false);
                }
            }
        }
        return zD;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x002d A[DONT_GENERATE, PHI: r0
  0x002d: PHI (r0v1 java.util.HashMap) = (r0v3 java.util.HashMap), (r0v4 java.util.HashMap) binds: [B:62:0x003b, B:56:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, byte[]> a(int i2, ad adVar) {
        HashMap map = null;
        try {
            List<ag> listC = c(i2);
            if (listC != null) {
                HashMap map2 = new HashMap();
                try {
                    for (ag agVar : listC) {
                        byte[] bArr = agVar.f6373g;
                        if (bArr != null) {
                            map2.put(agVar.f6372f, bArr);
                        }
                    }
                    map = map2;
                } catch (Throwable th) {
                    th = th;
                    map = map2;
                    try {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                        if (adVar != null) {
                        }
                    } finally {
                        if (adVar != null) {
                            adVar.a(map);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return map;
    }

    public synchronized boolean a(ag agVar) {
        ContentValues contentValuesB;
        if (agVar == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f6351c.getWritableDatabase();
            if (writableDatabase != null && (contentValuesB = b(agVar)) != null) {
                long jReplace = writableDatabase.replace("t_lr", com.umeng.analytics.pro.bl.f7101d, contentValuesB);
                if (jReplace >= 0) {
                    an.c("[Database] insert %s success.", "t_lr");
                    agVar.a = jReplace;
                    return true;
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            if (a && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x00c2 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:123:0x00bc, B:125:0x00c2), top: B:145:0x00bc, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c7 A[Catch: all -> 0x00e6, TRY_ENTER, TryCatch #1 {, blocks: (B:83:0x0001, B:94:0x0035, B:95:0x0038, B:98:0x003e, B:115:0x00ad, B:116:0x00b0, B:119:0x00b6, B:127:0x00c7, B:128:0x00ca, B:131:0x00d0, B:134:0x00d7, B:135:0x00da, B:138:0x00e0, B:139:0x00e3, B:123:0x00bc, B:125:0x00c2), top: B:147:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<ag> a(int i2) {
        String str;
        Throwable th;
        Cursor cursorQuery;
        SQLiteDatabase writableDatabase = f6351c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                try {
                    str = "_tp = " + i2;
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                    try {
                        if (!an.a(th)) {
                        }
                        if (cursorQuery != null) {
                        }
                        if (a) {
                            writableDatabase.close();
                        }
                        return null;
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (a && writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                str = null;
            }
            cursorQuery = writableDatabase.query("t_lr", null, str, null, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    ag agVarA = a(cursorQuery);
                    if (agVarA != null) {
                        arrayList.add(agVarA);
                    } else {
                        try {
                            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex(com.umeng.analytics.pro.bl.f7101d));
                            sb.append(" or ");
                            sb.append(com.umeng.analytics.pro.bl.f7101d);
                            sb.append(" = ");
                            sb.append(j2);
                        } catch (Throwable unused) {
                            an.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    an.d("[Database] deleted %s illegal data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string.substring(4), null)));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return null;
            }
        }
        return null;
    }

    public synchronized void a(List<ag> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f6351c.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (ag agVar : list) {
                        sb.append(" or ");
                        sb.append(com.umeng.analytics.pro.bl.f7101d);
                        sb.append(" = ");
                        sb.append(agVar.a);
                    }
                    String string = sb.toString();
                    if (string.length() > 0) {
                        string = string.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        an.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string, null)));
                    } catch (Throwable th) {
                        try {
                            if (!an.a(th)) {
                                th.printStackTrace();
                            }
                            if (a) {
                            }
                        } finally {
                            if (a) {
                                writableDatabase.close();
                            }
                        }
                    }
                }
            }
        }
    }

    protected ag a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ag agVar = new ag();
            agVar.a = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f7101d));
            agVar.f6368b = cursor.getInt(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f7102e));
            agVar.f6369c = cursor.getString(cursor.getColumnIndex("_pc"));
            agVar.f6370d = cursor.getString(cursor.getColumnIndex("_th"));
            agVar.f6371e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f6373g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public synchronized boolean a(int i2, String str, ad adVar) {
        boolean z;
        SQLiteDatabase writableDatabase;
        String str2;
        z = false;
        try {
            writableDatabase = f6351c.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (aq.a(str)) {
                        str2 = "_id = " + i2;
                    } else {
                        str2 = "_id = " + i2 + " and " + com.umeng.analytics.pro.bl.f7102e + " = \"" + str + "\"";
                    }
                    int iDelete = writableDatabase.delete("t_pf", str2, null);
                    an.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(iDelete));
                    if (iDelete > 0) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                        if (adVar != null) {
                            adVar.a(false);
                        }
                        if (a && writableDatabase != null) {
                        }
                        return z;
                    } finally {
                        if (adVar != null) {
                            adVar.a(false);
                        }
                        if (a && writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
        return z;
    }
}
