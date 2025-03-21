package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p259g1.AbstractC4506b;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;
import p324i.p338d.InterfaceC5821b;

/* compiled from: BlockingFlowableNext.java */
/* renamed from: g.a.y0.e.b.e */
/* loaded from: classes2.dex */
public final class C4710e<T> implements Iterable<T> {

    /* renamed from: a */
    final InterfaceC5821b<? extends T> f17840a;

    /* compiled from: BlockingFlowableNext.java */
    /* renamed from: g.a.y0.e.b.e$a */
    static final class a<T> implements Iterator<T> {

        /* renamed from: a */
        private final b<T> f17841a;

        /* renamed from: b */
        private final InterfaceC5821b<? extends T> f17842b;

        /* renamed from: c */
        private T f17843c;

        /* renamed from: d */
        private boolean f17844d = true;

        /* renamed from: e */
        private boolean f17845e = true;

        /* renamed from: f */
        private Throwable f17846f;

        /* renamed from: g */
        private boolean f17847g;

        a(InterfaceC5821b<? extends T> interfaceC5821b, b<T> bVar) {
            this.f17842b = interfaceC5821b;
            this.f17841a = bVar;
        }

        /* renamed from: a */
        private boolean m18318a() {
            try {
                if (!this.f17847g) {
                    this.f17847g = true;
                    this.f17841a.m18320c();
                    AbstractC4519l.m17659q(this.f17842b).m17987t().m17799a((InterfaceC4529q<? super C4453a0<T>>) this.f17841a);
                }
                C4453a0<T> m18321d = this.f17841a.m18321d();
                if (m18321d.m16442e()) {
                    this.f17845e = false;
                    this.f17843c = m18321d.m16439b();
                    return true;
                }
                this.f17844d = false;
                if (m18321d.m16440c()) {
                    return false;
                }
                if (!m18321d.m16441d()) {
                    throw new IllegalStateException("Should not reach here");
                }
                this.f17846f = m18321d.m16438a();
                throw C5171k.m18626c(this.f17846f);
            } catch (InterruptedException e2) {
                this.f17841a.dispose();
                this.f17846f = e2;
                throw C5171k.m18626c(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f17846f;
            if (th != null) {
                throw C5171k.m18626c(th);
            }
            if (this.f17844d) {
                return !this.f17845e || m18318a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f17846f;
            if (th != null) {
                throw C5171k.m18626c(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f17845e = true;
            return this.f17843c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* compiled from: BlockingFlowableNext.java */
    /* renamed from: g.a.y0.e.b.e$b */
    static final class b<T> extends AbstractC4506b<C4453a0<T>> {

        /* renamed from: b */
        private final BlockingQueue<C4453a0<T>> f17848b = new ArrayBlockingQueue(1);

        /* renamed from: c */
        final AtomicInteger f17849c = new AtomicInteger();

        b() {
        }

        @Override // p324i.p338d.InterfaceC5822c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(C4453a0<T> c4453a0) {
            if (this.f17849c.getAndSet(0) == 1 || !c4453a0.m16442e()) {
                while (!this.f17848b.offer(c4453a0)) {
                    C4453a0<T> poll = this.f17848b.poll();
                    if (poll != null && !poll.m16442e()) {
                        c4453a0 = poll;
                    }
                }
            }
        }

        /* renamed from: c */
        void m18320c() {
            this.f17849c.set(1);
        }

        /* renamed from: d */
        public C4453a0<T> m18321d() throws InterruptedException {
            m18320c();
            C5165e.m18612a();
            return this.f17848b.take();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            C4476a.m17152b(th);
        }
    }

    public C4710e(InterfaceC5821b<? extends T> interfaceC5821b) {
        this.f17840a = interfaceC5821b;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f17840a, new b());
    }
}
