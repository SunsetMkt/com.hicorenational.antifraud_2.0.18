package com.bumptech.glide.load.p118p.p122d0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: PreFillQueue.java */
/* renamed from: com.bumptech.glide.load.p.d0.c */
/* loaded from: classes.dex */
final class C1658c {

    /* renamed from: a */
    private final Map<C1659d, Integer> f4452a;

    /* renamed from: b */
    private final List<C1659d> f4453b;

    /* renamed from: c */
    private int f4454c;

    /* renamed from: d */
    private int f4455d;

    public C1658c(Map<C1659d, Integer> map) {
        this.f4452a = map;
        this.f4453b = new ArrayList(map.keySet());
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            this.f4454c += it.next().intValue();
        }
    }

    /* renamed from: a */
    public int m4058a() {
        return this.f4454c;
    }

    /* renamed from: b */
    public boolean m4059b() {
        return this.f4454c == 0;
    }

    /* renamed from: c */
    public C1659d m4060c() {
        C1659d c1659d = this.f4453b.get(this.f4455d);
        Integer num = this.f4452a.get(c1659d);
        if (num.intValue() == 1) {
            this.f4452a.remove(c1659d);
            this.f4453b.remove(this.f4455d);
        } else {
            this.f4452a.put(c1659d, Integer.valueOf(num.intValue() - 1));
        }
        this.f4454c--;
        this.f4455d = this.f4453b.isEmpty() ? 0 : (this.f4455d + 1) % this.f4453b.size();
        return c1659d;
    }
}
