package com.bumptech.glide.load.p.d0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PreFillQueue.java */
/* JADX INFO: loaded from: classes.dex */
final class c {
    private final Map<d, Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f2911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2913d;

    public c(Map<d, Integer> map) {
        this.a = map;
        this.f2911b = new ArrayList(map.keySet());
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            this.f2912c += it.next().intValue();
        }
    }

    public int a() {
        return this.f2912c;
    }

    public boolean b() {
        return this.f2912c == 0;
    }

    public d c() {
        d dVar = this.f2911b.get(this.f2913d);
        Integer num = this.a.get(dVar);
        if (num.intValue() == 1) {
            this.a.remove(dVar);
            this.f2911b.remove(this.f2913d);
        } else {
            this.a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.f2912c--;
        this.f2913d = this.f2911b.isEmpty() ? 0 : (this.f2913d + 1) % this.f2911b.size();
        return dVar;
    }
}
