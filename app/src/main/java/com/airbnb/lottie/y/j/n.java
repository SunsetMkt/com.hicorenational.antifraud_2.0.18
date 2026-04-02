package com.airbnb.lottie.y.j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: BaseAnimatableValue.java */
/* JADX INFO: loaded from: classes.dex */
abstract class n<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.c0.a<V>> a;

    n(V v) {
        this(Collections.singletonList(new com.airbnb.lottie.c0.a(v)));
    }

    @Override // com.airbnb.lottie.y.j.m
    public List<com.airbnb.lottie.c0.a<V>> b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.y.j.m
    public boolean c() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).g());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    n(List<com.airbnb.lottie.c0.a<V>> list) {
        this.a = list;
    }
}
