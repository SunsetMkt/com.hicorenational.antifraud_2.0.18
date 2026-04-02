package com.vivo.push.f;

import android.content.Context;

/* JADX INFO: compiled from: OnNotificationClickTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class x extends aa {
    x(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        Context context = this.a;
        if (com.vivo.push.util.aa.c(context, context.getPackageName())) {
            e eVar = new e(vVar);
            eVar.a(((aa) this).f8506b);
            eVar.a(vVar);
        } else {
            d dVar = new d(vVar);
            dVar.a(((aa) this).f8506b);
            dVar.a(vVar);
        }
    }
}
