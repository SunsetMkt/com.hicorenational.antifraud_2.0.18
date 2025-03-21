package com.tencent.bugly.beta.p205ui;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.ViewOnClickListenerC3079b;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaActivity extends FragmentActivity {
    public Runnable onDestroyRunnable = null;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            if (Beta.dialogFullScreen) {
                getWindow().setFlags(1024, 1024);
            }
            View findViewById = getWindow().getDecorView().findViewById(R.id.content);
            if (findViewById != null) {
                findViewById.setOnClickListener(new ViewOnClickListenerC3079b(1, this, findViewById));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int intExtra = getIntent().getIntExtra("frag", -1);
        AbstractC3091b abstractC3091b = C3096g.f9968a.get(Integer.valueOf(intExtra));
        if (abstractC3091b == null) {
            finish();
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.content, abstractC3091b).commit();
            C3096g.f9968a.remove(Integer.valueOf(intExtra));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.onDestroyRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.content);
        boolean z = false;
        try {
            if (findFragmentById instanceof AbstractC3091b) {
                z = ((AbstractC3091b) findFragmentById).mo9353a(i2, keyEvent);
            }
        } catch (Exception unused) {
        }
        if (z) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}
