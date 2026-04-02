package com.hihonor.cloudservice.tasks.q;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ExecutorFragment.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<f>> f4080b = new WeakHashMap<>();
    private final List<WeakReference<d.c.a.d.d<?>>> a = new ArrayList();

    public static void a(Activity activity, d.c.a.d.d dVar) {
        f fVarA = a(activity);
        if (fVarA != null) {
            synchronized (fVarA.a) {
                fVarA.a.add(new WeakReference<>(dVar));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.a) {
            Iterator<WeakReference<d.c.a.d.d<?>>> it = this.a.iterator();
            while (it.hasNext()) {
                d.c.a.d.d<?> dVar = it.next().get();
                if (dVar != null) {
                    dVar.cancel();
                }
            }
            this.a.clear();
        }
    }

    private static f a(Activity activity) {
        f fVarA;
        WeakReference<f> weakReference = f4080b.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            f fVar = (f) fragmentManager.findFragmentByTag("com.hihonor.hmf.tasks.lifecycle_fragment_tag");
            if (fVar == null) {
                try {
                    fVarA = a(fragmentManager);
                } catch (ClassCastException e2) {
                    e = e2;
                    fVarA = fVar;
                    String str = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
                    return fVarA;
                }
            } else {
                fVarA = fVar;
            }
        } catch (ClassCastException e3) {
            e = e3;
            fVarA = null;
        }
        try {
            f4080b.put(activity, new WeakReference<>(fVarA));
            return fVarA;
        } catch (ClassCastException e4) {
            e = e4;
            String str2 = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
            return fVarA;
        }
    }

    private static f a(FragmentManager fragmentManager) {
        f fVar;
        try {
            fVar = new f();
            try {
                fragmentManager.beginTransaction().add(fVar, "com.hihonor.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                String str = "create fragment failed." + e.getMessage();
            }
        } catch (Exception e3) {
            e = e3;
            fVar = null;
        }
        return fVar;
    }
}
