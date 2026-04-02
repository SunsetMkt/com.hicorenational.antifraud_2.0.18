package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class as {
    public int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f196a = new HashMap();

    public String a() {
        return this.f195a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f196a.toString(), this.f195a);
    }
}
