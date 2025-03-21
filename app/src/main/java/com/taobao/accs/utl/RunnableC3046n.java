package com.taobao.accs.utl;

import android.app.Application;
import com.taobao.accs.utl.C3044l;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.n */
/* loaded from: classes2.dex */
class RunnableC3046n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3044l f9761a;

    RunnableC3046n(C3044l c3044l) {
        this.f9761a = c3044l;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        arrayList = C3044l.f9750d;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C3044l.b bVar = (C3044l.b) it.next();
            if (bVar != null) {
                Application unused = C3044l.f9751e;
                bVar.mo9077b();
            }
        }
    }
}
