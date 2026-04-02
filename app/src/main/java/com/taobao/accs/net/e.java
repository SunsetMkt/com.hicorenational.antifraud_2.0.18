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

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class e extends g {

    /* JADX INFO: renamed from: c */
    private PendingIntent f5813c;

    /* JADX INFO: renamed from: d */
    private AlarmManager f5814d;

    e(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.g
    protected void a(int i2) {
        if (GlobalConfig.isAlarmHeartbeatEnable()) {
            if (this.f5814d == null) {
                this.f5814d = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.f5814d == null) {
                ALog.e("AlarmHeartBeatMgr", "setInner null", new Object[0]);
                return;
            }
            if (this.f5813c == null) {
                Intent intent = new Intent();
                intent.setPackage(this.a.getPackageName());
                intent.addFlags(32);
                intent.setAction(Constants.ACTION_COMMAND);
                intent.putExtra("command", 201);
                this.f5813c = PendingIntent.getBroadcast(this.a, 0, intent, Build.VERSION.SDK_INT >= 23 ? d.c.a.b.a.a.B1 : 0);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(13, i2);
            this.f5814d.set(0, calendar.getTimeInMillis(), this.f5813c);
        }
    }
}
