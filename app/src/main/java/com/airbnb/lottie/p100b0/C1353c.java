package com.airbnb.lottie.p100b0;

import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.InterfaceC1382m;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LogcatLogger.java */
/* renamed from: com.airbnb.lottie.b0.c */
/* loaded from: classes.dex */
public class C1353c implements InterfaceC1382m {

    /* renamed from: a */
    private static final Set<String> f3132a = new HashSet();

    @Override // com.airbnb.lottie.InterfaceC1382m
    /* renamed from: a */
    public void mo2783a(String str) {
        mo2787c(str, null);
    }

    @Override // com.airbnb.lottie.InterfaceC1382m
    /* renamed from: b */
    public void mo2785b(String str) {
        mo2786b(str, null);
    }

    @Override // com.airbnb.lottie.InterfaceC1382m
    /* renamed from: c */
    public void mo2787c(String str, Throwable th) {
        boolean z = C1374e.f3188a;
    }

    @Override // com.airbnb.lottie.InterfaceC1382m
    /* renamed from: a */
    public void mo2784a(String str, Throwable th) {
        boolean z = C1374e.f3188a;
    }

    @Override // com.airbnb.lottie.InterfaceC1382m
    /* renamed from: b */
    public void mo2786b(String str, Throwable th) {
        if (f3132a.contains(str)) {
            return;
        }
        f3132a.add(str);
    }
}
