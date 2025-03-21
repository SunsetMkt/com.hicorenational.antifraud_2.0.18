package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

/* loaded from: classes.dex */
public class AutoLifecycleFragment extends Fragment {

    /* renamed from: a */
    private final SparseArray<C2330a> f7240a = new SparseArray<>();

    /* renamed from: b */
    private boolean f7241b;

    /* renamed from: com.huawei.hms.common.internal.AutoLifecycleFragment$a */
    private static class C2330a {

        /* renamed from: a */
        public final HuaweiApiClient f7242a;

        /* renamed from: b */
        protected final int f7243b;

        public C2330a(int i2, HuaweiApiClient huaweiApiClient) {
            this.f7242a = huaweiApiClient;
            this.f7243b = i2;
        }

        /* renamed from: a */
        public void m6717a() {
            this.f7242a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e2);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f7241b = true;
        for (int i2 = 0; i2 < this.f7240a.size(); i2++) {
            this.f7240a.valueAt(i2).f7242a.connect((Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f7241b = false;
        for (int i2 = 0; i2 < this.f7240a.size(); i2++) {
            this.f7240a.valueAt(i2).f7242a.disconnect();
        }
    }

    public void startAutoMange(int i2, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        Preconditions.checkState(this.f7240a.indexOfKey(i2) < 0, "Already managing a HuaweiApiClient with this clientId: " + i2);
        this.f7240a.put(i2, new C2330a(i2, huaweiApiClient));
        if (this.f7241b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i2) {
        C2330a c2330a = this.f7240a.get(i2);
        this.f7240a.remove(i2);
        if (c2330a != null) {
            c2330a.m6717a();
        }
    }
}
