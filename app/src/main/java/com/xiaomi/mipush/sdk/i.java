package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.df;
import com.xiaomi.push.gf;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;

/* JADX INFO: loaded from: classes2.dex */
public class i implements df {
    private Context a;

    public i(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.df
    public String a() {
        return b.m73a(this.a).d();
    }

    @Override // com.xiaomi.push.df
    public void a(he heVar, gf gfVar, gs gsVar) {
        u.a(this.a).a(heVar, gfVar, gsVar);
    }
}
