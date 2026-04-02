package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.bw;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class bp implements Runnable {
    private String a;

    /* JADX INFO: renamed from: a */
    private WeakReference<Context> f226a;

    public bp(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f226a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f226a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (ca.a(this.a) <= bo.f224a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bs bsVarA = bs.a(this.a);
        br brVarA = br.a(this.a);
        bsVarA.a(brVarA);
        brVarA.a(bq.a(context, this.a, 1000));
        bw.a(context).a((bw.a) bsVarA);
    }
}
