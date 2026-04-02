package com.xiaomi.push;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class bf extends JSONArray implements be {
    private int a = 2;

    @Override // com.xiaomi.push.be
    public int a() {
        return this.a + (length() - 1);
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof be) {
            this.a += ((be) obj).a();
        }
        return super.put(obj);
    }
}
