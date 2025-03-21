package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableDelay.java */
/* renamed from: g.a.y0.e.b.g0 */
/* loaded from: classes2.dex */
public final class C4723g0<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f17897c;

    /* renamed from: d */
    final TimeUnit f17898d;

    /* renamed from: e */
    final AbstractC4516j0 f17899e;

    /* renamed from: f */
    final boolean f17900f;

    /* compiled from: FlowableDelay.java */
    /* renamed from: g.a.y0.e.b.g0$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f17901a;

        /* renamed from: b */
        final long f17902b;

        /* renamed from: c */
        final TimeUnit f17903c;

        /* renamed from: d */
        final AbstractC4516j0.c f17904d;

        /* renamed from: e */
        final boolean f17905e;

        /* renamed from: f */
        InterfaceC5823d f17906f;

        /* compiled from: FlowableDelay.java */
        /* renamed from: g.a.y0.e.b.g0$a$a, reason: collision with other inner class name */
        final class RunnableC7391a implements Runnable {
            RunnableC7391a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f17901a.onComplete();
                } finally {
                    a.this.f17904d.dispose();
                }
            }
        }

        /* compiled from: FlowableDelay.java */
        /* renamed from: g.a.y0.e.b.g0$a$b */
        final class b implements Runnable {

            /* renamed from: a */
            private final Throwable f17908a;

            b(Throwable th) {
                this.f17908a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f17901a.onError(this.f17908a);
                } finally {
                    a.this.f17904d.dispose();
                }
            }
        }

        /* compiled from: FlowableDelay.java */
        /* renamed from: g.a.y0.e.b.g0$a$c */
        final class c implements Runnable {

            /* renamed from: a */
            private final T f17910a;

            c(T t) {
                this.f17910a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17901a.onNext(this.f17910a);
            }
        }

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar, boolean z) {
            this.f17901a = interfaceC5822c;
            this.f17902b = j2;
            this.f17903c = timeUnit;
            this.f17904d = cVar;
            this.f17905e = z;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17906f.cancel();
            this.f17904d.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f17904d.mo17283a(new RunnableC7391a(), this.f17902b, this.f17903c);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f17904d.mo17283a(new b(th), this.f17905e ? this.f17902b : 0L, this.f17903c);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f17904d.mo17283a(new c(t), this.f17902b, this.f17903c);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17906f, interfaceC5823d)) {
                this.f17906f = interfaceC5823d;
                this.f17901a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f17906f.request(j2);
        }
    }

    public C4723g0(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        super(abstractC4519l);
        this.f17897c = j2;
        this.f17898d = timeUnit;
        this.f17899e = abstractC4516j0;
        this.f17900f = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(this.f17900f ? interfaceC5822c : new C4509e(interfaceC5822c), this.f17897c, this.f17898d, this.f17899e.mo17277a(), this.f17900f));
    }
}
