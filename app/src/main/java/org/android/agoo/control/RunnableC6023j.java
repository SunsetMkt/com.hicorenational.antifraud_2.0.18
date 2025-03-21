package org.android.agoo.control;

import android.content.Context;
import com.taobao.accs.client.C2978a;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.j */
/* loaded from: classes2.dex */
class RunnableC6023j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ BaseIntentService f21499a;

    RunnableC6023j(BaseIntentService baseIntentService) {
        this.f21499a = baseIntentService;
    }

    @Override // java.lang.Runnable
    public void run() {
        NotifManager notifManager;
        MessageService messageService;
        AgooFactory agooFactory;
        NotifManager notifManager2;
        MessageService messageService2;
        C2978a.f9405f.incrementAndGet();
        this.f21499a.notifyManager = new NotifManager();
        notifManager = this.f21499a.notifyManager;
        notifManager.init(this.f21499a.getApplicationContext());
        this.f21499a.messageService = new MessageService();
        messageService = this.f21499a.messageService;
        messageService.m24963a(this.f21499a.getApplicationContext());
        this.f21499a.agooFactory = new AgooFactory();
        agooFactory = this.f21499a.agooFactory;
        Context applicationContext = this.f21499a.getApplicationContext();
        notifManager2 = this.f21499a.notifyManager;
        messageService2 = this.f21499a.messageService;
        agooFactory.init(applicationContext, notifManager2, messageService2);
    }
}
