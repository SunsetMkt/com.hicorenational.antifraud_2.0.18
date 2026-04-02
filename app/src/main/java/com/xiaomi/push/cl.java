package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class cl implements ff, fk {
    private Context a;

    public cl(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ff
    public void a(fo foVar) {
        ct.b(this.a);
    }

    @Override // com.xiaomi.push.fk
    /* JADX INFO: renamed from: a */
    public boolean mo238a(fo foVar) {
        return true;
    }

    @Override // com.xiaomi.push.ff
    public void a(er erVar) {
        if (erVar != null && erVar.a() == 0 && "PING".equals(erVar.m388a())) {
            ct.d(this.a);
        } else {
            ct.b(this.a);
        }
    }
}
