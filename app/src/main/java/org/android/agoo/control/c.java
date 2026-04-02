package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import org.android.agoo.common.MsgDO;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class c implements Runnable {
    final /* synthetic */ AgooFactory a;

    c(AgooFactory agooFactory) {
        this.a = agooFactory;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<MsgDO> arrayListB = this.a.messageService.b();
        if (arrayListB == null || arrayListB.size() <= 0) {
            return;
        }
        ALog.e("AgooFactory", "reportCacheMsg", "size", Integer.valueOf(arrayListB.size()));
        for (MsgDO msgDO : arrayListB) {
            if (msgDO != null) {
                msgDO.isFromCache = true;
                this.a.notifyManager.report(msgDO, null);
            }
        }
    }
}
