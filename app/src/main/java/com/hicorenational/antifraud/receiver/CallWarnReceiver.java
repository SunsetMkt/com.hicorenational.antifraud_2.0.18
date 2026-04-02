package com.hicorenational.antifraud.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.hicorenational.antifraud.service.CallIntercepeService;
import ui.Hicore;
import util.d2;
import util.g2;

/* JADX INFO: loaded from: classes.dex */
public class CallWarnReceiver extends BroadcastReceiver {
    private Context a = Hicore.getApp();

    public CallWarnReceiver() {
        g2.b(this.a);
    }

    public void a() {
        try {
            Intent intent = new Intent(this.a, (Class<?>) CallIntercepeService.class);
            if (!d2.b(this.a, CallIntercepeService.class.getName())) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.a.startForegroundService(intent);
                } else {
                    this.a.startService(intent);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
            return;
        }
        a();
    }
}
