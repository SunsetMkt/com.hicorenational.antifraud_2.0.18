package i.i2;

import i.m2.f;
import i.q2.e;
import i.q2.t.f0;
import j.c.a.d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: Locks.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(name = "LocksKt")
public final class a {
    @f
    private static final <T> T a(@d Lock lock, i.q2.s.a<? extends T> aVar) {
        lock.lock();
        try {
            return aVar.invoke();
        } finally {
            f0.b(1);
            lock.unlock();
            f0.a(1);
        }
    }

    @f
    private static final <T> T b(@d ReentrantReadWriteLock reentrantReadWriteLock, i.q2.s.a<? extends T> aVar) {
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return aVar.invoke();
        } finally {
            f0.b(1);
            while (i2 < readHoldCount) {
                lock.lock();
                i2++;
            }
            writeLock.unlock();
            f0.a(1);
        }
    }

    @f
    private static final <T> T a(@d ReentrantReadWriteLock reentrantReadWriteLock, i.q2.s.a<? extends T> aVar) {
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            return aVar.invoke();
        } finally {
            f0.b(1);
            lock.unlock();
            f0.a(1);
        }
    }
}
