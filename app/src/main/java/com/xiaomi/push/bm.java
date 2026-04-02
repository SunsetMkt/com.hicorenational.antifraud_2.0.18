package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class bm {
    private static volatile bm a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f216a;

    private bm(Context context) {
        this.f216a = context;
    }

    public static bm a(Context context) {
        if (a == null) {
            synchronized (bm.class) {
                if (a == null) {
                    a = new bm(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m186a(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.f216a.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m185a(String str, String str2, long j2) {
        SharedPreferences.Editor editorEdit = this.f216a.getSharedPreferences(str, 4).edit();
        editorEdit.putLong(str2, j2);
        editorEdit.commit();
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f216a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized long a(String str, String str2, long j2) {
        try {
        } catch (Throwable unused) {
            return j2;
        }
        return this.f216a.getSharedPreferences(str, 4).getLong(str2, j2);
    }
}
