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
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.ComponentCallbacks2C1585k;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever.java */
/* renamed from: com.bumptech.glide.manager.k */
/* loaded from: classes.dex */
public class C1797k implements Handler.Callback {

    /* renamed from: i */
    @VisibleForTesting
    static final String f5082i = "com.bumptech.glide.manager";

    /* renamed from: j */
    private static final String f5083j = "RMRetriever";

    /* renamed from: k */
    private static final int f5084k = 1;

    /* renamed from: l */
    private static final int f5085l = 2;

    /* renamed from: m */
    private static final String f5086m = "key";

    /* renamed from: n */
    private static final b f5087n = new a();

    /* renamed from: a */
    private volatile ComponentCallbacks2C1585k f5088a;

    /* renamed from: d */
    private final Handler f5091d;

    /* renamed from: e */
    private final b f5092e;

    /* renamed from: b */
    @VisibleForTesting
    final Map<FragmentManager, RequestManagerFragment> f5089b = new HashMap();

    /* renamed from: c */
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f5090c = new HashMap();

    /* renamed from: f */
    private final ArrayMap<View, Fragment> f5093f = new ArrayMap<>();

    /* renamed from: g */
    private final ArrayMap<View, android.app.Fragment> f5094g = new ArrayMap<>();

    /* renamed from: h */
    private final Bundle f5095h = new Bundle();

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: com.bumptech.glide.manager.k$a */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.manager.C1797k.b
        @NonNull
        /* renamed from: a */
        public ComponentCallbacks2C1585k mo4553a(@NonNull ComponentCallbacks2C1576b componentCallbacks2C1576b, @NonNull InterfaceC1794h interfaceC1794h, @NonNull InterfaceC1798l interfaceC1798l, @NonNull Context context) {
            return new ComponentCallbacks2C1585k(componentCallbacks2C1576b, interfaceC1794h, interfaceC1798l, context);
        }
    }

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: com.bumptech.glide.manager.k$b */
    public interface b {
        @NonNull
        /* renamed from: a */
        ComponentCallbacks2C1585k mo4553a(@NonNull ComponentCallbacks2C1576b componentCallbacks2C1576b, @NonNull InterfaceC1794h interfaceC1794h, @NonNull InterfaceC1798l interfaceC1798l, @NonNull Context context);
    }

    public C1797k(@Nullable b bVar) {
        this.f5092e = bVar == null ? f5087n : bVar;
        this.f5091d = new Handler(Looper.getMainLooper(), this);
    }

    @Deprecated
    /* renamed from: b */
    private void m4541b(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.f5095h.putInt(f5086m, i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f5095h, f5086m);
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    m4538a(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            i2 = i3;
        }
    }

    @NonNull
    /* renamed from: c */
    private ComponentCallbacks2C1585k m4542c(@NonNull Context context) {
        if (this.f5088a == null) {
            synchronized (this) {
                if (this.f5088a == null) {
                    this.f5088a = this.f5092e.mo4553a(ComponentCallbacks2C1576b.m3633a(context.getApplicationContext()), new C1788b(), new C1793g(), context.getApplicationContext());
                }
            }
        }
        return this.f5088a;
    }

    /* renamed from: d */
    private static boolean m4544d(Context context) {
        Activity m4540b = m4540b(context);
        return m4540b == null || !m4540b.isFinishing();
    }

    @NonNull
    /* renamed from: a */
    public ComponentCallbacks2C1585k m4547a(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (C1878l.m5012d() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return m4550a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return m4545a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return m4547a(contextWrapper.getBaseContext());
                }
            }
        }
        return m4542c(context);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks remove;
        int i2 = message.what;
        Object obj = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f5089b.remove(obj);
        } else if (i2 != 2) {
            z = false;
            remove = null;
        } else {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f5090c.remove(obj);
        }
        if (z && remove == null && Log.isLoggable(f5083j, 5)) {
            String str = "Failed to remove expected request manager fragment, manager: " + obj;
        }
        return z;
    }

    @Nullable
    /* renamed from: b */
    private static Activity m4540b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m4540b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(17)
    /* renamed from: c */
    private static void m4543c(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @NonNull
    /* renamed from: a */
    public ComponentCallbacks2C1585k m4550a(@NonNull FragmentActivity fragmentActivity) {
        if (C1878l.m5010c()) {
            return m4547a(fragmentActivity.getApplicationContext());
        }
        m4543c((Activity) fragmentActivity);
        return m4535a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, m4544d(fragmentActivity));
    }

    @NonNull
    @Deprecated
    /* renamed from: b */
    RequestManagerFragment m4552b(Activity activity) {
        return m4536a(activity.getFragmentManager(), (android.app.Fragment) null, m4544d(activity));
    }

    @NonNull
    /* renamed from: a */
    public ComponentCallbacks2C1585k m4549a(@NonNull Fragment fragment) {
        C1876j.m4986a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (C1878l.m5010c()) {
            return m4547a(fragment.getContext().getApplicationContext());
        }
        return m4535a(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    /* renamed from: a */
    public ComponentCallbacks2C1585k m4545a(@NonNull Activity activity) {
        if (C1878l.m5010c()) {
            return m4547a(activity.getApplicationContext());
        }
        m4543c(activity);
        return m4534a(activity, activity.getFragmentManager(), (android.app.Fragment) null, m4544d(activity));
    }

    @NonNull
    /* renamed from: a */
    public ComponentCallbacks2C1585k m4548a(@NonNull View view) {
        if (C1878l.m5010c()) {
            return m4547a(view.getContext().getApplicationContext());
        }
        C1876j.m4985a(view);
        C1876j.m4986a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity m4540b = m4540b(view.getContext());
        if (m4540b == null) {
            return m4547a(view.getContext().getApplicationContext());
        }
        if (m4540b instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) m4540b;
            Fragment m4533a = m4533a(view, fragmentActivity);
            return m4533a != null ? m4549a(m4533a) : m4550a(fragmentActivity);
        }
        android.app.Fragment m4532a = m4532a(view, m4540b);
        if (m4532a == null) {
            return m4545a(m4540b);
        }
        return m4546a(m4532a);
    }

    /* renamed from: a */
    private static void m4539a(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                m4539a(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    /* renamed from: a */
    private Fragment m4533a(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f5093f.clear();
        m4539a(fragmentActivity.getSupportFragmentManager().getFragments(), this.f5093f);
        View findViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f5093f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f5093f.clear();
        return fragment;
    }

    @Nullable
    @Deprecated
    /* renamed from: a */
    private android.app.Fragment m4532a(@NonNull View view, @NonNull Activity activity) {
        this.f5094g.clear();
        m4538a(activity.getFragmentManager(), this.f5094g);
        View findViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f5094g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f5094g.clear();
        return fragment;
    }

    @TargetApi(26)
    @Deprecated
    /* renamed from: a */
    private void m4538a(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    m4538a(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        m4541b(fragmentManager, arrayMap);
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    /* renamed from: a */
    public ComponentCallbacks2C1585k m4546a(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!C1878l.m5010c() && Build.VERSION.SDK_INT >= 17) {
                return m4534a(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return m4547a(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    /* renamed from: a */
    private RequestManagerFragment m4536a(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(f5082i);
        if (requestManagerFragment == null && (requestManagerFragment = this.f5089b.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.m4504a(fragment);
            if (z) {
                requestManagerFragment.m4506b().m4525b();
            }
            this.f5089b.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, f5082i).commitAllowingStateLoss();
            this.f5091d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    @Deprecated
    /* renamed from: a */
    private ComponentCallbacks2C1585k m4534a(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment m4536a = m4536a(fragmentManager, fragment, z);
        ComponentCallbacks2C1585k m4507c = m4536a.m4507c();
        if (m4507c != null) {
            return m4507c;
        }
        ComponentCallbacks2C1585k mo4553a = this.f5092e.mo4553a(ComponentCallbacks2C1576b.m3633a(context), m4536a.m4506b(), m4536a.m4508d(), context);
        m4536a.m4505a(mo4553a);
        return mo4553a;
    }

    @NonNull
    /* renamed from: a */
    SupportRequestManagerFragment m4551a(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return m4537a(fragmentManager, (Fragment) null, m4544d(context));
    }

    @NonNull
    /* renamed from: a */
    private SupportRequestManagerFragment m4537a(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(f5082i);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f5090c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.m4517a(fragment);
            if (z) {
                supportRequestManagerFragment.m4520e().m4525b();
            }
            this.f5090c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, f5082i).commitAllowingStateLoss();
            this.f5091d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    @NonNull
    /* renamed from: a */
    private ComponentCallbacks2C1585k m4535a(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment m4537a = m4537a(fragmentManager, fragment, z);
        ComponentCallbacks2C1585k m4521f = m4537a.m4521f();
        if (m4521f != null) {
            return m4521f;
        }
        ComponentCallbacks2C1585k mo4553a = this.f5092e.mo4553a(ComponentCallbacks2C1576b.m3633a(context), m4537a.m4520e(), m4537a.m4522g(), context);
        m4537a.m4518a(mo4553a);
        return mo4553a;
    }
}
