package com.taobao.accs.antibrush;

import android.content.Context;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AntiBrush f8381a;

    a(AntiBrush antiBrush) {
        this.f8381a = antiBrush;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        ALog.e("AntiBrush", "anti bursh timeout", new Object[0]);
        context = this.f8381a.mContext;
        AntiBrush.onResult(context, false);
    }
}
