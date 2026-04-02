package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class g extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<g>> f4374b = new WeakHashMap<>();
    private final List<WeakReference<ExecuteResult<?>>> a = new ArrayList();

    private static g a(Activity activity) {
        g gVarA;
        WeakReference<g> weakReference = f4374b.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            g gVar = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar == null) {
                try {
                    gVarA = a(fragmentManager);
                } catch (ClassCastException e2) {
                    e = e2;
                    gVarA = gVar;
                    String str = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
                    return gVarA;
                }
            } else {
                gVarA = gVar;
            }
        } catch (ClassCastException e3) {
            e = e3;
            gVarA = null;
        }
        try {
            f4374b.put(activity, new WeakReference<>(gVarA));
            return gVarA;
        } catch (ClassCastException e4) {
            e = e4;
            String str2 = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
            return gVarA;
        }
    }

    private static g a(FragmentManager fragmentManager) {
        g gVar;
        try {
            gVar = new g();
            try {
                fragmentManager.beginTransaction().add(gVar, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                String str = "create fragment failed." + e.getMessage();
            }
        } catch (Exception e3) {
            e = e3;
            gVar = null;
        }
        return gVar;
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        g gVarA = a(activity);
        if (gVarA != null) {
            synchronized (gVarA.a) {
                gVarA.a.add(new WeakReference<>(executeResult));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.a) {
            Iterator<WeakReference<ExecuteResult<?>>> it = this.a.iterator();
            while (it.hasNext()) {
                ExecuteResult<?> executeResult = it.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.a.clear();
        }
    }
}
