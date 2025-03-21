package org.android.agoo.control;

import android.content.Context;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseIntentService f17343a;

    j(BaseIntentService baseIntentService) {
        this.f17343a = baseIntentService;
    }

    @Override // java.lang.Runnable
    public void run() {
        NotifManager notifManager;
        MessageService messageService;
        AgooFactory agooFactory;
        NotifManager notifManager2;
        MessageService messageService2;
        com.taobao.accs.client.a.f8410f.incrementAndGet();
        this.f17343a.notifyManager = new NotifManager();
        notifManager = this.f17343a.notifyManager;
        notifManager.init(this.f17343a.getApplicationContext());
        this.f17343a.messageService = new MessageService();
        messageService = this.f17343a.messageService;
        messageService.a(this.f17343a.getApplicationContext());
        this.f17343a.agooFactory = new AgooFactory();
        agooFactory = this.f17343a.agooFactory;
        Context applicationContext = this.f17343a.getApplicationContext();
        notifManager2 = this.f17343a.notifyManager;
        messageService2 = this.f17343a.messageService;
        agooFactory.init(applicationContext, notifManager2, messageService2);
    }
}
