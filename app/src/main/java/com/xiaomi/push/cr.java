package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class cr implements fd {
    private Context a;

    public cr(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i2, Exception exc) {
        cn.a(this.a, faVar.mo412a(), i2);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        cn.m239a(this.a);
    }
}
