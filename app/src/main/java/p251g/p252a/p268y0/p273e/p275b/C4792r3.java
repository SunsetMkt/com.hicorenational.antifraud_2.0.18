package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSubscribeOn.java */
/* renamed from: g.a.y0.e.b.r3 */
/* loaded from: classes2.dex */
public final class C4792r3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final AbstractC4516j0 f18364c;

    /* renamed from: d */
    final boolean f18365d;

    /* compiled from: FlowableSubscribeOn.java */
    /* renamed from: g.a.y0.e.b.r3$a */
    static final class a<T> extends AtomicReference<Thread> implements InterfaceC4529q<T>, InterfaceC5823d, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final InterfaceC5822c<? super T> actual;
        final boolean nonScheduledRequests;
        InterfaceC5821b<T> source;
        final AbstractC4516j0.c worker;

        /* renamed from: s */
        final AtomicReference<InterfaceC5823d> f18366s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        /* compiled from: FlowableSubscribeOn.java */
        /* renamed from: g.a.y0.e.b.r3$a$a, reason: collision with other inner class name */
        static final class RunnableC7396a implements Runnable {

            /* renamed from: a */
            private final InterfaceC5823d f18367a;

            /* renamed from: b */
            private final long f18368b;

            RunnableC7396a(InterfaceC5823d interfaceC5823d, long j2) {
                this.f18367a = interfaceC5823d;
                this.f18368b = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18367a.request(this.f18368b);
            }
        }

        a(InterfaceC5822c<? super T> interfaceC5822c, AbstractC4516j0.c cVar, InterfaceC5821b<T> interfaceC5821b, boolean z) {
            this.actual = interfaceC5822c;
            this.worker = cVar;
            this.source = interfaceC5821b;
            this.nonScheduledRequests = !z;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this.f18366s);
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this.f18366s, interfaceC5823d)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, interfaceC5823d);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                InterfaceC5823d interfaceC5823d = this.f18366s.get();
                if (interfaceC5823d != null) {
                    requestUpstream(j2, interfaceC5823d);
                    return;
                }
                C5164d.m18607a(this.requested, j2);
                InterfaceC5823d interfaceC5823d2 = this.f18366s.get();
                if (interfaceC5823d2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, interfaceC5823d2);
                    }
                }
            }
        }

        void requestUpstream(long j2, InterfaceC5823d interfaceC5823d) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                interfaceC5823d.request(j2);
            } else {
                this.worker.mo17282a(new RunnableC7396a(interfaceC5823d, j2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            InterfaceC5821b<T> interfaceC5821b = this.source;
            this.source = null;
            interfaceC5821b.subscribe(this);
        }
    }

    public C4792r3(AbstractC4519l<T> abstractC4519l, AbstractC4516j0 abstractC4516j0, boolean z) {
        super(abstractC4519l);
        this.f18364c = abstractC4516j0;
        this.f18365d = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        AbstractC4516j0.c mo17277a = this.f18364c.mo17277a();
        a aVar = new a(interfaceC5822c, mo17277a, this.f17759b, this.f18365d);
        interfaceC5822c.onSubscribe(aVar);
        mo17277a.mo17282a(aVar);
    }
}
