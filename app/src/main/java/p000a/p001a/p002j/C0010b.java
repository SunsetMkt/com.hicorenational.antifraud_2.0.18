package p000a.p001a.p002j;

import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* renamed from: a.a.j.b */
/* loaded from: classes.dex */
public class C0010b {

    /* renamed from: a */
    private static List<a> f0a = new ArrayList();

    /* renamed from: b */
    private static final ReentrantReadWriteLock f1b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private static final ReentrantReadWriteLock.ReadLock f2c = f1b.readLock();

    /* renamed from: d */
    private static final ReentrantReadWriteLock.WriteLock f3d = f1b.writeLock();

    /* compiled from: Taobao */
    /* renamed from: a.a.j.b$a */
    private static class a implements Comparable<a> {

        /* renamed from: a */
        final InterfaceC0009a f4a;

        /* renamed from: b */
        final InterfaceC0011c f5b;

        /* renamed from: c */
        final int f6c;

        a(InterfaceC0009a interfaceC0009a, InterfaceC0011c interfaceC0011c, int i2) {
            this.f4a = interfaceC0009a;
            this.f5b = interfaceC0011c;
            this.f6c = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.f6c - aVar.f6c;
        }
    }

    /* renamed from: a */
    public static void m59a(InterfaceC0009a interfaceC0009a, InterfaceC0011c interfaceC0011c, int i2) {
        try {
            if (interfaceC0009a == null) {
                throw new IllegalArgumentException("cache is null");
            }
            if (interfaceC0011c == null) {
                throw new IllegalArgumentException("prediction is null");
            }
            f3d.lock();
            f0a.add(new a(interfaceC0009a, interfaceC0011c, i2));
            Collections.sort(f0a);
        } finally {
            f3d.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        r0.remove();
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m58a(p000a.p001a.p002j.InterfaceC0009a r2) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = p000a.p001a.p002j.C0010b.f3d     // Catch: java.lang.Throwable -> L24
            r0.lock()     // Catch: java.lang.Throwable -> L24
            java.util.List<a.a.j.b$a> r0 = p000a.p001a.p002j.C0010b.f0a     // Catch: java.lang.Throwable -> L24
            java.util.ListIterator r0 = r0.listIterator()     // Catch: java.lang.Throwable -> L24
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L24
            a.a.j.b$a r1 = (p000a.p001a.p002j.C0010b.a) r1     // Catch: java.lang.Throwable -> L24
            a.a.j.a r1 = r1.f4a     // Catch: java.lang.Throwable -> L24
            if (r1 != r2) goto Lb
            r0.remove()     // Catch: java.lang.Throwable -> L24
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = p000a.p001a.p002j.C0010b.f3d
            r2.unlock()
            return
        L24:
            r2 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = p000a.p001a.p002j.C0010b.f3d
            r0.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002j.C0010b.m58a(a.a.j.a):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        r3 = r1.f4a;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p000a.p001a.p002j.InterfaceC0009a m56a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = p000a.p001a.p002j.C0010b.f2c     // Catch: java.lang.Throwable -> L29
            r0.lock()     // Catch: java.lang.Throwable -> L29
            java.util.List<a.a.j.b$a> r0 = p000a.p001a.p002j.C0010b.f0a     // Catch: java.lang.Throwable -> L29
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L29
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L27
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L29
            a.a.j.b$a r1 = (p000a.p001a.p002j.C0010b.a) r1     // Catch: java.lang.Throwable -> L29
            a.a.j.c r2 = r1.f5b     // Catch: java.lang.Throwable -> L29
            boolean r2 = r2.handleCache(r3, r4)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto Lb
            a.a.j.a r3 = r1.f4a     // Catch: java.lang.Throwable -> L29
        L21:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = p000a.p001a.p002j.C0010b.f2c
            r4.unlock()
            return r3
        L27:
            r3 = 0
            goto L21
        L29:
            r3 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = p000a.p001a.p002j.C0010b.f2c
            r4.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002j.C0010b.m56a(java.lang.String, java.util.Map):a.a.j.a");
    }

    /* renamed from: a */
    public static void m57a() {
        ALog.m718w("anet.CacheManager", "clearAllCache", null, new Object[0]);
        Iterator<a> it = f0a.iterator();
        while (it.hasNext()) {
            try {
                it.next().f4a.clear();
            } catch (Exception unused) {
            }
        }
    }
}
