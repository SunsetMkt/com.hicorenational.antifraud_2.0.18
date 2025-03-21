package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.InterfaceC3431a;
import com.umeng.common.C3442a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    private class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i2) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(InterfaceC3431a.f12305c)) {
                str = str.replaceFirst(InterfaceC3431a.f12305c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(InterfaceC3431a.f12306d, ""), (JSONArray) obj);
            return true;
        }
    }

    private class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i2) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(InterfaceC3431a.f12305c)) {
                str = str.replaceFirst(InterfaceC3431a.f12305c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(InterfaceC3431a.f12306d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* renamed from: com.umeng.analytics.process.UMProcessDBHelper$a */
    private class C3430a implements Serializable {

        /* renamed from: a */
        int f12294a;

        /* renamed from: b */
        String f12295b;

        /* renamed from: c */
        String f12296c;

        /* renamed from: d */
        String f12297d;

        /* renamed from: e */
        int f12298e;

        /* renamed from: f */
        String f12299f;

        /* renamed from: g */
        String f12300g;

        /* renamed from: h */
        String f12301h;

        private C3430a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<C3430a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                C3430a c3430a = new C3430a();
                c3430a.f12296c = jSONObject.optString("id");
                c3430a.f12300g = UMUtils.getAppVersionName(this.mContext);
                c3430a.f12301h = UMUtils.getAppVersionCode(this.mContext);
                c3430a.f12295b = jSONObject.optString("__i");
                c3430a.f12298e = jSONObject.optInt("__t");
                c3430a.f12299f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                c3430a.f12297d = C3442a.m11498a().m11500a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(c3430a);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(C3432b.m11447b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<C3430a> list) {
        SQLiteDatabase sQLiteDatabase;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        try {
            sQLiteDatabase = C3433c.m11448a(this.mContext).m11450a(str);
        } catch (Exception unused) {
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                for (C3430a c3430a : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", c3430a.f12295b);
                        contentValues.put("__e", c3430a.f12296c);
                        contentValues.put("__t", Integer.valueOf(c3430a.f12298e));
                        contentValues.put(InterfaceC3431a.a.f12316f, c3430a.f12299f);
                        contentValues.put("__av", c3430a.f12300g);
                        contentValues.put("__vc", c3430a.f12301h);
                        contentValues.put("__s", c3430a.f12297d);
                        sQLiteDatabase.insert(InterfaceC3431a.a.f12311a, null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                C3433c.m11448a(this.mContext).m11451b(str);
                return true;
            } catch (Exception unused4) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                C3433c.m11448a(this.mContext).m11451b(str);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            C3433c.m11448a(this.mContext).m11451b(str);
            throw th;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<C3430a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(InterfaceC3431a.f12310h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b0, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ae, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0093, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5 A[Catch: Exception -> 0x00c8, TRY_LEAVE, TryCatch #3 {Exception -> 0x00c8, blocks: (B:36:0x00c0, B:30:0x00c5), top: B:35:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.C3430a> readEventByProcess(java.lang.String r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La2
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.C3433c.m11448a(r2)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La2
            android.database.sqlite.SQLiteDatabase r2 = r2.m11450a(r13)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La2
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            java.lang.String r4 = "__et_p"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            if (r3 == 0) goto L8e
        L22:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            if (r4 == 0) goto L8e
            com.umeng.analytics.process.UMProcessDBHelper$a r4 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.<init>()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r5 = 0
            int r5 = r3.getInt(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.f12294a = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = "__i"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.f12295b = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = "__e"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.f12296c = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = "__s"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.f12297d = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = "__t"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            int r5 = r3.getInt(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.f12298e = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = "__pn"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.f12299f = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = "__av"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.f12300g = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = "__vc"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r4.f12301h = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            r0.add(r4)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbd
            goto L22
        L8c:
            r1 = move-exception
            goto La6
        L8e:
            if (r3 == 0) goto L93
            r3.close()     // Catch: java.lang.Exception -> Lb3
        L93:
            if (r2 == 0) goto Lb3
            goto Lb0
        L96:
            r0 = move-exception
            r3 = r1
            goto Lbe
        L99:
            r3 = move-exception
            r11 = r3
            r3 = r1
            r1 = r11
            goto La6
        L9e:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto Lbe
        La2:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        La6:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lbd
            if (r3 == 0) goto Lae
            r3.close()     // Catch: java.lang.Exception -> Lb3
        Lae:
            if (r2 == 0) goto Lb3
        Lb0:
            r2.endTransaction()     // Catch: java.lang.Exception -> Lb3
        Lb3:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.C3433c.m11448a(r1)
            r1.m11451b(r13)
            return r0
        Lbd:
            r0 = move-exception
        Lbe:
            if (r3 == 0) goto Lc3
            r3.close()     // Catch: java.lang.Exception -> Lc8
        Lc3:
            if (r2 == 0) goto Lc8
            r2.endTransaction()     // Catch: java.lang.Exception -> Lc8
        Lc8:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.C3433c.m11448a(r1)
            r1.m11451b(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            C3433c.m11448a(this.mContext).m11450a(str);
            C3433c.m11448a(this.mContext).m11451b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        com.umeng.analytics.process.C3433c.m11448a(r4.mContext).m11451b(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if (r0 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteEventDatas(java.lang.String r5, java.lang.String r6, java.util.List<com.umeng.analytics.process.UMProcessDBHelper.C3430a> r7) {
        /*
            r4 = this;
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L7
            return
        L7:
            r6 = 0
            android.content.Context r0 = r4.mContext     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.C3433c.m11448a(r0)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            android.database.sqlite.SQLiteDatabase r0 = r0.m11450a(r5)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r1 = r7.size()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r7 == 0) goto L3f
            if (r1 <= 0) goto L3f
            r6 = 0
        L1e:
            if (r6 >= r1) goto L44
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2.<init>()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r3 = "delete from __et_p where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.Object r3 = r7.get(r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            com.umeng.analytics.process.UMProcessDBHelper$a r3 = (com.umeng.analytics.process.UMProcessDBHelper.C3430a) r3     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r3 = r3.f12294a     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2.append(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r6 = r6 + 1
            goto L1e
        L3f:
            java.lang.String r7 = "__et_p"
            r0.delete(r7, r6, r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
        L44:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r0 == 0) goto L66
            goto L63
        L4a:
            r6 = move-exception
            goto L51
        L4c:
            goto L61
        L4e:
            r7 = move-exception
            r0 = r6
            r6 = r7
        L51:
            if (r0 == 0) goto L56
            r0.endTransaction()
        L56:
            android.content.Context r7 = r4.mContext
            com.umeng.analytics.process.c r7 = com.umeng.analytics.process.C3433c.m11448a(r7)
            r7.m11451b(r5)
            throw r6
        L60:
            r0 = r6
        L61:
            if (r0 == 0) goto L66
        L63:
            r0.endTransaction()
        L66:
            android.content.Context r6 = r4.mContext
            com.umeng.analytics.process.c r6 = com.umeng.analytics.process.C3433c.m11448a(r6)
            r6.m11451b(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteEventDatas(java.lang.String, java.lang.String, java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:
    
        com.umeng.analytics.process.C3433c.m11448a(r7.mContext).m11451b(com.umeng.analytics.process.InterfaceC3431a.f12310h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r1 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r7.mContext     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.C3433c.m11448a(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            android.database.sqlite.SQLiteDatabase r1 = r2.m11450a(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
        L14:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r2 == 0) goto L32
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r6 = 0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r5[r6] = r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            goto L14
        L32:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r1 == 0) goto L4e
            goto L4b
        L38:
            r8 = move-exception
            if (r1 == 0) goto L3e
            r1.endTransaction()
        L3e:
            android.content.Context r1 = r7.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.C3433c.m11448a(r1)
            r1.m11451b(r0)
            throw r8
        L48:
            if (r1 == 0) goto L4e
        L4b:
            r1.endTransaction()
        L4e:
            android.content.Context r8 = r7.mContext
            com.umeng.analytics.process.c r8 = com.umeng.analytics.process.C3433c.m11448a(r8)
            r8.m11451b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(C3432b.m11447b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(C3432b.m11445a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.InterfaceC3427a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.InterfaceC3427a
                /* renamed from: a */
                public void mo11443a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor2 = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor2 = null;
        cursor2 = null;
        try {
            sQLiteDatabase = C3433c.m11448a(this.mContext).m11450a(InterfaceC3431a.f12310h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = sQLiteDatabase.query(InterfaceC3431a.a.f12311a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = cursor.getString(cursor.getColumnIndex("__av"));
                                        String string2 = cursor.getString(cursor.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e2) {
                                        e = e2;
                                        cursor2 = cursor;
                                        e.printStackTrace();
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception unused) {
                                                C3433c.m11448a(this.mContext).m11451b(InterfaceC3431a.f12310h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        C3433c.m11448a(this.mContext).m11451b(InterfaceC3431a.f12310h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception unused2) {
                                        C3433c.m11448a(this.mContext).m11451b(InterfaceC3431a.f12310h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                C3433c.m11448a(this.mContext).m11451b(InterfaceC3431a.f12310h);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            jSONObject = null;
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    C3433c.m11448a(this.mContext).m11451b(InterfaceC3431a.f12310h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                }
            } catch (Exception e4) {
                e = e4;
                jSONObject = null;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            sQLiteDatabase = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        C3442a.m11498a().m11501a(context);
    }
}
