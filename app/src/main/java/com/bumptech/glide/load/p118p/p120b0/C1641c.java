package com.bumptech.glide.load.p118p.p120b0;

import com.bumptech.glide.util.C1876j;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* renamed from: com.bumptech.glide.load.p.b0.c */
/* loaded from: classes.dex */
final class C1641c {

    /* renamed from: a */
    private final Map<String, a> f4337a = new HashMap();

    /* renamed from: b */
    private final b f4338b = new b();

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.p.b0.c$a */
    private static class a {

        /* renamed from: a */
        final Lock f4339a = new ReentrantLock();

        /* renamed from: b */
        int f4340b;

        a() {
        }
    }

    C1641c() {
    }

    /* renamed from: a */
    void m3984a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f4337a.get(str);
            if (aVar == null) {
                aVar = this.f4338b.m3986a();
                this.f4337a.put(str, aVar);
            }
            aVar.f4340b++;
        }
        aVar.f4339a.lock();
    }

    /* renamed from: b */
    void m3985b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) C1876j.m4985a(this.f4337a.get(str));
            if (aVar.f4340b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f4340b);
            }
            aVar.f4340b--;
            if (aVar.f4340b == 0) {
                a remove = this.f4337a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f4338b.m3987a(remove);
            }
        }
        aVar.f4339a.unlock();
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.p.b0.c$b */
    private static class b {

        /* renamed from: b */
        private static final int f4341b = 10;

        /* renamed from: a */
        private final Queue<a> f4342a = new ArrayDeque();

        b() {
        }

        /* renamed from: a */
        a m3986a() {
            a poll;
            synchronized (this.f4342a) {
                poll = this.f4342a.poll();
            }
            return poll == null ? new a() : poll;
        }

        /* renamed from: a */
        void m3987a(a aVar) {
            synchronized (this.f4342a) {
                if (this.f4342a.size() < 10) {
                    this.f4342a.offer(aVar);
                }
            }
        }
    }
}
