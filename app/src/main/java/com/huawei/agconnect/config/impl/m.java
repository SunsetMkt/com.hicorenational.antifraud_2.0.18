package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class m implements ConfigReader {
    private final Map<String, String> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f4334b;

    m(Context context, String str) {
        this.f4334b = new k(context, str);
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        String str3 = this.a.get(str);
        if (str3 != null) {
            return str3;
        }
        String strA = this.f4334b.a(str, str2);
        if (strA == null) {
            return str2;
        }
        this.a.put(str, strA);
        return strA;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
