package p251g.p252a.p268y0.p284j;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p324i.p338d.InterfaceC5822c;

/* compiled from: HalfSerializer.java */
/* renamed from: g.a.y0.j.l */
/* loaded from: classes2.dex */
public final class C5172l {
    private C5172l() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T> void m18630a(InterfaceC5822c<? super T> interfaceC5822c, T t, AtomicInteger atomicInteger, C5163c c5163c) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            interfaceC5822c.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = c5163c.terminate();
                if (terminate != null) {
                    interfaceC5822c.onError(terminate);
                } else {
                    interfaceC5822c.onComplete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m18631a(InterfaceC5822c<?> interfaceC5822c, Throwable th, AtomicInteger atomicInteger, C5163c c5163c) {
        if (c5163c.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                interfaceC5822c.onError(c5163c.terminate());
                return;
            }
            return;
        }
        C4476a.m17152b(th);
    }

    /* renamed from: a */
    public static void m18632a(InterfaceC5822c<?> interfaceC5822c, AtomicInteger atomicInteger, C5163c c5163c) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = c5163c.terminate();
            if (terminate != null) {
                interfaceC5822c.onError(terminate);
            } else {
                interfaceC5822c.onComplete();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T> void m18627a(InterfaceC4514i0<? super T> interfaceC4514i0, T t, AtomicInteger atomicInteger, C5163c c5163c) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            interfaceC4514i0.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = c5163c.terminate();
                if (terminate != null) {
                    interfaceC4514i0.onError(terminate);
                } else {
                    interfaceC4514i0.onComplete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m18628a(InterfaceC4514i0<?> interfaceC4514i0, Throwable th, AtomicInteger atomicInteger, C5163c c5163c) {
        if (c5163c.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                interfaceC4514i0.onError(c5163c.terminate());
                return;
            }
            return;
        }
        C4476a.m17152b(th);
    }

    /* renamed from: a */
    public static void m18629a(InterfaceC4514i0<?> interfaceC4514i0, AtomicInteger atomicInteger, C5163c c5163c) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = c5163c.terminate();
            if (terminate != null) {
                interfaceC4514i0.onError(terminate);
            } else {
                interfaceC4514i0.onComplete();
            }
        }
    }
}
