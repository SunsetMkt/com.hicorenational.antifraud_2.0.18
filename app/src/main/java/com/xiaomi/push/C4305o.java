package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.o */
/* loaded from: classes2.dex */
public class C4305o {

    /* renamed from: a */
    private static volatile C4305o f16381a;

    /* renamed from: a */
    private Context f16382a;

    /* renamed from: a */
    private Handler f16383a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private Map<String, Map<String, String>> f16384a = new HashMap();

    private C4305o(Context context) {
        this.f16382a = context;
    }

    /* renamed from: b */
    private synchronized void m15708b(String str, String str2, String str3) {
        if (this.f16384a == null) {
            this.f16384a = new HashMap();
        }
        Map<String, String> map = this.f16384a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f16384a.put(str, map);
    }

    /* renamed from: a */
    public static C4305o m15706a(Context context) {
        if (f16381a == null) {
            synchronized (C4305o.class) {
                if (f16381a == null) {
                    f16381a = new C4305o(context);
                }
            }
        }
        return f16381a;
    }

    /* renamed from: a */
    public synchronized void m15710a(final String str, final String str2, final String str3) {
        m15708b(str, str2, str3);
        this.f16383a.post(new Runnable() { // from class: com.xiaomi.push.o.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = C4305o.this.f16382a.getSharedPreferences(str, 4).edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        });
    }

    /* renamed from: a */
    private synchronized String m15707a(String str, String str2) {
        if (this.f16384a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f16384a.get(str);
                    if (map == null) {
                        return "";
                    }
                    return map.get(str2);
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    /* renamed from: a */
    public synchronized String m15709a(String str, String str2, String str3) {
        String m15707a = m15707a(str, str2);
        if (!TextUtils.isEmpty(m15707a)) {
            return m15707a;
        }
        return this.f16382a.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
