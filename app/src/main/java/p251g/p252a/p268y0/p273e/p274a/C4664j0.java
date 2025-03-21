package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: CompletableTimeout.java */
/* renamed from: g.a.y0.e.a.j0 */
/* loaded from: classes2.dex */
public final class C4664j0 extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17699a;

    /* renamed from: b */
    final long f17700b;

    /* renamed from: c */
    final TimeUnit f17701c;

    /* renamed from: d */
    final AbstractC4516j0 f17702d;

    /* renamed from: e */
    final InterfaceC4513i f17703e;

    /* compiled from: CompletableTimeout.java */
    /* renamed from: g.a.y0.e.a.j0$a */
    final class a implements Runnable {

        /* renamed from: a */
        private final AtomicBoolean f17704a;

        /* renamed from: b */
        final C4551b f17705b;

        /* renamed from: c */
        final InterfaceC4491f f17706c;

        /* compiled from: CompletableTimeout.java */
        /* renamed from: g.a.y0.e.a.j0$a$a, reason: collision with other inner class name */
        final class C7386a implements InterfaceC4491f {
            C7386a() {
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onComplete() {
                a.this.f17705b.dispose();
                a.this.f17706c.onComplete();
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onError(Throwable th) {
                a.this.f17705b.dispose();
                a.this.f17706c.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                a.this.f17705b.mo18181b(interfaceC4552c);
            }
        }

        a(AtomicBoolean atomicBoolean, C4551b c4551b, InterfaceC4491f interfaceC4491f) {
            this.f17704a = atomicBoolean;
            this.f17705b = c4551b;
            this.f17706c = interfaceC4491f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17704a.compareAndSet(false, true)) {
                this.f17705b.m18176a();
                InterfaceC4513i interfaceC4513i = C4664j0.this.f17703e;
                if (interfaceC4513i == null) {
                    this.f17706c.onError(new TimeoutException());
                } else {
                    interfaceC4513i.mo17074a(new C7386a());
                }
            }
        }
    }

    /* compiled from: CompletableTimeout.java */
    /* renamed from: g.a.y0.e.a.j0$b */
    static final class b implements InterfaceC4491f {

        /* renamed from: a */
        private final C4551b f17709a;

        /* renamed from: b */
        private final AtomicBoolean f17710b;

        /* renamed from: c */
        private final InterfaceC4491f f17711c;

        b(C4551b c4551b, AtomicBoolean atomicBoolean, InterfaceC4491f interfaceC4491f) {
            this.f17709a = c4551b;
            this.f17710b = atomicBoolean;
            this.f17711c = interfaceC4491f;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            if (this.f17710b.compareAndSet(false, true)) {
                this.f17709a.dispose();
                this.f17711c.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            if (!this.f17710b.compareAndSet(false, true)) {
                C4476a.m17152b(th);
            } else {
                this.f17709a.dispose();
                this.f17711c.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17709a.mo18181b(interfaceC4552c);
        }
    }

    public C4664j0(InterfaceC4513i interfaceC4513i, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, InterfaceC4513i interfaceC4513i2) {
        this.f17699a = interfaceC4513i;
        this.f17700b = j2;
        this.f17701c = timeUnit;
        this.f17702d = abstractC4516j0;
        this.f17703e = interfaceC4513i2;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        C4551b c4551b = new C4551b();
        interfaceC4491f.onSubscribe(c4551b);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        c4551b.mo18181b(this.f17702d.mo17409a(new a(atomicBoolean, c4551b, interfaceC4491f), this.f17700b, this.f17701c));
        this.f17699a.mo17074a(new b(c4551b, atomicBoolean, interfaceC4491f));
    }
}
