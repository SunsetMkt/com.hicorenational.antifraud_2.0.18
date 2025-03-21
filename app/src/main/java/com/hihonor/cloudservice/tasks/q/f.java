package com.hihonor.cloudservice.tasks.q;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: ExecutorFragment.java */
/* loaded from: classes.dex */
public final class f extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<f>> f6065b = new WeakHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final List<WeakReference<c.c.a.d.d<?>>> f6066a = new ArrayList();

    public static void a(Activity activity, c.c.a.d.d dVar) {
        f a2 = a(activity);
        if (a2 != null) {
            synchronized (a2.f6066a) {
                a2.f6066a.add(new WeakReference<>(dVar));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.f6066a) {
            Iterator<WeakReference<c.c.a.d.d<?>>> it = this.f6066a.iterator();
            while (it.hasNext()) {
                c.c.a.d.d<?> dVar = it.next().get();
                if (dVar != null) {
                    dVar.cancel();
                }
            }
            this.f6066a.clear();
        }
    }

    private static f a(Activity activity) {
        f fVar;
        WeakReference<f> weakReference = f6065b.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            f fVar2 = (f) fragmentManager.findFragmentByTag("com.hihonor.hmf.tasks.lifecycle_fragment_tag");
            if (fVar2 == null) {
                try {
                    fVar = a(fragmentManager);
                } catch (ClassCastException e2) {
                    e = e2;
                    fVar = fVar2;
                    String str = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
                    return fVar;
                }
            } else {
                fVar = fVar2;
            }
        } catch (ClassCastException e3) {
            e = e3;
            fVar = null;
        }
        try {
            f6065b.put(activity, new WeakReference<>(fVar));
            return fVar;
        } catch (ClassCastException e4) {
            e = e4;
            String str2 = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
            return fVar;
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
                return fVar;
            }
        } catch (Exception e3) {
            e = e3;
            fVar = null;
        }
        return fVar;
    }
}
