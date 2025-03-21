package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.c */
/* loaded from: classes2.dex */
class RunnableC6016c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AgooFactory f21487a;

    RunnableC6016c(AgooFactory agooFactory) {
        this.f21487a = agooFactory;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageService messageService;
        messageService = this.f21487a.messageService;
        ArrayList<MsgDO> m24969b = messageService.m24969b();
        if (m24969b == null || m24969b.size() <= 0) {
            return;
        }
        ALog.m9182e("AgooFactory", "reportCacheMsg", "size", Integer.valueOf(m24969b.size()));
        Iterator<MsgDO> it = m24969b.iterator();
        while (it.hasNext()) {
            MsgDO next = it.next();
            if (next != null) {
                next.isFromCache = true;
                this.f21487a.notifyManager.report(next, null);
            }
        }
    }
}
