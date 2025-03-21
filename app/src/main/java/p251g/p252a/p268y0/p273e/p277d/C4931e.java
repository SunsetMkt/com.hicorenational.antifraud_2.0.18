package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: BlockingObservableNext.java */
/* renamed from: g.a.y0.e.d.e */
/* loaded from: classes2.dex */
public final class C4931e<T> implements Iterable<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f18915a;

    /* compiled from: BlockingObservableNext.java */
    /* renamed from: g.a.y0.e.d.e$a */
    static final class a<T> implements Iterator<T> {

        /* renamed from: a */
        private final b<T> f18916a;

        /* renamed from: b */
        private final InterfaceC4504g0<T> f18917b;

        /* renamed from: c */
        private T f18918c;

        /* renamed from: d */
        private boolean f18919d = true;

        /* renamed from: e */
        private boolean f18920e = true;

        /* renamed from: f */
        private Throwable f18921f;

        /* renamed from: g */
        private boolean f18922g;

        a(InterfaceC4504g0<T> interfaceC4504g0, b<T> bVar) {
            this.f18917b = interfaceC4504g0;
            this.f18916a = bVar;
        }

        /* renamed from: a */
        private boolean m18440a() {
            if (!this.f18922g) {
                this.f18922g = true;
                this.f18916a.m18442b();
                new C5027w1(this.f18917b).subscribe(this.f18916a);
            }
            try {
                C4453a0<T> m18443c = this.f18916a.m18443c();
                if (m18443c.m16442e()) {
                    this.f18920e = false;
                    this.f18918c = m18443c.m16439b();
                    return true;
                }
                this.f18919d = false;
                if (m18443c.m16440c()) {
                    return false;
                }
                this.f18921f = m18443c.m16438a();
                throw C5171k.m18626c(this.f18921f);
            } catch (InterruptedException e2) {
                this.f18916a.dispose();
                this.f18921f = e2;
                throw C5171k.m18626c(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f18921f;
            if (th != null) {
                throw C5171k.m18626c(th);
            }
            if (this.f18919d) {
                return !this.f18920e || m18440a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f18921f;
            if (th != null) {
                throw C5171k.m18626c(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f18920e = true;
            return this.f18918c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* compiled from: BlockingObservableNext.java */
    /* renamed from: g.a.y0.e.d.e$b */
    static final class b<T> extends AbstractC4458e<C4453a0<T>> {

        /* renamed from: b */
        private final BlockingQueue<C4453a0<T>> f18923b = new ArrayBlockingQueue(1);

        /* renamed from: c */
        final AtomicInteger f18924c = new AtomicInteger();

        b() {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(C4453a0<T> c4453a0) {
            if (this.f18924c.getAndSet(0) == 1 || !c4453a0.m16442e()) {
                while (!this.f18923b.offer(c4453a0)) {
                    C4453a0<T> poll = this.f18923b.poll();
                    if (poll != null && !poll.m16442e()) {
                        c4453a0 = poll;
                    }
                }
            }
        }

        /* renamed from: b */
        void m18442b() {
            this.f18924c.set(1);
        }

        /* renamed from: c */
        public C4453a0<T> m18443c() throws InterruptedException {
            m18442b();
            C5165e.m18612a();
            return this.f18923b.take();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            C4476a.m17152b(th);
        }
    }

    public C4931e(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f18915a = interfaceC4504g0;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f18915a, new b());
    }
}
