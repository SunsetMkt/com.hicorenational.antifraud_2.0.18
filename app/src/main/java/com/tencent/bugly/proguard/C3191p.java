package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.umeng.analytics.pro.C3355bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.p */
/* loaded from: classes2.dex */
public class C3191p {

    /* renamed from: a */
    public static C3191p f10775a = new C3191p();

    /* renamed from: a */
    public synchronized ContentValues m10127a(String str) {
        ContentValues contentValues = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor m9829a = C3142ae.m9817a().m9829a("dl_1002", null, "_dUrl=?", new String[]{str}, null, true);
        if (m9829a != null && m9829a.moveToFirst()) {
            contentValues = new ContentValues();
            contentValues.put("_dUrl", m9829a.getString(m9829a.getColumnIndex("_dUrl")));
            contentValues.put("_sFile", m9829a.getString(m9829a.getColumnIndex("_sFile")));
            contentValues.put("_sLen", Long.valueOf(m9829a.getLong(m9829a.getColumnIndex("_sLen"))));
            contentValues.put("_tLen", Long.valueOf(m9829a.getLong(m9829a.getColumnIndex("_tLen"))));
            contentValues.put("_MD5", m9829a.getString(m9829a.getColumnIndex("_MD5")));
            contentValues.put("_DLTIME", Long.valueOf(m9829a.getLong(m9829a.getColumnIndex("_DLTIME"))));
        }
        if (m9829a != null) {
            m9829a.close();
        }
        return contentValues;
    }

    /* renamed from: b */
    public synchronized int m10133b(DownloadTask downloadTask) {
        return C3142ae.m9817a().m9827a("dl_1002", "_dUrl = ?", new String[]{downloadTask.getDownloadUrl()}, (InterfaceC3141ad) null, true);
    }

    /* renamed from: c */
    public synchronized boolean m10136c(String str) {
        return C3142ae.m9817a().m9827a("st_1002", "_id = ? and _tp = ? ", new String[]{"1002", str}, (InterfaceC3141ad) null, true) > 0;
    }

    /* renamed from: b */
    public synchronized int m10134b(String str) {
        return C3142ae.m9817a().m9827a("dl_1002", "_sFile = ?", new String[]{str}, (InterfaceC3141ad) null, true);
    }

    /* renamed from: c */
    public synchronized Map<String, byte[]> m10135c() {
        Cursor cursor;
        try {
            cursor = C3142ae.m9817a().m9829a("st_1002", null, "_id = 1002", null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                HashMap hashMap = new HashMap();
                while (cursor.moveToNext()) {
                    hashMap.put(cursor.getString(cursor.getColumnIndex(C3355bl.f11733e)), cursor.getBlob(cursor.getColumnIndex("_dt")));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C3151an.m9916a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: b */
    public synchronized int m10132b() {
        return C3142ae.m9817a().m9827a("ge_1002", (String) null, (String[]) null, (InterfaceC3141ad) null, true);
    }

    /* renamed from: a */
    public synchronized boolean m10130a(DownloadTask downloadTask) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("_dUrl", downloadTask.getDownloadUrl());
        contentValues.put("_sFile", downloadTask.getSaveFile().getAbsolutePath());
        contentValues.put("_sLen", Long.valueOf(downloadTask.getSavedLength()));
        contentValues.put("_tLen", Long.valueOf(downloadTask.getTotalLength()));
        contentValues.put("_MD5", downloadTask.getMD5());
        contentValues.put("_DLTIME", Long.valueOf(downloadTask.getCostTime()));
        return C3142ae.m9817a().m9828a("dl_1002", contentValues, (InterfaceC3141ad) null, true) >= 0;
    }

    /* renamed from: a */
    public synchronized List<C3198w> m10128a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor m9829a = C3142ae.m9817a().m9829a("ge_1002", null, null, null, null, true);
        while (m9829a != null && m9829a.moveToNext()) {
            C3198w c3198w = (C3198w) C3145ah.m9853a(m9829a.getBlob(m9829a.getColumnIndex("_datas")), C3198w.class);
            if (c3198w != null) {
                arrayList.add(c3198w);
            }
        }
        if (m9829a != null) {
            m9829a.close();
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized boolean m10131a(C3198w c3198w) {
        if (c3198w == null) {
            return false;
        }
        byte[] m9854a = C3145ah.m9854a((AbstractC3188m) c3198w);
        if (m9854a != null && m9854a.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_time", Long.valueOf(c3198w.f10817b));
            contentValues.put("_datas", m9854a);
            return C3142ae.m9817a().m9828a("ge_1002", contentValues, (InterfaceC3141ad) null, true) >= 0;
        }
        return false;
    }

    /* renamed from: a */
    public synchronized int m10126a(long j2) {
        return C3142ae.m9817a().m9827a("ge_1002", "_time = ?", new String[]{String.valueOf(j2)}, (InterfaceC3141ad) null, true);
    }

    /* renamed from: a */
    public synchronized boolean m10129a(int i2, String str, byte[] bArr) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put(C3355bl.f11732d, Integer.valueOf(i2));
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(C3355bl.f11733e, str);
        contentValues.put("_dt", bArr);
        return C3142ae.m9817a().m9828a("st_1002", contentValues, (InterfaceC3141ad) null, true) >= 0;
    }
}
