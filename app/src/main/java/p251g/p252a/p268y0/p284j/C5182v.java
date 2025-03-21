package p251g.p252a.p268y0.p284j;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4574e;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p280f.C5111c;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: QueueDrainHelper.java */
/* renamed from: g.a.y0.j.v */
/* loaded from: classes2.dex */
public final class C5182v {

    /* renamed from: a */
    static final long f20050a = Long.MIN_VALUE;

    /* renamed from: b */
    static final long f20051b = Long.MAX_VALUE;

    private C5182v() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T, U> void m18648a(InterfaceC4615n<T> interfaceC4615n, InterfaceC5822c<? super U> interfaceC5822c, boolean z, InterfaceC4552c interfaceC4552c, InterfaceC5181u<T, U> interfaceC5181u) {
        int i2 = 1;
        while (true) {
            boolean mo18597c = interfaceC5181u.mo18597c();
            T poll = interfaceC4615n.poll();
            boolean z2 = poll == null;
            if (m18654a(mo18597c, z2, interfaceC5822c, z, interfaceC4615n, interfaceC5181u)) {
                if (interfaceC4552c != null) {
                    interfaceC4552c.dispose();
                    return;
                }
                return;
            } else if (z2) {
                i2 = interfaceC5181u.mo18590a(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                long requested = interfaceC5181u.requested();
                if (requested == 0) {
                    interfaceC4615n.clear();
                    if (interfaceC4552c != null) {
                        interfaceC4552c.dispose();
                    }
                    interfaceC5822c.onError(new C4562c("Could not emit value due to lack of requests."));
                    return;
                }
                if (interfaceC5181u.mo18337a(interfaceC5822c, poll) && requested != Long.MAX_VALUE) {
                    interfaceC5181u.mo18591a(1L);
                }
            }
        }
    }

    /* renamed from: b */
    public static <T> boolean m18655b(long j2, InterfaceC5822c<? super T> interfaceC5822c, Queue<T> queue, AtomicLong atomicLong, InterfaceC4574e interfaceC4574e) {
        long j3;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, C5164d.m18606a(Long.MAX_VALUE & j3, j2) | (j3 & Long.MIN_VALUE)));
        if (j3 != Long.MIN_VALUE) {
            return false;
        }
        m18651a(j2 | Long.MIN_VALUE, interfaceC5822c, queue, atomicLong, interfaceC4574e);
        return true;
    }

    /* renamed from: a */
    public static <T, U> boolean m18654a(boolean z, boolean z2, InterfaceC5822c<?> interfaceC5822c, boolean z3, InterfaceC4616o<?> interfaceC4616o, InterfaceC5181u<T, U> interfaceC5181u) {
        if (interfaceC5181u.mo18598d()) {
            interfaceC4616o.clear();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            Throwable mo18592a = interfaceC5181u.mo18592a();
            if (mo18592a != null) {
                interfaceC5822c.onError(mo18592a);
            } else {
                interfaceC5822c.onComplete();
            }
            return true;
        }
        Throwable mo18592a2 = interfaceC5181u.mo18592a();
        if (mo18592a2 != null) {
            interfaceC4616o.clear();
            interfaceC5822c.onError(mo18592a2);
            return true;
        }
        if (!z2) {
            return false;
        }
        interfaceC5822c.onComplete();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r1 = r15.mo18300a(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        return;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T, U> void m18647a(p251g.p252a.p268y0.p271c.InterfaceC4615n<T> r11, p251g.p252a.InterfaceC4514i0<? super U> r12, boolean r13, p251g.p252a.p264u0.InterfaceC4552c r14, p251g.p252a.p268y0.p284j.InterfaceC5178r<T, U> r15) {
        /*
            r0 = 1
            r1 = 1
        L2:
            boolean r2 = r15.mo18306c()
            boolean r3 = r11.isEmpty()
            r4 = r12
            r5 = r13
            r6 = r11
            r7 = r14
            r8 = r15
            boolean r2 = m18653a(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L16
            return
        L16:
            boolean r3 = r15.mo18306c()
            java.lang.Object r2 = r11.poll()
            if (r2 != 0) goto L22
            r10 = 1
            goto L24
        L22:
            r4 = 0
            r10 = 0
        L24:
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r11
            r8 = r14
            r9 = r15
            boolean r3 = m18653a(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L31
            return
        L31:
            if (r10 == 0) goto L3b
            int r1 = -r1
            int r1 = r15.mo18300a(r1)
            if (r1 != 0) goto L2
            return
        L3b:
            r15.mo18302a(r12, r2)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p284j.C5182v.m18647a(g.a.y0.c.n, g.a.i0, boolean, g.a.u0.c, g.a.y0.j.r):void");
    }

    /* renamed from: a */
    public static <T, U> boolean m18653a(boolean z, boolean z2, InterfaceC4514i0<?> interfaceC4514i0, boolean z3, InterfaceC4616o<?> interfaceC4616o, InterfaceC4552c interfaceC4552c, InterfaceC5178r<T, U> interfaceC5178r) {
        if (interfaceC5178r.mo18307d()) {
            interfaceC4616o.clear();
            interfaceC4552c.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            interfaceC4552c.dispose();
            Throwable mo18301a = interfaceC5178r.mo18301a();
            if (mo18301a != null) {
                interfaceC4514i0.onError(mo18301a);
            } else {
                interfaceC4514i0.onComplete();
            }
            return true;
        }
        Throwable mo18301a2 = interfaceC5178r.mo18301a();
        if (mo18301a2 != null) {
            interfaceC4616o.clear();
            interfaceC4552c.dispose();
            interfaceC4514i0.onError(mo18301a2);
            return true;
        }
        if (!z2) {
            return false;
        }
        interfaceC4552c.dispose();
        interfaceC4514i0.onComplete();
        return true;
    }

    /* renamed from: a */
    public static <T> InterfaceC4616o<T> m18646a(int i2) {
        if (i2 < 0) {
            return new C5111c(-i2);
        }
        return new C5110b(i2);
    }

    /* renamed from: a */
    public static void m18650a(InterfaceC5823d interfaceC5823d, int i2) {
        interfaceC5823d.request(i2 < 0 ? Long.MAX_VALUE : i2);
    }

    /* renamed from: a */
    static boolean m18652a(InterfaceC4574e interfaceC4574e) {
        try {
            return interfaceC4574e.getAsBoolean();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            return true;
        }
    }

    /* renamed from: a */
    static <T> boolean m18651a(long j2, InterfaceC5822c<? super T> interfaceC5822c, Queue<T> queue, AtomicLong atomicLong, InterfaceC4574e interfaceC4574e) {
        long j3 = j2 & Long.MIN_VALUE;
        while (true) {
            if (j3 != j2) {
                if (m18652a(interfaceC4574e)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    interfaceC5822c.onComplete();
                    return true;
                }
                interfaceC5822c.onNext(poll);
                j3++;
            } else {
                if (m18652a(interfaceC4574e)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    interfaceC5822c.onComplete();
                    return true;
                }
                j2 = atomicLong.get();
                if (j2 == j3) {
                    long addAndGet = atomicLong.addAndGet(-(j3 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j2 = addAndGet;
                    j3 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    /* renamed from: a */
    public static <T> void m18649a(InterfaceC5822c<? super T> interfaceC5822c, Queue<T> queue, AtomicLong atomicLong, InterfaceC4574e interfaceC4574e) {
        long j2;
        long j3;
        if (queue.isEmpty()) {
            interfaceC5822c.onComplete();
            return;
        }
        if (m18651a(atomicLong.get(), interfaceC5822c, queue, atomicLong, interfaceC4574e)) {
            return;
        }
        do {
            j2 = atomicLong.get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j3 = j2 | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        if (j2 != 0) {
            m18651a(j3, interfaceC5822c, queue, atomicLong, interfaceC4574e);
        }
    }
}
