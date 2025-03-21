package com.taobao.accs.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.e */
/* loaded from: classes2.dex */
class C3005e extends AbstractC3007g {

    /* renamed from: c */
    private PendingIntent f9544c;

    /* renamed from: d */
    private AlarmManager f9545d;

    C3005e(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.AbstractC3007g
    /* renamed from: a */
    protected void mo9111a(int i2) {
        if (GlobalConfig.isAlarmHeartbeatEnable()) {
            if (this.f9545d == null) {
                this.f9545d = (AlarmManager) this.f9549a.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.f9545d == null) {
                ALog.m9182e("AlarmHeartBeatMgr", "setInner null", new Object[0]);
                return;
            }
            if (this.f9544c == null) {
                Intent intent = new Intent();
                intent.setPackage(this.f9549a.getPackageName());
                intent.addFlags(32);
                intent.setAction(Constants.ACTION_COMMAND);
                intent.putExtra("command", 201);
                this.f9544c = PendingIntent.getBroadcast(this.f9549a, 0, intent, Build.VERSION.SDK_INT >= 23 ? AbstractC1191a.f2487B1 : 0);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(13, i2);
            this.f9545d.set(0, calendar.getTimeInMillis(), this.f9544c);
        }
    }
}
