package com.tencent.open.p212b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.c */
/* loaded from: classes2.dex */
public class C3261c implements Serializable {

    /* renamed from: a */
    public final HashMap<String, String> f11180a;

    public C3261c(Bundle bundle) {
        this.f11180a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f11180a.put(str, bundle.getString(str));
            }
        }
    }

    public String toString() {
        return "BaseData{time=" + this.f11180a.get("time") + ", name=" + this.f11180a.get("interface_name") + '}';
    }

    public C3261c(HashMap<String, String> hashMap) {
        this.f11180a = new HashMap<>(hashMap);
    }
}
