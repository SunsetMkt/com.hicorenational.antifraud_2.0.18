package p251g.p252a.p268y0.p280f;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p284j.C5180t;

/* compiled from: SpscLinkedArrayQueue.java */
/* renamed from: g.a.y0.f.c */
/* loaded from: classes2.dex */
public final class C5111c<T> implements InterfaceC4615n<T> {

    /* renamed from: i */
    static final int f19829i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    private static final Object f19830j = new Object();

    /* renamed from: b */
    int f19832b;

    /* renamed from: c */
    long f19833c;

    /* renamed from: d */
    final int f19834d;

    /* renamed from: e */
    AtomicReferenceArray<Object> f19835e;

    /* renamed from: f */
    final int f19836f;

    /* renamed from: g */
    AtomicReferenceArray<Object> f19837g;

    /* renamed from: a */
    final AtomicLong f19831a = new AtomicLong();

    /* renamed from: h */
    final AtomicLong f19838h = new AtomicLong();

    public C5111c(int i2) {
        int m18645b = C5180t.m18645b(Math.max(8, i2));
        int i3 = m18645b - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(m18645b + 1);
        this.f19835e = atomicReferenceArray;
        this.f19834d = i3;
        m18540a(m18645b);
        this.f19837g = atomicReferenceArray;
        this.f19836f = i3;
        this.f19833c = i3 - 1;
        m18549b(0L);
    }

    /* renamed from: a */
    private boolean m18545a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        m18542a(atomicReferenceArray, i2, t);
        m18549b(j2 + 1);
        return true;
    }

    /* renamed from: b */
    private static int m18546b(int i2) {
        return i2;
    }

    /* renamed from: b */
    private AtomicReferenceArray<Object> m18548b(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int m18546b = m18546b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) m18538a(atomicReferenceArray, m18546b);
        m18542a(atomicReferenceArray, m18546b, (Object) null);
        return atomicReferenceArray2;
    }

    /* renamed from: c */
    private long m18550c() {
        return this.f19838h.get();
    }

    /* renamed from: d */
    private long m18551d() {
        return this.f19831a.get();
    }

    /* renamed from: e */
    private long m18552e() {
        return this.f19838h.get();
    }

    /* renamed from: f */
    private long m18553f() {
        return this.f19831a.get();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean isEmpty() {
        return m18553f() == m18552e();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f19835e;
        long m18551d = m18551d();
        int i2 = this.f19834d;
        int m18537a = m18537a(m18551d, i2);
        if (m18551d < this.f19833c) {
            return m18545a(atomicReferenceArray, t, m18551d, m18537a);
        }
        long j2 = this.f19832b + m18551d;
        if (m18538a(atomicReferenceArray, m18537a(j2, i2)) == null) {
            this.f19833c = j2 - 1;
            return m18545a(atomicReferenceArray, t, m18551d, m18537a);
        }
        if (m18538a(atomicReferenceArray, m18537a(1 + m18551d, i2)) == null) {
            return m18545a(atomicReferenceArray, t, m18551d, m18537a);
        }
        m18543a(atomicReferenceArray, m18551d, m18537a, t, i2);
        return true;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4615n, p251g.p252a.p268y0.p271c.InterfaceC4616o
    @InterfaceC4547g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f19837g;
        long m18550c = m18550c();
        int i2 = this.f19836f;
        int m18537a = m18537a(m18550c, i2);
        T t = (T) m18538a(atomicReferenceArray, m18537a);
        boolean z = t == f19830j;
        if (t == null || z) {
            if (z) {
                return m18547b(m18548b(atomicReferenceArray, i2 + 1), m18550c, i2);
            }
            return null;
        }
        m18542a(atomicReferenceArray, m18537a, (Object) null);
        m18541a(m18550c + 1);
        return t;
    }

    /* renamed from: a */
    private void m18543a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f19835e = atomicReferenceArray2;
        this.f19833c = (j3 + j2) - 1;
        m18542a(atomicReferenceArray2, i2, t);
        m18544a(atomicReferenceArray, atomicReferenceArray2);
        m18542a(atomicReferenceArray, i2, f19830j);
        m18549b(j2 + 1);
    }

    /* renamed from: b */
    private T m18547b(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f19837g = atomicReferenceArray;
        int m18537a = m18537a(j2, i2);
        T t = (T) m18538a(atomicReferenceArray, m18537a);
        if (t != null) {
            m18542a(atomicReferenceArray, m18537a, (Object) null);
            m18541a(j2 + 1);
        }
        return t;
    }

    /* renamed from: b */
    public int m18555b() {
        long m18552e = m18552e();
        while (true) {
            long m18553f = m18553f();
            long m18552e2 = m18552e();
            if (m18552e == m18552e2) {
                return (int) (m18553f - m18552e2);
            }
            m18552e = m18552e2;
        }
    }

    /* renamed from: a */
    private void m18544a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m18542a(atomicReferenceArray, m18546b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    /* renamed from: b */
    private void m18549b(long j2) {
        this.f19831a.lazySet(j2);
    }

    /* renamed from: a */
    public T m18554a() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f19837g;
        long m18550c = m18550c();
        int i2 = this.f19836f;
        T t = (T) m18538a(atomicReferenceArray, m18537a(m18550c, i2));
        return t == f19830j ? m18539a(m18548b(atomicReferenceArray, i2 + 1), m18550c, i2) : t;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f19835e;
        long m18553f = m18553f();
        int i2 = this.f19834d;
        long j2 = 2 + m18553f;
        if (m18538a(atomicReferenceArray, m18537a(j2, i2)) == null) {
            int m18537a = m18537a(m18553f, i2);
            m18542a(atomicReferenceArray, m18537a + 1, t2);
            m18542a(atomicReferenceArray, m18537a, t);
            m18549b(j2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f19835e = atomicReferenceArray2;
        int m18537a2 = m18537a(m18553f, i2);
        m18542a(atomicReferenceArray2, m18537a2 + 1, t2);
        m18542a(atomicReferenceArray2, m18537a2, t);
        m18544a(atomicReferenceArray, atomicReferenceArray2);
        m18542a(atomicReferenceArray, m18537a2, f19830j);
        m18549b(j2);
        return true;
    }

    /* renamed from: a */
    private T m18539a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f19837g = atomicReferenceArray;
        return (T) m18538a(atomicReferenceArray, m18537a(j2, i2));
    }

    /* renamed from: a */
    private void m18540a(int i2) {
        this.f19832b = Math.min(i2 / 4, f19829i);
    }

    /* renamed from: a */
    private void m18541a(long j2) {
        this.f19838h.lazySet(j2);
    }

    /* renamed from: a */
    private static int m18537a(long j2, int i2) {
        return m18546b(((int) j2) & i2);
    }

    /* renamed from: a */
    private static void m18542a(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    /* renamed from: a */
    private static <E> Object m18538a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }
}
