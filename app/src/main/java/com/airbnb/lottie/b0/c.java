package com.airbnb.lottie.b0;

import com.airbnb.lottie.m;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: LogcatLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements m {
    private static final Set<String> a = new HashSet();

    @Override // com.airbnb.lottie.m
    public void a(String str) {
        c(str, null);
    }

    @Override // com.airbnb.lottie.m
    public void b(String str) {
        b(str, null);
    }

    @Override // com.airbnb.lottie.m
    public void c(String str, Throwable th) {
        boolean z = com.airbnb.lottie.e.a;
    }

    @Override // com.airbnb.lottie.m
    public void a(String str, Throwable th) {
        boolean z = com.airbnb.lottie.e.a;
    }

    @Override // com.airbnb.lottie.m
    public void b(String str, Throwable th) {
        if (a.contains(str)) {
            return;
        }
        a.add(str);
    }
}
