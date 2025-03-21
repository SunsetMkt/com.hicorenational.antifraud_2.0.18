package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static p f9423a = new p();

    public synchronized ContentValues a(String str) {
        ContentValues contentValues = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor a2 = ae.a().a("dl_1002", null, "_dUrl=?", new String[]{str}, null, true);
        if (a2 != null && a2.moveToFirst()) {
            contentValues = new ContentValues();
            contentValues.put("_dUrl", a2.getString(a2.getColumnIndex("_dUrl")));
            contentValues.put("_sFile", a2.getString(a2.getColumnIndex("_sFile")));
            contentValues.put("_sLen", Long.valueOf(a2.getLong(a2.getColumnIndex("_sLen"))));
            contentValues.put("_tLen", Long.valueOf(a2.getLong(a2.getColumnIndex("_tLen"))));
            contentValues.put("_MD5", a2.getString(a2.getColumnIndex("_MD5")));
            contentValues.put("_DLTIME", Long.valueOf(a2.getLong(a2.getColumnIndex("_DLTIME"))));
        }
        if (a2 != null) {
            a2.close();
        }
        return contentValues;
    }

    public synchronized int b(DownloadTask downloadTask) {
        return ae.a().a("dl_1002", "_dUrl = ?", new String[]{downloadTask.getDownloadUrl()}, (ad) null, true);
    }

    public synchronized boolean c(String str) {
        return ae.a().a("st_1002", "_id = ? and _tp = ? ", new String[]{"1002", str}, (ad) null, true) > 0;
    }

    public synchronized int b(String str) {
        return ae.a().a("dl_1002", "_sFile = ?", new String[]{str}, (ad) null, true);
    }

    public synchronized Map<String, byte[]> c() {
        Cursor cursor;
        try {
            cursor = ae.a().a("st_1002", null, "_id = 1002", null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                HashMap hashMap = new HashMap();
                while (cursor.moveToNext()) {
                    hashMap.put(cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f10171e)), cursor.getBlob(cursor.getColumnIndex("_dt")));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!an.a(th)) {
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

    public synchronized int b() {
        return ae.a().a("ge_1002", (String) null, (String[]) null, (ad) null, true);
    }

    public synchronized boolean a(DownloadTask downloadTask) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("_dUrl", downloadTask.getDownloadUrl());
        contentValues.put("_sFile", downloadTask.getSaveFile().getAbsolutePath());
        contentValues.put("_sLen", Long.valueOf(downloadTask.getSavedLength()));
        contentValues.put("_tLen", Long.valueOf(downloadTask.getTotalLength()));
        contentValues.put("_MD5", downloadTask.getMD5());
        contentValues.put("_DLTIME", Long.valueOf(downloadTask.getCostTime()));
        return ae.a().a("dl_1002", contentValues, (ad) null, true) >= 0;
    }

    public synchronized List<w> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor a2 = ae.a().a("ge_1002", null, null, null, null, true);
        while (a2 != null && a2.moveToNext()) {
            w wVar = (w) ah.a(a2.getBlob(a2.getColumnIndex("_datas")), w.class);
            if (wVar != null) {
                arrayList.add(wVar);
            }
        }
        if (a2 != null) {
            a2.close();
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return arrayList;
    }

    public synchronized boolean a(w wVar) {
        if (wVar == null) {
            return false;
        }
        byte[] a2 = ah.a((m) wVar);
        if (a2 != null && a2.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_time", Long.valueOf(wVar.f9465b));
            contentValues.put("_datas", a2);
            return ae.a().a("ge_1002", contentValues, (ad) null, true) >= 0;
        }
        return false;
    }

    public synchronized int a(long j2) {
        return ae.a().a("ge_1002", "_time = ?", new String[]{String.valueOf(j2)}, (ad) null, true);
    }

    public synchronized boolean a(int i2, String str, byte[] bArr) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put(com.umeng.analytics.pro.bl.f10170d, Integer.valueOf(i2));
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(com.umeng.analytics.pro.bl.f10171e, str);
        contentValues.put("_dt", bArr);
        return ae.a().a("st_1002", contentValues, (ad) null, true) >= 0;
    }
}
