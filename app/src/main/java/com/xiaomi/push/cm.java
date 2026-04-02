package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class cm implements ff, fk {
    private Context a;

    public cm(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ff
    public void a(fo foVar) {
        ct.a(this.a);
    }

    @Override // com.xiaomi.push.fk
    /* JADX INFO: renamed from: a */
    public boolean mo238a(fo foVar) {
        return true;
    }

    @Override // com.xiaomi.push.ff
    public void a(er erVar) {
        if (erVar != null && erVar.a() == 0 && "PING".equals(erVar.m388a())) {
            ct.c(this.a);
        } else {
            ct.a(this.a);
        }
    }
}
