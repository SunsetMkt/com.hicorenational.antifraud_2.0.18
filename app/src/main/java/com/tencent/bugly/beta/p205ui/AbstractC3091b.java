package com.tencent.bugly.beta.p205ui;

import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.b */
/* loaded from: classes2.dex */
public abstract class AbstractC3091b extends Fragment {

    /* renamed from: m */
    protected boolean f9949m = false;

    /* renamed from: a */
    public synchronized void mo9351a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* renamed from: a */
    public abstract boolean mo9353a(int i2, KeyEvent keyEvent);

    /* renamed from: b */
    public synchronized boolean m9354b() {
        return this.f9949m;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        synchronized (this) {
            this.f9949m = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        synchronized (this) {
            this.f9949m = true;
        }
    }
}
