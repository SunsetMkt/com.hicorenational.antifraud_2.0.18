package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BaseSharePreference.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    protected Context a;

    /* JADX INFO: renamed from: b */
    private String f8663b;

    /* JADX INFO: renamed from: c */
    private volatile SharedPreferences f8664c;

    /* JADX INFO: renamed from: d */
    private HashMap<String, String> f8665d = new HashMap<>();

    /* JADX INFO: renamed from: e */
    private HashMap<String, Long> f8666e = new HashMap<>();

    /* JADX INFO: renamed from: f */
    private HashMap<String, Integer> f8667f = new HashMap<>();

    /* JADX INFO: renamed from: g */
    private HashMap<String, Boolean> f8668g = new HashMap<>();

    public final void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.f8663b = str;
        this.f8664c = context.getSharedPreferences(this.f8663b, 0);
        this.a = context;
        List<String> listB = b("local_iv");
        if (listB == null || listB.size() < 4) {
            u.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        HashMap map = new HashMap();
        map.put("com.vivo.push.secure_sub_iv", listB.get(1));
        map.put("com.vivo.push.secure_sub_key", listB.get(2));
        map.put("com.vivo.push.secure_cache_iv", listB.get(3));
        map.put("com.vivo.push.secure_cache_key", listB.get(0));
        a(map);
    }

    public final String b(String str, String str2) {
        String string = this.f8665d.get(str);
        if (string != null) {
            return string;
        }
        b();
        if (this.f8664c != null) {
            string = this.f8664c.getString(str, str2);
            if (!TextUtils.isEmpty(string) && !string.equals(str2)) {
                this.f8665d.put(str, string);
            }
        }
        return string;
    }

    public final int b(String str, int i2) {
        Integer numValueOf = this.f8667f.get(str);
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        b();
        if (this.f8664c != null) {
            numValueOf = Integer.valueOf(this.f8664c.getInt(str, i2));
            if (!numValueOf.equals(Integer.valueOf(i2))) {
                this.f8667f.put(str, numValueOf);
            }
        }
        return numValueOf.intValue();
    }

    public final void a(String str, String str2) {
        this.f8665d.put(str, str2);
        b();
        if (this.f8664c != null) {
            SharedPreferences.Editor editorEdit = this.f8664c.edit();
            editorEdit.putString(str, str2);
            a(editorEdit);
        }
    }

    public final long b(String str, long j2) {
        Long lValueOf = this.f8666e.get(str);
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        b();
        if (this.f8664c != null) {
            lValueOf = Long.valueOf(this.f8664c.getLong(str, j2));
            if (!lValueOf.equals(Long.valueOf(j2))) {
                this.f8666e.put(str, lValueOf);
            }
        }
        return lValueOf.longValue();
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f8664c != null) {
                SharedPreferences.Editor editorEdit = this.f8664c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f8665d.put(str, str2);
                    editorEdit.putString(str, str2);
                }
                a(editorEdit);
            }
        }
    }

    private synchronized void b() {
        if (this.f8664c == null) {
            if (this.a != null) {
                this.f8664c = this.a.getSharedPreferences(this.f8663b, 0);
            } else {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
        }
    }

    private List<String> b(String str) {
        String[] strArrSplit;
        if (this.a == null) {
            u.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Object objA = ag.a(this.a, this.a.getPackageName(), str);
            if (objA == null) {
                return null;
            }
            String str2 = new String(Base64.decode(objA.toString(), 2));
            if (!TextUtils.isEmpty(str2) && (strArrSplit = str2.split(",#@")) != null && strArrSplit.length >= 4) {
                for (String str3 : strArrSplit) {
                    arrayList.add(str3.replace(",#@", ""));
                }
                if (arrayList.size() < 4) {
                }
            }
            return null;
        } catch (Exception e2) {
            u.c("BaseSharePreference", " parsLocalIv error e =" + e2.getMessage());
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final void a(String str, int i2) {
        this.f8667f.put(str, Integer.valueOf(i2));
        b();
        if (this.f8664c != null) {
            SharedPreferences.Editor editorEdit = this.f8664c.edit();
            editorEdit.putInt(str, i2);
            a(editorEdit);
        }
    }

    public final void a(String str, long j2) {
        this.f8666e.put(str, Long.valueOf(j2));
        b();
        if (this.f8664c != null) {
            SharedPreferences.Editor editorEdit = this.f8664c.edit();
            editorEdit.putLong(str, j2);
            a(editorEdit);
        }
    }

    public final void a(String str) {
        this.f8666e.remove(str);
        this.f8667f.remove(str);
        this.f8668g.remove(str);
        this.f8665d.remove(str);
        b();
        if (this.f8664c != null) {
            SharedPreferences.Editor editorEdit = this.f8664c.edit();
            if (this.f8664c.contains(str)) {
                editorEdit.remove(str);
                a(editorEdit);
            }
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        this.f8666e.clear();
        this.f8667f.clear();
        this.f8668g.clear();
        this.f8665d.clear();
        b();
        if (this.f8664c != null) {
            SharedPreferences.Editor editorEdit = this.f8664c.edit();
            editorEdit.clear();
            a(editorEdit);
        }
    }
}
