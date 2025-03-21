package com.huawei.hmf.tasks.p170a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: com.huawei.hmf.tasks.a.g */
/* loaded from: classes.dex */
public final class FragmentC2277g extends Fragment {

    /* renamed from: b */
    private static final WeakHashMap<Activity, WeakReference<FragmentC2277g>> f6970b = new WeakHashMap<>();

    /* renamed from: a */
    private final List<WeakReference<ExecuteResult<?>>> f6971a = new ArrayList();

    /* renamed from: a */
    private static FragmentC2277g m6480a(Activity activity) {
        FragmentC2277g fragmentC2277g;
        WeakReference<FragmentC2277g> weakReference = f6970b.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            FragmentC2277g fragmentC2277g2 = (FragmentC2277g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (fragmentC2277g2 == null) {
                try {
                    fragmentC2277g = m6481a(fragmentManager);
                } catch (ClassCastException e2) {
                    e = e2;
                    fragmentC2277g = fragmentC2277g2;
                    String str = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
                    return fragmentC2277g;
                }
            } else {
                fragmentC2277g = fragmentC2277g2;
            }
        } catch (ClassCastException e3) {
            e = e3;
            fragmentC2277g = null;
        }
        try {
            f6970b.put(activity, new WeakReference<>(fragmentC2277g));
            return fragmentC2277g;
        } catch (ClassCastException e4) {
            e = e4;
            String str2 = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
            return fragmentC2277g;
        }
    }

    /* renamed from: a */
    private static FragmentC2277g m6481a(FragmentManager fragmentManager) {
        FragmentC2277g fragmentC2277g;
        try {
            fragmentC2277g = new FragmentC2277g();
            try {
                fragmentManager.beginTransaction().add(fragmentC2277g, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                String str = "create fragment failed." + e.getMessage();
                return fragmentC2277g;
            }
        } catch (Exception e3) {
            e = e3;
            fragmentC2277g = null;
        }
        return fragmentC2277g;
    }

    /* renamed from: a */
    public static void m6482a(Activity activity, ExecuteResult executeResult) {
        FragmentC2277g m6480a = m6480a(activity);
        if (m6480a != null) {
            synchronized (m6480a.f6971a) {
                m6480a.f6971a.add(new WeakReference<>(executeResult));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.f6971a) {
            Iterator<WeakReference<ExecuteResult<?>>> it = this.f6971a.iterator();
            while (it.hasNext()) {
                ExecuteResult<?> executeResult = it.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f6971a.clear();
        }
    }
}
