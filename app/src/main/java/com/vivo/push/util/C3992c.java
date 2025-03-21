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
/* renamed from: com.vivo.push.util.c */
/* loaded from: classes2.dex */
public class C3992c {

    /* renamed from: a */
    protected Context f14239a;

    /* renamed from: b */
    private String f14240b;

    /* renamed from: c */
    private volatile SharedPreferences f14241c;

    /* renamed from: d */
    private HashMap<String, String> f14242d = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, Long> f14243e = new HashMap<>();

    /* renamed from: f */
    private HashMap<String, Integer> f14244f = new HashMap<>();

    /* renamed from: g */
    private HashMap<String, Boolean> f14245g = new HashMap<>();

    /* renamed from: a */
    public final void m13239a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.f14240b = str;
        this.f14241c = context.getSharedPreferences(this.f14240b, 0);
        this.f14239a = context;
        List<String> m13236b = m13236b("local_iv");
        if (m13236b == null || m13236b.size() < 4) {
            C4010u.m13292a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("com.vivo.push.secure_sub_iv", m13236b.get(1));
        hashMap.put("com.vivo.push.secure_sub_key", m13236b.get(2));
        hashMap.put("com.vivo.push.secure_cache_iv", m13236b.get(3));
        hashMap.put("com.vivo.push.secure_cache_key", m13236b.get(0));
        m13235a(hashMap);
    }

    /* renamed from: b */
    public final String m13246b(String str, String str2) {
        String str3 = this.f14242d.get(str);
        if (str3 != null) {
            return str3;
        }
        m13237b();
        if (this.f14241c != null) {
            str3 = this.f14241c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f14242d.put(str, str3);
            }
        }
        return str3;
    }

    /* renamed from: b */
    public final int m13244b(String str, int i2) {
        Integer num = this.f14244f.get(str);
        if (num != null) {
            return num.intValue();
        }
        m13237b();
        if (this.f14241c != null) {
            num = Integer.valueOf(this.f14241c.getInt(str, i2));
            if (!num.equals(Integer.valueOf(i2))) {
                this.f14244f.put(str, num);
            }
        }
        return num.intValue();
    }

    /* renamed from: a */
    public final void m13243a(String str, String str2) {
        this.f14242d.put(str, str2);
        m13237b();
        if (this.f14241c != null) {
            SharedPreferences.Editor edit = this.f14241c.edit();
            edit.putString(str, str2);
            m13234a(edit);
        }
    }

    /* renamed from: b */
    public final long m13245b(String str, long j2) {
        Long l2 = this.f14243e.get(str);
        if (l2 != null) {
            return l2.longValue();
        }
        m13237b();
        if (this.f14241c != null) {
            l2 = Long.valueOf(this.f14241c.getLong(str, j2));
            if (!l2.equals(Long.valueOf(j2))) {
                this.f14243e.put(str, l2);
            }
        }
        return l2.longValue();
    }

    /* renamed from: a */
    private void m13235a(Map<String, String> map) {
        if (map.size() > 0) {
            m13237b();
            if (this.f14241c != null) {
                SharedPreferences.Editor edit = this.f14241c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f14242d.put(str, str2);
                    edit.putString(str, str2);
                }
                m13234a(edit);
            }
        }
    }

    /* renamed from: b */
    private synchronized void m13237b() {
        if (this.f14241c == null) {
            if (this.f14239a != null) {
                this.f14241c = this.f14239a.getSharedPreferences(this.f14240b, 0);
            } else {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
        }
    }

    /* renamed from: b */
    private List<String> m13236b(String str) {
        Object m13209a;
        String[] split;
        if (this.f14239a == null) {
            C4010u.m13306c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            m13209a = C3990ag.m13209a(this.f14239a, this.f14239a.getPackageName(), str);
        } catch (Exception e2) {
            C4010u.m13306c("BaseSharePreference", " parsLocalIv error e =" + e2.getMessage());
            e2.printStackTrace();
        }
        if (m13209a == null) {
            return null;
        }
        String str2 = new String(Base64.decode(m13209a.toString(), 2));
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

    /* renamed from: a */
    public final void m13241a(String str, int i2) {
        this.f14244f.put(str, Integer.valueOf(i2));
        m13237b();
        if (this.f14241c != null) {
            SharedPreferences.Editor edit = this.f14241c.edit();
            edit.putInt(str, i2);
            m13234a(edit);
        }
    }

    /* renamed from: a */
    public final void m13242a(String str, long j2) {
        this.f14243e.put(str, Long.valueOf(j2));
        m13237b();
        if (this.f14241c != null) {
            SharedPreferences.Editor edit = this.f14241c.edit();
            edit.putLong(str, j2);
            m13234a(edit);
        }
    }

    /* renamed from: a */
    public final void m13240a(String str) {
        this.f14243e.remove(str);
        this.f14244f.remove(str);
        this.f14245g.remove(str);
        this.f14242d.remove(str);
        m13237b();
        if (this.f14241c != null) {
            SharedPreferences.Editor edit = this.f14241c.edit();
            if (this.f14241c.contains(str)) {
                edit.remove(str);
                m13234a(edit);
            }
        }
    }

    /* renamed from: a */
    public static void m13234a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    /* renamed from: a */
    public final void m13238a() {
        this.f14243e.clear();
        this.f14244f.clear();
        this.f14245g.clear();
        this.f14242d.clear();
        m13237b();
        if (this.f14241c != null) {
            SharedPreferences.Editor edit = this.f14241c.edit();
            edit.clear();
            m13234a(edit);
        }
    }
}
