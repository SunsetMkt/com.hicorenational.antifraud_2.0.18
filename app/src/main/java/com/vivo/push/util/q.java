package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.List;

/* compiled from: ImageDownTask.java */
/* loaded from: classes2.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f12296a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f12297b;

    q(p pVar, List list) {
        this.f12297b = pVar;
        this.f12296a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j2;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j3;
        int i2;
        NotifyArriveCallbackByUser notifyArriveCallbackByUser;
        u.a aVar;
        insideNotificationItem = this.f12297b.f12290b;
        if (insideNotificationItem != null) {
            ad b2 = ad.b();
            j2 = this.f12297b.f12291c;
            b2.a("com.vivo.push.notify_key", j2);
            context = this.f12297b.f12289a;
            List list = this.f12296a;
            insideNotificationItem2 = this.f12297b.f12290b;
            j3 = this.f12297b.f12291c;
            i2 = this.f12297b.f12293e;
            notifyArriveCallbackByUser = this.f12297b.f12294f;
            aVar = this.f12297b.f12295g;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j3, i2, notifyArriveCallbackByUser, aVar);
        }
    }
}
