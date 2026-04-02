package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TextDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class v {
    private final Map<String, String> a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private final LottieAnimationView f2242b;

    /* JADX INFO: renamed from: c */
    @Nullable
    private final j f2243c;

    /* JADX INFO: renamed from: d */
    private boolean f2244d;

    @VisibleForTesting
    v() {
        this.a = new HashMap();
        this.f2244d = true;
        this.f2242b = null;
        this.f2243c = null;
    }

    public String a(String str) {
        return str;
    }

    public void a(String str, String str2) {
        this.a.put(str, str2);
        b();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String b(String str) {
        if (this.f2244d && this.a.containsKey(str)) {
            return this.a.get(str);
        }
        String strA = a(str);
        if (this.f2244d) {
            this.a.put(str, strA);
        }
        return strA;
    }

    public void c(String str) {
        this.a.remove(str);
        b();
    }

    public void a(boolean z) {
        this.f2244d = z;
    }

    public void a() {
        this.a.clear();
        b();
    }

    public v(LottieAnimationView lottieAnimationView) {
        this.a = new HashMap();
        this.f2244d = true;
        this.f2242b = lottieAnimationView;
        this.f2243c = null;
    }

    private void b() {
        LottieAnimationView lottieAnimationView = this.f2242b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        j jVar = this.f2243c;
        if (jVar != null) {
            jVar.invalidateSelf();
        }
    }

    public v(j jVar) {
        this.a = new HashMap();
        this.f2244d = true;
        this.f2243c = jVar;
        this.f2242b = null;
    }
}
