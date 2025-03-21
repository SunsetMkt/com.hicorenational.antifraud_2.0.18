package com.umeng.message.notify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.message.proguard.C3561aj;

/* loaded from: classes2.dex */
public final class UPushMessageNotifyActivity extends Activity {
    /* renamed from: a */
    private void m12216a(Intent intent) {
        try {
            C3561aj m12251a = C3561aj.m12251a();
            m12251a.m12254b();
            m12251a.m12252a(this, intent);
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m12216a(getIntent());
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m12216a(intent);
    }
}
