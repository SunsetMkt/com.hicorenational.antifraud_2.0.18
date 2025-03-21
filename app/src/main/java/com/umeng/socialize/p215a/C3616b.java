package com.umeng.socialize.p215a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import java.util.Map;

/* compiled from: DataStore.java */
/* renamed from: com.umeng.socialize.a.b */
/* loaded from: classes2.dex */
public class C3616b {

    /* renamed from: a */
    private static volatile C3616b f13477a;

    /* renamed from: b */
    private final SharedPreferences f13478b = ContextUtil.getContext().getSharedPreferences("um_social_azx", 0);

    private C3616b() {
    }

    /* renamed from: a */
    public static C3616b m12495a() {
        if (f13477a == null) {
            synchronized (C3616b.class) {
                if (f13477a == null) {
                    f13477a = new C3616b();
                }
            }
        }
        return f13477a;
    }

    /* renamed from: b */
    public String m12499b(String str, String str2) {
        return this.f13478b.getString(str, str2);
    }

    /* renamed from: b */
    public Map<String, ?> m12500b() {
        return this.f13478b.getAll();
    }

    /* renamed from: a */
    public void m12498a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f13478b.edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    public int m12496a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        SharedPreferences.Editor edit = this.f13478b.edit();
        int i2 = 0;
        for (String str : strArr) {
            if (this.f13478b.contains(str)) {
                edit.remove(str);
                i2++;
            }
        }
        if (i2 > 0) {
            edit.apply();
        }
        return i2;
    }

    /* renamed from: a */
    public void m12497a(String str) {
        if (this.f13478b.contains(str)) {
            this.f13478b.edit().remove(str).apply();
        }
    }
}
