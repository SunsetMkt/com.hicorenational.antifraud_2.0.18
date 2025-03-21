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

/* compiled from: BaseSharePreference.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected Context f12260a;

    /* renamed from: b, reason: collision with root package name */
    private String f12261b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SharedPreferences f12262c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f12263d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Long> f12264e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f12265f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, Boolean> f12266g = new HashMap<>();

    public final void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.f12261b = str;
        this.f12262c = context.getSharedPreferences(this.f12261b, 0);
        this.f12260a = context;
        List<String> b2 = b("local_iv");
        if (b2 == null || b2.size() < 4) {
            u.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("com.vivo.push.secure_sub_iv", b2.get(1));
        hashMap.put("com.vivo.push.secure_sub_key", b2.get(2));
        hashMap.put("com.vivo.push.secure_cache_iv", b2.get(3));
        hashMap.put("com.vivo.push.secure_cache_key", b2.get(0));
        a(hashMap);
    }

    public final String b(String str, String str2) {
        String str3 = this.f12263d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.f12262c != null) {
            str3 = this.f12262c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f12263d.put(str, str3);
            }
        }
        return str3;
    }

    public final int b(String str, int i2) {
        Integer num = this.f12265f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f12262c != null) {
            num = Integer.valueOf(this.f12262c.getInt(str, i2));
            if (!num.equals(Integer.valueOf(i2))) {
                this.f12265f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void a(String str, String str2) {
        this.f12263d.put(str, str2);
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor edit = this.f12262c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j2) {
        Long l2 = this.f12264e.get(str);
        if (l2 != null) {
            return l2.longValue();
        }
        b();
        if (this.f12262c != null) {
            l2 = Long.valueOf(this.f12262c.getLong(str, j2));
            if (!l2.equals(Long.valueOf(j2))) {
                this.f12264e.put(str, l2);
            }
        }
        return l2.longValue();
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f12262c != null) {
                SharedPreferences.Editor edit = this.f12262c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f12263d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private synchronized void b() {
        if (this.f12262c == null) {
            if (this.f12260a != null) {
                this.f12262c = this.f12260a.getSharedPreferences(this.f12261b, 0);
            } else {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
        }
    }

    private List<String> b(String str) {
        Object a2;
        String[] split;
        if (this.f12260a == null) {
            u.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            a2 = ag.a(this.f12260a, this.f12260a.getPackageName(), str);
        } catch (Exception e2) {
            u.c("BaseSharePreference", " parsLocalIv error e =" + e2.getMessage());
            e2.printStackTrace();
        }
        if (a2 == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a2.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final void a(String str, int i2) {
        this.f12265f.put(str, Integer.valueOf(i2));
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor edit = this.f12262c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    public final void a(String str, long j2) {
        this.f12264e.put(str, Long.valueOf(j2));
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor edit = this.f12262c.edit();
            edit.putLong(str, j2);
            a(edit);
        }
    }

    public final void a(String str) {
        this.f12264e.remove(str);
        this.f12265f.remove(str);
        this.f12266g.remove(str);
        this.f12263d.remove(str);
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor edit = this.f12262c.edit();
            if (this.f12262c.contains(str)) {
                edit.remove(str);
                a(edit);
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
        this.f12264e.clear();
        this.f12265f.clear();
        this.f12266g.clear();
        this.f12263d.clear();
        b();
        if (this.f12262c != null) {
            SharedPreferences.Editor edit = this.f12262c.edit();
            edit.clear();
            a(edit);
        }
    }
}
