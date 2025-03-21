package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleTimeout.java */
/* renamed from: g.a.y0.e.f.o0 */
/* loaded from: classes2.dex */
public final class C5090o0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19756a;

    /* renamed from: b */
    final long f19757b;

    /* renamed from: c */
    final TimeUnit f19758c;

    /* renamed from: d */
    final AbstractC4516j0 f19759d;

    /* renamed from: e */
    final InterfaceC4530q0<? extends T> f19760e;

    /* compiled from: SingleTimeout.java */
    /* renamed from: g.a.y0.e.f.o0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, Runnable, InterfaceC4552c {
        private static final long serialVersionUID = 37497744973048446L;
        final InterfaceC4524n0<? super T> actual;
        final C7425a<T> fallback;
        InterfaceC4530q0<? extends T> other;
        final AtomicReference<InterfaceC4552c> task = new AtomicReference<>();

        /* compiled from: SingleTimeout.java */
        /* renamed from: g.a.y0.e.f.o0$a$a, reason: collision with other inner class name */
        static final class C7425a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final InterfaceC4524n0<? super T> actual;

            C7425a(InterfaceC4524n0<? super T> interfaceC4524n0) {
                this.actual = interfaceC4524n0;
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onError(Throwable th) {
                this.actual.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onSuccess(T t) {
                this.actual.onSuccess(t);
            }
        }

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4530q0<? extends T> interfaceC4530q0) {
            this.actual = interfaceC4524n0;
            this.other = interfaceC4530q0;
            if (interfaceC4530q0 != null) {
                this.fallback = new C7425a<>(interfaceC4524n0);
            } else {
                this.fallback = null;
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            EnumC4592d.dispose(this.task);
            C7425a<T> c7425a = this.fallback;
            if (c7425a != null) {
                EnumC4592d.dispose(c7425a);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || !compareAndSet(interfaceC4552c, enumC4592d)) {
                C4476a.m17152b(th);
            } else {
                EnumC4592d.dispose(this.task);
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || !compareAndSet(interfaceC4552c, enumC4592d)) {
                return;
            }
            EnumC4592d.dispose(this.task);
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || !compareAndSet(interfaceC4552c, enumC4592d)) {
                return;
            }
            if (interfaceC4552c != null) {
                interfaceC4552c.dispose();
            }
            InterfaceC4530q0<? extends T> interfaceC4530q0 = this.other;
            if (interfaceC4530q0 == null) {
                this.actual.onError(new TimeoutException());
            } else {
                this.other = null;
                interfaceC4530q0.mo17490a(this.fallback);
            }
        }
    }

    public C5090o0(InterfaceC4530q0<T> interfaceC4530q0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, InterfaceC4530q0<? extends T> interfaceC4530q02) {
        this.f19756a = interfaceC4530q0;
        this.f19757b = j2;
        this.f19758c = timeUnit;
        this.f19759d = abstractC4516j0;
        this.f19760e = interfaceC4530q02;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        a aVar = new a(interfaceC4524n0, this.f19760e);
        interfaceC4524n0.onSubscribe(aVar);
        EnumC4592d.replace(aVar.task, this.f19759d.mo17409a(aVar, this.f19757b, this.f19758c));
        this.f19756a.mo17490a(aVar);
    }
}
