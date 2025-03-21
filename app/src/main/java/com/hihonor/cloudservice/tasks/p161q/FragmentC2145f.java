package com.hihonor.cloudservice.tasks.p161q;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import p031c.p075c.p076a.p090d.InterfaceC1207d;

/* compiled from: ExecutorFragment.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.f */
/* loaded from: classes.dex */
public final class FragmentC2145f extends Fragment {

    /* renamed from: b */
    private static final WeakHashMap<Activity, WeakReference<FragmentC2145f>> f6455b = new WeakHashMap<>();

    /* renamed from: a */
    private final List<WeakReference<InterfaceC1207d<?>>> f6456a = new ArrayList();

    /* renamed from: a */
    public static void m6073a(Activity activity, InterfaceC1207d interfaceC1207d) {
        FragmentC2145f m6071a = m6071a(activity);
        if (m6071a != null) {
            synchronized (m6071a.f6456a) {
                m6071a.f6456a.add(new WeakReference<>(interfaceC1207d));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.f6456a) {
            Iterator<WeakReference<InterfaceC1207d<?>>> it = this.f6456a.iterator();
            while (it.hasNext()) {
                InterfaceC1207d<?> interfaceC1207d = it.next().get();
                if (interfaceC1207d != null) {
                    interfaceC1207d.cancel();
                }
            }
            this.f6456a.clear();
        }
    }

    /* renamed from: a */
    private static FragmentC2145f m6071a(Activity activity) {
        FragmentC2145f fragmentC2145f;
        WeakReference<FragmentC2145f> weakReference = f6455b.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            FragmentC2145f fragmentC2145f2 = (FragmentC2145f) fragmentManager.findFragmentByTag("com.hihonor.hmf.tasks.lifecycle_fragment_tag");
            if (fragmentC2145f2 == null) {
                try {
                    fragmentC2145f = m6072a(fragmentManager);
                } catch (ClassCastException e2) {
                    e = e2;
                    fragmentC2145f = fragmentC2145f2;
                    String str = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
                    return fragmentC2145f;
                }
            } else {
                fragmentC2145f = fragmentC2145f2;
            }
        } catch (ClassCastException e3) {
            e = e3;
            fragmentC2145f = null;
        }
        try {
            f6455b.put(activity, new WeakReference<>(fragmentC2145f));
            return fragmentC2145f;
        } catch (ClassCastException e4) {
            e = e4;
            String str2 = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
            return fragmentC2145f;
        }
    }

    /* renamed from: a */
    private static FragmentC2145f m6072a(FragmentManager fragmentManager) {
        FragmentC2145f fragmentC2145f;
        try {
            fragmentC2145f = new FragmentC2145f();
            try {
                fragmentManager.beginTransaction().add(fragmentC2145f, "com.hihonor.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                String str = "create fragment failed." + e.getMessage();
                return fragmentC2145f;
            }
        } catch (Exception e3) {
            e = e3;
            fragmentC2145f = null;
        }
        return fragmentC2145f;
    }
}
