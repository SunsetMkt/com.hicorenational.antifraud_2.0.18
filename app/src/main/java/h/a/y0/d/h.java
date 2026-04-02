package h.a.y0.d;

import h.a.n0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: BlockingMultiObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends CountDownLatch implements n0<T>, h.a.f, h.a.v<T> {
    T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f10470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    h.a.u0.c f10471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f10472d;

    public h() {
        super(1);
    }

    public T a() {
        if (getCount() != 0) {
            try {
                h.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                c();
                throw h.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f10470b;
        if (th == null) {
            return this.a;
        }
        throw h.a.y0.j.k.c(th);
    }

    public Throwable b() {
        if (getCount() != 0) {
            try {
                h.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                c();
                return e2;
            }
        }
        return this.f10470b;
    }

    void c() {
        this.f10472d = true;
        h.a.u0.c cVar = this.f10471c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // h.a.f
    public void onComplete() {
        countDown();
    }

    @Override // h.a.n0
    public void onError(Throwable th) {
        this.f10470b = th;
        countDown();
    }

    @Override // h.a.n0
    public void onSubscribe(h.a.u0.c cVar) {
        this.f10471c = cVar;
        if (this.f10472d) {
            cVar.dispose();
        }
    }

    @Override // h.a.n0
    public void onSuccess(T t) {
        this.a = t;
        countDown();
    }

    public Throwable b(long j2, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                h.a.y0.j.e.a();
                if (!await(j2, timeUnit)) {
                    c();
                    throw h.a.y0.j.k.c(new TimeoutException());
                }
            } catch (InterruptedException e2) {
                c();
                throw h.a.y0.j.k.c(e2);
            }
        }
        return this.f10470b;
    }

    public T a(T t) {
        if (getCount() != 0) {
            try {
                h.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                c();
                throw h.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f10470b;
        if (th == null) {
            T t2 = this.a;
            return t2 != null ? t2 : t;
        }
        throw h.a.y0.j.k.c(th);
    }

    public boolean a(long j2, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                h.a.y0.j.e.a();
                if (!await(j2, timeUnit)) {
                    c();
                    return false;
                }
            } catch (InterruptedException e2) {
                c();
                throw h.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f10470b;
        if (th == null) {
            return true;
        }
        throw h.a.y0.j.k.c(th);
    }
}
