package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: BlockingObservableLatest.java */
/* renamed from: g.a.y0.e.d.c */
/* loaded from: classes2.dex */
public final class C4919c<T> implements Iterable<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f18813a;

    /* compiled from: BlockingObservableLatest.java */
    /* renamed from: g.a.y0.e.d.c$a */
    static final class a<T> extends AbstractC4458e<C4453a0<T>> implements Iterator<T> {

        /* renamed from: b */
        C4453a0<T> f18814b;

        /* renamed from: c */
        final Semaphore f18815c = new Semaphore(0);

        /* renamed from: d */
        final AtomicReference<C4453a0<T>> f18816d = new AtomicReference<>();

        a() {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(C4453a0<T> c4453a0) {
            if (this.f18816d.getAndSet(c4453a0) == null) {
                this.f18815c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            C4453a0<T> c4453a0 = this.f18814b;
            if (c4453a0 != null && c4453a0.m16441d()) {
                throw C5171k.m18626c(this.f18814b.m16438a());
            }
            if (this.f18814b == null) {
                try {
                    C5165e.m18612a();
                    this.f18815c.acquire();
                    C4453a0<T> andSet = this.f18816d.getAndSet(null);
                    this.f18814b = andSet;
                    if (andSet.m16441d()) {
                        throw C5171k.m18626c(andSet.m16438a());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f18814b = C4453a0.m16436a((Throwable) e2);
                    throw C5171k.m18626c(e2);
                }
            }
            return this.f18814b.m16442e();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T m16439b = this.f18814b.m16439b();
            this.f18814b = null;
            return m16439b;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            C4476a.m17152b(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public C4919c(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f18813a = interfaceC4504g0;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        AbstractC4469b0.m16646v(this.f18813a).m16949t().subscribe(aVar);
        return aVar;
    }
}
