package com.umeng.message.notify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.message.proguard.aj;

/* loaded from: classes2.dex */
public final class UPushMessageNotifyActivity extends Activity {
    private void a(Intent intent) {
        try {
            aj a2 = aj.a();
            a2.b();
            a2.a(this, intent);
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
