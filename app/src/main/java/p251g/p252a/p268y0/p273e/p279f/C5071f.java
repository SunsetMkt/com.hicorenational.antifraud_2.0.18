package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;

/* compiled from: SingleDelay.java */
/* renamed from: g.a.y0.e.f.f */
/* loaded from: classes2.dex */
public final class C5071f<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19695a;

    /* renamed from: b */
    final long f19696b;

    /* renamed from: c */
    final TimeUnit f19697c;

    /* renamed from: d */
    final AbstractC4516j0 f19698d;

    /* renamed from: e */
    final boolean f19699e;

    /* compiled from: SingleDelay.java */
    /* renamed from: g.a.y0.e.f.f$a */
    final class a implements InterfaceC4524n0<T> {

        /* renamed from: a */
        private final C4599k f19700a;

        /* renamed from: b */
        final InterfaceC4524n0<? super T> f19701b;

        /* compiled from: SingleDelay.java */
        /* renamed from: g.a.y0.e.f.f$a$a, reason: collision with other inner class name */
        final class RunnableC7424a implements Runnable {

            /* renamed from: a */
            private final Throwable f19703a;

            RunnableC7424a(Throwable th) {
                this.f19703a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19701b.onError(this.f19703a);
            }
        }

        /* compiled from: SingleDelay.java */
        /* renamed from: g.a.y0.e.f.f$a$b */
        final class b implements Runnable {

            /* renamed from: a */
            private final T f19705a;

            b(T t) {
                this.f19705a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19701b.onSuccess(this.f19705a);
            }
        }

        a(C4599k c4599k, InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.f19700a = c4599k;
            this.f19701b = interfaceC4524n0;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            C4599k c4599k = this.f19700a;
            AbstractC4516j0 abstractC4516j0 = C5071f.this.f19698d;
            RunnableC7424a runnableC7424a = new RunnableC7424a(th);
            C5071f c5071f = C5071f.this;
            c4599k.replace(abstractC4516j0.mo17409a(runnableC7424a, c5071f.f19699e ? c5071f.f19696b : 0L, C5071f.this.f19697c));
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19700a.replace(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            C4599k c4599k = this.f19700a;
            AbstractC4516j0 abstractC4516j0 = C5071f.this.f19698d;
            b bVar = new b(t);
            C5071f c5071f = C5071f.this;
            c4599k.replace(abstractC4516j0.mo17409a(bVar, c5071f.f19696b, c5071f.f19697c));
        }
    }

    public C5071f(InterfaceC4530q0<? extends T> interfaceC4530q0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        this.f19695a = interfaceC4530q0;
        this.f19696b = j2;
        this.f19697c = timeUnit;
        this.f19698d = abstractC4516j0;
        this.f19699e = z;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        C4599k c4599k = new C4599k();
        interfaceC4524n0.onSubscribe(c4599k);
        this.f19695a.mo17490a(new a(c4599k, interfaceC4524n0));
    }
}
