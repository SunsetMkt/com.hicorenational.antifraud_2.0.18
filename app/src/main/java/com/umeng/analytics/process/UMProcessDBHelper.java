package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* JADX INFO: renamed from: com.umeng.analytics.process.UMProcessDBHelper$1 */
    class AnonymousClass1 implements DBFileTraversalUtil.a {
        AnonymousClass1() {
        }

        @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
        public void a() {
            if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
            }
        }
    }

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
        public boolean onFileLock(String str, Object obj) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f7420c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f7420c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f7421d, ""), (JSONArray) obj);
            return true;
        }

        /* synthetic */ InsertEventCallback(UMProcessDBHelper uMProcessDBHelper, AnonymousClass1 anonymousClass1) {
            this();
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
        public boolean onFileLock(String str) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f7420c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f7420c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f7421d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }

        /* synthetic */ ProcessToMainCallback(UMProcessDBHelper uMProcessDBHelper, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private class a implements Serializable {
        int a;

        /* JADX INFO: renamed from: b */
        String f7411b;

        /* JADX INFO: renamed from: c */
        String f7412c;

        /* JADX INFO: renamed from: d */
        String f7413d;

        /* JADX INFO: renamed from: e */
        int f7414e;

        /* JADX INFO: renamed from: f */
        String f7415f;

        /* JADX INFO: renamed from: g */
        String f7416g;

        /* JADX INFO: renamed from: h */
        String f7417h;

        private a() {
        }

        /* synthetic */ a(UMProcessDBHelper uMProcessDBHelper, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                a aVar = new a();
                aVar.f7412c = jSONObject.optString("id");
                aVar.f7416g = UMUtils.getAppVersionName(this.mContext);
                aVar.f7417h = UMUtils.getAppVersionCode(this.mContext);
                aVar.f7411b = jSONObject.optString("__i");
                aVar.f7414e = jSONObject.optInt("__t");
                aVar.f7415f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f7413d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
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

    private boolean insertEvents_(String str, List<a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(str);
        } catch (Exception unused) {
            sQLiteDatabaseA = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabaseA = null;
        }
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.f7411b);
                        contentValues.put("__e", aVar.f7412c);
                        contentValues.put("__t", Integer.valueOf(aVar.f7414e));
                        contentValues.put(a.InterfaceC0127a.f7430f, aVar.f7415f);
                        contentValues.put("__av", aVar.f7416g);
                        contentValues.put("__vc", aVar.f7417h);
                        contentValues.put("__s", aVar.f7413d);
                        sQLiteDatabaseA.insert(a.InterfaceC0127a.a, null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Exception unused4) {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            throw th;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    public void processToMain(String str) throws Throwable {
        if (dbIsExists(str)) {
            List<a> eventByProcess = readEventByProcess(str);
            if (!eventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.f7425h, eventByProcess)) {
                deleteEventDatas(str, null, eventByProcess);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00b0 A[Catch: Exception -> 0x00b3, PHI: r2
  0x00b0: PHI (r2v6 android.database.sqlite.SQLiteDatabase) = (r2v5 android.database.sqlite.SQLiteDatabase), (r2v9 android.database.sqlite.SQLiteDatabase) binds: [B:78:0x00ae, B:65:0x0093] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {Exception -> 0x00b3, blocks: (B:77:0x00ab, B:79:0x00b0, B:64:0x0090), top: B:95:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c5 A[Catch: Exception -> 0x00c8, TRY_LEAVE, TryCatch #3 {Exception -> 0x00c8, blocks: (B:84:0x00c0, B:86:0x00c5), top: B:93:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<a> readEventByProcess(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorQuery;
        Exception e2;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                sQLiteDatabaseA = c.a(this.mContext).a(str);
            } catch (Exception e3) {
                cursorQuery = null;
                e2 = e3;
                sQLiteDatabaseA = null;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabaseA = null;
                cursorQuery = null;
            }
            try {
                sQLiteDatabaseA.beginTransaction();
                cursorQuery = sQLiteDatabaseA.query(a.InterfaceC0127a.a, null, null, null, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            try {
                                a aVar = new a();
                                aVar.a = cursorQuery.getInt(0);
                                aVar.f7411b = cursorQuery.getString(cursorQuery.getColumnIndex("__i"));
                                aVar.f7412c = cursorQuery.getString(cursorQuery.getColumnIndex("__e"));
                                aVar.f7413d = cursorQuery.getString(cursorQuery.getColumnIndex("__s"));
                                aVar.f7414e = cursorQuery.getInt(cursorQuery.getColumnIndex("__t"));
                                aVar.f7415f = cursorQuery.getString(cursorQuery.getColumnIndex(a.InterfaceC0127a.f7430f));
                                aVar.f7416g = cursorQuery.getString(cursorQuery.getColumnIndex("__av"));
                                aVar.f7417h = cursorQuery.getString(cursorQuery.getColumnIndex("__vc"));
                                arrayList.add(aVar);
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                    } catch (Exception unused) {
                                        c.a(this.mContext).b(str);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabaseA != null) {
                                    sQLiteDatabaseA.endTransaction();
                                }
                                c.a(this.mContext).b(str);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            e2.printStackTrace();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e5) {
                cursorQuery = null;
                e2 = e5;
            } catch (Throwable th3) {
                th = th3;
                cursorQuery = null;
                if (cursorQuery != null) {
                }
                if (sQLiteDatabaseA != null) {
                }
                c.a(this.mContext).b(str);
                throw th;
            }
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
        } catch (Exception unused2) {
        }
        c.a(this.mContext).b(str);
        return arrayList;
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0063 A[PHI: r0
  0x0063: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = (r0v3 android.database.sqlite.SQLiteDatabase), (r0v7 android.database.sqlite.SQLiteDatabase) binds: [B:63:0x0061, B:51:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteEventDatas(String str, String str2, List<a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(str);
            try {
                sQLiteDatabaseA.beginTransaction();
                int size = list.size();
                if (list == null || size <= 0) {
                    sQLiteDatabaseA.delete(a.InterfaceC0127a.a, null, null);
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        sQLiteDatabaseA.execSQL("delete from __et_p where rowid=" + list.get(i2).a);
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Exception unused) {
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused2) {
            sQLiteDatabaseA = null;
        } catch (Throwable th3) {
            sQLiteDatabaseA = null;
            th = th3;
        }
        if (sQLiteDatabaseA != null) {
            sQLiteDatabaseA.endTransaction();
        }
        c.a(this.mContext).b(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x004b A[PHI: r1
  0x004b: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = (r1v4 android.database.sqlite.SQLiteDatabase), (r1v6 android.database.sqlite.SQLiteDatabase) binds: [B:39:0x0049, B:31:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteMainProcessEventDatasByIds(List<Integer> list) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.f7425h);
            sQLiteDatabaseA.beginTransaction();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabaseA.delete(a.InterfaceC0127a.a, "id=?", new String[]{String.valueOf(it.next())});
            }
            sQLiteDatabaseA.setTransactionSuccessful();
        } catch (Exception unused) {
            if (sQLiteDatabaseA != null) {
            }
        } catch (Throwable th) {
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
            c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
            throw th;
        }
        if (sQLiteDatabaseA != null) {
            sQLiteDatabaseA.endTransaction();
        }
        c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
    }

    public void insertEvents(String str, JSONArray jSONArray) throws Throwable {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) throws Throwable {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                AnonymousClass1() {
                }

                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject readMainEvents(long j2, List<Integer> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursor;
        JSONObject jSONObject = new JSONObject();
        Cursor cursorQuery = null;
        cursorQuery = null;
        cursorQuery = null;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.f7425h);
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorQuery = sQLiteDatabaseA.query(a.InterfaceC0127a.a, null, null, null, null, null, null);
                    if (cursorQuery != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        String str = "";
                        while (cursorQuery.moveToNext()) {
                            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("__t"));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("__i"));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("__s"));
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(a.InterfaceC0127a.f7430f));
                            String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("__av"));
                            if (!TextUtils.isEmpty(string)) {
                                if (TextUtils.isEmpty(str)) {
                                    str = string4;
                                }
                                if (!TextUtils.isEmpty(string2) && i3 == 2049) {
                                    JSONObject jSONObject3 = new JSONObject(com.umeng.common.a.a().b(string2));
                                    String strOptString = jSONObject3.optString("pn");
                                    if (TextUtils.isEmpty(strOptString) || "unknown".equals(strOptString)) {
                                        jSONObject3.put("pn", this.mContext.getPackageName() + Constants.COLON_SEPARATOR + string3);
                                    }
                                    JSONArray jSONArrayOptJSONArray = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new JSONArray();
                                    if (q.a(jSONObject3) + q.a(jSONArrayOptJSONArray) <= j2 && str.equalsIgnoreCase(string4)) {
                                        list.add(Integer.valueOf(i2));
                                        jSONArrayOptJSONArray.put(jSONObject3);
                                        jSONObject2.put(string, jSONArrayOptJSONArray);
                                    }
                                }
                            }
                        }
                        if (jSONObject2.length() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                JSONObject jSONObject4 = new JSONObject();
                                String next = itKeys.next();
                                jSONObject4.put(next, new JSONArray(jSONObject2.optString(next)));
                                if (jSONObject4.length() > 0) {
                                    jSONArray.put(jSONObject4);
                                }
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put("ekv", jSONArray);
                            }
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception unused) {
                    cursor = cursorQuery;
                    sQLiteDatabase = sQLiteDatabaseA;
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6784\u5efa\u5b50\u8fdb\u7a0b\u4e8b\u4ef6\u6570\u636e\u5f02\u5e38\uff0c\u6e05\u9664\u6570\u636e\u5e93\u6570\u636e\u3002");
                        sQLiteDatabase.execSQL("delete from __et_p");
                        sQLiteDatabase.setTransactionSuccessful();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
                        return jSONObject;
                    } catch (Throwable th) {
                        th = th;
                        Cursor cursor2 = cursor;
                        sQLiteDatabaseA = sQLiteDatabase;
                        cursorQuery = cursor2;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
                    throw th;
                }
            } catch (Exception unused3) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabaseA = null;
            }
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
        } catch (Throwable unused4) {
        }
        c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
        return jSONObject;
    }

    public JSONObject readVersionInfoFromColumId(Integer num) throws Throwable {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.f7425h);
            try {
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorQuery = sQLiteDatabaseA.query(a.InterfaceC0127a.a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            try {
                                if (cursorQuery.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("__av"));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e2) {
                                        e = e2;
                                        cursor = cursorQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                    } catch (Exception unused2) {
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabaseA != null) {
                                    sQLiteDatabaseA.endTransaction();
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            jSONObject = null;
                        }
                    }
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f7425h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = cursor;
                }
            } catch (Exception e4) {
                e = e4;
                jSONObject = null;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
            sQLiteDatabaseA = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
