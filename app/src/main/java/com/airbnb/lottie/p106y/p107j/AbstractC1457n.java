package com.airbnb.lottie.p106y.p107j;

import com.airbnb.lottie.p101c0.C1361a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* renamed from: com.airbnb.lottie.y.j.n */
/* loaded from: classes.dex */
abstract class AbstractC1457n<V, O> implements InterfaceC1456m<V, O> {

    /* renamed from: a */
    final List<C1361a<V>> f3630a;

    AbstractC1457n(V v) {
        this(Collections.singletonList(new C1361a(v)));
    }

    @Override // com.airbnb.lottie.p106y.p107j.InterfaceC1456m
    /* renamed from: b */
    public List<C1361a<V>> mo3221b() {
        return this.f3630a;
    }

    @Override // com.airbnb.lottie.p106y.p107j.InterfaceC1456m
    /* renamed from: c */
    public boolean mo3222c() {
        return this.f3630a.isEmpty() || (this.f3630a.size() == 1 && this.f3630a.get(0).m2856g());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f3630a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f3630a.toArray()));
        }
        return sb.toString();
    }

    AbstractC1457n(List<C1361a<V>> list) {
        this.f3630a = list;
    }
}
