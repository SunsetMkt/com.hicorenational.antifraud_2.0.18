package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p259g1.AbstractC4506b;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;
import p324i.p338d.InterfaceC5821b;

/* compiled from: BlockingFlowableLatest.java */
/* renamed from: g.a.y0.e.b.c */
/* loaded from: classes2.dex */
public final class C4698c<T> implements Iterable<T> {

    /* renamed from: a */
    final InterfaceC5821b<? extends T> f17794a;

    /* compiled from: BlockingFlowableLatest.java */
    /* renamed from: g.a.y0.e.b.c$a */
    static final class a<T> extends AbstractC4506b<C4453a0<T>> implements Iterator<T> {

        /* renamed from: b */
        final Semaphore f17795b = new Semaphore(0);

        /* renamed from: c */
        final AtomicReference<C4453a0<T>> f17796c = new AtomicReference<>();

        /* renamed from: d */
        C4453a0<T> f17797d;

        a() {
        }

        @Override // p324i.p338d.InterfaceC5822c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(C4453a0<T> c4453a0) {
            if (this.f17796c.getAndSet(c4453a0) == null) {
                this.f17795b.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            C4453a0<T> c4453a0 = this.f17797d;
            if (c4453a0 != null && c4453a0.m16441d()) {
                throw C5171k.m18626c(this.f17797d.m16438a());
            }
            C4453a0<T> c4453a02 = this.f17797d;
            if ((c4453a02 == null || c4453a02.m16442e()) && this.f17797d == null) {
                try {
                    C5165e.m18612a();
                    this.f17795b.acquire();
                    C4453a0<T> andSet = this.f17796c.getAndSet(null);
                    this.f17797d = andSet;
                    if (andSet.m16441d()) {
                        throw C5171k.m18626c(andSet.m16438a());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f17797d = C4453a0.m16436a((Throwable) e2);
                    throw C5171k.m18626c(e2);
                }
            }
            return this.f17797d.m16442e();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.f17797d.m16442e()) {
                throw new NoSuchElementException();
            }
            T m16439b = this.f17797d.m16439b();
            this.f17797d = null;
            return m16439b;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            C4476a.m17152b(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public C4698c(InterfaceC5821b<? extends T> interfaceC5821b) {
        this.f17794a = interfaceC5821b;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        AbstractC4519l.m17659q(this.f17794a).m17987t().m17799a((InterfaceC4529q<? super C4453a0<T>>) aVar);
        return aVar;
    }
}
