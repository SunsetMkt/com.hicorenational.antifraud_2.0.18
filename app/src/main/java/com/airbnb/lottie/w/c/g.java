package com.airbnb.lottie.w.c;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MaskKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private final List<a<com.airbnb.lottie.y.k.l, Path>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a<Integer, Integer>> f2359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.airbnb.lottie.y.k.g> f2360c;

    public g(List<com.airbnb.lottie.y.k.g> list) {
        this.f2360c = list;
        this.a = new ArrayList(list.size());
        this.f2359b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.add(list.get(i2).b().a());
            this.f2359b.add(list.get(i2).c().a());
        }
    }

    public List<a<com.airbnb.lottie.y.k.l, Path>> a() {
        return this.a;
    }

    public List<com.airbnb.lottie.y.k.g> b() {
        return this.f2360c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f2359b;
    }
}
