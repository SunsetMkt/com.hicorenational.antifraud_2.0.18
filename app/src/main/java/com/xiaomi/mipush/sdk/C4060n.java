package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* renamed from: com.xiaomi.mipush.sdk.n */
/* loaded from: classes2.dex */
class C4060n {

    /* renamed from: a */
    int f14422a = 0;

    /* renamed from: a */
    String f14423a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C4060n)) {
            return false;
        }
        C4060n c4060n = (C4060n) obj;
        return !TextUtils.isEmpty(c4060n.f14423a) && c4060n.f14423a.equals(this.f14423a);
    }
}
