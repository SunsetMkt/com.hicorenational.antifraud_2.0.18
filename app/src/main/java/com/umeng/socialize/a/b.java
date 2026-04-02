package com.umeng.socialize.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import java.util.Map;

/* JADX INFO: compiled from: DataStore.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f8169b = ContextUtil.getContext().getSharedPreferences("um_social_azx", 0);

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public String b(String str, String str2) {
        return this.f8169b.getString(str, str2);
    }

    public Map<String, ?> b() {
        return this.f8169b.getAll();
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8169b.edit().putString(str, str2).apply();
    }

    public int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        SharedPreferences.Editor editorEdit = this.f8169b.edit();
        int i2 = 0;
        for (String str : strArr) {
            if (this.f8169b.contains(str)) {
                editorEdit.remove(str);
                i2++;
            }
        }
        if (i2 > 0) {
            editorEdit.apply();
        }
        return i2;
    }

    public void a(String str) {
        if (this.f8169b.contains(str)) {
            this.f8169b.edit().remove(str).apply();
        }
    }
}
