package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.agconnect.config.impl.m */
/* loaded from: classes.dex */
class C2260m implements ConfigReader {

    /* renamed from: a */
    private final Map<String, String> f6911a = new ConcurrentHashMap();

    /* renamed from: b */
    private final C2258k f6912b;

    C2260m(Context context, String str) {
        this.f6912b = new C2258k(context, str);
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        String str3 = this.f6911a.get(str);
        if (str3 != null) {
            return str3;
        }
        String m6442a = this.f6912b.m6442a(str, str2);
        if (m6442a == null) {
            return str2;
        }
        this.f6911a.put(str, m6442a);
        return m6442a;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
