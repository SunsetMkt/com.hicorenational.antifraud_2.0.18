package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: CompletablePeek.java */
/* renamed from: g.a.y0.e.a.g0 */
/* loaded from: classes2.dex */
public final class C4658g0 extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17661a;

    /* renamed from: b */
    final InterfaceC4576g<? super InterfaceC4552c> f17662b;

    /* renamed from: c */
    final InterfaceC4576g<? super Throwable> f17663c;

    /* renamed from: d */
    final InterfaceC4570a f17664d;

    /* renamed from: e */
    final InterfaceC4570a f17665e;

    /* renamed from: f */
    final InterfaceC4570a f17666f;

    /* renamed from: g */
    final InterfaceC4570a f17667g;

    /* compiled from: CompletablePeek.java */
    /* renamed from: g.a.y0.e.a.g0$a */
    final class a implements InterfaceC4491f, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4491f f17668a;

        /* renamed from: b */
        InterfaceC4552c f17669b;

        a(InterfaceC4491f interfaceC4491f) {
            this.f17668a = interfaceC4491f;
        }

        /* renamed from: a */
        void m18312a() {
            try {
                C4658g0.this.f17666f.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            try {
                C4658g0.this.f17667g.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
            this.f17669b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17669b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            if (this.f17669b == EnumC4592d.DISPOSED) {
                return;
            }
            try {
                C4658g0.this.f17664d.run();
                C4658g0.this.f17665e.run();
                this.f17668a.onComplete();
                m18312a();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17668a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            if (this.f17669b == EnumC4592d.DISPOSED) {
                C4476a.m17152b(th);
                return;
            }
            try {
                C4658g0.this.f17663c.accept(th);
                C4658g0.this.f17665e.run();
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                th = new C4560a(th, th2);
            }
            this.f17668a.onError(th);
            m18312a();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            try {
                C4658g0.this.f17662b.accept(interfaceC4552c);
                if (EnumC4592d.validate(this.f17669b, interfaceC4552c)) {
                    this.f17669b = interfaceC4552c;
                    this.f17668a.onSubscribe(this);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                interfaceC4552c.dispose();
                this.f17669b = EnumC4592d.DISPOSED;
                EnumC4593e.error(th, this.f17668a);
            }
        }
    }

    public C4658g0(InterfaceC4513i interfaceC4513i, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2, InterfaceC4570a interfaceC4570a3, InterfaceC4570a interfaceC4570a4) {
        this.f17661a = interfaceC4513i;
        this.f17662b = interfaceC4576g;
        this.f17663c = interfaceC4576g2;
        this.f17664d = interfaceC4570a;
        this.f17665e = interfaceC4570a2;
        this.f17666f = interfaceC4570a3;
        this.f17667g = interfaceC4570a4;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17661a.mo17074a(new a(interfaceC4491f));
    }
}
