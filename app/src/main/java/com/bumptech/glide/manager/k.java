package com.bumptech.glide.manager;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: RequestManagerRetriever.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements Handler.Callback {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final String f3327i = "com.bumptech.glide.manager";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f3328j = "RMRetriever";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f3329k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f3330l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f3331m = "key";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final b f3332n = new a();
    private volatile com.bumptech.glide.k a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f3335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f3336e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final Map<FragmentManager, RequestManagerFragment> f3333b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f3334c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayMap<View, Fragment> f3337f = new ArrayMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f3338g = new ArrayMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Bundle f3339h = new Bundle();

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.manager.k.b
        @NonNull
        public com.bumptech.glide.k a(@NonNull com.bumptech.glide.b bVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
            return new com.bumptech.glide.k(bVar, hVar, lVar, context);
        }
    }

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    public interface b {
        @NonNull
        com.bumptech.glide.k a(@NonNull com.bumptech.glide.b bVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context);
    }

    public k(@Nullable b bVar) {
        this.f3336e = bVar == null ? f3332n : bVar;
        this.f3335d = new Handler(Looper.getMainLooper(), this);
    }

    @Deprecated
    private void b(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.f3339h.putInt(f3331m, i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f3339h, f3331m);
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    a(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            i2 = i3;
        }
    }

    @NonNull
    private com.bumptech.glide.k c(@NonNull Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = this.f3336e.a(com.bumptech.glide.b.a(context.getApplicationContext()), new com.bumptech.glide.manager.b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.a;
    }

    private static boolean d(Context context) {
        Activity activityB = b(context);
        return activityB == null || !activityB.isFinishing();
    }

    @NonNull
    public com.bumptech.glide.k a(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.util.l.d() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return a(contextWrapper.getBaseContext());
                }
            }
        }
        return c(context);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks componentCallbacksRemove;
        int i2 = message.what;
        Object obj = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            componentCallbacksRemove = this.f3333b.remove(obj);
        } else if (i2 != 2) {
            z = false;
            componentCallbacksRemove = null;
        } else {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            componentCallbacksRemove = this.f3334c.remove(obj);
        }
        if (z && componentCallbacksRemove == null && Log.isLoggable(f3328j, 5)) {
            String str = "Failed to remove expected request manager fragment, manager: " + obj;
        }
        return z;
    }

    @Nullable
    private static Activity b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(17)
    private static void c(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @NonNull
    public com.bumptech.glide.k a(@NonNull FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.util.l.c()) {
            return a(fragmentActivity.getApplicationContext());
        }
        c((Activity) fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    @NonNull
    @Deprecated
    RequestManagerFragment b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    @NonNull
    public com.bumptech.glide.k a(@NonNull Fragment fragment) {
        com.bumptech.glide.util.j.a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.util.l.c()) {
            return a(fragment.getContext().getApplicationContext());
        }
        return a(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public com.bumptech.glide.k a(@NonNull Activity activity) {
        if (com.bumptech.glide.util.l.c()) {
            return a(activity.getApplicationContext());
        }
        c(activity);
        return a(activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    @NonNull
    public com.bumptech.glide.k a(@NonNull View view) {
        if (com.bumptech.glide.util.l.c()) {
            return a(view.getContext().getApplicationContext());
        }
        com.bumptech.glide.util.j.a(view);
        com.bumptech.glide.util.j.a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityB = b(view.getContext());
        if (activityB == null) {
            return a(view.getContext().getApplicationContext());
        }
        if (activityB instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activityB;
            Fragment fragmentA = a(view, fragmentActivity);
            return fragmentA != null ? a(fragmentA) : a(fragmentActivity);
        }
        android.app.Fragment fragmentA2 = a(view, activityB);
        if (fragmentA2 == null) {
            return a(activityB);
        }
        return a(fragmentA2);
    }

    private static void a(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    private Fragment a(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f3337f.clear();
        a(fragmentActivity.getSupportFragmentManager().getFragments(), this.f3337f);
        View viewFindViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f3337f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f3337f.clear();
        return fragment;
    }

    @Nullable
    @Deprecated
    private android.app.Fragment a(@NonNull View view, @NonNull Activity activity) {
        this.f3338g.clear();
        a(activity.getFragmentManager(), this.f3338g);
        View viewFindViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f3338g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f3338g.clear();
        return fragment;
    }

    @TargetApi(26)
    @Deprecated
    private void a(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    a(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        b(fragmentManager, arrayMap);
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.k a(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!com.bumptech.glide.util.l.c() && Build.VERSION.SDK_INT >= 17) {
                return a(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return a(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    private RequestManagerFragment a(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(f3327i);
        if (requestManagerFragment == null && (requestManagerFragment = this.f3333b.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.a(fragment);
            if (z) {
                requestManagerFragment.b().b();
            }
            this.f3333b.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, f3327i).commitAllowingStateLoss();
            this.f3335d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    @Deprecated
    private com.bumptech.glide.k a(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragmentA = a(fragmentManager, fragment, z);
        com.bumptech.glide.k kVarC = requestManagerFragmentA.c();
        if (kVarC != null) {
            return kVarC;
        }
        com.bumptech.glide.k kVarA = this.f3336e.a(com.bumptech.glide.b.a(context), requestManagerFragmentA.b(), requestManagerFragmentA.d(), context);
        requestManagerFragmentA.a(kVarA);
        return kVarA;
    }

    @NonNull
    SupportRequestManagerFragment a(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return a(fragmentManager, (Fragment) null, d(context));
    }

    @NonNull
    private SupportRequestManagerFragment a(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(f3327i);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f3334c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.a(fragment);
            if (z) {
                supportRequestManagerFragment.e().b();
            }
            this.f3334c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, f3327i).commitAllowingStateLoss();
            this.f3335d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    @NonNull
    private com.bumptech.glide.k a(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragmentA = a(fragmentManager, fragment, z);
        com.bumptech.glide.k kVarF = supportRequestManagerFragmentA.f();
        if (kVarF != null) {
            return kVarF;
        }
        com.bumptech.glide.k kVarA = this.f3336e.a(com.bumptech.glide.b.a(context), supportRequestManagerFragmentA.e(), supportRequestManagerFragmentA.g(), context);
        supportRequestManagerFragmentA.a(kVarA);
        return kVarA;
    }
}
