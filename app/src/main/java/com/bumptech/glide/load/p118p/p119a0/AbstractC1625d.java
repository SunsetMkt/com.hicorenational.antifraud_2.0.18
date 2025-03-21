package com.bumptech.glide.load.p118p.p119a0;

import com.bumptech.glide.load.p118p.p119a0.InterfaceC1634m;
import com.bumptech.glide.util.C1878l;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* renamed from: com.bumptech.glide.load.p.a0.d */
/* loaded from: classes.dex */
abstract class AbstractC1625d<T extends InterfaceC1634m> {

    /* renamed from: b */
    private static final int f4281b = 20;

    /* renamed from: a */
    private final Queue<T> f4282a = C1878l.m5002a(20);

    AbstractC1625d() {
    }

    /* renamed from: a */
    abstract T mo3916a();

    /* renamed from: a */
    public void m3918a(T t) {
        if (this.f4282a.size() < 20) {
            this.f4282a.offer(t);
        }
    }

    /* renamed from: b */
    T m3919b() {
        T poll = this.f4282a.poll();
        return poll == null ? mo3916a() : poll;
    }
}
