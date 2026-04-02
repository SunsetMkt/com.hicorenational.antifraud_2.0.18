package com.bumptech.glide.load.p.a0;

import com.bumptech.glide.load.p.a0.m;
import java.util.Queue;

/* JADX INFO: compiled from: BaseKeyPool.java */
/* JADX INFO: loaded from: classes.dex */
abstract class d<T extends m> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f2780b = 20;
    private final Queue<T> a = com.bumptech.glide.util.l.a(20);

    d() {
    }

    abstract T a();

    public void a(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }

    T b() {
        T tPoll = this.a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }
}
