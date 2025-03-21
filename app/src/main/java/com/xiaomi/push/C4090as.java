package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.as */
/* loaded from: classes2.dex */
public class C4090as {

    /* renamed from: a */
    public int f14569a;

    /* renamed from: a */
    public String f14570a;

    /* renamed from: a */
    public Map<String, String> f14571a = new HashMap();

    /* renamed from: a */
    public String m13779a() {
        return this.f14570a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f14569a), this.f14571a.toString(), this.f14570a);
    }
}
