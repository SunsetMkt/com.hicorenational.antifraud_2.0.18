package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableBuffer.java */
/* renamed from: g.a.y0.e.d.m */
/* loaded from: classes2.dex */
public final class C4975m<T, U extends Collection<? super T>> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final int f19121b;

    /* renamed from: c */
    final int f19122c;

    /* renamed from: d */
    final Callable<U> f19123d;

    /* compiled from: ObservableBuffer.java */
    /* renamed from: g.a.y0.e.d.m$a */
    static final class a<T, U extends Collection<? super T>> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super U> f19124a;

        /* renamed from: b */
        final int f19125b;

        /* renamed from: c */
        final Callable<U> f19126c;

        /* renamed from: d */
        U f19127d;

        /* renamed from: e */
        int f19128e;

        /* renamed from: f */
        InterfaceC4552c f19129f;

        a(InterfaceC4514i0<? super U> interfaceC4514i0, int i2, Callable<U> callable) {
            this.f19124a = interfaceC4514i0;
            this.f19125b = i2;
            this.f19126c = callable;
        }

        /* renamed from: a */
        boolean m18460a() {
            try {
                this.f19127d = (U) C4601b.m18284a(this.f19126c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19127d = null;
                InterfaceC4552c interfaceC4552c = this.f19129f;
                if (interfaceC4552c == null) {
                    EnumC4593e.error(th, this.f19124a);
                    return false;
                }
                interfaceC4552c.dispose();
                this.f19124a.onError(th);
                return false;
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19129f.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19129f.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            U u = this.f19127d;
            this.f19127d = null;
            if (u != null && !u.isEmpty()) {
                this.f19124a.onNext(u);
            }
            this.f19124a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19127d = null;
            this.f19124a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            U u = this.f19127d;
            if (u != null) {
                u.add(t);
                int i2 = this.f19128e + 1;
                this.f19128e = i2;
                if (i2 >= this.f19125b) {
                    this.f19124a.onNext(u);
                    this.f19128e = 0;
                    m18460a();
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19129f, interfaceC4552c)) {
                this.f19129f = interfaceC4552c;
                this.f19124a.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableBuffer.java */
    /* renamed from: g.a.y0.e.d.m$b */
    static final class b<T, U extends Collection<? super T>> extends AtomicBoolean implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -8223395059921494546L;
        final InterfaceC4514i0<? super U> actual;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        long index;

        /* renamed from: s */
        InterfaceC4552c f19130s;
        final int skip;

        b(InterfaceC4514i0<? super U> interfaceC4514i0, int i2, int i3, Callable<U> callable) {
            this.actual = interfaceC4514i0;
            this.count = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19130s.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19130s.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.actual.onNext(this.buffers.poll());
            }
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            long j2 = this.index;
            this.index = 1 + j2;
            if (j2 % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) C4601b.m18284a(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.f19130s.dispose();
                    this.actual.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.actual.onNext(next);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19130s, interfaceC4552c)) {
                this.f19130s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4975m(InterfaceC4504g0<T> interfaceC4504g0, int i2, int i3, Callable<U> callable) {
        super(interfaceC4504g0);
        this.f19121b = i2;
        this.f19122c = i3;
        this.f19123d = callable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        int i2 = this.f19122c;
        int i3 = this.f19121b;
        if (i2 != i3) {
            this.f18742a.subscribe(new b(interfaceC4514i0, i3, i2, this.f19123d));
            return;
        }
        a aVar = new a(interfaceC4514i0, i3, this.f19123d);
        if (aVar.m18460a()) {
            this.f18742a.subscribe(aVar);
        }
    }
}
