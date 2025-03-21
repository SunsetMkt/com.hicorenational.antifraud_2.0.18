package com.airbnb.lottie.p102w.p104c;

import android.graphics.Path;
import com.airbnb.lottie.p106y.p108k.C1465g;
import com.airbnb.lottie.p106y.p108k.C1470l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.g */
/* loaded from: classes.dex */
public class C1420g {

    /* renamed from: a */
    private final List<AbstractC1414a<C1470l, Path>> f3531a;

    /* renamed from: b */
    private final List<AbstractC1414a<Integer, Integer>> f3532b;

    /* renamed from: c */
    private final List<C1465g> f3533c;

    public C1420g(List<C1465g> list) {
        this.f3533c = list;
        this.f3531a = new ArrayList(list.size());
        this.f3532b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f3531a.add(list.get(i2).m3267b().mo3220a());
            this.f3532b.add(list.get(i2).m3268c().mo3220a());
        }
    }

    /* renamed from: a */
    public List<AbstractC1414a<C1470l, Path>> m3158a() {
        return this.f3531a;
    }

    /* renamed from: b */
    public List<C1465g> m3159b() {
        return this.f3533c;
    }

    /* renamed from: c */
    public List<AbstractC1414a<Integer, Integer>> m3160c() {
        return this.f3532b;
    }
}
