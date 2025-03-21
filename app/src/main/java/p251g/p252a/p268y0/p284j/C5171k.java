package p251g.p252a.p268y0.p284j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p265v0.C4560a;

/* compiled from: ExceptionHelper.java */
/* renamed from: g.a.y0.j.k */
/* loaded from: classes2.dex */
public final class C5171k {

    /* renamed from: a */
    public static final Throwable f20031a = new a();

    /* compiled from: ExceptionHelper.java */
    /* renamed from: g.a.y0.j.k$a */
    static final class a extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    private C5171k() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> boolean m18624a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == f20031a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new C4560a(th2, th)));
        return true;
    }

    /* renamed from: b */
    public static <E extends Throwable> Exception m18625b(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    /* renamed from: c */
    public static RuntimeException m18626c(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }

    /* renamed from: a */
    public static <T> Throwable m18622a(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f20031a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    /* renamed from: a */
    public static List<Throwable> m18623a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(th);
        while (!arrayDeque.isEmpty()) {
            Throwable th2 = (Throwable) arrayDeque.removeFirst();
            if (th2 instanceof C4560a) {
                List<Throwable> exceptions = ((C4560a) th2).getExceptions();
                for (int size = exceptions.size() - 1; size >= 0; size--) {
                    arrayDeque.offerFirst(exceptions.get(size));
                }
            } else {
                arrayList.add(th2);
            }
        }
        return arrayList;
    }
}
