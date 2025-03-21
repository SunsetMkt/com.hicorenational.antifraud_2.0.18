package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;

/* compiled from: CompletableDoOnEvent.java */
/* renamed from: g.a.y0.e.a.l */
/* loaded from: classes2.dex */
public final class C4667l extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17718a;

    /* renamed from: b */
    final InterfaceC4576g<? super Throwable> f17719b;

    /* compiled from: CompletableDoOnEvent.java */
    /* renamed from: g.a.y0.e.a.l$a */
    final class a implements InterfaceC4491f {

        /* renamed from: a */
        private final InterfaceC4491f f17720a;

        a(InterfaceC4491f interfaceC4491f) {
            this.f17720a = interfaceC4491f;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            try {
                C4667l.this.f17719b.accept(null);
                this.f17720a.onComplete();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17720a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            try {
                C4667l.this.f17719b.accept(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                th = new C4560a(th, th2);
            }
            this.f17720a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17720a.onSubscribe(interfaceC4552c);
        }
    }

    public C4667l(InterfaceC4513i interfaceC4513i, InterfaceC4576g<? super Throwable> interfaceC4576g) {
        this.f17718a = interfaceC4513i;
        this.f17719b = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17718a.mo17074a(new a(interfaceC4491f));
    }
}
