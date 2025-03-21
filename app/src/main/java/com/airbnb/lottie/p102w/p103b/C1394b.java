package com.airbnb.lottie.p102w.p103b;

import android.graphics.Path;
import com.airbnb.lottie.p100b0.C1358h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* renamed from: com.airbnb.lottie.w.b.b */
/* loaded from: classes.dex */
public class C1394b {

    /* renamed from: a */
    private List<C1412t> f3391a = new ArrayList();

    /* renamed from: a */
    void m3102a(C1412t c1412t) {
        this.f3391a.add(c1412t);
    }

    /* renamed from: a */
    public void m3101a(Path path) {
        for (int size = this.f3391a.size() - 1; size >= 0; size--) {
            C1358h.m2842a(path, this.f3391a.get(size));
        }
    }
}
