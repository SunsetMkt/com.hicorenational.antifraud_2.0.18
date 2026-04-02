package com.taobao.accs.utl;

import android.app.Application;
import com.taobao.accs.utl.l;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class m implements Runnable {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (l.b bVar : l.f5936d) {
            if (bVar != null) {
                Application unused = l.f5937e;
                bVar.a();
            }
        }
    }
}
