package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17331a;

    c(AgooFactory agooFactory) {
        this.f17331a = agooFactory;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageService messageService;
        messageService = this.f17331a.messageService;
        ArrayList<MsgDO> b2 = messageService.b();
        if (b2 == null || b2.size() <= 0) {
            return;
        }
        ALog.e("AgooFactory", "reportCacheMsg", "size", Integer.valueOf(b2.size()));
        Iterator<MsgDO> it = b2.iterator();
        while (it.hasNext()) {
            MsgDO next = it.next();
            if (next != null) {
                next.isFromCache = true;
                this.f17331a.notifyManager.report(next, null);
            }
        }
    }
}
