package com.airbnb.lottie.p106y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.C1376g;

/* compiled from: LottieCompositionCache.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.airbnb.lottie.y.g */
/* loaded from: classes.dex */
public class C1441g {

    /* renamed from: b */
    private static final C1441g f3606b = new C1441g();

    /* renamed from: a */
    private final LruCache<String, C1376g> f3607a = new LruCache<>(20);

    @VisibleForTesting
    C1441g() {
    }

    /* renamed from: b */
    public static C1441g m3212b() {
        return f3606b;
    }

    @Nullable
    /* renamed from: a */
    public C1376g m3213a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f3607a.get(str);
    }

    /* renamed from: a */
    public void m3216a(@Nullable String str, C1376g c1376g) {
        if (str == null) {
            return;
        }
        this.f3607a.put(str, c1376g);
    }

    /* renamed from: a */
    public void m3214a() {
        this.f3607a.evictAll();
    }

    /* renamed from: a */
    public void m3215a(int i2) {
        this.f3607a.resize(i2);
    }
}
