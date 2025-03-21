package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: CompletableMerge.java */
/* renamed from: g.a.y0.e.a.y */
/* loaded from: classes2.dex */
public final class C4684y extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC5821b<? extends InterfaceC4513i> f17754a;

    /* renamed from: b */
    final int f17755b;

    /* renamed from: c */
    final boolean f17756c;

    /* compiled from: CompletableMerge.java */
    /* renamed from: g.a.y0.e.a.y$a */
    static final class a extends AtomicInteger implements InterfaceC4529q<InterfaceC4513i>, InterfaceC4552c {
        private static final long serialVersionUID = -2108443387387077490L;
        final InterfaceC4491f actual;
        final boolean delayErrors;
        final int maxConcurrency;

        /* renamed from: s */
        InterfaceC5823d f17757s;
        final C4551b set = new C4551b();
        final C5163c error = new C5163c();

        /* compiled from: CompletableMerge.java */
        /* renamed from: g.a.y0.e.a.y$a$a, reason: collision with other inner class name */
        final class C7387a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c {
            private static final long serialVersionUID = 251330541679988317L;

            C7387a() {
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public void dispose() {
                EnumC4592d.dispose(this);
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public boolean isDisposed() {
                return EnumC4592d.isDisposed(get());
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onComplete() {
                a.this.innerComplete(this);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this, interfaceC4552c);
            }
        }

        a(InterfaceC4491f interfaceC4491f, int i2, boolean z) {
            this.actual = interfaceC4491f;
            this.maxConcurrency = i2;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17757s.cancel();
            this.set.dispose();
        }

        void innerComplete(C7387a c7387a) {
            this.set.mo18182c(c7387a);
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.f17757s.request(1L);
                }
            } else {
                Throwable th = this.error.get();
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        void innerError(C7387a c7387a, Throwable th) {
            this.set.mo18182c(c7387a);
            if (!this.delayErrors) {
                this.f17757s.cancel();
                this.set.dispose();
                if (!this.error.addThrowable(th)) {
                    C4476a.m17152b(th);
                    return;
                } else {
                    if (getAndSet(0) > 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
            }
            if (!this.error.addThrowable(th)) {
                C4476a.m17152b(th);
            } else if (decrementAndGet() == 0) {
                this.actual.onError(this.error.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.f17757s.request(1L);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                if (this.error.get() != null) {
                    this.actual.onError(this.error.terminate());
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.delayErrors) {
                if (!this.error.addThrowable(th)) {
                    C4476a.m17152b(th);
                    return;
                } else {
                    if (decrementAndGet() == 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
            }
            this.set.dispose();
            if (!this.error.addThrowable(th)) {
                C4476a.m17152b(th);
            } else if (getAndSet(0) > 0) {
                this.actual.onError(this.error.terminate());
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17757s, interfaceC5823d)) {
                this.f17757s = interfaceC5823d;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    interfaceC5823d.request(C5556m0.f20396b);
                } else {
                    interfaceC5823d.request(i2);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(InterfaceC4513i interfaceC4513i) {
            getAndIncrement();
            C7387a c7387a = new C7387a();
            this.set.mo18181b(c7387a);
            interfaceC4513i.mo17074a(c7387a);
        }
    }

    public C4684y(InterfaceC5821b<? extends InterfaceC4513i> interfaceC5821b, int i2, boolean z) {
        this.f17754a = interfaceC5821b;
        this.f17755b = i2;
        this.f17756c = z;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17754a.subscribe(new a(interfaceC4491f, this.f17755b, this.f17756c));
    }
}
