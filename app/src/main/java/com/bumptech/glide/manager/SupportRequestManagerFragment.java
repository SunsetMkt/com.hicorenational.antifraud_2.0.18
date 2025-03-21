package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.ComponentCallbacks2C1585k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: g */
    private static final String f5062g = "SupportRMFragment";

    /* renamed from: a */
    private final C1787a f5063a;

    /* renamed from: b */
    private final InterfaceC1798l f5064b;

    /* renamed from: c */
    private final Set<SupportRequestManagerFragment> f5065c;

    /* renamed from: d */
    @Nullable
    private SupportRequestManagerFragment f5066d;

    /* renamed from: e */
    @Nullable
    private ComponentCallbacks2C1585k f5067e;

    /* renamed from: f */
    @Nullable
    private Fragment f5068f;

    /* renamed from: com.bumptech.glide.manager.SupportRequestManagerFragment$a */
    private class C1786a implements InterfaceC1798l {
        C1786a() {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1798l
        @NonNull
        /* renamed from: a */
        public Set<ComponentCallbacks2C1585k> mo4509a() {
            Set<SupportRequestManagerFragment> m4519d = SupportRequestManagerFragment.this.m4519d();
            HashSet hashSet = new HashSet(m4519d.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : m4519d) {
                if (supportRequestManagerFragment.m4521f() != null) {
                    hashSet.add(supportRequestManagerFragment.m4521f());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new C1787a());
    }

    /* renamed from: b */
    private void m4513b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f5065c.remove(supportRequestManagerFragment);
    }

    /* renamed from: c */
    private boolean m4514c(@NonNull Fragment fragment) {
        Fragment m4515h = m4515h();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(m4515h)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @Nullable
    /* renamed from: h */
    private Fragment m4515h() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f5068f;
    }

    /* renamed from: i */
    private void m4516i() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f5066d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.m4513b(this);
            this.f5066d = null;
        }
    }

    /* renamed from: a */
    public void m4518a(@Nullable ComponentCallbacks2C1585k componentCallbacks2C1585k) {
        this.f5067e = componentCallbacks2C1585k;
    }

    @NonNull
    /* renamed from: d */
    Set<SupportRequestManagerFragment> m4519d() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f5066d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f5065c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f5066d.m4519d()) {
            if (m4514c(supportRequestManagerFragment2.m4515h())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    /* renamed from: e */
    C1787a m4520e() {
        return this.f5063a;
    }

    @Nullable
    /* renamed from: f */
    public ComponentCallbacks2C1585k m4521f() {
        return this.f5067e;
    }

    @NonNull
    /* renamed from: g */
    public InterfaceC1798l m4522g() {
        return this.f5064b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager m4512b = m4512b((Fragment) this);
        if (m4512b == null) {
            Log.isLoggable(f5062g, 5);
            return;
        }
        try {
            m4510a(getContext(), m4512b);
        } catch (IllegalStateException unused) {
            Log.isLoggable(f5062g, 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f5063a.m4523a();
        m4516i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5068f = null;
        m4516i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f5063a.m4525b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f5063a.m4527c();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m4515h() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull C1787a c1787a) {
        this.f5064b = new C1786a();
        this.f5065c = new HashSet();
        this.f5063a = c1787a;
    }

    /* renamed from: a */
    private void m4511a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f5065c.add(supportRequestManagerFragment);
    }

    @Nullable
    /* renamed from: b */
    private static FragmentManager m4512b(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    /* renamed from: a */
    void m4517a(@Nullable Fragment fragment) {
        FragmentManager m4512b;
        this.f5068f = fragment;
        if (fragment == null || fragment.getContext() == null || (m4512b = m4512b(fragment)) == null) {
            return;
        }
        m4510a(fragment.getContext(), m4512b);
    }

    /* renamed from: a */
    private void m4510a(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        m4516i();
        this.f5066d = ComponentCallbacks2C1576b.m3633a(context).m3665i().m4551a(context, fragmentManager);
        if (equals(this.f5066d)) {
            return;
        }
        this.f5066d.m4511a(this);
    }
}
