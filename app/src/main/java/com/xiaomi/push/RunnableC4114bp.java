package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4121bw;
import java.lang.ref.WeakReference;

/* renamed from: com.xiaomi.push.bp */
/* loaded from: classes2.dex */
public class RunnableC4114bp implements Runnable {

    /* renamed from: a */
    private String f14656a;

    /* renamed from: a */
    private WeakReference<Context> f14657a;

    public RunnableC4114bp(String str, WeakReference<Context> weakReference) {
        this.f14656a = str;
        this.f14657a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f14657a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (C4126ca.m14027a(this.f14656a) <= C4113bo.f14654a) {
            AbstractC4022b.m13356b("=====> do not need clean db");
            return;
        }
        C4117bs m13952a = C4117bs.m13952a(this.f14656a);
        C4116br m13948a = C4116br.m13948a(this.f14656a);
        m13952a.m13970a(m13948a);
        m13948a.m13970a(C4115bq.m13945a(context, this.f14656a, 1000));
        C4121bw.m13957a(context).m13961a((C4121bw.a) m13952a);
    }
}
