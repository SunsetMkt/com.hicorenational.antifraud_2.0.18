package com.xiaomi.push;

import org.json.JSONArray;

/* renamed from: com.xiaomi.push.bf */
/* loaded from: classes2.dex */
public class C4104bf extends JSONArray implements InterfaceC4103be {

    /* renamed from: a */
    private int f14618a = 2;

    @Override // com.xiaomi.push.InterfaceC4103be
    /* renamed from: a */
    public int mo13904a() {
        return this.f14618a + (length() - 1);
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof InterfaceC4103be) {
            this.f14618a += ((InterfaceC4103be) obj).mo13904a();
        }
        return super.put(obj);
    }
}
