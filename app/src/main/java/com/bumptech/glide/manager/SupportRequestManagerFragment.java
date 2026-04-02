package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: g */
    private static final String f3313g = "SupportRMFragment";
    private final com.bumptech.glide.manager.a a;

    /* JADX INFO: renamed from: b */
    private final l f3314b;

    /* JADX INFO: renamed from: c */
    private final Set<SupportRequestManagerFragment> f3315c;

    /* JADX INFO: renamed from: d */
    @Nullable
    private SupportRequestManagerFragment f3316d;

    /* JADX INFO: renamed from: e */
    @Nullable
    private com.bumptech.glide.k f3317e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private Fragment f3318f;

    private class a implements l {
        a() {
        }

        @Override // com.bumptech.glide.manager.l
        @NonNull
        public Set<com.bumptech.glide.k> a() {
            Set<SupportRequestManagerFragment> setD = SupportRequestManagerFragment.this.d();
            HashSet hashSet = new HashSet(setD.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : setD) {
                if (supportRequestManagerFragment.f() != null) {
                    hashSet.add(supportRequestManagerFragment.f());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f3315c.remove(supportRequestManagerFragment);
    }

    private boolean c(@NonNull Fragment fragment) {
        Fragment fragmentH = h();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(fragmentH)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @Nullable
    private Fragment h() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f3318f;
    }

    private void i() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f3316d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.b(this);
            this.f3316d = null;
        }
    }

    public void a(@Nullable com.bumptech.glide.k kVar) {
        this.f3317e = kVar;
    }

    @NonNull
    Set<SupportRequestManagerFragment> d() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f3316d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f3315c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f3316d.d()) {
            if (c(supportRequestManagerFragment2.h())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    com.bumptech.glide.manager.a e() {
        return this.a;
    }

    @Nullable
    public com.bumptech.glide.k f() {
        return this.f3317e;
    }

    @NonNull
    public l g() {
        return this.f3314b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager fragmentManagerB = b((Fragment) this);
        if (fragmentManagerB == null) {
            Log.isLoggable(f3313g, 5);
            return;
        }
        try {
            a(getContext(), fragmentManagerB);
        } catch (IllegalStateException unused) {
            Log.isLoggable(f3313g, 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.a();
        i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3318f = null;
        i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.c();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + h() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f3314b = new a();
        this.f3315c = new HashSet();
        this.a = aVar;
    }

    private void a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f3315c.add(supportRequestManagerFragment);
    }

    @Nullable
    private static FragmentManager b(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    void a(@Nullable Fragment fragment) {
        FragmentManager fragmentManagerB;
        this.f3318f = fragment;
        if (fragment == null || fragment.getContext() == null || (fragmentManagerB = b(fragment)) == null) {
            return;
        }
        a(fragment.getContext(), fragmentManagerB);
    }

    private void a(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        i();
        this.f3316d = com.bumptech.glide.b.a(context).i().a(context, fragmentManager);
        if (equals(this.f3316d)) {
            return;
        }
        this.f3316d.a(this);
    }
}
