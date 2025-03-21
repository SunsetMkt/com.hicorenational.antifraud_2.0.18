package com.taobao.accs.antibrush;

import android.content.Context;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.antibrush.a */
/* loaded from: classes.dex */
class RunnableC2963a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AntiBrush f9375a;

    RunnableC2963a(AntiBrush antiBrush) {
        this.f9375a = antiBrush;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        ALog.m9182e("AntiBrush", "anti bursh timeout", new Object[0]);
        context = this.f9375a.mContext;
        AntiBrush.onResult(context, false);
    }
}
