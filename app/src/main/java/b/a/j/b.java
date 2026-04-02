package b.a.j;

import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static List<a> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f1797b = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock.ReadLock f1798c = f1797b.readLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ReentrantReadWriteLock.WriteLock f1799d = f1797b.writeLock();

    /* JADX INFO: compiled from: Taobao */
    private static class a implements Comparable<a> {
        final b.a.j.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f1800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f1801c;

        a(b.a.j.a aVar, c cVar, int i2) {
            this.a = aVar;
            this.f1800b = cVar;
            this.f1801c = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.f1801c - aVar.f1801c;
        }
    }

    public static void a(b.a.j.a aVar, c cVar, int i2) {
        try {
            if (aVar == null) {
                throw new IllegalArgumentException("cache is null");
            }
            if (cVar == null) {
                throw new IllegalArgumentException("prediction is null");
            }
            f1799d.lock();
            a.add(new a(aVar, cVar, i2));
            Collections.sort(a);
        } finally {
            f1799d.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(b.a.j.a aVar) {
        try {
            f1799d.lock();
            ListIterator<a> listIterator = a.listIterator();
            while (true) {
                if (!listIterator.hasNext()) {
                    break;
                } else if (listIterator.next().a == aVar) {
                    break;
                }
            }
        } finally {
            f1799d.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        r3 = r1.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b.a.j.a a(String str, Map<String, String> map) {
        b.a.j.a aVar;
        try {
            f1798c.lock();
            Iterator<a> it = a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                a next = it.next();
                if (next.f1800b.handleCache(str, map)) {
                    break;
                }
            }
            return aVar;
        } finally {
            f1798c.unlock();
        }
    }

    public static void a() {
        ALog.w("anet.CacheManager", "clearAllCache", null, new Object[0]);
        Iterator<a> it = a.iterator();
        while (it.hasNext()) {
            try {
                it.next().a.clear();
            } catch (Exception unused) {
            }
        }
    }
}
