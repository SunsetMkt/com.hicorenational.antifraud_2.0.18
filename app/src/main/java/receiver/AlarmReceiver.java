package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bean.CheckTimeBean;
import manager.NotificationHelper;
import ui.presenter.WelocmPresenter;
import util.c2;
import util.k2;
import util.s1;
import util.y0;

/* JADX INFO: loaded from: classes2.dex */
public class AlarmReceiver extends BroadcastReceiver {
    private void a(Context context) {
        CheckTimeBean checkTimeBean = (CheckTimeBean) c2.a(c2.I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new y0().b(context, checkTimeBean.getCode());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!NotificationHelper.isNotificationEnabled(context, k2.f14936g, k2.f14937h)) {
            c2.a((Object) null, c2.I0);
            c2.b(c2.J0, 0L);
            c2.b(c2.K0, 0L);
        } else {
            if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
                return;
            }
            if (((CheckTimeBean) c2.a(c2.I0, CheckTimeBean.class)) != null) {
                s1.a("hello alarm ing");
                a(context);
                new k2(context, k2.f14935f);
            }
            s1.a("hello alarm");
        }
    }
}
