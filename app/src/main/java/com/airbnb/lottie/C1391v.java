package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TextDelegate.java */
/* renamed from: com.airbnb.lottie.v */
/* loaded from: classes.dex */
public class C1391v {

    /* renamed from: a */
    private final Map<String, String> f3371a;

    /* renamed from: b */
    @Nullable
    private final LottieAnimationView f3372b;

    /* renamed from: c */
    @Nullable
    private final C1379j f3373c;

    /* renamed from: d */
    private boolean f3374d;

    @VisibleForTesting
    C1391v() {
        this.f3371a = new HashMap();
        this.f3374d = true;
        this.f3372b = null;
        this.f3373c = null;
    }

    /* renamed from: a */
    public String m3085a(String str) {
        return str;
    }

    /* renamed from: a */
    public void m3087a(String str, String str2) {
        this.f3371a.put(str, str2);
        m3084b();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public final String m3089b(String str) {
        if (this.f3374d && this.f3371a.containsKey(str)) {
            return this.f3371a.get(str);
        }
        String m3085a = m3085a(str);
        if (this.f3374d) {
            this.f3371a.put(str, m3085a);
        }
        return m3085a;
    }

    /* renamed from: c */
    public void m3090c(String str) {
        this.f3371a.remove(str);
        m3084b();
    }

    /* renamed from: a */
    public void m3088a(boolean z) {
        this.f3374d = z;
    }

    /* renamed from: a */
    public void m3086a() {
        this.f3371a.clear();
        m3084b();
    }

    public C1391v(LottieAnimationView lottieAnimationView) {
        this.f3371a = new HashMap();
        this.f3374d = true;
        this.f3372b = lottieAnimationView;
        this.f3373c = null;
    }

    /* renamed from: b */
    private void m3084b() {
        LottieAnimationView lottieAnimationView = this.f3372b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        C1379j c1379j = this.f3373c;
        if (c1379j != null) {
            c1379j.invalidateSelf();
        }
    }

    public C1391v(C1379j c1379j) {
        this.f3371a = new HashMap();
        this.f3374d = true;
        this.f3373c = c1379j;
        this.f3372b = null;
    }
}
