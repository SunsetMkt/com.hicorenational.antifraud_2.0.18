package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bean.CheckTimeBean;
import manager.NotificationHelper;
import p388ui.presenter.WelocmPresenter;
import util.C7254a2;
import util.C7301n1;
import util.C7325u1;
import util.C7327v0;

/* loaded from: classes2.dex */
public class AlarmReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private void m25159a(Context context) {
        CheckTimeBean checkTimeBean = (CheckTimeBean) C7325u1.m26615a(C7325u1.f25640I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new C7327v0().m26641b(context, checkTimeBean.getCode());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!NotificationHelper.isNotificationEnabled(context, C7254a2.f25106g, C7254a2.f25107h)) {
            C7325u1.m26619a((Object) null, C7325u1.f25640I0);
            C7325u1.m26629b(C7325u1.f25642J0, 0L);
            C7325u1.m26629b(C7325u1.f25644K0, 0L);
        } else {
            if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
                return;
            }
            if (((CheckTimeBean) C7325u1.m26615a(C7325u1.f25640I0, CheckTimeBean.class)) != null) {
                C7301n1.m26453a("hello alarm ing");
                m25159a(context);
                new C7254a2(context, C7254a2.f25105f);
            }
            C7301n1.m26453a("hello alarm");
        }
    }
}
