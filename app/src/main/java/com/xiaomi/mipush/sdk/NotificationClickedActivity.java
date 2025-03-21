package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4303m;

/* loaded from: classes2.dex */
public final class NotificationClickedActivity extends Activity {

    /* renamed from: a */
    private BroadcastReceiver f14365a;

    /* renamed from: a */
    private Handler f14366a;

    /* renamed from: a */
    private void m13453a(Intent intent) {
        try {
            if (intent != null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    AbstractC4022b.m13348a("PushClickedActivity", "clicked activity start service.");
                    startService(intent2);
                } else {
                    AbstractC4022b.m13362d("PushClickedActivity", "clicked activity start service, newIntent is null");
                }
            } else {
                AbstractC4022b.m13362d("PushClickedActivity", "clicked activity start service, missing intent");
            }
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 8388659;
        window.setAttributes(attributes);
        this.f14366a = new Handler();
        this.f14366a.postDelayed(new Runnable() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC4022b.m13363e("clicked activity finish by timeout.");
                NotificationClickedActivity.this.finish();
            }
        }, 3000L);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        this.f14365a = new BroadcastReceiver() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                AbstractC4022b.m13356b("clicked activity finish by normal.");
                NotificationClickedActivity.this.finish();
            }
        };
        try {
            C4303m.m15702a(this, this.f14365a, intentFilter, C4049c.m13516a(this), null, 4);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f14366a.removeCallbacksAndMessages(null);
        try {
            unregisterReceiver(this.f14365a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m13453a(getIntent());
    }
}
