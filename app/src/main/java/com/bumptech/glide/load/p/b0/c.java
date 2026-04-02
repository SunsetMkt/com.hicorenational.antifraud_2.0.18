package com.bumptech.glide.load.p.b0;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: DiskCacheWriteLocker.java */
/* JADX INFO: loaded from: classes.dex */
final class c {
    private final Map<String, a> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2822b = new b();

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class a {
        final Lock a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2823b;

        a() {
        }
    }

    c() {
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.a.get(str);
            if (aVarA == null) {
                aVarA = this.f2822b.a();
                this.a.put(str, aVarA);
            }
            aVarA.f2823b++;
        }
        aVarA.a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.bumptech.glide.util.j.a(this.a.get(str));
            if (aVar.f2823b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f2823b);
            }
            aVar.f2823b--;
            if (aVar.f2823b == 0) {
                a aVarRemove = this.a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.f2822b.a(aVarRemove);
            }
        }
        aVar.a.unlock();
    }

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f2824b = 10;
        private final Queue<a> a = new ArrayDeque();

        b() {
        }

        a a() {
            a aVarPoll;
            synchronized (this.a) {
                aVarPoll = this.a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void a(a aVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(aVar);
                }
            }
        }
    }
}
