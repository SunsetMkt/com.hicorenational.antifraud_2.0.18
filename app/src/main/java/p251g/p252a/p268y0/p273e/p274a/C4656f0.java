package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;

/* compiled from: CompletableOnErrorComplete.java */
/* renamed from: g.a.y0.e.a.f0 */
/* loaded from: classes2.dex */
public final class C4656f0 extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17656a;

    /* renamed from: b */
    final InterfaceC4587r<? super Throwable> f17657b;

    /* compiled from: CompletableOnErrorComplete.java */
    /* renamed from: g.a.y0.e.a.f0$a */
    final class a implements InterfaceC4491f {

        /* renamed from: a */
        private final InterfaceC4491f f17658a;

        a(InterfaceC4491f interfaceC4491f) {
            this.f17658a = interfaceC4491f;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.f17658a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            try {
                if (C4656f0.this.f17657b.test(th)) {
                    this.f17658a.onComplete();
                } else {
                    this.f17658a.onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f17658a.onError(new C4560a(th, th2));
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17658a.onSubscribe(interfaceC4552c);
        }
    }

    public C4656f0(InterfaceC4513i interfaceC4513i, InterfaceC4587r<? super Throwable> interfaceC4587r) {
        this.f17656a = interfaceC4513i;
        this.f17657b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17656a.mo17074a(new a(interfaceC4491f));
    }
}
