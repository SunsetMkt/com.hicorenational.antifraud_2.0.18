package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.p237f.C3911u;
import java.util.List;

/* compiled from: ImageDownTask.java */
/* renamed from: com.vivo.push.util.q */
/* loaded from: classes2.dex */
final class RunnableC4006q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f14275a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC4005p f14276b;

    RunnableC4006q(AsyncTaskC4005p asyncTaskC4005p, List list) {
        this.f14276b = asyncTaskC4005p;
        this.f14275a = list;
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
        C3911u.a aVar;
        insideNotificationItem = this.f14276b.f14269b;
        if (insideNotificationItem != null) {
            C3987ad m13198b = C3987ad.m13198b();
            j2 = this.f14276b.f14270c;
            m13198b.m13242a("com.vivo.push.notify_key", j2);
            context = this.f14276b.f14268a;
            List list = this.f14275a;
            insideNotificationItem2 = this.f14276b.f14269b;
            j3 = this.f14276b.f14270c;
            i2 = this.f14276b.f14272e;
            notifyArriveCallbackByUser = this.f14276b.f14273f;
            aVar = this.f14276b.f14274g;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j3, i2, notifyArriveCallbackByUser, aVar);
        }
    }
}
