package com.tencent.bugly.beta.ui;

import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends Fragment {

    /* JADX INFO: renamed from: m */
    protected boolean f6050m = false;

    public synchronized void a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public abstract boolean a(int i2, KeyEvent keyEvent);

    public synchronized boolean b() {
        return this.f6050m;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        synchronized (this) {
            this.f6050m = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        synchronized (this) {
            this.f6050m = true;
        }
    }
}
