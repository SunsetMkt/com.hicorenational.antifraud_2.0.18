package com.hicorenational.antifraud.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.hicorenational.antifraud.service.CallIntercepeService;
import p388ui.Hicore;
import util.C7328v1;
import util.C7337y1;

/* loaded from: classes.dex */
public class CallWarnReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private Context f6323a = Hicore.getApp();

    public CallWarnReceiver() {
        C7337y1.m26745a(this.f6323a);
    }

    /* renamed from: a */
    public void m5951a() {
        try {
            Intent intent = new Intent(this.f6323a, (Class<?>) CallIntercepeService.class);
            if (!C7328v1.m26654b(this.f6323a, CallIntercepeService.class.getName())) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f6323a.startForegroundService(intent);
                } else {
                    this.f6323a.startService(intent);
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
        m5951a();
    }
}
