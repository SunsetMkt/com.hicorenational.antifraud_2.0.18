package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bean.CheckTimeBean;
import util.c2;
import util.s1;
import util.y0;

/* JADX INFO: loaded from: classes2.dex */
public class TimeChangeReceiver extends BroadcastReceiver {
    private void a(Context context) {
        CheckTimeBean checkTimeBean = (CheckTimeBean) c2.a(c2.I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new y0().a(context, checkTimeBean.getCode());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        byte b2;
        String action = intent.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != 502473491) {
            b2 = (iHashCode == 505380757 && action.equals("android.intent.action.TIME_SET")) ? (byte) 0 : (byte) -1;
        } else if (action.equals("android.intent.action.TIMEZONE_CHANGED")) {
            b2 = 1;
        }
        if (b2 == 0) {
            s1.a("system time changed");
        } else if (b2 != 1) {
            return;
        }
        s1.a("system time zone changed");
        a(context);
    }
}
