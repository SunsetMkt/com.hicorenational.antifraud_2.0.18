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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: g */
    private static final String f3307g = "RMFragment";
    private final com.bumptech.glide.manager.a a;

    /* JADX INFO: renamed from: b */
    private final l f3308b;

    /* JADX INFO: renamed from: c */
    private final Set<RequestManagerFragment> f3309c;

    /* JADX INFO: renamed from: d */
    @Nullable
    private com.bumptech.glide.k f3310d;

    /* JADX INFO: renamed from: e */
    @Nullable
    private RequestManagerFragment f3311e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private Fragment f3312f;

    private class a implements l {
        a() {
        }

        @Override // com.bumptech.glide.manager.l
        @NonNull
        public Set<com.bumptech.glide.k> a() {
            Set<RequestManagerFragment> setA = RequestManagerFragment.this.a();
            HashSet hashSet = new HashSet(setA.size());
            for (RequestManagerFragment requestManagerFragment : setA) {
                if (requestManagerFragment.c() != null) {
                    hashSet.add(requestManagerFragment.c());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    @Nullable
    @TargetApi(17)
    private Fragment e() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f3312f;
    }

    private void f() {
        RequestManagerFragment requestManagerFragment = this.f3311e;
        if (requestManagerFragment != null) {
            requestManagerFragment.b(this);
            this.f3311e = null;
        }
    }

    public void a(@Nullable com.bumptech.glide.k kVar) {
        this.f3310d = kVar;
    }

    @NonNull
    com.bumptech.glide.manager.a b() {
        return this.a;
    }

    @Nullable
    public com.bumptech.glide.k c() {
        return this.f3310d;
    }

    @NonNull
    public l d() {
        return this.f3308b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable(f3307g, 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.a();
        f();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        f();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.c();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    RequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f3308b = new a();
        this.f3309c = new HashSet();
        this.a = aVar;
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f3309c.add(requestManagerFragment);
    }

    private void b(RequestManagerFragment requestManagerFragment) {
        this.f3309c.remove(requestManagerFragment);
    }

    @TargetApi(17)
    private boolean b(@NonNull Fragment fragment) {
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
    Set<RequestManagerFragment> a() {
        if (equals(this.f3311e)) {
            return Collections.unmodifiableSet(this.f3309c);
        }
        if (this.f3311e != null && Build.VERSION.SDK_INT >= 17) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.f3311e.a()) {
                if (b(requestManagerFragment.getParentFragment())) {
                    hashSet.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    void a(@Nullable Fragment fragment) {
        this.f3312f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    private void a(@NonNull Activity activity) {
        f();
        this.f3311e = com.bumptech.glide.b.a((Context) activity).i().b(activity);
        if (equals(this.f3311e)) {
            return;
        }
        this.f3311e.a(this);
    }
}
