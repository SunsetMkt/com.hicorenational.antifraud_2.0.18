package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.ComponentCallbacks2C1585k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: g */
    private static final String f5054g = "RMFragment";

    /* renamed from: a */
    private final C1787a f5055a;

    /* renamed from: b */
    private final InterfaceC1798l f5056b;

    /* renamed from: c */
    private final Set<RequestManagerFragment> f5057c;

    /* renamed from: d */
    @Nullable
    private ComponentCallbacks2C1585k f5058d;

    /* renamed from: e */
    @Nullable
    private RequestManagerFragment f5059e;

    /* renamed from: f */
    @Nullable
    private Fragment f5060f;

    /* renamed from: com.bumptech.glide.manager.RequestManagerFragment$a */
    private class C1785a implements InterfaceC1798l {
        C1785a() {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1798l
        @NonNull
        /* renamed from: a */
        public Set<ComponentCallbacks2C1585k> mo4509a() {
            Set<RequestManagerFragment> m4503a = RequestManagerFragment.this.m4503a();
            HashSet hashSet = new HashSet(m4503a.size());
            for (RequestManagerFragment requestManagerFragment : m4503a) {
                if (requestManagerFragment.m4507c() != null) {
                    hashSet.add(requestManagerFragment.m4507c());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new C1787a());
    }

    @Nullable
    @TargetApi(17)
    /* renamed from: e */
    private Fragment m4501e() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f5060f;
    }

    /* renamed from: f */
    private void m4502f() {
        RequestManagerFragment requestManagerFragment = this.f5059e;
        if (requestManagerFragment != null) {
            requestManagerFragment.m4499b(this);
            this.f5059e = null;
        }
    }

    /* renamed from: a */
    public void m4505a(@Nullable ComponentCallbacks2C1585k componentCallbacks2C1585k) {
        this.f5058d = componentCallbacks2C1585k;
    }

    @NonNull
    /* renamed from: b */
    C1787a m4506b() {
        return this.f5055a;
    }

    @Nullable
    /* renamed from: c */
    public ComponentCallbacks2C1585k m4507c() {
        return this.f5058d;
    }

    @NonNull
    /* renamed from: d */
    public InterfaceC1798l m4508d() {
        return this.f5056b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m4497a(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable(f5054g, 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f5055a.m4523a();
        m4502f();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        m4502f();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f5055a.m4525b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f5055a.m4527c();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m4501e() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    RequestManagerFragment(@NonNull C1787a c1787a) {
        this.f5056b = new C1785a();
        this.f5057c = new HashSet();
        this.f5055a = c1787a;
    }

    /* renamed from: a */
    private void m4498a(RequestManagerFragment requestManagerFragment) {
        this.f5057c.add(requestManagerFragment);
    }

    /* renamed from: b */
    private void m4499b(RequestManagerFragment requestManagerFragment) {
        this.f5057c.remove(requestManagerFragment);
    }

    @TargetApi(17)
    /* renamed from: b */
    private boolean m4500b(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @NonNull
    @TargetApi(17)
    /* renamed from: a */
    Set<RequestManagerFragment> m4503a() {
        if (equals(this.f5059e)) {
            return Collections.unmodifiableSet(this.f5057c);
        }
        if (this.f5059e != null && Build.VERSION.SDK_INT >= 17) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.f5059e.m4503a()) {
                if (m4500b(requestManagerFragment.getParentFragment())) {
                    hashSet.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    /* renamed from: a */
    void m4504a(@Nullable Fragment fragment) {
        this.f5060f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        m4497a(fragment.getActivity());
    }

    /* renamed from: a */
    private void m4497a(@NonNull Activity activity) {
        m4502f();
        this.f5059e = ComponentCallbacks2C1576b.m3633a((Context) activity).m3665i().m4552b(activity);
        if (equals(this.f5059e)) {
            return;
        }
        this.f5059e.m4498a(this);
    }
}
