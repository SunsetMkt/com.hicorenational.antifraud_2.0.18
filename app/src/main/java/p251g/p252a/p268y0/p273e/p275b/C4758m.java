package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4574e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5182v;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableBuffer.java */
/* renamed from: g.a.y0.e.b.m */
/* loaded from: classes2.dex */
public final class C4758m<T, C extends Collection<? super T>> extends AbstractC4686a<T, C> {

    /* renamed from: c */
    final int f18047c;

    /* renamed from: d */
    final int f18048d;

    /* renamed from: e */
    final Callable<C> f18049e;

    /* compiled from: FlowableBuffer.java */
    /* renamed from: g.a.y0.e.b.m$a */
    static final class a<T, C extends Collection<? super T>> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super C> f18050a;

        /* renamed from: b */
        final Callable<C> f18051b;

        /* renamed from: c */
        final int f18052c;

        /* renamed from: d */
        C f18053d;

        /* renamed from: e */
        InterfaceC5823d f18054e;

        /* renamed from: f */
        boolean f18055f;

        /* renamed from: g */
        int f18056g;

        a(InterfaceC5822c<? super C> interfaceC5822c, int i2, Callable<C> callable) {
            this.f18050a = interfaceC5822c;
            this.f18052c = i2;
            this.f18051b = callable;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18054e.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18055f) {
                return;
            }
            this.f18055f = true;
            C c2 = this.f18053d;
            if (c2 != null && !c2.isEmpty()) {
                this.f18050a.onNext(c2);
            }
            this.f18050a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18055f) {
                C4476a.m17152b(th);
            } else {
                this.f18055f = true;
                this.f18050a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18055f) {
                return;
            }
            C c2 = this.f18053d;
            if (c2 == null) {
                try {
                    c2 = (C) C4601b.m18284a(this.f18051b.call(), "The bufferSupplier returned a null buffer");
                    this.f18053d = c2;
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c2.add(t);
            int i2 = this.f18056g + 1;
            if (i2 != this.f18052c) {
                this.f18056g = i2;
                return;
            }
            this.f18056g = 0;
            this.f18053d = null;
            this.f18050a.onNext(c2);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18054e, interfaceC5823d)) {
                this.f18054e = interfaceC5823d;
                this.f18050a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                this.f18054e.request(C5164d.m18608b(j2, this.f18052c));
            }
        }
    }

    /* compiled from: FlowableBuffer.java */
    /* renamed from: g.a.y0.e.b.m$b */
    static final class b<T, C extends Collection<? super T>> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d, InterfaceC4574e {
        private static final long serialVersionUID = -7370244972039324525L;
        final InterfaceC5822c<? super C> actual;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        int index;
        long produced;

        /* renamed from: s */
        InterfaceC5823d f18057s;
        final int size;
        final int skip;
        final AtomicBoolean once = new AtomicBoolean();
        final ArrayDeque<C> buffers = new ArrayDeque<>();

        b(InterfaceC5822c<? super C> interfaceC5822c, int i2, int i3, Callable<C> callable) {
            this.actual = interfaceC5822c;
            this.size = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            this.f18057s.cancel();
        }

        @Override // p251g.p252a.p267x0.InterfaceC4574e
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j2 = this.produced;
            if (j2 != 0) {
                C5164d.m18610c(this, j2);
            }
            C5182v.m18649a(this.actual, this.buffers, this, this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.buffers;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    arrayDeque.offer((Collection) C4601b.m18284a(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t);
                this.produced++;
                this.actual.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18057s, interfaceC5823d)) {
                this.f18057s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (!EnumC5160j.validate(j2) || C5182v.m18655b(j2, this.actual, this.buffers, this, this)) {
                return;
            }
            if (this.once.get() || !this.once.compareAndSet(false, true)) {
                this.f18057s.request(C5164d.m18608b(this.skip, j2));
            } else {
                this.f18057s.request(C5164d.m18606a(this.size, C5164d.m18608b(this.skip, j2 - 1)));
            }
        }
    }

    /* compiled from: FlowableBuffer.java */
    /* renamed from: g.a.y0.e.b.m$c */
    static final class c<T, C extends Collection<? super T>> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -5616169793639412593L;
        final InterfaceC5822c<? super C> actual;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        int index;

        /* renamed from: s */
        InterfaceC5823d f18058s;
        final int size;
        final int skip;

        c(InterfaceC5822c<? super C> interfaceC5822c, int i2, int i3, Callable<C> callable) {
            this.actual = interfaceC5822c;
            this.size = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18058s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c2 = this.buffer;
            this.buffer = null;
            if (c2 != null) {
                this.actual.onNext(c2);
            }
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C c2 = this.buffer;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    c2 = (C) C4601b.m18284a(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c2;
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c2 != null) {
                c2.add(t);
                if (c2.size() == this.size) {
                    this.buffer = null;
                    this.actual.onNext(c2);
                }
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18058s, interfaceC5823d)) {
                this.f18058s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.f18058s.request(C5164d.m18608b(this.skip, j2));
                    return;
                }
                this.f18058s.request(C5164d.m18606a(C5164d.m18608b(j2, this.size), C5164d.m18608b(this.skip - this.size, j2 - 1)));
            }
        }
    }

    public C4758m(AbstractC4519l<T> abstractC4519l, int i2, int i3, Callable<C> callable) {
        super(abstractC4519l);
        this.f18047c = i2;
        this.f18048d = i3;
        this.f18049e = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super C> interfaceC5822c) {
        int i2 = this.f18047c;
        int i3 = this.f18048d;
        if (i2 == i3) {
            this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, i2, this.f18049e));
        } else if (i3 > i2) {
            this.f17759b.m17799a((InterfaceC4529q) new c(interfaceC5822c, i2, i3, this.f18049e));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, i2, i3, this.f18049e));
        }
    }
}
