package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5171k;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableFlattenIterable.java */
/* renamed from: g.a.y0.e.b.c1 */
/* loaded from: classes2.dex */
public final class C4700c1<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> f17801c;

    /* renamed from: d */
    final int f17802d;

    /* compiled from: FlowableFlattenIterable.java */
    /* renamed from: g.a.y0.e.b.c1$a */
    static final class a<T, R> extends AbstractC5153c<R> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        int fusionMode;
        final int limit;
        final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        InterfaceC4616o<T> queue;

        /* renamed from: s */
        InterfaceC5823d f17803s;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o, int i2) {
            this.actual = interfaceC5822c;
            this.mapper = interfaceC4584o;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f17803s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<?> interfaceC5822c, InterfaceC4616o<?> interfaceC4616o) {
            if (this.cancelled) {
                this.current = null;
                interfaceC4616o.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.error.get() == null) {
                if (!z2) {
                    return false;
                }
                interfaceC5822c.onComplete();
                return true;
            }
            Throwable m18622a = C5171k.m18622a(this.error);
            this.current = null;
            interfaceC4616o.clear();
            interfaceC5822c.onError(m18622a);
            return true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        void consumedOne(boolean z) {
            if (z) {
                int i2 = this.consumed + 1;
                if (i2 != this.limit) {
                    this.consumed = i2;
                } else {
                    this.consumed = 0;
                    this.f17803s.request(i2);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x0121, code lost:
        
            if (r6 == null) goto L72;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4700c1.a.drain():void");
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.current == null ? this.queue.isEmpty() : !r0.hasNext();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done || !C5171k.m18624a(this.error, th)) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                onError(new C4562c("Queue is full?!"));
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17803s, interfaceC5823d)) {
                this.f17803s = interfaceC5823d;
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.actual.onSubscribe(this);
                        interfaceC5823d.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new C5110b(this.prefetch);
                this.actual.onSubscribe(this);
                interfaceC5823d.request(this.prefetch);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = this.mapper.apply(poll).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r = (R) C4601b.m18284a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return r;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return ((i2 & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }

    public C4700c1(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o, int i2) {
        super(abstractC4519l);
        this.f17801c = interfaceC4584o;
        this.f17802d = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        AbstractC4519l<T> abstractC4519l = this.f17759b;
        if (!(abstractC4519l instanceof Callable)) {
            abstractC4519l.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17801c, this.f17802d));
            return;
        }
        try {
            Object call = ((Callable) abstractC4519l).call();
            if (call == null) {
                EnumC5157g.complete(interfaceC5822c);
                return;
            }
            try {
                C4724g1.m18322a((InterfaceC5822c) interfaceC5822c, (Iterator) this.f17801c.apply(call).iterator());
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC5157g.error(th, interfaceC5822c);
            }
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            EnumC5157g.error(th2, interfaceC5822c);
        }
    }
}
