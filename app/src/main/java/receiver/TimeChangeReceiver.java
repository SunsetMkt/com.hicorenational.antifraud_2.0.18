package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bean.CheckTimeBean;
import util.C7301n1;
import util.C7325u1;
import util.C7327v0;

/* loaded from: classes2.dex */
public class TimeChangeReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private void m25175a(Context context) {
        CheckTimeBean checkTimeBean = (CheckTimeBean) C7325u1.m26615a(C7325u1.f25640I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new C7327v0().m26640a(context, checkTimeBean.getCode());
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
            C7301n1.m26453a("system time changed");
        } else if (c2 != 1) {
            return;
        }
        C7301n1.m26453a("system time zone changed");
        m25175a(context);
    }
}
