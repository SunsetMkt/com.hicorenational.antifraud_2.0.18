package p286h.p292i2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5535f0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Locks.kt */
@InterfaceC5481e(name = "LocksKt")
/* renamed from: h.i2.a */
/* loaded from: classes2.dex */
public final class C5336a {
    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> T m21895a(@InterfaceC5816d Lock lock, InterfaceC5495a<? extends T> interfaceC5495a) {
        lock.lock();
        try {
            return interfaceC5495a.invoke();
        } finally {
            C5535f0.m22474b(1);
            lock.unlock();
            C5535f0.m22471a(1);
        }
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> T m21897b(@InterfaceC5816d ReentrantReadWriteLock reentrantReadWriteLock, InterfaceC5495a<? extends T> interfaceC5495a) {
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return interfaceC5495a.invoke();
        } finally {
            C5535f0.m22474b(1);
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            C5535f0.m22471a(1);
        }
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> T m21896a(@InterfaceC5816d ReentrantReadWriteLock reentrantReadWriteLock, InterfaceC5495a<? extends T> interfaceC5495a) {
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            return interfaceC5495a.invoke();
        } finally {
            C5535f0.m22474b(1);
            readLock.unlock();
            C5535f0.m22471a(1);
        }
    }
}
