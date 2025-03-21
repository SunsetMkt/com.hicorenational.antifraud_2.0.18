package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bean.CheckTimeBean;
import util.n1;
import util.u1;
import util.v0;

/* loaded from: classes2.dex */
public class TimeChangeReceiver extends BroadcastReceiver {
    private void a(Context context) {
        CheckTimeBean checkTimeBean = (CheckTimeBean) u1.a(u1.I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new v0().a(context, checkTimeBean.getCode());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        char c2;
        String action = intent.getAction();
        int hashCode = action.hashCode();
        if (hashCode != 502473491) {
            if (hashCode == 505380757 && action.equals("android.intent.action.TIME_SET")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            n1.a("system time changed");
        } else if (c2 != 1) {
            return;
        }
        n1.a("system time zone changed");
        a(context);
    }
}
