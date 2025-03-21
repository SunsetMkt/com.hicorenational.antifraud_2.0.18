package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: CompletableDelay.java */
/* renamed from: g.a.y0.e.a.h */
/* loaded from: classes2.dex */
public final class C4659h extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17671a;

    /* renamed from: b */
    final long f17672b;

    /* renamed from: c */
    final TimeUnit f17673c;

    /* renamed from: d */
    final AbstractC4516j0 f17674d;

    /* renamed from: e */
    final boolean f17675e;

    /* compiled from: CompletableDelay.java */
    /* renamed from: g.a.y0.e.a.h$a */
    final class a implements InterfaceC4491f {

        /* renamed from: a */
        private final C4551b f17676a;

        /* renamed from: b */
        final InterfaceC4491f f17677b;

        /* compiled from: CompletableDelay.java */
        /* renamed from: g.a.y0.e.a.h$a$a, reason: collision with other inner class name */
        final class RunnableC7384a implements Runnable {
            RunnableC7384a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17677b.onComplete();
            }
        }

        /* compiled from: CompletableDelay.java */
        /* renamed from: g.a.y0.e.a.h$a$b */
        final class b implements Runnable {

            /* renamed from: a */
            private final Throwable f17680a;

            b(Throwable th) {
                this.f17680a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17677b.onError(this.f17680a);
            }
        }

        a(C4551b c4551b, InterfaceC4491f interfaceC4491f) {
            this.f17676a = c4551b;
            this.f17677b = interfaceC4491f;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            C4551b c4551b = this.f17676a;
            AbstractC4516j0 abstractC4516j0 = C4659h.this.f17674d;
            RunnableC7384a runnableC7384a = new RunnableC7384a();
            C4659h c4659h = C4659h.this;
            c4551b.mo18181b(abstractC4516j0.mo17409a(runnableC7384a, c4659h.f17672b, c4659h.f17673c));
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            C4551b c4551b = this.f17676a;
            AbstractC4516j0 abstractC4516j0 = C4659h.this.f17674d;
            b bVar = new b(th);
            C4659h c4659h = C4659h.this;
            c4551b.mo18181b(abstractC4516j0.mo17409a(bVar, c4659h.f17675e ? c4659h.f17672b : 0L, C4659h.this.f17673c));
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17676a.mo18181b(interfaceC4552c);
            this.f17677b.onSubscribe(this.f17676a);
        }
    }

    public C4659h(InterfaceC4513i interfaceC4513i, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        this.f17671a = interfaceC4513i;
        this.f17672b = j2;
        this.f17673c = timeUnit;
        this.f17674d = abstractC4516j0;
        this.f17675e = z;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17671a.mo17074a(new a(new C4551b(), interfaceC4491f));
    }
}
